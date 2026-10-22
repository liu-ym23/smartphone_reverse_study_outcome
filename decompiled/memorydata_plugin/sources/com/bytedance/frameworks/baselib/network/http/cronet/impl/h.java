package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h extends com.bytedance.frameworks.baselib.network.http.a implements ICronetClient.ICronetBootFailureCheckerProvider, ICronetClient.ICronetThreadStackOptFailureCheckerProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2422a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f2423b = 0;
    private static Context c = null;
    private static ICronetClient d = null;
    private static volatile h e = null;
    private static volatile boolean f = true;
    private static volatile String g;
    private static volatile String h;
    private static ConcurrentHashMap<String, Integer> i;
    private static Map<String, Integer> j;
    private static volatile ICronetAppProvider k;
    private static a l;
    private static b m;
    private static c n;
    private static d o;

    public interface a {
        boolean isCronetBootFailureExpected();
    }

    public interface b {
        boolean isCronetHttpDnsOpen();
    }

    public interface c {
        boolean a();

        String b();
    }

    public interface d {
        JSONObject getABTest();
    }

    static {
        i = new ConcurrentHashMap();
        j = new ConcurrentHashMap();
    }

    private h(Context r3) {
        c = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    public static int a(String r2, int r3) {
        if (c(r3) == true) goto L7;
        r3 = 0;
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return r3;
    L10:
        if (i.containsKey(r2) == false) goto L16;
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(i.get(r2), Integer.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L14;
        r3 = 0;
        goto L16
    L14:
        r3 = r4.intValue();
    L16:
        if (c(r3) == true) goto L18;
        return 0;
    L18:
        return r3;
    }

    public static int a(String r2, com.bytedance.frameworks.baselib.network.http.b r3) {
        if (a(f2423b) == false) goto L7;
        return f2423b;
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L9;
    L18:
        if (r3 != null) goto L20;
        return 0;
    L20:
        if (r3.c != 0) goto L22;
        return 0;
    L22:
        if (a(r3.c.o) == true) goto L28;
        if (r3.c.p == true) goto L26;
        return 0;
    L26:
        if (b(r3.c.o) == true) goto L28;
        return 0;
    L28:
        return r3.c.o;
    L9:
        if (j.isEmpty() == true) goto L18;
        if (j.containsKey(r2) == false) goto L18;
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(j.get(r2), Integer.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L18;
        if (a(r4.intValue()) == false) goto L18;
        return r4.intValue();
    }

    public static int a(HttpURLConnection r1) {
        return d.getCronetInternalErrorCode(r1);
    }

    public static TTDispatchResult a(String r1, int r2, boolean r3) {
        i();
        return d.ttUrlDispatch(r1, r2, r3);
    }

    public static d a() {
        return o;
    }

    public static h a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (e != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new h(r3);     // Catch: Throwable -> L11
        h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return e;
    }

    public static void a(SharedPreferences.Editor r2) {
        SharedPreferences.Editor r3 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        r3.putInt("cronet_inputstream_buff_size", f2423b);
        if (g == null) goto L6;
        r3.putString("post_body_buffer_size", g);
    L6:
        if (h == null) goto L9;
        r3.putString("path_cronet_inputstream_buff_size", h);
        return;
    }

    public static void a(ICronetAppProvider r2) {
        k = (ICronetAppProvider) ZeusTransformUtils.wrapperContextForParams(r2, ICronetAppProvider.class, "com.obric.memorydata.plugin");
    }

    public static void a(a r2) {
        l = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
    }

    public static void a(b r2) {
        m = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
    }

    public static void a(c r2) {
        n = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
    }

    public static void a(d r2) {
        o = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
    }

    public static void a(String r1, String r2) {
        i();
        d.setBestHostWithRouteSelectionName(r1, r2);
    }

    public static void a(String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22) {
        i();
        d.notifyStoreRegionUpdated(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public static void a(JSONObject r7, SharedPreferences r8) {
        SharedPreferences r9 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r8, SharedPreferences.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L18;
        f2423b = r7.optInt("cronet_inputstream_buff_size", 0);
        JSONObject r5 = r7.optJSONObject("post_body_buffer_size");     // Catch: Throwable -> L26
        if (r5 == null) goto L8;
        b(r5);     // Catch: Throwable -> L26
        g = r5.toString();     // Catch: Throwable -> L26
    L9:
        JSONObject r10 = r7.optJSONObject("path_cronet_inputstream_buff_size");     // Catch: Throwable -> L26
        if (r10 == null) goto L17;
        String r6 = r10.toString();     // Catch: Throwable -> L26
        if (h != null) goto L14;
    L16:
        c(r10);     // Catch: Throwable -> L26
        h = r6;     // Catch: Throwable -> L26
        goto L18
    L14:
        if (r6.equals(h) == false) goto L16;
        return;
    L17:
        j.clear();     // Catch: Throwable -> L26
        h = "";     // Catch: Throwable -> L26
        goto L18
    L8:
        i.clear();     // Catch: Throwable -> L26
        g = "";     // Catch: Throwable -> L26
    L18:
        if (r9 == null) goto L34;
        f2423b = r9.getInt("cronet_inputstream_buff_size", 0);
        String r11 = r9.getString("post_body_buffer_size", "");
        if (TextUtils.isEmpty(r11) == false) goto L29;
    L22:
        String r12 = r9.getString("path_cronet_inputstream_buff_size", "");
        if (TextUtils.isEmpty(r12) == true) goto L35;
        c(new JSONObject(r12));     // Catch: Throwable -> L28
        return;
    L36:
        return;
    L35:
        return;
    L29:
        b(new JSONObject(r11));     // Catch: Throwable -> L27
        goto L22
    }

    public static void a(boolean r0) {
        f = r0;
    }

    public static boolean a(int r1) {
        if (r1 >= 8192) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 20971520) goto L7;
        return true;
    }

    public static HttpURLConnection b(String r9, com.bytedance.frameworks.baselib.network.http.b r10) {
        h();
        ICronetClient r0 = d;
        if (r0 == null) goto L11;
        r0.setCronetBootFailureCheckerProvider(e);
        d.setCronetThreadStackOptFailureCheckerProvider(e);
        ICronetClient r2 = d;
        Context r3 = c;
        b r1 = m;
        if (r1 != null) goto L7;
        boolean r4 = false;
    L9:
        return r2.openConnection(r3, r9, r4, com.bytedance.frameworks.baselib.network.http.f.l(), r10, k);
    L7:
        r4 = r1.isCronetHttpDnsOpen();
        goto L9
    L11:
        throw new IllegalArgumentException("CronetClient is null");
    }

    private static void b(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        i.clear();
        Iterator<String> r0 = r4.keys();
    L6:
        if (r0.hasNext() == false) goto L12;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        int r2 = r4.optInt(r1);
        if (TextUtils.isEmpty(r1) == true) goto L6;
        if (c(r2) == false) goto L6;
        i.put(r1, Integer.valueOf(r2));
        goto L6
    }

    public static boolean b() {
        return f;
    }

    public static boolean b(int r1) {
        if (r1 > 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 > 20971520) goto L6;
        return true;
    }

    public static String c() {
        i();
        return d.getCronetVersion();
    }

    private static void c(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        j.clear();
        Iterator<String> r0 = r4.keys();
    L6:
        if (r0.hasNext() == false) goto L13;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r1) == true) goto L6;
        int r2 = r4.optInt(r1);
        if (b(r2) == false) goto L6;
        j.put(r1, Integer.valueOf(r2));
        goto L6
    }

    public static boolean c(int r1) {
        if (r1 >= 16384) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 10485760) goto L7;
        return true;
    }

    public static Context getContext() {
        return c;
    }

    private static void h() {
        if (d == null) goto L5;
        return;
    L5:
        if (com.bytedance.common.utility.h.a(f2422a) == true) goto L7;
        String r1 = f2422a;
    L8:
        Logger.w("SsCronetHttpClient", "tryResolveImpl:" + r1);
        Object r2 = ZeusTransformUtils.forName(r1, "com.obric.memorydata.plugin").newInstance();     // Catch: Throwable -> L13
        if (ZeusTransformUtils.instanceOf(r2, ICronetClient.class) == false) goto L19;
        d = (ICronetClient) ZeusTransformUtils.preCheckCast(r2, ICronetClient.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L13:
        th = move-exception;
        Logger.w("SsCronetHttpClient", "load CronetClient exception: " + th);
        return;
    L7:
        r1 = "org.chromium.CronetClient";
        goto L8
    }

    private static void i() {
        if (d == null) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public Request a(Request r3) {
        TypedOutput r2 = r3.getBody();
        if (ZeusTransformUtils.instanceOf(r2, FormUrlEncodedTypedOutput.class) == true) goto L5;
        return r3;
    L5:
        FormUrlEncodedTypedOutput r4 = (FormUrlEncodedTypedOutput) ZeusTransformUtils.preCheckCast(r2, FormUrlEncodedTypedOutput.class, "com.obric.memorydata.plugin");
        r4.useFormBodyModifyHookAndConstructStream(r3);
        return r3.newBuilder().post(r4).build();
    }

    public void a(long r1) {
        i();
        d.setAlogFuncAddr(r1);
    }

    public void a(long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32) {
        i();
        d.setZstdFuncAddr(r18, r20, r22, r24, r26, r28, r30, r32);
    }

    public void a(String r2, int r3, String r4, Map<String, String> r5) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        i();
        d.ttDnsResolve(r2, r3, r4, r1);
    }

    public void a(String r8, String r9, String r10, String r11, String r12, String r13) {
        i();
        d.notifyTNCConfigUpdated(r8, r9, r10, r11, r12, r13);
    }

    public void a(String r2, Map<String, String> r3) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        i();
        d.preconnectUrl(r2, r1);
    }

    public void a(String r1, boolean r2) {
        if (d != null) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
    L9:
        d.removeClientOpaqueData(r1);
        return;
    L7:
        if (com.bytedance.frameworks.baselib.network.http.util.g.b(c) == true) goto L9;
    }

    public void a(JSONObject r1) {
        i();
        d.setSlaSamplingSetting(r1);
    }

    public void a(boolean r8, String r9, String r10, String r11, boolean r12, String r13) {
        i();
        d.enableTTBizHttpDns(r8, r9, r10, r11, r12, r13);
    }

    public void a(boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, ICronetAppProvider r15) {
        ICronetAppProvider r8 = (ICronetAppProvider) ZeusTransformUtils.wrapperContextForParams(r15, ICronetAppProvider.class, "com.obric.memorydata.plugin");
        h();
        ICronetClient r16 = d;
        if (r16 == null) goto L6;
        r16.setCronetBootFailureCheckerProvider(this);
        d.setCronetThreadStackOptFailureCheckerProvider(this);
        d.tryCreateCronetEngine(c, r10, r11, r12, r13, com.bytedance.frameworks.baselib.network.http.f.l(), r14, r8);
        return;
    }

    public void a(String[] r1, int r2) {
        i();
        d.stopThrottle(r1, r2);
    }

    public void a(String[] r1, int r2, int r3) {
        i();
        d.tryStartNetDetect(r1, r2, r3);
    }

    public void a(String[] r1, int r2, long r3) {
        i();
        d.startThrottle(r1, r2, r3);
    }

    public void a(String[] r10, byte[] r11, byte[] r12, long r13, long r15, boolean r17) {
        if (d != null) goto L5;
        return;
    L5:
        if (r17 == false) goto L7;
    L9:
        d.addClientOpaqueData(r10, r11, r12, r13, r15);
        return;
    L7:
        if (com.bytedance.frameworks.baselib.network.http.util.g.b(c) == true) goto L9;
    }

    public void b(String r1) {
        i();
        d.getMappingRequestState(r1);
    }

    public void b(boolean r1) {
        if (d != null) goto L6;
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.util.g.b(c) == true) goto L8;
        return;
    L8:
        d.triggerGetDomain(r1);
    }

    public void c(String r1) {
        i();
        d.setProxy(r1);
    }

    public void c(boolean r1) {
        if (d != null) goto L6;
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.util.g.b(c) == true) goto L8;
        return;
    L8:
        d.runInBackGround(r1);
    }

    public int d() {
        i();
        return d.getEffectiveConnectionType();
    }

    public g d(int r1) {
        i();
        return d.getPacketLossRateMetrics(r1);
    }

    public void d(String r1) {
        i();
        d.setHostResolverRules(r1);
    }

    public void d(boolean r1) {
        if (d != null) goto L5;
        return;
    L5:
        if (r1 == false) goto L7;
    L9:
        d.clearClientOpaqueData();
        return;
    L7:
        if (com.bytedance.frameworks.baselib.network.http.util.g.b(c) == true) goto L9;
    }

    public f e() {
        i();
        return d.getNetworkQuality();
    }

    public void e(String r1) {
        i();
        d.reportNetDiagnosisUserLog(r1);
    }

    public Map<String, f> f() {
        i();
        return d.getGroupRttEstimates();
    }

    public void g() {
        i();
        d.setCookieInitCompleted();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetThreadStackOptFailureCheckerProvider
    public String getThreadStackInitReason() {
        c r0 = n;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetBootFailureCheckerProvider
    public boolean isCronetBootFailureExpected() {
        a r0 = l;
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.isCronetBootFailureExpected();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetThreadStackOptFailureCheckerProvider
    public boolean isCronetThreadStackOptFailureExpected() {
        c r0 = n;
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.a();
    }

    @Override // com.bytedance.retrofit2.client.Client
    public SsCall newSsCall(Request r3) {
        Request r2 = a(r3);
        Request r4 = com.bytedance.frameworks.baselib.network.c.d.a().a(r2);
        if (r4 == null) goto L6;
        r2 = r4;
    L6:
        if (e.a().b() == false) goto L18;
        if (r2.getUrl().contains("no_retry=1") == true) goto L18;
        e.a r5 = e.a().a(r2);
        if (r5 == null) goto L18;
        if (r5.a() == null) goto L18;
        if (r5.a().size() < 2) goto L18;
        r2.getMetrics().networklib.misc.isConcurrentRequest = true;
        return new com.bytedance.frameworks.baselib.network.http.cronet.impl.b(r2, r5);
    L18:
        return new com.bytedance.frameworks.baselib.network.http.cronet.impl.d(r2);
    }
}
