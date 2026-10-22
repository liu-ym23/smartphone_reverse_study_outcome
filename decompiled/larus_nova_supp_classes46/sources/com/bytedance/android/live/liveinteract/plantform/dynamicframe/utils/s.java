package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s {
    public static final /* synthetic */ int a = 0;

    public static boolean a() {
        if (je0.d.D() == false) goto L5;
        return true;
    L5:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isAudienceLinkEngineOn() == false) goto L7;
        return true;
    L7:
        if (vm2.d.d0().e() == true) goto L13;
        return false;
    L13:
        return true;
    }

    static {
    }

    public static void b(String r11) {
        Intrinsics.checkNotNullParameter(r11, "bizId");
        Intrinsics.checkNotNullParameter("jsb", "source");
        ALogger.i("MultiLinkDynamicFullLinkMonitor", "loadSubWidget, bizId: " + r11 + ", source: jsb");
        if (a() == true) goto L5;
        return;
    L5:
        JSONObject r9 = new JSONObject();
        r9.put("biz_id", r11);
        r9.put("source", "jsb");
        StringCompanionObject r12 = StringCompanionObject.INSTANCE;
        ALogger.d("MultiLinkDynamicFullLinkMonitor", String.format("loadSubWidget, extra: %s", Arrays.copyOf(new Object[]{r9}, 1)));
        int r13 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.MultiLinkDynamic, "multilink_dynamic_native_sub_widget_load", 0, null, r9, 88);
    }

    public static void c(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "bizId");
        Intrinsics.checkNotNullParameter(r11, "source");
        ALogger.i("MultiLinkDynamicFullLinkMonitor", "unloadSubWidget, bizId: " + r10 + ", source: " + r11);
        if (a() == true) goto L5;
        return;
    L5:
        JSONObject r8 = new JSONObject();
        r8.put("biz_id", r10);
        r8.put("source", r11);
        StringCompanionObject r12 = StringCompanionObject.INSTANCE;
        ALogger.d("MultiLinkDynamicFullLinkMonitor", String.format("unloadSubWidget, extra: %s", Arrays.copyOf(new Object[]{r8}, 1)));
        int r13 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.MultiLinkDynamic, "multilink_dynamic_native_sub_widget_unload", 0, null, r8, 88);
    }
}
