package x6a;

import android.graphics.Rect;
import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j {
    public final RectF a;
    public final float[] b;
    public final boolean c;

    public final Rect a() {
        RectF r1 = this.a;
        return new Rect((int) r1.left, (int) r1.top, (int) r1.right, (int) r1.bottom);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof j) == true) goto L8;
        return false;
    L8:
        j r7 = (j) r6;
        RectF r1 = this.a;
        if (r1 != null) goto L11;
    L23:
        if (r1 == null) goto L25;
    L32:
        if (r1 == null) goto L41;
        RectF r3 = r7.a;
        if (r3 == null) goto L41;
        if (this.c == true) goto L41;
        if (r7.c == true) goto L41;
        return r1.equals(r3);
    L41:
        if (r1 == null) goto L43;
    L49:
        return false;
    L43:
        if (r7.a != null) goto L49;
        if (this.c == true) goto L49;
        if (r7.c == true) goto L49;
        return true;
    L25:
        if (r7.a != null) goto L32;
        if (this.c == false) goto L32;
        if (r7.c == false) goto L32;
        return Arrays.equals(this.b, r7.b);
    L11:
        if (this.b == null) goto L23;
        if (this.c == false) goto L23;
        if (r7.c == false) goto L23;
        if (r1.equals(r7.a) == true) goto L19;
    L21:
        return false;
    L19:
        if (Arrays.equals(this.b, r7.b) == false) goto L21;
        return true;
    }

    public j(RectF r5, float[] r6) {
        boolean r0 = false;
        this.c = false;
        this.a = r5;
        this.b = r6;
        if (r6 != null) goto L6;
    L14:
        this.c = r0;
        return;
    L6:
        if (r6.length != 8) goto L14;
        int r7 = r6.length;
        int r1 = 0;
    L9:
        if (r1 >= r7) goto L14;
        if (r6[r1] > 0.0f) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        r0 = true;
        goto L14
    }
}
