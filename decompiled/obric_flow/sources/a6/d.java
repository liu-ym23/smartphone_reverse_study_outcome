package a6;

import android.util.Log;
import com.bytedance.android.anniex.base.service.f;
import com.bytedance.apm.j;
import com.bytedance.common.wschannel.WsConstants;
import j6.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public long A;
    public long B;
    public int C;
    public int D;
    public int E;
    public int F;
    public long G;
    public long H;
    public long I;
    public long J;
    public int K;
    public int L;
    public int M;
    public int N;
    public long O;
    public long P;
    public long Q;
    public long R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f117c;
    public long d;
    public long e;
    public long f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f119i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f120j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f121k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f122l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f123m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f124n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f125o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f126p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f127q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f128r;
    public long s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f129t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f130u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f131v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f132w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f133x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f134y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f135z;

    public d() {
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.f118h = 0;
        this.f119i = 0;
        this.f120j = 0;
        this.f121k = 0;
        this.f122l = 0;
        this.f123m = 0;
        this.f124n = 0;
        this.f125o = 0;
        this.f126p = 0;
        this.f127q = 0;
        this.f128r = 0;
        this.s = 0;
        this.f129t = 0;
        this.f130u = 0;
        this.f132w = true;
        this.I = 0;
        this.J = 0;
        this.Q = 0;
        this.R = 0;
    }

    public final JSONObject a(boolean r23) {
        JSONObject r5 = new JSONObject();
        if (this.f115a <= 10000) goto L30;
        r5.put("front_alarm", this.f118h);
        r5.put("front_loc_p_time", (this.f * 1.0f) / 1000.0f);
        r5.put("front_power_p_time", (this.g * 1.0f) / 1000.0f);
        long r10 = this.e;
        if (r10 < 0) goto L7;
        r5.put("front_cpu_active_time_p_time", (r10 * 1.0f) / 1000.0f);
        double r12 = (this.g * 6.944444521650439E-6d) + ((this.f * 7.499999810534064E-6d) + ((this.e * 6.944444612599909E-5d) + (this.f118h * 0.002083333383779973d)));
        if (this.f132w == true) goto L13;
        if (r23 == false) goto L13;
    L15:
        if (r12 < 0.0d) goto L17;
        r5.put("front_score", r12);
        r5.put("front_p_time", (this.f115a * 1.0f) / 1000.0f);
        float r11 = 60000.0f / this.f115a;
        r5.put("front_alarm_per_min", this.f118h * r11);
        r5.put("front_loc_per_min_p_time", (this.f / 1000.0f) * r11);
        r5.put("front_power_per_min_p_time", (this.g / 1000.0f) * r11);
        r5.put("front_cpu_active_time_per_min_p_time", (this.e / 1000.0f) * r11);
        if (this.f132w == true) goto L23;
        if (r23 == false) goto L23;
    L24:
        r5.put("front_score_per_min", r12 * ((double) r11));
        if (this.f132w == false) goto L27;
        r5.put("front_battery_consume", this.f123m);
        r5.put("front_battery_consume_per_min", this.f123m * r11);
    L27:
        if (r23 == false) goto L30;
        this.C = (int) (((long) this.C) + this.f118h);
        this.F = (int) (((long) this.F) + this.e);
        this.D = (int) (((long) this.D) + this.f);
        this.E = (int) (((long) this.E) + this.g);
        this.f117c += this.f115a;
        this.G += this.f119i;
        this.H += this.f120j;
        this.I += this.f121k;
        this.J += this.f122l;
    L23:
        r5.put("front_traffic_per_min_p_capacity", (this.f119i / 1024.0f) * r11);
        r5.put("front_traffic_packets_per_min", this.f120j * r11);
        r5.put("front_traffic_all_iface_per_min", ((this.f121k * 1.0f) / 1024.0f) * r11);
        r5.put("front_traffic_packets_all_iface_per_min", this.f122l * r11);
        goto L24
    L17:
        if (j.f3887a == false) goto L19;
        Log.w("<monitor><battery>", f.o(new String[]{" report data invalid, frontScore < 0 : " + r12}));
    L19:
        return null;
    L13:
        r5.put("front_traffic_all_iface", (this.f121k * 1.0f) / 1024.0f);
        r5.put("front_traffic_packets_all_iface", this.f122l);
        r5.put("front_traffic_p_capacity", (this.f119i * 1.0f) / 1024.0f);
        r5.put("front_traffic_packets", this.f120j);
        r12 = r12 + (this.f119i * 2.6666666030905617E-7d);
        goto L15
    L7:
        if (j.f3887a == false) goto L9;
        Log.w("<monitor><battery>", f.o(new String[]{" report data invalid, frontCpuMs < 0 : " + this.e}));
    L9:
        return null;
    L30:
        if (this.f116b <= 5000) goto L48;
        r5.put("back_alarm", this.f127q);
        r5.put("back_loc_p_time", (this.f125o * 1.0f) / 1000.0f);
        r5.put("back_power_p_time", (this.f126p * 1.0f) / 1000.0f);
        long r13 = this.f124n;
        if (r13 < 0) goto L34;
        r5.put("back_cpu_active_time_p_time", (r13 * 1.0f) / 1000.0f);
        double r14 = (this.f126p * 6.944444521650439E-6d) + ((this.f125o * 7.499999810534064E-6d) + ((this.f124n * 6.944444612599909E-5d) + (this.f127q * 0.002083333383779973d)));
        if (this.f132w == true) goto L40;
        if (r23 == false) goto L40;
    L41:
        r5.put("back_score", r14);
        r5.put("back_p_time", (this.f116b * 1.0f) / 1000.0f);
        float r15 = 60000.0f / this.f116b;
        r5.put("back_alarm_per_min", this.f127q * r15);
        r5.put("back_loc_per_min_p_time", (this.f125o / 1000.0f) * r15);
        r5.put("back_power_per_min_p_time", (this.f126p / 1000.0f) * r15);
        r5.put("back_cpu_active_time_per_min_p_time", (this.f124n / 1000.0f) * r15);
        if (this.f132w == true) goto L44;
        if (r23 == false) goto L44;
    L45:
        r5.put("back_score_per_min", r14 * ((double) r15));
        if (r23 == false) goto L48;
        this.K = (int) (((long) this.K) + this.f127q);
        this.N = (int) (((long) this.N) + this.f124n);
        this.L = (int) (((long) this.L) + this.f125o);
        this.M = (int) (((long) this.M) + this.f126p);
        this.d += this.f116b;
        this.Q += this.f129t;
        this.R += this.f130u;
        this.O += this.f128r;
        this.P += this.s;
    L44:
        r5.put("back_traffic_all_iface_per_min", ((this.f129t * 1.0f) / 1024.0f) * r15);
        r5.put("back_traffic_packets_all_iface_per_min", this.f130u * r15);
        r5.put("back_traffic_per_min_p_capacity", (this.f128r / 1024.0f) * r15);
        r5.put("back_traffic_packets_per_min", this.s * r15);
    L40:
        r5.put("back_traffic_all_iface", (this.f129t * 1.0f) / 1024.0f);
        r5.put("back_traffic_packets_all_iface", this.f130u);
        r5.put("back_traffic_p_capacity", (this.f128r * 1.0f) / 1024.0f);
        r5.put("back_traffic_packets", this.s);
        r14 = r14 + (this.f128r * 2.6666666030905617E-7d);
        goto L41
    L34:
        if (j.f3887a == false) goto L36;
        Log.w("<monitor><battery>", f.o(new String[]{" report data invalid, mBackCpuMs < 0 : " + this.f124n}));
    L36:
        return null;
    L48:
        return r5;
    }

    public final void b() {
        long r5 = this.f117c;
        if (r5 <= this.A) goto L5;
        this.A = r5;
    L5:
        this.f117c = 0;
        long r10 = this.d;
        if (r10 <= this.B) goto L8;
        this.B = r10;
    L8:
        this.d = 0;
    }

    public final boolean c(boolean r11) {
        JSONObject r12 = a(r11);
        if (r12 != null) goto L6;
        boolean r13 = false;
    L11:
        if (r13 == false) goto L13;
    L15:
        this.f115a = 0;
        this.f116b = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.f118h = 0;
        this.f119i = 0;
        this.f120j = 0;
        this.f121k = 0;
        this.f122l = 0;
        this.f123m = 0;
        this.f124n = 0;
        this.f125o = 0;
        this.f126p = 0;
        this.f127q = 0;
        this.f128r = 0;
        this.s = 0;
        this.f129t = 0;
        this.f130u = 0;
        this.f132w = true;
        this.f131v = false;
        this.f133x = "";
        this.f134y = "";
        this.f135z = "";
        return r13;
    L13:
        if (j.f3887a == false) goto L15;
        Log.i("<monitor><battery>", f.o(new String[]{"stats report failed, processName: " + this.f133x}));
        goto L15
    L6:
        if (r12.length() != 0) goto L8;
    L7:
        r13 = true;
        goto L11
    L8:
        JSONObject r5 = new JSONObject();
        r5.put("is_main_process", this.f132w);
        r5.put("process_name", this.f133x);
        r5.put("scene", this.f135z);
        r5.put("is_charging", this.f131v ? 1 : 0);
        JSONObject r10 = new JSONObject();
        r10.put(WsConstants.KEY_SESSION_ID, this.f134y);
        e r14 = new e("battery", "", r12, r5, r10);
        r14.d = s6.c.w().x(false);
        i6.a.i().b(r14);
        if (j.f3887a == false) goto L7;
        Log.i("<monitor><battery>", f.o(new String[]{"stats report, processName: " + this.f133x + " Json:" + r12.toString()}));
        goto L7
    }
}
