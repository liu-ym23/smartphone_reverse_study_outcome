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
public final class m implements ne0.a {
    public final /* synthetic */ j a;

    public m(j r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r7, Object r8) {
        Intrinsics.checkNotNullParameter(r7, "store");
        ALogger.w(LinkMicTeamFightInfo.TAG, "ResumeGuestBattleMethod " + r8);
        GuestBattleWidget r9 = this.a.a;
        GuestBattleStateMachine.c r10 = r9.m.a();
        r10.getClass();
        if ((r10 instanceof GuestBattleStateMachine.c.d) == true) goto L5;
        ALogger.e("[GuestBattle]GuestBattleWidget", "battle already resumed " + r9.Cq());
        return;
    L5:
        ALogger.i("[GuestBattle]GuestBattleWidget", "GuestBattle.Request.Resume.Send");
        long r0 = System.currentTimeMillis();
        ((SingleSubscribeProxy) ((LinkGuestBattleApi) com.bytedance.android.live.network.c.b().e(LinkGuestBattleApi.class)).resumeBattle(r9.getRoom().getId(), (int) r9.j).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(ContextUtil.contextToFragmentActivity(((Widget) r9).context)))).subscribe(new z(r9, r0), new a0(r9, r0));
    }
}
