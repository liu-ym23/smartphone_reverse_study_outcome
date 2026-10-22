package w4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.connectionclass.ConnectionQuality;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowApiHttpException;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.n;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.tnc.TNCManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r2.i;

/* JADX INFO: loaded from: classes.dex */
public class a implements o2.f.e, WeakHandler.IHandler, g3.a.InterfaceC0172a, com.bytedance.ttnet.c.InterfaceC0072c, i.b, i.a, m2.a.b, o2.f.i, i.c, o2.f.g, o2.f.j {
    private static a G = null;
    private static String H = null;
    private static String I = "";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static int f13328J = -1;
    private static int K = -1;
    static boolean L = false;
    static boolean M = true;
    static boolean N = false;
    private static ArrayList<String> O;
    static boolean P;
    private static boolean Q;
    private static boolean R;
    private String A;
    private JSONObject B;
    private String C;
    private final AtomicInteger D;
    private final List<String> E;
    final WeakHandler F;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f13329c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AtomicLong f13330g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AtomicBoolean f13331h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f13332i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Context f13333j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f13334k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile int f13335l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f13336m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private AtomicBoolean f13337n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f13338o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f13339p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f13340q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f13341r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f13342s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f13343t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f13344u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f13345v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f13346w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private List<String> f13347x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private List<String> f13348y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private volatile int f13349z;

    /* JADX INFO: renamed from: w4.a$a, reason: collision with other inner class name */
    class C0311a extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ a f13350j;

