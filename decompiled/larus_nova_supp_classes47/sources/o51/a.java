package o51;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.android.live.revlink.link.core.service.q;
import f31.k;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final RectF b(List<q> r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$rectF");
        Iterator<T> r8 = r7.iterator();
        int r0 = Integer.MAX_VALUE;
        int r1 = Integer.MAX_VALUE;
        int r2 = Integer.MIN_VALUE;
        int r3 = Integer.MIN_VALUE;
    L4:
        if (r8.hasNext() == false) goto L7;
        q r4 = (q) r8.next();
        r0 = RangesKt.coerceAtMost(r0, r4.b);
        r1 = RangesKt.coerceAtMost(r1, r4.c);
        r2 = RangesKt.coerceAtLeast(r2, r4.b + r4.d);
        r3 = RangesKt.coerceAtLeast(r3, r4.c + r4.e);
        goto L4
    L7:
        return new RectF(r0, r1, r2, r3);
    }

    public static final RectF c(t51.b r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$rectF");
        return new RectF(r5.e(), r5.f(), r5.e() + r5.d(), r5.f() + r5.a());
    }

    public static final RectF d(List<? extends RectF> r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$total");
        Iterator<T> r7 = r6.iterator();
        float r0 = Float.MAX_VALUE;
        float r1 = Float.MAX_VALUE;
        float r2 = Float.MIN_VALUE;
        float r3 = Float.MIN_VALUE;
    L4:
        if (r7.hasNext() == false) goto L7;
        RectF r4 = (RectF) r7.next();
        r0 = RangesKt.coerceAtMost(r0, r4.left);
        r1 = RangesKt.coerceAtMost(r1, r4.top);
        r2 = RangesKt.coerceAtLeast(r2, r4.right);
        r3 = RangesKt.coerceAtLeast(r3, r4.bottom);
        goto L4
    L7:
        return new RectF(r0, r1, r2, r3);
    }

    public static final RectF e(List<k> r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$visibleRectF");
        Iterator<T> r8 = r7.iterator();
        int r0 = Integer.MAX_VALUE;
        int r1 = Integer.MAX_VALUE;
        int r2 = Integer.MIN_VALUE;
        int r3 = Integer.MIN_VALUE;
    L4:
        if (r8.hasNext() == false) goto L7;
        k r4 = (k) r8.next();
        r0 = RangesKt.coerceAtMost(r0, r4.c);
        r1 = RangesKt.coerceAtMost(r1, r4.d);
        r2 = RangesKt.coerceAtLeast(r2, r4.c + r4.e);
        r3 = RangesKt.coerceAtLeast(r3, r4.d + r4.f);
        goto L4
    L7:
        return new RectF(r0, r1, r2, r3);
    }

    public static final Matrix a(RectF r4, RectF r5) {
        Intrinsics.checkNotNullParameter(r4, "from");
        Intrinsics.checkNotNullParameter(r5, "to");
        Matrix r0 = new Matrix();
        r0.postTranslate(r5.left - r4.left, r5.top - r4.top);
        r0.postScale(r5.width() / r4.width(), r5.height() / r4.height(), r5.left, r5.top);
        return r0;
    }
}
