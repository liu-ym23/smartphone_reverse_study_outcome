package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h0<T> implements Consumer {
    public static final h0 a = null;

    static {
        a = new h0();
    }

    public h0() {
    }

    public final void accept(Object r3) {
        ALogger.e("LongPressPanelPromptWidget", "report reason error: " + ((Throwable) r3).getMessage());
    }
}
