package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaTypeEnhancement {
    private final JavaResolverSettings javaResolverSettings;

    private static final class Result {
        private final int subtreeSize;
        private final KotlinType type;

        public Result(KotlinType r10, int r11) {
            this.type = r10;
            this.subtreeSize = r11;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final KotlinType getType() {
            return this.type;
        }
    }

    private static final class SimpleResult {
        private final boolean forWarnings;
        private final int subtreeSize;
        private final SimpleType type;

        public SimpleResult(SimpleType r10, int r11, boolean r12) {
            this.type = r10;
            this.subtreeSize = r11;
            this.forWarnings = r12;
        }

        public final boolean getForWarnings() {
            return this.forWarnings;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final SimpleType getType() {
            return this.type;
        }
    }

    public JavaTypeEnhancement(JavaResolverSettings r10) {
        Intrinsics.checkNotNullParameter(r10, "javaResolverSettings");
        this.javaResolverSettings = r10;
    }

    private final SimpleResult enhanceInflexible(SimpleType r19, Function1<? super Integer, JavaTypeQualifiers> r20, int r21, TypeComponentPosition r22, boolean r23, boolean r24) {
        Function1<? super Integer, JavaTypeQualifiers> r10 = r20;
        boolean r11 = TypeComponentPositionKt.shouldEnhance(r22);
        if (r24 == false) goto L7;
        if (r23 == false) goto L7;
        boolean r12 = false;
    L8:
        KotlinType r13 = null;
        if (r11 == false) goto L11;
    L14:
        ClassifierDescriptor r14 = r19.getConstructor().mo1323getDeclarationDescriptor();
        if (r14 == null) goto L17;
        JavaTypeQualifiers r15 = r10.invoke(Integer.valueOf(r21));
        ClassifierDescriptor r16 = TypeEnhancementKt.access$enhanceMutability(r14, r15, r22);
        Boolean r17 = TypeEnhancementKt.access$getEnhancedNullability(r15, r22);
        if (r16 == null) goto L22;
        TypeConstructor r18 = r16.getTypeConstructor();
        if (r18 == null) goto L22;
    L23:
        TypeConstructor r110 = r18;
        Intrinsics.checkNotNullExpressionValue(r110, "enhancedClassifier?.typeConstructor ?: constructor");
        int r111 = r21 + 1;
        List<TypeProjection> r112 = r19.getArguments();
        List<TypeParameterDescriptor> r113 = r110.getParameters();
        Intrinsics.checkNotNullExpressionValue(r113, "typeConstructor.parameters");
        Iterator<T> r114 = r112.iterator();
        Iterator<T> r115 = r113.iterator();
        ArrayList r25 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r112, 10), CollectionsKt.collectionSizeOrDefault(r113, 10)));
    L25:
        if (r114.hasNext() == false) goto L50;
        if (r115.hasNext() == false) goto L50;
        Object r116 = r114.next();
        TypeParameterDescriptor r117 = (TypeParameterDescriptor) r115.next();
        TypeProjection r118 = (TypeProjection) r116;
        if (r12 == true) goto L31;
        boolean r26 = r12;
        Result r27 = new Result(r13, 0);
    L38:
        r111 = r111 + r27.getSubtreeSize();
        if (r27.getType() == null) goto L42;
        KotlinType r28 = r27.getType();
    L41:
        Variance r29 = r118.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(r29, "arg.projectionKind");
        TypeProjection r30 = TypeUtilsKt.createProjection(r28, r29, r117);
    L49:
        r25.add(r30);
        r10 = r20;
        r12 = r26;
        r13 = null;
        goto L25
    L42:
        if (r16 != null) goto L44;
    L46:
        if (r16 == null) goto L48;
        r30 = TypeUtils.makeStarProjection(r117);
        goto L49
    L48:
        r30 = null;
        goto L49
    L44:
        if (r118.isStarProjection() == true) goto L46;
        r28 = r118.getType();
        Intrinsics.checkNotNullExpressionValue(r28, "arg.type");
        goto L41
    L31:
        r26 = r12;
        if (r118.isStarProjection() == true) goto L35;
        r27 = enhancePossiblyFlexible(r118.getType().unwrap(), r10, r111, r24);
        goto L38
    L35:
        if (r10.invoke(Integer.valueOf(r111)).getNullability() != NullabilityQualifier.FORCE_FLEXIBILITY) goto L37;
        UnwrappedType r31 = r118.getType().unwrap();
        r27 = new Result(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(r31).makeNullableAsSpecified(false), FlexibleTypesKt.upperIfFlexible(r31).makeNullableAsSpecified(true)), 1);
        goto L38
    L37:
        r27 = new Result(null, 1);
    L50:
        int r119 = r111 - r21;
        if (r16 != null) goto L68;
        if (r17 != null) goto L68;
        if (r25.isEmpty() == false) goto L56;
    L55:
        boolean r32 = true;
    L65:
        if (r32 == false) goto L68;
        return new SimpleResult(null, r119, false);
    L56:
        Iterator r33 = r25.iterator();
    L58:
        if (r33.hasNext() == false) goto L55;
        if (((TypeProjection) r33.next()) != null) goto L62;
        boolean r34 = true;
    L63:
        if (r34 == true) goto L58;
        r32 = false;
        goto L65
    L62:
        r34 = false;
    L68:
        Annotations[] r35 = new Annotations[3];
        r35[0] = r19.getAnnotations();
        EnhancedTypeAnnotations r36 = TypeEnhancementKt.access$getENHANCED_MUTABILITY_ANNOTATIONS$p();
        if (r16 == null) goto L71;
        boolean r37 = true;
    L72:
        if (r37 == true) goto L75;
        r36 = null;
    L75:
        r35[1] = r36;
        EnhancedTypeAnnotations r38 = TypeEnhancementKt.access$getENHANCED_NULLABILITY_ANNOTATIONS$p();
        if (r17 == null) goto L78;
        boolean r120 = true;
    L79:
        if (r120 == true) goto L82;
        r38 = null;
    L82:
        r35[2] = r38;
        TypeAttributes r121 = TypeAttributesKt.toDefaultAttributes(TypeEnhancementKt.access$compositeAnnotationsOrSingle(CollectionsKt.listOfNotNull(r35)));
        List<TypeProjection> r39 = r19.getArguments();
        Iterator r40 = r25.iterator();
        Iterator<T> r41 = r39.iterator();
        ArrayList r122 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r25, 10), CollectionsKt.collectionSizeOrDefault(r39, 10)));
    L84:
        if (r40.hasNext() == false) goto L92;
        if (r41.hasNext() == false) goto L92;
        Object r42 = r40.next();
        TypeProjection r43 = (TypeProjection) r41.next();
        TypeProjection r44 = (TypeProjection) r42;
        if (r44 == null) goto L91;
        r43 = r44;
    L91:
        r122.add(r43);
    L92:
        if (r17 == null) goto L94;
        boolean r45 = r17.booleanValue();
    L95:
        SimpleType r46 = KotlinTypeFactory.simpleType$default(r121, r110, r122, r45, null, 16, null);
        if (r15.getDefinitelyNotNull() == false) goto L98;
        r46 = notNullTypeParameter(r46);
    L98:
        if (r17 != null) goto L100;
    L102:
        boolean r47 = false;
    L104:
        return new SimpleResult(r46, r119, r47);
    L100:
        if (r15.isNullabilityQualifierForWarning() == false) goto L102;
        r47 = true;
        goto L104
    L94:
        r45 = r19.isMarkedNullable();
        goto L95
    L78:
        r120 = false;
        goto L79
    L71:
        r37 = false;
    L22:
        r18 = r19.getConstructor();
        goto L23
    L17:
        return new SimpleResult(null, 1, false);
    L11:
        if (r19.getArguments().isEmpty() == false) goto L14;
        return new SimpleResult(null, 1, false);
    L7:
        r12 = true;
        goto L8
    }

    static /* synthetic */ SimpleResult enhanceInflexible$default(JavaTypeEnhancement r10, SimpleType r11, Function1 r12, int r13, TypeComponentPosition r14, boolean r15, boolean r16, int r17, Object r18) {
        if ((r17 & 8) == 0) goto L5;
        boolean r19 = false;
    L7:
        if ((r17 & 16) == 0) goto L9;
        boolean r20 = false;
    L11:
        return r10.enhanceInflexible(r11, r12, r13, r14, r19, r20);
    L9:
        r20 = r16;
        goto L11
    L5:
        r19 = r15;
        goto L7
    }

    private final Result enhancePossiblyFlexible(UnwrappedType r12, Function1<? super Integer, JavaTypeQualifiers> r13, int r14, boolean r15) {
        KotlinType r10 = null;
        if (KotlinTypeKt.isError(r12) == false) goto L7;
        return new Result(null, 1);
    L7:
        if ((r12 instanceof FlexibleType) == false) goto L44;
        boolean r11 = r12 instanceof RawType;
        FlexibleType r16 = (FlexibleType) r12;
        SimpleResult r17 = enhanceInflexible(r16.getLowerBound(), r13, r14, TypeComponentPosition.FLEXIBLE_LOWER, r11, r15);
        SimpleResult r18 = enhanceInflexible(r16.getUpperBound(), r13, r14, TypeComponentPosition.FLEXIBLE_UPPER, r11, r15);
        r17.getSubtreeSize();
        r18.getSubtreeSize();
        if (r17.getType() != null) goto L14;
        if (r18.getType() != null) goto L14;
    L53:
        return new Result(r10, r17.getSubtreeSize());
    L14:
        if (r17.getForWarnings() == false) goto L16;
    L33:
        SimpleType r19 = r18.getType();
        if (r19 == null) goto L40;
        SimpleType r110 = r17.getType();
        if (r110 != null) goto L38;
        r110 = r19;
    L38:
        KotlinType r111 = KotlinTypeFactory.flexibleType(r110, r19);
        if (r111 == null) goto L40;
    L41:
        r10 = TypeWithEnhancementKt.wrapEnhancement(r12, r111);
    L40:
        r111 = r17.getType();
        Intrinsics.checkNotNull(r111);
        goto L41
    L16:
        if (r18.getForWarnings() == true) goto L33;
        if (r11 == false) goto L26;
        SimpleType r112 = r17.getType();
        if (r112 != null) goto L22;
        r112 = r16.getLowerBound();
    L22:
        SimpleType r113 = r18.getType();
        if (r113 != null) goto L25;
        r113 = r16.getUpperBound();
    L25:
        r10 = new RawTypeImpl(r112, r113);
        goto L53
    L26:
        SimpleType r114 = r17.getType();
        if (r114 != null) goto L29;
        r114 = r16.getLowerBound();
    L29:
        SimpleType r115 = r18.getType();
        if (r115 != null) goto L32;
        r115 = r16.getUpperBound();
    L32:
        r10 = KotlinTypeFactory.flexibleType(r114, r115);
        goto L53
    L44:
        if ((r12 instanceof SimpleType) == false) goto L52;
        SimpleResult r116 = enhanceInflexible$default(this, (SimpleType) r12, r13, r14, TypeComponentPosition.INFLEXIBLE, false, r15, 8, null);
        if (r116.getForWarnings() == false) goto L48;
        KotlinType r117 = TypeWithEnhancementKt.wrapEnhancement(r12, r116.getType());
    L50:
        return new Result(r117, r116.getSubtreeSize());
    L48:
        r117 = r116.getType();
        goto L50
    L52:
        throw new NoWhenBranchMatchedException();
    }

    private final SimpleType notNullTypeParameter(SimpleType r10) {
        if (this.javaResolverSettings.getCorrectNullabilityForNotNullTypeParameter() == false) goto L6;
        return SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(r10, true);
    L6:
        return new NotNullTypeParameterImpl(r10);
    }

    public final KotlinType enhance(KotlinType r10, Function1<? super Integer, JavaTypeQualifiers> r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "qualifiers");
        return enhancePossiblyFlexible(r10.unwrap(), r11, 0, r12).getType();
    }
}
