package ed0;

import android.graphics.PointF;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    static {
    }

    public static float a(PointF r9, PointF r10, EPointF r11) {
        Intrinsics.checkNotNullParameter(r9, "originPoint");
        Intrinsics.checkNotNullParameter(r10, "pointA");
        Intrinsics.checkNotNullParameter(r11, "pointB");
        Intrinsics.checkNotNullParameter(r9, "originPoint");
        Intrinsics.checkNotNullParameter(r10, "pointA");
        Intrinsics.checkNotNullParameter(r11, "pointB");
        PointF r3 = new PointF(r10.x - r9.x, r10.y - r9.y);
        PointF r4 = new PointF(((PointF) r11).x - r9.x, ((PointF) r11).y - r9.y);
        float r5 = (r3.x * r4.y) - (r3.y * r4.x);
        Intrinsics.checkNotNullParameter(r9, "originPoint");
        Intrinsics.checkNotNullParameter(r10, "pointA");
        Intrinsics.checkNotNullParameter(r11, "pointB");
        PointF r6 = new PointF(r10.x - r9.x, r10.y - r9.y);
        PointF r7 = new PointF(((PointF) r11).x - r9.x, ((PointF) r11).y - r9.y);
        Intrinsics.checkNotNullParameter(r9, "originPoint");
        Intrinsics.checkNotNullParameter(r10, "pointA");
        Intrinsics.checkNotNullParameter(r11, "pointB");
        PointF r0 = new PointF(r10.x - r9.x, r10.y - r9.y);
        PointF r12 = new PointF(((PointF) r11).x - r9.x, ((PointF) r11).y - r9.y);
        float r13 = (r0.x * r12.x) + (r0.y * r12.y);
        float r14 = r6.x;
        float r15 = r6.y;
        double r16 = Math.sqrt((r14 * r14) + (r15 * r15));
        float r1 = r7.x;
        float r2 = r7.y;
        float r17 = 0;
        float r18 = (float) Math.toDegrees(Math.acos(((double) r13) / (r16 * Math.sqrt((r1 * r1) + (r2 * r2)))));
        if (r5 <= r17) goto L6;
        return r18;
    L6:
        return r17 - r18;
    }
}
