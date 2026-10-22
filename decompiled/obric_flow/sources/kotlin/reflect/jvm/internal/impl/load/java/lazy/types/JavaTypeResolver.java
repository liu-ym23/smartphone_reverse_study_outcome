package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
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
@SourceDebugExtension({"SMAP\nJavaTypeResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaTypeResolver.kt\norg/jetbrains/kotlin/load/java/lazy/types/JavaTypeResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 coreLib.kt\norg/jetbrains/kotlin/utils/CoreLibKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,321:1\n1#2:322\n19#3:323\n1549#4:324\n1620#4,3:325\n1549#4:328\n1620#4,3:329\n1549#4:332\n1620#4,3:333\n*S KotlinDebug\n*F\n+ 1 JavaTypeResolver.kt\norg/jetbrains/kotlin/load/java/lazy/types/JavaTypeResolver\n*L\n144#1:323\n205#1:324\n205#1:325,3\n263#1:328\n263#1:329,3\n267#1:332\n267#1:333,3\n*E\n"})
public final class JavaTypeResolver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f18751c;
    private final RawProjectionComputer projectionComputer;
    private final TypeParameterResolver typeParameterResolver;
    private final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeResolver(LazyJavaResolverContext r5, TypeParameterResolver r10) {
        Intrinsics.checkNotNullParameter(r5, "c");
        Intrinsics.checkNotNullParameter(r10, "typeParameterResolver");
        this.f18751c = r5;
        this.typeParameterResolver = r10;
        RawProjectionComputer r11 = new RawProjectionComputer();
        this.projectionComputer = r11;
        this.typeParameterUpperBoundEraser = new TypeParameterUpperBoundEraser(r11, null, 2, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ TypeParameterUpperBoundEraser access$getTypeParameterUpperBoundEraser$p(JavaTypeResolver r5) {
        return r5.typeParameterUpperBoundEraser;
    }

    private final boolean argumentsMakeSenseOnlyForMutableContainer(JavaClassifierType r5, ClassDescriptor r10) {
        if (JavaTypesKt.isSuperWildcard((JavaType) CollectionsKt.lastOrNull(r5.getTypeArguments())) == true) goto L5;
        return false;
    L5:
        TypeParameterDescriptor r11 = (TypeParameterDescriptor) CollectionsKt.lastOrNull(JavaToKotlinClassMapper.INSTANCE.convertReadOnlyToMutable(r10).getTypeConstructor().getParameters());
        if (r11 == null) goto L14;
        Variance r12 = r11.getVariance();
        if (r12 != null) goto L11;
        return false;
    L11:
        if (r12 == Variance.OUT_VARIANCE) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    }

    private final List<TypeProjection> computeArguments(JavaClassifierType r10, JavaTypeAttributes r11, TypeConstructor r12) {
        if (r10.isRaw() == false) goto L5;
    L10:
        boolean r5 = true;
    L11:
        List<TypeParameterDescriptor> r13 = r12.getParameters();
        if (r5 == false) goto L16;
        return computeRawTypeArguments(r10, r13, r12, r11);
    L16:
        if (r13.size() == r10.getTypeArguments().size()) goto L23;
        ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator<T> r15 = r13.iterator();
    L19:
        if (r15.hasNext() == false) goto L22;
        TypeParameterDescriptor r16 = (TypeParameterDescriptor) r15.next();
        r14.add(new TypeProjectionImpl(ErrorUtils.createErrorType(ErrorTypeKind.MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER, new String[]{r16.getName().asString()})));
        goto L19
    L22:
        return CollectionsKt.toList(r14);
    L23:
        Iterable r17 = CollectionsKt.withIndex(r10.getTypeArguments());
        ArrayList r18 = new ArrayList(CollectionsKt.h(r17));
        Iterator r19 = r17.iterator();
    L25:
        if (r19.hasNext() == false) goto L28;
        IndexedValue r110 = (IndexedValue) r19.next();
        int r20 = r110.component1();
        JavaType r111 = (JavaType) r110.component2();
        r13.size();
        TypeParameterDescriptor r21 = r13.get(r20);
        r18.add(transformToTypeProjection(r111, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null), r21));
        goto L25
    L28:
        return CollectionsKt.toList(r18);
    L5:
        if (r10.getTypeArguments().isEmpty() == true) goto L7;
    L9:
        r5 = false;
        goto L11
    L7:
        if (r12.getParameters().isEmpty() == true) goto L9;
        goto L9
    }

    private final List<TypeProjection> computeRawTypeArguments(final JavaClassifierType r12, List<? extends TypeParameterDescriptor> r13, final TypeConstructor r14, final JavaTypeAttributes r15) {
        ArrayList r5 = new ArrayList(CollectionsKt.h(r13));
        Iterator<T> r16 = r13.iterator();
    L4:
        if (r16.hasNext() == false) goto L10;
        final TypeParameterDescriptor r10 = (TypeParameterDescriptor) r16.next();
        if (TypeUtilsKt.hasTypeParameterRecursiveBounds(r10, null, r15.getVisitedTypeParameters()) == false) goto L8;
        TypeProjection r11 = TypeUtils.makeStarProjection(r10, r15);
    L9:
        r5.add(r11);
        goto L4
    L8:
        LazyWrappedType r17 = new LazyWrappedType(this.f18751c.getStorageManager(), new JavaTypeResolver$computeRawTypeArguments$1$erasedUpperBound$1(this, r10, r15, r14, r12));
        r11 = this.projectionComputer.computeProjection(r10, r15.markIsRaw(r12.isRaw()), this.typeParameterUpperBoundEraser, r17);
        goto L9
    L10:
        return r5;
    }

    private final SimpleType computeSimpleJavaClassifierType(JavaClassifierType r10, JavaTypeAttributes r11, SimpleType r12) {
        if (r12 == null) goto L7;
        TypeAttributes r5 = r12.getAttributes();
        if (r5 == null) goto L7;
    L6:
        TypeAttributes r13 = r5;
        TypeConstructor r14 = computeTypeConstructor(r10, r11);
        TypeConstructor r15 = null;
        if (r14 != null) goto L11;
        return null;
    L11:
        boolean r16 = isNullable(r11);
        if (r12 == null) goto L15;
        r15 = r12.getConstructor();
    L15:
        if (Intrinsics.areEqual(r15, r14) == false) goto L22;
        if (r10.isRaw() == true) goto L22;
        if (r16 == false) goto L22;
        return r12.makeNullableAsSpecified(true);
    L22:
        return KotlinTypeFactory.simpleType$default(r13, r14, computeArguments(r10, r11, r14), r16, null, 16, null);
    L7:
        boolean r17 = false;
        r5 = TypeAttributesKt.toDefaultAttributes(new LazyJavaAnnotations(this.f18751c, r10, r17, 4, null));
        goto L6
    }

    private final TypeConstructor computeTypeConstructor(JavaClassifierType r5, JavaTypeAttributes r10) {
        JavaClassifier r11 = r5.getClassifier();
        if (r11 != null) goto L7;
        return createNotFoundClass(r5);
    L7:
        if ((r11 instanceof JavaClass) == false) goto L20;
        JavaClass r12 = (JavaClass) r11;
        FqName r13 = r12.getFqName();
        if (r13 == null) goto L18;
        ClassDescriptor r14 = mapKotlinClass(r5, r10, r13);
        if (r14 != null) goto L13;
        r14 = this.f18751c.getComponents().getModuleClassResolver().resolveClass(r12);
    L13:
        if (r14 == null) goto L29;
        TypeConstructor r15 = r14.getTypeConstructor();
        if (r15 == null) goto L29;
        return r15;
    L29:
        return createNotFoundClass(r5);
    L18:
        throw new AssertionError("Class type should have a FQ name: " + r11);
    L20:
        if ((r11 instanceof JavaTypeParameter) == false) goto L27;
        TypeParameterDescriptor r16 = this.typeParameterResolver.resolveTypeParameter((JavaTypeParameter) r11);
        if (r16 != null) goto L30;
        return null;
    L30:
        return r16.getTypeConstructor();
    L27:
        throw new IllegalStateException("Unknown classifier kind: " + r11);
    }

    private final TypeConstructor createNotFoundClass(JavaClassifierType r5) {
        ClassId r10 = ClassId.topLevel(new FqName(r5.getClassifierQualifiedName()));
        return this.f18751c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(r10, CollectionsKt.listOf(0)).getTypeConstructor();
    }

    private final boolean isConflictingArgumentFor(Variance r5, TypeParameterDescriptor r10) {
        if (r10.getVariance() != Variance.INVARIANT) goto L6;
        return false;
    L6:
        if (r5 == r10.getVariance()) goto L9;
        return true;
    L9:
        return false;
    }

    private final boolean isNullable(JavaTypeAttributes r5) {
        if (r5.getFlexibility() != JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND) goto L6;
        return false;
    L6:
        if (r5.isForAnnotationParameter() == false) goto L8;
        return false;
    L8:
        if (r5.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) goto L12;
        return true;
    L12:
        return false;
    }

    private final ClassDescriptor mapKotlinClass(JavaClassifierType r10, JavaTypeAttributes r11, FqName r12) {
        if (r11.isForAnnotationParameter() == true) goto L5;
    L8:
        JavaToKotlinClassMapper r13 = JavaToKotlinClassMapper.INSTANCE;
        ClassDescriptor r14 = JavaToKotlinClassMapper.mapJavaToKotlin$default(r13, r12, this.f18751c.getModule().getBuiltIns(), null, 4, null);
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
        return this.f18751c.getComponents().getReflectionTypes().getKClass();
    }

    public static /* synthetic */ KotlinType transformArrayType$default(JavaTypeResolver r5, JavaArrayType r10, JavaTypeAttributes r11, boolean r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = false;
    L6:
        return r5.transformArrayType(r10, r11, r12);
    }

    private final KotlinType transformJavaClassifierType(JavaClassifierType r5, JavaTypeAttributes r10) {
        if (r10.isForAnnotationParameter() == false) goto L5;
    L7:
        boolean r11 = false;
    L8:
        boolean r12 = r5.isRaw();
        if (r12 == true) goto L16;
        if (r11 == true) goto L16;
        SimpleType r13 = computeSimpleJavaClassifierType(r5, r10, null);
        if (r13 == null) goto L15;
        return r13;
    L15:
        return transformJavaClassifierType$errorType(r5);
    L16:
        SimpleType r14 = computeSimpleJavaClassifierType(r5, r10.withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
        if (r14 == null) goto L19;
        SimpleType r15 = computeSimpleJavaClassifierType(r5, r10.withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), r14);
        if (r15 == null) goto L23;
        if (r12 == false) goto L27;
        return new RawTypeImpl(r14, r15);
    L27:
        return KotlinTypeFactory.flexibleType(r14, r15);
    L23:
        return transformJavaClassifierType$errorType(r5);
    L19:
        return transformJavaClassifierType$errorType(r5);
    L5:
        if (r10.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) goto L7;
        r11 = true;
        goto L8
    }

    private static final ErrorType transformJavaClassifierType$errorType(JavaClassifierType r5) {
        return ErrorUtils.createErrorType(ErrorTypeKind.UNRESOLVED_JAVA_CLASS, new String[]{r5.getPresentableText()});
    }

    private final TypeProjection transformToTypeProjection(JavaType r10, JavaTypeAttributes r11, TypeParameterDescriptor r12) {
        if ((r10 instanceof JavaWildcardType) == false) goto L18;
        JavaWildcardType r13 = (JavaWildcardType) r10;
        JavaType r5 = r13.getBound();
        if (r13.isExtends() == false) goto L7;
        Variance r14 = Variance.OUT_VARIANCE;
    L8:
        if (r5 == null) goto L20;
        if (isConflictingArgumentFor(r14, r12) == true) goto L20;
        AnnotationDescriptor r15 = UtilsKt.extractNullabilityAnnotationOnBoundedWildcard(this.f18751c, r13);
        KotlinType r16 = transformJavaType(r5, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null));
        if (r15 == null) goto L19;
        r16 = TypeUtilsKt.replaceAnnotations(r16, Annotations.Companion.create(CollectionsKt.plus(r16.getAnnotations(), r15)));
    L19:
        return TypeUtilsKt.createProjection(r16, r14, r12);
    L20:
        return TypeUtils.makeStarProjection(r12, r11);
    L7:
        r14 = Variance.IN_VARIANCE;
        goto L8
    L18:
        return new TypeProjectionImpl(Variance.INVARIANT, transformJavaType(r10, r11));
    }

    public final KotlinType transformArrayType(JavaArrayType r10, JavaTypeAttributes r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "arrayType");
        Intrinsics.checkNotNullParameter(r11, "attr");
        JavaType r5 = r10.getComponentType();
        PrimitiveType r13 = null;
        if ((r5 instanceof JavaPrimitiveType) == false) goto L5;
        JavaPrimitiveType r14 = (JavaPrimitiveType) r5;
    L6:
        if (r14 == null) goto L8;
        r13 = r14.getType();
    L8:
        LazyJavaAnnotations r15 = new LazyJavaAnnotations(this.f18751c, r10, true);
        if (r13 == null) goto L15;
        SimpleType r16 = this.f18751c.getModule().getBuiltIns().getPrimitiveArrayKotlinType(r13);
        KotlinType r17 = TypeUtilsKt.replaceAnnotations(r16, new CompositeAnnotations(new Annotations[]{r16.getAnnotations(), r15}));
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        SimpleType r18 = (SimpleType) r17;
        if (r11.isForAnnotationParameter() == false) goto L14;
        return r18;
    L14:
        return KotlinTypeFactory.flexibleType(r18, r18.makeNullableAsSpecified(true));
    L15:
        KotlinType r19 = transformJavaType(r5, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, r11.isForAnnotationParameter(), false, null, 6, null));
        if (r11.isForAnnotationParameter() == false) goto L23;
        if (r12 == false) goto L19;
        Variance r110 = Variance.OUT_VARIANCE;
    L21:
        return this.f18751c.getModule().getBuiltIns().getArrayType(r110, r19, r15);
    L19:
        r110 = Variance.INVARIANT;
        goto L21
    L23:
        return KotlinTypeFactory.flexibleType(this.f18751c.getModule().getBuiltIns().getArrayType(Variance.INVARIANT, r19, r15), this.f18751c.getModule().getBuiltIns().getArrayType(Variance.OUT_VARIANCE, r19, r15).makeNullableAsSpecified(true));
    L5:
        r14 = null;
        goto L6
    }

    public final KotlinType transformJavaType(JavaType r10, JavaTypeAttributes r11) {
        Intrinsics.checkNotNullParameter(r11, "attr");
        if ((r10 instanceof JavaPrimitiveType) == false) goto L9;
        PrimitiveType r12 = ((JavaPrimitiveType) r10).getType();
        if (r12 == null) goto L29;
        return this.f18751c.getModule().getBuiltIns().getPrimitiveKotlinType(r12);
    L29:
        return this.f18751c.getModule().getBuiltIns().getUnitType();
    L9:
        if ((r10 instanceof JavaClassifierType) == false) goto L12;
        return transformJavaClassifierType((JavaClassifierType) r10, r11);
    L12:
        if ((r10 instanceof JavaArrayType) == false) goto L15;
        return transformArrayType$default(this, (JavaArrayType) r10, r11, false, 4, null);
    L15:
        if ((r10 instanceof JavaWildcardType) == false) goto L23;
        JavaType r13 = ((JavaWildcardType) r10).getBound();
        if (r13 == null) goto L33;
        KotlinType r14 = transformJavaType(r13, r11);
        if (r14 == null) goto L33;
        return r14;
    L33:
        return this.f18751c.getModule().getBuiltIns().getDefaultBound();
    L23:
        if (r10 != null) goto L27;
        return this.f18751c.getModule().getBuiltIns().getDefaultBound();
    L27:
        throw new UnsupportedOperationException("Unsupported type: " + r10);
    }
}
