package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.List;
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
            int[] r10 = new int[JavaTypeFlexibility.values().length];
            r10[JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[JavaTypeFlexibility.INFLEXIBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r10;
        }
    }

    public RawProjectionComputer() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer
    public TypeProjection computeProjection(TypeParameterDescriptor r10, ErasureTypeAttributes r11, TypeParameterUpperBoundEraser r12, KotlinType r13) {
        Intrinsics.checkNotNullParameter(r10, "parameter");
        Intrinsics.checkNotNullParameter(r11, "typeAttr");
        Intrinsics.checkNotNullParameter(r12, "typeParameterUpperBoundEraser");
        Intrinsics.checkNotNullParameter(r13, "erasedUpperBound");
        if ((r11 instanceof JavaTypeAttributes) == false) goto L5;
        JavaTypeAttributes r14 = (JavaTypeAttributes) r11;
        if (r14.isRaw() == true) goto L10;
        r14 = r14.withFlexibility(JavaTypeFlexibility.INFLEXIBLE);
    L10:
        int r15 = WhenMappings.$EnumSwitchMapping$0[r14.getFlexibility().ordinal()];
        if (r15 == 1) goto L28;
        if (r15 == 2) goto L20;
        if (r15 == 3) goto L20;
        throw new NoWhenBranchMatchedException();
    L20:
        if (r10.getVariance().getAllowsOutPosition() == true) goto L22;
        TypeProjection r16 = new TypeProjectionImpl(Variance.INVARIANT, DescriptorUtilsKt.getBuiltIns(r10).getNothingType());
    L26:
        Intrinsics.checkNotNullExpressionValue(r16, "{\n                if (!p…          }\n            }");
        return r16;
    L22:
        List<TypeParameterDescriptor> r17 = r13.getConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r17, "erasedUpperBound.constructor.parameters");
        if ((!r17.isEmpty()) == false) goto L25;
        r16 = new TypeProjectionImpl(Variance.OUT_VARIANCE, r13);
        goto L26
    L25:
        r16 = TypeUtils.makeStarProjection(r10, r14);
        goto L26
    L28:
        return new TypeProjectionImpl(Variance.INVARIANT, r13);
    L5:
        return super.computeProjection(r10, r11, r12, r13);
    }
}
