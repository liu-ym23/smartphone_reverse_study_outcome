package com.bytedance.android.live.liveinteract.revenue.guestlink;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Consumer {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final void accept(Object r3) {
        ALogger.e("GuestLinkWidget", "observeChannelInfoUpdate", (Throwable) r3);
    }
}
