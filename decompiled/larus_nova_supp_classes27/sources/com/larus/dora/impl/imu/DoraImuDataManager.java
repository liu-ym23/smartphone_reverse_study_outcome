package com.larus.dora.impl.imu;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.dora.api.awareness.IAwarenessEventReporter;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.settings.h;
import com.larus.dora.impl.settings.l;
import com.larus.dora.impl.settings.o;
import com.larus.dora.impl.util.r0;
import com.larus.dora.impl.util.t0;
import com.larus.utils.l0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraImuDataManager {
    public static final DoraImuDataManager a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static Job e;
    public static final AtomicReference<DoraDevice> f = null;
    public static final ConcurrentLinkedQueue<a> g = null;
    public static final ReentrantLock h = null;
    public static final AtomicBoolean i = null;
    public static final AtomicBoolean j = null;
    public static final ConcurrentHashMap<String, ConcurrentLinkedQueue<a>> k = null;
    public static final ConcurrentHashMap<String, AtomicBoolean> l = null;
    public static final c m = null;
    public static final d n = null;
    public static final b o = null;

    public static final class a {
        public final String a;
        public final String b;
        public final long c;
        public final long d;

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
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            long r1 = this.c;
            int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            long r3 = this.d;
            return r2 + ((int) (r3 ^ (r3 >>> 32)));
        }

        public final String toString() {
            return "ImuData(key=" + this.a + ", value=" + this.b + ", timestamp=" + this.c + ", primaryTimestamp=" + this.d + ')';
        }

        public a(String r2, String r3, long r4, long r6) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r6;
        }
    }

    public static final class b extends r0 {
        public b() {
        }

        public final void y0(DoraDevice r6, int[] r7) {
            if (r7 != null) goto L6;
            g49.d.d("DoraImuDataManager", "Skip wearing event, wearState is null");
            return;
        L6:
            StringBuilder r1 = new StringBuilder("onWearStateChanged: left=");
            int r2 = 0;
            r1.append(ArraysKt.getOrNull(r7, 0));
            r1.append(", right=");
            r1.append(ArraysKt.getOrNull(r7, 1));
            g49.d.d("DoraImuDataManager", r1.toString());
            DoraImuDataManager r3 = DoraImuDataManager.a;
            Integer r4 = ArraysKt.getOrNull(r7, 0);
            if (r4 != null) goto L10;
        L12:
            boolean r5 = false;
        L13:
            Integer r8 = ArraysKt.getOrNull(r7, 1);
            if (r8 != null) goto L17;
        L19:
            boolean r9 = false;
        L20:
            r3.getClass();
            DoraImuDataManager.f.set(r6);
            if (o59.a.l(r6) != true) goto L23;
            boolean r10 = true;
        L24:
            if (r10 == true) goto L26;
            g49.d.d("DoraImuDataManager", "Skip wearing event, current device is not Dora G, productId=" + Integer.valueOf(r6.productId));
            return;
        L26:
            if (r5 == true) goto L28;
            if (r9 == true) goto L28;
        L29:
            long r11 = System.currentTimeMillis();
            DoraImuDataManager.l("wearing_event", r2, r11);
            if (r2 == 0) goto L32;
            String r12 = "1";
        L33:
            DoraImuDataManager.h("wearing_event", r12, r11);
            return;
        L32:
            r12 = "0";
        L28:
            r2 = 1;
            goto L29
        L23:
            r10 = false;
            goto L24
        L17:
            if (r8.intValue() != 1) goto L19;
            r9 = true;
            goto L20
        L10:
            if (r4.intValue() != 1) goto L12;
            r5 = true;
            goto L13
        }
    }

    public static final class c implements zj4.d {
        public c() {
        }

        public final /* synthetic */ void b(int r1) {
        }

        public final /* synthetic */ void g(int r1) {
        }

        public final void a(int r10, long r11) {
            g49.d.d("DoraImuDataManager", "onHealthServiceUserBehavior: " + r10 + ", primaryTimestamp=" + r11);
            DoraImuDataManager.a.getClass();
            a r0 = new a("user_behavior", String.valueOf(r10), System.currentTimeMillis(), r11);
            ConcurrentLinkedQueue<a> r12 = DoraImuDataManager.g;
            r12.offer(r0);
            g49.d.a("DoraImuDataManager", "User behavior added to queue: " + r0 + ", current queue size: " + r12.size());
            int r13 = DoraImuDataManager.g();
            if (r12.size() < r13) goto L6;
            g49.d.d("DoraImuDataManager", "Queue data exceeds limit(" + r13 + "), report immediately");
            DoraImuDataManager.e();
            return;
        }

        public final void c(int r3, long r4) {
            g49.d.d("DoraImuDataManager", "onHealthServiceSedentary: " + r3 + ", primaryTimestamp=" + r4);
            DoraImuDataManager.a.getClass();
            DoraImuDataManager.l("sedentary_event", r3, r4);
            DoraImuDataManager.h("sedentary_event", String.valueOf(r3), r4);
        }

        public final void d(int r3, long r4) {
            g49.d.d("DoraImuDataManager", "onHealthServiceLongHeadDown: " + r3 + ", primaryTimestamp=" + r4);
            DoraImuDataManager.a.getClass();
            DoraImuDataManager.l("long_head_down_event", r3, r4);
            DoraImuDataManager.h("long_head_down_event", String.valueOf(r3), r4);
        }

        public final void e(int r3, long r4) {
            g49.d.d("DoraImuDataManager", "onHealthServiceFall: " + r3 + ", primaryTimestamp=" + r4);
            DoraImuDataManager.a.getClass();
            DoraImuDataManager.l("fall_event", r3, r4);
            DoraImuDataManager.h("fall_event", String.valueOf(r3), r4);
        }

        public final void f(int r3, long r4) {
            g49.d.d("DoraImuDataManager", "onHealthServiceHeadGesture: " + r3 + ", primaryTimestamp=" + r4);
        }
    }

    public static final class d extends t0 {
        public d() {
        }

        public final void onDoraLinkStateChanged(DoraDevice r10, int r11, int r12) {
            super.onDoraLinkStateChanged(r10, r11, r12);
            g49.d.d("DoraImuDataManager", "onDoraLinkStateChanged: device=" + r10 + ", prevState=" + r11 + ", state=" + r12);
            if (r10 == null) goto L6;
            DoraImuDataManager.f.set(r10);
        L6:
            if (r10 != null) goto L8;
        L10:
            boolean r1 = false;
        L11:
            Integer r2 = null;
            if (r1 == true) goto L18;
            StringBuilder r13 = new StringBuilder("Skip IMU link handling for non-Dora-G device, state=");
            r13.append(r12);
            r13.append(", productId=");
            if (r10 == null) goto L16;
            r2 = Integer.valueOf(r10.productId);
        L16:
            r13.append(r2);
            g49.d.d("DoraImuDataManager", r13.toString());
            DoraImuDataManager.d(DoraImuDataManager.a);
            return;
        L18:
            if (r12 != 0) goto L20;
            g49.d.d("DoraImuDataManager", "Device disconnected, report remaining data immediately");
            DoraImuDataManager.d(DoraImuDataManager.a);
            DoraImuDataManager.e();
            return;
        L20:
            if (r12 != 2) goto L40;
            g49.d.d("DoraImuDataManager", "Device connected, start periodic reporting and report cached low frequency events");
            DoraImuDataManager.a.getClass();
            ReentrantLock r14 = DoraImuDataManager.h;
            r14.lock();
            Job r15 = DoraImuDataManager.e;     // Catch: Throwable -> L31
            if (r15 == null) goto L26;
            Job.DefaultImpls.cancel$default(r15, null, 1, null);     // Catch: Throwable -> L31
        L26:
            Lazy r16 = DoraImuDataManager.c;     // Catch: Throwable -> L31
            DoraImuDataManager.e = BuildersKt.launch$default((CoroutineScope) r16.getValue(), null, null, new DoraImuDataManager$startTimerReport$1$1(null), 3, null);     // Catch: Throwable -> L31
            g49.d.d("DoraImuDataManager", "Timer report started");     // Catch: Throwable -> L31
            Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L31
            r14.unlock();
            if (DoraImuDataManager.i() == true) goto L30;
            g49.d.d("DoraImuDataManager", "IMU report is disabled, skip report");
            return;
        L30:
            BuildersKt.launch$default((CoroutineScope) r16.getValue(), null, null, new DoraImuDataManager$reportCachedLowFreqEvents$1(null), 3, null);
            return;
        L31:
            th = move-exception;
            r14.unlock();
            throw th;
        L40:
            return;
        L8:
            if (o59.a.l(r10) != true) goto L10;
            r1 = true;
            goto L11
        }
    }

    public DoraImuDataManager() {
    }

    static {
        a = new DoraImuDataManager();
        b = LazyKt.lazy(new com.larus.dora.impl.imu.a());
        c = LazyKt.lazy(new com.larus.dora.impl.imu.b());
        d = LazyKt.lazy(new com.larus.dora.impl.imu.c());
        f = new AtomicReference(null);
        g = new ConcurrentLinkedQueue();
        h = new ReentrantLock();
        i = new AtomicBoolean(false);
        j = new AtomicBoolean(false);
        k = new ConcurrentHashMap();
        l = new ConcurrentHashMap();
        m = new c();
        n = new d();
        o = new b();
    }

    public static int g() {
        DoraSetting.a.getClass();
        int r0 = l0.a;
        return ((Number) l0.a(300, new h())).intValue();
    }

    public static boolean i() {
        DoraSetting.a.getClass();
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new o())).booleanValue();
    }

    public static void e() {
        if (i() == true) goto L6;
        g49.d.d("DoraImuDataManager", "IMU report is disabled, skip flushing package data");
        return;
    L6:
        DoraDevice r0 = f("flush package data");
        if (r0 != null) goto L11;
        g49.d.d("DoraImuDataManager", "Skip flushing package data because Dora G device is unavailable");
        return;
    L11:
        if (i.compareAndSet(false, true) == true) goto L14;
        g49.d.d("DoraImuDataManager", "Package data reporting already in progress, existing coroutine will handle it");
        return;
    L14:
        BuildersKt.launch$default((CoroutineScope) c.getValue(), null, null, new DoraImuDataManager$flushPackageData$1(r0, null), 3, null);
    }

    public static final boolean a(DoraImuDataManager r0) {
        r0.getClass();
        if (i() == false) goto L10;
        DoraDevice r1 = f.get();
        if (r1 != null) goto L8;
        r1 = kj4.a.g().c();
    L8:
        if (o59.a.l(r1) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static final void d(DoraImuDataManager r3) {
        r3.getClass();
        ReentrantLock r4 = h;
        r4.lock();
        Job r0 = e;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);     // Catch: Throwable -> L9
    L6:
        e = null;     // Catch: Throwable -> L9
        g49.d.d("DoraImuDataManager", "Timer report stopped");     // Catch: Throwable -> L9
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r4.unlock();
        return;
    L9:
        th = move-exception;
        r4.unlock();
        throw th;
    }

    public static DoraDevice f(String r4) {
        AtomicReference<DoraDevice> r0 = f;
        DoraDevice r1 = r0.get();
        if (r1 != null) goto L5;
        r1 = kj4.a.g().c();
    L5:
        if (r1 == null) goto L8;
        r0.set(r1);
    L8:
        if (r1 != null) goto L11;
        g49.d.d("DoraImuDataManager", "Skip " + r4 + ", current device is null");
    L13:
        return null;
    L11:
        if (o59.a.l(r1) == true) goto L15;
        g49.d.d("DoraImuDataManager", "Skip " + r4 + ", current device is not Dora G, productId=" + r1.productId);
        goto L13
    L15:
        return r1;
    }

    public static a j(String r13) {
        String r0 = "dora_imu_low_freq_" + r13;
        String r1 = ((Keva) b.getValue()).getString(r0, null);
        if (r1 != null) goto L5;
        return null;
    L5:
        List r3 = StringsKt.split$default(r1, new String[]{"|"}, false, 0, 6, null);
        if (r3.size() >= 2) goto L20;
        return null;
    L20:
        String r8 = (String) ListProtector.get(r3, 0);     // Catch: Exception -> L17
        long r9 = CastLongProtector.parseLong((String) ListProtector.get(r3, 1));     // Catch: Exception -> L17
        String r4 = (String) CollectionsKt.getOrNull(r3, 2);     // Catch: Exception -> L17
        if (r4 == null) goto L14;
        Long r5 = StringsKt.toLongOrNull(r4);     // Catch: Exception -> L17
        if (r5 == null) goto L14;
        long r6 = r5.longValue();     // Catch: Exception -> L17
    L15:
        return new a(r13, r8, r9, r6);
    L14:
        r6 = -1;
    L17:
        e = move-exception;
        g49.d.c("DoraImuDataManager", "Parse low frequency event from keva failed: key=" + r0 + ", value=" + r1, e);
        return null;
    }

    public static void k(String r10) {
        if (i() == true) goto L6;
        g49.d.d("DoraImuDataManager", "IMU report is disabled, skip processing event queue: " + r10);
        return;
    L6:
        DoraDevice r0 = f("process event queue: " + r10);
        if (r0 != null) goto L9;
        return;
    L9:
        ConcurrentHashMap<String, AtomicBoolean> r2 = l;
        AtomicBoolean r3 = r2.get(r10);
        if (r3 != null) goto L15;
        r3 = new AtomicBoolean(false);
        AtomicBoolean r4 = r2.putIfAbsent(r10, r3);
        if (r4 == null) goto L15;
        r3 = r4;
    L15:
        AtomicBoolean r5 = r3;
        if (r5.compareAndSet(false, true) == true) goto L19;
        g49.d.d("DoraImuDataManager", r10 + " processing already in progress, skip this trigger");
        return;
    L19:
        BuildersKt.launch$default((CoroutineScope) c.getValue(), null, null, new DoraImuDataManager$processEventQueue$1(r0, r10, r5, null), 3, null);
    }

    public static final void b(DoraImuDataManager r6, a r7) {
        r6.getClass();
        a r8 = j(r7.a);
        if (r8 != null) goto L6;
        g49.d.d("DoraImuDataManager", "No low frequency event cache to clear, key=" + r7.a);
        return;
    L6:
        if (Intrinsics.areEqual(r8.b, r7.b) == true) goto L8;
    L13:
        g49.d.d("DoraImuDataManager", "Skip clearing low frequency event cache because cached data was updated, key=" + r7.a + ", cached=" + r8 + ", report=" + r7);
        return;
    L8:
        if (r8.c != r7.c) goto L13;
        if (r8.d != r7.d) goto L13;
        String r9 = "dora_imu_low_freq_" + r7.a;
        ((Keva) b.getValue()).erase(r9);
        g49.d.d("DoraImuDataManager", "Low frequency event cache cleared after successful report, key=" + r9 + ", data=" + r7);
    }

    public static final void c(DoraImuDataManager r6, a r7) {
        r6.getClass();
        DoraSetting.a.getClass();
        int r8 = l0.a;
        long r0 = ((Number) l0.a(86400000L, new l())).longValue();
        if (r0 <= 0) goto L16;
        long r4 = r7.d;
        if (r4 <= 0) goto L17;
        long r2 = r7.c;
        if (r2 < r4) goto L10;
        long r3 = r2 - r4;
    L12:
        if (r3 <= r0) goto L18;
        g49.d.d("DoraImuDataManager", "Report timestamp calibration, key=" + r7.a + ", timestamp=" + r7.c + ", primaryTimestamp=" + r7.d + ", diff=" + r3 + ", threshold=" + r0);
        DoraBuryPointManager.J(DoraBuryPointManager.a, "dora_health_event_report_calibration", MapsKt.mapOf(new Pair[]{TuplesKt.to("event_name", r7.a), TuplesKt.to("event_value", r7.b), TuplesKt.to("client_timestamp", Long.valueOf(r7.c)), TuplesKt.to("rtos_timestamp", Long.valueOf(r7.d))}), false, 12);
        return;
    L18:
        return;
    L10:
        r3 = r4 - r2;
        goto L12
    L17:
        return;
    }

    public static void h(String r8, String r9, long r10) {
        a r7 = new a(r8, r9, System.currentTimeMillis(), r10);
        String r11 = "dora_imu_low_freq_" + r7.a;
        ((Keva) b.getValue()).storeString(r11, r7.b + '|' + r7.c + '|' + r7.d);
        g49.d.a("DoraImuDataManager", "Low frequency event saved to keva: key=" + r11 + ", data=" + r7);
        StringBuilder r12 = new StringBuilder("Low frequency event cached: ");
        r12.append(r7);
        g49.d.d("DoraImuDataManager", r12.toString());
        ConcurrentHashMap<String, ConcurrentLinkedQueue<a>> r13 = k;
        ConcurrentLinkedQueue<a> r14 = r13.get(r8);
        if (r14 != null) goto L8;
        r14 = new ConcurrentLinkedQueue();
        ConcurrentLinkedQueue<a> r15 = r13.putIfAbsent(r8, r14);
        if (r15 == null) goto L8;
        r14 = r15;
    L8:
        ConcurrentLinkedQueue<a> r16 = r14;
        r16.offer(r7);
        g49.d.d("DoraImuDataManager", "Low frequency event added to queue: " + r7 + ", queue size: " + r16.size());
        k(r8);
    }

    public static void l(String r13, int r14, long r15) {
        IAwarenessEventReporter r6 = (IAwarenessEventReporter) ServiceManager.get().getService(IAwarenessEventReporter.class);
        if (r6 != null) goto L5;
        return;
    L5:
        BuildersKt.launch$default((CoroutineScope) d.getValue(), null, null, new DoraImuDataManager$reportAwarenessEvent$1(r13, r14, r15, r6, null), 3, null);
    }
}
