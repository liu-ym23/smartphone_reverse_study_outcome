package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s5<T> implements Consumer {
    public static final s5 a = null;

    static {
        a = new s5();
    }

    public s5() {
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        ALogger.e("ToolbarVSMsgBoardBehavior", "load remote img error");
    }
}
