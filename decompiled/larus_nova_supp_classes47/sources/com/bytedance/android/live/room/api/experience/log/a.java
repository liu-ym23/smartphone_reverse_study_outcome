package com.bytedance.android.live.room.api.experience.log;

import am2.x;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizLevel;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeManager;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import l61.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Map r4) {
        o r0 = j0.l().c(x.class);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getMap() != null) goto L8;
        return;
    L8:
        String r3 = "";
        if (r0.getMap().containsKey("enter_from_merge") == false) goto L15;
        String r1 = (String) r0.getMap().get("enter_from_merge");
        if (r1 != null) goto L13;
        r1 = "";
    L13:
        r4.put("enter_from_merge", r1);
    L15:
        if (r0.getMap().containsKey("enter_method") == false) goto L21;
        String r2 = (String) r0.getMap().get("enter_method");
        if (r2 != null) goto L19;
        r2 = "";
    L19:
        r4.put("enter_method", r2);
    L21:
        if (r0.getMap().containsKey("action_type") == false) goto L28;
        String r5 = (String) r0.getMap().get("action_type");
        if (r5 == null) goto L26;
        r3 = r5;
    L26:
        r4.put("action_type", r3);
        return;
    }

    public static void b(Map r15) {
        Intrinsics.checkNotNullParameter(r15, "logMap");
        Lazy r1 = PlatformExpUtils.a;
        boolean r2 = TopSpeedModeUtils.a();
        String r8 = DataType.TRUE;
        if (r2 == false) goto L42;
        int r3 = com.bytedance.android.live.room.api.playopt.topspeed.log.a.a;
        Intrinsics.checkNotNullParameter(r15, "logMap");
        TopSpeedModeManager r0 = TopSpeedModeManager.l;
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.c.a).booleanValue() == true) goto L8;
        r8 = DataType.FALSE;
    L8:
        r15.put("top_speed", r8);
        Set<String> r4 = r0.c;
        r15.put("degrade_scene_count", String.valueOf(r4.size()));
        StringBuilder r7 = new StringBuilder();
        if (r4.size() <= 0) goto L15;
        Iterator<T> r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        r7.append(((String) r5.next()) + " 、");
        goto L12
    L14:
        r15.put("degrade_scene", r7.toString());
    L15:
        r15.put("exp_degrade_level", String.valueOf(((Number) r0.e.a).intValue()));
        r15.put("exp_degrade_risk_level", String.valueOf(((Number) r0.f.a).intValue()));
        o r6 = j0.l().c(x.class);
        if (r6 != null) goto L19;
    L40:
        j0.l().sendLog("livesdk_top_speed_monitor", r15, new Object[]{Room.class, x.class});
        return;
    L19:
        if (r6.getMap() == null) goto L40;
        String r9 = "";
        if (r6.getMap().containsKey("enter_from_merge") == false) goto L28;
        String r10 = (String) r6.getMap().get("enter_from_merge");
        if (r10 != null) goto L26;
        r10 = "";
    L26:
        r15.put("enter_from_merge", r10);
    L28:
        if (r6.getMap().containsKey("enter_method") == false) goto L34;
        String r12 = (String) r6.getMap().get("enter_method");
        if (r12 != null) goto L32;
        r12 = "";
    L32:
        r15.put("enter_method", r12);
    L34:
        if (r6.getMap().containsKey("action_type") == false) goto L40;
        String r13 = (String) r6.getMap().get("action_type");
        if (r13 == null) goto L39;
        r9 = r13;
    L39:
        r15.put("action_type", r9);
        goto L40
    L42:
        if (((Boolean) o61.a.f.a).booleanValue() == false) goto L44;
        Object r14 = DataType.TRUE;
    L45:
        r15.put("normal_fluency", r14);
        if (((Boolean) o61.a.h.a).booleanValue() == false) goto L48;
        Object r16 = DataType.TRUE;
    L49:
        r15.put("best_fluency", r16);
        if (o61.a.d == false) goto L52;
        Object r17 = DataType.TRUE;
    L53:
        r15.put("play_opt", r17);
        if (PlatformExpUtils.b() == true) goto L57;
        r8 = DataType.FALSE;
    L57:
        r15.put("low_phone_degrade", r8);
        Set<b> r18 = o61.a.i;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<T> r20 = r18.iterator();
    L59:
        if (r20.hasNext() == false) goto L61;
        r19.add(((b) r20.next()).getKey());
        goto L59
    L61:
        r15.put("degrade_scene_count", String.valueOf(CollectionsKt.toMutableSet(r19).size()));
        n61.a r22 = o61.a.c;
        if (r22 == null) goto L66;
        Integer r23 = r22.a;
        if (r23 == null) goto L66;
        r15.put("exp_degrade_level", String.valueOf(r23.intValue()));
    L66:
        k61.a r24 = o61.a.b;
        if (r24 == null) goto L71;
        LivePerfBizLevel r25 = r24.d;
        if (r25 == null) goto L71;
        r15.put("real_degrade_level", String.valueOf(r25.getLevel()));
    L71:
        Set<b> r26 = o61.a.i;
        ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
        Iterator<T> r28 = r26.iterator();
    L73:
        if (r28.hasNext() == false) goto L75;
        r27.add(((b) r28.next()).getKey());
        goto L73
    L75:
        r15.put("degrade_scene", CollectionsKt.joinToString$default(CollectionsKt.toMutableSet(r27), "、", null, null, 0, null, null, 62, null));
        a(r15);
        j0.l().sendLog("livesdk_live_degrade_biz_monitor", r15, new Object[]{Room.class, x.class});
        return;
    L52:
        r17 = DataType.FALSE;
        goto L53
    L48:
        r16 = DataType.FALSE;
        goto L49
    L44:
        r14 = DataType.FALSE;
        goto L45
    }

    public static void c(String r3, Map r4) {
        Intrinsics.checkNotNullParameter(r3, "actType");
        Intrinsics.checkNotNullParameter(r4, "logExtra");
        Lazy r0 = PlatformExpUtils.a;
        HashMap r1 = new HashMap();
        r1.putAll(r4);
        r1.put("push_action_type", r3);
        if (PlatformExpUtils.b() == false) goto L5;
        String r5 = DataType.TRUE;
    L6:
        r1.put("low_phone_degrade", r5);
        a(r1);
        j0.l().sendLog("livesdk_live_degrade_push_monitor", r1, new Object[]{Room.class, x.class});
        return;
    L5:
        r5 = DataType.FALSE;
        goto L6
    }
}
