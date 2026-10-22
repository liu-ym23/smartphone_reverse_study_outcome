package com.bytedance.android.accessibilityLib_Core.base.largertoucharea;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/base/largertoucharea/LargerAreaAccessibilityNodeProvider;", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final class LargerAreaAccessibilityNodeProvider extends AccessibilityNodeProviderCompat {
    public final View a;
    public final AccessibilityDelegateCompat b;

    public final AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int r10) {
        AccessibilityNodeInfoCompat r11 = AccessibilityNodeInfoCompat.wrap(AccessibilityNodeInfo.obtain(this.a));     // Catch: Exception -> L13
        this.b.onInitializeAccessibilityNodeInfo(this.a, r11);     // Catch: Exception -> L13
        Rect r0 = new Rect();     // Catch: Exception -> L13
        r11.getBoundsInScreen(r0);     // Catch: Exception -> L13
        boolean r12 = false;
        int r1 = RangesKt.coerceAtLeast((a.f - r0.width()) / 2, 0);     // Catch: Exception -> L13
        int r13 = RangesKt.coerceAtLeast((a.g - r0.height()) / 2, 0);     // Catch: Exception -> L13
        if (r1 != 0) goto L7;
        if (r13 != 0) goto L7;
        return r11;
    L7:
        if (this.a.getVisibility() != 0) goto L9;
        r12 = true;
    L9:
        if (r12 == true) goto L11;
        return r11;
    L11:
        r0.left -= r1;     // Catch: Exception -> L13
        r0.top -= r13;     // Catch: Exception -> L13
        r0.right += r1;     // Catch: Exception -> L13
        r0.bottom += r13;     // Catch: Exception -> L13
        r11.setBoundsInScreen(r0);     // Catch: Exception -> L13
        return r11;
    L13:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L18;
        Context r14 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L18:
        if (("large touch area failed,occur exception, error message = " + e.getMessage()) == null) goto L20;
        Context r15 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L20:
        return null;
    }

    public LargerAreaAccessibilityNodeProvider(View r1, AccessibilityDelegateCompat r10) {
        this.a = r1;
        this.b = r10;
    }

    public final boolean performAction(int r10, int r11, Bundle r12) {
        return this.b.performAccessibilityAction(this.a, r11, r12);
    }
}
