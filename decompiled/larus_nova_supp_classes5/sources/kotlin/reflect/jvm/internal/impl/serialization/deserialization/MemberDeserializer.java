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
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class MemberDeserializer {
    private final AnnotationDeserializer annotationDeserializer;
    private final DeserializationContext c;

    public static /* synthetic */ NullableLazyValue accessor$MemberDeserializer$lambda0(MemberDeserializer r0, ProtoBuf$Property r1, DeserializedPropertyDescriptor r2) {
        return loadProperty$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ NullableLazyValue accessor$MemberDeserializer$lambda1(MemberDeserializer r0, ProtoBuf$Property r1, DeserializedPropertyDescriptor r2) {
        return loadProperty$lambda$5(r0, r1, r2);
    }

    public static /* synthetic */ List accessor$MemberDeserializer$lambda2(MemberDeserializer r0, MessageLite r1, AnnotatedCallableKind r2) {
        return getAnnotations$lambda$11(r0, r1, r2);
    }

    public static /* synthetic */ List accessor$MemberDeserializer$lambda3(MemberDeserializer r0, boolean r1, ProtoBuf$Property r2) {
        return getPropertyFieldAnnotations$lambda$13(r0, r1, r2);
    }

    public static /* synthetic */ List accessor$MemberDeserializer$lambda4(MemberDeserializer r0, MessageLite r1, AnnotatedCallableKind r2) {
        return getReceiverParameterAnnotations$lambda$15(r0, r1, r2);
    }

    public static /* synthetic */ List accessor$MemberDeserializer$lambda5(MemberDeserializer r0, ProtoContainer r1, MessageLite r2, AnnotatedCallableKind r3, int r4, ProtoBuf$ValueParameter r5) {
        return valueParameters$lambda$18$lambda$16(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ ConstantValue accessor$MemberDeserializer$lambda6(MemberDeserializer r0, ProtoBuf$Property r1, DeserializedPropertyDescriptor r2) {
        return loadProperty$lambda$3$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ ConstantValue accessor$MemberDeserializer$lambda7(MemberDeserializer r0, ProtoBuf$Property r1, DeserializedPropertyDescriptor r2) {
        return loadProperty$lambda$5$lambda$4(r0, r1, r2);
    }

    private final int loadOldFlags(int r2) {
        return (r2 & 63) + ((r2 >> 8) << 6);
    }

    private final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        DeclarationDescriptor r0 = this.c.getContainingDeclaration();
        if ((r0 instanceof ClassDescriptor) == false) goto L5;
        ClassDescriptor r1 = (ClassDescriptor) r0;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getThisAsReceiverParameter();
    L5:
        r1 = null;
        goto L6
    }

    public MemberDeserializer(DeserializationContext r3) {
        Intrinsics.checkNotNullParameter(r3, "c");
        this.c = r3;
        this.annotationDeserializer = new AnnotationDeserializer(r3.getComponents().getModuleDescriptor(), r3.getComponents().getNotFoundClasses());
    }

    private final ProtoContainer asProtoContainer(DeclarationDescriptor r5) {
        if ((r5 instanceof PackageFragmentDescriptor) == false) goto L6;
        return new ProtoContainer.Package(((PackageFragmentDescriptor) r5).getFqName(), this.c.getNameResolver(), this.c.getTypeTable(), this.c.getContainerSource());
    L6:
        if ((r5 instanceof DeserializedClassDescriptor) == true) goto L11;
        return null;
    L11:
        return ((DeserializedClassDescriptor) r5).getThisAsProtoContainer$deserialization();
    }

    public final SimpleFunctionDescriptor loadFunction(ProtoBuf$Function r32) {
        Intrinsics.checkNotNullParameter(r32, "proto");
        if (r32.hasFlags() == false) goto L5;
        int r0 = r32.getFlags();
    L6:
        int r9 = r0;
        AnnotatedCallableKind r1 = AnnotatedCallableKind.FUNCTION;
        Annotations r15 = getAnnotations(r32, r9, r1);
        if (ProtoTypeTableUtilKt.hasReceiver(r32) == false) goto L9;
        Annotations r2 = getReceiverParameterAnnotations(r32, r1);
    L11:
        if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(this.c.getContainingDeclaration()).child(NameResolverUtilKt.getName(this.c.getNameResolver(), r32.getName())), SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME) == false) goto L13;
        VersionRequirementTable r3 = VersionRequirementTable.Companion.getEMPTY();
    L14:
        DeserializedSimpleFunctionDescriptor r8 = new DeserializedSimpleFunctionDescriptor(this.c.getContainingDeclaration(), null, r15, NameResolverUtilKt.getName(this.c.getNameResolver(), r32.getName()), ProtoEnumFlagsUtilsKt.memberKind(ProtoEnumFlags.INSTANCE, Flags.MEMBER_KIND.get(r9)), r32, this.c.getNameResolver(), this.c.getTypeTable(), r3, this.c.getContainerSource(), null, 1024, null);
        DeserializationContext r12 = DeserializationContext.childContext$default(this.c, r8, r32.getTypeParameterList(), null, null, null, null, 60, null);
        ProtoBuf$Type r4 = ProtoTypeTableUtilKt.receiverType(r32, this.c.getTypeTable());
        if (r4 == null) goto L19;
        KotlinType r5 = r12.getTypeDeserializer().type(r4);
        if (r5 == null) goto L19;
        ReceiverParameterDescriptor r6 = DescriptorFactory.createExtensionReceiverParameterForCallable(r8, r5, r2);
    L20:
        ReceiverParameterDescriptor r7 = r6;
        ReceiverParameterDescriptor r10 = getDispatchReceiverParameter();
        List<ProtoBuf$Type> r11 = ProtoTypeTableUtilKt.contextReceiverTypes(r32, this.c.getTypeTable());
        List<? extends ReceiverParameterDescriptor> r13 = new ArrayList();
        Iterator<T> r14 = r11.iterator();
        int r16 = 0;
    L22:
        if (r14.hasNext() == false) goto L30;
        Object r17 = r14.next();
        int r18 = r16 + 1;
        if (r16 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();
    L26:
        ReceiverParameterDescriptor r19 = toContextReceiver((ProtoBuf$Type) r17, r12, r8, r16);
        if (r19 == null) goto L29;
        r13.add(r19);
    L29:
        r16 = r18;
        goto L22
    L30:
        List<TypeParameterDescriptor> r20 = r12.getTypeDeserializer().getOwnTypeParameters();
        List<ValueParameterDescriptor> r21 = r12.getMemberDeserializer().valueParameters(r32.getValueParameterList(), r32, AnnotatedCallableKind.FUNCTION);
        KotlinType r22 = r12.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(r32, this.c.getTypeTable()));
        ProtoEnumFlags r23 = ProtoEnumFlags.INSTANCE;
        initializeWithCoroutinesExperimentalityStatus(r8, r7, r10, r13, r20, r21, r22, r23.modality(Flags.MODALITY.get(r9)), ProtoEnumFlagsUtilsKt.descriptorVisibility(r23, Flags.VISIBILITY.get(r9)), MapsKt.emptyMap());
        r8.setOperator(Flags.IS_OPERATOR.get(r9).booleanValue());
        r8.setInfix(Flags.IS_INFIX.get(r9).booleanValue());
        r8.setExternal(Flags.IS_EXTERNAL_FUNCTION.get(r9).booleanValue());
        r8.setInline(Flags.IS_INLINE.get(r9).booleanValue());
        r8.setTailrec(Flags.IS_TAILREC.get(r9).booleanValue());
        r8.setSuspend(Flags.IS_SUSPEND.get(r9).booleanValue());
        r8.setExpect(Flags.IS_EXPECT_FUNCTION.get(r9).booleanValue());
        r8.setHasStableParameterNames(!Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES.get(r9).booleanValue());
        Pair<CallableDescriptor.UserDataKey<?>, Object> r24 = this.c.getComponents().getContractDeserializer().deserializeContractFromFunction(r32, r8, this.c.getTypeTable(), r12.getTypeDeserializer());
        if (r24 == null) goto L33;
        r8.putInUserDataMap((CallableDescriptor.UserDataKey) r24.getFirst(), r24.getSecond());
    L33:
        return r8;
    L19:
        r6 = null;
        goto L20
    L13:
        r3 = this.c.getVersionRequirementTable();
        goto L14
    L9:
        r2 = Annotations.Companion.getEMPTY();
        goto L11
    L5:
        r0 = loadOldFlags(r32.getOldFlags());
        goto L6
    }

    public final PropertyDescriptor loadProperty(ProtoBuf$Property r30) {
        Intrinsics.checkNotNullParameter(r30, "proto");
        if (r30.hasFlags() == false) goto L5;
        int r1 = r30.getFlags();
    L6:
        int r14 = r1;
        DeclarationDescriptor r2 = this.c.getContainingDeclaration();
        Annotations r4 = getAnnotations(r30, r14, AnnotatedCallableKind.PROPERTY);
        ProtoEnumFlags r9 = ProtoEnumFlags.INSTANCE;
        DeserializedPropertyDescriptor r13 = new DeserializedPropertyDescriptor(r2, null, r4, r9.modality(Flags.MODALITY.get(r14)), ProtoEnumFlagsUtilsKt.descriptorVisibility(r9, Flags.VISIBILITY.get(r14)), Flags.IS_VAR.get(r14).booleanValue(), NameResolverUtilKt.getName(this.c.getNameResolver(), r30.getName()), ProtoEnumFlagsUtilsKt.memberKind(r9, Flags.MEMBER_KIND.get(r14)), Flags.IS_LATEINIT.get(r14).booleanValue(), Flags.IS_CONST.get(r14).booleanValue(), Flags.IS_EXTERNAL_PROPERTY.get(r14).booleanValue(), Flags.IS_DELEGATED.get(r14).booleanValue(), Flags.IS_EXPECT_PROPERTY.get(r14).booleanValue(), r30, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource());
        DeserializationContext r12 = DeserializationContext.childContext$default(this.c, r13, r30.getTypeParameterList(), null, null, null, null, 60, null);
        boolean r7 = Flags.HAS_GETTER.get(r14).booleanValue();
        if (r7 == true) goto L9;
    L11:
        ProtoBuf$Property r15 = r30;
        Annotations r3 = Annotations.Companion.getEMPTY();
    L12:
        KotlinType r5 = r12.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(r15, this.c.getTypeTable()));
        List<TypeParameterDescriptor> r6 = r12.getTypeDeserializer().getOwnTypeParameters();
        ReceiverParameterDescriptor r8 = getDispatchReceiverParameter();
        ProtoBuf$Type r10 = ProtoTypeTableUtilKt.receiverType(r15, this.c.getTypeTable());
        ClassKind r19 = null;
        if (r10 == null) goto L17;
        KotlinType r11 = r12.getTypeDeserializer().type(r10);
        if (r11 == null) goto L17;
        DeserializedPropertyDescriptor r16 = r13;
        ReceiverParameterDescriptor r17 = DescriptorFactory.createExtensionReceiverParameterForCallable(r16, r11, r3);
    L18:
        List<ProtoBuf$Type> r18 = ProtoTypeTableUtilKt.contextReceiverTypes(r15, this.c.getTypeTable());
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<T> r21 = r18.iterator();
        int r22 = 0;
    L20:
        if (r21.hasNext() == false) goto L25;
        Object r23 = r21.next();
        int r110 = r22 + 1;
        if (r22 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        r20.add(toContextReceiver((ProtoBuf$Type) r23, r12, r16, r22));
        r22 = r110;
        goto L20
    L25:
        r16.setType(r5, r6, r8, r17, r20);
        boolean r24 = Flags.HAS_ANNOTATIONS.get(r14).booleanValue();
        Flags.FlagField<ProtoBuf$Visibility> r111 = Flags.VISIBILITY;
        ProtoBuf$Visibility r25 = r111.get(r14);
        Flags.FlagField<ProtoBuf$Modality> r26 = Flags.MODALITY;
        int r112 = Flags.getAccessorFlags(r24, r25, r26.get(r14), false, false, false);
        if (r7 == true) goto L28;
        r111 = r111;
        r12 = r12;
        r26 = r26;
        PropertyGetterDescriptorImpl r113 = null;
    L38:
        if (Flags.HAS_SETTER.get(r14).booleanValue() == true) goto L40;
        DeserializedPropertyDescriptor r27 = r16;
        ProtoBuf$Property r28 = r15;
        boolean r29 = true;
        PropertySetterDescriptor r31 = null;
    L48:
        if (Flags.HAS_CONSTANT.get(r14).booleanValue() == false) goto L50;
        r27.setCompileTimeInitializerFactory(new MemberDeserializer$.Lambda.0(this, r28, r27));
    L50:
        DeclarationDescriptor r32 = this.c.getContainingDeclaration();
        if ((r32 instanceof ClassDescriptor) == false) goto L53;
        ClassDescriptor r33 = (ClassDescriptor) r32;
    L54:
        if (r33 == null) goto L57;
        r19 = r33.getKind();
    L57:
        if (r19 != ClassKind.ANNOTATION_CLASS) goto L59;
        r27.setCompileTimeInitializerFactory(new MemberDeserializer$.Lambda.1(this, r28, r27));
    L59:
        r27.initialize(r113, r31, new FieldDescriptorImpl(getPropertyFieldAnnotations(r28, false), r27), new FieldDescriptorImpl(getPropertyFieldAnnotations(r28, r29), r27));
        return r27;
    L53:
        r33 = null;
        goto L54
    L40:
        if (r30.hasSetterFlags() == false) goto L42;
        r112 = r30.getSetterFlags();
    L42:
        int r34 = r112;
        boolean r35 = Flags.IS_NOT_DEFAULT.get(r34).booleanValue();
        boolean r36 = Flags.IS_EXTERNAL_ACCESSOR.get(r34).booleanValue();
        boolean r37 = Flags.IS_INLINE_ACCESSOR.get(r34).booleanValue();
        AnnotatedCallableKind r114 = AnnotatedCallableKind.PROPERTY_SETTER;
        Annotations r38 = getAnnotations(r15, r34, r114);
        if (r35 == false) goto L45;
        ProtoEnumFlags r39 = ProtoEnumFlags.INSTANCE;
        PropertySetterDescriptor r40 = new PropertySetterDescriptorImpl(r16, r38, r39.modality(r26.get(r34)), ProtoEnumFlagsUtilsKt.descriptorVisibility(r39, r111.get(r34)), !r35, r36, r37, r16.getKind(), null, SourceElement.NO_SOURCE);
        r29 = true;
        r27 = r16;
        r28 = r15;
        r40.initialize((ValueParameterDescriptor) CollectionsKt.single(DeserializationContext.childContext$default(r12, r40, CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer().valueParameters(CollectionsKt.listOf(r30.getSetterValueParameter()), r28, r114)));
        r31 = r40;
        goto L48
    L45:
        r27 = r16;
        r28 = r15;
        r29 = true;
        r31 = DescriptorFactory.createDefaultSetter(r27, r38, Annotations.Companion.getEMPTY());
        Intrinsics.checkNotNull(r31);
        goto L48
    L28:
        if (r30.hasGetterFlags() == false) goto L30;
        int r41 = r30.getGetterFlags();
    L31:
        boolean r42 = Flags.IS_NOT_DEFAULT.get(r41).booleanValue();
        boolean r43 = Flags.IS_EXTERNAL_ACCESSOR.get(r41).booleanValue();
        boolean r115 = Flags.IS_INLINE_ACCESSOR.get(r41).booleanValue();
        Annotations r44 = getAnnotations(r15, r41, AnnotatedCallableKind.PROPERTY_GETTER);
        if (r42 == false) goto L34;
        ProtoEnumFlags r45 = ProtoEnumFlags.INSTANCE;
        PropertyGetterDescriptorImpl r46 = new PropertyGetterDescriptorImpl(r16, r44, r45.modality(r26.get(r41)), ProtoEnumFlagsUtilsKt.descriptorVisibility(r45, r111.get(r41)), !r42, r43, r115, r16.getKind(), null, SourceElement.NO_SOURCE);
    L35:
        r46.initialize(r16.getReturnType());
        r113 = r46;
        goto L38
    L34:
        PropertyGetterDescriptorImpl r116 = DescriptorFactory.createDefaultGetter(r16, r44);
        Intrinsics.checkNotNull(r116);
        r46 = r116;
        goto L35
    L30:
        r41 = r112;
    L17:
        r16 = r13;
        r17 = null;
        goto L18
    L9:
        if (ProtoTypeTableUtilKt.hasReceiver(r30) == false) goto L11;
        r15 = r30;
        r3 = getReceiverParameterAnnotations(r15, AnnotatedCallableKind.PROPERTY_GETTER);
        goto L12
    L5:
        r1 = loadOldFlags(r30.getOldFlags());
        goto L6
    }

    public final TypeAliasDescriptor loadTypeAlias(ProtoBuf$TypeAlias r23) {
        Intrinsics.checkNotNullParameter(r23, "proto");
        Annotations.Companion r1 = Annotations.Companion;
        List<ProtoBuf$Annotation> r2 = r23.getAnnotationList();
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ProtoBuf$Annotation r5 = (ProtoBuf$Annotation) r4.next();
        AnnotationDeserializer r6 = this.annotationDeserializer;
        Intrinsics.checkNotNull(r5);
        r3.add(r6.deserializeAnnotation(r5, this.c.getNameResolver()));
        goto L4
    L6:
        Annotations r7 = r1.create(r3);
        DescriptorVisibility r8 = ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(r23.getFlags()));
        DeserializedTypeAliasDescriptor r15 = new DeserializedTypeAliasDescriptor(this.c.getStorageManager(), this.c.getContainingDeclaration(), r7, NameResolverUtilKt.getName(this.c.getNameResolver(), r23.getName()), r8, r23, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource());
        DeserializationContext r9 = DeserializationContext.childContext$default(this.c, r15, r23.getTypeParameterList(), null, null, null, null, 60, null);
        r15.initialize(r9.getTypeDeserializer().getOwnTypeParameters(), r9.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.underlyingType(r23, this.c.getTypeTable()), false), r9.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.expandedType(r23, this.c.getTypeTable()), false));
        return r15;
    }

    private final Annotations getPropertyFieldAnnotations(ProtoBuf$Property r4, boolean r5) {
        if (Flags.HAS_ANNOTATIONS.get(r4.getFlags()).booleanValue() == true) goto L7;
        return Annotations.Companion.getEMPTY();
    L7:
        return new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new MemberDeserializer$.Lambda.3(this, r5, r4));
    }

    private final Annotations getReceiverParameterAnnotations(MessageLite r4, AnnotatedCallableKind r5) {
        return new DeserializedAnnotations(this.c.getStorageManager(), new MemberDeserializer$.Lambda.4(this, r4, r5));
    }

    public final ClassConstructorDescriptor loadConstructor(ProtoBuf$Constructor r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r21, "proto");
        DeclarationDescriptor r1 = this.c.getContainingDeclaration();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        ClassDescriptor r16 = (ClassDescriptor) r1;
        int r2 = r21.getFlags();
        AnnotatedCallableKind r13 = AnnotatedCallableKind.FUNCTION;
        DeserializedClassConstructorDescriptor r14 = new DeserializedClassConstructorDescriptor(r16, null, getAnnotations(r21, r2, r13), r22, CallableMemberDescriptor.Kind.DECLARATION, r21, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource(), null, 1024, null);
        r14.initialize(DeserializationContext.childContext$default(this.c, r14, CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer().valueParameters(r21.getValueParameterList(), r21, r13), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(r21.getFlags())));
        r14.setReturnType(r16.getDefaultType());
        r14.setExpect(r16.isExpect());
        r14.setHasStableParameterNames(!Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES.get(r21.getFlags()).booleanValue());
        return r14;
    }

    private final Annotations getAnnotations(MessageLite r3, int r4, AnnotatedCallableKind r5) {
        if (Flags.HAS_ANNOTATIONS.get(r4).booleanValue() == true) goto L7;
        return Annotations.Companion.getEMPTY();
    L7:
        return new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new MemberDeserializer$.Lambda.2(this, r3, r5));
    }

    private static final List getAnnotations$lambda$11(MemberDeserializer r1, MessageLite r2, AnnotatedCallableKind r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$proto");
        Intrinsics.checkNotNullParameter(r3, "$kind");
        ProtoContainer r0 = r1.asProtoContainer(r1.c.getContainingDeclaration());
        if (r0 == null) goto L5;
        List r4 = CollectionsKt.toList(r1.c.getComponents().getAnnotationAndConstantLoader().loadCallableAnnotations(r0, r2, r3));
    L6:
        if (r4 == null) goto L8;
        return r4;
    L8:
        return CollectionsKt.emptyList();
    L5:
        r4 = null;
        goto L6
    }

    private static final List getPropertyFieldAnnotations$lambda$13(MemberDeserializer r1, boolean r2, ProtoBuf$Property r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$proto");
        ProtoContainer r0 = r1.asProtoContainer(r1.c.getContainingDeclaration());
        if (r0 == null) goto L7;
        if (r2 == false) goto L6;
        List r4 = CollectionsKt.toList(r1.c.getComponents().getAnnotationAndConstantLoader().loadPropertyDelegateFieldAnnotations(r0, r3));
    L8:
        if (r4 == null) goto L10;
        return r4;
    L10:
        return CollectionsKt.emptyList();
    L6:
        r4 = CollectionsKt.toList(r1.c.getComponents().getAnnotationAndConstantLoader().loadPropertyBackingFieldAnnotations(r0, r3));
        goto L8
    L7:
        r4 = null;
        goto L8
    }

    private static final List getReceiverParameterAnnotations$lambda$15(MemberDeserializer r1, MessageLite r2, AnnotatedCallableKind r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$proto");
        Intrinsics.checkNotNullParameter(r3, "$kind");
        ProtoContainer r0 = r1.asProtoContainer(r1.c.getContainingDeclaration());
        if (r0 == null) goto L5;
        List<AnnotationDescriptor> r4 = r1.c.getComponents().getAnnotationAndConstantLoader().loadExtensionReceiverParameterAnnotations(r0, r2, r3);
    L6:
        if (r4 == null) goto L8;
        return r4;
    L8:
        return CollectionsKt.emptyList();
    L5:
        r4 = null;
        goto L6
    }

    private static final NullableLazyValue loadProperty$lambda$3(MemberDeserializer r2, ProtoBuf$Property r3, DeserializedPropertyDescriptor r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$proto");
        Intrinsics.checkNotNullParameter(r4, "$property");
        return r2.c.getStorageManager().createNullableLazyValue(new MemberDeserializer$.Lambda.6(r2, r3, r4));
    }

    private static final ConstantValue loadProperty$lambda$3$lambda$2(MemberDeserializer r1, ProtoBuf$Property r2, DeserializedPropertyDescriptor r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$proto");
        Intrinsics.checkNotNullParameter(r3, "$property");
        ProtoContainer r0 = r1.asProtoContainer(r1.c.getContainingDeclaration());
        Intrinsics.checkNotNull(r0);
        return r1.c.getComponents().getAnnotationAndConstantLoader().loadPropertyConstant(r0, r2, r3.getReturnType());
    }

    private static final NullableLazyValue loadProperty$lambda$5(MemberDeserializer r2, ProtoBuf$Property r3, DeserializedPropertyDescriptor r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$proto");
        Intrinsics.checkNotNullParameter(r4, "$property");
        return r2.c.getStorageManager().createNullableLazyValue(new MemberDeserializer$.Lambda.7(r2, r3, r4));
    }

    private static final ConstantValue loadProperty$lambda$5$lambda$4(MemberDeserializer r1, ProtoBuf$Property r2, DeserializedPropertyDescriptor r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$proto");
        Intrinsics.checkNotNullParameter(r3, "$property");
        ProtoContainer r0 = r1.asProtoContainer(r1.c.getContainingDeclaration());
        Intrinsics.checkNotNull(r0);
        return r1.c.getComponents().getAnnotationAndConstantLoader().loadAnnotationDefaultValue(r0, r2, r3.getReturnType());
    }

    private final List<ValueParameterDescriptor> valueParameters(List<ProtoBuf$ValueParameter> r26, MessageLite r27, AnnotatedCallableKind r28) {
        DeclarationDescriptor r0 = this.c.getContainingDeclaration();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        CallableDescriptor r20 = (CallableDescriptor) r0;
        ProtoContainer r21 = asProtoContainer(r20.getContainingDeclaration());
        List<ProtoBuf$ValueParameter> r1 = r26;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r22 = r1.iterator();
        int r11 = 0;
    L4:
        if (r22.hasNext() == false) goto L23;
        Object r2 = r22.next();
        int r24 = r11 + 1;
        if (r11 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ProtoBuf$ValueParameter r8 = (ProtoBuf$ValueParameter) r2;
        if (r8.hasFlags() == false) goto L11;
        int r9 = r8.getFlags();
    L12:
        if (r21 != null) goto L14;
    L16:
        Annotations r12 = Annotations.Companion.getEMPTY();
    L17:
        Name r13 = NameResolverUtilKt.getName(this.c.getNameResolver(), r8.getName());
        KotlinType r14 = this.c.getTypeDeserializer().type(ProtoTypeTableUtilKt.type(r8, this.c.getTypeTable()));
        boolean r3 = Flags.DECLARES_DEFAULT_VALUE.get(r9).booleanValue();
        boolean r16 = Flags.IS_CROSSINLINE.get(r9).booleanValue();
        boolean r17 = Flags.IS_NOINLINE.get(r9).booleanValue();
        ProtoBuf$Type r4 = ProtoTypeTableUtilKt.varargElementType(r8, this.c.getTypeTable());
        if (r4 == null) goto L20;
        KotlinType r5 = this.c.getTypeDeserializer().type(r4);
    L21:
        ArrayList r6 = r15;
        r6.add(new ValueParameterDescriptorImpl(r20, null, r11, r12, r13, r14, r3, r16, r17, r5, SourceElement.NO_SOURCE));
        r15 = r6;
        r11 = r24;
        goto L4
    L20:
        r5 = null;
        goto L21
    L14:
        if (Flags.HAS_ANNOTATIONS.get(r9).booleanValue() == false) goto L16;
        r12 = new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new MemberDeserializer$.Lambda.5(this, r21, r27, r28, r11, r8));
        goto L17
    L11:
        r9 = 0;
        goto L12
    L23:
        return CollectionsKt.toList(r15);
    }

    private final ReceiverParameterDescriptor toContextReceiver(ProtoBuf$Type r2, DeserializationContext r3, CallableDescriptor r4, int r5) {
        return DescriptorFactory.createContextReceiverParameterForCallable(r4, r3.getTypeDeserializer().type(r2), null, Annotations.Companion.getEMPTY(), r5);
    }

    private static final List valueParameters$lambda$18$lambda$16(MemberDeserializer r6, ProtoContainer r7, MessageLite r8, AnnotatedCallableKind r9, int r10, ProtoBuf$ValueParameter r11) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        Intrinsics.checkNotNullParameter(r8, "$callable");
        Intrinsics.checkNotNullParameter(r9, "$kind");
        Intrinsics.checkNotNullParameter(r11, "$proto");
        return CollectionsKt.toList(r6.c.getComponents().getAnnotationAndConstantLoader().loadValueParameterAnnotations(r7, r8, r9, r10, r11));
    }

    private final void initializeWithCoroutinesExperimentalityStatus(DeserializedSimpleFunctionDescriptor r1, ReceiverParameterDescriptor r2, ReceiverParameterDescriptor r3, List<? extends ReceiverParameterDescriptor> r4, List<? extends TypeParameterDescriptor> r5, List<? extends ValueParameterDescriptor> r6, KotlinType r7, Modality r8, DescriptorVisibility r9, Map<? extends CallableDescriptor.UserDataKey<?>, ?> r10) {
        r1.initialize(r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }
}
