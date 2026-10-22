package com.bytedance.android.live.liveinteract.chatroom.chatroom;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r2) {
        ALogger.e("ttlive_link", (Throwable) r2);
    }
}
