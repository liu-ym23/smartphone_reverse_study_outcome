package com.bytedance.android.anniex.monitor;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.android.anniex.ability.service.IAnnieXContextProvider;
import com.bytedance.ies.bullet.service.base.d;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.ies.xbridge.s;
import com.larus.apm.impl.protector.RunnableProtector;
import gz2.c;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXFrequencyMonitor {
    public static final Lazy a = null;
    public static final long b = 0;
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final Lazy f = null;
    public static volatile int g;
    public static final a h = null;
    public static final AtomicBoolean i = null;
    public static final Object j = null;
    public static final Lazy k = null;
    public static final Lazy l = null;
    public static final b m = null;
    public static final ArrayDeque<Long> n = null;
    public static final ArrayDeque<Long> o = null;
    public static boolean p;
    public static long q;
    public static int r;
    public static boolean s;
    public static long t;
    public static int u;
    public static long v;

    public static final class a implements JsEventSubscriber {
        public a() {
        }

        public final void onReceiveJsEvent(Js2NativeEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "jsEvent");
            XReadableMap r11 = r10.getParams();
            if (r11 != null) goto L5;
            return;
        L5:
            Lazy r0 = AnnieXFrequencyMonitor.a;
            AnnieXFrequencyMonitor.g = s.d(r11, "level", 0);
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        public final void a() {
            Lazy r0 = AnnieXFrequencyMonitor.a;
            com.bytedance.android.anniex.assemble.a r1 = com.bytedance.android.anniex.assemble.a.a;
            IAnnieXContextProvider r10 = (IAnnieXContextProvider) com.bytedance.android.anniex.assemble.a.g("default_bid", IAnnieXContextProvider.class);
            if (r10 == null) goto L6;
            r10.l0();
        L6:
            if (Intrinsics.areEqual(null, "living_room") == true) goto L8;
        L45:
            AnnieXFrequencyMonitor.e();
        L46:
            ((Handler) AnnieXFrequencyMonitor.l.getValue()).postDelayed(this, AnnieXFrequencyMonitor.b);
            return;
        L8:
            if (((Boolean) AnnieXFrequencyMonitor.f.getValue()).booleanValue() == false) goto L45;
            Object r11 = AnnieXFrequencyMonitor.j;
            monitor-enter(r11);
            long r12 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L42
            if ((r12 - AnnieXFrequencyMonitor.v) >= AnnieXFrequencyMonitor.b) goto L17;
            monitor-exit(r11);
            goto L46
        L17:
            AnnieXFrequencyMonitor.v = r12;     // Catch: Throwable -> L42
            ArrayDeque<Long> r13 = AnnieXFrequencyMonitor.n;     // Catch: Throwable -> L42
            AnnieXFrequencyMonitor.a(r13, r12);     // Catch: Throwable -> L42
            ArrayDeque<Long> r14 = AnnieXFrequencyMonitor.o;     // Catch: Throwable -> L42
            AnnieXFrequencyMonitor.a(r14, r12);     // Catch: Throwable -> L42
            int r15 = r13.size();     // Catch: Throwable -> L42
            int r16 = AnnieXFrequencyMonitor.d;     // Catch: Throwable -> L42
            if (r15 < r16) goto L20;
            boolean r17 = true;
        L21:
            boolean r18 = AnnieXFrequencyMonitor.p;     // Catch: Throwable -> L42
            if (r18 == true) goto L25;
            if (r17 == false) goto L25;
            AnnieXFrequencyMonitor.p = true;     // Catch: Throwable -> L42
            AnnieXFrequencyMonitor.q = r12;     // Catch: Throwable -> L42
            AnnieXFrequencyMonitor.r = r15;     // Catch: Throwable -> L42
        L28:
            int r19 = r14.size();     // Catch: Throwable -> L42
            int r20 = AnnieXFrequencyMonitor.e;     // Catch: Throwable -> L42
            if (r19 < r20) goto L31;
            boolean r21 = true;
        L32:
            boolean r22 = AnnieXFrequencyMonitor.s;     // Catch: Throwable -> L42
            if (r22 == true) goto L36;
            if (r21 == false) goto L36;
            AnnieXFrequencyMonitor.s = true;     // Catch: Throwable -> L42
            AnnieXFrequencyMonitor.t = r12;     // Catch: Throwable -> L42
            AnnieXFrequencyMonitor.u = r19;     // Catch: Throwable -> L42
        L39:
            Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L42
            monitor-exit(r11);
        L36:
            if (r22 == false) goto L39;
            if (r21 == true) goto L39;
            AnnieXFrequencyMonitor.d("jsb_exec", r12, AnnieXFrequencyMonitor.t, AnnieXFrequencyMonitor.u, r20);     // Catch: Throwable -> L42
            AnnieXFrequencyMonitor.s = false;     // Catch: Throwable -> L42
            AnnieXFrequencyMonitor.t = 0;     // Catch: Throwable -> L42
            AnnieXFrequencyMonitor.u = 0;     // Catch: Throwable -> L42
            goto L39
        L31:
            r21 = false;
        L25:
            if (r18 == false) goto L28;
            if (r17 == true) goto L28;
            AnnieXFrequencyMonitor.d("view_load", r12, AnnieXFrequencyMonitor.q, AnnieXFrequencyMonitor.r, r16);     // Catch: Throwable -> L42
            AnnieXFrequencyMonitor.p = false;     // Catch: Throwable -> L42
            AnnieXFrequencyMonitor.q = 0;     // Catch: Throwable -> L42
            AnnieXFrequencyMonitor.r = 0;     // Catch: Throwable -> L42
            goto L28
        L20:
            r17 = false;
        L42:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Lazy r0 = LazyKt.lazy(AnnieXFrequencyMonitor$bulletSettings$2.INSTANCE);
        a = r0;
        d r1 = (d) r0.getValue();
        if (r1 == null) goto L5;
        long r10 = r1.D0;
    L6:
        b = r10;
        d r11 = (d) r0.getValue();
        if (r11 == null) goto L9;
        int r12 = r11.E0;
    L10:
        c = r12;
        d r13 = (d) r0.getValue();
        if (r13 == null) goto L13;
        int r14 = r13.F0;
    L14:
        d = r14;
        d r15 = (d) r0.getValue();
        if (r15 == null) goto L17;
        int r16 = r15.G0;
    L18:
        e = r16;
        f = LazyKt.lazy(AnnieXFrequencyMonitor$enableAnnieXFrequencyInfoReport$2.INSTANCE);
        h = new a();
        i = new AtomicBoolean(false);
        j = new Object();
        k = LazyKt.lazy(AnnieXFrequencyMonitor$backgroundHandlerThread$2.INSTANCE);
        l = LazyKt.lazy(AnnieXFrequencyMonitor$backgroundHandler$2.INSTANCE);
        m = new b();
        n = new ArrayDeque();
        o = new ArrayDeque();
        return;
    L17:
        r16 = 20;
        goto L18
    L13:
        r14 = 3;
        goto L14
    L9:
        r12 = 512;
        goto L10
    L5:
        r10 = 1000;
        goto L6
    }

    public static void b() {
        if (((Boolean) f.getValue()).booleanValue() == false) goto L21;
        com.bytedance.android.anniex.assemble.a r0 = com.bytedance.android.anniex.assemble.a.a;
        IAnnieXContextProvider r1 = (IAnnieXContextProvider) com.bytedance.android.anniex.assemble.a.g("default_bid", IAnnieXContextProvider.class);
        if (r1 == null) goto L8;
        r1.l0();
    L8:
        if (Intrinsics.areEqual(null, "living_room") == false) goto L21;
        if (i.compareAndSet(false, true) == false) goto L20;
        Object r10 = j;
        monitor-enter(r10);
        p = false;     // Catch: Throwable -> L17
        q = 0;     // Catch: Throwable -> L17
        r = 0;     // Catch: Throwable -> L17
        s = false;     // Catch: Throwable -> L17
        t = 0;     // Catch: Throwable -> L17
        u = 0;     // Catch: Throwable -> L17
        n.clear();     // Catch: Throwable -> L17
        o.clear();     // Catch: Throwable -> L17
        v = 0;     // Catch: Throwable -> L17
        EventCenter.registerJsEventSubscriber("live_room_level_change", h);     // Catch: Throwable -> L17
        ((Handler) l.getValue()).postDelayed(m, b);     // Catch: Throwable -> L17
        monitor-exit(r10);
        return;
    L17:
        th = move-exception;
        throw th;
    L20:
        return;
    L21:
        e();
    }

    public static void e() {
        if (i.compareAndSet(true, false) == false) goto L12;
        Object r0 = j;
        monitor-enter(r0);
        p = false;     // Catch: Throwable -> L9
        q = 0;     // Catch: Throwable -> L9
        r = 0;     // Catch: Throwable -> L9
        s = false;     // Catch: Throwable -> L9
        t = 0;     // Catch: Throwable -> L9
        u = 0;     // Catch: Throwable -> L9
        n.clear();     // Catch: Throwable -> L9
        o.clear();     // Catch: Throwable -> L9
        v = 0;     // Catch: Throwable -> L9
        EventCenter.unregisterJsEventSubscriber("live_room_level_change", h);     // Catch: Throwable -> L9
        ((Handler) l.getValue()).removeCallbacks(m);     // Catch: Throwable -> L9
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r0);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static void c() {
        b();
        long r0 = SystemClock.elapsedRealtime();
        Object r10 = j;
        monitor-enter(r10);
        n.addLast(Long.valueOf(r0));     // Catch: Throwable -> L10
        if (p == false) goto L7;
        r++;     // Catch: Throwable -> L10
    L7:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r10);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void a(ArrayDeque r10, long r11) {
        long r12 = r11 - b;
    L4:
        if ((!r10.isEmpty()) == false) goto L9;
        if (((Number) r10.first()).longValue() > r12) goto L9;
        r10.removeFirst();
    L9:
        if (r10.size() <= c) goto L11;
        r10.removeFirst();
        goto L9
    }

    public static void d(String r10, long r11, long r12, int r13, int r14) {
        if (r12 != 0) goto L5;
        long r15 = 0;
    L7:
        if (r15 > 0) goto L9;
        double r16 = 1.0d;
    L10:
        double r0 = ((double) r13) / r16;
        JSONObject r17 = new JSONObject().put("busy_type", r10).put("count_in_window", r13);
        StringCompanionObject r18 = StringCompanionObject.INSTANCE;
        c.f("anniex_frequency", r17.put("rps", String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r0)}, 1))).put("live_perf_level", g).put("busy_dur_ms", r15).put("window_ms", b).put("threshold_per_window", r14));
        return;
    L9:
        r16 = r15 / 1000.0d;
        goto L10
    L5:
        r15 = r11 - r12;
        goto L7
    }
}
