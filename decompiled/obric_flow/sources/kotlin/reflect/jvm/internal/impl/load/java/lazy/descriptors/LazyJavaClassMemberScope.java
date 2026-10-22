package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

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
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nLazyJavaClassMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaClassMemberScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassMemberScope\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,890:1\n1446#2,5:891\n1747#2,2:897\n1747#2,3:899\n1749#2:902\n1603#2,9:903\n1855#2:912\n1856#2:914\n1612#2:915\n1747#2,3:916\n1549#2:919\n1620#2,3:920\n819#2:923\n847#2,2:924\n766#2:926\n857#2,2:927\n1747#2,3:929\n1747#2,3:932\n2624#2,3:935\n766#2:938\n857#2,2:939\n766#2:941\n857#2,2:942\n1549#2:944\n1620#2,3:945\n2624#2,3:948\n288#2,2:951\n1549#2:953\n1620#2,3:954\n1446#2,5:957\n2624#2,3:962\n1360#2:965\n1446#2,2:966\n1549#2:968\n1620#2,3:969\n1448#2,3:972\n1549#2:975\n1620#2,3:976\n3190#2,10:979\n1446#2,5:989\n1#3:896\n1#3:913\n*S KotlinDebug\n*F\n+ 1 LazyJavaClassMemberScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassMemberScope\n*L\n74#1:891,5\n160#1:897,2\n161#1:899,3\n160#1:902\n189#1:903,9\n189#1:912\n189#1:914\n189#1:915\n193#1:916,3\n199#1:919\n199#1:920,3\n202#1:923\n202#1:924,2\n211#1:926\n211#1:927,2\n216#1:929,3\n222#1:932,3\n322#1:935,3\n327#1:938\n327#1:939,2\n354#1:941\n354#1:942,2\n376#1:944\n376#1:945,3\n461#1:948,3\n470#1:951,2\n476#1:953\n476#1:954,3\n489#1:957,5\n495#1:962,3\n649#1:965\n649#1:966,2\n650#1:968\n650#1:969,3\n649#1:972,3\n698#1:975\n698#1:976,3\n749#1:979,10\n879#1:989,5\n189#1:913\n*E\n"})
public final class LazyJavaClassMemberScope extends LazyJavaScope {
    private final NotNullLazyValue<List<ClassConstructorDescriptor>> constructors;
    private final NotNullLazyValue<Map<Name, JavaField>> enumEntryIndex;
    private final NotNullLazyValue<Set<Name>> generatedNestedClassNames;
    private final JavaClass jClass;
    private final NotNullLazyValue<Set<Name>> nestedClassIndex;
    private final MemoizedFunctionToNullable<Name, ClassDescriptor> nestedClasses;
    private final ClassDescriptor ownerDescriptor;
    private final boolean skipRefinement;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredFunctions$3, reason: invalid class name */
    public /* synthetic */ class AnonymousClass3 extends FunctionReference implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public AnonymousClass3(Object r5) {
            super(1, r5);
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
        public /* bridge */ /* synthetic */ Collection<? extends SimpleFunctionDescriptor> invoke(Name r5) {
            return invoke2(r5);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<SimpleFunctionDescriptor> invoke2(Name r5) {
            Intrinsics.checkNotNullParameter(r5, "p0");
            return LazyJavaClassMemberScope.access$searchMethodsByNameWithoutBuiltinMagic((LazyJavaClassMemberScope) this.receiver, r5);
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredFunctions$4, reason: invalid class name */
    public /* synthetic */ class AnonymousClass4 extends FunctionReference implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public AnonymousClass4(Object r5) {
            super(1, r5);
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
        public /* bridge */ /* synthetic */ Collection<? extends SimpleFunctionDescriptor> invoke(Name r5) {
            return invoke2(r5);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<SimpleFunctionDescriptor> invoke2(Name r5) {
            Intrinsics.checkNotNullParameter(r5, "p0");
            return LazyJavaClassMemberScope.access$searchMethodsInSupertypesWithoutBuiltinMagic((LazyJavaClassMemberScope) this.receiver, r5);
        }
    }

    public /* synthetic */ LazyJavaClassMemberScope(LazyJavaResolverContext r10, ClassDescriptor r11, JavaClass r12, boolean r13, LazyJavaClassMemberScope r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 16) == 0) goto L5;
        r14 = null;
    L5:
        this(r10, r11, r12, r13, r14);
    }

    public static final /* synthetic */ ClassConstructorDescriptor access$createDefaultConstructor(LazyJavaClassMemberScope r5) {
        return r5.createDefaultConstructor();
    }

    public static final /* synthetic */ ClassConstructorDescriptor access$createDefaultRecordConstructor(LazyJavaClassMemberScope r5) {
        return r5.createDefaultRecordConstructor();
    }

    public static final /* synthetic */ NotNullLazyValue access$getEnumEntryIndex$p(LazyJavaClassMemberScope r5) {
        return r5.enumEntryIndex;
    }

    public static final /* synthetic */ NotNullLazyValue access$getGeneratedNestedClassNames$p(LazyJavaClassMemberScope r5) {
        return r5.generatedNestedClassNames;
    }

    public static final /* synthetic */ JavaClass access$getJClass$p(LazyJavaClassMemberScope r5) {
        return r5.jClass;
    }

    public static final /* synthetic */ NotNullLazyValue access$getNestedClassIndex$p(LazyJavaClassMemberScope r5) {
        return r5.nestedClassIndex;
    }

    public static final /* synthetic */ JavaClassConstructorDescriptor access$resolveConstructor(LazyJavaClassMemberScope r5, JavaConstructor r10) {
        return r5.resolveConstructor(r10);
    }

    public static final /* synthetic */ Collection access$searchMethodsByNameWithoutBuiltinMagic(LazyJavaClassMemberScope r5, Name r10) {
        return r5.searchMethodsByNameWithoutBuiltinMagic(r10);
    }

    public static final /* synthetic */ Collection access$searchMethodsInSupertypesWithoutBuiltinMagic(LazyJavaClassMemberScope r5, Name r10) {
        return r5.searchMethodsInSupertypesWithoutBuiltinMagic(r10);
    }

    private final void addAnnotationValueParameter(List<ValueParameterDescriptor> r14, ConstructorDescriptor r15, int r16, JavaMethod r17, KotlinType r18, KotlinType r19) {
        Annotations r5 = Annotations.Companion.getEMPTY();
        Name r10 = r17.getName();
        KotlinType r11 = TypeUtils.makeNotNullable(r18);
        boolean r12 = r17.getHasAnnotationParameterDefaultValue();
        if (r19 == null) goto L6;
        KotlinType r13 = TypeUtils.makeNotNullable(r19);
    L5:
        KotlinType r110 = r13;
        r14.add(new ValueParameterDescriptorImpl(r15, null, r16, r5, r10, r11, r12, false, false, r110, getC().getComponents().getSourceElementFactory().source(r17)));
        return;
    L6:
        r13 = null;
        goto L5
    }

    private final void addFunctionFromSupertypes(Collection<SimpleFunctionDescriptor> r10, Name r11, Collection<? extends SimpleFunctionDescriptor> r12, boolean r13) {
        Collection<? extends SimpleFunctionDescriptor> r14 = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(r11, r12, r10, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        if (r13 == true) goto L5;
        r10.addAll(r14);
        return;
    L5:
        Collection<? extends SimpleFunctionDescriptor> r15 = r14;
        List r16 = CollectionsKt.plus(r10, r15);
        ArrayList r17 = new ArrayList(CollectionsKt.h(r15));
        Iterator r18 = r15.iterator();
    L7:
        if (r18.hasNext() == false) goto L13;
        SimpleFunctionDescriptor r5 = (SimpleFunctionDescriptor) r18.next();
        SimpleFunctionDescriptor r19 = (SimpleFunctionDescriptor) SpecialBuiltinMembers.getOverriddenSpecialBuiltin(r5);
        if (r19 == null) goto L12;
        r5 = createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(r5, r19, r16);
    L12:
        r17.add(r5);
        goto L7
    L13:
        r10.addAll(r17);
    }

    private final void addOverriddenSpecialMethods(Name r5, Collection<? extends SimpleFunctionDescriptor> r10, Collection<? extends SimpleFunctionDescriptor> r11, Collection<SimpleFunctionDescriptor> r12, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r13) {
        Iterator<? extends SimpleFunctionDescriptor> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        SimpleFunctionDescriptor r15 = r14.next();
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r12, obtainOverrideForBuiltinWithDifferentJvmName(r15, r13, r5, r10));
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r12, obtainOverrideForBuiltInWithErasedValueParametersInJava(r15, r13, r10));
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r12, obtainOverrideForSuspend(r15, r13));
        goto L4
    }

