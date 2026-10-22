package com.ss.android.lark.monitor.callback;

import bsb.e;
import bsb.f;
import bsb.g;
import bsb.i;
import bsb.k;
import com.bytedance.apm.internal.ApmDelegate;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.MonitorModule;
import com.ss.android.lark.monitor.cpu.CpuSceneMonitor;
import com.ss.android.lark.monitor.downgrade.DowngradeSetting;
import com.ss.android.lark.monitor.temperature.TemperaturePerfMonitor;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;
import java.lang.ref.SoftReference;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DevicePerfManager {
    public final CopyOnWriteArrayList<a> a;
    public d b;
    public d c;
    public d d;
    public final bsb.c e;
    public DowngradeSetting.a.C0185a f;
    public DowngradeSetting.c.a g;
    public DowngradeSetting.b.a h;
    public int i;
    public int j;
    public boolean k;
    public boolean l;

    public static final enum PerfType extends Enum<PerfType> {
        public static final PerfType ALL = null;
        public static final PerfType CPU = null;
        public static final PerfType MEMORY = null;
        public static final PerfType TEMPERATURE = null;
        public static final /* synthetic */ PerfType[] a = null;

        static {
            PerfType r0 = new PerfType("ALL", 0);
            ALL = r0;
            PerfType r1 = new PerfType("TEMPERATURE", 1);
            TEMPERATURE = r1;
            PerfType r3 = new PerfType("CPU", 2);
            CPU = r3;
            PerfType r5 = new PerfType("MEMORY", 3);
            MEMORY = r5;
            a = new PerfType[]{r0, r1, r3, r5};
        }

        public static PerfType[] values() {
            return (PerfType[]) a.clone();
        }

        public static PerfType valueOf(String r1) {
            return (PerfType) r27.a.a(PerfType.class, r1);
        }

        public PerfType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static class a {
        public final SoftReference<c> a;
        public final PerfType b;
        public final DowngradeSetting.a.C0185a c;
        public final String d;
        public long e;

        public a(SoftReference r3, PerfType r4, dsb.b r5) {
            this.e = 0;
            this.a = r3;
            this.d = "TurboModeDetector";
            this.b = r4;
            if (r4 == PerfType.CPU) goto L5;
            return;
        L5:
            if ((r5 instanceof dsb.a) == false) goto L12;
            DowngradeSetting.a.C0185a r6 = new DowngradeSetting.a.C0185a();
            this.c = r6;
            dsb.a r7 = (dsb.a) r5;
            int r8 = r7.b();
            if (r8 != 0) goto L9;
            r8 = 10;
        L9:
            r6.CPU_CHECK_TIME = r8;
            r6.BUSY_USAGE = r7.a();
            r6.NORMAL_USAGE = r7.c();
            return;
        }
    }

    public static class b {
        public static final DevicePerfManager a = null;

        static {
            a = new DevicePerfManager();
        }
    }

    public interface c {
        void a(int r1);
    }

    public static class d {
        public String a;
        public final PerfType b;
        public long c;
        public int d;

        public d(PerfType r1) {
            this.b = r1;
        }
    }

    public final int b() {
        bsb.c r0 = this.e;
        int r1 = r0.e;
        int r2 = 3;
        if (r1 == 3) goto L21;
        int r3 = r0.g;
        if (r3 == 3) goto L21;
        int r4 = r0.c;
        if (r4 == 3) goto L21;
        r2 = 2;
        if (r1 == 2) goto L21;
        if (r3 == 2) goto L21;
        if (r4 == 2) goto L21;
        r2 = 1;
        if (r1 == 1) goto L21;
        if (r3 == 1) goto L21;
        if (r4 == 1) goto L21;
        return 0;
    L21:
        return r2;
    }

    public DevicePerfManager() {
        this.a = new CopyOnWriteArrayList();
        this.e = new bsb.c();
        this.k = false;
        this.l = false;
    }

    public final void a(com.ss.android.lark.monitor.d... r6) {
        if (z.e(com.larksuite.framework.utils.b.a) == true) goto L5;
        return;
    L5:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.android.app.monitor.downgrade_enable") == false) goto L45;
        Log.i("DevicePerfManager", "init DevicePerf");
        DowngradeSetting r1 = (DowngradeSetting) SettingManager.getInstance().get(DowngradeSetting.class);
        if (r1.temperatureValve != null) goto L10;
        r1.temperatureValve = new DowngradeSetting.c();
    L10:
        if (r1.cpuValve != null) goto L13;
        r1.cpuValve = new DowngradeSetting.a();
    L13:
        if (r1.memoryValve != null) goto L15;
        r1.memoryValve = new DowngradeSetting.b();
    L15:
        this.g = r1.temperatureValve.commonValve;
        this.f = r1.cpuValve.commonValve;
        this.h = r1.memoryValve.commonValve;
        int r2 = 0;
        this.e.h = false;
        DevicePerfUtils.DevicePerfLevel r3 = DevicePerfUtils.d();
        Log.i("DevicePerfManager", "initDevicePerfInfo:" + r3);
        if (r3.ordinal() < DevicePerfUtils.DevicePerfLevel.LOW.ordinal()) goto L18;
        this.e.h = true;
    L18:
        this.e.i = r3.ordinal() - 1;
        bsb.c r0 = this.e;
        r0.a = r0.i;
        if (this.g != null) goto L22;
        this.g = new DowngradeSetting.c.a();
    L22:
        if (this.f != null) goto L25;
        this.f = new DowngradeSetting.a.C0185a();
    L25:
        if (this.h != null) goto L27;
        this.h = new DowngradeSetting.b.a();
    L27:
        DowngradeSetting.a.C0185a r4 = this.f;
        this.i = r4.BUSY_USAGE;
        this.j = r4.NORMAL_USAGE;
        noc.c r5 = noc.c.b.a;
        ((CopyOnWriteArrayList) r5.i).add(new e(this));
        int r7 = r6.length;
    L28:
        if (r2 >= r7) goto L46;
        com.ss.android.lark.monitor.d r8 = r6[r2];
        if ((r8 instanceof CpuSceneMonitor) == false) goto L33;
        ((CpuSceneMonitor) r8).addCpuPerfCallback(new f(this));
    L38:
        r2 = r2 + 1;
        goto L28
    L33:
        if ((r8 instanceof esb.b) == false) goto L36;
        ((esb.b) r8).b.add(new g(this));
        goto L38
    L36:
        if ((r8 instanceof TemperaturePerfMonitor) == false) goto L38;
        TemperaturePerfMonitor r9 = (TemperaturePerfMonitor) r8;
        k r10 = new k(this);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "temperaturePerfCallback");
        r9.b.add(r10);
        goto L38
    L46:
        return;
    }

    public final void c(boolean r3, int r4) {
        if (r4 == this.e.c) goto L5;
    L7:
        Log.i("DevicePerfManager", "notifyTemperatureState:" + r3 + " ,level:" + r4);
        bsb.c r0 = this.e;
        r0.b = r3;
        r0.c = r4;
        if (this.b != null) goto L10;
        this.b = new d(PerfType.TEMPERATURE);
    L10:
        d(this.b, r4);
        this.e.a = b();
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new i(this));
        return;
    L5:
        if (r4 == 3) goto L7;
    }

    public final void d(d r12, int r13) {
        if (ApmDelegate.g.a.f == true) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        return;
    L12:
        if (r12.c != 0) goto L21;
    L17:
        if (r13 != 0) goto L19;
        r12.c = 0;
        return;
    L19:
        r12.c = System.currentTimeMillis();
        r12.a = MonitorModule.e().d();
        r12.d = r13;
        return;
    L21:
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L15
        r2.put("type", r12.b.name().toLowerCase());     // Catch: JSONException -> L15
        r2.put("time", (System.currentTimeMillis() - r12.c) / 1000);     // Catch: JSONException -> L15
        r2.put("level", r12.d);     // Catch: JSONException -> L15
        r2.put("device_level", this.e.i);     // Catch: JSONException -> L15
        r2.put("start_scene", r12.a);     // Catch: JSONException -> L15
        r2.put("end_scene", MonitorModule.e().d());     // Catch: JSONException -> L15
        isb.a.c("PerfException", r2);     // Catch: JSONException -> L15
        Log.i("DevicePerfManager", "PerfException:" + r2);     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L5:
        if (zs3.c.a.getServiceSwitch("PerfException") == true) goto L8;
        r1 = false;
        goto L9
    }
}
