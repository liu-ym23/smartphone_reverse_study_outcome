package x4;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.bytedance.ttnet.TTMultiNetwork;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements ICronetDepend, ICronetAppProvider {

    /* JADX INFO: renamed from: x4.a$a, reason: collision with other inner class name */
    class C0316a extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f13511j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f13512k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ a f13513l;

        C0316a(a r10, String r11, int r12, int r13) {
            this.f13513l = r10;
            this.f13511j = r12;
            this.f13512k = r13;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            this.f13513l.onMultiNetworkStateChanged(this.f13511j, this.f13512k);
        }
    }

    class b extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f13514j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ a f13515k;

        b(a r10, String r11, int r12) {
            this.f13515k = r10;
            this.f13514j = r12;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            this.f13515k.onNetworkQualityLevelChanged(this.f13514j);
        }
    }

    class c extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f13516j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f13517k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ int f13518l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ a f13519m;

        c(a r10, String r11, int r12, int r13, int r14) {
            this.f13519m = r10;
            this.f13516j = r12;
            this.f13517k = r13;
            this.f13518l = r14;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            this.f13519m.onNetworkQualityRttAndThroughputNotified(this.f13516j, this.f13517k, this.f13518l);
        }
    }

    class d extends r1.c {
        d(a r10, String r11) {
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            TTNetInit.notifyColdStartFinish();
        }
    }

    class e extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f13520j;

        e(a r10, String r11, String r12) {
            this.f13520j = r12;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            TTNetInit.onClientIPChanged(this.f13520j);
        }
    }

    class f extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ List f13521j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ List f13522k;

        f(a r10, String r11, List r12, List r13) {
            this.f13521j = r12;
            this.f13522k = r13;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            TTNetInit.onPublicIPsChanged(this.f13521j, this.f13522k);
        }
    }

    class g extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f13523j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f13524k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ String f13525l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f13526m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ String f13527n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final /* synthetic */ String f13528o;

        g(a r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17) {
            this.f13523j = r12;
            this.f13524k = r13;
            this.f13525l = r14;
            this.f13526m = r15;
            this.f13527n = r16;
            this.f13528o = r17;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            x4.b.a().c(this.f13523j, this.f13524k, this.f13525l, this.f13526m, this.f13527n, this.f13528o);
            c3.b.m().q(this.f13523j, this.f13524k, this.f13525l, this.f13526m, this.f13527n, this.f13528o);
        }
    }

    class h extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ boolean f13529j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ List f13530k;

        h(a r10, String r11, boolean r12, List r13) {
            this.f13529j = r12;
            this.f13530k = r13;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            x4.c.a().c(this.f13529j, this.f13530k);
        }
    }

    class i extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ ArrayList f13531j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f13532k;

        i(a r10, String r11, ArrayList r12, String r13) {
            this.f13531j = r12;
            this.f13532k = r13;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            w4.b.a().b(this.f13531j, this.f13532k);
        }
    }

    class j extends r1.c {
        j(a r10, String r11) {
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            w4.a.r(TTNetInit.getTTNetDepend().getContext()).C();
            com.bytedance.ttnet.c.d(true);
        }
    }

    class k extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f13533j;

        k(a r10, String r11, String r12) {
            this.f13533j = r12;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            w4.a.r(TTNetInit.getTTNetDepend().getContext()).E(this.f13533j);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    class l extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f13534j;

        l(a r10, String r11, String r12) {
            this.f13534j = r12;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            w4.a.r(TTNetInit.getTTNetDepend().getContext()).D(this.f13534j);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    class m extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f13535j;

        m(a r10, String r11, String r12) {
            this.f13535j = r12;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            boolean r10 = false;
            w4.e.b r11 = null;
        L12:
            th = move-exception;
            th.printStackTrace();
            return;
        L4:
            if (w4.e.a() == false) goto L8;
            r11 = new w4.e.b(this.f13535j, new JSONObject(this.f13535j));     // Catch: Throwable -> L12
            w4.c.g(r11);     // Catch: Throwable -> L12
            if (w4.c.d() == false) goto L8;
            r10 = true;
        L8:
            if (r10 == false) goto L10;
            w4.a.r(TTNetInit.getTTNetDepend().getContext()).v(this.f13535j, r11);     // Catch: Throwable -> L12
            ClientKeyManager.k().c(r11);     // Catch: Throwable -> L12
            return;
        L10:
            w4.a r12 = w4.a.r(TTNetInit.getTTNetDepend().getContext());     // Catch: Throwable -> L12
            String r13 = this.f13535j;     // Catch: Throwable -> L12
            r12.v(r13, r13);     // Catch: Throwable -> L12
            ClientKeyManager.k().c(this.f13535j);     // Catch: Throwable -> L12
        }
    }

    class n extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f13536j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f13537k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ int f13538l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f13539m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ int f13540n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final /* synthetic */ List f13541o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final /* synthetic */ String f13542p;

        n(a r10, String r11, String r12, String r13, int r14, int r15, int r16, List r17, String r18) {
            this.f13536j = r12;
            this.f13537k = r13;
            this.f13538l = r14;
            this.f13539m = r15;
            this.f13540n = r16;
            this.f13541o = r17;
            this.f13542p = r18;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            b5.a.c().a(this.f13536j, this.f13537k, this.f13538l, this.f13539m, this.f13540n, this.f13541o, this.f13542p);
        }
    }

    class o extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f13543j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ a f13544k;

        o(a r10, String r11, String r12) {
            this.f13544k = r10;
            this.f13543j = r12;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            this.f13544k.d(this.f13543j);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    class p extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f13545j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ a f13546k;

        p(a r10, String r11, int r12) {
            this.f13546k = r10;
            this.f13545j = r12;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            this.f13546k.onEffectiveConnectionTypeChanged(this.f13545j);
            this.f13546k.a(this.f13545j);
        }
    }

    class q extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f13547j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f13548k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ int f13549l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ a f13550m;

        q(a r10, String r11, int r12, int r13, int r14) {
            this.f13550m = r10;
            this.f13547j = r12;
            this.f13548k = r13;
            this.f13549l = r14;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            this.f13550m.onRTTOrThroughputEstimatesComputed(this.f13547j, this.f13548k, this.f13549l);
            this.f13550m.c(this.f13547j, this.f13548k, this.f13549l);
        }
    }

    class r extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f13551j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ double f13552k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ double f13553l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ double f13554m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ double f13555n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final /* synthetic */ a f13556o;

        r(a r10, String r11, int r12, double r13, double r14, double r15, double r16) {
            this.f13556o = r10;
            this.f13551j = r12;
            this.f13552k = r13;
            this.f13553l = r14;
            this.f13554m = r15;
            this.f13555n = r16;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            this.f13556o.onPacketLossComputed(this.f13551j, this.f13552k, this.f13553l, this.f13554m, this.f13555n);
            this.f13556o.b(this.f13551j, this.f13552k, this.f13553l, this.f13554m, this.f13555n);
        }
    }

    protected a() {
    }

    public void a(int r10) {
    }

    public void b(int r10, double r11, double r12, double r13, double r14) {
    }

    public void c(int r10, int r11, int r12) {
    }

    public void d(String r10) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void doLoadLibrary(String r10) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbClient() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbFeature() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbFlag() {
        return "-1";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public List<String> getAbSdkVersion() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbVersion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbi() {
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        return Build.CPU_ABI;
    L6:
        return Build.SUPPORTED_ABIS[0];
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public com.bytedance.frameworks.baselib.network.http.cronet.a getAppInfoSubset() {
        com.bytedance.frameworks.baselib.network.http.cronet.a r10 = new com.bytedance.frameworks.baselib.network.http.cronet.a();
        List<String> r11 = getAbSdkVersion();
        String r12 = "";
        if (r11 == null) goto L13;
        Iterator<String> r13 = r11.iterator();
        int r14 = 0;
    L6:
        if (r13.hasNext() == false) goto L13;
        String r15 = r13.next();
        r14 = r14 + 1;
        if (r14 > 5) goto L13;
        if (TextUtils.isEmpty(r15) == true) goto L6;
        r12 = r12 + r15 + ",";
    L13:
        r10.f1610a = r12;
        String[] r16 = TTNetInit.getTTNetDepend().f();
        if (r16 != null) goto L16;
    L24:
        Map<String, String> r17 = TTNetInit.getTTNetDepend().j();
        String r18 = r17.get("httpdns");
        if (r18 != null) goto L27;
    L29:
        String r19 = r17.get(TTNetInit.DOMAIN_BOE_KEY);
        if (r19 != null) goto L32;
    L34:
        String r20 = r17.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY);
        if (r20 != null) goto L37;
    L39:
        r10.f1617h = getAppInitialRegionInfo();
        return r10;
    L37:
        if (TextUtils.isEmpty(r20) == true) goto L39;
        r10.f1616g = r20;
        goto L39
    L32:
        if (TextUtils.isEmpty(r19) == true) goto L34;
        r10.f1615f = r19;
        goto L34
    L27:
        if (TextUtils.isEmpty(r18) == true) goto L29;
        r10.f1614e = r18;
        goto L29
    L16:
        if (r16.length <= 0) goto L19;
        r10.f1611b = r16[0];
    L19:
        if (r16.length <= 1) goto L22;
        r10.f1612c = r16[1];
    L22:
        if (r16.length <= 2) goto L24;
        r10.f1613d = r16[2];
        goto L24
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppInitialRegionInfo() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public long getAppStartTime() {
        return -1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getBypassBOEJSON() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCityName() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String[], Pair<byte[], byte[]>> getClientOpaqueData() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCronetSoPath() {
        return w4.a.r(TTNetInit.getTTNetDepend().getContext()).q();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDPI() {
        int r10 = com.bytedance.common.utility.h.a(TTNetInit.getTTNetDepend().getContext());
        if (r10 > 0) goto L5;
        return "";
    L5:
        return String.valueOf(r10);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceBrand() {
        return Build.BRAND;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceModel() {
        return Build.MODEL;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDevicePlatform() {
        return "android";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceType() {
        return Build.MODEL;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getGetDomainDependHostMap() {
        LinkedHashMap r10 = new LinkedHashMap();
        String[] r11 = TTNetInit.getTTNetDepend().f();
        boolean r12 = false;
        if (r11 != null) goto L5;
    L13:
        Map<String, String> r13 = TTNetInit.getTTNetDepend().j();
        if (TextUtils.isEmpty(r13.get("httpdns")) == false) goto L16;
    L19:
        r12 = true;
    L20:
        if (r12 == true) goto L24;
        r10.putAll(r13);
        return r10;
    L24:
        throw new IllegalArgumentException("You must set HttpDns, NetLog and BOE service domain, please refer to TTNet access documents.");
    L16:
        if (TextUtils.isEmpty(r13.get(TTNetInit.DOMAIN_BOE_KEY)) == false) goto L20;
        if (TextUtils.isEmpty(r13.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY)) == false) goto L20;
    L5:
        if (r11.length <= 0) goto L8;
        r10.put("first", r11[0]);
    L8:
        if (r11.length <= 1) goto L11;
        r10.put("second", r11[1]);
    L11:
        if (r11.length <= 2) goto L13;
        r10.put("third", r11[2]);
        goto L13
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getHttpDnsRequestFlags() {
        return NetConst.NOT_ENCRYPT_VERISON_CODE;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getIId() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getIsDropFirstTnc() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getLanguage() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean getLazyInitCronetIPC() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getNetAccessType() {
        return NetworkUtils.c(TTNetInit.getTTNetDepend().getContext());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getNetworkOperator() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return "";
    L7:
        return TTNetInit.getSystemApiSandbox().getNetworkOperator();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOSApi() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOSVersion() {
        String r10 = Build.VERSION.RELEASE;     // Catch: Exception -> L8
        if (r10 != null) goto L5;
        return r10;
    L5:
        if (r10.length() <= 10) goto L13;
        return r10.substring(0, 10);
    L13:
        return r10;
    L8:
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOpenUdid() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean getOptInit() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean getOptNqeDefault() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean getOptNqePersist() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final int getProcessFlag() {
        return com.bytedance.frameworks.baselib.network.http.util.g.f();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, Pair<Integer, Integer>> getQuicHint() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getResolution() {
        String r10 = com.bytedance.common.utility.h.c(TTNetInit.getTTNetDepend().getContext());
        if (com.bytedance.common.utility.g.b(r10) == true) goto L5;
        return r10;
    L5:
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getRticket() {
        return String.valueOf(System.currentTimeMillis());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSdkAppId() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSdkVersion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSimOperator() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return "";
    L7:
        return TTNetInit.getSystemApiSandbox().getSimOperator();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public String getSsCookieKey() {
        return CronetHttpURLConnection.SS_COOKIE;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSsmix() {
        return "a";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getStoreIdcRuleJSON() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getTNCRequestFlags() {
        return NetConst.NOT_ENCRYPT_VERISON_CODE;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getTNCRequestHeader() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getTNCRequestQuery() {
        Object r10 = TTNetInit.getTTNetDepend();
        if (r10 != null) goto L5;
        return null;
    L5:
        if ((r10 instanceof com.bytedance.ttnet.a) == true) goto L7;
        return null;
    L7:
        return ((com.bytedance.ttnet.a) r10).c();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUUID() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public int getWifiFrequency() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return 0;
    L7:
        return TTNetInit.getSystemApiSandbox().getWifiFrequency();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public int getWifiRssi() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return 0;
    L7:
        return TTNetInit.getSystemApiSandbox().getWifiRssi();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void handleApiResult(boolean r14, String r15, String r16, String r17, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, boolean r38, long r39, long r41, String r43, String r44, String r45, Exception r46) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "handleApiResult, succ: " + r14 + " url: " + r15 + "tracecode: " + r16 + " remoteIp: " + r17 + " appStart: " + r18);
    L5:
        o2.b r11 = o2.b.a();
        r11.P = r16;
        r11.f11397d = r17;
        r11.f11399f = r18;
        r11.f11400g = r18;
        r11.f11401h = r20;
        r11.f11402i = r22;
        r11.f11404k = r24;
        r11.f11405l = r26;
        r11.f11407n = r28;
        r11.f11408o = r30;
        r11.f11409p = r32;
        r11.f11410q = r34;
        r11.f11411r = r36;
        r11.f11412s = r38;
        r11.f11413t = r39;
        r11.f11414u = r26 - r20;
        r11.f11416w = r41;
        r11.A = r43;
        r11.f11417x = 0;
        if (r14 == false) goto L8;
        o2.f.u(r15, r11);
        o2.f.C(r15, r11);
        return;
    L8:
        o2.f.t(r15, r46, r11);
        o2.f.A(r15, r11, r46);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean handleApiSample(String r10, String r11) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "handleApiSample, url: " + r10 + "method: " + r11);
    L6:
        return o2.f.v(r10, r11);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isBOEProxyEnabled() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isEnableBrotli() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isEnableHttp2() {
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isEnableQuic() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void loggerD(String r10, String r11) {
        Logger.d(r10, r11);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean needCustomLoadLibrary() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> onCallToAddSecurityFactor(String r10, Map<String, String> r11) {
        HashMap r12 = new HashMap();
        Iterator<Map.Entry<String, String>> r13 = r11.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        Map.Entry<String, String> r14 = r13.next();
        ArrayList r15 = new ArrayList();
        r15.add(r14.getValue());
        r12.put(r14.getKey(), r15);
        goto L4
    L7:
        return o2.f.Z(r10, r12);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onClientIPChanged(String r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onClientIPChanged");
    L5:
        new e(this, "NetWork-Event", r10).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onColdStartFinish() {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onColdStartFinish");
    L5:
        new d(this, "NetWork-Event").a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onCronetBootSucceed() {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onCronetBootSucceed... ");
    L5:
        new j(this, "NetWork-Event").a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onDropReasonChanged(boolean r10, List<Integer> r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onDropReasonChanged");
    L5:
        new h(this, "NetWork-Event", r10, r11).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onEffectiveConnectionTypeChanged(int r10) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onEffectiveConnectionTypeChangedOnIOThread(int r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onEffectiveConnectionTypeChangedOnIOThread type = " + r10);
    L5:
        new p(this, "NetWork-Event", r10).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onMultiNetStateChanged(int r10, int r11) {
        if (Logger.debug() == false) goto L10;
        Logger.d("CronetDependAdapter", "onMultiNetStateChanged prev state = " + r10 + ", curr state = " + r11);
    L10:
        Reflect r12 = Reflect.on(TTMultiNetwork.class);     // Catch: Throwable -> L7
        Class<?> r13 = Integer.TYPE;     // Catch: Throwable -> L7
        r12.call("notifyMultiNetState", new Class[]{r13, r13}, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11)});     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onMultiNetworkStateChanged(int r10, int r11) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onNetworkQualityLevelChanged(int r10) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onNetworkQualityLevelChangedOnIOThread(int r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onNetworkQualityLevelChangedOnIOThread nql: " + r10);
    L5:
        new b(this, "NetWork-Event", r10).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onNetworkQualityRttAndThroughputNotified(int r10, int r11, int r12) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onNetworkQualityRttAndThroughputNotifiedOnIOThread(int r10, int r11, int r12) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onNetworkQualityRttAndThroughputNotifiedOnIOThread, effectiveHrttMs: " + r10 + ", effectiveTrttMs: " + r11 + ", effectiveRxThroughputKbps: " + r12);
    L5:
        new c(this, "NetWork-Event", r10, r11, r12).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onPacketLossComputed(int r10, double r11, double r12, double r13, double r14) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onPacketLossComputedOnIOThread(int r15, double r16, double r18, double r20, double r22) {
        if (Logger.debug() == false) goto L6;
        Logger.d("onPacketLossComputedOnIOThread", "onPacketLossComputed protocol = " + r15 + ", upstreamLossRate = " + r16 + ", upstreamLossRateVariance = " + r18 + ", downstreamLossRate = " + r20 + ", downstreamLossRateVariance = " + r22);
    L6:
        new r(this, "NetWork-Event", r15, r16, r18, r20, r22).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onPublicIPsChanged(List<String> r10, List<String> r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onPublicIPsChanged");
    L5:
        new f(this, "NetWork-Event", r10, r11).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onRTTOrThroughputEstimatesComputed(int r10, int r11, int r12) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onRTTOrThroughputEstimatesComputedOnIOThread(int r10, int r11, int r12) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onRTTOrThroughputEstimatesComputedOnIOThread httpRtt = " + r10 + ", transportRttMs = " + r11 + ",downstreamThroughputKbps = " + r12);
    L5:
        new q(this, "NetWork-Event", r10, r11, r12).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigABTestChanged(String r10) {
        new l(this, "NetWork-Event", r10).a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigEtagChanged(String r10) {
        new k(this, "NetWork-Event", r10).a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigUpdated(String r10) {
    L7:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "config = " + r10);     // Catch: Throwable -> L7
    L5:
        new m(this, "NetWork-Event", r10).a();     // Catch: Throwable -> L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onStoreIdcChanged(String r12, String r13, String r14, String r15, String r16, String r17) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onStoreIdcChanged");
    L5:
        new g(this, "NetWork-Event", r12, r13, r14, r15, r16, r17).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTNCUpdateFailed(ArrayList<String> r10, String r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onTNCUpdateFailed");
    L5:
        new i(this, "NetWork-Event", r10, r11).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTTDnsResolveResult(String r13, String r14, int r15, int r16, int r17, List<String> r18, String r19) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "onTTDnsResolveResult uuid = " + r13 + " host = " + r14);
    L6:
        new n(this, "NetWork-Event", r13, r14, r15, r16, r17, r18, r19).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTTNetDetectInfoChanged(String r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onTTNetDetectInfoChanged result = " + r10);
    L5:
        new o(this, "NetWork-Event", r10).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onUserSpecifiedNetworkEnabled(boolean r10) {
        if (Logger.debug() == false) goto L10;
        Logger.d("CronetDependAdapter", "onUserSpecifiedNetworkEnabled enable = " + r10);
    L10:
        Reflect.on(TTMultiNetwork.class).call("notifyUserSpecifiedNetworkEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(r10)});     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onWiFiToCellStateChangedOnIOThread(int r10, int r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onWiFiToCellStateChangedOnIOThread prev state = " + r10 + ", curr state = " + r11);
    L5:
        new C0316a(this, "NetWork-Event", r10, r11).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void setAdapter(ICronetDepend r10) {
    }
}
