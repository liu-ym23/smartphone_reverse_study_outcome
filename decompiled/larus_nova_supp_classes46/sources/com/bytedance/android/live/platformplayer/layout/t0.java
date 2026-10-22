package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdkapi.service.IFloatWindowService;
import com.bytedance.android.livesdkapi.service.IUhdLoginService;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public t0(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        Boolean r8 = (Boolean) r7;
        this.a.Er("player widget @" + this.a.hashCode() + " onStopped()");
        Boolean r0 = (Boolean) this.a.U2.e().getSwitchStreamDataEvent().getValue();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L6;
        this.a.U2.e().getSwitchStreamDataEvent().setValue(Boolean.FALSE);
        return;
    L6:
        if ((!Intrinsics.areEqual(r8, r1)) == false) goto L18;
        this.a.getClass();
        IFloatWindowService r9 = LivePlayerWidget.jr(IFloatWindowService.class);
        Intrinsics.checkNotNull(r9);
        if (r9.isAppBackground() == true) goto L18;
        IRoomContextService r10 = jc1.k.f(IRoomContextService.class);
        if (r10 == null) goto L34;
        com.bytedance.android.livesdk.chatroom.o r11 = IRoomContextService.a.a(r10, null, 0, 3);
        if (r11 != null) goto L14;
        return;
    L14:
        if (r11.isVSFirstShow() != true) goto L36;
        LivePlayerWidget r12 = this.a;
        if (r12.x == false) goto L37;
        r12.U2.o().e.u();
        return;
    L37:
        return;
    L36:
        return;
    L34:
        return;
    L18:
        IRoomContextService r13 = jc1.k.f(IRoomContextService.class);
        if (r13 == null) goto L29;
        com.bytedance.android.livesdk.chatroom.o r14 = IRoomContextService.a.a(r13, null, 0, 3);
        if (r14 == null) goto L29;
        if (r14.isVSFirstShow() != true) goto L29;
        this.a.getClass();
        IFloatWindowService r15 = LivePlayerWidget.jr(IFloatWindowService.class);
        if (r15 == null) goto L29;
        if (r15.isAppBackground() != true) goto L29;
        this.a.U2.o().e.j();
        this.a.x = true;
    L29:
        this.a.U2.e().getStartPull().setValue(Boolean.FALSE);
        this.a.getClass();
        IUhdLoginService r16 = LivePlayerWidget.Sq();
        if (r16 == null) goto L39;
        r16.releaseTimer(this.a.hashCode());
        return;
    }
}
