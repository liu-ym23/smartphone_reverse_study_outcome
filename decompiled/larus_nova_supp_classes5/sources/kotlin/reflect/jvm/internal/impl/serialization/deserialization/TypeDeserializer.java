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
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class TypeDeserializer {
    private final DeserializationContext c;
    private final Function1<Integer, ClassifierDescriptor> classifierDescriptors;
    private final String containerPresentableName;
    private final String debugName;
    private final TypeDeserializer parent;
    private final Function1<Integer, ClassifierDescriptor> typeAliasDescriptors;
    private final Map<Integer, TypeParameterDescriptor> typeParameterDescriptors;

    public static /* synthetic */ ClassifierDescriptor accessor$TypeDeserializer$lambda0(TypeDeserializer r0, int r1) {
        return classifierDescriptors$lambda$0(r0, r1);
    }

    public static /* synthetic */ ClassifierDescriptor accessor$TypeDeserializer$lambda1(TypeDeserializer r0, int r1) {
        return typeAliasDescriptors$lambda$1(r0, r1);
    }

    public static /* synthetic */ List accessor$TypeDeserializer$lambda2(TypeDeserializer r0, ProtoBuf$Type r1) {
        return simpleType$lambda$3(r0, r1);
    }

    public static /* synthetic */ ProtoBuf$Type accessor$TypeDeserializer$lambda3(TypeDeserializer r0, ProtoBuf$Type r1) {
        return typeConstructor$notFoundClass$lambda$8(r0, r1);
    }

    public static /* synthetic */ int accessor$TypeDeserializer$lambda4(ProtoBuf$Type r0) {
        return typeConstructor$notFoundClass$lambda$9(r0);
    }

    public final List<TypeParameterDescriptor> getOwnTypeParameters() {
        return CollectionsKt.toList(this.typeParameterDescriptors.values());
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.debugName);
        if (this.parent != null) goto L5;
        String r1 = "";
    L6:
        r0.append(r1);
        return r0.toString();
    L5:
        r1 = ". Child of " + this.parent.debugName;
        goto L6
    }

    private final ClassifierDescriptor computeClassifierDescriptor(int r2) {
        ClassId r3 = NameResolverUtilKt.getClassId(this.c.getNameResolver(), r2);
        if (r3.isLocal() == false) goto L7;
        return this.c.getComponents().deserializeClass(r3);
    L7:
        return FindClassInModuleKt.findClassifierAcrossModuleDependencies(this.c.getComponents().getModuleDescriptor(), r3);
    }

    private final SimpleType computeLocalClassifierReplacementType(int r2) {
        if (NameResolverUtilKt.getClassId(this.c.getNameResolver(), r2).isLocal() == true) goto L5;
        return null;
    L5:
        return this.c.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
    }

    private final ClassifierDescriptor computeTypeAliasDescriptor(int r2) {
        ClassId r3 = NameResolverUtilKt.getClassId(this.c.getNameResolver(), r2);
        if (r3.isLocal() == false) goto L7;
        return null;
    L7:
        return FindClassInModuleKt.findTypeAliasAcrossModuleDependencies(this.c.getComponents().getModuleDescriptor(), r3);
    }

    private final TypeParameterDescriptor loadTypeParameter(int r3) {
        TypeParameterDescriptor r0 = this.typeParameterDescriptors.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        TypeDeserializer r1 = this.parent;
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.loadTypeParameter(r3);
    L9:
        return r0;
    }

    private final SimpleType transformRuntimeFunctionTypeToSuspendFunction(KotlinType r6) {
        TypeProjection r0 = (TypeProjection) CollectionsKt.lastOrNull(FunctionTypesKt.getValueParameterTypesFromFunctionType(r6));
        FqName r1 = null;
        if (r0 == null) goto L32;
        KotlinType r2 = r0.getType();
        if (r2 == null) goto L32;
        ClassifierDescriptor r3 = r2.getConstructor().getDeclarationDescriptor();
        if (r3 == null) goto L10;
        FqName r4 = DescriptorUtilsKt.getFqNameSafe(r3);
    L12:
        if (r2.getArguments().size() != 1) goto L31;
        if (Intrinsics.areEqual(r4, StandardNames.CONTINUATION_INTERFACE_FQ_NAME) == false) goto L16;
    L18:
        KotlinType r5 = ((TypeProjection) CollectionsKt.single(r2.getArguments())).getType();
        DeclarationDescriptor r7 = this.c.getContainingDeclaration();
        if ((r7 instanceof CallableDescriptor) == false) goto L21;
        CallableDescriptor r8 = (CallableDescriptor) r7;
    L22:
        if (r8 == null) goto L25;
        r1 = DescriptorUtilsKt.fqNameOrNull(r8);
    L25:
        if (Intrinsics.areEqual(r1, SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME) == false) goto L29;
        return createSimpleSuspendFunctionType(r6, r5);
    L29:
        return createSimpleSuspendFunctionType(r6, r5);
    L21:
        r8 = null;
        goto L22
    L16:
        if (Intrinsics.areEqual(r4, TypeDeserializerKt.access$getEXPERIMENTAL_CONTINUATION_FQ_NAME$p()) == true) goto L18;
    L31:
        return (SimpleType) r6;
    L10:
        r4 = null;
    L32:
        return null;
    }

    private final TypeConstructor typeConstructor(ProtoBuf$Type r7) {
        if (r7.hasClassName() == false) goto L8;
        ClassifierDescriptor r0 = (ClassifierDescriptor) this.classifierDescriptors.invoke(Integer.valueOf(r7.getClassName()));
        if (r0 != null) goto L32;
        r0 = typeConstructor$notFoundClass(this, r7, r7.getClassName());
    L32:
        return r0.getTypeConstructor();
    L8:
        if (r7.hasTypeParameter() == false) goto L14;
        r0 = loadTypeParameter(r7.getTypeParameter());
        if (r0 != null) goto L32;
        return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER, new String[]{String.valueOf(r7.getTypeParameter()), this.containerPresentableName});
    L14:
        if (r7.hasTypeParameterName() == false) goto L27;
        String r8 = this.c.getNameResolver().getString(r7.getTypeParameterName());
        Iterator<T> r1 = getOwnTypeParameters().iterator();
    L17:
        if (r1.hasNext() == false) goto L21;
        Object r4 = r1.next();
        if (Intrinsics.areEqual(((TypeParameterDescriptor) r4).getName().asString(), r8) == false) goto L17;
    L22:
        r0 = (TypeParameterDescriptor) r4;
        if (r0 != null) goto L32;
        return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME, new String[]{r8, this.c.getContainingDeclaration().toString()});
    L21:
        r4 = null;
        goto L22
    L27:
        if (r7.hasTypeAliasName() == false) goto L34;
        r0 = (ClassifierDescriptor) this.typeAliasDescriptors.invoke(Integer.valueOf(r7.getTypeAliasName()));
        if (r0 != null) goto L32;
        r0 = typeConstructor$notFoundClass(this, r7, r7.getTypeAliasName());
        goto L32
    L34:
        return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.UNKNOWN_TYPE, new String[0]);
    }

    private static final int typeConstructor$notFoundClass$lambda$9(ProtoBuf$Type r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1.getArgumentCount();
    }

    public final KotlinType type(ProtoBuf$Type r7) {
        Intrinsics.checkNotNullParameter(r7, "proto");
        if (r7.hasFlexibleTypeCapabilitiesId() == false) goto L7;
        String r0 = this.c.getNameResolver().getString(r7.getFlexibleTypeCapabilitiesId());
        SimpleType r4 = simpleType$default(this, r7, false, 2, null);
        ProtoBuf$Type r5 = ProtoTypeTableUtilKt.flexibleUpperBound(r7, this.c.getTypeTable());
        Intrinsics.checkNotNull(r5);
        SimpleType r1 = simpleType$default(this, r5, false, 2, null);
        return this.c.getComponents().getFlexibleTypeDeserializer().create(r7, r0, r4, r1);
    L7:
        return simpleType(r7, true);
    }

    private static final ClassifierDescriptor classifierDescriptors$lambda$0(TypeDeserializer r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return r1.computeClassifierDescriptor(r2);
    }

    private final SimpleType createSimpleSuspendFunctionType(KotlinType r9, KotlinType r10) {
        KotlinBuiltIns r0 = TypeUtilsKt.getBuiltIns(r9);
        Annotations r1 = r9.getAnnotations();
        KotlinType r2 = FunctionTypesKt.getReceiverTypeFromFunctionType(r9);
        List r3 = FunctionTypesKt.getContextReceiverTypesFromFunctionType(r9);
        List r4 = CollectionsKt.dropLast(FunctionTypesKt.getValueParameterTypesFromFunctionType(r9), 1);
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        r5.add(((TypeProjection) r6.next()).getType());
        goto L4
    L7:
        return FunctionTypesKt.createFunctionType(r0, r1, r2, r3, r5, null, r10, true).makeNullableAsSpecified(r9.isMarkedNullable());
    }

    private static final List<ProtoBuf$Type.Argument> simpleType$collectAllArguments(ProtoBuf$Type r2, TypeDeserializer r3) {
        List<ProtoBuf$Type.Argument> r0 = r2.getArgumentList();
        ProtoBuf$Type r4 = ProtoTypeTableUtilKt.outerType(r2, r3.c.getTypeTable());
        if (r4 == null) goto L5;
        List<ProtoBuf$Type.Argument> r5 = simpleType$collectAllArguments(r4, r3);
    L6:
        if (r5 != null) goto L9;
        r5 = CollectionsKt.emptyList();
    L9:
        return CollectionsKt.plus(r0, r5);
    L5:
        r5 = null;
        goto L6
    }

    private static final List simpleType$lambda$3(TypeDeserializer r1, ProtoBuf$Type r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$proto");
        return r1.c.getComponents().getAnnotationAndConstantLoader().loadTypeAnnotations(r2, r1.c.getNameResolver());
    }

    private static final ClassifierDescriptor typeAliasDescriptors$lambda$1(TypeDeserializer r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return r1.computeTypeAliasDescriptor(r2);
    }

    private final TypeProjection typeArgument(TypeParameterDescriptor r4, ProtoBuf$Type.Argument r5) {
        if (r5.getProjection() != ProtoBuf$Type.Argument.Projection.STAR) goto L8;
        if (r4 != null) goto L7;
        return new StarProjectionForAbsentTypeParameter(this.c.getComponents().getModuleDescriptor().getBuiltIns());
    L7:
        return new StarProjectionImpl(r4);
    L8:
        Variance r6 = ProtoEnumFlags.INSTANCE.variance(r5.getProjection());
        ProtoBuf$Type r0 = ProtoTypeTableUtilKt.type(r5, this.c.getTypeTable());
        if (r0 != null) goto L13;
        return new TypeProjectionImpl(ErrorUtils.createErrorType(ErrorTypeKind.NO_RECORDED_TYPE, new String[]{r5.toString()}));
    L13:
        return new TypeProjectionImpl(r6, type(r0));
    }

    private static final ProtoBuf$Type typeConstructor$notFoundClass$lambda$8(TypeDeserializer r1, ProtoBuf$Type r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "it");
        return ProtoTypeTableUtilKt.outerType(r2, r1.c.getTypeTable());
    }

    public final SimpleType simpleType(final ProtoBuf$Type r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r18, "proto");
        if (r18.hasClassName() == false) goto L6;
        SimpleType r2 = computeLocalClassifierReplacementType(r18.getClassName());
    L9:
        if (r2 == null) goto L11;
        return r2;
    L11:
        TypeConstructor r4 = typeConstructor(r18);
        boolean r3 = true;
        if (ErrorUtils.isError(r4.getDeclarationDescriptor()) == true) goto L14;
        DeserializedAnnotations r5 = new DeserializedAnnotations(this.c.getStorageManager(), new TypeDeserializer$$Lambda$2(this, r18));
        TypeAttributes r6 = toAttributes(this.c.getComponents().getTypeAttributeTranslators(), r5, r4, this.c.getContainingDeclaration());
        List<ProtoBuf$Type.Argument> r7 = simpleType$collectAllArguments(r18, this);
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r9 = r7.iterator();
        int r10 = 0;
    L17:
        if (r9.hasNext() == false) goto L22;
        Object r11 = r9.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        r8.add(typeArgument((TypeParameterDescriptor) CollectionsKt.getOrNull(r4.getParameters(), r10), (ProtoBuf$Type.Argument) r11));
        r10 = r12;
        goto L17
    L22:
        List<? extends TypeProjection> r13 = CollectionsKt.toList(r8);
        ClassifierDescriptor r14 = r4.getDeclarationDescriptor();
        if (r19 == false) goto L34;
        if ((r14 instanceof TypeAliasDescriptor) == false) goto L34;
        KotlinTypeFactory r15 = KotlinTypeFactory.INSTANCE;
        SimpleType r16 = KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor) r14, r13);
        TypeAttributes r17 = toAttributes(this.c.getComponents().getTypeAttributeTranslators(), Annotations.Companion.create(CollectionsKt.plus(r5, r16.getAnnotations())), r4, this.c.getContainingDeclaration());
        if (KotlinTypeKt.isNullable(r16) == false) goto L29;
    L32:
        SimpleType r20 = r16.makeNullableAsSpecified(r3).replaceAttributes(r17);
    L43:
        ProtoBuf$Type r1 = ProtoTypeTableUtilKt.abbreviatedType(r18, this.c.getTypeTable());
        if (r1 == null) goto L53;
        SimpleType r21 = SpecialTypesKt.withAbbreviation(r20, simpleType(r1, false));
        if (r21 != null) goto L49;
        return r20;
    L49:
        return r21;
    L53:
        return r20;
    L29:
        if (r18.getNullable() == true) goto L32;
        r3 = false;
    L34:
        if (Flags.SUSPEND_TYPE.get(r18.getFlags()).booleanValue() == false) goto L36;
        r20 = createSuspendFunctionType(r6, r4, r13, r18.getNullable());
        goto L43
    L36:
        r20 = KotlinTypeFactory.simpleType$default(r6, r4, r13, r18.getNullable(), null, 16, null);
        if (Flags.DEFINITELY_NOT_NULL_TYPE.get(r18.getFlags()).booleanValue() == false) goto L43;
        SimpleType r22 = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, r20, true, false, 4, null);
        if (r22 == null) goto L42;
        r20 = r22;
        goto L43
    L42:
        throw new IllegalStateException(("null DefinitelyNotNullType for '" + r20 + '\'').toString());
    L14:
        return ErrorUtils.INSTANCE.createErrorType(ErrorTypeKind.TYPE_FOR_ERROR_TYPE_CONSTRUCTOR, r4, new String[]{r4.toString()});
    L6:
        if (r18.hasTypeAliasName() == false) goto L8;
        r2 = computeLocalClassifierReplacementType(r18.getTypeAliasName());
        goto L9
    L8:
        r2 = null;
        goto L9
    }

    private static final ClassDescriptor typeConstructor$notFoundClass(TypeDeserializer r2, ProtoBuf$Type r3, int r4) {
        ClassId r5 = NameResolverUtilKt.getClassId(r2.c.getNameResolver(), r4);
        List<Integer> r6 = SequencesKt.toMutableList(SequencesKt.map(SequencesKt.generateSequence(r3, new TypeDeserializer$.Lambda.3(r2)), TypeDeserializer$.Lambda.4.INSTANCE));
        int r0 = SequencesKt.count(SequencesKt.generateSequence(r5, typeConstructor.notFoundClass.classNestingLevel.1.INSTANCE));
    L4:
        if (r6.size() >= r0) goto L7;
        r6.add(0);
        goto L4
    L7:
        return r2.c.getComponents().getNotFoundClasses().getClass(r5, r6);
    }

    private final SimpleType createSuspendFunctionType(TypeAttributes r9, TypeConstructor r10, List<? extends TypeProjection> r11, boolean r12) {
        int r0 = r10.getParameters().size() - r11.size();
        if (r0 == 0) goto L10;
        SimpleType r1 = null;
        if (r0 != 1) goto L11;
        int r2 = r11.size() - 1;
        if (r2 < 0) goto L11;
        r1 = KotlinTypeFactory.simpleType$default(r9, r10.getBuiltIns().getSuspendFunction(r2).getTypeConstructor(), r11, r12, null, 16, null);
    L11:
        if (r1 == null) goto L13;
        return r1;
    L13:
        return ErrorUtils.INSTANCE.createErrorTypeWithArguments(ErrorTypeKind.INCONSISTENT_SUSPEND_FUNCTION, r11, r10, new String[0]);
    L10:
        r1 = createSuspendFunctionTypeForBasicCase(r9, r10, r11, r12);
        goto L11
    }

    private final SimpleType createSuspendFunctionTypeForBasicCase(TypeAttributes r8, TypeConstructor r9, List<? extends TypeProjection> r10, boolean r11) {
        SimpleType r12 = KotlinTypeFactory.simpleType$default(r8, r9, r10, r11, null, 16, null);
        if (FunctionTypesKt.isFunctionType(r12) == true) goto L6;
        return null;
    L6:
        return transformRuntimeFunctionTypeToSuspendFunction(r12);
    }

    private final TypeAttributes toAttributes(List<? extends TypeAttributeTranslator> r3, Annotations r4, TypeConstructor r5, DeclarationDescriptor r6) {
        List<? extends TypeAttributeTranslator> r7 = r3;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r0.add(((TypeAttributeTranslator) r8.next()).toAttributes(r4, r5, r6));
        goto L4
    L6:
        List<? extends TypeAttribute<?>> r9 = CollectionsKt.flatten(r0);
        return TypeAttributes.Companion.create(r9);
    }

    public TypeDeserializer(DeserializationContext r4, TypeDeserializer r5, List<ProtoBuf$TypeParameter> r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "c");
        Intrinsics.checkNotNullParameter(r6, "typeParameterProtos");
        Intrinsics.checkNotNullParameter(r7, "debugName");
        Intrinsics.checkNotNullParameter(r8, "containerPresentableName");
        this.c = r4;
        this.parent = r5;
        this.debugName = r7;
        this.containerPresentableName = r8;
        this.classifierDescriptors = r4.getStorageManager().createMemoizedFunctionWithNullableValues(new TypeDeserializer$$Lambda$0(this));
        this.typeAliasDescriptors = r4.getStorageManager().createMemoizedFunctionWithNullableValues(new TypeDeserializer$$Lambda$1(this));
        if (r6.isEmpty() == false) goto L5;
        Map<Integer, TypeParameterDescriptor> r9 = MapsKt.emptyMap();
    L9:
        this.typeParameterDescriptors = r9;
        return;
    L5:
        r9 = new LinkedHashMap();
        Iterator<T> r10 = r6.iterator();
        int r11 = 0;
    L7:
        if (r10.hasNext() == false) goto L9;
        ProtoBuf$TypeParameter r12 = (ProtoBuf$TypeParameter) r10.next();
        r9.put(Integer.valueOf(r12.getId()), new DeserializedTypeParameterDescriptor(this.c, r12, r11));
        r11 = r11 + 1;
        goto L7
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeDeserializer r0, ProtoBuf$Type r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.simpleType(r1, r2);
    }
}
