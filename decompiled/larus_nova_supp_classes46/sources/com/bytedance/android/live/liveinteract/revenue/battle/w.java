package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.i0;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.s1;
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
public final class w<T> implements Consumer {
    public final /* synthetic */ GuestBattleWidget a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ int f;
    public final /* synthetic */ int g;
    public final /* synthetic */ String h;
    public final /* synthetic */ long i;

    public w(GuestBattleWidget r1, int r2, int r3, String r4, boolean r5, int r6, int r7, String r8, long r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }

    public final void accept(Object r19) {
        Throwable r6 = (Throwable) r19;
        GuestBattleWidget r1 = this.a;
        r1.p = false;
        ExceptionUtils.handleException(((Widget) r1).context, r6, s1.B(2131917256));
        ii0.b r2 = ii0.b.a;
        String r3 = this.a.Eq().b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "e");
        Intrinsics.checkNotNullParameter(r3, "currentState");
        ALogger.e("[GuestBattle]GuestBattleWidget", "openBattle failed " + r6);
        JSONObject r4 = new JSONObject();
        ii0.b.m(r6, r4);
        r4.put("current_state", r3);
        r2.o("start_battle_failed", r4);
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("start_battle_failed", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("extra", r4.toString())}));
        ALogger.d("[GuestBattle]GuestBattleWidget", "#GuestBattleDebug# [tryStartGuestBattle] exception duration: " + this.b + ", loserNum: " + this.c);
        if (com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r6) != 4004252) goto L5;
        boolean r5 = ii0.a.b;
        ii0.a.b(this.d, this.b, this.e, this.f, this.g, "fail_peakhour", this.h);
    L7:
        if (((Boolean) i0.a.getValue()).booleanValue() == true) goto L10;
        MultiLinkEventModule r7 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a;
        long r8 = this.i;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.d.a();
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.b = false;
        JSONObject r11 = new JSONObject();
        nd0.c.r(nd0.c.a, LinkMonitorData.CreateGuestBattleRequest, com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a, System.currentTimeMillis() - r8, r6, r11, 32);
        StringCompanionObject r9 = StringCompanionObject.INSTANCE;
        ALogger.d("GuestBattleFullLinkMonitor", String.format("createGuestBattleApiFailed, extra: %s", Arrays.copyOf(new Object[]{r11}, 1)));
        return;
    L10:
        return;
    L5:
        boolean r10 = ii0.a.b;
        ii0.a.b(this.d, this.b, this.e, this.f, this.g, "fail_others", this.h);
        goto L7
    }
}
