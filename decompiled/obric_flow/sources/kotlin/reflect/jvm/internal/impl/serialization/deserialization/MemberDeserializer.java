package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nMemberDeserializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemberDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/MemberDeserializer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,371:1\n1#2:372\n1#2:391\n1559#3:373\n1590#3,4:374\n1569#3,11:378\n1864#3,2:389\n1866#3:392\n1580#3:393\n1549#3:394\n1620#3,3:395\n1559#3:398\n1590#3,4:399\n*S KotlinDebug\n*F\n+ 1 MemberDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/MemberDeserializer\n*L\n215#1:391\n63#1:373\n63#1:374,4\n215#1:378,11\n215#1:389,2\n215#1:392\n215#1:393\n243#1:394\n243#1:395,3\n327#1:398\n327#1:399,4\n*E\n"})
public final class MemberDeserializer {
    private final AnnotationDeserializer annotationDeserializer;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DeserializationContext f18755c;

    public MemberDeserializer(DeserializationContext r5) {
        Intrinsics.checkNotNullParameter(r5, "c");
        this.f18755c = r5;
        this.annotationDeserializer = new AnnotationDeserializer(r5.getComponents().getModuleDescriptor(), r5.getComponents().getNotFoundClasses());
    }

    public static final /* synthetic */ ProtoContainer access$asProtoContainer(MemberDeserializer r5, DeclarationDescriptor r10) {
        return r5.asProtoContainer(r10);
    }

    public static final /* synthetic */ DeserializationContext access$getC$p(MemberDeserializer r5) {
        return r5.f18755c;
    }

    private final ProtoContainer asProtoContainer(DeclarationDescriptor r5) {
        if ((r5 instanceof PackageFragmentDescriptor) == false) goto L6;
        return new ProtoContainer.Package(((PackageFragmentDescriptor) r5).getFqName(), this.f18755c.getNameResolver(), this.f18755c.getTypeTable(), this.f18755c.getContainerSource());
    L6:
        if ((r5 instanceof DeserializedClassDescriptor) == true) goto L11;
        return null;
    L11:
        return ((DeserializedClassDescriptor) r5).getThisAsProtoContainer$deserialization();
    }

    private final Annotations getAnnotations(final MessageLite r5, int r10, final AnnotatedCallableKind r11) {
        if (Flags.HAS_ANNOTATIONS.get(r10).booleanValue() == true) goto L7;
        return Annotations.Companion.getEMPTY();
    L7:
        return new NonEmptyDeserializedAnnotations(this.f18755c.getStorageManager(), new AnonymousClass1(this, r5, r11));
    }

