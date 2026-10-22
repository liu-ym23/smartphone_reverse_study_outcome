package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Observer {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final void onChanged(Object r3) {
        ALogger.i("GuestLinkMainPageDialogForAudience", "registerPlayerEvent playComplete: " + ((Boolean) r3));
    }
}