        C0311a(a r10, String r11) {
            this.f13350j = r10;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            this.f13350j.F();
        }
    }

    class b extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ TNCManager.TNCUpdateSource f13351j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ boolean f13352k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ a f13353l;

        b(a r10, String r11, TNCManager.TNCUpdateSource r12, boolean r13) {
            this.f13353l = r10;
            this.f13351j = r12;
            this.f13352k = r13;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            this.f13353l.K(this.f13351j, this.f13352k);
        }
    }

    class c extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ Map f13354j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ a f13355k;

        c(a r10, String r11, Map r12) {
            this.f13355k = r10;
            this.f13354j = r12;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            TTNetInit.getTTNetDepend().b(a.m(this.f13355k), this.f13354j);
            Intent r10 = new Intent("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG");
            if (TextUtils.isEmpty(a.n()) == true) goto L5;
            r10.setPackage(a.n());
        L5:
            a.m(this.f13355k).sendBroadcast(r10);
        }
    }

    class d extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ Map f13356j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ a f13357k;

        d(a r10, String r11, Map r12) {
            this.f13357k = r10;
            this.f13356j = r12;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            TTNetInit.getTTNetDepend().b(a.m(this.f13357k), this.f13356j);
        }
    }

    static final class e extends BroadcastReceiver {

        /* JADX INFO: renamed from: w4.a$e$a, reason: collision with other inner class name */
        class C0312a extends r1.c {
            C0312a(e r10, String r11) {
                super(r11);
            }

            @Override // r1.c, java.lang.Runnable
            public void run() {
                h.c().a();
            }
        }

        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            if ("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG".equals(r11.getAction()) == false) goto L8;
            new C0312a(this, "SyncMainProcessConfig").a();
            return;
        }
    }

    static {
        ArrayList<String> r10 = new ArrayList();
        O = r10;
        P = false;
        r10.add("MI PAD 2");
        O.add("YT3-X90L");
        O.add("YT3-X90F");
        O.add("GT-810");
        Q = false;
        R = false;
    }

    private a(Context r10, boolean r11) {
        this.f13330g = new AtomicLong(0);
        this.f13331h = new AtomicBoolean(false);
        this.f13332i = new Object();
        this.f13334k = false;
        this.f13335l = -1;
        this.f13336m = 0;
        this.f13337n = new AtomicBoolean(false);
        this.f13338o = 0;
        this.f13339p = 0;
        this.f13340q = 0;
        this.f13341r = 1;
        this.f13342s = 1;
        this.f13343t = 1;
        this.f13344u = 1;
        this.f13345v = 1;
        this.f13346w = "";
        this.f13347x = new CopyOnWriteArrayList();
        this.f13348y = new CopyOnWriteArrayList();
        this.A = "";
        this.D = new AtomicInteger(10800);
        this.E = new CopyOnWriteArrayList();
        this.F = new WeakHandler(Looper.getMainLooper(), this);
        this.f13333j = r10;
        this.f13329c = r11;
    }

    private void B(JSONObject r10, String r11) {
        if (r10 != null) goto L8;
        return;
    L8:
        r10.put("return", r11);     // Catch: JSONException -> L7
        r10.put("CurrentShareCookieHostList", this.f13347x.toString());     // Catch: JSONException -> L7
    L5:
        TTNetInit.getTTNetDepend().d(TTNetInit.getTTNetDepend().getContext(), "handleResponse", "shareCookieHostList", r10);
    }

    private void J(TNCManager.TNCUpdateSource r10, boolean r11) {
        if (this.f13329c == false) goto L6;
        o(r10, r11);
        return;
    L6:
        if (this.f13330g.get() > 0) goto L13;
        new C0311a(this, "LoadDomainConfig4Other-Thread").a();     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    static /* synthetic */ Context m(a r10) {
        return r10.f13333j;
    }

    static /* synthetic */ String n() {
        return H;
    }

    public static a r(Context r10) {
        monitor-enter(a.class);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (G != null) goto L24;
        boolean r11 = com.bytedance.frameworks.baselib.network.http.util.g.h(r10);     // Catch: Throwable -> L27
        G = new a(r10.getApplicationContext(), r11);     // Catch: Throwable -> L27
        if (O.contains(Build.MODEL) == false) goto L9;
        P = true;     // Catch: Throwable -> L27
    L9:
        H = r10.getPackageName();     // Catch: Throwable -> L27
        if (r11 == false) goto L15;
        g3.a.e(G);     // Catch: Throwable -> L27
        i.P(G);     // Catch: Throwable -> L27
        i.O(G);     // Catch: Throwable -> L27
        i.Q(G);     // Catch: Throwable -> L27
        com.bytedance.ttnet.c.e(G);     // Catch: Throwable -> L27
        m2.a.c().f(G);     // Catch: Throwable -> L27
        o2.f.K(G);     // Catch: Throwable -> L27
        o2.f.I(G);     // Catch: Throwable -> L27
        if (o2.f.l() != null) goto L23;
        o2.f.j r12 = G;     // Catch: Throwable -> L27
    L14:
        o2.f.M(r12);     // Catch: Throwable -> L27
    L23:
        o2.f.H(G);     // Catch: Throwable -> L27
        w4.d.a(r10);     // Catch: Throwable -> L27
        goto L24
    L15:
        IntentFilter r13 = new IntentFilter();     // Catch: Throwable -> L27
        r13.addAction("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG");     // Catch: Throwable -> L27
        com.bytedance.ttnet.utils.d.f(r10, new e(), r13);     // Catch: Throwable -> L18
    L20:
        h r14 = h.c();     // Catch: Throwable -> L27
        g3.a.e(r14);     // Catch: Throwable -> L27
        i.P(r14);     // Catch: Throwable -> L27
        i.O(r14);     // Catch: Throwable -> L27
        com.bytedance.ttnet.c.e(r14);     // Catch: Throwable -> L27
        if (o2.f.l() != null) goto L23;
        r12 = r14;
        goto L14
    L18:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L27
    L24:
        a r15 = G;     // Catch: Throwable -> L27
        monitor-exit(a.class);     // Catch: Throwable -> L27
        return r15;
    }

    public static String s() {
        return "ss_app_config";
    }

    public static boolean x() {
        if (w4.c.f() == false) goto L29;
        return y();
    L29:
    L26:
        th = move-exception;
        th.printStackTrace();
    L28:
        return false;
    L8:
        if (Build.VERSION.SDK_INT >= 21) goto L10;
        String r10 = Build.CPU_ABI;     // Catch: Throwable -> L26
    L12:
        if (TextUtils.isEmpty(r10) == false) goto L15;
        return false;
    L15:
        if ("x86".equalsIgnoreCase(r10) == true) goto L20;
        if ("x86_64".equalsIgnoreCase(r10) == false) goto L28;
    L20:
        if (y4.a.e() == false) goto L23;
        Logger.d("AppConfig", "x86 support");     // Catch: Throwable -> L26
        return false;
    L23:
        Logger.w("AppConfig", "Cronet unsupported CPU arch: " + r10);     // Catch: Throwable -> L26
        n.v(2);     // Catch: Throwable -> L26
        return true;
    L10:
        r10 = Build.SUPPORTED_ABIS[0];     // Catch: Throwable -> L26
        goto L12
    }

    private static boolean y() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        String[] r10 = Build.SUPPORTED_ABIS;
        int r11 = r10.length;
        int r12 = 0;
    L10:
        if (r12 >= r11) goto L15;
        if (r10[r12].contains("arm") == true) goto L13;
        r12 = r12 + 1;
    L13:
        boolean r13 = true;
    L17:
        if (r13 == false) goto L22;
        if (n.l() != 2) goto L27;
        n.v(-1);
    L27:
        if (Logger.debug() == false) goto L30;
        StringBuilder r14 = new StringBuilder();
        r14.append("use isCronetUnsupportedABIv2, result is ");
        r14.append(!r13);
        Logger.d("AppConfig", r14.toString());
    L30:
        return !r13;
    L22:
        if (y4.a.e() == false) goto L25;
        Logger.d("AppConfig", "x86 support");
        return false;
    L25:
        n.v(2);
    L15:
        r13 = false;
        goto L17
    L5:
        if (Build.CPU_ABI.contains("arm") == true) goto L13;
        if (Build.CPU_ABI2.contains("arm") == false) goto L15;
        goto L15
    }

    private boolean z() {
        if (p() != null) goto L5;
    L26:
        return true;
    L5:
        if (p().length < 1) goto L26;
        String r10 = p()[0];
        if (TextUtils.isEmpty(r10) == false) goto L10;
        return true;
    L10:
        String r11 = ReportConsts.HTTPS + r10 + "/get_domains/v5/";
        String r12 = o2.f.c(r11, true);
        if (r11.equals(r12) == false) goto L13;
        return true;
    L13:
        LinkedHashMap r13 = new LinkedHashMap();
        k.k(r12, r13);     // Catch: Exception -> L27
        if (r13.containsKey("device_id") == true) goto L17;
        return true;
    L17:
        List r14 = (List) r13.get("device_id");     // Catch: Exception -> L27
        if (r14 != null) goto L20;
        return true;
    L20:
        Iterator r15 = r14.iterator();     // Catch: Exception -> L27
    L22:
        if (r15.hasNext() == false) goto L26;
        if (((String) r15.next()).equals(NetConst.NOT_ENCRYPT_VERISON_CODE) == true) goto L22;
        return false;
    }

    public void A() {
        SharedPreferences r10 = this.f13333j.getSharedPreferences("ss_app_config", 0);
        if (this.f13335l >= 0) goto L6;
        this.f13335l = r10.getInt("chromium_boot_failures", 0);
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("AppConfig", "mChromiumBootFailures is " + this.f13335l);
    L8:
        this.f13336m = r10.getLong("chromium_boot_failures_timestamp", 0);
        if (this.f13335l > 5) goto L11;
        return;
    L11:
        if ((System.currentTimeMillis() - this.f13336m) <= TimeUnit.HOURS.toMillis(1)) goto L15;
        this.f13335l = 5;
        return;
    }

    public void C() {
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (Logger.debug() == false) goto L7;
        Logger.d("AppConfig", "KEY_CHROMIUM_BOOT_FAILURES set 0");     // Catch: Throwable -> L11
    L7:
        if (this.f13335l != 0) goto L9;
        return;
    L9:
        this.f13335l = 0;     // Catch: Throwable -> L11
        SharedPreferences.Editor r10 = this.f13333j.getSharedPreferences("ss_app_config", 0).edit();     // Catch: Throwable -> L11
        r10.putInt("chromium_boot_failures", 0);     // Catch: Throwable -> L11
        t1.a.a(r10);     // Catch: Throwable -> L11
        LinkedHashMap r11 = new LinkedHashMap();     // Catch: Throwable -> L11
        r11.put("chromium_boot_failures", 0);     // Catch: Throwable -> L11
        TTNetInit.getTTNetDepend().b(this.f13333j, r11);     // Catch: Throwable -> L11
    }

    public void D(String r10) {
        this.B = o2.b.b(r10);
        TNCManager.m().o().j(r10);
    }

    public void E(String r10) {
        this.A = r10;
    }

    synchronized void F() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if ((System.currentTimeMillis() - this.f13330g.get()) <= (((long) this.D.get()) * 1000)) goto L15;
        this.f13330g.set(System.currentTimeMillis());     // Catch: Throwable -> L17
        int r10 = TTNetInit.getTTNetDepend().i(this.f13333j, "disable_framed_transport", 0);     // Catch: Exception -> L20 Throwable -> L17
        if (r10 <= 0) goto L13;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.d.c(r10);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L20 Throwable -> L17
    L13:
        if (TNCManager.m().o() == null) goto L15;
        TNCManager.m().o().g(this.f13330g.get());     // Catch: Exception -> L20 Throwable -> L17
    L15:
        monitor-exit(this);
    }

    public void G() {
        Object r10 = this.f13332i;
        monitor-enter(r10);
    L75:
        th = move-exception;
        throw th;
    L5:
        if (this.f13334k == false) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L75
        return;
    L8:
        boolean r11 = true;
        this.f13334k = true;     // Catch: Throwable -> L75
        monitor-exit(r10);     // Catch: Throwable -> L75
        SharedPreferences r12 = this.f13333j.getSharedPreferences("ss_app_config", 0);
        r12.getInt("ok_http_open", 0);
        r12.getInt("ok_http3_open", 0);
        r12.getInt("cronet_version", 0);
        this.f13338o = r12.getInt("http_dns_enabled", 0);
        r12.getInt("detect_open", 0);
        r12.getInt("detect_native_page", 1);
        r12.getInt("collect_recent_page_info_enable", 1);
        this.f13339p = r12.getInt("add_ss_queries_open", 0);
        this.f13340q = r12.getInt("add_ss_queries_header_open", 0);
        this.f13341r = r12.getInt("add_ss_queries_plaintext_open", 1);
        r12.getInt("add_device_fingerprint_open", 1);
        this.f13345v = r12.getInt("dynamic_adjust_threadpool_size_open", 1);
        if (this.f13335l >= 0) goto L14;
        this.f13335l = r12.getInt("chromium_boot_failures", 0);
    L14:
        if (this.f13345v <= 0) goto L16;
        boolean r13 = true;
    L17:
        com.bytedance.frameworks.baselib.network.dispatcher.c.e(r13);
        this.f13342s = r12.getInt("image_ttnet_enabled", 1);
        this.f13343t = r12.getInt("sample_band_width_enabled", 1);
        this.f13344u = r12.getInt("cdn_sample_band_width_enabled", 1);
        f13328J = r12.getInt("use_http_dns", -1);
        K = r12.getInt("use_http_dns_refetch_on_expire", -1);
        z2.d.d(r12);
        i.c0(null, r12);
        com.bytedance.ttnet.utils.a.d(r12);
        if (this.f13339p <= 0) goto L20;
    L21:
        e5.a.e(true);
    L22:
        I = r12.getString(WsConstants.KEY_FRONTIER_URLS, "");
        this.f13346w = r12.getString("cronet_so_path", "");
        String r14 = r12.getString("api_http_host_list", "");
        if (com.bytedance.common.utility.g.b(r14) == true) goto L30;
        String[] r15 = r14.split(",");
        int r16 = r15.length;
        int r17 = 0;
    L25:
        if (r17 >= r16) goto L30;
        String r18 = r15[r17];
        if (com.bytedance.common.utility.g.b(r18) == true) goto L29;
        this.f13348y.add(r18.trim());
    L29:
        r17 = r17 + 1;
    L30:
        r2.f.d().i(r12.getString("concurrent_request_config", ""));
        r12.getString("add_common_params", "");
        p2.b.b().a();
        d3.d.f().k(r12.getString("L0_params", ""));
        int r19 = r12.getInt("query_filter_enabled", Integer.MIN_VALUE);
        String r20 = r12.getString("query_filter_actions", "");
        if (r19 == Integer.MIN_VALUE) goto L37;
        d3.d r21 = d3.d.f();
        if (r19 <= 0) goto L35;
        boolean r22 = true;
    L36:
        r21.d(r22);
        d3.d.f().g(r20);
        goto L37
    L35:
        r22 = false;
    L37:
        String r23 = r12.getString("share_cookie_host_list", "");
        com.bytedance.ttnet.utils.d.d(r23, this.f13347x);
        String r24 = TTNetInit.getTTNetDepend().k();
        if (com.bytedance.common.utility.g.b(r24) == true) goto L43;
        if (com.bytedance.ttnet.utils.d.a(r24, this.f13347x) == true) goto L43;
        this.f13347x.add(r24);
    L43:
        if (r12.getInt("private_protocol_enabled", 1) < 1) goto L45;
        boolean r25 = true;
    L46:
        o2.f.R(r25);
        int r26 = r12.getInt("destroy_delta_millis", 100);
        if (r26 < 0) goto L50;
        o2.f.O(r26);
    L50:
        if (r12.getInt("disable_rotating_host_path_retry", -1) >= 1) goto L53;
        r11 = false;
    L53:
        o2.f.P(r11);
        this.D.set(r12.getInt("tnc_update_interval", 10800));
        String r27 = r12.getString("send_tnc_host_arrays", "");
        if (TextUtils.isEmpty(r27) == true) goto L56;
        String[] r28 = r27.split(",");
        this.E.clear();
        this.E.addAll(Arrays.asList(r28));
    L56:
        this.C = r12.getString("tnc_summary", "");
        if (TNCManager.m().o() == null) goto L59;
        TNCManager.m().o().f(this.f13330g.get());
    L59:
        int r29 = r12.getInt("disable_framed_transport", 0);
        if (r29 <= 0) goto L66;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.d.c(r29);     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        th.printStackTrace();
    L66:
        if (this.f13329c == false) goto L86;
        LinkedHashMap r30 = new LinkedHashMap();     // Catch: Throwable -> L72
        if (com.bytedance.common.utility.g.b(I) == true) goto L70;
        r30.put(WsConstants.KEY_FRONTIER_URLS, I);     // Catch: Throwable -> L72
    L70:
        r30.put("http_dns_enabled", Integer.valueOf(this.f13338o));     // Catch: Throwable -> L72
        r30.put("add_ss_queries_open", Integer.valueOf(this.f13339p));     // Catch: Throwable -> L72
        r30.put("add_ss_queries_header_open", Integer.valueOf(this.f13340q));     // Catch: Throwable -> L72
        r30.put("add_ss_queries_plaintext_open", Integer.valueOf(this.f13341r));     // Catch: Throwable -> L72
        r30.put("chromium_boot_failures", Integer.valueOf(this.f13335l));     // Catch: Throwable -> L72
        r30.put("share_cookie_host_list", r23);     // Catch: Throwable -> L72
        r30.put("disable_framed_transport", Integer.valueOf(r29));     // Catch: Throwable -> L72
        new c(this, "SaveMapToProvider-Thread", r30).a();     // Catch: Throwable -> L72
        return;
    L72:
        th = move-exception;
        th.printStackTrace();
        return;
    L86:
        return;
    L45:
        r25 = false;
        goto L46
    L20:
        if (this.f13340q <= 0) goto L22;
    L16:
        r13 = false;
        goto L17
    }

    public void H(TNCManager.TNCUpdateSource r10) {
        I(r10, false);
    }

    public void I(TNCManager.TNCUpdateSource r10, boolean r11) {
        J(r10, r11);
    }

    void K(TNCManager.TNCUpdateSource r10, boolean r11) {
        if (Logger.debug() == false) goto L6;
        Logger.d("TNCManager", "doRefresh, actual request");
    L6:
        if (NetworkUtils.g(this.f13333j) == true) goto L8;
        return;
    L8:
        G();
        if (i() == true) goto L11;
    L14:
        if (r11 == true) goto L16;
    L22:
        int r12 = 102;
        if (TNCManager.m().j(this.f13333j, true, r10, this.C) == false) goto L25;
    L24:
        r12 = 101;
    L28:
        this.F.sendEmptyMessage(r12);
        this.F.removeMessages(103);
        this.F.sendEmptyMessageDelayed(103, ((long) this.D.get()) * 1000);
        return;
    L25:
        Logger.d("AppConfig", "tnc reqeust through okhttp failed, fallback to HttpUrlConnection");
        if (TNCManager.m().j(this.f13333j, false, TNCManager.TNCUpdateSource.PORTRETRY, this.C) == false) goto L28;
    L16:
        if (z() == false) goto L22;
        if (Logger.debug() == false) goto L20;
        Logger.d("TNCManager", "did is empty, delay 5s send tnc again");
    L20:
        this.F.sendEmptyMessageDelayed(104, 5000);
        this.f13331h.set(false);
        return;
    L11:
        if (r10 == TNCManager.TNCUpdateSource.TTCRONETFAILED) goto L14;
        this.f13331h.set(false);
    }

    @Override // o2.f.e
    @Deprecated
    public String a(String r10, o2.c r11) {
        if (com.bytedance.common.utility.g.b(r10) == false) goto L14;
        return r10;
    L14:
    L10:
        th = move-exception;
        th.printStackTrace();
    L12:
        return r10;
    L6:
        if (this.f13329c == false) goto L8;
        G();     // Catch: Throwable -> L10
    L13:
        goto L12
    L8:
        F();     // Catch: Throwable -> L10
        goto L13
    }

    @Override // o2.f.i
    public boolean b(String r10) {
        if (com.bytedance.common.utility.g.b(r10) == false) goto L6;
        return false;
    L6:
        if (this.f13343t > 0) goto L21;
        return false;
    L21:
        URI r11 = com.bytedance.frameworks.baselib.network.http.util.i.b(r10);     // Catch: Throwable -> L18
        if (r11 != null) goto L11;
        return false;
    L11:
        String r12 = r11.getHost();     // Catch: Throwable -> L18
        if (com.bytedance.common.utility.g.b(r12) == false) goto L14;
        return false;
    L14:
        if (r12.endsWith(com.bytedance.ttnet.b.a()) == false) goto L20;
        return true;
    L20:
        return false;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    @Override // o2.f.e
    public void c(String r10, String r11, boolean r12) {
        if (this.f13348y.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<String> r13 = this.f13348y.iterator();
    L7:
        if (r13.hasNext() == false) goto L29;
        String r14 = r13.next();
        if (com.bytedance.common.utility.g.b(r14) == true) goto L7;
        if (r10.endsWith(r14) == false) goto L7;
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L20
        r15.put("url", r10 + r11);     // Catch: Throwable -> L20
        r15.put("replace", r12);     // Catch: Throwable -> L20
        TTNetInit.monitorLogSend("api_http", r15);     // Catch: Throwable -> L20
    L14:
        if (TTNetInit.apiHttpInterceptEnabled() == false) goto L19;
        if (r12 == false) goto L18;
        return;
    L18:
        throw new NotAllowApiHttpException("Api http request is not allowed to be executed");
    L19:
        return;
    }

    @Override // g3.a.InterfaceC0172a
    public boolean d() {
        if (R == false) goto L6;
        return false;
    L6:
        if (this.f13340q <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // g3.a.InterfaceC0172a
    public boolean e() {
        if (R == false) goto L6;
        return true;
    L6:
        if (this.f13341r > 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // o2.f.j
    public List<String> f(CookieManager r10, com.bytedance.frameworks.baselib.network.http.impl.b r11, URI r12) {
        if (r12 == null) goto L42;
        if (r10 != null) goto L45;
        if (r11 == null) goto L42;
    L45:
        String r13 = r12.getHost();     // Catch: Exception -> L9
    L11:
        if (com.bytedance.common.utility.g.b(r13) == true) goto L42;
        if (com.bytedance.ttnet.utils.d.a(r13, this.f13347x) == false) goto L42;
        if (com.bytedance.common.utility.g.b(TTNetInit.getTTNetDepend().k()) == false) goto L18;
        return null;
    L18:
        ArrayList r14 = new ArrayList();
        if (r10 == null) goto L25;
        String r15 = r10.getCookie(r12.getScheme() + "://" + TTNetInit.getTTNetDepend().k());
        if (com.bytedance.common.utility.g.b(r15) == true) goto L25;
        r14.add(r15);
        return r14;
    L25:
        if (com.bytedance.common.utility.c.a(r14) == false) goto L49;
        if (r11 == null) goto L50;
        Map<String, List<String>> r16 = r11.get(URI.create(r12.getScheme() + "://" + TTNetInit.getTTNetDepend().k()), new LinkedHashMap());     // Catch: Throwable -> L37
        if (r16 != null) goto L30;
        return r14;
    L30:
        if (r16.isEmpty() == true) goto L52;
        List<String> r17 = r16.get("Cookie");     // Catch: Throwable -> L37
        if (r17 == null) goto L41;
        r17.add("x-tt-cookie-backup-source=1");     // Catch: Throwable -> L35
    L35:
        Throwable th = th;
    L39:
        th.printStackTrace();
    L41:
        return r17;
    L52:
        return r14;
    L37:
        th = move-exception;
        r17 = r14;
        th = th;
        goto L39
    L50:
        return r14;
    L49:
        return r14;
    L9:
        r13 = null;
    L42:
        return null;
    }

    @Override // o2.f.j
    public List<String> g(String r10) {
        if (com.bytedance.ttnet.utils.d.a(r10, this.f13347x) == true) goto L5;
        return null;
    L5:
        return this.f13347x;
    }

    @Override // r2.i.b
    public boolean h() {
        if (Q == false) goto L6;
        return false;
    L6:
        if (this.f13338o <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public void handleConfigUpdate(String r10) {
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        switch(r10.what) {
            case 101: goto L17;
            case 102: goto L15;
            case 103: goto L10;
            case 104: goto L6;
            default: goto L24;
        };
    L17:
        this.f13330g.set(System.currentTimeMillis());
        if (Logger.debug() == false) goto L21;
        String r11 = "doRefresh, succ";
    L20:
        Logger.d("TNCManager", r11);
    L21:
        this.f13331h.set(false);
        return;
    L24:
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("TNCManager", "did is empty, delay request tnc");
    L8:
        TNCManager.TNCUpdateSource r12 = TNCManager.TNCUpdateSource.TTSERVER;
    L13:
        H(r12);
        return;
    L10:
        if (Logger.debug() == false) goto L12;
        Logger.d("TNCManager", "do tnc polling");
    L12:
        r12 = TNCManager.TNCUpdateSource.TTPOLL;
        goto L13
    L15:
        if (Logger.debug() == false) goto L21;
        r11 = "doRefresh, error";
        goto L20
    }

    @Override // com.bytedance.ttnet.c.InterfaceC0072c
    public boolean i() {
        if (M == false) goto L8;
        if (this.f13337n.compareAndSet(false, true) == false) goto L8;
        A();
    L8:
        if (N == false) goto L12;
        n.v(0);
        return false;
    L12:
        if (P == false) goto L16;
        n.v(8);
        return false;
    L16:
        if (x() == false) goto L19;
        return false;
    L19:
        if (L == true) goto L25;
        if (this.f13335l <= 5) goto L25;
        n.v(3);
        Logger.e("AppConfig", "After five consecutive crashes of cronet, you must reinstall app to enable cronet, or wait until several hours");
        return false;
    L25:
        if (TTNetInit.getTTNetDepend().g() == true) goto L28;
        n.v(6);
        return false;
    L28:
        return true;
    }

    @Override // r2.i.a
    public boolean isCronetBootFailureExpected() {
        if (Logger.debug() == false) goto L5;
        Logger.d("AppConfig", "isCronetBootFailureExpected...");
    L5:
        boolean r10 = false;
        SharedPreferences r11 = this.f13333j.getSharedPreferences("ss_app_config", 0);
        if (M == true) goto L16;
        if (this.f13335l >= 0) goto L10;
        this.f13335l = r11.getInt("chromium_boot_failures", 0);
    L10:
        this.f13336m = r11.getLong("chromium_boot_failures_timestamp", 0);
        if (this.f13335l <= 5) goto L16;
        if ((System.currentTimeMillis() - this.f13336m) <= TimeUnit.HOURS.toMillis(1)) goto L16;
        this.f13335l = 5;
    L16:
        if (i() == false) goto L24;
        SharedPreferences.Editor r12 = r11.edit();
        r10 = true;
        r12.putInt("chromium_boot_failures", this.f13335l + 1);
        r12.putLong("chromium_boot_failures_timestamp", System.currentTimeMillis());
        if (Logger.debug() == false) goto L20;
        Logger.d("AppConfig", "KEY_CHROMIUM_BOOT_FAILURES inc...");
    L20:
        t1.a.a(r12);
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("chromium_boot_failures", Integer.valueOf(this.f13335l + 1));
        if (TTNetInit.getCronetProvider().getOptInit() == false) goto L23;
        new d(this, "SaveMapToProvider-Thread", r13).a();
        goto L24
    L23:
        TTNetInit.getTTNetDepend().b(this.f13333j, r13);
    L24:
        return r10;
    }

    @Override // r2.i.c
    public JSONObject j() {
        return this.B;
    }

    @Override // g3.a.InterfaceC0172a
    public boolean k() {
        if (R == false) goto L6;
        return true;
    L6:
        if (this.f13339p > 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // m2.a.b
    public void l(ConnectionQuality r10) {
        if (Logger.debug() == false) goto L7;
        if (r10 == null) goto L8;
        Logger.d("AppConfig", "onBandwidthStateChange bandwidthState = " + r10);
        return;
    L8:
        return;
    }

    public boolean o(TNCManager.TNCUpdateSource r10, boolean r11) {
        if (Logger.debug() == false) goto L6;
        Logger.d("TNCManager", "doRefresh: updating state " + this.f13331h.get());
    L6:
        if (this.f13331h.compareAndSet(false, true) == false) goto L8;
    L13:
        new b(this, "AppConfigThread", r10, r11).a();
        return true;
    L8:
        if (r10 == TNCManager.TNCUpdateSource.TTCRONETFAILED) goto L13;
        if (Logger.debug() == false) goto L12;
        Logger.d("TNCManager", "doRefresh, already running " + r10);
    L12:
        return false;
    }

    public String[] p() {
        String[] r10 = TTNetInit.getTTNetDepend().f();
        if (r10 == null) goto L7;
        if (r10.length <= 0) goto L7;
        return r10;
    L7:
        return new String[0];
    }

    public String q() {
        return this.f13346w;
    }

    public List<String> t() {
        return this.E;
    }

    public String u() {
        return this.C;
    }

    public void v(String r10, Object r11) {
        if (w4.e.c(r11) == true) goto L22;
        return;
    L22:
        boolean r12 = w(r11, TNCManager.TNCUpdateSource.TTCRONET, System.currentTimeMillis(), false);     // Catch: Exception -> L7
    L9:
        int r13 = 102;
        if (r12 == false) goto L20;
        r13 = 101;
    L20:
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L14
        r14.put("from", "cronet");     // Catch: Throwable -> L14
        TTNetInit.getTTNetDepend().a(this.f13333j, r14);     // Catch: Throwable -> L14
    L24:
        handleConfigUpdate(r10);     // Catch: Throwable -> L19
    L17:
        this.F.sendEmptyMessage(r13);
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
        r12 = false;
        goto L9
    }

    public boolean w(Object r38, TNCManager.TNCUpdateSource r39, long r40, boolean r42) {
        JSONObject r10 = new JSONObject();
        if ((r38 instanceof String) == false) goto L11;
        String r11 = (String) r38;
        if (com.bytedance.common.utility.g.b(r11) == false) goto L9;
        String r12 = "empty response.";
    L7:
        B(r10, r12);
        return false;
    L9:
        JSONObject r13 = new JSONObject(r11);
    L17:
        if (r13 != null) goto L19;
        r12 = "object is null.";
        goto L7
    L19:
        this.C = r13.optString("summary");
        JSONObject r14 = r13.getJSONObject("data");
        f13328J = r14.optInt("use_http_dns", -1);
        K = r14.optInt("collect_recent_page_info_enable", -1);
        int r15 = r14.optInt("ok_http_open", 0);
        int r16 = r14.optInt("ok_http3_open", 0);
        int r17 = r14.optInt("cronet_version", 0);
        int r18 = r14.optInt("http_dns_enabled", 0);
        int r19 = r14.optInt("detect_open", 0);
        int r110 = r14.optInt("detect_native_page", 1);
        int r111 = r14.optInt("collect_recent_page_info_enable", 1);
        int r20 = r14.optInt("add_ss_queries_open", 0);
        int r21 = r14.optInt("add_ss_queries_header_open", 0);
        int r22 = r14.optInt("add_ss_queries_plaintext_open", 1);
        int r23 = r14.optInt("add_device_fingerprint_open", 1);
        int r24 = r14.optInt("image_ttnet_enabled", 1);
        int r25 = r14.optInt("sample_band_width_enabled", 1);
        int r112 = r14.optInt("cdn_sample_band_width_enabled", 1);
        int r113 = r14.optInt("dynamic_adjust_threadpool_size_open", 1);
        int r114 = r14.optInt("http_show_hijack", 1);
        int r115 = r14.optInt("http_verify_sign", 1);
        int r116 = r14.optInt("tnc_update_interval", -1);
        if (r116 <= 0) goto L22;
        this.D.set(r116);
    L22:
        int r117 = r14.optInt("private_protocol_enabled", 1);
        if (r117 < 1) goto L25;
        boolean r118 = true;
    L26:
        o2.f.R(r118);
        int r119 = r14.optInt("destroy_delta_millis", 100);
        if (r119 < 0) goto L29;
        o2.f.O(r119);
    L29:
        int r120 = r14.optInt("disable_rotating_host_path_retry", -1);
        if (r120 < 1) goto L32;
        boolean r121 = true;
    L33:
        o2.f.P(r121);
        JSONArray r122 = r14.optJSONArray("send_tnc_host_arrays");
        if (r122 == null) goto L44;
        this.E.clear();
        int r123 = 0;
    L37:
        if (r123 >= r122.length()) goto L43;
        if (TextUtils.isEmpty(r122.optString(r123)) == true) goto L42;
        this.E.add(r122.optString(r123));
    L42:
        r123 = r123 + 1;
        r16 = r16;
        goto L37
    L43:
        int r28 = r16;
    L45:
        int r26 = r14.optInt("crash_limit_times", 0);
        int r27 = r14.optInt("crash_detect_interval_ms", 5000);
        monitor-enter(this);
        this.f13338o = r18;     // Catch: Throwable -> L152
        this.f13339p = r20;     // Catch: Throwable -> L152
        this.f13340q = r21;     // Catch: Throwable -> L152
        this.f13341r = r22;     // Catch: Throwable -> L152
        this.f13345v = r113;     // Catch: Throwable -> L152
        this.f13342s = r24;     // Catch: Throwable -> L152
        this.f13343t = r25;     // Catch: Throwable -> L152
        this.f13344u = r112;     // Catch: Throwable -> L152
        monitor-exit(this);     // Catch: Throwable -> L152
        if (r113 <= 0) goto L51;
        boolean r29 = true;
    L52:
        com.bytedance.frameworks.baselib.network.dispatcher.c.e(r29);
        if (r14.optInt("enable_req_ticket", 1) <= 0) goto L55;
        boolean r30 = true;
    L56:
        com.bytedance.ttnet.utils.c.e(r30);
        com.bytedance.ttnet.utils.a.C0075a r124 = com.bytedance.ttnet.utils.a.e(r14);
        if (this.f13339p <= 0) goto L59;
    L62:
        e5.a.e(true);
    L63:
        z2.d.f(r14);
        i.c0(r14, null);
        String r125 = r14.optString(WsConstants.KEY_FRONTIER_URLS, "");
        String r126 = r14.optString("share_cookie_host_list", "");
        TTNetInit.getTTNetDepend().e(r126);
        String r127 = r14.optString("api_http_host_list", "");
        String r128 = r14.optString("concurrent_request_config", "");
        r2.f.d().i(r128);
        String r129 = r14.optString("add_common_params", "");
        p2.b.b().a();
        String r130 = r14.optString("L0_params", "");
        d3.d.f().k(r130);
        int r131 = r14.optInt("query_filter_enabled", Integer.MIN_VALUE);
        String r132 = w4.e.e(r38, r14, new String[]{"data", "query_filter_actions"});
        if (r131 == Integer.MIN_VALUE) goto L70;
        d3.d r31 = d3.d.f();
        if (r131 <= 0) goto L68;
        boolean r32 = true;
    L69:
        r31.d(r32);
        d3.d.f().g(r132);
        goto L70
    L68:
        r32 = false;
    L70:
        this.f13349z = r14.optInt("disable_encrypt_switch", 0);
        this.f13346w = r14.optString("cronet_so_path", "");
        if (this.f13349z != 2) goto L73;
        int r133 = 0;
        SharedPreferences.Editor r33 = this.f13333j.getSharedPreferences("app_log_encrypt_switch_count", 0).edit();
        r33.putInt("app_log_encrypt_faild_count", 0);
        t1.a.a(r33);
    L74:
        int r34 = r14.optInt("disable_framed_transport", r133);
        if (r34 > 0) goto L154;
    L80:
        monitor-enter(this);
        SharedPreferences r35 = this.f13333j.getSharedPreferences("ss_app_config", 0);     // Catch: Throwable -> L147
        String r134 = r35.getString("share_cookie_host_list", "");     // Catch: Throwable -> L147
        SharedPreferences.Editor r36 = r35.edit();     // Catch: Throwable -> L147
        r36.putString("ttnet_response_verify", r124.f2941b);     // Catch: Throwable -> L147
        r36.putInt("ttnet_response_verify_enabled", r124.f2940a);     // Catch: Throwable -> L147
        z2.d.e(r36);     // Catch: Throwable -> L147
        i.D(r36);     // Catch: Throwable -> L147
        r36.putInt("ok_http_open", r15);     // Catch: Throwable -> L147
        r36.putInt("ok_http3_open", r28);     // Catch: Throwable -> L147
        r36.putInt("cronet_version", r17);     // Catch: Throwable -> L147
        r36.putInt("http_dns_enabled", r18);     // Catch: Throwable -> L147
        r36.putInt("detect_open", r19);     // Catch: Throwable -> L147
        r36.putInt("detect_native_page", r110);     // Catch: Throwable -> L147
        r36.putInt("collect_recent_page_info_enable", r111);     // Catch: Throwable -> L147
        r36.putInt("add_ss_queries_open", r20);     // Catch: Throwable -> L147
        r36.putInt("add_ss_queries_header_open", r21);     // Catch: Throwable -> L147
        r36.putInt("add_ss_queries_plaintext_open", r22);     // Catch: Throwable -> L147
        r36.putInt("add_device_fingerprint_open", r23);     // Catch: Throwable -> L147
        r36.putInt("dynamic_adjust_threadpool_size_open", r113);     // Catch: Throwable -> L147
        r36.putInt("image_ttnet_enabled", r24);     // Catch: Throwable -> L147
        r36.putInt("use_http_dns", f13328J);     // Catch: Throwable -> L147
        r36.putInt("use_http_dns_refetch_on_expire", K);     // Catch: Throwable -> L147
        r36.putInt("http_show_hijack", r114);     // Catch: Throwable -> L147
        r36.putInt("http_verify_sign", r115);     // Catch: Throwable -> L147
        r36.putInt("crash_limit_times", r26);     // Catch: Throwable -> L147
        r36.putInt("crash_detect_interval_ms", r27);     // Catch: Throwable -> L147
        r36.putString(WsConstants.KEY_FRONTIER_URLS, r125);     // Catch: Throwable -> L147
        r36.putString("cronet_so_path", this.f13346w);     // Catch: Throwable -> L147
        r36.putString("share_cookie_host_list", r126);     // Catch: Throwable -> L147
        r10.put("oldShareCookieHosts", r134);     // Catch: Throwable -> L147
        r10.put("newShareCookieHosts", r126);     // Catch: Throwable -> L147
        if (TextUtils.isEmpty(r126) == true) goto L84;
        this.f13347x.clear();     // Catch: Throwable -> L147
        com.bytedance.ttnet.utils.d.d(r126, this.f13347x);     // Catch: Throwable -> L147
    L84:
        String r37 = TTNetInit.getTTNetDepend().k();     // Catch: Throwable -> L147
        if (com.bytedance.common.utility.g.b(r37) == false) goto L87;
    L89:
        r36.putString("api_http_host_list", r127);     // Catch: Throwable -> L147
        r36.putString("concurrent_request_config", r128);     // Catch: Throwable -> L147
        r36.putString("add_common_params", r129);     // Catch: Throwable -> L147
        r36.putString("query_filter_actions", r132);     // Catch: Throwable -> L147
        r36.putString("L0_params", r130);     // Catch: Throwable -> L147
        r36.putInt("query_filter_enabled", r131);     // Catch: Throwable -> L147
        String[] r41 = r127.split(",");     // Catch: Throwable -> L147
        int r43 = r41.length;     // Catch: Throwable -> L147
        int r135 = 0;
    L90:
        if (r135 >= r43) goto L98;
        int r136 = r43;
        String r44 = r41[r135];     // Catch: Throwable -> L147
        if (com.bytedance.common.utility.g.b(r44) == true) goto L96;
        String[] r137 = r41;
        if (com.bytedance.ttnet.utils.d.a(r44, this.f13348y) == true) goto L97;
        String r45 = r44.trim();     // Catch: Throwable -> L147
        this.f13348y.add(r45);     // Catch: Throwable -> L147
    L97:
        r135 = r135 + 1;     // Catch: Throwable -> L147
        r43 = r136;
        r41 = r137;
        goto L90
    L96:
        r137 = r41;
        goto L97
    L98:
        r36.putInt("android_log_encrypt_switch", this.f13349z);     // Catch: Throwable -> L147
        r36.putInt("image_ttnet_enabled", this.f13342s);     // Catch: Throwable -> L147
        r36.putInt("sample_band_width_enabled", this.f13343t);     // Catch: Throwable -> L147
        r36.putInt("cdn_sample_band_width_enabled", this.f13344u);     // Catch: Throwable -> L147
        r36.putInt("disable_framed_transport", r34);     // Catch: Throwable -> L147
        r36.putInt("tnc_update_interval", this.D.get());     // Catch: Throwable -> L147
        r36.putInt("private_protocol_enabled", r117);     // Catch: Throwable -> L147
        r36.putInt("destroy_delta_millis", r119);     // Catch: Throwable -> L147
        r36.putInt("disable_rotating_host_path_retry", r120);     // Catch: Throwable -> L147
        StringBuilder r46 = new StringBuilder();     // Catch: Throwable -> L147
        int r138 = 0;
    L100:
        if (r138 >= this.E.size()) goto L105;
        r46.append(this.E.get(r138));     // Catch: Throwable -> L147
        if (r138 == this.E.size()) goto L104;
        r46.append(',');     // Catch: Throwable -> L147
    L104:
        r138 = r138 + 1;     // Catch: Throwable -> L147
        goto L100
    L105:
        String r47 = r46.toString();     // Catch: Throwable -> L147
        if (TextUtils.isEmpty(r47) == true) goto L109;
        r36.putString("send_tnc_host_arrays", r47);     // Catch: Throwable -> L147
    L109:
        if (TextUtils.isEmpty(this.C) == true) goto L111;
        r36.putString("tnc_summary", this.C);     // Catch: Throwable -> L147
    L111:
        t1.a.a(r36);     // Catch: Throwable -> L147
        LinkedHashMap r48 = new LinkedHashMap();     // Catch: Throwable -> L122
        if (com.bytedance.common.utility.g.b(r125) == false) goto L115;
    L117:
        r48.put("http_dns_enabled", Integer.valueOf(r18));     // Catch: Throwable -> L122
        r48.put("add_ss_queries_open", Integer.valueOf(r20));     // Catch: Throwable -> L122
        r48.put("add_ss_queries_header_open", Integer.valueOf(r21));     // Catch: Throwable -> L122
        r48.put("add_ss_queries_plaintext_open", Integer.valueOf(r22));     // Catch: Throwable -> L122
        r48.put("share_cookie_host_list", r126);     // Catch: Throwable -> L122
        r48.put("disable_framed_transport", Integer.valueOf(r34));     // Catch: Throwable -> L122
        r48.put("query_filter_actions", r132);     // Catch: Throwable -> L122
        r48.put("L0_params", r130);     // Catch: Throwable -> L122
        r48.put("query_filter_enabled", Integer.valueOf(r131));     // Catch: Throwable -> L122
        r48.put("private_protocol_enabled", Integer.valueOf(r117));     // Catch: Throwable -> L122
        r48.put("disable_rotating_host_path_retry", Integer.valueOf(r120));     // Catch: Throwable -> L122
        TTNetInit.getTTNetDepend().b(this.f13333j, r48);     // Catch: Throwable -> L122
        Intent r49 = new Intent("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG");     // Catch: Throwable -> L122
        if (TextUtils.isEmpty(H) == true) goto L120;
        r49.setPackage(H);     // Catch: Throwable -> L122
    L120:
        this.f13333j.sendBroadcast(r49);     // Catch: Throwable -> L122
    L124:
        monitor-exit(this);     // Catch: Throwable -> L147
        if (com.bytedance.common.utility.g.b(r126) == true) goto L129;
        g.c().d(r134, r126);
    L129:
        if (w4.d.b() == null) goto L131;
        JSONObject r50 = r14;
        w4.d.b().e(r50);
    L133:
        if (TNCManager.m().o() != null) goto L135;
        boolean r51 = true;
    L145:
        B(r10, "return true");
        return r51;
    L135:
        if (w4.e.b() == true) goto L137;
    L141:
        JSONObject r139 = r50;
        r51 = true;
        TNCManager.m().o().d(r139, r39, this.A, "", r40);
    L142:
        if (r42 == false) goto L145;
        c3.b.m().r();
        goto L145
    L137:
        if ((r38 instanceof w4.e.b) == false) goto L141;
        if (w4.c.e() == false) goto L141;
        TNCManager.m().o().d(r38, r39, this.A, "", r40);
        r51 = true;
        goto L142
    L131:
        r50 = r14;
        goto L133
    L115:
        if (r125.equals(I) == true) goto L117;
        I = r125;     // Catch: Throwable -> L122
        r48.put(WsConstants.KEY_FRONTIER_URLS, r125);     // Catch: Throwable -> L122
    L122:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L147
        goto L124
    L87:
        if (com.bytedance.ttnet.utils.d.a(r37, this.f13347x) == true) goto L89;
        this.f13347x.add(r37);     // Catch: Throwable -> L147
    L147:
        th = move-exception;
        throw th;
    L154:
        com.bytedance.frameworks.baselib.network.http.ok3.impl.d.c(r34);     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        th.printStackTrace();
        goto L80
    L73:
        r133 = 0;
        goto L74
    L59:
        if (this.f13340q <= 0) goto L63;
    L55:
        r30 = false;
        goto L56
    L51:
        r29 = false;
    L152:
        th = move-exception;
        throw th;
    L44:
        r28 = r16;
        goto L45
    L32:
        r121 = false;
        goto L33
    L25:
        r118 = false;
        goto L26
    L11:
        if ((r38 instanceof JSONObject) == false) goto L14;
        r13 = (JSONObject) r38;
        goto L17
    L14:
        if ((r38 instanceof w4.e.b) == false) goto L16;
        r13 = ((w4.e.b) r38).b();
        goto L17
    L16:
        r13 = null;
        goto L17
    }
}