    private final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        DeclarationDescriptor r5 = this.f18755c.getContainingDeclaration();
        if ((r5 instanceof ClassDescriptor) == false) goto L5;
        ClassDescriptor r10 = (ClassDescriptor) r5;
    L6:
        if (r10 != null) goto L8;
        return null;
    L8:
        return r10.getThisAsReceiverParameter();
    L5:
        r10 = null;
        goto L6
    }

    private final Annotations getPropertyFieldAnnotations(final ProtoBuf.Property r5, final boolean r10) {
        if (Flags.HAS_ANNOTATIONS.get(r5.getFlags()).booleanValue() == true) goto L7;
        return Annotations.Companion.getEMPTY();
    L7:
        return new NonEmptyDeserializedAnnotations(this.f18755c.getStorageManager(), new C02381(this, r10, r5));
    }

    private final Annotations getReceiverParameterAnnotations(final MessageLite r5, final AnnotatedCallableKind r10) {
        return new DeserializedAnnotations(this.f18755c.getStorageManager(), new C02391(this, r5, r10));
    }

    private final void initializeWithCoroutinesExperimentalityStatus(DeserializedSimpleFunctionDescriptor r5, ReceiverParameterDescriptor r10, ReceiverParameterDescriptor r11, List<? extends ReceiverParameterDescriptor> r12, List<? extends TypeParameterDescriptor> r13, List<? extends ValueParameterDescriptor> r14, KotlinType r15, Modality r16, DescriptorVisibility r17, Map<? extends CallableDescriptor.UserDataKey<?>, ?> r18) {
        r5.initialize(r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    private final int loadOldFlags(int r5) {
        return (r5 & 63) + ((r5 >> 8) << 6);
    }

    private final ReceiverParameterDescriptor toContextReceiver(ProtoBuf.Type r5, DeserializationContext r10, CallableDescriptor r11, int r12) {
        return DescriptorFactory.createContextReceiverParameterForCallable(r11, r10.getTypeDeserializer().type(r5), null, Annotations.Companion.getEMPTY(), r12);
    }

    private final List<ValueParameterDescriptor> valueParameters(List<ProtoBuf.ValueParameter> r26, final MessageLite r27, final AnnotatedCallableKind r28) {
        DeclarationDescriptor r5 = this.f18755c.getContainingDeclaration();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        CallableDescriptor r20 = (CallableDescriptor) r5;
        final ProtoContainer r21 = asProtoContainer(r20.getContainingDeclaration());
        ArrayList r15 = new ArrayList(CollectionsKt.h(r26));
        Iterator<T> r22 = r26.iterator();
        int r11 = 0;
    L4:
        if (r22.hasNext() == false) goto L24;
        Object r10 = r22.next();
        int r24 = r11 + 1;
        if (r11 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        final ProtoBuf.ValueParameter r12 = (ProtoBuf.ValueParameter) r10;
        if (r12.hasFlags() == false) goto L11;
        int r13 = r12.getFlags();
    L12:
        if (r21 != null) goto L14;
    L16:
        Annotations r14 = Annotations.Companion.getEMPTY();
    L17:
        Name r16 = NameResolverUtilKt.getName(this.f18755c.getNameResolver(), r12.getName());
        KotlinType r17 = this.f18755c.getTypeDeserializer().type(ProtoTypeTableUtilKt.type(r12, this.f18755c.getTypeTable()));
        boolean r18 = Flags.DECLARES_DEFAULT_VALUE.get(r13).booleanValue();
        boolean r19 = Flags.IS_CROSSINLINE.get(r13).booleanValue();
        boolean r110 = Flags.IS_NOINLINE.get(r13).booleanValue();
        ProtoBuf.Type r23 = ProtoTypeTableUtilKt.varargElementType(r12, this.f18755c.getTypeTable());
        if (r23 == null) goto L21;
        KotlinType r25 = this.f18755c.getTypeDeserializer().type(r23);
    L22:
        ArrayList r29 = r15;
        r29.add(new ValueParameterDescriptorImpl(r20, null, r11, r14, r16, r17, r18, r19, r110, r25, SourceElement.NO_SOURCE));
        r15 = r29;
        r11 = r24;
        goto L4
    L21:
        r25 = null;
        goto L22
    L14:
        if (Flags.HAS_ANNOTATIONS.get(r13).booleanValue() == false) goto L16;
        final int r30 = r11;
        r14 = new NonEmptyDeserializedAnnotations(this.f18755c.getStorageManager(), new MemberDeserializer$valueParameters$1$annotations$1(this, r21, r27, r28, r30, r12));
        goto L17
    L11:
        r13 = 0;
        goto L12
    L24:
        return CollectionsKt.toList(r15);
    }

    public final ClassConstructorDescriptor loadConstructor(ProtoBuf.Constructor r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r21, "proto");
        DeclarationDescriptor r5 = this.f18755c.getContainingDeclaration();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        ClassDescriptor r16 = (ClassDescriptor) r5;
        int r10 = r21.getFlags();
        AnnotatedCallableKind r13 = AnnotatedCallableKind.FUNCTION;
        DeserializedClassConstructorDescriptor r14 = new DeserializedClassConstructorDescriptor(r16, null, getAnnotations(r21, r10, r13), r22, CallableMemberDescriptor.Kind.DECLARATION, r21, this.f18755c.getNameResolver(), this.f18755c.getTypeTable(), this.f18755c.getVersionRequirementTable(), this.f18755c.getContainerSource(), null, 1024, null);
        r14.initialize(DeserializationContext.childContext$default(this.f18755c, r14, CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer().valueParameters(r21.getValueParameterList(), r21, r13), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(r21.getFlags())));
        r14.setReturnType(r16.getDefaultType());
        r14.setExpect(r16.isExpect());
        r14.setHasStableParameterNames(!Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES.get(r21.getFlags()).booleanValue());
        return r14;
    }

    public final SimpleFunctionDescriptor loadFunction(ProtoBuf.Function r32) {
        Intrinsics.checkNotNullParameter(r32, "proto");
        if (r32.hasFlags() == false) goto L6;
        int r5 = r32.getFlags();
    L5:
        int r10 = r5;
        AnnotatedCallableKind r11 = AnnotatedCallableKind.FUNCTION;
        Annotations r15 = getAnnotations(r32, r10, r11);
        if (ProtoTypeTableUtilKt.hasReceiver(r32) == false) goto L10;
        Annotations r12 = getReceiverParameterAnnotations(r32, r11);
    L12:
        if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(this.f18755c.getContainingDeclaration()).child(NameResolverUtilKt.getName(this.f18755c.getNameResolver(), r32.getName())), SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME) == false) goto L15;
        VersionRequirementTable r13 = VersionRequirementTable.Companion.getEMPTY();
    L16:
        DeserializedSimpleFunctionDescriptor r14 = new DeserializedSimpleFunctionDescriptor(this.f18755c.getContainingDeclaration(), null, r15, NameResolverUtilKt.getName(this.f18755c.getNameResolver(), r32.getName()), ProtoEnumFlagsUtilsKt.memberKind(ProtoEnumFlags.INSTANCE, Flags.MEMBER_KIND.get(r10)), r32, this.f18755c.getNameResolver(), this.f18755c.getTypeTable(), r13, this.f18755c.getContainerSource(), null, 1024, null);
        DeserializationContext r16 = DeserializationContext.childContext$default(this.f18755c, r14, r32.getTypeParameterList(), null, null, null, null, 60, null);
        ProtoBuf.Type r17 = ProtoTypeTableUtilKt.receiverType(r32, this.f18755c.getTypeTable());
        if (r17 == null) goto L22;
        KotlinType r18 = r16.getTypeDeserializer().type(r17);
        if (r18 == null) goto L22;
        ReceiverParameterDescriptor r19 = DescriptorFactory.createExtensionReceiverParameterForCallable(r14, r18, r12);
    L21:
        ReceiverParameterDescriptor r20 = r19;
        ReceiverParameterDescriptor r21 = getDispatchReceiverParameter();
        List<ProtoBuf.Type> r22 = ProtoTypeTableUtilKt.contextReceiverTypes(r32, this.f18755c.getTypeTable());
        List<? extends ReceiverParameterDescriptor> r23 = new ArrayList();
        Iterator<T> r24 = r22.iterator();
        int r25 = 0;
    L25:
        if (r24.hasNext() == false) goto L33;
        Object r26 = r24.next();
        int r27 = r25 + 1;
        if (r25 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        ReceiverParameterDescriptor r28 = toContextReceiver((ProtoBuf.Type) r26, r16, r14, r25);
        if (r28 == null) goto L32;
        r23.add(r28);
    L32:
        r25 = r27;
        goto L25
    L33:
        List<TypeParameterDescriptor> r29 = r16.getTypeDeserializer().getOwnTypeParameters();
        List<ValueParameterDescriptor> r30 = r16.getMemberDeserializer().valueParameters(r32.getValueParameterList(), r32, AnnotatedCallableKind.FUNCTION);
        KotlinType r31 = r16.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(r32, this.f18755c.getTypeTable()));
        ProtoEnumFlags r33 = ProtoEnumFlags.INSTANCE;
        initializeWithCoroutinesExperimentalityStatus(r14, r20, r21, r23, r29, r30, r31, r33.modality(Flags.MODALITY.get(r10)), ProtoEnumFlagsUtilsKt.descriptorVisibility(r33, Flags.VISIBILITY.get(r10)), MapsKt.emptyMap());
        r14.setOperator(Flags.IS_OPERATOR.get(r10).booleanValue());
        r14.setInfix(Flags.IS_INFIX.get(r10).booleanValue());
        r14.setExternal(Flags.IS_EXTERNAL_FUNCTION.get(r10).booleanValue());
        r14.setInline(Flags.IS_INLINE.get(r10).booleanValue());
        r14.setTailrec(Flags.IS_TAILREC.get(r10).booleanValue());
        r14.setSuspend(Flags.IS_SUSPEND.get(r10).booleanValue());
        r14.setExpect(Flags.IS_EXPECT_FUNCTION.get(r10).booleanValue());
        r14.setHasStableParameterNames(!Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES.get(r10).booleanValue());
        Pair<CallableDescriptor.UserDataKey<?>, Object> r34 = this.f18755c.getComponents().getContractDeserializer().deserializeContractFromFunction(r32, r14, this.f18755c.getTypeTable(), r16.getTypeDeserializer());
        if (r34 == null) goto L36;
        r14.putInUserDataMap(r34.getFirst(), r34.getSecond());
    L36:
        return r14;
    L22:
        r19 = null;
        goto L21
    L15:
        r13 = this.f18755c.getVersionRequirementTable();
        goto L16
    L10:
        r12 = Annotations.Companion.getEMPTY();
        goto L12
    L6:
        r5 = loadOldFlags(r32.getOldFlags());
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PropertyDescriptor loadProperty(ProtoBuf.Property r35) {
        Intrinsics.checkNotNullParameter(r35, "proto");
        if (r35.hasFlags() == false) goto L6;
        int r5 = r35.getFlags();
    L5:
        int r10 = r5;
        DeclarationDescriptor r11 = this.f18755c.getContainingDeclaration();
        Annotations r12 = getAnnotations(r35, r10, AnnotatedCallableKind.PROPERTY);
        ProtoEnumFlags r13 = ProtoEnumFlags.INSTANCE;
        DeserializedPropertyDescriptor r14 = new DeserializedPropertyDescriptor(r11, null, r12, r13.modality(Flags.MODALITY.get(r10)), ProtoEnumFlagsUtilsKt.descriptorVisibility(r13, Flags.VISIBILITY.get(r10)), Flags.IS_VAR.get(r10).booleanValue(), NameResolverUtilKt.getName(this.f18755c.getNameResolver(), r35.getName()), ProtoEnumFlagsUtilsKt.memberKind(r13, Flags.MEMBER_KIND.get(r10)), Flags.IS_LATEINIT.get(r10).booleanValue(), Flags.IS_CONST.get(r10).booleanValue(), Flags.IS_EXTERNAL_PROPERTY.get(r10).booleanValue(), Flags.IS_DELEGATED.get(r10).booleanValue(), Flags.IS_EXPECT_PROPERTY.get(r10).booleanValue(), r35, this.f18755c.getNameResolver(), this.f18755c.getTypeTable(), this.f18755c.getVersionRequirementTable(), this.f18755c.getContainerSource());
        DeserializationContext r15 = DeserializationContext.childContext$default(this.f18755c, r14, r35.getTypeParameterList(), null, null, null, null, 60, null);
        boolean r16 = Flags.HAS_GETTER.get(r10).booleanValue();
        if (r16 == true) goto L10;
    L12:
        final ProtoBuf.Property r17 = r35;
        Annotations r18 = Annotations.Companion.getEMPTY();
    L13:
        KotlinType r19 = r15.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(r17, this.f18755c.getTypeTable()));
        List<TypeParameterDescriptor> r20 = r15.getTypeDeserializer().getOwnTypeParameters();
        ReceiverParameterDescriptor r21 = getDispatchReceiverParameter();
        ProtoBuf.Type r22 = ProtoTypeTableUtilKt.receiverType(r17, this.f18755c.getTypeTable());
        ClassKind r110 = null;
        if (r22 == null) goto L18;
        KotlinType r23 = r15.getTypeDeserializer().type(r22);
        if (r23 == null) goto L18;
        DeserializedPropertyDescriptor r111 = r14;
        ReceiverParameterDescriptor r24 = DescriptorFactory.createExtensionReceiverParameterForCallable(r111, r23, r18);
    L19:
        List<ProtoBuf.Type> r25 = ProtoTypeTableUtilKt.contextReceiverTypes(r17, this.f18755c.getTypeTable());
        ArrayList r26 = new ArrayList(CollectionsKt.h(r25));
        Iterator<T> r27 = r25.iterator();
        int r112 = 0;
    L21:
        if (r27.hasNext() == false) goto L26;
        Object r113 = r27.next();
        int r114 = r112 + 1;
        if (r112 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        r26.add(toContextReceiver((ProtoBuf.Type) r113, r15, r111, r112));
        r112 = r114;
        goto L21
    L26:
        r111.setType(r19, r20, r21, r24, r26);
        boolean r28 = Flags.HAS_ANNOTATIONS.get(r10).booleanValue();
        Flags.FlagField<ProtoBuf.Visibility> r115 = Flags.VISIBILITY;
        ProtoBuf.Visibility r29 = r115.get(r10);
        Flags.FlagField<ProtoBuf.Modality> r116 = Flags.MODALITY;
        int r117 = Flags.getAccessorFlags(r28, r29, r116.get(r10), false, false, false);
        if (r16 == true) goto L29;
        r15 = r15;
        r116 = r116;
        r115 = r115;
        final DeserializedPropertyDescriptor r30 = r111;
        PropertyGetterDescriptorImpl r118 = null;
    L39:
        if (Flags.HAS_SETTER.get(r10).booleanValue() == true) goto L41;
        PropertySetterDescriptorImpl r119 = null;
    L49:
        if (Flags.HAS_CONSTANT.get(r10).booleanValue() == false) goto L51;
        r30.setCompileTimeInitializerFactory(new AnonymousClass4(this, r17, r30));
    L51:
        DeclarationDescriptor r31 = this.f18755c.getContainingDeclaration();
        if ((r31 instanceof ClassDescriptor) == false) goto L54;
        ClassDescriptor r32 = (ClassDescriptor) r31;
    L55:
        if (r32 == null) goto L58;
        r110 = r32.getKind();
    L58:
        if (r110 != ClassKind.ANNOTATION_CLASS) goto L60;
        r30.setCompileTimeInitializerFactory(new AnonymousClass5(this, r17, r30));
    L60:
        r30.initialize(r118, r119, new FieldDescriptorImpl(getPropertyFieldAnnotations(r17, false), r30), new FieldDescriptorImpl(getPropertyFieldAnnotations(r17, true), r30));
        return r30;
    L54:
        r32 = null;
        goto L55
    L41:
        if (r35.hasSetterFlags() == false) goto L43;
        r117 = r35.getSetterFlags();
    L43:
        int r33 = r117;
        boolean r34 = Flags.IS_NOT_DEFAULT.get(r33).booleanValue();
        boolean r120 = Flags.IS_EXTERNAL_ACCESSOR.get(r33).booleanValue();
        boolean r121 = Flags.IS_INLINE_ACCESSOR.get(r33).booleanValue();
        AnnotatedCallableKind r122 = AnnotatedCallableKind.PROPERTY_SETTER;
        Annotations r36 = getAnnotations(r17, r33, r122);
        if (r34 == false) goto L46;
        ProtoEnumFlags r37 = ProtoEnumFlags.INSTANCE;
        PropertySetterDescriptorImpl r123 = new PropertySetterDescriptorImpl(r30, r36, r37.modality(r116.get(r33)), ProtoEnumFlagsUtilsKt.descriptorVisibility(r37, r115.get(r33)), !r34, r120, r121, r30.getKind(), null, SourceElement.NO_SOURCE);
        r123.initialize((ValueParameterDescriptor) CollectionsKt.single(DeserializationContext.childContext$default(r15, r123, CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer().valueParameters(CollectionsKt.listOf(r35.getSetterValueParameter()), r17, r122)));
        r119 = r123;
        goto L49
    L46:
        r119 = DescriptorFactory.createDefaultSetter(r30, r36, Annotations.Companion.getEMPTY());
        goto L49
    L29:
        if (r35.hasGetterFlags() == false) goto L31;
        int r38 = r35.getGetterFlags();
    L32:
        boolean r39 = Flags.IS_NOT_DEFAULT.get(r38).booleanValue();
        boolean r124 = Flags.IS_EXTERNAL_ACCESSOR.get(r38).booleanValue();
        boolean r125 = Flags.IS_INLINE_ACCESSOR.get(r38).booleanValue();
        Annotations r40 = getAnnotations(r17, r38, AnnotatedCallableKind.PROPERTY_GETTER);
        if (r39 == false) goto L35;
        ProtoEnumFlags r41 = ProtoEnumFlags.INSTANCE;
        DeserializedPropertyDescriptor r42 = r111;
        PropertyGetterDescriptorImpl r43 = new PropertyGetterDescriptorImpl(r111, r40, r41.modality(r116.get(r38)), ProtoEnumFlagsUtilsKt.descriptorVisibility(r41, r115.get(r38)), !r39, r124, r125, r111.getKind(), null, SourceElement.NO_SOURCE);
    L36:
        r43.initialize(r42.getReturnType());
        r118 = r43;
        r30 = r42;
        goto L39
    L35:
        DeserializedPropertyDescriptor r44 = r111;
        r43 = DescriptorFactory.createDefaultGetter(r44, r40);
        r42 = r44;
        goto L36
    L31:
        r38 = r117;
    L18:
        r111 = r14;
        r24 = null;
        goto L19
    L10:
        if (ProtoTypeTableUtilKt.hasReceiver(r35) == false) goto L12;
        r17 = r35;
        r18 = getReceiverParameterAnnotations(r17, AnnotatedCallableKind.PROPERTY_GETTER);
        goto L13
    L6:
        r5 = loadOldFlags(r35.getOldFlags());
        goto L5
    }

    public final TypeAliasDescriptor loadTypeAlias(ProtoBuf.TypeAlias r23) {
        Intrinsics.checkNotNullParameter(r23, "proto");
        Annotations.Companion r5 = Annotations.Companion;
        List<ProtoBuf.Annotation> r10 = r23.getAnnotationList();
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ProtoBuf.Annotation r13 = (ProtoBuf.Annotation) r12.next();
        r11.add(this.annotationDeserializer.deserializeAnnotation(r13, this.f18755c.getNameResolver()));
        goto L4
    L6:
        Annotations r14 = r5.create(r11);
        DescriptorVisibility r15 = ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(r23.getFlags()));
        DeserializedTypeAliasDescriptor r16 = new DeserializedTypeAliasDescriptor(this.f18755c.getStorageManager(), this.f18755c.getContainingDeclaration(), r14, NameResolverUtilKt.getName(this.f18755c.getNameResolver(), r23.getName()), r15, r23, this.f18755c.getNameResolver(), this.f18755c.getTypeTable(), this.f18755c.getVersionRequirementTable(), this.f18755c.getContainerSource());
        DeserializationContext r17 = DeserializationContext.childContext$default(this.f18755c, r16, r23.getTypeParameterList(), null, null, null, null, 60, null);
        r16.initialize(r17.getTypeDeserializer().getOwnTypeParameters(), r17.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.underlyingType(r23, this.f18755c.getTypeTable()), false), r17.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.expandedType(r23, this.f18755c.getTypeTable()), false));
        return r16;
    }
}
