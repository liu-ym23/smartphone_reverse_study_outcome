package com.bytedance.lynx.service.reporter.performance;

import android.content.Context;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.lynx.service.reporter.LynxEventReporterService;
import com.lynx.base.log.LynxLog;
import com.ss.android.common.lib.AppLogNewUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f6855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f6856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f6857c;
    public final AtomicReference d;
    public Context e;
    public final Lazy f;
    public final Lazy g;

    public g() {
        this.f6855a = new ConcurrentHashMap();
        this.f6856b = new ConcurrentHashMap();
        this.f6857c = new AtomicReference(null);
        this.d = new AtomicReference(Boolean.FALSE);
        this.f = LazyKt.lazy(new LynxMemoryUsageProcessor$globalReporter$2(this));
        this.g = LazyKt.lazy(LynxMemoryUsageProcessor$enable$2.f6841a);
        Npth.addAttachLongUserData(new f(this), CrashType.ALL);
    }

    @Override // com.bytedance.lynx.service.reporter.performance.a
    public final boolean a(co.e r10) {
        Intrinsics.checkNotNullParameter(r10, "entry");
        ((Boolean) this.g.getValue()).getClass();
        String r5 = r10.f1226a;
        if (r5 == null) goto L39;
        int r11 = r5.hashCode();
        Integer r12 = null;
        if (r11 == (-701686520)) goto L24;
        if (r11 == 101203) goto L15;
        if (r11 != 528832539) goto L39;
        if (r5.equals("actualFmp") == false) goto L39;
    L17:
        Object r13 = r10.f1228c.get("instanceId");
        if ((r13 instanceof Integer) == false) goto L20;
        Integer r14 = (Integer) r13;
    L21:
        if (r14 == null) goto L39;
        c(r14.intValue(), r10.f1226a, null);
        goto L39
    L20:
        r14 = null;
        goto L21
    L15:
        if (r5.equals("fcp") == true) goto L17;
    L24:
        if (r5.equals("loadBundle") == false) goto L39;
        Object r15 = r10.f1228c.get("instanceId");
        if ((r15 instanceof Integer) == false) goto L29;
        r12 = (Integer) r15;
    L29:
        if (r12 == null) goto L39;
        final int r16 = r12.intValue();
        if (this.f6856b.containsKey(Integer.valueOf(r16)) == true) goto L39;
        final WeakReference r17 = new WeakReference(this);
        Lazy r18 = c.e;
        Function3<Long, Integer, Long, Unit> r19 = new LynxMemoryUsageProcessor$startTimer$timer$1(r17, r16);
        Intrinsics.checkNotNullParameter(r19, "reportBlock");
        c r20 = new c(r19);
        if (r20.d == true) goto L37;
        r20.d = true;
        r20.f6846b = 0;
        r20.f6847c = 0;
        r20.a();
    L37:
        this.f6856b.put(Integer.valueOf(r16), r20);
    L39:
        return Intrinsics.areEqual(r10.f1227b, LynxMonitorService.KEY_MEMORY);
    }

    @Override // com.bytedance.lynx.service.reporter.performance.a
    public final Map b(co.e r17) {
        Intrinsics.checkNotNullParameter(r17, "entry");
        if ((r17 instanceof co.c) == true) goto L5;
        return null;
    L5:
        Object r5 = r17.f1228c.get("instanceId");
        if ((r5 instanceof Integer) == false) goto L8;
        Integer r10 = (Integer) r5;
    L9:
        if (r10 == null) goto L113;
        int r11 = r10.intValue();
        final e r12 = (e) this.f.getValue();
        co.c r13 = (co.c) r17;
        co.c r14 = (co.c) this.f6855a.get(r10);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "entry");
        if (r12.e != null) goto L18;
        Lazy r15 = c.e;
        Function3<Long, Integer, Long, Unit> r16 = new LynxMemoryUsageGlobalReporter$startTimerIfNeeded$1(r12);
        Intrinsics.checkNotNullParameter(r16, "reportBlock");
        c r18 = new c(r16);
        if (r18.d == true) goto L16;
        r18.d = true;
        r18.f6846b = 0;
        r18.f6847c = 0;
        r18.a();
    L16:
        r12.e = r18;
    L18:
        if (r13.d != 0) goto L29;
        if (r14 == null) goto L80;
        String r19 = (String) r12.f6851a.get(r10);
        if (r19 == null) goto L28;
        d r20 = (d) r12.f6852b.get(r19);
        if (r20 == null) goto L28;
        long r21 = r14.d;
        r20.f6849b -= r21;
        r12.f6853c -= r21;
        r20.f6850c--;
        r12.d--;
        if (r20.f6850c > 0) goto L28;
        r12.f6852b.remove(r19);
    L28:
        r12.f6851a.remove(r10);
    L80:
        if (r13.d != 0) goto L84;
        this.f6855a.remove(r10);
        c r22 = (c) this.f6856b.remove(r10);
        if (r22 == null) goto L85;
        r22.d = false;
    L85:
        LinkedHashSet r23 = new LinkedHashSet();
        LinkedHashMap r24 = new LinkedHashMap();
        Iterator r25 = this.f6855a.values().iterator();
        long r110 = 0;
    L87:
        if (r25.hasNext() == false) goto L114;
        co.c r26 = (co.c) r25.next();
        long r27 = r26.d;
        co.d r28 = (co.d) r26.e.get("backgroundThreadScriptingEngine");
        if (r28 == null) goto L96;
        String r111 = (String) r28.f1225b.get("groupId");
        if (r111 == null) goto L96;
        if (r23.contains(r111) == false) goto L95;
        r27 = r27 - r28.f1224a;
        goto L96
    L95:
        r23.add(r111);
    L96:
        Object r29 = r26.f1228c.get("url");
        if ((r29 instanceof String) == false) goto L99;
        String r30 = (String) r29;
    L100:
        if (r30 == null) goto L87;
        r24.put(r30, new JSONObject(r26.f1228c));
        r110 = r110 + r27;
        goto L87
    L99:
        r30 = null;
        goto L100
    L114:
        JSONObject r31 = new JSONObject();     // Catch: JSONException -> L106
        r31.put("sizeBytes", r110);     // Catch: JSONException -> L106
        r31.put("lynxViewCount", r24.size());     // Catch: JSONException -> L106
        r31.put("detail", new JSONObject(r24));     // Catch: JSONException -> L106
        LynxLog.b(2, "LynxSDKMonitor", "LynxSDKMemoryUsage - totalSizeBytes: " + r110 + ", lynxViewCount: " + r24.size());     // Catch: JSONException -> L106
        StringBuilder r32 = new StringBuilder();     // Catch: JSONException -> L106
        r32.append("LynxSDKMemoryUsage - detail: ");     // Catch: JSONException -> L106
        r32.append(r31);     // Catch: JSONException -> L106
        String r33 = r32.toString();     // Catch: JSONException -> L106
        this.f6857c.set(r33);     // Catch: JSONException -> L106
        LynxLog.b(2, "LynxSDKMonitor", r33);     // Catch: JSONException -> L106
        if (((Boolean) this.d.get()).booleanValue() == true) goto L120;
        this.d.set(Boolean.TRUE);     // Catch: JSONException -> L106
        Npth.addTag("enableLynxMemoryMonitor", "true");     // Catch: JSONException -> L106
        return null;
    L120:
        return null;
    L106:
        e = move-exception;
        String r34 = e.getMessage();
        if (r34 != null) goto L110;
        r34 = "";
    L110:
        LynxLog.b(4, "LynxMemoryUsageProcessor", r34);
        return null;
    L84:
        this.f6855a.put(r10, r17);
        goto L85
    L29:
        Object r35 = r12.f6851a.get(r10);
        CharSequence r112 = (CharSequence) r35;
        if (r112 != null) goto L32;
    L50:
        Object r113 = r13.f1228c.get("url");
        if ((r113 instanceof String) == false) goto L53;
        String r114 = (String) r113;
    L54:
        if (r114 != null) goto L56;
    L59:
        CharSequence r115 = (CharSequence) r35;
        if (r115 != null) goto L62;
    L63:
        r35 = com.lynx.jsbridge.a.d(r11, "unknown_url_");
    L64:
        r12.f6851a.put(r10, r35);
    L65:
        ConcurrentHashMap r36 = r12.f6852b;
        Object r116 = r36.get(r35);
        Object r117 = r116;
        if (r116 != null) goto L71;
        Intrinsics.checkNotNull(r35);
        String r118 = (String) r35;
        Intrinsics.checkNotNullParameter(r118, "url");
        d r119 = new d();
        r119.f6848a = r118;
        r119.f6849b = 0;
        r119.f6850c = 0;
        Object r37 = r36.putIfAbsent(r35, r119);
        r117 = r119;
        if (r37 == null) goto L71;
        r117 = r37;
    L71:
        d r120 = (d) r117;
        long r121 = r13.d;
        if (r14 == null) goto L74;
        long r38 = r14.d;
    L75:
        long r122 = r121 - r38;
        if (r14 != null) goto L78;
        r120.f6850c++;
        r12.d++;
    L78:
        r120.f6849b += r122;
        r12.f6853c += r122;
        goto L80
    L74:
        r38 = 0;
        goto L75
    L62:
        if (r115.length() != 0) goto L64;
    L56:
        if (r114.length() == 0) goto L59;
        r35 = com.lynx.jsbridge.a.e(r114);
        goto L59
    L53:
        r114 = null;
        goto L54
    L32:
        if (r112.length() == 0) goto L50;
        if (StringsKt.P((String) r35, "unknown_url_") == false) goto L65;
        Object r39 = r13.f1228c.get("url");
        if ((r39 instanceof String) == false) goto L39;
        String r40 = (String) r39;
    L40:
        if (r40 == null) goto L65;
        if (r40.length() == 0) goto L65;
        String r41 = com.lynx.jsbridge.a.e(r40);
        if (r41 == null) goto L65;
        d r123 = (d) r12.f6852b.get(r35);
        if (r123 == null) goto L49;
        TypeIntrinsics.asMutableMap(r12.f6852b).remove(r35);
        Intrinsics.checkNotNullParameter(r41, "<set-?>");
        r123.f6848a = r41;
        d r42 = (d) r12.f6852b.put(r41, r123);
    L49:
        r12.f6851a.put(r10, r41);
        r35 = r41;
        goto L65
    L39:
        r40 = null;
        goto L40
    L113:
        return null;
    L8:
        r10 = null;
        goto L9
    }

    public final void c(int r5, String r10, Map r11) {
        co.c r12 = (co.c) this.f6855a.get(Integer.valueOf(r5));
        if (r12 != null) goto L5;
        return;
    L5:
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("totalSizeBytes", Long.valueOf(r12.d));
        r13.put("stage", r10);
        Iterator r14 = r12.e.entrySet().iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        Map.Entry r15 = (Map.Entry) r14.next();
        String r16 = (String) r15.getKey();
        co.d r17 = (co.d) r15.getValue();
        r13.put(io.reactivex.internal.observers.h.b(r16, "SizeBytes"), Long.valueOf(r17.f1224a));
        goto L7
    L9:
        HashMap r18 = r12.f1228c;
        if (r18 == null) goto L12;
        r13.putAll(r18);
    L12:
        if (r11 == null) goto L14;
        r13.putAll(r11);
    L14:
        AppLogNewUtils.onEventV3("lynxsdk_performance_entry_memory", LynxEventReporterService.INSTANCE.convertBooleanToInt(new JSONObject(r13)));
    }

    @Override // com.bytedance.lynx.service.reporter.performance.a
    public final void onInitialize(Context r5) {
        this.e = r5;
    }
}
