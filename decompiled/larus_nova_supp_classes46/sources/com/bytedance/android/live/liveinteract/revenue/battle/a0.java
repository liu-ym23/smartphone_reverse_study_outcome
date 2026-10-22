package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ GuestBattleWidget a;
    public final /* synthetic */ long b;

    public a0(GuestBattleWidget r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r12) {
        Throwable r5 = (Throwable) r12;
        ALogger.e("[GuestBattle]GuestBattleWidget", "GuestBattle.Request.Resume.Failed", r5);
        ExceptionUtils.handleException(((Widget) this.a).context, r5);
        ii0.b r13 = ii0.b.a;
        GuestBattleWidget r1 = this.a;
        int r2 = GuestBattleWidget.u;
        String r3 = r1.Eq().b;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r5, "e");
        Intrinsics.checkNotNullParameter(r3, "currentState");
        ALogger.e("[GuestBattle]GuestBattleWidget", "resume failed " + r5);
        JSONObject r0 = new JSONObject();
        ii0.b.m(r5, r0);
        r0.put("current_state", r3);
        r13.o("resume_battle_failed", r0);
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("resume_battle_failed", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("extra", r0.toString())}));
        MultiLinkEventModule r4 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a;
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r6 = this.a.Cq();
        long r7 = this.b;
        JSONObject r9 = new JSONObject();
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.c(r6, r9);
        nd0.c.r(nd0.c.a, LinkMonitorData.ResumeGuestBattleRequest, com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a, System.currentTimeMillis() - r7, r5, r9, 32);
        StringCompanionObject r8 = StringCompanionObject.INSTANCE;
        ALogger.d("GuestBattleFullLinkMonitor", String.format("resumeGuestBattleApiFailed, extra: %s", Arrays.copyOf(new Object[]{r9}, 1)));
    }
}
