package h1;

import android.text.TextUtils;
import com.bytedance.apm6.util.constant.ReportConsts;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f9138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f9139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f9140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f9141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f9142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Map<String, List<Set<String>>> f9143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Map<String, List<Map<String, Object>>> f9144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String f9145h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f9146i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    String[] f9147j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f9148k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    n1.a f9149l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f9150m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    String f9151n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    String f9152o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    String f9153p;

    public b() {
        this.f9147j = null;
        this.f9148k = false;
        this.f9150m = 0;
    }

    public void a(int r10) {
        this.f9148k = k1.a.b(r10);
    }

    public n1.a b() {
        return this.f9149l;
    }

    public long c() {
        return this.f9142e;
    }

    public String d() {
        if (this.f9150m != 0) goto L5;
    L30:
        return null;
    L5:
        if (TextUtils.isEmpty(this.f9151n) == true) goto L30;
        if (TextUtils.isEmpty(this.f9153p) == false) goto L29;
        if (this.f9151n.startsWith(ReportConsts.HTTPS) == true) goto L12;
    L14:
        String r10 = null;
    L16:
        if (TextUtils.isEmpty(r10) == false) goto L20;
        this.f9153p = null;
        return null;
    L20:
        if (TextUtils.isEmpty(this.f9152o) == false) goto L22;
    L26:
        String r11 = "/service/2/app_log/";
    L27:
        this.f9153p = r10 + r11;
        goto L29
    L22:
        if (this.f9152o.startsWith("/") == false) goto L26;
        if (this.f9152o.endsWith("/") == false) goto L26;
        r11 = this.f9152o;
        goto L27
    L12:
        if (this.f9151n.endsWith("/") == true) goto L14;
        r10 = this.f9151n;
    L29:
        return this.f9153p;
    }

    public int e() {
        return this.f9139b;
    }

    public int f() {
        return this.f9138a;
    }

    public String[] g(String[] r10, String r11) {
        if (TextUtils.isEmpty(this.f9145h) == false) goto L8;
        if (TextUtils.isEmpty(this.f9146i) == false) goto L8;
        return null;
    L8:
        if (this.f9147j != null) goto L32;
        this.f9147j = new String[r10.length];
        int r12 = 0;
    L11:
        if (r12 >= r10.length) goto L32;
        int r13 = r10[r12].indexOf(r11);
        if (r13 <= 0) goto L29;
        String r14 = r10[r12].substring(0, r13);
        String r15 = r10[r12].substring(r13);
        if (TextUtils.isEmpty(this.f9145h) == true) goto L22;
        if (this.f9145h.startsWith(ReportConsts.HTTPS) == false) goto L22;
        if (this.f9145h.endsWith("/") == true) goto L22;
        r14 = this.f9145h;
    L22:
        if (TextUtils.isEmpty(this.f9146i) == false) goto L24;
    L28:
        this.f9147j[r12] = r14 + r15;
    L30:
        r12 = r12 + 1;
        goto L11
    L24:
        if (this.f9146i.startsWith("/") == false) goto L28;
        if (this.f9146i.endsWith("/") == false) goto L28;
        r15 = this.f9146i;
        goto L28
    L29:
        this.f9147j[r12] = r10[r12];
    L32:
        if (this.f9148k == false) goto L34;
        return null;
    L34:
        String[] r16 = this.f9147j;
        if (r16 != null) goto L37;
    L39:
        return null;
    L37:
        if (r16.length <= 0) goto L39;
        return r16;
    }

    public int h() {
        return this.f9140c;
    }
}
