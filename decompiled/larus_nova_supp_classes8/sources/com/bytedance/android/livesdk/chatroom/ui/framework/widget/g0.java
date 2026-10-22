package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g0<T> implements Consumer {
    public static final g0 a = null;

    static {
        a = new g0();
    }

    public g0() {
    }

    public final void accept(Object r2) {
        com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
        ALogger.i("LongPressPanelPromptWidget", "report reason success");
    }
}
