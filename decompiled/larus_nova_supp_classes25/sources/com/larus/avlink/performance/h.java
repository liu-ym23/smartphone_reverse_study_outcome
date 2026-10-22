package com.larus.avlink.performance;

import com.flow.performance.thermal.SystemBatteryRecoder;
import com.larus.avlink.model.FlowDoraScene;
import com.larus.avlink.model.FlowDoraSceneState;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import h49.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import t39.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public static final h a = null;
    public static final CoroutineScope b = null;
    public static Job c;
    public static volatile long d;
    public static volatile boolean e;
    public static final c f = null;
    public static final b g = null;
    public static final d h = null;
    public static final a i = null;
    public static final DoraSceneStateNormalizer j = null;
    public static final com.larus.avlink.performance.a k = null;

    public static final class a implements n {
        public a() {
        }

        public final void e(int r5, int r6, String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, "productName");
            FLogger.a.i("DoraSceneBatteryRecorder", "onDoraLinkChanged, state:" + r5 + ", productId:" + r6 + ", productName:" + r7 + ", fwVersion:" + r8);
            Map r9 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("dora_product_id", String.valueOf(r6)), TuplesKt.to("dora_product_name", r7), TuplesKt.to("dora_fw_version", r8)});
            if (r5 != 0) goto L5;
            r9.put("dora_device_wear_state", null);
        L5:
            SystemBatteryRecoder r10 = SystemBatteryRecoder.a;
            monitor-enter(r10);
            Intrinsics.checkNotNullParameter(r9, "fields");     // Catch: Throwable -> L14
            Iterator r11 = r9.entrySet().iterator();     // Catch: Throwable -> L14
        L9:
            if (r11.hasNext() == false) goto L12;
            Map.Entry r12 = (Map.Entry) r11.next();     // Catch: Throwable -> L14
            SystemBatteryRecoder.a.g((String) r12.getKey(), (String) r12.getValue());     // Catch: Throwable -> L14
            goto L9
        L12:
            monitor-exit(r10);
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    public static final class b implements h49.e {
        public b() {
        }

        public final void b(int r1) {
        }

        public final void a(int r4) {
            if (r4 != 2) goto L5;
            boolean r5 = true;
        L6:
            FLogger.a.i("DoraSceneBatteryRecorder", "onDoraLinkStateChanged, connected:" + r5);
            h r0 = h.a;
            h.b(r5);
            return;
        L5:
            r5 = false;
            goto L6
        }
    }

    public static final class c implements b98.d {
        public c() {
        }

        public final void a(@FlowDoraScene int r6, @FlowDoraSceneState int r7) {
            FLogger r0 = FLogger.a;
            r0.i("DoraSceneBatteryRecorder", "onStateChange, scene:" + r6 + ", state:" + r7);
            boolean r1 = false;
            if (r6 != 0) goto L17;
            com.larus.avlink.performance.a r8 = h.k;
            monitor-enter(r8);
            if (r7 == 1) goto L10;
            if (r7 == 2) goto L31;
            monitor-exit(r8);
            return;
        L31:
            r8.e = r1;     // Catch: Throwable -> L14
            r8.c();     // Catch: Throwable -> L14
            monitor-exit(r8);
            return;
        L14:
            th = move-exception;
            throw th;
        L10:
            r1 = true;
            goto L31
        L17:
            h r4 = h.a;
            if (r6 == 1) goto L25;
            if (r6 == 2) goto L25;
            if (r6 == 6) goto L25;
            if (r6 == 7) goto L25;
        L26:
            if (r1 == true) goto L29;
            r0.d("DoraSceneBatteryRecorder", "skip non session scene, scene:" + r6);
            return;
        L29:
            h.k.b(r6, r7);
            h.j.d(new com.larus.avlink.performance.b(String.valueOf(r6), r7, Integer.valueOf(r6)));
            return;
        L25:
            r1 = true;
            goto L26
        }
    }

    public static final class d implements m {
        public d() {
        }

        public final void a(boolean r3, boolean r4) {
            h r0 = h.a;
            if (r3 == false) goto L6;
            if (r4 == false) goto L6;
            String r5 = "lr_on";
        L11:
            FLogger.a.i("DoraSceneBatteryRecorder", "updateWearState, wearState:".concat(r5));
            SystemBatteryRecoder.a.g("dora_device_wear_state", r5);
            return;
        L6:
            if (r3 == false) goto L8;
            r5 = "l_on";
            goto L11
        L8:
            if (r4 == false) goto L10;
            r5 = "r_on";
            goto L11
        L10:
            r5 = "off";
            goto L11
        }
    }

    public h() {
    }

    public final synchronized void a() {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L4:
        if (e == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        e = false;     // Catch: Throwable -> L25
        List r0 = b98.b.a;     // Catch: Throwable -> L25
        b98.b.e(f);     // Catch: Throwable -> L25
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L25
        if (r1 == null) goto L13;
        DeviceService r2 = r1.device();     // Catch: Throwable -> L25
        if (r2 == null) goto L13;
        r2.x0(g);     // Catch: Throwable -> L25
    L13:
        if (r1 == null) goto L17;
        DeviceService r3 = r1.device();     // Catch: Throwable -> L25
        if (r3 == null) goto L17;
        r3.c(h);     // Catch: Throwable -> L25
    L17:
        if (r1 == null) goto L19;
        r1.q0(i);     // Catch: Throwable -> L25
    L19:
        Job r4 = c;     // Catch: Throwable -> L25
        if (r4 == null) goto L22;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);     // Catch: Throwable -> L25
    L22:
        c = null;     // Catch: Throwable -> L25
        FLogger.a.i("DoraSceneBatteryRecorder", "deinit: unregister listeners");     // Catch: Throwable -> L25
        monitor-exit(this);
    }

    public final synchronized void c() {
        monitor-enter(this);
        d++;     // Catch: Throwable -> L9
        Job r0 = c;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);     // Catch: Throwable -> L9
    L6:
        c = null;     // Catch: Throwable -> L9
        SystemBatteryRecoder.a.h(null, null);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.avlink.performance.c] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.avlink.performance.e] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.avlink.performance.d] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.avlink.performance.f] */
    static {
        a = new h();
        CoroutineScope r0 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        b = r0;
        f = new c();
        g = new b();
        h = new d();
        i = new a();
        j = new DoraSceneStateNormalizer(r0, new com.larus.avlink.performance.c(), new com.larus.avlink.performance.d());
        k = new com.larus.avlink.performance.a(r0, new e(), new f());
    }

    public static void b(boolean r5) {
        if (r5 == true) goto L5;
        j.a();
        k.a();
        return;
    L5:
        com.larus.avlink.performance.a r6 = k;
        boolean r0 = false;
        int r1 = b98.b.a(0);
        monitor-enter(r6);
        Job r2 = r6.h;     // Catch: Throwable -> L16
        if (r2 == null) goto L10;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);     // Catch: Throwable -> L16
    L10:
        r6.h = null;     // Catch: Throwable -> L16
        r6.d = Boolean.TRUE;     // Catch: Throwable -> L16
        if (r1 != 1) goto L13;
        r0 = true;
    L13:
        r6.e = r0;     // Catch: Throwable -> L16
        r6.c();     // Catch: Throwable -> L16
        monitor-exit(r6);
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
