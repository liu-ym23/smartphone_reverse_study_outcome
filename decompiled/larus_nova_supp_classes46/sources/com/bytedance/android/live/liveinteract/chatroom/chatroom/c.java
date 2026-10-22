package com.bytedance.android.live.liveinteract.chatroom.chatroom;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.model.interact.q1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void accept(Object r4) {
        com.bytedance.android.live.network.response.e r5 = (com.bytedance.android.live.network.response.e) r4;
        if (r5 == null) goto L6;
        ALogger.d("ApplyPop", "count : " + ((q1) r5.data).getShowGuidelineCount());
        return;
    }
}
