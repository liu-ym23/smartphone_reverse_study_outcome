package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public class ErasureProjectionComputer {
    public ErasureProjectionComputer() {
    }

    public static /* synthetic */ TypeProjection computeProjection$default(ErasureProjectionComputer r5, TypeParameterDescriptor r10, ErasureTypeAttributes r11, TypeParameterUpperBoundEraser r12, KotlinType r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 8) == 0) goto L7;
        r13 = r12.getErasedUpperBound(r10, r11);
    L7:
        return r5.computeProjection(r10, r11, r12, r13);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: computeProjection");
    }

    public TypeProjection computeProjection(TypeParameterDescriptor r5, ErasureTypeAttributes r10, TypeParameterUpperBoundEraser r11, KotlinType r12) {
        Intrinsics.checkNotNullParameter(r5, "parameter");
        Intrinsics.checkNotNullParameter(r10, "typeAttr");
        Intrinsics.checkNotNullParameter(r11, "typeParameterUpperBoundEraser");
        Intrinsics.checkNotNullParameter(r12, "erasedUpperBound");
        return new TypeProjectionImpl(Variance.OUT_VARIANCE, r12);
    }
}
