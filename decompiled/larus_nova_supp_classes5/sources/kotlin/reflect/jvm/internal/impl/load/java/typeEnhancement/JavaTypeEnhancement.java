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
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JavaTypeEnhancement {
    private final JavaResolverSettings javaResolverSettings;

    public JavaTypeEnhancement(JavaResolverSettings r2) {
        Intrinsics.checkNotNullParameter(r2, "javaResolverSettings");
        this.javaResolverSettings = r2;
    }

    private final SimpleType notNullTypeParameter(SimpleType r2) {
        if (this.javaResolverSettings.getCorrectNullabilityForNotNullTypeParameter() == false) goto L6;
        return SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(r2, true);
    L6:
        return new NotNullTypeParameterImpl(r2);
    }

    public final KotlinType enhance(KotlinType r2, Function1<? super Integer, JavaTypeQualifiers> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "qualifiers");
        return enhancePossiblyFlexible(r2.unwrap(), r3, 0, r4).getType();
    }

    private final Result enhancePossiblyFlexible(UnwrappedType r12, Function1<? super Integer, JavaTypeQualifiers> r13, int r14, boolean r15) {
        KotlinType r1 = null;
        if (KotlinTypeKt.isError(r12) == false) goto L7;
        return new Result(null, 1);
    L7:
        if ((r12 instanceof FlexibleType) == false) goto L44;
        boolean r0 = r12 instanceof RawType;
        FlexibleType r9 = (FlexibleType) r12;
        SimpleResult r10 = enhanceInflexible(r9.getLowerBound(), r13, r14, TypeComponentPosition.FLEXIBLE_LOWER, r0, r15);
        SimpleResult r16 = enhanceInflexible(r9.getUpperBound(), r13, r14, TypeComponentPosition.FLEXIBLE_UPPER, r0, r15);
        r10.getSubtreeSize();
        r16.getSubtreeSize();
        if (r10.getType() != null) goto L14;
        if (r16.getType() != null) goto L14;
    L53:
        return new Result(r1, r10.getSubtreeSize());
    L14:
        if (r10.getForWarnings() == false) goto L16;
    L33:
        SimpleType r17 = r16.getType();
        if (r17 == null) goto L40;
        SimpleType r18 = r10.getType();
        if (r18 != null) goto L38;
        r18 = r17;
    L38:
        KotlinType r19 = KotlinTypeFactory.flexibleType(r18, r17);
        if (r19 == null) goto L40;
    L41:
        r1 = TypeWithEnhancementKt.wrapEnhancement(r12, r19);
    L40:
        r19 = r10.getType();
        Intrinsics.checkNotNull(r19);
        goto L41
    L16:
        if (r16.getForWarnings() == true) goto L33;
        if (r0 == false) goto L26;
        SimpleType r110 = r10.getType();
        if (r110 != null) goto L22;
        r110 = r9.getLowerBound();
    L22:
        SimpleType r111 = r16.getType();
        if (r111 != null) goto L25;
        r111 = r9.getUpperBound();
    L25:
        r1 = new RawTypeImpl(r110, r111);
        goto L53
    L26:
        SimpleType r112 = r10.getType();
        if (r112 != null) goto L29;
        r112 = r9.getLowerBound();
    L29:
        SimpleType r113 = r16.getType();
        if (r113 != null) goto L32;
        r113 = r9.getUpperBound();
    L32:
        r1 = KotlinTypeFactory.flexibleType(r112, r113);
        goto L53
    L44:
        if ((r12 instanceof SimpleType) == false) goto L52;
        SimpleResult r114 = enhanceInflexible$default(this, (SimpleType) r12, r13, r14, TypeComponentPosition.INFLEXIBLE, false, r15, 8, null);
        if (r114.getForWarnings() == false) goto L48;
        KotlinType r115 = TypeWithEnhancementKt.wrapEnhancement(r12, r114.getType());
    L50:
        return new Result(r115, r114.getSubtreeSize());
    L48:
        r115 = r114.getType();
        goto L50
    L52:
        throw new NoWhenBranchMatchedException();
    }

    private final SimpleResult enhanceInflexible(SimpleType r19, Function1<? super Integer, JavaTypeQualifiers> r20, int r21, TypeComponentPosition r22, boolean r23, boolean r24) {
        Function1<? super Integer, JavaTypeQualifiers> r1 = r20;
        boolean r4 = TypeComponentPositionKt.shouldEnhance(r22);
        if (r24 == false) goto L7;
        if (r23 == false) goto L7;
        boolean r7 = false;
    L8:
        KotlinType r8 = null;
        if (r4 == false) goto L11;
    L14:
        ClassifierDescriptor r5 = r19.getConstructor().getDeclarationDescriptor();
        if (r5 == null) goto L17;
        JavaTypeQualifiers r9 = (JavaTypeQualifiers) r1.invoke(Integer.valueOf(r21));
        ClassifierDescriptor r6 = TypeEnhancementKt.access$enhanceMutability(r5, r9, r22);
        Boolean r2 = TypeEnhancementKt.access$getEnhancedNullability(r9, r22);
        if (r6 == null) goto L22;
        TypeConstructor r10 = r6.getTypeConstructor();
        if (r10 == null) goto L22;
    L23:
        TypeConstructor r12 = r10;
        int r11 = r21 + 1;
        List<TypeProjection> r13 = r19.getArguments();
        List<TypeParameterDescriptor> r14 = r12.getParameters();
        Iterator<T> r15 = r13.iterator();
        Iterator<T> r16 = r14.iterator();
        ArrayList r17 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r13, 10), CollectionsKt.collectionSizeOrDefault(r14, 10)));
    L25:
        if (r15.hasNext() == false) goto L49;
        if (r16.hasNext() == false) goto L49;
        Object r18 = r15.next();
        TypeParameterDescriptor r110 = (TypeParameterDescriptor) r16.next();
        TypeProjection r111 = (TypeProjection) r18;
        if (r7 == true) goto L31;
        boolean r25 = r7;
        Result r26 = new Result(r8, 0);
    L38:
        r11 = r11 + r26.getSubtreeSize();
        if (r26.getType() == null) goto L41;
        TypeProjection r27 = TypeUtilsKt.createProjection(r26.getType(), r111.getProjectionKind(), r110);
    L48:
        r17.add(r27);
        r1 = r20;
        r7 = r25;
        r8 = null;
        goto L25
    L41:
        if (r6 != null) goto L43;
    L45:
        if (r6 == null) goto L47;
        r27 = TypeUtils.makeStarProjection(r110);
        goto L48
    L47:
        r27 = null;
        goto L48
    L43:
        if (r111.isStarProjection() == true) goto L45;
        r27 = TypeUtilsKt.createProjection(r111.getType(), r111.getProjectionKind(), r110);
        goto L48
    L31:
        r25 = r7;
        if (r111.isStarProjection() == true) goto L35;
        r26 = enhancePossiblyFlexible(r111.getType().unwrap(), r1, r11, r24);
        goto L38
    L35:
        if (((JavaTypeQualifiers) r1.invoke(Integer.valueOf(r11))).getNullability() != NullabilityQualifier.FORCE_FLEXIBILITY) goto L37;
        UnwrappedType r28 = r111.getType().unwrap();
        r26 = new Result(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(r28).makeNullableAsSpecified(false), FlexibleTypesKt.upperIfFlexible(r28).makeNullableAsSpecified(true)), 1);
        goto L38
    L37:
        r26 = new Result(null, 1);
    L49:
        int r112 = r11 - r21;
        if (r6 != null) goto L67;
        if (r2 != null) goto L67;
        if (r17.isEmpty() == false) goto L55;
    L54:
        boolean r29 = true;
    L64:
        if (r29 == false) goto L67;
        return new SimpleResult(null, r112, false);
    L55:
        Iterator r3 = r17.iterator();
    L57:
        if (r3.hasNext() == false) goto L54;
        if (((TypeProjection) r3.next()) != null) goto L61;
        boolean r30 = true;
    L62:
        if (r30 == true) goto L57;
        r29 = false;
        goto L64
    L61:
        r30 = false;
    L67:
        Annotations[] r31 = new Annotations[3];
        r31[0] = r19.getAnnotations();
        EnhancedTypeAnnotations r32 = TypeEnhancementKt.access$getENHANCED_MUTABILITY_ANNOTATIONS$p();
        if (r6 == null) goto L70;
        boolean r33 = true;
    L71:
        if (r33 == true) goto L74;
        r32 = null;
    L74:
        r31[1] = r32;
        Annotations r34 = TypeEnhancementKt.getENHANCED_NULLABILITY_ANNOTATIONS();
        if (r2 == null) goto L77;
        boolean r35 = true;
    L78:
        if (r35 == false) goto L80;
        Annotations r36 = r34;
    L81:
        r31[2] = r36;
        TypeAttributes r113 = TypeAttributesKt.toDefaultAttributes(TypeEnhancementKt.access$compositeAnnotationsOrSingle(CollectionsKt.listOfNotNull(r31)));
        List<TypeProjection> r37 = r19.getArguments();
        Iterator r38 = r17.iterator();
        Iterator<T> r39 = r37.iterator();
        ArrayList r114 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r17, 10), CollectionsKt.collectionSizeOrDefault(r37, 10)));
    L83:
        if (r38.hasNext() == false) goto L91;
        if (r39.hasNext() == false) goto L91;
        Object r40 = r38.next();
        TypeProjection r41 = (TypeProjection) r39.next();
        TypeProjection r42 = (TypeProjection) r40;
        if (r42 == null) goto L90;
        r41 = r42;
    L90:
        r114.add(r41);
    L91:
        if (r2 == null) goto L93;
        boolean r43 = r2.booleanValue();
    L94:
        SimpleType r44 = KotlinTypeFactory.simpleType$default(r113, r12, r114, r43, null, 16, null);
        if (r9.getDefinitelyNotNull() == false) goto L97;
        r44 = notNullTypeParameter(r44);
    L97:
        if (r2 != null) goto L99;
    L101:
        boolean r45 = false;
    L103:
        return new SimpleResult(r44, r112, r45);
    L99:
        if (r9.isNullabilityQualifierForWarning() == false) goto L101;
        r45 = true;
        goto L103
    L93:
        r43 = r19.isMarkedNullable();
        goto L94
    L80:
        r36 = null;
        goto L81
    L77:
        r35 = false;
        goto L78
    L70:
        r33 = false;
    L22:
        r10 = r19.getConstructor();
        goto L23
    L17:
        return new SimpleResult(null, 1, false);
    L11:
        if (r19.getArguments().isEmpty() == false) goto L14;
        return new SimpleResult(null, 1, false);
    L7:
        r7 = true;
        goto L8
    }

    public static /* synthetic */ SimpleResult enhanceInflexible$default(JavaTypeEnhancement r9, SimpleType r10, Function1 r11, int r12, TypeComponentPosition r13, boolean r14, boolean r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        boolean r7 = false;
    L7:
        if ((r16 & 16) == 0) goto L9;
        boolean r8 = false;
    L11:
        return r9.enhanceInflexible(r10, r11, r12, r13, r7, r8);
    L9:
        r8 = r15;
        goto L11
    L5:
        r7 = r14;
        goto L7
    }
}
