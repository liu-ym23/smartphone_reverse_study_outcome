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
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.c;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.l;
import com.bytedance.frameworks.baselib.network.http.util.g;
import com.bytedance.frameworks.baselib.network.http.util.j;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.bytedance.ttnet.config.AppConfig;
import com.bytedance.ttnet.d;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TNCManager implements c {
    private static TNCManager n;
    private static String o;
    private HashMap<String, Integer> A;
    private boolean B;
    private volatile a C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f3315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    l.a f3316b;
    private long c;
    private volatile long d;
    private volatile long e;
    private TNCUpdateSource f;
    private volatile long g;
    private volatile boolean h;
    private volatile boolean i;
    private String j;
    private String k;
    private volatile long l;
    private AtomicBoolean m;
    private boolean p;
    private Context q;
    private b r;
    private volatile int s;
    private volatile long t;
    private volatile long u;
    private int v;
    private HashMap<String, Integer> w;
    private HashMap<String, Integer> x;
    private int y;
    private HashMap<String, Integer> z;

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
            TNCUpdateSource r0 = new TNCUpdateSource("TTRESUME", 0, -2);
            TTRESUME = r0;
            TNCUpdateSource r1 = new TNCUpdateSource("TTHardCode", 1, -1);
            TTHardCode = r1;
            TNCUpdateSource r3 = new TNCUpdateSource("TTCACHE", 2, 0);
            TTCACHE = r3;
            TNCUpdateSource r5 = new TNCUpdateSource("TTSERVER", 3, 1);
            TTSERVER = r5;
            TNCUpdateSource r7 = new TNCUpdateSource("TTERROR", 4, 2);
            TTERROR = r7;
            TNCUpdateSource r9 = new TNCUpdateSource("TTPOLL", 5, 3);
            TTPOLL = r9;
            TNCUpdateSource r11 = new TNCUpdateSource("TTTNC", 6, 4);
            TTTNC = r11;
            TNCUpdateSource r13 = new TNCUpdateSource("PORTRETRY", 7, 7);
            PORTRETRY = r13;
            TNCUpdateSource r15 = new TNCUpdateSource("TTREGION", 8, 10);
            TTREGION = r15;
            TNCUpdateSource r14 = new TNCUpdateSource("TTCRONET", 9, 20);
            TTCRONET = r14;
            TNCUpdateSource r6 = new TNCUpdateSource("TTCRONETFAILED", 10, 30);
            TTCRONETFAILED = r6;
            $VALUES = new TNCUpdateSource[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r6};
        }

        private TNCUpdateSource(String r1, int r2, int r3) {
            super(r1, r2);
            this.mValue = r3;
        }

        public static TNCUpdateSource valueOf(String r2) {
            return (TNCUpdateSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(TNCUpdateSource.class, r2), TNCUpdateSource.class, "com.obric.memorydata.plugin");
        }

        public static TNCUpdateSource[] values() {
            return (TNCUpdateSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TNCUpdateSource[].class, "com.obric.memorydata.plugin");
        }
    }

    public interface a {
        boolean a(String r1, String r2, List<Header> r3, String r4);

        boolean b(String r1, String r2, List<Header> r3, String r4);
    }

    private TNCManager() {
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = TNCUpdateSource.TTCACHE;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.m = new AtomicBoolean(false);
        this.p = false;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = new HashMap();
        this.x = new HashMap();
        this.y = 0;
        this.z = new HashMap();
        this.A = new HashMap();
        this.B = true;
        final Looper r1 = Looper.getMainLooper();
        this.f3315a = new AnonymousClass2(this, r1);
        this.C = null;
        this.f3316b = new AnonymousClass3(this);
    }

    static /* synthetic */ TNCUpdateSource a(TNCManager r0, int r1) {
        return r0.c(r1);
    }

    static /* synthetic */ a a(TNCManager r0) {
        return r0.C;
    }

    private String a(Exception r2) {
        StringWriter r1 = new StringWriter();
        r2.printStackTrace(new PrintWriter(r1));
        return r1.toString().toLowerCase();
    }

    static /* synthetic */ List a(TNCManager r2, Map r3) {
        return r2.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    private List<Header> a(Map<String, List<String>> r7) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        ArrayList r8 = new ArrayList();
        Iterator r1 = r6.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.preCheckCast(r6.get(r2), List.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L4;
        Iterator r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L4;
        r8.add(new Header(r2, (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin")));
        goto L10
    L12:
        return r8;
    }

    public static void a(ICronetAppProvider r10) {
        final ICronetAppProvider r11 = (ICronetAppProvider) ZeusTransformUtils.wrapperContextForParams(r10, ICronetAppProvider.class, "com.obric.memorydata.plugin");
        String r0 = r11.getCarrierRegion();
        String r2 = r11.getSysRegion();
        String r3 = r11.getRegion();
        if (TextUtils.isEmpty(r0) == true) goto L6;
    L9:
        com.bytedance.frameworks.baselib.network.http.d.b.a().a(r0, r11.getStoreIdcRuleJSON(), r11.getAppInitialRegionInfo(), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), new AnonymousClass1(r11));
        if (TextUtils.isEmpty(r0) == true) goto L13;
        o = TTNetInit.getGetDomainConfigByRegion(r0);
    L13:
        if (TextUtils.isEmpty(o) == false) goto L16;
        o = r11.getGetDomainDefaultJSON();
    L16:
        if (Logger.debug() == false) goto L19;
        Logger.d("TNCManager", "region: " + r0 + " json: " + o);
        return;
    L19:
        return;
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r0 = r2;
        goto L9
    L8:
        r0 = r3;
        goto L9
    }

    private static void a(j r5) {
        d r0 = TTNetInit.getTTNetDepend();
        if (r0 != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.ttnet.a.class) == false) goto L16;
        Map<String, String> r1 = ((com.bytedance.ttnet.a) ZeusTransformUtils.preCheckCast(r0, com.bytedance.ttnet.a.class, "com.obric.memorydata.plugin")).a();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isEmpty() == true) goto L18;
        Iterator<Map.Entry<String, String>> r2 = r1.entrySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L19;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r5.a((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.memorydata.plugin"));
        goto L12
    L19:
        return;
    L18:
        return;
    }

    static /* synthetic */ void a(TNCManager r0, boolean r1, TNCUpdateSource r2) {
        r0.a(r1, r2);
    }

    private void a(Response r13, String r14) {
        if (r13 != null) goto L5;
        return;
    L5:
        if (this.B == true) goto L7;
        return;
    L7:
        String r15 = r13.header("tt-idc-switch", null);
        if (TextUtils.isEmpty(r15) == true) goto L10;
        String[] r16 = r15.split("@");
        if (r16 == null) goto L50;
        if (r16.length != 2) goto L50;
        long r3 = 0;
        int r6 = Integer.parseInt(r16[0]);     // Catch: Throwable -> L24
        long r7 = Long.parseLong(r16[1]);     // Catch: Throwable -> L22
    L31:
        if (Logger.debug() == false) goto L34;
        Logger.d("TNCManager", "handleTncProbe, local: " + this.s + "@" + this.t + " svr: " + r6 + "@" + r7 + " " + r14);
    L34:
        if (r7 > this.t) goto L36;
        return;
    L36:
        this.s = r6;
        this.t = r7;
        this.e = System.currentTimeMillis();
        this.q.getSharedPreferences("ttnet_tnc_config", 0).edit().putInt("tnc_probe_cmd", r6).putLong("tnc_probe_version", r7).apply();
        if (this.s != 10000) goto L58;
        com.bytedance.ttnet.tnc.a r17 = d();
        if (r17 != null) goto L41;
        return;
    L41:
        Random r0 = new Random(System.currentTimeMillis());
        if (r17.k <= 0) goto L45;
        r3 = ((long) r0.nextInt(r17.k)) * 1000;
    L45:
        if (Logger.debug() == false) goto L47;
        Logger.d("TNCManager", "handleTncProbe, updateConfig delay: " + r3 + " " + r14);
    L47:
        a(true, r3, TNCUpdateSource.TTTNC);
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
        r7 = 0;
    L24:
        th = th;
        r6 = 0;
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

    private void a(boolean r4, long r5, TNCUpdateSource r7) {
        if (this.f3315a.hasMessages(10000) == false) goto L5;
        return;
    L5:
        Message r0 = this.f3315a.obtainMessage();
        r0.what = 10000;
        r0.arg1 = r4 ? 1 : 0;
        r0.arg2 = r7.mValue;
        Handler r3 = this.f3315a;
        if (r5 <= 0) goto L8;
        r3.sendMessageDelayed(r0, r5);
        return;
    L8:
        r3.sendMessage(r0);
    }

    private void a(boolean r10, TNCUpdateSource r11) {
        com.bytedance.ttnet.tnc.a r0 = d();
        if (r0 != null) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("TNCManager", "doUpdateRemote, " + r10);
    L8:
        long r3 = SystemClock.elapsedRealtime();
        if (r10 == false) goto L11;
    L16:
        this.c = r3;
        if (r11 != TNCUpdateSource.TTTNC) goto L19;
        this.d = System.currentTimeMillis();
    L19:
        AppConfig.getInstance(this.q).doRefresh(r11, false);
        return;
    L11:
        if ((this.c + (((long) r0.j) * 1000)) <= r3) goto L16;
        if (Logger.debug() == false) goto L21;
        Logger.d("TNCManager", "doUpdateRemote, time limit");
        return;
    }

    private boolean a(int r1) {
        if (r1 >= 200) goto L5;
        return false;
    L5:
        if (r1 >= 400) goto L10;
        return true;
    L10:
        return false;
    }

    private boolean a(Context r8, TNCUpdateSource r9, String r10, String r11, String r12, String r13, boolean r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
    L26:
        return false;
    L4:
        if (Logger.debug() == false) goto L7;
        Logger.d("TNCManager", "okhttp tnc response success, etag is " + r12 + ", tnc control " + r11);     // Catch: Exception -> L26
    L7:
        if (TextUtils.isEmpty(r12) == true) goto L9;
        AppConfig.getInstance(r15).setTncEtag(r12);     // Catch: Exception -> L26
    L9:
        c().r.a(r13);     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r11) == true) goto L15;
        if (r11.equals("1") == false) goto L15;
        return true;
    L15:
        if (TextUtils.isEmpty(r10) == false) goto L17;
        return false;
    L17:
        JSONObject r2 = new JSONObject(r10);     // Catch: Exception -> L26
        ClientKeyManager.a().a(r10);     // Catch: Exception -> L26
        boolean r16 = AppConfig.getInstance(r15).handleResponse(r2, r9, System.currentTimeMillis(), r14);     // Catch: Exception -> L26
        if (r16 == false) goto L25;
        this.g = System.currentTimeMillis();     // Catch: Exception -> L26
        if (this.h == true) goto L22;
        this.h = true;     // Catch: Exception -> L26
    L22:
        this.i = true;     // Catch: Exception -> L26
        if (r9 != TNCUpdateSource.TTTNC) goto L25;
        this.u = this.t;     // Catch: Exception -> L26
    L25:
        return r16;
    }

    static String b() {
        return o;
    }

    private List<Header> b(Map<String, String> r6) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        ArrayList r7 = new ArrayList();
        Iterator r1 = r5.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r5.get(r2), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r2) == true) goto L4;
        if (TextUtils.isEmpty(r3) == true) goto L4;
        r7.add(new Header(r2, r3));
        goto L4
    L10:
        return r7;
    }

    private boolean b(int r4) {
        if (r4 >= 100) goto L5;
    L16:
        return true;
    L5:
        if (r4 >= 1000) goto L16;
        com.bytedance.ttnet.tnc.a r3 = d();
        if (r3 != null) goto L10;
        return false;
    L10:
        if (TextUtils.isEmpty(r3.l) == false) goto L12;
        return false;
    L12:
        if (r3.l.contains("" + r4) == false) goto L18;
        return true;
    L18:
        return false;
    }

    private TNCUpdateSource c(int r1) {
        if (r1 == 7) goto L34;
        if (r1 == 10) goto L32;
        if (r1 == 20) goto L30;
        if (r1 == 30) goto L28;
        switch(r1) {
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

    public static synchronized TNCManager c() {
        monitor-enter(TNCManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (n != null) goto L7;
        n = new TNCManager();     // Catch: Throwable -> L10
    L7:
        TNCManager r1 = n;     // Catch: Throwable -> L10
        monitor-exit(TNCManager.class);
        return r1;
    }

    private void g() {
        SharedPreferences r0 = this.q.getSharedPreferences("ttnet_tnc_config", 0);
        this.s = r0.getInt("tnc_probe_cmd", 0);
        this.t = r0.getLong("tnc_probe_version", 0);
    }

    private void h() {
        if (Logger.debug() == false) goto L5;
        Logger.d("TNCManager", "resetTNCControlState");
    L5:
        this.v = 0;
        this.w.clear();
        this.x.clear();
        this.y = 0;
        this.z.clear();
        this.A.clear();
    }

    @Deprecated
    public String a(String r1) {
        return com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.j.a().b(r1);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.c
    public JSONObject a() {
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L29
        r2.put("update_time", this.g);     // Catch: JSONException -> L29
        r2.put(AILabCheckPermissionTask.KEY_SOURCE, this.f.mValue);     // Catch: JSONException -> L29
        int r5 = 1;
        if (this.h == false) goto L6;
        int r4 = 1;
    L7:
        r2.put("cold_start", r4);     // Catch: JSONException -> L29
        if (this.i == true) goto L11;
        r5 = 0;
    L11:
        r2.put("config_updated", r5);     // Catch: JSONException -> L29
        if (TextUtils.isEmpty(this.j) == true) goto L15;
        r2.put("config", this.j);     // Catch: JSONException -> L29
    L15:
        if (TextUtils.isEmpty(this.k) == true) goto L17;
        r2.put("canary", this.k);     // Catch: JSONException -> L29
    L17:
        r2.put("local_probe_version", this.u);     // Catch: JSONException -> L29
        String r3 = AppConfig.getInstance(this.q).getTncRules();     // Catch: JSONException -> L29
        if (TextUtils.isEmpty(r3) == true) goto L20;
        r2.put("rules", r3);     // Catch: JSONException -> L29
    L20:
        b r6 = this.r;     // Catch: JSONException -> L29
        if (r6 != null) goto L23;
    L27:
        r1.put("data", r2);     // Catch: JSONException -> L29
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L29
        r7.put("version", this.t);     // Catch: JSONException -> L29
        r7.put("cmd", this.s);     // Catch: JSONException -> L29
        r7.put("send_time", this.d);     // Catch: JSONException -> L29
        r7.put("get_time", this.e);     // Catch: JSONException -> L29
        r1.put("probe", r7);     // Catch: JSONException -> L29
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L29
        r8.put("probe_version", this.u);     // Catch: JSONException -> L29
        r8.put(AILabCheckPermissionTask.KEY_SOURCE, this.f.mValue);     // Catch: JSONException -> L29
        r8.put("start_time", this.l);     // Catch: JSONException -> L29
        r1.put(Ext.KEY_REQUEST, r8);     // Catch: JSONException -> L29
    L31:
        return r1;
    L23:
        if (TextUtils.isEmpty(r6.b()) == true) goto L27;
        if (TextUtils.isEmpty(this.r.c()) == true) goto L27;
        r2.put(Api.KEY_REGION, this.r.b());     // Catch: JSONException -> L29
        r2.put("region_source", this.r.c());     // Catch: JSONException -> L29
        goto L27
    L6:
        r4 = 0;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    }

    public synchronized void a(Context r3, boolean r4) {
        monitor-enter(this);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (this.p == true) goto L12;
        this.q = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        this.B = r4;     // Catch: Throwable -> L14
        this.r = new b(r5, r4);     // Catch: Throwable -> L14
        if (r4 == false) goto L9;
        g();     // Catch: Throwable -> L14
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("TNCManager", "initTnc, isMainProc: " + r4 + " probeCmd: " + this.s + " probeVersion: " + this.t);     // Catch: Throwable -> L14
    L11:
        this.p = true;     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.c
    public synchronized void a(Request r7, Exception r8) {
        monitor-enter(this);
        if (r7 == null) goto L69;
        if (r8 == null) goto L69;
    L66:
        th = move-exception;
        throw th;
    L7:
        if (this.B == true) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (NetworkUtils.b(this.q) == true) goto L14;
        monitor-exit(this);
        return;
    L14:
        HttpUrl r9 = r7.url();     // Catch: Throwable -> L66
        String r0 = r9.scheme();     // Catch: Throwable -> L66
        String r1 = r9.host();     // Catch: Throwable -> L66
        String r10 = r9.encodedPath();     // Catch: Throwable -> L66
        String r11 = a(r8);     // Catch: Throwable -> L66
        if ("http".equals(r0) == true) goto L21;
        if (LocationInfoConst.HTTPS.equals(r0) == true) goto L21;
        monitor-exit(this);
        return;
    L21:
        if (TextUtils.isEmpty(r1) == false) goto L25;
        monitor-exit(this);
        return;
    L25:
        if (TextUtils.isEmpty(r11) == false) goto L27;
    L64:
        monitor-exit(this);
        return;
    L27:
        if (r11.contains(LocationMonitorConst.TIMEOUT) == false) goto L64;
        if (r11.contains("time out") == false) goto L64;
        if (r11.contains("unreachable") == true) goto L64;
        com.bytedance.ttnet.tnc.a r2 = d();     // Catch: Throwable -> L66
        if (r2 != null) goto L36;
    L62:
        monitor-exit(this);
        return;
    L36:
        if (r2.f3320a == false) goto L62;
        if (r2.c != null) goto L41;
    L60:
        monitor-exit(this);
        return;
    L41:
        if (r2.c.size() <= 0) goto L60;
        if (r2.c.containsKey(r1) == false) goto L60;
        if (Logger.debug() == false) goto L48;
        Logger.d("TNCManager", "onOk3Timeout, url matched: " + r0 + "://" + r1 + "#" + r11 + " " + this.v + "#" + this.w.size() + "#" + this.x.size() + " " + this.y + "#" + this.z.size() + "#" + this.A.size());     // Catch: Throwable -> L66
    L48:
        this.v++;     // Catch: Throwable -> L66
        this.w.put(r10, 0);     // Catch: Throwable -> L66
        this.x.put(r1, 0);     // Catch: Throwable -> L66
        if (this.v >= r2.d) goto L51;
    L58:
        monitor-exit(this);
        return;
    L51:
        if (this.w.size() < r2.e) goto L58;
        if (this.x.size() < r2.f) goto L58;
        if (Logger.debug() == false) goto L57;
        Logger.d("TNCManager", "onOk3Timeout, url doUpate: " + r0 + "://" + r1);     // Catch: Throwable -> L66
    L57:
        a(false, 0, TNCUpdateSource.TTERROR);     // Catch: Throwable -> L66
        h();     // Catch: Throwable -> L66
    L69:
        monitor-exit(this);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.c
    public synchronized void a(Request r7, Response r8) {
        monitor-enter(this);
        if (r7 == null) goto L80;
        if (r8 == null) goto L80;
    L77:
        th = move-exception;
        throw th;
    L7:
        if (this.B == true) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (NetworkUtils.b(this.q) == true) goto L14;
        monitor-exit(this);
        return;
    L14:
        HttpUrl r9 = r7.url();     // Catch: Throwable -> L77
        String r0 = r9.scheme();     // Catch: Throwable -> L77
        String r1 = r9.host();     // Catch: Throwable -> L77
        String r10 = r9.encodedPath();     // Catch: Throwable -> L77
        int r2 = r8.code();     // Catch: Throwable -> L77
        if ("http".equals(r0) == true) goto L21;
        if (LocationInfoConst.HTTPS.equals(r0) == true) goto L21;
        monitor-exit(this);
        return;
    L21:
        if (TextUtils.isEmpty(r1) == false) goto L25;
        monitor-exit(this);
        return;
    L25:
        if (r8.networkResponse() != null) goto L29;
        monitor-exit(this);
        return;
    L29:
        if (Logger.debug() == false) goto L31;
        Logger.d("TNCManager", "onOk3Response, url: " + r0 + "://" + r1 + "#" + r2);     // Catch: Throwable -> L77
    L31:
        com.bytedance.ttnet.tnc.a r3 = d();     // Catch: Throwable -> L77
        if (r3 != null) goto L34;
    L36:
        if (r3 != null) goto L38;
    L75:
        monitor-exit(this);
        return;
    L38:
        if (r3.f3320a == false) goto L75;
        if (r3.c != null) goto L43;
    L73:
        monitor-exit(this);
        return;
    L43:
        if (r3.c.size() <= 0) goto L73;
        if (r3.c.containsKey(r1) == false) goto L73;
        if (Logger.debug() == false) goto L50;
        Logger.d("TNCManager", "onOk3Response, url matched: " + r0 + "://" + r1 + "#" + r2 + " " + this.v + "#" + this.w.size() + "#" + this.x.size() + " " + this.y + "#" + this.z.size() + "#" + this.A.size());     // Catch: Throwable -> L77
    L50:
        if (r2 > 0) goto L52;
    L71:
        monitor-exit(this);
        return;
    L52:
        if (a(r2) == false) goto L59;
        if (this.v <= 0) goto L56;
    L57:
        h();     // Catch: Throwable -> L77
        goto L71
    L56:
        if (this.y <= 0) goto L71;
    L59:
        if (b(r2) == true) goto L71;
        this.y++;     // Catch: Throwable -> L77
        this.z.put(r10, 0);     // Catch: Throwable -> L77
        this.A.put(r1, 0);     // Catch: Throwable -> L77
        if (this.y < r3.g) goto L71;
        if (this.z.size() < r3.h) goto L71;
        if (this.A.size() < r3.i) goto L71;
        if (Logger.debug() == false) goto L69;
        Logger.d("TNCManager", "onOk3Response, url doUpdate: " + r0 + "://" + r1 + "#" + r2);     // Catch: Throwable -> L77
    L69:
        a(false, 0, TNCUpdateSource.TTERROR);     // Catch: Throwable -> L77
        goto L57
    L34:
        if (r3.f3321b == false) goto L36;
        a(r8, r1);     // Catch: Throwable -> L77
    L80:
        monitor-exit(this);
    }

    public boolean a(Context r26, boolean r27, TNCUpdateSource r28, String r29) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r26, Context.class, "com.obric.memorydata.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.d("TNCManager", "getdomain internal, use retrofit okhttp: " + r27 + ", tnc source: " + r28);
    L5:
        ArrayList r0 = new ArrayList();
        if (AppConfig.getInstance(r13).getTncHostArrays() != null) goto L8;
    L15:
        r0.addAll(Arrays.asList(AppConfig.getInstance(r13).getConfigServers()));
    L16:
        this.f = r28;
        this.l = System.currentTimeMillis();
        Iterator r15 = r0.iterator();
    L18:
        if (r15.hasNext() == false) goto L92;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = new StringBuilder();
        r3.append(ReportConsts.HTTPS).append(r1).append("/get_domains/v5/");
        j r4 = new j(r3.toString());
        if (Build.VERSION.SDK_INT >= 21) goto L23;
        String r2 = Build.CPU_ABI;     // Catch: Throwable -> L29
    L24:
        r4.a("abi", r2);     // Catch: Throwable -> L29
        r4.a("tnc_src", r28.mValue);     // Catch: Throwable -> L29
        r4.a("okhttp_version", "4.2.243.22-doubao");     // Catch: Throwable -> L29
        if (com.bytedance.frameworks.baselib.network.http.d.b.a().c() == false) goto L27;
        r4.a("use_store_region_cookie", "1");     // Catch: Throwable -> L29
    L27:
        a(r4);     // Catch: Throwable -> L29
    L31:
        HashMap r5 = new HashMap();
        com.bytedance.frameworks.baselib.network.http.d.b.a().a(r5);
        boolean r16 = !TextUtils.isEmpty(com.bytedance.frameworks.baselib.network.http.d.b.a().d());
        if (TextUtils.isEmpty(r29) == true) goto L36;
        r5.put("x-tt-tnc-summary", r29);
    L36:
        if (r27 == false) goto L37;
        r4.a("aid", TTNetInit.getTTNetDepend().h());
        r4.a("device_platform", "android");
        if (TTNetInit.getCronetProvider() == null) goto L53;
        r4.a("version_code", TTNetInit.getCronetProvider().getVersionCode());
        r4.a("channel", TTNetInit.getCronetProvider().getChannel());
    L53:
        ArrayList r6 = new ArrayList();
        Iterator<Map.Entry<String, String>> r7 = r5.entrySet().iterator();
    L55:
        if (r7.hasNext() == false) goto L61;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r8.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L55;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r8.getValue(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L55;
        r6.add(new Header((String) ZeusTransformUtils.preCheckCast(r8.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r8.getValue(), String.class, "com.obric.memorydata.plugin")));
        goto L55
    L61:
        String r9 = r4.toString();
        LinkedHashMap r10 = new LinkedHashMap();
        Pair<String, String> r11 = k.a(r9, r10);     // Catch: IOException -> L90
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.first, String.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L90
        String r21 = (String) ZeusTransformUtils.preCheckCast(r11.second, String.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L90
        INetworkApi r18 = (INetworkApi) ZeusTransformUtils.preCheckCast(RetrofitUtils.a(r12, INetworkApi.class), INetworkApi.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L18;
        Call<String> r19 = r18.doGet(true, -1, r21, r10, r6, null);
        SsResponse<String> r14 = r19.execute();     // Catch: Throwable -> L81
        List<Header> r17 = r14.headers();     // Catch: Throwable -> L81
        String r20 = (String) ZeusTransformUtils.preCheckCast(r14.body(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L81
        if (this.C != null) goto L70;
    L74:
        String r22 = RetrofitUtils.a(r17, "x-ss-etag");     // Catch: Throwable -> L81
        String r23 = RetrofitUtils.a(r17, "x-tt-tnc-abtest");     // Catch: Throwable -> L81
        String r24 = RetrofitUtils.a(r17, "x-tt-tnc-control");     // Catch: Throwable -> L81
        this.j = RetrofitUtils.a(r17, "x-tt-tnc-config");     // Catch: Throwable -> L81
        this.k = RetrofitUtils.a(r17, "x-ss-canary");     // Catch: Throwable -> L81
        if (c().a(r13, r28, r20, r24, r22, r23, r16) == true) goto L78;
        if (r19 == null) goto L18;
    L77:
        r19.cancel();
        goto L18
    L78:
        if (r19 == null) goto L80;
        r19.cancel();
    L80:
        return true;
    L70:
        if (this.C.b(HttpMethodContrants.GET, r19.request().getUrl(), r17, r20) == true) goto L74;
        if (r19 == null) goto L73;
        r19.cancel();
    L73:
        return false;
    L81:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L85
        if (r19 == null) goto L18;
    L85:
        th = move-exception;
        if (r19 == null) goto L135;
        r19.cancel();
        throw th;
    L135:
        throw th;
    L90:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L37:
        com.bytedance.ttnet.b.a r25 = new com.bytedance.ttnet.b.a();
        r25.f3205b = r4.toString();
        r25.f = true;
        long r30 = System.currentTimeMillis();
    L48:
        th = move-exception;
        th.printStackTrace();
        goto L18
    L39:
        if (a(HttpMethodContrants.GET, r25.f3205b, r5, "") == false) goto L40;
        HashMap r31 = new HashMap();     // Catch: Throwable -> L48
        String r32 = com.bytedance.ttnet.b.c.a(r25.f3205b, r5, r31, r25);     // Catch: Throwable -> L48
        if (b(HttpMethodContrants.GET, r25.f3205b, r31, r32) == false) goto L43;
        r25.c = System.currentTimeMillis() - r30;     // Catch: Throwable -> L48
        this.k = r25.n;     // Catch: Throwable -> L48
        this.j = r25.m;     // Catch: Throwable -> L48
        if (c().a(r13, r28, r32, r25.l, r25.h, r25.i, r16) == false) goto L18;
        return true;
    L43:
        return false;
    L40:
        return false;
    L23:
        r2 = Build.SUPPORTED_ABIS[0];     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        th.printStackTrace();
        goto L31
    L92:
        return false;
    L8:
        if (AppConfig.getInstance(r13).getTncHostArrays().size() == 0) goto L15;
        r0.addAll(AppConfig.getInstance(r13).getTncHostArrays());
        String[] r33 = AppConfig.getInstance(r13).getConfigServers();
        int r34 = r33.length;
        int r35 = 0;
    L10:
        if (r35 >= r34) goto L16;
        String r36 = r33[r35];
        if (r0.contains(r36) == true) goto L14;
        r0.add(r36);
    L14:
        r35 = r35 + 1;
        goto L10
    }

    public boolean a(String r3, String r4, Map<String, String> r5, String r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (this.C != null) goto L6;
        return true;
    L6:
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        List<Header> r8 = b(r7);
        return this.C.a(r3, r4, r8, r6);
    }

    public boolean a(JSONObject r12, String r13, String r14, boolean r15) {
        if (Logger.debug() == false) goto L6;
        Logger.d("TNCManager", "data: " + r12 + " etag: " + r13 + " tncAttr: " + r14 + " needUpdateTnc: " + r15);
    L6:
        if (r12 == null) goto L13;
        b r2 = this.r;
        if (r2 == null) goto L10;
        r2.a("");
        boolean r16 = this.r.a(r12, TNCUpdateSource.TTSERVER, r13, r14, System.currentTimeMillis());
    L11:
        if (r16 == false) goto L14;
        com.bytedance.frameworks.baselib.network.http.d.b.a().b();
    L14:
        if (r15 == false) goto L18;
        if (r16 == true) goto L18;
        Logger.d("TNCManager", "doUpdateRemote tnc");
        a(true, TNCUpdateSource.TTREGION);
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

    public boolean b(String r3, String r4, Map<String, List<String>> r5, String r6) {
        Map<String, List<String>> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (this.C != null) goto L6;
        return true;
    L6:
        List<Header> r8 = a(r7);
        return this.C.b(r3, r4, r8, r6);
    }

    public com.bytedance.ttnet.tnc.a d() {
        b r0 = this.r;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a();
    }

    public b e() {
        return this.r;
    }

    public void f() {
        if (d() != null) goto L5;
        return;
    L5:
        if (g.b(this.q) == true) goto L7;
        return;
    L7:
        if (this.m.compareAndSet(false, true) == false) goto L12;
        a(true, 0, TNCUpdateSource.TTCRONETFAILED);
        return;
    }
}
