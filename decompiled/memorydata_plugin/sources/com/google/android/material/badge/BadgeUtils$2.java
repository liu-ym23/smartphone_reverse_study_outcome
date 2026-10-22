package com.google.android.material.badge;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: loaded from: classes2.dex */
class BadgeUtils$2 extends AccessibilityDelegateCompat {
    final /* synthetic */ a val$badgeDrawable;

    BadgeUtils$2(View.AccessibilityDelegate r1, a r2) {
        this.val$badgeDrawable = r2;
        super(r1);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View r1, AccessibilityNodeInfoCompat r2) {
        super.onInitializeAccessibilityNodeInfo(r1, r2);
        r2.setContentDescription(this.val$badgeDrawable.f());
    }
}
