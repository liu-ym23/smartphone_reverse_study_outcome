package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.multiscene.LinkMicTeamFightInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements ne0.a {
    public final /* synthetic */ j a;

    public l(j r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "store");
        ALogger.w(LinkMicTeamFightInfo.TAG, "FinishGuestBattleMethod " + r3);
        this.a.a.Bq(2);
    }
}
