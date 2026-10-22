package xt8;

import android.graphics.RectF;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static RectF a(float[] r6) {
        RectF r0 = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        int r1 = 1;
    L4:
        if (r1 >= r6.length) goto L20;
        float r2 = Math.round(r6[r1 - 1] * 10.0f) / 10.0f;
        float r4 = Math.round(r6[r1] * 10.0f) / 10.0f;
        float r3 = r0.left;
        if (r2 >= r3) goto L8;
        r3 = r2;
    L8:
        r0.left = r3;
        float r5 = r0.top;
        if (r4 >= r5) goto L11;
        r5 = r4;
    L11:
        r0.top = r5;
        float r7 = r0.right;
        if (r2 > r7) goto L15;
        r2 = r7;
    L15:
        r0.right = r2;
        float r8 = r0.bottom;
        if (r4 > r8) goto L19;
        r4 = r8;
    L19:
        r0.bottom = r4;
        r1 = r1 + 2;
        goto L4
    L20:
        r0.sort();
        return r0;
    }
}
