package x;

import android.text.TextUtils;
import com.bytedance.apm.util.i;
import com.bytedance.apm.util.m;
import com.bytedance.apm.util.p;
import com.bytedance.crash.service.INetworkCallback;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends w.a<y.a> {
    private static long A = 30000;
    private static boolean B = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f13458l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f13459m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile int f13460n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private volatile List<String> f13461o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private List<Pattern> f13462p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private List<String> f13463q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List<Pattern> f13464r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List<String> f13465s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List<String> f13466t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private List<String> f13467u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f13468v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f13469w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private double f13470x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f13471y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private c f13472z;

    static /* synthetic */ class a {
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f13473a = null;

        static {
            f13473a = new d(null);
        }

        static /* synthetic */ d a() {
            return f13473a;
        }
    }

    static {
    }

    private d() {
        this.f13459m = true;
        this.f13468v = true;
        this.f13469w = false;
    }

    /* synthetic */ d(a r10) {
        this();
    }

    private boolean B(JSONObject r10) {
        if (r10 != null) goto L12;
        return false;
    L12:
        String r11 = r10.optString("cronet_internal_error_code");     // Catch: Exception -> L11
        if ("11".equals(r10.optString("cronet_error_code")) == false) goto L14;
        if ("-999".equals(r11) == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L16:
        return false;
    }

    private boolean E(String r10) {
        return p.c(r10, this.f13463q, this.f13464r);
    }

    private boolean F(String r10) {
        return p.c(r10, this.f13461o, this.f13462p);
    }

    public static boolean G() {
        if (B == true) goto L6;
        return false;
    L6:
        if (com.bytedance.apm.d.f() != 0) goto L9;
        return false;
    L9:
        if ((System.currentTimeMillis() - com.bytedance.apm.d.f()) <= A) goto L11;
        return false;
    L11:
        return true;
    }

    private boolean H(String r10) {
        return p.b(r10, this.f13465s);
    }

    public static void I(boolean r10) {
        B = r10;
    }

    public static void J(long r10) {
        A = r10;
    }

    private void p(JSONObject r10, String r11) {
        if (r10 == null) goto L32;
    L27:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (TextUtils.equals(r11, "api_all") == false) goto L9;
        String r12 = "api_all_v2";
    L7:
        r10.put("net_log_type", r12);     // Catch: Exception -> L27
    L13:
        if (C() == false) goto L19;
        if (D() == false) goto L19;
        String r13 = "01";
    L17:
        r10.put("inject_tracelog", r13);     // Catch: Exception -> L27
    L23:
        double r14 = this.f13470x;     // Catch: Exception -> L27
        if (r14 == 0.0d) goto L33;
        r10.put("enable_base_api_all", r14);     // Catch: Exception -> L27
        return;
    L33:
        return;
    L19:
        if (w() != 1) goto L23;
        if (D() == false) goto L23;
        r13 = "02";
        goto L17
    L9:
        if (TextUtils.equals(r11, "api_error") == false) goto L13;
        r12 = "api_error_v2";
        goto L7
    }

    private boolean q(String r10, JSONObject r11) {
        if (H(r10) == false) goto L5;
    L16:
        return false;
    L5:
        if (m.b(com.bytedance.apm.d.g()) == true) goto L10;
        if (this.f13471y == false) goto L16;
    L10:
        if (B(r11) == true) goto L12;
        return true;
    L12:
        if (this.f13469w == true) goto L17;
        return false;
    L17:
        return true;
    }

    private boolean r(String r10, String r11, JSONObject r12) {
        if (TextUtils.equals(r10, "api_all") == false) goto L12;
        if (C() == false) goto L8;
        y(r11, r12);
        return true;
    L8:
        if (F(r11) == true) goto L17;
        return y(r11, r12);
    L17:
        return false;
    L12:
        if (TextUtils.equals(r10, "api_error") == false) goto L17;
        if (this.f13460n != 1) goto L17;
        return true;
    }

    private void t(JSONObject r10) {
        u(this.f13466t, r10, "requestHeader");
        u(this.f13467u, r10, "responseHeader");
    }

    private void u(List<String> r10, JSONObject r11, String r12) {
        if (r10 == null) goto L31;
        if (r11 == null) goto L32;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (TextUtils.isEmpty(r12) == true) goto L33;
        String r13 = r11.optString(r12);     // Catch: JSONException -> L16 Exception -> L19
        if (TextUtils.isEmpty(r13) == true) goto L34;
        JSONObject r14 = new JSONObject(r13);     // Catch: JSONException -> L16 Exception -> L19
        JSONObject r15 = new JSONObject();     // Catch: JSONException -> L16 Exception -> L19
        Iterator<String> r16 = r14.keys();     // Catch: JSONException -> L16 Exception -> L19
    L10:
        if (r16.hasNext() == false) goto L14;
        String r17 = r16.next();     // Catch: JSONException -> L16 Exception -> L19
        if (r10.contains(r17) == false) goto L10;
        r15.put(r17, r14.opt(r17));     // Catch: JSONException -> L16 Exception -> L19
        goto L10
    L14:
        r11.put(r12, r15.toString());     // Catch: JSONException -> L16 Exception -> L19
    L35:
        return;
    L34:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L19
        return;
    L33:
        return;
    L32:
        return;
    }

    public static d v() {
        return b.a();
    }

    private boolean y(String r10, JSONObject r11) {
        if (C() == false) goto L5;
    L10:
        int r12 = 1;
    L11:
        boolean r13 = o0.c.f("smart_traffic");
        if (r13 == false) goto L14;
        int r14 = r12 | 4;
    L21:
        r11.put("hit_rules", r14);     // Catch: JSONException -> L20
    L16:
        if (r12 != 0) goto L19;
        if (r13 == true) goto L19;
        return false;
    L19:
        return true;
    L14:
        r14 = r12;
        goto L21
    L5:
        if (this.f13458l != 0) goto L10;
        if (E(r10) == true) goto L10;
        r12 = 0;
        goto L11
    }

    private void z(y.a r10) {
        String r11 = r10.f13598d;
        String r12 = r10.f13595a;
        boolean r13 = !r10.f13602h.isNull("hit_rules");
        if (r13 == false) goto L5;
    L7:
        JSONObject r14 = r10.c();
        i.a(r14, r10.f13602h);
        if (r14 != null) goto L11;
        return;
    L11:
        if (r13 == false) goto L13;
    L16:
        boolean r15 = true;
    L18:
        if (this.f13468v == false) goto L20;
        p(r14, r10.f13595a);
    L20:
        t(r14);
        if (this.f13472z != null) goto L23;
    L27:
        l(r12, r12, r14, r15, true);
        return;
    L23:
        if ("api_all".equals(r12) == false) goto L27;
        if (r10.f13602h.optBoolean("download", false) == true) goto L27;
        this.f13472z.a(r11, r10.f13602h);
        goto L27
    L13:
        if (r(r12, r11, r14) == true) goto L16;
        r15 = false;
        goto L18
    L5:
        if (q(r11, r10.f13602h) == true) goto L7;
    }

    protected void A(y.a r10) {
        if (w.a.k() == true) goto L5;
        boolean r11 = true;
    L6:
        r10.g(r11);     // Catch: JSONException -> L11
        if (G() == false) goto L9;
        r10.h();     // Catch: JSONException -> L11
    L9:
        r10.f(INetworkCallback.TYPE_TTNET);     // Catch: JSONException -> L11
        return;
    L5:
        r11 = false;
    }

    public boolean C() {
        if (this.f13468v == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f13470x == 0.0d) goto L7;
        return true;
    }

    public boolean D() {
        return this.f13459m;
    }

    public void K(boolean r10) {
        this.f13471y = r10;
    }

    public void L(c r10) {
        this.f13472z = r10;
    }

    @Override // w.a
    protected /* bridge */ /* synthetic */ boolean d(w.b r10) {
        return s((y.a) r10);
    }

    @Override // w.a
    protected /* bridge */ /* synthetic */ void f(w.b r10) {
        x((y.a) r10);
    }

    @Override // w.a
    protected /* bridge */ /* synthetic */ void i(w.b r10) {
        A((y.a) r10);
    }

    @Override // w.a, u4.a
    public void onRefresh(JSONObject r10, boolean r11) {
        JSONObject r12 = p.a(r10, "network_image_modules");
        if (r12 == null) goto L14;
        JSONObject r13 = p.a(r12, "network");
        if (r13 == null) goto L10;
        this.f13461o = p.d(r13, "api_block_list");
        this.f13462p = p.g(r13, "api_block_list");
        this.f13463q = p.e(r13, "api_allow_list");
        this.f13464r = p.f(r13, "api_allow_list");
        boolean r14 = false;
        this.f13458l = r13.optInt("enable_api_all_upload", 0);
        this.f13459m = r13.optBoolean("enable_trace_log", true);
        this.f13460n = r13.optInt("enable_api_error_upload", 1);
        if (r13.optInt("enable_cancel_error_report") != 1) goto L9;
        r14 = true;
    L9:
        this.f13469w = r14;
        this.f13466t = p.e(r13, "request_allow_header");
        this.f13467u = p.e(r13, "response_allow_header");
        this.f13470x = r13.optDouble("enable_base_api_all", 0.0d);
    L10:
        JSONObject r15 = p.a(r12, "image");
        if (r15 == null) goto L15;
        this.f13465s = p.e(r15, "image_allow_list");
        return;
    L15:
        return;
    }

    protected boolean s(y.a r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (TextUtils.isEmpty(r10.f13598d) == true) goto L6;
        return true;
    }

    public int w() {
        return this.f13458l;
    }

    protected void x(y.a r10) {
        z(r10);
    }
}
