package com.bytedance.android.live.room.navi.userinfo_p.element;

import androidx.core.view.accessibility.AccessibilityManagerCompat;
import com.bytedance.android.livesdk.r3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements AccessibilityManagerCompat.TouchExplorationStateChangeListener {
    public final /* synthetic */ UserInfoBasicElement a;

    public d(UserInfoBasicElement r1) {
        this.a = r1;
    }

    public final void onTouchExplorationStateChanged(boolean r1) {
        if (r1 == false) goto L5;
        r3.p(this.a.i);
        return;
    }
}
