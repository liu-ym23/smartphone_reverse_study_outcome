package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
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
import kotlin.reflect.jvm.internal.impl.types.TypeParameterErasureOptions;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JavaTypeResolver {
    private final LazyJavaResolverContext c;
    private final RawProjectionComputer projectionComputer;
    private final TypeParameterResolver typeParameterResolver;
    private final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    public static /* synthetic */ KotlinType accessor$JavaTypeResolver$lambda0(JavaTypeResolver r0, TypeParameterDescriptor r1, JavaTypeAttributes r2, TypeConstructor r3, JavaClassifierType r4) {
        return computeRawTypeArguments$lambda$4$lambda$3(r0, r1, r2, r3, r4);
    }

    private final TypeConstructor createNotFoundClass(JavaClassifierType r3) {
        ClassId r4 = ClassId.Companion.topLevel(new FqName(r3.getClassifierQualifiedName()));
        return this.c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(r4, CollectionsKt.listOf(0)).getTypeConstructor();
    }

    private final boolean isNullable(JavaTypeAttributes r4) {
        if (r4.getFlexibility() != JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND) goto L6;
        return false;
    L6:
        if (r4.isForAnnotationParameter() == false) goto L8;
        return false;
    L8:
        if (r4.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) goto L12;
        return true;
    L12:
        return false;
    }

    private static final ErrorType transformJavaClassifierType$errorType(JavaClassifierType r3) {
        return ErrorUtils.createErrorType(ErrorTypeKind.UNRESOLVED_JAVA_CLASS, new String[]{r3.getPresentableText()});
    }

    public JavaTypeResolver(LazyJavaResolverContext r3, TypeParameterResolver r4) {
        Intrinsics.checkNotNullParameter(r3, "c");
        Intrinsics.checkNotNullParameter(r4, "typeParameterResolver");
        this.c = r3;
        this.typeParameterResolver = r4;
        RawProjectionComputer r5 = new RawProjectionComputer();
        this.projectionComputer = r5;
        TypeParameterErasureOptions r0 = null;
        this.typeParameterUpperBoundEraser = new TypeParameterUpperBoundEraser(r5, r0, 2, r0);
    }

    private final boolean argumentsMakeSenseOnlyForMutableContainer(JavaClassifierType r2, ClassDescriptor r3) {
        if (JavaTypesKt.isSuperWildcard((JavaType) CollectionsKt.lastOrNull(r2.getTypeArguments())) == true) goto L5;
        return false;
    L5:
        TypeParameterDescriptor r4 = (TypeParameterDescriptor) CollectionsKt.lastOrNull(JavaToKotlinClassMapper.INSTANCE.convertReadOnlyToMutable(r3).getTypeConstructor().getParameters());
        if (r4 == null) goto L13;
        Variance r5 = r4.getVariance();
        if (r5 != null) goto L10;
        return false;
    L10:
        if (r5 == Variance.OUT_VARIANCE) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    private final TypeConstructor computeTypeConstructor(JavaClassifierType r4, JavaTypeAttributes r5) {
        JavaClass r0 = r4.getClassifier();
        if (r0 != null) goto L7;
        return createNotFoundClass(r4);
    L7:
        if ((r0 instanceof JavaClass) == false) goto L20;
        JavaClass r1 = r0;
        FqName r2 = r1.getFqName();
        if (r2 == null) goto L18;
        ClassDescriptor r6 = mapKotlinClass(r4, r5, r2);
        if (r6 != null) goto L13;
        r6 = this.c.getComponents().getModuleClassResolver().resolveClass(r1);
    L13:
        if (r6 == null) goto L29;
        TypeConstructor r7 = r6.getTypeConstructor();
        if (r7 == null) goto L29;
        return r7;
    L29:
        return createNotFoundClass(r4);
    L18:
        throw new AssertionError("Class type should have a FQ name: " + r0);
    L20:
        if ((r0 instanceof JavaTypeParameter) == false) goto L27;
        TypeParameterDescriptor r8 = this.typeParameterResolver.resolveTypeParameter((JavaTypeParameter) r0);
        if (r8 != null) goto L30;
        return null;
    L30:
        return r8.getTypeConstructor();
    L27:
        throw new IllegalStateException("Unknown classifier kind: " + r0);
    }

    private final boolean isConflictingArgumentFor(Variance r4, TypeParameterDescriptor r5) {
        if (r5.getVariance() != Variance.INVARIANT) goto L6;
        return false;
    L6:
        if (r4 == r5.getVariance()) goto L9;
        return true;
    L9:
        return false;
    }

    private final KotlinType transformJavaClassifierType(JavaClassifierType r4, JavaTypeAttributes r5) {
        if (r5.isForAnnotationParameter() == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        boolean r1 = r4.isRaw();
        if (r1 == true) goto L16;
        if (r0 == true) goto L16;
        SimpleType r6 = computeSimpleJavaClassifierType(r4, r5, null);
        if (r6 == null) goto L15;
        return r6;
    L15:
        return transformJavaClassifierType$errorType(r4);
    L16:
        SimpleType r2 = computeSimpleJavaClassifierType(r4, r5.withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
        if (r2 == null) goto L19;
        SimpleType r7 = computeSimpleJavaClassifierType(r4, r5.withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), r2);
        if (r7 == null) goto L23;
        if (r1 == false) goto L27;
        return new RawTypeImpl(r2, r7);
    L27:
        return KotlinTypeFactory.flexibleType(r2, r7);
    L23:
        return transformJavaClassifierType$errorType(r4);
    L19:
        return transformJavaClassifierType$errorType(r4);
    L5:
        if (r5.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) goto L7;
        r0 = true;
        goto L8
    }

    public final KotlinType transformJavaType(JavaType r8, JavaTypeAttributes r9) {
        Intrinsics.checkNotNullParameter(r9, "attr");
        if ((r8 instanceof JavaPrimitiveType) == false) goto L10;
        PrimitiveType r10 = ((JavaPrimitiveType) r8).getType();
        if (r10 == null) goto L7;
        SimpleType r11 = this.c.getModule().getBuiltIns().getPrimitiveKotlinType(r10);
    L8:
        Intrinsics.checkNotNull(r11);
        return r11;
    L7:
        r11 = this.c.getModule().getBuiltIns().getUnitType();
        goto L8
    L10:
        if ((r8 instanceof JavaClassifierType) == false) goto L13;
        return transformJavaClassifierType((JavaClassifierType) r8, r9);
    L13:
        if ((r8 instanceof JavaArrayType) == false) goto L16;
        return transformArrayType$default(this, (JavaArrayType) r8, r9, false, 4, null);
    L16:
        if ((r8 instanceof JavaWildcardType) == false) goto L22;
        JavaType r12 = ((JavaWildcardType) r8).getBound();
        if (r12 == null) goto L31;
        KotlinType r13 = transformJavaType(r12, r9);
        if (r13 == null) goto L31;
        return r13;
    L31:
        return this.c.getModule().getBuiltIns().getDefaultBound();
    L22:
        if (r8 != null) goto L26;
        return this.c.getModule().getBuiltIns().getDefaultBound();
    L26:
        throw new UnsupportedOperationException("Unsupported type: " + r8);
    }

    private final List<TypeProjection> computeArguments(JavaClassifierType r11, JavaTypeAttributes r12, TypeConstructor r13) {
        if (r11.isRaw() == false) goto L5;
    L10:
        boolean r0 = true;
    L11:
        List<TypeParameterDescriptor> r3 = r13.getParameters();
        if (r0 == false) goto L16;
        return computeRawTypeArguments(r11, r3, r13, r12);
    L16:
        if (r3.size() == r11.getTypeArguments().size()) goto L23;
        List<TypeParameterDescriptor> r4 = r3;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r15 = r4.iterator();
    L19:
        if (r15.hasNext() == false) goto L22;
        r14.add(new TypeProjectionImpl(ErrorUtils.createErrorType(ErrorTypeKind.MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER, new String[]{((TypeParameterDescriptor) r15.next()).getName().asString()})));
        goto L19
    L22:
        return CollectionsKt.toList(r14);
    L23:
        Iterable r16 = CollectionsKt.withIndex(r11.getTypeArguments());
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r18 = r16.iterator();
    L25:
        if (r18.hasNext() == false) goto L28;
        IndexedValue r19 = (IndexedValue) r18.next();
        int r1 = r19.component1();
        JavaType r110 = (JavaType) r19.component2();
        r3.size();
        TypeParameterDescriptor r2 = (TypeParameterDescriptor) ListProtector.get(r3, r1);
        JavaTypeAttributes r5 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null);
        Intrinsics.checkNotNull(r2);
        r17.add(transformToTypeProjection(r110, r5, r2));
        goto L25
    L28:
        return CollectionsKt.toList(r17);
    L5:
        if (r11.getTypeArguments().isEmpty() == true) goto L7;
    L9:
        r0 = false;
        goto L11
    L7:
        if ((!r13.getParameters().isEmpty()) == false) goto L9;
        goto L9
    }

    private final SimpleType computeSimpleJavaClassifierType(JavaClassifierType r9, JavaTypeAttributes r10, SimpleType r11) {
        if (r11 == null) goto L5;
        TypeAttributes r0 = r11.getAttributes();
        if (r0 == null) goto L5;
    L6:
        TypeAttributes r1 = r0;
        TypeConstructor r2 = computeTypeConstructor(r9, r10);
        TypeConstructor r3 = null;
        if (r2 != null) goto L9;
        return null;
    L9:
        boolean r4 = isNullable(r10);
        if (r11 == null) goto L13;
        r3 = r11.getConstructor();
    L13:
        if (Intrinsics.areEqual(r3, r2) == false) goto L20;
        if (r9.isRaw() == true) goto L20;
        if (r4 == false) goto L20;
        return r11.makeNullableAsSpecified(true);
    L20:
        return KotlinTypeFactory.simpleType$default(r1, r2, computeArguments(r9, r10, r2), r4, null, 16, null);
    L5:
        r0 = TypeAttributesKt.toDefaultAttributes(new LazyJavaAnnotations(this.c, r9, false, 4, null));
        goto L6
    }

    private final ClassDescriptor mapKotlinClass(JavaClassifierType r8, JavaTypeAttributes r9, FqName r10) {
        if (r9.isForAnnotationParameter() == true) goto L5;
    L8:
        JavaToKotlinClassMapper r6 = JavaToKotlinClassMapper.INSTANCE;
        ClassDescriptor r11 = JavaToKotlinClassMapper.mapJavaToKotlin$default(r6, r10, this.c.getModule().getBuiltIns(), null, 4, null);
        if (r11 != null) goto L13;
        return null;
    L13:
        if (r6.isReadOnly(r11) == true) goto L15;
    L22:
        return r11;
    L15:
        if (r9.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND) goto L21;
        if (r9.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) goto L21;
        if (argumentsMakeSenseOnlyForMutableContainer(r8, r11) == false) goto L22;
    L21:
        return r6.convertReadOnlyToMutable(r11);
    L5:
        if (Intrinsics.areEqual(r10, JavaTypeResolverKt.access$getJAVA_LANG_CLASS_FQ_NAME$p()) == false) goto L8;
        return this.c.getComponents().getReflectionTypes().getKClass();
    }

    private final TypeProjection transformToTypeProjection(JavaType r9, JavaTypeAttributes r10, TypeParameterDescriptor r11) {
        if ((r9 instanceof JavaWildcardType) == false) goto L18;
        JavaWildcardType r12 = (JavaWildcardType) r9;
        JavaType r0 = r12.getBound();
        if (r12.isExtends() == false) goto L7;
        Variance r1 = Variance.OUT_VARIANCE;
    L8:
        if (r0 == null) goto L20;
        if (isConflictingArgumentFor(r1, r11) == true) goto L20;
        AnnotationDescriptor r13 = UtilsKt.extractNullabilityAnnotationOnBoundedWildcard(this.c, r12);
        KotlinType r14 = transformJavaType(r0, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null));
        if (r13 == null) goto L19;
        r14 = TypeUtilsKt.replaceAnnotations(r14, Annotations.Companion.create(CollectionsKt.plus(r14.getAnnotations(), r13)));
    L19:
        return TypeUtilsKt.createProjection(r14, r1, r11);
    L20:
        return TypeUtils.makeStarProjection(r11, r10);
    L7:
        r1 = Variance.IN_VARIANCE;
        goto L8
    L18:
        return new TypeProjectionImpl(Variance.INVARIANT, transformJavaType(r9, r10));
    }

    public final KotlinType transformArrayType(JavaArrayType r12, JavaTypeAttributes r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "arrayType");
        Intrinsics.checkNotNullParameter(r13, "attr");
        JavaPrimitiveType r0 = r12.getComponentType();
        PrimitiveType r2 = null;
        if ((r0 instanceof JavaPrimitiveType) == false) goto L5;
        JavaPrimitiveType r1 = r0;
    L6:
        if (r1 == null) goto L8;
        r2 = r1.getType();
    L8:
        LazyJavaAnnotations r3 = new LazyJavaAnnotations(this.c, r12, true);
        if (r2 == null) goto L15;
        SimpleType r15 = this.c.getModule().getBuiltIns().getPrimitiveArrayKotlinType(r2);
        Intrinsics.checkNotNull(r15);
        KotlinType r16 = TypeUtilsKt.replaceAnnotations(r15, new CompositeAnnotations(new Annotations[]{r15.getAnnotations(), r3}));
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        SimpleType r17 = (SimpleType) r16;
        if (r13.isForAnnotationParameter() == false) goto L14;
        return r17;
    L14:
        return KotlinTypeFactory.flexibleType(r17, r17.makeNullableAsSpecified(true));
    L15:
        KotlinType r18 = transformJavaType(r0, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, r13.isForAnnotationParameter(), false, null, 6, null));
        if (r13.isForAnnotationParameter() == false) goto L23;
        if (r14 == false) goto L19;
        Variance r19 = Variance.OUT_VARIANCE;
    L21:
        return this.c.getModule().getBuiltIns().getArrayType(r19, r18, r3);
    L19:
        r19 = Variance.INVARIANT;
        goto L21
    L23:
        return KotlinTypeFactory.flexibleType(this.c.getModule().getBuiltIns().getArrayType(Variance.INVARIANT, r18, r3), this.c.getModule().getBuiltIns().getArrayType(Variance.OUT_VARIANCE, r18, r3).makeNullableAsSpecified(true));
    L5:
        r1 = null;
        goto L6
    }

    private final List<TypeProjection> computeRawTypeArguments(JavaClassifierType r12, List<? extends TypeParameterDescriptor> r13, TypeConstructor r14, JavaTypeAttributes r15) {
        List<? extends TypeParameterDescriptor> r16 = r13;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r17 = r16.iterator();
    L4:
        if (r17.hasNext() == false) goto L10;
        TypeParameterDescriptor r1 = (TypeParameterDescriptor) r17.next();
        if (TypeUtilsKt.hasTypeParameterRecursiveBounds(r1, null, r15.getVisitedTypeParameters()) == false) goto L8;
        TypeProjection r2 = TypeUtils.makeStarProjection(r1, r15);
    L9:
        r0.add(r2);
        goto L4
    L8:
        LazyWrappedType r8 = new LazyWrappedType(this.c.getStorageManager(), new JavaTypeResolver$.Lambda.0(this, r1, r15, r14, r12));
        r2 = this.projectionComputer.computeProjection(r1, r15.markIsRaw(r12.isRaw()), this.typeParameterUpperBoundEraser, r8);
        goto L9
    L10:
        return r0;
    }

    private static final KotlinType computeRawTypeArguments$lambda$4$lambda$3(JavaTypeResolver r1, TypeParameterDescriptor r2, JavaTypeAttributes r3, TypeConstructor r4, JavaClassifierType r5) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$parameter");
        Intrinsics.checkNotNullParameter(r3, "$attr");
        Intrinsics.checkNotNullParameter(r4, "$constructor");
        Intrinsics.checkNotNullParameter(r5, "$javaType");
        TypeParameterUpperBoundEraser r6 = r1.typeParameterUpperBoundEraser;
        ClassifierDescriptor r7 = r4.getDeclarationDescriptor();
        if (r7 == null) goto L5;
        SimpleType r8 = r7.getDefaultType();
    L7:
        return r6.getErasedUpperBound(r2, r3.withDefaultType(r8).markIsRaw(r5.isRaw()));
    L5:
        r8 = null;
        goto L7
    }

    public static /* synthetic */ KotlinType transformArrayType$default(JavaTypeResolver r0, JavaArrayType r1, JavaTypeAttributes r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return r0.transformArrayType(r1, r2, r3);
    }
}
