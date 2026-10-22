package com.bytedance.android.monitorV2.lynx;

import com.bytedance.android.monitorV2.event.HybridEvent$TerminateType;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements pn.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3640a;

    public e() {
        this.f3640a = CollectionsKt.listOf(new String[]{"jsb_module_name", "jsb_method_name", "jsb_name", "jsb_protocol_version", "jsb_bridgesdk", "jsb_status_code"});
    }

    public static void a(String r5, String r10, LinkedHashMap r11) {
        Intrinsics.checkNotNullParameter(r10, "eventType");
        com.bytedance.android.monitorV2.event.a r12 = new com.bytedance.android.monitorV2.event.a(r10);
        r12.e();
        if (r5 != null) goto L6;
        r12.b(HybridEvent$TerminateType.f3541b);
        return;
    L6:
        r12.f3550m = new a("jsbPv", new JSONObject(r11));
        boolean r13 = Switches.f3591j.f3600a;
        r12.d(!r13, HybridEvent$TerminateType.f3540a);
        if (r13 == false) goto L20;
        com.bytedance.android.monitorV2.lynx.impl.d r14 = (com.bytedance.android.monitorV2.lynx.impl.d) com.bytedance.android.monitorV2.lynx.impl.d.f3687o.get(r5);
        if (r14 == null) goto L18;
        Intrinsics.checkNotNullParameter(r12, "event");
        if (r14.H() == false) goto L21;
        com.bytedance.android.monitorV2.lynx.impl.e r15 = r14.e;
        if (r15 == null) goto L19;
        r15.G(r12);
        return;
    L19:
        return;
    L21:
        return;
    L18:
        return;
    }

    @Override // pn.a
    public final void onReportEvent(String r5, int r10, Map r11, Map r12) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r11, "props");
        if (Intrinsics.areEqual(r5, "lynxsdk_jsb_timing") == true) goto L5;
        return;
    L5:
        LinkedHashMap r13 = new LinkedHashMap();
        r13.putAll(r11);
        if (r12 == null) goto L8;
        r13.putAll(r12);
    L8:
        LinkedHashMap r14 = new LinkedHashMap();
        LinkedHashMap r15 = new LinkedHashMap();
        Iterator r16 = r13.entrySet().iterator();
    L10:
        if (r16.hasNext() == false) goto L15;
        Map.Entry r17 = (Map.Entry) r16.next();
        if (this.f3640a.contains((String) r17.getKey()) == true) goto L13;
        r15.put(r17.getKey(), r17.getValue());
        goto L10
    L13:
        r14.put(r17.getKey(), r17.getValue());
        goto L10
    L15:
        String r18 = null;
        if (r12 == null) goto L18;
        Object r19 = r12.get("bdx_monitor_session_id");
    L20:
        if ((r19 instanceof String) == false) goto L22;
        r18 = (String) r19;
    L22:
        a(r18, "jsbPv", r14);
        LinkedHashMap r20 = new LinkedHashMap();
        r20.put("info", r14);
        r20.put("perf", r15);
        Unit r21 = Unit.INSTANCE;
        a(r18, "jsbPerfV2", r20);
        return;
    L18:
        r19 = null;
        goto L20
    }
}
