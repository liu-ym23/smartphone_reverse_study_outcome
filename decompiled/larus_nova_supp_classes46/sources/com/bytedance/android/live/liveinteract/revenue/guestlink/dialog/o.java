package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o<T> implements Observer {
    public static final o a = null;

    static {
        a = new o();
    }

    public o() {
    }

    public final void onChanged(Object r3) {
        String r4 = (String) r3;
        if (TextUtils.isEmpty(r4) == true) goto L6;
        ALogger.e("GuestLinkMainPageDialogForAudience", "registerPlayerEvent playerMediaError: " + r4);
        return;
    }
}
