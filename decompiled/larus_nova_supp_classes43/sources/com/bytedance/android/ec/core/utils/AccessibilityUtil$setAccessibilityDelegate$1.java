package com.bytedance.android.ec.core.utils;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/ec/core/utils/AccessibilityUtil$setAccessibilityDelegate$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AccessibilityUtil$setAccessibilityDelegate$1 extends AccessibilityDelegateCompat {
    public final /* synthetic */ a.InterfaceC0145a a;

    public AccessibilityUtil$setAccessibilityDelegate$1(a.InterfaceC0145a r1) {
        this.a = r1;
    }

    public final void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
        Intrinsics.checkNotNullParameter(r10, "host");
        Intrinsics.checkNotNullParameter(r11, "info");
        super.onInitializeAccessibilityNodeInfo(r10, r11);
        a.InterfaceC0145a r12 = this.a;
        if (r12 == null) goto L6;
        r12.a(r11);
        return;
    }
}
