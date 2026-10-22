package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Observer {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final void onChanged(Object r3) {
        ALogger.i("GuestLinkMainPageDialogForAudience", "registerPlayerEvent playing: " + ((Boolean) r3));
    }
}
