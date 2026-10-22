package w1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.UiThread;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import com.bytedance.common.wschannel.l;
import com.bytedance.common.wschannel.server.NetworkUtils;
import com.bytedance.crash.event.EnsureReportData;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.TlsVersion;
import okhttp3.c0;
import okhttp3.s;
import okhttp3.w;
import okhttp3.x;
import okhttp3.z;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
class c implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f13251c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i f13252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private w1.d f13253h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private w f13254i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f13255j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private x f13256k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f13257l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Map<String, Object> f13258m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Handler f13259n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private y1.c f13260o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private k f13261p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private y1.a f13262q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f13263r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private b2.a f13264s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private b2.b f13265t;

    class a implements b2.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f13266a;

        a(c r10) {
            this.f13266a = r10;
        }

        @Override // b2.c
        public void a() {
            c.q(this.f13266a);
        }

        @Override // b2.c
        public void b() {
            c.r(this.f13266a);
        }
    }

    class b implements b2.b.InterfaceC0024b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f13267a;

        b(c r10) {
            this.f13267a = r10;
        }

        @Override // b2.b.InterfaceC0024b
        public void onTimeout() {
            c.q(this.f13267a);
        }
    }

    /* JADX INFO: renamed from: w1.c$c, reason: collision with other inner class name */
    class RunnableC0310c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f13268c;

        RunnableC0310c(c r10) {
            this.f13268c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.s(this.f13268c, true);
            c.t(this.f13268c);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f13269c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f13270g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f13271h;

        d(c r10, Map r11, List r12) {
            this.f13271h = r10;
            this.f13269c = r11;
            this.f13270g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r10 = this.f13271h.D();
            if (r10 != 4) goto L5;
        L11:
            Log.d("WsChannelSdk_ok", "cancel connect :,current state = " + r10);
            return;
        L5:
            if (r10 == 1) goto L11;
            if (r10 == 5) goto L11;
            this.f13271h.X(this.f13269c);
            c r11 = this.f13271h;
            r11.handleMsg(c.a(r11).obtainMessage(2, this.f13270g));
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f13272c;

        e(c r10) {
            this.f13272c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13272c.a0();
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f13273c;

        f(c r10) {
            this.f13273c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
        L6:
            th = move-exception;
            d2.a.c().b(th);     // Catch: Throwable -> L10
        L5:
            c.c(this.f13273c).b();
            return;
        L10:
            th = move-exception;
            c.c(this.f13273c).b();
            throw th;
        L3:
            if (c.b(this.f13273c) == null) goto L5;
            Logger.d("WsChannelSdk_ok", "send ping");     // Catch: Throwable -> L6
            c.b(this.f13273c).b();     // Catch: Throwable -> L6
            goto L5
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f13274c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f13275g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f13276h;

        g(c r10, Map r11, List r12) {
            this.f13276h = r10;
            this.f13274c = r11;
            this.f13275g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13276h.X(this.f13274c);
            c r10 = this.f13276h;
            r10.handleMsg(c.a(r10).obtainMessage(7, this.f13275g));
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f13277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f13278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private w f13279c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private x1.b f13280d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private b2.a f13281e;

        h(Context r10) {
            this.f13277a = r10;
        }

        public c a() {
            return new c(new i(this.f13277a, this.f13278b, this.f13279c, this.f13280d, this.f13281e), null);
        }

        h b(b2.a r10) {
            if (r10 == null) goto L4;
            this.f13281e = r10;
        L4:
            return this;
        }

        h c(x1.b r10) {
            this.f13280d = r10;
            return this;
        }
    }

    static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f13282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f13283b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private w f13284c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private x1.b f13285d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private b2.a f13286e;

        i(Context r10, List<String> r11, w r12, x1.b r13, b2.a r14) {
            this.f13282a = r10;
            this.f13283b = r11;
            this.f13284c = r12;
            this.f13285d = r13;
            this.f13286e = r14;
        }

        static /* synthetic */ Context a(i r10) {
            return r10.f13282a;
        }

        static /* synthetic */ w b(i r10) {
            return r10.f13284c;
        }

        static /* synthetic */ b2.a c(i r10) {
            return r10.f13286e;
        }

        static /* synthetic */ List d(i r10) {
            return r10.f13283b;
        }

        static /* synthetic */ List e(i r10, List r11) {
            r10.f13283b = r11;
            return r11;
        }

        static /* synthetic */ x1.b f(i r10) {
            return r10.f13285d;
        }

        public String toString() {
            return "Config{mHeartBeatPolicy=" + this.f13286e + ", mContext=" + this.f13282a + ", wsUrls=" + this.f13283b + ", mOkHttpClient=" + this.f13284c + ", mRetryPolicy=" + this.f13285d + '}';
        }
    }

    private class j extends y1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f13287a;

        class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f13288c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f13289g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f13290h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ y1.b f13291i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ Pair f13292j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            final /* synthetic */ j f13293k;

            a(j r10, String r11, int r12, String r13, y1.b r14, Pair r15) {
                this.f13293k = r10;
                this.f13288c = r11;
                this.f13289g = r12;
                this.f13290h = r13;
                this.f13291i = r14;
                this.f13292j = r15;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.d("WsChannelSdk_ok", "----------onFailure--------");
                if (c.e(this.f13293k.f13287a) == null) goto L6;
                c.e(this.f13293k.f13287a).b(this.f13288c, this.f13289g, this.f13290h);
            L6:
                if (c.h(this.f13293k.f13287a) == false) goto L10;
                c.i(this.f13293k.f13287a, false);
                c r10 = this.f13293k.f13287a;
                c.k(r10, c.j(r10).c());
                return;
            L10:
                if (c.b(this.f13293k.f13287a) == this.f13291i) goto L14;
                Logger.d("WsChannelSdk_ok", "socket is expired");
                return;
            L14:
                if (j.b(this.f13293k, this.f13289g) == false) goto L16;
                c.c(this.f13293k.f13287a).c();
                c.l(this.f13293k.f13287a, ((Long) this.f13292j.second).longValue(), (String) this.f13292j.first, false);
                return;
            L16:
                c.d(this.f13293k.f13287a, 2);
                c.p(this.f13293k.f13287a);
            }
        }

        private j(c r10) {
            this.f13287a = r10;
        }

        /* synthetic */ j(c r10, a r11) {
            this(r10);
        }

        static /* synthetic */ boolean b(j r10, int r11) {
            return r10.c(r11);
        }

        private boolean c(int r10) {
            if (r10 > 0) goto L4;
        L13:
            return true;
        L4:
            if (r10 == 414) goto L13;
            if (r10 == 511) goto L13;
            if (r10 == 512) goto L13;
            if (r10 == 513) goto L13;
            return false;
        }

        @Override // y1.c
        public void a(y1.b r10, Throwable r11, z r12) {
            String r13 = c.g(this.f13287a, r10);
            int r14 = c.m(this.f13287a, r12);
            String r15 = c.n(this.f13287a, r14);
            if (com.bytedance.common.utility.g.b(r15) == true) goto L5;
            String r16 = r15;
        L10:
            Pair<String, Long> r17 = c.j(this.f13287a).b(r12);
            c.o(this.f13287a, r12);
            c.f(this.f13287a, new a(this, r13, r14, r16, r10, r17));
            return;
        L5:
            if (com.bytedance.common.utility.g.b(r11.getMessage()) == false) goto L7;
            String r18 = Log.getStackTraceString(r11);
        L8:
            r16 = r18;
            goto L10
        L7:
            r18 = r11.getMessage();
            goto L8
        }
    }

    interface k {
        void a(String r10);

        void b(String r10, int r11, String r12);
    }

    private c(i r10) {
        this.f13255j = 3;
        this.f13258m = new ConcurrentHashMap();
        this.f13259n = new WeakHandler(Looper.myLooper(), this);
        this.f13260o = new j(this, null);
        this.f13252g = r10;
        this.f13251c = i.a(r10);
        this.f13254i = i.b(r10);
        b2.a r11 = i.c(r10);
        this.f13264s = r11;
        if (r11 != null) goto L5;
        this.f13264s = new e2.b(new e2.a().c());
    L5:
        this.f13264s.d(new a(this), this.f13259n);
        this.f13265t = new b2.b(new b(this), this.f13259n);
    }

    /* synthetic */ c(i r10, a r11) {
        this(r10);
    }

    private static w.a A(w.a r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 >= 16) goto L5;
    L15:
        return r10;
    L5:
        if (r11 >= 22) goto L15;
        SSLContext r12 = SSLContext.getInstance("TLSv1.2");     // Catch: Exception -> L13
        r12.init(null, null, null);     // Catch: Exception -> L13
        r10 = B(r10, r12);     // Catch: Exception -> L9
    L11:
        okhttp3.k r13 = new okhttp3.k.a(okhttp3.k.f11985g).f(new TlsVersion[]{TlsVersion.TLS_1_2}).a();     // Catch: Exception -> L13
        ArrayList r14 = new ArrayList();     // Catch: Exception -> L13
        r14.add(r13);     // Catch: Exception -> L13
        r14.add(okhttp3.k.f11986h);     // Catch: Exception -> L13
        r14.add(okhttp3.k.f11987i);     // Catch: Exception -> L13
        r10.f(r14);     // Catch: Exception -> L13
        goto L15
    L9:
        e = move-exception;
        Log.e("WsChannelSdk_ok", "Error while setting TLS 1.2 with two parameter func", e);     // Catch: Exception -> L13
        r10.W(new w1.b(r12.getSocketFactory()));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.e("WsChannelSdk_ok", "Error while setting TLS 1.2", e);
        goto L15
    }

    private static w.a B(w.a r10, SSLContext r11) {
        TrustManagerFactory r12 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r12.init(null);
        TrustManager[] r13 = r12.getTrustManagers();
        if (r13.length != 1) goto L9;
        if ((r13[0] instanceof X509TrustManager) == false) goto L9;
        r10.X(new w1.b(r11.getSocketFactory()), (X509TrustManager) r13[0]);
        return r10;
    L9:
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(r13));
    }

    private void C() {
        y1.a r10 = this.f13262q;
        if (r10 == null) goto L6;
        r10.f(1000, "normal close");
        return;
    }

    private int E(z r10) {
        if (r10 != null) goto L9;
        return -1;
    L9:
        return Integer.parseInt(r10.p("Handshake-Status"));
    L11:
        return -1;
    }

    private String F(int r10) {
        if (r10 != 0) goto L5;
        return "success";
    L5:
        if (r10 != 404) goto L8;
        return "uri not found";
    L8:
        if (r10 != 409) goto L11;
        return "fpid not registered";
    L11:
        if (r10 != 410) goto L14;
        return "invalid device id";
    L14:
        if (r10 != 411) goto L17;
        return "appid not registered";
    L17:
        if (r10 != 412) goto L20;
        return "websocket protocol not support";
    L20:
        if (r10 != 413) goto L23;
        return "the device already connected";
    L23:
        if (r10 != 414) goto L26;
        return "server can't accept more connection,try again later";
    L26:
        if (r10 != 415) goto L29;
        return "device was blocked";
    L29:
        if (r10 != 416) goto L32;
        return "parameter error";
    L32:
        if (r10 != 417) goto L35;
        return "authentication failed";
    L35:
        if (r10 != 510) goto L38;
        return "server internal error";
    L38:
        if (r10 != 511) goto L41;
        return "server is busy，try again later";
    L41:
        if (r10 != 512) goto L44;
        return "server is shutting down";
    L44:
        if (r10 != 513) goto L47;
        return "auth server is error";
    L47:
        if (r10 != 514) goto L49;
        return "auth return error";
    L49:
        return "";
    }

    private void G(String r10) {
        if (this.f13254i != null) goto L5;
        w.a r11 = new w.a();
        r11.S(Collections.singletonList(Protocol.HTTP_1_1));
        this.f13254i = A(r11).c();
    L5:
        Map<String, Object> r12 = this.f13258m;
        String r13 = w(r10, r12);
        if (r12 == null) goto L8;
        Map r14 = (Map) r12.get(WsConstants.KEY_HEADERS);
    L10:
        if (com.bytedance.common.utility.g.b(r13) == false) goto L13;
        Logger.e("WsChannelSdk_ok", "url is empty,cancel connect");
        return;
    L13:
        C();
        Logger.d("WsChannelSdk_ok", "try tu open socket:" + r13);
        x r15 = this.f13256k;
        if (r15 != null) goto L16;
    L17:
        x.a r16 = new x.a().a("Sec-Websocket-Protocol", "pbbp").a("x-support-ack", NetConst.ENCRYPT_VERISON_CODE).k(r13);
        if (r14 == null) goto L23;
        Iterator r17 = r14.entrySet().iterator();
    L21:
        if (r17.hasNext() == false) goto L23;
        Map.Entry r18 = (Map.Entry) r17.next();
        r16.a((String) r18.getKey(), (String) r18.getValue());
    L23:
        this.f13256k = r16.b();
    L24:
        Y(1);
        y1.a r19 = y1.a.h(this.f13256k, l.f(this.f13251c).d(), this.f13260o);
        this.f13262q = r19;
        r19.g(this.f13254i);
        this.f13265t.d(this.f13262q);
        k r20 = this.f13261p;
        if (r20 == null) goto L29;
        r20.a(r13);
        return;
    L29:
        return;
    L16:
        if (r13.equals(r15.l().toString()) == true) goto L24;
    L8:
        r14 = null;
        goto L10
    }

    @SuppressLint({"MissingPermission"})
    private boolean I(Context r10) {
        return NetworkUtils.c(r10);
    }

    private int J() {
        NetworkUtils.NetworkType r10 = NetworkUtils.b(this.f13251c);
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10 != NetworkUtils.NetworkType.NONE) goto L9;
        return 0;
    L9:
        if (r10 != NetworkUtils.NetworkType.WIFI) goto L13;
        return 1;
    L13:
        if (r10 != NetworkUtils.NetworkType.MOBILE_2G) goto L17;
        return 2;
    L17:
        if (r10 != NetworkUtils.NetworkType.MOBILE_3G) goto L20;
        return 3;
    L20:
        return 4;
    }

    private void K(String r10, int r11, String r12, boolean r13) {
        Y(2);
        Q();
        k r14 = this.f13261p;
        if (r14 == null) goto L7;
        if (r13 == false) goto L8;
        r14.b(r10, r11, r12);
        return;
    L8:
        return;
    }

    private void O() {
        x r10 = this.f13256k;
        if (r10 == null) goto L7;
        k r11 = this.f13261p;
        if (r11 == null) goto L7;
        r11.b(r10.l().toString(), 3, "heatbeat timeout");
    L7:
        Pair<String, Long> r12 = this.f13253h.b(null);
        b0();
        C();
        d0(0, (String) r12.first, true);
    }

    private void P() {
        this.f13259n.post(new f(this));
    }

    private void Q() {
        w1.d r10 = this.f13253h;
        if (r10 == null) goto L6;
        r10.d();
        return;
    }

    private void R(Runnable r10) {
        this.f13259n.post(r10);
    }

    private void S(Closeable r10) {
        if (r10 == null) goto L8;
        r10.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    private String T(c0 r10) {
        if (r10 == null) goto L9;
        x r11 = r10.a();
        if (r11 == null) goto L11;
        s r12 = r11.l();
        if (r12 != null) goto L8;
        return "";
    L8:
        return r12.toString();
    L11:
        return "";
    L9:
        return "";
    }

    private boolean U(Object r10) {
        Logger.d("WsChannelSdk_ok", "send msg : " + r10);
        if (this.f13262q != null) goto L5;
    L12:
        return false;
    L5:
        if (H() == false) goto L12;
        if ((r10 instanceof String) == false) goto L10;
        return this.f13262q.k((String) r10);
    L10:
        if ((r10 instanceof ByteString) == false) goto L12;
        return this.f13262q.l((ByteString) r10);
    }

    private boolean V(ByteString r10) {
        return U(r10);
    }

    private synchronized void Y(int r10) {
        monitor-enter(this);
        this.f13255j = r10;     // Catch: Throwable -> L24
        String r11 = "";
        if (r10 != 1) goto L7;
        r11 = "connecting";
    L21:
        Logger.d("WsChannelSdk_ok", "current status is :" + r11);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L7:
        if (r10 != 2) goto L10;
        r11 = "connect failed";
        goto L21
    L10:
        if (r10 != 3) goto L13;
        r11 = "connection close ";
        goto L21
    L13:
        if (r10 != 4) goto L16;
        r11 = "connected";
        goto L21
    L16:
        if (r10 != 5) goto L19;
        r11 = "retry...";
        goto L21
    L19:
        if (r10 != 6) goto L21;
        r11 = "half-close status";
    L24:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ Handler a(c r10) {
        return r10.f13259n;
    }

    static /* synthetic */ y1.a b(c r10) {
        return r10.f13262q;
    }

    private void b0() {
        this.f13259n.removeMessages(2);
        this.f13259n.removeMessages(1);
        this.f13259n.removeMessages(3);
        this.f13259n.removeMessages(5);
        u();
        y();
    }

    static /* synthetic */ b2.a c(c r10) {
        return r10.f13264s;
    }

    @UiThread
    private void c0(String r10) {
        if (I(this.f13251c) == true) goto L6;
        K(r10, 1, "network error", true);
        return;
    L6:
        int r11 = D();
        if (r11 == 4) goto L24;
        if (r11 == 1) goto L25;
        G(r10);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        if (this.f13261p == null) goto L16;
        this.f13261p.b(r10, 4, Log.getStackTraceString(th));
    L16:
        if (WsConstants.TTNET_TRAFFIC_CONTROL_DROP.equals(th.getMessage()) == false) goto L26;
        String r12 = this.f13253h.a();
        if (TextUtils.isEmpty(r12) == true) goto L20;
        Logger.d("WsChannelSdk_ok", th.getMessage() + ":" + r10 + ", try next url:" + r12);
        d0(0, r12, true);
        return;
    L20:
        Logger.d("WsChannelSdk_ok", "All urls are dropped, stop retry.");
        this.f13253h.d();
        return;
    L26:
        return;
    L25:
        return;
    }

    static /* synthetic */ void d(c r10, int r11) {
        r10.Y(r11);
    }

    @UiThread
    private void d0(long r10, String r11, boolean r12) {
        this.f13259n.removeMessages(1);
        if (I(this.f13251c) == true) goto L7;
        K(r11, 1, "network error", r12);
        Logger.d("WsChannelSdk_ok", "network not available，cancel retry");
        return;
    L7:
        if (this.f13257l == false) goto L11;
        Logger.d("WsChannelSdk_ok", "close manually");
        return;
    L11:
        if (r10 != (-1)) goto L13;
    L16:
        Logger.d("WsChannelSdk_ok", "retry finished ---> interval: " + r10 + " , url :" + r11);
        Logger.d("WsChannelSdk_ok", "retry finished，waiting the next time to reconnect");
        Bundle r13 = new Bundle();
        r13.putString(EnsureReportData.METHOD, "tryReconnect");
        r13.putLong("interval", r10);
        K(r11, 2, "retry failed", r12);
        r11 = this.f13253h.c();
    L17:
        Logger.d("WsChannelSdk_ok", "the next time to reconnect is " + g2.c.h(System.currentTimeMillis() + r10));
        Message r14 = new Message();
        r14.what = 1;
        r14.obj = r11;
        this.f13259n.sendMessageDelayed(r14, r10);
        return;
    L13:
        if (com.bytedance.common.utility.g.b(r11) == true) goto L16;
        Y(5);
        goto L17
    }

    static /* synthetic */ k e(c r10) {
        return r10.f13261p;
    }

    static /* synthetic */ void f(c r10, Runnable r11) {
        r10.R(r11);
    }

    static /* synthetic */ String g(c r10, c0 r11) {
        return r10.T(r11);
    }

    static /* synthetic */ boolean h(c r10) {
        return r10.f13263r;
    }

    static /* synthetic */ boolean i(c r10, boolean r11) {
        r10.f13263r = r11;
        return r11;
    }

    static /* synthetic */ w1.d j(c r10) {
        return r10.f13253h;
    }

    static /* synthetic */ void k(c r10, String r11) {
        r10.c0(r11);
    }

    static /* synthetic */ void l(c r10, long r11, String r12, boolean r13) {
        r10.d0(r11, r12, r13);
    }

    static /* synthetic */ int m(c r10, z r11) {
        return r10.E(r11);
    }

    static /* synthetic */ String n(c r10, int r11) {
        return r10.F(r11);
    }

    static /* synthetic */ void o(c r10, Closeable r11) {
        r10.S(r11);
    }

    static /* synthetic */ void p(c r10) {
        r10.Q();
    }

    static /* synthetic */ void q(c r10) {
        r10.O();
    }

    static /* synthetic */ void r(c r10) {
        r10.P();
    }

    static /* synthetic */ boolean s(c r10, boolean r11) {
        r10.f13257l = r11;
        return r11;
    }

    static /* synthetic */ void t(c r10) {
        r10.b0();
    }

    private void u() {
        Q();
        this.f13259n.removeMessages(1);
    }

    private String w(String r10, Map<String, Object> r11) {
        if (TextUtils.isEmpty(r10) == true) goto L44;
        if (r11 == null) goto L44;
        String r12 = g2.c.o(String.valueOf(r11.get(WsConstants.KEY_FPID)) + String.valueOf(r11.get(WsConstants.KEY_APP_KEY)) + String.valueOf(r11.get("device_id")) + WsConstants.SALT).toLowerCase();
        Uri.Builder r13 = Uri.parse(r10).buildUpon();
        Iterator<Map.Entry<String, Object>> r14 = r11.entrySet().iterator();
    L8:
        if (r14.hasNext() == false) goto L29;
        Map.Entry<String, Object> r15 = r14.next();
        if (r15 == null) goto L8;
        if (TextUtils.isEmpty(r15.getKey()) == true) goto L8;
        if (TextUtils.equals(r15.getKey(), WsConstants.KEY_HEADERS) == true) goto L8;
        if (r15.getValue() != null) goto L20;
        String r16 = "";
    L21:
        String r17 = r15.getKey();
        if (com.bytedance.common.utility.g.a(WsConstants.KEY_APP_KEY, r17) == true) goto L8;
        if (com.bytedance.common.utility.g.a(r17, WsConstants.KEY_EXTRA) == true) goto L8;
        if (com.bytedance.common.utility.g.a("app_version", r17) == false) goto L28;
        r17 = "version_code";
    L28:
        r13.appendQueryParameter(r17, r16);
        goto L8
    L20:
        r16 = r15.getValue().toString();
        goto L21
    L29:
        String r18 = (String) r11.get(WsConstants.KEY_EXTRA);
        if (com.bytedance.common.utility.g.b(r18) == true) goto L39;
        String[] r19 = r18.split("&");
        int r20 = r19.length;
        int r21 = 0;
    L32:
        if (r21 >= r20) goto L39;
        String r22 = r19[r21];
        if (TextUtils.isEmpty(r22) == true) goto L38;
        String[] r23 = r22.split("=");
        if (r23.length != 2) goto L38;
        r13.appendQueryParameter(r23[0], Uri.decode(r23[1]));
    L38:
        r21 = r21 + 1;
    L39:
        r13.appendQueryParameter("access_key", r12);
        r13.appendQueryParameter("ne", String.valueOf(J()));
        String r24 = r13.build().toString();
        Logger.d("WsChannelSdk_ok", "origin url: " + r24);
        String r25 = z(r24);     // Catch: Exception -> L42
        Logger.d("WsChannelSdk_ok", "Dispatch final url: " + r25);     // Catch: Exception -> L42
        return r25;
    L42:
        e = move-exception;
        throw e;
    L44:
        return "";
    }

    private boolean y() {
        int r10 = D();
        if (r10 != 3) goto L5;
        return true;
    L5:
        if (r10 != 2) goto L7;
        return true;
    L7:
        if (r10 == 5) goto L23;
        this.f13264s.c();
        y1.a r11 = this.f13262q;
        if (r11 == null) goto L22;
        Message r12 = this.f13259n.obtainMessage(6, r11);
        this.f13259n.sendMessageDelayed(r12, 1000);
        if (r10 != 4) goto L15;
        this.f13262q.d(1000, "normal close");
        Y(6);
        return false;
    L15:
        this.f13262q.c();
        Y(3);
        if (r10 == 1) goto L19;
        return true;
    L19:
        return false;
    L22:
        return true;
    L23:
        return true;
    }

    private String z(String r10) {
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().m() == true) goto L19;
        y2.c r11 = new y2.c(r10, "GET");
        y2.b r12 = com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().d(r11);
        if (r12 != null) goto L7;
    L24:
        return r10;
    L7:
        if (r10.equals(r12.f13666a) == true) goto L24;
        if (r12.f13666a.isEmpty() == false) goto L16;
        if (r12.f13667b.isEmpty() == true) goto L16;
        throw new Exception(WsConstants.TTNET_TRAFFIC_CONTROL_DROP);
    L16:
        if (com.bytedance.frameworks.baselib.network.http.util.k.f(r12.f13666a) == false) goto L24;
        return r12.f13666a;
    L19:
        Logger.d("WsChannelSdk_ok", "fallback to host replace map");
        String r13 = com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().k(r10);
        if (r10.equals(r13) == true) goto L24;
        if (com.bytedance.frameworks.baselib.network.http.util.k.f(r13) == false) goto L24;
        return r13;
    }

    synchronized int D() {
        monitor-enter(this);
        int r10 = this.f13255j;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    boolean H() {
        if (D() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    void L(boolean r10) {
        this.f13259n.obtainMessage(5, Boolean.valueOf(r10)).sendToTarget();
    }

    void M(int r10) {
        this.f13259n.obtainMessage(3, Integer.valueOf(r10)).sendToTarget();
    }

    void N(Map<String, Object> r10, List<String> r11) {
        if (r11.isEmpty() == false) goto L6;
        Logger.e("WsChannelSdk_ok", "error : no target ws url ,return");
        return;
    L6:
        R(new g(this, r10, r11));
    }

    boolean W(byte[] r10) {
        return V(ByteString.of(r10));
    }

    void X(Map<String, Object> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.remove(WsConstants.KEY_CHANNEL_ID);
        this.f13258m.putAll(r10);
    }

    void Z(k r10) {
        this.f13261p = r10;
    }

    void a0() {
        R(new RunnableC0310c(this));
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r11 = r10.what;
        if (r11 != 1) goto L47;
        if (H() == false) goto L9;
        return;
    L9:
        this.f13259n.removeMessages(1);
        this.f13259n.removeMessages(2);
        String r12 = (String) r10.obj;
    L10:
        c0(r12);
        return;
    L47:
        if (r11 != 2) goto L18;
        this.f13259n.removeMessages(2);     // Catch: Throwable -> L15
        this.f13259n.removeMessages(1);     // Catch: Throwable -> L15
        i.e(this.f13252g, (List) r10.obj);     // Catch: Throwable -> L15
        this.f13257l = false;     // Catch: Throwable -> L15
        this.f13253h = new w1.d(i.d(this.f13252g), i.f(this.f13252g));     // Catch: Throwable -> L15
        u();     // Catch: Throwable -> L15
        c0(this.f13253h.c());     // Catch: Throwable -> L15
    L46:
        return;
    L18:
        if (r11 != 3) goto L33;
        this.f13259n.removeMessages(2);
        this.f13259n.removeMessages(1);
        if (H() == false) goto L22;
        return;
    L22:
        u();
        if (I(this.f13251c) == true) goto L25;
        Logger.d("WsChannelSdk_ok", "network changed! but the network is not available，do not retry");
        return;
    L25:
        if (y() == false) goto L30;
        w1.d r13 = this.f13253h;
        if (r13 != null) goto L29;
        return;
    L29:
        r12 = r13.c();
        goto L10
    L30:
        this.f13263r = true;
        return;
    L33:
        if (r11 != 5) goto L40;
        if (((Boolean) r10.obj).booleanValue() == false) goto L37;
        AppState r14 = AppState.STATE_FOREGROUND;
    L38:
        this.f13265t.e(r14);
        this.f13264s.a(r14);
        return;
    L37:
        r14 = AppState.STATE_BACKGROUND;
        goto L38
    L40:
        if (r11 != 7) goto L54;
        this.f13259n.removeMessages(2);     // Catch: Throwable -> L15
        this.f13259n.removeMessages(1);     // Catch: Throwable -> L15
        i.e(this.f13252g, (List) r10.obj);     // Catch: Throwable -> L15
        this.f13257l = false;     // Catch: Throwable -> L15
        this.f13253h = new w1.d(i.d(this.f13252g), i.f(this.f13252g));     // Catch: Throwable -> L15
        u();     // Catch: Throwable -> L15
        if (y() == false) goto L44;
        c0(this.f13253h.c());     // Catch: Throwable -> L15
        goto L46
    L44:
        this.f13263r = true;     // Catch: Throwable -> L15
        goto L46
    L54:
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
    }

    void v(Map<String, Object> r10, List<String> r11) {
        if (r11.isEmpty() == false) goto L6;
        Logger.e("WsChannelSdk_ok", "error : no target ws url ,return");
        return;
    L6:
        R(new d(this, r10, r11));
    }

    void x() {
        this.f13259n.removeMessages(2);
        this.f13259n.removeMessages(1);
        this.f13259n.removeMessages(3);
        this.f13259n.removeMessages(5);
        R(new e(this));
    }
}
