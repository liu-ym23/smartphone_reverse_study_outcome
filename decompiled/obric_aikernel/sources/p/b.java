package p;

import androidx.annotation.WorkerThread;
import androidx.work.WorkRequest;
import com.bytedance.apm.d;
import com.bytedance.crash.dumper.Scraps;
import org.json.JSONObject;
import y.e;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private long A;
    private long B;
    private int C;
    private int D;
    private int E;
    private int F;
    private long G;
    private long H;
    private long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private long f12286J;
    private int K;
    private int L;
    private int M;
    private int N;
    private long O;
    private long P;
    private long Q;
    private long R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f12287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f12288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f12289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f12290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f12291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f12292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f12293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f12294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f12295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f12296j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f12297k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f12298l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f12299m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f12300n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f12301o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f12302p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f12303q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f12304r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f12305s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f12306t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f12307u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f12308v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f12309w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f12310x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f12311y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f12312z;

    public b() {
        this.f12291e = 0;
        this.f12292f = 0;
        this.f12293g = 0;
        this.f12294h = 0;
        this.f12295i = 0;
        this.f12296j = 0;
        this.f12297k = 0;
        this.f12298l = 0;
        this.f12299m = 0;
        this.f12300n = 0;
        this.f12301o = 0;
        this.f12302p = 0;
        this.f12303q = 0;
        this.f12304r = 0;
        this.f12305s = 0;
        this.f12306t = 0;
        this.f12307u = 0;
        this.f12309w = true;
        this.I = 0;
        this.f12286J = 0;
        this.Q = 0;
        this.R = 0;
    }

    private boolean u(boolean r10) {
        JSONObject r11 = v(r10);
        if (r11 != null) goto L6;
        return false;
    L6:
        if (r11.length() != 0) goto L8;
        return true;
    L8:
        JSONObject r12 = new JSONObject();
        r12.put("is_main_process", this.f12309w);
        r12.put("process_name", this.f12310x);
        r12.put("scene", this.f12312z);
        r12.put("is_charging", this.f12308v ? 1 : 0);
        JSONObject r13 = new JSONObject();
        r13.put("sid", this.f12311y);
        e r14 = new e(Scraps.BATTERY, "", r11, r12, r13);
        i0.b.a(r14, false);
        x.a.p().e(r14);
        if (d.D() == false) goto L11;
        e0.e.d(e0.b.f8548b, new String[]{"stats report, processName: " + this.f12310x + " Json:" + r11.toString()});
    L11:
        return true;
    }

    void A() {
        this.f12294h = this.C;
        this.f12291e = this.F;
        this.f12292f = this.D;
        this.f12293g = this.E;
        this.f12287a = this.A;
        this.f12295i = this.G;
        this.f12296j = this.H;
        this.f12297k = this.I;
        this.f12298l = this.f12286J;
        this.f12303q = this.K;
        this.f12300n = this.N;
        this.f12301o = this.L;
        this.f12302p = this.M;
        this.f12288b = this.B;
        this.f12304r = this.O;
        this.f12305s = this.P;
        this.f12306t = this.Q;
        this.f12307u = this.R;
        this.f12309w = false;
        this.f12310x = "all_process";
        this.f12308v = false;
        this.f12312z = "";
        z(false);     // Catch: Exception -> L5
        return;
    }

    void B(boolean r10) {
        this.f12308v = r10;
    }

    void C(boolean r10) {
        this.f12309w = r10;
    }

    void D(String r10) {
        this.f12310x = r10;
    }

    void E(String r10) {
        this.f12312z = r10;
    }

    void F(String r10) {
        this.f12311y = r10;
    }

    public void a(long r10) {
        this.f12306t += r10;
    }

    public void b(long r10) {
        this.f12300n += r10;
    }

    void c(long r10) {
        this.f12288b += r10;
    }

    public void d(long r10) {
        this.f12301o += r10;
    }

    public void e(long r10) {
        this.f12307u += r10;
    }

    public void f(long r10) {
        this.f12304r += r10;
    }

    public void g(long r10) {
        this.f12305s += r10;
    }

    public void h(long r10) {
        this.f12302p += r10;
    }

    public void i(long r10) {
        this.f12303q += r10;
    }

    public void j(long r10) {
        this.f12299m += r10;
    }

    public void k(long r10) {
        this.f12297k += r10;
    }

    public void l(long r10) {
        this.f12291e += r10;
    }

    void m(long r10) {
        this.f12287a += r10;
    }

    public void n(long r10) {
        this.f12292f += r10;
    }

    public void o(long r10) {
        this.f12298l += r10;
    }

    public void p(long r10) {
        this.f12295i += r10;
    }

    public void q(long r10) {
        this.f12296j += r10;
    }

    public void r(long r10) {
        this.f12293g += r10;
    }

    public void s(long r10) {
        this.f12294h += r10;
    }

    void t() {
        this.f12287a = 0;
        this.f12288b = 0;
        this.f12291e = 0;
        this.f12292f = 0;
        this.f12293g = 0;
        this.f12294h = 0;
        this.f12295i = 0;
        this.f12296j = 0;
        this.f12297k = 0;
        this.f12298l = 0;
        this.f12299m = 0;
        this.f12300n = 0;
        this.f12301o = 0;
        this.f12302p = 0;
        this.f12303q = 0;
        this.f12304r = 0;
        this.f12305s = 0;
        this.f12306t = 0;
        this.f12307u = 0;
        this.f12309w = true;
        this.f12308v = false;
        this.f12310x = "";
        this.f12311y = "";
        this.f12312z = "";
    }

    public JSONObject v(boolean r24) {
        JSONObject r10 = new JSONObject();
        if (x() == false) goto L31;
        r10.put("front_alarm", this.f12294h);
        r10.put("front_loc_p_time", (this.f12292f * 1.0f) / 1000.0f);
        r10.put("front_power_p_time", (this.f12293g * 1.0f) / 1000.0f);
        long r11 = this.f12291e;
        if (r11 < 0) goto L8;
        r10.put("front_cpu_active_time_p_time", (r11 * 1.0f) / 1000.0f);
        double r12 = (((this.f12294h * 0.002083333383779973d) + (this.f12291e * 6.944444612599909E-5d)) + (this.f12292f * 7.499999810534064E-6d)) + (this.f12293g * 6.944444521650439E-6d);
        if (this.f12309w == true) goto L14;
        if (r24 == false) goto L14;
    L16:
        if (r12 < 0.0d) goto L18;
        r10.put("front_score", r12);
        r10.put("front_p_time", (this.f12287a * 1.0f) / 1000.0f);
        float r13 = 60000.0f / this.f12287a;
        r10.put("front_alarm_per_min", this.f12294h * r13);
        r10.put("front_loc_per_min_p_time", (this.f12292f / 1000.0f) * r13);
        r10.put("front_power_per_min_p_time", (this.f12293g / 1000.0f) * r13);
        r10.put("front_cpu_active_time_per_min_p_time", (this.f12291e / 1000.0f) * r13);
        if (this.f12309w == true) goto L24;
        if (r24 == false) goto L24;
    L25:
        r10.put("front_score_per_min", r12 * ((double) r13));
        if (this.f12309w == false) goto L28;
        r10.put("front_battery_consume", this.f12299m);
        r10.put("front_battery_consume_per_min", this.f12299m * r13);
    L28:
        if (r24 == false) goto L31;
        this.C = (int) (((long) this.C) + this.f12294h);
        this.F = (int) (((long) this.F) + this.f12291e);
        this.D = (int) (((long) this.D) + this.f12292f);
        this.E = (int) (((long) this.E) + this.f12293g);
        this.f12289c += this.f12287a;
        this.G += this.f12295i;
        this.H += this.f12296j;
        this.I += this.f12297k;
        this.f12286J += this.f12298l;
    L24:
        r10.put("front_traffic_per_min_p_capacity", (this.f12295i / 1024.0f) * r13);
        r10.put("front_traffic_packets_per_min", this.f12296j * r13);
        r10.put("front_traffic_all_iface_per_min", ((this.f12297k * 1.0f) / 1024.0f) * r13);
        r10.put("front_traffic_packets_all_iface_per_min", this.f12298l * r13);
        goto L25
    L18:
        if (d.D() == false) goto L20;
        e0.e.g(e0.b.f8548b, new String[]{" report data invalid, frontScore < 0 : " + r12});
    L20:
        return null;
    L14:
        r10.put("front_traffic_all_iface", (this.f12297k * 1.0f) / 1024.0f);
        r10.put("front_traffic_packets_all_iface", this.f12298l);
        r10.put("front_traffic_p_capacity", (this.f12295i * 1.0f) / 1024.0f);
        r10.put("front_traffic_packets", this.f12296j);
        r12 = r12 + (this.f12295i * 2.6666666030905617E-7d);
        goto L16
    L8:
        if (d.D() == false) goto L10;
        e0.e.g(e0.b.f8548b, new String[]{" report data invalid, frontCpuMs < 0 : " + this.f12291e});
    L10:
        return null;
    L31:
        if (w() == false) goto L50;
        r10.put("back_alarm", this.f12303q);
        r10.put("back_loc_p_time", (this.f12301o * 1.0f) / 1000.0f);
        r10.put("back_power_p_time", (this.f12302p * 1.0f) / 1000.0f);
        long r14 = this.f12300n;
        if (r14 < 0) goto L36;
        r10.put("back_cpu_active_time_p_time", (r14 * 1.0f) / 1000.0f);
        double r15 = (((this.f12303q * 0.002083333383779973d) + (this.f12300n * 6.944444612599909E-5d)) + (this.f12301o * 7.499999810534064E-6d)) + (this.f12302p * 6.944444521650439E-6d);
        if (this.f12309w == true) goto L42;
        if (r24 == false) goto L42;
    L43:
        r10.put("back_score", r15);
        r10.put("back_p_time", (this.f12288b * 1.0f) / 1000.0f);
        float r16 = 60000.0f / this.f12288b;
        r10.put("back_alarm_per_min", this.f12303q * r16);
        r10.put("back_loc_per_min_p_time", (this.f12301o / 1000.0f) * r16);
        r10.put("back_power_per_min_p_time", (this.f12302p / 1000.0f) * r16);
        r10.put("back_cpu_active_time_per_min_p_time", (this.f12300n / 1000.0f) * r16);
        if (this.f12309w == true) goto L46;
        if (r24 == false) goto L46;
    L47:
        r10.put("back_score_per_min", r15 * ((double) r16));
        if (r24 == false) goto L50;
        this.K = (int) (((long) this.K) + this.f12303q);
        this.N = (int) (((long) this.N) + this.f12300n);
        this.L = (int) (((long) this.L) + this.f12301o);
        this.M = (int) (((long) this.M) + this.f12302p);
        this.f12290d += this.f12288b;
        this.Q += this.f12306t;
        this.R += this.f12307u;
        this.O += this.f12304r;
        this.P += this.f12305s;
    L46:
        r10.put("back_traffic_all_iface_per_min", ((this.f12306t * 1.0f) / 1024.0f) * r16);
        r10.put("back_traffic_packets_all_iface_per_min", this.f12307u * r16);
        r10.put("back_traffic_per_min_p_capacity", (this.f12304r / 1024.0f) * r16);
        r10.put("back_traffic_packets_per_min", this.f12305s * r16);
    L42:
        r10.put("back_traffic_all_iface", (this.f12306t * 1.0f) / 1024.0f);
        r10.put("back_traffic_packets_all_iface", this.f12307u);
        r10.put("back_traffic_p_capacity", (this.f12304r * 1.0f) / 1024.0f);
        r10.put("back_traffic_packets", this.f12305s);
        r15 = r15 + (this.f12304r * 2.6666666030905617E-7d);
        goto L43
    L36:
        if (d.D() == false) goto L38;
        e0.e.g(e0.b.f8548b, new String[]{" report data invalid, mBackCpuMs < 0 : " + this.f12300n});
    L38:
        return null;
    L50:
        return r10;
    }

    boolean w() {
        if (this.f12288b <= 5000) goto L5;
        return true;
    L5:
        return false;
    }

    boolean x() {
        if (this.f12287a <= WorkRequest.MIN_BACKOFF_MILLIS) goto L5;
        return true;
    L5:
        return false;
    }

    public void y() {
        long r10 = this.f12289c;
        if (r10 <= this.A) goto L5;
        this.A = r10;
    L5:
        this.f12289c = 0;
        long r11 = this.f12290d;
        if (r11 <= this.B) goto L8;
        this.B = r11;
    L8:
        this.f12290d = 0;
    }

    @WorkerThread
    public boolean z(boolean r10) {
        boolean r11 = u(r10);
        if (r11 == false) goto L5;
    L7:
        t();
        return r11;
    L5:
        if (d.D() == false) goto L7;
        e0.e.d(e0.b.f8548b, new String[]{"stats report failed, processName: " + this.f12310x});
        goto L7
    }
}
