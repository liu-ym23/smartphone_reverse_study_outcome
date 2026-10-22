package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.i0;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v<T> implements Consumer {
    public final /* synthetic */ GuestBattleWidget a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;
    public final /* synthetic */ String i;

    public v(GuestBattleWidget r1, long r2, int r4, int r5, String r6, boolean r7, int r8, int r9, String r10) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public final void accept(Object r15) {
        com.bytedance.android.live.network.response.e r16 = (com.bytedance.android.live.network.response.e) r15;
        this.a.p = false;
        vh7.c r0 = null;
        if (r16 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.model.interact.b0 r2 = (com.bytedance.android.livesdk.chatroom.model.interact.b0) r16.data;
        if (r2 == null) goto L9;
        vh7.c r3 = r2.getBattleInfo();
        if (r3 == null) goto L9;
        vh7.c r4 = jm2.a.d(r3);
    L11:
        if ((r4 instanceof com.bytedance.android.livesdk.chatroom.model.interact.a0) == false) goto L14;
        r0 = r4;
    L14:
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r1 = (com.bytedance.android.livesdk.chatroom.model.interact.a0) r0;
        if (r1 == null) goto L27;
        GuestBattleWidget.wq(this.a, "playmode_api_start", GsonProtectorUtils.toJsonTree(new Gson(), (com.bytedance.android.livesdk.chatroom.model.interact.b0) r16.data).getAsJsonObject());
        if (((Boolean) i0.a.getValue()).booleanValue() == true) goto L20;
        MultiLinkEventModule r5 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a;
        long r6 = this.b;
        String r11 = r16.logId;
        Intrinsics.checkNotNullParameter(r1, "guestBattleInfo");
        Intrinsics.checkNotNullParameter(r11, "logId");
        JSONObject r17 = new JSONObject();
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.c(r1, r17);
        nd0.c.s(nd0.c.a, LinkMonitorData.CreateGuestBattleRequest, com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a, System.currentTimeMillis() - r6, r11, r17, 96);
        ALogger.d("GuestBattleFullLinkMonitor", "createGuestBattleApiSuccess");
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.e r7 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.d;
        r7.c = System.currentTimeMillis() - r7.a;
        r7.m.onNext(Unit.INSTANCE);
        StringCompanionObject r8 = StringCompanionObject.INSTANCE;
        ALogger.d("GuestBattleFullLinkMonitor", String.format("createGuestBattleApiSuccess, extra: %s", Arrays.copyOf(new Object[]{r17}, 1)));
    L20:
        List r18 = r1.getRawResults();
        if (r18 == null) goto L24;
        List r19 = CollectionsKt.toMutableList(r18);
        if (r19 == null) goto L24;
    L25:
        r1.setResults(r19);
        r1.setSourceFrom("create_api");
        this.a.m.b(new GuestBattleStateMachine.a.k(r1));
        ii0.b r110 = ii0.b.a;
        String r9 = this.a.Eq().b;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r1, "battleInfo");
        Intrinsics.checkNotNullParameter(r9, "currentState");
        JSONObject r10 = new JSONObject();
        r10.put("battle_info", r1);
        r10.put("current_state", r9);
        r110.o("start_battle_success", r10);
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("start_battle_success", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("extra", r10.toString())}));
        ALogger.d("[GuestBattle]GuestBattleWidget", "#GuestBattleDebug# [tryStartGuestBattle] response duration: " + this.c + ", loserNum: " + this.d + ". battleInfo: " + r1);
        boolean r111 = ii0.a.b;
        ii0.a.b(this.e, this.c, this.f, this.g, this.h, "success", this.i);
        return;
    L24:
        r19 = new ArrayList();
        goto L25
    L27:
        return;
    L9:
        r4 = null;
        goto L11
    }
}
