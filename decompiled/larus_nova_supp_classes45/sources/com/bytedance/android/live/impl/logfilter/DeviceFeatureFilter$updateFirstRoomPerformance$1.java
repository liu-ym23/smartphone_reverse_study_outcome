package com.bytedance.android.live.impl.logfilter;

import com.bytedance.android.live.impl.service.FeatureManager;
import com.bytedance.android.live.impl.utils.TimeUtils;
import com.bytedance.android.live.impl.utils.json.JsonHelper;
import com.bytedance.android.live.impl.utils.json.JsonItemHelper;
import com.bytedance.android.live.impl.utils.json.JsonItemType;
import com.larus.apm.impl.protector.RunnableProtector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class DeviceFeatureFilter$updateFirstRoomPerformance$1 implements Runnable {
    public final /* synthetic */ boolean a;

    public DeviceFeatureFilter$updateFirstRoomPerformance$1(boolean r1) {
        this.a = r1;
    }

    public final void a() {
        ArrayList r0 = new ArrayList();
        DeviceFeatureFilter r1 = DeviceFeatureFilter.O;
        String r2 = DeviceFeatureFilter.e(r1).d("first_room_performance_data", r0.toString());
        if (r2 == null) goto L172;
        boolean r3 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.d("curTime", DeviceFeatureFilter$updateFirstRoomPerformance$1$1$1.INSTANCE);
        SimpleDateFormat r4 = TimeUtils.a;
        String r5 = TimeUtils.b(DeviceFeatureFilter.t);
        int r6 = JsonHelper.a;
        List r7 = JsonHelper.e(r2, JsonItemType.FIRST_ROOM_PERFORMANCE_DATA_ITEM);
        if ((r7 instanceof List) == true) goto L7;
        r7 = null;
    L7:
        JSONObject r8 = new JSONObject();
        if (r7 == null) goto L147;
        int r9 = 0;
        if (this.a == true) goto L12;
        Iterator r11 = r7.iterator();
    L102:
        if (r11.hasNext() == false) goto L132;
        JsonItemHelper.FirstRoomPerformanceDataItem r12 = (JsonItemHelper.FirstRoomPerformanceDataItem) r11.next();
        String r13 = r12.getDate();
        if (r13 == null) goto L106;
        long r14 = TimeUtils.c(r13);
    L107:
        SimpleDateFormat r15 = TimeUtils.a;
        float r16 = DeviceFeatureFilter.b;
        long r17 = TimeUtils.a(r14, DeviceFeatureFilter.t);
        FeatureManager.u.getClass();
        if (r17 >= FeatureManager.j) goto L102;
        r0.add(JsonHelper.f(r12));
        Iterator<String> r18 = DeviceFeatureFilter.I.iterator();
    L111:
        if (r18.hasNext() == false) goto L131;
        String r19 = r18.next();
        Object r110 = r8.opt(r19);
        if (r110 == null) goto L119;
        String r111 = r110.toString();
        if (r111 == null) goto L119;
        Float r112 = StringsKt.toFloatOrNull(r111);
        if (r112 == null) goto L119;
        float r113 = r112.floatValue();
    L120:
        JSONObject r114 = r12.getFirstRoomPerformanceData();
        if (r114 == null) goto L129;
        Object r115 = r114.opt(r19);
        if (r115 == null) goto L129;
        String r116 = r115.toString();
        if (r116 == null) goto L129;
        Float r117 = StringsKt.toFloatOrNull(r116);
        if (r117 == null) goto L129;
        float r118 = r117.floatValue();
    L130:
        r8.putOpt(r19, Float.valueOf(r113 + r118));
    L129:
        r118 = 0.0f;
    L119:
        r113 = 0.0f;
        goto L120
    L131:
        r9 = r9 + r12.getFrequency();
        goto L102
    L106:
        r14 = 0;
        goto L107
    L132:
        int r21 = r9;
    L133:
        if (r21 == 0) goto L173;
        Iterator<String> r22 = DeviceFeatureFilter.I.iterator();
    L136:
        if (r22.hasNext() == false) goto L146;
        String r23 = r22.next();
        FeatureManager r24 = FeatureManager.u;
        String r25 = "first_room_" + r23 + "_in_recent_7_days_avg";
        Object r26 = r8.opt(r23);
        if (r26 == null) goto L144;
        String r27 = r26.toString();
        if (r27 == null) goto L144;
        Float r28 = StringsKt.toFloatOrNull(r27);
        if (r28 == null) goto L144;
        Float r29 = Float.valueOf(r28.floatValue() / r21);
    L145:
        z90.a.C0301a.a(r24, r25, r29);
    L144:
        r29 = null;
        goto L145
    L146:
        DeviceFeatureFilter.e(DeviceFeatureFilter.O).e("first_room_performance_data", r0.toString());
        return;
    L173:
        return;
    L12:
        if (DeviceFeatureFilter.H != null) goto L14;
        return;
    L14:
        Iterator r31 = r7.iterator();
        boolean r32 = false;
        r21 = 0;
    L16:
        if (r31.hasNext() == false) goto L72;
        JsonItemHelper.FirstRoomPerformanceDataItem r119 = (JsonItemHelper.FirstRoomPerformanceDataItem) r31.next();
        if (Intrinsics.areEqual(r119.getDate(), r5) == false) goto L48;
        int r33 = r119.getFrequency();
        JSONObject r120 = DeviceFeatureFilter.H;
        if (r120 == null) goto L22;
        int r121 = r120.optInt("performance_report_count");
    L23:
        r119.setFrequency(r33 + r121);
        Iterator<String> r34 = DeviceFeatureFilter.I.iterator();
    L25:
        if (r34.hasNext() == false) goto L47;
        String r122 = r34.next();
        JSONObject r123 = r119.getFirstRoomPerformanceData();
        if (r123 == null) goto L25;
        Object r124 = r123.opt(r122);
        if (r124 == null) goto L35;
        String r125 = r124.toString();
        if (r125 == null) goto L35;
        Float r126 = StringsKt.toFloatOrNull(r125);
        if (r126 == null) goto L35;
        float r127 = r126.floatValue();
    L36:
        JSONObject r128 = DeviceFeatureFilter.H;
        if (r128 == null) goto L45;
        Object r129 = r128.opt(r122);
        if (r129 == null) goto L45;
        String r130 = r129.toString();
        if (r130 == null) goto L45;
        Float r131 = StringsKt.toFloatOrNull(r130);
        if (r131 == null) goto L45;
        float r132 = r131.floatValue();
    L46:
        r123.putOpt(r122, Float.valueOf(r127 + r132));
    L45:
        r132 = 0.0f;
    L35:
        r127 = 0.0f;
        goto L36
    L47:
        r0.add(JsonHelper.f(r119));
        r32 = true;
    L49:
        Iterator<String> r133 = DeviceFeatureFilter.I.iterator();
    L51:
        if (r133.hasNext() == false) goto L71;
        String r134 = r133.next();
        Object r135 = r8.opt(r134);
        if (r135 == null) goto L59;
        String r136 = r135.toString();
        if (r136 == null) goto L59;
        Float r137 = StringsKt.toFloatOrNull(r136);
        if (r137 == null) goto L59;
        float r138 = r137.floatValue();
    L60:
        JSONObject r139 = r119.getFirstRoomPerformanceData();
        if (r139 == null) goto L69;
        Object r140 = r139.opt(r134);
        if (r140 == null) goto L69;
        String r141 = r140.toString();
        if (r141 == null) goto L69;
        Float r142 = StringsKt.toFloatOrNull(r141);
        if (r142 == null) goto L69;
        float r143 = r142.floatValue();
    L70:
        r8.putOpt(r134, Float.valueOf(r138 + r143));
    L69:
        r143 = 0.0f;
    L59:
        r138 = 0.0f;
        goto L60
    L71:
        r21 = r21 + r119.getFrequency();
        goto L16
    L22:
        r121 = 0;
        goto L23
    L48:
        r0.add(JsonHelper.f(r119));
        goto L49
    L72:
        if (r32 == true) goto L99;
        JSONObject r35 = DeviceFeatureFilter.H;
        if (r35 == null) goto L76;
        r9 = r35.optInt("performance_report_count");
    L76:
        JsonItemHelper.FirstRoomPerformanceDataItem r36 = new JsonItemHelper.FirstRoomPerformanceDataItem(r5, r35, r9);
        r0.add(JsonHelper.f(r36));
        Iterator<String> r37 = DeviceFeatureFilter.I.iterator();
    L78:
        if (r37.hasNext() == false) goto L98;
        String r38 = r37.next();
        Object r39 = r8.opt(r38);
        if (r39 == null) goto L86;
        String r41 = r39.toString();
        if (r41 == null) goto L86;
        Float r42 = StringsKt.toFloatOrNull(r41);
        if (r42 == null) goto L86;
        float r43 = r42.floatValue();
    L87:
        JSONObject r144 = r36.getFirstRoomPerformanceData();
        if (r144 == null) goto L96;
        Object r145 = r144.opt(r38);
        if (r145 == null) goto L96;
        String r146 = r145.toString();
        if (r146 == null) goto L96;
        Float r147 = StringsKt.toFloatOrNull(r146);
        if (r147 == null) goto L96;
        float r148 = r147.floatValue();
    L97:
        r8.putOpt(r38, Float.valueOf(r43 + r148));
    L96:
        r148 = 0.0f;
    L86:
        r43 = 0.0f;
        goto L87
    L98:
        r21 = r21 + r36.getFrequency();
    L99:
        DeviceFeatureFilter.H = null;
        goto L133
    L147:
        com.bytedance.android.live.impl.utils.a.b(r1.a, DeviceFeatureFilter$updateFirstRoomPerformance$1$1$3$1.INSTANCE, null);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
