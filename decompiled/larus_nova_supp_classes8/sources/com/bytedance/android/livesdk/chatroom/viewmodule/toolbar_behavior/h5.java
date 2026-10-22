package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h5 implements Consumer<Throwable> {
    public h5() {
    }

    public final void accept(Object r2) throws Exception {
        Throwable r3 = (Throwable) r2;
        ALogger.e("ToolbarShareBehavior", "load remote img error");
    }
}
