package wx0;

import android.graphics.RectF;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public Float a;
    public Float b;

    public b() {
    }

    public final RectF b(float r5) {
        Float r0 = this.a;
        if (r0 == null) goto L12;
        float r1 = r0.floatValue();
        Float r2 = this.b;
        if (r2 == null) goto L12;
        float r3 = r2.floatValue() * 1.0f;
        float r6 = RangesKt.coerceAtMost(r5 * r3, r1);
        float r4 = r3 * 1.0f;
        if (r6 < r1) goto L9;
        float r7 = 0.0f;
    L11:
        return new RectF(r7, 0.0f, r6 + r7, r4);
    L9:
        r7 = (r1 - r6) / 2.0f;
    L12:
        return null;
    }

    public final RectF a(int r4, float r5, float r6) {
        Float r0 = this.a;
        if (r0 == null) goto L8;
        float r1 = r0.floatValue();
        Float r2 = this.b;
        if (r2 == null) goto L8;
        float r3 = r2.floatValue() * r5;
        float r7 = RangesKt.coerceAtMost(r6 * r3, r1);
        float r8 = (r1 - r7) / 2.0f;
        float r9 = r4;
        return new RectF(r8, r9, r7 + r8, (r3 * 1.0f) + r9);
    L8:
        return null;
    }
}
