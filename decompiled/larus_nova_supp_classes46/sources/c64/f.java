package c64;

import android.util.Size;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Size a(int r2, int r3, int r4, int r5) {
        if (r4 <= 0) goto L20;
        if (r5 <= 0) goto L20;
        if (r2 > r4) goto L10;
        if (r3 > r5) goto L10;
        float r6 = r2;
        float r7 = r3;
        float r8 = Math.max((r6 * 1.0f) / r4, (1.0f * r7) / r5);
        return new Size((int) (r6 / r8), (int) (r7 / r8));
    L10:
        if (r2 < r4) goto L14;
        if (r3 < r5) goto L14;
        float r9 = r2;
        float r10 = r3;
        float r11 = Math.max((r9 * 1.0f) / r4, (1.0f * r10) / r5);
        return new Size((int) (r9 / r11), (int) (r10 / r11));
    L14:
        if (r2 < r4) goto L17;
        float r12 = r2;
        float r0 = (1.0f * r12) / r4;
        return new Size((int) (r12 / r0), (int) (r3 / r0));
    L17:
        float r13 = r3;
        float r1 = (1.0f * r13) / r5;
        return new Size((int) (r2 / r1), (int) (r13 / r1));
    L20:
        return new Size(r2, r3);
    }
}
