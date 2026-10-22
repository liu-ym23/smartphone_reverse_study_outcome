package com.larus.bmhome.chat.api;

import com.larus.utils.CubicBezierInterpolator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b0$a {
    public static /* synthetic */ void b(b0 r2, boolean r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        boolean r5 = true;
    L9:
        r2.l(r3, 0, r5, null);
        return;
    L8:
        r5 = false;
        goto L9
    }

    public static /* synthetic */ void a(b0 r2, boolean r3, int r4, Function0 r5, CubicBezierInterpolator r6, int r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r8 & 16) == 0) goto L17;
        r7 = Integer.MIN_VALUE;
    L17:
        r2.c(r3, r4, r5, r6, r7);
    }
}
