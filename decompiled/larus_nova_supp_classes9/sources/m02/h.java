package m02;

import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    static {
    }

    public static float a(PointF r9, PointF r10, PointF r11) {
        Intrinsics.checkNotNullParameter(r9, "originPoint");
        Intrinsics.checkNotNullParameter(r10, "pointA");
        Intrinsics.checkNotNullParameter(r11, "pointB");
        Intrinsics.checkNotNullParameter(r9, "originPoint");
        Intrinsics.checkNotNullParameter(r10, "pointA");
        Intrinsics.checkNotNullParameter(r11, "pointB");
        PointF r3 = new PointF(r10.x - r9.x, r10.y - r9.y);
        PointF r4 = new PointF(r11.x - r9.x, r11.y - r9.y);
        float r5 = (r3.x * r4.y) - (r3.y * r4.x);
        Intrinsics.checkNotNullParameter(r9, "originPoint");
        Intrinsics.checkNotNullParameter(r10, "pointA");
        Intrinsics.checkNotNullParameter(r11, "pointB");
        PointF r6 = new PointF(r10.x - r9.x, r10.y - r9.y);
        PointF r7 = new PointF(r11.x - r9.x, r11.y - r9.y);
        Intrinsics.checkNotNullParameter(r9, "originPoint");
        Intrinsics.checkNotNullParameter(r10, "pointA");
        Intrinsics.checkNotNullParameter(r11, "pointB");
        PointF r0 = new PointF(r10.x - r9.x, r10.y - r9.y);
        PointF r13 = new PointF(r11.x - r9.x, r11.y - r9.y);
        float r14 = (r0.x * r13.x) + (r0.y * r13.y);
        float r15 = r6.x;
        float r16 = r6.y;
        double r17 = Math.sqrt((r15 * r15) + (r16 * r16));
        float r1 = r7.x;
        float r2 = r7.y;
        float r18 = 0;
        float r19 = (float) Math.toDegrees(Math.acos(((double) r14) / (r17 * Math.sqrt((r1 * r1) + (r2 * r2)))));
        if (r5 <= r18) goto L6;
        return r19;
    L6:
        return r18 - r19;
    }
}
