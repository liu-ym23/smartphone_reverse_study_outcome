package com.bytedance.android.live.broadcastgame.xplay;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b0 implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ com.bytedance.android.live.broadcastgame.api.xplay.l b;
    public final /* synthetic */ Ref.BooleanRef c;
    public final /* synthetic */ c0 d;

    public b0(boolean r1, com.bytedance.android.live.broadcastgame.api.xplay.l r2, Ref.BooleanRef r3, c0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        String r1 = com.bytedance.android.live.liveinteract.revenue.game.c.a;
        XplayGlobalServiceImpl r2 = XplayGlobalServiceImpl.c;
        c0 r3 = this.d;
        Context r4 = r3.e;
        DataCenter r13 = (DataCenter) r3.d.getDataCenter().getValue();
        long r5 = ((Room) this.d.d.getRoom().getValue()).getRoomId();
        String r6 = ((Room) this.d.d.getRoom().getValue()).getOwnerUserIdString();
        if (r6 != null) goto L5;
        String r7 = "";
    L6:
        boolean r8 = this.a;
        IUserService r9 = jc1.k.f(IUserService.class);
        if (r9 == null) goto L14;
        com.bytedance.android.livesdk.user.f r11 = r9.user();
        if (r11 == null) goto L14;
        String r12 = r11.n();
        if (r12 == null) goto L14;
        String r14 = r12;
    L15:
        XplayScene r15 = XplayScene.TalkRoom;
        com.bytedance.android.live.broadcastgame.api.xplay.l r16 = this.b;
        com.bytedance.android.live.broadcastgame.api.xplay.s r17 = new com.bytedance.android.live.broadcastgame.api.xplay.s(false, false, null, 2047);
        r17.b = true;
        Unit r18 = Unit.INSTANCE;
        r2.j(new com.bytedance.android.live.broadcastgame.api.xplay.p(r4, r5, r7, r8, r14, r15, null, r16, r13, r17, null, true, this.c.element, 1088));
        return;
    L14:
        r14 = "";
        goto L15
    L5:
        r7 = r6;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
