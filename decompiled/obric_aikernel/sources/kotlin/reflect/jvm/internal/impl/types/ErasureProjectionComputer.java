package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public class ErasureProjectionComputer {
    public ErasureProjectionComputer() {
    }

    public static /* synthetic */ TypeProjection computeProjection$default(ErasureProjectionComputer r10, TypeParameterDescriptor r11, ErasureTypeAttributes r12, TypeParameterUpperBoundEraser r13, KotlinType r14, int r15, Object r16) {
        if (r16 != null) goto L9;
        if ((r15 & 8) == 0) goto L7;
        r14 = r13.getErasedUpperBound(r11, r12);
    L7:
        return r10.computeProjection(r11, r12, r13, r14);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: computeProjection");
    }

    public TypeProjection computeProjection(TypeParameterDescriptor r10, ErasureTypeAttributes r11, TypeParameterUpperBoundEraser r12, KotlinType r13) {
        Intrinsics.checkNotNullParameter(r10, "parameter");
        Intrinsics.checkNotNullParameter(r11, "typeAttr");
        Intrinsics.checkNotNullParameter(r12, "typeParameterUpperBoundEraser");
        Intrinsics.checkNotNullParameter(r13, "erasedUpperBound");
        return new TypeProjectionImpl(Variance.OUT_VARIANCE, r13);
    }
}
