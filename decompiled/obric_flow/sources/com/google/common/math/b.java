package com.google.common.math;

import com.google.common.base.b0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f9304a = 0;

    static {
        Math.log(2.0d);
    }

    public static boolean a(double r10) {
        if (com.lynx.tasm.utils.e.i(r10) == true) goto L5;
    L13:
        return false;
    L5:
        if (r10 == 0.0d) goto L15;
        b0.g("not a normal value", com.lynx.tasm.utils.e.i(r10));
        int r5 = Math.getExponent(r10);
        long r11 = Double.doubleToRawLongBits(r10) & 4503599627370495L;
        if (r5 != (-1023)) goto L9;
        long r12 = r11 << 1;
    L11:
        if ((52 - Long.numberOfTrailingZeros(r12)) > Math.getExponent(r10)) goto L13;
        return true;
    L9:
        r12 = r11 | 4503599627370496L;
        goto L11
    L15:
        return true;
    }
}
