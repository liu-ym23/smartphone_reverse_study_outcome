package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionForAbsentTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeAttribute;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeDeserializer {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DeserializationContext f10219c;
    private final Function1<Integer, ClassifierDescriptor> classifierDescriptors;
    private final String containerPresentableName;
    private final String debugName;
    private final TypeDeserializer parent;
    private final Function1<Integer, ClassifierDescriptor> typeAliasDescriptors;
    private final Map<Integer, TypeParameterDescriptor> typeParameterDescriptors;

    public TypeDeserializer(DeserializationContext r10, TypeDeserializer r11, List<ProtoBuf.TypeParameter> r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r12, "typeParameterProtos");
        Intrinsics.checkNotNullParameter(r13, "debugName");
        Intrinsics.checkNotNullParameter(r14, "containerPresentableName");
        this.f10219c = r10;
        this.parent = r11;
        this.debugName = r13;
        this.containerPresentableName = r14;
        this.classifierDescriptors = r10.getStorageManager().createMemoizedFunctionWithNullableValues(new TypeDeserializer$classifierDescriptors$1(this));
        this.typeAliasDescriptors = r10.getStorageManager().createMemoizedFunctionWithNullableValues(new TypeDeserializer$typeAliasDescriptors$1(this));
        if (r12.isEmpty() == false) goto L5;
        Map<Integer, TypeParameterDescriptor> r15 = MapsKt.emptyMap();
    L9:
        this.typeParameterDescriptors = r15;
        return;
    L5:
        r15 = new LinkedHashMap();
        Iterator<ProtoBuf.TypeParameter> r16 = r12.iterator();
        int r17 = 0;
    L7:
        if (r16.hasNext() == false) goto L9;
        ProtoBuf.TypeParameter r18 = r16.next();
        r15.put(Integer.valueOf(r18.getId()), new DeserializedTypeParameterDescriptor(this.f10219c, r18, r17));
        r17 = r17 + 1;
        goto L7
    }

    public static final /* synthetic */ ClassifierDescriptor access$computeClassifierDescriptor(TypeDeserializer r10, int r11) {
        return r10.computeClassifierDescriptor(r11);
    }

    public static final /* synthetic */ ClassifierDescriptor access$computeTypeAliasDescriptor(TypeDeserializer r10, int r11) {
        return r10.computeTypeAliasDescriptor(r11);
    }

    public static final /* synthetic */ DeserializationContext access$getC$p(TypeDeserializer r10) {
        return r10.f10219c;
    }

    private final ClassifierDescriptor computeClassifierDescriptor(int r10) {
        ClassId r11 = NameResolverUtilKt.getClassId(this.f10219c.getNameResolver(), r10);
        boolean r12 = r11.isLocal();
        DeserializationComponents r13 = this.f10219c.getComponents();
        if (r12 == false) goto L7;
        return r13.deserializeClass(r11);
    L7:
        return FindClassInModuleKt.findClassifierAcrossModuleDependencies(r13.getModuleDescriptor(), r11);
    }

    private final SimpleType computeLocalClassifierReplacementType(int r10) {
        if (NameResolverUtilKt.getClassId(this.f10219c.getNameResolver(), r10).isLocal() == true) goto L5;
        return null;
    L5:
        return this.f10219c.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
    }

    private final ClassifierDescriptor computeTypeAliasDescriptor(int r10) {
        ClassId r11 = NameResolverUtilKt.getClassId(this.f10219c.getNameResolver(), r10);
        if (r11.isLocal() == false) goto L7;
        return null;
    L7:
        return FindClassInModuleKt.findTypeAliasAcrossModuleDependencies(this.f10219c.getComponents().getModuleDescriptor(), r11);
    }

    private final SimpleType createSimpleSuspendFunctionType(KotlinType r10, KotlinType r11) {
        KotlinBuiltIns r12 = TypeUtilsKt.getBuiltIns(r10);
        Annotations r13 = r10.getAnnotations();
        KotlinType r14 = FunctionTypesKt.getReceiverTypeFromFunctionType(r10);
        List<KotlinType> r15 = FunctionTypesKt.getContextReceiverTypesFromFunctionType(r10);
        List r16 = CollectionsKt.dropLast(FunctionTypesKt.getValueParameterTypesFromFunctionType(r10), 1);
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r18 = r16.iterator();
    L4:
        if (r18.hasNext() == false) goto L7;
        r17.add(((TypeProjection) r18.next()).getType());
        goto L4
    L7:
        return FunctionTypesKt.createFunctionType(r12, r13, r14, r15, r17, null, r11, true).makeNullableAsSpecified(r10.isMarkedNullable());
    }

    private final SimpleType createSuspendFunctionType(TypeAttributes r10, TypeConstructor r11, List<? extends TypeProjection> r12, boolean r13) {
        int r14 = r11.getParameters().size() - r12.size();
        SimpleType r15 = null;
        if (r14 != 0) goto L5;
        r15 = createSuspendFunctionTypeForBasicCase(r10, r11, r12, r13);
    L11:
        if (r15 == null) goto L13;
        return r15;
    L13:
        return ErrorUtils.INSTANCE.createErrorTypeWithArguments(ErrorTypeKind.INCONSISTENT_SUSPEND_FUNCTION, r12, r11, new String[0]);
    L5:
        if (r14 != 1) goto L11;
        int r16 = r12.size() - 1;
        if (r16 < 0) goto L11;
        TypeConstructor r17 = r11.getBuiltIns().getSuspendFunction(r16).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r17, "functionTypeConstructor.…on(arity).typeConstructor");
        r15 = KotlinTypeFactory.simpleType$default(r10, r17, r12, r13, null, 16, null);
        goto L11
    }

    private final SimpleType createSuspendFunctionTypeForBasicCase(TypeAttributes r10, TypeConstructor r11, List<? extends TypeProjection> r12, boolean r13) {
        SimpleType r14 = KotlinTypeFactory.simpleType$default(r10, r11, r12, r13, null, 16, null);
        if (FunctionTypesKt.isFunctionType(r14) == true) goto L6;
        return null;
    L6:
        return transformRuntimeFunctionTypeToSuspendFunction(r14);
    }

    private final TypeParameterDescriptor loadTypeParameter(int r10) {
        TypeParameterDescriptor r11 = this.typeParameterDescriptors.get(Integer.valueOf(r10));
        if (r11 != null) goto L9;
        TypeDeserializer r12 = this.parent;
        if (r12 != null) goto L10;
        return null;
    L10:
        return r12.loadTypeParameter(r10);
    L9:
        return r11;
    }

    private static final List<ProtoBuf.Type.Argument> simpleType$collectAllArguments(ProtoBuf.Type r10, TypeDeserializer r11) {
        List<ProtoBuf.Type.Argument> r12 = r10.getArgumentList();
        Intrinsics.checkNotNullExpressionValue(r12, "argumentList");
        ProtoBuf.Type r13 = ProtoTypeTableUtilKt.outerType(r10, r11.f10219c.getTypeTable());
        if (r13 == null) goto L5;
        List<ProtoBuf.Type.Argument> r14 = simpleType$collectAllArguments(r13, r11);
    L6:
        if (r14 != null) goto L9;
        r14 = CollectionsKt.emptyList();
    L9:
        return CollectionsKt.plus(r12, r14);
    L5:
        r14 = null;
        goto L6
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeDeserializer r10, ProtoBuf.Type r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = true;
    L6:
        return r10.simpleType(r11, r12);
    }

    private final TypeAttributes toAttributes(List<? extends TypeAttributeTranslator> r10, Annotations r11, TypeConstructor r12, DeclarationDescriptor r13) {
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r15 = r10.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        r14.add(((TypeAttributeTranslator) r15.next()).toAttributes(r11, r12, r13));
        goto L4
    L6:
        List<? extends TypeAttribute<?>> r16 = CollectionsKt.flatten(r14);
        return TypeAttributes.Companion.create(r16);
    }

    private final SimpleType transformRuntimeFunctionTypeToSuspendFunction(KotlinType r10) {
        TypeProjection r11 = (TypeProjection) CollectionsKt.lastOrNull(FunctionTypesKt.getValueParameterTypesFromFunctionType(r10));
        FqName r12 = null;
        if (r11 == null) goto L28;
        KotlinType r13 = r11.getType();
        if (r13 == null) goto L28;
        ClassifierDescriptor r14 = r13.getConstructor().mo1323getDeclarationDescriptor();
        if (r14 == null) goto L10;
        FqName r15 = DescriptorUtilsKt.getFqNameSafe(r14);
    L12:
        if (r13.getArguments().size() != 1) goto L27;
        if (Intrinsics.areEqual(r15, StandardNames.CONTINUATION_INTERFACE_FQ_NAME) == false) goto L16;
    L18:
        KotlinType r16 = ((TypeProjection) CollectionsKt.single(r13.getArguments())).getType();
        Intrinsics.checkNotNullExpressionValue(r16, "continuationArgumentType.arguments.single().type");
        DeclarationDescriptor r17 = this.f10219c.getContainingDeclaration();
        if ((r17 instanceof CallableDescriptor) == true) goto L21;
        r17 = null;
    L21:
        CallableDescriptor r18 = (CallableDescriptor) r17;
        if (r18 == null) goto L24;
        r12 = DescriptorUtilsKt.fqNameOrNull(r18);
    L24:
        Intrinsics.areEqual(r12, SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME);
        return createSimpleSuspendFunctionType(r10, r16);
    L16:
        if (Intrinsics.areEqual(r15, TypeDeserializerKt.access$getEXPERIMENTAL_CONTINUATION_FQ_NAME$p()) == true) goto L18;
    L27:
        return (SimpleType) r10;
    L10:
        r15 = null;
    L28:
        return null;
    }

    private final TypeProjection typeArgument(TypeParameterDescriptor r10, ProtoBuf.Type.Argument r11) {
        if (r11.getProjection() != ProtoBuf.Type.Argument.Projection.STAR) goto L8;
        if (r10 != null) goto L7;
        return new StarProjectionForAbsentTypeParameter(this.f10219c.getComponents().getModuleDescriptor().getBuiltIns());
    L7:
        return new StarProjectionImpl(r10);
    L8:
        ProtoEnumFlags r12 = ProtoEnumFlags.INSTANCE;
        ProtoBuf.Type.Argument.Projection r13 = r11.getProjection();
        Intrinsics.checkNotNullExpressionValue(r13, "typeArgumentProto.projection");
        Variance r14 = r12.variance(r13);
        ProtoBuf.Type r15 = ProtoTypeTableUtilKt.type(r11, this.f10219c.getTypeTable());
        if (r15 != null) goto L13;
        return new TypeProjectionImpl(ErrorUtils.createErrorType(ErrorTypeKind.NO_RECORDED_TYPE, new String[]{r11.toString()}));
    L13:
        return new TypeProjectionImpl(r14, type(r15));
    }

    private final TypeConstructor typeConstructor(ProtoBuf.Type r10) {
        if (r10.hasClassName() == false) goto L9;
        ClassifierDescriptor r11 = this.classifierDescriptors.invoke(Integer.valueOf(r10.getClassName()));
        if (r11 != null) goto L32;
        int r12 = r10.getClassName();
    L7:
        r11 = typeConstructor$notFoundClass(this, r10, r12);
    L32:
        TypeConstructor r13 = r11.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r13, "classifier.typeConstructor");
        return r13;
    L9:
        if (r10.hasTypeParameter() == false) goto L15;
        r11 = loadTypeParameter(r10.getTypeParameter());
        if (r11 != null) goto L32;
        return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER, new String[]{String.valueOf(r10.getTypeParameter()), this.containerPresentableName});
    L15:
        if (r10.hasTypeParameterName() == false) goto L28;
        String r14 = this.f10219c.getNameResolver().getString(r10.getTypeParameterName());
        Iterator<T> r15 = getOwnTypeParameters().iterator();
    L18:
        if (r15.hasNext() == false) goto L22;
        Object r16 = r15.next();
        if (Intrinsics.areEqual(((TypeParameterDescriptor) r16).getName().asString(), r14) == false) goto L18;
    L23:
        r11 = (TypeParameterDescriptor) r16;
        if (r11 != null) goto L32;
        return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME, new String[]{r14, this.f10219c.getContainingDeclaration().toString()});
    L22:
        r16 = null;
        goto L23
    L28:
        if (r10.hasTypeAliasName() == false) goto L35;
        r11 = this.typeAliasDescriptors.invoke(Integer.valueOf(r10.getTypeAliasName()));
        if (r11 != null) goto L32;
        r12 = r10.getTypeAliasName();
        goto L7
    L35:
        return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.UNKNOWN_TYPE, new String[0]);
    }

    private static final ClassDescriptor typeConstructor$notFoundClass(final TypeDeserializer r10, ProtoBuf.Type r11, int r12) {
        ClassId r13 = NameResolverUtilKt.getClassId(r10.f10219c.getNameResolver(), r12);
        List<Integer> r14 = SequencesKt.toMutableList(SequencesKt.map(SequencesKt.generateSequence(r11, new TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1(r10)), TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2.INSTANCE));
        int r15 = SequencesKt.count(SequencesKt.generateSequence(r13, TypeDeserializer$typeConstructor$notFoundClass$classNestingLevel$1.INSTANCE));
    L4:
        if (r14.size() >= r15) goto L7;
        r14.add(0);
        goto L4
    L7:
        return r10.f10219c.getComponents().getNotFoundClasses().getClass(r13, r14);
    }

    public final List<TypeParameterDescriptor> getOwnTypeParameters() {
        return CollectionsKt.toList(this.typeParameterDescriptors.values());
    }

    public final SimpleType simpleType(final ProtoBuf.Type r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "proto");
        if (r14.hasClassName() == false) goto L7;
        int r10 = r14.getClassName();
    L5:
        SimpleType r11 = computeLocalClassifierReplacementType(r10);
    L10:
        if (r11 == null) goto L12;
        return r11;
    L12:
        TypeConstructor r12 = typeConstructor(r14);
        boolean r13 = true;
        if (ErrorUtils.isError(r12.mo1323getDeclarationDescriptor()) == true) goto L15;
        DeserializedAnnotations r16 = new DeserializedAnnotations(this.f10219c.getStorageManager(), new TypeDeserializer$simpleType$annotations$1(this, r14));
        TypeAttributes r17 = toAttributes(this.f10219c.getComponents().getTypeAttributeTranslators(), r16, r12, this.f10219c.getContainingDeclaration());
        List<ProtoBuf.Type.Argument> r18 = simpleType$collectAllArguments(r14, this);
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<T> r20 = r18.iterator();
        int r21 = 0;
    L18:
        if (r20.hasNext() == false) goto L23;
        Object r22 = r20.next();
        int r110 = r21 + 1;
        if (r21 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        List<TypeParameterDescriptor> r111 = r12.getParameters();
        Intrinsics.checkNotNullExpressionValue(r111, "constructor.parameters");
        r19.add(typeArgument((TypeParameterDescriptor) CollectionsKt.getOrNull(r111, r21), (ProtoBuf.Type.Argument) r22));
        r21 = r110;
        goto L18
    L23:
        List<? extends TypeProjection> r23 = CollectionsKt.toList(r19);
        ClassifierDescriptor r24 = r12.mo1323getDeclarationDescriptor();
        if (r15 == true) goto L26;
    L34:
        Boolean r112 = Flags.SUSPEND_TYPE.get(r14.getFlags());
        Intrinsics.checkNotNullExpressionValue(r112, "SUSPEND_TYPE.get(proto.flags)");
        if (r112.booleanValue() == false) goto L37;
        SimpleType r113 = createSuspendFunctionType(r17, r12, r23, r14.getNullable());
    L44:
        ProtoBuf.Type r25 = ProtoTypeTableUtilKt.abbreviatedType(r14, this.f10219c.getTypeTable());
        if (r25 == null) goto L51;
        SimpleType r26 = SpecialTypesKt.withAbbreviation(r113, simpleType(r25, false));
        if (r26 == null) goto L51;
        r113 = r26;
    L51:
        if (r14.hasClassName() == true) goto L53;
        return r113;
    L53:
        return this.f10219c.getComponents().getPlatformDependentTypeTransformer().transformPlatformType(NameResolverUtilKt.getClassId(this.f10219c.getNameResolver(), r14.getClassName()), r113);
    L37:
        r113 = KotlinTypeFactory.simpleType$default(r17, r12, r23, r14.getNullable(), null, 16, null);
        Boolean r27 = Flags.DEFINITELY_NOT_NULL_TYPE.get(r14.getFlags());
        Intrinsics.checkNotNullExpressionValue(r27, "DEFINITELY_NOT_NULL_TYPE.get(proto.flags)");
        if (r27.booleanValue() == false) goto L44;
        DefinitelyNotNullType r28 = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, r113, false, 2, null);
        if (r28 == null) goto L43;
        r113 = r28;
        goto L44
    L43:
        throw new IllegalStateException(("null DefinitelyNotNullType for '" + r113 + '\'').toString());
    L26:
        if ((r24 instanceof TypeAliasDescriptor) == false) goto L34;
        KotlinTypeFactory r114 = KotlinTypeFactory.INSTANCE;
        SimpleType r115 = KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor) r24, r23);
        TypeAttributes r29 = toAttributes(this.f10219c.getComponents().getTypeAttributeTranslators(), Annotations.Companion.create(CollectionsKt.plus(r16, r115.getAnnotations())), r12, this.f10219c.getContainingDeclaration());
        if (KotlinTypeKt.isNullable(r115) == false) goto L30;
    L33:
        r113 = r115.makeNullableAsSpecified(r13).replaceAttributes(r29);
        goto L44
    L30:
        if (r14.getNullable() == true) goto L33;
        r13 = false;
        goto L33
    L15:
        return ErrorUtils.INSTANCE.createErrorType(ErrorTypeKind.TYPE_FOR_ERROR_TYPE_CONSTRUCTOR, r12, new String[]{r12.toString()});
    L7:
        if (r14.hasTypeAliasName() == false) goto L9;
        r10 = r14.getTypeAliasName();
        goto L5
    L9:
        r11 = null;
        goto L10
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(this.debugName);
        if (this.parent != null) goto L5;
        String r11 = "";
    L6:
        r10.append(r11);
        return r10.toString();
    L5:
        r11 = ". Child of " + this.parent.debugName;
        goto L6
    }

    public final KotlinType type(ProtoBuf.Type r10) {
        Intrinsics.checkNotNullParameter(r10, "proto");
        if (r10.hasFlexibleTypeCapabilitiesId() == false) goto L7;
        String r11 = this.f10219c.getNameResolver().getString(r10.getFlexibleTypeCapabilitiesId());
        SimpleType r12 = simpleType$default(this, r10, false, 2, null);
        ProtoBuf.Type r13 = ProtoTypeTableUtilKt.flexibleUpperBound(r10, this.f10219c.getTypeTable());
        Intrinsics.checkNotNull(r13);
        SimpleType r14 = simpleType$default(this, r13, false, 2, null);
        return this.f10219c.getComponents().getFlexibleTypeDeserializer().create(r10, r11, r12, r14);
    L7:
        return simpleType(r10, true);
    }
}
