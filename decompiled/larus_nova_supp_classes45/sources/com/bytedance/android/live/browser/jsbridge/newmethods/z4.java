package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetMessageBoardDataResultModel;
import com.bytedance.android.livesdkapi.interact.RefreshVSMessageBoardDataEvent;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z4<T> implements Consumer {
    public final /* synthetic */ w4 a;
    public final /* synthetic */ GetMessageBoardDataResultModel b;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.msgboard.a c;
    public final /* synthetic */ w20.p9 d;

    public z4(w4 r1, GetMessageBoardDataResultModel r2, com.bytedance.android.livesdk.chatroom.msgboard.a r3, long r4, w20.p9 r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r6;
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        w4 r7 = this.a;
        GetMessageBoardDataResultModel r0 = this.b;
        com.bytedance.android.livesdk.chatroom.msgboard.a r1 = this.c;
        List<String> r2 = r7.a;
        this.d.getClass();
        w4.j(r7, r0, r1, r2);
        xs2.b.a().post(new RefreshVSMessageBoardDataEvent());
    }
}
