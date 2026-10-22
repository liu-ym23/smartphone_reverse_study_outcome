package com.bytedance.android.monitorV2.listener;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.android.monitorV2.event.HybridEvent$EventPhase;
import com.bytedance.android.monitorV2.event.HybridEvent$TerminateType;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.bytedance.android.monitorV2.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mn.h;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f3615k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f3616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f3618c;
    public Handler d;
    public final HandlerThread e;
    public boolean f;
    public final Lazy g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashSet f3619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f3620i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HashMap f3621j;

    public e() {
        this.f3616a = new ConcurrentHashMap();
        this.f3617b = System.currentTimeMillis();
        this.e = new HandlerThread("MonitorEventWatch");
        this.g = LazyKt.lazy(EventWatchTools$settingsFilter$2.f3608a);
        this.f3619h = new LinkedHashSet();
        this.f3620i = "total";
        this.f3621j = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("EVENT_CREATE", "total"), TuplesKt.to("EVENT_UPLOAD", "upload"), TuplesKt.to("SAMPLE_THROW", "unsample"), TuplesKt.to("SWITCH_OFF", "switch_off"), TuplesKt.to("PARAM_EXCEPTION", "type_invalid"), TuplesKt.to("CATCH_EXCEPTION", "exception"), TuplesKt.to("EVENT_REPEATED", "repeat"), TuplesKt.to("INVALID_CASE", "invalid_case"), TuplesKt.to("BLOCK_LIST", "block_list")});
        c5.a r5 = c5.c.f1123b;
        c r10 = new c(this);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "listener");
        ((ArrayList) r5.d).add(r10);
    }

    public static final void h(e r5) {
        r5.getClass();
        d5.b.c("EventWatchTools", "realFlush");
        ConcurrentHashMap r10 = r5.f3616a;
        if (r10 != null) goto L6;
        r10 = null;
    L6:
        if (r10 == null) goto L8;
        com.bytedance.android.monitorV2.constant.a.d("monitor_event_details", new JSONObject(r10).toString());
    L8:
        com.bytedance.android.monitorV2.constant.a.c("monitor_event_flush_time", System.currentTimeMillis());
        com.bytedance.android.monitorV2.constant.a.d("monitor_event_filter_id", ((CheckFilter) r5.g.getValue()).f3603c);
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public final void a(com.bytedance.android.monitorV2.event.d r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        String r10 = k(r5);
        String r11 = String.valueOf((HybridEvent$EventPhase) r5.d.f18728b);
        String r12 = (String) this.f3621j.get(r11);
        if (r12 != null) goto L5;
        r12 = "unknown_phase";
    L5:
        g(r5, r10, r12);
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public final void b(com.bytedance.android.monitorV2.event.d r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public final void c(com.bytedance.android.monitorV2.event.d r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        this.f3619h.add(r5.a().toString());
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public final void d(com.bytedance.android.monitorV2.event.d r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        String r10 = k(r5);
        String r11 = String.valueOf((HybridEvent$TerminateType) r5.d.f18729c);
        String r12 = (String) this.f3621j.get(r11);
        if (r12 != null) goto L5;
        r12 = "unknown_phase";
    L5:
        g(r5, r10, r12);
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public final void e(com.bytedance.android.monitorV2.event.d r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        String r10 = k(r5);
        String r11 = String.valueOf((HybridEvent$EventPhase) r5.d.f18728b);
        String r12 = (String) this.f3621j.get(r11);
        if (r12 != null) goto L5;
        r12 = "unknown_phase";
    L5:
        g(r5, r10, r12);
    }

    public final Map f(String r5) {
        ConcurrentHashMap r10 = this.f3616a;
        if (r10.get(r5) != null) goto L5;
        r10.put(r5, new ConcurrentHashMap());
    L5:
        Object r11 = r10.get(r5);
        Intrinsics.checkNotNull(r11);
        return (Map) r11;
    }

    public final void g(com.bytedance.android.monitorV2.event.d r5, String r10, String r11) {
        String r12 = r5.a().toString();     // Catch: Throwable -> L7
        int r13 = r10.length();     // Catch: Throwable -> L7
        LinkedHashSet r14 = this.f3619h;
        if (r13 != 0) goto L9;
        r14.remove(r12);     // Catch: Throwable -> L7
        return;
    L9:
        i(r10, r11);     // Catch: Throwable -> L7
        if (r14.contains(r12) == false) goto L16;
        i(r10, this.f3620i);     // Catch: Throwable -> L7
        r14.remove(r12);     // Catch: Throwable -> L7
        return;
    L16:
        return;
    L7:
        th = move-exception;
        h.g("default_handle", th);
    }

    public final void i(String r10, String r11) {
        if (f(r10).containsKey(r11) == false) goto L5;
        Map r5 = f(r10);
        Object r12 = f(r10).get(r11);
        Intrinsics.checkNotNull(r12);
        r5.put(r11, Long.valueOf(((Number) r12).longValue() + 1));
    L6:
        Handler r13 = this.f3618c;
        HandlerThread r14 = this.e;
        if (r13 != null) goto L10;
        r14.start();
        Handler r15 = new Handler(r14.getLooper());
        this.f3618c = r15;
        r15.postDelayed(new d(this, 2), 600000);
    L10:
        if (c5.c.f1123b.f1118b == true) goto L12;
        return;
    L12:
        if (this.d != null) goto L14;
        this.d = new Handler(r14.getLooper());
    L14:
        Handler r16 = this.d;
        if (r16 == null) goto L17;
        r16.removeCallbacksAndMessages(null);
    L17:
        Handler r17 = this.d;
        if (r17 == null) goto L22;
        r17.postDelayed(new d(this, 0), 2000);
        return;
    L22:
        return;
    L5:
        f(r10).put(r11, 1L);
        goto L6
    }

    public final LinkedHashMap j(String r10) {
        LinkedHashMap r5 = new LinkedHashMap();
        int r11 = 0;
        List r12 = StringsKt.K(r10, new String[]{"@@"}, 0, 6);
        ArrayList r13 = ((CheckFilter) this.g.getValue()).f3602b;
        int r14 = r12.size();
    L3:
        if (r11 >= r14) goto L10;
        if (Intrinsics.areEqual(r12.get(r11), "==") == true) goto L9;
        List r15 = com.bytedance.android.monitorV2.constant.b.f3524a;
        if (r13.contains(r15.get(r11)) == false) goto L9;
        r5.put(r15.get(r11), r12.get(r11));
    L9:
        r11 = r11 + 1;
        goto L3
    L10:
        r5.put("id", com.bytedance.android.monitorV2.constant.a.b("monitor_event_filter_id", ""));
        return r5;
    }

    public final String k(com.bytedance.android.monitorV2.event.d r18) {
        if (this.f == true) goto L26;
        long r10 = com.bytedance.android.monitorV2.constant.a.a("monitor_event_flush_time");
        if (r10 != 0) goto L8;
    L25:
        this.f = true;
        goto L26
    L8:
        if ((this.f3617b - r10) > 86400000) goto L24;
        String r5 = com.bytedance.android.monitorV2.constant.a.b("monitor_event_details", "");
        if (r5.length() <= 0) goto L24;
        JSONObject r11 = qo.a.c(r5);
        Iterator<String> r12 = r11.keys();     // Catch: Throwable -> L19
    L13:
        if (r12.hasNext() == false) goto L24;
        String r13 = r12.next();     // Catch: Throwable -> L19
        LinkedHashMap r14 = j(r13);     // Catch: Throwable -> L19
        LinkedHashMap r15 = new LinkedHashMap();     // Catch: Throwable -> L19
        JSONObject r16 = r11.optJSONObject(r13);     // Catch: Throwable -> L19
        Iterator<String> r17 = r16.keys();     // Catch: Throwable -> L19
    L17:
        if (r17.hasNext() == false) goto L21;
        String r19 = r17.next();     // Catch: Throwable -> L19
        r15.put(r19, Long.valueOf(r16.optLong(r19, 0)));     // Catch: Throwable -> L19
        goto L17
    L21:
        i.b(r14, r15, "report_check_plus");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        h.g("default_handle", th);
    L24:
        com.bytedance.android.monitorV2.constant.a.d("monitor_event_details", "");
    L26:
        Lazy r20 = this.g;
        Iterator r21 = ((CheckFilter) r20.getValue()).f3601a.entrySet().iterator();
    L28:
        if (r21.hasNext() == false) goto L86;
        if (((Collection) ((Map.Entry) r21.next()).getValue()).isEmpty() == true) goto L28;
        x4.a r22 = r18.f3560h;
        JSONObject r23 = null;
        if (r22 == null) goto L34;
        JSONObject r24 = new JSONObject();
        r22.m(r24);
    L35:
        Pair r25 = TuplesKt.to("containerName", qo.a.p("container_name", r24));
        ArrayList r26 = k5.h.f18618a;
        Intrinsics.checkNotNullParameter(r18, "event");
        if ((r18 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L38;
        Object r27 = "custom";
    L39:
        JSONObject r28 = k5.h.e(r18);
        if (Intrinsics.areEqual("custom", r27) == true) goto L75;
        String r29 = r28.getJSONObject("nativeBase").getJSONObject("bid_info").getString("setting_bid");     // Catch: JSONException -> L43
    L50:
        Pair r30 = TuplesKt.to("bid", r29);
        Pair r31 = TuplesKt.to("eventType", r18.f3557a);
        x4.a r32 = r18.f3560h;
        if (r32 == null) goto L53;
        r23 = new JSONObject();
        r32.m(r23);
    L53:
        Map r33 = MapsKt.mapOf(new Pair[]{r25, r30, r31, TuplesKt.to("containerType", qo.a.p("container_type", r23)), TuplesKt.to("sdkVersion", "9.0.0")});
        Iterator r34 = com.bytedance.android.monitorV2.constant.b.f3524a.iterator();
        boolean r35 = false;
        String r36 = "";
    L55:
        if (r34.hasNext() == false) goto L70;
        String r37 = (String) r34.next();
        Object r38 = ((CheckFilter) r20.getValue()).f3601a.get(r37);
        Intrinsics.checkNotNull(r38);
        List r39 = (List) r38;
        if (r35 == false) goto L60;
        r36 = io.reactivex.internal.observers.h.b(r36, "@@");
    L60:
        if (r39.isEmpty() == false) goto L62;
    L64:
        StringBuilder r40 = sk.a.a(r36);
        if (r39.isEmpty() == false) goto L67;
        String r41 = "==";
    L68:
        r40.append(r41);
        r36 = r40.toString();
        r35 = true;
        goto L55
    L67:
        r41 = (String) r33.get(r37);
        goto L68
    L62:
        if (CollectionsKt.contains(r39, r33.get(r37)) == true) goto L64;
        return "";
    L70:
        return r36;
    L43:
        e = move-exception;
        h.g("default_handle", e);
    L49:
        r29 = "";
        goto L50
    L75:
        r29 = r28.getJSONObject("bid_info").getString("setting_bid");     // Catch: JSONException -> L47
    L47:
        e = move-exception;
        h.g("default_handle", e);
        goto L49
    L38:
        r27 = "";
        goto L39
    L34:
        r24 = null;
        goto L35
    L86:
        return "";
    }
}
