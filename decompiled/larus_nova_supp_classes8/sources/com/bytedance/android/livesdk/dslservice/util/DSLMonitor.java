package com.bytedance.android.livesdk.dslservice.util;

import am2.x;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class DSLMonitor {
    public final String a;
    public final String b;
    public final String c;

    public DSLMonitor() {
        this.a = "livesdk_dsl_load_component_card";
        this.b = "livesdk_dsl_load_component_result";
        this.c = "TriangleManager";
    }

    public String c() {
        return this.c;
    }

    public final void a(Function1<? super f, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "initBlock");
        e(0, r2);
    }

    public final void d(Function1<? super f, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "initBlock");
        e(1, r2);
    }

    public final void e(int r4, Function1<? super f, Unit> r5) {
        Function2 r0 = DSLMonitor$logDebugInfo$logFunc$1.INSTANCE;
        if (r4 == 0) goto L12;
        if (r4 != 1) goto L7;
        r0 = DSLMonitor$logDebugInfo$1.INSTANCE;
    L14:
        f r6 = new f();
        r5.invoke(r6);
        String r1 = "";
        if (r6.b == null) goto L23;
        String r7 = r6.a;
        if (r7 != null) goto L19;
        r7 = c();
    L19:
        String r2 = r6.b;
        if (r2 != null) goto L22;
        r2 = "";
    L22:
        r0.invoke(r7, r2);
    L23:
        Throwable r8 = r6.c;
        if (r8 == null) goto L36;
        StringBuilder r3 = new StringBuilder();
        String r9 = r6.a;
        if (r9 != null) goto L28;
        r9 = c();
    L28:
        r3.append(r9);
        String r10 = r6.b;
        if (r10 == null) goto L32;
        r1 = r10;
    L32:
        r3.append(r1);
        SafetyGuard.a(null, r8, r3.toString());
        if (v.a() == false) goto L37;
        throw r8;
    L37:
        return;
    L36:
        return;
    L7:
        if (r4 != 2) goto L14;
        r0 = DSLMonitor$logDebugInfo$2.INSTANCE;
        goto L14
    L12:
        if (v.a() == true) goto L14;
    }

    public final void h(final String r5, final Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r6, "map");
        j0.l().sendLog(r5, r6, new Object[]{IRoom.class, x.class});
        e(1, new DSLMonitor$sendTrackLog$1(this, r5, r6));
    }

    public static void g(String r4, Map r5, int r6, long r7) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r5, "map");
        LiveTracingMonitor.EventModule r0 = LiveTracingMonitor.EventModule.common;
        JSONObject r1 = new JSONObject();
        r1.put("latency", r7);     // Catch: JSONException -> L15
    L4:
        JSONObject r8 = new JSONObject();
        r8.put("status_code", r6);     // Catch: JSONException -> L16
    L6:
        Iterator r9 = r5.entrySet().iterator();
    L8:
        if (r9.hasNext() == false) goto L13;
        Map.Entry r10 = (Map.Entry) r9.next();
        r8.put((String) r10.getKey(), (String) r10.getValue());     // Catch: JSONException -> L12
        goto L8
    L13:
        LiveMonitor r11 = new LiveMonitor();
        r11.mCategory = r8;
        r11.mEventModule = r0;
        r11.mServiceName = r4;
        r11.mExtraLog = null;
        r11.mMetrics = r1;
        LiveMonitor.access$002(r11, false);
        LiveMonitor.access$102(r11, false);
        LiveMonitor.access$202(r11, true);
        LiveMonitor.access$302(r11, false);
        LiveMonitor.access$402(r11, false);
        r11.report();
    }

    public final void f(String r4, int r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "dslType");
        Intrinsics.checkNotNullParameter(r6, "loadType");
        Intrinsics.checkNotNullParameter(r7, "id");
        HashMap r1 = new HashMap();
        r1.put("result", String.valueOf(r5));
        r1.put("dsl_type", r4);
        r1.put("load_type", r6);
        r1.put("id", r7);
        h(this.b, r1);
    }

    public static HashMap b(long r3, String r5, String r6, boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r6, "dslType");
        Intrinsics.checkNotNullParameter(r8, "loadType");
        Pair[] r1 = new Pair[5];
        r1[0] = TuplesKt.to("template", r5);
        r1[1] = TuplesKt.to("cost", String.valueOf(r3));
        if (r7 == false) goto L5;
        String r4 = "1";
    L6:
        r1[2] = TuplesKt.to("isFirst", r4);
        r1[3] = TuplesKt.to("loadType", r8);
        r1[4] = TuplesKt.to("dsl_type", r6);
        return MapsKt.hashMapOf(r1);
    L5:
        r4 = "0";
        goto L6
    }
}
