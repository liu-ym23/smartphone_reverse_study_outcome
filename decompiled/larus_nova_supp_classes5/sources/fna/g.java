package fna;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.crash.Npth;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.IRuntimeContext;
import com.obric.performance.power.monitor.battery.BatteryMonitor;
import com.obric.performance.power.monitor.constants.ObricPerformancePowerMonitorConfig;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static ObricPerformancePowerMonitorConfig c;
    public static Context d;
    public static kna.d e;
    public static kna.c f;
    public static boolean g;
    public static boolean h;
    public static boolean i;
    public static volatile boolean j;
    public static boolean k;
    public static volatile boolean l;
    public static boolean m;
    public static volatile boolean n;
    public static int o;
    public static volatile boolean p;
    public static final Lazy q = null;
    public static com.obric.performance.power.monitor.cpu.a r;
    public static float s;
    public static int t;
    public static float u;
    public static int v;
    public static final Lazy w = null;
    public static final a x = null;
    public static final c y = null;
    public static final b z = null;

    public static final class a implements BatteryMonitor.a {
        public a() {
        }

        @Override // com.obric.performance.power.monitor.battery.BatteryMonitor.a
        public final void a(boolean r4) {
            if (g.p == true) goto L5;
        L7:
            ILogDepend.a.d("PowerMonitor", "reportRunnable onChargeChanged " + r4);
            return;
        L5:
            if (g.m == r4) goto L7;
            g.n = true;
            goto L7
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        public final void a() {
            if (g.p == false) goto L15;
            Context r0 = g.d;     // Catch: Exception -> L9
            if (r0 == null) goto L11;
            g.u += mna.a.a(r0);     // Catch: Exception -> L9
            g.v++;     // Catch: Exception -> L9
        L11:
            g.b().postDelayed(this, g.c.getCollectCurrentIntervalMillis());
            return;
        L9:
            e = move-exception;
            ILogDepend.a.d("PowerMonitor", "onCollectOnlyFront: " + e.getMessage());
            goto L11
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

    public static final class c implements Runnable {
        public c() {
        }

        public final void a() {
            if (g.p == false) goto L144;
            Lazy r0 = g.a;
            ILogDepend.Companion r1 = ILogDepend.a;
            r1.d("PowerMonitor", "performTask start");
            com.obric.performance.power.monitor.cpu.a r4 = g.r;
            if (r4 == null) goto L7;
            r4.a();
        L7:
            com.obric.performance.power.monitor.cpu.a r5 = g.r;
            if (r5 == null) goto L10;
            int r6 = r5.b();
        L11:
            com.obric.performance.power.monitor.cpu.a r7 = g.r;
            if (r7 == null) goto L16;
            com.obric.performance.power.monitor.cpu.c r9 = r7.h;
            if (r9 == null) goto L16;
            long r10 = r9.e;
        L17:
            if (r7 == null) goto L21;
            com.obric.performance.power.monitor.cpu.c r11 = r7.h;
            if (r11 == null) goto L21;
            long r12 = r11.f;
        L22:
            if (r7 == null) goto L26;
            com.obric.performance.power.monitor.cpu.c r8 = r7.h;
            if (r8 == null) goto L26;
            long r13 = r8.i;
        L27:
            JSONObject r14 = new JSONObject();
            int r15 = g.v;
            if (r15 <= 0) goto L30;
            r14.put("device_current", Float.valueOf(g.u / r15));
        L30:
            g.a().getClass();
            r14.put("battery_temperature", Float.valueOf(BatteryMonitor.g));
            g.a().getClass();
            r14.put("battery_level", Float.valueOf(BatteryMonitor.e));
            if (g.s <= 0.0f) goto L33;
            g.a().getClass();
            r14.put("battery_level_change", Float.valueOf(BatteryMonitor.e - g.s));
        L33:
            g.a().getClass();
            g.s = BatteryMonitor.e;
            g.a().getClass();
            r14.put("battery_change_counter_uah", BatteryMonitor.h);
            if (g.t <= 0) goto L36;
            g.a().getClass();
            r14.put("battery_change_counter_uah_change", BatteryMonitor.h - g.t);
        L36:
            g.a().getClass();
            g.t = BatteryMonitor.h;
            r14.put("cpu_core_count", r6);
            r14.put("device_cpu_time", r10);
            r14.put("device_idle_time", r12);
            com.obric.performance.power.monitor.cpu.a r16 = g.r;
            if (r16 == null) goto L41;
            com.obric.performance.power.monitor.cpu.c r17 = r16.h;
            if (r17 == null) goto L41;
            Object r2 = Double.valueOf(r17.d);
        L42:
            r14.put("device_cpu_usage", r2);
            if (r13 <= 0) goto L46;
            if (r6 <= 0) goto L46;
            r14.put("device_cpu_speed", Float.valueOf(((r10 - r12) / r13) / r6));
        L46:
            com.obric.performance.power.monitor.cpu.a r18 = g.r;
            if (r18 == null) goto L51;
            com.obric.performance.power.monitor.cpu.c r19 = r18.h;
            if (r19 == null) goto L51;
            long r20 = r19.h;
        L52:
            r14.put("process_cpu_time", r20);
            r14.put("process_wall_time", r13);
            com.obric.performance.power.monitor.cpu.a r21 = g.r;
            if (r21 == null) goto L57;
            com.obric.performance.power.monitor.cpu.c r22 = r21.h;
            if (r22 == null) goto L57;
            Object r23 = Double.valueOf(r22.a);
        L58:
            r14.put("process_cpu_usage", r23);
            com.obric.performance.power.monitor.cpu.a r24 = g.r;
            if (r24 == null) goto L63;
            com.obric.performance.power.monitor.cpu.c r25 = r24.h;
            if (r25 == null) goto L63;
            Object r26 = Double.valueOf(r25.b);
        L64:
            r14.put("process_cpu_speed", r26);
            if (pna.a.b == true) goto L207;
            r1.d("PowerMonitor", "ThreadMonitor getCount: canRead=false, return 0");
        L73:
            int r27 = 0;
        L74:
            r14.put("process_thread_count", r27);
            List<Pair<Integer, Long>> r28 = com.obric.performance.power.monitor.cpu.d.c;
            r14.put("process_wake_lock_count", r28.size());
            monitor-enter(r28);
            Iterator<T> r29 = r28.iterator();     // Catch: Throwable -> L140
            long r30 = 0;
        L78:
            if (r29.hasNext() == false) goto L82;
            Pair r31 = (Pair) r29.next();     // Catch: Throwable -> L140
            List<Pair<Integer, Long>> r110 = r28;
            r30 = r30 + (SystemClock.uptimeMillis() - Math.max(com.obric.performance.power.monitor.cpu.d.b, ((Number) r31.getSecond()).longValue()));     // Catch: Throwable -> L138
            r28 = r110;
        L138:
            th = th;
        L142:
            monitor-exit(r110);
            throw th;
        L82:
            r110 = r28;
            long r32 = r30 + com.obric.performance.power.monitor.cpu.d.a;     // Catch: Throwable -> L138
            com.obric.performance.power.monitor.cpu.d.a = 0;     // Catch: Throwable -> L138
            com.obric.performance.power.monitor.cpu.d.b = SystemClock.uptimeMillis();     // Catch: Throwable -> L138
            monitor-exit(r110);
            r14.put("process_wake_lock_walltime", r32);
            int r3 = nna.a.a;
            nna.a.a = 0;
            r14.put("process_gps_request_count", r3);
            r14.put("process_gps_listener_count", nna.a.d.size());
            r14.put("process_gps_listener_time", nna.a.b());
            r14.put("process_sensor_listener_count", ona.b.c.size());
            r14.put("process_sensor_listener_time", ona.b.b());
            r14.put("process_camera_count", jna.a.c.size());
            r14.put("process_camera_time", jna.a.c());
            r14.put("process_audio_in_count", hna.a.c.size());
            r14.put("process_audio_in_time", hna.a.a());
            r14.put("process_audio_count", gna.a.c.size());
            r14.put("process_audio_time", gna.a.b());
            r14.put("process_bluetooth_scan_count", ina.a.d.size() + ina.a.c);
            r14.put("process_bluetooth_scan_time", ina.a.a());
            Lazy r33 = g.w;
            r14.put("process_name", (String) r33.getValue());
            String r34 = g.f.b();
            if (r34 != null) goto L87;
            r34 = "";
        L87:
            r14.put("activity", r34);
            r14.put("is_background", g.g);
            boolean r35 = !g.j;
            if (r35 == true) goto L90;
        L92:
            boolean r36 = false;
        L93:
            r14.put("is_all_foreground", r36);
            if (r35 == true) goto L96;
        L98:
            boolean r37 = false;
        L99:
            r14.put("is_all_background", r37);
            r14.put("is_screen_on", g.h);
            boolean r38 = !g.l;
            if (r38 == true) goto L102;
        L104:
            boolean r39 = false;
        L105:
            r14.put("is_all_screen_on", r39);
            if (r38 == true) goto L108;
        L110:
            boolean r40 = false;
        L111:
            r14.put("is_all_screen_off", r40);
            int r41 = g.o;
            g.o = r41 + 1;
            r14.put("report_index", r41);
            g.a().getClass();
            r14.put("is_charging", BatteryMonitor.f);
            boolean r42 = true;
            boolean r43 = !g.n;
            if (r43 == true) goto L114;
        L116:
            boolean r44 = false;
        L117:
            r14.put("is_all_charging", r44);
            if (r43 == true) goto L120;
        L122:
            boolean r45 = false;
        L123:
            r14.put("is_all_not_charging", r45);
            kna.d r46 = g.e;
            if (r46 == null) goto L201;
            r46.a(r14);
        L201:
            Context r47 = g.d;     // Catch: Exception -> L135
            if (r47 == null) goto L137;
            String r48 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US).format(new Date()) + "  " + Process.myPid() + "  " + ((String) r33.getValue()) + "  " + r14 + '\n';     // Catch: Exception -> L135
            PolarisFileWrapper r49 = new PolarisFileWrapper(r47.getFilesDir(), "performance");     // Catch: Exception -> L135
            if (r49.exists() == true) goto L133;
            r49.mkdirs();     // Catch: Exception -> L135
        L133:
            FilesKt.appendText$default(new PolarisFileWrapper(r49, "power.txt"), r48, null, 2, null);     // Catch: Exception -> L135
        L137:
            g.u = 0.0f;
            g.v = 0;
        L146:
            if (g.g == false) goto L151;
            if (new Random().nextFloat() < g.c.getBackgroundSampledRate()) goto L154;
        L153:
            r42 = false;
        L154:
            g.p = r42;
            if (IRuntimeContext.a.a() == false) goto L157;
            g.b().removeCallbacks(g.z);
        L157:
            g.a().getClass();
            if (BatteryMonitor.c == null) goto L173;
            ILogDepend.a.d("PowerMonitor", "BatteryMonitor unregisterBatteryReceiver");
            Context r50 = BatteryMonitor.b;
            if (r50 == null) goto L172;
            BatteryMonitor.BatteryInfoReceiver r51 = BatteryMonitor.c;
            ReceiverRegisterLancet.loge(r51, false);
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L199;
            r50.unregisterReceiver(r51);
            goto L172
        L199:
        L167:
            e = move-exception;
            if (r51 == null) goto L170;
            Npth.addTag("unregisterReceiver", r51.toString());
        L170:
            e.printStackTrace();
            goto L172
        L164:
            if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r51, r50) == false) goto L172;
            r50.unregisterReceiver(r51);     // Catch: Exception -> L167
        L172:
            BatteryMonitor.c = null;
            BatteryMonitor.b = null;
        L173:
            g.a().d(g.x);
            if (g.p == false) goto L194;
            ILogDepend.Companion r52 = ILogDepend.a;
            r52.d("PowerMonitor", "reportRunnable sampled");
            g.i = g.g;
            g.j = false;
            g.k = g.h;
            g.l = false;
            com.obric.performance.power.monitor.cpu.a r53 = g.r;
            if (r53 == null) goto L179;
            r53.a();
        L179:
            if (IRuntimeContext.a.a() == false) goto L181;
            g.b().post(g.z);
        L181:
            Context r54 = g.d;
            if (r54 == null) goto L193;
            g.a().getClass();
            Intrinsics.checkNotNullParameter(r54, "context");
            if (BatteryMonitor.c != null) goto L192;
            if (BatteryMonitor.b != null) goto L192;
            BatteryMonitor.b = r54;     // Catch: Throwable -> L197
            r52.d("PowerMonitor", "BatteryMonitor registerBatteryReceiver");     // Catch: Throwable -> L197
            BatteryMonitor.c = new BatteryMonitor.BatteryInfoReceiver();     // Catch: Throwable -> L197
            Intent r55 = BatteryMonitor.a(r54, BatteryMonitor.c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Throwable -> L197
            if (r55 == null) goto L192;
            BatteryMonitor.c(r55);     // Catch: Throwable -> L197
        L192:
            g.a().b(g.x);
        L193:
            g.a().getClass();
            g.m = BatteryMonitor.f;
            g.n = false;
        L195:
            g.b().postDelayed(this, g.c.getReportIntervalMillis());
            return;
        L194:
            ILogDepend.a.d("PowerMonitor", "reportRunnable not sampled");
            List<Pair<Integer, Long>> r56 = com.obric.performance.power.monitor.cpu.d.c;
            com.obric.performance.power.monitor.cpu.d.b = SystemClock.uptimeMillis();
            int r57 = ina.a.c;
            ina.a.b = SystemClock.uptimeMillis();
            List<Pair<String, Long>> r58 = jna.a.c;
            jna.a.b = SystemClock.uptimeMillis();
            List<Pair<ona.a, Long>> r59 = ona.b.c;
            ona.b.b = SystemClock.uptimeMillis();
            int r60 = nna.a.a;
            nna.a.c = SystemClock.uptimeMillis();
            List<Pair<Integer, Long>> r61 = hna.a.c;
            hna.a.b = SystemClock.uptimeMillis();
            List<Pair<Integer, Long>> r62 = gna.a.c;
            gna.a.b = SystemClock.uptimeMillis();
            goto L195
        L151:
            if (new Random().nextFloat() >= g.c.getFrontSampledRate()) goto L153;
        L135:
            e = move-exception;
            ILogDepend.a.d("PowerMonitor", "writePowerToFile failed: " + e.getMessage());
            goto L137
        L120:
            if (g.m == true) goto L122;
            r45 = true;
            goto L123
        L114:
            if (g.m == false) goto L116;
            r44 = true;
            goto L117
        L108:
            if (g.k == true) goto L110;
            r40 = true;
            goto L111
        L102:
            if (g.k == false) goto L104;
            r39 = true;
            goto L105
        L96:
            if (g.i == false) goto L98;
            r37 = true;
            goto L99
        L90:
            if (g.i == true) goto L92;
            r36 = true;
        L140:
            th = th;
            r110 = r28;
            goto L142
        L207:
            File[] r63 = pna.a.a.listFiles();     // Catch: Throwable -> L198
            if (r63 == null) goto L70;
            r27 = r63.length;     // Catch: Throwable -> L198
        L71:
            r1.d("PowerMonitor", "ThreadMonitor getCount: " + r27);     // Catch: Throwable -> L198
        L70:
            r27 = 0;
        L63:
            r26 = -1;
        L57:
            r23 = -1;
        L51:
            r20 = -1;
        L41:
            r2 = -1;
        L26:
            r13 = -1;
        L21:
            r12 = -1;
        L16:
            r10 = -1;
            goto L17
        L10:
            r6 = -1;
            goto L11
        L144:
            r42 = true;
            goto L146
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
        a = LazyKt.lazy(new fna.a());
        b = LazyKt.lazy(new fna.b());
        c = new ObricPerformancePowerMonitorConfig(false, false, 0, 0, 0.0f, 0.0f, 63, null);
        f = kna.a.a;
        int r0 = kna.b.a;
        g = true;
        i = true;
        o = 1;
        q = LazyKt.lazy(new fna.c());
        w = LazyKt.lazy(new d());
        x = new a();
        y = new c();
        z = new b();
    }

    public static BatteryMonitor a() {
        return (BatteryMonitor) q.getValue();
    }

    public static Handler b() {
        return (Handler) b.getValue();
    }

    public static boolean d() {
        if (c.getEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (p == false) goto L7;
        return true;
    }

    public static void c(kna.f r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        ObricPerformancePowerMonitorConfig r0 = r3.b;
        c = r0;
        if (r0.getEnabled() == true) goto L6;
        ILogDepend.a.d("PowerMonitor", "disabled, return");
        return;
    L6:
        d = r3.getContext();
        e = r3.c;
        kna.c r1 = r3.d;
        f = r1;
        kna.e r2 = r3.e;
        r1.c(new e());
        r3.e.b(new f());
        g = r3.d.a();
        h = r3.e.a();
        ILogDepend.a.d("PowerMonitor", "init, isBackground: " + g);
        r = new com.obric.performance.power.monitor.cpu.a(true, null, true, 8);
        b().post(y);
    }
}
