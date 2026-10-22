package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.utils.MorePanelBubbleAlog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomReqUserData;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ ShareBubbleLoader.AnonymousClass1.a a;

    public m(ShareBubbleLoader.AnonymousClass1.a r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        Room r9 = (Room) r8;
        ShareBubbleLoader r0 = this.a.a.this$0;
        r0.getClass();
        if (r9 == null) goto L7;
        RoomReqUserData r10 = r9.reqUserRoomData;
        if (r10 == null) goto L7;
        float r11 = r10.getShareScore();
    L8:
        int r2 = 0;
        if (r11 <= 0.0f) goto L11;
        boolean r1 = true;
    L12:
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r4 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r4.d(r0.b);
        r4.c("checkScore");
        Pair[] r5 = {TuplesKt.to("score", Float.valueOf(r11)), TuplesKt.to("result", Boolean.valueOf(r1))};
    L13:
        if (r2 >= 2) goto L20;
        Pair r12 = r5[r2];
        if (r12 == null) goto L19;
        Object r3 = r12.getSecond();
        if (r3 == null) goto L19;
        r4.a((String) r12.getFirst(), r3);
    L19:
        r2 = r2 + 1;
        goto L13
    L20:
        MorePanelBubbleAlog.a(r4.b());
        if (r1 == false) goto L28;
        this.a.a.this$0.a();
        return;
    L28:
        return;
    L11:
        r1 = false;
    L7:
        r11 = 0.0f;
        goto L8
    }
}
