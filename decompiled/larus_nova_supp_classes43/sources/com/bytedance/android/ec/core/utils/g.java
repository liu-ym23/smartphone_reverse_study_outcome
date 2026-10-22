package com.bytedance.android.ec.core.utils;

import android.content.Context;
import android.media.AudioManager;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.math.BigDecimal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public static AudioManager a = null;
    public static int b = -1;
    public static int c = -1;

    public static double a() {
        ECAppInfoService r0 = ECAppInfoService.e;
        double r10 = 0.0d;
        if (b(r0.getApplicationContext()) == false) goto L24;
        return 0.0d;
    L24:
        int r11 = -1;
        if (b < 0) goto L8;
    L15:
        int r1 = c;     // Catch: Exception -> L21
        if (b(r0.getApplicationContext()) == false) goto L26;
    L19:
        c = r11;     // Catch: Exception -> L21
        r10 = (((double) r11) * 1.0d) / ((double) b);     // Catch: Exception -> L21
        return new BigDecimal(r10).setScale(2, 4).doubleValue();
    L26:
        r11 = a.getStreamVolume(3);     // Catch: Exception -> L23
        goto L19
    L8:
        if (b(r0.getApplicationContext()) == false) goto L11;
        int r12 = -1;
    L14:
        b = r12;     // Catch: Exception -> L21
        goto L15
    L11:
        if (b >= 0) goto L13;
        b = a.getStreamMaxVolume(3);     // Catch: Exception -> L21
    L13:
        r12 = b;     // Catch: Exception -> L21
    L22:
        return r10;
    }

    public static boolean b(Context r1) {
        if (a != null) goto L8;
        a = (AudioManager) r1.getApplicationContext().getSystemService("audio");     // Catch: Exception -> L6
    L8:
        if (a != null) goto L10;
        return true;
    L10:
        return false;
    }
}
