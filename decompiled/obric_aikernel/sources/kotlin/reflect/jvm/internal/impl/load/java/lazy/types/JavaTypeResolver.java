package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaTypeResolver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f10215c;
    private final RawProjectionComputer projectionComputer;
    private final TypeParameterResolver typeParameterResolver;
    private final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeResolver(LazyJavaResolverContext r10, TypeParameterResolver r11) {
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r11, "typeParameterResolver");
        this.f10215c = r10;
        this.typeParameterResolver = r11;
        RawProjectionComputer r12 = new RawProjectionComputer();
        this.projectionComputer = r12;
        this.typeParameterUpperBoundEraser = new TypeParameterUpperBoundEraser(r12, null, 2, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ TypeParameterUpperBoundEraser access$getTypeParameterUpperBoundEraser$p(JavaTypeResolver r10) {
        return r10.typeParameterUpperBoundEraser;
    }

    private final boolean argumentsMakeSenseOnlyForMutableContainer(JavaClassifierType r10, ClassDescriptor r11) {
        if (JavaTypesKt.isSuperWildcard((JavaType) CollectionsKt.lastOrNull(r10.getTypeArguments())) == true) goto L5;
        return false;
    L5:
        List<TypeParameterDescriptor> r12 = JavaToKotlinClassMapper.INSTANCE.convertReadOnlyToMutable(r11).getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r12, "JavaToKotlinClassMapper.…ypeConstructor.parameters");
        TypeParameterDescriptor r13 = (TypeParameterDescriptor) CollectionsKt.lastOrNull(r12);
        if (r13 == null) goto L14;
        Variance r14 = r13.getVariance();
        if (r14 != null) goto L11;
        return false;
    L11:
        if (r14 == Variance.OUT_VARIANCE) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    }

    private final List<TypeProjection> computeArguments(JavaClassifierType r12, JavaTypeAttributes r13, TypeConstructor r14) {
        if (r12.isRaw() == false) goto L5;
    L10:
        boolean r10 = true;
    L11:
        List<TypeParameterDescriptor> r11 = r14.getParameters();
        Intrinsics.checkNotNullExpressionValue(r11, "constructor.parameters");
        if (r10 == false) goto L16;
        return computeRawTypeArguments(r12, r11, r14, r13);
    L16:
        if (r11.size() == r12.getTypeArguments().size()) goto L23;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r16 = r11.iterator();
    L19:
        if (r16.hasNext() == false) goto L22;
        TypeParameterDescriptor r17 = (TypeParameterDescriptor) r16.next();
        ErrorTypeKind r18 = ErrorTypeKind.MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER;
        String r19 = r17.getName().asString();
        Intrinsics.checkNotNullExpressionValue(r19, "p.name.asString()");
        r15.add(new TypeProjectionImpl(ErrorUtils.createErrorType(r18, new String[]{r19})));
        goto L19
    L22:
        return CollectionsKt.toList(r15);
    L23:
        Iterable r110 = CollectionsKt.withIndex(r12.getTypeArguments());
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r112 = r110.iterator();
    L25:
        if (r112.hasNext() == false) goto L28;
        IndexedValue r113 = (IndexedValue) r112.next();
        int r20 = r113.component1();
        JavaType r114 = (JavaType) r113.component2();
        r11.size();
        TypeParameterDescriptor r21 = r11.get(r20);
        JavaTypeAttributes r22 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null);
        Intrinsics.checkNotNullExpressionValue(r21, "parameter");
        r111.add(transformToTypeProjection(r114, r22, r21));
        goto L25
    L28:
        return CollectionsKt.toList(r111);
    L5:
        if (r12.getTypeArguments().isEmpty() == false) goto L9;
        List<TypeParameterDescriptor> r23 = r14.getParameters();
        Intrinsics.checkNotNullExpressionValue(r23, "constructor.parameters");
        if ((!r23.isEmpty()) == true) goto L10;
    L9:
        r10 = false;
        goto L11
    }

    private final List<TypeProjection> computeRawTypeArguments(final JavaClassifierType r12, List<? extends TypeParameterDescriptor> r13, final TypeConstructor r14, final JavaTypeAttributes r15) {
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r16 = r13.iterator();
    L4:
        if (r16.hasNext() == false) goto L10;
        final TypeParameterDescriptor r11 = (TypeParameterDescriptor) r16.next();
        if (TypeUtilsKt.hasTypeParameterRecursiveBounds(r11, null, r15.getVisitedTypeParameters()) == false) goto L8;
        TypeProjection r17 = TypeUtils.makeStarProjection(r11, r15);
    L9:
        r10.add(r17);
        goto L4
    L8:
        LazyWrappedType r18 = new LazyWrappedType(this.f10215c.getStorageManager(), new JavaTypeResolver$computeRawTypeArguments$1$erasedUpperBound$1(this, r11, r15, r14, r12));
        r17 = this.projectionComputer.computeProjection(r11, r15.markIsRaw(r12.isRaw()), this.typeParameterUpperBoundEraser, r18);
        goto L9
    L10:
        return r10;
    }

    private final SimpleType computeSimpleJavaClassifierType(JavaClassifierType r10, JavaTypeAttributes r11, SimpleType r12) {
        if (r12 == null) goto L5;
        TypeAttributes r13 = r12.getAttributes();
        if (r13 == null) goto L5;
    L6:
        TypeAttributes r14 = r13;
        TypeConstructor r15 = computeTypeConstructor(r10, r11);
        TypeConstructor r16 = null;
        if (r15 != null) goto L9;
        return null;
    L9:
        boolean r17 = isNullable(r11);
        if (r12 == null) goto L13;
        r16 = r12.getConstructor();
    L13:
        if (Intrinsics.areEqual(r16, r15) == false) goto L20;
        if (r10.isRaw() == true) goto L20;
        if (r17 == false) goto L20;
        return r12.makeNullableAsSpecified(true);
    L20:
        return KotlinTypeFactory.simpleType$default(r14, r15, computeArguments(r10, r11, r15), r17, null, 16, null);
    L5:
        r13 = TypeAttributesKt.toDefaultAttributes(new LazyJavaAnnotations(this.f10215c, r10, false, 4, null));
        goto L6
    }

    private final TypeConstructor computeTypeConstructor(JavaClassifierType r10, JavaTypeAttributes r11) {
        JavaClassifier r12 = r10.getClassifier();
        if (r12 != null) goto L7;
        return createNotFoundClass(r10);
    L7:
        if ((r12 instanceof JavaClass) == false) goto L20;
        JavaClass r13 = (JavaClass) r12;
        FqName r14 = r13.getFqName();
        if (r14 == null) goto L18;
        ClassDescriptor r15 = mapKotlinClass(r10, r11, r14);
        if (r15 != null) goto L13;
        r15 = this.f10215c.getComponents().getModuleClassResolver().resolveClass(r13);
    L13:
        if (r15 == null) goto L29;
        TypeConstructor r16 = r15.getTypeConstructor();
        if (r16 == null) goto L29;
        return r16;
    L29:
        return createNotFoundClass(r10);
    L18:
        throw new AssertionError("Class type should have a FQ name: " + r12);
    L20:
        if ((r12 instanceof JavaTypeParameter) == false) goto L27;
        TypeParameterDescriptor r17 = this.typeParameterResolver.resolveTypeParameter((JavaTypeParameter) r12);
        if (r17 != null) goto L30;
        return null;
    L30:
        return r17.getTypeConstructor();
    L27:
        throw new IllegalStateException("Unknown classifier kind: " + r12);
    }

    private final TypeConstructor createNotFoundClass(JavaClassifierType r10) {
        ClassId r11 = ClassId.topLevel(new FqName(r10.getClassifierQualifiedName()));
        Intrinsics.checkNotNullExpressionValue(r11, "topLevel(FqName(javaType.classifierQualifiedName))");
        TypeConstructor r12 = this.f10215c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(r11, CollectionsKt.listOf(0)).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r12, "c.components.deserialize…istOf(0)).typeConstructor");
        return r12;
    }

    private final boolean isConflictingArgumentFor(Variance r10, TypeParameterDescriptor r11) {
        if (r11.getVariance() != Variance.INVARIANT) goto L6;
        return false;
    L6:
        if (r10 == r11.getVariance()) goto L9;
        return true;
    L9:
        return false;
    }

    private final boolean isNullable(JavaTypeAttributes r10) {
        if (r10.getFlexibility() != JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND) goto L6;
        return false;
    L6:
        if (r10.isForAnnotationParameter() == false) goto L8;
        return false;
    L8:
        if (r10.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) goto L12;
        return true;
    L12:
        return false;
    }

    private final ClassDescriptor mapKotlinClass(JavaClassifierType r10, JavaTypeAttributes r11, FqName r12) {
        if (r11.isForAnnotationParameter() == true) goto L5;
    L8:
        JavaToKotlinClassMapper r13 = JavaToKotlinClassMapper.INSTANCE;
        ClassDescriptor r14 = JavaToKotlinClassMapper.mapJavaToKotlin$default(r13, r12, this.f10215c.getModule().getBuiltIns(), null, 4, null);
        if (r14 != null) goto L13;
        return null;
    L13:
        if (r13.isReadOnly(r14) == true) goto L15;
    L22:
        return r14;
    L15:
        if (r11.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND) goto L21;
        if (r11.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) goto L21;
        if (argumentsMakeSenseOnlyForMutableContainer(r10, r14) == false) goto L22;
    L21:
        return r13.convertReadOnlyToMutable(r14);
    L5:
        if (Intrinsics.areEqual(r12, JavaTypeResolverKt.access$getJAVA_LANG_CLASS_FQ_NAME$p()) == false) goto L8;
        return this.f10215c.getComponents().getReflectionTypes().getKClass();
    }

    public static /* synthetic */ KotlinType transformArrayType$default(JavaTypeResolver r10, JavaArrayType r11, JavaTypeAttributes r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = false;
    L6:
        return r10.transformArrayType(r11, r12, r13);
    }

    private final KotlinType transformJavaClassifierType(JavaClassifierType r10, JavaTypeAttributes r11) {
        if (r11.isForAnnotationParameter() == false) goto L5;
    L7:
        boolean r12 = false;
    L8:
        boolean r13 = r10.isRaw();
        if (r13 == true) goto L16;
        if (r12 == true) goto L16;
        SimpleType r14 = computeSimpleJavaClassifierType(r10, r11, null);
        if (r14 == null) goto L15;
        return r14;
    L15:
        return transformJavaClassifierType$errorType(r10);
    L16:
        SimpleType r15 = computeSimpleJavaClassifierType(r10, r11.withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
        if (r15 == null) goto L19;
        SimpleType r16 = computeSimpleJavaClassifierType(r10, r11.withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), r15);
        if (r16 == null) goto L23;
        if (r13 == false) goto L27;
        return new RawTypeImpl(r15, r16);
    L27:
        return KotlinTypeFactory.flexibleType(r15, r16);
    L23:
        return transformJavaClassifierType$errorType(r10);
    L19:
        return transformJavaClassifierType$errorType(r10);
    L5:
        if (r11.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) goto L7;
        r12 = true;
        goto L8
    }

    private static final ErrorType transformJavaClassifierType$errorType(JavaClassifierType r10) {
        return ErrorUtils.createErrorType(ErrorTypeKind.UNRESOLVED_JAVA_CLASS, new String[]{r10.getPresentableText()});
    }

    private final TypeProjection transformToTypeProjection(JavaType r10, JavaTypeAttributes r11, TypeParameterDescriptor r12) {
        if ((r10 instanceof JavaWildcardType) == false) goto L16;
        JavaWildcardType r13 = (JavaWildcardType) r10;
        JavaType r14 = r13.getBound();
        if (r13.isExtends() == false) goto L7;
        Variance r15 = Variance.OUT_VARIANCE;
    L8:
        if (r14 != null) goto L10;
    L13:
        TypeProjection r16 = TypeUtils.makeStarProjection(r12, r11);
    L14:
        Intrinsics.checkNotNullExpressionValue(r16, "{\n                val bo…          }\n            }");
        return r16;
    L10:
        if (isConflictingArgumentFor(r15, r12) == true) goto L13;
        r16 = TypeUtilsKt.createProjection(transformJavaType(r14, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null)), r15, r12);
        goto L14
    L7:
        r15 = Variance.IN_VARIANCE;
        goto L8
    L16:
        return new TypeProjectionImpl(Variance.INVARIANT, transformJavaType(r10, r11));
    }

    public final KotlinType transformArrayType(JavaArrayType r12, JavaTypeAttributes r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "arrayType");
        Intrinsics.checkNotNullParameter(r13, "attr");
        JavaType r10 = r12.getComponentType();
        PrimitiveType r11 = null;
        if ((r10 instanceof JavaPrimitiveType) == false) goto L5;
        JavaPrimitiveType r15 = (JavaPrimitiveType) r10;
    L6:
        if (r15 == null) goto L8;
        r11 = r15.getType();
    L8:
        LazyJavaAnnotations r16 = new LazyJavaAnnotations(this.f10215c, r12, true);
        if (r11 == null) goto L15;
        SimpleType r17 = this.f10215c.getModule().getBuiltIns().getPrimitiveArrayKotlinType(r11);
        Intrinsics.checkNotNullExpressionValue(r17, "c.module.builtIns.getPri…KotlinType(primitiveType)");
        TypeUtilsKt.replaceAnnotations(r17, Annotations.Companion.create(CollectionsKt.plus(r16, r17.getAnnotations())));
        if (r13.isForAnnotationParameter() == false) goto L14;
        return r17;
    L14:
        return KotlinTypeFactory.flexibleType(r17, r17.makeNullableAsSpecified(true));
    L15:
        KotlinType r18 = transformJavaType(r10, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, r13.isForAnnotationParameter(), false, null, 6, null));
        if (r13.isForAnnotationParameter() == false) goto L22;
        if (r14 == false) goto L19;
        Variance r19 = Variance.OUT_VARIANCE;
    L20:
        SimpleType r110 = this.f10215c.getModule().getBuiltIns().getArrayType(r19, r18, r16);
        Intrinsics.checkNotNullExpressionValue(r110, "c.module.builtIns.getArr…mponentType, annotations)");
        return r110;
    L19:
        r19 = Variance.INVARIANT;
        goto L20
    L22:
        SimpleType r111 = this.f10215c.getModule().getBuiltIns().getArrayType(Variance.INVARIANT, r18, r16);
        Intrinsics.checkNotNullExpressionValue(r111, "c.module.builtIns.getArr…mponentType, annotations)");
        return KotlinTypeFactory.flexibleType(r111, this.f10215c.getModule().getBuiltIns().getArrayType(Variance.OUT_VARIANCE, r18, r16).makeNullableAsSpecified(true));
    L5:
        r15 = null;
        goto L6
    }

    public final KotlinType transformJavaType(JavaType r10, JavaTypeAttributes r11) {
        Intrinsics.checkNotNullParameter(r11, "attr");
        if ((r10 instanceof JavaPrimitiveType) == false) goto L10;
        PrimitiveType r12 = ((JavaPrimitiveType) r10).getType();
        KotlinBuiltIns r13 = this.f10215c.getModule().getBuiltIns();
        if (r12 == null) goto L7;
        SimpleType r14 = r13.getPrimitiveKotlinType(r12);
    L8:
        Intrinsics.checkNotNullExpressionValue(r14, "{\n                val pr…ns.unitType\n            }");
        return r14;
    L7:
        r14 = r13.getUnitType();
        goto L8
    L10:
        if ((r10 instanceof JavaClassifierType) == false) goto L13;
        return transformJavaClassifierType((JavaClassifierType) r10, r11);
    L13:
        if ((r10 instanceof JavaArrayType) == false) goto L16;
        return transformArrayType$default(this, (JavaArrayType) r10, r11, false, 4, null);
    L16:
        if ((r10 instanceof JavaWildcardType) == false) goto L23;
        JavaType r15 = ((JavaWildcardType) r10).getBound();
        if (r15 == null) goto L24;
        KotlinType r16 = transformJavaType(r15, r11);
        if (r16 == null) goto L24;
        return r16;
    L24:
        SimpleType r17 = this.f10215c.getModule().getBuiltIns().getDefaultBound();
        Intrinsics.checkNotNullExpressionValue(r17, "c.module.builtIns.defaultBound");
        return r17;
    L23:
        if (r10 == null) goto L24;
        throw new UnsupportedOperationException("Unsupported type: " + r10);
    }
}
