package com.larus.dora.impl.assistant;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import gd9.i;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import me.ele.lancet.base.annotations.Skip;
import vk4.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraWifiIntentClientImpl {
    public static final DoraWifiIntentClientImpl a = null;
    public static final Object b = null;
    public static final Set<String> c = null;
    public static boolean d;

    public static final class a {
        public final e a;
        public final long b;
        public final long c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            long r3 = this.c;
            return r2 + ((int) (r3 ^ (r3 >>> 32)));
        }

        public final String toString() {
            return "WifiSwitchOperationResult(result=" + this.a + ", latencyMs=" + this.b + ", effectiveLatencyMs=" + this.c + ')';
        }

        public a(e r2, long r3, long r5) {
            Intrinsics.checkNotNullParameter(r2, "result");
            this.a = r2;
            this.b = r3;
            this.c = r5;
        }
    }

    public DoraWifiIntentClientImpl() {
    }

    static {
        a = new DoraWifiIntentClientImpl();
        b = new Object();
        c = new LinkedHashSet();
        vk4.e r0 = vk4.e.d.a;
        h r1 = new d();
        ((CopyOnWriteArraySet) r0.c).add(r1);
    }

    public static e b() {
        Set<String> r0 = c;
        if ((!r0.isEmpty()) == false) goto L7;
        FLogger.a.i("DoraWifiIntentClient", "releaseWifi keep enabled, ownerCount=" + r0.size());
        return null;
    L7:
        if (d == true) goto L11;
        FLogger.a.i("DoraWifiIntentClient", "releaseWifi ignored, wifi was not opened by client");
        return null;
    L11:
        if (vk4.e.d.a.e == 0) goto L14;
        FLogger.a.i("DoraWifiIntentClient", "releaseWifi pending: WiFi scenes still active");
        return null;
    L14:
        e r1 = d(false).a;
        if (r1.a == false) goto L17;
        d = false;
        FLogger.a.i("DoraWifiIntentClient", "releaseWifi success, closed by client");
    L18:
        return r1;
    L17:
        FLogger.a.w("DoraWifiIntentClient", "releaseWifi close failed, errorCode=" + r1.b);
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.content.Context, com.larus.nova.NovaApplication, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.content.BroadcastReceiver, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.dora.impl.assistant.DoraWifiIntentClientImpl$setWifiEnabledAndWaitEffective$receiver$1] */
    public static a d(final boolean r23) {
        i r0 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r0);
        ?? r2 = r0.getApplication();
        r2.getClass();
        final CountDownLatch r3 = new CountDownLatch(1);
        final AtomicLong r5 = new AtomicLong(-1);
        PthreadHandlerThreadV2 r8 = new PthreadHandlerThreadV2("DoraWifiIntentStateWatcher");
        ThreadMethodProxy.start(r8);
        ?? r9 = new DoraWifiIntentClientImpl$setWifiEnabledAndWaitEffective$receiver$1(r23, r5, r3);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        a(r2, r9, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"), new Handler(r8.getLooper()));     // Catch: Throwable -> L8
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
        boolean r11 = true;
    L11:
        Throwable r6 = Result.exceptionOrNull-impl(r4);
        if (r6 == null) goto L14;
        FLogger.a.w("DoraWifiIntentClient", "register wifi state receiver failed, enabled=" + r23, r6);
    L14:
        long r13 = SystemClock.elapsedRealtime();
        com.larus.dora.impl.assistant.a.a.getClass();
        FLogger r15 = FLogger.a;
        r15.i("AssistantIntentDispatcher", "setWifiEnabled start, enabled=" + r23);
        IAgentAppIntentIDL r7 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        WifiManager r10 = null;
        if (r7 != null) goto L96;
        r15.w("AssistantIntentDispatcher", "setWifiEnabled failed, ipc is null, enabled=" + r23);
        int r12 = e.d;
        e r14 = e.a.a("ipc_null", "IAgentAppIntentIDL is null");
    L17:
        e r16 = r14;
        if (r23 == true) goto L33;
    L35:
        long r17 = SystemClock.elapsedRealtime() - r13;
        if (r16.a == false) goto L68;
        Intrinsics.checkNotNull(r2);
        Object r18 = r2.getSystemService("wifi");
        if ((r18 instanceof WifiManager) == false) goto L40;
        r10 = (WifiManager) r18;
    L40:
        if (r10 == null) goto L42;
        int r20 = r10.getWifiState();
    L43:
        if (r23 == true) goto L45;
        boolean r110 = true;
        if (r20 == 1) goto L51;
    L50:
        r110 = false;
    L51:
        if (r110 == false) goto L53;
        e r111 = r16;
        PthreadHandlerThreadV2 r112 = r8;
        ?? r113 = r9;
        r5.compareAndSet(-1, SystemClock.elapsedRealtime());
    L63:
        long r114 = r17;
        ?? r115 = r113;
    L64:
        long r21 = r5.get();
        ?? r116 = r115;
        if (r21 == (-1)) goto L69;
        long r22 = r21 - r13;
        ?? r117 = r115;
    L70:
        if (r11 == false) goto L88;
        ?? r24 = r117;
        ReceiverRegisterLancet.loge(r24, false);     // Catch: Throwable -> L83
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L104;
        r2.unregisterReceiver(r24);     // Catch: Throwable -> L83
    L81:
        Object r25 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L83
    L85:
        Throwable r26 = Result.exceptionOrNull-impl(r25);
        if (r26 == null) goto L88;
        FLogger.a.w("DoraWifiIntentClient", "unregister wifi state receiver failed, enabled=" + r23, r26);
        goto L88
    L104:
    L78:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r24.toString());     // Catch: Throwable -> L83
        e.printStackTrace();     // Catch: Throwable -> L83
        goto L81
    L75:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r24, r2) == false) goto L81;
        r2.unregisterReceiver(r24);     // Catch: Exception -> L78 Throwable -> L83
    L83:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
    L88:
        r112.quitSafely();
        if (r111.a == true) goto L91;
    L93:
        e r28 = r111;
    L94:
        FLogger.a.i("DoraWifiIntentClient", "setWifiEnabled result, enabled=" + r23 + ", success=" + r28.a + ", latencyMs=" + r114 + ", effectiveLatencyMs=" + r22 + ", errorCode=" + r28.b);
        return new a(r28, r114, r22);
    L91:
        if (r22 != (-1)) goto L93;
        int r30 = e.d;
        r28 = e.a.a("wifi_state_effective_timeout", "wifi state not changed to target enabled=" + r23);
    L69:
        r22 = -1;
        r117 = r116;
        goto L70
    L53:
        r111 = r16;
        r112 = r8;
        ?? r118 = r9;
        r113 = r118;
        if (r11 == false) goto L63;
        r114 = r17;
        Object r31 = Result.constructor-impl(Boolean.valueOf(r3.await(RangesKt.coerceAtLeast(5000 - r17, 0), TimeUnit.MILLISECONDS)));     // Catch: Throwable -> L58
    L60:
        Throwable r32 = Result.exceptionOrNull-impl(r31);
        r115 = r118;
        if (r32 == null) goto L64;
        FLogger.a.w("DoraWifiIntentClient", "wait wifi state effective failed, enabled=" + r23, r32);
        r115 = r118;
    L58:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r31 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L60
    L45:
        if (r20 != 3) goto L50;
        r110 = true;
        goto L51
    L42:
        r20 = 4;
        goto L43
    L68:
        r111 = r16;
        r114 = r17;
        r112 = r8;
        r116 = r9;
        goto L69
    L33:
        if (r16.a == false) goto L35;
        d = true;
        goto L35
    L96:
        boolean r34 = r7.setWifiEnabled(r23);     // Catch: Throwable -> L24
        r15.i("AssistantIntentDispatcher", "setWifiEnabled returns " + r34 + ", enabled=" + r23);     // Catch: Throwable -> L24
        if (r34 == false) goto L21;
        e r35 = new e(true, null, null);     // Catch: Throwable -> L24
    L22:
        Object r36 = Result.constructor-impl(r35);     // Catch: Throwable -> L24
    L26:
        Throwable r37 = Result.exceptionOrNull-impl(r36);
        if (r37 == null) goto L30;
        FLogger.a.w("AssistantIntentDispatcher", "setWifiEnabled failed, enabled=" + r23, r37);
        int r38 = e.d;
        r36 = e.a.a("ipc_exception", r37.getMessage());
    L30:
        r14 = (e) r36;
        goto L17
    L21:
        int r40 = e.d;     // Catch: Throwable -> L24
        r35 = e.a.a("appintent_failed", "setWifiEnabled returns false");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r36 = Result.constructor-impl(ResultKt.createFailure(th));
    L6:
        th = th;
        r11 = true;
    L10:
        Result.Companion r119 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L8:
        th = th;
        r11 = false;
        goto L10
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r9, DoraWifiIntentClientImpl$setWifiEnabledAndWaitEffective$receiver$1 r10, IntentFilter r11, Handler r12) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L30;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L30:
    L24:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L29;
        ReceiverRegisterCrashOptimizer.registerReceiver(r10, r11, null, r12);
        return;
    L29:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L9;
    L22:
        r9.registerReceiver(r10, r11, null, r12);     // Catch: Exception -> L24
        return;
    L9:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r11) == false) goto L22;
        int r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r10, r11, 0, null, r12, 4, r9).result;     // Catch: Exception -> L24
        if (r1 != 1) goto L13;
        r9.registerReceiver(r10, r11, null, r12);     // Catch: Exception -> L24
        return;
    L13:
        if (r1 != 2) goto L15;
        new Intent();     // Catch: Exception -> L24
        return;
    L15:
        if (r1 == 3) goto L31;
        r9.registerReceiver(r10, r11, null, r12);     // Catch: Exception -> L24
        return;
    }

    public static void c(String r7, e r8, long r9, long r11) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        DoraBuryPointManager r1 = DoraBuryPointManager.a;     // Catch: Throwable -> L11
        Pair[] r2 = new Pair[5];     // Catch: Throwable -> L11
        r2[0] = TuplesKt.to("scene", r7);     // Catch: Throwable -> L11
        if (r8.a == false) goto L5;
        int r4 = 1;
    L6:
        r2[1] = TuplesKt.to("result", Integer.valueOf(r4));     // Catch: Throwable -> L11
        String r10 = r8.b;     // Catch: Throwable -> L11
        if (r10 != null) goto L9;
        r10 = "";
    L9:
        r2[2] = TuplesKt.to("error_code", r10);     // Catch: Throwable -> L11
        r2[3] = TuplesKt.to("intent_latency", Long.valueOf(r9));     // Catch: Throwable -> L11
        r2[4] = TuplesKt.to("effective_latency", Long.valueOf(r11));     // Catch: Throwable -> L11
        DoraBuryPointManager.J(r1, "d_wifi_intent_result", MapsKt.mapOf(r2), false, 12);     // Catch: Throwable -> L11
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L19;
        FLogger.a.w("DoraWifiIntentClient", "reportWifiIntentResult failed", r13);
        return;
    L19:
        return;
    L5:
        r4 = 2;
    L11:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