    private final void addPropertyOverrideByMethod(Set<? extends PropertyDescriptor> r5, Collection<PropertyDescriptor> r10, Set<PropertyDescriptor> r11, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r12) {
        Iterator<? extends PropertyDescriptor> r13 = r5.iterator();
    L4:
        if (r13.hasNext() == false) goto L15;
        PropertyDescriptor r14 = r13.next();
        JavaPropertyDescriptor r15 = createPropertyDescriptorByMethods(r14, r12);
        if (r15 == null) goto L4;
        r10.add(r15);
        if (r11 == null) goto L14;
        r11.add(r14);
        return;
    L14:
        return;
    }

    private final void computeAnnotationProperties(Name r10, Collection<PropertyDescriptor> r11) {
        JavaMethod r5 = (JavaMethod) CollectionsKt.singleOrNull(getDeclaredMemberIndex().invoke().findMethodsByName(r10));
        if (r5 != null) goto L5;
        return;
    L5:
        r11.add(createPropertyDescriptorWithDefaultGetter$default(this, r5, null, Modality.FINAL, 2, null));
    }

    private final Collection<KotlinType> computeSupertypes() {
        if (this.skipRefinement == false) goto L7;
        return getOwnerDescriptor().getTypeConstructor().mo1403getSupertypes();
    L7:
        return getC().getComponents().getKotlinTypeChecker().getKotlinTypeRefiner().refineSupertypes(getOwnerDescriptor());
    }

