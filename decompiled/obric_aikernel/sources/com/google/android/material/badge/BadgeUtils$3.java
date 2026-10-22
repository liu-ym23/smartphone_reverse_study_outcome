package com.google.android.material.badge;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: loaded from: classes.dex */
class BadgeUtils$3 extends AccessibilityDelegateCompat {
    final /* synthetic */ a val$badgeDrawable;

    BadgeUtils$3(a r10) {
        this.val$badgeDrawable = r10;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
        super.onInitializeAccessibilityNodeInfo(r10, r11);
        r11.setContentDescription(this.val$badgeDrawable.f());
    }
}
