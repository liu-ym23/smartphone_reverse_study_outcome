package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\ntypeEnhancement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/JavaTypeEnhancement\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,262:1\n1#2:263\n3433#3,7:264\n1726#3,3:271\n3433#3,7:274\n*S KotlinDebug\n*F\n+ 1 typeEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/JavaTypeEnhancement\n*L\n117#1:264,7\n143#1:271,3\n155#1:274,7\n*E\n"})
public final class JavaTypeEnhancement {
    private final JavaResolverSettings javaResolverSettings;

    public static final class Result {
        private final int subtreeSize;
        private final KotlinType type;

        public Result(KotlinType r5, int r10) {
            this.type = r5;
            this.subtreeSize = r10;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final KotlinType getType() {
            return this.type;
        }
    }

    public static final class SimpleResult {
        private final boolean forWarnings;
        private final int subtreeSize;
        private final SimpleType type;

        public SimpleResult(SimpleType r5, int r10, boolean r11) {
            this.type = r5;
            this.subtreeSize = r10;
            this.forWarnings = r11;
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

    public JavaTypeEnhancement(JavaResolverSettings r5) {
        Intrinsics.checkNotNullParameter(r5, "javaResolverSettings");
        this.javaResolverSettings = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v14 */
    private final SimpleResult enhanceInflexible(SimpleType r19, Function1<? super Integer, JavaTypeQualifiers> r20, int r21, TypeComponentPosition r22, boolean r23, boolean r24) {
        Function1<? super Integer, JavaTypeQualifiers> r5 = r20;
        boolean r10 = TypeComponentPositionKt.shouldEnhance(r22);
        ?? r11 = 0;
        if (r24 == false) goto L7;
        if (r23 == false) goto L7;
        boolean r12 = false;
    L8:
        KotlinType r13 = null;
        if (r10 == false) goto L11;
    L14:
        ClassifierDescriptor r14 = r19.getConstructor().mo1402getDeclarationDescriptor();
        if (r14 == null) goto L17;
        JavaTypeQualifiers r15 = r5.invoke(Integer.valueOf(r21));
        ClassifierDescriptor r16 = TypeEnhancementKt.access$enhanceMutability(r14, r15, r22);
        Boolean r17 = TypeEnhancementKt.access$getEnhancedNullability(r15, r22);
        if (r16 == null) goto L24;
        TypeConstructor r18 = r16.getTypeConstructor();
        if (r18 == null) goto L24;
    L23:
        TypeConstructor r110 = r18;
        int r111 = r21 + 1;
        List<TypeProjection> r112 = r19.getArguments();
        List<TypeParameterDescriptor> r113 = r110.getParameters();
        Iterator<T> r114 = r112.iterator();
        Iterator<T> r115 = r113.iterator();
        ArrayList r25 = new ArrayList(Math.min(CollectionsKt.h(r112), CollectionsKt.h(r113)));
    L27:
        if (r114.hasNext() == false) goto L51;
        if (r115.hasNext() == false) goto L51;
        Object r116 = r114.next();
        TypeParameterDescriptor r117 = (TypeParameterDescriptor) r115.next();
        TypeProjection r118 = (TypeProjection) r116;
        if (r12 == true) goto L33;
        boolean r26 = r12;
        Result r27 = new Result(r13, r11);
    L40:
        r111 = r111 + r27.getSubtreeSize();
        if (r27.getType() == null) goto L43;
        TypeProjection r28 = TypeUtilsKt.createProjection(r27.getType(), r118.getProjectionKind(), r117);
    L50:
        r25.add(r28);
        r5 = r20;
        r12 = r26;
        r11 = 0;
        r13 = null;
        goto L27
    L43:
        if (r16 != null) goto L45;
    L47:
        if (r16 == null) goto L49;
        r28 = TypeUtils.makeStarProjection(r117);
        goto L50
    L49:
        r28 = null;
        goto L50
    L45:
        if (r118.isStarProjection() == true) goto L47;
        r28 = TypeUtilsKt.createProjection(r118.getType(), r118.getProjectionKind(), r117);
        goto L50
    L33:
        r26 = r12;
        if (r118.isStarProjection() == true) goto L37;
        r27 = enhancePossiblyFlexible(r118.getType().unwrap(), r5, r111, r24);
        goto L40
    L37:
        if (r5.invoke(Integer.valueOf(r111)).getNullability() != NullabilityQualifier.FORCE_FLEXIBILITY) goto L39;
        UnwrappedType r29 = r118.getType().unwrap();
        r27 = new Result(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(r29).makeNullableAsSpecified(r11), FlexibleTypesKt.upperIfFlexible(r29).makeNullableAsSpecified(true)), 1);
        goto L40
    L39:
        r27 = new Result(null, 1);
    L51:
        int r119 = r111 - r21;
        if (r16 != null) goto L66;
        if (r17 != null) goto L66;
        if (r25.isEmpty() == true) goto L65;
        Iterator r30 = r25.iterator();
    L59:
        if (r30.hasNext() == false) goto L65;
        if (((TypeProjection) r30.next()) != null) goto L66;
    L65:
        return new SimpleResult(null, r119, false);
    L66:
        Annotations r31 = r19.getAnnotations();
        EnhancedTypeAnnotations r32 = TypeEnhancementKt.access$getENHANCED_MUTABILITY_ANNOTATIONS$p();
        if (r16 != null) goto L70;
        r32 = null;
    L70:
        Annotations r33 = TypeEnhancementKt.getENHANCED_NULLABILITY_ANNOTATIONS();
        if (r17 == null) goto L73;
        Annotations r34 = r33;
    L74:
        TypeAttributes r120 = TypeAttributesKt.toDefaultAttributes(TypeEnhancementKt.access$compositeAnnotationsOrSingle(CollectionsKt.listOfNotNull(new Annotations[]{r31, r32, r34})));
        List<TypeProjection> r35 = r19.getArguments();
        Iterator r36 = r25.iterator();
        Iterator<T> r37 = r35.iterator();
        ArrayList r121 = new ArrayList(Math.min(CollectionsKt.h(r25), CollectionsKt.h(r35)));
    L76:
        if (r36.hasNext() == false) goto L84;
        if (r37.hasNext() == false) goto L84;
        Object r38 = r36.next();
        TypeProjection r39 = (TypeProjection) r37.next();
        TypeProjection r40 = (TypeProjection) r38;
        if (r40 == null) goto L83;
        r39 = r40;
    L83:
        r121.add(r39);
    L84:
        if (r17 == null) goto L87;
        boolean r41 = r17.booleanValue();
    L88:
        SimpleType r42 = KotlinTypeFactory.simpleType$default(r120, r110, r121, r41, null, 16, null);
        if (r15.getDefinitelyNotNull() == false) goto L91;
        r42 = notNullTypeParameter(r42);
    L91:
        if (r17 != null) goto L93;
    L95:
        boolean r43 = false;
    L97:
        return new SimpleResult(r42, r119, r43);
    L93:
        if (r15.isNullabilityQualifierForWarning() == false) goto L95;
        r43 = true;
        goto L97
    L87:
        r41 = r19.isMarkedNullable();
        goto L88
    L73:
        r34 = null;
    L24:
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

    public static /* synthetic */ SimpleResult enhanceInflexible$default(JavaTypeEnhancement r10, SimpleType r11, Function1 r12, int r13, TypeComponentPosition r14, boolean r15, boolean r16, int r17, Object r18) {
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
        KotlinType r5 = null;
        if (KotlinTypeKt.isError(r12) == false) goto L7;
        return new Result(null, 1);
    L7:
        if ((r12 instanceof FlexibleType) == false) goto L44;
        boolean r10 = r12 instanceof RawType;
        FlexibleType r11 = (FlexibleType) r12;
        SimpleResult r16 = enhanceInflexible(r11.getLowerBound(), r13, r14, TypeComponentPosition.FLEXIBLE_LOWER, r10, r15);
        SimpleResult r17 = enhanceInflexible(r11.getUpperBound(), r13, r14, TypeComponentPosition.FLEXIBLE_UPPER, r10, r15);
        r16.getSubtreeSize();
        r17.getSubtreeSize();
        if (r16.getType() != null) goto L14;
        if (r17.getType() != null) goto L14;
    L53:
        return new Result(r5, r16.getSubtreeSize());
    L14:
        if (r16.getForWarnings() == false) goto L16;
    L33:
        SimpleType r18 = r17.getType();
        if (r18 == null) goto L40;
        SimpleType r19 = r16.getType();
        if (r19 != null) goto L38;
        r19 = r18;
    L38:
        KotlinType r110 = KotlinTypeFactory.flexibleType(r19, r18);
        if (r110 == null) goto L40;
    L41:
        r5 = TypeWithEnhancementKt.wrapEnhancement(r12, r110);
    L40:
        r110 = r16.getType();
        Intrinsics.checkNotNull(r110);
        goto L41
    L16:
        if (r17.getForWarnings() == true) goto L33;
        if (r10 == false) goto L26;
        SimpleType r111 = r16.getType();
        if (r111 != null) goto L22;
        r111 = r11.getLowerBound();
    L22:
        SimpleType r112 = r17.getType();
        if (r112 != null) goto L25;
        r112 = r11.getUpperBound();
    L25:
        r5 = new RawTypeImpl(r111, r112);
        goto L53
    L26:
        SimpleType r113 = r16.getType();
        if (r113 != null) goto L29;
        r113 = r11.getLowerBound();
    L29:
        SimpleType r114 = r17.getType();
        if (r114 != null) goto L32;
        r114 = r11.getUpperBound();
    L32:
        r5 = KotlinTypeFactory.flexibleType(r113, r114);
        goto L53
    L44:
        if ((r12 instanceof SimpleType) == false) goto L52;
        SimpleResult r115 = enhanceInflexible$default(this, (SimpleType) r12, r13, r14, TypeComponentPosition.INFLEXIBLE, false, r15, 8, null);
        if (r115.getForWarnings() == false) goto L48;
        KotlinType r116 = TypeWithEnhancementKt.wrapEnhancement(r12, r115.getType());
    L50:
        return new Result(r116, r115.getSubtreeSize());
    L48:
        r116 = r115.getType();
        goto L50
    L52:
        throw new NoWhenBranchMatchedException();
    }

    private final SimpleType notNullTypeParameter(SimpleType r5) {
        if (this.javaResolverSettings.getCorrectNullabilityForNotNullTypeParameter() == false) goto L6;
        return SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(r5, true);
    L6:
        return new NotNullTypeParameterImpl(r5);
    }

    public final KotlinType enhance(KotlinType r5, Function1<? super Integer, JavaTypeQualifiers> r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "qualifiers");
        return enhancePossiblyFlexible(r5.unwrap(), r10, 0, r11).getType();
    }
}
