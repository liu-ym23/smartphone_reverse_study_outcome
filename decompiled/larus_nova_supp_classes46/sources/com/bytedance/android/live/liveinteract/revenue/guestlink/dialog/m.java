package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Observer {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public final void onChanged(Object r3) {
        ALogger.i("GuestLinkMainPageDialogForAudience", "registerPlayerEvent playResume: " + ((Boolean) r3));
    }
}
