package d9;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.keva.KevaImpl;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import d7.e;
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
import l7.f;
import l7.g;
import org.json.JSONObject;
import we.a0;
import we.r;
import we.y;

/* JADX INFO: loaded from: classes.dex */
public final class d implements e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static d f6976o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f6977p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f6978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f6980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d9.b f6981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6982e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f6983f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6984g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<String, Integer> f6985h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap<String, Integer> f6986i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6987j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap<String, Integer> f6988k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HashMap<String, Integer> f6989l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6990m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f6991n;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f6992a;

        public a(d r8, Looper r10) {
            this.f6992a = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r8) {
            if (r8.what == 10000) goto L6;
            return;
        L6:
            if (r8.arg1 != 0) goto L8;
            boolean r10 = false;
        L9:
            int r11 = r8.arg2;
            d r12 = this.f6992a;
            r12.getClass();
            if (r11 != 7) goto L12;
            b r13 = b.f7000s;
        L36:
            r12.a(r13, r10);
            return;
        L12:
            if (r11 != 10) goto L14;
            r13 = b.f7001t;
            goto L36
        L14:
            if (r11 != 20) goto L16;
            r13 = b.f7002u;
            goto L36
        L16:
            if (r11 != (-2)) goto L18;
            r13 = b.f6993b;
            goto L36
        L18:
            if (r11 == (-1)) goto L31;
            if (r11 != 0) goto L21;
            r13 = b.f6995n;
            goto L36
        L21:
            if (r11 != 2) goto L23;
            r13 = b.f6997p;
            goto L36
        L23:
            if (r11 != 3) goto L25;
            r13 = b.f6998q;
            goto L36
        L25:
            if (r11 == 4) goto L27;
            r13 = b.f6996o;
            goto L36
        L27:
            r13 = b.f6999r;
            goto L36
        L31:
            r13 = b.f6994m;
            goto L36
        L8:
            r10 = true;
            goto L9
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f6993b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final b f6994m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final b f6995n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final b f6996o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final b f6997p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final b f6998q = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final b f6999r = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final b f7000s = null;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final b f7001t = null;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final b f7002u = null;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final /* synthetic */ b[] f7003v = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7004a;

        static {
            b r8 = new b("TTRESUME", 0, -2);
            f6993b = r8;
            b r10 = new b("TTHardCode", 1, -1);
            f6994m = r10;
            b r11 = new b("TTCACHE", 2, 0);
            f6995n = r11;
            b r12 = new b("TTSERVER", 3, 1);
            f6996o = r12;
            b r13 = new b("TTERROR", 4, 2);
            f6997p = r13;
            b r14 = new b("TTPOLL", 5, 3);
            f6998q = r14;
            b r15 = new b("TTTNC", 6, 4);
            f6999r = r15;
            b r16 = new b("PORTRETRY", 7, 7);
            f7000s = r16;
            b r17 = new b("TTREGION", 8, 10);
            f7001t = r17;
            b r18 = new b("TTCRONET", 9, 20);
            f7002u = r18;
            f7003v = new b[]{r8, r10, r11, r12, r13, r14, r15, r16, r17, r18};
        }

        public b(String r8, int r10, int r11) {
            super(r8, r10);
            this.f7004a = r11;
        }

        public static b valueOf(String r8) {
            return (b) Enum.valueOf(b.class, r8);
        }

        public static b[] values() {
            return (b[]) f7003v.clone();
        }
    }

    public d() {
        this.f6978a = 0;
        this.f6979b = false;
        this.f6982e = 0;
        this.f6983f = 0;
        this.f6984g = 0;
        this.f6985h = new HashMap();
        this.f6986i = new HashMap();
        this.f6987j = 0;
        this.f6988k = new HashMap();
        this.f6989l = new HashMap();
        this.f6990m = true;
        this.f6991n = new a(this, Looper.getMainLooper());
    }

    public static boolean b(Context r17, boolean r18, b r19) {
        Logger.d("TNCManager", "getdomain internal, use retrofit okhttp: " + r18 + ", tnc source: " + r19);
        ArrayList r8 = new ArrayList();
        if (x8.c.k(r17).H != null) goto L5;
    L12:
        x8.c.k(r17).getClass();
        r8.addAll(Arrays.asList(x8.c.j()));
    L13:
        Iterator r10 = r8.iterator();
    L15:
        if (r10.hasNext() == false) goto L87;
        f r11 = new f(defpackage.b.h("https://", (String) r10.next(), "/get_domains/v5/").toString());
        r11.b("abi", Build.SUPPORTED_ABIS[0]);     // Catch: Throwable -> L23
        r11.a(r19.f7004a, "tnc_src");     // Catch: Throwable -> L23
        r11.b("okhttp_version", "4.0.76.2");     // Catch: Throwable -> L23
        r11.b("ttnet_version", "4.0.76.2");     // Catch: Throwable -> L23
        Object r12 = TTNetInit.getTTNetDepend();     // Catch: Throwable -> L23
        if (r12 != null) goto L20;
    L25:
        HashMap r13 = new HashMap();
        k7.b r14 = k7.b.e();
        if (r14.f8970j == true) goto L28;
    L38:
        if (r18 == false) goto L39;
        r11.a(TTNetInit.getTTNetDepend().getAppId(), WsConstants.KEY_APP_ID);
        r11.b("device_platform", "android");
        if (TTNetInit.getCronetProvider() == null) goto L53;
        r11.b("version_code", TTNetInit.getCronetProvider().getVersionCode());
        r11.b("channel", TTNetInit.getCronetProvider().getChannel());
    L53:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r13.entrySet().iterator();
    L55:
        if (r16.hasNext() == false) goto L61;
        Map.Entry r20 = (Map.Entry) r16.next();
        if (TextUtils.isEmpty((CharSequence) r20.getKey()) == true) goto L55;
        if (TextUtils.isEmpty((CharSequence) r20.getValue()) == true) goto L55;
        r15.add(new Header((String) r20.getKey(), (String) r20.getValue()));
        goto L55
    L61:
        String r21 = r11.c();
        LinkedHashMap r110 = new LinkedHashMap();
        Pair r22 = g.c(r21, r110);     // Catch: IOException -> L85
        String r23 = (String) r22.first;     // Catch: IOException -> L85
        String r111 = (String) r22.second;     // Catch: IOException -> L85
        INetworkApi r112 = (INetworkApi) e9.d.c(INetworkApi.class, r23);
        if (r112 == null) goto L15;
        Call<String> r24 = r112.doGet(true, -1, r111, r110, r15, null);
        SsResponse<String> r25 = r24.execute();     // Catch: Throwable -> L76
        List<Header> r26 = r25.headers();     // Catch: Throwable -> L76
        String r27 = r25.body();     // Catch: Throwable -> L76
        String r28 = e9.d.d("x-ss-etag", r26);     // Catch: Throwable -> L76
        String r29 = e9.d.d("x-tt-tnc-abtest", r26);     // Catch: Throwable -> L76
        if (r5.f.b(r27) == true) goto L79;
        if (r5.f.b(r28) == true) goto L73;
        x8.c.k(r17).F = r28;     // Catch: Throwable -> L76
    L73:
        c().f6981d.f6974d = r29;     // Catch: Throwable -> L76
        Logger.d("TNCManager", "okhttp tnc response success, etag is " + r28);     // Catch: Throwable -> L76
        JSONObject r30 = new JSONObject(r27);     // Catch: Throwable -> L76
        ClientKeyManager.d().a(r27);     // Catch: Throwable -> L76
        boolean r31 = x8.c.k(r17).m(r30, r19, System.currentTimeMillis());     // Catch: Throwable -> L76
        r24.cancel();
        return r31;
    L79:
        r24.cancel();
    L76:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L80
        if (r24 == null) goto L15;
    L80:
        th = move-exception;
        if (r24 == null) goto L126;
        r24.cancel();
        throw th;
    L126:
        throw th;
    L85:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L39:
        a9.a r32 = new a9.a();
        r32.f129a = r11.c();
        r32.f130b = true;
        System.currentTimeMillis();
        String r33 = a9.e.a(r32.f129a, r13, null, r32);     // Catch: Throwable -> L48
        System.currentTimeMillis();     // Catch: Throwable -> L48
        if (r5.f.b(r33) == true) goto L15;
        if (r5.f.b(r32.f132d) == true) goto L46;
        x8.c.k(r17).F = r32.f132d;     // Catch: Throwable -> L48
    L46:
        c().f6981d.f6974d = r32.f133e;     // Catch: Throwable -> L48
        JSONObject r34 = new JSONObject(r33);     // Catch: Throwable -> L48
        ClientKeyManager.d().a(r33);     // Catch: Throwable -> L48
        return x8.c.k(r17).m(r34, r19, System.currentTimeMillis());
    L48:
        th = move-exception;
        th.printStackTrace();
        goto L15
    L28:
        if (r14.f8971k == true) goto L38;
        if (r14.f8962b.isEmpty() == true) goto L33;
        r13.put("x-tt-store-idc", r14.f8962b);
    L33:
        if (r14.f8961a.isEmpty() == true) goto L36;
        r13.put("x-tt-store-region", r14.f8961a);
    L36:
        if (r14.f8965e.isEmpty() == true) goto L38;
        r13.put("x-tt-store-region-src", r14.f8965e);
        goto L38
    L20:
        if ((r12 instanceof w8.a) == false) goto L25;
        w8.a r35 = (w8.a) r12;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.printStackTrace();
        goto L25
    L87:
        return false;
    L5:
        if (x8.c.k(r17).H.size() == 0) goto L12;
        r8.addAll(x8.c.k(r17).H);
        x8.c.k(r17).getClass();
        String[] r36 = x8.c.j();
        int r37 = r36.length;
        int r38 = 0;
    L7:
        if (r38 >= r37) goto L13;
        String r39 = r36[r38];
        if (r8.contains(r39) == true) goto L11;
        r8.add(r39);
    L11:
        r38 = r38 + 1;
        goto L7
    }

    public static synchronized d c() {
        monitor-enter(d.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f6976o != null) goto L7;
        f6976o = new d();     // Catch: Throwable -> L10
    L7:
        d r8 = f6976o;     // Catch: Throwable -> L10
        monitor-exit(d.class);
        return r8;
    }

    public final void a(b r10, boolean r11) {
        d9.b r8 = this.f6981d;
        if (r8 == null) goto L5;
        d9.a r12 = r8.f6972b;
    L6:
        if (r12 != null) goto L9;
        return;
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("TNCManager", "doUpdateRemote, " + r11);
    L11:
        long r13 = SystemClock.elapsedRealtime();
        if (r11 == false) goto L14;
    L19:
        this.f6978a = r13;
        x8.c.k(this.f6980c).i(r10, false);
        return;
    L14:
        if (((((long) r12.f6968j) * 1000) + this.f6978a) <= r13) goto L19;
        if (Logger.debug() == false) goto L21;
        Logger.d("TNCManager", "doUpdateRemote, time limit");
        return;
    L21:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void d(String r13, a0 r14) {
        if (r14 != null) goto L5;
        return;
    L5:
        if (this.f6990m == true) goto L7;
        return;
    L7:
        String r15 = r14.n("tt-idc-switch");
        if (TextUtils.isEmpty(r15) == true) goto L10;
        String[] r16 = r15.split("@");
        if (r16 == null) goto L53;
        if (r16.length != 2) goto L53;
        long r8 = 0;
        int r10 = Integer.parseInt(r16[0]);     // Catch: Throwable -> L24
        long r11 = Long.parseLong(r16[1]);     // Catch: Throwable -> L22
    L31:
        if (Logger.debug() == false) goto L34;
        Logger.d("TNCManager", "handleTncProbe, local: " + this.f6982e + "@" + this.f6983f + " svr: " + r10 + "@" + r11 + " " + r13);
    L34:
        if (r11 > this.f6983f) goto L36;
        return;
    L36:
        this.f6982e = r10;
        this.f6983f = r11;
        this.f6980c.getSharedPreferences("ttnet_tnc_config", 0).edit().putInt("tnc_probe_cmd", r10).putLong("tnc_probe_version", r11).apply();
        if (this.f6982e != 10000) goto L61;
        d9.b r17 = this.f6981d;
        if (r17 == null) goto L41;
        d9.a r18 = r17.f6972b;
    L42:
        if (r18 != null) goto L44;
        return;
    L44:
        Random r12 = new Random(System.currentTimeMillis());
        int r19 = r18.f6969k;
        if (r19 <= 0) goto L48;
        r8 = ((long) r12.nextInt(r19)) * 1000;
    L48:
        if (Logger.debug() == false) goto L50;
        Logger.d("TNCManager", "handleTncProbe, updateConfig delay: " + r8 + " " + r13);
    L50:
        h(true, r8, b.f6999r);
        return;
    L41:
        r18 = null;
        goto L42
    L61:
        return;
    L22:
        th = th;
    L26:
        th.printStackTrace();
        if (Logger.debug() == false) goto L29;
        Logger.d("TNCManager", "handleTncProbe, probeProto except, " + r13);
    L29:
        r11 = 0;
    L24:
        th = th;
        r10 = 0;
    L53:
        if (Logger.debug() == false) goto L62;
        Logger.d("TNCManager", "handleTncProbe, probeProto err, " + r13);
        return;
    L62:
        return;
    L10:
        if (Logger.debug() == false) goto L60;
        Logger.d("TNCManager", "handleTncProbe, no probeProto, " + r13);
        return;
    }

    public final synchronized void e(y r10, a0 r11) {
        monitor-enter(this);
        if (r10 == null) goto L104;
        if (r11 == null) goto L104;
    L101:
        th = move-exception;
        throw th;
    L8:
        if (this.f6990m == true) goto L12;
        monitor-exit(this);
        return;
    L12:
        if (r5.e.e(this.f6980c) == true) goto L15;
        monitor-exit(this);
        return;
    L15:
        r r12 = r10.f13337a;     // Catch: Throwable -> L101
        String r8 = r12.f13241a;     // Catch: Throwable -> L101
        String r13 = r12.f13244d;     // Catch: Throwable -> L101
        String r14 = r12.e();     // Catch: Throwable -> L101
        int r15 = r11.f13116m;     // Catch: Throwable -> L101
        if ("http".equals(r8) == true) goto L22;
        if (LocationInfoConst.HTTPS.equals(r8) == true) goto L22;
        monitor-exit(this);
        return;
    L22:
        if (TextUtils.isEmpty(r13) == false) goto L26;
        monitor-exit(this);
        return;
    L26:
        if (r11.f13121r != null) goto L30;
        monitor-exit(this);
        return;
    L30:
        if (Logger.debug() == false) goto L32;
        Logger.d("TNCManager", "onOk3Response, url: " + r8 + "://" + r13 + "#" + r15);     // Catch: Throwable -> L101
    L32:
        d9.b r16 = this.f6981d;     // Catch: Throwable -> L101
        d9.a r17 = null;
        if (r16 == null) goto L35;
        d9.a r18 = r16.f6972b;     // Catch: Throwable -> L101
    L36:
        if (r18 != null) goto L38;
    L40:
        if (r18 != null) goto L42;
    L99:
        monitor-exit(this);
        return;
    L42:
        if (r18.f6959a == false) goto L99;
        HashMap r19 = r18.f6961c;     // Catch: Throwable -> L101
        if (r19 != null) goto L47;
    L97:
        monitor-exit(this);
        return;
    L47:
        if (r19.size() <= 0) goto L97;
        if (r18.f6961c.containsKey(r13) == false) goto L97;
        if (Logger.debug() == false) goto L54;
        Logger.d("TNCManager", "onOk3Response, url matched: " + r8 + "://" + r13 + "#" + r15 + " " + this.f6984g + "#" + this.f6985h.size() + "#" + this.f6986i.size() + " " + this.f6987j + "#" + this.f6988k.size() + "#" + this.f6989l.size());     // Catch: Throwable -> L101
    L54:
        if (r15 > 0) goto L56;
    L95:
        monitor-exit(this);
        return;
    L56:
        if (r15 >= 200) goto L58;
    L60:
        boolean r110 = false;
    L61:
        if (r110 == false) goto L68;
        if (this.f6984g <= 0) goto L65;
    L94:
        g();     // Catch: Throwable -> L101
        goto L95
    L65:
        if (this.f6987j <= 0) goto L95;
    L68:
        if (r15 >= 100) goto L70;
    L82:
        boolean r111 = true;
    L83:
        if (r111 == true) goto L95;
        this.f6987j++;     // Catch: Throwable -> L101
        this.f6988k.put(r14, 0);     // Catch: Throwable -> L101
        this.f6989l.put(r13, 0);     // Catch: Throwable -> L101
        if (this.f6987j < r18.f6965g) goto L95;
        if (this.f6988k.size() < r18.f6966h) goto L95;
        if (this.f6989l.size() < r18.f6967i) goto L95;
        if (Logger.debug() == false) goto L93;
        Logger.d("TNCManager", "onOk3Response, url doUpdate: " + r8 + "://" + r13 + "#" + r15);     // Catch: Throwable -> L101
    L93:
        h(false, 0, b.f6997p);     // Catch: Throwable -> L101
        goto L94
    L70:
        if (r15 >= 1000) goto L82;
        d9.b r112 = this.f6981d;     // Catch: Throwable -> L101
        if (r112 == null) goto L75;
        r17 = r112.f6972b;     // Catch: Throwable -> L101
    L75:
        if (r17 != null) goto L77;
    L81:
        r111 = false;
        goto L83
    L77:
        if (TextUtils.isEmpty(r17.f6970l) == true) goto L81;
        if (r17.f6970l.contains("" + r15) == false) goto L81;
    L58:
        if (r15 >= 400) goto L60;
        r110 = true;
        goto L61
    L38:
        if (r18.f6960b == false) goto L40;
        d(r13, r11);     // Catch: Throwable -> L101
        goto L40
    L35:
        r18 = null;
    L104:
        monitor-exit(this);
    }

    public final synchronized void f(y r8, Exception r10) {
        monitor-enter(this);
        if (r8 != null) goto L73;
        monitor-exit(this);
        return;
    L73:
    L68:
        th = move-exception;
        throw th;
    L6:
        if (this.f6990m == true) goto L10;
        monitor-exit(this);
        return;
    L10:
        if (r5.e.e(this.f6980c) == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        r r11 = r8.f13337a;     // Catch: Throwable -> L68
        String r12 = r11.f13241a;     // Catch: Throwable -> L68
        String r13 = r11.f13244d;     // Catch: Throwable -> L68
        String r14 = r11.e();     // Catch: Throwable -> L68
        StringWriter r15 = new StringWriter();     // Catch: Throwable -> L68
        r10.printStackTrace(new PrintWriter(r15));     // Catch: Throwable -> L68
        String r16 = r15.toString().toLowerCase();     // Catch: Throwable -> L68
        if ("http".equals(r12) == true) goto L20;
        if (LocationInfoConst.HTTPS.equals(r12) == true) goto L20;
        monitor-exit(this);
        return;
    L20:
        if (TextUtils.isEmpty(r13) == false) goto L24;
        monitor-exit(this);
        return;
    L24:
        if (TextUtils.isEmpty(r16) == false) goto L26;
    L66:
        monitor-exit(this);
        return;
    L26:
        if (r16.contains("timeout") == false) goto L66;
        if (r16.contains("time out") == false) goto L66;
        if (r16.contains("unreachable") == true) goto L66;
        d9.b r17 = this.f6981d;     // Catch: Throwable -> L68
        if (r17 == null) goto L35;
        d9.a r18 = r17.f6972b;     // Catch: Throwable -> L68
    L36:
        if (r18 != null) goto L38;
    L64:
        monitor-exit(this);
        return;
    L38:
        if (r18.f6959a == false) goto L64;
        HashMap r19 = r18.f6961c;     // Catch: Throwable -> L68
        if (r19 != null) goto L43;
    L62:
        monitor-exit(this);
        return;
    L43:
        if (r19.size() <= 0) goto L62;
        if (r18.f6961c.containsKey(r13) == false) goto L62;
        if (Logger.debug() == false) goto L50;
        Logger.d("TNCManager", "onOk3Timeout, url matched: " + r12 + "://" + r13 + "#" + r16 + " " + this.f6984g + "#" + this.f6985h.size() + "#" + this.f6986i.size() + " " + this.f6987j + "#" + this.f6988k.size() + "#" + this.f6989l.size());     // Catch: Throwable -> L68
    L50:
        this.f6984g++;     // Catch: Throwable -> L68
        this.f6985h.put(r14, 0);     // Catch: Throwable -> L68
        this.f6986i.put(r13, 0);     // Catch: Throwable -> L68
        if (this.f6984g >= r18.f6962d) goto L53;
    L60:
        monitor-exit(this);
        return;
    L53:
        if (this.f6985h.size() < r18.f6963e) goto L60;
        if (this.f6986i.size() < r18.f6964f) goto L60;
        if (Logger.debug() == false) goto L59;
        Logger.d("TNCManager", "onOk3Timeout, url doUpate: " + r12 + "://" + r13);     // Catch: Throwable -> L68
    L59:
        h(false, 0, b.f6997p);     // Catch: Throwable -> L68
        g();     // Catch: Throwable -> L68
        goto L60
    L35:
        r18 = null;
        goto L36
    }

    public final void g() {
        if (Logger.debug() == false) goto L5;
        Logger.d("TNCManager", "resetTNCControlState");
    L5:
        this.f6984g = 0;
        this.f6985h.clear();
        this.f6986i.clear();
        this.f6987j = 0;
        this.f6988k.clear();
        this.f6989l.clear();
    }

    public final void h(boolean r8, long r10, b r11) {
        a r12 = this.f6991n;
        if (r12.hasMessages(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) == false) goto L5;
        return;
    L5:
        Message r13 = r12.obtainMessage();
        r13.what = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        r13.arg1 = r8 ? 1 : 0;
        r13.arg2 = r11.f7004a;
        if (r10 <= 0) goto L8;
        r12.sendMessageDelayed(r13, r10);
        return;
    L8:
        r12.sendMessage(r13);
    }
}
