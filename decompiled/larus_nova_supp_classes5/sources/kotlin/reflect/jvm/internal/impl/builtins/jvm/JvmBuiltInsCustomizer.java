package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilterKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo$Result;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JvmBuiltInsCustomizer implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue cloneableType$delegate;
    private final MemoizedFunctionToNotNull<Pair<String, String>, Annotations> deprecationForSomeOfTheListMethods;
    private final JavaToKotlinClassMapper j2kClassMapper;
    private final CacheWithNotNullValues<FqName, ClassDescriptor> javaAnalogueClassesWithCustomSupertypeCache;
    private final KotlinType mockSerializableType;
    private final ModuleDescriptor moduleDescriptor;
    private final NotNullLazyValue notConsideredDeprecation$delegate;
    private final NotNullLazyValue settings$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsCustomizer.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsCustomizer.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsCustomizer.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    }

    public static /* synthetic */ SimpleType accessor$JvmBuiltInsCustomizer$lambda0(JvmBuiltInsCustomizer r0, StorageManager r1) {
        return cloneableType_delegate$lambda$0(r0, r1);
    }

    public static /* synthetic */ Annotations accessor$JvmBuiltInsCustomizer$lambda1(JvmBuiltInsCustomizer r0) {
        return notConsideredDeprecation_delegate$lambda$1(r0);
    }

    public static /* synthetic */ Annotations accessor$JvmBuiltInsCustomizer$lambda2(JvmBuiltInsCustomizer r0, Pair r1) {
        return deprecationForSomeOfTheListMethods$lambda$2(r0, r1);
    }

    public static /* synthetic */ KotlinType accessor$JvmBuiltInsCustomizer$lambda3(JvmBuiltInsCustomizer r0) {
        return createMockJavaIoSerializableType$lambda$3(r0);
    }

    public static /* synthetic */ Collection accessor$JvmBuiltInsCustomizer$lambda4(Name r0, MemberScope r1) {
        return getFunctions$lambda$5(r0, r1);
    }

    public static /* synthetic */ ClassDescriptor accessor$JvmBuiltInsCustomizer$lambda5(LazyJavaClassDescriptor r0, ClassDescriptor r1) {
        return getAdditionalFunctions$lambda$9(r0, r1);
    }

    public static /* synthetic */ Iterable accessor$JvmBuiltInsCustomizer$lambda6(CallableMemberDescriptor r0) {
        return isMutabilityViolation$lambda$13(r0);
    }

    public static /* synthetic */ Boolean accessor$JvmBuiltInsCustomizer$lambda7(JvmBuiltInsCustomizer r0, CallableMemberDescriptor r1) {
        return isMutabilityViolation$lambda$14(r0, r1);
    }

    public static /* synthetic */ Iterable accessor$JvmBuiltInsCustomizer$lambda8(JvmBuiltInsCustomizer r0, ClassDescriptor r1) {
        return getJdkMethodStatus$lambda$16(r0, r1);
    }

    private final SimpleType getCloneableType() {
        return (SimpleType) StorageKt.getValue(this.cloneableType$delegate, this, $$delegatedProperties[1]);
    }

    private final Annotations getNotConsideredDeprecation() {
        return (Annotations) StorageKt.getValue(this.notConsideredDeprecation$delegate, this, $$delegatedProperties[2]);
    }

    private final JvmBuiltIns.Settings getSettings() {
        return (JvmBuiltIns.Settings) StorageKt.getValue(this.settings$delegate, this, $$delegatedProperties[0]);
    }

    private final KotlinType createMockJavaIoSerializableType(StorageManager r13) {
        final ModuleDescriptor r0 = this.moduleDescriptor;
        final FqName r1 = new FqName("java.io");
        PackageFragmentDescriptorImpl r4 = new JvmBuiltInsCustomizer$createMockJavaIoSerializableType$mockJavaIoPackageFragment$1(r0, r1);
        List r2 = CollectionsKt.listOf(new LazyWrappedType(r13, new JvmBuiltInsCustomizer$$Lambda$3(this)));
        ClassDescriptorImpl r3 = new ClassDescriptorImpl(r4, Name.identifier("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, r2, SourceElement.NO_SOURCE, false, r13);
        r3.initialize(MemberScope.Empty.INSTANCE, SetsKt.emptySet(), null);
        return r3.getDefaultType();
    }

    private static final KotlinType createMockJavaIoSerializableType$lambda$3(JvmBuiltInsCustomizer r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return r1.moduleDescriptor.getBuiltIns().getAnyType();
    }

    private final LazyJavaClassDescriptor getJavaAnalogue(ClassDescriptor r4) {
        if (KotlinBuiltIns.isAny(r4) == false) goto L6;
        return null;
    L6:
        if (KotlinBuiltIns.isUnderKotlinPackage(r4) == true) goto L8;
        return null;
    L8:
        FqNameUnsafe r5 = DescriptorUtilsKt.getFqNameUnsafe(r4);
        if (r5.isSafe() == true) goto L11;
        return null;
    L11:
        ClassId r6 = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(r5);
        if (r6 == null) goto L20;
        FqName r7 = r6.asSingleFqName();
        if (r7 == null) goto L22;
        LazyJavaClassDescriptor r8 = DescriptorUtilKt.resolveClassByFqName(getSettings().getOwnerModuleDescriptor(), r7, NoLookupLocation.FROM_BUILTINS);
        if ((r8 instanceof LazyJavaClassDescriptor) == true) goto L19;
        return null;
    L19:
        return r8;
    L22:
        return null;
    L20:
        return null;
    }

    private final JDKMemberStatus getJdkMethodStatus(FunctionDescriptor r5) {
        DeclarationDescriptor r0 = r5.getContainingDeclaration();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String r6 = MethodSignatureMappingKt.computeJvmDescriptor$default(r5, false, false, 3, null);
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        return (JDKMemberStatus) DFS.dfs(CollectionsKt.listOf((ClassDescriptor) r0), new JvmBuiltInsCustomizer$.Lambda.8(this), new getJdkMethodStatus.2(r6, r1));
    }

    private static final Iterable isMutabilityViolation$lambda$13(CallableMemberDescriptor r0) {
        return r0.getOriginal().getOverriddenDescriptors();
    }

    private static final Annotations notConsideredDeprecation_delegate$lambda$1(JvmBuiltInsCustomizer r7) {
        Intrinsics.checkNotNullParameter(r7, "this$0");
        AnnotationDescriptor r8 = AnnotationUtilKt.createDeprecatedAnnotation$default(r7.moduleDescriptor.getBuiltIns(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, true, 6, null);
        return Annotations.Companion.create(CollectionsKt.listOf(r8));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor r14) {
        Intrinsics.checkNotNullParameter(r14, "classDescriptor");
        if (r14.getKind() != ClassKind.CLASS) goto L50;
        if (getSettings().isAdditionalBuiltInsFeatureSupported() == false) goto L50;
        LazyJavaClassDescriptor r0 = getJavaAnalogue(r14);
        if (r0 == null) goto L10;
        ClassDescriptor r1 = JavaToKotlinClassMapper.mapJavaToKotlin$default(this.j2kClassMapper, DescriptorUtilsKt.getFqNameSafe(r0), FallbackBuiltIns.Companion.getInstance(), null, 4, null);
        if (r1 == null) goto L14;
        TypeSubstitutor r2 = MappingUtilKt.createMappedTypeParametersSubstitution(r1, r0).buildSubstitutor();
        List r3 = r0.getConstructors();
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L16:
        boolean r8 = false;
        if (r5.hasNext() == false) goto L41;
        Object r6 = r5.next();
        ClassConstructorDescriptor r9 = (ClassConstructorDescriptor) r6;
        if (r9.getVisibility().isPublicAPI() == false) goto L39;
        Collection<ClassConstructorDescriptor> r10 = r1.getConstructors();
        if ((r10 instanceof Collection) == true) goto L23;
    L25:
        Iterator<T> r11 = r10.iterator();
    L27:
        if (r11.hasNext() == false) goto L24;
        ClassConstructorDescriptor r12 = (ClassConstructorDescriptor) r11.next();
        Intrinsics.checkNotNull(r12);
        if (getConstructors$isEffectivelyTheSameAs(r12, r2, r9) == false) goto L27;
        boolean r13 = false;
    L31:
        if (r13 == false) goto L39;
        if (isTrivialCopyConstructorFor(r9, r14) == true) goto L39;
        if (KotlinBuiltIns.isDeprecated(r9) == true) goto L39;
        if (JvmBuiltInsSignatures.INSTANCE.getHIDDEN_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, r0, MethodSignatureMappingKt.computeJvmDescriptor$default(r9, false, false, 3, null))) == true) goto L39;
        r8 = true;
    L24:
        r13 = true;
        goto L31
    L23:
        if (r10.isEmpty() == false) goto L25;
    L39:
        if (r8 == false) goto L16;
        r4.add(r6);
        goto L16
    L41:
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r15 = r4.iterator();
    L43:
        if (r15.hasNext() == false) goto L48;
        ClassConstructorDescriptor r16 = (ClassConstructorDescriptor) r15.next();
        FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> r17 = r16.newCopyBuilder();
        r17.setOwner(r14);
        r17.setReturnType(r14.getDefaultType());
        r17.setPreserveSourceElement();
        r17.setSubstitution(r2.getSubstitution());
        if (JvmBuiltInsSignatures.INSTANCE.getVISIBLE_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, r0, MethodSignatureMappingKt.computeJvmDescriptor$default(r16, false, false, 3, null))) == true) goto L47;
        r17.setAdditionalAnnotations(getNotConsideredDeprecation());
    L47:
        FunctionDescriptor r18 = r17.build();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
        r7.add((ClassConstructorDescriptor) r18);
        goto L43
    L48:
        return r7;
    L14:
        return CollectionsKt.emptyList();
    L10:
        return CollectionsKt.emptyList();
    L50:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Set<Name> getFunctionsNames(ClassDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "classDescriptor");
        if (getSettings().isAdditionalBuiltInsFeatureSupported() == false) goto L5;
        LazyJavaClassDescriptor r3 = getJavaAnalogue(r2);
        if (r3 == null) goto L13;
        LazyJavaClassMemberScope r4 = r3.getUnsubstitutedMemberScope();
        if (r4 == null) goto L13;
        Set<Name> r5 = r4.getFunctionNames();
        if (r5 == null) goto L13;
        return r5;
    L13:
        return SetsKt.emptySet();
    L5:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<KotlinType> getSupertypes(ClassDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "classDescriptor");
        FqNameUnsafe r4 = DescriptorUtilsKt.getFqNameUnsafe(r3);
        if (JvmBuiltInsSignatures.INSTANCE.isArrayOrPrimitiveArray(r4) == false) goto L6;
        return CollectionsKt.listOf(new KotlinType[]{getCloneableType(), this.mockSerializableType});
    L6:
        if (JvmBuiltInsSignatures.INSTANCE.isSerializableInJava(r4) == false) goto L9;
        return CollectionsKt.listOf(this.mockSerializableType);
    L9:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public /* bridge */ /* synthetic */ Collection getFunctionsNames(ClassDescriptor r1) {
        return getFunctionsNames(r1);
    }

    private static final SimpleType cloneableType_delegate$lambda$0(JvmBuiltInsCustomizer r3, StorageManager r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r4, "$storageManager");
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(r3.getSettings().getOwnerModuleDescriptor(), JvmBuiltInClassDescriptorFactory.Companion.getCLONEABLE_CLASS_ID(), new NotFoundClasses(r4, r3.getSettings().getOwnerModuleDescriptor())).getDefaultType();
    }

    private final SimpleFunctionDescriptor createCloneForArray(DeserializedClassDescriptor r2, SimpleFunctionDescriptor r3) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> r4 = r3.newCopyBuilder();
        r4.setOwner(r2);
        r4.setVisibility(DescriptorVisibilities.PUBLIC);
        r4.setReturnType(r2.getDefaultType());
        r4.setDispatchReceiverParameter(r2.getThisAsReceiverParameter());
        FunctionDescriptor r5 = r4.build();
        Intrinsics.checkNotNull(r5);
        return (SimpleFunctionDescriptor) r5;
    }

    private static final Annotations deprecationForSomeOfTheListMethods$lambda$2(JvmBuiltInsCustomizer r3, Pair r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r4, "<destruct>");
        String r0 = (String) r4.component1();
        String r5 = (String) r4.component2();
        return Annotations.Companion.create(CollectionsKt.listOf(AnnotationUtilKt.createDeprecatedAnnotation(r3.moduleDescriptor.getBuiltIns(), "'" + r0 + "()' member of List is redundant in Kotlin and might be removed soon. Please use '" + r5 + "()' stdlib extension instead", r5 + "()", "HIDDEN", false)));
    }

    private final Collection<SimpleFunctionDescriptor> getAdditionalFunctions(ClassDescriptor r9, Function1<? super MemberScope, ? extends Collection<? extends SimpleFunctionDescriptor>> r10) {
        LazyJavaClassDescriptor r0 = getJavaAnalogue(r9);
        if (r0 == null) goto L5;
        Collection<ClassDescriptor> r1 = this.j2kClassMapper.mapPlatformClass(DescriptorUtilsKt.getFqNameSafe(r0), FallbackBuiltIns.Companion.getInstance());
        ClassDescriptor r2 = (ClassDescriptor) CollectionsKt.lastOrNull(r1);
        if (r2 == null) goto L9;
        SmartSet.Companion r3 = SmartSet.Companion;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r5 = r1.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        r4.add(DescriptorUtilsKt.getFqNameSafe((ClassDescriptor) r5.next()));
        goto L12
    L14:
        SmartSet r6 = r3.create(r4);
        boolean r11 = this.j2kClassMapper.isMutable(r9);
        Iterable r12 = (Iterable) r10.invoke(this.javaAnalogueClassesWithCustomSupertypeCache.computeIfAbsent(DescriptorUtilsKt.getFqNameSafe(r0), new JvmBuiltInsCustomizer$.Lambda.5(r0, r2)).getUnsubstitutedMemberScope());
        ArrayList r7 = new ArrayList();
        Iterator r13 = r12.iterator();
    L16:
        if (r13.hasNext() == false) goto L44;
        Object r8 = r13.next();
        SimpleFunctionDescriptor r14 = (SimpleFunctionDescriptor) r8;
        boolean r15 = false;
        if (r14.getKind() == CallableMemberDescriptor.Kind.DECLARATION) goto L21;
    L42:
        if (r15 == false) goto L16;
        r7.add(r8);
        goto L16
    L21:
        if (r14.getVisibility().isPublicAPI() == false) goto L42;
        if (KotlinBuiltIns.isDeprecated(r14) == true) goto L42;
        Collection<? extends FunctionDescriptor> r16 = r14.getOverriddenDescriptors();
        if ((r16 instanceof Collection) == true) goto L29;
    L31:
        Iterator<T> r17 = r16.iterator();
    L33:
        if (r17.hasNext() == false) goto L30;
        if (r6.contains(DescriptorUtilsKt.getFqNameSafe(((FunctionDescriptor) r17.next()).getContainingDeclaration())) == false) goto L33;
        boolean r18 = true;
    L37:
        if (r18 == true) goto L42;
        if (isMutabilityViolation(r14, r11) == true) goto L42;
        r15 = true;
    L30:
        r18 = false;
        goto L37
    L29:
        if (r16.isEmpty() == false) goto L31;
    L44:
        return r7;
    L9:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    private static final ClassDescriptor getAdditionalFunctions$lambda$9(LazyJavaClassDescriptor r1, ClassDescriptor r2) {
        Intrinsics.checkNotNullParameter(r1, "$javaAnalogueDescriptor");
        Intrinsics.checkNotNullParameter(r2, "$kotlinMutableClassIfContainer");
        return r1.copy$descriptors_jvm(JavaResolverCache.EMPTY, r2);
    }

    private static final Collection getFunctions$lambda$5(Name r1, MemberScope r2) {
        Intrinsics.checkNotNullParameter(r1, "$name");
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2.getContributedFunctions(r1, NoLookupLocation.FROM_BUILTINS);
    }

    private static final Iterable getJdkMethodStatus$lambda$16(JvmBuiltInsCustomizer r4, ClassDescriptor r5) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Collection<KotlinType> r6 = r5.getTypeConstructor().getSupertypes();
        ArrayList r0 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L21;
        ClassifierDescriptor r1 = ((KotlinType) r7.next()).getConstructor().getDeclarationDescriptor();
        ClassDescriptor r2 = null;
        if (r1 == null) goto L8;
        ClassifierDescriptor r3 = r1.getOriginal();
    L10:
        if ((r3 instanceof ClassDescriptor) == false) goto L12;
        ClassDescriptor r8 = (ClassDescriptor) r3;
    L13:
        if (r8 == null) goto L19;
        r2 = r4.getJavaAnalogue(r8);
        if (r2 != null) goto L19;
        r2 = r8;
    L19:
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L12:
        r8 = null;
        goto L13
    L8:
        r3 = null;
        goto L10
    L21:
        return r0;
    }

    private final boolean isMutabilityViolation(SimpleFunctionDescriptor r5, boolean r6) {
        DeclarationDescriptor r0 = r5.getContainingDeclaration();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String r1 = MethodSignatureMappingKt.computeJvmDescriptor$default(r5, false, false, 3, null);
        Set<String> r2 = JvmBuiltInsSignatures.INSTANCE.getMUTABLE_METHOD_SIGNATURES();
        SignatureBuildingComponents r3 = SignatureBuildingComponents.INSTANCE;
        if ((r6 ^ r2.contains(MethodSignatureBuildingUtilsKt.signature(r3, (ClassDescriptor) r0, r1))) == false) goto L7;
        return true;
    L7:
        return DFS.ifAny(CollectionsKt.listOf(r5), JvmBuiltInsCustomizer$.Lambda.6.INSTANCE, new JvmBuiltInsCustomizer$.Lambda.7(this)).booleanValue();
    }

    private static final Boolean isMutabilityViolation$lambda$14(JvmBuiltInsCustomizer r2, CallableMemberDescriptor r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (r3.getKind() != CallableMemberDescriptor.Kind.DECLARATION) goto L7;
        JavaToKotlinClassMapper r4 = r2.j2kClassMapper;
        DeclarationDescriptor r5 = r3.getContainingDeclaration();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        if (r4.isMutable((ClassDescriptor) r5) == false) goto L7;
        boolean r6 = true;
    L9:
        return Boolean.valueOf(r6);
    L7:
        r6 = false;
        goto L9
    }

    private final boolean isTrivialCopyConstructorFor(ConstructorDescriptor r3, ClassDescriptor r4) {
        if (r3.getValueParameters().size() != 1) goto L11;
        ClassifierDescriptor r5 = ((ValueParameterDescriptor) CollectionsKt.single(r3.getValueParameters())).getType().getConstructor().getDeclarationDescriptor();
        if (r5 == null) goto L7;
        FqNameUnsafe r6 = DescriptorUtilsKt.getFqNameUnsafe(r5);
    L9:
        if (Intrinsics.areEqual(r6, DescriptorUtilsKt.getFqNameUnsafe(r4)) == false) goto L11;
        return true;
    L7:
        r6 = null;
    L11:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<SimpleFunctionDescriptor> getFunctions(final Name r8, ClassDescriptor r9) {
        Intrinsics.checkNotNullParameter(r8, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r9, "classDescriptor");
        boolean r1 = true;
        if (Intrinsics.areEqual(r8, CloneableClassScope.Companion.getCLONE_NAME()) == false) goto L24;
        if ((r9 instanceof DeserializedClassDescriptor) == false) goto L24;
        if (KotlinBuiltIns.isArrayOrPrimitiveArray(r9) == false) goto L24;
        DeserializedClassDescriptor r10 = (DeserializedClassDescriptor) r9;
        List<ProtoBuf$Function> r0 = r10.getClassProto().getFunctionList();
        if ((r0 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r2 = r0.iterator();
    L15:
        if (r2.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(NameResolverUtilKt.getName(r10.getC().getNameResolver(), ((ProtoBuf$Function) r2.next()).getName()), CloneableClassScope.Companion.getCLONE_NAME()) == false) goto L15;
    L18:
        if (r1 == false) goto L22;
        return CollectionsKt.emptyList();
    L22:
        return CollectionsKt.listOf(createCloneForArray(r10, (SimpleFunctionDescriptor) CollectionsKt.single(getCloneableType().getMemberScope().getContributedFunctions(r8, NoLookupLocation.FROM_BUILTINS))));
    L12:
        r1 = false;
        goto L18
    L11:
        if (r0.isEmpty() == false) goto L13;
    L24:
        if (getSettings().isAdditionalBuiltInsFeatureSupported() == false) goto L26;
        Collection<SimpleFunctionDescriptor> r11 = getAdditionalFunctions(r9, new JvmBuiltInsCustomizer$$Lambda$4(r8));
        ArrayList r3 = new ArrayList();
        Iterator<T> r12 = r11.iterator();
    L29:
        if (r12.hasNext() == false) goto L60;
        SimpleFunctionDescriptor r4 = (SimpleFunctionDescriptor) r12.next();
        DeclarationDescriptor r5 = r4.getContainingDeclaration();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        FunctionDescriptor r6 = r4.substitute(MappingUtilKt.createMappedTypeParametersSubstitution((ClassDescriptor) r5, r9).buildSubstitutor());
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> r7 = ((SimpleFunctionDescriptor) r6).newCopyBuilder();
        r7.setOwner(r9);
        r7.setDispatchReceiverParameter(r9.getThisAsReceiverParameter());
        r7.setPreserveSourceElement();
        int r13 = WhenMappings.$EnumSwitchMapping$0[getJdkMethodStatus(r4).ordinal()];
        SimpleFunctionDescriptor r14 = null;
        if (r13 == 1) goto L54;
        if (r13 != 2) goto L35;
        Name r15 = r4.getName();
        if (Intrinsics.areEqual(r15, JvmBuiltInsCustomizerKt.access$getGET_FIRST_LIST_NAME$p()) == false) goto L48;
        Annotations r16 = (Annotations) this.deprecationForSomeOfTheListMethods.invoke(TuplesKt.to(r4.getName().asString(), "first"));
    L50:
        r7.setAdditionalAnnotations(r16);
    L57:
        FunctionDescriptor r17 = r7.build();
        Intrinsics.checkNotNull(r17);
        r14 = (SimpleFunctionDescriptor) r17;
    L58:
        if (r14 == null) goto L29;
        r3.add(r14);
        goto L29
    L48:
        if (Intrinsics.areEqual(r15, JvmBuiltInsCustomizerKt.access$getGET_LAST_LIST_NAME$p()) == false) goto L52;
        r16 = (Annotations) this.deprecationForSomeOfTheListMethods.invoke(TuplesKt.to(r4.getName().asString(), "last"));
        goto L50
    L52:
        throw new IllegalStateException(("Unexpected name: " + r4.getName()).toString());
    L35:
        if (r13 != 3) goto L37;
        r7.setAdditionalAnnotations(getNotConsideredDeprecation());
        goto L57
    L37:
        if (r13 == 4) goto L58;
        if (r13 != 5) goto L42;
        Unit r18 = Unit.INSTANCE;
        goto L57
    L42:
        throw new NoWhenBranchMatchedException();
    L54:
        if (ModalityUtilsKt.isFinalClass(r9) == true) goto L58;
        r7.setHiddenForResolutionEverywhereBesideSupercalls();
        goto L57
    L60:
        return r3;
    L26:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
    public boolean isFunctionAvailable(ClassDescriptor r7, SimpleFunctionDescriptor r8) {
        Intrinsics.checkNotNullParameter(r7, "classDescriptor");
        Intrinsics.checkNotNullParameter(r8, "functionDescriptor");
        LazyJavaClassDescriptor r9 = getJavaAnalogue(r7);
        if (r9 != null) goto L6;
        return true;
    L6:
        if (r8.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME()) == true) goto L9;
        return true;
    L9:
        if (getSettings().isAdditionalBuiltInsFeatureSupported() == true) goto L11;
        return false;
    L11:
        String r4 = MethodSignatureMappingKt.computeJvmDescriptor$default(r8, false, false, 3, null);
        Collection r10 = r9.getUnsubstitutedMemberScope().getContributedFunctions(r8.getName(), NoLookupLocation.FROM_BUILTINS);
        if ((r10 instanceof Collection) == true) goto L14;
    L16:
        Iterator r11 = r10.iterator();
    L18:
        if (r11.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default((SimpleFunctionDescriptor) r11.next(), false, false, 3, null), r4) == false) goto L18;
        return true;
    L15:
        return false;
    L14:
        if (r10.isEmpty() == false) goto L16;
        goto L15
    }

    public JvmBuiltInsCustomizer(ModuleDescriptor r2, final StorageManager r3, Function0<JvmBuiltIns.Settings> r4) {
        Intrinsics.checkNotNullParameter(r2, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(r3, "storageManager");
        Intrinsics.checkNotNullParameter(r4, "settingsComputation");
        this.moduleDescriptor = r2;
        this.j2kClassMapper = JavaToKotlinClassMapper.INSTANCE;
        this.settings$delegate = r3.createLazyValue(r4);
        this.mockSerializableType = createMockJavaIoSerializableType(r3);
        this.cloneableType$delegate = r3.createLazyValue(new JvmBuiltInsCustomizer$$Lambda$0(this, r3));
        this.javaAnalogueClassesWithCustomSupertypeCache = r3.createCacheWithNotNullValues();
        this.notConsideredDeprecation$delegate = r3.createLazyValue(new JvmBuiltInsCustomizer$$Lambda$1(this));
        this.deprecationForSomeOfTheListMethods = r3.createMemoizedFunction(new JvmBuiltInsCustomizer$$Lambda$2(this));
    }

    private static final boolean getConstructors$isEffectivelyTheSameAs(ConstructorDescriptor r0, TypeSubstitutor r1, ConstructorDescriptor r2) {
        if (OverridingUtil.getBothWaysOverridability(r0, r2.substitute(r1)) != OverridingUtil$OverrideCompatibilityInfo$Result.OVERRIDABLE) goto L5;
        return true;
    L5:
        return false;
    }
}
