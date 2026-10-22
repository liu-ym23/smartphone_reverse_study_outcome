package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nLazyJavaScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaScope\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,405:1\n1477#2:406\n1502#2,3:407\n1505#2,3:417\n1549#2:420\n1620#2,3:421\n1549#2:424\n1620#2,3:425\n361#3,7:410\n*S KotlinDebug\n*F\n+ 1 LazyJavaScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaScope\n*L\n129#1:406\n129#1:407,3\n129#1:417,3\n165#1:420\n165#1:421,3\n212#1:424\n212#1:425,3\n129#1:410,7\n*E\n"})
public abstract class LazyJavaScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f18749c;
    private final NotNullLazyValue classNamesLazy$delegate;
    private final MemoizedFunctionToNullable<Name, PropertyDescriptor> declaredField;
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> declaredFunctions;
    private final NotNullLazyValue<DeclaredMemberIndex> declaredMemberIndex;
    private final NotNullLazyValue functionNamesLazy$delegate;
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
    private final LazyJavaScope mainScope;
    private final MemoizedFunctionToNotNull<Name, List<PropertyDescriptor>> properties;
    private final NotNullLazyValue propertyNamesLazy$delegate;

    public static final class MethodSignatureData {
        private final List<String> errors;
        private final boolean hasStableParameterNames;
        private final KotlinType receiverType;
        private final KotlinType returnType;
        private final List<TypeParameterDescriptor> typeParameters;
        private final List<ValueParameterDescriptor> valueParameters;

        /* JADX WARN: Multi-variable type inference failed */
        public MethodSignatureData(KotlinType r5, KotlinType r10, List<? extends ValueParameterDescriptor> r11, List<? extends TypeParameterDescriptor> r12, boolean r13, List<String> r14) {
            Intrinsics.checkNotNullParameter(r5, "returnType");
            Intrinsics.checkNotNullParameter(r11, "valueParameters");
            Intrinsics.checkNotNullParameter(r12, "typeParameters");
            Intrinsics.checkNotNullParameter(r14, "errors");
            this.returnType = r5;
            this.receiverType = r10;
            this.valueParameters = r11;
            this.typeParameters = r12;
            this.hasStableParameterNames = r13;
            this.errors = r14;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof MethodSignatureData) == true) goto L8;
            return false;
        L8:
            MethodSignatureData r10 = (MethodSignatureData) r5;
            if (Intrinsics.areEqual(this.returnType, r10.returnType) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.receiverType, r10.receiverType) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.valueParameters, r10.valueParameters) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.typeParameters, r10.typeParameters) == true) goto L21;
            return false;
        L21:
            if (this.hasStableParameterNames == r10.hasStableParameterNames) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.errors, r10.errors) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final List<String> getErrors() {
            return this.errors;
        }

        public final boolean getHasStableParameterNames() {
            return this.hasStableParameterNames;
        }

        public final KotlinType getReceiverType() {
            return this.receiverType;
        }

        public final KotlinType getReturnType() {
            return this.returnType;
        }

        public final List<TypeParameterDescriptor> getTypeParameters() {
            return this.typeParameters;
        }

        public final List<ValueParameterDescriptor> getValueParameters() {
            return this.valueParameters;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v9 */
        public int hashCode() {
            int r5 = this.returnType.hashCode() * 31;
            KotlinType r10 = this.receiverType;
            if (r10 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = (r5 + r11) * 31;
            int r13 = a.f(this.valueParameters, r12, 31);
            int r14 = a.f(this.typeParameters, r13, 31);
            boolean r15 = this.hasStableParameterNames;
            ?? r16 = r15;
            if (r15 == false) goto L9;
            r16 = 1;
        L9:
            int r17 = this.errors.hashCode();
            return r17 + ((r14 + r16) * 31);
        L5:
            r11 = r10.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("MethodSignatureData(returnType=");
            r5.append(this.returnType);
            r5.append(", receiverType=");
            r5.append(this.receiverType);
            r5.append(", valueParameters=");
            r5.append(this.valueParameters);
            r5.append(", typeParameters=");
            r5.append(this.typeParameters);
            r5.append(", hasStableParameterNames=");
            r5.append(this.hasStableParameterNames);
            r5.append(", errors=");
            return a.v(r5, this.errors, ')');
        }
    }

    public static final class ResolvedValueParameters {
        private final List<ValueParameterDescriptor> descriptors;
        private final boolean hasSynthesizedNames;

        /* JADX WARN: Multi-variable type inference failed */
        public ResolvedValueParameters(List<? extends ValueParameterDescriptor> r5, boolean r10) {
            Intrinsics.checkNotNullParameter(r5, "descriptors");
            this.descriptors = r5;
            this.hasSynthesizedNames = r10;
        }

        public final List<ValueParameterDescriptor> getDescriptors() {
            return this.descriptors;
        }

        public final boolean getHasSynthesizedNames() {
            return this.hasSynthesizedNames;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaScope.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaScope.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaScope.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    }

    public /* synthetic */ LazyJavaScope(LazyJavaResolverContext r5, LazyJavaScope r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10);
    }

    public static final /* synthetic */ MemoizedFunctionToNullable access$getDeclaredField$p(LazyJavaScope r5) {
        return r5.declaredField;
    }

    public static final /* synthetic */ MemoizedFunctionToNotNull access$getDeclaredFunctions$p(LazyJavaScope r5) {
        return r5.declaredFunctions;
    }

    public static final /* synthetic */ PropertyDescriptor access$resolveProperty(LazyJavaScope r5, JavaField r10) {
        return r5.resolveProperty(r10);
    }

    public static final /* synthetic */ void access$retainMostSpecificMethods(LazyJavaScope r5, Set r10) {
        r5.retainMostSpecificMethods(r10);
    }

    private final PropertyDescriptorImpl createPropertyDescriptor(JavaField r10) {
        boolean r5 = !r10.isFinal();
        return JavaPropertyDescriptor.create(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(this.f18749c, r10), Modality.FINAL, UtilsKt.toDescriptorVisibility(r10.getVisibility()), r5, r10.getName(), this.f18749c.getComponents().getSourceElementFactory().source(r10), isFinalStatic(r10));
    }

    private final Set<Name> getClassNamesLazy() {
        return (Set) StorageKt.getValue(this.classNamesLazy$delegate, this, $$delegatedProperties[2]);
    }

    private final Set<Name> getFunctionNamesLazy() {
        return (Set) StorageKt.getValue(this.functionNamesLazy$delegate, this, $$delegatedProperties[0]);
    }

    private final Set<Name> getPropertyNamesLazy() {
        return (Set) StorageKt.getValue(this.propertyNamesLazy$delegate, this, $$delegatedProperties[1]);
    }

    private final KotlinType getPropertyType(JavaField r10) {
        KotlinType r5 = this.f18749c.getTypeResolver().transformJavaType(r10.getType(), JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null));
        if (KotlinBuiltIns.isPrimitiveType(r5) == true) goto L7;
        if (KotlinBuiltIns.isString(r5) == true) goto L7;
    L12:
        return r5;
    L7:
        if (isFinalStatic(r10) == false) goto L12;
        if (r10.getHasConstantNotNullInitializer() == false) goto L12;
        return TypeUtils.makeNotNullable(r5);
    }

    private final boolean isFinalStatic(JavaField r5) {
        if (r5.isFinal() == true) goto L5;
    L7:
        return false;
    L5:
        if (r5.isStatic() == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final PropertyDescriptor resolveProperty(final JavaField r10) {
        final PropertyDescriptorImpl r11 = createPropertyDescriptor(r10);
        r11.initialize(null, null, null, null);
        r11.setType(getPropertyType(r10), CollectionsKt.emptyList(), getDispatchReceiverParameter(), null, CollectionsKt.emptyList());
        if (DescriptorUtils.shouldRecordInitializerForProperty(r11, r11.getType()) == false) goto L5;
        r11.setCompileTimeInitializerFactory(new AnonymousClass1(this, r10, r11));
    L5:
        this.f18749c.getComponents().getJavaResolverCache().recordField(r10, r11);
        return r11;
    }

    private final void retainMostSpecificMethods(Set<SimpleFunctionDescriptor> r10) {
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Object r12 = r11.next();
        String r13 = MethodSignatureMappingKt.computeJvmDescriptor$default((SimpleFunctionDescriptor) r12, false, false, 2, null);
        Object r14 = r5.get(r13);
        if (r14 != null) goto L8;
        r14 = new ArrayList();
        r5.put(r13, r14);
    L8:
        ((List) r14).add(r12);
        goto L4
    L9:
        Iterator r15 = r5.values().iterator();
    L11:
        if (r15.hasNext() == false) goto L15;
        List r16 = (List) r15.next();
        if (r16.size() == 1) goto L11;
        Collection<? extends SimpleFunctionDescriptor> r17 = OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(r16, LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1.INSTANCE);
        r10.removeAll(r16);
        r10.addAll(r17);
        goto L11
    }

    public abstract Set<Name> computeClassNames(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10);

    public final List<DeclarationDescriptor> computeDescriptors(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
        NoLookupLocation r5 = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet r12 = new LinkedHashSet();
        if (r10.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK()) == false) goto L11;
        Iterator<Name> r13 = computeClassNames(r10, r11).iterator();
    L6:
        if (r13.hasNext() == false) goto L11;
        Name r14 = r13.next();
        if (r11.invoke(r14).booleanValue() == false) goto L6;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r12, mo1404getContributedClassifier(r14, r5));
    L11:
        if (r10.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) == false) goto L21;
        if (r10.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE) == true) goto L21;
        Iterator<Name> r15 = computeFunctionNames(r10, r11).iterator();
    L16:
        if (r15.hasNext() == false) goto L21;
        Name r16 = r15.next();
        if (r11.invoke(r16).booleanValue() == false) goto L16;
        r12.addAll(getContributedFunctions(r16, r5));
    L21:
        if (r10.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) == false) goto L31;
        if (r10.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE) == true) goto L31;
        Iterator<Name> r17 = computePropertyNames(r10, r11).iterator();
    L26:
        if (r17.hasNext() == false) goto L31;
        Name r18 = r17.next();
        if (r11.invoke(r18).booleanValue() == false) goto L26;
        r12.addAll(getContributedVariables(r18, r5));
    L31:
        return CollectionsKt.toList(r12);
    }

    public abstract Set<Name> computeFunctionNames(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10);

    public void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> r5, Name r10) {
        Intrinsics.checkNotNullParameter(r5, "result");
        Intrinsics.checkNotNullParameter(r10, "name");
    }

    public abstract DeclaredMemberIndex computeMemberIndex();

    public final KotlinType computeMethodReturnType(JavaMethod r10, LazyJavaResolverContext r11) {
        Intrinsics.checkNotNullParameter(r10, "method");
        Intrinsics.checkNotNullParameter(r11, "c");
        boolean r5 = r10.getContainingClass().isAnnotationType();
        JavaTypeAttributes r12 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, r5, false, null, 6, null);
        return r11.getTypeResolver().transformJavaType(r10.getReturnType(), r12);
    }

    public abstract void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> r5, Name r10);

    public abstract void computeNonDeclaredProperties(Name r5, Collection<PropertyDescriptor> r10);

    public abstract Set<Name> computePropertyNames(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10);

    public final NotNullLazyValue<Collection<DeclarationDescriptor>> getAllDescriptors() {
        return this.allDescriptors;
    }

    public final LazyJavaResolverContext getC() {
        return this.f18749c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return getClassNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        Intrinsics.checkNotNullParameter(r10, "nameFilter");
        return this.allDescriptors.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        if (getFunctionNames().contains(r5) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return this.functions.invoke(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        if (getVariableNames().contains(r5) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return this.properties.invoke(r5);
    }

    public final NotNullLazyValue<DeclaredMemberIndex> getDeclaredMemberIndex() {
        return this.declaredMemberIndex;
    }

    public abstract ReceiverParameterDescriptor getDispatchReceiverParameter();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return getFunctionNamesLazy();
    }

    public final LazyJavaScope getMainScope() {
        return this.mainScope;
    }

    public abstract DeclarationDescriptor getOwnerDescriptor();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return getPropertyNamesLazy();
    }

    public boolean isVisibleAsFunction(JavaMethodDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return true;
    }

    public abstract MethodSignatureData resolveMethodSignature(JavaMethod r5, List<? extends TypeParameterDescriptor> r10, KotlinType r11, List<? extends ValueParameterDescriptor> r12);

    public final JavaMethodDescriptor resolveMethodToFunctionDescriptor(JavaMethod r21) {
        Intrinsics.checkNotNullParameter(r21, "method");
        Annotations r5 = LazyJavaAnnotationsKt.resolveAnnotations(this.f18749c, r21);
        DeclarationDescriptor r10 = getOwnerDescriptor();
        Name r11 = r21.getName();
        JavaSourceElement r12 = this.f18749c.getComponents().getSourceElementFactory().source(r21);
        if (this.declaredMemberIndex.invoke().findRecordComponentByName(r21.getName()) != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        JavaMethodDescriptor r15 = JavaMethodDescriptor.createJavaMethod(r10, r5, r11, r12, r13);
        LazyJavaResolverContext r14 = ContextKt.childForMethod$default(this.f18749c, r15, r21, 0, 4, null);
        List<JavaTypeParameter> r16 = r21.getTypeParameters();
        ArrayList r17 = new ArrayList(CollectionsKt.h(r16));
        Iterator<T> r18 = r16.iterator();
    L10:
        if (r18.hasNext() == false) goto L12;
        TypeParameterDescriptor r19 = r14.getTypeParameterResolver().resolveTypeParameter((JavaTypeParameter) r18.next());
        Intrinsics.checkNotNull(r19);
        r17.add(r19);
        goto L10
    L12:
        ResolvedValueParameters r20 = resolveValueParameters(r14, r15, r21.getValueParameters());
        MethodSignatureData r22 = resolveMethodSignature(r21, r17, computeMethodReturnType(r21, r14), r20.getDescriptors());
        KotlinType r23 = r22.getReceiverType();
        if (r23 == null) goto L16;
        ReceiverParameterDescriptor r24 = DescriptorFactory.createExtensionReceiverParameterForCallable(r15, r23, Annotations.Companion.getEMPTY());
    L15:
        ReceiverParameterDescriptor r110 = r24;
        ReceiverParameterDescriptor r111 = getDispatchReceiverParameter();
        List<ReceiverParameterDescriptor> r112 = CollectionsKt.emptyList();
        List<TypeParameterDescriptor> r113 = r22.getTypeParameters();
        List<ValueParameterDescriptor> r25 = r22.getValueParameters();
        KotlinType r114 = r22.getReturnType();
        Modality r115 = Modality.Companion.convertFromFlags(false, r21.isAbstract(), !r21.isFinal());
        DescriptorVisibility r116 = UtilsKt.toDescriptorVisibility(r21.getVisibility());
        if (r22.getReceiverType() == null) goto L21;
        Map<? extends CallableDescriptor.UserDataKey<?>, ?> r26 = MapsKt.mapOf(TuplesKt.to(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER, CollectionsKt.first(r20.getDescriptors())));
    L22:
        r15.initialize(r110, r111, r112, r113, r25, r114, r115, r116, r26);
        r15.setParameterNamesStatus(r22.getHasStableParameterNames(), r20.getHasSynthesizedNames());
        if (r22.getErrors().isEmpty() == true) goto L25;
        r14.getComponents().getSignaturePropagator().reportSignatureErrors(r15, r22.getErrors());
    L25:
        return r15;
    L21:
        r26 = MapsKt.emptyMap();
        goto L22
    L16:
        r24 = null;
        goto L15
    L5:
        if (r21.getValueParameters().isEmpty() == false) goto L7;
        r13 = true;
        goto L8
    }

    public final ResolvedValueParameters resolveValueParameters(LazyJavaResolverContext r21, FunctionDescriptor r22, List<? extends JavaValueParameter> r23) {
        LazyJavaResolverContext r5 = r21;
        Intrinsics.checkNotNullParameter(r5, "c");
        Intrinsics.checkNotNullParameter(r22, "function");
        Intrinsics.checkNotNullParameter(r23, "jValueParameters");
        Iterable r10 = CollectionsKt.withIndex(r23);
        ArrayList r13 = new ArrayList(CollectionsKt.h(r10));
        Iterator r11 = r10.iterator();
        boolean r12 = false;
    L4:
        if (r11.hasNext() == false) goto L30;
        IndexedValue r14 = (IndexedValue) r11.next();
        int r15 = r14.component1();
        JavaValueParameter r16 = (JavaValueParameter) r14.component2();
        Annotations r17 = LazyJavaAnnotationsKt.resolveAnnotations(r5, r16);
        JavaTypeAttributes r18 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null);
        JavaArrayType r19 = null;
        if (r16.isVararg() == false) goto L14;
        JavaType r20 = r16.getType();
        if ((r20 instanceof JavaArrayType) == false) goto L10;
        r19 = (JavaArrayType) r20;
    L10:
        if (r19 == null) goto L13;
        KotlinType r24 = r21.getTypeResolver().transformArrayType(r19, r18, true);
        Pair r25 = TuplesKt.to(r24, r21.getModule().getBuiltIns().getArrayElementType(r24));
    L15:
        KotlinType r26 = (KotlinType) r25.component1();
        KotlinType r110 = (KotlinType) r25.component2();
        if (Intrinsics.areEqual(r22.getName().asString(), "equals") == true) goto L18;
    L23:
        Name r27 = r16.getName();
        if (r27 != null) goto L26;
        r12 = true;
    L26:
        if (r27 == null) goto L27;
    L22:
        boolean r111 = r12;
        ArrayList r28 = r13;
        r28.add(new ValueParameterDescriptorImpl(r22, null, r15, r17, r27, r26, false, false, false, r110, r21.getComponents().getSourceElementFactory().source(r16)));
        r13 = r28;
        r12 = r111;
        r5 = r21;
        goto L4
    L27:
        r27 = Name.identifier(LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME + r15);
        goto L22
    L18:
        if (r23.size() != 1) goto L23;
        if (Intrinsics.areEqual(r21.getModule().getBuiltIns().getNullableAnyType(), r26) == false) goto L23;
        r27 = Name.identifier("other");
        goto L22
    L13:
        throw new AssertionError("Vararg parameter should be an array: " + r16);
    L14:
        r25 = TuplesKt.to(r21.getTypeResolver().transformJavaType(r16.getType(), r18), null);
        goto L15
    L30:
        return new ResolvedValueParameters(CollectionsKt.toList(r13), r12);
    }

    public String toString() {
        return "Lazy scope for " + getOwnerDescriptor();
    }

    public LazyJavaScope(LazyJavaResolverContext r5, LazyJavaScope r10) {
        Intrinsics.checkNotNullParameter(r5, "c");
        this.f18749c = r5;
        this.mainScope = r10;
        this.allDescriptors = r5.getStorageManager().createRecursionTolerantLazyValue(new LazyJavaScope$allDescriptors$1(this), CollectionsKt.emptyList());
        this.declaredMemberIndex = r5.getStorageManager().createLazyValue(new LazyJavaScope$declaredMemberIndex$1(this));
        this.declaredFunctions = r5.getStorageManager().createMemoizedFunction(new LazyJavaScope$declaredFunctions$1(this));
        this.declaredField = r5.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaScope$declaredField$1(this));
        this.functions = r5.getStorageManager().createMemoizedFunction(new LazyJavaScope$functions$1(this));
        this.functionNamesLazy$delegate = r5.getStorageManager().createLazyValue(new LazyJavaScope$functionNamesLazy$2(this));
        this.propertyNamesLazy$delegate = r5.getStorageManager().createLazyValue(new LazyJavaScope$propertyNamesLazy$2(this));
        this.classNamesLazy$delegate = r5.getStorageManager().createLazyValue(new LazyJavaScope$classNamesLazy$2(this));
        this.properties = r5.getStorageManager().createMemoizedFunction(new LazyJavaScope$properties$1(this));
    }
}
