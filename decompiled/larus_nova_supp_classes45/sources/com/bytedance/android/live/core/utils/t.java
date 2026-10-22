package com.bytedance.android.live.core.utils;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t extends View.AccessibilityDelegate {
    public static final t a = null;

    static {
        a = new t();
    }

    public t() {
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "info");
        super.onInitializeAccessibilityNodeInfo(r2, r3);
        r3.setClassName(Button.class.getName());
    }
}
