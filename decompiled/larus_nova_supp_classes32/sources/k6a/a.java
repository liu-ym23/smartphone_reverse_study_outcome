package k6a;

import android.graphics.Path;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static Path a(float[] r4, boolean r5) {
        Path r0 = new Path();
        if (r4 == null) goto L13;
        int r2 = 2;
        if (r4.length < 2) goto L13;
        r0.moveTo(r4[0], r4[1]);
    L9:
        if (r2 >= r4.length) goto L11;
        r0.lineTo(r4[r2], r4[r2 + 1]);
        r2 = r2 + 2;
        goto L9
    L11:
        if (r5 == false) goto L13;
        r0.close();
    L13:
        return r0;
    }
}
