package x8;

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
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ttnet.TTNetInit;
import com.qualcomm.qti.qesdk.QesdkUtils;
import d7.p;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
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

/* JADX INFO: loaded from: classes.dex */
public final class c implements w6.e.b, WeakHandler.IHandler, n7.a.InterfaceC0119a, w8.b.InterfaceC0189b, a7.i.b, a7.i.a, u6.a.b, w6.e.d, w6.e.InterfaceC0187e {
    public static c J = null;
    public static String K = null;
    public static int L = -1;
    public static int M = -1;
    public static final ArrayList<String> N = null;
    public static boolean O;
    public int A;
    public String B;
    public final CopyOnWriteArrayList C;
    public final CopyOnWriteArrayList D;
    public volatile int E;
    public String F;
    public final AtomicInteger G;
    public final CopyOnWriteArrayList H;
    public final WeakHandler I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f13679b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f13680m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f13681n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Context f13682o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f13683p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f13684q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile int f13685r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f13686s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f13687t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f13688u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13689v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13690w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f13691x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f13692y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f13693z;

    public class a extends s5.c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ Map f13694o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ c f13695p;

        public a(c r8, LinkedHashMap r10) {
            this.f13695p = r8;
            this.f13694o = r10;
            super(0);
        }

        @Override // s5.c, java.lang.Runnable
        public final void run() {
            w8.c r8 = TTNetInit.getTTNetDepend();
            c r10 = this.f13695p;
            r8.saveMapToProvider(r10.f13682o, this.f13694o);
            Intent r11 = new Intent("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG");
            if (TextUtils.isEmpty(c.K) == true) goto L5;
            r11.setPackage(c.K);
        L5:
            r10.f13682o.sendBroadcast(r11);
        }
    }

    public static final class b extends BroadcastReceiver {

        public class a extends s5.c {
            public a() {
                super(0);
            }

            @Override // s5.c, java.lang.Runnable
            public final void run() {
                if (h.f13709q == null) goto L5;
            L14:
                h.f13709q.h();
                return;
            L5:
                monitor-enter(h.class);
            L11:
                th = move-exception;
                throw th;
            L7:
                if (h.f13709q != null) goto L9;
                h.f13709q = new h();     // Catch: Throwable -> L11
            L9:
                monitor-exit(h.class);     // Catch: Throwable -> L11
                goto L14
            }
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r8, Intent r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if ("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG".equals(r10.getAction()) == false) goto L8;
            new a().a();
            return;
        }
    }

    static {
        ArrayList<String> r8 = new ArrayList();
        N = r8;
        O = false;
        r8.add("MI PAD 2");
        r8.add("YT3-X90L");
        r8.add("YT3-X90F");
        r8.add("GT-810");
    }

    public c(Context r8, boolean r10) {
        this.f13679b = new AtomicLong(0);
        this.f13680m = new AtomicBoolean(false);
        this.f13681n = new Object();
        this.f13683p = false;
        this.f13684q = "";
        this.f13685r = -1;
        this.f13686s = 0;
        this.f13687t = 0;
        this.f13688u = 0;
        this.f13689v = 0;
        this.f13690w = 1;
        this.f13691x = 1;
        this.f13692y = 1;
        this.f13693z = 1;
        this.A = 1;
        this.B = "";
        this.C = new CopyOnWriteArrayList();
        this.D = new CopyOnWriteArrayList();
        this.F = "";
        this.G = new AtomicInteger(10800);
        this.H = new CopyOnWriteArrayList();
        this.I = new WeakHandler(Looper.getMainLooper(), this);
        this.f13682o = r8;
        this.f13678a = r10;
    }

    public static String[] j() {
        String[] r8 = TTNetInit.getTTNetDepend().getConfigServers();
        if (r8 == null) goto L7;
        if (r8.length <= 0) goto L7;
        return r8;
    L7:
        return new String[0];
    }

    public static c k(Context r8) {
        monitor-enter(c.class);
    L53:
        th = move-exception;
        throw th;
    L5:
        if (J != null) goto L50;
        boolean r10 = l7.e.c(r8);     // Catch: Throwable -> L53
        J = new c(r8.getApplicationContext(), r10);     // Catch: Throwable -> L53
        if (N.contains(Build.MODEL) == false) goto L9;
        O = true;     // Catch: Throwable -> L53
    L9:
        K = r8.getPackageName();     // Catch: Throwable -> L53
        if (r10 == false) goto L17;
        c r11 = J;     // Catch: Throwable -> L53
        n7.a.f9470a = r11;     // Catch: Throwable -> L53
        a7.i.f116g = r11;     // Catch: Throwable -> L53
        a7.i.f115f = J;     // Catch: Throwable -> L53
        w8.b.f13060a = J;     // Catch: Throwable -> L53
        u6.a r12 = u6.a.C0171a.f12481a;     // Catch: Throwable -> L53
        c r13 = J;     // Catch: Throwable -> L53
        if (r13 == null) goto L14;
        r12.f12479e.add(r13);     // Catch: Throwable -> L53
    L14:
        u6.b r14 = r12.f12477c.get();     // Catch: Throwable -> L53
        w6.e.f13020a = J;     // Catch: Throwable -> L53
        if (w6.e.f13028i != null) goto L37;
        w6.e.InterfaceC0187e r15 = J;     // Catch: Throwable -> L53
    L36:
        w6.e.f13028i = r15;     // Catch: Throwable -> L53
    L37:
        w6.e.f13027h = J;     // Catch: Throwable -> L53
        if (e.f13697f != null) goto L49;
        Object r16 = e.f13698g;     // Catch: Throwable -> L53
        monitor-enter(r16);     // Catch: Throwable -> L53
    L46:
        th = move-exception;
        throw th;     // Catch: Throwable -> L53
    L42:
        if (e.f13697f != null) goto L44;
        e.f13697f = new e(r8);     // Catch: Throwable -> L46
    L44:
        monitor-exit(r16);     // Catch: Throwable -> L46
    L49:
        e r17 = e.f13697f;     // Catch: Throwable -> L53
        goto L50
    L17:
        IntentFilter r18 = new IntentFilter();     // Catch: Throwable -> L53
        r18.addAction("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG");     // Catch: Throwable -> L53
        r8.registerReceiver(new b(), r18);     // Catch: Throwable -> L20
    L23:
        if (h.f13709q == null) goto L25;
    L34:
        h r19 = h.f13709q;     // Catch: Throwable -> L53
        n7.a.f9470a = r19;     // Catch: Throwable -> L53
        a7.i.f116g = r19;     // Catch: Throwable -> L53
        a7.i.f115f = r19;     // Catch: Throwable -> L53
        w8.b.f13060a = r19;     // Catch: Throwable -> L53
        r15 = r19;
        if (w6.e.f13028i != null) goto L37;
    L25:
        monitor-enter(h.class);     // Catch: Throwable -> L53
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L53
    L27:
        if (h.f13709q != null) goto L29;
        h.f13709q = new h();     // Catch: Throwable -> L31
    L29:
        monitor-exit(h.class);     // Catch: Throwable -> L31
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L53
    L50:
        c r20 = J;     // Catch: Throwable -> L53
        monitor-exit(c.class);     // Catch: Throwable -> L53
        return r20;
    }

    public static boolean n() {
        String r8 = Build.SUPPORTED_ABIS[0];     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r8) == false) goto L7;
        return false;
    L7:
        if ("x86".equalsIgnoreCase(r8) == true) goto L11;
        if ("x86_64".equalsIgnoreCase(r8) == true) goto L11;
    L28:
        return false;
    L11:
        if (TTNetInit.h.f4076a == TTNetInit.getEnv()) goto L13;
        boolean r10 = true;
    L14:
        if (r10 == true) goto L16;
        boolean r11 = false;
    L21:
        if (r11 == false) goto L24;
        Logger.d("AppConfig", "x86 support");     // Catch: Throwable -> L26
        return false;
    L24:
        Logger.w("AppConfig", "Cronet unsupported CPU arch: " + r8);     // Catch: Throwable -> L26
        p.f6905b = 2;     // Catch: Throwable -> L26
        return true;
    L16:
        Context r12 = TTNetInit.getTTNetDepend().getContext();     // Catch: Throwable -> L26
        String r13 = null;
        if (r12 == null) goto L19;
        r13 = r12.getSharedPreferences("ttnet_debug_setting", 0).getString("x86_support", null);     // Catch: Throwable -> L26
    L19:
        r11 = "true".equals(r13);     // Catch: Throwable -> L26
        goto L21
    L13:
        r10 = false;
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L28
    }

    @Override // w6.e.InterfaceC0187e
    public final List<String> a(CookieManager r8, c7.a r10, URI r11) {
        if (r11 == null) goto L36;
        if (r8 != null) goto L37;
        if (r10 == null) goto L36;
    L37:
        String r12 = r11.getHost();     // Catch: Exception -> L9
    L11:
        if (r5.f.b(r12) == true) goto L36;
        if (defpackage.c.O(r12, this.C) == false) goto L36;
        if (r5.f.b(TTNetInit.getTTNetDepend().getShareCookieMainDomain()) == false) goto L18;
        return null;
    L18:
        ArrayList r13 = new ArrayList();
        if (r8 == null) goto L25;
        String r14 = r8.getCookie(r11.getScheme() + "://" + TTNetInit.getTTNetDepend().getShareCookieMainDomain());
        if (r5.f.b(r14) == true) goto L25;
        r13.add(r14);
        return r13;
    L25:
        if (l6.a.g0(r13) == false) goto L41;
        if (r10 == null) goto L42;
        Map<String, List<String>> r15 = r10.get(URI.create(r11.getScheme() + "://" + TTNetInit.getTTNetDepend().getShareCookieMainDomain()), new LinkedHashMap());     // Catch: Throwable -> L33
        if (r15 != null) goto L30;
        return r13;
    L30:
        if (r15.isEmpty() == true) goto L44;
        return r15.get("Cookie");
    L44:
        return r13;
    L33:
        th = move-exception;
        th.printStackTrace();
        return r13;
    L42:
        return r13;
    L41:
        return r13;
    L9:
        r12 = null;
    L36:
        return null;
    }

    @Override // w6.e.InterfaceC0187e
    public final List<String> b(String r8) {
        CopyOnWriteArrayList r10 = this.C;
        if (defpackage.c.O(r8, r10) == false) goto L5;
        return r10;
    L5:
        return null;
    }

    @Override // w8.b.InterfaceC0189b
    public final boolean c() {
        if (O == false) goto L7;
        p.f6905b = 8;
        return false;
    L7:
        if (n() == false) goto L10;
        return false;
    L10:
        if (this.f13685r <= 5) goto L14;
        p.f6905b = 3;
        Logger.e("AppConfig", "After five consecutive crashes of cronet, you must reinstall app to enable cronet, or wait until several hours");
        return false;
    L14:
        if (TTNetInit.getTTNetDepend().isCronetPluginInstalled() == true) goto L17;
        p.f6905b = 6;
        return false;
    L17:
        return true;
    }

    @Override // n7.a.InterfaceC0119a
    public final boolean d() {
        if (this.f13688u <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // n7.a.InterfaceC0119a
    public final boolean e() {
        if (this.f13689v <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // n7.a.InterfaceC0119a
    public final boolean f() {
        if (this.f13690w <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // a7.i.b
    public final boolean g() {
        if (this.f13687t <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // u6.a.b
    public final void h(u6.b r8) {
        if (Logger.debug() == false) goto L7;
        if (r8 == null) goto L8;
        Logger.d("AppConfig", "onBandwidthStateChange bandwidthState = " + r8);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r8) {
        int r10 = r8.what;
        AtomicBoolean r11 = this.f13680m;
        switch(r10) {
            case 101: goto L17;
            case 102: goto L15;
            case 103: goto L11;
            case 104: goto L6;
            default: goto L24;
        };
    L17:
        this.f13679b.set(System.currentTimeMillis());
        if (Logger.debug() == false) goto L21;
        String r12 = "doRefresh, succ";
    L20:
        Logger.d("TNCManager", r12);
    L21:
        r11.set(false);
        return;
    L24:
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("TNCManager", "did is empty, delay request tnc");
    L8:
        d9.d.b r13 = d9.d.b.f6996o;
    L9:
        s(r13, false);
        return;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d("TNCManager", "do tnc polling");
    L13:
        r13 = d9.d.b.f6998q;
        goto L9
    L15:
        if (Logger.debug() == false) goto L21;
        r12 = "doRefresh, error";
        goto L20
    }

    public final void i(d9.d.b r8, boolean r10) {
        StringBuilder r11 = new StringBuilder("doRefresh: updating state ");
        AtomicBoolean r12 = this.f13680m;
        r11.append(r12.get());
        Logger.d("TNCManager", r11.toString());
        if (r12.compareAndSet(false, true) == true) goto L6;
        Logger.d("TNCManager", "doRefresh, already running");
        return;
    L6:
        new x8.b(this, r8, r10).a();
    }

    @Override // a7.i.a
    public final boolean isCronetBootFailureExpected() {
        if (Logger.debug() == false) goto L5;
        Logger.d("AppConfig", "isCronetBootFailureExpected...");
    L5:
        SharedPreferences r8 = this.f13682o.getSharedPreferences("ss_app_config", 0);
        if (this.f13685r >= 0) goto L8;
        this.f13685r = r8.getInt("chromium_boot_failures", 0);
    L8:
        this.f13686s = r8.getLong("chromium_boot_failures_timestamp", 0);
        if (this.f13685r <= 5) goto L14;
        if ((System.currentTimeMillis() - this.f13686s) <= TimeUnit.HOURS.toMillis(1)) goto L14;
        this.f13685r = 5;
    L14:
        if (c() == false) goto L20;
        SharedPreferences.Editor r10 = r8.edit();
        r10.putInt("chromium_boot_failures", this.f13685r + 1);
        r10.putLong("chromium_boot_failures_timestamp", System.currentTimeMillis());
        if (Logger.debug() == false) goto L18;
        Logger.d("AppConfig", "KEY_CHROMIUM_BOOT_FAILURES inc...");
    L18:
        r10.apply();
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("chromium_boot_failures", Integer.valueOf(this.f13685r + 1));
        TTNetInit.getTTNetDepend().saveMapToProvider(this.f13682o, r11);
        return true;
    L20:
        return false;
    }

    public final void l(String r8) {
        if (r5.f.b(r8) == false) goto L20;
        return;
    L20:
        boolean r10 = m(r8, d9.d.b.f7002u, System.currentTimeMillis());     // Catch: Exception -> L7
    L9:
        if (r10 == false) goto L11;
        int r11 = 101;
    L18:
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L14
        r12.put("from", "cronet");     // Catch: Throwable -> L14
        TTNetInit.getTTNetDepend().onAppConfigUpdated(this.f13682o, r12);     // Catch: Throwable -> L14
    L16:
        this.I.sendEmptyMessage(r11);
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    L11:
        r11 = 102;
    L7:
        e = move-exception;
        e.printStackTrace();
        r10 = false;
        goto L9
    }

    public final boolean m(Object r32, d9.d.b r33, long r34) {
        JSONObject r8 = new JSONObject();
        if ((r32 instanceof String) == false) goto L9;
        String r10 = (String) r32;
        if (r5.f.b(r10) == false) goto L7;
        String r11 = "empty response.";
    L14:
        o(r11, r8);
        return false;
    L7:
        JSONObject r12 = new JSONObject(r10);
    L12:
        if (r12 != null) goto L16;
        r11 = "object is null.";
        goto L14
    L16:
        JSONObject r13 = r12.getJSONObject("data");
        i r14 = i.a(this.f13682o);
        r14.getClass();
        r14.f13721d = r13.toString();
        SharedPreferences.Editor r15 = r14.f13718a.getSharedPreferences("tt_state_config", 4).edit();
        r15.putString("tnc_delay_config", r14.f13721d);
        r15.apply();
        r14.b(r13);
        i.a(r14.f13718a).c(y6.a.f14001b);
        L = r13.optInt("use_http_dns", -1);
        M = r13.optInt("collect_recent_page_info_enable", -1);
        int r16 = r13.optInt("ok_http_open", 0);
        int r17 = r13.optInt("ok_http3_open", 0);
        int r18 = r13.optInt("cronet_version", 0);
        int r19 = r13.optInt("http_dns_enabled", 0);
        int r110 = r13.optInt("detect_open", 0);
        int r111 = r13.optInt("detect_native_page", 1);
        int r112 = r13.optInt("collect_recent_page_info_enable", 1);
        int r113 = r13.optInt("add_ss_queries_open", 0);
        int r114 = r13.optInt("add_ss_queries_header_open", 0);
        int r20 = r13.optInt("add_ss_queries_plaintext_open", 1);
        int r21 = r13.optInt("add_device_fingerprint_open", 1);
        int r22 = r13.optInt("image_ttnet_enabled", 1);
        int r23 = r13.optInt("sample_band_width_enabled", 1);
        int r24 = r13.optInt("cdn_sample_band_width_enabled", 1);
        int r115 = r13.optInt("dynamic_adjust_threadpool_size_open", 1);
        int r116 = r13.optInt("http_show_hijack", 1);
        int r117 = r13.optInt("http_verify_sign", 1);
        int r118 = r13.optInt("tnc_update_interval", -1);
        if (r118 <= 0) goto L19;
        this.G.set(r118);
    L19:
        JSONArray r119 = r13.optJSONArray("send_tnc_host_arrays");
        if (r119 == null) goto L30;
        this.H.clear();
        int r120 = 0;
    L23:
        if (r120 >= r119.length()) goto L29;
        if (TextUtils.isEmpty(r119.optString(r120)) == true) goto L28;
        this.H.add(r119.optString(r120));
    L28:
        r120 = r120 + 1;
        r18 = r18;
        goto L23
    L29:
        int r25 = r18;
    L31:
        monitor-enter(this);
        this.f13687t = r19;     // Catch: Throwable -> L190
        this.f13688u = r113;     // Catch: Throwable -> L190
        this.f13689v = r114;     // Catch: Throwable -> L190
        this.f13690w = r20;     // Catch: Throwable -> L190
        this.A = r115;     // Catch: Throwable -> L190
        this.f13691x = r22;     // Catch: Throwable -> L190
        this.f13692y = r23;     // Catch: Throwable -> L190
        this.f13693z = r24;     // Catch: Throwable -> L190
        monitor-exit(this);     // Catch: Throwable -> L190
        if (r115 <= 0) goto L36;
        boolean r26 = true;
    L38:
        monitor-enter(v6.e.class);
        v6.e.f12749a = r26;     // Catch: Throwable -> L187
        if (v6.e.f12750b == null) goto L42;
        v6.f r27 = v6.e.f12750b;     // Catch: Throwable -> L187
        r27.f12759h = v6.e.f12749a;     // Catch: Throwable -> L187
    L42:
        monitor-exit(v6.e.class);
        if (r13.optInt("enable_req_ticket", 1) <= 0) goto L46;
        boolean r28 = true;
    L47:
        e9.b.f7207b = r28;
        boolean r29 = e9.a.f7199a;
        int r30 = r13.optInt("ttnet_response_verify_enabled", -1);
        JSONArray r31 = r13.optJSONArray("ttnet_response_verify");
        if (r31 == null) goto L50;
        String r35 = r31.toString();
    L51:
        e9.a.a(r31, r30);
        e9.a.C0066a r36 = new e9.a.C0066a();
        r36.f7203a = r30;
        r36.f7204b = r35;
        if (this.f13688u <= 0) goto L54;
    L55:
        c9.a.f3424a = true;
    L56:
        int r37 = h7.c.f7920a;
        h7.c.f7920a = r13.optInt("read_response_buff_init_size", 0);
        h7.c.f7921b = r13.optInt("read_response_buff_increase_size", 0);
        Context r38 = a7.i.f110a;
        a7.i.f114e = r13.optInt("cronet_inputstream_buff_size", 0);
        String r39 = r13.optString(WsConstants.KEY_FRONTIER_URLS, "");
        String r121 = r13.optString("share_cookie_host_list", "");
        TTNetInit.getTTNetDepend().onShareCookieConfigUpdated(r121);
        String r122 = r13.optString("api_http_host_list", "");
        String r123 = r13.optString("concurrent_request_config", "");
        a7.f.c().e(r123);
        String r124 = r13.optString("add_common_params", "");
        x6.a.a().getClass();
        String r125 = r13.optString("L0_params", "");
        m7.c.c().g(r125);
        int r126 = r13.optInt("query_filter_enabled", Integer.MIN_VALUE);
        String r127 = r13.optString("query_filter_actions");
        if (r126 == Integer.MIN_VALUE) goto L63;
        m7.c r40 = m7.c.c();
        if (r126 <= 0) goto L61;
        boolean r128 = true;
    L62:
        r40.f9294b = r128;
        m7.c.c().d(r127);
        goto L63
    L61:
        r128 = false;
    L63:
        int r41 = r13.optInt("disable_store_region_v2", 0);
        k7.b r129 = k7.b.e();
        if (r41 <= 0) goto L66;
        boolean r42 = true;
    L67:
        Context r130 = r129.f8969i;
        if (r130 != null) goto L70;
    L75:
        int r131 = 0;
    L76:
        this.E = r13.optInt("disable_encrypt_switch", r131);
        this.B = r13.optString("cronet_so_path", "");
        if (this.E != 2) goto L79;
        SharedPreferences.Editor r43 = this.f13682o.getSharedPreferences("app_log_encrypt_switch_count", r131).edit();
        r43.putInt("app_log_encrypt_faild_count", r131);
        r43.apply();
    L79:
        int r132 = r13.optInt("disable_framed_transport", r131);
        if (r132 <= 0) goto L88;
        if (r132 <= 0) goto L88;
    L86:
        th = move-exception;
        th.printStackTrace();
        goto L88
    L83:
        if (d7.h.f6861b != 0) goto L88;
        d7.h.f6861b = r132;     // Catch: Throwable -> L86
    L88:
        monitor-enter(this);
        SharedPreferences r44 = this.f13682o.getSharedPreferences("ss_app_config", 0);     // Catch: Throwable -> L92
        String r133 = r44.getString("share_cookie_host_list", "");     // Catch: Throwable -> L92
        SharedPreferences.Editor r45 = r44.edit();     // Catch: Throwable -> L92
        r45.putString("ttnet_response_verify", r36.f7204b);     // Catch: Throwable -> L92
        r45.putInt("ttnet_response_verify_enabled", r36.f7203a);     // Catch: Throwable -> L92
        r45.putInt("read_response_buff_init_size", h7.c.f7920a);     // Catch: Throwable -> L92
        r45.putInt("read_response_buff_increase_size", h7.c.f7921b);     // Catch: Throwable -> L92
        r45.putInt("cronet_inputstream_buff_size", a7.i.f114e);     // Catch: Throwable -> L92
        r45.putInt("ok_http_open", r16);     // Catch: Throwable -> L92
        r45.putInt("ok_http3_open", r17);     // Catch: Throwable -> L92
        r45.putInt("cronet_version", r25);     // Catch: Throwable -> L92
        r45.putInt("http_dns_enabled", r19);     // Catch: Throwable -> L92
        r45.putInt("detect_open", r110);     // Catch: Throwable -> L92
        r45.putInt("detect_native_page", r111);     // Catch: Throwable -> L92
        r45.putInt("collect_recent_page_info_enable", r112);     // Catch: Throwable -> L92
        r45.putInt("add_ss_queries_open", r113);     // Catch: Throwable -> L92
        r45.putInt("add_ss_queries_header_open", r114);     // Catch: Throwable -> L92
        r45.putInt("add_ss_queries_plaintext_open", r20);     // Catch: Throwable -> L92
        r45.putInt("add_device_fingerprint_open", r21);     // Catch: Throwable -> L92
        r45.putInt("dynamic_adjust_threadpool_size_open", r115);     // Catch: Throwable -> L92
        r45.putInt("image_ttnet_enabled", r22);     // Catch: Throwable -> L92
        r45.putInt("use_http_dns", L);     // Catch: Throwable -> L92
        r45.putInt("use_http_dns_refetch_on_expire", M);     // Catch: Throwable -> L92
        r45.putInt("http_show_hijack", r116);     // Catch: Throwable -> L92
        r45.putInt("http_verify_sign", r117);     // Catch: Throwable -> L92
        r45.putString(WsConstants.KEY_FRONTIER_URLS, r39);     // Catch: Throwable -> L92
        r45.putString("cronet_so_path", this.B);     // Catch: Throwable -> L92
        r45.putString("share_cookie_host_list", r121);     // Catch: Throwable -> L92
        r8.put("oldShareCookieHosts", r133);     // Catch: Throwable -> L92
        r8.put("newShareCookieHosts", r121);     // Catch: Throwable -> L92
        if (TextUtils.isEmpty(r121) == true) goto L94;
        this.C.clear();     // Catch: Throwable -> L92
        defpackage.c.Z(r121, this.C);     // Catch: Throwable -> L92
    L94:
        String r46 = TTNetInit.getTTNetDepend().getShareCookieMainDomain();     // Catch: Throwable -> L92
        if (r5.f.b(r46) == false) goto L97;
    L99:
        r45.putString("api_http_host_list", r122);     // Catch: Throwable -> L92
        r45.putString("concurrent_request_config", r123);     // Catch: Throwable -> L92
        r45.putString("add_common_params", r124);     // Catch: Throwable -> L92
        r45.putString("query_filter_actions", r127);     // Catch: Throwable -> L92
        r45.putString("L0_params", r125);     // Catch: Throwable -> L92
        r45.putInt("query_filter_enabled", r126);     // Catch: Throwable -> L92
        String[] r47 = r122.split(",");     // Catch: Throwable -> L92
        int r48 = r47.length;     // Catch: Throwable -> L92
        int r134 = 0;
    L100:
        if (r134 >= r48) goto L108;
        int r135 = r48;
        String r49 = r47[r134];     // Catch: Throwable -> L92
        if (r5.f.b(r49) == true) goto L106;
        String[] r310 = r47;
        if (defpackage.c.O(r49, this.D) == true) goto L107;
        String r50 = r49.trim();     // Catch: Throwable -> L92
        this.D.add(r50);     // Catch: Throwable -> L92
    L107:
        r134 = r134 + 1;     // Catch: Throwable -> L92
        r47 = r310;
        r48 = r135;
        goto L100
    L106:
        r310 = r47;
        goto L107
    L108:
        r45.putInt("android_log_encrypt_switch", this.E);     // Catch: Throwable -> L92
        r45.putInt("image_ttnet_enabled", this.f13691x);     // Catch: Throwable -> L92
        r45.putInt("sample_band_width_enabled", this.f13692y);     // Catch: Throwable -> L92
        r45.putInt("cdn_sample_band_width_enabled", this.f13693z);     // Catch: Throwable -> L92
        r45.putInt("disable_framed_transport", r132);     // Catch: Throwable -> L92
        r45.putInt("tnc_update_interval", this.G.get());     // Catch: Throwable -> L92
        StringBuilder r51 = new StringBuilder();     // Catch: Throwable -> L92
        int r52 = 0;
    L110:
        if (r52 >= this.H.size()) goto L115;
        r51.append((String) this.H.get(r52));     // Catch: Throwable -> L92
        if (r52 == this.H.size()) goto L114;
        r51.append(',');     // Catch: Throwable -> L92
    L114:
        r52 = r52 + 1;     // Catch: Throwable -> L92
        goto L110
    L115:
        String r53 = r51.toString();     // Catch: Throwable -> L92
        if (TextUtils.isEmpty(r53) == true) goto L118;
        r45.putString("send_tnc_host_arrays", r53);     // Catch: Throwable -> L92
    L118:
        r45.apply();     // Catch: Throwable -> L92
        LinkedHashMap r54 = new LinkedHashMap();     // Catch: Throwable -> L129
        if (r5.f.b(r39) == false) goto L122;
    L124:
        r54.put("http_dns_enabled", Integer.valueOf(r19));     // Catch: Throwable -> L129
        r54.put("add_ss_queries_open", Integer.valueOf(r113));     // Catch: Throwable -> L129
        r54.put("add_ss_queries_header_open", Integer.valueOf(r114));     // Catch: Throwable -> L129
        r54.put("add_ss_queries_plaintext_open", Integer.valueOf(r20));     // Catch: Throwable -> L129
        r54.put("share_cookie_host_list", r121);     // Catch: Throwable -> L129
        r54.put("disable_framed_transport", Integer.valueOf(r132));     // Catch: Throwable -> L129
        r54.put("query_filter_actions", r127);     // Catch: Throwable -> L129
        r54.put("L0_params", r125);     // Catch: Throwable -> L129
        r54.put("query_filter_enabled", Integer.valueOf(r126));     // Catch: Throwable -> L129
        TTNetInit.getTTNetDepend().saveMapToProvider(this.f13682o, r54);     // Catch: Throwable -> L129
        Intent r55 = new Intent("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG");     // Catch: Throwable -> L129
        if (TextUtils.isEmpty(K) == true) goto L127;
        r55.setPackage(K);     // Catch: Throwable -> L129
    L127:
        this.f13682o.sendBroadcast(r55);     // Catch: Throwable -> L129
    L131:
        monitor-exit(this);     // Catch: Throwable -> L92
        if (r5.f.b(r121) == true) goto L151;
        if (g.f13708a == null) goto L137;
    L146:
        g r56 = g.f13708a;
        r56.getClass();
        if (r121.equals(r133) == true) goto L151;
        new f(r56, r133, r121).a();
        goto L151
    L137:
        monitor-enter(g.class);
    L143:
        th = move-exception;
        throw th;
    L139:
        if (g.f13708a != null) goto L141;
        g.f13708a = new g();     // Catch: Throwable -> L143
    L141:
        monitor-exit(g.class);     // Catch: Throwable -> L143
    L151:
        if (e.f13697f == null) goto L179;
        e r57 = e.f13697f;
        r57.getClass();
        if (r13.length() <= 0) goto L179;
        JSONObject r58 = r13;
        int r59 = r58.optInt("image_opt_switch", 0);     // Catch: Throwable -> L160
        long r60 = r58.optLong("image_opt_black_interval", 0);     // Catch: Throwable -> L160
        int r136 = r58.optInt("image_opt_failed_times", 0);     // Catch: Throwable -> L160
        int r137 = r58.optInt("image_opt_limit_count", 0);     // Catch: Throwable -> L160
        if (e.f13699h != null) goto L162;
        e.f13699h = r57.f13700a.getSharedPreferences("image_opt_table", 0);     // Catch: Throwable -> L160
    L162:
        SharedPreferences.Editor r61 = e.f13699h.edit();     // Catch: Throwable -> L160
        if (r59 == r57.f13701b) goto L166;
        r61.putInt("image_opt_switch", r59);     // Catch: Throwable -> L160
    L166:
        if (r60 == r57.f13702c) goto L169;
        r61.putLong("image_opt_black_interval", r60);     // Catch: Throwable -> L160
    L169:
        if (r136 == r57.f13703d) goto L172;
        r61.putInt("image_opt_failed_times", r136);     // Catch: Throwable -> L160
    L172:
        if (r137 == r57.f13704e) goto L174;
        r61.putInt("image_opt_limit_count", r137);     // Catch: Throwable -> L160
    L174:
        r61.apply();     // Catch: Throwable -> L160
        r57.f13701b = r59;     // Catch: Throwable -> L160
        r57.f13702c = r60;     // Catch: Throwable -> L160
        r57.f13703d = r136;     // Catch: Throwable -> L160
        r57.f13704e = r137;     // Catch: Throwable -> L160
    L181:
        if (d9.d.c().f6981d == null) goto L183;
        d9.d.c().f6981d.a(r58, r33, this.F, "", r34);
    L183:
        o("return true", r8);
        return true;
    L160:
        th = th;
    L178:
        th.printStackTrace();
    L176:
        th = th;
        r58 = r13;
    L179:
        r58 = r13;
        goto L181
    L122:
        if (r39.equals(this.f13684q) == true) goto L124;
        this.f13684q = r39;     // Catch: Throwable -> L129
        r54.put(WsConstants.KEY_FRONTIER_URLS, r39);     // Catch: Throwable -> L129
    L129:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L92
        goto L131
    L97:
        if (defpackage.c.O(r46, this.C) == true) goto L99;
        this.C.add(r46);     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        throw th;
    L70:
        if (r129.f8970j == false) goto L75;
        if (r129.f8971k == r42) goto L75;
        r129.f8971k = r42;
        r131 = 0;
        SharedPreferences.Editor r62 = r130.getSharedPreferences("ttnet_store_region", 0).edit();
        r62.putBoolean("disable_store_region", r129.f8971k);
        r62.apply();
        goto L76
    L66:
        r42 = false;
        goto L67
    L54:
        if (this.f13689v <= 0) goto L56;
    L50:
        r35 = "";
        goto L51
    L46:
        r28 = false;
    L187:
        th = move-exception;
        throw th;
    L36:
        r26 = false;
    L190:
        th = move-exception;
        throw th;
    L30:
        r25 = r18;
        goto L31
    L9:
        if ((r32 instanceof JSONObject) == false) goto L11;
        r12 = (JSONObject) r32;
        goto L12
    L11:
        r12 = null;
        goto L12
    }

    public final void o(String r8, JSONObject r10) {
        r10.put(QesdkUtils.TAGS.JSON_TAG_RETURN, r8);     // Catch: JSONException -> L5
        r10.put("CurrentShareCookieHostList", this.C.toString());     // Catch: JSONException -> L5
    L3:
        TTNetInit.getTTNetDepend().mobOnEvent(TTNetInit.getTTNetDepend().getContext(), "handleResponse", "shareCookieHostList", r10);
    }

    public final boolean p(String r8) {
        if (r5.f.b(r8) == false) goto L6;
        return false;
    L6:
        if (this.f13692y > 0) goto L21;
        return false;
    L21:
        URI r10 = t2.b.T(r8);     // Catch: Throwable -> L18
        if (r10 != null) goto L11;
        return false;
    L11:
        String r11 = r10.getHost();     // Catch: Throwable -> L18
        if (r5.f.b(r11) == false) goto L14;
        return false;
    L14:
        if (r11.endsWith(defpackage.c.I()) == false) goto L20;
        return true;
    L20:
        return false;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    public final synchronized void q() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if ((System.currentTimeMillis() - this.f13679b.get()) <= (((long) this.G.get()) * 1000)) goto L18;
        this.f13679b.set(System.currentTimeMillis());     // Catch: Throwable -> L20
        int r8 = TTNetInit.getTTNetDepend().getProviderInt(this.f13682o, "disable_framed_transport", 0);     // Catch: Exception -> L23 Throwable -> L20
        if (r8 <= 0) goto L16;
        if (r8 <= 0) goto L16;
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L23 Throwable -> L20
        goto L16
    L10:
        if (d7.h.f6861b != 0) goto L16;
        d7.h.f6861b = r8;     // Catch: Throwable -> L13
    L16:
        if (d9.d.c().f6981d == null) goto L18;
        d9.d.c().f6981d.c(this.f13679b.get());     // Catch: Exception -> L23 Throwable -> L20
    L18:
        monitor-exit(this);
    }

    public final void r() {
        Object r8 = this.f13681n;
        monitor-enter(r8);
    L115:
        th = move-exception;
        throw th;
    L5:
        if (this.f13683p == false) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L115
        return;
    L8:
        boolean r10 = true;
        this.f13683p = true;     // Catch: Throwable -> L115
        monitor-exit(r8);     // Catch: Throwable -> L115
        i r11 = i.a(this.f13682o);
        String r12 = r11.f13718a.getSharedPreferences("tt_state_config", 4).getString("tnc_delay_config", "");
        r11.f13721d = r12;
        if (TextUtils.isEmpty(r12) == true) goto L17;
        r11.b(new JSONObject(r11.f13721d));     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        if (r11.f13719b == false) goto L19;
        r11.c(y6.a.f14001b);
    L19:
        SharedPreferences r13 = this.f13682o.getSharedPreferences("ss_app_config", 0);
        r13.getInt("ok_http_open", 0);
        r13.getInt("ok_http3_open", 0);
        r13.getInt("cronet_version", 0);
        this.f13687t = r13.getInt("http_dns_enabled", 0);
        r13.getInt("detect_open", 0);
        r13.getInt("detect_native_page", 1);
        r13.getInt("collect_recent_page_info_enable", 1);
        this.f13688u = r13.getInt("add_ss_queries_open", 0);
        this.f13689v = r13.getInt("add_ss_queries_header_open", 0);
        this.f13690w = r13.getInt("add_ss_queries_plaintext_open", 1);
        r13.getInt("add_device_fingerprint_open", 1);
        this.A = r13.getInt("dynamic_adjust_threadpool_size_open", 1);
        if (this.f13685r >= 0) goto L23;
        this.f13685r = r13.getInt("chromium_boot_failures", 0);
    L23:
        if (this.A <= 0) goto L25;
        boolean r14 = true;
    L27:
        monitor-enter(v6.e.class);
        v6.e.f12749a = r14;     // Catch: Throwable -> L112
        if (v6.e.f12750b == null) goto L31;
        v6.e.f12750b.f12759h = v6.e.f12749a;     // Catch: Throwable -> L112
    L31:
        monitor-exit(v6.e.class);
        this.f13691x = r13.getInt("image_ttnet_enabled", 1);
        this.f13692y = r13.getInt("sample_band_width_enabled", 1);
        this.f13693z = r13.getInt("cdn_sample_band_width_enabled", 1);
        L = r13.getInt("use_http_dns", -1);
        M = r13.getInt("use_http_dns_refetch_on_expire", -1);
        int r15 = h7.c.f7920a;
        h7.c.f7920a = r13.getInt("read_response_buff_init_size", 0);
        h7.c.f7921b = r13.getInt("read_response_buff_increase_size", 0);
        Context r16 = a7.i.f110a;
        a7.i.f114e = r13.getInt("cronet_inputstream_buff_size", 0);
        boolean r17 = e9.a.f7199a;
        int r18 = r13.getInt("ttnet_response_verify_enabled", -1);
        String r19 = r13.getString("ttnet_response_verify", "");
        if (TextUtils.isEmpty(r19) == false) goto L128;
    L38:
        JSONArray r20 = null;
    L39:
        e9.a.a(r20, r18);
        if (this.f13688u <= 0) goto L42;
    L43:
        c9.a.f3424a = true;
    L44:
        this.f13684q = r13.getString(WsConstants.KEY_FRONTIER_URLS, "");
        this.B = r13.getString("cronet_so_path", "");
        String r21 = r13.getString("api_http_host_list", "");
        if (r5.f.b(r21) == true) goto L52;
        String[] r22 = r21.split(",");
        int r23 = r22.length;
        int r24 = 0;
    L47:
        if (r24 >= r23) goto L52;
        String r25 = r22[r24];
        if (r5.f.b(r25) == true) goto L51;
        this.D.add(r25.trim());
    L51:
        r24 = r24 + 1;
    L52:
        a7.f.c().e(r13.getString("concurrent_request_config", ""));
        r13.getString("add_common_params", "");
        x6.a.a().getClass();
        m7.c.c().g(r13.getString("L0_params", ""));
        int r26 = r13.getInt("query_filter_enabled", Integer.MIN_VALUE);
        String r27 = r13.getString("query_filter_actions", "");
        if (r26 == Integer.MIN_VALUE) goto L59;
        m7.c r28 = m7.c.c();
        if (r26 > 0) goto L58;
        r10 = false;
    L58:
        r28.f9294b = r10;
        m7.c.c().d(r27);
    L59:
        String r29 = r13.getString("share_cookie_host_list", "");
        defpackage.c.Z(r29, this.C);
        String r30 = TTNetInit.getTTNetDepend().getShareCookieMainDomain();
        if (r5.f.b(r30) == false) goto L62;
    L64:
        this.G.set(r13.getInt("tnc_update_interval", 10800));
        String r31 = r13.getString("send_tnc_host_arrays", "");
        if (TextUtils.isEmpty(r31) == true) goto L68;
        String[] r32 = r31.split(",");
        this.H.clear();
        this.H.addAll(Arrays.asList(r32));
    L68:
        if (d9.d.c().f6981d == null) goto L93;
        d9.b r33 = d9.d.c().f6981d;
        long r110 = this.f13679b.get();
        r33.getClass();
        Logger.d("TNCConfigHandler", "load local config");
        if (r33.f6973c == false) goto L93;
        SharedPreferences r34 = r33.f6971a.getSharedPreferences("ttnet_tnc_config", 0);
        String r35 = r34.getString("tnc_config_str", null);
        String r111 = r34.getString("ttnet_tnc_etag", null);
        String r112 = r34.getString("ttnet_tnc_abtest", null);
        if (TextUtils.isEmpty(r35) == false) goto L126;
        r35 = d9.b.b();
        if (TextUtils.isEmpty(r35) == false) goto L126;
        String r36 = "load local config failed.";
    L92:
        Logger.d("TNCConfigHandler", r36);
    L126:
        JSONObject r37 = new JSONObject(r35);     // Catch: Throwable -> L88
        g7.j r38 = g7.j.e();     // Catch: Throwable -> L88
        d9.d.b r39 = d9.d.b.f6993b;     // Catch: Throwable -> L88
        r38.g(r37, 0, r111, r112, r110);     // Catch: Throwable -> L88
        e7.e.g().k(r37);     // Catch: Throwable -> L88
        w8.e.a(r37);     // Catch: Throwable -> L88
        t6.a.a(r37);     // Catch: Throwable -> L88
        d9.a r40 = d9.b.d(r37);     // Catch: Throwable -> L88
        if (r40 == null) goto L81;
        r33.f6972b = r40;     // Catch: Throwable -> L88
    L81:
        if (Logger.debug() == false) goto L93;
        StringBuilder r41 = new StringBuilder("loadLocalConfig: ");     // Catch: Throwable -> L88
        if (r40 != null) goto L85;
        String r42 = "null";
    L86:
        r41.append(r42);     // Catch: Throwable -> L88
        Logger.d("TNCConfigHandler", r41.toString());     // Catch: Throwable -> L88
        goto L93
    L85:
        r42 = r40.toString();     // Catch: Throwable -> L88
    L88:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L93;
        r36 = "loadLocalConfig: except: " + th.getMessage();
    L93:
        int r43 = r13.getInt("disable_framed_transport", 0);
        if (r43 <= 0) goto L103;
        if (r43 <= 0) goto L103;
    L100:
        th = move-exception;
        th.printStackTrace();
        goto L103
    L97:
        if (d7.h.f6861b != 0) goto L103;
        d7.h.f6861b = r43;     // Catch: Throwable -> L100
    L103:
        if (this.f13678a == false) goto L134;
        LinkedHashMap r44 = new LinkedHashMap();     // Catch: Throwable -> L109
        if (r5.f.b(this.f13684q) == true) goto L107;
        r44.put(WsConstants.KEY_FRONTIER_URLS, this.f13684q);     // Catch: Throwable -> L109
    L107:
        r44.put("http_dns_enabled", Integer.valueOf(this.f13687t));     // Catch: Throwable -> L109
        r44.put("add_ss_queries_open", Integer.valueOf(this.f13688u));     // Catch: Throwable -> L109
        r44.put("add_ss_queries_header_open", Integer.valueOf(this.f13689v));     // Catch: Throwable -> L109
        r44.put("add_ss_queries_plaintext_open", Integer.valueOf(this.f13690w));     // Catch: Throwable -> L109
        r44.put("chromium_boot_failures", Integer.valueOf(this.f13685r));     // Catch: Throwable -> L109
        r44.put("share_cookie_host_list", r29);     // Catch: Throwable -> L109
        r44.put("disable_framed_transport", Integer.valueOf(r43));     // Catch: Throwable -> L109
        new a(this, r44).a();     // Catch: Throwable -> L109
        return;
    L109:
        th = move-exception;
        th.printStackTrace();
        return;
    L134:
        return;
    L62:
        if (defpackage.c.O(r30, this.C) == true) goto L64;
        this.C.add(r30);
        goto L64
    L42:
        if (this.f13689v <= 0) goto L44;
    L128:
        r20 = new JSONArray(r19);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.printStackTrace();
    L112:
        th = move-exception;
        throw th;
    L25:
        r14 = false;
        goto L27
    }

    public final void s(d9.d.b r8, boolean r10) {
        if (this.f13678a == false) goto L6;
        i(r8, r10);
        return;
    L6:
        if (this.f13679b.get() > 0) goto L13;
        new x8.a(this).a();     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }
}
