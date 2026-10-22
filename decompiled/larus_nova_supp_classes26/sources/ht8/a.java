package ht8;

import android.graphics.PointF;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void d(RectF r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "rect");
        e(r1, 0.0f, 0.0f, r2, r2);
    }

    public static RectF a(PointF r4, PointF r5, PointF r6, PointF r7) {
        Intrinsics.checkNotNullParameter(r4, "A");
        Intrinsics.checkNotNullParameter(r5, "B");
        Intrinsics.checkNotNullParameter(r6, "C");
        Intrinsics.checkNotNullParameter(r7, "D");
        if (Math.abs(r4.x - r5.x) >= 3.0f) goto L24;
        if (r4.x >= r6.x) goto L15;
        if (r4.y < r5.y) goto L11;
        r4 = r5;
    L11:
        if (r6.y > r7.y) goto L63;
        r6 = r7;
    L63:
        return new RectF(r4.x, r4.y, r6.x, r6.y);
    L15:
        if (r6.y < r7.y) goto L19;
        r6 = r7;
    L19:
        if (r4.y > r5.y) goto L22;
        r4 = r5;
    L22:
        PointF r3 = r6;
        r6 = r4;
        r4 = r3;
        goto L63
    L24:
        if (Math.abs(r4.x - r6.x) >= 3.0f) goto L44;
        if (r4.x >= r5.x) goto L36;
        if (r4.y < r6.y) goto L32;
        r4 = r6;
    L32:
        if (r5.y > r7.y) goto L52;
        r5 = r7;
    L52:
        r6 = r5;
        goto L63
    L36:
        if (r5.y < r7.y) goto L40;
        r5 = r7;
    L40:
        if (r4.y > r6.y) goto L61;
        r4 = r6;
    L61:
        r6 = r4;
        r4 = r5;
        goto L63
    L44:
        if (r4.x >= r5.x) goto L54;
        if (r4.y < r7.y) goto L50;
        r4 = r7;
    L50:
        if (r6.y <= r5.y) goto L52;
        r5 = r6;
        goto L52
    L54:
        if (r5.y < r6.y) goto L58;
        r5 = r6;
    L58:
        if (r4.y > r7.y) goto L61;
        r4 = r7;
        goto L61
    }

    public static void b(PointF r8, float r9, float r10, int r11) {
        Intrinsics.checkNotNullParameter(r8, "point");
        double r2 = r11 * 0.017453292f;
        float r12 = (float) (((((double) (r8.x - r9)) * Math.cos(r2)) - (((double) (r8.y - r10)) * Math.sin(r2))) + ((double) r9));
        float r13 = (float) (((((double) (r8.x - r9)) * Math.sin(r2)) + (((double) (r8.y - r10)) * Math.cos(r2))) + ((double) r10));
        r8.x = r12;
        r8.y = r13;
    }

    public static void c(RectF r6, int r7, float r8, float r9) {
        Intrinsics.checkNotNullParameter(r6, "rect");
        PointF r0 = new PointF(r6.left, r6.top);
        PointF r1 = new PointF(r6.right, r6.top);
        PointF r2 = new PointF(r6.left, r6.bottom);
        PointF r3 = new PointF(r6.right, r6.bottom);
        b(r0, r8, r9, r7);
        b(r1, r8, r9, r7);
        b(r2, r8, r9, r7);
        b(r3, r8, r9, r7);
        r6.set(a(r0, r1, r2, r3));
    }

    public static void e(RectF r1, float r2, float r3, float r4, float r5) {
        Intrinsics.checkNotNullParameter(r1, "rect");
        r1.left = ((r1.left - r2) * r4) + r2;
        r1.right = ((r1.right - r2) * r4) + r2;
        r1.top = ((r1.top - r3) * r5) + r3;
        r1.bottom = ((r1.bottom - r3) * r5) + r3;
    }
}
