package com.bytedance.android.live.liveinteract.api.fulllink.revenue;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.livesdk.chatroom.model.interact.a0;
import io.reactivex.Observable;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final MultiLinkEventModule a = null;
    public static boolean b;
    public static long c;
    public static final e d = null;

    static {
        a = MultiLinkEventModule.GUEST_BATTLE;
        d = new e();
    }

    public static boolean d() {
        if (b == true) goto L5;
    L7:
        return false;
    L5:
        if ((System.currentTimeMillis() - c) >= 10000) goto L7;
        return true;
    }

    public static void f() {
        ALogger.d("GuestBattleFullLinkMonitor", "clickBtn");
        b = true;
        c = System.currentTimeMillis();
        e r2 = d;
        r2.a();
        GuestBattleFullLinkMonitor$clickBtn$1 r3 = GuestBattleFullLinkMonitor$clickBtn$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r3, "task");
        r2.u.clear();
        RxUtilKt.c(Observable.combineLatest(r2.m, r2.n, r2.o, r2.t, b.a).subscribe(new c(r2, r3), d.a), r2.u);
        r2.a = System.currentTimeMillis();
        r2.k.onNext(Unit.INSTANCE);
        JSONObject r4 = new JSONObject();
        nd0.c.p(nd0.c.a, LinkMonitorData.StartCreateGuestBattle, r4, a, 0, null, false, null, 120);
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        ALogger.d("GuestBattleFullLinkMonitor", String.format("startCreateGuestBattle, extra: %s", Arrays.copyOf(new Object[]{r4}, 1)));
    }

    public static void a(a0 r14) {
        Intrinsics.checkNotNullParameter(r14, "guestBattleInfo");
        if (d() == true) goto L6;
        return;
    L6:
        if ((System.currentTimeMillis() - c) <= 10000) goto L8;
        return;
    L8:
        JSONObject r0 = new JSONObject();
        c(r14, r0);
        if (((Boolean) i0.a.getValue()).booleanValue() == true) goto L12;
        nd0.c.p(nd0.c.a, LinkMonitorData.CreateGuestBattleSuccess, r0, a, 0, null, false, null, 120);
    L12:
        if (d() == false) goto L14;
        ALogger.d("GuestBattleFullLinkMonitor", "startGameStateMachineTransition");
        e r15 = d;
        r15.e = System.currentTimeMillis() - r15.a;
        r15.o.onNext(Unit.INSTANCE);
    L14:
        StringCompanionObject r16 = StringCompanionObject.INSTANCE;
        ALogger.d("GuestBattleFullLinkMonitor", String.format("createGuestBattleSuccess, extra: %s", Arrays.copyOf(new Object[]{r0}, 1)));
    }

    public static void e(String r11) {
        d.a();
        b = false;
        JSONObject r10 = new JSONObject();
        r10.put("failure_reason", r11);
        nd0.c.p(nd0.c.a, LinkMonitorData.CreateGuestBattlePreCheck, r10, a, 0, null, false, null, 120);
        StringCompanionObject r12 = StringCompanionObject.INSTANCE;
        ALogger.d("GuestBattleFullLinkMonitor", String.format("preCheckCreateGuestBattle, extra: %s", Arrays.copyOf(new Object[]{r10}, 1)));
    }

    public static void c(a0 r3, JSONObject r4) {
        if (r3 == null) goto L5;
        r4.put("battle_id", r3.getBattleId());
        r4.put("battle_status", r3.getBattleStatus());
        r4.put("update_time", r3.getCurrentTime());
        return;
    }

    public static void b(String r12, String r13, int r14, String r15) {
        Intrinsics.checkNotNullParameter(r12, "effectId");
        Intrinsics.checkNotNullParameter(r13, "effectName");
        Intrinsics.checkNotNullParameter(r15, "statusMsg");
        JSONObject r5 = new JSONObject();
        r5.put("effectId", r12);
        r5.put("effectName", r13);
        r5.put("status_code", r14);
        r5.put("status_msg", r15);
        nd0.c.p(nd0.c.a, LinkMonitorData.GuestBattleStickerLoadFinish, r5, a, 0, null, false, null, 120);
        ALogger.d("GuestBattleFullLinkMonitor", "finishLoadGuestBattleSticker, effectId: " + r12 + ", effectName: " + r13 + ", statusCode: " + r14 + ", statusMsg: " + r15);
    }
}
