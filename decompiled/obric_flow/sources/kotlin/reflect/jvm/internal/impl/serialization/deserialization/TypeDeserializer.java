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
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nTypeDeserializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/TypeDeserializer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,305:1\n1549#2:306\n1620#2,3:307\n1559#2:310\n1590#2,4:311\n1549#2:316\n1620#2,3:317\n1#3:315\n*S KotlinDebug\n*F\n+ 1 TypeDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/TypeDeserializer\n*L\n76#1:306\n76#1:307,3\n105#1:310\n105#1:311,4\n251#1:316\n251#1:317,3\n*E\n"})
public final class TypeDeserializer {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DeserializationContext f18756c;
    private final Function1<Integer, ClassifierDescriptor> classifierDescriptors;
    private final String containerPresentableName;
    private final String debugName;
    private final TypeDeserializer parent;
    private final Function1<Integer, ClassifierDescriptor> typeAliasDescriptors;
    private final Map<Integer, TypeParameterDescriptor> typeParameterDescriptors;

    public TypeDeserializer(DeserializationContext r5, TypeDeserializer r10, List<ProtoBuf.TypeParameter> r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r5, "c");
        Intrinsics.checkNotNullParameter(r11, "typeParameterProtos");
        Intrinsics.checkNotNullParameter(r12, "debugName");
        Intrinsics.checkNotNullParameter(r13, "containerPresentableName");
        this.f18756c = r5;
        this.parent = r10;
        this.debugName = r12;
        this.containerPresentableName = r13;
        this.classifierDescriptors = r5.getStorageManager().createMemoizedFunctionWithNullableValues(new TypeDeserializer$classifierDescriptors$1(this));
        this.typeAliasDescriptors = r5.getStorageManager().createMemoizedFunctionWithNullableValues(new TypeDeserializer$typeAliasDescriptors$1(this));
        if (r11.isEmpty() == false) goto L5;
        Map<Integer, TypeParameterDescriptor> r14 = MapsKt.emptyMap();
    L9:
        this.typeParameterDescriptors = r14;
        return;
    L5:
        r14 = new LinkedHashMap();
        Iterator<ProtoBuf.TypeParameter> r15 = r11.iterator();
        int r16 = 0;
    L7:
        if (r15.hasNext() == false) goto L9;
        ProtoBuf.TypeParameter r17 = r15.next();
        r14.put(Integer.valueOf(r17.getId()), new DeserializedTypeParameterDescriptor(this.f18756c, r17, r16));
        r16 = r16 + 1;
        goto L7
    }

    public static final /* synthetic */ ClassifierDescriptor access$computeClassifierDescriptor(TypeDeserializer r5, int r10) {
        return r5.computeClassifierDescriptor(r10);
    }

    public static final /* synthetic */ ClassifierDescriptor access$computeTypeAliasDescriptor(TypeDeserializer r5, int r10) {
        return r5.computeTypeAliasDescriptor(r10);
    }

    public static final /* synthetic */ DeserializationContext access$getC$p(TypeDeserializer r5) {
        return r5.f18756c;
    }

    private final ClassifierDescriptor computeClassifierDescriptor(int r5) {
        ClassId r10 = NameResolverUtilKt.getClassId(this.f18756c.getNameResolver(), r5);
        if (r10.isLocal() == false) goto L7;
        return this.f18756c.getComponents().deserializeClass(r10);
    L7:
        return FindClassInModuleKt.findClassifierAcrossModuleDependencies(this.f18756c.getComponents().getModuleDescriptor(), r10);
    }

    private final SimpleType computeLocalClassifierReplacementType(int r5) {
        if (NameResolverUtilKt.getClassId(this.f18756c.getNameResolver(), r5).isLocal() == true) goto L5;
        return null;
    L5:
        return this.f18756c.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
    }

    private final ClassifierDescriptor computeTypeAliasDescriptor(int r5) {
        ClassId r10 = NameResolverUtilKt.getClassId(this.f18756c.getNameResolver(), r5);
        if (r10.isLocal() == false) goto L7;
        return null;
    L7:
        return FindClassInModuleKt.findTypeAliasAcrossModuleDependencies(this.f18756c.getComponents().getModuleDescriptor(), r10);
    }

    private final SimpleType createSimpleSuspendFunctionType(KotlinType r10, KotlinType r11) {
        KotlinBuiltIns r5 = TypeUtilsKt.getBuiltIns(r10);
        Annotations r12 = r10.getAnnotations();
        KotlinType r13 = FunctionTypesKt.getReceiverTypeFromFunctionType(r10);
        List<KotlinType> r14 = FunctionTypesKt.getContextReceiverTypesFromFunctionType(r10);
        List r15 = CollectionsKt.dropLast(FunctionTypesKt.getValueParameterTypesFromFunctionType(r10), 1);
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator r17 = r15.iterator();
    L4:
        if (r17.hasNext() == false) goto L7;
        r16.add(((TypeProjection) r17.next()).getType());
        goto L4
    L7:
        return FunctionTypesKt.createFunctionType(r5, r12, r13, r14, r16, null, r11, true).makeNullableAsSpecified(r10.isMarkedNullable());
    }

    private final SimpleType createSuspendFunctionType(TypeAttributes r10, TypeConstructor r11, List<? extends TypeProjection> r12, boolean r13) {
        int r5 = r11.getParameters().size() - r12.size();
        if (r5 == 0) goto L10;
        SimpleType r14 = null;
        if (r5 != 1) goto L11;
        int r15 = r12.size() - 1;
        if (r15 < 0) goto L11;
        r14 = KotlinTypeFactory.simpleType$default(r10, r11.getBuiltIns().getSuspendFunction(r15).getTypeConstructor(), r12, r13, null, 16, null);
    L11:
        if (r14 == null) goto L13;
        return r14;
    L13:
        return ErrorUtils.INSTANCE.createErrorTypeWithArguments(ErrorTypeKind.INCONSISTENT_SUSPEND_FUNCTION, r12, r11, new String[0]);
    L10:
        r14 = createSuspendFunctionTypeForBasicCase(r10, r11, r12, r13);
        goto L11
    }

    private final SimpleType createSuspendFunctionTypeForBasicCase(TypeAttributes r10, TypeConstructor r11, List<? extends TypeProjection> r12, boolean r13) {
        SimpleType r14 = KotlinTypeFactory.simpleType$default(r10, r11, r12, r13, null, 16, null);
        if (FunctionTypesKt.isFunctionType(r14) == true) goto L6;
        return null;
    L6:
        return transformRuntimeFunctionTypeToSuspendFunction(r14);
    }

    private final TypeParameterDescriptor loadTypeParameter(int r5) {
        TypeParameterDescriptor r10 = this.typeParameterDescriptors.get(Integer.valueOf(r5));
        if (r10 != null) goto L9;
        TypeDeserializer r11 = this.parent;
        if (r11 != null) goto L10;
        return null;
    L10:
        return r11.loadTypeParameter(r5);
    L9:
        return r10;
    }

    private static final List<ProtoBuf.Type.Argument> simpleType$collectAllArguments(ProtoBuf.Type r5, TypeDeserializer r10) {
        List<ProtoBuf.Type.Argument> r11 = r5.getArgumentList();
        ProtoBuf.Type r12 = ProtoTypeTableUtilKt.outerType(r5, r10.f18756c.getTypeTable());
        if (r12 == null) goto L5;
        List<ProtoBuf.Type.Argument> r13 = simpleType$collectAllArguments(r12, r10);
    L6:
        if (r13 != null) goto L9;
        r13 = CollectionsKt.emptyList();
    L9:
        return CollectionsKt.plus(r11, r13);
    L5:
        r13 = null;
        goto L6
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeDeserializer r5, ProtoBuf.Type r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = true;
    L6:
        return r5.simpleType(r10, r11);
    }

    private final TypeAttributes toAttributes(List<? extends TypeAttributeTranslator> r5, Annotations r10, TypeConstructor r11, DeclarationDescriptor r12) {
        ArrayList r13 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r14 = r5.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13.add(((TypeAttributeTranslator) r14.next()).toAttributes(r10, r11, r12));
        goto L4
    L6:
        List<? extends TypeAttribute<?>> r15 = CollectionsKt.flatten(r13);
        return TypeAttributes.Companion.create(r15);
    }

    private final SimpleType transformRuntimeFunctionTypeToSuspendFunction(KotlinType r10) {
        TypeProjection r5 = (TypeProjection) CollectionsKt.lastOrNull(FunctionTypesKt.getValueParameterTypesFromFunctionType(r10));
        FqName r11 = null;
        if (r5 == null) goto L32;
        KotlinType r12 = r5.getType();
        if (r12 == null) goto L32;
        ClassifierDescriptor r13 = r12.getConstructor().mo1402getDeclarationDescriptor();
        if (r13 == null) goto L10;
        FqName r14 = DescriptorUtilsKt.getFqNameSafe(r13);
    L12:
        if (r12.getArguments().size() != 1) goto L31;
        if (Intrinsics.areEqual(r14, StandardNames.CONTINUATION_INTERFACE_FQ_NAME) == false) goto L16;
    L18:
        KotlinType r15 = ((TypeProjection) CollectionsKt.single(r12.getArguments())).getType();
        DeclarationDescriptor r16 = this.f18756c.getContainingDeclaration();
        if ((r16 instanceof CallableDescriptor) == false) goto L21;
        CallableDescriptor r17 = (CallableDescriptor) r16;
    L22:
        if (r17 == null) goto L25;
        r11 = DescriptorUtilsKt.fqNameOrNull(r17);
    L25:
        if (Intrinsics.areEqual(r11, SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME) == false) goto L29;
        return createSimpleSuspendFunctionType(r10, r15);
    L29:
        return createSimpleSuspendFunctionType(r10, r15);
    L21:
        r17 = null;
        goto L22
    L16:
        if (Intrinsics.areEqual(r14, TypeDeserializerKt.access$getEXPERIMENTAL_CONTINUATION_FQ_NAME$p()) == true) goto L18;
    L31:
        return (SimpleType) r10;
    L10:
        r14 = null;
    L32:
        return null;
    }

    private final TypeProjection typeArgument(TypeParameterDescriptor r5, ProtoBuf.Type.Argument r10) {
        if (r10.getProjection() != ProtoBuf.Type.Argument.Projection.STAR) goto L8;
        if (r5 != null) goto L7;
        return new StarProjectionForAbsentTypeParameter(this.f18756c.getComponents().getModuleDescriptor().getBuiltIns());
    L7:
        return new StarProjectionImpl(r5);
    L8:
        Variance r11 = ProtoEnumFlags.INSTANCE.variance(r10.getProjection());
        ProtoBuf.Type r12 = ProtoTypeTableUtilKt.type(r10, this.f18756c.getTypeTable());
        if (r12 != null) goto L13;
        return new TypeProjectionImpl(ErrorUtils.createErrorType(ErrorTypeKind.NO_RECORDED_TYPE, new String[]{r10.toString()}));
    L13:
        return new TypeProjectionImpl(r11, type(r12));
    }

    private final TypeConstructor typeConstructor(ProtoBuf.Type r5) {
        if (r5.hasClassName() == false) goto L8;
        ClassifierDescriptor r10 = this.classifierDescriptors.invoke(Integer.valueOf(r5.getClassName()));
        if (r10 != null) goto L32;
        r10 = typeConstructor$notFoundClass(this, r5, r5.getClassName());
    L32:
        return r10.getTypeConstructor();
    L8:
        if (r5.hasTypeParameter() == false) goto L14;
        r10 = loadTypeParameter(r5.getTypeParameter());
        if (r10 != null) goto L32;
        return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER, new String[]{String.valueOf(r5.getTypeParameter()), this.containerPresentableName});
    L14:
        if (r5.hasTypeParameterName() == false) goto L27;
        String r11 = this.f18756c.getNameResolver().getString(r5.getTypeParameterName());
        Iterator<T> r12 = getOwnTypeParameters().iterator();
    L17:
        if (r12.hasNext() == false) goto L21;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(((TypeParameterDescriptor) r13).getName().asString(), r11) == false) goto L17;
    L22:
        r10 = (TypeParameterDescriptor) r13;
        if (r10 != null) goto L32;
        return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME, new String[]{r11, this.f18756c.getContainingDeclaration().toString()});
    L21:
        r13 = null;
        goto L22
    L27:
        if (r5.hasTypeAliasName() == false) goto L34;
        r10 = this.typeAliasDescriptors.invoke(Integer.valueOf(r5.getTypeAliasName()));
        if (r10 != null) goto L32;
        r10 = typeConstructor$notFoundClass(this, r5, r5.getTypeAliasName());
        goto L32
    L34:
        return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.UNKNOWN_TYPE, new String[0]);
    }

    private static final ClassDescriptor typeConstructor$notFoundClass(final TypeDeserializer r5, ProtoBuf.Type r10, int r11) {
        ClassId r12 = NameResolverUtilKt.getClassId(r5.f18756c.getNameResolver(), r11);
        List<Integer> r13 = SequencesKt.toMutableList(SequencesKt.map(SequencesKt.generateSequence(r10, new TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1(r5)), TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2.INSTANCE));
        int r14 = SequencesKt.count(SequencesKt.generateSequence(r12, TypeDeserializer$typeConstructor$notFoundClass$classNestingLevel$1.INSTANCE));
    L4:
        if (r13.size() >= r14) goto L7;
        r13.add(0);
        goto L4
    L7:
        return r5.f18756c.getComponents().getNotFoundClasses().getClass(r12, r13);
    }

    public final List<TypeParameterDescriptor> getOwnTypeParameters() {
        return CollectionsKt.toList(this.typeParameterDescriptors.values());
    }

    public final SimpleType simpleType(final ProtoBuf.Type r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r18, "proto");
        if (r18.hasClassName() == false) goto L6;
        SimpleType r5 = computeLocalClassifierReplacementType(r18.getClassName());
    L9:
        if (r5 == null) goto L11;
        return r5;
    L11:
        TypeConstructor r10 = typeConstructor(r18);
        if (ErrorUtils.isError(r10.mo1402getDeclarationDescriptor()) == true) goto L14;
        DeserializedAnnotations r11 = new DeserializedAnnotations(this.f18756c.getStorageManager(), new TypeDeserializer$simpleType$annotations$1(this, r18));
        TypeAttributes r12 = toAttributes(this.f18756c.getComponents().getTypeAttributeTranslators(), r11, r10, this.f18756c.getContainingDeclaration());
        List<ProtoBuf.Type.Argument> r13 = simpleType$collectAllArguments(r18, this);
        ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator<T> r15 = r13.iterator();
        int r16 = 0;
    L17:
        if (r15.hasNext() == false) goto L22;
        Object r17 = r15.next();
        int r20 = r16 + 1;
        if (r16 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        r14.add(typeArgument((TypeParameterDescriptor) CollectionsKt.getOrNull(r10.getParameters(), r16), (ProtoBuf.Type.Argument) r17));
        r16 = r20;
        goto L17
    L22:
        List<? extends TypeProjection> r21 = CollectionsKt.toList(r14);
        ClassifierDescriptor r22 = r10.mo1402getDeclarationDescriptor();
        if (r19 == false) goto L35;
        if ((r22 instanceof TypeAliasDescriptor) == false) goto L35;
        SimpleType r23 = KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor) r22, r21);
        TypeAttributes r24 = toAttributes(this.f18756c.getComponents().getTypeAttributeTranslators(), Annotations.Companion.create(CollectionsKt.plus(r11, r23.getAnnotations())), r10, this.f18756c.getContainingDeclaration());
        if (KotlinTypeKt.isNullable(r23) == false) goto L29;
    L32:
        boolean r25 = true;
    L33:
        SimpleType r26 = r23.makeNullableAsSpecified(r25).replaceAttributes(r24);
    L44:
        ProtoBuf.Type r27 = ProtoTypeTableUtilKt.abbreviatedType(r18, this.f18756c.getTypeTable());
        if (r27 == null) goto L51;
        SimpleType r28 = SpecialTypesKt.withAbbreviation(r26, simpleType(r27, false));
        if (r28 == null) goto L51;
        r26 = r28;
    L51:
        if (r18.hasClassName() == true) goto L53;
        return r26;
    L53:
        return this.f18756c.getComponents().getPlatformDependentTypeTransformer().transformPlatformType(NameResolverUtilKt.getClassId(this.f18756c.getNameResolver(), r18.getClassName()), r26);
    L29:
        if (r18.getNullable() == true) goto L32;
        r25 = false;
    L35:
        if (Flags.SUSPEND_TYPE.get(r18.getFlags()).booleanValue() == false) goto L37;
        r26 = createSuspendFunctionType(r12, r10, r21, r18.getNullable());
        goto L44
    L37:
        r26 = KotlinTypeFactory.simpleType$default(r12, r10, r21, r18.getNullable(), null, 16, null);
        if (Flags.DEFINITELY_NOT_NULL_TYPE.get(r18.getFlags()).booleanValue() == false) goto L44;
        DefinitelyNotNullType r29 = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, r26, true, false, 4, null);
        if (r29 == null) goto L43;
        r26 = r29;
        goto L44
    L43:
        throw new IllegalStateException(("null DefinitelyNotNullType for '" + r26 + '\'').toString());
    L14:
        return ErrorUtils.INSTANCE.createErrorType(ErrorTypeKind.TYPE_FOR_ERROR_TYPE_CONSTRUCTOR, r10, new String[]{r10.toString()});
    L6:
        if (r18.hasTypeAliasName() == false) goto L8;
        r5 = computeLocalClassifierReplacementType(r18.getTypeAliasName());
        goto L9
    L8:
        r5 = null;
        goto L9
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.debugName);
        if (this.parent != null) goto L5;
        String r10 = "";
    L6:
        r5.append(r10);
        return r5.toString();
    L5:
        r10 = ". Child of " + this.parent.debugName;
        goto L6
    }

    public final KotlinType type(ProtoBuf.Type r10) {
        Intrinsics.checkNotNullParameter(r10, "proto");
        if (r10.hasFlexibleTypeCapabilitiesId() == false) goto L7;
        String r5 = this.f18756c.getNameResolver().getString(r10.getFlexibleTypeCapabilitiesId());
        SimpleType r11 = simpleType$default(this, r10, false, 2, null);
        ProtoBuf.Type r12 = ProtoTypeTableUtilKt.flexibleUpperBound(r10, this.f18756c.getTypeTable());
        Intrinsics.checkNotNull(r12);
        SimpleType r13 = simpleType$default(this, r12, false, 2, null);
        return this.f18756c.getComponents().getFlexibleTypeDeserializer().create(r10, r5, r11, r13);
    L7:
        return simpleType(r10, true);
    }
}
