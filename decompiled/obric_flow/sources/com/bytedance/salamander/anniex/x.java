package com.bytedance.salamander.anniex;

import com.bytedance.rts.foundation.Int32;
import com.bytedance.rts.foundation.RTSMapKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x {
    public static w a(int r5, boolean r10) {
        w r11 = new w(r10);
        RTSMapKt.set(y.f7283a, Integer.valueOf(r5), r11);
        if (r5 <= y.f7284b) goto L5;
        y.f7284b = r5;
    L5:
        return r11;
    }

    public static void b(long r10) {
        int r5 = 0;
    L4:
        if (r5 > y.f7284b) goto L16;
        boolean r11 = true;
        if (r5 == 0) goto L8;
        r10 = r10 >> 1;
    L8:
        w r12 = (w) y.f7283a.get(Integer.valueOf(r5));
        if (r12 == null) goto L15;
        if ((r10 % 2) != Int32.Companion.toInt64(0)) goto L14;
        r11 = false;
    L14:
        r12.f7282a = r11;
    L15:
        r5 = r5 + 1;
        goto L4
    }
}
