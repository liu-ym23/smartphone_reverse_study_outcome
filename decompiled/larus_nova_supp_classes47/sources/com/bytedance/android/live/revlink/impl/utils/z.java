package com.bytedance.android.live.revlink.impl.utils;

import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z {
    public static final /* synthetic */ int a = 0;

    public static int c() {
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 == null) goto L5;
        int r1 = r0.getCurrentMode();
    L7:
        if (gd0.v.a(r1, 4) == false) goto L11;
        return 1;
    L11:
        if (gd0.v.a(r1, 64) == false) goto L14;
        return 7;
    L14:
        return 0;
    L5:
        r1 = 0;
        goto L7
    }

    static {
    }

    public static void a(Map r3) {
        IPerformanceManager r0 = jc1.k.f(IPerformanceManager.class);
        if (r0 == null) goto L6;
        r3.put("ui_stall_time", String.valueOf(r0.getUIStallDuration()));
        r3.put("ui_stall_rate", String.valueOf(r0.getUIStallRate()));
        r3.put("fps", String.valueOf(r0.getFps()));
        r3.put("temperature", String.valueOf(r0.getTemperature()));
        r3.put("cpu", String.valueOf(r0.getCpuSpeed()));
        r3.put("cpu_rate", String.valueOf(r0.getCpuRate()));
        return;
    }

    public static void b(Map r5) {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r0 == null) goto L38;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L39;
        r5.put("room_id", String.valueOf(((IRoom) r1.getRoom().getValue()).getId()));
        r5.put("anchor_id", String.valueOf(iz.a.a(((IRoom) r1.getRoom().getValue()).getOwner())));
        LiveMode r2 = ((IRoom) r1.getRoom().getValue()).getStreamType();
        int r3 = h1.a;
        r5.put("live_type", i1.a(r2));
        d31.d r4 = com.bytedance.android.live.revlink.impl.global.b.c0();
        String r6 = "";
        if (r4 == null) goto L9;
        String r7 = r4.c();
    L10:
        r5.put("connection_type", r7);
        d31.d r8 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r8 == null) goto L16;
        String r9 = r8.a();
        if (r9 == null) goto L16;
        r6 = r9;
    L16:
        r5.put("anchor_connect_status", r6);
        LinkCrossRoomDataHolder r10 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r10 == null) goto L19;
        Long r12 = Long.valueOf(r10.c());
    L20:
        r5.put("channel_id", String.valueOf(r12));
        com.bytedance.live.datacontext.i r13 = r1.isAnchor();
        String r14 = DataType.TRUE;
        if (r13 != null) goto L23;
    L25:
        Object r15 = DataType.FALSE;
    L26:
        r5.put("is_anchor", r15);
        com.bytedance.android.live.revlink.impl.service.internal.a r16 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r16 == null) goto L29;
        int r17 = r16.getCurrentMode();
    L30:
        r5.put("current_scene", String.valueOf(r17));
        p11.d r18 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo469getPerfManager();
        if (r18 != null) goto L33;
    L35:
        r14 = DataType.FALSE;
    L36:
        r5.put("is_degrade", r14);
        return;
    L33:
        if (r18.a() != true) goto L35;
    L29:
        r17 = 0;
        goto L30
    L23:
        if (((Boolean) r13.getValue()).booleanValue() != true) goto L25;
        r15 = DataType.TRUE;
        goto L26
    L19:
        r12 = null;
        goto L20
    L9:
        r7 = "";
        goto L10
    L39:
        return;
    }

    public static void d(String r3, Map r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        mz0.n r0 = new mz0.n();
        Map<String, String> r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r1.putAll(r4);
        mz0.m r5 = new mz0.m();
        r5.b(LogCommon.PAGE_SOURCE_LOG);
        r5.b(LogCommon.ROOM);
        List<Object> r2 = r0.b;
        ArrayList r6 = (ArrayList) r2;
        r6.addAll(r5.a);
        cy0.e.a.getClass();
        cy0.j r7 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r8);
        ((mz0.i) ((f80.a) r8)).w3(r3, r0.a, r0.b);
    }

    public static void e(int r3, com.bytedance.android.live.revlink.impl.perf.b r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        if (com.bytedance.android.live.revlink.impl.settings.live.b.p.b().getEnable() == true) goto L5;
        return;
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        if (r4 == null) goto L10;
        Pair<Double, Long> r7 = r4.a(r3);
        if (r7 == null) goto L10;
        Double r8 = (Double) r7.getFirst();
    L11:
        r1.put("stream_fps_avg", String.valueOf(r8));
        r1.put("monitor_scene", String.valueOf(r3));
        r1.put("degrade_reason", String.valueOf(r5));
        b(r1);
        a(r1);
        r1.put("source", r6);
        c();
        d("livesdk_rd_con_perf_monitor_degrade_trigger", r1);
        return;
    L10:
        r8 = null;
        goto L11
    }
}
