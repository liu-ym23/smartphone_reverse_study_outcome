package com.bytedance.ai.core.manager;

import android.content.Context;
import android.os.Trace;
import com.bytedance.ai.core.base.SessionType;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.JSWorkerRuntime;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.utils.g;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import h5.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.MutexImpl;
import m5.i;
import m5.i1;
import m5.j;
import m5.x;
import m5.y;
import m5.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class WorkerRuntimeManager {
    public static final /* synthetic */ int e = 0;
    public final ConcurrentHashMap<String, AppletRuntime> a;
    public final ConcurrentHashMap<String, AppletRuntime> b;
    public final MutexImpl c;
    public final ConcurrentHashMap<String, CompletableDeferred<AppletRuntime>> d;

    public static final class a {
    }

    static {
    }

    public WorkerRuntimeManager() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = kotlinx.coroutines.sync.b.a();
        this.d = new ConcurrentHashMap();
    }

    public final void d(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        AppletRuntime r0 = this.a.remove(r10);
        if (r0 == null) goto L5;
        r0.G();
    L5:
        b3.b r1 = b3.b.a;
        monitor-enter(r1);
        Intrinsics.checkNotNullParameter(r10, "appletId");     // Catch: Throwable -> L12
        com.bytedance.ai.applet.base.log.b r11 = com.bytedance.ai.applet.base.log.a.a;     // Catch: Throwable -> L12
        com.bytedance.ai.applet.base.log.a.c("AppletAppManagerService", "terminateApp, appletId:" + r10);     // Catch: Throwable -> L12
        b3.a r12 = b3.b.b.remove(r10);     // Catch: Throwable -> L12
        if (r12 == null) goto L10;
        r12.c.destroy();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r1);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final <T> Object c(CompletableDeferred<T> r10, Function1<? super Continuation<? super T>, ? extends Object> r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof WorkerRuntimeManager$safeRun$1) == false) goto L7;
        WorkerRuntimeManager$safeRun$1 r0 = (WorkerRuntimeManager$safeRun$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L16;
        if (r15 != 1) goto L15;
        r10 = (CompletableDeferred) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L22
    L20:
        r10.complete(r13);     // Catch: Exception -> L22
    L25:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r13);
        r0.L$0 = r10;     // Catch: Exception -> L22
        r0.label = 1;     // Catch: Exception -> L22
        r13 = r11.invoke(r0);     // Catch: Exception -> L22
        if (r13 != r14) goto L20;
        return r14;
    L22:
        e = move-exception;
        g.a.e("WorkerRuntimeManager", "Exception safeRun: " + e.getMessage(), e);
        r10.complete(null);
    L7:
        r0 = new WorkerRuntimeManager$safeRun$1(this, r12);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2 */
    public final Object b(String r24, Context r25, String r26, String r27, String r28, String r29, SessionType r30, Map<String, Object> r31, Continuation<? super AppletRuntime> r32) {
        if ((r32 instanceof WorkerRuntimeManager$runAppletWorker$1) == false) goto L7;
        WorkerRuntimeManager$runAppletWorker$1 r10 = (WorkerRuntimeManager$runAppletWorker$1) r32;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        WorkerRuntimeManager$runAppletWorker$1 r0 = r10;
        Object r12 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r13 = r0.label;
        if (r13 == 0) goto L24;
        if (r13 == 1) goto L23;
        if (r13 == 2) goto L18;
        if (r13 != 3) goto L17;
        CompletableDeferred<AppletRuntime> r1 = (CompletableDeferred) r0.L$3;
        Ref.ObjectRef r15 = (Ref.ObjectRef) r0.L$2;
        kotlinx.coroutines.sync.a r16 = (kotlinx.coroutines.sync.a) r0.L$1;
        String r17 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L80
        Ref.ObjectRef r18 = r15;
        kotlinx.coroutines.sync.a r19 = r16;
        WorkerRuntimeManager r20 = this;
        CompletableDeferred<AppletRuntime> r21 = r1;
        Continuation r22 = null;
    L66:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new WorkerRuntimeManager$runAppletWorker$2$3(r20, r17, r21, r22), 3, null);     // Catch: Throwable -> L69
        JobKt.ensureActive(r0.getContext());     // Catch: Throwable -> L69
        AppletRuntime r23 = (AppletRuntime) r18.element;     // Catch: Throwable -> L69
        kotlinx.coroutines.sync.a r110 = r19;
    L67:
        r110.unlock(r22);
        return r23;
    L69:
        th = th;
    L70:
        ?? r33 = r19;
    L83:
        r33.unlock(r22);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        CompletableDeferred<AppletRuntime> r34 = (CompletableDeferred) r0.L$11;
        CompletableDeferred<AppletRuntime> r35 = (CompletableDeferred) r0.L$10;
        Ref.ObjectRef r36 = (Ref.ObjectRef) r0.L$9;
        kotlinx.coroutines.sync.a r37 = (kotlinx.coroutines.sync.a) r0.L$8;
        Map<String, Object> r38 = (Map) r0.L$7;
        SessionType r39 = (SessionType) r0.L$6;
        String r111 = (String) r0.L$5;
        String r112 = (String) r0.L$4;
        String r113 = (String) r0.L$3;
        String r114 = (String) r0.L$2;
        Context r40 = (Context) r0.L$1;
        String r41 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L21
        kotlinx.coroutines.sync.a r42 = r37;
        String r115 = r113;
        String r43 = r41;
        r18 = r36;
        Object r44 = r14;
        CompletableDeferred<AppletRuntime> r116 = r34;
        Context r45 = r40;
    L96:
        r23 = (AppletRuntime) r12;     // Catch: Throwable -> L50
        kotlinx.coroutines.sync.a r210 = r42;
        if (r23 == null) goto L42;
        g.a.i("WorkerRuntimeManager", "runApplet " + r43 + ": await completed successfully, result=true");     // Catch: Throwable -> L48
        r110 = r210;
        r22 = null;
        goto L67
    L42:
        Object r117 = r44;
        g.a.e("WorkerRuntimeManager", "runApplet " + r43 + ": await timeout, will retry by current thread");     // Catch: Throwable -> L48
        WorkerRuntimeManager r46 = this;
        Boxing.boxBoolean(r46.d.remove(r43, r116));     // Catch: Throwable -> L46
        r19 = r210;
        Map<String, Object> r118 = r38;
        String r47 = r115;
        CompletableDeferred<AppletRuntime> r119 = r35;
        String r211 = r114;
        String r120 = r43;
        String r48 = r211;
        String r212 = r112;
        SessionType r121 = r39;
        String r49 = r212;
    L92:
        Object r50 = r117;
        String r51 = r47;
        String r52 = r49;
        String r53 = r111;
        SessionType r122 = r121;
        Map<String, Object> r123 = r118;
        CompletableDeferred<AppletRuntime> r124 = r119;
        String r125 = r120;
        WorkerRuntimeManager$runAppletWorker$2$2 r54 = new WorkerRuntimeManager$runAppletWorker$2$2(r120, r18, this, r45, r48, r51, r52, r53, r122, r123, null);     // Catch: Throwable -> L73
        r0.L$0 = r125;     // Catch: Throwable -> L73
        r0.L$1 = r19;     // Catch: Throwable -> L73
        r0.L$2 = r18;     // Catch: Throwable -> L73
        r21 = r124;
        r0.L$3 = r21;     // Catch: Throwable -> L73
        r22 = null;
        r0.L$4 = null;     // Catch: Throwable -> L71
        r0.L$5 = null;     // Catch: Throwable -> L71
        r0.L$6 = null;     // Catch: Throwable -> L71
        r0.L$7 = null;     // Catch: Throwable -> L71
        r0.L$8 = null;     // Catch: Throwable -> L71
        r0.L$9 = null;     // Catch: Throwable -> L71
        r0.L$10 = null;     // Catch: Throwable -> L71
        r0.L$11 = null;     // Catch: Throwable -> L71
        r0.label = 3;     // Catch: Throwable -> L71
        r20 = this;
        if (r20.c(r21, r54, r0) != r50) goto L65;
        return r50;
    L65:
        r17 = r125;
        r19 = r19;
    L71:
        th = th;
    L73:
        th = th;
    L75:
        r22 = null;
    L76:
        th = th;
    L46:
        th = th;
    L47:
        kotlinx.coroutines.sync.a r55 = r210;
    L54:
        r22 = null;
        r33 = r55;
    L48:
        th = th;
        r46 = this;
    L50:
        th = th;
        r46 = this;
        r210 = r42;
    L21:
        th = th;
        r22 = null;
        ?? r56 = r37;
    L82:
        r33 = r56;
        goto L83
    L23:
        kotlinx.coroutines.sync.a r57 = (kotlinx.coroutines.sync.a) r0.L$8;
        Map<String, Object> r58 = (Map) r0.L$7;
        SessionType r59 = (SessionType) r0.L$6;
        r111 = (String) r0.L$5;
        String r126 = (String) r0.L$4;
        String r127 = (String) r0.L$3;
        String r128 = (String) r0.L$2;
        r45 = (Context) r0.L$1;
        r43 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);
        String r60 = r128;
        Map<String, Object> r129 = r58;
        r47 = r127;
        r121 = r59;
        r49 = r126;
        kotlinx.coroutines.sync.a r61 = r57;
    L28:
        r18 = new Ref.ObjectRef();     // Catch: Throwable -> L80
        r117 = r14;
        CompletableDeferred<AppletRuntime> r62 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);     // Catch: Throwable -> L78
        r116 = this.d.putIfAbsent(r43, r62);     // Catch: Throwable -> L80
        if (r116 != null) goto L85;
        r46 = this;
        r19 = r61;
        r118 = r129;
        r120 = r43;
        r48 = r60;
        r119 = r62;
        goto L92
    L85:
        g.a.i("WorkerRuntimeManager", "await runApplet " + r43 + ", another thread is loading");     // Catch: Throwable -> L52
        WorkerRuntimeManager$runAppletWorker$2$1$awaitResult$1 r63 = new WorkerRuntimeManager$runAppletWorker$2$1$awaitResult$1(r116, null);     // Catch: Throwable -> L52
        r0.L$0 = r43;     // Catch: Throwable -> L52
        r0.L$1 = r45;     // Catch: Throwable -> L52
        r0.L$2 = r60;     // Catch: Throwable -> L52
        r0.L$3 = r47;     // Catch: Throwable -> L52
        r0.L$4 = r49;     // Catch: Throwable -> L52
        r0.L$5 = r111;     // Catch: Throwable -> L52
        r0.L$6 = r121;     // Catch: Throwable -> L52
        r0.L$7 = r129;     // Catch: Throwable -> L52
        r0.L$8 = r61;     // Catch: Throwable -> L52
        r0.L$9 = r18;     // Catch: Throwable -> L52
        r0.L$10 = r62;     // Catch: Throwable -> L52
        r0.L$11 = r116;     // Catch: Throwable -> L52
        r0.label = 2;     // Catch: Throwable -> L52
        String r130 = r60;
        r12 = TimeoutKt.c(30000, r63, r0);     // Catch: Throwable -> L52
        r44 = r117;
        if (r12 != r44) goto L37;
        return r44;
    L37:
        r42 = r61;
        r35 = r62;
        r115 = r47;
        r38 = r129;
        r114 = r130;
        SessionType r213 = r121;
        r112 = r49;
        r39 = r213;
    L52:
        th = th;
        r46 = this;
        r55 = r61;
    L78:
        th = th;
        r22 = null;
        r33 = r61;
        goto L83
    L24:
        ResultKt.throwOnFailure(r12);
        kotlinx.coroutines.sync.a r64 = this.c;
        r0.L$0 = r24;
        r45 = r25;
        r0.L$1 = r45;
        r0.L$2 = r26;
        r47 = r27;
        r0.L$3 = r47;
        r49 = r28;
        r0.L$4 = r49;
        r111 = r29;
        r0.L$5 = r111;
        r121 = r30;
        r0.L$6 = r121;
        r129 = r31;
        r0.L$7 = r129;
        r0.L$8 = r64;
        r0.label = 1;
        if (r64.a(null, r0) != r14) goto L27;
        return r14;
    L27:
        r61 = r64;
        r60 = r26;
        r43 = r24;
    L80:
        th = th;
        r22 = null;
        r56 = r13;
    L7:
        r10 = new WorkerRuntimeManager$runAppletWorker$1(this, r32);
        goto L8
    }

    public static final Object a(WorkerRuntimeManager r25, String r26, Context r27, String r28, String r29, String r30, String r31, SessionType r32, Map r33, Continuation r34) {
        String r1 = r26;
        r25.getClass();
        if ((r34 instanceof WorkerRuntimeManager$runAppletWorkerInner$1) == false) goto L7;
        WorkerRuntimeManager$runAppletWorkerInner$1 r10 = (WorkerRuntimeManager$runAppletWorkerInner$1) r34;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        long r15 = r10.J$1;
        long r16 = r10.J$0;
        String r17 = (String) r10.L$10;
        final String r18 = (String) r10.L$9;
        Ref.ObjectRef r19 = (Ref.ObjectRef) r10.L$8;
        Map r110 = (Map) r10.L$7;
        SessionType r111 = (SessionType) r10.L$6;
        String r112 = (String) r10.L$5;
        String r113 = (String) r10.L$4;
        String r114 = (String) r10.L$3;
        String r115 = (String) r10.L$2;
        Context r20 = (Context) r10.L$1;
        String r21 = (String) r10.L$0;
        ResultKt.throwOnFailure(r12);
        Context r0 = r20;
        r1 = r21;
        Object r22 = r12;
        String r23 = r17;
        long r24 = r16;
        long r35 = r15;
    L66:
        Applet r36 = (Applet) r22;
        if (r36 != null) goto L75;
        String r37 = "Applet " + r1 + " not found, can't launch main thread";
        g r38 = g.a;
        r38.e("applet_lifecycle", "<parseMessage>< runapplet: " + r37);
        r38.e("WorkerRuntimeManager", "runAppletWorkerInner: loadApplet FAILED, elapsed=" + (System.currentTimeMillis() - r24) + "ms");
        com.bytedance.ai.monitor.b.d("applet_run_applet_result", new d(r1, r113, r112, r37));
        Object r39 = r19.element;
        if (((AppletRuntime) r39) == null) goto L71;
        r25.b.put(r1, (AppletRuntime) r39);
        r25.d(r1);
    L71:
        if (r18 == null) goto L74;
        if (r23 == null) goto L74;
        i1 r40 = y0.a;
        y0.b(r18, r37, AppletErrorCode.APPLET_NOT_FOUND.getType(), r23);
    L74:
        Trace.endSection();
    L122:
        return null;
    L75:
        String r116 = r114;
        SessionType r310 = r111;
        g r117 = g.a;
        String r311 = r115;
        Map r118 = r110;
        Context r119 = r0;
        r117.i("WorkerRuntimeManager", "runAppletWorkerInner: loadApplet SUCCESS, loadTime=" + (System.currentTimeMillis() - r35) + "ms, totalElapsed=" + (System.currentTimeMillis() - r24) + "ms, versionCode=" + r36.c);
        if (r18 == null) goto L90;
        if (r23 == null) goto L90;
        String r41 = r36.B;
        if (r41 != null) goto L81;
        r41 = "";
    L81:
        String r42 = r36.d;
        if (r42 != null) goto L84;
        r42 = "";
    L84:
        i1 r43 = y0.a;
        final Map r44 = MapsKt.mapOf(new Pair[]{TuplesKt.to("applet_res_from", r41), TuplesKt.to("scm_version", r42), TuplesKt.to("version_code", Boxing.boxLong(r36.c)), TuplesKt.to("packageId", r36.b)});
        Intrinsics.checkNotNullParameter(r18, "traceId");
        Intrinsics.checkNotNullParameter(r23, "eventType");
        Intrinsics.checkNotNullParameter(r44, "eventInfo");
        final long r120 = System.currentTimeMillis();
        g r45 = r117;
        r45.d("AppletEventMonitorManager", "onLoadAppletEnd: " + r18 + ", " + r23);
        if (Intrinsics.areEqual(r23, "applet_widget_timeline_full") == false) goto L88;
        y0.r(new x(r18, r120, r44));
    L91:
        Object r46 = r19.element;
        if (r46 == null) goto L97;
        long r121 = ((AppletRuntime) r46).h.c;
        Ref.ObjectRef r47 = r19;
        if (r121 != r36.c) goto L98;
        long r48 = System.currentTimeMillis() - r24;
        com.bytedance.ai.monitor.b.d("applet_run_applet_result", new c(r1, r113, r112, r48));
        Trace.endSection();
        r45.i("WorkerRuntimeManager", "runAppletWorkerInner END: reused existing runtime, totalTime=" + r48 + "ms");
        return r47.element;
    L98:
        StringBuilder r49 = new StringBuilder("runAppletWorkerInner: need to create new runtime, reason=");
        if (r47.element != null) goto L101;
        String r50 = "no existing runtime";
    L102:
        r49.append(r50);
        r49.append(", elapsed=");
        r49.append(System.currentTimeMillis() - r24);
        r49.append("ms");
        r45.i("WorkerRuntimeManager", r49.toString());
        Object r51 = r47.element;
        if (((AppletRuntime) r51) == null) goto L106;
        r25.b.put(r1, (AppletRuntime) r51);
        r25.d(r1);
    L106:
        if (e.a(r36.h, "2.0") < 0) goto L116;
        String r52 = r36.P;
        if (r52 != null) goto L110;
    L113:
        boolean r122 = true;
    L114:
        if (r122 == false) goto L116;
        r45.e("WorkerRuntimeManager", "runtimeEntry is empty");
        boolean r123 = false;
    L117:
        if (r123 == true) goto L124;
        if (r18 == 0) goto L121;
        if (r23 == null) goto L121;
        String r53 = "The runtimeEntry of " + r1 + " not found";
        i1 r54 = y0.a;
        y0.b(r18, r53, AppletErrorCode.RUNTIME_ENTRY_EMPTY.getType(), r23);
    L121:
        Trace.endSection();
        goto L122
    L124:
        if (c3.b.a(r36.C) == false) goto L137;
        r45.i("WorkerRuntimeManager", "runAppletWorkerInner: need to create lynx runtime, appletId=" + r1);
        b3.b r55 = b3.b.a;
        monitor-enter(r55);
        Intrinsics.checkNotNullParameter(r119, "app");     // Catch: Throwable -> L134
        Intrinsics.checkNotNullParameter(r36, "applet");     // Catch: Throwable -> L134
        if (r55.a(r36.o()) != null) goto L133;
        com.bytedance.ai.applet.base.log.b r56 = com.bytedance.ai.applet.base.log.a.a;     // Catch: Throwable -> L134
        com.bytedance.ai.applet.base.log.a.c("AppletAppManagerService", "launchApp, appletId:" + r36.o());     // Catch: Throwable -> L134
        b3.a r57 = new b3.a(r119, r36, r118);     // Catch: Throwable -> L134
        b3.b.b.put(r36.o(), r57);     // Catch: Throwable -> L134
        monitor-exit(r55);
        AppletRuntime r58 = r57.d;
    L138:
        AppletRuntime r59 = r58;
        r59.x();
        long r60 = System.currentTimeMillis() - r24;
        r45.i("WorkerRuntimeManager", "runAppletWorkerInner: created new runtime type=" + r59.getClass().getSimpleName() + ", elapsed=" + r60 + "ms");
        r25.a.put(r1, r59);
        AppletRuntimeManager.INSTANCE.getClass();
        r59.j = AppletRuntimeManager.e;
        com.bytedance.ai.monitor.b.d("applet_run_applet_result", new b(r1, r113, r112, r60, r47));
        Trace.endSection();
        if (r311 == null) goto L144;
        if (r310 != null) goto L142;
        SessionType r124 = SessionType.CHATUI;
    L143:
        r59.m(r311, r116, r124);
        goto L144
    L142:
        r124 = r310;
    L144:
        r45.i("WorkerRuntimeManager", "runAppletWorkerInner END: created new runtime, totalTime=" + (System.currentTimeMillis() - r24) + "ms");
        return r59;
    L133:
        throw new IllegalArgumentException("appletId:" + r36.o() + " is already installed");     // Catch: Throwable -> L134
    L134:
        th = move-exception;
        throw th;
    L137:
        r58 = new JSWorkerRuntime(r119, r36, r118);
        goto L138
    L110:
        if (r52.length() == 0) goto L113;
        r122 = false;
    L116:
        r123 = true;
        goto L117
    L101:
        r50 = "version changed (" + ((AppletRuntime) r47.element).h.c + " -> " + r36.c + ')';
        goto L102
    L97:
        r47 = r19;
        goto L98
    L88:
        if (Intrinsics.areEqual(r23, "applet_page_timeline_full") == false) goto L91;
        y0.r(new y(r18, r120, r44));
    L90:
        r45 = r117;
        goto L91
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        long r61 = System.currentTimeMillis();
        g r62 = g.a;
        r62.i("WorkerRuntimeManager", "runAppletWorkerInner START: appletId=" + r1 + ", msgId=" + r30 + ", thread=" + ThreadMethodProxy.currentThread().getName());
        Trace.beginSection("runApplet");
        com.bytedance.ai.monitor.b.d("applet_run_applet", new com.bytedance.ai.core.manager.a(r1, r30, r29, r31));
        Ref.ObjectRef r125 = new Ref.ObjectRef();
        r125.element = r25.a.get(r1);
        StringBuilder r126 = new StringBuilder("runAppletWorkerInner: check existing runtime, found=");
        if (r125.element == null) goto L17;
        boolean r127 = true;
    L18:
        r126.append(r127);
        r126.append(", terminated=");
        AppletRuntime r128 = (AppletRuntime) r125.element;
        if (r128 == null) goto L21;
        Boolean r129 = Boxing.boxBoolean(r128.H());
    L22:
        r126.append(r129);
        r126.append(", elapsed=");
        r126.append(System.currentTimeMillis() - r61);
        r126.append("ms");
        r62.i("WorkerRuntimeManager", r126.toString());
        AppletRuntime r130 = (AppletRuntime) r125.element;
        if (r130 != null) goto L25;
    L27:
        boolean r131 = false;
    L28:
        if (r131 == false) goto L30;
        r25.d(r26);
        String r132 = null;
        r125.element = null;
    L31:
        if (r33 == null) goto L33;
        Object r133 = r33.get("trace_id");
    L35:
        if ((r133 instanceof String) == false) goto L37;
        String r134 = (String) r133;
    L38:
        if (r134 != null) goto L40;
        r134 = r132;
    L40:
        if (r33 == null) goto L42;
        Object r135 = r33.get("eventName");
    L44:
        if ((r135 instanceof String) == false) goto L46;
        String r136 = (String) r135;
    L47:
        if (r136 != null) goto L49;
        r136 = r132;
    L49:
        if (r134 == null) goto L57;
        if (r136 == null) goto L57;
        i1 r137 = y0.a;
        Intrinsics.checkNotNullParameter(r134, "traceId");
        Intrinsics.checkNotNullParameter(r136, "eventType");
        final long r138 = System.currentTimeMillis();
        StringBuilder r139 = new StringBuilder("onLoadAppletStart: ");
        final String r63 = r134;
        r139.append(r63);
        Object r140 = r13;
        r139.append(", ");
        r139.append(r136);
        r62.d("AppletEventMonitorManager", r139.toString());
        if (Intrinsics.areEqual(r136, "applet_widget_timeline_full") == false) goto L55;
        y0.r(new i(r63, r138));
    L58:
        StringBuilder r141 = new StringBuilder("runAppletWorkerInner: start loading applet, elapsed=");
        String r142 = r136;
        r141.append(System.currentTimeMillis() - r61);
        r141.append("ms");
        r62.i("WorkerRuntimeManager", r141.toString());
        long r143 = System.currentTimeMillis();
        AIManager r64 = AIManager.a;
        if (r30 == null) goto L61;
        Map<String, Object> r65 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message_id", r30)});
    L62:
        r10.L$0 = r1;
        r10.L$1 = r27;
        r10.L$2 = r28;
        r10.L$3 = r29;
        r10.L$4 = r30;
        r10.L$5 = r31;
        r10.L$6 = r32;
        r10.L$7 = r33;
        r10.L$8 = r125;
        r10.L$9 = r63;
        r10.L$10 = r142;
        r10.J$0 = r61;
        r10.J$1 = r143;
        String r144 = r63;
        r10.label = 1;
        Object r66 = r64.D(r1, r65, r10);
        Object r67 = r140;
        if (r66 == r67) goto L147;
        r0 = r27;
        r22 = r66;
        r23 = r142;
        r18 = r144;
        r112 = r31;
        r114 = r29;
        r19 = r125;
        r113 = r30;
        r111 = r32;
        r35 = r143;
        r115 = r28;
        r110 = r33;
        r24 = r61;
        goto L66
    L147:
        return r67;
    L61:
        r65 = null;
        goto L62
    L55:
        if (Intrinsics.areEqual(r136, "applet_page_timeline_full") == false) goto L58;
        y0.r(new j(r63, r138));
    L57:
        r140 = r13;
        r63 = r134;
        goto L58
    L46:
        r136 = r132;
        goto L47
    L42:
        r135 = r132;
        goto L44
    L37:
        r134 = r132;
        goto L38
    L33:
        r133 = r132;
        goto L35
    L30:
        r132 = null;
        goto L31
    L25:
        if (r130.H() != true) goto L27;
        r131 = true;
        goto L28
    L21:
        r129 = null;
        goto L22
    L17:
        r127 = false;
    L7:
        r10 = new WorkerRuntimeManager$runAppletWorkerInner$1(r25, r34);
        goto L8
    }
}
