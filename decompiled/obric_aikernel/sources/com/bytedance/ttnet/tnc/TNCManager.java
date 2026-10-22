package com.bytedance.ttnet.tnc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.k;
import com.bytedance.frameworks.baselib.network.http.util.g;
import com.bytedance.frameworks.baselib.network.http.util.j;
import com.bytedance.retrofit2.a0;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.s;
import okhttp3.x;
import okhttp3.z;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TNCManager implements com.bytedance.frameworks.baselib.network.http.ok3.impl.b {
    private static TNCManager A;
    private static String B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f2897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile long f2898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f2899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TNCUpdateSource f2900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f2901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f2902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f2903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f2904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f2905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile long f2906j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private AtomicBoolean f2907k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f2908l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Context f2909m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.bytedance.ttnet.tnc.a f2910n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private volatile int f2911o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private volatile long f2912p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile long f2913q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f2914r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private HashMap<String, Integer> f2915s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private HashMap<String, Integer> f2916t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f2917u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private HashMap<String, Integer> f2918v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private HashMap<String, Integer> f2919w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f2920x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Handler f2921y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private volatile d f2922z;

    public static final enum TNCUpdateSource extends Enum<TNCUpdateSource> {
        private static final /* synthetic */ TNCUpdateSource[] $VALUES = null;
        public static final TNCUpdateSource PORTRETRY = null;
        public static final TNCUpdateSource TTCACHE = null;
        public static final TNCUpdateSource TTCRONET = null;
        public static final TNCUpdateSource TTCRONETFAILED = null;
        public static final TNCUpdateSource TTERROR = null;
        public static final TNCUpdateSource TTHardCode = null;
        public static final TNCUpdateSource TTPOLL = null;
        public static final TNCUpdateSource TTREGION = null;
        public static final TNCUpdateSource TTRESUME = null;
        public static final TNCUpdateSource TTSERVER = null;
        public static final TNCUpdateSource TTTNC = null;
        public final int mValue;

        static {
            TNCUpdateSource r10 = new TNCUpdateSource("TTRESUME", 0, -2);
            TTRESUME = r10;
            TNCUpdateSource r11 = new TNCUpdateSource("TTHardCode", 1, -1);
            TTHardCode = r11;
            TNCUpdateSource r12 = new TNCUpdateSource("TTCACHE", 2, 0);
            TTCACHE = r12;
            TNCUpdateSource r13 = new TNCUpdateSource("TTSERVER", 3, 1);
            TTSERVER = r13;
            TNCUpdateSource r14 = new TNCUpdateSource("TTERROR", 4, 2);
            TTERROR = r14;
            TNCUpdateSource r15 = new TNCUpdateSource("TTPOLL", 5, 3);
            TTPOLL = r15;
            TNCUpdateSource r16 = new TNCUpdateSource("TTTNC", 6, 4);
            TTTNC = r16;
            TNCUpdateSource r17 = new TNCUpdateSource("PORTRETRY", 7, 7);
            PORTRETRY = r17;
            TNCUpdateSource r18 = new TNCUpdateSource("TTREGION", 8, 10);
            TTREGION = r18;
            TNCUpdateSource r19 = new TNCUpdateSource("TTCRONET", 9, 20);
            TTCRONET = r19;
            TNCUpdateSource r20 = new TNCUpdateSource("TTCRONETFAILED", 10, 30);
            TTCRONETFAILED = r20;
            $VALUES = new TNCUpdateSource[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20};
        }

        private TNCUpdateSource(String r10, int r11, int r12) {
            super(r10, r11);
            this.mValue = r12;
        }

        public static TNCUpdateSource valueOf(String r10) {
            return (TNCUpdateSource) Enum.valueOf(TNCUpdateSource.class, r10);
        }

        public static TNCUpdateSource[] values() {
            return (TNCUpdateSource[]) $VALUES.clone();
        }
    }

    class a implements c3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ICronetAppProvider f2923a;

        a(ICronetAppProvider r10) {
            this.f2923a = r10;
        }

        @Override // c3.a
        public void a(String r10, String r11) {
            this.f2923a.sendAppMonitorEvent(r10, r11);
        }

        @Override // c3.a
        public boolean b(JSONObject r10, String r11, String r12, boolean r13) {
            return TNCManager.m().q(r10, r11, r12, r13);
        }

        @Override // c3.a
        public void onStoreIdcChanged(String r10, String r11, String r12, String r13, String r14, String r15) {
            x4.b.a().c(r10, r11, r12, r13, r14, r15);
        }
    }

    class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TNCManager f2924a;

        b(TNCManager r10, Looper r11) {
            this.f2924a = r10;
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            if (r10.what == 10000) goto L6;
            return;
        L6:
            if (r10.arg1 != 0) goto L8;
            boolean r11 = false;
        L9:
            TNCManager r12 = this.f2924a;
            TNCManager.e(r12, r11, TNCManager.d(r12, r10.arg2));
            return;
        L8:
            r11 = true;
            goto L9
        }
    }

    class c implements k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TNCManager f2925a;

        c(TNCManager r10) {
            this.f2925a = r10;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.k.a
        public boolean a(String r10, String r11, Map<String, List<String>> r12, String r13) {
            List<n4.b> r14 = TNCManager.f(this.f2925a, r12);
            return TNCManager.g(this.f2925a).b(r10, r11, r14, r13);
        }
    }

    public interface d {
        boolean a(String r10, String r11, List<n4.b> r12, String r13);

        boolean b(String r10, String r11, List<n4.b> r12, String r13);
    }

    private TNCManager() {
        this.f2897a = 0;
        this.f2898b = 0;
        this.f2899c = 0;
        this.f2900d = TNCUpdateSource.TTCACHE;
        this.f2901e = 0;
        this.f2902f = false;
        this.f2903g = false;
        this.f2907k = new AtomicBoolean(false);
        this.f2908l = false;
        this.f2911o = 0;
        this.f2912p = 0;
        this.f2913q = 0;
        this.f2914r = 0;
        this.f2915s = new HashMap();
        this.f2916t = new HashMap();
        this.f2917u = 0;
        this.f2918v = new HashMap();
        this.f2919w = new HashMap();
        this.f2920x = true;
        this.f2921y = new b(this, Looper.getMainLooper());
        this.f2922z = null;
        new c(this);
    }

    private void A() {
        SharedPreferences r10 = this.f2909m.getSharedPreferences("ttnet_tnc_config", 0);
        this.f2911o = r10.getInt("tnc_probe_cmd", 0);
        this.f2912p = r10.getLong("tnc_probe_version", 0);
    }

    private List<n4.b> B(Map<String, List<String>> r10) {
        ArrayList r11 = new ArrayList();
        Iterator<String> r12 = r10.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        String r13 = r12.next();
        List<String> r14 = r10.get(r13);
        if (r14 == null) goto L4;
        Iterator<String> r15 = r14.iterator();
    L10:
        if (r15.hasNext() == false) goto L4;
        r11.add(new n4.b(r13, r15.next()));
        goto L10
    L12:
        return r11;
    }

    private void C() {
        if (Logger.debug() == false) goto L5;
        Logger.d("TNCManager", "resetTNCControlState");
    L5:
        this.f2914r = 0;
        this.f2915s.clear();
        this.f2916t.clear();
        this.f2917u = 0;
        this.f2918v.clear();
        this.f2919w.clear();
    }

    private void D(boolean r10, long r11, TNCUpdateSource r12) {
        if (this.f2921y.hasMessages(10000) == false) goto L5;
        return;
    L5:
        Message r13 = this.f2921y.obtainMessage();
        r13.what = 10000;
        r13.arg1 = r10 ? 1 : 0;
        r13.arg2 = r12.mValue;
        Handler r14 = this.f2921y;
        if (r11 <= 0) goto L8;
        r14.sendMessageDelayed(r13, r11);
        return;
    L8:
        r14.sendMessage(r13);
    }

    private TNCUpdateSource E(int r10) {
        if (r10 == 7) goto L34;
        if (r10 == 10) goto L32;
        if (r10 == 20) goto L30;
        if (r10 == 30) goto L28;
        switch(r10) {
            case -2: goto L26;
            case -1: goto L24;
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            default: goto L12;
        };
    L12:
        return TNCUpdateSource.TTSERVER;
    L14:
        return TNCUpdateSource.TTTNC;
    L16:
        return TNCUpdateSource.TTPOLL;
    L18:
        return TNCUpdateSource.TTERROR;
    L20:
        return TNCUpdateSource.TTSERVER;
    L22:
        return TNCUpdateSource.TTCACHE;
    L24:
        return TNCUpdateSource.TTHardCode;
    L26:
        return TNCUpdateSource.TTRESUME;
    L28:
        return TNCUpdateSource.TTCRONETFAILED;
    L30:
        return TNCUpdateSource.TTCRONET;
    L32:
        return TNCUpdateSource.TTREGION;
    L34:
        return TNCUpdateSource.PORTRETRY;
    }

    static /* synthetic */ TNCUpdateSource d(TNCManager r10, int r11) {
        return r10.E(r11);
    }

    static /* synthetic */ void e(TNCManager r10, boolean r11, TNCUpdateSource r12) {
        r10.i(r11, r12);
    }

    static /* synthetic */ List f(TNCManager r10, Map r11) {
        return r10.B(r11);
    }

    static /* synthetic */ d g(TNCManager r10) {
        return r10.f2922z;
    }

    private static void h(j r10) {
        Object r11 = TTNetInit.getTTNetDepend();
        if (r11 != null) goto L5;
        return;
    L5:
        if ((r11 instanceof com.bytedance.ttnet.a) == false) goto L16;
        Map<String, String> r12 = ((com.bytedance.ttnet.a) r11).c();
        if (r12 != null) goto L9;
        return;
    L9:
        if (r12.isEmpty() == true) goto L18;
        Iterator<Map.Entry<String, String>> r13 = r12.entrySet().iterator();
    L12:
        if (r13.hasNext() == false) goto L19;
        Map.Entry<String, String> r14 = r13.next();
        r10.b(r14.getKey(), r14.getValue());
        goto L12
    L19:
        return;
    L18:
        return;
    }

    private void i(boolean r10, TNCUpdateSource r11) {
        f5.a r12 = n();
        if (r12 != null) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("TNCManager", "doUpdateRemote, " + r10);
    L8:
        long r13 = SystemClock.elapsedRealtime();
        if (r10 == false) goto L11;
    L16:
        this.f2897a = r13;
        if (r11 != TNCUpdateSource.TTTNC) goto L19;
        this.f2898b = System.currentTimeMillis();
    L19:
        w4.a.r(this.f2909m).o(r11, false);
        return;
    L11:
        if ((this.f2897a + (((long) r12.f8862j) * 1000)) <= r13) goto L16;
        if (Logger.debug() == false) goto L21;
        Logger.d("TNCManager", "doUpdateRemote, time limit");
        return;
    }

    private String k(Exception r10) {
        StringWriter r11 = new StringWriter();
        r10.printStackTrace(new PrintWriter(r11));
        return r11.toString().toLowerCase();
    }

    static String l() {
        return B;
    }

    public static synchronized TNCManager m() {
        monitor-enter(TNCManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (A != null) goto L7;
        A = new TNCManager();     // Catch: Throwable -> L10
    L7:
        TNCManager r10 = A;     // Catch: Throwable -> L10
        monitor-exit(TNCManager.class);
        return r10;
    }

    private void r(z r13, String r14) {
        if (r13 != null) goto L5;
        return;
    L5:
        if (this.f2920x == true) goto L7;
        return;
    L7:
        String r15 = r13.r("tt-idc-switch", null);
        if (TextUtils.isEmpty(r15) == true) goto L10;
        String[] r16 = r15.split("@");
        if (r16 == null) goto L50;
        if (r16.length != 2) goto L50;
        long r10 = 0;
        int r11 = Integer.parseInt(r16[0]);     // Catch: Throwable -> L24
        long r12 = Long.parseLong(r16[1]);     // Catch: Throwable -> L22
    L31:
        if (Logger.debug() == false) goto L34;
        Logger.d("TNCManager", "handleTncProbe, local: " + this.f2911o + "@" + this.f2912p + " svr: " + r11 + "@" + r12 + " " + r14);
    L34:
        if (r12 > this.f2912p) goto L36;
        return;
    L36:
        this.f2911o = r11;
        this.f2912p = r12;
        this.f2899c = System.currentTimeMillis();
        this.f2909m.getSharedPreferences("ttnet_tnc_config", 0).edit().putInt("tnc_probe_cmd", r11).putLong("tnc_probe_version", r12).apply();
        if (this.f2911o != 10000) goto L58;
        f5.a r17 = n();
        if (r17 != null) goto L41;
        return;
    L41:
        Random r18 = new Random(System.currentTimeMillis());
        int r19 = r17.f8863k;
        if (r19 <= 0) goto L45;
        r10 = ((long) r18.nextInt(r19)) * 1000;
    L45:
        if (Logger.debug() == false) goto L47;
        Logger.d("TNCManager", "handleTncProbe, updateConfig delay: " + r10 + " " + r14);
    L47:
        D(true, r10, TNCUpdateSource.TTTNC);
        return;
    L58:
        return;
    L22:
        th = th;
    L26:
        th.printStackTrace();
        if (Logger.debug() == false) goto L29;
        Logger.d("TNCManager", "handleTncProbe, probeProto except, " + r14);
    L29:
        r12 = 0;
    L24:
        th = th;
        r11 = 0;
    L50:
        if (Logger.debug() == false) goto L59;
        Logger.d("TNCManager", "handleTncProbe, probeProto err, " + r14);
        return;
    L59:
        return;
    L10:
        if (Logger.debug() == false) goto L57;
        Logger.d("TNCManager", "handleTncProbe, no probeProto, " + r14);
        return;
    }

    private boolean s(Context r10, TNCUpdateSource r11, String r12, String r13, String r14, String r15, boolean r16) {
    L26:
        return false;
    L4:
        if (Logger.debug() == false) goto L7;
        Logger.d("TNCManager", "okhttp tnc response success, etag is " + r14 + ", tnc control " + r13);     // Catch: Exception -> L26
    L7:
        if (TextUtils.isEmpty(r14) == true) goto L9;
        w4.a.r(r10).E(r14);     // Catch: Exception -> L26
    L9:
        m().f2910n.j(r15);     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r13) == true) goto L15;
        if (r13.equals(NetConst.ENCRYPT_VERISON_CODE) == false) goto L15;
        return true;
    L15:
        if (TextUtils.isEmpty(r12) == false) goto L17;
        return false;
    L17:
        JSONObject r17 = new JSONObject(r12);     // Catch: Exception -> L26
        ClientKeyManager.k().c(r12);     // Catch: Exception -> L26
        boolean r18 = w4.a.r(r10).w(r17, r11, System.currentTimeMillis(), r16);     // Catch: Exception -> L26
        if (r18 == false) goto L25;
        this.f2901e = System.currentTimeMillis();     // Catch: Exception -> L26
        if (this.f2902f == true) goto L22;
        this.f2902f = true;     // Catch: Exception -> L26
    L22:
        this.f2903g = true;     // Catch: Exception -> L26
        if (r11 != TNCUpdateSource.TTTNC) goto L25;
        this.f2913q = this.f2912p;     // Catch: Exception -> L26
    L25:
        return r18;
    }

    private List<n4.b> t(Map<String, String> r10) {
        ArrayList r11 = new ArrayList();
        Iterator<String> r12 = r10.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        String r13 = r12.next();
        String r14 = r10.get(r13);
        if (TextUtils.isEmpty(r13) == true) goto L4;
        if (TextUtils.isEmpty(r14) == true) goto L4;
        r11.add(new n4.b(r13, r14));
        goto L4
    L10:
        return r11;
    }

    public static void u(ICronetAppProvider r10) {
        String r11 = r10.getCarrierRegion();
        String r12 = r10.getSysRegion();
        String r13 = r10.getRegion();
        if (TextUtils.isEmpty(r11) == true) goto L6;
    L9:
        c3.b.m().l(r11, r10.getStoreIdcRuleJSON(), r10.getAppInitialRegionInfo(), TTNetInit.getTTNetDepend().getContext(), new a(r10));
        if (TextUtils.isEmpty(r11) == true) goto L13;
        B = TTNetInit.getGetDomainConfigByRegion(r11);
    L13:
        if (TextUtils.isEmpty(B) == false) goto L16;
        B = r10.getGetDomainDefaultJSON();
    L16:
        if (Logger.debug() == false) goto L19;
        Logger.d("TNCManager", "region: " + r11 + " json: " + B);
        return;
    L19:
        return;
    L6:
        if (TextUtils.isEmpty(r12) == true) goto L8;
        r11 = r12;
        goto L9
    L8:
        r11 = r13;
        goto L9
    }

    private boolean w(int r10) {
        if (r10 >= 100) goto L5;
    L16:
        return true;
    L5:
        if (r10 >= 1000) goto L16;
        f5.a r11 = n();
        if (r11 != null) goto L10;
        return false;
    L10:
        if (TextUtils.isEmpty(r11.f8864l) == false) goto L12;
        return false;
    L12:
        if (r11.f8864l.contains("" + r10) == false) goto L18;
        return true;
    L18:
        return false;
    }

    private boolean x(int r10) {
        if (r10 >= 200) goto L5;
        return false;
    L5:
        if (r10 >= 400) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.b
    public synchronized void a(x r10, z r11) {
        monitor-enter(this);
        if (r10 == null) goto L80;
        if (r11 == null) goto L80;
    L77:
        th = move-exception;
        throw th;
    L7:
        if (this.f2920x == true) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (NetworkUtils.g(this.f2909m) == true) goto L14;
        monitor-exit(this);
        return;
    L14:
        s r12 = r10.l();     // Catch: Throwable -> L77
        String r13 = r12.s();     // Catch: Throwable -> L77
        String r14 = r12.h();     // Catch: Throwable -> L77
        String r15 = r12.d();     // Catch: Throwable -> L77
        int r16 = r11.k();     // Catch: Throwable -> L77
        if ("http".equals(r13) == true) goto L21;
        if ("https".equals(r13) == true) goto L21;
        monitor-exit(this);
        return;
    L21:
        if (TextUtils.isEmpty(r14) == false) goto L25;
        monitor-exit(this);
        return;
    L25:
        if (r11.D() != null) goto L29;
        monitor-exit(this);
        return;
    L29:
        if (Logger.debug() == false) goto L31;
        Logger.d("TNCManager", "onOk3Response, url: " + r13 + "://" + r14 + "#" + r16);     // Catch: Throwable -> L77
    L31:
        f5.a r17 = n();     // Catch: Throwable -> L77
        if (r17 != null) goto L34;
    L36:
        if (r17 != null) goto L38;
    L75:
        monitor-exit(this);
        return;
    L38:
        if (r17.f8853a == false) goto L75;
        Map<String, Integer> r18 = r17.f8855c;     // Catch: Throwable -> L77
        if (r18 != null) goto L43;
    L73:
        monitor-exit(this);
        return;
    L43:
        if (r18.size() <= 0) goto L73;
        if (r17.f8855c.containsKey(r14) == false) goto L73;
        if (Logger.debug() == false) goto L50;
        Logger.d("TNCManager", "onOk3Response, url matched: " + r13 + "://" + r14 + "#" + r16 + " " + this.f2914r + "#" + this.f2915s.size() + "#" + this.f2916t.size() + " " + this.f2917u + "#" + this.f2918v.size() + "#" + this.f2919w.size());     // Catch: Throwable -> L77
    L50:
        if (r16 > 0) goto L52;
    L71:
        monitor-exit(this);
        return;
    L52:
        if (x(r16) == false) goto L59;
        if (this.f2914r <= 0) goto L56;
    L57:
        C();     // Catch: Throwable -> L77
        goto L71
    L56:
        if (this.f2917u <= 0) goto L71;
    L59:
        if (w(r16) == true) goto L71;
        this.f2917u++;     // Catch: Throwable -> L77
        this.f2918v.put(r15, 0);     // Catch: Throwable -> L77
        this.f2919w.put(r14, 0);     // Catch: Throwable -> L77
        if (this.f2917u < r17.f8859g) goto L71;
        if (this.f2918v.size() < r17.f8860h) goto L71;
        if (this.f2919w.size() < r17.f8861i) goto L71;
        if (Logger.debug() == false) goto L69;
        Logger.d("TNCManager", "onOk3Response, url doUpdate: " + r13 + "://" + r14 + "#" + r16);     // Catch: Throwable -> L77
    L69:
        D(false, 0, TNCUpdateSource.TTERROR);     // Catch: Throwable -> L77
        goto L57
    L34:
        if (r17.f8854b == false) goto L36;
        r(r11, r14);     // Catch: Throwable -> L77
    L80:
        monitor-exit(this);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.b
    public JSONObject b() {
        JSONObject r10 = new JSONObject();
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L29
        r11.put("update_time", this.f2901e);     // Catch: JSONException -> L29
        r11.put("source", this.f2900d.mValue);     // Catch: JSONException -> L29
        int r12 = 1;
        if (this.f2902f == false) goto L6;
        int r13 = 1;
    L7:
        r11.put("cold_start", r13);     // Catch: JSONException -> L29
        if (this.f2903g == true) goto L11;
        r12 = 0;
    L11:
        r11.put("config_updated", r12);     // Catch: JSONException -> L29
        if (TextUtils.isEmpty(this.f2904h) == true) goto L15;
        r11.put("config", this.f2904h);     // Catch: JSONException -> L29
    L15:
        if (TextUtils.isEmpty(this.f2905i) == true) goto L17;
        r11.put("canary", this.f2905i);     // Catch: JSONException -> L29
    L17:
        r11.put("local_probe_version", this.f2913q);     // Catch: JSONException -> L29
        String r14 = w4.a.r(this.f2909m).u();     // Catch: JSONException -> L29
        if (TextUtils.isEmpty(r14) == true) goto L20;
        r11.put("rules", r14);     // Catch: JSONException -> L29
    L20:
        com.bytedance.ttnet.tnc.a r15 = this.f2910n;     // Catch: JSONException -> L29
        if (r15 != null) goto L23;
    L27:
        r10.put("data", r11);     // Catch: JSONException -> L29
        JSONObject r16 = new JSONObject();     // Catch: JSONException -> L29
        r16.put("version", this.f2912p);     // Catch: JSONException -> L29
        r16.put("cmd", this.f2911o);     // Catch: JSONException -> L29
        r16.put(ICronetClient.KEY_SEND_TIME, this.f2898b);     // Catch: JSONException -> L29
        r16.put("get_time", this.f2899c);     // Catch: JSONException -> L29
        r10.put("probe", r16);     // Catch: JSONException -> L29
        JSONObject r17 = new JSONObject();     // Catch: JSONException -> L29
        r17.put("probe_version", this.f2913q);     // Catch: JSONException -> L29
        r17.put("source", this.f2900d.mValue);     // Catch: JSONException -> L29
        r17.put("start_time", this.f2906j);     // Catch: JSONException -> L29
        r10.put("request", r17);     // Catch: JSONException -> L29
    L31:
        return r10;
    L23:
        if (TextUtils.isEmpty(r15.a()) == true) goto L27;
        if (TextUtils.isEmpty(this.f2910n.b()) == true) goto L27;
        r11.put(Api.KEY_REGION, this.f2910n.a());     // Catch: JSONException -> L29
        r11.put("region_source", this.f2910n.b());     // Catch: JSONException -> L29
        goto L27
    L6:
        r13 = 0;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.b
    public synchronized void c(x r10, Exception r11) {
        monitor-enter(this);
        if (r10 == null) goto L69;
        if (r11 == null) goto L69;
    L66:
        th = move-exception;
        throw th;
    L7:
        if (this.f2920x == true) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (NetworkUtils.g(this.f2909m) == true) goto L14;
        monitor-exit(this);
        return;
    L14:
        s r12 = r10.l();     // Catch: Throwable -> L66
        String r13 = r12.s();     // Catch: Throwable -> L66
        String r14 = r12.h();     // Catch: Throwable -> L66
        String r15 = r12.d();     // Catch: Throwable -> L66
        String r16 = k(r11);     // Catch: Throwable -> L66
        if ("http".equals(r13) == true) goto L21;
        if ("https".equals(r13) == true) goto L21;
        monitor-exit(this);
        return;
    L21:
        if (TextUtils.isEmpty(r14) == false) goto L25;
        monitor-exit(this);
        return;
    L25:
        if (TextUtils.isEmpty(r16) == false) goto L27;
    L64:
        monitor-exit(this);
        return;
    L27:
        if (r16.contains("timeout") == false) goto L64;
        if (r16.contains("time out") == false) goto L64;
        if (r16.contains("unreachable") == true) goto L64;
        f5.a r17 = n();     // Catch: Throwable -> L66
        if (r17 != null) goto L36;
    L62:
        monitor-exit(this);
        return;
    L36:
        if (r17.f8853a == false) goto L62;
        Map<String, Integer> r18 = r17.f8855c;     // Catch: Throwable -> L66
        if (r18 != null) goto L41;
    L60:
        monitor-exit(this);
        return;
    L41:
        if (r18.size() <= 0) goto L60;
        if (r17.f8855c.containsKey(r14) == false) goto L60;
        if (Logger.debug() == false) goto L48;
        Logger.d("TNCManager", "onOk3Timeout, url matched: " + r13 + "://" + r14 + "#" + r16 + " " + this.f2914r + "#" + this.f2915s.size() + "#" + this.f2916t.size() + " " + this.f2917u + "#" + this.f2918v.size() + "#" + this.f2919w.size());     // Catch: Throwable -> L66
    L48:
        this.f2914r++;     // Catch: Throwable -> L66
        this.f2915s.put(r15, 0);     // Catch: Throwable -> L66
        this.f2916t.put(r14, 0);     // Catch: Throwable -> L66
        if (this.f2914r >= r17.f8856d) goto L51;
    L58:
        monitor-exit(this);
        return;
    L51:
        if (this.f2915s.size() < r17.f8857e) goto L58;
        if (this.f2916t.size() < r17.f8858f) goto L58;
        if (Logger.debug() == false) goto L57;
        Logger.d("TNCManager", "onOk3Timeout, url doUpate: " + r13 + "://" + r14);     // Catch: Throwable -> L66
    L57:
        D(false, 0, TNCUpdateSource.TTERROR);     // Catch: Throwable -> L66
        C();     // Catch: Throwable -> L66
    L69:
        monitor-exit(this);
    }

    public boolean j(Context r24, boolean r25, TNCUpdateSource r26, String r27) {
        if (Logger.debug() == false) goto L5;
        Logger.d("TNCManager", "getdomain internal, use retrofit okhttp: " + r25 + ", tnc source: " + r26);
    L5:
        ArrayList r10 = new ArrayList();
        if (w4.a.r(r24).t() != null) goto L8;
    L15:
        r10.addAll(Arrays.asList(w4.a.r(r24).p()));
    L16:
        this.f2900d = r26;
        this.f2906j = System.currentTimeMillis();
        Iterator r13 = r10.iterator();
    L18:
        if (r13.hasNext() == false) goto L89;
        j r11 = new j(ReportConsts.HTTPS + ((String) r13.next()) + "/get_domains/v5/");
        if (Build.VERSION.SDK_INT >= 21) goto L23;
        String r12 = Build.CPU_ABI;     // Catch: Throwable -> L29
    L24:
        r11.b("abi", r12);     // Catch: Throwable -> L29
        r11.a("tnc_src", r26.mValue);     // Catch: Throwable -> L29
        r11.b("okhttp_version", "4.2.228.21-doubao");     // Catch: Throwable -> L29
        if (c3.b.m().o() == false) goto L27;
        r11.b("use_store_region_cookie", NetConst.ENCRYPT_VERISON_CODE);     // Catch: Throwable -> L29
    L27:
        h(r11);     // Catch: Throwable -> L29
    L31:
        HashMap r14 = new HashMap();
        c3.b.m().b(r14);
        boolean r15 = !TextUtils.isEmpty(c3.b.m().i());
        if (TextUtils.isEmpty(r27) == true) goto L36;
        r14.put("x-tt-tnc-summary", r27);
    L36:
        if (r25 == false) goto L37;
        r11.a("aid", TTNetInit.getTTNetDepend().getAppId());
        r11.b("device_platform", "android");
        if (TTNetInit.getCronetProvider() == null) goto L53;
        r11.b("version_code", TTNetInit.getCronetProvider().getVersionCode());
        r11.b("channel", TTNetInit.getCronetProvider().getChannel());
    L53:
        ArrayList r16 = new ArrayList();
        Iterator<Map.Entry<String, String>> r17 = r14.entrySet().iterator();
    L55:
        if (r17.hasNext() == false) goto L61;
        Map.Entry<String, String> r18 = r17.next();
        if (TextUtils.isEmpty(r18.getKey()) == true) goto L55;
        if (TextUtils.isEmpty(r18.getValue()) == true) goto L55;
        r16.add(new n4.b(r18.getKey(), r18.getValue()));
        goto L55
    L61:
        String r19 = r11.toString();
        LinkedHashMap r20 = new LinkedHashMap();
        Pair<String, String> r21 = com.bytedance.frameworks.baselib.network.http.util.k.j(r19, r20);     // Catch: IOException -> L87
        String r22 = (String) r21.first;     // Catch: IOException -> L87
        String r110 = (String) r21.second;     // Catch: IOException -> L87
        INetworkApi r111 = (INetworkApi) RetrofitUtils.g(r22, INetworkApi.class);
        if (r111 == null) goto L18;
        com.bytedance.retrofit2.b<String> r112 = r111.doGet(true, -1, r110, r20, r16, null);
        a0<String> r23 = r112.execute();     // Catch: Throwable -> L78
        List<n4.b> r28 = r23.e();     // Catch: Throwable -> L78
        String r29 = r23.a();     // Catch: Throwable -> L78
        if (this.f2922z != null) goto L70;
    L73:
        String r30 = RetrofitUtils.h(r28, "x-ss-etag");     // Catch: Throwable -> L78
        String r31 = RetrofitUtils.h(r28, "x-tt-tnc-abtest");     // Catch: Throwable -> L78
        String r32 = RetrofitUtils.h(r28, "x-tt-tnc-control");     // Catch: Throwable -> L78
        this.f2904h = RetrofitUtils.h(r28, "x-tt-tnc-config");     // Catch: Throwable -> L78
        this.f2905i = RetrofitUtils.h(r28, "x-ss-canary");     // Catch: Throwable -> L78
        if (m().s(r24, r26, r29, r32, r30, r31, r15) == true) goto L76;
    L75:
        r112.cancel();
        goto L18
    L76:
        r112.cancel();
        return true;
    L70:
        if (this.f2922z.a("GET", r112.a().G(), r28, r29) == true) goto L73;
        r112.cancel();
        return false;
    L78:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L82
        if (r112 == null) goto L18;
    L82:
        th = move-exception;
        if (r112 == null) goto L130;
        r112.cancel();
        throw th;
    L130:
        throw th;
    L87:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L37:
        a5.a r33 = new a5.a();
        r33.f101a = r11.toString();
        r33.f102b = true;
        System.currentTimeMillis();
    L48:
        th = move-exception;
        th.printStackTrace();
        goto L18
    L39:
        if (y("GET", r33.f101a, r14, "") == false) goto L40;
        HashMap r34 = new HashMap();     // Catch: Throwable -> L48
        String r35 = a5.c.a(r33.f101a, r14, r34, r33);     // Catch: Throwable -> L48
        if (z("GET", r33.f101a, r34, r35) == false) goto L43;
        System.currentTimeMillis();     // Catch: Throwable -> L48
        this.f2905i = r33.f108h;     // Catch: Throwable -> L48
        this.f2904h = r33.f107g;     // Catch: Throwable -> L48
        if (m().s(r24, r26, r35, r33.f106f, r33.f104d, r33.f105e, r15) == false) goto L18;
        return true;
    L43:
        return false;
    L40:
        return false;
    L23:
        r12 = Build.SUPPORTED_ABIS[0];     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        th.printStackTrace();
        goto L31
    L89:
        return false;
    L8:
        if (w4.a.r(r24).t().size() == 0) goto L15;
        r10.addAll(w4.a.r(r24).t());
        String[] r36 = w4.a.r(r24).p();
        int r37 = r36.length;
        int r38 = 0;
    L10:
        if (r38 >= r37) goto L16;
        String r39 = r36[r38];
        if (r10.contains(r39) == true) goto L14;
        r10.add(r39);
    L14:
        r38 = r38 + 1;
        goto L10
    }

    public f5.a n() {
        com.bytedance.ttnet.tnc.a r10 = this.f2910n;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.c();
    }

    public com.bytedance.ttnet.tnc.a o() {
        return this.f2910n;
    }

    public void p() {
        if (n() != null) goto L5;
        return;
    L5:
        if (g.h(this.f2909m) == true) goto L7;
        return;
    L7:
        if (this.f2907k.compareAndSet(false, true) == false) goto L12;
        D(true, 0, TNCUpdateSource.TTCRONETFAILED);
        return;
    }

    public boolean q(JSONObject r12, String r13, String r14, boolean r15) {
        if (Logger.debug() == false) goto L6;
        Logger.d("TNCManager", "data: " + r12 + " etag: " + r13 + " tncAttr: " + r14 + " needUpdateTnc: " + r15);
    L6:
        if (r12 == null) goto L13;
        com.bytedance.ttnet.tnc.a r10 = this.f2910n;
        if (r10 == null) goto L10;
        r10.j("");
        boolean r16 = this.f2910n.d(r12, TNCUpdateSource.TTSERVER, r13, r14, System.currentTimeMillis());
    L11:
        if (r16 == false) goto L14;
        c3.b.m().r();
    L14:
        if (r15 == false) goto L18;
        if (r16 == true) goto L18;
        Logger.d("TNCManager", "doUpdateRemote tnc");
        i(true, TNCUpdateSource.TTREGION);
        return true;
    L18:
        return false;
    L10:
        r16 = false;
        goto L11
    L13:
        r16 = false;
        goto L14
    }

    public synchronized void v(Context r10, boolean r11) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f2908l == true) goto L12;
        this.f2909m = r10;     // Catch: Throwable -> L14
        this.f2920x = r11;     // Catch: Throwable -> L14
        this.f2910n = new com.bytedance.ttnet.tnc.a(r10, r11);     // Catch: Throwable -> L14
        if (r11 == false) goto L9;
        A();     // Catch: Throwable -> L14
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("TNCManager", "initTnc, isMainProc: " + r11 + " probeCmd: " + this.f2911o + " probeVersion: " + this.f2912p);     // Catch: Throwable -> L14
    L11:
        this.f2908l = true;     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
    }

    public boolean y(String r10, String r11, Map<String, String> r12, String r13) {
        if (this.f2922z != null) goto L6;
        return true;
    L6:
        if (r13 != null) goto L8;
        r13 = "";
    L8:
        List<n4.b> r14 = t(r12);
        return this.f2922z.b(r10, r11, r14, r13);
    }

    public boolean z(String r10, String r11, Map<String, List<String>> r12, String r13) {
        if (this.f2922z != null) goto L6;
        return true;
    L6:
        List<n4.b> r14 = B(r12);
        return this.f2922z.a(r10, r11, r14, r13);
    }
}
