package com.bytedance.badger.network;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.badger.Badger;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.e;
import com.bytedance.badger.j;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u0 {
    public static final /* synthetic */ KProperty[] a = null;
    public static final Lazy b = null;
    public static final ConcurrentHashMap c = null;
    public static final ConcurrentHashMap d = null;
    public static final Lazy e = null;
    public static final ConcurrentHashMap f = null;
    public static final Lazy g = null;
    public static final u0 h = null;

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(u0.class), "scheduledExecutor", "getScheduledExecutor()Ljava/util/concurrent/ScheduledExecutorService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(u0.class), "networkObserver", "getNetworkObserver()Lcom/bytedance/badger/network/NetworkObserver;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(u0.class), "initialRetryIntervalMs", "getInitialRetryIntervalMs()J"))};
        h = new u0();
        b = LazyKt.lazy(C0389p.a);
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = LazyKt.lazy(C0388m.a);
        f = new ConcurrentHashMap();
        g = LazyKt.lazy(C0387l.a);
    }

    public u0() {
    }

    public static b0 a(a0 r4) {
        BadgerCore.Companion.getClass();
        return j.a().getNetRequestInterface().b(r4);
    L5:
        th = move-exception;
        e.c("BadgerNetworkRetryHandler", "sendRequestSync failed", th);
        return new b0(false, -1, CollectionsKt.emptyList(), th.toString());
    }

    public static void c(String r4, long r5) {
        Lazy r0 = b;     // Catch: RejectedExecutionException -> L6
        KProperty r1 = a[0];     // Catch: RejectedExecutionException -> L6
        ScheduledFuture r6 = (ScheduledFuture) d.put(r4, ((ScheduledExecutorService) r0.getValue()).schedule(new q0(r4), r5, TimeUnit.MILLISECONDS));     // Catch: RejectedExecutionException -> L6
        if (r6 == null) goto L11;
        r6.cancel(false);     // Catch: RejectedExecutionException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.c("BadgerNetworkRetryHandler", "Failed to schedule retry task: " + r4, e);
        c.remove(r4);
    }

    public static void b(a0 r16, int r17, int r18, Function6 r19, com.bytedance.badger.C.a r20) {
        if (r17 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L71;
        if (r18 < 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L69;
        com.bytedance.badger.v.d.f0.getClass();
        com.bytedance.badger.v.j r3 = com.bytedance.badger.v.d.F;
        KProperty r4 = com.bytedance.badger.v.d.a[32];
        boolean r5 = ((Collection) r3.a()).contains(Integer.valueOf(com.bytedance.badger.C.a.d.a()));
        NetworkInfo r6 = ((ConnectivityManager) Badger.INSTANCE.getContext().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L73
        if (r6 == null) goto L17;
        if (r6.isConnected() == false) goto L17;
        boolean r7 = true;
    L18:
        boolean r8 = !r7;
        if (r5 == false) goto L21;
        e.g("BadgerNetworkRetryHandler", "onCompensate# forbid reigster network observer");
    L21:
        if (r8 == false) goto L24;
        if (r5 == true) goto L24;
        boolean r9 = true;
    L26:
        if (r9 == false) goto L35;
        String r10 = r16.a + '_' + r16.hashCode();
        C0386k r12 = new C0386k(r16, r17, r18, r19);
        ConcurrentHashMap r13 = f;
        if (r13.containsKey(r10) == true) goto L32;
        t0 r14 = new t0(r10, r12);
        r13.put(r10, r14);     // Catch: Exception -> L72
        Lazy r15 = e;     // Catch: Exception -> L72
        KProperty r22 = a[1];     // Catch: Exception -> L72
        ((j0) r15.getValue()).b(r14);     // Catch: Exception -> L72
        e.f("BadgerNetworkRetryHandler", "Waiting for network: " + r10);     // Catch: Exception -> L72
    L32:
        e.g("BadgerNetworkRetryHandler", "network is unavailable, register listener.");
        return;
    L35:
        if (r17 < 0) goto L59;
        int r110 = 0;
    L37:
        b0 r23 = a(r16);
        if (r110 == 0) goto L40;
        Object r0 = new g0(r110, r17 - r110);
    L46:
        Object r24 = r0;
        if (r23.a == true) goto L49;
    L56:
        r19.invoke(Boolean.FALSE, "", r16, r23, r24, r20);
        if (r110 == r17) goto L59;
        r110 = r110 + 1;
        goto L37
    L49:
        if (r23.b != 200) goto L56;
        String r25 = w.a(r23.c, Constants.Keys.KEY_X_TT_LOGID, true);
        if (r25 != null) goto L54;
        r25 = "";
    L54:
        r19.invoke(Boolean.TRUE, r25, r16, r23, r24, r20);
        return;
    L40:
        if (r17 != 0) goto L43;
        if (r18 != 0) goto L43;
        boolean r26 = true;
    L44:
        r0 = new f0(r26);
    L43:
        r26 = false;
    L59:
        if (r18 > 0) goto L61;
        e.g("BadgerNetworkRetryHandler", "addDelayedRetryTask: delayedRetryCount must be > 0");
        return;
    L61:
        String r111 = r16.a + '_' + r16.hashCode();
        ConcurrentHashMap r112 = c;
        p0 r27 = (p0) r112.remove(r111);
        ScheduledFuture r28 = (ScheduledFuture) d.remove(r111);
        if (r28 == null) goto L64;
        r28.cancel(false);
    L64:
        if (r27 == null) goto L66;
        e.b("BadgerNetworkRetryHandler", "Cancelled retry task: " + r111);
    L66:
        p0 r113 = new p0(r16, r17, r18, r19, System.currentTimeMillis());
        r112.put(r111, r113);
        e.b("BadgerNetworkRetryHandler", "Added retry task: " + r111 + ", retryCount: " + r18);
        r113.a.decrementAndGet();
        long r29 = (long) Math.max(1, 1);
        Lazy r30 = g;
        KProperty r32 = a[2];
        c(r111, r29 * ((Number) r30.getValue()).longValue());
        return;
    L24:
        r9 = false;
    L17:
        r7 = false;
        goto L18
    L69:
        throw new IllegalArgumentException("delayedRetryCount must be >= 0".toString());
    L9:
        r2 = false;
        goto L10
    L71:
        throw new IllegalArgumentException("immediateRetryCount must be >= 0".toString());
    L5:
        r1 = false;
        goto L6
    }
}
