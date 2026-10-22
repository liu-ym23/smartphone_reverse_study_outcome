package com.lynx.tasm.fontface;

import android.graphics.Typeface;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h {
    public static final String c = null;
    public final Typeface a;
    public final Typeface[] b;

    static {
        c = h.class.getSimpleName();
    }

    public h(Typeface r3) {
        Typeface[] r0 = new Typeface[4];
        this.b = r0;
        this.a = r3;
        r0[0] = r3;
    }

    public final Typeface a(int r5) {
        if (r5 >= 0) goto L4;
    L5:
        r5 = 0;
    L6:
        Typeface[] r0 = this.b;
        if (r0[r5] != null) goto L13;
        r0[r5] = Typeface.create(this.a, r5);     // Catch: ArrayIndexOutOfBoundsException -> L10
    L10:
        e = move-exception;
        LLog.e(c, "create typeface failed, style: " + r5 + ", origin typeface: " + this.a + ", Typeface.create function is not thread safe lower than Android 9, exception: " + e);
    L13:
        return this.b[r5];
    L4:
        if (r5 <= 3) goto L6;
        goto L5
    }
}
