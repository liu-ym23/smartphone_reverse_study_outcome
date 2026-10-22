package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n<T> implements Consumer {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
    }

    public final void accept(Object r3) {
        ALogger.e("FetchRoomDataSource", "getRoomInfoByScene error: " + ((Throwable) r3).getMessage());
    }
}
