package com.bytedance.apm.battery;

import android.app.Activity;
import android.app.Application;
import android.os.BatteryManager;
import android.os.Build;
import android.os.SystemClock;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.crash.dumper.Scraps;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends com.bytedance.apm.h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f1173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f1174b;
    int c;
    int d;
    long e;
    long f;
    private boolean h;
    private long i;
    private long j;
    private long k;
    private final ConcurrentHashMap<String, Long> l;
    private final LinkedList<b> m;
    private final LinkedList<b> n;
    private int o;
    private long p;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f1175a = null;

        static {
            f1175a = new f();
        }

        static /* synthetic */ f a() {
            return f1175a;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f1177b;
        public long c;
        public long d;
        public long e;

        private b() {
        }

        public long a() {
            return this.d - this.f1177b;
        }

        public long b() {
            return this.e - this.c;
        }

        public double c() {
            double r0 = a() / 1000.0d;
            if (r0 > 0.0d) goto L5;
            return 0.0d;
        L5:
            return (Math.round(b() / r0) * 100) / 100.0d;
        }

        public String toString() {
            return String.format("Scene{ name=%s, cpu=%s ms, dur=%s ms, speed=%s", new Object[]{this.f1176a, Long.valueOf(b()), Long.valueOf(a()), Double.valueOf(c())});
        }
    }

    public f() {
        this.l = new ConcurrentHashMap();
        this.m = new LinkedList();
        this.n = new LinkedList();
        this.o = 0;
        this.f1173a = 0;
        this.f1174b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = Scraps.BATTERY;
    }

    public static f a() {
        return a.a();
    }

    private void h() {
        long r0 = SystemClock.uptimeMillis();
        long r2 = this.e;
        if ((this.j + r2) <= r0) goto L5;
        return;
    L5:
        long r3 = r0 - r2;
        this.e = r0;
        int r1 = ((BatteryManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSystemService("batterymanager"), BatteryManager.class, "com.obric.memorydata.plugin")).getIntProperty(4);
        int r4 = r1 - this.d;
        if (this.f == this.o) goto L8;
    L13:
        this.d = r1;
        this.f = this.o;
        return;
    L8:
        if (l() == true) goto L13;
        if (r4 > 0) goto L13;
        int r5 = Math.abs(r4);
        if (r5 > 100) goto L13;
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L15
        r6.put(Scraps.BATTERY, Math.abs(r5));     // Catch: Exception -> L15
        r6.put("duraion", r3);     // Catch: Exception -> L15
        CommonEventDeliverer.monitorEvent("apm_battery_monitor", null, r6, null);     // Catch: Exception -> L15
        goto L13
    }

    private void i() {
        long r0 = SystemClock.uptimeMillis();
        if ((this.p + this.k) <= r0) goto L5;
        return;
    L5:
        this.p = r0;
        LinkedList<b> r1 = this.n;
        monitor-enter(r1);
        Iterator<b> r2 = this.n.iterator();     // Catch: Throwable -> L16
    L9:
        if (r2.hasNext() == false) goto L13;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r2.next(), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L19 Throwable -> L16
        r4.put(MemoryInfoSectionEditActivity.KIND_SCENE, r3.f1176a);     // Catch: Exception -> L19 Throwable -> L16
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L19 Throwable -> L16
        r5.put("cpu_speed", r3.c());     // Catch: Exception -> L19 Throwable -> L16
        CommonEventDeliverer.monitorEvent("apm_proc_cpu_info", r4, r5, null);     // Catch: Exception -> L19 Throwable -> L16
        goto L9
    L13:
        this.n.clear();     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.h.a, com.bytedance.services.apm.api.d
    public void a(Activity r3) {
        super.a((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"));
        this.o++;
    }

    @Override // com.bytedance.apm.h.a
    public void a(JSONObject r5) {
        boolean r1 = true;
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L7:
        r1 = false;
    L8:
        this.h = r1;
        if (r1 == false) goto L11;
        this.i = r5.optLong("power_cpu_monitor_interval", 60000);
        this.j = r5.optLong("power_battery_monior_interval", 300000);
        this.k = r5.optLong("power_proc_cpu_upload_interval", 120000);
        return;
    L11:
        ActivityLifeObserver.getInstance().unregister(this);
        com.bytedance.apm.l.b.a().b(this);
        return;
    L5:
        if (r5.optInt("power_monitor_enable", 0) != 1) goto L7;
        goto L7
    }

    @Override // com.bytedance.apm.h.a, com.bytedance.services.apm.api.d
    public void b(Activity r3) {
        super.b((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"));
        this.o++;
    }

    @Override // com.bytedance.apm.h.a
    public void b_() {
        super.b_();
    }

    @Override // com.bytedance.apm.h.a
    public boolean c() {
        return this.h;
    }

    @Override // com.bytedance.apm.h.a
    public long d() {
        return this.i;
    }

    @Override // com.bytedance.apm.h.a
    public void e() {
        super.e();
        g();
        h();
        i();
    }

    public void g() {
        long r0 = com.bytedance.apm.util.b.d();
        long r2 = SystemClock.uptimeMillis();
        long r4 = this.f1174b;
        if (r4 != 0) goto L5;
    L14:
        this.c = this.o;
        this.f1173a = r0;
        this.f1174b = r2;
        return;
    L5:
        if (this.c != this.o) goto L14;
        double r5 = (r2 - r4) / 60000.0d;
        if (r5 <= 0.0d) goto L14;
        double r6 = Math.round(((r0 - this.f1173a) / r5) * 100.0d) / 100.0d;
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L16
        if (l() == false) goto L12;
        String r8 = TraceCons.METRIC_BACKGROUND;
    L13:
        r7.put("status", r8);     // Catch: Exception -> L16
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L16
        r9.put("cpu_speed_min", r6);     // Catch: Exception -> L16
        CommonEventDeliverer.monitorEvent("apm_cpu_speed", r7, r9, null);     // Catch: Exception -> L16
        goto L14
    L12:
        r8 = "foreground";
        goto L13
    }
}
