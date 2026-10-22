package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer;
import kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
public final class RawProjectionComputer extends ErasureProjectionComputer {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[JavaTypeFlexibility.values().length];
            r5[JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[JavaTypeFlexibility.INFLEXIBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public RawProjectionComputer() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer
    public TypeProjection computeProjection(TypeParameterDescriptor r5, ErasureTypeAttributes r10, TypeParameterUpperBoundEraser r11, KotlinType r12) {
        Intrinsics.checkNotNullParameter(r5, "parameter");
        Intrinsics.checkNotNullParameter(r10, "typeAttr");
        Intrinsics.checkNotNullParameter(r11, "typeParameterUpperBoundEraser");
        Intrinsics.checkNotNullParameter(r12, "erasedUpperBound");
        if ((r10 instanceof JavaTypeAttributes) == false) goto L5;
        JavaTypeAttributes r13 = (JavaTypeAttributes) r10;
        if (r13.isRaw() == true) goto L10;
        r13 = r13.withFlexibility(JavaTypeFlexibility.INFLEXIBLE);
    L10:
        JavaTypeFlexibility r14 = r13.getFlexibility();
        int r15 = WhenMappings.$EnumSwitchMapping$0[r14.ordinal()];
        if (r15 == 1) goto L27;
        if (r15 == 2) goto L20;
        if (r15 == 3) goto L20;
        throw new NoWhenBranchMatchedException();
    L20:
        if (r5.getVariance().getAllowsOutPosition() == true) goto L23;
        return new TypeProjectionImpl(Variance.INVARIANT, DescriptorUtilsKt.getBuiltIns(r5).getNothingType());
    L23:
        if (r12.getConstructor().getParameters().isEmpty() == true) goto L30;
        return new TypeProjectionImpl(Variance.OUT_VARIANCE, r12);
    L30:
        return TypeUtils.makeStarProjection(r5, r13);
    L27:
        return new TypeProjectionImpl(Variance.INVARIANT, r12);
    L5:
        return super.computeProjection(r5, r10, r11, r12);
    }
}
