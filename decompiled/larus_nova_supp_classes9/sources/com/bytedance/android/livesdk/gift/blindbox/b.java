package com.bytedance.android.livesdk.gift.blindbox;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final h1 a(h1 r5) {
        if (r5 == null) goto L18;
        String r1 = r5.getBannerScheme();
        boolean r2 = false;
        if (r1 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L13;
    L15:
        if (r2 == false) goto L18;
        return r5;
    L13:
        if (r5.getType() != 12) goto L15;
        r2 = true;
        goto L15
    L7:
        if (r1.length() == 0) goto L10;
        r3 = false;
    L18:
        return null;
    }

    public static final h1 b(AbsPanel<?> r2) {
        if (r2 == null) goto L5;
        Object r3 = r2.h;
    L7:
        if ((r3 instanceof h1) == true) goto L9;
        r3 = null;
    L9:
        h1 r4 = (h1) r3;
        if (r4 != null) goto L12;
        return null;
    L12:
        return a(r4);
    L5:
        r3 = null;
        goto L7
    }
}
