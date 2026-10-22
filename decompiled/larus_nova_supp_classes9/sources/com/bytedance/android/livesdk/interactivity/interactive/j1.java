package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j1<T> implements Consumer {
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.msgboard.a a;

    public j1(com.bytedance.android.livesdk.chatroom.msgboard.a r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.setRequestDressInfoFailed(true);
        ALogger.e("VSMsgBoardUtils", "request dressInfo Failed");
    }
}
