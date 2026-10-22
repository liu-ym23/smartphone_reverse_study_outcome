package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.live.room.api.messagewindow.state.source.CardDataState;
import com.bytedance.android.livesdk.config.ny0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ ToolbarAudienceWelfareBehavior a;

    public a(ToolbarAudienceWelfareBehavior r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        r71.f r5 = (r71.f) r4;
        ToolbarAudienceWelfareBehavior r0 = this.a;
        if (r0.p != null) goto L6;
        r0.p = jc1.k.n(IMsgWindowService.class).commonCardBuilder().a(new ToolbarAudienceWelfareBehavior$prepareWelfareCommonCard$2$1(this, r5)).b();
    L6:
        if (ny0.a.getValue().booleanValue() == true) goto L8;
        com.bytedance.android.live.room.api.messagewindow.builder.card.c r6 = this.a.p;
        if (r6 == null) goto L15;
        r6.c(null);
    L15:
        ALogger.i("WelfareCommonCard", "onLoad show");
        return;
    L8:
        if (r5.b != CardDataState.SHOW) goto L15;
        com.bytedance.android.live.room.api.messagewindow.builder.card.c r7 = this.a.p;
        if (r7 == null) goto L15;
        r7.c(null);
        goto L15
    }
}
