package com.bytedance.android.livesdk.chatroom.viewmodule.record;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p extends AccessibilityDelegateCompat {
    public final /* synthetic */ LiveRecordWidget a;

    public p(LiveRecordWidget r1) {
        this.a = r1;
    }

    public final void onInitializeAccessibilityNodeInfo(View r1, AccessibilityNodeInfoCompat r2) {
        super.onInitializeAccessibilityNodeInfo(r1, r2);
        if (this.a.r == false) goto L5;
        r2.setContentDescription(s1.B(2131921127));
        return;
    L5:
        r2.setContentDescription(s1.B(2131915842));
    }
}
