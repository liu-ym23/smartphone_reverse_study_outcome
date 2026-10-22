package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0<T> implements Consumer {
    public static final d0 a = null;

    static {
        a = new d0();
    }

    public d0() {
    }

    public final void accept(Object r3) {
        ALogger.e("interact_emoji", "query_user failed " + ((Throwable) r3));
    }
}
