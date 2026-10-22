package com.bytedance.android.ec.common.api.xigua;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/common/api/xigua/AccessibleTypeDelegate;", "Landroidx/core/view/AccessibilityDelegateCompat;", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final class AccessibleTypeDelegate extends AccessibilityDelegateCompat {
    public final String a;
    public final String b;

    public AccessibleTypeDelegate(String r1, String r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void onInitializeAccessibilityEvent(View r10, AccessibilityEvent r11) {
        Intrinsics.checkNotNullParameter(r10, "host");
        Intrinsics.checkNotNullParameter(r11, "event");
        super.onInitializeAccessibilityEvent(r10, r11);
        r11.setClassName(this.b);
        CharSequence r0 = this.a;
        if (r0 != null) goto L6;
        r0 = r10.getContentDescription();
    L6:
        r11.setContentDescription(r0);
    }

    public final void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
        Intrinsics.checkNotNullParameter(r10, "host");
        Intrinsics.checkNotNullParameter(r11, "info");
        super.onInitializeAccessibilityNodeInfo(r10, r11);
        r11.setClassName(this.b);
        CharSequence r0 = this.a;
        if (r0 != null) goto L6;
        r0 = r10.getContentDescription();
    L6:
        r11.setContentDescription(r0);
    }
}
