package d3;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.j;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.bytedance.retrofit2.RetrofitMetrics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile d f8461f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile String f8462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f8463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<c> f8464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f8465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8466e;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8467a = null;

        static {
            int[] r10 = new int[RetrofitMetrics.EncryptType.values().length];
            f8467a = r10;
            r10[RetrofitMetrics.EncryptType.ENCRYPT_BOTH_QUERY_AND_BODY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f8467a[RetrofitMetrics.EncryptType.ENCRYPT_BODY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f8467a[RetrofitMetrics.EncryptType.ENCRYPT_QUERY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    class b implements Comparator<c> {
        b(d r10) {
        }

        public int a(c r10, c r11) {
            return r10.d() - r11.d();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(c r10, c r11) {
            return a(r10, r11);
        }
    }

    private d() {
        this.f8463b = false;
        this.f8464c = new CopyOnWriteArrayList();
        this.f8465d = new CopyOnWriteArrayList();
        this.f8466e = false;
    }

    private static void a(List<n4.b> r10, RetrofitMetrics.EncryptType r11) {
        int r12 = a.f8467a[r11.ordinal()];
        if (r12 != 1) goto L5;
        r10.add(new n4.b("x-tt-cipher-version", "1.0.0"));
        n4.b r13 = new n4.b("x-tt-encrypt-info", "2");
    L12:
        r10.add(r13);
        return;
    L5:
        if (r12 != 2) goto L7;
        r10.add(new n4.b("x-tt-cipher-version", "1.0.0"));
        r13 = new n4.b("x-tt-encrypt-info", NetConst.ENCRYPT_VERISON_CODE);
        goto L12
    L7:
        if (r12 != 3) goto L14;
        r10.add(new n4.b("x-tt-cipher-version", "1.0.0"));
        r13 = new n4.b("x-tt-encrypt-info", NetConst.NOT_ENCRYPT_VERISON_CODE);
        goto L12
    }

    private JSONArray b(List<d3.a> r10) {
        JSONArray r11 = new JSONArray();
        Iterator<d3.a> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L21;
        d3.a r13 = r12.next();
        long r14 = r13.b();     // Catch: JSONException -> L18
        if (this.f8466e == false) goto L13;
        if (r13.c() == true) goto L13;
        if (r14 <= 0) goto L4;
    L13:
        JSONObject r15 = new JSONObject();     // Catch: JSONException -> L18
        r15.put("hit", r13.c());     // Catch: JSONException -> L18
        r15.put("priority", r13.a());     // Catch: JSONException -> L18
        if (r14 <= 0) goto L16;
        r15.put("consume", r14);     // Catch: JSONException -> L18
    L16:
        r11.put(r15);     // Catch: JSONException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L21:
        if (Logger.debug() == false) goto L23;
        Logger.d("QueryFilterEngine", "action info: " + r11.toString());
    L23:
        return r11;
    }

    private boolean c(n4.c r10, Map<String, List<String>> r11) {
        ArrayList r12 = new ArrayList();
        boolean r13 = false;
        r10.U(0);
        Iterator<c> r14 = this.f8464c.iterator();
    L4:
        if (r14.hasNext() == false) goto L9;
        if (r14.next().n(r10, r11, r12) == false) goto L4;
        r13 = true;
        goto L4
    L9:
        if (Logger.debug() == false) goto L12;
        Logger.d("QueryFilterEngine", "dispatchQueryMap hit: " + r13);
    L12:
        if (r10.z() == null) goto L14;
        r10.z().f2448l0 = b(r12);
    L14:
        return r13;
    }

    public static d f() {
        if (f8461f != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8461f != null) goto L9;
        f8461f = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f8461f;
    }

    private void h(JSONObject r10, ArrayList<c> r11) {
        String r12 = r10.getString("action");
        int r13 = r10.getInt("act_priority");
        if (r13 >= 0) goto L5;
        return;
    L5:
        JSONObject r14 = r10.getJSONObject("param");
        int r15 = r10.optInt("set_req_priority", r13);
        if (r15 != (-1)) goto L8;
        r15 = Integer.MAX_VALUE;
    L8:
        c r16 = c.a(r12, r13, r15, r14);
        if (r16 == null) goto L12;
        r11.add(r16);
        return;
    }

    static void i(JSONArray r10, List<String> r11) {
        if (r10 == null) goto L12;
        if (r11 == null) goto L19;
        int r12 = 0;
    L14:
        if (r12 >= r10.length()) goto L21;
        String r13 = r10.getString(r12);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r13) == true) goto L11;
        r11.add(r13);     // Catch: JSONException -> L13
    L11:
        r12 = r12 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    private synchronized void j(String r10) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(this.f8462a) == false) goto L6;
    L12:
        ArrayList<c> r11 = new ArrayList();     // Catch: Throwable -> L19
        JSONArray r12 = new JSONArray(r10);     // Catch: Throwable -> L19
        int r13 = 0;
    L14:
        if (r13 >= r12.length()) goto L16;
        h(r12.getJSONObject(r13), r11);     // Catch: Throwable -> L19
        r13 = r13 + 1;     // Catch: Throwable -> L19
        goto L14
    L16:
        Collections.sort(r11, new b(this));     // Catch: Throwable -> L19
        this.f8464c.clear();     // Catch: Throwable -> L19
        this.f8464c.addAll(r11);     // Catch: Throwable -> L19
        this.f8462a = r10;     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L6:
        if (this.f8462a.equals(r10) == false) goto L12;
        if (Logger.debug() == false) goto L10;
        Logger.d("QueryFilterEngine", "Config is same with local config, do not parse.");     // Catch: Throwable -> L19
    L10:
        monitor-exit(this);
    }

    private static void l(n4.c.a r10, n4.c r11, String r12) {
        if ((r11.s() instanceof com.bytedance.retrofit2.mime.a) == false) goto L7;
        boolean r13 = ((com.bytedance.retrofit2.mime.a) r11.s()).i();
        if (r13 == false) goto L9;
        Logger.i("QueryFilterEngine", "Request body has been encrypted before.");
    L9:
        if (r11.M() == false) goto L11;
    L14:
        ArrayList r14 = new ArrayList();
        if (TextUtils.isEmpty(r12) == true) goto L18;
        r14.add(new n4.b("x-tt-encrypt-queries", r12));
    L18:
        if (r11.v() == null) goto L20;
        r14.addAll(r11.v());
    L20:
        RetrofitMetrics r15 = r11.z();
        if (r13 == false) goto L23;
    L29:
        RetrofitMetrics.EncryptType r16 = RetrofitMetrics.EncryptType.ENCRYPT_NONE;
        if (r13 == true) goto L32;
    L34:
        if (r13 == false) goto L38;
        r16 = RetrofitMetrics.EncryptType.ENCRYPT_BODY;
    L36:
        a(r14, r16);
    L40:
        if (r15 == null) goto L42;
        r15.l(r16);
    L42:
        r10.b(r14);
        return;
    L38:
        if (r11.M() == false) goto L40;
        r16 = RetrofitMetrics.EncryptType.ENCRYPT_QUERY;
        goto L36
    L32:
        if (r11.M() == false) goto L34;
        r16 = RetrofitMetrics.EncryptType.ENCRYPT_BOTH_QUERY_AND_BODY;
        goto L36
    L23:
        if (r11.J() == false) goto L29;
        r4.f r17 = r11.s();
        if ((r17 instanceof com.bytedance.retrofit2.mime.a) == false) goto L29;
        long r18 = System.currentTimeMillis();
        r13 = ((com.bytedance.retrofit2.mime.a) r17).h();
        if (r15 == null) goto L29;
        r15.f2440h0 = System.currentTimeMillis() - r18;
        goto L29
    L11:
        if (r11.J() == true) goto L14;
        if (r13 == true) goto L14;
        return;
    L7:
        r13 = false;
        goto L9
    }

    public void d(boolean r10) {
        this.f8463b = r10;
    }

    public n4.c e(n4.c r10) {
        if (this.f8463b == true) goto L9;
        if (Logger.debug() == false) goto L7;
        Logger.d("QueryFilterEngine", "Query filter engine is not enabled");
    L7:
        return null;
    L9:
        if (r10.L() == false) goto L11;
        return null;
    L11:
        String r11 = r10.G();
        if (TextUtils.isEmpty(r11) == false) goto L54;
        return null;
    L54:
        LinkedHashMap r12 = new LinkedHashMap();     // Catch: Throwable -> L51
        Pair<String, String> r13 = k.k(r11, r12);     // Catch: Throwable -> L51
        if (r13 != null) goto L18;
        return null;
    L18:
        if (c(r10, r12) == true) goto L21;
        return null;
    L21:
        if (r10.M() == true) goto L23;
    L29:
        String r14 = null;
    L30:
        j r15 = new j(((String) r13.first) + ((String) r13.second));     // Catch: Throwable -> L51
        if (r12.isEmpty() == true) goto L49;
        Iterator<Map.Entry<String, List<String>>> r16 = r12.entrySet().iterator();     // Catch: Throwable -> L51
    L34:
        if (r16.hasNext() == false) goto L49;
        Map.Entry<String, List<String>> r17 = r16.next();     // Catch: Throwable -> L51
        if (r17 == null) goto L34;
        if (r17.getKey() == null) goto L34;
        List<String> r18 = r17.getValue();     // Catch: Throwable -> L51
        if (r18 == null) goto L34;
        if (r18.isEmpty() == true) goto L34;
        Iterator<String> r19 = r18.iterator();     // Catch: Throwable -> L51
    L47:
        if (r19.hasNext() == false) goto L34;
        r15.b(r17.getKey(), r19.next());     // Catch: Throwable -> L51
    L49:
        n4.c.a r20 = r10.O();     // Catch: Throwable -> L51
        l(r20, r10, r14);     // Catch: Throwable -> L51
        r20.f(r15.c());     // Catch: Throwable -> L51
        return r20.a();
    L23:
        if (r12.containsKey("x-tt-encrypt-queries") == false) goto L29;
        List<String> r21 = r12.get("x-tt-encrypt-queries");     // Catch: Throwable -> L51
        if (r21 == null) goto L29;
        if (r21.size() <= 0) goto L29;
        r14 = r21.get(0);     // Catch: Throwable -> L51
        r12.remove("x-tt-encrypt-queries");     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void g(String r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d("QueryFilterEngine", "onNetConfigChanged config: " + r10 + " enabled: " + this.f8463b);
    L6:
        if (this.f8463b == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r10) == true) goto L18;
        j(r10);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void k(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        this.f8465d.clear();
        JSONArray r11 = new JSONArray(r10);     // Catch: JSONException -> L11
        int r12 = 0;
    L8:
        if (r12 >= r11.length()) goto L17;
        String r13 = r11.getString(r12);     // Catch: JSONException -> L11
        this.f8465d.add(r13);     // Catch: JSONException -> L11
        r12 = r12 + 1;
        goto L8
    L17:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }
}
