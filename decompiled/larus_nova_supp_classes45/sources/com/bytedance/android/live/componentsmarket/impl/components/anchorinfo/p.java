package com.bytedance.android.live.componentsmarket.impl.components.anchorinfo;

import androidx.core.view.accessibility.AccessibilityManagerCompat;
import com.bytedance.android.livesdk.r3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p implements AccessibilityManagerCompat.TouchExplorationStateChangeListener {
    public final /* synthetic */ MediaAnchorInfoWidget a;

    public p(MediaAnchorInfoWidget r1) {
        this.a = r1;
    }

    public final void onTouchExplorationStateChanged(boolean r1) {
        if (r1 == false) goto L5;
        r3.p(this.a.c);
        return;
    }
}
