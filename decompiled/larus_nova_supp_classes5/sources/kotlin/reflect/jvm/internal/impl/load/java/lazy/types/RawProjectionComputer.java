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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class RawProjectionComputer extends ErasureProjectionComputer {
    public RawProjectionComputer() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer
    public TypeProjection computeProjection(TypeParameterDescriptor r3, ErasureTypeAttributes r4, TypeParameterUpperBoundEraser r5, KotlinType r6) {
        Intrinsics.checkNotNullParameter(r3, "parameter");
        Intrinsics.checkNotNullParameter(r4, "typeAttr");
        Intrinsics.checkNotNullParameter(r5, "typeParameterUpperBoundEraser");
        Intrinsics.checkNotNullParameter(r6, "erasedUpperBound");
        if ((r4 instanceof JavaTypeAttributes) == false) goto L5;
        JavaTypeAttributes r7 = (JavaTypeAttributes) r4;
        if (r7.isRaw() == true) goto L10;
        r7 = r7.withFlexibility(JavaTypeFlexibility.INFLEXIBLE);
    L10:
        int r8 = WhenMappings.$EnumSwitchMapping$0[r7.getFlexibility().ordinal()];
        if (r8 == 1) goto L28;
        if (r8 == 2) goto L20;
        if (r8 == 3) goto L20;
        throw new NoWhenBranchMatchedException();
    L20:
        if (r3.getVariance().getAllowsOutPosition() == true) goto L23;
        TypeProjection r9 = new TypeProjectionImpl(Variance.INVARIANT, DescriptorUtilsKt.getBuiltIns(r3).getNothingType());
    L26:
        Intrinsics.checkNotNull(r9);
        return r9;
    L23:
        if ((!r6.getConstructor().getParameters().isEmpty()) == false) goto L25;
        r9 = new TypeProjectionImpl(Variance.OUT_VARIANCE, r6);
        goto L26
    L25:
        r9 = TypeUtils.makeStarProjection(r3, r7);
        goto L26
    L28:
        return new TypeProjectionImpl(Variance.INVARIANT, r6);
    L5:
        return super.computeProjection(r3, r4, r5, r6);
    }
}
