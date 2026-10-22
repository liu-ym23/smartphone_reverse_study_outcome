package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
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
public final class MemberDeserializer {
    private final AnnotationDeserializer annotationDeserializer;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DeserializationContext f10218c;

    public MemberDeserializer(DeserializationContext r10) {
        Intrinsics.checkNotNullParameter(r10, "c");
        this.f10218c = r10;
        this.annotationDeserializer = new AnnotationDeserializer(r10.getComponents().getModuleDescriptor(), r10.getComponents().getNotFoundClasses());
    }

    public static final /* synthetic */ ProtoContainer access$asProtoContainer(MemberDeserializer r10, DeclarationDescriptor r11) {
        return r10.asProtoContainer(r11);
    }

    public static final /* synthetic */ DeserializationContext access$getC$p(MemberDeserializer r10) {
        return r10.f10218c;
    }

    private final ProtoContainer asProtoContainer(DeclarationDescriptor r10) {
        if ((r10 instanceof PackageFragmentDescriptor) == false) goto L6;
        return new ProtoContainer.Package(((PackageFragmentDescriptor) r10).getFqName(), this.f10218c.getNameResolver(), this.f10218c.getTypeTable(), this.f10218c.getContainerSource());
    L6:
        if ((r10 instanceof DeserializedClassDescriptor) == true) goto L11;
        return null;
    L11:
        return ((DeserializedClassDescriptor) r10).getThisAsProtoContainer$deserialization();
    }

    private final Annotations getAnnotations(final MessageLite r10, int r11, final AnnotatedCallableKind r12) {
        if (Flags.HAS_ANNOTATIONS.get(r11).booleanValue() == true) goto L7;
        return Annotations.Companion.getEMPTY();
    L7:
        return new NonEmptyDeserializedAnnotations(this.f10218c.getStorageManager(), new AnonymousClass1(this, r10, r12));
    }

