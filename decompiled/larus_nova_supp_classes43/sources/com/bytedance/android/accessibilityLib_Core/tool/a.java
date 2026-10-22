package com.bytedance.android.accessibilityLib_Core.tool;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final String a(IBaseConfig r0) {
        CharSequence r1 = ((AccessibilityNodeInfoCompat) r0.getVirtualNode().d.getValue()).getContentDescription();
        if (r1 == null) goto L7;
        String r10 = r1.toString();
        if (r10 == null) goto L7;
        return r10;
    L7:
        return "";
    }
}
