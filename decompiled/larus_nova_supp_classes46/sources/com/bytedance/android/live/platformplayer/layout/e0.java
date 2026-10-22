package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdkapi.service.IUhdLoginService;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public e0(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Boolean r6 = (Boolean) r5;
        if (r6 == null) goto L27;
        r6.booleanValue();
        this.a.Er("player widget @" + this.a.hashCode() + " onPlayComplete()");
        if (this.a.U2.getLivePaused() == false) goto L10;
        this.a.getClass();
        IUhdLoginService r7 = LivePlayerWidget.Sq();
        if (r7 == null) goto L28;
        r7.releaseTimer(this.a.hashCode());
        return;
    L28:
        return;
    L10:
        if (r6.booleanValue() == false) goto L30;
        IRoomContextService r8 = jc1.k.f(IRoomContextService.class);
        if (r8 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.o r9 = IRoomContextService.a.a(r8, null, 0, 3);
        if (r9 == null) goto L19;
        com.bytedance.live.datacontext.m r10 = r9.c2();
        if (r10 == null) goto L19;
        if (((Boolean) r10.getValue()).booleanValue() != true) goto L19;
    L20:
        com.bytedance.android.live.platformplayer.utils.f r11 = this.a.r.c;
        if (r11 == null) goto L23;
        r11.start();
    L23:
        this.a.getClass();
        IUhdLoginService r12 = LivePlayerWidget.Sq();
        if (r12 == null) goto L31;
        r12.releaseTimer(this.a.hashCode());
        return;
    L31:
        return;
    L19:
        this.a.U2.e().getTryShowLoading().setValue(Boolean.TRUE);
        goto L20
    L30:
        return;
    }
}
