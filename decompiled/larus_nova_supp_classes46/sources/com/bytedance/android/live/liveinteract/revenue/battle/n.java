package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.liveinteract.multiscene.LinkMicTeamFightInfo;
import com.bytedance.android.live.liveinteract.plantform.api.LinkGuestBattleApi;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements ne0.a {
    public final /* synthetic */ j a;

    public n(j r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r5, Object r6) {
        Intrinsics.checkNotNullParameter(r5, "store");
        ALogger.w(LinkMicTeamFightInfo.TAG, "PauseGuestBattleMethod " + r6);
        GuestBattleWidget r7 = this.a.a;
        GuestBattleStateMachine.c r8 = r7.m.a();
        r8.getClass();
        if ((r8 instanceof GuestBattleStateMachine.c.d) == false) goto L5;
        ALogger.e("[GuestBattle]GuestBattleWidget", "battle already paused " + r7.Cq());
        return;
    L5:
        ALogger.i("[GuestBattle]GuestBattleWidget", "GuestBattle.Request.Pause.Send");
        long r0 = System.currentTimeMillis();
        ((SingleSubscribeProxy) ((LinkGuestBattleApi) com.bytedance.android.live.network.c.b().e(LinkGuestBattleApi.class)).pauseBattle(r7.getRoom().getId()).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(ContextUtil.contextToFragmentActivity(((Widget) r7).context)))).subscribe(new x(r7, r0), new y(r7, r0));
    }
}
