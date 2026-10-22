package com.bytedance.apm.util;

import android.content.Context;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.apm.core.ActivityLifeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class i {
    public static float a;
    public static int b;
    public static int c;
    public static boolean d;
    public static int e;
    public static int f;

    static {
        Context r0 = com.bytedance.apm.d.getContext();
        ActivityLifeObserver.getInstance().register(new h());
        int r2 = 0;
        boolean r3 = false;
        float r4 = 0.0f;
        if (com.bytedance.apm.d.t == true) goto L5;
    L18:
        c = 60;
        b = 60;
        d = true;
        a = 1000.0f / 60;
        f = 60;
        e = 60;
        if (Build.VERSION.SDK_INT < 23) goto L36;
        if (r0 == null) goto L37;
        Display r1 = ((WindowManager) r0.getSystemService("window")).getDefaultDisplay();
        e = a(r1.getRefreshRate());
        Display.Mode[] r5 = r1.getSupportedModes();
        int r6 = r5.length;
    L22:
        if (r2 >= r6) goto L27;
        float r7 = r5[r2].getRefreshRate();
        if (r7 <= r4) goto L26;
        r4 = r7;
    L26:
        r2 = r2 + 1;
        goto L22
    L27:
        f = a(r4);
        return;
    L37:
        return;
    L36:
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L18;
        if (r0 == null) goto L18;
        Display r8 = ((WindowManager) r0.getSystemService("window")).getDefaultDisplay();
        float r9 = r8.getRefreshRate();
        Display.Mode[] r10 = r8.getSupportedModes();
        int r11 = r10.length;
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L14;
        float r13 = r10[r12].getRefreshRate();
        if (r13 <= r4) goto L13;
        r4 = r13;
    L13:
        r12 = r12 + 1;
        goto L9
    L14:
        int r14 = a(r9);
        b = r14;
        e = r14;
        int r15 = a(r4);
        c = r15;
        int r16 = b;
        if (r16 != r15) goto L17;
        r3 = true;
    L17:
        d = r3;
        a = 1000.0f / r16;
    }

    public static int a(float r2) {
        if (Math.abs(r2 - 60.0f) >= 5.1f) goto L7;
        return 60;
    L7:
        if (Math.abs(r2 - 90.0f) >= 5.1f) goto L11;
        return 90;
    L11:
        if (Math.abs(r2 - 120.0f) >= 5.1f) goto L15;
        return 120;
    L15:
        return (int) r2;
    }
}
