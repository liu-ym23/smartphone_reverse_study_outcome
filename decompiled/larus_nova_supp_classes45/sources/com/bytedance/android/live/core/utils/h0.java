package com.bytedance.android.live.core.utils;

import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h0 {
    public static float a() {
        if (b() > 0.0f) goto L5;
        return 16.666668f;
    L5:
        return 1000 / b();
    }

    public static float b() {
        WindowManager r0 = (WindowManager) s1.getContext().getSystemService("window");
        if (r0 == null) goto L8;
        Display r1 = r0.getDefaultDisplay();
        if (r1 == null) goto L8;
        return r1.getRefreshRate();
    L8:
        return 60;
    }
}
