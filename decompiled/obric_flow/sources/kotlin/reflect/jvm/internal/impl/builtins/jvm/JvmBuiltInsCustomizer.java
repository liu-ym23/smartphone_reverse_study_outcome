package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
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
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilterKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nJvmBuiltInsCustomizer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmBuiltInsCustomizer.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,345:1\n1747#2,3:346\n1603#2,9:349\n1855#2:358\n1856#2:360\n1612#2:361\n1549#2:362\n1620#2,3:363\n766#2:366\n857#2:367\n1747#2,3:368\n858#2:371\n766#2:372\n857#2:373\n2624#2,3:374\n858#2:377\n1549#2:378\n1620#2,3:379\n1747#2,3:382\n1603#2,9:385\n1855#2:394\n1856#2:396\n1612#2:397\n1#3:359\n1#3:395\n*S KotlinDebug\n*F\n+ 1 JvmBuiltInsCustomizer.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer\n*L\n108#1:346,3\n124#1:349,9\n124#1:358\n124#1:360\n124#1:361\n173#1:362\n173#1:363,3\n187#1:366\n187#1:367\n192#1:368,3\n187#1:371\n288#1:372\n288#1:373\n290#1:374,3\n288#1:377\n297#1:378\n297#1:379,3\n324#1:382,3\n235#1:385,9\n235#1:394\n235#1:396\n235#1:397\n124#1:359\n235#1:395\n*E\n"})
public final class JvmBuiltInsCustomizer implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue cloneableType$delegate;
    private final JavaToKotlinClassMapper j2kClassMapper;
    private final CacheWithNotNullValues<FqName, ClassDescriptor> javaAnalogueClassesWithCustomSupertypeCache;
    private final KotlinType mockSerializableType;
    private final ModuleDescriptor moduleDescriptor;
    private final NotNullLazyValue notConsideredDeprecation$delegate;
    private final NotNullLazyValue settings$delegate;

    public static final enum JDKMemberStatus extends Enum<JDKMemberStatus> {
        private static final /* synthetic */ JDKMemberStatus[] $VALUES = null;
        public static final JDKMemberStatus DROP = null;
        public static final JDKMemberStatus HIDDEN = null;
        public static final JDKMemberStatus NOT_CONSIDERED = null;
        public static final JDKMemberStatus VISIBLE = null;

        private static final /* synthetic */ JDKMemberStatus[] $values() {
            return new JDKMemberStatus[]{HIDDEN, VISIBLE, NOT_CONSIDERED, DROP};
        }

        static {
            HIDDEN = new JDKMemberStatus("HIDDEN", 0);
            VISIBLE = new JDKMemberStatus("VISIBLE", 1);
            NOT_CONSIDERED = new JDKMemberStatus("NOT_CONSIDERED", 2);
            DROP = new JDKMemberStatus("DROP", 3);
            $VALUES = $values();
        }

        private JDKMemberStatus(String r5, int r10) {
            super(r5, r10);
        }

        public static JDKMemberStatus valueOf(String r5) {
            return (JDKMemberStatus) Enum.valueOf(JDKMemberStatus.class, r5);
        }

        public static JDKMemberStatus[] values() {
            return (JDKMemberStatus[]) $VALUES.clone();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[JDKMemberStatus.values().length];
            r5[JDKMemberStatus.HIDDEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r5[JDKMemberStatus.NOT_CONSIDERED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r5[JDKMemberStatus.DROP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r5[JDKMemberStatus.VISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r5;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsCustomizer.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsCustomizer.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsCustomizer.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    }

    public JvmBuiltInsCustomizer(ModuleDescriptor r5, final StorageManager r10, Function0<JvmBuiltIns.Settings> r11) {
        Intrinsics.checkNotNullParameter(r5, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(r10, "storageManager");
        Intrinsics.checkNotNullParameter(r11, "settingsComputation");
        this.moduleDescriptor = r5;
        this.j2kClassMapper = JavaToKotlinClassMapper.INSTANCE;
        this.settings$delegate = r10.createLazyValue(r11);
        this.mockSerializableType = createMockJavaIoSerializableType(r10);
        this.cloneableType$delegate = r10.createLazyValue(new JvmBuiltInsCustomizer$cloneableType$2(this, r10));
        this.javaAnalogueClassesWithCustomSupertypeCache = r10.createCacheWithNotNullValues();
        this.notConsideredDeprecation$delegate = r10.createLazyValue(new JvmBuiltInsCustomizer$notConsideredDeprecation$2(this));
    }

    public static final /* synthetic */ JavaToKotlinClassMapper access$getJ2kClassMapper$p(JvmBuiltInsCustomizer r5) {
        return r5.j2kClassMapper;
    }

    public static final /* synthetic */ ModuleDescriptor access$getModuleDescriptor$p(JvmBuiltInsCustomizer r5) {
        return r5.moduleDescriptor;
    }

    public static final /* synthetic */ JvmBuiltIns.Settings access$getSettings(JvmBuiltInsCustomizer r5) {
        return r5.getSettings();
    }

    public static /* synthetic */ Iterable accessor$JvmBuiltInsCustomizer$lambda0(CallableMemberDescriptor r5) {
        return isMutabilityViolation$lambda$7(r5);
    }

    public static /* synthetic */ Iterable accessor$JvmBuiltInsCustomizer$lambda1(JvmBuiltInsCustomizer r5, ClassDescriptor r10) {
        return getJdkMethodStatus$lambda$9(r5, r10);
    }

    private final SimpleFunctionDescriptor createCloneForArray(DeserializedClassDescriptor r5, SimpleFunctionDescriptor r10) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> r11 = r10.newCopyBuilder();
        r11.setOwner(r5);
        r11.setVisibility(DescriptorVisibilities.PUBLIC);
        r11.setReturnType(r5.getDefaultType());
        r11.setDispatchReceiverParameter(r5.getThisAsReceiverParameter());
        FunctionDescriptor r12 = r11.build();
        Intrinsics.checkNotNull(r12);
        return (SimpleFunctionDescriptor) r12;
    }

    private final KotlinType createMockJavaIoSerializableType(StorageManager r13) {
        final ModuleDescriptor r5 = this.moduleDescriptor;
        final FqName r10 = new FqName("java.io");
        PackageFragmentDescriptorImpl r11 = new JvmBuiltInsCustomizer$createMockJavaIoSerializableType$mockJavaIoPackageFragment$1(r5, r10);
        List r12 = CollectionsKt.listOf(new LazyWrappedType(r13, new JvmBuiltInsCustomizer$createMockJavaIoSerializableType$superTypes$1(this)));
        ClassDescriptorImpl r14 = new ClassDescriptorImpl(r11, Name.identifier("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, r12, SourceElement.NO_SOURCE, false, r13);
        r14.initialize(MemberScope.Empty.INSTANCE, SetsKt.emptySet(), null);
        return r14.getDefaultType();
    }

    private final Collection<SimpleFunctionDescriptor> getAdditionalFunctions(ClassDescriptor r10, Function1<? super MemberScope, ? extends Collection<? extends SimpleFunctionDescriptor>> r11) {
        final LazyJavaClassDescriptor r5 = getJavaAnalogue(r10);
        if (r5 == null) goto L5;
        Collection<ClassDescriptor> r12 = this.j2kClassMapper.mapPlatformClass(DescriptorUtilsKt.getFqNameSafe(r5), FallbackBuiltIns.Companion.getInstance());
        final ClassDescriptor r13 = (ClassDescriptor) CollectionsKt.lastOrNull(r12);
        if (r13 == null) goto L9;
        SmartSet.Companion r14 = SmartSet.Companion;
        ArrayList r15 = new ArrayList(CollectionsKt.h(r12));
        Iterator<T> r16 = r12.iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        r15.add(DescriptorUtilsKt.getFqNameSafe((ClassDescriptor) r16.next()));
        goto L12
    L14:
        SmartSet r17 = r14.create(r15);
        boolean r18 = this.j2kClassMapper.isMutable(r10);
        Collection<? extends SimpleFunctionDescriptor> r19 = r11.invoke(this.javaAnalogueClassesWithCustomSupertypeCache.computeIfAbsent(DescriptorUtilsKt.getFqNameSafe(r5), new JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1(r5, r13)).getUnsubstitutedMemberScope());
        ArrayList r20 = new ArrayList();
        Iterator<T> r21 = r19.iterator();
    L16:
        if (r21.hasNext() == false) goto L40;
        Object r22 = r21.next();
        SimpleFunctionDescriptor r23 = (SimpleFunctionDescriptor) r22;
        if (r23.getKind() != CallableMemberDescriptor.Kind.DECLARATION) goto L16;
        if (r23.getVisibility().isPublicAPI() == false) goto L16;
        if (KotlinBuiltIns.isDeprecated(r23) == true) goto L16;
        Collection<? extends FunctionDescriptor> r24 = r23.getOverriddenDescriptors();
        if ((r24 instanceof Collection) == true) goto L29;
    L31:
        Iterator<T> r25 = r24.iterator();
    L33:
        if (r25.hasNext() == false) goto L38;
        if (r17.contains(DescriptorUtilsKt.getFqNameSafe(((FunctionDescriptor) r25.next()).getContainingDeclaration())) == false) goto L33;
    L38:
        if (isMutabilityViolation(r23, r18) == true) goto L16;
        r20.add(r22);
        goto L16
    L29:
        if (r24.isEmpty() == false) goto L31;
    L40:
        return r20;
    L9:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    private final SimpleType getCloneableType() {
        return (SimpleType) StorageKt.getValue(this.cloneableType$delegate, this, $$delegatedProperties[1]);
    }

    private static final boolean getConstructors$isEffectivelyTheSameAs(ConstructorDescriptor r5, TypeSubstitutor r10, ConstructorDescriptor r11) {
        if (OverridingUtil.getBothWaysOverridability(r5, r11.substitute(r10)) != OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) goto L5;
        return true;
    L5:
        return false;
    }

    private final LazyJavaClassDescriptor getJavaAnalogue(ClassDescriptor r5) {
        if (KotlinBuiltIns.isAny(r5) == false) goto L6;
        return null;
    L6:
        if (KotlinBuiltIns.isUnderKotlinPackage(r5) == true) goto L8;
        return null;
    L8:
        FqNameUnsafe r10 = DescriptorUtilsKt.getFqNameUnsafe(r5);
        if (r10.isSafe() == true) goto L11;
        return null;
    L11:
        ClassId r11 = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(r10);
        if (r11 == null) goto L20;
        FqName r12 = r11.asSingleFqName();
        if (r12 == null) goto L22;
        ClassDescriptor r13 = DescriptorUtilKt.resolveClassByFqName(getSettings().getOwnerModuleDescriptor(), r12, NoLookupLocation.FROM_BUILTINS);
        if ((r13 instanceof LazyJavaClassDescriptor) == true) goto L19;
        return null;
    L19:
        return (LazyJavaClassDescriptor) r13;
    L22:
        return null;
    L20:
        return null;
    }

    private final JDKMemberStatus getJdkMethodStatus(FunctionDescriptor r5) {
        DeclarationDescriptor r10 = r5.getContainingDeclaration();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        final String r11 = MethodSignatureMappingKt.computeJvmDescriptor$default(r5, false, false, 3, null);
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        return (JDKMemberStatus) DFS.dfs(CollectionsKt.listOf((ClassDescriptor) r10), new JvmBuiltInsCustomizer$$Lambda$1(this), new C02222(r11, r12));
    }

    private static final Iterable getJdkMethodStatus$lambda$9(JvmBuiltInsCustomizer r5, ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Collection<KotlinType> r11 = r10.getTypeConstructor().mo1403getSupertypes();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L17;
        ClassifierDescriptor r14 = ((KotlinType) r13.next()).getConstructor().mo1402getDeclarationDescriptor();
        LazyJavaClassDescriptor r15 = null;
        if (r14 == null) goto L8;
        ClassifierDescriptor r16 = r14.getOriginal();
    L10:
        if ((r16 instanceof ClassDescriptor) == false) goto L12;
        ClassDescriptor r17 = (ClassDescriptor) r16;
    L13:
        if (r17 == null) goto L15;
        r15 = r5.getJavaAnalogue(r17);
    L15:
        if (r15 == null) goto L4;
        r12.add(r15);
        goto L4
    L12:
        r17 = null;
        goto L13
    L8:
        r16 = null;
        goto L10
    L17:
        return r12;
    }

    private final Annotations getNotConsideredDeprecation() {
        return (Annotations) StorageKt.getValue(this.notConsideredDeprecation$delegate, this, $$delegatedProperties[2]);
    }

    private final JvmBuiltIns.Settings getSettings() {
        return (JvmBuiltIns.Settings) StorageKt.getValue(this.settings$delegate, this, $$delegatedProperties[0]);
    }

    private final boolean isMutabilityViolation(SimpleFunctionDescriptor r5, boolean r10) {
        DeclarationDescriptor r11 = r5.getContainingDeclaration();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String r12 = MethodSignatureMappingKt.computeJvmDescriptor$default(r5, false, false, 3, null);
        Set<String> r13 = JvmBuiltInsSignatures.INSTANCE.getMUTABLE_METHOD_SIGNATURES();
        SignatureBuildingComponents r14 = SignatureBuildingComponents.INSTANCE;
        if ((r10 ^ r13.contains(MethodSignatureBuildingUtilsKt.signature(r14, (ClassDescriptor) r11, r12))) == false) goto L7;
        return true;
    L7:
        return DFS.ifAny(CollectionsKt.listOf(r5), JvmBuiltInsCustomizer$$Lambda$0.INSTANCE, new C02232(this)).booleanValue();
    }

    private static final Iterable isMutabilityViolation$lambda$7(CallableMemberDescriptor r5) {
        return r5.getOriginal().getOverriddenDescriptors();
    }

    private final boolean isTrivialCopyConstructorFor(ConstructorDescriptor r5, ClassDescriptor r10) {
        if (r5.getValueParameters().size() != 1) goto L11;
        ClassifierDescriptor r11 = ((ValueParameterDescriptor) CollectionsKt.single(r5.getValueParameters())).getType().getConstructor().mo1402getDeclarationDescriptor();
        if (r11 == null) goto L7;
        FqNameUnsafe r12 = DescriptorUtilsKt.getFqNameUnsafe(r11);
    L9:
        if (Intrinsics.areEqual(r12, DescriptorUtilsKt.getFqNameUnsafe(r10)) == false) goto L11;
        return true;
    L7:
        r12 = null;
    L11:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor r13) {
        Intrinsics.checkNotNullParameter(r13, "classDescriptor");
        if (r13.getKind() != ClassKind.CLASS) goto L47;
        if (getSettings().isAdditionalBuiltInsFeatureSupported() == false) goto L47;
        LazyJavaClassDescriptor r5 = getJavaAnalogue(r13);
        if (r5 == null) goto L10;
        ClassDescriptor r10 = JavaToKotlinClassMapper.mapJavaToKotlin$default(this.j2kClassMapper, DescriptorUtilsKt.getFqNameSafe(r5), FallbackBuiltIns.Companion.getInstance(), null, 4, null);
        if (r10 == null) goto L14;
        TypeSubstitutor r11 = MappingUtilKt.createMappedTypeParametersSubstitution(r10, r5).buildSubstitutor();
        List<ClassConstructorDescriptor> r12 = r5.getConstructors();
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r12.iterator();
    L17:
        if (r15.hasNext() == false) goto L38;
        Object r16 = r15.next();
        ClassConstructorDescriptor r17 = (ClassConstructorDescriptor) r16;
        if (r17.getVisibility().isPublicAPI() == false) goto L17;
        Collection<ClassConstructorDescriptor> r18 = r10.getConstructors();
        if ((r18 instanceof Collection) == true) goto L23;
    L25:
        Iterator<T> r19 = r18.iterator();
    L27:
        if (r19.hasNext() == false) goto L32;
        if (getConstructors$isEffectivelyTheSameAs((ClassConstructorDescriptor) r19.next(), r11, r17) == false) goto L27;
    L32:
        if (isTrivialCopyConstructorFor(r17, r13) == true) goto L17;
        if (KotlinBuiltIns.isDeprecated(r17) == true) goto L17;
        if (JvmBuiltInsSignatures.INSTANCE.getHIDDEN_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, r5, MethodSignatureMappingKt.computeJvmDescriptor$default(r17, false, false, 3, null))) == true) goto L17;
        r14.add(r16);
        goto L17
    L23:
        if (r18.isEmpty() == false) goto L25;
    L38:
        ArrayList r20 = new ArrayList(CollectionsKt.h(r14));
        Iterator r21 = r14.iterator();
    L40:
        if (r21.hasNext() == false) goto L45;
        ClassConstructorDescriptor r22 = (ClassConstructorDescriptor) r21.next();
        FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> r23 = r22.newCopyBuilder();
        r23.setOwner(r13);
        r23.setReturnType(r13.getDefaultType());
        r23.setPreserveSourceElement();
        r23.setSubstitution(r11.getSubstitution());
        if (JvmBuiltInsSignatures.INSTANCE.getVISIBLE_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, r5, MethodSignatureMappingKt.computeJvmDescriptor$default(r22, false, false, 3, null))) == true) goto L44;
        r23.setAdditionalAnnotations(getNotConsideredDeprecation());
    L44:
        FunctionDescriptor r24 = r23.build();
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
        r20.add((ClassConstructorDescriptor) r24);
        goto L40
    L45:
        return r20;
    L14:
        return CollectionsKt.emptyList();
    L10:
        return CollectionsKt.emptyList();
    L47:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<SimpleFunctionDescriptor> getFunctions(final Name r10, ClassDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "classDescriptor");
        if (Intrinsics.areEqual(r10, CloneableClassScope.Companion.getCLONE_NAME()) == false) goto L23;
        if ((r11 instanceof DeserializedClassDescriptor) == false) goto L23;
        if (KotlinBuiltIns.isArrayOrPrimitiveArray(r11) == false) goto L23;
        DeserializedClassDescriptor r12 = (DeserializedClassDescriptor) r11;
        List<ProtoBuf.Function> r5 = r12.getClassProto().getFunctionList();
        if (r5 != null) goto L11;
    L13:
        Iterator<T> r13 = r5.iterator();
    L15:
        if (r13.hasNext() == false) goto L21;
        ProtoBuf.Function r14 = (ProtoBuf.Function) r13.next();
        if (Intrinsics.areEqual(NameResolverUtilKt.getName(r12.getC().getNameResolver(), r14.getName()), CloneableClassScope.Companion.getCLONE_NAME()) == false) goto L15;
        return CollectionsKt.emptyList();
    L21:
        return CollectionsKt.listOf(createCloneForArray(r12, (SimpleFunctionDescriptor) CollectionsKt.single(getCloneableType().getMemberScope().getContributedFunctions(r10, NoLookupLocation.FROM_BUILTINS))));
    L11:
        if (r5.isEmpty() == false) goto L13;
    L23:
        if (getSettings().isAdditionalBuiltInsFeatureSupported() == false) goto L25;
        Collection<SimpleFunctionDescriptor> r15 = getAdditionalFunctions(r11, new AnonymousClass2(r10));
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r15.iterator();
    L28:
        if (r17.hasNext() == false) goto L44;
        SimpleFunctionDescriptor r18 = (SimpleFunctionDescriptor) r17.next();
        DeclarationDescriptor r19 = r18.getContainingDeclaration();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        FunctionDescriptor r20 = r18.substitute(MappingUtilKt.createMappedTypeParametersSubstitution((ClassDescriptor) r19, r11).buildSubstitutor());
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> r21 = ((SimpleFunctionDescriptor) r20).newCopyBuilder();
        r21.setOwner(r11);
        r21.setDispatchReceiverParameter(r11.getThisAsReceiverParameter());
        r21.setPreserveSourceElement();
        JDKMemberStatus r22 = getJdkMethodStatus(r18);
        int r23 = WhenMappings.$EnumSwitchMapping$0[r22.ordinal()];
        SimpleFunctionDescriptor r24 = null;
        if (r23 == 1) goto L38;
        if (r23 != 2) goto L34;
        r21.setAdditionalAnnotations(getNotConsideredDeprecation());
    L41:
        FunctionDescriptor r25 = r21.build();
        Intrinsics.checkNotNull(r25);
        r24 = (SimpleFunctionDescriptor) r25;
    L42:
        if (r24 == null) goto L28;
        r16.add(r24);
        goto L28
    L34:
        if (r23 == 3) goto L42;
    L38:
        if (ModalityUtilsKt.isFinalClass(r11) == true) goto L42;
        r21.setHiddenForResolutionEverywhereBesideSupercalls();
        goto L41
    L44:
        return r16;
    L25:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public /* bridge */ /* synthetic */ Collection getFunctionsNames(ClassDescriptor r5) {
        return getFunctionsNames(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<KotlinType> getSupertypes(ClassDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "classDescriptor");
        FqNameUnsafe r10 = DescriptorUtilsKt.getFqNameUnsafe(r5);
        JvmBuiltInsSignatures r11 = JvmBuiltInsSignatures.INSTANCE;
        if (r11.isArrayOrPrimitiveArray(r10) == false) goto L6;
        return CollectionsKt.listOf(new KotlinType[]{getCloneableType(), this.mockSerializableType});
    L6:
        if (r11.isSerializableInJava(r10) == false) goto L9;
        return CollectionsKt.listOf(this.mockSerializableType);
    L9:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
    public boolean isFunctionAvailable(ClassDescriptor r10, SimpleFunctionDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "classDescriptor");
        Intrinsics.checkNotNullParameter(r11, "functionDescriptor");
        LazyJavaClassDescriptor r12 = getJavaAnalogue(r10);
        if (r12 != null) goto L6;
        return true;
    L6:
        if (r11.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME()) == true) goto L9;
        return true;
    L9:
        if (getSettings().isAdditionalBuiltInsFeatureSupported() == true) goto L11;
        return false;
    L11:
        String r5 = MethodSignatureMappingKt.computeJvmDescriptor$default(r11, false, false, 3, null);
        Collection<SimpleFunctionDescriptor> r13 = r12.getUnsubstitutedMemberScope().getContributedFunctions(r11.getName(), NoLookupLocation.FROM_BUILTINS);
        if ((r13 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r14 = r13.iterator();
    L18:
        if (r14.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default((SimpleFunctionDescriptor) r14.next(), false, false, 3, null), r5) == false) goto L18;
        return true;
    L21:
        return false;
    L14:
        if (r13.isEmpty() == false) goto L16;
        goto L16
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Set<Name> getFunctionsNames(ClassDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "classDescriptor");
        if (getSettings().isAdditionalBuiltInsFeatureSupported() == false) goto L5;
        LazyJavaClassDescriptor r10 = getJavaAnalogue(r5);
        if (r10 == null) goto L13;
        LazyJavaClassMemberScope r11 = r10.getUnsubstitutedMemberScope();
        if (r11 == null) goto L13;
        Set<Name> r12 = r11.getFunctionNames();
        if (r12 == null) goto L13;
        return r12;
    L13:
        return SetsKt.emptySet();
    L5:
        return SetsKt.emptySet();
    }
}
