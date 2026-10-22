package com.ttnet.org.chromium.base;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ApiCompatibilityUtils$ApisM {
    private ApiCompatibilityUtils$ApisM() {
    }

    public static void setStatusBarIconColor(View r1, boolean r2) {
        int r0 = r1.getSystemUiVisibility();
        if (r2 == false) goto L5;
        int r3 = r0 | 8192;
    L6:
        r1.setSystemUiVisibility(r3);
        return;
    L5:
        r3 = r0 & (-8193);
        goto L6
    }
}
