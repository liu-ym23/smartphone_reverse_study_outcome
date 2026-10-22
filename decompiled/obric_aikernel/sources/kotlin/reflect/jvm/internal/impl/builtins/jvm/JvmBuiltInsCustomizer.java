package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.bytedance.crash.tracker.ActivityLifecycle;
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
public final class JvmBuiltInsCustomizer implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue cloneableType$delegate;
    private final JavaToKotlinClassMapper j2kClassMapper;
    private final CacheWithNotNullValues<FqName, ClassDescriptor> javaAnalogueClassesWithCustomSupertypeCache;
    private final KotlinType mockSerializableType;
    private final ModuleDescriptor moduleDescriptor;
    private final NotNullLazyValue notConsideredDeprecation$delegate;
    private final NotNullLazyValue settings$delegate;

    private static final enum JDKMemberStatus extends Enum<JDKMemberStatus> {
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

        private JDKMemberStatus(String r10, int r11) {
            super(r10, r11);
        }

        public static JDKMemberStatus valueOf(String r10) {
            return (JDKMemberStatus) Enum.valueOf(JDKMemberStatus.class, r10);
        }

        public static JDKMemberStatus[] values() {
            return (JDKMemberStatus[]) $VALUES.clone();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[JDKMemberStatus.values().length];
            r10[JDKMemberStatus.HIDDEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r10[JDKMemberStatus.NOT_CONSIDERED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r10[JDKMemberStatus.DROP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r10[JDKMemberStatus.VISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r10;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsCustomizer.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsCustomizer.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsCustomizer.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    }

    public JvmBuiltInsCustomizer(ModuleDescriptor r10, final StorageManager r11, Function0<JvmBuiltIns.Settings> r12) {
        Intrinsics.checkNotNullParameter(r10, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(r11, "storageManager");
        Intrinsics.checkNotNullParameter(r12, "settingsComputation");
        this.moduleDescriptor = r10;
        this.j2kClassMapper = JavaToKotlinClassMapper.INSTANCE;
        this.settings$delegate = r11.createLazyValue(r12);
        this.mockSerializableType = createMockJavaIoSerializableType(r11);
        this.cloneableType$delegate = r11.createLazyValue(new JvmBuiltInsCustomizer$cloneableType$2(this, r11));
        this.javaAnalogueClassesWithCustomSupertypeCache = r11.createCacheWithNotNullValues();
        this.notConsideredDeprecation$delegate = r11.createLazyValue(new JvmBuiltInsCustomizer$notConsideredDeprecation$2(this));
    }

    public static final /* synthetic */ JavaToKotlinClassMapper access$getJ2kClassMapper$p(JvmBuiltInsCustomizer r10) {
        return r10.j2kClassMapper;
    }

    public static final /* synthetic */ LazyJavaClassDescriptor access$getJavaAnalogue(JvmBuiltInsCustomizer r10, ClassDescriptor r11) {
        return r10.getJavaAnalogue(r11);
    }

    public static final /* synthetic */ ModuleDescriptor access$getModuleDescriptor$p(JvmBuiltInsCustomizer r10) {
        return r10.moduleDescriptor;
    }

    public static final /* synthetic */ JvmBuiltIns.Settings access$getSettings(JvmBuiltInsCustomizer r10) {
        return r10.getSettings();
    }

    private final SimpleFunctionDescriptor createCloneForArray(DeserializedClassDescriptor r10, SimpleFunctionDescriptor r11) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> r12 = r11.newCopyBuilder();
        r12.setOwner(r10);
        r12.setVisibility(DescriptorVisibilities.PUBLIC);
        r12.setReturnType(r10.getDefaultType());
        r12.setDispatchReceiverParameter(r10.getThisAsReceiverParameter());
        FunctionDescriptor r13 = r12.build();
        Intrinsics.checkNotNull(r13);
        return (SimpleFunctionDescriptor) r13;
    }

    private final KotlinType createMockJavaIoSerializableType(StorageManager r13) {
        final ModuleDescriptor r10 = this.moduleDescriptor;
        final FqName r11 = new FqName("java.io");
        PackageFragmentDescriptorImpl r12 = new JvmBuiltInsCustomizer$createMockJavaIoSerializableType$mockJavaIoPackageFragment$1(r10, r11);
        List r14 = CollectionsKt.listOf(new LazyWrappedType(r13, new JvmBuiltInsCustomizer$createMockJavaIoSerializableType$superTypes$1(this)));
        ClassDescriptorImpl r15 = new ClassDescriptorImpl(r12, Name.identifier("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, r14, SourceElement.NO_SOURCE, false, r13);
        r15.initialize(MemberScope.Empty.INSTANCE, SetsKt.emptySet(), null);
        SimpleType r16 = r15.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(r16, "mockSerializableClass.defaultType");
        return r16;
    }

    private final Collection<SimpleFunctionDescriptor> getAdditionalFunctions(ClassDescriptor r10, Function1<? super MemberScope, ? extends Collection<? extends SimpleFunctionDescriptor>> r11) {
        final LazyJavaClassDescriptor r12 = getJavaAnalogue(r10);
        if (r12 == null) goto L5;
        Collection<ClassDescriptor> r13 = this.j2kClassMapper.mapPlatformClass(DescriptorUtilsKt.getFqNameSafe(r12), FallbackBuiltIns.Companion.getInstance());
        final ClassDescriptor r14 = (ClassDescriptor) CollectionsKt.lastOrNull(r13);
        if (r14 == null) goto L9;
        SmartSet.Companion r15 = SmartSet.Companion;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r17 = r13.iterator();
    L12:
        if (r17.hasNext() == false) goto L14;
        r16.add(DescriptorUtilsKt.getFqNameSafe((ClassDescriptor) r17.next()));
        goto L12
    L14:
        SmartSet r18 = r15.create(r16);
        boolean r19 = this.j2kClassMapper.isMutable(r10);
        MemberScope r20 = this.javaAnalogueClassesWithCustomSupertypeCache.computeIfAbsent(DescriptorUtilsKt.getFqNameSafe(r12), new JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1(r12, r14)).getUnsubstitutedMemberScope();
        Intrinsics.checkNotNullExpressionValue(r20, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
        Collection<? extends SimpleFunctionDescriptor> r110 = r11.invoke(r20);
        ArrayList r21 = new ArrayList();
        Iterator<T> r111 = r110.iterator();
    L16:
        if (r111.hasNext() == false) goto L43;
        Object r22 = r111.next();
        SimpleFunctionDescriptor r23 = (SimpleFunctionDescriptor) r22;
        boolean r24 = true;
        if (r23.getKind() == CallableMemberDescriptor.Kind.DECLARATION) goto L21;
    L19:
        r24 = false;
    L41:
        if (r24 == false) goto L16;
        r21.add(r22);
        goto L16
    L21:
        if (r23.getVisibility().isPublicAPI() == false) goto L19;
        if (KotlinBuiltIns.isDeprecated(r23) == true) goto L19;
        Collection<? extends FunctionDescriptor> r25 = r23.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(r25, "analogueMember.overriddenDescriptors");
        if ((r25 instanceof Collection) == true) goto L29;
    L31:
        Iterator<T> r26 = r25.iterator();
    L33:
        if (r26.hasNext() == false) goto L30;
        DeclarationDescriptor r27 = ((FunctionDescriptor) r26.next()).getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r27, "it.containingDeclaration");
        if (r18.contains(DescriptorUtilsKt.getFqNameSafe(r27)) == false) goto L33;
        boolean r28 = true;
    L37:
        if (r28 == true) goto L19;
        if (isMutabilityViolation(r23, r19) == true) goto L19;
    L30:
        r28 = false;
        goto L37
    L29:
        if (r25.isEmpty() == false) goto L31;
    L43:
        return r21;
    L9:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    private final SimpleType getCloneableType() {
        return (SimpleType) StorageKt.getValue(this.cloneableType$delegate, this, $$delegatedProperties[1]);
    }

    private static final boolean getConstructors$isEffectivelyTheSameAs(ConstructorDescriptor r10, TypeSubstitutor r11, ConstructorDescriptor r12) {
        if (OverridingUtil.getBothWaysOverridability(r10, r12.substitute(r11)) != OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) goto L5;
        return true;
    L5:
        return false;
    }

    private final LazyJavaClassDescriptor getJavaAnalogue(ClassDescriptor r10) {
        if (KotlinBuiltIns.isAny(r10) == false) goto L6;
        return null;
    L6:
        if (KotlinBuiltIns.isUnderKotlinPackage(r10) == true) goto L8;
        return null;
    L8:
        FqNameUnsafe r11 = DescriptorUtilsKt.getFqNameUnsafe(r10);
        if (r11.isSafe() == true) goto L11;
        return null;
    L11:
        ClassId r12 = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(r11);
        if (r12 == null) goto L20;
        FqName r13 = r12.asSingleFqName();
        if (r13 == null) goto L22;
        ClassDescriptor r14 = DescriptorUtilKt.resolveClassByFqName(getSettings().getOwnerModuleDescriptor(), r13, NoLookupLocation.FROM_BUILTINS);
        if ((r14 instanceof LazyJavaClassDescriptor) == true) goto L19;
        return null;
    L19:
        return (LazyJavaClassDescriptor) r14;
    L22:
        return null;
    L20:
        return null;
    }

    private final JDKMemberStatus getJdkMethodStatus(FunctionDescriptor r10) {
        DeclarationDescriptor r11 = r10.getContainingDeclaration();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        final String r12 = MethodSignatureMappingKt.computeJvmDescriptor$default(r10, false, false, 3, null);
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        Object r14 = DFS.dfs(CollectionsKt.listOf((ClassDescriptor) r11), new AnonymousClass1(this), new C04102(r12, r13));
        Intrinsics.checkNotNullExpressionValue(r14, "private fun FunctionDesc…ERED\n            })\n    }");
        return (JDKMemberStatus) r14;
    }

    private final Annotations getNotConsideredDeprecation() {
        return (Annotations) StorageKt.getValue(this.notConsideredDeprecation$delegate, this, $$delegatedProperties[2]);
    }

    private final JvmBuiltIns.Settings getSettings() {
        return (JvmBuiltIns.Settings) StorageKt.getValue(this.settings$delegate, this, $$delegatedProperties[0]);
    }

    private final boolean isMutabilityViolation(SimpleFunctionDescriptor r10, boolean r11) {
        DeclarationDescriptor r12 = r10.getContainingDeclaration();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String r13 = MethodSignatureMappingKt.computeJvmDescriptor$default(r10, false, false, 3, null);
        Set<String> r14 = JvmBuiltInsSignatures.INSTANCE.getMUTABLE_METHOD_SIGNATURES();
        SignatureBuildingComponents r15 = SignatureBuildingComponents.INSTANCE;
        if ((r11 ^ r14.contains(MethodSignatureBuildingUtilsKt.signature(r15, (ClassDescriptor) r12, r13))) == false) goto L6;
        return true;
    L6:
        Boolean r16 = DFS.ifAny(CollectionsKt.listOf(r10), C04111.INSTANCE, new C04122(this));
        Intrinsics.checkNotNullExpressionValue(r16, "private fun SimpleFuncti…scriptor)\n        }\n    }");
        return r16.booleanValue();
    }

    private final boolean isTrivialCopyConstructorFor(ConstructorDescriptor r10, ClassDescriptor r11) {
        if (r10.getValueParameters().size() != 1) goto L11;
        List<ValueParameterDescriptor> r12 = r10.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r12, "valueParameters");
        ClassifierDescriptor r13 = ((ValueParameterDescriptor) CollectionsKt.single(r12)).getType().getConstructor().mo1323getDeclarationDescriptor();
        if (r13 == null) goto L7;
        FqNameUnsafe r14 = DescriptorUtilsKt.getFqNameUnsafe(r13);
    L9:
        if (Intrinsics.areEqual(r14, DescriptorUtilsKt.getFqNameUnsafe(r11)) == false) goto L11;
        return true;
    L7:
        r14 = null;
    L11:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor r15) {
        Intrinsics.checkNotNullParameter(r15, "classDescriptor");
        if (r15.getKind() != ClassKind.CLASS) goto L50;
        if (getSettings().isAdditionalBuiltInsFeatureSupported() == false) goto L50;
        LazyJavaClassDescriptor r10 = getJavaAnalogue(r15);
        if (r10 == null) goto L10;
        ClassDescriptor r11 = JavaToKotlinClassMapper.mapJavaToKotlin$default(this.j2kClassMapper, DescriptorUtilsKt.getFqNameSafe(r10), FallbackBuiltIns.Companion.getInstance(), null, 4, null);
        if (r11 == null) goto L14;
        TypeSubstitutor r12 = MappingUtilKt.createMappedTypeParametersSubstitution(r11, r10).buildSubstitutor();
        List<ClassConstructorDescriptor> r13 = r10.getConstructors();
        ArrayList r14 = new ArrayList();
        Iterator<T> r16 = r13.iterator();
    L16:
        boolean r17 = false;
        if (r16.hasNext() == false) goto L41;
        Object r18 = r16.next();
        ClassConstructorDescriptor r19 = (ClassConstructorDescriptor) r18;
        if (r19.getVisibility().isPublicAPI() == false) goto L39;
        Collection<ClassConstructorDescriptor> r110 = r11.getConstructors();
        Intrinsics.checkNotNullExpressionValue(r110, "defaultKotlinVersion.constructors");
        if ((r110 instanceof Collection) == true) goto L23;
    L25:
        Iterator<T> r111 = r110.iterator();
    L27:
        if (r111.hasNext() == false) goto L24;
        ClassConstructorDescriptor r112 = (ClassConstructorDescriptor) r111.next();
        Intrinsics.checkNotNullExpressionValue(r112, "it");
        if (getConstructors$isEffectivelyTheSameAs(r112, r12, r19) == false) goto L27;
        boolean r113 = false;
    L31:
        if (r113 == false) goto L39;
        if (isTrivialCopyConstructorFor(r19, r15) == true) goto L39;
        if (KotlinBuiltIns.isDeprecated(r19) == true) goto L39;
        if (JvmBuiltInsSignatures.INSTANCE.getHIDDEN_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, r10, MethodSignatureMappingKt.computeJvmDescriptor$default(r19, false, false, 3, null))) == true) goto L39;
        r17 = true;
    L24:
        r113 = true;
        goto L31
    L23:
        if (r110.isEmpty() == false) goto L25;
    L39:
        if (r17 == false) goto L16;
        r14.add(r18);
        goto L16
    L41:
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r21 = r14.iterator();
    L43:
        if (r21.hasNext() == false) goto L48;
        ClassConstructorDescriptor r22 = (ClassConstructorDescriptor) r21.next();
        FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> r23 = r22.newCopyBuilder();
        r23.setOwner(r15);
        r23.setReturnType(r15.getDefaultType());
        r23.setPreserveSourceElement();
        r23.setSubstitution(r12.getSubstitution());
        if (JvmBuiltInsSignatures.INSTANCE.getVISIBLE_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, r10, MethodSignatureMappingKt.computeJvmDescriptor$default(r22, false, false, 3, null))) == true) goto L47;
        r23.setAdditionalAnnotations(getNotConsideredDeprecation());
    L47:
        FunctionDescriptor r24 = r23.build();
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
        r20.add((ClassConstructorDescriptor) r24);
        goto L43
    L48:
        return r20;
    L14:
        return CollectionsKt.emptyList();
    L10:
        return CollectionsKt.emptyList();
    L50:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<SimpleFunctionDescriptor> getFunctions(final Name r10, ClassDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "classDescriptor");
        boolean r12 = true;
        if (Intrinsics.areEqual(r10, CloneableClassScope.Companion.getCLONE_NAME()) == false) goto L24;
        if ((r11 instanceof DeserializedClassDescriptor) == false) goto L24;
        if (KotlinBuiltIns.isArrayOrPrimitiveArray(r11) == false) goto L24;
        DeserializedClassDescriptor r13 = (DeserializedClassDescriptor) r11;
        List<ProtoBuf.Function> r14 = r13.getClassProto().getFunctionList();
        Intrinsics.checkNotNullExpressionValue(r14, "classDescriptor.classProto.functionList");
        if ((r14 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r15 = r14.iterator();
    L15:
        if (r15.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(NameResolverUtilKt.getName(r13.getC().getNameResolver(), ((ProtoBuf.Function) r15.next()).getName()), CloneableClassScope.Companion.getCLONE_NAME()) == false) goto L15;
    L18:
        if (r12 == false) goto L22;
        return CollectionsKt.emptyList();
    L22:
        return CollectionsKt.listOf(createCloneForArray(r13, (SimpleFunctionDescriptor) CollectionsKt.single(getCloneableType().getMemberScope().getContributedFunctions(r10, NoLookupLocation.FROM_BUILTINS))));
    L12:
        r12 = false;
        goto L18
    L11:
        if (r14.isEmpty() == false) goto L13;
    L24:
        if (getSettings().isAdditionalBuiltInsFeatureSupported() == false) goto L26;
        Collection<SimpleFunctionDescriptor> r16 = getAdditionalFunctions(r11, new AnonymousClass2(r10));
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r16.iterator();
    L29:
        if (r18.hasNext() == false) goto L45;
        SimpleFunctionDescriptor r19 = (SimpleFunctionDescriptor) r18.next();
        DeclarationDescriptor r20 = r19.getContainingDeclaration();
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        FunctionDescriptor r21 = r19.substitute(MappingUtilKt.createMappedTypeParametersSubstitution((ClassDescriptor) r20, r11).buildSubstitutor());
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> r22 = ((SimpleFunctionDescriptor) r21).newCopyBuilder();
        r22.setOwner(r11);
        r22.setDispatchReceiverParameter(r11.getThisAsReceiverParameter());
        r22.setPreserveSourceElement();
        int r23 = WhenMappings.$EnumSwitchMapping$0[getJdkMethodStatus(r19).ordinal()];
        SimpleFunctionDescriptor r24 = null;
        if (r23 == 1) goto L39;
        if (r23 != 2) goto L35;
        r22.setAdditionalAnnotations(getNotConsideredDeprecation());
    L42:
        FunctionDescriptor r25 = r22.build();
        Intrinsics.checkNotNull(r25);
        r24 = (SimpleFunctionDescriptor) r25;
    L43:
        if (r24 == null) goto L29;
        r17.add(r24);
        goto L29
    L35:
        if (r23 == 3) goto L43;
    L39:
        if (ModalityUtilsKt.isFinalClass(r11) == true) goto L43;
        r22.setHiddenForResolutionEverywhereBesideSupercalls();
        goto L42
    L45:
        return r17;
    L26:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public /* bridge */ /* synthetic */ Collection getFunctionsNames(ClassDescriptor r10) {
        return getFunctionsNames(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Set<Name> getFunctionsNames(ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "classDescriptor");
        if (getSettings().isAdditionalBuiltInsFeatureSupported() == false) goto L5;
        LazyJavaClassDescriptor r11 = getJavaAnalogue(r10);
        if (r11 == null) goto L13;
        LazyJavaClassMemberScope r12 = r11.getUnsubstitutedMemberScope();
        if (r12 == null) goto L13;
        Set<Name> r13 = r12.getFunctionNames();
        if (r13 == null) goto L13;
        return r13;
    L13:
        return SetsKt.emptySet();
    L5:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<KotlinType> getSupertypes(ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "classDescriptor");
        FqNameUnsafe r11 = DescriptorUtilsKt.getFqNameUnsafe(r10);
        JvmBuiltInsSignatures r12 = JvmBuiltInsSignatures.INSTANCE;
        if (r12.isArrayOrPrimitiveArray(r11) == false) goto L6;
        SimpleType r13 = getCloneableType();
        Intrinsics.checkNotNullExpressionValue(r13, "cloneableType");
        return CollectionsKt.listOf(new KotlinType[]{r13, this.mockSerializableType});
    L6:
        if (r12.isSerializableInJava(r11) == false) goto L9;
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
        String r13 = MethodSignatureMappingKt.computeJvmDescriptor$default(r11, false, false, 3, null);
        LazyJavaClassMemberScope r14 = r12.getUnsubstitutedMemberScope();
        Name r15 = r11.getName();
        Intrinsics.checkNotNullExpressionValue(r15, "functionDescriptor.name");
        Collection<SimpleFunctionDescriptor> r16 = r14.getContributedFunctions(r15, NoLookupLocation.FROM_BUILTINS);
        if ((r16 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r17 = r16.iterator();
    L18:
        if (r17.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default((SimpleFunctionDescriptor) r17.next(), false, false, 3, null), r13) == false) goto L18;
        return true;
    L21:
        return false;
    L14:
        if (r16.isEmpty() == false) goto L16;
        goto L16
    }
}
