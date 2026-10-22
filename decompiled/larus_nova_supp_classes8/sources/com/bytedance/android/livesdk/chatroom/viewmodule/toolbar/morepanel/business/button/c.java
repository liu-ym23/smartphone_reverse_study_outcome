package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void accept(Object r2) {
        ALogger.d("AbsAudienceToolbarButtonMoreDialog", ((Throwable) r2).toString());
    }
}
