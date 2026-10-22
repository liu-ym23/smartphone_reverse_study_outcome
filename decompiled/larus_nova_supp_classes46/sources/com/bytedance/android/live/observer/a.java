package com.bytedance.android.live.observer;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.experience.log.ExpOptLog;
import com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeManager;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import com.bytedance.android.live.room.api.playopt.topspeed.log.TopSpeedTrace;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import is2.g;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ls2.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements g {
    public final DataCenter a;

    public final String businessTypeV2() {
        return "";
    }

    public final Map<String, Object> getEnvData() {
        return null;
    }

    public final Map<String, Object> getPropertyParams() {
        return null;
    }

    public final String getSpm() {
        return null;
    }

    public final boolean isIgnored() {
        return false;
    }

    public final void onOrientationChangeV2(int r1) {
    }

    public final void onRoomBackgroundV2() {
    }

    public final void onRoomPrepareV2(boolean r1) {
    }

    public a(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.a = r2;
    }

    public final void onRoomEnterV2(Room r2, ls2.a r3) {
        Intrinsics.checkNotNullParameter(r2, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r3, "enterExtra");
        g.a.a(r2, r3);
    }

    public final void onRoomPreloadV2(Room r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r1, PbRequest.SwitchType.ROOM);
    }

    public final void onRoomExitV2(long r3, String r5, boolean r6, Room r7, e r8, boolean r9, EndReason r10) {
        Intrinsics.checkNotNullParameter(r5, "userId");
        Intrinsics.checkNotNullParameter(r8, "error");
        Intrinsics.checkNotNullParameter(r10, "reason");
        if (r9 == true) goto L5;
        return;
    L5:
        Set r4 = null;
        if (PlatformExpUtils.b() == false) goto L17;
        ILiveExpMiddlewareService r11 = k.f(ILiveExpMiddlewareService.class);
        if (r11 == null) goto L10;
        r11.checkResetPerfWhenRoomExit();
    L10:
        ExpOptLog r12 = ExpOptLog.c;
        r12.getClass();
        if ((!ExpOptLog.b.isEmpty()) == true) goto L14;
        r12 = null;
    L14:
        if (r12 == null) goto L17;
        ExpOptLog.b(this.a);
    L17:
        if (TopSpeedModeUtils.a() == false) goto L43;
        TopSpeedModeManager r13 = TopSpeedModeManager.l;
        r13.getClass();
        ALogger.w("LiveTopSpeedLog", "onRoomExitV2::: degradeListener size " + r13.i.size() + " clear");
        r13.i.clear();
        TopSpeedTrace r14 = TopSpeedTrace.b;
        r14.getClass();
        if ((!r13.c.isEmpty()) == true) goto L22;
        r14 = null;
    L22:
        if (r14 == null) goto L43;
        DataCenter r15 = this.a;
        if (TopSpeedModeUtils.b() == false) goto L43;
        if (r15 == null) goto L29;
        IRoom r16 = a0.n(r15);
        if (r16 == null) goto L29;
    L30:
        Set r17 = r13.c;
        if ((!r17.isEmpty()) == false) goto L33;
        r4 = r17;
    L33:
        if (r4 == null) goto L43;
        TopSpeedTrace.b().append("------当前性能状态------\n");
        TopSpeedTrace.b().append("性能等级: " + ((Number) r13.e.a).intValue() + "   风险等级: " + ((Number) r13.f.a).intValue() + " \n");
        StringBuffer r18 = TopSpeedTrace.b();
        StringBuilder r19 = new StringBuilder("------以下");
        r19.append(r17.size());
        r19.append("个业务场景降级了------\n");
        r18.append(r19.toString());
        Iterator r20 = r4.iterator();
    L36:
        if (r20.hasNext() == false) goto L38;
        String r21 = (String) r20.next();
        TopSpeedTrace.b.getClass();
        TopSpeedTrace.b().append(r21 + "\n");
        goto L36
    L38:
        Unit r22 = Unit.INSTANCE;
        TopSpeedTrace.b.getClass();
        TopSpeedTrace.b().append("------ end ------");
        String r23 = TopSpeedTrace.b().toString();
        if (TopSpeedModeUtils.b() == false) goto L42;
        int r24 = com.bytedance.android.live.core.monitor.trace.e.m;
        com.bytedance.android.live.core.monitor.trace.e.a r25 = com.bytedance.android.live.core.monitor.trace.e.b.a("top_speed_mode", "live_exp_opt");
        r25.c = "webcast_client_community";
        r25.h = 0;
        r25.i = "";
        r25.e = r16.getIdStr();
        r25.g = k.n(IMiddlewareUserService.class).user().n();
        r25.f = r16.getAnchorId();
        com.bytedance.android.live.core.monitor.trace.e r26 = r25.a();
        JSONObject r27 = new JSONObject();
        r27.put("top_speed_perf_log", r23);
        TraceMonitor.h(r26, r27);
        SimpleAlogArgsBuilder r28 = new SimpleAlogArgsBuilder();
        r28.c(r23);
        TopSpeedTrace.c(r28.b());
    L42:
        TopSpeedTrace.b().setLength(0);
    L29:
        r16 = a0.a;
    L43:
        g.a.b(r5, r8, r10);
    }
}
