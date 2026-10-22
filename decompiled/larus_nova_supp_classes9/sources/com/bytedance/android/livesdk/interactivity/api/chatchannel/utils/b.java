package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final boolean a(com.bytedance.android.livesdk.interactivity.api.base.d r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.a != PublicScreenAreaPageType.ChatChannel) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L15;
        return true;
    L15:
        return false;
    L7:
        r1 = false;
        goto L8
    }
}
