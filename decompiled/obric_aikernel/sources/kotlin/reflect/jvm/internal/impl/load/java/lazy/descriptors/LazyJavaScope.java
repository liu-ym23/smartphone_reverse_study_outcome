package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.bytedance.crash.event.EnsureReportData;
import com.bytedance.crash.tracker.ActivityLifecycle;
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
public abstract class LazyJavaScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f10213c;
    private final NotNullLazyValue classNamesLazy$delegate;
    private final MemoizedFunctionToNullable<Name, PropertyDescriptor> declaredField;
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> declaredFunctions;
    private final NotNullLazyValue<DeclaredMemberIndex> declaredMemberIndex;
    private final NotNullLazyValue functionNamesLazy$delegate;
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
    private final LazyJavaScope mainScope;
    private final MemoizedFunctionToNotNull<Name, List<PropertyDescriptor>> properties;
    private final NotNullLazyValue propertyNamesLazy$delegate;

    protected static final class MethodSignatureData {
        private final List<String> errors;
        private final boolean hasStableParameterNames;
        private final KotlinType receiverType;
        private final KotlinType returnType;
        private final List<TypeParameterDescriptor> typeParameters;
        private final List<ValueParameterDescriptor> valueParameters;

        /* JADX WARN: Multi-variable type inference failed */
        public MethodSignatureData(KotlinType r10, KotlinType r11, List<? extends ValueParameterDescriptor> r12, List<? extends TypeParameterDescriptor> r13, boolean r14, List<String> r15) {
            Intrinsics.checkNotNullParameter(r10, "returnType");
            Intrinsics.checkNotNullParameter(r12, "valueParameters");
            Intrinsics.checkNotNullParameter(r13, "typeParameters");
            Intrinsics.checkNotNullParameter(r15, "errors");
            this.returnType = r10;
            this.receiverType = r11;
            this.valueParameters = r12;
            this.typeParameters = r13;
            this.hasStableParameterNames = r14;
            this.errors = r15;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof MethodSignatureData) == true) goto L8;
            return false;
        L8:
            MethodSignatureData r11 = (MethodSignatureData) r10;
            if (Intrinsics.areEqual(this.returnType, r11.returnType) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.receiverType, r11.receiverType) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.valueParameters, r11.valueParameters) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.typeParameters, r11.typeParameters) == true) goto L21;
            return false;
        L21:
            if (this.hasStableParameterNames == r11.hasStableParameterNames) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.errors, r11.errors) == true) goto L26;
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
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9 */
        public int hashCode() {
            int r10 = this.returnType.hashCode() * 31;
            KotlinType r11 = this.receiverType;
            if (r11 != null) goto L5;
            int r12 = 0;
        L6:
            int r13 = (((((r10 + r12) * 31) + this.valueParameters.hashCode()) * 31) + this.typeParameters.hashCode()) * 31;
            boolean r14 = this.hasStableParameterNames;
            ?? r15 = r14;
            if (r14 == false) goto L10;
            r15 = 1;
        L10:
            return ((r13 + r15) * 31) + this.errors.hashCode();
        L5:
            r12 = r11.hashCode();
            goto L6
        }

        public String toString() {
            return "MethodSignatureData(returnType=" + this.returnType + ", receiverType=" + this.receiverType + ", valueParameters=" + this.valueParameters + ", typeParameters=" + this.typeParameters + ", hasStableParameterNames=" + this.hasStableParameterNames + ", errors=" + this.errors + ')';
        }
    }

    protected static final class ResolvedValueParameters {
        private final List<ValueParameterDescriptor> descriptors;
        private final boolean hasSynthesizedNames;

        /* JADX WARN: Multi-variable type inference failed */
        public ResolvedValueParameters(List<? extends ValueParameterDescriptor> r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "descriptors");
            this.descriptors = r10;
            this.hasSynthesizedNames = r11;
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

    public LazyJavaScope(LazyJavaResolverContext r10, LazyJavaScope r11) {
        Intrinsics.checkNotNullParameter(r10, "c");
        this.f10213c = r10;
        this.mainScope = r11;
        this.allDescriptors = r10.getStorageManager().createRecursionTolerantLazyValue(new LazyJavaScope$allDescriptors$1(this), CollectionsKt.emptyList());
        this.declaredMemberIndex = r10.getStorageManager().createLazyValue(new LazyJavaScope$declaredMemberIndex$1(this));
        this.declaredFunctions = r10.getStorageManager().createMemoizedFunction(new LazyJavaScope$declaredFunctions$1(this));
        this.declaredField = r10.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaScope$declaredField$1(this));
        this.functions = r10.getStorageManager().createMemoizedFunction(new LazyJavaScope$functions$1(this));
        this.functionNamesLazy$delegate = r10.getStorageManager().createLazyValue(new LazyJavaScope$functionNamesLazy$2(this));
        this.propertyNamesLazy$delegate = r10.getStorageManager().createLazyValue(new LazyJavaScope$propertyNamesLazy$2(this));
        this.classNamesLazy$delegate = r10.getStorageManager().createLazyValue(new LazyJavaScope$classNamesLazy$2(this));
        this.properties = r10.getStorageManager().createMemoizedFunction(new LazyJavaScope$properties$1(this));
    }

    public /* synthetic */ LazyJavaScope(LazyJavaResolverContext r10, LazyJavaScope r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static final /* synthetic */ MemoizedFunctionToNullable access$getDeclaredField$p(LazyJavaScope r10) {
        return r10.declaredField;
    }

    public static final /* synthetic */ MemoizedFunctionToNotNull access$getDeclaredFunctions$p(LazyJavaScope r10) {
        return r10.declaredFunctions;
    }

    public static final /* synthetic */ PropertyDescriptor access$resolveProperty(LazyJavaScope r10, JavaField r11) {
        return r10.resolveProperty(r11);
    }

    public static final /* synthetic */ void access$retainMostSpecificMethods(LazyJavaScope r10, Set r11) {
        r10.retainMostSpecificMethods(r11);
    }

    private final PropertyDescriptorImpl createPropertyDescriptor(JavaField r10) {
        boolean r11 = !r10.isFinal();
        JavaPropertyDescriptor r12 = JavaPropertyDescriptor.create(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(this.f10213c, r10), Modality.FINAL, UtilsKt.toDescriptorVisibility(r10.getVisibility()), r11, r10.getName(), this.f10213c.getComponents().getSourceElementFactory().source(r10), isFinalStatic(r10));
        Intrinsics.checkNotNullExpressionValue(r12, "create(\n            owne…d.isFinalStatic\n        )");
        return r12;
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
        KotlinType r11 = this.f10213c.getTypeResolver().transformJavaType(r10.getType(), JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null));
        if (KotlinBuiltIns.isPrimitiveType(r11) == true) goto L7;
        if (KotlinBuiltIns.isString(r11) == true) goto L7;
    L11:
        boolean r12 = false;
    L12:
        if (r12 == false) goto L15;
        KotlinType r13 = TypeUtils.makeNotNullable(r11);
        Intrinsics.checkNotNullExpressionValue(r13, "makeNotNullable(propertyType)");
        return r13;
    L15:
        return r11;
    L7:
        if (isFinalStatic(r10) == false) goto L11;
        if (r10.getHasConstantNotNullInitializer() == false) goto L11;
        r12 = true;
        goto L12
    }

    private final boolean isFinalStatic(JavaField r10) {
        if (r10.isFinal() == true) goto L5;
    L7:
        return false;
    L5:
        if (r10.isStatic() == false) goto L7;
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
        this.f10213c.getComponents().getJavaResolverCache().recordField(r10, r11);
        return r11;
    }

    private final void retainMostSpecificMethods(Set<SimpleFunctionDescriptor> r10) {
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r13 = r12.next();
        String r14 = MethodSignatureMappingKt.computeJvmDescriptor$default((SimpleFunctionDescriptor) r13, false, false, 2, null);
        Object r15 = r11.get(r14);
        if (r15 != null) goto L8;
        r15 = new ArrayList();
        r11.put(r14, r15);
    L8:
        ((List) r15).add(r13);
        goto L4
    L9:
        Iterator r16 = r11.values().iterator();
    L11:
        if (r16.hasNext() == false) goto L15;
        List r17 = (List) r16.next();
        if (r17.size() == 1) goto L11;
        Collection<? extends SimpleFunctionDescriptor> r18 = OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(r17, LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1.INSTANCE);
        r10.removeAll(r17);
        r10.addAll(r18);
        goto L11
    }

    protected abstract Set<Name> computeClassNames(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11);

    protected final List<DeclarationDescriptor> computeDescriptors(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
        NoLookupLocation r12 = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet r13 = new LinkedHashSet();
        if (r10.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK()) == false) goto L11;
        Iterator<Name> r14 = computeClassNames(r10, r11).iterator();
    L6:
        if (r14.hasNext() == false) goto L11;
        Name r15 = r14.next();
        if (r11.invoke(r15).booleanValue() == false) goto L6;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r13, mo1325getContributedClassifier(r15, r12));
    L11:
        if (r10.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) == false) goto L21;
        if (r10.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE) == true) goto L21;
        Iterator<Name> r16 = computeFunctionNames(r10, r11).iterator();
    L16:
        if (r16.hasNext() == false) goto L21;
        Name r17 = r16.next();
        if (r11.invoke(r17).booleanValue() == false) goto L16;
        r13.addAll(getContributedFunctions(r17, r12));
    L21:
        if (r10.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) == false) goto L31;
        if (r10.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE) == true) goto L31;
        Iterator<Name> r18 = computePropertyNames(r10, r11).iterator();
    L26:
        if (r18.hasNext() == false) goto L31;
        Name r19 = r18.next();
        if (r11.invoke(r19).booleanValue() == false) goto L26;
        r13.addAll(getContributedVariables(r19, r12));
    L31:
        return CollectionsKt.toList(r13);
    }

    protected abstract Set<Name> computeFunctionNames(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11);

    protected void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> r10, Name r11) {
        Intrinsics.checkNotNullParameter(r10, "result");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
    }

    protected abstract DeclaredMemberIndex computeMemberIndex();

    protected final KotlinType computeMethodReturnType(JavaMethod r10, LazyJavaResolverContext r11) {
        Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
        Intrinsics.checkNotNullParameter(r11, "c");
        boolean r12 = r10.getContainingClass().isAnnotationType();
        JavaTypeAttributes r13 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, r12, false, null, 6, null);
        return r11.getTypeResolver().transformJavaType(r10.getReturnType(), r13);
    }

    protected abstract void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> r10, Name r11);

    protected abstract void computeNonDeclaredProperties(Name r10, Collection<PropertyDescriptor> r11);

    protected abstract Set<Name> computePropertyNames(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11);

    protected final NotNullLazyValue<Collection<DeclarationDescriptor>> getAllDescriptors() {
        return this.allDescriptors;
    }

    protected final LazyJavaResolverContext getC() {
        return this.f10213c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return getClassNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
        return this.allDescriptors.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        if (getFunctionNames().contains(r10) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return this.functions.invoke(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        if (getVariableNames().contains(r10) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return this.properties.invoke(r10);
    }

    protected final NotNullLazyValue<DeclaredMemberIndex> getDeclaredMemberIndex() {
        return this.declaredMemberIndex;
    }

    protected abstract ReceiverParameterDescriptor getDispatchReceiverParameter();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return getFunctionNamesLazy();
    }

    protected final LazyJavaScope getMainScope() {
        return this.mainScope;
    }

    protected abstract DeclarationDescriptor getOwnerDescriptor();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return getPropertyNamesLazy();
    }

    protected boolean isVisibleAsFunction(JavaMethodDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return true;
    }

    protected abstract MethodSignatureData resolveMethodSignature(JavaMethod r10, List<? extends TypeParameterDescriptor> r11, KotlinType r12, List<? extends ValueParameterDescriptor> r13);

    protected final JavaMethodDescriptor resolveMethodToFunctionDescriptor(JavaMethod r21) {
        Intrinsics.checkNotNullParameter(r21, EnsureReportData.METHOD);
        Annotations r10 = LazyJavaAnnotationsKt.resolveAnnotations(this.f10213c, r21);
        DeclarationDescriptor r11 = getOwnerDescriptor();
        Name r12 = r21.getName();
        JavaSourceElement r13 = this.f10213c.getComponents().getSourceElementFactory().source(r21);
        if (this.declaredMemberIndex.invoke().findRecordComponentByName(r21.getName()) != null) goto L5;
    L7:
        boolean r14 = false;
    L8:
        JavaMethodDescriptor r15 = JavaMethodDescriptor.createJavaMethod(r11, r10, r12, r13, r14);
        Intrinsics.checkNotNullExpressionValue(r15, "createJavaMethod(\n      …eters.isEmpty()\n        )");
        LazyJavaResolverContext r16 = ContextKt.childForMethod$default(this.f10213c, r15, r21, 0, 4, null);
        List<JavaTypeParameter> r17 = r21.getTypeParameters();
        List<? extends TypeParameterDescriptor> r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<T> r19 = r17.iterator();
    L10:
        if (r19.hasNext() == false) goto L12;
        TypeParameterDescriptor r20 = r16.getTypeParameterResolver().resolveTypeParameter((JavaTypeParameter) r19.next());
        Intrinsics.checkNotNull(r20);
        r18.add(r20);
        goto L10
    L12:
        ResolvedValueParameters r22 = resolveValueParameters(r16, r15, r21.getValueParameters());
        MethodSignatureData r23 = resolveMethodSignature(r21, r18, computeMethodReturnType(r21, r16), r22.getDescriptors());
        KotlinType r24 = r23.getReceiverType();
        if (r24 == null) goto L15;
        ReceiverParameterDescriptor r25 = DescriptorFactory.createExtensionReceiverParameterForCallable(r15, r24, Annotations.Companion.getEMPTY());
    L16:
        ReceiverParameterDescriptor r110 = r25;
        ReceiverParameterDescriptor r111 = getDispatchReceiverParameter();
        List<ReceiverParameterDescriptor> r112 = CollectionsKt.emptyList();
        List<TypeParameterDescriptor> r113 = r23.getTypeParameters();
        List<ValueParameterDescriptor> r26 = r23.getValueParameters();
        KotlinType r114 = r23.getReturnType();
        Modality r115 = Modality.Companion.convertFromFlags(false, r21.isAbstract(), !r21.isFinal());
        DescriptorVisibility r116 = UtilsKt.toDescriptorVisibility(r21.getVisibility());
        if (r23.getReceiverType() == null) goto L19;
        Map<? extends CallableDescriptor.UserDataKey<?>, ?> r27 = MapsKt.mapOf(TuplesKt.to(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER, CollectionsKt.first(r22.getDescriptors())));
    L20:
        r15.initialize(r110, r111, r112, r113, r26, r114, r115, r116, r27);
        r15.setParameterNamesStatus(r23.getHasStableParameterNames(), r22.getHasSynthesizedNames());
        if ((!r23.getErrors().isEmpty()) == false) goto L23;
        r16.getComponents().getSignaturePropagator().reportSignatureErrors(r15, r23.getErrors());
    L23:
        return r15;
    L19:
        r27 = MapsKt.emptyMap();
        goto L20
    L15:
        r25 = null;
        goto L16
    L5:
        if (r21.getValueParameters().isEmpty() == false) goto L7;
        r14 = true;
        goto L8
    }

    protected final ResolvedValueParameters resolveValueParameters(LazyJavaResolverContext r21, FunctionDescriptor r22, List<? extends JavaValueParameter> r23) {
        LazyJavaResolverContext r10 = r21;
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r22, "function");
        Intrinsics.checkNotNullParameter(r23, "jValueParameters");
        Iterable r11 = CollectionsKt.withIndex(r23);
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r12 = r11.iterator();
        boolean r14 = false;
    L4:
        if (r12.hasNext() == false) goto L29;
        IndexedValue r15 = (IndexedValue) r12.next();
        int r16 = r15.component1();
        JavaValueParameter r17 = (JavaValueParameter) r15.component2();
        Annotations r18 = LazyJavaAnnotationsKt.resolveAnnotations(r10, r17);
        JavaTypeAttributes r19 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null);
        JavaArrayType r20 = null;
        if (r17.isVararg() == false) goto L14;
        JavaType r24 = r17.getType();
        if ((r24 instanceof JavaArrayType) == false) goto L10;
        r20 = (JavaArrayType) r24;
    L10:
        if (r20 == null) goto L13;
        KotlinType r25 = r21.getTypeResolver().transformArrayType(r20, r19, true);
        Pair r26 = TuplesKt.to(r25, r21.getModule().getBuiltIns().getArrayElementType(r25));
    L15:
        KotlinType r27 = (KotlinType) r26.component1();
        KotlinType r110 = (KotlinType) r26.component2();
        if (Intrinsics.areEqual(r22.getName().asString(), "equals") == true) goto L18;
    L22:
        Name r28 = r17.getName();
        if (r28 != null) goto L25;
        r14 = true;
    L25:
        if (r28 != null) goto L27;
        StringBuilder r29 = new StringBuilder();
        r29.append('p');
        r29.append(r16);
        r28 = Name.identifier(r29.toString());
        Intrinsics.checkNotNullExpressionValue(r28, "identifier(\"p$index\")");
    L27:
        Name r30 = r28;
        Intrinsics.checkNotNullExpressionValue(r30, "if (function.name.asStri…(\"p$index\")\n            }");
        ArrayList r31 = r13;
        r31.add(new ValueParameterDescriptorImpl(r22, null, r16, r18, r30, r27, false, false, false, r110, r21.getComponents().getSourceElementFactory().source(r17)));
        r13 = r31;
        r14 = r14;
        r10 = r21;
        goto L4
    L18:
        if (r23.size() != 1) goto L22;
        if (Intrinsics.areEqual(r21.getModule().getBuiltIns().getNullableAnyType(), r27) == false) goto L22;
        r28 = Name.identifier("other");
        goto L27
    L13:
        throw new AssertionError("Vararg parameter should be an array: " + r17);
    L14:
        r26 = TuplesKt.to(r21.getTypeResolver().transformJavaType(r17.getType(), r19), null);
        goto L15
    L29:
        return new ResolvedValueParameters(CollectionsKt.toList(r13), r14);
    }

    public String toString() {
        return "Lazy scope for " + getOwnerDescriptor();
    }
}
