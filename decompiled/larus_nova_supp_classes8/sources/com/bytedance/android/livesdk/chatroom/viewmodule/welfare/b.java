package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ ToolbarAudienceWelfareBehavior a;

    public b(ToolbarAudienceWelfareBehavior r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        u71.a r3 = (u71.a) r2;
        com.bytedance.android.live.room.api.messagewindow.builder.card.c r0 = this.a.p;
        if (r0 == null) goto L12;
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r1 = r0.a;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.getType() != r3.a) goto L14;
        ALogger.i("WelfareCommonCard", "onCommonCardCycleDisplayEvent");
        com.bytedance.android.live.room.api.messagewindow.builder.card.c r4 = this.a.p;
        if (r4 == null) goto L15;
        r4.c(null);
        return;
    L15:
        return;
    L14:
        return;
    }
}
