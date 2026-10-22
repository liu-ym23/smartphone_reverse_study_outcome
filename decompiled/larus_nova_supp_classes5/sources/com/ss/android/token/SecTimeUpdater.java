package com.ss.android.token;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.android.sdk.bdticketguard.init.TicketGuardBootFinishManager;
import com.bytedance.sdk.account.impl.d0;
import com.ss.android.account.k;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import ta7.b;
import ta7.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class SecTimeUpdater implements c {
    public static final /* synthetic */ KProperty[] a = null;
    public static long b;
    public static final Lazy c = null;
    public static final AtomicReference<UpdateState> d = null;
    public static final AtomicLong e = null;
    public static final AtomicReference<ScheduledFuture<?>> f = null;
    public static final AtomicBoolean g = null;
    public static final Lazy h = null;
    public static final PThreadPoolExecutor i = null;
    public static final AtomicBoolean j = null;
    public static final SecTimeUpdater k = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/token/SecTimeUpdater$UpdateState;", "", "STOPPED", "STARTING", "RUNNING", "STOPPING", "account-sdk-core_release"}, k = 1, mv = {1, 4, 0})
    public static final enum UpdateState extends Enum<UpdateState> {
        public static final UpdateState RUNNING = null;
        public static final UpdateState STARTING = null;
        public static final UpdateState STOPPED = null;
        public static final UpdateState STOPPING = null;
        public static final /* synthetic */ UpdateState[] a = null;

        static {
            UpdateState r1 = new UpdateState("STOPPED", 0);
            STOPPED = r1;
            UpdateState r2 = new UpdateState("STARTING", 1);
            STARTING = r2;
            UpdateState r3 = new UpdateState("RUNNING", 2);
            RUNNING = r3;
            UpdateState r4 = new UpdateState("STOPPING", 3);
            STOPPING = r4;
            a = new UpdateState[]{r1, r2, r3, r4};
        }

        public static UpdateState valueOf(String r1) {
            return (UpdateState) r27.a.a(UpdateState.class, r1);
        }

        public static UpdateState[] values() {
            return (UpdateState[]) a.clone();
        }

        public UpdateState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements RejectedExecutionHandler {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable r1, ThreadPoolExecutor r2) {
            tb7.a.e("SecTimeUpdater", "Task rejected: executor is busy");
        }
    }

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SecTimeUpdater.class), "degradeRequestCooldownMs", "getDegradeRequestCooldownMs()J")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SecTimeUpdater.class), "updateSecTimeExecutor", "getUpdateSecTimeExecutor()Ljava/util/concurrent/ScheduledExecutorService;"))};
        k = new SecTimeUpdater();
        c = LazyKt.lazy(SecTimeUpdater$degradeRequestCooldownMs$2.INSTANCE);
        d = new AtomicReference(UpdateState.STOPPED);
        e = new AtomicLong(0);
        f = new AtomicReference(null);
        g = new AtomicBoolean(true);
        h = LazyKt.lazy(SecTimeUpdater$updateSecTimeExecutor$2.INSTANCE);
        i = new PThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory("ecTimeUpdater"), a.a);
        j = new AtomicBoolean(false);
    }

    public SecTimeUpdater() {
    }

    public static void d() {
        tb7.a.d("SecTimeUpdater", "stopUpdateSecTime");
        AtomicReference<UpdateState> r2 = d;
        UpdateState r3 = r2.get();
        if (r3 == UpdateState.STOPPED) goto L27;
        UpdateState r4 = UpdateState.STOPPING;
        if (r3 != r4) goto L8;
        return;
    L8:
        if (r2.compareAndSet(r3, r4) == true) goto L9;
        if (r2.get() == r3) goto L8;
        boolean r5 = false;
    L13:
        if (r5 == true) goto L28;
        return;
    L28:
        ScheduledFuture<?> r6 = f.getAndSet(null);     // Catch: Throwable -> L19 Exception -> L21
        if (r6 == null) goto L23;
        r6.cancel(false);     // Catch: Throwable -> L19 Exception -> L21
    L23:
        d.set(UpdateState.STOPPED);
        tb7.a.d("SecTimeUpdater", "stopUpdateSecTime: stopped successfully");
        return;
    L21:
        e = move-exception;
        tb7.a.c("SecTimeUpdater", "Error cancelling scheduled task", e);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        d.set(UpdateState.STOPPED);
        tb7.a.d("SecTimeUpdater", "stopUpdateSecTime: stopped successfully");
        throw th;
    L9:
        r5 = true;
        goto L13
    }

    public static void c(boolean r9) {
        tb7.a.d("SecTimeUpdater", "startUpdateSecTime");
        com.bytedance.sdk.account.ticketguard.f.a();
        long r6 = com.bytedance.sdk.account.ticketguard.f.s;
        if (r6 > 0) goto L8;
        tb7.a.e("SecTimeUpdater", "startUpdateSecTime: interval <= 0");
        Context r0 = k.c();
        if (r0 == null) goto L32;
        k.getClass();
        b(r0, "boot_check", r9);
        return;
    L32:
        return;
    L8:
        AtomicReference<UpdateState> r10 = d;
        UpdateState r1 = UpdateState.STOPPED;
        UpdateState r2 = UpdateState.STARTING;
    L10:
        if (r10.compareAndSet(r1, r2) == true) goto L11;
        if (r10.get() == r1) goto L10;
        boolean r11 = false;
    L15:
        if (r11 == true) goto L18;
        tb7.a.e("SecTimeUpdater", "startUpdateSecTime: already starting or running");
        return;
    L18:
        Lazy r12 = h;
        KProperty[] r3 = a;
        KProperty r4 = r3[1];
        if (((ScheduledExecutorService) r12.getValue()).isShutdown() == false) goto L27;
        d.set(UpdateState.STOPPED);
        return;
    L27:
        KProperty r5 = r3[1];     // Catch: Exception -> L24
        ScheduledFuture<?> r13 = ((ScheduledExecutorService) r12.getValue()).scheduleWithFixedDelay(b.a, 0, r6, TimeUnit.SECONDS);     // Catch: Exception -> L24
        f.set(r13);     // Catch: Exception -> L24
        d.set(UpdateState.RUNNING);     // Catch: Exception -> L24
        tb7.a.d("SecTimeUpdater", "startUpdateSecTime: started successfully");     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        tb7.a.c("SecTimeUpdater", "startUpdateSecTime error", e);
        d.set(UpdateState.STOPPED);
        f.set(null);
        return;
    L11:
        r11 = true;
        goto L15
    }

    public final void M(b r3) {
        boolean r0 = true;
        if (r3.a != 1) goto L15;
        wqa.f r4 = k.b;
        if (r4 == null) goto L11;
        Context r5 = r4.getApplicationContext();
        if (r5 == null) goto L11;
        if (h0.d(r5) != true) goto L11;
    L12:
        if (r0 == false) goto L16;
        tb7.a.d("SecTimeUpdater", "Logout, restart update sec time");
        c(false);
        return;
    L16:
        return;
    L11:
        r0 = false;
        goto L12
    }

    public static final void a(SecTimeUpdater r9, String r10) {
        r9.getClass();
        tb7.a.d("SecTimeUpdater", "tryUpdateSecTime, scene: " + r10);
        if (b <= 0) goto L7;
        long r2 = SystemClock.elapsedRealtime() - b;
        Lazy r4 = c;
        KProperty[] r5 = a;
        KProperty r6 = r5[0];
        if (r2 >= ((Number) r4.getValue()).longValue()) goto L7;
        StringBuilder r11 = new StringBuilder("updateSecTs network degrade in cooldown, lastDegradeElapsedTimeMs=");
        r11.append(b);
        r11.append(", scene=");
        r11.append(r10);
        r11.append(", AVAILABLE IN: ");
        long r3 = b;
        KProperty r12 = r5[0];
        r11.append(((r3 + ((Number) r4.getValue()).longValue()) - SystemClock.elapsedRealtime()) / ((long) 1000));
        r11.append(" s");
        tb7.a.e("SecTimeUpdater", r11.toString());
        return;
    L7:
        com.bytedance.sdk.account.ticketguard.f.a();
        if (com.bytedance.sdk.account.ticketguard.f.j0 == false) goto L33;
        TicketGuardBootFinishManager.e.getClass();
        if (TicketGuardBootFinishManager.c() == true) goto L33;
        if (j.compareAndSet(false, true) == true) goto L14;
        tb7.a.d("SecTimeUpdater", "tryUpdateSecTime,scene: " + r10 + ", not boot finish, have delay, skip");
        return;
    L14:
        tb7.a.d("SecTimeUpdater", "tryUpdateSecTime,scene: " + r10 + ", not boot finish, delay");
        TicketGuardBootFinishManager.a(new k(r10));
        return;
    L33:
        ArrayList r7 = new ArrayList();     // Catch: Exception -> L30
        wqa.c r8 = k.d;     // Catch: Exception -> L30
        if (r8 == null) goto L20;
        wqa.i r13 = r8.getRequestTagHeader(true);     // Catch: Exception -> L30
        if (r13 == null) goto L20;
        r7.add(r13);     // Catch: Exception -> L30
    L20:
        d0 r14 = d0.c();     // Catch: Exception -> L30
        StringBuilder r15 = new StringBuilder("https://");     // Catch: Exception -> L30
        wqa.f r16 = k.b;     // Catch: Exception -> L30
        if (r16 == null) goto L23;
        String r17 = r16.S();     // Catch: Exception -> L30
    L24:
        r15.append(r17);     // Catch: Exception -> L30
        r15.append("/passport/user_info/get_sec_ts/?update_scene=");     // Catch: Exception -> L30
        r15.append(r10);     // Catch: Exception -> L30
        String r18 = r15.toString();     // Catch: Exception -> L30
        LinkedHashMap r19 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16));     // Catch: Exception -> L30
        Iterator r20 = r7.iterator();     // Catch: Exception -> L30
    L26:
        if (r20.hasNext() == false) goto L28;
        wqa.i r21 = (wqa.i) r20.next();     // Catch: Exception -> L30
        Pair r22 = TuplesKt.to(r21.a, r21.b);     // Catch: Exception -> L30
        r19.put(r22.getFirst(), r22.getSecond());     // Catch: Exception -> L30
        goto L26
    L28:
        HashMap r23 = new HashMap();     // Catch: Exception -> L30
        new rb7.c(r14.a, rb7.c.p(r18, r19, r23, false), new l(r10, r7)).m();     // Catch: Exception -> L30
        return;
    L23:
        r17 = null;
    L30:
        e = move-exception;
        tb7.a.c("SecTimeUpdater", "tryUpdateSecTime error", e);
    }

    public static void b(Context r13, String r14, boolean r15) {
        long r0 = System.currentTimeMillis();
        AtomicLong r2 = e;
        long r3 = r2.get();
        com.bytedance.sdk.account.ticketguard.f.a();
        long r5 = com.bytedance.sdk.account.ticketguard.f.t * 1000;
        if ((r0 - r3) >= r5) goto L5;
        return;
    L5:
        if (r5 >= 0) goto L8;
        return;
    L8:
        if (r2.compareAndSet(r3, r0) == true) goto L10;
        return;
    L10:
        if (r15 == true) goto L37;
        j r16 = i.b(r13);
        com.bytedance.sdk.account.ticketguard.f.a();
        long r1 = com.bytedance.sdk.account.ticketguard.f.w;
        boolean r4 = false;
        if (r1 >= 0) goto L15;
    L36:
        if (r4 == true) goto L37;
        return;
    L15:
        if (r16 == null) goto L31;
        long r6 = r1 * 1000;
        long r7 = SystemClock.elapsedRealtime();
        long r8 = System.currentTimeMillis();
        if (r16.e != com.bytedance.sdk.account.time.e.a(r13)) goto L23;
        long r11 = r16.d;
        if (r7 <= r11) goto L23;
        if ((r7 - r11) > r6) goto L29;
    L28:
        boolean r17 = false;
    L30:
        Boolean r18 = Boolean.valueOf(r17);
    L33:
        if (Intrinsics.areEqual(r18, Boolean.TRUE) == true) goto L35;
        if (r16 != null) goto L36;
    L35:
        r4 = true;
    L29:
        r17 = true;
    L23:
        long r9 = r8 - r16.c;
        if (r9 > r6) goto L29;
        if (r9 >= 0) goto L28;
    L31:
        r18 = null;
    L37:
        tb7.a.d("SecTimeUpdater", "start update timestamp");
        i.submit(new m(r14));     // Catch: RejectedExecutionException -> L40
        return;
    L40:
        e = move-exception;
        tb7.a.f("SecTimeUpdater", "updateOnce: task rejected", e);
    }
}
