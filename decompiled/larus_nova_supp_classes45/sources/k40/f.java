package k40;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public static final h b(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$pos");
        return new h(r2.left, r2.top);
    }

    public static final g c(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$rawPos");
        return new g(r2.getRawX(), r2.getRawY());
    }

    public static final g g(h r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$toVec2f");
        return new g(r2.a().intValue(), r2.b().intValue());
    }

    public static final float a(g r1, g r2) {
        Intrinsics.checkNotNullParameter(r1, "a");
        Intrinsics.checkNotNullParameter(r2, "b");
        g r3 = e(r2, r1);
        float r4 = r3.a().floatValue();
        float r5 = r3.b().floatValue();
        return (float) Math.sqrt((r4 * r4) + (r5 * r5));
    }

    public static final void d(View r5, Rect r6) {
        Intrinsics.checkNotNullParameter(r5, "$this$getSizeStableHitRect");
        Intrinsics.checkNotNullParameter(r6, "rect");
        int r0 = MathKt.roundToInt(r5.getTranslationX());
        int r1 = MathKt.roundToInt(r5.getTranslationY());
        r6.set(r5.getLeft() + r0, r5.getTop() + r1, r5.getRight() + r0, r5.getBottom() + r1);
    }

    public static final g e(g r3, g r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$minus");
        Intrinsics.checkNotNullParameter(r4, "rhs");
        return new g(r3.a().floatValue() - r4.a().floatValue(), r3.b().floatValue() - r4.b().floatValue());
    }

    public static final h f(h r3, h r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$minus");
        Intrinsics.checkNotNullParameter(r4, "rhs");
        return new h(r3.a().intValue() - r4.a().intValue(), r3.b().intValue() - r4.b().intValue());
    }
}
