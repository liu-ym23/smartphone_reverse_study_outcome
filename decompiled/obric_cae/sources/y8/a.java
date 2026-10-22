package y8;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
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

    /* JADX INFO: renamed from: y8.a$a, reason: collision with other inner class name */
    public class C0200a extends s5.c {
        public C0200a() {
            super(0);
        }

        @Override // s5.c, java.lang.Runnable
        public final void run() {
            TTNetInit.notifyColdStartFinish();
        }
    }

    public class b extends s5.c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ String f14062o;

        public b(String r8) {
            this.f14062o = r8;
            super(0);
        }

        @Override // s5.c, java.lang.Runnable
        public final void run() {
            TTNetInit.onClientIPChanged(this.f14062o);
        }
    }

    public class c extends s5.c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ String f14063o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ String f14064p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ String f14065q;

        public c(String r8, String r10, String r11) {
            this.f14063o = r8;
            this.f14064p = r10;
            this.f14065q = r11;
            super(0);
        }

        @Override // s5.c, java.lang.Runnable
        public final void run() {
            if (y8.b.f14092a == null) goto L5;
        L14:
            y8.b r8 = y8.b.f14092a;
            String r10 = this.f14063o;
            String r11 = this.f14064p;
            String r12 = this.f14065q;
            r8.a(r10, r11, r12);
            k7.b r13 = k7.b.e();
            if (r13.f8969i != null) goto L17;
            return;
        L17:
            if (r13.f8970j == true) goto L20;
            return;
        L20:
            if (TextUtils.isEmpty(r11) == false) goto L22;
            return;
        L22:
            if (TextUtils.isEmpty(r12) == false) goto L25;
            return;
        L25:
            if (r13.f8962b.equalsIgnoreCase(r10) == true) goto L27;
        L31:
            SharedPreferences.Editor r14 = r13.f8969i.getSharedPreferences("ttnet_store_region", 0).edit();
            if (TextUtils.isEmpty(r10) == true) goto L34;
            r13.f8962b = r10;
        L34:
            r13.f8961a = r11;
            if (r12.equalsIgnoreCase("uid") == false) goto L38;
            r13.f8965e = "uid";
            r13.f8964d = r11;
        L40:
            Logger.d("b", "saveStoreRegionForCronet idc:" + r13.f8962b + " region:" + r13.f8961a + " source:" + r13.f8965e);
            r14.putString("store_region", r13.f8961a);
            r14.putString("store_idc", r13.f8962b);
            r14.putString("store_region_src", r13.f8965e);
            r14.putString("store_region_did", r13.f8963c);
            r14.putString("store_region_uid", r13.f8964d);
            r14.apply();
            return;
        L38:
            if (r12.equalsIgnoreCase("did") == false) goto L40;
            r13.f8965e = "did";
            r13.f8963c = r11;
            goto L40
        L27:
            if (r13.f8961a.equalsIgnoreCase(r11) == false) goto L31;
            if (r13.f8965e.equalsIgnoreCase(r12) == false) goto L31;
            return;
        L5:
            monitor-enter(y8.b.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (y8.b.f14092a != null) goto L9;
            y8.b.f14092a = new y8.b();     // Catch: Throwable -> L11
        L9:
            monitor-exit(y8.b.class);     // Catch: Throwable -> L11
            goto L14
        }
    }

    public class d extends s5.c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ ArrayList f14066o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ String f14067p;

        public d(ArrayList r8, String r10) {
            this.f14066o = r8;
            this.f14067p = r10;
            super(0);
        }

        @Override // s5.c, java.lang.Runnable
        public final void run() {
            if (x8.d.f13696a == null) goto L5;
        L14:
            x8.d r8 = x8.d.f13696a;
            ArrayList r10 = this.f14066o;
            String r11 = this.f14067p;
            r8.getClass();
            if (r10 != null) goto L17;
            return;
        L17:
            if (r10.isEmpty() == true) goto L109;
            Context r12 = TTNetInit.getTTNetDepend().getContext();
            if (r12 == null) goto L110;
            Logger.d("CronetRetryEventHandler", "start get-domain request.");
            Iterator r13 = r10.iterator();
        L24:
            if (r13.hasNext() == false) goto L111;
            String r14 = (String) r13.next();
            a9.a r15 = new a9.a();     // Catch: Throwable -> L84
            r15.f130b = true;     // Catch: Throwable -> L84
            r15.f131c = false;     // Catch: Throwable -> L84
            l7.f r16 = new l7.f(r14);     // Catch: Throwable -> L84
            r16.b("tnc_src", "7");     // Catch: Throwable -> L84
            String r17 = r16.c();     // Catch: Throwable -> L84
            HashMap r18 = new HashMap();     // Catch: Throwable -> L84
            HashMap r19 = new HashMap();     // Catch: Throwable -> L84
            if (TextUtils.isEmpty(r11) == true) goto L29;
            r19.put("x-tt-tnc-summary", r11);     // Catch: Throwable -> L84
        L29:
            String r20 = a9.e.a(r17, r19, r18, r15);     // Catch: Throwable -> L84
            Logger.d("CronetRetryEventHandler", "response: " + r20);     // Catch: Throwable -> L84
            if (r5.f.b(r20) == true) goto L24;
            if ("success".equals(new JSONObject(r20).getString("message")) == false) goto L24;
        L78:
            th = th;
            Iterator r28 = r13;
        L77:
            String r21 = r11;
        L92:
            th.printStackTrace();     // Catch: Throwable -> L82
            return;
        L82:
            th = th;
        L86:
            th.printStackTrace();
            r13 = r28;
            r11 = r21;
            goto L24
        L37:
            if (r18.get("x-ss-etag") != null) goto L39;
        L41:
            String r110 = "";
        L43:
            if (r18.get("x-ss-canary") != null) goto L45;
        L47:
            String r111 = "";
        L49:
            if (r18.get("x-tt-tnc-config") != null) goto L51;
        L53:
            String r112 = "";
        L55:
            if (r18.get("x-tt-tnc-abtest") == null) goto L61;
            r28 = r13;
            if (TextUtils.isEmpty((CharSequence) ((List) r18.get("x-tt-tnc-abtest")).get(0)) == true) goto L62;
            String r22 = (String) ((List) r18.get("x-tt-tnc-abtest")).get(0);     // Catch: Throwable -> L76
        L64:
            if (r18.get("x-tt-tnc-control") != null) goto L66;
            r21 = r11;
        L71:
            String r113 = "";
        L72:
            Logger.d("CronetRetryEventHandler", "tnc verion: " + r110 + " canary: " + r111 + " configid: " + r112 + " abtest: " + r22);     // Catch: Throwable -> L74
            a7.i.m(r12).getClass();     // Catch: Throwable -> L74
            a7.i.a();     // Catch: Throwable -> L74
            Reflect.on(a7.i.f111b).call("notifyTNCConfigUpdated", new Class[]{String.class, String.class, String.class, String.class, String.class, String.class}, new Object[]{r110, r111, r112, r22, r113, r20}).get();     // Catch: Throwable -> L74
        L74:
            th = th;
            goto L92
        L112:
            return;
        L66:
            r21 = r11;
            if (TextUtils.isEmpty((CharSequence) ((List) r18.get("x-tt-tnc-control")).get(0)) == true) goto L71;
            r113 = (String) ((List) r18.get("x-tt-tnc-control")).get(0);     // Catch: Throwable -> L74
        L62:
            r22 = "";
        L76:
            th = th;
            goto L77
        L61:
            r28 = r13;
            goto L62
        L51:
            if (TextUtils.isEmpty((CharSequence) ((List) r18.get("x-tt-tnc-config")).get(0)) == true) goto L53;
            r112 = (String) ((List) r18.get("x-tt-tnc-config")).get(0);     // Catch: Throwable -> L78
            goto L55
        L45:
            if (TextUtils.isEmpty((CharSequence) ((List) r18.get("x-ss-canary")).get(0)) == true) goto L47;
            r111 = (String) ((List) r18.get("x-ss-canary")).get(0);     // Catch: Throwable -> L78
            goto L49
        L39:
            if (TextUtils.isEmpty((CharSequence) ((List) r18.get("x-ss-etag")).get(0)) == true) goto L41;
            r110 = (String) ((List) r18.get("x-ss-etag")).get(0);     // Catch: Throwable -> L78
        L84:
            th = th;
            r28 = r13;
            r21 = r11;
            goto L86
        L111:
            return;
        L110:
            return;
        L109:
            return;
        L5:
            monitor-enter(x8.d.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (x8.d.f13696a != null) goto L9;
            x8.d.f13696a = new x8.d();     // Catch: Throwable -> L11
        L9:
            monitor-exit(x8.d.class);     // Catch: Throwable -> L11
            goto L14
        }
    }

    public class e extends s5.c {
        public e() {
            super(0);
        }

        @Override // s5.c, java.lang.Runnable
        public final void run() {
            x8.c r8 = x8.c.k(TTNetInit.getTTNetDepend().getContext());
            r8.getClass();
            SharedPreferences r10 = r8.f13682o.getSharedPreferences("ss_app_config", 0);     // Catch: Throwable -> L8
            SharedPreferences.Editor r11 = r10.edit();     // Catch: Throwable -> L8
            r11.putInt("chromium_boot_failures", 0);     // Catch: Throwable -> L8
            if (Logger.debug() == false) goto L6;
            Logger.d("AppConfig", "KEY_CHROMIUM_BOOT_FAILURES set 0");     // Catch: Throwable -> L8
        L6:
            u5.a.a(r11);     // Catch: Throwable -> L8
            r8.f13685r = r10.getInt("chromium_boot_failures", 0);     // Catch: Throwable -> L8
            LinkedHashMap r12 = new LinkedHashMap();     // Catch: Throwable -> L8
            r12.put("chromium_boot_failures", Integer.valueOf(r8.f13685r));     // Catch: Throwable -> L8
            TTNetInit.getTTNetDepend().saveMapToProvider(r8.f13682o, r12);     // Catch: Throwable -> L8
        L10:
            w8.b.f13064e = true;
            return;
        L8:
            th = move-exception;
            th.printStackTrace();
            goto L10
        }
    }

    public class f extends s5.c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ String f14068o;

        public f(String r8) {
            this.f14068o = r8;
            super(0);
        }

        @Override // s5.c, java.lang.Runnable
        public final void run() {
            x8.c r8 = x8.c.k(TTNetInit.getTTNetDepend().getContext());     // Catch: Throwable -> L4
            r8.F = this.f14068o;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public class g extends s5.c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ String f14069o;

        public g(String r8) {
            this.f14069o = r8;
            super(0);
        }

        @Override // s5.c, java.lang.Runnable
        public final void run() {
            String r8 = this.f14069o;
            x8.c.k(TTNetInit.getTTNetDepend().getContext()).l(r8);     // Catch: Throwable -> L5
            ClientKeyManager.d().a(r8);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public class h extends s5.c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ String f14070o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ List f14071p;

        public h(String r8, String r10, int r11, int r12, int r13, List r14, String r15) {
            this.f14070o = r8;
            this.f14071p = r14;
            super(0);
        }

        @Override // s5.c, java.lang.Runnable
        public final void run() {
            monitor-enter(b9.a.class);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (b9.a.f3133c != null) goto L7;
            b9.a.f3133c = new b9.a(0);     // Catch: Throwable -> L13
        L7:
            b9.a r8 = b9.a.f3133c;     // Catch: Throwable -> L13
            monitor-exit(b9.a.class);
            List r10 = this.f14071p;
            Map r11 = (Map) r8.f3135b;
            String r12 = this.f14070o;
            b9.b r13 = (b9.b) r11.get(r12);
            if (r13 == null) goto L18;
            r13.f3138c = new b9.c(r10);
            r13.f3137b.countDown();
            r11.remove(r12);
            return;
        }
    }

    public class i extends s5.c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ String f14072o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ a f14073p;

        public i(a r8, String r10) {
            this.f14073p = r8;
            this.f14072o = r10;
            super(0);
        }

        @Override // s5.c, java.lang.Runnable
        public final void run() {
            this.f14073p.onTTNetDetectResult(this.f14072o);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public class j extends s5.c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ String f14074o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ int f14075p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ a f14076q;

        public j(a r8, String r10, int r11) {
            this.f14076q = r8;
            this.f14074o = r10;
            this.f14075p = r11;
            super(0);
        }

        @Override // s5.c, java.lang.Runnable
        public final void run() {
            String r8 = this.f14074o;
            int r10 = this.f14075p;
            this.f14076q.onCronetMappingRequestStatus(r8, r10);
        }
    }

    public class k extends s5.c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ int f14077o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ a f14078p;

        public k(a r8, int r10) {
            this.f14078p = r8;
            this.f14077o = r10;
            super(0);
        }

        @Override // s5.c, java.lang.Runnable
        public final void run() {
            this.f14078p.onNQEEffectiveConnectionTypeChanged(this.f14077o);
        }
    }

    public class l extends s5.c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ int f14079o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ int f14080p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ int f14081q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ a f14082r;

        public l(a r8, int r10, int r11, int r12) {
            this.f14082r = r8;
            this.f14079o = r10;
            this.f14080p = r11;
            this.f14081q = r12;
            super(0);
        }

        @Override // s5.c, java.lang.Runnable
        public final void run() {
            int r8 = this.f14080p;
            int r10 = this.f14081q;
            this.f14082r.onNQERTTOrThroughputComputed(this.f14079o, r8, r10);
        }
    }

    public class m extends s5.c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ int f14083o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ double f14084p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ double f14085q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ double f14086r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ double f14087s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final /* synthetic */ a f14088t;

        public m(a r8, int r10, double r11, double r12, double r13, double r14) {
            this.f14088t = r8;
            this.f14083o = r10;
            this.f14084p = r11;
            this.f14085q = r12;
            this.f14086r = r13;
            this.f14087s = r14;
            super(0);
        }

        @Override // s5.c, java.lang.Runnable
        public final void run() {
            this.f14088t.onNQEPacketLossComputed(this.f14083o, this.f14084p, this.f14085q, this.f14086r, this.f14087s);
        }
    }

    public class n extends s5.c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ int f14089o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ int f14090p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ a f14091q;

        public n(a r8, int r10, int r11) {
            this.f14091q = r8;
            this.f14089o = r10;
            this.f14090p = r11;
            super(0);
        }

        @Override // s5.c, java.lang.Runnable
        public final void run() {
            int r8 = this.f14089o;
            int r10 = this.f14090p;
            this.f14091q.onMNStateChanged(r8, r10);
        }
    }

    public a() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void doLoadLibrary(String r8) {
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
    public String getAbVersion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbi() {
        return Build.SUPPORTED_ABIS[0];
    }

    public String getAppId() {
        return "-1";
    }

    public String getAppName() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getBypassBOEJSON() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCarrierRegion() {
        return "";
    }

    public String getChannel() {
        return "";
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
        return x8.c.k(TTNetInit.getTTNetDepend().getContext()).B;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDPI() {
        Context r8 = TTNetInit.getTTNetDepend().getContext();
        if (r5.g.f11521b != (-1)) goto L6;
        if (r8 == null) goto L6;
        r5.g.f11521b = r8.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
    L6:
        int r10 = r5.g.f11521b;
        if (r10 > 0) goto L9;
        return "";
    L9:
        return String.valueOf(r10);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceBrand() {
        return Build.BRAND;
    }

    public String getDeviceId() {
        return "";
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
    public String getGetDomainDefaultJSON() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getGetDomainDependHostMap() {
        LinkedHashMap r8 = new LinkedHashMap();
        String[] r10 = TTNetInit.getTTNetDepend().getConfigServers();
        if (r10 != null) goto L5;
    L13:
        Map<String, String> r11 = TTNetInit.getTTNetDepend().getTTNetServiceDomainMap();
        if (TextUtils.isEmpty(r11.get("httpdns")) == true) goto L24;
        if (TextUtils.isEmpty(r11.get(TTNetInit.DOMAIN_NETLOG_KEY)) == true) goto L24;
        if (TextUtils.isEmpty(r11.get(TTNetInit.DOMAIN_BOE_KEY)) == true) goto L20;
    L21:
        r8.putAll(r11);
        return r8;
    L20:
        if (TextUtils.isEmpty(TTNetInit.DOMAIN_BOE_HTTPS_KEY) == false) goto L21;
    L24:
        throw new IllegalArgumentException("You must set HttpDns, NetLog and BOE service domain, please refer to TTNet access documents.");
    L5:
        if (r10.length <= 0) goto L8;
        r8.put("first", r10[0]);
    L8:
        if (r10.length <= 1) goto L11;
        r8.put("second", r10[1]);
    L11:
        if (r10.length <= 2) goto L13;
        r8.put("third", r10[2]);
        goto L13
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getHttpDnsRequestFlags() {
        return "0";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getIId() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getLanguage() {
        return "";
    }

    public String getManifestVersionCode() {
        return "-1";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getNetAccessType() {
        return r5.e.b(TTNetInit.getTTNetDepend().getContext());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOSApi() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOSVersion() {
        String r8 = Build.VERSION.RELEASE;     // Catch: Exception -> L8
        if (r8 != null) goto L5;
        return r8;
    L5:
        if (r8.length() <= 10) goto L13;
        return r8.substring(0, 10);
    L13:
        return r8;
    L8:
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public ArrayList<byte[]> getOpaqueData() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOpenUdid() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final int getProcessFlag() {
        return l7.e.f9171a.get();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, Pair<Integer, Integer>> getQuicHint() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getRegion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getResolution() {
        Context r8 = TTNetInit.getTTNetDepend().getContext();
        if (r5.f.b(r5.g.f11520a) == false) goto L16;
        if (r8 == null) goto L16;
        DisplayMetrics r10 = r8.getResources().getDisplayMetrics();
        int r11 = 0;
        if (r10 != null) goto L8;
        int r12 = 0;
    L9:
        DisplayMetrics r13 = r8.getResources().getDisplayMetrics();
        if (r13 == null) goto L13;
        r11 = r13.heightPixels;
    L13:
        if (r12 <= 0) goto L16;
        if (r11 <= 0) goto L16;
        r5.g.f11520a = r12 + "*" + r11;
        goto L16
    L8:
        r12 = r10.widthPixels;
    L16:
        String r14 = r5.g.f11520a;
        if (r5.f.b(r14) == true) goto L19;
        return r14;
    L19:
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

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public String getSsCookieKey() {
        return CronetHttpURLConnection.SS_COOKIE;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSsmix() {
        return "a";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getStoreIdc() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getStoreIdcRuleJSON() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSysRegion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getTNCRequestFlags() {
        return "0";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getTNCRequestHeader() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getTNCRequestQuery() {
        Object r8 = TTNetInit.getTTNetDepend();
        if (r8 != null) goto L5;
    L7:
        return null;
    L5:
        if ((r8 instanceof w8.a) == false) goto L7;
        w8.a r10 = (w8.a) r8;
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUUID() {
        return "";
    }

    public String getUpdateVersionCode() {
        return "-1";
    }

    public String getUserId() {
        return "";
    }

    public String getVersionCode() {
        return "-1";
    }

    public String getVersionName() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void handleApiResult(boolean r13, String r14, String r15, String r16, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, boolean r37, long r38, long r40, String r42, String r43, String r44, Exception r45) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "handleApiResult, succ: " + r13 + " url: " + r14 + "tracecode: " + r15 + " remoteIp: " + r16 + " appStart: " + r17);
    L6:
        w6.a r8 = w6.a.E.a();
        r8.f12990a = r16;
        r8.f12992c = r17;
        r8.f12993d = r17;
        r8.f12994e = r19;
        r8.f12995f = r21;
        r8.f12996g = r23;
        r8.f12997h = r25;
        r8.f12999j = r27;
        r8.f13000k = r29;
        r8.f13001l = r31;
        r8.f13002m = r33;
        r8.f13003n = r35;
        r8.f13004o = r37;
        r8.f13005p = r38;
        long r10 = r25 - r19;
        r8.f13006q = r10;
        r8.f13008s = r40;
        r8.f13012w = r42;
        r8.f13009t = 0;
        if (r13 == false) goto L9;
        w6.e.d(r10, r19, r14, r15, r8);
        return;
    L9:
        w6.e.b(r10, r19, r14, r15, r8, r45);
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
    public void loggerD(String r8, String r10) {
        Logger.d(r8, r10);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public boolean loggerDebug() {
        return Logger.debug();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean needCustomLoadLibrary() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> onCallToAddSecurityFactor(String r8, Map<String, String> r10) {
        HashMap r11 = new HashMap();
        Iterator<Map.Entry<String, String>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<String, String> r13 = r12.next();
        ArrayList r14 = new ArrayList();
        r14.add(r13.getValue());
        r11.put(r13.getKey(), r14);
        goto L4
    L6:
        w6.e.d r15 = w6.e.f13020a;
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onClientIPChanged(String r8) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onClientIPChanged");
    L5:
        new b(r8).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onColdStartFinish() {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onColdStartFinish");
    L5:
        new C0200a().a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onCronetBootSucceed() {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onCronetBootSucceed... ");
    L5:
        new e().a();
    }

    public void onCronetMappingRequestStatus(String r8, int r10) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onEffectiveConnectionTypeChanged(int r8) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onEffectiveConnectionTypeChanged state = " + r8);
    L5:
        new k(this, r8).a();
    }

    public void onMNStateChanged(int r8, int r10) {
    }

    public final void onMappingRequestStatus(String r8, int r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onMappingRequestStatus key = " + r8 + " status: " + r10);
    L5:
        new j(this, r8, r10).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onMultiNetworkStateChanged(int r8, int r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onMultiNetworkStateChanged prev state = " + r8 + ", curr state = " + r10);
    L5:
        new n(this, r8, r10).a();
    }

    public void onNQEEffectiveConnectionTypeChanged(int r8) {
    }

    public void onNQEPacketLossComputed(int r8, double r10, double r11, double r12, double r13) {
    }

    public void onNQERTTOrThroughputComputed(int r8, int r10, int r11) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onPacketLossComputed(int r14, double r15, double r17, double r19, double r21) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "onPacketLossComputed protocol = " + r14 + ", upstreamLossRate = " + r15 + ", upstreamLossRateVariance = " + r17 + ", downstreamLossRate = " + r19 + ", downstreamLossRateVariance = " + r21);
    L6:
        new m(this, r14, r15, r17, r19, r21).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onRTTOrThroughputEstimatesComputed(int r8, int r10, int r11) {
        if (Logger.debug() == false) goto L5;
        StringBuilder r12 = defpackage.a.g("onRTTOrThroughputEstimatesComputed httpRtt = ", r8, ", transportRttMs = ", r10, ",downstreamThroughputKbps = ");
        r12.append(r11);
        Logger.d("CronetDependAdapter", r12.toString());
    L5:
        new l(this, r8, r10, r11).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigEtagChanged(String r8) {
        new f(r8).a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigUpdated(String r8) {
    L8:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "config = " + r8);     // Catch: Throwable -> L8
    L6:
        new g(r8).a();     // Catch: Throwable -> L8
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onStoreIdcChanged(String r8, String r10, String r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onStoreIdcChanged");
    L5:
        new c(r8, r10, r11).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTNCUpdateFailed(ArrayList<String> r8, String r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onTNCUpdateFailed");
    L5:
        new d(r8, r10).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTTDnsResolveResult(String r11, String r12, int r13, int r14, int r15, List<String> r16, String r17) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "onTTDnsResolveResult uuid = " + r11 + " host = " + r12);
    L6:
        new h(r11, r12, r13, r14, r15, r16, r17).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTTNetDetectInfoChanged(String r8) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onTTNetDetectInfoChanged result = " + r8);
    L5:
        new i(this, r8).a();
    }

    public void onTTNetDetectResult(String r8) {
    }

    public void onTTNetworkStateChanged(int r8) {
    }

    public void sendAppMonitorEvent(String r8, String r10) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void setAdapter(ICronetDepend r8) {
    }

    public final void tryStartTTNetDetect(List<String> r8, int r10, int r11) {
    }
}
