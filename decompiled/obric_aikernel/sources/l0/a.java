package l0;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.util.m;
import com.bytedance.apm.util.y;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.crash.service.INetworkCallback;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.chromium.wschannel.TrafficChangedObservable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, c> f10748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, c> f10749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, c> f10750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, c> f10751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, c> f10752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, c> f10753g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private y<i> f10754h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile long f10755i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<String, Map<String, c>> f10756j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private double f10757k;

    /* JADX INFO: renamed from: l0.a$a, reason: collision with other inner class name */
    class C0227a implements x.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f10758a;

        C0227a(a r10) {
            this.f10758a = r10;
        }

        @Override // x.c
        public void a(String r10, JSONObject r11) {
            if (a.a(this.f10758a) == true) goto L5;
            return;
        L5:
            this.f10758a.m(r10, r11);
        }
    }

    class b implements x.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f10759a;

        b(a r10) {
            this.f10759a = r10;
        }

        @Override // x.b
        public void a(String r10, String r11, JSONObject r12) {
            if (a.a(this.f10759a) == true) goto L5;
            return;
        L5:
            if ("image_monitor_v2".equals(r11) == false) goto L9;
            this.f10759a.n(r12);
            return;
        }
    }

    class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, Long> f10761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f10762c;

        public c(a r10, String r11) {
            this.f10762c = 0;
            this.f10760a = r11;
            this.f10761b = new HashMap();
        }

        public void a(String r10, long r11) {
            if (this.f10761b.containsKey(r10) == false) goto L5;
            Map<String, Long> r12 = this.f10761b;
            Long r13 = Long.valueOf(r12.get(r10).longValue() + r11);
        L6:
            r12.put(r10, r13);
            this.f10762c += r11;
            return;
        L5:
            r12 = this.f10761b;
            r13 = Long.valueOf(r11);
            goto L6
        }

        public JSONObject b() {
            JSONObject r10 = new JSONObject();
            r10.put("biz", this.f10760a);     // Catch: JSONException -> L13
            r10.put("usage", this.f10762c);     // Catch: JSONException -> L13
            JSONArray r11 = new JSONArray();     // Catch: JSONException -> L13
            Map<String, Long> r12 = this.f10761b;     // Catch: JSONException -> L13
            if (r12 != null) goto L6;
        L11:
            r10.put("detail", r11);     // Catch: JSONException -> L13
            goto L12
        L6:
            if (r12.size() <= 0) goto L11;
            Iterator<Map.Entry<String, Long>> r13 = this.f10761b.entrySet().iterator();     // Catch: JSONException -> L13
        L9:
            if (r13.hasNext() == false) goto L11;
            Map.Entry<String, Long> r14 = r13.next();     // Catch: JSONException -> L13
            JSONObject r15 = new JSONObject();     // Catch: JSONException -> L13
            r15.put("source_id", r14.getKey());     // Catch: JSONException -> L13
            r15.put("usage", r14.getValue());     // Catch: JSONException -> L13
            r11.put(r15);     // Catch: JSONException -> L13
        L12:
            return r10;
        }

        public JSONObject c(long r10) {
            JSONObject r11 = new JSONObject();
            r11.put("biz", this.f10760a);     // Catch: JSONException -> L15
            r11.put("usage", this.f10762c);     // Catch: JSONException -> L15
            JSONArray r12 = new JSONArray();     // Catch: JSONException -> L15
            Map<String, Long> r13 = this.f10761b;     // Catch: JSONException -> L15
            if (r13 != null) goto L6;
        L13:
            r11.put("detail", r12);     // Catch: JSONException -> L15
            goto L14
        L6:
            if (r13.size() <= 0) goto L13;
            Iterator<Map.Entry<String, Long>> r14 = this.f10761b.entrySet().iterator();     // Catch: JSONException -> L15
        L9:
            if (r14.hasNext() == false) goto L13;
            Map.Entry<String, Long> r15 = r14.next();     // Catch: JSONException -> L15
            if (r15.getValue().longValue() < r10) goto L9;
            JSONObject r16 = new JSONObject();     // Catch: JSONException -> L15
            r16.put("source_id", r15.getKey());     // Catch: JSONException -> L15
            r16.put("usage", r15.getValue());     // Catch: JSONException -> L15
            r12.put(r16);     // Catch: JSONException -> L15
        L14:
            return r11;
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f10763a = null;

        static {
            f10763a = new a(null);
        }

        static /* synthetic */ a a() {
            return f10763a;
        }
    }

    private a() {
        this.f10755i = 0;
        this.f10757k = 102400.0d;
    }

    /* synthetic */ a(C0227a r10) {
        this();
    }

    static /* synthetic */ boolean a(a r10) {
        return r10.f10747a;
    }

    private void b(String r10, long r11, String r12) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        boolean r13 = m.c(com.bytedance.apm.d.g());
        boolean r14 = false;
        ActivityLifecycleService r15 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
        if (r15 == null) goto L9;
        r14 = r15.isForeground();
    L9:
        if (this.f10748b != null) goto L12;
        this.f10748b = new HashMap();
    L12:
        if (this.f10749c != null) goto L15;
        this.f10749c = new HashMap();
    L15:
        if (this.f10750d != null) goto L18;
        this.f10750d = new HashMap();
    L18:
        if (this.f10751e != null) goto L21;
        this.f10751e = new HashMap();
    L21:
        if (this.f10752f != null) goto L24;
        this.f10752f = new HashMap();
    L24:
        if (this.f10748b.containsKey(r10) == false) goto L26;
        this.f10748b.get(r10).a(r12, r11);
    L27:
        if (r13 == false) goto L33;
        if (r14 == true) goto L33;
        if (this.f10749c.containsKey(r10) == false) goto L32;
        this.f10749c.get(r10).a(r12, r11);
        goto L33
    L32:
        c r16 = new c(this, r10);
        r16.a(r12, r11);
        this.f10749c.put(r10, r16);
    L33:
        if (r13 == false) goto L39;
        if (r14 == false) goto L39;
        if (this.f10750d.containsKey(r10) == false) goto L38;
        this.f10750d.get(r10).a(r12, r11);
        goto L39
    L38:
        c r17 = new c(this, r10);
        r17.a(r12, r11);
        this.f10750d.put(r10, r17);
    L39:
        if (r13 == true) goto L45;
        if (r14 == true) goto L45;
        if (this.f10751e.containsKey(r10) == false) goto L44;
        this.f10751e.get(r10).a(r12, r11);
        goto L45
    L44:
        c r18 = new c(this, r10);
        r18.a(r12, r11);
        this.f10751e.put(r10, r18);
    L45:
        if (r13 == true) goto L52;
        if (r14 == false) goto L52;
        if (this.f10752f.containsKey(r10) == false) goto L50;
        this.f10752f.get(r10).a(r12, r11);
        goto L52
    L50:
        c r19 = new c(this, r10);
        r19.a(r12, r11);
        this.f10752f.put(r10, r19);
    L52:
        if (this.f10753g != null) goto L55;
        this.f10753g = new HashMap();
    L55:
        if (this.f10753g.containsKey(r10) == false) goto L57;
        this.f10753g.get(r10).a(r12, r11);
    L58:
        Map<String, Map<String, c>> r20 = this.f10756j;
        if (r20 == null) goto L67;
        Iterator<Map.Entry<String, Map<String, c>>> r21 = r20.entrySet().iterator();
    L62:
        if (r21.hasNext() == false) goto L74;
        Map<String, c> r22 = r21.next().getValue();
        if (r22.containsKey(r10) == true) goto L65;
        c r23 = new c(this, r10);
        r23.a(r12, r11);
        r22.put(r10, r23);
        goto L62
    L65:
        r22.get(r10).a(r12, r11);
        goto L62
    L74:
        return;
    L67:
        return;
    L57:
        c r24 = new c(this, r10);
        r24.a(r12, r11);
        this.f10753g.put(r10, r24);
        goto L58
    L26:
        c r25 = new c(this, r10);
        r25.a(r12, r11);
        this.f10748b.put(r10, r25);
        goto L27
    }

    public static a j() {
        return d.a();
    }

    private void p() {
        x.a.p().q(new b(this));
    }

    private void q(boolean r10) {
        this.f10747a = r10;
    }

    private void r(boolean r10) {
        e0.a.i(r10);
    }

    private void t() {
        x.d.v().L(new C0227a(this));
    }

    public void c() {
        Map<String, c> r10 = this.f10748b;
        if (r10 == null) goto L5;
        r10.clear();
    L5:
        Map<String, c> r11 = this.f10749c;
        if (r11 == null) goto L8;
        r11.clear();
    L8:
        Map<String, c> r12 = this.f10750d;
        if (r12 == null) goto L11;
        r12.clear();
    L11:
        Map<String, c> r13 = this.f10751e;
        if (r13 == null) goto L14;
        r13.clear();
    L14:
        Map<String, c> r14 = this.f10752f;
        if (r14 == null) goto L17;
        r14.clear();
    L17:
        y<i> r15 = this.f10754h;
        if (r15 == null) goto L20;
        r15.b();
    L20:
        this.f10755i = 0;
    }

    public long d() {
        return this.f10755i;
    }

    @Nullable
    public Map<String, c> e() {
        return this.f10751e;
    }

    @Nullable
    public Map<String, c> f() {
        return this.f10752f;
    }

    @Nullable
    public Map<String, c> g() {
        return this.f10748b;
    }

    @Nullable
    public Map<String, c> h() {
        return this.f10749c;
    }

    @Nullable
    public Map<String, c> i() {
        return this.f10750d;
    }

    @Nullable
    public y<i> k() {
        return this.f10754h;
    }

    public Map<String, c> l() {
        return this.f10753g;
    }

    public void m(String r10, JSONObject r11) {
        if (this.f10747a == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == true) goto L38;
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.length() == 0) goto L40;
        String r12 = new URL(r10).getPath();     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r12) == false) goto L14;
        return;
    L14:
        String r13 = r11.optString("net_consume_type", INetworkCallback.TYPE_TTNET);     // Catch: Throwable -> L34
        JSONObject r14 = r11.optJSONObject(ICronetClient.KEY_REQUEST_LOG);     // Catch: Throwable -> L34
        if (r14 != null) goto L19;
        String r15 = r11.optString(ICronetClient.KEY_REQUEST_LOG);     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r15) == true) goto L19;
        r14 = new JSONObject(r15);     // Catch: Throwable -> L34
    L19:
        JSONObject r16 = r14.optJSONObject("response");     // Catch: Throwable -> L34
        long r17 = 0;
        if (r16 == null) goto L22;
        r17 = r16.optLong(TrafficChangedObservable.TRAFFICCHANGED_RECEIVEDBYTES) + r16.optLong(TrafficChangedObservable.TRAFFICCHANGED_SENTBYTES);     // Catch: Throwable -> L34
    L22:
        this.f10755i += r17;     // Catch: Throwable -> L34
        if (r17 <= this.f10757k) goto L29;
        if (this.f10754h != null) goto L27;
        this.f10754h = new y(30);     // Catch: Throwable -> L34
    L27:
        this.f10754h.a(new i(r12, r17, r13));     // Catch: Throwable -> L34
    L29:
        if (TextUtils.isEmpty(r10) == false) goto L37;
    L31:
        b(r13, r17, r10);
        l0.c.d().a(r17, r12, r13);
        return;
    L37:
        r10 = Uri.parse(r10).buildUpon().clearQuery().build().toString();     // Catch: Exception -> L33 Throwable -> L34
    L41:
        return;
    L40:
        return;
    }

    @WorkerThread
    @Deprecated
    public void n(JSONObject r10) {
    }

    public void o(double r10) {
    }

    public void s(double r10) {
        this.f10757k = r10;
    }

    public void u() {
        q(true);
        r(true);
        t();
        p();
    }
}
