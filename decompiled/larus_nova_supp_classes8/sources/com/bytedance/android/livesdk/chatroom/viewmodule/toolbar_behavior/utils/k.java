package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k<T> implements Consumer {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        if (r4 == null) goto L6;
        String r0 = r4.getMessage();
        if (r0 == null) goto L6;
    L7:
        Logger.e("introduce-card", r0, r4);
        return;
    L6:
        r0 = "直播间状态设置出错";
        goto L7
    }
}
