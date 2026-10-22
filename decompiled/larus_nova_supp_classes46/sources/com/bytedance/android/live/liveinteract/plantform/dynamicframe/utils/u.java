package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u {
    public static long a;
    public static final /* synthetic */ int b = 0;

    static {
    }

    public static void c(String r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r21, "lynxUrl");
        Intrinsics.checkNotNullParameter(r22, "cardType");
        Intrinsics.checkNotNullParameter(r23, "bizId");
        ALogger.i("MultiLinkDynamicWidget-Time", "start load card:" + r22 + "_biz:" + r23);
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("action_type", "card_create");
        r6.put("card_type", r22);
        r6.put("biz_id", r23);
        j0.l().sendLog("livesdk_multilink_dynamic_element", r6, new Object[]{IRoom.class, am2.x.class});
        int r7 = s.a;
        Intrinsics.checkNotNullParameter(r21, "lynxUrl");
        Intrinsics.checkNotNullParameter(r23, "bizId");
        Intrinsics.checkNotNullParameter(r22, "cardType");
        ALogger.i("MultiLinkDynamicFullLinkMonitor", "hybridCardLoadStart, bizId: " + r23 + ", cardType: " + r22 + ", lynxUrl: " + r21);
        if (s.a() == false) goto L7;
        JSONObject r3 = new JSONObject();
        r3.put("lynx_url", r21);
        r3.put("biz_id", r23);
        r3.put("card_type", r22);
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        ALogger.d("MultiLinkDynamicFullLinkMonitor", String.format("hybridCardLoadStart, extra: %s", Arrays.copyOf(new Object[]{r3}, 1)));
        int r1 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.MultiLinkDynamic, "multilink_dynamic_element_load_start", 0, null, r3, 88);
        return;
    }

    public static void d(String r24, String r25, String r26, long r27) {
        Intrinsics.checkNotNullParameter(r24, "lynxUrl");
        Intrinsics.checkNotNullParameter(r25, "cardType");
        Intrinsics.checkNotNullParameter(r26, "bizId");
        ALogger.i("MultiLinkDynamicWidget-Time", "success load card:" + r25 + "_biz:" + r26 + " useTime:" + r27);
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("action_type", "card_load_success");
        r8.put("card_type", r25);
        r8.put("biz_id", r26);
        r8.put("duration", String.valueOf(r27));
        r8.put("loaded_element", r25 + '_' + r26 + "_load_suc");
        StringBuilder r12 = new StringBuilder("dynamic load ");
        r12.append(r25);
        r12.append(" card suc: ");
        r12.append(System.currentTimeMillis() - a);
        ALogger.i("MultiLinkDynamicWidget-Time", r12.toString());
        j0.l().sendLog("livesdk_multilink_dynamic_element", r8, new Object[]{IRoom.class, am2.x.class});
        int r9 = s.a;
        Intrinsics.checkNotNullParameter(r24, "lynxUrl");
        Intrinsics.checkNotNullParameter(r26, "bizId");
        Intrinsics.checkNotNullParameter(r25, "cardType");
        ALogger.i("MultiLinkDynamicFullLinkMonitor", "hybridCardLoadSuccess, bizId: " + r26 + ", cardType: " + r25 + ", duration: " + r27 + ", lynxUrl: " + r24);
        if (s.a() == false) goto L7;
        JSONObject r5 = new JSONObject();
        r5.put("lynx_url", r24);
        r5.put("biz_id", r26);
        r5.put("card_type", r25);
        r5.put("duration", r27);
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        ALogger.d("MultiLinkDynamicFullLinkMonitor", String.format("hybridCardLoadSuccess, extra: %s", Arrays.copyOf(new Object[]{r5}, 1)));
        int r1 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.MultiLinkDynamic, "multilink_dynamic_element_load_success", 0, null, r5, 88);
        return;
    }

    public static void e(String r16, String r17, String r18, long r19) {
        Intrinsics.checkNotNullParameter(r16, "lynxUrl");
        Intrinsics.checkNotNullParameter(r17, "cardType");
        Intrinsics.checkNotNullParameter(r18, "bizId");
        ALogger.i("MultiLinkDynamicWidget-Time", "card:" + r17 + "_biz:" + r18 + " unload");
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("card_type", r17);
        r6.put("biz_id", r18);
        r6.put("duration", String.valueOf(r19));
        int r7 = s.a;
        Intrinsics.checkNotNullParameter(r16, "lynxUrl");
        Intrinsics.checkNotNullParameter(r18, "bizId");
        Intrinsics.checkNotNullParameter(r17, "cardType");
        ALogger.i("MultiLinkDynamicFullLinkMonitor", "hybridCardUnload, bizId: " + r18 + ", cardType: " + r17 + ", lynxUrl: " + r16);
        if (s.a() == false) goto L7;
        JSONObject r14 = new JSONObject();
        r14.put("lynx_url", r16);
        r14.put("biz_id", r18);
        r14.put("card_type", r17);
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        ALogger.d("MultiLinkDynamicFullLinkMonitor", String.format("hybridCardInnerError, extra: %s", Arrays.copyOf(new Object[]{r14}, 1)));
        int r1 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.MultiLinkDynamic, "multilink_dynamic_element_unload", 0, null, r14, 88);
        return;
    }

    public static void b(String r25, String r26, String r27, long r28, String r30) {
        Intrinsics.checkNotNullParameter(r25, "lynxUrl");
        Intrinsics.checkNotNullParameter(r26, "cardType");
        Intrinsics.checkNotNullParameter(r27, "bizId");
        ALogger.i("MultiLinkDynamicWidget-Time", "fail load card:" + r26 + "_biz:" + r27 + " useTime:" + r28);
        LinkedHashMap r9 = new LinkedHashMap();
        r9.put("action_type", "card_load_fail");
        r9.put("card_type", r26);
        r9.put("biz_id", r27);
        r9.put("duration", String.valueOf(r28));
        j0.l().sendLog("livesdk_multilink_dynamic_element", r9, new Object[]{IRoom.class, am2.x.class});
        int r10 = s.a;
        Intrinsics.checkNotNullParameter(r25, "lynxUrl");
        Intrinsics.checkNotNullParameter(r27, "bizId");
        Intrinsics.checkNotNullParameter(r26, "cardType");
        ALogger.i("MultiLinkDynamicFullLinkMonitor", "hybridCardLoadFail, bizId: " + r27 + ", cardType: " + r26 + ", duration: " + r28 + ", lynxUrl: " + r25 + ", reason: " + r30);
        if (s.a() == false) goto L7;
        JSONObject r6 = new JSONObject();
        r6.put("lynx_url", r25);
        r6.put("biz_id", r27);
        r6.put("card_type", r26);
        r6.put("duration", r28);
        r6.put("reason", r30);
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        ALogger.d("MultiLinkDynamicFullLinkMonitor", String.format("hybridCardLoadFail, extra: %s", Arrays.copyOf(new Object[]{r6}, 1)));
        int r1 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.MultiLinkDynamic, "multilink_dynamic_element_load_fail", 0, null, r6, 88);
        return;
    }

    public static void a(String r16, String r17, String r18, String r19, int r20, String r21, long r22) {
        Intrinsics.checkNotNullParameter(r16, "actionType");
        Intrinsics.checkNotNullParameter(r17, "lynxUrl");
        Intrinsics.checkNotNullParameter(r18, "cardType");
        Intrinsics.checkNotNullParameter(r19, "bizId");
        Intrinsics.checkNotNullParameter(r21, "errorMessage");
        ALogger.e("MultiLinkDynamicWidget-Time", "card:" + r18 + "_biz:" + r19 + " inner error errorCode:" + r20 + " errMsg:" + r21);
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("action_type", r16);
        r8.put("card_type", r18);
        r8.put("biz_id", r19);
        r8.put("duration", String.valueOf(r22));
        r8.put("error_code", String.valueOf(r20));
        j0.l().sendLog("livesdk_multilink_dynamic_element", r8, new Object[]{IRoom.class, am2.x.class});
        int r9 = s.a;
        Integer r10 = Integer.valueOf(r20);
        Intrinsics.checkNotNullParameter(r17, "lynxUrl");
        Intrinsics.checkNotNullParameter(r19, "bizId");
        Intrinsics.checkNotNullParameter(r18, "cardType");
        ALogger.i("MultiLinkDynamicFullLinkMonitor", "hybridCardInnerError, bizId: " + r19 + ", cardType: " + r18 + ", lynxUrl: " + r17 + ", errorCode: " + r10 + ", errorMessage: " + r21);
        if (s.a() == false) goto L7;
        JSONObject r5 = new JSONObject();
        r5.put("lynx_url", r17);
        r5.put("biz_id", r19);
        r5.put("card_type", r18);
        r5.put("error_code", r10);
        r5.put("error_message", r21);
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        ALogger.d("MultiLinkDynamicFullLinkMonitor", String.format("hybridCardInnerError, extra: %s", Arrays.copyOf(new Object[]{r5}, 1)));
        int r1 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.MultiLinkDynamic, "multilink_dynamic_element_inner_error", 0, null, r5, 88);
        return;
    }
}
