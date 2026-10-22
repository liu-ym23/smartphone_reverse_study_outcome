package com.bytedance.ai.core.manager;

import android.app.Application;
import android.content.Context;
import android.os.Trace;
import androidx.lifecycle.Lifecycle;
import b3.h;
import com.bytedance.ai.core.base.SessionType;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.JSWorkerRuntime;
import com.bytedance.ai.model.RelaxWorkerRuntime;
import com.bytedance.ai.model.i;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.ai.resource.j;
import com.bytedance.ai.settings.AISDKSettingsCore;
import com.bytedance.ai.utils.c;
import com.bytedance.ies.web.jsbridge2.p;
import com.lynx.tasm.ui.image.f0;
import com.lynx.tasm.utils.g;
import com.obric.feature.miniapp.widget.MiniAppConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.r;
import kotlinx.coroutines.s;
import kotlinx.coroutines.sync.d;
import kotlinx.coroutines.sync.e;
import l9.l;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f2141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f2142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f2143c;
    public final ConcurrentHashMap d;
    public final ArrayList e;

    public b() {
        this.f2141a = new ConcurrentHashMap();
        this.f2142b = new ConcurrentHashMap();
        this.f2143c = e.a();
        this.d = new ConcurrentHashMap();
        this.e = CollectionsKt.arrayListOf(new String[]{MiniAppConstants.APPLET_ID_CALENDAR, "com.flow.remind.o", "com.obric.map", "com.obric.news", "com.obric.exchange"});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [T, java.lang.Object] */
    public static final Object a(b r22, String r23, Context r24, String r25, String r26, String r27, String r28, SessionType r29, Map r30, ContinuationImpl r31) {
        if ((r31 instanceof WorkerRuntimeManager$runAppletWorkerInner$1) == false) goto L7;
        WorkerRuntimeManager$runAppletWorkerInner$1 r10 = (WorkerRuntimeManager$runAppletWorkerInner$1) r31;
        int r11 = r10.f2134q;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.f2134q = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.f2132o;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.f2134q;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        long r5 = r10.f2131n;
        long r15 = r10.f2130m;
        String r16 = r10.f2129l;
        String r17 = r10.f2128k;
        Ref.ObjectRef r18 = r10.f2127j;
        Map r19 = r10.f2126i;
        SessionType r110 = r10.f2125h;
        String r111 = r10.g;
        String r112 = r10.f;
        String r20 = r10.e;
        String r113 = r10.d;
        Context r21 = r10.f2124c;
        String r32 = r10.f2123b;
        b r33 = r10.f2122a;
        ResultKt.throwOnFailure(r12);
        String r34 = r17;
        String r114 = r20;
        Ref.ObjectRef r35 = r18;
        Object r115 = r12;
        long r36 = r15;
        String r37 = r32;
        String r38 = r16;
        long r39 = r5;
    L74:
        Applet r116 = (Applet) r115;
        if (r116 != null) goto L91;
        String r40 = g.d("Applet ", r37, " not found, can't launch main thread");
        String r41 = com.lynx.tasm.behavior.utils.d.c("<parseMessage>< runapplet: ", r40, "applet_lifecycle");
        t0.d r117 = c.f2846a;
        if (r117 == null) goto L79;
        r117.e("applet_lifecycle", r41);
    L79:
        String r42 = "runAppletWorkerInner: loadApplet FAILED, elapsed=" + (System.currentTimeMillis() - r36) + "ms";
        Intrinsics.checkNotNullParameter("WorkerRuntimeManager", "tag");
        t0.d r43 = c.f2846a;
        if (r43 == null) goto L82;
        r43.e("WorkerRuntimeManager", r42);
    L82:
        z2.d.e("applet_run_applet_result", new p(2, r37, r112, r111, r40));
        T r44 = r35.element;
        if (((AppletRuntime) r44) == null) goto L85;
        r33.f2142b.put(r37, r44);
        r33.d(r37);
    L85:
        if (r34 == null) goto L88;
        if (r38 == null) goto L88;
        b3.p r45 = h.f841a;
        AppletErrorCode r46 = AppletErrorCode.f2378b;
        h.a(101, r34, r40, r38);
    L88:
        Trace.endSection();
        return null;
    L91:
        SessionType r210 = r110;
        String r211 = r113;
        Map r118 = r19;
        String r47 = "runAppletWorkerInner: loadApplet SUCCESS, loadTime=" + (System.currentTimeMillis() - r39) + "ms, totalElapsed=" + (System.currentTimeMillis() - r36) + "ms, versionCode=" + r116.f2260c;
        Intrinsics.checkNotNullParameter("WorkerRuntimeManager", "tag");
        t0.d r48 = c.f2846a;
        if (r48 == null) goto L94;
        r48.i("WorkerRuntimeManager", r47);
    L94:
        if (r34 == null) goto L111;
        if (r38 == null) goto L111;
        String r49 = r116.B;
        if (r49 != null) goto L99;
        r49 = "";
    L99:
        String r50 = r116.d;
        if (r50 != null) goto L102;
        r50 = "";
    L102:
        b3.p r119 = h.f841a;
        Map r51 = MapsKt.mapOf(new Pair[]{TuplesKt.to("applet_res_from", r49), TuplesKt.to("scm_version", r50), TuplesKt.to("version_code", Boxing.boxLong(r116.f2260c)), TuplesKt.to("packageId", r116.f2259b)});
        Intrinsics.checkNotNullParameter(r34, "traceId");
        Intrinsics.checkNotNullParameter(r38, "eventType");
        Intrinsics.checkNotNullParameter(r51, "eventInfo");
        long r120 = System.currentTimeMillis();
        String r52 = com.lynx.tasm.utils.b.j("onLoadAppletEnd: ", r34, ", ", r38);
        Context r121 = r21;
        Intrinsics.checkNotNullParameter("AppletEventMonitorManager", "tag");
        t0.d r122 = c.f2846a;
        if (r122 == null) goto L106;
        r122.d("AppletEventMonitorManager", r52);
    L106:
        if (Intrinsics.areEqual(r38, "applet_widget_timeline_full") == false) goto L109;
        h.c(new b3.a(r34, r120, r51, 0));
    L112:
        T r53 = r35.element;
        if (r53 != 0) goto L115;
    L122:
        StringBuilder r54 = new StringBuilder("runAppletWorkerInner: need to create new runtime, reason=");
        if (r35.element != 0) goto L125;
        String r55 = "no existing runtime";
    L126:
        r54.append(r55);
        r54.append(", elapsed=");
        r54.append(System.currentTimeMillis() - r36);
        String r56 = androidx.room.jarjarred.org.antlr.runtime.a.v(r54, "ms", "WorkerRuntimeManager", "tag");
        t0.d r57 = c.f2846a;
        if (r57 == null) goto L129;
        r57.i("WorkerRuntimeManager", r56);
    L129:
        T r58 = r35.element;
        if (((AppletRuntime) r58) == null) goto L132;
        r33.f2142b.put(r37, r58);
        r33.d(r37);
    L132:
        r33.getClass();
        if (ym.h.a(r116.f2261h, "2.0") < 0) goto L146;
        String r59 = r116.K;
        if (r59 != null) goto L137;
        Intrinsics.checkNotNullParameter("WorkerRuntimeManager", "tag");
        t0.d r60 = c.f2846a;
        if (r60 == null) goto L145;
        r60.e("WorkerRuntimeManager", "runtimeEntry is NULL");
    L145:
        Boolean r123 = null;
    L154:
        if (r123 != null) goto L156;
    L208:
        if (r34 == null) goto L211;
        if (r38 == null) goto L211;
        String r61 = g.d("The runtimeEntry of ", r37, " not found");
        b3.p r62 = h.f841a;
        AppletErrorCode r63 = AppletErrorCode.f2378b;
        h.a(105, r34, r61, r38);
    L211:
        Trace.endSection();
        return null;
    L156:
        if (r123.booleanValue() == false) goto L158;
        Context r64 = r121;
        Intrinsics.checkNotNullParameter(r64, "app");
        Intrinsics.checkNotNullParameter(r116, "applet");
        AppletRuntime r65 = new RelaxWorkerRuntime(r64, r116, r118);
    L183:
        if (r65 == null) goto L208;
        Result.Companion r66 = Result.Companion;     // Catch: Throwable -> L187
        r65.m(new com.bytedance.ai.bridge.method.net.e(r65, 1));     // Catch: Throwable -> L187
        Object r67 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L187
    L189:
        Throwable r68 = Result.m127exceptionOrNullimpl(r67);
        if (r68 == null) goto L194;
        String r69 = "init worker failed: " + r68.getMessage();
        Intrinsics.checkNotNullParameter("WorkerRuntime", "tag");
        t0.d r70 = c.f2846a;
        if (r70 == null) goto L194;
        r70.e("WorkerRuntime", r69, r68);
    L194:
        HashSet r71 = i.f2247a;
        Intrinsics.checkNotNullParameter(r65, "runtime");
        i.f2247a.add(r65);
        c.g(r65.f2204o, Lifecycle.Event.ON_CREATE);
        StringBuilder r72 = new StringBuilder("runAppletWorkerInner: created new runtime type=");
        r72.append(r65.getClass().getSimpleName());
        r72.append(", elapsed=");
        r72.append(System.currentTimeMillis() - r36);
        String r73 = androidx.room.jarjarred.org.antlr.runtime.a.v(r72, "ms", "WorkerRuntimeManager", "tag");
        t0.d r74 = c.f2846a;
        if (r74 == null) goto L197;
        r74.i("WorkerRuntimeManager", r73);
    L197:
        r33.f2141a.put(r37, r65);
        Lazy r75 = com.bytedance.ai.model.p.f2292a;
        z2.d.e("applet_run_applet_result", new a(r37, r112, r111, 0));
        Trace.endSection();
        if (r211 == null) goto L204;
        if (r210 != null) goto L202;
        SessionType r124 = SessionType.f2087a;
    L203:
        r65.k(r211, r114, r124);
        goto L204
    L202:
        r124 = r210;
    L204:
        String r76 = "runAppletWorkerInner END: created new runtime, totalTime=" + (System.currentTimeMillis() - r36) + "ms";
        Intrinsics.checkNotNullParameter("WorkerRuntimeManager", "tag");
        t0.d r77 = c.f2846a;
        if (r77 == null) goto L207;
        r77.i("WorkerRuntimeManager", r76);
    L207:
        return r65;
    L187:
        th = move-exception;
        Result.Companion r78 = Result.Companion;
        r67 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L189
    L158:
        Context r79 = r121;
        if (ym.a.e(r116.C) == false) goto L182;
        String r80 = com.lynx.tasm.behavior.utils.d.c("runAppletWorkerInner: need to create lynx runtime, appletId=", r37, "WorkerRuntimeManager");
        t0.d r81 = c.f2846a;
        if (r81 == null) goto L163;
        r81.i("WorkerRuntimeManager", r80);
    L163:
        k1.b r82 = k1.b.f18581a;
        monitor-enter(r82);
        Intrinsics.checkNotNullParameter(r79, "app");     // Catch: Throwable -> L173
        Intrinsics.checkNotNullParameter(r116, "applet");     // Catch: Throwable -> L173
        String r83 = r116.i();     // Catch: Throwable -> L173
        monitor-enter(r82);     // Catch: Throwable -> L173
        Intrinsics.checkNotNullParameter(r83, "appletId");     // Catch: Throwable -> L177
        LinkedHashMap r84 = k1.b.f18582b;     // Catch: Throwable -> L177
        k1.a r85 = (k1.a) r84.get(r83);     // Catch: Throwable -> L177
        monitor-exit(r82);     // Catch: Throwable -> L173
        if (r85 != null) goto L176;
        String r125 = "launchApp, appletId:" + r116.i();     // Catch: Throwable -> L173
        Intrinsics.checkNotNullParameter("AppletAppManagerService", "tag");     // Catch: Throwable -> L173
        Intrinsics.checkNotNullParameter(r125, "msg");     // Catch: Throwable -> L173
        a1.a.f43a.i("AppletAppManagerService", r125);     // Catch: Throwable -> L173
        k1.a r86 = new k1.a(r79, r116, r118);     // Catch: Throwable -> L173
        r84.put(r116.i(), r86);     // Catch: Throwable -> L173
        monitor-exit(r82);     // Catch: Throwable -> L173
        r65 = r86.f18580b;
        goto L183
    L176:
        throw new IllegalArgumentException("appletId:" + r116.i() + " is already installed");     // Catch: Throwable -> L173
    L177:
        th = move-exception;
        throw th;     // Catch: Throwable -> L173
    L173:
        th = move-exception;
        throw th;
    L182:
        Intrinsics.checkNotNullParameter(r79, "app");
        Intrinsics.checkNotNullParameter(r116, "applet");
        r65 = new JSWorkerRuntime(r79, r116, r118);
        goto L183
    L137:
        if (r59.length() != 0) goto L141;
        Intrinsics.checkNotNullParameter("WorkerRuntimeManager", "tag");
        t0.d r87 = c.f2846a;
        if (r87 == null) goto L145;
        r87.e("WorkerRuntimeManager", "runtimeEntry is empty");
        goto L145
    L141:
        r123 = Boolean.valueOf(StringsKt.k(r59, ".rasm"));
        goto L154
    L146:
        String r88 = r116.i();
        if (r33.e.contains(r88) == false) goto L149;
    L152:
        boolean r126 = true;
    L153:
        r123 = Boolean.valueOf(r126);
        goto L154
    L149:
        if (AISDKSettingsCore.c().relaxConfig().d().contains(r88) == true) goto L152;
        r126 = false;
        goto L153
    L125:
        StringBuilder r89 = new StringBuilder("version changed (");
        r89.append(((AppletRuntime) r35.element).f2197h.f2260c);
        r89.append(" -> ");
        r55 = androidx.room.jarjarred.org.antlr.runtime.a.t(r89, r116.f2260c, ')');
        goto L126
    L115:
        if (((AppletRuntime) r53).f2197h.f2260c != r116.f2260c) goto L122;
        z2.d.e("applet_run_applet_result", new a(r37, r112, r111, 1));
        Trace.endSection();
        String r90 = "runAppletWorkerInner END: reused existing runtime, totalTime=" + (System.currentTimeMillis() - r36) + "ms";
        Intrinsics.checkNotNullParameter("WorkerRuntimeManager", "tag");
        t0.d r91 = c.f2846a;
        if (r91 == null) goto L121;
        r91.i("WorkerRuntimeManager", r90);
    L121:
        return r35.element;
    L109:
        if (Intrinsics.areEqual(r38, "applet_page_timeline_full") == false) goto L112;
        h.c(new b3.a(r34, r120, r51, 1));
    L111:
        r121 = r21;
        goto L112
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        long r92 = System.currentTimeMillis();
        StringBuilder r127 = com.lynx.tasm.base.a.e("runAppletWorkerInner START: appletId=", r23, ", msgId=", r27, ", thread=");
        r127.append(Thread.currentThread().getName());
        String r128 = r127.toString();
        Intrinsics.checkNotNullParameter("WorkerRuntimeManager", "tag");
        t0.d r129 = c.f2846a;
        if (r129 == null) goto L17;
        r129.i("WorkerRuntimeManager", r128);
    L17:
        Trace.beginSection("runApplet");
        z2.d.e("applet_run_applet", new l(r23, r27, r26, r28));
        Ref.ObjectRef r93 = new Ref.ObjectRef();
        r93.element = r22.f2141a.get(r23);
        StringBuilder r130 = new StringBuilder("runAppletWorkerInner: check existing runtime, found=");
        if (r93.element == 0) goto L20;
        boolean r131 = true;
    L21:
        r130.append(r131);
        r130.append(", terminated=");
        AppletRuntime r132 = (AppletRuntime) r93.element;
        if (r132 == null) goto L24;
        Boolean r133 = Boxing.boxBoolean(r132.f2200k.get());
    L25:
        r130.append(r133);
        r130.append(", elapsed=");
        r130.append(System.currentTimeMillis() - r92);
        String r134 = androidx.room.jarjarred.org.antlr.runtime.a.v(r130, "ms", "WorkerRuntimeManager", "tag");
        t0.d r135 = c.f2846a;
        if (r135 == null) goto L28;
        r135.i("WorkerRuntimeManager", r134);
    L28:
        AppletRuntime r136 = (AppletRuntime) r93.element;
        if (r136 != null) goto L31;
    L33:
        if (r30 == null) goto L35;
        Object r137 = r30.get("trace_id");
    L37:
        if ((r137 instanceof String) == false) goto L39;
        String r138 = (String) r137;
    L40:
        if (r138 != null) goto L42;
        r138 = null;
    L42:
        if (r30 == null) goto L44;
        Object r139 = r30.get("eventName");
    L46:
        if ((r139 instanceof String) == false) goto L48;
        String r140 = (String) r139;
    L49:
        if (r140 != null) goto L51;
        r140 = null;
    L51:
        if (r138 == null) goto L62;
        if (r140 == null) goto L62;
        b3.p r141 = h.f841a;
        Intrinsics.checkNotNullParameter(r138, "traceId");
        Intrinsics.checkNotNullParameter(r140, "eventType");
        long r142 = System.currentTimeMillis();
        Object r143 = r13;
        String r144 = com.lynx.tasm.utils.b.j("onLoadAppletStart: ", r138, ", ", r140);
        Ref.ObjectRef r145 = r93;
        Intrinsics.checkNotNullParameter("AppletEventMonitorManager", "tag");
        t0.d r146 = c.f2846a;
        if (r146 == null) goto L57;
        r146.d("AppletEventMonitorManager", r144);
    L57:
        if (Intrinsics.areEqual(r140, "applet_widget_timeline_full") == false) goto L60;
        h.c(new a3.b(r138, r142, 13));
    L63:
        String r147 = "runAppletWorkerInner: start loading applet, elapsed=" + (System.currentTimeMillis() - r92) + "ms";
        Intrinsics.checkNotNullParameter("WorkerRuntimeManager", "tag");
        t0.d r148 = c.f2846a;
        if (r148 == null) goto L66;
        r148.i("WorkerRuntimeManager", r147);
    L66:
        long r149 = System.currentTimeMillis();
        j r94 = j.f2734a;
        if (r27 == null) goto L69;
        Map r150 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message_id", r27)});
    L70:
        r10.f2122a = r22;
        r10.f2123b = r23;
        r10.f2124c = r24;
        r10.d = r25;
        r10.e = r26;
        r10.f = r27;
        r10.g = r28;
        r10.f2125h = r29;
        r10.f2126i = r30;
        r10.f2127j = r145;
        r10.f2128k = r138;
        r10.f2129l = r140;
        r10.f2130m = r92;
        r10.f2131n = r149;
        r10.f2134q = 1;
        Object r95 = r94.f(r23, r150, r10);
        Object r96 = r143;
        if (r95 != r96) goto L73;
        return r96;
    L73:
        r115 = r95;
        r114 = r26;
        r34 = r138;
        r38 = r140;
        r21 = r24;
        r113 = r25;
        r37 = r23;
        r112 = r27;
        r19 = r30;
        r36 = r92;
        r35 = r145;
        r33 = r22;
        r110 = r29;
        r111 = r28;
        r39 = r149;
        goto L74
    L69:
        r150 = null;
        goto L70
    L60:
        if (Intrinsics.areEqual(r140, "applet_page_timeline_full") == false) goto L63;
        h.c(new a3.b(r138, r142, 14));
    L62:
        r145 = r93;
        r143 = r13;
        goto L63
    L48:
        r140 = null;
        goto L49
    L44:
        r139 = null;
        goto L46
    L39:
        r138 = null;
        goto L40
    L35:
        r137 = null;
        goto L37
    L31:
        if (r136.f2200k.get() != true) goto L33;
        r22.d(r23);
        r93.element = null;
        goto L33
    L24:
        r133 = null;
        goto L25
    L20:
        r131 = false;
    L7:
        r10 = new WorkerRuntimeManager$runAppletWorkerInner$1(r22, r31);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(String r31, Application r32, String r33, String r34, String r35, String r36, SessionType r37, Map r38, ContinuationImpl r39) {
        b r5 = this;
        String r10 = ": await completed successfully, result=true";
        Object r11 = "await runApplet ";
        if ((r39 instanceof WorkerRuntimeManager$runAppletWorker$1) == false) goto L7;
        WorkerRuntimeManager$runAppletWorker$1 r12 = (WorkerRuntimeManager$runAppletWorker$1) r39;
        int r13 = r12.f2108p;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.f2108p = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.f2106n;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.f2108p;
        if (r16 == 0) goto L24;
        if (r16 == 1) goto L23;
        if (r16 == 2) goto L18;
        if (r16 != 3) goto L17;
        r r17 = (r) r12.e;
        Ref.ObjectRef r18 = (Ref.ObjectRef) r12.d;
        kotlinx.coroutines.sync.a r19 = (kotlinx.coroutines.sync.a) r12.f2099c;
        String r20 = r12.f2098b;
        b r21 = r12.f2097a;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L83
        r11 = r19;
    L79:
        BuildersKt.launch$default(h0.a(Dispatchers.getDefault()), null, null, new WorkerRuntimeManager$runAppletWorker$2$3(r21, r20, r17, null), 3, null);     // Catch: Throwable -> L83
        j0.e(r12.getContext());     // Catch: Throwable -> L83
        Object r110 = r11;
        AppletRuntime r22 = (AppletRuntime) r18.element;     // Catch: Throwable -> L83
    L81:
        ((d) r110).d(null);
        return r22;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r r23 = r12.f2105m;
        r r24 = r12.f2104l;
        Ref.ObjectRef r25 = r12.f2103k;
        Object r26 = r12.f2102j;
        Map r111 = r12.f2101i;
        SessionType r112 = r12.f2100h;
        String r113 = r12.g;
        String r114 = r12.f;
        String r27 = (String) r12.e;
        String r115 = (String) r12.d;
        Context r28 = (Context) r12.f2099c;
        String r29 = r12.f2098b;
        b r30 = r12.f2097a;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L21
        r10 = ": await completed successfully, result=true";
        Object r116 = r26;
        String r117 = r114;
        r r40 = r23;
        String r41 = r29;
        String r118 = r113;
        SessionType r119 = r112;
        String r120 = r27;
        Ref.ObjectRef r42 = r25;
        Context r43 = r28;
        b r44 = r30;
        Object r45 = r15;
        r r46 = r24;
        Object r47 = r14;
    L102:
        r22 = (AppletRuntime) r47;     // Catch: Throwable -> L53
        r r310 = r46;
        if (r22 == null) goto L55;
        String r48 = "runApplet " + r41 + r10;     // Catch: Throwable -> L53
        Intrinsics.checkNotNullParameter("WorkerRuntimeManager", "tag");     // Catch: Throwable -> L51
        t0.d r49 = c.f2846a;     // Catch: Throwable -> L51
        r110 = r116;
        if (r49 == null) goto L81;
        r49.i("WorkerRuntimeManager", r48);     // Catch: Throwable -> L51
        r110 = r116;
        goto L81
    L55:
        String r50 = "runApplet " + r41 + ": await timeout, will retry by current thread";     // Catch: Throwable -> L53
        Intrinsics.checkNotNullParameter("WorkerRuntimeManager", "tag");     // Catch: Throwable -> L51
        t0.d r51 = c.f2846a;     // Catch: Throwable -> L51
        if (r51 == null) goto L59;
        r51.e("WorkerRuntimeManager", r50);     // Catch: Throwable -> L51
    L59:
        Boxing.boxBoolean(r44.d.remove(r41, r40));     // Catch: Throwable -> L53
        Context r210 = r43;
        r18 = r42;
        r20 = r41;
        Map r211 = r111;
        String r212 = r115;
        String r213 = r120;
        SessionType r214 = r119;
        String r215 = r118;
        Object r52 = r116;
        String r216 = r117;
        r21 = r44;
        r r53 = r310;
    L93:
        WorkerRuntimeManager$runAppletWorker$2$2 r54 = new WorkerRuntimeManager$runAppletWorker$2$2(r20, r18, r21, r210, r212, r213, r216, r215, r214, r211, null);     // Catch: Throwable -> L85
        r12.f2097a = r21;     // Catch: Throwable -> L83
        r12.f2098b = r20;     // Catch: Throwable -> L83
        r12.f2099c = r52;     // Catch: Throwable -> L85
        r12.d = r18;     // Catch: Throwable -> L83
        r12.e = r53;     // Catch: Throwable -> L85
        r12.f = null;     // Catch: Throwable -> L83
        r12.g = null;     // Catch: Throwable -> L83
        r12.f2100h = null;     // Catch: Throwable -> L83
        r12.f2101i = null;     // Catch: Throwable -> L83
        r12.f2102j = null;     // Catch: Throwable -> L83
        r12.f2103k = null;     // Catch: Throwable -> L83
        r12.f2104l = null;     // Catch: Throwable -> L83
        r12.f2105m = null;     // Catch: Throwable -> L83
        r12.f2108p = 3;     // Catch: Throwable -> L85
        if (r21.c(r53, r54, r12) == r45) goto L105;
        r17 = r53;
        r11 = r52;
        goto L79
    L105:
        return r45;
    L85:
        th = th;
        r26 = r52;
    L87:
        r116 = r26;
    L89:
        ((d) r116).d(null);
        throw th;
    L51:
        th = th;
    L53:
        th = th;
        r26 = r116;
    L21:
        th = th;
        goto L87
    L23:
        kotlinx.coroutines.sync.a r55 = r12.f2102j;
        Map r56 = r12.f2101i;
        SessionType r57 = r12.f2100h;
        String r121 = r12.g;
        String r122 = r12.f;
        r120 = (String) r12.e;
        String r123 = (String) r12.d;
        Context r124 = (Context) r12.f2099c;
        r41 = r12.f2098b;
        r5 = r12.f2097a;
        ResultKt.throwOnFailure(r14);
        kotlinx.coroutines.sync.a r58 = r55;
        Map r125 = r56;
        r43 = r124;
        r119 = r57;
        String r59 = r123;
    L103:
        Ref.ObjectRef r60 = new Ref.ObjectRef();     // Catch: Throwable -> L63
        s r61 = j0.a();     // Catch: Throwable -> L63
        r40 = (r) r5.d.putIfAbsent(r41, r61);     // Catch: Throwable -> L63
        if (r40 == null) goto L65;
        String r62 = "await runApplet " + r41 + ", another thread is loading";     // Catch: Throwable -> L63
        Intrinsics.checkNotNullParameter("WorkerRuntimeManager", "tag");     // Catch: Throwable -> L63
        t0.d r63 = c.f2846a;     // Catch: Throwable -> L63
        if (r63 != null) goto L95;
    L36:
        WorkerRuntimeManager$runAppletWorker$2$1$awaitResult$1 r64 = new WorkerRuntimeManager$runAppletWorker$2$1$awaitResult$1(r40, null);     // Catch: Throwable -> L63
        r12.f2097a = r5;     // Catch: Throwable -> L63
        r12.f2098b = r41;     // Catch: Throwable -> L63
        r12.f2099c = r43;     // Catch: Throwable -> L63
        r12.d = r59;     // Catch: Throwable -> L63
        r12.e = r120;     // Catch: Throwable -> L63
        r12.f = r122;     // Catch: Throwable -> L63
        r12.g = r121;     // Catch: Throwable -> L63
        r12.f2100h = r119;     // Catch: Throwable -> L63
        r12.f2101i = r125;     // Catch: Throwable -> L63
        r12.f2102j = r58;     // Catch: Throwable -> L63
        r12.f2103k = r60;     // Catch: Throwable -> L63
        b r311 = r5;
        r12.f2104l = r61;     // Catch: Throwable -> L63
        r12.f2105m = r40;     // Catch: Throwable -> L63
        r12.f2108p = 2;     // Catch: Throwable -> L63
        kotlinx.coroutines.sync.a r126 = r58;
        Object r65 = e2.b(30000, r64, r12);     // Catch: Throwable -> L61
        r45 = r15;
        if (r65 == r45) goto L106;
        r47 = r65;
        r117 = r122;
        r44 = r311;
        r115 = r59;
        r42 = r60;
        r46 = r61;
        Map r217 = r125;
        r118 = r121;
        r111 = r217;
        r116 = r126;
        goto L102
    L106:
        return r45;
    L61:
        th = th;
    L62:
        r11 = r126;
    L88:
        r116 = r11;
        goto L89
    L95:
        r63.i("WorkerRuntimeManager", r62);     // Catch: Throwable -> L34
    L34:
        th = th;
        r11 = r58;
        goto L88
    L65:
        kotlinx.coroutines.sync.a r127 = r58;
        b r312 = r5;
        r45 = r15;
        r53 = r61;
        r18 = r60;
        r210 = r43;
        r212 = r59;
        r20 = r41;
        r215 = r121;
        r216 = r122;
        r213 = r120;
        r214 = r119;
        r211 = r125;
        r52 = r127;
        r21 = r312;
    L63:
        th = th;
        r126 = r58;
        goto L62
    L24:
        ResultKt.throwOnFailure(r14);
        r12.f2097a = r5;
        r12.f2098b = r31;
        r43 = r32;
        r12.f2099c = r43;
        r59 = r33;
        r12.d = r59;
        r12.e = r34;
        r122 = r35;
        r12.f = r122;
        r12.g = r36;
        r119 = r37;
        r12.f2100h = r119;
        r125 = r38;
        r12.f2101i = r125;
        d r66 = r5.f2143c;
        r12.f2102j = r66;
        r12.f2108p = 1;
        if (r66.c(r12) == r15) goto L77;
        r121 = r36;
        r120 = r34;
        r41 = r31;
        r58 = r66;
        goto L103
    L77:
        return r15;
    L83:
        th = th;
    L7:
        r12 = new WorkerRuntimeManager$runAppletWorker$1(r5, r39);
        goto L8
    }

    public final Object c(r r5, Function1 r10, ContinuationImpl r11) {
        if ((r11 instanceof WorkerRuntimeManager$safeRun$1) == false) goto L7;
        WorkerRuntimeManager$safeRun$1 r12 = (WorkerRuntimeManager$safeRun$1) r11;
        int r13 = r12.d;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.d = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.f2136b;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.d;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        r5 = r12.f2135a;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L14
    L22:
        ((s) r5).N(r14);     // Catch: Exception -> L14
    L29:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        r12.f2135a = r5;     // Catch: Exception -> L14
        r12.d = 1;     // Catch: Exception -> L14
        WorkerRuntimeManager$runAppletWorker$2$2 r17 = (WorkerRuntimeManager$runAppletWorker$2$2) r10;     // Catch: Exception -> L14
        r17.getClass();     // Catch: Exception -> L14
        r14 = ((WorkerRuntimeManager$runAppletWorker$2$2) r17.create(r12)).invokeSuspend(Unit.INSTANCE);     // Catch: Exception -> L14
        if (r14 != r15) goto L22;
        return r15;
    L14:
        e = move-exception;
        String r18 = f0.d(e, new StringBuilder("Exception safeRun: "), "WorkerRuntimeManager");
        t0.d r19 = c.f2846a;
        if (r19 == null) goto L27;
        r19.e("WorkerRuntimeManager", r18, e);
    L27:
        ((s) r5).N(null);
    L7:
        r12 = new WorkerRuntimeManager$safeRun$1(this, r11);
        goto L8
    }

    public final void d(String r5) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        AppletRuntime r10 = (AppletRuntime) this.f2141a.remove(r5);
        if (r10 == null) goto L5;
        r10.v();
    L5:
        k1.b r11 = k1.b.f18581a;
        monitor-enter(r11);
        Intrinsics.checkNotNullParameter(r5, "appletId");     // Catch: Throwable -> L12
        String r12 = "terminateApp, appletId:" + r5;     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter("AppletAppManagerService", "tag");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r12, "msg");     // Catch: Throwable -> L12
        a1.a.f43a.i("AppletAppManagerService", r12);     // Catch: Throwable -> L12
        k1.a r13 = (k1.a) k1.b.f18582b.remove(r5);     // Catch: Throwable -> L12
        if (r13 == null) goto L14;
        r13.f18579a.a();     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L14:
        monitor-exit(r11);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
