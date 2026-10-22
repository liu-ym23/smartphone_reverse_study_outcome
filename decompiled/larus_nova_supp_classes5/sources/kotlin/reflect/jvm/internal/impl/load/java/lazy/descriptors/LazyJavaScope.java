package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
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
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class LazyJavaScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
    private final LazyJavaResolverContext c;
    private final NotNullLazyValue classNamesLazy$delegate;
    private final MemoizedFunctionToNullable<Name, PropertyDescriptor> declaredField;
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> declaredFunctions;
    private final NotNullLazyValue<DeclaredMemberIndex> declaredMemberIndex;
    private final NotNullLazyValue functionNamesLazy$delegate;
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
    private final LazyJavaScope mainScope;
    private final MemoizedFunctionToNotNull<Name, List<PropertyDescriptor>> properties;
    private final NotNullLazyValue propertyNamesLazy$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaScope.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaScope.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaScope.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    }

    public static /* synthetic */ Collection accessor$LazyJavaScope$lambda0(LazyJavaScope r0) {
        return allDescriptors$lambda$0(r0);
    }

    public static /* synthetic */ DeclaredMemberIndex accessor$LazyJavaScope$lambda1(LazyJavaScope r0) {
        return declaredMemberIndex$lambda$1(r0);
    }

    public static /* synthetic */ NullableLazyValue accessor$LazyJavaScope$lambda10(LazyJavaScope r0, JavaField r1, Ref.ObjectRef r2) {
        return resolveProperty$lambda$16(r0, r1, r2);
    }

    public static /* synthetic */ ConstantValue accessor$LazyJavaScope$lambda11(LazyJavaScope r0, JavaField r1, Ref.ObjectRef r2) {
        return resolveProperty$lambda$16$lambda$15(r0, r1, r2);
    }

    public static /* synthetic */ Collection accessor$LazyJavaScope$lambda2(LazyJavaScope r0, Name r1) {
        return declaredFunctions$lambda$2(r0, r1);
    }

    public static /* synthetic */ PropertyDescriptor accessor$LazyJavaScope$lambda3(LazyJavaScope r0, Name r1) {
        return declaredField$lambda$3(r0, r1);
    }

    public static /* synthetic */ Collection accessor$LazyJavaScope$lambda4(LazyJavaScope r0, Name r1) {
        return functions$lambda$4(r0, r1);
    }

    public static /* synthetic */ Set accessor$LazyJavaScope$lambda5(LazyJavaScope r0) {
        return functionNamesLazy_delegate$lambda$10(r0);
    }

    public static /* synthetic */ Set accessor$LazyJavaScope$lambda6(LazyJavaScope r0) {
        return propertyNamesLazy_delegate$lambda$11(r0);
    }

    public static /* synthetic */ Set accessor$LazyJavaScope$lambda7(LazyJavaScope r0) {
        return classNamesLazy_delegate$lambda$12(r0);
    }

    public static /* synthetic */ List accessor$LazyJavaScope$lambda8(LazyJavaScope r0, Name r1) {
        return properties$lambda$13(r0, r1);
    }

    public static /* synthetic */ CallableDescriptor accessor$LazyJavaScope$lambda9(SimpleFunctionDescriptor r0) {
        return retainMostSpecificMethods$lambda$6(r0);
    }

    private static final CallableDescriptor retainMostSpecificMethods$lambda$6(SimpleFunctionDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$selectMostSpecificInEachOverridableGroup");
        return r1;
    }

    public abstract Set<Name> computeClassNames(DescriptorKindFilter r1, Function1<? super Name, Boolean> r2);

    public abstract Set<Name> computeFunctionNames(DescriptorKindFilter r1, Function1<? super Name, Boolean> r2);

    public void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> r2, Name r3) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
    }

    public abstract DeclaredMemberIndex computeMemberIndex();

    public abstract void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> r1, Name r2);

    public abstract void computeNonDeclaredProperties(Name r1, Collection<PropertyDescriptor> r2);

    public abstract Set<Name> computePropertyNames(DescriptorKindFilter r1, Function1<? super Name, Boolean> r2);

    public abstract ReceiverParameterDescriptor getDispatchReceiverParameter();

    public abstract DeclarationDescriptor getOwnerDescriptor();

    public boolean isVisibleAsFunction(JavaMethodDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return true;
    }

    public abstract MethodSignatureData resolveMethodSignature(JavaMethod r1, List<? extends TypeParameterDescriptor> r2, KotlinType r3, List<? extends ValueParameterDescriptor> r4);

    private final Set<Name> getClassNamesLazy() {
        return (Set) StorageKt.getValue(this.classNamesLazy$delegate, this, $$delegatedProperties[2]);
    }

    private final Set<Name> getFunctionNamesLazy() {
        return (Set) StorageKt.getValue(this.functionNamesLazy$delegate, this, $$delegatedProperties[0]);
    }

    private final Set<Name> getPropertyNamesLazy() {
        return (Set) StorageKt.getValue(this.propertyNamesLazy$delegate, this, $$delegatedProperties[1]);
    }

    public String toString() {
        return "Lazy scope for " + getOwnerDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return getClassNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return getFunctionNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return getPropertyNamesLazy();
    }

    public final NotNullLazyValue<Collection<DeclarationDescriptor>> getAllDescriptors() {
        return this.allDescriptors;
    }

    public final LazyJavaResolverContext getC() {
        return this.c;
    }

    public final NotNullLazyValue<DeclaredMemberIndex> getDeclaredMemberIndex() {
        return this.declaredMemberIndex;
    }

    public final LazyJavaScope getMainScope() {
        return this.mainScope;
    }

    private static final Collection allDescriptors$lambda$0(LazyJavaScope r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        return r2.computeDescriptors(DescriptorKindFilter.ALL, MemberScope.Companion.getALL_NAME_FILTER());
    }

    private static final Set classNamesLazy_delegate$lambda$12(LazyJavaScope r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        return r2.computeClassNames(DescriptorKindFilter.CLASSIFIERS, null);
    }

    private final PropertyDescriptorImpl createPropertyDescriptor(JavaField r10) {
        boolean r5 = !r10.isFinal();
        return JavaPropertyDescriptor.create(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(this.c, r10), Modality.FINAL, UtilsKt.toDescriptorVisibility(r10.getVisibility()), r5, r10.getName(), this.c.getComponents().getSourceElementFactory().source(r10), isFinalStatic(r10));
    }

    private static final DeclaredMemberIndex declaredMemberIndex$lambda$1(LazyJavaScope r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return r1.computeMemberIndex();
    }

    private static final Set functionNamesLazy_delegate$lambda$10(LazyJavaScope r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        return r2.computeFunctionNames(DescriptorKindFilter.FUNCTIONS, null);
    }

    private final KotlinType getPropertyType(JavaField r9) {
        KotlinType r0 = this.c.getTypeResolver().transformJavaType(r9.getType(), JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null));
        if (KotlinBuiltIns.isPrimitiveType(r0) == true) goto L7;
        if (KotlinBuiltIns.isString(r0) == true) goto L7;
    L11:
        boolean r10 = false;
    L12:
        if (r10 == true) goto L14;
        return r0;
    L14:
        return TypeUtils.makeNotNullable(r0);
    L7:
        if (isFinalStatic(r9) == false) goto L11;
        if (r9.getHasConstantNotNullInitializer() == false) goto L11;
        r10 = true;
        goto L12
    }

    private final boolean isFinalStatic(JavaField r2) {
        if (r2.isFinal() == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.isStatic() == false) goto L7;
        return true;
    }

    private static final Set propertyNamesLazy_delegate$lambda$11(LazyJavaScope r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        return r2.computePropertyNames(DescriptorKindFilter.VARIABLES, null);
    }

    private final PropertyDescriptor resolveProperty(JavaField r10) {
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        PropertyDescriptorImpl r1 = createPropertyDescriptor(r10);
        r0.element = r1;
        ClassDescriptor r2 = null;
        r1.initialize(null, null, null, null);
        KotlinType r4 = getPropertyType(r10);
        ((PropertyDescriptorImpl) r0.element).setType(r4, CollectionsKt.emptyList(), getDispatchReceiverParameter(), null, CollectionsKt.emptyList());
        DeclarationDescriptor r3 = getOwnerDescriptor();
        if ((r3 instanceof ClassDescriptor) == false) goto L5;
        r2 = (ClassDescriptor) r3;
    L5:
        if (r2 == null) goto L7;
        r0.element = this.c.getComponents().getSyntheticPartsProvider().modifyField(r2, (PropertyDescriptorImpl) r0.element, this.c);
    L7:
        Object r5 = r0.element;
        if (DescriptorUtils.shouldRecordInitializerForProperty((VariableDescriptor) r5, ((PropertyDescriptorImpl) r5).getType()) == false) goto L10;
        ((PropertyDescriptorImpl) r0.element).setCompileTimeInitializerFactory(new LazyJavaScope$.Lambda.10(this, r10, r0));
    L10:
        this.c.getComponents().getJavaResolverCache().recordField(r10, (PropertyDescriptor) r0.element);
        return (PropertyDescriptor) r0.element;
    }

    private final void retainMostSpecificMethods(Set<SimpleFunctionDescriptor> r8) {
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<T> r0 = r8.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r2 = r0.next();
        String r3 = MethodSignatureMappingKt.computeJvmDescriptor$default((SimpleFunctionDescriptor) r2, false, false, 2, null);
        Object r4 = r1.get(r3);
        if (r4 != null) goto L8;
        r4 = new ArrayList();
        r1.put(r3, r4);
    L8:
        ((List) r4).add(r2);
        goto L4
    L9:
        Iterator r5 = r1.values().iterator();
    L11:
        if (r5.hasNext() == false) goto L15;
        List r6 = (List) r5.next();
        if (r6.size() == 1) goto L11;
        List r7 = r6;
        Collection<? extends SimpleFunctionDescriptor> r9 = OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(r7, LazyJavaScope$.Lambda.9.INSTANCE);
        r8.removeAll(r7);
        r8.addAll(r9);
        goto L11
    }

    public final JavaMethodDescriptor resolveMethodToFunctionDescriptor(JavaMethod r21) {
        Intrinsics.checkNotNullParameter(r21, "method");
        Annotations r1 = LazyJavaAnnotationsKt.resolveAnnotations(this.c, r21);
        DeclarationDescriptor r2 = getOwnerDescriptor();
        Name r3 = r21.getName();
        JavaSourceElement r4 = this.c.getComponents().getSourceElementFactory().source(r21);
        if (((DeclaredMemberIndex) this.declaredMemberIndex.invoke()).findRecordComponentByName(r21.getName()) != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        JavaMethodDescriptor r15 = JavaMethodDescriptor.createJavaMethod(r2, r1, r3, r4, r5);
        LazyJavaResolverContext r6 = ContextKt.childForMethod$default(this.c, r15, r21, 0, 4, null);
        List r7 = r21.getTypeParameters();
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L10:
        if (r9.hasNext() == false) goto L12;
        TypeParameterDescriptor r10 = r6.getTypeParameterResolver().resolveTypeParameter((JavaTypeParameter) r9.next());
        Intrinsics.checkNotNull(r10);
        r8.add(r10);
        goto L10
    L12:
        ResolvedValueParameters r11 = resolveValueParameters(r6, r15, r21.getValueParameters());
        MethodSignatureData r12 = resolveMethodSignature(r21, r8, computeMethodReturnType(r21, r6), r11.getDescriptors());
        KotlinType r13 = r12.getReceiverType();
        if (r13 == null) goto L15;
        ReceiverParameterDescriptor r14 = DescriptorFactory.createExtensionReceiverParameterForCallable(r15, r13, Annotations.Companion.getEMPTY());
    L16:
        ReceiverParameterDescriptor r16 = r14;
        ReceiverParameterDescriptor r17 = getDispatchReceiverParameter();
        List r18 = CollectionsKt.emptyList();
        List r19 = r12.getTypeParameters();
        List r20 = r12.getValueParameters();
        KotlinType r110 = r12.getReturnType();
        Modality r111 = Modality.Companion.convertFromFlags(false, r21.isAbstract(), !r21.isFinal());
        DescriptorVisibility r112 = UtilsKt.toDescriptorVisibility(r21.getVisibility());
        if (r12.getReceiverType() == null) goto L19;
        Map r22 = MapsKt.mapOf(TuplesKt.to(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER, CollectionsKt.first(r11.getDescriptors())));
    L20:
        r15.initialize(r16, r17, r18, r19, r20, r110, r111, r112, r22);
        r15.setParameterNamesStatus(r12.getHasStableParameterNames(), r11.getHasSynthesizedNames());
        if ((!r12.getErrors().isEmpty()) == false) goto L23;
        r6.getComponents().getSignaturePropagator().reportSignatureErrors(r15, r12.getErrors());
    L23:
        return r15;
    L19:
        r22 = MapsKt.emptyMap();
        goto L20
    L15:
        r14 = null;
        goto L16
    L5:
        if (r21.getValueParameters().isEmpty() == false) goto L7;
        r5 = true;
        goto L8
    }

    public LazyJavaScope(LazyJavaResolverContext r3, LazyJavaScope r4) {
        Intrinsics.checkNotNullParameter(r3, "c");
        this.c = r3;
        this.mainScope = r4;
        this.allDescriptors = r3.getStorageManager().createRecursionTolerantLazyValue(new LazyJavaScope$$Lambda$0(this), CollectionsKt.emptyList());
        this.declaredMemberIndex = r3.getStorageManager().createLazyValue(new LazyJavaScope$$Lambda$1(this));
        this.declaredFunctions = r3.getStorageManager().createMemoizedFunction(new LazyJavaScope$$Lambda$2(this));
        this.declaredField = r3.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaScope$$Lambda$3(this));
        this.functions = r3.getStorageManager().createMemoizedFunction(new LazyJavaScope$$Lambda$4(this));
        this.functionNamesLazy$delegate = r3.getStorageManager().createLazyValue(new LazyJavaScope$$Lambda$5(this));
        this.propertyNamesLazy$delegate = r3.getStorageManager().createLazyValue(new LazyJavaScope$$Lambda$6(this));
        this.classNamesLazy$delegate = r3.getStorageManager().createLazyValue(new LazyJavaScope$$Lambda$7(this));
        this.properties = r3.getStorageManager().createMemoizedFunction(new LazyJavaScope$$Lambda$8(this));
    }

    private static final PropertyDescriptor declaredField$lambda$3(LazyJavaScope r1, Name r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        LazyJavaScope r0 = r1.mainScope;
        if (r0 != null) goto L5;
        JavaField r3 = ((DeclaredMemberIndex) r1.declaredMemberIndex.invoke()).findFieldByName(r2);
        if (r3 != null) goto L9;
    L11:
        return null;
    L9:
        if (r3.isEnumEntry() == true) goto L11;
        return r1.resolveProperty(r3);
    L5:
        return (PropertyDescriptor) r0.declaredField.invoke(r2);
    }

    private static final Collection declaredFunctions$lambda$2(LazyJavaScope r5, Name r6) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r6, DBDefinition.NAME);
        LazyJavaScope r0 = r5.mainScope;
        if (r0 != null) goto L5;
        ArrayList r1 = new ArrayList();
        Iterator r2 = ((DeclaredMemberIndex) r5.declaredMemberIndex.invoke()).findMethodsByName(r6).iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        JavaMethod r3 = (JavaMethod) r2.next();
        JavaMethodDescriptor r4 = r5.resolveMethodToFunctionDescriptor(r3);
        if (r5.isVisibleAsFunction(r4) == false) goto L8;
        r5.c.getComponents().getJavaResolverCache().recordMethod(r3, r4);
        r1.add(r4);
        goto L8
    L12:
        r5.computeImplicitlyDeclaredFunctions(r1, r6);
        return r1;
    L5:
        return (Collection) r0.declaredFunctions.invoke(r6);
    }

    private static final Collection functions$lambda$4(LazyJavaScope r2, Name r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
        LinkedHashSet r0 = new LinkedHashSet((Collection) r2.declaredFunctions.invoke(r3));
        r2.retainMostSpecificMethods(r0);
        r2.computeNonDeclaredFunctions(r0, r3);
        return CollectionsKt.toList(r2.c.getComponents().getSignatureEnhancement().enhanceSignatures(r2.c, r0));
    }

    private static final List properties$lambda$13(LazyJavaScope r2, Name r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
        ArrayList r0 = new ArrayList();
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r0, r2.declaredField.invoke(r3));
        r2.computeNonDeclaredProperties(r3, r0);
        if (DescriptorUtils.isAnnotationClass(r2.getOwnerDescriptor()) == false) goto L6;
        return CollectionsKt.toList(r0);
    L6:
        return CollectionsKt.toList(r2.c.getComponents().getSignatureEnhancement().enhanceSignatures(r2.c, r0));
    }

    public final List<DeclarationDescriptor> computeDescriptors(DescriptorKindFilter r6, Function1<? super Name, Boolean> r7) {
        Intrinsics.checkNotNullParameter(r6, "kindFilter");
        Intrinsics.checkNotNullParameter(r7, "nameFilter");
        NoLookupLocation r0 = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet r1 = new LinkedHashSet();
        if (r6.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK()) == false) goto L11;
        Iterator<Name> r2 = computeClassNames(r6, r7).iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        Name r3 = r2.next();
        if (((Boolean) r7.invoke(r3)).booleanValue() == false) goto L6;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r1, mo383getContributedClassifier(r3, r0));
    L11:
        if (r6.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) == false) goto L21;
        if (r6.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE) == true) goto L21;
        Iterator<Name> r4 = computeFunctionNames(r6, r7).iterator();
    L16:
        if (r4.hasNext() == false) goto L21;
        Name r5 = r4.next();
        if (((Boolean) r7.invoke(r5)).booleanValue() == false) goto L16;
        r1.addAll(getContributedFunctions(r5, r0));
    L21:
        if (r6.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) == false) goto L31;
        if (r6.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE) == true) goto L31;
        Iterator<Name> r8 = computePropertyNames(r6, r7).iterator();
    L26:
        if (r8.hasNext() == false) goto L31;
        Name r9 = r8.next();
        if (((Boolean) r7.invoke(r9)).booleanValue() == false) goto L26;
        r1.addAll(getContributedVariables(r9, r0));
    L31:
        return CollectionsKt.toList(r1);
    }

    public final KotlinType computeMethodReturnType(JavaMethod r8, LazyJavaResolverContext r9) {
        Intrinsics.checkNotNullParameter(r8, "method");
        Intrinsics.checkNotNullParameter(r9, "c");
        boolean r2 = r8.getContainingClass().isAnnotationType();
        JavaTypeAttributes r0 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, r2, false, null, 6, null);
        return r9.getTypeResolver().transformJavaType(r8.getReturnType(), r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r2, Function1<? super Name, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "kindFilter");
        Intrinsics.checkNotNullParameter(r3, "nameFilter");
        return (Collection) this.allDescriptors.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r3, "location");
        if (getFunctionNames().contains(r2) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return (Collection) this.functions.invoke(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r3, "location");
        if (getVariableNames().contains(r2) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return (Collection) this.properties.invoke(r2);
    }

    private static final NullableLazyValue resolveProperty$lambda$16(LazyJavaScope r2, JavaField r3, Ref.ObjectRef r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$field");
        Intrinsics.checkNotNullParameter(r4, "$propertyDescriptor");
        return r2.c.getStorageManager().createNullableLazyValue(new LazyJavaScope$.Lambda.11(r2, r3, r4));
    }

    private static final ConstantValue resolveProperty$lambda$16$lambda$15(LazyJavaScope r1, JavaField r2, Ref.ObjectRef r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$field");
        Intrinsics.checkNotNullParameter(r3, "$propertyDescriptor");
        return r1.c.getComponents().getJavaPropertyInitializerEvaluator().getInitializerConstant(r2, (PropertyDescriptor) r3.element);
    }

    public final ResolvedValueParameters resolveValueParameters(LazyJavaResolverContext r21, FunctionDescriptor r22, List<? extends JavaValueParameter> r23) {
        LazyJavaResolverContext r0 = r21;
        Intrinsics.checkNotNullParameter(r0, "c");
        Intrinsics.checkNotNullParameter(r22, "function");
        Intrinsics.checkNotNullParameter(r23, "jValueParameters");
        Iterable r2 = CollectionsKt.withIndex(r23);
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r3 = r2.iterator();
        boolean r4 = false;
    L4:
        if (r3.hasNext() == false) goto L29;
        IndexedValue r5 = (IndexedValue) r3.next();
        int r6 = r5.component1();
        JavaValueParameter r7 = (JavaValueParameter) r5.component2();
        Annotations r8 = LazyJavaAnnotationsKt.resolveAnnotations(r0, r7);
        JavaTypeAttributes r9 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null);
        JavaArrayType r10 = null;
        if (r7.isVararg() == false) goto L14;
        JavaType r11 = r7.getType();
        if ((r11 instanceof JavaArrayType) == false) goto L10;
        r10 = (JavaArrayType) r11;
    L10:
        if (r10 == null) goto L13;
        KotlinType r12 = r21.getTypeResolver().transformArrayType(r10, r9, true);
        Pair r13 = TuplesKt.to(r12, r21.getModule().getBuiltIns().getArrayElementType(r12));
    L15:
        KotlinType r15 = (KotlinType) r13.component1();
        KotlinType r16 = (KotlinType) r13.component2();
        if (Intrinsics.areEqual(r22.getName().asString(), "equals") == true) goto L18;
    L22:
        Name r17 = r7.getName();
        if (r17 != null) goto L25;
        r4 = true;
    L25:
        if (r17 != null) goto L27;
        r17 = Name.identifier("p" + r6);
    L27:
        Name r18 = r17;
        Intrinsics.checkNotNull(r18);
        ArrayList r1 = r14;
        r1.add(new ValueParameterDescriptorImpl(r22, null, r6, r8, r18, r15, false, false, false, r16, r21.getComponents().getSourceElementFactory().source(r7)));
        r14 = r1;
        r4 = r4;
        r0 = r21;
        goto L4
    L18:
        if (r23.size() != 1) goto L22;
        if (Intrinsics.areEqual(r21.getModule().getBuiltIns().getNullableAnyType(), r15) == false) goto L22;
        r17 = Name.identifier(IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        goto L27
    L13:
        throw new AssertionError("Vararg parameter should be an array: " + r7);
    L14:
        r13 = TuplesKt.to(r21.getTypeResolver().transformJavaType(r7.getType(), r9), null);
        goto L15
    L29:
        return new ResolvedValueParameters(CollectionsKt.toList(r14), r4);
    }

    public /* synthetic */ LazyJavaScope(LazyJavaResolverContext r1, LazyJavaScope r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