    private final List<ValueParameterDescriptor> createAnnotationConstructorParameters(ClassConstructorDescriptorImpl r13) {
        Collection<JavaMethod> r5 = this.jClass.getMethods();
        ArrayList r10 = new ArrayList(r5.size());
        JavaTypeAttributes r11 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, true, false, null, 6, null);
        ArrayList r12 = new ArrayList();
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r5.iterator();
    L4:
        if (r15.hasNext() == false) goto L9;
        Object r16 = r15.next();
        if (Intrinsics.areEqual(((JavaMethod) r16).getName(), JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME) == true) goto L7;
        r14.add(r16);
        goto L4
    L7:
        r12.add(r16);
        goto L4
    L9:
        Pair r17 = new Pair(r12, r14);
        List r18 = (List) r17.component1();
        List r19 = (List) r17.component2();
        r18.size();
        JavaMethod r110 = (JavaMethod) CollectionsKt.firstOrNull(r18);
        int r111 = 1;
        if (r110 == null) goto L16;
        JavaType r20 = r110.getReturnType();
        if ((r20 instanceof JavaArrayType) == false) goto L14;
        JavaArrayType r21 = (JavaArrayType) r20;
        Pair r22 = new Pair(getC().getTypeResolver().transformArrayType(r21, r11, true), getC().getTypeResolver().transformJavaType(r21.getComponentType(), r11));
    L15:
        addAnnotationValueParameter(r10, r13, 0, r110, (KotlinType) r22.component1(), (KotlinType) r22.component2());
        goto L16
    L14:
        r22 = new Pair(getC().getTypeResolver().transformJavaType(r20, r11), null);
    L16:
        int r23 = 0;
        if (r110 != null) goto L20;
        r111 = 0;
    L20:
        Iterator r24 = r19.iterator();
    L22:
        if (r24.hasNext() == false) goto L24;
        JavaMethod r25 = (JavaMethod) r24.next();
        addAnnotationValueParameter(r10, r13, r23 + r111, r25, getC().getTypeResolver().transformJavaType(r25.getReturnType(), r11), null);
        r23 = r23 + 1;
        goto L22
    L24:
        return r10;
    }

    private final ClassConstructorDescriptor createDefaultConstructor() {
        boolean r5 = this.jClass.isAnnotationType();
        if (this.jClass.isInterface() == false) goto L5;
    L6:
        if (r5 == true) goto L9;
        return null;
    L9:
        ClassDescriptor r10 = getOwnerDescriptor();
        JavaClassConstructorDescriptor r11 = JavaClassConstructorDescriptor.createJavaConstructor(r10, Annotations.Companion.getEMPTY(), true, getC().getComponents().getSourceElementFactory().source(this.jClass));
        if (r5 == false) goto L12;
        List<ValueParameterDescriptor> r12 = createAnnotationConstructorParameters(r11);
    L13:
        r11.setHasSynthesizedParameterNames(false);
        r11.initialize(r12, getConstructorVisibility(r10));
        r11.setHasStableParameterNames(true);
        r11.setReturnType(r10.getDefaultType());
        getC().getComponents().getJavaResolverCache().recordConstructor(this.jClass, r11);
        return r11;
    L12:
        r12 = Collections.emptyList();
        goto L13
    L5:
        if (this.jClass.hasDefaultConstructor() == true) goto L9;
        goto L6
    }

    private final ClassConstructorDescriptor createDefaultRecordConstructor() {
        ClassDescriptor r5 = getOwnerDescriptor();
        JavaClassConstructorDescriptor r10 = JavaClassConstructorDescriptor.createJavaConstructor(r5, Annotations.Companion.getEMPTY(), true, getC().getComponents().getSourceElementFactory().source(this.jClass));
        List<ValueParameterDescriptor> r11 = createRecordConstructorParameters(r10);
        r10.setHasSynthesizedParameterNames(false);
        r10.initialize(r11, getConstructorVisibility(r5));
        r10.setHasStableParameterNames(false);
        r10.setReturnType(r5.getDefaultType());
        return r10;
    }

    private final SimpleFunctionDescriptor createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(SimpleFunctionDescriptor r5, CallableDescriptor r10, Collection<? extends SimpleFunctionDescriptor> r11) {
        Collection<? extends SimpleFunctionDescriptor> r12 = r11;
        if ((r12 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L27;
        SimpleFunctionDescriptor r14 = (SimpleFunctionDescriptor) r13.next();
        if (Intrinsics.areEqual(r5, r14) == true) goto L9;
        if (r14.getInitialSignatureDescriptor() != null) goto L9;
        if (doesOverride(r14, r10) == false) goto L9;
        FunctionDescriptor r15 = r5.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
        Intrinsics.checkNotNull(r15);
        return (SimpleFunctionDescriptor) r15;
    L27:
        return r5;
    L5:
        if (r12.isEmpty() == false) goto L7;
        return r5;
    }

    private final SimpleFunctionDescriptor createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(FunctionDescriptor r5, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r10) {
        Iterator<T> r11 = r10.invoke(r5.getName()).iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        if (hasSameJvmDescriptorButDoesNotOverride((SimpleFunctionDescriptor) r12, r5) == false) goto L4;
    L9:
        SimpleFunctionDescriptor r13 = (SimpleFunctionDescriptor) r12;
        if (r13 == null) goto L21;
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> r14 = r13.newCopyBuilder();
        List<ValueParameterDescriptor> r15 = r5.getValueParameters();
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator<T> r17 = r15.iterator();
    L13:
        if (r17.hasNext() == false) goto L15;
        r16.add(((ValueParameterDescriptor) r17.next()).getType());
        goto L13
    L15:
        r14.setValueParameters(UtilKt.copyValueParameters(r16, r13.getValueParameters(), r5));
        r14.setSignatureChange();
        r14.setPreserveSourceElement();
        r14.putUserData(JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS, Boolean.TRUE);
        return (SimpleFunctionDescriptor) r14.build();
    L21:
        return null;
    L8:
        r12 = null;
        goto L9
    }

    private final JavaPropertyDescriptor createPropertyDescriptorByMethods(PropertyDescriptor r12, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r13) {
        PropertySetterDescriptorImpl r5 = null;
        if (doesClassOverridesProperty(r12, r13) == true) goto L5;
        return null;
    L5:
        SimpleFunctionDescriptor r10 = findGetterOverride(r12, r13);
        Intrinsics.checkNotNull(r10);
        if (r12.isVar() == false) goto L8;
        SimpleFunctionDescriptor r14 = findSetterOverride(r12, r13);
        Intrinsics.checkNotNull(r14);
    L9:
        if (r14 == null) goto L11;
        r14.getModality();
        r10.getModality();
    L11:
        JavaForKotlinOverridePropertyDescriptor r11 = new JavaForKotlinOverridePropertyDescriptor(getOwnerDescriptor(), r10, r14, r12);
        KotlinType r15 = r10.getReturnType();
        Intrinsics.checkNotNull(r15);
        r11.setType(r15, CollectionsKt.emptyList(), getDispatchReceiverParameter(), null, CollectionsKt.emptyList());
        PropertyGetterDescriptorImpl r16 = DescriptorFactory.createGetter(r11, r10.getAnnotations(), false, false, false, r10.getSource());
        r16.setInitialSignatureDescriptor(r10);
        r16.initialize(r11.getType());
        if (r14 == null) goto L18;
        ValueParameterDescriptor r17 = (ValueParameterDescriptor) CollectionsKt.firstOrNull(r14.getValueParameters());
        if (r17 == null) goto L17;
        r5 = DescriptorFactory.createSetter(r11, r14.getAnnotations(), r17.getAnnotations(), false, false, false, r14.getVisibility(), r14.getSource());
        r5.setInitialSignatureDescriptor(r14);
        goto L18
    L17:
        throw new AssertionError("No parameter found for " + r14);
    L18:
        r11.initialize(r16, r5);
        return r11;
    L8:
        r14 = null;
        goto L9
    }

    private final JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter(JavaMethod r16, KotlinType r17, Modality r18) {
        Annotations r10 = LazyJavaAnnotationsKt.resolveAnnotations(getC(), r16);
        JavaPropertyDescriptor r11 = JavaPropertyDescriptor.create(getOwnerDescriptor(), r10, r18, UtilsKt.toDescriptorVisibility(r16.getVisibility()), false, r16.getName(), getC().getComponents().getSourceElementFactory().source(r16), false);
        PropertyGetterDescriptorImpl r12 = DescriptorFactory.createDefaultGetter(r11, Annotations.Companion.getEMPTY());
        r11.initialize(r12, null);
        if (r17 != null) goto L5;
        KotlinType r13 = computeMethodReturnType(r16, ContextKt.childForMethod$default(getC(), r11, r16, 0, 4, null));
    L6:
        KotlinType r5 = r13;
        r11.setType(r5, CollectionsKt.emptyList(), getDispatchReceiverParameter(), null, CollectionsKt.emptyList());
        r12.initialize(r13);
        return r11;
    L5:
        r13 = r17;
        goto L6
    }

    public static /* synthetic */ JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter$default(LazyJavaClassMemberScope r5, JavaMethod r10, KotlinType r11, Modality r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        return r5.createPropertyDescriptorWithDefaultGetter(r10, r11, r12);
    }

    private final List<ValueParameterDescriptor> createRecordConstructorParameters(ClassConstructorDescriptorImpl r20) {
        Collection<JavaRecordComponent> r5 = this.jClass.getRecordComponents();
        ArrayList r10 = new ArrayList(r5.size());
        JavaTypeAttributes r11 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 6, null);
        Iterator<JavaRecordComponent> r12 = r5.iterator();
        int r13 = 0;
    L3:
        int r14 = r13;
        if (r12.hasNext() == false) goto L11;
        r13 = r14 + 1;
        JavaRecordComponent r15 = r12.next();
        KotlinType r16 = getC().getTypeResolver().transformJavaType(r15.getType(), r11);
        if (r15.isVararg() == false) goto L9;
        KotlinType r17 = getC().getComponents().getModule().getBuiltIns().getArrayElementType(r16);
    L8:
        KotlinType r18 = r17;
        r10.add(new ValueParameterDescriptorImpl(r20, null, r14, Annotations.Companion.getEMPTY(), r15.getName(), r16, false, false, false, r18, getC().getComponents().getSourceElementFactory().source(r15)));
        goto L3
    L9:
        r17 = null;
        goto L8
    L11:
        return r10;
    }

    private final SimpleFunctionDescriptor createRenamedCopy(SimpleFunctionDescriptor r5, Name r10) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> r11 = r5.newCopyBuilder();
        r11.setName(r10);
        r11.setSignatureChange();
        r11.setPreserveSourceElement();
        FunctionDescriptor r12 = r11.build();
        Intrinsics.checkNotNull(r12);
        return (SimpleFunctionDescriptor) r12;
    }

    private final SimpleFunctionDescriptor createSuspendView(SimpleFunctionDescriptor r5) {
        ValueParameterDescriptor r10 = (ValueParameterDescriptor) CollectionsKt.lastOrNull(r5.getValueParameters());
        if (r10 == null) goto L26;
        ClassifierDescriptor r11 = r10.getType().getConstructor().mo1402getDeclarationDescriptor();
        if (r11 == null) goto L14;
        FqNameUnsafe r12 = DescriptorUtilsKt.getFqNameUnsafe(r11);
        if (r12 == null) goto L14;
        if (r12.isSafe() == true) goto L12;
        r12 = null;
    L12:
        if (r12 == null) goto L14;
        FqName r13 = r12.toSafe();
    L16:
        if (Intrinsics.areEqual(r13, StandardNames.CONTINUATION_INTERFACE_FQ_NAME) == true) goto L19;
        r10 = null;
    L19:
        if (r10 == null) goto L26;
        SimpleFunctionDescriptor r14 = (SimpleFunctionDescriptor) r5.newCopyBuilder().setValueParameters(CollectionsKt.dropLast(r5.getValueParameters(), 1)).setReturnType(r10.getType().getArguments().get(0).getType()).build();
        SimpleFunctionDescriptorImpl r15 = (SimpleFunctionDescriptorImpl) r14;
        if (r15 == null) goto L25;
        r15.setSuspend(true);
    L25:
        return r14;
    L14:
        r13 = null;
    L26:
        return null;
    }

    private final boolean doesClassOverridesProperty(PropertyDescriptor r5, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r10) {
        if (JavaDescriptorUtilKt.isJavaField(r5) == false) goto L5;
        return false;
    L5:
        SimpleFunctionDescriptor r11 = findGetterOverride(r5, r10);
        SimpleFunctionDescriptor r12 = findSetterOverride(r5, r10);
        if (r11 != null) goto L9;
        return false;
    L9:
        if (r5.isVar() == true) goto L11;
        return true;
    L11:
        if (r12 != null) goto L13;
        return false;
    L13:
        if (r12.getModality() == r11.getModality()) goto L15;
        return false;
    L15:
        return true;
    }

    private final boolean doesOverride(CallableDescriptor r5, CallableDescriptor r10) {
        if (OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(r10, r5, true).getResult() == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) goto L5;
    L7:
        return false;
    L5:
        if (JavaIncompatibilityRulesOverridabilityCondition.Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(r10, r5) == true) goto L7;
        return true;
    }

    private final boolean doesOverrideRenamedBuiltins(SimpleFunctionDescriptor r10) {
        Name r5 = SpecialGenericSignatures.Companion.getBuiltinFunctionNamesByJvmName(r10.getName());
        if (r5 != null) goto L5;
        return false;
    L5:
        Set<SimpleFunctionDescriptor> r11 = getFunctionsFromSupertypes(r5);
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L12;
        Object r14 = r13.next();
        if (SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName((SimpleFunctionDescriptor) r14) == false) goto L7;
        r12.add(r14);
        goto L7
    L12:
        if (r12.isEmpty() == false) goto L14;
        return false;
    L14:
        SimpleFunctionDescriptor r15 = createRenamedCopy(r10, r5);
        if (r12.isEmpty() == true) goto L32;
        Iterator r16 = r12.iterator();
    L19:
        if (r16.hasNext() == false) goto L33;
        if (doesOverrideRenamedDescriptor((SimpleFunctionDescriptor) r16.next(), r15) == false) goto L19;
        return true;
    L33:
        return false;
    L32:
        return false;
    }

    private final boolean doesOverrideRenamedDescriptor(SimpleFunctionDescriptor r5, FunctionDescriptor r10) {
        if (BuiltinMethodsWithDifferentJvmName.INSTANCE.isRemoveAtByIndex(r5) == false) goto L6;
        r10 = r10.getOriginal();
    L6:
        return doesOverride(r10, r5);
    }

    private final boolean doesOverrideSuspendFunction(SimpleFunctionDescriptor r5) {
        SimpleFunctionDescriptor r10 = createSuspendView(r5);
        if (r10 != null) goto L5;
        return false;
    L5:
        Set<SimpleFunctionDescriptor> r11 = getFunctionsFromSupertypes(r5.getName());
        if ((r11 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r12 = r11.iterator();
    L12:
        if (r12.hasNext() == false) goto L26;
        SimpleFunctionDescriptor r13 = (SimpleFunctionDescriptor) r12.next();
        if (r13.isSuspend() == false) goto L12;
        if (doesOverride(r10, r13) == false) goto L12;
        return true;
    L26:
        return false;
    L8:
        if (r11.isEmpty() == false) goto L10;
        return false;
    }

    private final SimpleFunctionDescriptor findGetterByName(PropertyDescriptor r5, String r10, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r11) {
        Iterator<T> r12 = r11.invoke(Name.identifier(r10)).iterator();
    L3:
        SimpleFunctionDescriptor r13 = null;
        if (r12.hasNext() == false) goto L15;
        SimpleFunctionDescriptor r14 = (SimpleFunctionDescriptor) r12.next();
        if (r14.getValueParameters().size() != 0) goto L14;
        KotlinTypeChecker r15 = KotlinTypeChecker.DEFAULT;
        KotlinType r16 = r14.getReturnType();
        if (r16 != null) goto L11;
        boolean r17 = false;
    L12:
        if (r17 == false) goto L14;
        r13 = r14;
        goto L14
    L11:
        r17 = r15.isSubtypeOf(r16, r5.getType());
    L14:
        if (r13 == null) goto L3;
    L15:
        return r13;
    }

    private final SimpleFunctionDescriptor findGetterOverride(PropertyDescriptor r5, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r10) {
        PropertyGetterDescriptor r11 = r5.getGetter();
        String r12 = null;
        if (r11 == null) goto L5;
        PropertyGetterDescriptor r13 = (PropertyGetterDescriptor) SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(r11);
    L6:
        if (r13 == null) goto L8;
        r12 = ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(r13);
    L8:
        if (r12 == null) goto L14;
        if (SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(getOwnerDescriptor(), r13) == true) goto L14;
        return findGetterByName(r5, r12, r10);
    L14:
        return findGetterByName(r5, JvmAbi.getterName(r5.getName().asString()), r10);
    L5:
        r13 = null;
        goto L6
    }

    private final SimpleFunctionDescriptor findSetterOverride(PropertyDescriptor r5, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r10) {
        Iterator<T> r11 = r10.invoke(Name.identifier(JvmAbi.setterName(r5.getName().asString()))).iterator();
    L3:
        SimpleFunctionDescriptor r12 = null;
        if (r11.hasNext() == false) goto L18;
        SimpleFunctionDescriptor r13 = (SimpleFunctionDescriptor) r11.next();
        if (r13.getValueParameters().size() != 1) goto L17;
        KotlinType r14 = r13.getReturnType();
        if (r14 == null) goto L17;
        if (KotlinBuiltIns.isUnit(r14) == false) goto L17;
        if (KotlinTypeChecker.DEFAULT.equalTypes(((ValueParameterDescriptor) CollectionsKt.single(r13.getValueParameters())).getType(), r5.getType()) == false) goto L17;
        r12 = r13;
    L17:
        if (r12 == null) goto L3;
    L18:
        return r12;
    }

    private final DescriptorVisibility getConstructorVisibility(ClassDescriptor r5) {
        DescriptorVisibility r10 = r5.getVisibility();
        if (Intrinsics.areEqual(r10, JavaDescriptorVisibilities.PROTECTED_STATIC_VISIBILITY) == true) goto L5;
        return r10;
    L5:
        return JavaDescriptorVisibilities.PROTECTED_AND_PACKAGE;
    }

    private final Set<SimpleFunctionDescriptor> getFunctionsFromSupertypes(Name r5) {
        Collection<KotlinType> r10 = computeSupertypes();
        LinkedHashSet r11 = new LinkedHashSet();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        CollectionsKt.a(r11, ((KotlinType) r12.next()).getMemberScope().getContributedFunctions(r5, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        goto L4
    L6:
        return r11;
    }

    private final Set<PropertyDescriptor> getPropertiesFromSupertypes(Name r5) {
        Collection<KotlinType> r10 = computeSupertypes();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Collection<? extends PropertyDescriptor> r13 = ((KotlinType) r12.next()).getMemberScope().getContributedVariables(r5, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
        ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator<T> r15 = r13.iterator();
    L7:
        if (r15.hasNext() == false) goto L9;
        r14.add((PropertyDescriptor) r15.next());
        goto L7
    L9:
        CollectionsKt.a(r11, r14);
        goto L4
    L11:
        return CollectionsKt.toSet(r11);
    }

    private final boolean hasSameJvmDescriptorButDoesNotOverride(SimpleFunctionDescriptor r10, FunctionDescriptor r11) {
        if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default(r10, false, false, 2, null), MethodSignatureMappingKt.computeJvmDescriptor$default(r11.getOriginal(), false, false, 2, null)) == true) goto L5;
        return false;
    L5:
        if (doesOverride(r10, r11) == true) goto L9;
        return true;
    L9:
        return false;
    }

    private final boolean isVisibleAsFunctionInCurrentClass(final SimpleFunctionDescriptor r10) {
        List<Name> r5 = PropertiesConventionUtilKt.getPropertyNamesCandidatesByAccessorName(r10.getName());
        if (r5 != null) goto L5;
    L7:
        Iterator<T> r11 = r5.iterator();
    L9:
        if (r11.hasNext() == false) goto L26;
        Set<PropertyDescriptor> r12 = getPropertiesFromSupertypes((Name) r11.next());
        if ((r12 instanceof Collection) == false) goto L15;
        if (r12.isEmpty() == true) goto L9;
    L15:
        Iterator<T> r13 = r12.iterator();
    L17:
        if (r13.hasNext() == false) goto L9;
        PropertyDescriptor r14 = (PropertyDescriptor) r13.next();
        if (doesClassOverridesProperty(r14, new LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1(r10, this)) == false) goto L17;
        if (r14.isVar() == true) goto L24;
        if (JvmAbi.isSetterName(r10.getName().asString()) == true) goto L17;
    L24:
        return false;
    L26:
        if (doesOverrideRenamedBuiltins(r10) == false) goto L28;
        return false;
    L28:
        if (shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(r10) == false) goto L30;
        return false;
    L30:
        if (doesOverrideSuspendFunction(r10) == true) goto L47;
        return true;
    L47:
        return false;
    L5:
        if (r5.isEmpty() == false) goto L7;
        goto L7
    }

    private final SimpleFunctionDescriptor obtainOverrideForBuiltInWithErasedValueParametersInJava(SimpleFunctionDescriptor r5, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r10, Collection<? extends SimpleFunctionDescriptor> r11) {
        FunctionDescriptor r12 = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(r5);
        if (r12 != null) goto L5;
        return null;
    L5:
        SimpleFunctionDescriptor r13 = createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(r12, r10);
        if (r13 != null) goto L8;
        return null;
    L8:
        if (isVisibleAsFunctionInCurrentClass(r13) == true) goto L11;
        r13 = null;
    L11:
        if (r13 != null) goto L13;
        return null;
    L13:
        return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(r13, r12, r11);
    }

    private final SimpleFunctionDescriptor obtainOverrideForBuiltinWithDifferentJvmName(SimpleFunctionDescriptor r5, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r10, Name r11, Collection<? extends SimpleFunctionDescriptor> r12) {
        SimpleFunctionDescriptor r13 = (SimpleFunctionDescriptor) SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(r5);
        if (r13 != null) goto L5;
        return null;
    L5:
        String r14 = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(r13);
        Intrinsics.checkNotNull(r14);
        Iterator<? extends SimpleFunctionDescriptor> r15 = r10.invoke(Name.identifier(r14)).iterator();
    L7:
        if (r15.hasNext() == false) goto L12;
        SimpleFunctionDescriptor r16 = createRenamedCopy(r15.next(), r11);
        if (doesOverrideRenamedDescriptor(r13, r16) == false) goto L7;
        return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(r16, r13, r12);
    L12:
        return null;
    }

    private final SimpleFunctionDescriptor obtainOverrideForSuspend(SimpleFunctionDescriptor r5, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r10) {
        if (r5.isSuspend() == true) goto L5;
        return null;
    L5:
        Iterator<T> r11 = r10.invoke(r5.getName()).iterator();
    L7:
        if (r11.hasNext() == false) goto L22;
        SimpleFunctionDescriptor r12 = createSuspendView((SimpleFunctionDescriptor) r11.next());
        if (r12 != null) goto L11;
    L13:
        r12 = null;
    L14:
        if (r12 == null) goto L7;
        return r12;
    L11:
        if (doesOverride(r12, r5) == false) goto L13;
    L22:
        return null;
    }

    private final JavaClassConstructorDescriptor resolveConstructor(JavaConstructor r10) {
        ClassDescriptor r5 = getOwnerDescriptor();
        JavaClassConstructorDescriptor r11 = JavaClassConstructorDescriptor.createJavaConstructor(r5, LazyJavaAnnotationsKt.resolveAnnotations(getC(), r10), false, getC().getComponents().getSourceElementFactory().source(r10));
        LazyJavaResolverContext r12 = ContextKt.childForMethod(getC(), r11, r10, r5.getDeclaredTypeParameters().size());
        LazyJavaScope.ResolvedValueParameters r13 = resolveValueParameters(r12, r11, r10.getValueParameters());
        List<TypeParameterDescriptor> r14 = r5.getDeclaredTypeParameters();
        List<JavaTypeParameter> r15 = r10.getTypeParameters();
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator<T> r17 = r15.iterator();
    L4:
        if (r17.hasNext() == false) goto L6;
        JavaTypeParameter r18 = (JavaTypeParameter) r17.next();
        TypeParameterDescriptor r19 = r12.getTypeParameterResolver().resolveTypeParameter(r18);
        Intrinsics.checkNotNull(r19);
        r16.add(r19);
        goto L4
    L6:
        List<TypeParameterDescriptor> r20 = CollectionsKt.plus(r14, r16);
        r11.initialize(r13.getDescriptors(), UtilsKt.toDescriptorVisibility(r10.getVisibility()), r20);
        r11.setHasStableParameterNames(false);
        r11.setHasSynthesizedParameterNames(r13.getHasSynthesizedNames());
        r11.setReturnType(r5.getDefaultType());
        r12.getComponents().getJavaResolverCache().recordConstructor(r10, r11);
        return r11;
    }

    private final JavaMethodDescriptor resolveRecordComponentToFunctionDescriptor(JavaRecordComponent r17) {
        Annotations r5 = LazyJavaAnnotationsKt.resolveAnnotations(getC(), r17);
        JavaMethodDescriptor r10 = JavaMethodDescriptor.createJavaMethod(getOwnerDescriptor(), r5, r17.getName(), getC().getComponents().getSourceElementFactory().source(r17), true);
        JavaTypeAttributes r11 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 6, null);
        KotlinType r12 = getC().getTypeResolver().transformJavaType(r17.getType(), r11);
        r10.initialize(null, getDispatchReceiverParameter(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), r12, Modality.Companion.convertFromFlags(false, false, true), DescriptorVisibilities.PUBLIC, null);
        r10.setParameterNamesStatus(false, false);
        getC().getComponents().getJavaResolverCache().recordMethod(r17, r10);
        return r10;
    }

    private final Collection<SimpleFunctionDescriptor> searchMethodsByNameWithoutBuiltinMagic(Name r5) {
        Collection<JavaMethod> r10 = getDeclaredMemberIndex().invoke().findMethodsByName(r5);
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(resolveMethodToFunctionDescriptor((JavaMethod) r12.next()));
        goto L4
    L6:
        return r11;
    }

    private final Collection<SimpleFunctionDescriptor> searchMethodsInSupertypesWithoutBuiltinMagic(Name r5) {
        Set<SimpleFunctionDescriptor> r10 = getFunctionsFromSupertypes(r5);
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Object r13 = r12.next();
        SimpleFunctionDescriptor r14 = (SimpleFunctionDescriptor) r13;
        if (SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName(r14) == true) goto L4;
        if (BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(r14) != null) goto L4;
        r11.add(r13);
        goto L4
    L11:
        return r11;
    }

    private final boolean shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(SimpleFunctionDescriptor r5) {
        if (BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(r5.getName()) == true) goto L5;
        return false;
    L5:
        Set<SimpleFunctionDescriptor> r10 = getFunctionsFromSupertypes(r5.getName());
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L12;
        FunctionDescriptor r13 = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((SimpleFunctionDescriptor) r12.next());
        if (r13 == null) goto L7;
        r11.add(r13);
        goto L7
    L12:
        if (r11.isEmpty() == true) goto L29;
        Iterator r14 = r11.iterator();
    L16:
        if (r14.hasNext() == false) goto L30;
        if (hasSameJvmDescriptorButDoesNotOverride(r5, (FunctionDescriptor) r14.next()) == false) goto L16;
        return true;
    L30:
        return false;
    L29:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computeClassNames(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        return SetsKt.plus(this.nestedClassIndex.invoke(), this.enumEntryIndex.invoke().keySet());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ Set computeFunctionNames(DescriptorKindFilter r5, Function1 r10) {
        return computeFunctionNames(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> r5, Name r10) {
        Intrinsics.checkNotNullParameter(r5, "result");
        Intrinsics.checkNotNullParameter(r10, "name");
        if (this.jClass.isRecord() == true) goto L5;
    L16:
        LazyJavaResolverContext r11 = getC();
        getC().getComponents().getSyntheticPartsProvider().generateMethods(r11, getOwnerDescriptor(), r10, r5);
        return;
    L5:
        if (getDeclaredMemberIndex().invoke().findRecordComponentByName(r10) == null) goto L16;
        Collection<SimpleFunctionDescriptor> r12 = r5;
        if (r12.isEmpty() == true) goto L15;
        Iterator<T> r13 = r12.iterator();
    L11:
        if (r13.hasNext() == false) goto L15;
        if (((SimpleFunctionDescriptor) r13.next()).getValueParameters().isEmpty() == false) goto L11;
    L15:
        JavaRecordComponent r14 = getDeclaredMemberIndex().invoke().findRecordComponentByName(r10);
        Intrinsics.checkNotNull(r14);
        r5.add(resolveRecordComponentToFunctionDescriptor(r14));
        goto L16
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ DeclaredMemberIndex computeMemberIndex() {
        return computeMemberIndex();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> r10, Name r11) {
        Intrinsics.checkNotNullParameter(r10, "result");
        Intrinsics.checkNotNullParameter(r11, "name");
        Set<SimpleFunctionDescriptor> r12 = getFunctionsFromSupertypes(r11);
        if (SpecialGenericSignatures.Companion.getSameAsRenamedInJvmBuiltin(r11) == false) goto L5;
    L25:
        SmartSet r13 = SmartSet.Companion.create();
        Collection<? extends SimpleFunctionDescriptor> r14 = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(r11, r12, CollectionsKt.emptyList(), getOwnerDescriptor(), ErrorReporter.DO_NOTHING, getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        addOverriddenSpecialMethods(r11, r10, r14, r10, new AnonymousClass3(this));
        addOverriddenSpecialMethods(r11, r10, r14, r13, new AnonymousClass4(this));
        ArrayList r5 = new ArrayList();
        Iterator<T> r15 = r12.iterator();
    L27:
        if (r15.hasNext() == false) goto L31;
        Object r16 = r15.next();
        if (isVisibleAsFunctionInCurrentClass((SimpleFunctionDescriptor) r16) == false) goto L27;
        r5.add(r16);
        goto L27
    L31:
        addFunctionFromSupertypes(r10, r11, CollectionsKt.plus(r5, r13), true);
        return;
    L5:
        if (BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(r11) == true) goto L25;
        Set<SimpleFunctionDescriptor> r17 = r12;
        if ((r17 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r18 = r17.iterator();
    L13:
        if (r18.hasNext() == false) goto L17;
        if (((FunctionDescriptor) r18.next()).isSuspend() == false) goto L13;
    L17:
        ArrayList r19 = new ArrayList();
        Iterator<T> r20 = r17.iterator();
    L19:
        if (r20.hasNext() == false) goto L23;
        Object r21 = r20.next();
        if (isVisibleAsFunctionInCurrentClass((SimpleFunctionDescriptor) r21) == false) goto L19;
        r19.add(r21);
        goto L19
    L23:
        addFunctionFromSupertypes(r10, r11, r19, false);
        return;
    L9:
        if (r17.isEmpty() == false) goto L11;
        goto L11
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredProperties(Name r10, Collection<PropertyDescriptor> r11) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "result");
        if (this.jClass.isAnnotationType() == false) goto L5;
        computeAnnotationProperties(r10, r11);
    L5:
        Set<PropertyDescriptor> r5 = getPropertiesFromSupertypes(r10);
        if (r5.isEmpty() == false) goto L8;
        return;
    L8:
        SmartSet.Companion r12 = SmartSet.Companion;
        SmartSet r13 = r12.create();
        Collection<PropertyDescriptor> r14 = r12.create();
        addPropertyOverrideByMethod(r5, r11, r13, new C02281(this));
        addPropertyOverrideByMethod(SetsKt.b(r5, r13), r14, null, new AnonymousClass2(this));
        r11.addAll(DescriptorResolverUtils.resolveOverridesForNonStaticMembers(r10, SetsKt.plus(r5, r14), r11, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computePropertyNames(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        if (this.jClass.isAnnotationType() == true) goto L5;
        LinkedHashSet r11 = new LinkedHashSet(getDeclaredMemberIndex().invoke().getFieldNames());
        Iterator<T> r12 = getOwnerDescriptor().getTypeConstructor().mo1403getSupertypes().iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        CollectionsKt.a(r11, ((KotlinType) r12.next()).getMemberScope().getVariableNames());
        goto L8
    L10:
        return r11;
    L5:
        return getFunctionNames();
    }

    public final NotNullLazyValue<List<ClassConstructorDescriptor>> getConstructors$descriptors_jvm() {
        return this.constructors;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1404getContributedClassifier(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        mo1408recordLookup(r5, r10);
        LazyJavaClassMemberScope r11 = (LazyJavaClassMemberScope) getMainScope();
        if (r11 == null) goto L10;
        MemoizedFunctionToNullable<Name, ClassDescriptor> r12 = r11.nestedClasses;
        if (r12 == null) goto L10;
        ClassDescriptor r13 = r12.invoke(r5);
        if (r13 == null) goto L10;
        return r13;
    L10:
        return this.nestedClasses.invoke(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        mo1408recordLookup(r5, r10);
        return super.getContributedFunctions(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        mo1408recordLookup(r5, r10);
        return super.getContributedVariables(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return DescriptorUtils.getDispatchReceiverParameterIfNeeded(getOwnerDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOwnerDescriptor() {
        return getOwnerDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public boolean isVisibleAsFunction(JavaMethodDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (this.jClass.isAnnotationType() == false) goto L7;
        return false;
    L7:
        return isVisibleAsFunctionInCurrentClass(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo1408recordLookup(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        kotlin.reflect.jvm.internal.impl.incremental.UtilsKt.record(getC().getComponents().getLookupTracker(), r10, getOwnerDescriptor(), r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public LazyJavaScope.MethodSignatureData resolveMethodSignature(JavaMethod r10, List<? extends TypeParameterDescriptor> r11, KotlinType r12, List<? extends ValueParameterDescriptor> r13) {
        Intrinsics.checkNotNullParameter(r10, "method");
        Intrinsics.checkNotNullParameter(r11, "methodTypeParameters");
        Intrinsics.checkNotNullParameter(r12, "returnType");
        Intrinsics.checkNotNullParameter(r13, "valueParameters");
        SignaturePropagator.PropagatedSignature r14 = getC().getComponents().getSignaturePropagator().resolvePropagatedSignature(r10, getOwnerDescriptor(), r12, null, r13, r11);
        return new LazyJavaScope.MethodSignatureData(r14.getReturnType(), r14.getReceiverType(), r14.getValueParameters(), r14.getTypeParameters(), r14.hasStableParameterNames(), r14.getErrors());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public String toString() {
        return "Lazy Java member scope for " + this.jClass.getFqName();
    }

    public LazyJavaClassMemberScope(final LazyJavaResolverContext r5, ClassDescriptor r10, JavaClass r11, boolean r12, LazyJavaClassMemberScope r13) {
        Intrinsics.checkNotNullParameter(r5, "c");
        Intrinsics.checkNotNullParameter(r10, "ownerDescriptor");
        Intrinsics.checkNotNullParameter(r11, "jClass");
        super(r5, r13);
        this.ownerDescriptor = r10;
        this.jClass = r11;
        this.skipRefinement = r12;
        this.constructors = r5.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$constructors$1(this, r5));
        this.nestedClassIndex = r5.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$nestedClassIndex$1(this));
        this.generatedNestedClassNames = r5.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$generatedNestedClassNames$1(r5, this));
        this.enumEntryIndex = r5.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$enumEntryIndex$1(this));
        this.nestedClasses = r5.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaClassMemberScope$nestedClasses$1(this, r5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public LinkedHashSet<Name> computeFunctionNames(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        Collection<KotlinType> r11 = getOwnerDescriptor().getTypeConstructor().mo1403getSupertypes();
        LinkedHashSet<Name> r12 = new LinkedHashSet();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.a(r12, ((KotlinType) r13.next()).getMemberScope().getFunctionNames());
        goto L4
    L6:
        r12.addAll(getDeclaredMemberIndex().invoke().getMethodNames());
        r12.addAll(getDeclaredMemberIndex().invoke().getRecordComponentNames());
        r12.addAll(computeClassNames(r5, r10));
        LazyJavaResolverContext r14 = getC();
        r12.addAll(getC().getComponents().getSyntheticPartsProvider().getMethodNames(r14, getOwnerDescriptor()));
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, AnonymousClass1.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public ClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }
}
