package k;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.dumper.Scraps;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import l0.h;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends i0.a implements s.a.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f9960l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f9961m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f9962n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ConcurrentHashMap<String, C0211b> f9963o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Object f9964p;

    class a implements ub.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f9965a;

        a(b r10) {
            this.f9965a = r10;
        }

        @Override // ub.b
        public void a() {
            b.o(this.f9965a);
        }
    }

    /* JADX INFO: renamed from: k.b$b, reason: collision with other inner class name */
    public class C0211b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f9966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f9967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f9968c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f9969d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        StringBuilder f9970e;

        long a() {
            return this.f9967b;
        }

        public long b() {
            return this.f9969d;
        }

        float c() {
            return this.f9966a;
        }

        String d() {
            return this.f9970e.toString();
        }

        long e() {
            return this.f9968c;
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f9971a = null;

        static {
            f9971a = new b(null);
        }

        static /* synthetic */ b a() {
            return f9971a;
        }
    }

    private b() {
        this.f9963o = new ConcurrentHashMap();
        this.f9964p = new Object();
        h.e();
        new CopyOnWriteArrayList();
        new a(this);
        this.f9290j = Scraps.BATTERY;
    }

    /* synthetic */ b(a r10) {
        this();
    }

    static /* synthetic */ void o(b r10) {
        r10.r();
    }

    private void p() {
        if (TextUtils.isEmpty(this.f9962n) == true) goto L6;
        this.f9962n = null;
        q0.b.f().m(this);
        ub.a.a();
        r();
        return;
    }

    public static b q() {
        return c.a();
    }

    private void r() {
    }

    @Override // s.a.b
    public void a(boolean r10) {
        if (r10 == false) goto L11;
        Object r11 = this.f9964p;
        monitor-enter(r11);
        p();     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L8:
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
        this.f9960l = r11;
        if (r11 == false) goto L11;
        r10.optInt("battery_energy_sample_interval", 3000);
        this.f9961m = r10.optLong("battery_energy_upload_interval", AnrManager.ANR_MIN_INTERVAL);
        return;
    L11:
        ActivityLifeObserver.getInstance().unregister(this);
        q0.b.f().m(this);
        return;
    L5:
        if (r10.optInt("energy_enable", 0) != 1) goto L7;
        goto L7
    }

    @Override // i0.a
    protected boolean f() {
        return !e();
    }

    @Override // i0.a
    protected void h() {
        s.a.d(com.bytedance.apm.d.g(), this);
    }

    @Override // i0.a
    protected void i() {
        super.i();
        Iterator<Map.Entry<String, C0211b>> r10 = this.f9963o.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Map.Entry<String, C0211b> r11 = r10.next();
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L10
        JSONObject r13 = new JSONObject();     // Catch: JSONException -> L10
        r13.put("scene", r11.getKey());     // Catch: JSONException -> L10
        r12.put("current", r11.getValue().c());     // Catch: JSONException -> L10
        r12.put("capacity", r11.getValue().b());     // Catch: JSONException -> L10
        JSONObject r14 = new JSONObject();     // Catch: JSONException -> L10
        r14.put("cpu_time", r11.getValue().a());     // Catch: JSONException -> L10
        r14.put("traffic", r11.getValue().e());     // Catch: JSONException -> L10
        r14.put("loc", r11.getValue().d());     // Catch: JSONException -> L10
        y.e r15 = new y.e(Scraps.BATTERY, "", r12, r13, r14);     // Catch: JSONException -> L10
        i0.b.a(r15, false);     // Catch: JSONException -> L10
        x.a.p().e(r15);     // Catch: JSONException -> L10
        goto L4
    L8:
        this.f9963o.clear();
    }

    @Override // i0.a
    protected void j() {
        super.j();
    }

    @Override // i0.a
    protected long n() {
        return this.f9961m;
    }

    @Override // i0.a, t4.d
    public void onBackground(Activity r10) {
        super.onBackground(r10);
        q0.b.f().m(this);
        Object r11 = this.f9964p;
        monitor-enter(r11);
        p();     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // i0.a, t4.d
    public void onFront(Activity r10) {
        super.onFront(r10);
    }
}
