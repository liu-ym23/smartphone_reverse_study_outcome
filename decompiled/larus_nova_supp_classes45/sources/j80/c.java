package j80;

import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final float d(d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$norm2");
        return (float) Math.sqrt((r2.a().floatValue() * r2.a().floatValue()) + (r2.b().floatValue() * r2.b().floatValue()));
    }

    public static final e f(d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$roundToVec2i");
        return new e(MathKt.roundToInt(r2.a().floatValue()), MathKt.roundToInt(r2.b().floatValue()));
    }

    public static final d h(e r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$toVec2f");
        return new d(r2.a().intValue(), r2.b().intValue());
    }

    public static final float a(d r1, d r2) {
        Intrinsics.checkNotNullParameter(r1, "a");
        Intrinsics.checkNotNullParameter(r2, "b");
        d r3 = b(r2, r1);
        float r4 = r3.a().floatValue();
        float r5 = r3.b().floatValue();
        return (float) Math.sqrt((r4 * r4) + (r5 * r5));
    }

    public static final d b(d r3, d r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$minus");
        Intrinsics.checkNotNullParameter(r4, "rhs");
        return new d(r3.a().floatValue() - r4.a().floatValue(), r3.b().floatValue() - r4.b().floatValue());
    }

    public static final e c(e r3, e r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$minus");
        Intrinsics.checkNotNullParameter(r4, "rhs");
        return new e(r3.a().intValue() - r4.a().intValue(), r3.b().intValue() - r4.b().intValue());
    }

    public static final d e(d r3, d r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$plus");
        Intrinsics.checkNotNullParameter(r4, "rhs");
        return new d(r3.a().floatValue() + r4.a().floatValue(), r3.b().floatValue() + r4.b().floatValue());
    }

    public static final int g(e r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$times");
        Intrinsics.checkNotNullParameter(r3, "rhs");
        return (r2.a().intValue() * r3.a().intValue()) + (r2.b().intValue() * r3.b().intValue());
    }
}
