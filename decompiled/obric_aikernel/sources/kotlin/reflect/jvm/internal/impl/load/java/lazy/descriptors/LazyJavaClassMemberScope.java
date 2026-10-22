package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.bytedance.crash.event.EnsureReportData;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.PropertiesConventionUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaForKotlinOverridePropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaClassMemberScope extends LazyJavaScope {
    private final NotNullLazyValue<List<ClassConstructorDescriptor>> constructors;
    private final NotNullLazyValue<Map<Name, JavaField>> enumEntryIndex;
    private final JavaClass jClass;
    private final NotNullLazyValue<Set<Name>> nestedClassIndex;
    private final MemoizedFunctionToNullable<Name, ClassDescriptorBase> nestedClasses;
    private final ClassDescriptor ownerDescriptor;
    private final boolean skipRefinement;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredFunctions$3, reason: invalid class name */
    /* synthetic */ class AnonymousClass3 extends FunctionReference implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        AnonymousClass3(Object r10) {
            super(1, r10);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "searchMethodsByNameWithoutBuiltinMagic";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(LazyJavaClassMemberScope.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Collection<? extends SimpleFunctionDescriptor> invoke(Name r10) {
            return invoke2(r10);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<SimpleFunctionDescriptor> invoke2(Name r10) {
            Intrinsics.checkNotNullParameter(r10, "p0");
            return LazyJavaClassMemberScope.access$searchMethodsByNameWithoutBuiltinMagic((LazyJavaClassMemberScope) this.receiver, r10);
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredFunctions$4, reason: invalid class name */
    /* synthetic */ class AnonymousClass4 extends FunctionReference implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        AnonymousClass4(Object r10) {
            super(1, r10);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(LazyJavaClassMemberScope.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Collection<? extends SimpleFunctionDescriptor> invoke(Name r10) {
            return invoke2(r10);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<SimpleFunctionDescriptor> invoke2(Name r10) {
            Intrinsics.checkNotNullParameter(r10, "p0");
            return LazyJavaClassMemberScope.access$searchMethodsInSupertypesWithoutBuiltinMagic((LazyJavaClassMemberScope) this.receiver, r10);
        }
    }

    public LazyJavaClassMemberScope(final LazyJavaResolverContext r10, ClassDescriptor r11, JavaClass r12, boolean r13, LazyJavaClassMemberScope r14) {
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r11, "ownerDescriptor");
        Intrinsics.checkNotNullParameter(r12, "jClass");
        super(r10, r14);
        this.ownerDescriptor = r11;
        this.jClass = r12;
        this.skipRefinement = r13;
        this.constructors = r10.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$constructors$1(this, r10));
        this.nestedClassIndex = r10.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$nestedClassIndex$1(this));
        this.enumEntryIndex = r10.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$enumEntryIndex$1(this));
        this.nestedClasses = r10.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaClassMemberScope$nestedClasses$1(this, r10));
    }

    public /* synthetic */ LazyJavaClassMemberScope(LazyJavaResolverContext r10, ClassDescriptor r11, JavaClass r12, boolean r13, LazyJavaClassMemberScope r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 16) == 0) goto L5;
        r14 = null;
    L5:
        this(r10, r11, r12, r13, r14);
    }

    public static final /* synthetic */ ClassConstructorDescriptor access$createDefaultConstructor(LazyJavaClassMemberScope r10) {
        return r10.createDefaultConstructor();
    }

    public static final /* synthetic */ ClassConstructorDescriptor access$createDefaultRecordConstructor(LazyJavaClassMemberScope r10) {
        return r10.createDefaultRecordConstructor();
    }

    public static final /* synthetic */ NotNullLazyValue access$getEnumEntryIndex$p(LazyJavaClassMemberScope r10) {
        return r10.enumEntryIndex;
    }

    public static final /* synthetic */ JavaClass access$getJClass$p(LazyJavaClassMemberScope r10) {
        return r10.jClass;
    }

    public static final /* synthetic */ NotNullLazyValue access$getNestedClassIndex$p(LazyJavaClassMemberScope r10) {
        return r10.nestedClassIndex;
    }

    public static final /* synthetic */ JavaClassConstructorDescriptor access$resolveConstructor(LazyJavaClassMemberScope r10, JavaConstructor r11) {
        return r10.resolveConstructor(r11);
    }

    public static final /* synthetic */ Collection access$searchMethodsByNameWithoutBuiltinMagic(LazyJavaClassMemberScope r10, Name r11) {
        return r10.searchMethodsByNameWithoutBuiltinMagic(r11);
    }

    public static final /* synthetic */ Collection access$searchMethodsInSupertypesWithoutBuiltinMagic(LazyJavaClassMemberScope r10, Name r11) {
        return r10.searchMethodsInSupertypesWithoutBuiltinMagic(r11);
    }

    private final void addAnnotationValueParameter(List<ValueParameterDescriptor> r14, ConstructorDescriptor r15, int r16, JavaMethod r17, KotlinType r18, KotlinType r19) {
        Annotations r10 = Annotations.Companion.getEMPTY();
        Name r11 = r17.getName();
        KotlinType r12 = TypeUtils.makeNotNullable(r18);
        Intrinsics.checkNotNullExpressionValue(r12, "makeNotNullable(returnType)");
        boolean r13 = r17.getHasAnnotationParameterDefaultValue();
        if (r19 == null) goto L5;
        KotlinType r20 = TypeUtils.makeNotNullable(r19);
    L6:
        r14.add(new ValueParameterDescriptorImpl(r15, null, r16, r10, r11, r12, r13, false, false, r20, getC().getComponents().getSourceElementFactory().source(r17)));
        return;
    L5:
        r20 = null;
        goto L6
    }

    private final void addFunctionFromSupertypes(Collection<SimpleFunctionDescriptor> r10, Name r11, Collection<? extends SimpleFunctionDescriptor> r12, boolean r13) {
        Collection<? extends SimpleFunctionDescriptor> r14 = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(r11, r12, r10, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(r14, "resolveOverridesForNonSt….overridingUtil\n        )");
        if (r13 == true) goto L5;
        r10.addAll(r14);
        return;
    L5:
        List r15 = CollectionsKt.plus(r10, r14);
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r17 = r14.iterator();
    L7:
        if (r17.hasNext() == false) goto L13;
        SimpleFunctionDescriptor r18 = (SimpleFunctionDescriptor) r17.next();
        SimpleFunctionDescriptor r19 = (SimpleFunctionDescriptor) SpecialBuiltinMembers.getOverriddenSpecialBuiltin(r18);
        Intrinsics.checkNotNullExpressionValue(r18, "resolvedOverride");
        if (r19 == null) goto L12;
        r18 = createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(r18, r19, r15);
    L12:
        r16.add(r18);
        goto L7
    L13:
        r10.addAll(r16);
    }

    private final void addOverriddenSpecialMethods(Name r10, Collection<? extends SimpleFunctionDescriptor> r11, Collection<? extends SimpleFunctionDescriptor> r12, Collection<SimpleFunctionDescriptor> r13, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r14) {
        Iterator<? extends SimpleFunctionDescriptor> r15 = r12.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        SimpleFunctionDescriptor r16 = r15.next();
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r13, obtainOverrideForBuiltinWithDifferentJvmName(r16, r14, r10, r11));
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r13, obtainOverrideForBuiltInWithErasedValueParametersInJava(r16, r14, r11));
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r13, obtainOverrideForSuspend(r16, r14));
        goto L4
    }

    private final void addPropertyOverrideByMethod(Set<? extends PropertyDescriptor> r10, Collection<PropertyDescriptor> r11, Set<PropertyDescriptor> r12, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r13) {
        Iterator<? extends PropertyDescriptor> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L15;
        PropertyDescriptor r15 = r14.next();
        JavaPropertyDescriptor r16 = createPropertyDescriptorByMethods(r15, r13);
        if (r16 == null) goto L4;
        r11.add(r16);
        if (r12 == null) goto L14;
        r12.add(r15);
        return;
    L14:
        return;
    }

    private final void computeAnnotationProperties(Name r10, Collection<PropertyDescriptor> r11) {
        JavaMethod r12 = (JavaMethod) CollectionsKt.singleOrNull(getDeclaredMemberIndex().invoke().findMethodsByName(r10));
        if (r12 != null) goto L5;
        return;
    L5:
        r11.add(createPropertyDescriptorWithDefaultGetter$default(this, r12, null, Modality.FINAL, 2, null));
    }

    private final Collection<KotlinType> computeSupertypes() {
        if (this.skipRefinement == false) goto L7;
        Collection<KotlinType> r10 = getOwnerDescriptor().getTypeConstructor().mo1324getSupertypes();
        Intrinsics.checkNotNullExpressionValue(r10, "ownerDescriptor.typeConstructor.supertypes");
        return r10;
    L7:
        return getC().getComponents().getKotlinTypeChecker().getKotlinTypeRefiner().refineSupertypes(getOwnerDescriptor());
    }

    private final List<ValueParameterDescriptor> createAnnotationConstructorParameters(ClassConstructorDescriptorImpl r13) {
        Collection<JavaMethod> r10 = this.jClass.getMethods();
        ArrayList r11 = new ArrayList(r10.size());
        JavaTypeAttributes r12 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, true, false, null, 6, null);
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r10.iterator();
    L4:
        if (r16.hasNext() == false) goto L9;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((JavaMethod) r17).getName(), JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME) == true) goto L7;
        r15.add(r17);
        goto L4
    L7:
        r14.add(r17);
        goto L4
    L9:
        Pair r18 = new Pair(r14, r15);
        List r19 = (List) r18.component1();
        List r20 = (List) r18.component2();
        r19.size();
        JavaMethod r110 = (JavaMethod) CollectionsKt.firstOrNull(r19);
        int r111 = 1;
        if (r110 == null) goto L16;
        JavaType r21 = r110.getReturnType();
        if ((r21 instanceof JavaArrayType) == false) goto L14;
        JavaArrayType r22 = (JavaArrayType) r21;
        Pair r23 = new Pair(getC().getTypeResolver().transformArrayType(r22, r12, true), getC().getTypeResolver().transformJavaType(r22.getComponentType(), r12));
    L15:
        addAnnotationValueParameter(r11, r13, 0, r110, (KotlinType) r23.component1(), (KotlinType) r23.component2());
        goto L16
    L14:
        r23 = new Pair(getC().getTypeResolver().transformJavaType(r21, r12), null);
    L16:
        int r24 = 0;
        if (r110 != null) goto L20;
        r111 = 0;
    L20:
        Iterator r25 = r20.iterator();
    L22:
        if (r25.hasNext() == false) goto L24;
        JavaMethod r26 = (JavaMethod) r25.next();
        addAnnotationValueParameter(r11, r13, r24 + r111, r26, getC().getTypeResolver().transformJavaType(r26.getReturnType(), r12), null);
        r24 = r24 + 1;
        goto L22
    L24:
        return r11;
    }

    private final ClassConstructorDescriptor createDefaultConstructor() {
        boolean r10 = this.jClass.isAnnotationType();
        if (this.jClass.isInterface() == false) goto L5;
    L6:
        if (r10 == true) goto L9;
        return null;
    L9:
        ClassDescriptor r11 = getOwnerDescriptor();
        JavaClassConstructorDescriptor r12 = JavaClassConstructorDescriptor.createJavaConstructor(r11, Annotations.Companion.getEMPTY(), true, getC().getComponents().getSourceElementFactory().source(this.jClass));
        Intrinsics.checkNotNullExpressionValue(r12, "createJavaConstructor(\n ….source(jClass)\n        )");
        if (r10 == false) goto L12;
        List<ValueParameterDescriptor> r13 = createAnnotationConstructorParameters(r12);
    L13:
        r12.setHasSynthesizedParameterNames(false);
        r12.initialize(r13, getConstructorVisibility(r11));
        r12.setHasStableParameterNames(true);
        r12.setReturnType(r11.getDefaultType());
        getC().getComponents().getJavaResolverCache().recordConstructor(this.jClass, r12);
        return r12;
    L12:
        r13 = Collections.emptyList();
        goto L13
    L5:
        if (this.jClass.hasDefaultConstructor() == true) goto L9;
        goto L6
    }

    private final ClassConstructorDescriptor createDefaultRecordConstructor() {
        ClassDescriptor r10 = getOwnerDescriptor();
        JavaClassConstructorDescriptor r11 = JavaClassConstructorDescriptor.createJavaConstructor(r10, Annotations.Companion.getEMPTY(), true, getC().getComponents().getSourceElementFactory().source(this.jClass));
        Intrinsics.checkNotNullExpressionValue(r11, "createJavaConstructor(\n ….source(jClass)\n        )");
        List<ValueParameterDescriptor> r12 = createRecordConstructorParameters(r11);
        r11.setHasSynthesizedParameterNames(false);
        r11.initialize(r12, getConstructorVisibility(r10));
        r11.setHasStableParameterNames(false);
        r11.setReturnType(r10.getDefaultType());
        return r11;
    }

    private final SimpleFunctionDescriptor createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(SimpleFunctionDescriptor r10, CallableDescriptor r11, Collection<? extends SimpleFunctionDescriptor> r12) {
        boolean r13 = false;
        if ((r12 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r14 = r12.iterator();
    L9:
        if (r14.hasNext() == false) goto L6;
        SimpleFunctionDescriptor r15 = (SimpleFunctionDescriptor) r14.next();
        if (Intrinsics.areEqual(r10, r15) == false) goto L13;
    L17:
        boolean r16 = false;
    L18:
        if (r16 == false) goto L9;
    L19:
        if (r13 == true) goto L28;
        FunctionDescriptor r17 = r10.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
        Intrinsics.checkNotNull(r17);
        return (SimpleFunctionDescriptor) r17;
    L28:
        return r10;
    L13:
        if (r15.getInitialSignatureDescriptor() != null) goto L17;
        if (doesOverride(r15, r11) == false) goto L17;
        r16 = true;
    L6:
        r13 = true;
        goto L19
    L5:
        if (r12.isEmpty() == false) goto L7;
        goto L6
    }

    private final SimpleFunctionDescriptor createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(FunctionDescriptor r10, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r11) {
        Name r12 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r12, "overridden.name");
        Iterator<T> r13 = r11.invoke(r12).iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Object r14 = r13.next();
        if (hasSameJvmDescriptorButDoesNotOverride((SimpleFunctionDescriptor) r14, r10) == false) goto L4;
    L9:
        SimpleFunctionDescriptor r15 = (SimpleFunctionDescriptor) r14;
        if (r15 == null) goto L21;
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> r16 = r15.newCopyBuilder();
        List<ValueParameterDescriptor> r17 = r10.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r17, "overridden.valueParameters");
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<T> r19 = r17.iterator();
    L13:
        if (r19.hasNext() == false) goto L15;
        r18.add(((ValueParameterDescriptor) r19.next()).getType());
        goto L13
    L15:
        List<ValueParameterDescriptor> r20 = r15.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r20, "override.valueParameters");
        r16.setValueParameters(UtilKt.copyValueParameters(r18, r20, r10));
        r16.setSignatureChange();
        r16.setPreserveSourceElement();
        r16.putUserData(JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS, Boolean.TRUE);
        return (SimpleFunctionDescriptor) r16.build();
    L21:
        return null;
    L8:
        r14 = null;
        goto L9
    }

    private final JavaPropertyDescriptor createPropertyDescriptorByMethods(PropertyDescriptor r12, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r13) {
        PropertySetterDescriptorImpl r10 = null;
        if (doesClassOverridesProperty(r12, r13) == true) goto L5;
        return null;
    L5:
        SimpleFunctionDescriptor r11 = findGetterOverride(r12, r13);
        Intrinsics.checkNotNull(r11);
        if (r12.isVar() == false) goto L8;
        SimpleFunctionDescriptor r14 = findSetterOverride(r12, r13);
        Intrinsics.checkNotNull(r14);
    L9:
        if (r14 == null) goto L11;
        r14.getModality();
        r11.getModality();
    L11:
        JavaForKotlinOverridePropertyDescriptor r15 = new JavaForKotlinOverridePropertyDescriptor(getOwnerDescriptor(), r11, r14, r12);
        KotlinType r16 = r11.getReturnType();
        Intrinsics.checkNotNull(r16);
        r15.setType(r16, CollectionsKt.emptyList(), getDispatchReceiverParameter(), null, CollectionsKt.emptyList());
        PropertyGetterDescriptorImpl r17 = DescriptorFactory.createGetter(r15, r11.getAnnotations(), false, false, false, r11.getSource());
        r17.setInitialSignatureDescriptor(r11);
        r17.initialize(r15.getType());
        Intrinsics.checkNotNullExpressionValue(r17, "createGetter(\n          …escriptor.type)\n        }");
        if (r14 == null) goto L18;
        List<ValueParameterDescriptor> r18 = r14.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r18, "setterMethod.valueParameters");
        ValueParameterDescriptor r19 = (ValueParameterDescriptor) CollectionsKt.firstOrNull(r18);
        if (r19 == null) goto L17;
        r10 = DescriptorFactory.createSetter(r15, r14.getAnnotations(), r19.getAnnotations(), false, false, false, r14.getVisibility(), r14.getSource());
        r10.setInitialSignatureDescriptor(r14);
        goto L18
    L17:
        throw new AssertionError("No parameter found for " + r14);
    L18:
        r15.initialize(r17, r10);
        return r15;
    L8:
        r14 = null;
        goto L9
    }

    private final JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter(JavaMethod r16, KotlinType r17, Modality r18) {
        Annotations r10 = LazyJavaAnnotationsKt.resolveAnnotations(getC(), r16);
        JavaPropertyDescriptor r11 = JavaPropertyDescriptor.create(getOwnerDescriptor(), r10, r18, UtilsKt.toDescriptorVisibility(r16.getVisibility()), false, r16.getName(), getC().getComponents().getSourceElementFactory().source(r16), false);
        Intrinsics.checkNotNullExpressionValue(r11, "create(\n            owne…inal = */ false\n        )");
        PropertyGetterDescriptorImpl r12 = DescriptorFactory.createDefaultGetter(r11, Annotations.Companion.getEMPTY());
        Intrinsics.checkNotNullExpressionValue(r12, "createDefaultGetter(prop…iptor, Annotations.EMPTY)");
        r11.initialize(r12, null);
        if (r17 != null) goto L5;
        KotlinType r13 = computeMethodReturnType(r16, ContextKt.childForMethod$default(getC(), r11, r16, 0, 4, null));
    L6:
        KotlinType r14 = r13;
        r11.setType(r14, CollectionsKt.emptyList(), getDispatchReceiverParameter(), null, CollectionsKt.emptyList());
        r12.initialize(r13);
        return r11;
    L5:
        r13 = r17;
        goto L6
    }

    static /* synthetic */ JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter$default(LazyJavaClassMemberScope r10, JavaMethod r11, KotlinType r12, Modality r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = null;
    L6:
        return r10.createPropertyDescriptorWithDefaultGetter(r11, r12, r13);
    }

    private final List<ValueParameterDescriptor> createRecordConstructorParameters(ClassConstructorDescriptorImpl r20) {
        Collection<JavaRecordComponent> r10 = this.jClass.getRecordComponents();
        ArrayList r11 = new ArrayList(r10.size());
        JavaTypeAttributes r12 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 6, null);
        Iterator<JavaRecordComponent> r13 = r10.iterator();
        int r14 = 0;
    L3:
        int r15 = r14;
        if (r13.hasNext() == false) goto L10;
        r14 = r15 + 1;
        JavaRecordComponent r16 = r13.next();
        KotlinType r17 = getC().getTypeResolver().transformJavaType(r16.getType(), r12);
        if (r16.isVararg() == false) goto L8;
        KotlinType r18 = getC().getComponents().getModule().getBuiltIns().getArrayElementType(r17);
    L9:
        KotlinType r19 = r18;
        r11.add(new ValueParameterDescriptorImpl(r20, null, r15, Annotations.Companion.getEMPTY(), r16.getName(), r17, false, false, false, r19, getC().getComponents().getSourceElementFactory().source(r16)));
        goto L3
    L8:
        r18 = null;
        goto L9
    L10:
        return r11;
    }

    private final SimpleFunctionDescriptor createRenamedCopy(SimpleFunctionDescriptor r10, Name r11) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> r12 = r10.newCopyBuilder();
        r12.setName(r11);
        r12.setSignatureChange();
        r12.setPreserveSourceElement();
        FunctionDescriptor r13 = r12.build();
        Intrinsics.checkNotNull(r13);
        return (SimpleFunctionDescriptor) r13;
    }

    private final SimpleFunctionDescriptor createSuspendView(SimpleFunctionDescriptor r10) {
        List<ValueParameterDescriptor> r11 = r10.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r11, "valueParameters");
        ValueParameterDescriptor r12 = (ValueParameterDescriptor) CollectionsKt.lastOrNull(r11);
        if (r12 == null) goto L26;
        ClassifierDescriptor r13 = r12.getType().getConstructor().mo1323getDeclarationDescriptor();
        if (r13 == null) goto L14;
        FqNameUnsafe r14 = DescriptorUtilsKt.getFqNameUnsafe(r13);
        if (r14 == null) goto L14;
        if (r14.isSafe() == true) goto L12;
        r14 = null;
    L12:
        if (r14 == null) goto L14;
        FqName r15 = r14.toSafe();
    L16:
        if (Intrinsics.areEqual(r15, StandardNames.CONTINUATION_INTERFACE_FQ_NAME) == true) goto L19;
        r12 = null;
    L19:
        if (r12 == null) goto L26;
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> r16 = r10.newCopyBuilder();
        List<ValueParameterDescriptor> r17 = r10.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r17, "valueParameters");
        SimpleFunctionDescriptor r18 = (SimpleFunctionDescriptor) r16.setValueParameters(CollectionsKt.dropLast(r17, 1)).setReturnType(r12.getType().getArguments().get(0).getType()).build();
        SimpleFunctionDescriptorImpl r19 = (SimpleFunctionDescriptorImpl) r18;
        if (r19 == null) goto L25;
        r19.setSuspend(true);
    L25:
        return r18;
    L14:
        r15 = null;
    L26:
        return null;
    }

    private final boolean doesClassOverridesProperty(PropertyDescriptor r10, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r11) {
        if (JavaDescriptorUtilKt.isJavaField(r10) == false) goto L5;
        return false;
    L5:
        SimpleFunctionDescriptor r12 = findGetterOverride(r10, r11);
        SimpleFunctionDescriptor r13 = findSetterOverride(r10, r11);
        if (r12 != null) goto L9;
        return false;
    L9:
        if (r10.isVar() == true) goto L11;
        return true;
    L11:
        if (r13 != null) goto L13;
        return false;
    L13:
        if (r13.getModality() == r12.getModality()) goto L15;
        return false;
    L15:
        return true;
    }

    private final boolean doesOverride(CallableDescriptor r10, CallableDescriptor r11) {
        OverridingUtil.OverrideCompatibilityInfo.Result r12 = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(r11, r10, true).getResult();
        Intrinsics.checkNotNullExpressionValue(r12, "DEFAULT.isOverridableByW…iptor, this, true).result");
        if (r12 == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) goto L5;
    L7:
        return false;
    L5:
        if (JavaIncompatibilityRulesOverridabilityCondition.Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(r11, r10) == true) goto L7;
        return true;
    }

    private final boolean doesOverrideRenamedBuiltins(SimpleFunctionDescriptor r10) {
        SpecialGenericSignatures.Companion r11 = SpecialGenericSignatures.Companion;
        Name r12 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r12, ActivityLifecycle.NAME);
        Name r13 = r11.getBuiltinFunctionNamesByJvmName(r12);
        if (r13 != null) goto L5;
        return false;
    L5:
        Set<SimpleFunctionDescriptor> r14 = getFunctionsFromSupertypes(r13);
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L7:
        if (r16.hasNext() == false) goto L12;
        Object r17 = r16.next();
        if (SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName((SimpleFunctionDescriptor) r17) == false) goto L7;
        r15.add(r17);
        goto L7
    L12:
        if (r15.isEmpty() == false) goto L14;
        return false;
    L14:
        SimpleFunctionDescriptor r18 = createRenamedCopy(r10, r13);
        if (r15.isEmpty() == true) goto L32;
        Iterator r19 = r15.iterator();
    L19:
        if (r19.hasNext() == false) goto L33;
        if (doesOverrideRenamedDescriptor((SimpleFunctionDescriptor) r19.next(), r18) == false) goto L19;
        return true;
    L33:
        return false;
    L32:
        return false;
    }

    private final boolean doesOverrideRenamedDescriptor(SimpleFunctionDescriptor r10, FunctionDescriptor r11) {
        if (BuiltinMethodsWithDifferentJvmName.INSTANCE.isRemoveAtByIndex(r10) == false) goto L5;
        r11 = r11.getOriginal();
    L5:
        Intrinsics.checkNotNullExpressionValue(r11, "if (superDescriptor.isRe…iginal else subDescriptor");
        return doesOverride(r11, r10);
    }

    private final boolean doesOverrideSuspendFunction(SimpleFunctionDescriptor r10) {
        SimpleFunctionDescriptor r11 = createSuspendView(r10);
        if (r11 != null) goto L5;
        return false;
    L5:
        Name r12 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r12, ActivityLifecycle.NAME);
        Set<SimpleFunctionDescriptor> r13 = getFunctionsFromSupertypes(r12);
        if ((r13 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r14 = r13.iterator();
    L12:
        if (r14.hasNext() == false) goto L28;
        SimpleFunctionDescriptor r15 = (SimpleFunctionDescriptor) r14.next();
        if (r15.isSuspend() == true) goto L16;
    L18:
        boolean r16 = false;
    L19:
        if (r16 == false) goto L12;
        return true;
    L16:
        if (doesOverride(r11, r15) == false) goto L18;
        r16 = true;
        goto L19
    L28:
        return false;
    L8:
        if (r13.isEmpty() == false) goto L10;
        return false;
    }

    private final SimpleFunctionDescriptor findGetterByName(PropertyDescriptor r10, String r11, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r12) {
        Name r13 = Name.identifier(r11);
        Intrinsics.checkNotNullExpressionValue(r13, "identifier(getterName)");
        Iterator<T> r14 = r12.invoke(r13).iterator();
    L3:
        SimpleFunctionDescriptor r15 = null;
        if (r14.hasNext() == false) goto L15;
        SimpleFunctionDescriptor r16 = (SimpleFunctionDescriptor) r14.next();
        if (r16.getValueParameters().size() != 0) goto L14;
        KotlinTypeChecker r17 = KotlinTypeChecker.DEFAULT;
        KotlinType r18 = r16.getReturnType();
        if (r18 != null) goto L11;
        boolean r19 = false;
    L12:
        if (r19 == false) goto L14;
        r15 = r16;
        goto L14
    L11:
        r19 = r17.isSubtypeOf(r18, r10.getType());
    L14:
        if (r15 == null) goto L3;
    L15:
        return r15;
    }

    private final SimpleFunctionDescriptor findGetterOverride(PropertyDescriptor r10, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r11) {
        PropertyGetterDescriptor r12 = r10.getGetter();
        String r13 = null;
        if (r12 == null) goto L5;
        PropertyGetterDescriptor r14 = (PropertyGetterDescriptor) SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(r12);
    L6:
        if (r14 == null) goto L8;
        r13 = ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(r14);
    L8:
        if (r13 != null) goto L10;
    L13:
        String r15 = r10.getName().asString();
        Intrinsics.checkNotNullExpressionValue(r15, "name.asString()");
        return findGetterByName(r10, JvmAbi.getterName(r15), r11);
    L10:
        if (SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(getOwnerDescriptor(), r14) == true) goto L13;
        return findGetterByName(r10, r13, r11);
    L5:
        r14 = null;
        goto L6
    }

    private final SimpleFunctionDescriptor findSetterOverride(PropertyDescriptor r10, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r11) {
        String r12 = r10.getName().asString();
        Intrinsics.checkNotNullExpressionValue(r12, "name.asString()");
        Name r13 = Name.identifier(JvmAbi.setterName(r12));
        Intrinsics.checkNotNullExpressionValue(r13, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator<T> r14 = r11.invoke(r13).iterator();
    L3:
        SimpleFunctionDescriptor r15 = null;
        if (r14.hasNext() == false) goto L18;
        SimpleFunctionDescriptor r16 = (SimpleFunctionDescriptor) r14.next();
        if (r16.getValueParameters().size() != 1) goto L17;
        KotlinType r17 = r16.getReturnType();
        if (r17 == null) goto L17;
        if (KotlinBuiltIns.isUnit(r17) == false) goto L17;
        KotlinTypeChecker r18 = KotlinTypeChecker.DEFAULT;
        List<ValueParameterDescriptor> r19 = r16.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r19, "descriptor.valueParameters");
        if (r18.equalTypes(((ValueParameterDescriptor) CollectionsKt.single(r19)).getType(), r10.getType()) == false) goto L17;
        r15 = r16;
    L17:
        if (r15 == null) goto L3;
    L18:
        return r15;
    }

    private final DescriptorVisibility getConstructorVisibility(ClassDescriptor r10) {
        DescriptorVisibility r11 = r10.getVisibility();
        Intrinsics.checkNotNullExpressionValue(r11, "classDescriptor.visibility");
        if (Intrinsics.areEqual(r11, JavaDescriptorVisibilities.PROTECTED_STATIC_VISIBILITY) == false) goto L6;
        DescriptorVisibility r12 = JavaDescriptorVisibilities.PROTECTED_AND_PACKAGE;
        Intrinsics.checkNotNullExpressionValue(r12, "PROTECTED_AND_PACKAGE");
        return r12;
    L6:
        return r11;
    }

    private final Set<SimpleFunctionDescriptor> getFunctionsFromSupertypes(Name r10) {
        Collection<KotlinType> r11 = computeSupertypes();
        LinkedHashSet r12 = new LinkedHashSet();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.addAll(r12, ((KotlinType) r13.next()).getMemberScope().getContributedFunctions(r10, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        goto L4
    L6:
        return r12;
    }

    private final Set<PropertyDescriptor> getPropertiesFromSupertypes(Name r10) {
        Collection<KotlinType> r11 = computeSupertypes();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        Collection<? extends PropertyDescriptor> r14 = ((KotlinType) r13.next()).getMemberScope().getContributedVariables(r10, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r16 = r14.iterator();
    L7:
        if (r16.hasNext() == false) goto L9;
        r15.add((PropertyDescriptor) r16.next());
        goto L7
    L9:
        CollectionsKt.addAll(r12, r15);
        goto L4
    L11:
        return CollectionsKt.toSet(r12);
    }

    private final boolean hasSameJvmDescriptorButDoesNotOverride(SimpleFunctionDescriptor r10, FunctionDescriptor r11) {
        String r12 = MethodSignatureMappingKt.computeJvmDescriptor$default(r10, false, false, 2, null);
        FunctionDescriptor r13 = r11.getOriginal();
        Intrinsics.checkNotNullExpressionValue(r13, "builtinWithErasedParameters.original");
        if (Intrinsics.areEqual(r12, MethodSignatureMappingKt.computeJvmDescriptor$default(r13, false, false, 2, null)) == true) goto L5;
        return false;
    L5:
        if (doesOverride(r10, r11) == true) goto L9;
        return true;
    L9:
        return false;
    }

    private final boolean isVisibleAsFunctionInCurrentClass(final SimpleFunctionDescriptor r10) {
        Name r11 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r11, "function.name");
        List<Name> r12 = PropertiesConventionUtilKt.getPropertyNamesCandidatesByAccessorName(r11);
        if ((r12 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L6;
        Set<PropertyDescriptor> r14 = getPropertiesFromSupertypes((Name) r13.next());
        if ((r14 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r15 = r14.iterator();
    L17:
        if (r15.hasNext() == false) goto L14;
        PropertyDescriptor r16 = (PropertyDescriptor) r15.next();
        if (doesClassOverridesProperty(r16, new LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1(r10, this)) == true) goto L21;
    L25:
        boolean r17 = false;
    L26:
        if (r17 == false) goto L17;
        boolean r18 = true;
    L28:
        if (r18 == false) goto L9;
        boolean r19 = true;
    L30:
        if (r19 == false) goto L33;
        return false;
    L33:
        if (doesOverrideRenamedBuiltins(r10) == true) goto L40;
        if (shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(r10) == true) goto L40;
        if (doesOverrideSuspendFunction(r10) == true) goto L40;
        return true;
    L40:
        return false;
    L21:
        if (r16.isVar() == true) goto L24;
        String r20 = r10.getName().asString();
        Intrinsics.checkNotNullExpressionValue(r20, "function.name.asString()");
        if (JvmAbi.isSetterName(r20) == true) goto L25;
    L24:
        r17 = true;
    L14:
        r18 = false;
        goto L28
    L13:
        if (r14.isEmpty() == false) goto L15;
    L6:
        r19 = false;
        goto L30
    L5:
        if (r12.isEmpty() == false) goto L7;
        goto L6
    }

    private final SimpleFunctionDescriptor obtainOverrideForBuiltInWithErasedValueParametersInJava(SimpleFunctionDescriptor r10, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r11, Collection<? extends SimpleFunctionDescriptor> r12) {
        FunctionDescriptor r13 = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(r10);
        if (r13 != null) goto L5;
        return null;
    L5:
        SimpleFunctionDescriptor r14 = createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(r13, r11);
        if (r14 != null) goto L8;
        return null;
    L8:
        if (isVisibleAsFunctionInCurrentClass(r14) == true) goto L11;
        r14 = null;
    L11:
        if (r14 != null) goto L13;
        return null;
    L13:
        return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(r14, r13, r12);
    }

    private final SimpleFunctionDescriptor obtainOverrideForBuiltinWithDifferentJvmName(SimpleFunctionDescriptor r10, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r11, Name r12, Collection<? extends SimpleFunctionDescriptor> r13) {
        SimpleFunctionDescriptor r14 = (SimpleFunctionDescriptor) SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(r10);
        if (r14 != null) goto L5;
        return null;
    L5:
        String r15 = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(r14);
        Intrinsics.checkNotNull(r15);
        Name r16 = Name.identifier(r15);
        Intrinsics.checkNotNullExpressionValue(r16, "identifier(nameInJava)");
        Iterator<? extends SimpleFunctionDescriptor> r17 = r11.invoke(r16).iterator();
    L7:
        if (r17.hasNext() == false) goto L12;
        SimpleFunctionDescriptor r18 = createRenamedCopy(r17.next(), r12);
        if (doesOverrideRenamedDescriptor(r14, r18) == false) goto L7;
        return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(r18, r14, r13);
    L12:
        return null;
    }

    private final SimpleFunctionDescriptor obtainOverrideForSuspend(SimpleFunctionDescriptor r10, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r11) {
        if (r10.isSuspend() == true) goto L5;
        return null;
    L5:
        Name r12 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r12, "descriptor.name");
        Iterator<T> r13 = r11.invoke(r12).iterator();
    L7:
        if (r13.hasNext() == false) goto L22;
        SimpleFunctionDescriptor r14 = createSuspendView((SimpleFunctionDescriptor) r13.next());
        if (r14 != null) goto L11;
    L13:
        r14 = null;
    L14:
        if (r14 == null) goto L7;
        return r14;
    L11:
        if (doesOverride(r14, r10) == false) goto L13;
    L22:
        return null;
    }

    private final JavaClassConstructorDescriptor resolveConstructor(JavaConstructor r10) {
        ClassDescriptor r11 = getOwnerDescriptor();
        JavaClassConstructorDescriptor r12 = JavaClassConstructorDescriptor.createJavaConstructor(r11, LazyJavaAnnotationsKt.resolveAnnotations(getC(), r10), false, getC().getComponents().getSourceElementFactory().source(r10));
        Intrinsics.checkNotNullExpressionValue(r12, "createJavaConstructor(\n …ce(constructor)\n        )");
        LazyJavaResolverContext r13 = ContextKt.childForMethod(getC(), r12, r10, r11.getDeclaredTypeParameters().size());
        LazyJavaScope.ResolvedValueParameters r14 = resolveValueParameters(r13, r12, r10.getValueParameters());
        List<TypeParameterDescriptor> r15 = r11.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r15, "classDescriptor.declaredTypeParameters");
        List<JavaTypeParameter> r16 = r10.getTypeParameters();
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r18 = r16.iterator();
    L4:
        if (r18.hasNext() == false) goto L6;
        JavaTypeParameter r19 = (JavaTypeParameter) r18.next();
        TypeParameterDescriptor r20 = r13.getTypeParameterResolver().resolveTypeParameter(r19);
        Intrinsics.checkNotNull(r20);
        r17.add(r20);
        goto L4
    L6:
        List<TypeParameterDescriptor> r21 = CollectionsKt.plus(r15, r17);
        r12.initialize(r14.getDescriptors(), UtilsKt.toDescriptorVisibility(r10.getVisibility()), r21);
        r12.setHasStableParameterNames(false);
        r12.setHasSynthesizedParameterNames(r14.getHasSynthesizedNames());
        r12.setReturnType(r11.getDefaultType());
        r13.getComponents().getJavaResolverCache().recordConstructor(r10, r12);
        return r12;
    }

    private final JavaMethodDescriptor resolveRecordComponentToFunctionDescriptor(JavaRecordComponent r17) {
        Annotations r10 = LazyJavaAnnotationsKt.resolveAnnotations(getC(), r17);
        JavaMethodDescriptor r11 = JavaMethodDescriptor.createJavaMethod(getOwnerDescriptor(), r10, r17.getName(), getC().getComponents().getSourceElementFactory().source(r17), true);
        Intrinsics.checkNotNullExpressionValue(r11, "createJavaMethod(\n      …omponent), true\n        )");
        JavaTypeAttributes r12 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 6, null);
        KotlinType r13 = getC().getTypeResolver().transformJavaType(r17.getType(), r12);
        r11.initialize(null, getDispatchReceiverParameter(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), r13, Modality.Companion.convertFromFlags(false, false, true), DescriptorVisibilities.PUBLIC, null);
        r11.setParameterNamesStatus(false, false);
        getC().getComponents().getJavaResolverCache().recordMethod(r17, r11);
        return r11;
    }

    private final Collection<SimpleFunctionDescriptor> searchMethodsByNameWithoutBuiltinMagic(Name r10) {
        Collection<JavaMethod> r11 = getDeclaredMemberIndex().invoke().findMethodsByName(r10);
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(resolveMethodToFunctionDescriptor((JavaMethod) r13.next()));
        goto L4
    L6:
        return r12;
    }

    private final Collection<SimpleFunctionDescriptor> searchMethodsInSupertypesWithoutBuiltinMagic(Name r10) {
        Set<SimpleFunctionDescriptor> r11 = getFunctionsFromSupertypes(r10);
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L14;
        Object r14 = r13.next();
        SimpleFunctionDescriptor r15 = (SimpleFunctionDescriptor) r14;
        if (SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName(r15) == false) goto L8;
    L11:
        boolean r16 = true;
    L12:
        if (r16 == true) goto L4;
        r12.add(r14);
        goto L4
    L8:
        if (BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(r15) != null) goto L11;
        r16 = false;
        goto L12
    L14:
        return r12;
    }

    private final boolean shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(SimpleFunctionDescriptor r10) {
        BuiltinMethodsWithSpecialGenericSignature r11 = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        Name r12 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r12, ActivityLifecycle.NAME);
        if (r11.getSameAsBuiltinMethodWithErasedValueParameters(r12) == true) goto L5;
        return false;
    L5:
        Name r13 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r13, ActivityLifecycle.NAME);
        Set<SimpleFunctionDescriptor> r14 = getFunctionsFromSupertypes(r13);
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L7:
        if (r16.hasNext() == false) goto L12;
        FunctionDescriptor r17 = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((SimpleFunctionDescriptor) r16.next());
        if (r17 == null) goto L7;
        r15.add(r17);
        goto L7
    L12:
        if (r15.isEmpty() == true) goto L29;
        Iterator r18 = r15.iterator();
    L16:
        if (r18.hasNext() == false) goto L30;
        if (hasSameJvmDescriptorButDoesNotOverride(r10, (FunctionDescriptor) r18.next()) == false) goto L16;
        return true;
    L30:
        return false;
    L29:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computeClassNames(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        return SetsKt.plus(this.nestedClassIndex.invoke(), this.enumEntryIndex.invoke().keySet());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected LinkedHashSet<Name> computeFunctionNames(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        Collection<KotlinType> r12 = getOwnerDescriptor().getTypeConstructor().mo1324getSupertypes();
        Intrinsics.checkNotNullExpressionValue(r12, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet<Name> r13 = new LinkedHashSet();
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        CollectionsKt.addAll(r13, ((KotlinType) r14.next()).getMemberScope().getFunctionNames());
        goto L4
    L6:
        r13.addAll(getDeclaredMemberIndex().invoke().getMethodNames());
        r13.addAll(getDeclaredMemberIndex().invoke().getRecordComponentNames());
        r13.addAll(computeClassNames(r10, r11));
        r13.addAll(getC().getComponents().getSyntheticPartsProvider().getMethodNames(getOwnerDescriptor()));
        return r13;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ Set computeFunctionNames(DescriptorKindFilter r10, Function1 r11) {
        return computeFunctionNames(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> r10, Name r11) {
        Intrinsics.checkNotNullParameter(r10, "result");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        if (this.jClass.isRecord() == true) goto L5;
    L17:
        getC().getComponents().getSyntheticPartsProvider().generateMethods(getOwnerDescriptor(), r11, r10);
        return;
    L5:
        if (getDeclaredMemberIndex().invoke().findRecordComponentByName(r11) == null) goto L17;
        boolean r12 = true;
        if (r10.isEmpty() == true) goto L15;
        Iterator<T> r13 = r10.iterator();
    L11:
        if (r13.hasNext() == false) goto L15;
        if (((SimpleFunctionDescriptor) r13.next()).getValueParameters().isEmpty() == false) goto L11;
        r12 = false;
    L15:
        if (r12 == false) goto L17;
        JavaRecordComponent r14 = getDeclaredMemberIndex().invoke().findRecordComponentByName(r11);
        Intrinsics.checkNotNull(r14);
        r10.add(resolveRecordComponentToFunctionDescriptor(r14));
        goto L17
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, AnonymousClass1.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ DeclaredMemberIndex computeMemberIndex() {
        return computeMemberIndex();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> r11, Name r12) {
        Intrinsics.checkNotNullParameter(r11, "result");
        Intrinsics.checkNotNullParameter(r12, ActivityLifecycle.NAME);
        Set<SimpleFunctionDescriptor> r10 = getFunctionsFromSupertypes(r12);
        if (SpecialGenericSignatures.Companion.getSameAsRenamedInJvmBuiltin(r12) == false) goto L5;
    L26:
        SmartSet r13 = SmartSet.Companion.create();
        Collection<? extends SimpleFunctionDescriptor> r14 = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(r12, r10, CollectionsKt.emptyList(), getOwnerDescriptor(), ErrorReporter.DO_NOTHING, getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(r14, "resolveOverridesForNonSt….overridingUtil\n        )");
        addOverriddenSpecialMethods(r12, r11, r14, r11, new AnonymousClass3(this));
        addOverriddenSpecialMethods(r12, r11, r14, r13, new AnonymousClass4(this));
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r10.iterator();
    L28:
        if (r16.hasNext() == false) goto L32;
        Object r17 = r16.next();
        if (isVisibleAsFunctionInCurrentClass((SimpleFunctionDescriptor) r17) == false) goto L28;
        r15.add(r17);
        goto L28
    L32:
        addFunctionFromSupertypes(r11, r12, CollectionsKt.plus(r15, r13), true);
        return;
    L5:
        if (BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(r12) == true) goto L26;
        if ((r10 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r18 = r10.iterator();
    L13:
        if (r18.hasNext() == false) goto L10;
        if (((FunctionDescriptor) r18.next()).isSuspend() == false) goto L13;
        boolean r19 = false;
    L17:
        if (r19 == false) goto L26;
        ArrayList r20 = new ArrayList();
        Iterator<T> r21 = r10.iterator();
    L20:
        if (r21.hasNext() == false) goto L24;
        Object r22 = r21.next();
        if (isVisibleAsFunctionInCurrentClass((SimpleFunctionDescriptor) r22) == false) goto L20;
        r20.add(r22);
        goto L20
    L24:
        addFunctionFromSupertypes(r11, r12, r20, false);
        return;
    L10:
        r19 = true;
        goto L17
    L9:
        if (r10.isEmpty() == false) goto L11;
        goto L10
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredProperties(Name r12, Collection<PropertyDescriptor> r13) {
        Intrinsics.checkNotNullParameter(r12, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r13, "result");
        if (this.jClass.isAnnotationType() == false) goto L5;
        computeAnnotationProperties(r12, r13);
    L5:
        Set<PropertyDescriptor> r10 = getPropertiesFromSupertypes(r12);
        if (r10.isEmpty() == false) goto L8;
        return;
    L8:
        SmartSet.Companion r11 = SmartSet.Companion;
        SmartSet r14 = r11.create();
        SmartSet r15 = r11.create();
        addPropertyOverrideByMethod(r10, r13, r14, new C04171(this));
        addPropertyOverrideByMethod(SetsKt.minus(r10, r14), r15, null, new AnonymousClass2(this));
        Collection<? extends PropertyDescriptor> r16 = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(r12, SetsKt.plus(r10, r15), r13, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(r16, "resolveOverridesForNonSt…rridingUtil\n            )");
        r13.addAll(r16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computePropertyNames(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        if (this.jClass.isAnnotationType() == true) goto L5;
        LinkedHashSet r12 = new LinkedHashSet(getDeclaredMemberIndex().invoke().getFieldNames());
        Collection<KotlinType> r13 = getOwnerDescriptor().getTypeConstructor().mo1324getSupertypes();
        Intrinsics.checkNotNullExpressionValue(r13, "ownerDescriptor.typeConstructor.supertypes");
        Iterator<T> r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        CollectionsKt.addAll(r12, ((KotlinType) r14.next()).getMemberScope().getVariableNames());
        goto L8
    L10:
        return r12;
    L5:
        return getFunctionNames();
    }

    public final NotNullLazyValue<List<ClassConstructorDescriptor>> getConstructors$descriptors_jvm() {
        return this.constructors;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1325getContributedClassifier(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        mo1329recordLookup(r10, r11);
        LazyJavaClassMemberScope r12 = (LazyJavaClassMemberScope) getMainScope();
        if (r12 == null) goto L10;
        MemoizedFunctionToNullable<Name, ClassDescriptorBase> r13 = r12.nestedClasses;
        if (r13 == null) goto L10;
        ClassDescriptorBase r14 = r13.invoke(r10);
        if (r14 == null) goto L10;
        return r14;
    L10:
        return this.nestedClasses.invoke(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        mo1329recordLookup(r10, r11);
        return super.getContributedFunctions(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        mo1329recordLookup(r10, r11);
        return super.getContributedVariables(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return DescriptorUtils.getDispatchReceiverParameterIfNeeded(getOwnerDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected ClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOwnerDescriptor() {
        return getOwnerDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected boolean isVisibleAsFunction(JavaMethodDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (this.jClass.isAnnotationType() == false) goto L7;
        return false;
    L7:
        return isVisibleAsFunctionInCurrentClass(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo1329recordLookup(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        kotlin.reflect.jvm.internal.impl.incremental.UtilsKt.record(getC().getComponents().getLookupTracker(), r11, getOwnerDescriptor(), r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected LazyJavaScope.MethodSignatureData resolveMethodSignature(JavaMethod r10, List<? extends TypeParameterDescriptor> r11, KotlinType r12, List<? extends ValueParameterDescriptor> r13) {
        Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
        Intrinsics.checkNotNullParameter(r11, "methodTypeParameters");
        Intrinsics.checkNotNullParameter(r12, "returnType");
        Intrinsics.checkNotNullParameter(r13, "valueParameters");
        SignaturePropagator.PropagatedSignature r14 = getC().getComponents().getSignaturePropagator().resolvePropagatedSignature(r10, getOwnerDescriptor(), r12, null, r13, r11);
        Intrinsics.checkNotNullExpressionValue(r14, "c.components.signaturePr…dTypeParameters\n        )");
        KotlinType r15 = r14.getReturnType();
        Intrinsics.checkNotNullExpressionValue(r15, "propagated.returnType");
        KotlinType r16 = r14.getReceiverType();
        List<ValueParameterDescriptor> r17 = r14.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r17, "propagated.valueParameters");
        List<TypeParameterDescriptor> r18 = r14.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r18, "propagated.typeParameters");
        boolean r19 = r14.hasStableParameterNames();
        List<String> r20 = r14.getErrors();
        Intrinsics.checkNotNullExpressionValue(r20, "propagated.errors");
        return new LazyJavaScope.MethodSignatureData(r15, r16, r17, r18, r19, r20);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public String toString() {
        return "Lazy Java member scope for " + this.jClass.getFqName();
    }
}
