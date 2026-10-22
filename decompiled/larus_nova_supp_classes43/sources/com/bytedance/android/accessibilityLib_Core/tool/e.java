package com.bytedance.android.accessibilityLib_Core.tool;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final int a(View r10) {
        if (Build.VERSION.SDK_INT >= 29) goto L7;
        return -1;
    L7:
        return r10.getSourceLayoutResId();
    }
}
