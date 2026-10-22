package com.bytedance.android.live.room.api.playopt.topspeed.log;

import am2.x;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerfBalanceService;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "actionType");
        Intrinsics.checkNotNullParameter("inner_push", "pageFrom");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("event_type", r4);
        r0.put("page_from", "inner_push");
        j0.l().sendLog("livesdk_experienceopt_topspeed_mode_guide", r0, new Object[]{x.class, Room.class});
    }

    public static void b(String r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        LinkedHashMap r0 = new LinkedHashMap();
        IPerfBalanceService r1 = k.f(IPerfBalanceService.class);
        float r2 = -1.0f;
        if (r1 == null) goto L5;
        float r3 = r1.getHeartEffect();
    L6:
        if (r1 == null) goto L8;
        float r4 = r1.getTimeEffect();
    L9:
        float r5 = 100;
        float r8 = r4 * r5;
        if (r1 == null) goto L12;
        r2 = r1.getSpeedEffect();
    L12:
        r0.put("temperature", String.valueOf(r3));
        r0.put("power_consumption", String.valueOf(r8));
        r0.put("ui_stall", String.valueOf(r2 * r5));
        r0.put("strategy_level", String.valueOf(r7));
        r0.put("capability_status", TopSpeedModeUtils.c());
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.c.a).booleanValue() == false) goto L15;
        String r9 = "on";
    L16:
        r0.put("topspeed_mode_on_off", r9);
        r0.put("topspeed_trigger_scene", r6);
        boolean r10 = ((Boolean) com.bytedance.android.live.room.api.playopt.base.a.e.a).booleanValue();
        String r12 = DataType.TRUE;
        if (r10 == false) goto L19;
        Object r13 = DataType.TRUE;
    L20:
        r0.put("is_sub_topspeed_quality_on", r13);
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.g.a).booleanValue() == true) goto L24;
        r12 = DataType.FALSE;
    L24:
        r0.put("is_sub_topspeed_all_function_on", r12);
        j0.l().sendLog("livesdk_experienceopt_topspeed_mode_use", r0, new Object[]{x.class, Room.class});
        return;
    L19:
        r13 = DataType.FALSE;
        goto L20
    L15:
        r9 = "off";
        goto L16
    L8:
        r4 = -1.0f;
        goto L9
    L5:
        r3 = -1.0f;
        goto L6
    }

    public static void c(String r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "clickArea");
        Intrinsics.checkNotNullParameter(r5, "clickType");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("capability_status", TopSpeedModeUtils.c());
        r0.put("click_area", r3);
        if (r4 == false) goto L5;
        String r6 = "on";
    L6:
        r0.put("after_status", r6);
        r0.put("click_type", r5);
        j0.l().sendLog("livesdk_experienceopt_page_click", r0, new Object[]{x.class, Room.class});
        return;
    L5:
        r6 = "off";
        goto L6
    }
}
