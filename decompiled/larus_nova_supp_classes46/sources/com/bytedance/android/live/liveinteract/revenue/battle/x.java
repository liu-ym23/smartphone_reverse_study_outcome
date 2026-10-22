package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ GuestBattleWidget a;
    public final /* synthetic */ long b;

    public x(GuestBattleWidget r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r15) {
        com.bytedance.android.live.network.response.e r16 = (com.bytedance.android.live.network.response.e) r15;
        vh7.c r0 = null;
        if (r16 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.model.interact.b0 r1 = (com.bytedance.android.livesdk.chatroom.model.interact.b0) r16.data;
        if (r1 == null) goto L9;
        vh7.c r2 = r1.getBattleInfo();
        if (r2 == null) goto L9;
        vh7.c r3 = jm2.a.d(r2);
    L11:
        if ((r3 instanceof com.bytedance.android.livesdk.chatroom.model.interact.a0) == false) goto L14;
        r0 = r3;
    L14:
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r4 = (com.bytedance.android.livesdk.chatroom.model.interact.a0) r0;
        if (r4 == null) goto L27;
        r4.setSourceFrom("pause_msg");
        List r5 = r4.getRawResults();
        if (r5 == null) goto L21;
        List r6 = CollectionsKt.toMutableList(r5);
        if (r6 == null) goto L21;
    L22:
        r4.setResults(r6);
        ALogger.i("[GuestBattle]GuestBattleWidget", "pause guest battle success " + r4);
        GuestBattleWidget r7 = this.a;
        if (((Widget) r7).isViewValid == false) goto L25;
        r7.m.b(new GuestBattleStateMachine.a.f(r4));
    L25:
        ii0.b r8 = ii0.b.a;
        GuestBattleWidget r9 = this.a;
        int r10 = GuestBattleWidget.u;
        String r11 = r9.Eq().b;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r4, "battleInfo");
        Intrinsics.checkNotNullParameter(r11, "currentState");
        JSONObject r12 = new JSONObject();
        r12.put("battle_info", r4);
        r12.put("current_state", r11);
        r8.o("pause_battle_success", r12);
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("pause_battle_success", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("extra", r12.toString())}));
        MultiLinkEventModule r13 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a;
        long r14 = this.b;
        String r17 = r16.logId;
        Intrinsics.checkNotNullParameter(r4, "guestBattleInfo");
        Intrinsics.checkNotNullParameter(r17, "logId");
        JSONObject r18 = new JSONObject();
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.c(r4, r18);
        nd0.c.s(nd0.c.a, LinkMonitorData.PauseGuestBattleRequest, com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a, System.currentTimeMillis() - r14, r17, r18, 96);
        StringCompanionObject r19 = StringCompanionObject.INSTANCE;
        ALogger.d("GuestBattleFullLinkMonitor", String.format("pauseGuestBattleApiSuccess, extra: %s", Arrays.copyOf(new Object[]{r18}, 1)));
        return;
    L21:
        r6 = new ArrayList();
        goto L22
    L27:
        return;
    L9:
        r3 = null;
        goto L11
    }
}
