package wx0;

import android.graphics.Matrix;
import android.graphics.RectF;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final RectF a;

    /* JADX INFO: renamed from: wx0.a$a, reason: collision with other inner class name */
    public static final class C0341a {
    }

    static {
    }

    public a() {
        this.a = new RectF();
    }

    public static RectF b(float r4, float r5, RectF r6) {
        float r7 = r5 * 1.0f;
        float r8 = RangesKt.coerceAtMost(r7, r4 * 1.0f);
        RectF r1 = new RectF(r6);
        Matrix r9 = new Matrix();
        float r2 = r8 / r7;
        if (r8 < r7) goto L5;
        float r10 = 0.0f;
    L6:
        r9.postScale(r2, 1.0f);
        r9.postTranslate(r10, 0.0f);
        r9.mapRect(r1);
        return r1;
    L5:
        r10 = 1.0f - r2;
        goto L6
    }

    public static RectF a(float r3, float r4, float r5, RectF r6) {
        float r7 = r3 * 1.0f;
        float r8 = r5 * r7;
        float r9 = RangesKt.coerceAtMost(r8, r4 * 1.0f);
        RectF r2 = new RectF(r6);
        Matrix r10 = new Matrix();
        float r12 = r9 / r8;
        r10.postScale(r12, (r7 * 1.0f) / r7);
        r10.postTranslate((1.0f - r12) / 2.0f, 0.0f);
        r10.mapRect(r2);
        jy0.b.d("DefaultStream2VisibleAreaConvert", "computeRule1Pos visibleRelativePos = " + r2.left + ", " + r2.top + ", " + r2.right + ", " + r2.bottom);
        return r2;
    }
}
