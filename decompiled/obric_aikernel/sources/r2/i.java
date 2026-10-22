package r2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.TTDispatchResult;
import com.bytedance.retrofit2.RetrofitMetrics;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i extends o2.a implements ICronetClient.ICronetBootFailureCheckerProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f12642c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile int f12643d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Context f12644e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ICronetClient f12645f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile i f12646g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile boolean f12647h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile String f12648i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile String f12649j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static ConcurrentHashMap<String, Integer> f12650k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Map<String, Integer> f12651l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static volatile ICronetAppProvider f12652m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static a f12653n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static b f12654o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static c f12655p;

    public interface a {
        boolean isCronetBootFailureExpected();
    }

    public interface b {
        boolean h();
    }

    public interface c {
        JSONObject j();
    }

    static {
        f12650k = new ConcurrentHashMap();
        f12651l = new ConcurrentHashMap();
    }

    private i(Context r10) {
        f12644e = r10.getApplicationContext();
    }

    public static void A(String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22) {
        g();
        f12645f.notifyStoreRegionUpdated(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public static void D(SharedPreferences.Editor r10) {
        r10.putInt("cronet_inputstream_buff_size", f12643d);
        if (f12648i == null) goto L6;
        r10.putString("post_body_buffer_size", f12648i);
    L6:
        if (f12649j == null) goto L9;
        r10.putString("path_cronet_inputstream_buff_size", f12649j);
        return;
    }

    protected static HttpURLConnection E(String r10, o2.b r11) {
        a0();
        ICronetClient r12 = f12645f;
        if (r12 == null) goto L11;
        r12.setCronetBootFailureCheckerProvider(f12646g);
        ICronetClient r13 = f12645f;
        Context r14 = f12644e;
        b r15 = f12654o;
        if (r15 != null) goto L7;
        boolean r16 = false;
    L8:
        HttpURLConnection r17 = r13.openConnection(r14, r10, r16, o2.f.s(), r11.f11395b, new a3.c(), f12652m);
        r17.setConnectTimeout(o2.f.j());
        r17.setReadTimeout(o2.f.p());
        return r17;
    L7:
        r16 = r15.h();
        goto L8
    L11:
        throw new IllegalArgumentException("CronetClient is null");
    }

    public static void K(String r10, String r11) {
        g();
        f12645f.setBestHostWithRouteSelectionName(r10, r11);
    }

    public static void L(boolean r10) {
        f12647h = r10;
    }

    public static void N(ICronetAppProvider r10) {
        f12652m = r10;
    }

    public static void O(a r10) {
        f12653n = r10;
    }

    public static void P(b r10) {
        f12654o = r10;
    }

    public static void Q(c r10) {
        f12655p = r10;
    }

    private static void a0() {
        if (f12645f == null) goto L5;
        return;
    L5:
        if (com.bytedance.common.utility.g.b(f12642c) == true) goto L7;
        String r10 = f12642c;
    L8:
        Logger.w("SsCronetHttpClient", "tryResolveImpl:" + r10);
        Object r11 = Class.forName(r10).newInstance();     // Catch: Throwable -> L13
        if ((r11 instanceof ICronetClient) == false) goto L19;
        f12645f = (ICronetClient) r11;     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L13:
        th = move-exception;
        Logger.w("SsCronetHttpClient", "load CronetClient exception: " + th);
        return;
    L7:
        r10 = "org.chromium.CronetClient";
        goto L8
    }

    public static void c0(JSONObject r10, SharedPreferences r11) {
        if (r10 == null) goto L18;
        f12643d = r10.optInt("cronet_inputstream_buff_size", 0);
        JSONObject r12 = r10.optJSONObject("post_body_buffer_size");     // Catch: Throwable -> L26
        if (r12 == null) goto L8;
        g0(r12);     // Catch: Throwable -> L26
        f12648i = r12.toString();     // Catch: Throwable -> L26
    L9:
        JSONObject r13 = r10.optJSONObject("path_cronet_inputstream_buff_size");     // Catch: Throwable -> L26
        if (r13 == null) goto L17;
        String r14 = r13.toString();     // Catch: Throwable -> L26
        if (f12649j != null) goto L14;
    L16:
        f0(r13);     // Catch: Throwable -> L26
        f12649j = r14;     // Catch: Throwable -> L26
        goto L18
    L14:
        if (r14.equals(f12649j) == false) goto L16;
        return;
    L17:
        f12651l.clear();     // Catch: Throwable -> L26
        f12649j = "";     // Catch: Throwable -> L26
        goto L18
    L8:
        f12650k.clear();     // Catch: Throwable -> L26
        f12648i = "";     // Catch: Throwable -> L26
    L18:
        if (r11 == null) goto L34;
        f12643d = r11.getInt("cronet_inputstream_buff_size", 0);
        String r15 = r11.getString("post_body_buffer_size", "");
        if (TextUtils.isEmpty(r15) == false) goto L29;
    L22:
        String r16 = r11.getString("path_cronet_inputstream_buff_size", "");
        if (TextUtils.isEmpty(r16) == true) goto L35;
        f0(new JSONObject(r16));     // Catch: Throwable -> L28
        return;
    L36:
        return;
    L35:
        return;
    L29:
        g0(new JSONObject(r15));     // Catch: Throwable -> L27
        goto L22
    }

    public static TTDispatchResult e0(String r10, int r11, boolean r12) {
        g();
        return f12645f.ttUrlDispatch(r10, r11, r12);
    }

    private static void f0(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        f12651l.clear();
        Iterator<String> r11 = r10.keys();
    L6:
        if (r11.hasNext() == false) goto L13;
        String r12 = r11.next();
        if (TextUtils.isEmpty(r12) == true) goto L6;
        int r13 = r10.optInt(r12);
        if (y(r13) == false) goto L6;
        f12651l.put(r12, Integer.valueOf(r13));
        goto L6
    }

    private static void g() {
        if (f12645f == null) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    private static void g0(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        f12650k.clear();
        Iterator<String> r11 = r10.keys();
    L6:
        if (r11.hasNext() == false) goto L12;
        String r12 = r11.next();
        int r13 = r10.optInt(r12);
        if (TextUtils.isEmpty(r12) == true) goto L6;
        if (z(r13) == false) goto L6;
        f12650k.put(r12, Integer.valueOf(r13));
        goto L6
    }

    public static Context j() {
        return f12644e;
    }

    protected static int k(String r10, o2.b r11) {
        if (x(f12643d) == false) goto L7;
        return f12643d;
    L7:
        if (TextUtils.isEmpty(r10) == false) goto L9;
    L18:
        if (r11 == null) goto L29;
        T r12 = r11.f11398e;
        if (r12 != 0) goto L22;
        return 0;
    L22:
        if (x(r12.f11435p) == true) goto L28;
        T r13 = r11.f11398e;
        if (r13.f11436q == true) goto L26;
        return 0;
    L26:
        if (y(r13.f11435p) == true) goto L28;
        return 0;
    L28:
        return r11.f11398e.f11435p;
    L29:
        return 0;
    L9:
        if (f12651l.isEmpty() == true) goto L18;
        if (f12651l.containsKey(r10) == false) goto L18;
        Integer r14 = f12651l.get(r10);
        if (r14 == null) goto L18;
        if (x(r14.intValue()) == false) goto L18;
        return r14.intValue();
    }

    public static int l(HttpURLConnection r10) {
        return f12645f.getCronetInternalErrorCode(r10);
    }

    protected static int m(String r10, int r11) {
        if (z(r11) == true) goto L7;
        r11 = 0;
    L7:
        if (TextUtils.isEmpty(r10) == false) goto L10;
        return r11;
    L10:
        if (f12650k.containsKey(r10) == false) goto L16;
        Integer r12 = f12650k.get(r10);
        if (r12 != null) goto L14;
        r11 = 0;
        goto L16
    L14:
        r11 = r12.intValue();
    L16:
        if (z(r11) == true) goto L18;
        return 0;
    L18:
        return r11;
    }

    public static c n() {
        return f12655p;
    }

    public static String o() {
        g();
        return f12645f.getCronetVersion();
    }

    public static boolean q() {
        return f12647h;
    }

    protected static Map<String, Object> v(HttpURLConnection r10) {
        ICronetClient r11 = f12645f;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.getRequestMetricsMap(r10);
    }

    public static i w(Context r10) {
        if (f12646g != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12646g != null) goto L9;
        f12646g = new i(r10);     // Catch: Throwable -> L11
        a0();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        return f12646g;
    }

    protected static boolean x(int r10) {
        if (r10 >= 8192) goto L5;
    L7:
        return false;
    L5:
        if (r10 > 20971520) goto L7;
        return true;
    }

    protected static boolean y(int r10) {
        if (r10 > 0) goto L4;
    L6:
        return false;
    L4:
        if (r10 > 20971520) goto L6;
        return true;
    }

    protected static boolean z(int r10) {
        if (r10 >= 16384) goto L5;
    L7:
        return false;
    L5:
        if (r10 > 10485760) goto L7;
        return true;
    }

    public boolean B(boolean r10) {
        g();
        return f12645f.notifySwitchToMultiNetwork(r10);
    }

    public void C(String r10, String r11, String r12, String r13, String r14, String r15) {
        g();
        f12645f.notifyTNCConfigUpdated(r10, r11, r12, r13, r14, r15);
    }

    public void F(String r10, Map<String, String> r11) {
        g();
        f12645f.preconnectUrl(r10, r11);
    }

    public void G(String r10, boolean r11) {
        if (f12645f != null) goto L5;
        return;
    L5:
        if (r11 == false) goto L7;
    L9:
        f12645f.removeClientOpaqueData(r10);
        return;
    L7:
        if (com.bytedance.frameworks.baselib.network.http.util.g.h(f12644e) == true) goto L9;
    }

    public void H(String r10) {
        g();
        f12645f.reportNetDiagnosisUserLog(r10);
    }

    public void I(boolean r10) {
        if (f12645f != null) goto L6;
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.util.g.h(f12644e) == true) goto L8;
        return;
    L8:
        f12645f.runInBackGround(r10);
    }

    public void J(long r10) {
        g();
        f12645f.setAlogFuncAddr(r10);
    }

    public void M() {
        g();
        f12645f.setCookieInitCompleted();
    }

    public void R(String r10) {
        g();
        f12645f.setHostResolverRules(r10);
    }

    public void S(String r10) {
        g();
        f12645f.setProxy(r10);
    }

    public void T(JSONObject r10) {
        g();
        f12645f.setSlaSamplingSetting(r10);
    }

    public void U(long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32) {
        g();
        f12645f.setZstdFuncAddr(r18, r20, r22, r24, r26, r28, r30, r32);
    }

    public void V(String[] r10, int r11, long r12) {
        g();
        f12645f.startThrottle(r10, r11, r12);
    }

    public void W(String[] r10, int r11) {
        g();
        f12645f.stopThrottle(r10, r11);
    }

    public void X(boolean r10) {
        if (f12645f != null) goto L6;
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.util.g.h(f12644e) == true) goto L8;
        return;
    L8:
        f12645f.triggerGetDomain(r10);
    }

    public void Y() {
        g();
        f12645f.triggerSwitchingToCellular();
    }

    public void Z(boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, ICronetAppProvider r17) {
        a0();
        ICronetClient r10 = f12645f;
        if (r10 == null) goto L6;
        r10.setCronetBootFailureCheckerProvider(this);
        f12645f.tryCreateCronetEngine(f12644e, r12, r13, r14, r15, o2.f.s(), new a3.c(), r16, r17);
        return;
    }

    @Override // n4.a
    public n4.e a(n4.c r10) {
        long r11 = SystemClock.uptimeMillis();
        n4.c r12 = d3.d.f().e(r10);
        if (r10.z() == null) goto L5;
        RetrofitMetrics r13 = r10.z();
        r13.f2438g0 = SystemClock.uptimeMillis() - r11;
    L5:
        if (r12 == null) goto L8;
        r10 = r12;
    L8:
        if (f.d().e() == false) goto L20;
        if (r10.G().contains("no_retry=1") == true) goto L20;
        f.a r14 = f.d().b(r10);
        if (r14 == null) goto L20;
        if (r14.a() == null) goto L20;
        if (r14.a().size() < 2) goto L20;
        return new d(r10, r14);
    L20:
        return new e(r10);
    }

    public void b0(String[] r10, int r11, int r12) {
        g();
        f12645f.tryStartNetDetect(r10, r11, r12);
    }

    public void d0(String r10, int r11, String r12, Map<String, String> r13) {
        g();
        f12645f.ttDnsResolve(r10, r11, r12, r13);
    }

    public void f(String[] r10, byte[] r11, byte[] r12, long r13, long r15, boolean r17) {
        if (f12645f != null) goto L5;
        return;
    L5:
        if (r17 == false) goto L7;
    L9:
        f12645f.addClientOpaqueData(r10, r11, r12, r13, r15);
        return;
    L7:
        if (com.bytedance.frameworks.baselib.network.http.util.g.h(f12644e) == true) goto L9;
    }

    public void h(boolean r10) {
        if (f12645f != null) goto L5;
        return;
    L5:
        if (r10 == false) goto L7;
    L9:
        f12645f.clearClientOpaqueData();
        return;
    L7:
        if (com.bytedance.frameworks.baselib.network.http.util.g.h(f12644e) == true) goto L9;
    }

    public void i(boolean r10, String r11, String r12, String r13, boolean r14, String r15) {
        g();
        f12645f.enableTTBizHttpDns(r10, r11, r12, r13, r14, r15);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetBootFailureCheckerProvider
    public boolean isCronetBootFailureExpected() {
        a r10 = f12653n;
        if (r10 != null) goto L6;
        return false;
    L6:
        return r10.isCronetBootFailureExpected();
    }

    public int p() {
        g();
        return f12645f.getEffectiveConnectionType();
    }

    public Map<String, g> r() {
        g();
        return f12645f.getGroupRttEstimates();
    }

    public void s(String r10) {
        g();
        f12645f.getMappingRequestState(r10);
    }

    public g t() {
        g();
        return f12645f.getNetworkQuality();
    }

    public h u(int r10) {
        g();
        return f12645f.getPacketLossRateMetrics(r10);
    }
}
