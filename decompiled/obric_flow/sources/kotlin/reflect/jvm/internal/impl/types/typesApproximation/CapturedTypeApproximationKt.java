package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nCapturedTypeApproximation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CapturedTypeApproximation.kt\norg/jetbrains/kotlin/types/typesApproximation/CapturedTypeApproximationKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,178:1\n1747#2,3:179\n1549#2:183\n1620#2,3:184\n1#3:182\n*S KotlinDebug\n*F\n+ 1 CapturedTypeApproximation.kt\norg/jetbrains/kotlin/types/typesApproximation/CapturedTypeApproximationKt\n*L\n158#1:179,3\n167#1:183\n167#1:184,3\n*E\n"})
public final class CapturedTypeApproximationKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[Variance.values().length];
            r5[Variance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[Variance.IN_VARIANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[Variance.OUT_VARIANCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public static final ApproximationBounds<KotlinType> approximateCapturedTypes(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if (FlexibleTypesKt.isFlexible(r5) == false) goto L6;
        ApproximationBounds<KotlinType> r10 = approximateCapturedTypes(FlexibleTypesKt.lowerIfFlexible(r5));
        ApproximationBounds<KotlinType> r11 = approximateCapturedTypes(FlexibleTypesKt.upperIfFlexible(r5));
        return new ApproximationBounds(TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(r10.getLower()), FlexibleTypesKt.upperIfFlexible(r11.getLower())), r5), TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(r10.getUpper()), FlexibleTypesKt.upperIfFlexible(r11.getUpper())), r5));
    L6:
        TypeConstructor r12 = r5.getConstructor();
        if (CapturedTypeConstructorKt.isCaptured(r5) == false) goto L18;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
        TypeProjection r13 = ((CapturedTypeConstructor) r12).getProjection();
        KotlinType r14 = approximateCapturedTypes$makeNullableIfNeeded(r13.getType(), r5);
        int r15 = WhenMappings.$EnumSwitchMapping$0[r13.getProjectionKind().ordinal()];
        if (r15 == 2) goto L16;
        if (r15 != 3) goto L14;
        return new ApproximationBounds(approximateCapturedTypes$makeNullableIfNeeded(TypeUtilsKt.getBuiltIns(r5).getNothingType(), r5), r14);
    L14:
        throw new AssertionError("Only nontrivial projections should have been captured, not: " + r13);
    L16:
        return new ApproximationBounds(r14, TypeUtilsKt.getBuiltIns(r5).getNullableAnyType());
    L18:
        if (r5.getArguments().isEmpty() == true) goto L45;
        if (r5.getArguments().size() != r12.getParameters().size()) goto L45;
        ArrayList r16 = new ArrayList();
        ArrayList r17 = new ArrayList();
        Iterator r18 = CollectionsKt.zip(r5.getArguments(), r12.getParameters()).iterator();
    L24:
        if (r18.hasNext() == false) goto L29;
        Pair r19 = (Pair) r18.next();
        TypeProjection r20 = (TypeProjection) r19.component1();
        TypeArgument r21 = toTypeArgument(r20, (TypeParameterDescriptor) r19.component2());
        if (r20.isStarProjection() == true) goto L27;
        ApproximationBounds<TypeArgument> r22 = approximateProjection(r21);
        TypeArgument r23 = r22.component1();
        TypeArgument r24 = r22.component2();
        r16.add(r23);
        r17.add(r24);
        goto L24
    L27:
        r16.add(r21);
        r17.add(r21);
        goto L24
    L29:
        boolean r25 = false;
        if (r16.isEmpty() == true) goto L39;
        Iterator r26 = r16.iterator();
    L34:
        if (r26.hasNext() == false) goto L39;
        if (((TypeArgument) r26.next()).isConsistent() == true) goto L34;
        r25 = true;
    L39:
        if (r25 == false) goto L41;
        Object r27 = TypeUtilsKt.getBuiltIns(r5).getNothingType();
    L43:
        return new ApproximationBounds(r27, replaceTypeArguments(r5, r17));
    L41:
        r27 = replaceTypeArguments(r5, r16);
    L45:
        return new ApproximationBounds(r5, r5);
    }

    private static final KotlinType approximateCapturedTypes$makeNullableIfNeeded(KotlinType r5, KotlinType r10) {
        return TypeUtils.makeNullableIfNeeded(r5, r10.isMarkedNullable());
    }

    public static final TypeProjection approximateCapturedTypesIfNecessary(TypeProjection r5, boolean r10) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.isStarProjection() == false) goto L8;
        return r5;
    L8:
        KotlinType r11 = r5.getType();
        if (TypeUtils.contains(r11, AnonymousClass1.INSTANCE) == true) goto L11;
        return r5;
    L11:
        Variance r12 = r5.getProjectionKind();
        if (r12 == Variance.OUT_VARIANCE) goto L14;
        if (r10 == false) goto L19;
        return new TypeProjectionImpl(r12, approximateCapturedTypes(r11).getLower());
    L19:
        return substituteCapturedTypesWithProjections(r5);
    L14:
        return new TypeProjectionImpl(r12, approximateCapturedTypes(r11).getUpper());
    }

    private static final ApproximationBounds<TypeArgument> approximateProjection(TypeArgument r10) {
        ApproximationBounds<KotlinType> r5 = approximateCapturedTypes(r10.getInProjection());
        KotlinType r11 = r5.component1();
        KotlinType r12 = r5.component2();
        ApproximationBounds<KotlinType> r13 = approximateCapturedTypes(r10.getOutProjection());
        KotlinType r14 = r13.component1();
        KotlinType r15 = r13.component2();
        return new ApproximationBounds(new TypeArgument(r10.getTypeParameter(), r12, r14), new TypeArgument(r10.getTypeParameter(), r11, r15));
    }

    private static final KotlinType replaceTypeArguments(KotlinType r10, List<TypeArgument> r11) {
        r10.getArguments().size();
        r11.size();
        ArrayList r5 = new ArrayList(CollectionsKt.h(r11));
        Iterator<T> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        r5.add(toTypeProjection((TypeArgument) r12.next()));
        goto L4
    L7:
        return TypeSubstitutionKt.replace$default(r10, r5, null, null, 6, null);
    }

    private static final TypeProjection substituteCapturedTypesWithProjections(TypeProjection r5) {
        return TypeSubstitutor.create(new CapturedTypeApproximationKt$substituteCapturedTypesWithProjections$typeSubstitutor$1()).substituteWithoutApproximation(r5);
    }

    private static final TypeArgument toTypeArgument(TypeProjection r5, TypeParameterDescriptor r10) {
        Variance r11 = TypeSubstitutor.combine(r10.getVariance(), r5);
        int r12 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
        if (r12 == 1) goto L13;
        if (r12 == 2) goto L15;
        if (r12 != 3) goto L10;
        return new TypeArgument(r10, DescriptorUtilsKt.getBuiltIns(r10).getNothingType(), r5.getType());
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return new TypeArgument(r10, r5.getType(), DescriptorUtilsKt.getBuiltIns(r10).getNullableAnyType());
    L13:
        return new TypeArgument(r10, r5.getType(), r5.getType());
    }

    private static final TypeProjection toTypeProjection(TypeArgument r5) {
        r5.isConsistent();
        if (Intrinsics.areEqual(r5.getInProjection(), r5.getOutProjection()) == true) goto L17;
        Variance r10 = r5.getTypeParameter().getVariance();
        Variance r11 = Variance.IN_VARIANCE;
        if (r10 == r11) goto L17;
        if (KotlinBuiltIns.isNothing(r5.getInProjection()) == false) goto L13;
        if (r5.getTypeParameter().getVariance() == r11) goto L13;
        return new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(r5, Variance.OUT_VARIANCE), r5.getOutProjection());
    L13:
        if (KotlinBuiltIns.isNullableAny(r5.getOutProjection()) == false) goto L20;
        return new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(r5, r11), r5.getInProjection());
    L20:
        return new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(r5, Variance.OUT_VARIANCE), r5.getOutProjection());
    L17:
        return new TypeProjectionImpl(r5.getInProjection());
    }

    private static final Variance toTypeProjection$removeProjectionIfRedundant(TypeArgument r5, Variance r10) {
        if (r10 == r5.getTypeParameter().getVariance()) goto L5;
        return r10;
    L5:
        return Variance.INVARIANT;
    }
}
