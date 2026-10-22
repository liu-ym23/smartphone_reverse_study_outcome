package com.bytedance.ttnet.throttle;

import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.c;
import r2.i;

/* JADX INFO: loaded from: classes.dex */
public class TTNetThrottle {
    public static final int DIRECTION_TYPE_DOWN = 2;
    public static final int DIRECTION_TYPE_PC_DOWN = 8;
    public static final int DIRECTION_TYPE_PC_UP = 4;
    public static final int DIRECTION_TYPE_UP = 1;
    private static final String TAG = "TTNetThrottle";

    public TTNetThrottle() {
    }

    private static i getCronetHttpClient() {
        if (c.c() == false) goto L7;
        return i.w(TTNetInit.getTTNetDepend().getContext());
    L7:
        throw new UnsupportedOperationException("Cronet is not enabled");
    }

    public static void start(String[] r10, int r11, long r12) {
        if (r10 == null) goto L20;
        if (r11 == 1) goto L12;
        if (r11 == 2) goto L12;
        if (r11 == 4) goto L12;
        if (r11 != 8) goto L20;
    L12:
        if (r12 < 0) goto L20;
        getCronetHttpClient().V(r10, r11, r12);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L20:
        if (Logger.debug() == false) goto L26;
        Logger.e(TAG, "start throttle params error hosts:" + r10 + " directionType:" + r11 + " bytesPerSec:" + r12);
        return;
    }

    public static void stop(String[] r10, int r11) {
        if (r10 == null) goto L18;
        if (r11 != 1) goto L6;
    L21:
        getCronetHttpClient().W(r10, r11);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (r11 == 2) goto L21;
        if (r11 == 4) goto L21;
        if (r11 == 8) goto L21;
    L18:
        if (Logger.debug() == false) goto L24;
        Logger.e(TAG, "stop throttle params error hosts:" + r10 + " directionType:" + r11);
        return;
    }
}
