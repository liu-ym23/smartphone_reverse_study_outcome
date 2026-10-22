package com.google.android.material.badge;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: loaded from: classes.dex */
class BadgeUtils$2 extends AccessibilityDelegateCompat {
    final /* synthetic */ a val$badgeDrawable;

    BadgeUtils$2(View.AccessibilityDelegate r10, a r11) {
        this.val$badgeDrawable = r11;
        super(r10);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
        super.onInitializeAccessibilityNodeInfo(r10, r11);
        r11.setContentDescription(this.val$badgeDrawable.f());
    }
}
