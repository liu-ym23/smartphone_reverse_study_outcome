package com.bytedance.android.live.broadcastgame.xplay;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final Rect a(j r5, int r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r5, "$this$makeRect");
        Rect r0 = new Rect();
        boolean r2 = true;
        if ((r8 & 4) == 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        r0.left = r6;
        r0.right = r6 + r5.a;
    L16:
        if ((r8 & 8) == 0) goto L18;
        boolean r9 = true;
    L19:
        if (r9 == true) goto L21;
        r0.top = r7;
        r0.bottom = r7 + r5.b;
    L28:
        return r0;
    L21:
        if ((r8 & 2) != 0) goto L24;
        r2 = false;
    L24:
        if (r2 == false) goto L26;
        int r11 = r5.b;
        int r12 = r7 - (r11 / 2);
        r0.top = r12;
        r0.bottom = r12 + r11;
        goto L28
    L26:
        r0.top = r7 - r5.b;
        r0.bottom = r7;
        goto L28
    L18:
        r9 = false;
        goto L19
    L8:
        if ((r8 & 1) == 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        int r4 = r5.a;
        int r13 = r6 - (r4 / 2);
        r0.left = r13;
        r0.right = r13 + r4;
        goto L16
    L13:
        r0.left = r6 - r5.a;
        r0.right = r6;
        goto L16
    L10:
        r3 = false;
        goto L11
    L5:
        r1 = false;
        goto L6
    }
}
