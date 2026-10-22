package com.lynx.tasm.fontface;

import android.graphics.Typeface;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.p;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Typeface f10873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Typeface[] f10874b;

    public i(Typeface r5) {
        Typeface[] r10 = new Typeface[4];
        this.f10874b = r10;
        this.f10873a = r5;
        r10[0] = r5;
    }

    public final Typeface a(int r5) {
        Typeface r10 = this.f10873a;
        if (r5 >= 0) goto L5;
    L6:
        r5 = 0;
    L7:
        Typeface[] r11 = this.f10874b;
        if (r11[r5] != null) goto L14;
        r11[r5] = Typeface.create(r10, r5);     // Catch: ArrayIndexOutOfBoundsException -> L11
    L11:
        e = move-exception;
        StringBuilder r12 = p.d(r5, "create typeface failed, style: ", ", origin typeface: ");
        r12.append(r10);
        r12.append(", Typeface.create function is not thread safe lower than Android 9, exception: ");
        r12.append(e);
        LynxLog.b(4, "StyledTypeface", r12.toString());
    L14:
        return r11[r5];
    L5:
        if (r5 <= 3) goto L7;
        goto L6
    }
}
