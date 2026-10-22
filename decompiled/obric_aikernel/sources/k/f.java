package k;

import android.app.Activity;
import android.os.BatteryManager;
import android.os.Build;
import android.os.SystemClock;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends i0.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f9988l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f9989m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f9990n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f9991o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final LinkedList<b> f9992p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f9993q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    long f9994r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    long f9995s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f9996t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f9997u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    long f9998v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    long f9999w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f10000x;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f10001a = null;

        static {
            f10001a = new f();
        }

        static /* synthetic */ f a() {
            return f10001a;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f10003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f10004c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f10005d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f10006e;

        private b() {
        }

        public double a() {
            double r10 = c() / 1000.0d;
            if (r10 > 0.0d) goto L5;
            return 0.0d;
        L5:
            return (Math.round(b() / r10) * 100) / 100.0d;
        }

        public long b() {
            return this.f10006e - this.f10004c;
        }

        public long c() {
            return this.f10005d - this.f10003b;
        }

        public String toString() {
            return String.format("Scene{ name=%s, cpu=%s ms, dur=%s ms, speed=%s", new Object[]{this.f10002a, Long.valueOf(b()), Long.valueOf(c()), Double.valueOf(a())});
        }
    }

    public f() {
        new ConcurrentHashMap();
        new LinkedList();
        this.f9992p = new LinkedList();
        this.f9993q = 0;
        this.f9994r = 0;
        this.f9995s = 0;
        this.f9996t = 0;
        this.f9997u = 0;
        this.f9998v = 0;
        this.f9999w = 0;
        this.f9290j = Scraps.BATTERY;
    }

    private void o() {
        long r10 = SystemClock.uptimeMillis();
        long r11 = this.f9998v;
        if ((this.f9990n + r11) <= r10) goto L5;
        return;
    L5:
        long r12 = r10 - r11;
        this.f9998v = r10;
        int r13 = ((BatteryManager) ApmBaseContext.getContext().getSystemService("batterymanager")).getIntProperty(4);
        int r14 = r13 - this.f9997u;
        if (this.f9999w == this.f9993q) goto L8;
    L13:
        this.f9997u = r13;
        this.f9999w = this.f9993q;
        return;
    L8:
        if (e() == true) goto L13;
        if (r14 > 0) goto L13;
        int r15 = Math.abs(r14);
        if (r15 > 100) goto L13;
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L15
        r16.put(Scraps.BATTERY, Math.abs(r15));     // Catch: Exception -> L15
        r16.put("duraion", r12);     // Catch: Exception -> L15
        CommonEventDeliverer.monitorEvent("apm_battery_monitor", null, r16, null);     // Catch: Exception -> L15
        goto L13
    }

    public static f q() {
        return a.a();
    }

    private void r() {
        long r10 = SystemClock.uptimeMillis();
        if ((this.f10000x + this.f9991o) <= r10) goto L5;
        return;
    L5:
        this.f10000x = r10;
        LinkedList<b> r11 = this.f9992p;
        monitor-enter(r11);
        Iterator<b> r12 = this.f9992p.iterator();     // Catch: Throwable -> L16
    L9:
        if (r12.hasNext() == false) goto L13;
        b r13 = r12.next();     // Catch: Throwable -> L16
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L19 Throwable -> L16
        r14.put("scene", r13.f10002a);     // Catch: Exception -> L19 Throwable -> L16
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L19 Throwable -> L16
        r15.put("cpu_speed", r13.a());     // Catch: Exception -> L19 Throwable -> L16
        CommonEventDeliverer.monitorEvent("apm_proc_cpu_info", r14, r15, null);     // Catch: Exception -> L19 Throwable -> L16
        goto L9
    L13:
        this.f9992p.clear();     // Catch: Throwable -> L16
        monitor-exit(r11);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // i0.a
    protected void c(JSONObject r10) {
        boolean r11 = true;
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L7:
        r11 = false;
    L8:
        this.f9988l = r11;
        if (r11 == false) goto L11;
        this.f9989m = r10.optLong("power_cpu_monitor_interval", VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER);
        this.f9990n = r10.optLong("power_battery_monior_interval", 300000);
        this.f9991o = r10.optLong("power_proc_cpu_upload_interval", AnrManager.ANR_MIN_INTERVAL);
        return;
    L11:
        ActivityLifeObserver.getInstance().unregister(this);
        q0.b.f().m(this);
        return;
    L5:
        if (r10.optInt("power_monitor_enable", 0) != 1) goto L7;
        goto L7
    }

    @Override // i0.a
    protected boolean f() {
        return this.f9988l;
    }

    @Override // i0.a
    protected void i() {
        super.i();
        p();
        o();
        r();
    }

    @Override // i0.a
    protected void j() {
        super.j();
    }

    @Override // i0.a
    protected long n() {
        return this.f9989m;
    }

    @Override // i0.a, t4.d
    public void onBackground(Activity r10) {
        super.onBackground(r10);
        this.f9993q++;
    }

    @Override // i0.a, t4.d
    public void onFront(Activity r10) {
        super.onFront(r10);
        this.f9993q++;
    }

    public void p() {
        long r10 = com.bytedance.apm.util.b.b();
        long r11 = SystemClock.uptimeMillis();
        long r12 = this.f9995s;
        if (r12 != 0) goto L5;
    L14:
        this.f9996t = this.f9993q;
        this.f9994r = r10;
        this.f9995s = r11;
        return;
    L5:
        if (this.f9996t != this.f9993q) goto L14;
        double r13 = (r11 - r12) / 60000.0d;
        if (r13 <= 0.0d) goto L14;
        double r14 = Math.round(((r10 - this.f9994r) / r13) * 100.0d) / 100.0d;
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L16
        if (e() == false) goto L12;
        String r16 = "background";
    L13:
        r15.put("status", r16);     // Catch: Exception -> L16
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L16
        r17.put("cpu_speed_min", r14);     // Catch: Exception -> L16
        CommonEventDeliverer.monitorEvent("apm_cpu_speed", r15, r17, null);     // Catch: Exception -> L16
        goto L14
    L12:
        r16 = "foreground";
        goto L13
    }
}
