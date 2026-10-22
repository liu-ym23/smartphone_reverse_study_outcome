package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class RevShareViewUI$$PropsSetter extends UIGroup$.PropsSetter {
    public RevShareViewUI$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        RevShareViewUI r0 = (RevShareViewUI) r3;
        r4.getClass();
        if (r4.equals("load-state") == false) goto L5;
        r0.setLoadState(r5.d(r4));
        return;
    L5:
        if (r4.equals("share-id") == true) goto L8;
        super.setProperty(r3, r4, r5);
        return;
    L8:
        r0.setShareId(r5.h(r4));
    }
}