    private final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        DeclarationDescriptor r10 = this.f10218c.getContainingDeclaration();
        if ((r10 instanceof ClassDescriptor) == false) goto L5;
        ClassDescriptor r11 = (ClassDescriptor) r10;
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.getThisAsReceiverParameter();
    L5:
        r11 = null;
        goto L6
    }

    private final Annotations getPropertyFieldAnnotations(final ProtoBuf.Property r10, final boolean r11) {
        if (Flags.HAS_ANNOTATIONS.get(r10.getFlags()).booleanValue() == true) goto L7;
        return Annotations.Companion.getEMPTY();
    L7:
        return new NonEmptyDeserializedAnnotations(this.f10218c.getStorageManager(), new C04291(this, r11, r10));
    }

    private final Annotations getReceiverParameterAnnotations(final MessageLite r10, final AnnotatedCallableKind r11) {
        return new DeserializedAnnotations(this.f10218c.getStorageManager(), new C04301(this, r10, r11));
    }

    private final void initializeWithCoroutinesExperimentalityStatus(DeserializedSimpleFunctionDescriptor r10, ReceiverParameterDescriptor r11, ReceiverParameterDescriptor r12, List<? extends ReceiverParameterDescriptor> r13, List<? extends TypeParameterDescriptor> r14, List<? extends ValueParameterDescriptor> r15, KotlinType r16, Modality r17, DescriptorVisibility r18, Map<? extends CallableDescriptor.UserDataKey<?>, ?> r19) {
        r10.initialize(r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    private final int loadOldFlags(int r10) {
        return (r10 & 63) + ((r10 >> 8) << 6);
    }

    private final ReceiverParameterDescriptor toContextReceiver(ProtoBuf.Type r10, DeserializationContext r11, CallableDescriptor r12) {
        return DescriptorFactory.createContextReceiverParameterForCallable(r12, r11.getTypeDeserializer().type(r10), Annotations.Companion.getEMPTY());
    }

    private final List<ValueParameterDescriptor> valueParameters(List<ProtoBuf.ValueParameter> r26, final MessageLite r27, final AnnotatedCallableKind r28) {
        DeclarationDescriptor r10 = this.f10218c.getContainingDeclaration();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        CallableDescriptor r20 = (CallableDescriptor) r10;
        DeclarationDescriptor r11 = r20.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r11, "callableDescriptor.containingDeclaration");
        final ProtoContainer r21 = asProtoContainer(r11);
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
        Iterator<T> r22 = r26.iterator();
        int r12 = 0;
    L4:
        if (r22.hasNext() == false) goto L23;
        Object r13 = r22.next();
        int r24 = r12 + 1;
        if (r12 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        final ProtoBuf.ValueParameter r14 = (ProtoBuf.ValueParameter) r13;
        if (r14.hasFlags() == false) goto L11;
        int r16 = r14.getFlags();
    L12:
        if (r21 == null) goto L16;
        Boolean r17 = Flags.HAS_ANNOTATIONS.get(r16);
        Intrinsics.checkNotNullExpressionValue(r17, "HAS_ANNOTATIONS.get(flags)");
        if (r17.booleanValue() == false) goto L16;
        final int r18 = r12;
        Annotations r19 = new NonEmptyDeserializedAnnotations(this.f10218c.getStorageManager(), new MemberDeserializer$valueParameters$1$annotations$1(this, r21, r27, r28, r18, r14));
    L17:
        Name r110 = NameResolverUtilKt.getName(this.f10218c.getNameResolver(), r14.getName());
        KotlinType r111 = this.f10218c.getTypeDeserializer().type(ProtoTypeTableUtilKt.type(r14, this.f10218c.getTypeTable()));
        Boolean r23 = Flags.DECLARES_DEFAULT_VALUE.get(r16);
        Intrinsics.checkNotNullExpressionValue(r23, "DECLARES_DEFAULT_VALUE.get(flags)");
        boolean r25 = r23.booleanValue();
        Boolean r29 = Flags.IS_CROSSINLINE.get(r16);
        Intrinsics.checkNotNullExpressionValue(r29, "IS_CROSSINLINE.get(flags)");
        boolean r112 = r29.booleanValue();
        Boolean r30 = Flags.IS_NOINLINE.get(r16);
        Intrinsics.checkNotNullExpressionValue(r30, "IS_NOINLINE.get(flags)");
        boolean r113 = r30.booleanValue();
        ProtoBuf.Type r31 = ProtoTypeTableUtilKt.varargElementType(r14, this.f10218c.getTypeTable());
        if (r31 == null) goto L20;
        KotlinType r32 = this.f10218c.getTypeDeserializer().type(r31);
    L21:
        KotlinType r114 = r32;
        SourceElement r33 = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(r33, "NO_SOURCE");
        ArrayList r34 = r15;
        r34.add(new ValueParameterDescriptorImpl(r20, null, r12, r19, r110, r111, r25, r112, r113, r114, r33));
        r15 = r34;
        r12 = r24;
        goto L4
    L20:
        r32 = null;
    L16:
        r19 = Annotations.Companion.getEMPTY();
        goto L17
    L11:
        r16 = 0;
        goto L12
    L23:
        return CollectionsKt.toList(r15);
    }

    public final ClassConstructorDescriptor loadConstructor(ProtoBuf.Constructor r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r21, "proto");
        DeclarationDescriptor r10 = this.f10218c.getContainingDeclaration();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        ClassDescriptor r16 = (ClassDescriptor) r10;
        int r11 = r21.getFlags();
        AnnotatedCallableKind r13 = AnnotatedCallableKind.FUNCTION;
        DeserializedClassConstructorDescriptor r14 = new DeserializedClassConstructorDescriptor(r16, null, getAnnotations(r21, r11, r13), r22, CallableMemberDescriptor.Kind.DECLARATION, r21, this.f10218c.getNameResolver(), this.f10218c.getTypeTable(), this.f10218c.getVersionRequirementTable(), this.f10218c.getContainerSource(), null, 1024, null);
        MemberDeserializer r12 = DeserializationContext.childContext$default(this.f10218c, r14, CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer();
        List<ProtoBuf.ValueParameter> r15 = r21.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(r15, "proto.valueParameterList");
        r14.initialize(r12.valueParameters(r15, r21, r13), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(r21.getFlags())));
        r14.setReturnType(r16.getDefaultType());
        r14.setExpect(r16.isExpect());
        r14.setHasStableParameterNames(!Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES.get(r21.getFlags()).booleanValue());
        return r14;
    }

    public final SimpleFunctionDescriptor loadFunction(ProtoBuf.Function r32) {
        Intrinsics.checkNotNullParameter(r32, "proto");
        if (r32.hasFlags() == false) goto L5;
        int r10 = r32.getFlags();
    L6:
        int r11 = r10;
        AnnotatedCallableKind r12 = AnnotatedCallableKind.FUNCTION;
        Annotations r15 = getAnnotations(r32, r11, r12);
        if (ProtoTypeTableUtilKt.hasReceiver(r32) == false) goto L9;
        Annotations r13 = getReceiverParameterAnnotations(r32, r12);
    L11:
        if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(this.f10218c.getContainingDeclaration()).child(NameResolverUtilKt.getName(this.f10218c.getNameResolver(), r32.getName())), SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME) == false) goto L13;
        VersionRequirementTable r14 = VersionRequirementTable.Companion.getEMPTY();
    L14:
        DeserializedSimpleFunctionDescriptor r16 = new DeserializedSimpleFunctionDescriptor(this.f10218c.getContainingDeclaration(), null, r15, NameResolverUtilKt.getName(this.f10218c.getNameResolver(), r32.getName()), ProtoEnumFlagsUtilsKt.memberKind(ProtoEnumFlags.INSTANCE, Flags.MEMBER_KIND.get(r11)), r32, this.f10218c.getNameResolver(), this.f10218c.getTypeTable(), r14, this.f10218c.getContainerSource(), null, 1024, null);
        DeserializationContext r17 = this.f10218c;
        List<ProtoBuf.TypeParameter> r18 = r32.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(r18, "proto.typeParameterList");
        DeserializationContext r19 = DeserializationContext.childContext$default(r17, r16, r18, null, null, null, null, 60, null);
        ProtoBuf.Type r20 = ProtoTypeTableUtilKt.receiverType(r32, this.f10218c.getTypeTable());
        if (r20 == null) goto L19;
        KotlinType r21 = r19.getTypeDeserializer().type(r20);
        if (r21 == null) goto L19;
        ReceiverParameterDescriptor r22 = DescriptorFactory.createExtensionReceiverParameterForCallable(r16, r21, r13);
    L20:
        ReceiverParameterDescriptor r23 = r22;
        ReceiverParameterDescriptor r24 = getDispatchReceiverParameter();
        List<ProtoBuf.Type> r25 = ProtoTypeTableUtilKt.contextReceiverTypes(r32, this.f10218c.getTypeTable());
        List<? extends ReceiverParameterDescriptor> r26 = new ArrayList();
        Iterator<T> r27 = r25.iterator();
    L22:
        if (r27.hasNext() == false) goto L26;
        ReceiverParameterDescriptor r28 = toContextReceiver((ProtoBuf.Type) r27.next(), r19, r16);
        if (r28 == null) goto L22;
        r26.add(r28);
        goto L22
    L26:
        List<TypeParameterDescriptor> r29 = r19.getTypeDeserializer().getOwnTypeParameters();
        MemberDeserializer r30 = r19.getMemberDeserializer();
        List<ProtoBuf.ValueParameter> r31 = r32.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(r31, "proto.valueParameterList");
        List<ValueParameterDescriptor> r33 = r30.valueParameters(r31, r32, AnnotatedCallableKind.FUNCTION);
        KotlinType r34 = r19.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(r32, this.f10218c.getTypeTable()));
        ProtoEnumFlags r35 = ProtoEnumFlags.INSTANCE;
        initializeWithCoroutinesExperimentalityStatus(r16, r23, r24, r26, r29, r33, r34, r35.modality(Flags.MODALITY.get(r11)), ProtoEnumFlagsUtilsKt.descriptorVisibility(r35, Flags.VISIBILITY.get(r11)), MapsKt.emptyMap());
        Boolean r36 = Flags.IS_OPERATOR.get(r11);
        Intrinsics.checkNotNullExpressionValue(r36, "IS_OPERATOR.get(flags)");
        r16.setOperator(r36.booleanValue());
        Boolean r37 = Flags.IS_INFIX.get(r11);
        Intrinsics.checkNotNullExpressionValue(r37, "IS_INFIX.get(flags)");
        r16.setInfix(r37.booleanValue());
        Boolean r38 = Flags.IS_EXTERNAL_FUNCTION.get(r11);
        Intrinsics.checkNotNullExpressionValue(r38, "IS_EXTERNAL_FUNCTION.get(flags)");
        r16.setExternal(r38.booleanValue());
        Boolean r39 = Flags.IS_INLINE.get(r11);
        Intrinsics.checkNotNullExpressionValue(r39, "IS_INLINE.get(flags)");
        r16.setInline(r39.booleanValue());
        Boolean r40 = Flags.IS_TAILREC.get(r11);
        Intrinsics.checkNotNullExpressionValue(r40, "IS_TAILREC.get(flags)");
        r16.setTailrec(r40.booleanValue());
        Boolean r41 = Flags.IS_SUSPEND.get(r11);
        Intrinsics.checkNotNullExpressionValue(r41, "IS_SUSPEND.get(flags)");
        r16.setSuspend(r41.booleanValue());
        Boolean r42 = Flags.IS_EXPECT_FUNCTION.get(r11);
        Intrinsics.checkNotNullExpressionValue(r42, "IS_EXPECT_FUNCTION.get(flags)");
        r16.setExpect(r42.booleanValue());
        r16.setHasStableParameterNames(!Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES.get(r11).booleanValue());
        Pair<CallableDescriptor.UserDataKey<?>, Object> r43 = this.f10218c.getComponents().getContractDeserializer().deserializeContractFromFunction(r32, r16, this.f10218c.getTypeTable(), r19.getTypeDeserializer());
        if (r43 == null) goto L29;
        r16.putInUserDataMap(r43.getFirst(), r43.getSecond());
    L29:
        return r16;
    L19:
        r22 = null;
        goto L20
    L13:
        r14 = this.f10218c.getVersionRequirementTable();
        goto L14
    L9:
        r13 = Annotations.Companion.getEMPTY();
        goto L11
    L5:
        r10 = loadOldFlags(r32.getOldFlags());
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PropertyDescriptor loadProperty(ProtoBuf.Property r30) {
        Intrinsics.checkNotNullParameter(r30, "proto");
        if (r30.hasFlags() == false) goto L5;
        int r10 = r30.getFlags();
    L6:
        int r14 = r10;
        DeclarationDescriptor r11 = this.f10218c.getContainingDeclaration();
        Annotations r12 = getAnnotations(r30, r14, AnnotatedCallableKind.PROPERTY);
        ProtoEnumFlags r13 = ProtoEnumFlags.INSTANCE;
        Modality r15 = r13.modality(Flags.MODALITY.get(r14));
        DescriptorVisibility r16 = ProtoEnumFlagsUtilsKt.descriptorVisibility(r13, Flags.VISIBILITY.get(r14));
        Boolean r17 = Flags.IS_VAR.get(r14);
        Intrinsics.checkNotNullExpressionValue(r17, "IS_VAR.get(flags)");
        boolean r18 = r17.booleanValue();
        Name r19 = NameResolverUtilKt.getName(this.f10218c.getNameResolver(), r30.getName());
        CallableMemberDescriptor.Kind r20 = ProtoEnumFlagsUtilsKt.memberKind(r13, Flags.MEMBER_KIND.get(r14));
        Boolean r110 = Flags.IS_LATEINIT.get(r14);
        Intrinsics.checkNotNullExpressionValue(r110, "IS_LATEINIT.get(flags)");
        boolean r111 = r110.booleanValue();
        Boolean r112 = Flags.IS_CONST.get(r14);
        Intrinsics.checkNotNullExpressionValue(r112, "IS_CONST.get(flags)");
        boolean r113 = r112.booleanValue();
        Boolean r114 = Flags.IS_EXTERNAL_PROPERTY.get(r14);
        Intrinsics.checkNotNullExpressionValue(r114, "IS_EXTERNAL_PROPERTY.get(flags)");
        boolean r115 = r114.booleanValue();
        Boolean r21 = Flags.IS_DELEGATED.get(r14);
        Intrinsics.checkNotNullExpressionValue(r21, "IS_DELEGATED.get(flags)");
        boolean r116 = r21.booleanValue();
        Boolean r22 = Flags.IS_EXPECT_PROPERTY.get(r14);
        Intrinsics.checkNotNullExpressionValue(r22, "IS_EXPECT_PROPERTY.get(flags)");
        DeserializedPropertyDescriptor r117 = new DeserializedPropertyDescriptor(r11, null, r12, r15, r16, r18, r19, r20, r111, r113, r115, r116, r22.booleanValue(), r30, this.f10218c.getNameResolver(), this.f10218c.getTypeTable(), this.f10218c.getVersionRequirementTable(), this.f10218c.getContainerSource());
        DeserializationContext r23 = this.f10218c;
        List<ProtoBuf.TypeParameter> r24 = r30.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(r24, "proto.typeParameterList");
        DeserializationContext r118 = DeserializationContext.childContext$default(r23, r117, r24, null, null, null, null, 60, null);
        Boolean r25 = Flags.HAS_GETTER.get(r14);
        Intrinsics.checkNotNullExpressionValue(r25, "HAS_GETTER.get(flags)");
        boolean r26 = r25.booleanValue();
        if (r26 == true) goto L9;
    L11:
        ProtoBuf.Property r119 = r30;
        Annotations r27 = Annotations.Companion.getEMPTY();
    L12:
        KotlinType r28 = r118.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(r119, this.f10218c.getTypeTable()));
        List<TypeParameterDescriptor> r29 = r118.getTypeDeserializer().getOwnTypeParameters();
        ReceiverParameterDescriptor r31 = getDispatchReceiverParameter();
        ProtoBuf.Type r32 = ProtoTypeTableUtilKt.receiverType(r119, this.f10218c.getTypeTable());
        ClassKind r120 = null;
        if (r32 == null) goto L17;
        KotlinType r33 = r118.getTypeDeserializer().type(r32);
        if (r33 == null) goto L17;
        DeserializedPropertyDescriptor r121 = r117;
        ReceiverParameterDescriptor r34 = DescriptorFactory.createExtensionReceiverParameterForCallable(r121, r33, r27);
    L18:
        List<ProtoBuf.Type> r35 = ProtoTypeTableUtilKt.contextReceiverTypes(r119, this.f10218c.getTypeTable());
        ArrayList r36 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r35, 10));
        Iterator<T> r37 = r35.iterator();
    L20:
        if (r37.hasNext() == false) goto L22;
        r36.add(toContextReceiver((ProtoBuf.Type) r37.next(), r118, r121));
        goto L20
    L22:
        r121.setType(r28, r29, r31, r34, r36);
        Boolean r38 = Flags.HAS_ANNOTATIONS.get(r14);
        Intrinsics.checkNotNullExpressionValue(r38, "HAS_ANNOTATIONS.get(flags)");
        boolean r210 = r38.booleanValue();
        Flags.FlagField<ProtoBuf.Visibility> r122 = Flags.VISIBILITY;
        ProtoBuf.Visibility r211 = r122.get(r14);
        Flags.FlagField<ProtoBuf.Modality> r123 = Flags.MODALITY;
        int r124 = Flags.getAccessorFlags(r210, r211, r123.get(r14), false, false, false);
        if (r26 == true) goto L25;
        r122 = r122;
        r118 = r118;
        r123 = r123;
        PropertyGetterDescriptorImpl r125 = null;
    L34:
        Boolean r39 = Flags.HAS_SETTER.get(r14);
        Intrinsics.checkNotNullExpressionValue(r39, "HAS_SETTER.get(flags)");
        if (r39.booleanValue() == true) goto L37;
        final DeserializedPropertyDescriptor r40 = r121;
        final ProtoBuf.Property r41 = r119;
        boolean r42 = true;
        PropertySetterDescriptorImpl r43 = null;
    L44:
        Boolean r44 = Flags.HAS_CONSTANT.get(r14);
        Intrinsics.checkNotNullExpressionValue(r44, "HAS_CONSTANT.get(flags)");
        if (r44.booleanValue() == false) goto L47;
        r40.setCompileTimeInitializerFactory(new AnonymousClass4(this, r41, r40));
    L47:
        DeclarationDescriptor r45 = this.f10218c.getContainingDeclaration();
        if ((r45 instanceof ClassDescriptor) == false) goto L50;
        ClassDescriptor r46 = (ClassDescriptor) r45;
    L51:
        if (r46 == null) goto L54;
        r120 = r46.getKind();
    L54:
        if (r120 != ClassKind.ANNOTATION_CLASS) goto L56;
        r40.setCompileTimeInitializerFactory(new AnonymousClass5(this, r41, r40));
    L56:
        r40.initialize(r125, r43, new FieldDescriptorImpl(getPropertyFieldAnnotations(r41, false), r40), new FieldDescriptorImpl(getPropertyFieldAnnotations(r41, r42), r40));
        return r40;
    L50:
        r46 = null;
        goto L51
    L37:
        if (r30.hasSetterFlags() == false) goto L39;
        r124 = r30.getSetterFlags();
    L39:
        int r47 = r124;
        Boolean r48 = Flags.IS_NOT_DEFAULT.get(r47);
        Intrinsics.checkNotNullExpressionValue(r48, "IS_NOT_DEFAULT.get(setterFlags)");
        boolean r49 = r48.booleanValue();
        Boolean r50 = Flags.IS_EXTERNAL_ACCESSOR.get(r47);
        Intrinsics.checkNotNullExpressionValue(r50, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
        boolean r51 = r50.booleanValue();
        Boolean r52 = Flags.IS_INLINE_ACCESSOR.get(r47);
        Intrinsics.checkNotNullExpressionValue(r52, "IS_INLINE_ACCESSOR.get(setterFlags)");
        boolean r53 = r52.booleanValue();
        AnnotatedCallableKind r126 = AnnotatedCallableKind.PROPERTY_SETTER;
        Annotations r54 = getAnnotations(r119, r47, r126);
        if (r49 == false) goto L42;
        ProtoEnumFlags r55 = ProtoEnumFlags.INSTANCE;
        PropertySetterDescriptorImpl r56 = new PropertySetterDescriptorImpl(r121, r54, r55.modality(r123.get(r47)), ProtoEnumFlagsUtilsKt.descriptorVisibility(r55, r122.get(r47)), !r49, r51, r53, r121.getKind(), null, SourceElement.NO_SOURCE);
        r42 = true;
        r40 = r121;
        r41 = r119;
        r56.initialize((ValueParameterDescriptor) CollectionsKt.single(DeserializationContext.childContext$default(r118, r56, CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer().valueParameters(CollectionsKt.listOf(r30.getSetterValueParameter()), r41, r126)));
        r43 = r56;
        goto L44
    L42:
        DeserializedPropertyDescriptor r57 = r121;
        r41 = r119;
        r42 = true;
        r43 = DescriptorFactory.createDefaultSetter(r57, r54, Annotations.Companion.getEMPTY());
        Intrinsics.checkNotNullExpressionValue(r43, "{\n                Descri…          )\n            }");
        r40 = r57;
        goto L44
    L25:
        if (r30.hasGetterFlags() == false) goto L27;
        int r58 = r30.getGetterFlags();
    L28:
        Boolean r59 = Flags.IS_NOT_DEFAULT.get(r58);
        Intrinsics.checkNotNullExpressionValue(r59, "IS_NOT_DEFAULT.get(getterFlags)");
        boolean r60 = r59.booleanValue();
        Boolean r61 = Flags.IS_EXTERNAL_ACCESSOR.get(r58);
        Intrinsics.checkNotNullExpressionValue(r61, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
        boolean r62 = r61.booleanValue();
        Boolean r63 = Flags.IS_INLINE_ACCESSOR.get(r58);
        Intrinsics.checkNotNullExpressionValue(r63, "IS_INLINE_ACCESSOR.get(getterFlags)");
        boolean r64 = r63.booleanValue();
        Annotations r65 = getAnnotations(r119, r58, AnnotatedCallableKind.PROPERTY_GETTER);
        if (r60 == false) goto L31;
        ProtoEnumFlags r66 = ProtoEnumFlags.INSTANCE;
        PropertyGetterDescriptorImpl r67 = new PropertyGetterDescriptorImpl(r121, r65, r66.modality(r123.get(r58)), ProtoEnumFlagsUtilsKt.descriptorVisibility(r66, r122.get(r58)), !r60, r62, r64, r121.getKind(), null, SourceElement.NO_SOURCE);
    L32:
        r67.initialize(r121.getReturnType());
        r125 = r67;
        goto L34
    L31:
        r67 = DescriptorFactory.createDefaultGetter(r121, r65);
        Intrinsics.checkNotNullExpressionValue(r67, "{\n                Descri…nnotations)\n            }");
        goto L32
    L27:
        r58 = r124;
    L17:
        r121 = r117;
        r34 = null;
        goto L18
    L9:
        if (ProtoTypeTableUtilKt.hasReceiver(r30) == false) goto L11;
        r119 = r30;
        r27 = getReceiverParameterAnnotations(r119, AnnotatedCallableKind.PROPERTY_GETTER);
        goto L12
    L5:
        r10 = loadOldFlags(r30.getOldFlags());
        goto L6
    }

    public final TypeAliasDescriptor loadTypeAlias(ProtoBuf.TypeAlias r23) {
        Intrinsics.checkNotNullParameter(r23, "proto");
        Annotations.Companion r10 = Annotations.Companion;
        List<ProtoBuf.Annotation> r11 = r23.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(r11, "proto.annotationList");
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        ProtoBuf.Annotation r14 = (ProtoBuf.Annotation) r13.next();
        AnnotationDeserializer r15 = this.annotationDeserializer;
        Intrinsics.checkNotNullExpressionValue(r14, "it");
        r12.add(r15.deserializeAnnotation(r14, this.f10218c.getNameResolver()));
        goto L4
    L6:
        Annotations r16 = r10.create(r12);
        DescriptorVisibility r17 = ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(r23.getFlags()));
        DeserializedTypeAliasDescriptor r18 = new DeserializedTypeAliasDescriptor(this.f10218c.getStorageManager(), this.f10218c.getContainingDeclaration(), r16, NameResolverUtilKt.getName(this.f10218c.getNameResolver(), r23.getName()), r17, r23, this.f10218c.getNameResolver(), this.f10218c.getTypeTable(), this.f10218c.getVersionRequirementTable(), this.f10218c.getContainerSource());
        DeserializationContext r19 = this.f10218c;
        List<ProtoBuf.TypeParameter> r20 = r23.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(r20, "proto.typeParameterList");
        DeserializationContext r21 = DeserializationContext.childContext$default(r19, r18, r20, null, null, null, null, 60, null);
        r18.initialize(r21.getTypeDeserializer().getOwnTypeParameters(), r21.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.underlyingType(r23, this.f10218c.getTypeTable()), false), r21.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.expandedType(r23, this.f10218c.getTypeTable()), false));
        return r18;
    }
}
