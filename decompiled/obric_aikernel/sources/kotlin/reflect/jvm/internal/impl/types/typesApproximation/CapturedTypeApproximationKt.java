package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
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
public final class CapturedTypeApproximationKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[Variance.values().length];
            r10[Variance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[Variance.IN_VARIANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[Variance.OUT_VARIANCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r10;
        }
    }

    public static final ApproximationBounds<KotlinType> approximateCapturedTypes(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        if (FlexibleTypesKt.isFlexible(r10) == false) goto L6;
        ApproximationBounds<KotlinType> r11 = approximateCapturedTypes(FlexibleTypesKt.lowerIfFlexible(r10));
        ApproximationBounds<KotlinType> r12 = approximateCapturedTypes(FlexibleTypesKt.upperIfFlexible(r10));
        return new ApproximationBounds(TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(r11.getLower()), FlexibleTypesKt.upperIfFlexible(r12.getLower())), r10), TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(r11.getUpper()), FlexibleTypesKt.upperIfFlexible(r12.getUpper())), r10));
    L6:
        TypeConstructor r13 = r10.getConstructor();
        if (CapturedTypeConstructorKt.isCaptured(r10) == false) goto L18;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
        TypeProjection r14 = ((CapturedTypeConstructor) r13).getProjection();
        KotlinType r15 = r14.getType();
        Intrinsics.checkNotNullExpressionValue(r15, "typeProjection.type");
        KotlinType r16 = approximateCapturedTypes$makeNullableIfNeeded(r15, r10);
        int r17 = WhenMappings.$EnumSwitchMapping$0[r14.getProjectionKind().ordinal()];
        if (r17 != 2) goto L11;
        SimpleType r18 = TypeUtilsKt.getBuiltIns(r10).getNullableAnyType();
        Intrinsics.checkNotNullExpressionValue(r18, "type.builtIns.nullableAnyType");
        return new ApproximationBounds(r16, r18);
    L11:
        if (r17 != 3) goto L14;
        SimpleType r19 = TypeUtilsKt.getBuiltIns(r10).getNothingType();
        Intrinsics.checkNotNullExpressionValue(r19, "type.builtIns.nothingType");
        return new ApproximationBounds(approximateCapturedTypes$makeNullableIfNeeded(r19, r10), r16);
    L14:
        throw new AssertionError("Only nontrivial projections should have been captured, not: " + r14);
    L18:
        if (r10.getArguments().isEmpty() == true) goto L45;
        if (r10.getArguments().size() != r13.getParameters().size()) goto L45;
        ArrayList r20 = new ArrayList();
        ArrayList r21 = new ArrayList();
        List<TypeProjection> r22 = r10.getArguments();
        List<TypeParameterDescriptor> r23 = r13.getParameters();
        Intrinsics.checkNotNullExpressionValue(r23, "typeConstructor.parameters");
        Iterator r24 = CollectionsKt.zip(r22, r23).iterator();
    L24:
        if (r24.hasNext() == false) goto L30;
        Pair r25 = (Pair) r24.next();
        TypeProjection r26 = (TypeProjection) r25.component1();
        TypeParameterDescriptor r27 = (TypeParameterDescriptor) r25.component2();
        Intrinsics.checkNotNullExpressionValue(r27, "typeParameter");
        TypeArgument r28 = toTypeArgument(r26, r27);
        if (r26.isStarProjection() == false) goto L28;
        r20.add(r28);
    L29:
        r21.add(r28);
        goto L24
    L28:
        ApproximationBounds<TypeArgument> r29 = approximateProjection(r28);
        TypeArgument r30 = r29.component1();
        r28 = r29.component2();
        r20.add(r30);
        goto L29
    L30:
        boolean r31 = true;
        if (r20.isEmpty() == false) goto L33;
    L32:
        r31 = false;
    L39:
        if (r31 == false) goto L41;
        Object r32 = TypeUtilsKt.getBuiltIns(r10).getNothingType();
        Intrinsics.checkNotNullExpressionValue(r32, "type.builtIns.nothingType");
    L43:
        return new ApproximationBounds(r32, replaceTypeArguments(r10, r21));
    L41:
        r32 = replaceTypeArguments(r10, r20);
        goto L43
    L33:
        Iterator r33 = r20.iterator();
    L35:
        if (r33.hasNext() == false) goto L32;
        if ((!((TypeArgument) r33.next()).isConsistent()) == false) goto L35;
    L45:
        return new ApproximationBounds(r10, r10);
    }

    private static final KotlinType approximateCapturedTypes$makeNullableIfNeeded(KotlinType r10, KotlinType r11) {
        KotlinType r12 = TypeUtils.makeNullableIfNeeded(r10, r11.isMarkedNullable());
        Intrinsics.checkNotNullExpressionValue(r12, "makeNullableIfNeeded(this, type.isMarkedNullable)");
        return r12;
    }

    public static final TypeProjection approximateCapturedTypesIfNecessary(TypeProjection r10, boolean r11) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.isStarProjection() == false) goto L8;
        return r10;
    L8:
        KotlinType r12 = r10.getType();
        Intrinsics.checkNotNullExpressionValue(r12, "typeProjection.type");
        if (TypeUtils.contains(r12, AnonymousClass1.INSTANCE) == true) goto L11;
        return r10;
    L11:
        Variance r13 = r10.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(r13, "typeProjection.projectionKind");
        if (r13 == Variance.OUT_VARIANCE) goto L14;
        if (r11 == false) goto L19;
        return new TypeProjectionImpl(r13, approximateCapturedTypes(r12).getLower());
    L19:
        return substituteCapturedTypesWithProjections(r10);
    L14:
        return new TypeProjectionImpl(r13, approximateCapturedTypes(r12).getUpper());
    }

    private static final ApproximationBounds<TypeArgument> approximateProjection(TypeArgument r10) {
        ApproximationBounds<KotlinType> r11 = approximateCapturedTypes(r10.getInProjection());
        KotlinType r12 = r11.component1();
        KotlinType r13 = r11.component2();
        ApproximationBounds<KotlinType> r14 = approximateCapturedTypes(r10.getOutProjection());
        KotlinType r15 = r14.component1();
        KotlinType r16 = r14.component2();
        return new ApproximationBounds(new TypeArgument(r10.getTypeParameter(), r13, r15), new TypeArgument(r10.getTypeParameter(), r12, r16));
    }

    private static final KotlinType replaceTypeArguments(KotlinType r10, List<TypeArgument> r11) {
        r10.getArguments().size();
        r11.size();
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        r12.add(toTypeProjection((TypeArgument) r13.next()));
        goto L4
    L7:
        return TypeSubstitutionKt.replace$default(r10, r12, null, null, 6, null);
    }

    private static final TypeProjection substituteCapturedTypesWithProjections(TypeProjection r10) {
        TypeSubstitutor r11 = TypeSubstitutor.create(new CapturedTypeApproximationKt$substituteCapturedTypesWithProjections$typeSubstitutor$1());
        Intrinsics.checkNotNullExpressionValue(r11, "create(object : TypeCons…ojection\n        }\n    })");
        return r11.substituteWithoutApproximation(r10);
    }

    private static final TypeArgument toTypeArgument(TypeProjection r10, TypeParameterDescriptor r11) {
        Variance r12 = TypeSubstitutor.combine(r11.getVariance(), r10);
        int r13 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
        if (r13 != 1) goto L5;
        KotlinType r14 = r10.getType();
        Intrinsics.checkNotNullExpressionValue(r14, WsConstants.KEY_CONNECTION_TYPE);
        KotlinType r15 = r10.getType();
        Intrinsics.checkNotNullExpressionValue(r15, WsConstants.KEY_CONNECTION_TYPE);
        return new TypeArgument(r11, r14, r15);
    L5:
        if (r13 != 2) goto L7;
        KotlinType r16 = r10.getType();
        Intrinsics.checkNotNullExpressionValue(r16, WsConstants.KEY_CONNECTION_TYPE);
        SimpleType r17 = DescriptorUtilsKt.getBuiltIns(r11).getNullableAnyType();
        Intrinsics.checkNotNullExpressionValue(r17, "typeParameter.builtIns.nullableAnyType");
        return new TypeArgument(r11, r16, r17);
    L7:
        if (r13 != 3) goto L10;
        SimpleType r18 = DescriptorUtilsKt.getBuiltIns(r11).getNothingType();
        Intrinsics.checkNotNullExpressionValue(r18, "typeParameter.builtIns.nothingType");
        KotlinType r19 = r10.getType();
        Intrinsics.checkNotNullExpressionValue(r19, WsConstants.KEY_CONNECTION_TYPE);
        return new TypeArgument(r11, r18, r19);
    L10:
        throw new NoWhenBranchMatchedException();
    }

    private static final TypeProjection toTypeProjection(TypeArgument r10) {
        r10.isConsistent();
        if (Intrinsics.areEqual(r10.getInProjection(), r10.getOutProjection()) == true) goto L17;
        Variance r11 = r10.getTypeParameter().getVariance();
        Variance r12 = Variance.IN_VARIANCE;
        if (r11 == r12) goto L17;
        if (KotlinBuiltIns.isNothing(r10.getInProjection()) == false) goto L13;
        if (r10.getTypeParameter().getVariance() == r12) goto L13;
        return new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(r10, Variance.OUT_VARIANCE), r10.getOutProjection());
    L13:
        if (KotlinBuiltIns.isNullableAny(r10.getOutProjection()) == false) goto L20;
        return new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(r10, r12), r10.getInProjection());
    L20:
        return new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(r10, Variance.OUT_VARIANCE), r10.getOutProjection());
    L17:
        return new TypeProjectionImpl(r10.getInProjection());
    }

    private static final Variance toTypeProjection$removeProjectionIfRedundant(TypeArgument r10, Variance r11) {
        if (r11 == r10.getTypeParameter().getVariance()) goto L5;
        return r11;
    L5:
        return Variance.INVARIANT;
    }
}
