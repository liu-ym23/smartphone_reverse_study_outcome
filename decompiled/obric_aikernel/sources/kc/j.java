package kc;

import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.q;
import okhttp3.s;
import okhttp3.t;
import okhttp3.w;
import okhttp3.x;
import okhttp3.y;
import okhttp3.z;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f10180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f10184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f10185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<String> f10186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f10187h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public j(w r26) {
        Intrinsics.checkNotNullParameter(r26, "client");
        this.f10180a = r26;
        this.f10181b = "x-tt-token";
        this.f10182c = "Cookie";
        this.f10183d = "Cookie2";
        this.f10184e = CronetHttpURLConnection.SS_COOKIE;
        this.f10185f = "x-tt-bypass-dp";
        this.f10186g = hc.e.w(new String[]{"Accept", "Accept-Charset", NetConst.KEY_ACCEPT_ENCODING, "Accept-Language", "Authorization", "Cache-Control", "Connection", "Content-Length", NetConst.KEY_CONTENT_TYPE, "Host", "If-Match", "If-Modified-Since", "If-None-Match", "If-Range", "If-Unmodified-Since", "Origin", "Pragma", "Proxy-Authorization", "Proxy-Connection", "Range", "Referer", "Transfer-Encoding", "User-Agent"});
    }

    private final x b(z r11, String r12, okhttp3.internal.connection.e r13) {
        y r10 = null;
        if (this.f10180a.s() == true) goto L5;
        return null;
    L5:
        String r14 = z.s(r11, "Location", null, 2, null);
        if (r14 != null) goto L8;
        return null;
    L8:
        boolean r15 = true;
        s r16 = r11.K().l().r(r14, true);
        if (r16 != null) goto L11;
        return null;
    L11:
        s r17 = d(r13, r11.K(), r16, r13.n());
        if (r17 == null) goto L15;
        r16 = r17;
    L15:
        if (Intrinsics.areEqual(r16.s(), r11.K().l().s()) == false) goto L17;
    L19:
        x.a r18 = r11.K().h();
        if (f.a(r12) == false) goto L38;
        int r19 = r11.k();
        f r20 = f.f10166a;
        if (r20.c(r12) == true) goto L28;
        if (r19 == 308) goto L28;
        if (r19 == 307) goto L28;
        r15 = false;
    L28:
        if (r20.b(r12) == false) goto L32;
        if (r19 == 308) goto L32;
        if (r19 == 307) goto L32;
        r12 = "GET";
    L34:
        r18.f(r12, r10);
        if (r15 == true) goto L38;
        r18.h("Transfer-Encoding");
        r18.h("Content-Length");
        r18.h(NetConst.KEY_CONTENT_TYPE);
    L32:
        if (r15 == false) goto L34;
        r10 = r11.K().a();
    L38:
        if (hc.e.j(r11.K().l(), r16) == true) goto L40;
        r18.h("Authorization");
    L40:
        s r21 = r16;
        e(r13, r11.K(), r21, r18, r13.n());
        return r18.l(r16).b();
    L17:
        if (this.f10180a.t() == true) goto L19;
        return null;
    }

    private final x c(z r10, okhttp3.internal.connection.c r11, okhttp3.internal.connection.e r12) {
        if (r11 == null) goto L7;
        RealConnection r13 = r11.h();
        if (r13 == null) goto L7;
        b0 r14 = r13.a();
    L8:
        int r15 = r10.k();
        String r16 = r10.K().g();
        if (r15 == 307) goto L73;
        if (r15 == 308) goto L73;
        if (r15 == 401) goto L71;
        if (r15 != 421) goto L17;
        y r17 = r10.K().a();
        if (r17 != null) goto L61;
    L63:
        if (r11 != null) goto L65;
    L69:
        return null;
    L65:
        if (r11.l() == false) goto L69;
        r11.h().z();
        return r10.K();
    L61:
        if (r17.f() == false) goto L63;
        return null;
    L17:
        if (r15 != 503) goto L19;
        z r18 = r10.G();
        if (r18 == null) goto L54;
        if (r18.k() != 503) goto L54;
        return null;
    L54:
        if (l(r10, Integer.MAX_VALUE) == 0) goto L56;
        return null;
    L56:
        return r10.K();
    L19:
        if (r15 != 407) goto L21;
        Intrinsics.checkNotNull(r14);
        if (r14.c().type() != Proxy.Type.HTTP) goto L47;
        return this.f10180a.E().a(r14, r10);
    L47:
        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
    L21:
        if (r15 == 408) goto L25;
        switch(r15) {
            case 300: goto L73;
            case 301: goto L73;
            case 302: goto L73;
            case 303: goto L73;
            default: goto L23;
        };
    L23:
        return null;
    L25:
        if (this.f10180a.H() == true) goto L27;
        return null;
    L27:
        y r19 = r10.K().a();
        if (r19 != null) goto L30;
    L32:
        z r20 = r10.G();
        if (r20 == null) goto L38;
        if (r20.k() != 408) goto L38;
        return null;
    L38:
        if (l(r10, 0) <= 0) goto L41;
        return null;
    L41:
        return r10.K();
    L30:
        if (r19.f() == false) goto L32;
        return null;
    L71:
        return this.f10180a.f().a(r14, r10);
    L73:
        return b(r10, r16, r12);
    L7:
        r14 = null;
        goto L8
    }

    private final s d(okhttp3.e r10, x r11, s r12, q r13) {
        if (r11 == null) goto L4;
        s r14 = r11.l();
    L5:
        if (r13 == null) goto L16;
        if (r14 == null) goto L17;
        if (r12 == null) goto L18;
        String r15 = r11.d(this.f10185f);
        if (TextUtils.isEmpty(r15) == true) goto L15;
        if (Intrinsics.areEqual(NetConst.ENCRYPT_VERISON_CODE, r15) == false) goto L15;
        return r12;
    L15:
        return r13.f(r10, r14, r11.g(), r12);
    L18:
        return r12;
    L17:
        return r12;
    L16:
        return r12;
    L4:
        r14 = null;
        goto L5
    }

    private final void e(okhttp3.e r10, x r11, s r12, x.a r13, q r14) {
        if (r11 == null) goto L36;
        if (r12 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r12.h()) == false) goto L7;
        return;
    L7:
        if (this.f10180a.q() == false) goto L10;
        return;
    L10:
        if (r11.f() == true) goto L16;
        if (r11.i() != null) goto L14;
    L18:
        boolean r15 = false;
    L19:
        if (r15 == false) goto L24;
        o(r10, r11, r12, true, r13, r14);
        if (sc.a.b(r12.h()) == false) goto L39;
        r13.a("x-metasec-ok-bypass-downgrade-cookie", NetConst.ENCRYPT_VERISON_CODE);
        return;
    L39:
        return;
    L24:
        if (sc.a.d().a().f12801f.get() == false) goto L26;
        return;
    L26:
        if (r11.l().h().equals(r12.h()) == false) goto L28;
        return;
    L28:
        if (r11.i() == null) goto L33;
        if (r12.h().equals(r11.i().h()) == false) goto L33;
        return;
    L33:
        if (g(r12.h()) == true) goto L43;
        o(r10, r11, r12, false, r13, r14);
        return;
    L43:
        return;
    L14:
        if (r11.i().i() == false) goto L18;
    L16:
        if (r12.i() == true) goto L18;
        r15 = true;
        goto L19
    }

    private final boolean f(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        CopyOnWriteArrayList<String> r11 = sc.a.d().a().f12799d;
        Intrinsics.checkNotNullExpressionValue(r11, "inst().redirectRequestCo….mSecureRedirectBlackList");
        Iterator<String> r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L17;
        String r13 = r12.next();
        if (Intrinsics.areEqual(r10, r13) == true) goto L10;
        if (StringsKt.startsWith$default(r13, ".", false, 2, null) == true) goto L14;
        r13 = '.' + r13;
    L14:
        Locale r14 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r14, "getDefault()");
        String r15 = r10.toLowerCase(r14);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).toLowerCase(locale)");
        Locale r16 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r16, "getDefault()");
        String r17 = r13.toLowerCase(r16);
        Intrinsics.checkNotNullExpressionValue(r17, "this as java.lang.String).toLowerCase(locale)");
        if (StringsKt.endsWith$default(r15, r17, false, 2, null) == false) goto L7;
        return true;
    L10:
        return true;
    L17:
        return false;
    }

    private final boolean g(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        CopyOnWriteArrayList<String> r11 = sc.a.d().a().f12797b;
        Intrinsics.checkNotNullExpressionValue(r11, "inst().redirectRequestCo….mSecureRedirectWhiteList");
        Iterator<String> r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L18;
        String r13 = r12.next();
        if (Intrinsics.areEqual(r10, r13) == true) goto L10;
        if (StringsKt.startsWith$default(r13, ".", false, 2, null) == true) goto L14;
        r13 = '.' + r13;
    L14:
        Locale r14 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r14, "getDefault()");
        String r15 = r10.toLowerCase(r14);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).toLowerCase(locale)");
        Locale r16 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r16, "getDefault()");
        String r17 = r13.toLowerCase(r16);
        Intrinsics.checkNotNullExpressionValue(r17, "this as java.lang.String).toLowerCase(locale)");
        if (StringsKt.endsWith$default(r15, r17, false, 2, null) == false) goto L7;
        return true;
    L10:
        return true;
    L18:
        return sc.a.b(r10);
    }

    private final boolean h(IOException r10, boolean r11) {
        if ((r10 instanceof ProtocolException) == false) goto L6;
        return false;
    L6:
        if ((r10 instanceof InterruptedIOException) == false) goto L13;
        if ((r10 instanceof SocketTimeoutException) == false) goto L21;
        if (r11 == false) goto L11;
        return false;
    L11:
        return true;
    L21:
        return false;
    L13:
        if ((r10 instanceof SSLHandshakeException) == false) goto L18;
        if ((r10.getCause() instanceof CertificateException) == false) goto L18;
        return false;
    L18:
        if ((r10 instanceof SSLPeerUnverifiedException) == false) goto L20;
        return false;
    L20:
        return true;
    }

    private final boolean i(IOException r10, okhttp3.internal.connection.e r11, x r12, boolean r13) {
        if (this.f10180a.H() == true) goto L5;
        return false;
    L5:
        if (r13 == false) goto L10;
        if (k(r10, r12) == false) goto L10;
        return false;
    L10:
        if (h(r10, r13) == true) goto L14;
        return m(r10, r12, r11);
    L14:
        if (r11.w() == false) goto L16;
        return true;
    L16:
        return m(r10, r12, r11);
    }

    private final void j(okhttp3.e r10, x r11, s r12, q r13, boolean r14, boolean r15, List<String> r16, sc.a.C0291a r17) {
        JSONObject r18 = new JSONObject();     // Catch: JSONException -> L16
        r18.put("src", "ttok");     // Catch: JSONException -> L16
        if (r17.f12802g.get() == false) goto L6;
        r18.put("origin_url", r11.l());     // Catch: JSONException -> L16
        r18.put("rect_url", r12);     // Catch: JSONException -> L16
    L6:
        r18.put("origin_host", r11.l().s() + "://" + r11.l().h());     // Catch: JSONException -> L16
        r18.put("rect_host", r12.s() + "://" + r12.h());     // Catch: JSONException -> L16
        r18.put("origin_path", r11.l().d());     // Catch: JSONException -> L16
        r18.put("rect_path", r12.d());     // Catch: JSONException -> L16
        JSONArray r19 = new JSONArray();     // Catch: JSONException -> L16
        Iterator<String> r20 = r16.iterator();     // Catch: JSONException -> L16
    L8:
        if (r20.hasNext() == false) goto L10;
        r19.put(r20.next());     // Catch: JSONException -> L16
        goto L8
    L10:
        r18.put("scy_headers", r19);     // Catch: JSONException -> L16
        r18.put("remove_scy_header", r14);     // Catch: JSONException -> L16
        r18.put("downgrade", r15);     // Catch: JSONException -> L16
        if (r17.f12803h.get() == false) goto L13;
        r18.put("ctl_ver", "v2");     // Catch: JSONException -> L16
    L13:
        if (r13 == null) goto L22;
        r13.e(r10, r18);     // Catch: JSONException -> L16
        return;
    L22:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
    }

    private final boolean k(IOException r10, x r11) {
        y r12 = r11.a();
        if (r12 == null) goto L7;
        if (r12.f() == false) goto L7;
    L8:
        return true;
    L7:
        if ((r10 instanceof FileNotFoundException) == true) goto L8;
        return false;
    }

    private final int l(z r10, int r11) {
        String r12 = z.s(r10, "Retry-After", null, 2, null);
        if (r12 != null) goto L6;
        return r11;
    L6:
        if (new Regex("\\d+").matches(r12) == false) goto L9;
        Integer r13 = Integer.valueOf(r12);
        Intrinsics.checkNotNullExpressionValue(r13, "valueOf(header)");
        return r13.intValue();
    L9:
        return Integer.MAX_VALUE;
    }

    private final boolean m(IOException r10, x r11, okhttp3.internal.connection.e r12) {
        if (this.f10187h == false) goto L5;
        return false;
    L5:
        this.f10187h = true;
        int r13 = sc.c.c(r10);
        if (sc.a.d().k(r10, r11, r13) == false) goto L9;
        r12.v(r13);
        sc.b.a().b(r11, true);
        return true;
    L9:
        return false;
    }

    private final void o(okhttp3.e r11, x r12, s r13, boolean r14, x.a r15, q r16) {
        sc.a.C0291a r10 = sc.a.d().a();
        ArrayList r17 = new ArrayList();
        boolean r18 = true;
        if (r10.f12803h.get() == false) goto L5;
        Iterator<Map.Entry<String, List<String>>> r19 = r12.e().h().entrySet().iterator();
    L30:
        if (r19.hasNext() == false) goto L36;
        String r20 = r19.next().getKey();
        List<String> r21 = r10.f12804i;
        Intrinsics.checkNotNullExpressionValue(r21, "redirectConfig.mKeepHeadersV2");
        List<String> r22 = r10.f12805j;
        Intrinsics.checkNotNullExpressionValue(r22, "redirectConfig.mRmStdKeepHeadersV2");
        if (n(r20, r21, r22) == true) goto L30;
        r17.add(r20);
    L36:
        if (r17.isEmpty() == false) goto L38;
        return;
    L38:
        boolean r23 = r18 | r14;
        if (r23 == false) goto L45;
        Iterator<String> r24 = r17.iterator();
    L42:
        if (r24.hasNext() == false) goto L45;
        r15.h(r24.next());
    L45:
        if (r10.f12800e.get() == false) goto L47;
        return;
    L47:
        Intrinsics.checkNotNullExpressionValue(r10, "redirectConfig");
        j(r11, r12, r13, r16, r23, r14, r17, r10);
        return;
    L5:
        if (r10.f12798c.get() == true) goto L11;
        if (f(r13.h()) == true) goto L11;
        r18 = false;
    L11:
        if (TextUtils.isEmpty(r12.d(this.f10181b)) == true) goto L14;
        r17.add(this.f10181b);
    L14:
        if (TextUtils.isEmpty(r12.d(this.f10182c)) == true) goto L17;
        r17.add(this.f10182c);
    L17:
        if (TextUtils.isEmpty(r12.d(this.f10183d)) == true) goto L20;
        r17.add(this.f10183d);
    L20:
        if (TextUtils.isEmpty(r12.d(this.f10184e)) == true) goto L22;
        r17.add(this.f10184e);
    L22:
        Iterator<String> r25 = r10.f12796a.iterator();
    L24:
        if (r25.hasNext() == false) goto L36;
        String r26 = r25.next();
        Intrinsics.checkNotNullExpressionValue(r26, "headerKey");
        if (TextUtils.isEmpty(r12.d(r26)) == true) goto L24;
        r17.add(r26);
        goto L24
    }

    @Override // okhttp3.t
    public z a(t.a r11) {
        Intrinsics.checkNotNullParameter(r11, "chain");
        g r12 = (g) r11;
        x r10 = r12.j();
        okhttp3.internal.connection.e r13 = r12.f();
        List r14 = CollectionsKt.emptyList();
        z r15 = null;
        boolean r16 = true;
        int r17 = 0;
    L3:
        r13.j(r10, r16);
    L51:
        th = move-exception;
        r13.k(true);
        throw th;
    L5:
        if (r13.isCanceled() == true) goto L50;
        z r18 = r12.b(r10);     // Catch: IOException -> L31 RouteException -> L41 Throwable -> L51
    L7:
        if (r15 == null) goto L9;
        r18 = r18.F().o(r15.F().b(null).c()).c();     // Catch: Throwable -> L51
    L9:
        r15 = r18;
        okhttp3.internal.connection.c r19 = r13.o();     // Catch: Throwable -> L51
        x r20 = c(r15, r19, r13);     // Catch: Throwable -> L51
        if (r20 == null) goto L11;
        y r21 = r20.a();     // Catch: Throwable -> L51
        if (r21 != null) goto L20;
    L23:
        a0 r22 = r15.a();     // Catch: Throwable -> L51
        if (r22 == null) goto L26;
        hc.e.m(r22);     // Catch: Throwable -> L51
    L26:
        r17 = r17 + 1;
        if (r17 > 20) goto L30;
        r13.k(true);
        r10 = r20;
        r16 = true;
        goto L3
    L30:
        throw new ProtocolException("Too many follow-up requests: " + r17);     // Catch: Throwable -> L51
    L20:
        if (r21.f() == false) goto L23;
        r13.k(false);
        return r15;
    L11:
        if (r19 != null) goto L13;
    L15:
        r13.k(false);
        return r15;
    L13:
        if (r19.m() == false) goto L15;
        r13.y();     // Catch: Throwable -> L51
    L41:
        e = move-exception;
        if (i(e.getLastConnectException(), r13, r10, false) == false) goto L48;
        e = e.getFirstConnectException();     // Catch: Throwable -> L51
    L45:
        r14 = CollectionsKt.plus(r14, e);     // Catch: Throwable -> L51
        r13.k(true);
        r16 = false;
        goto L3
    L48:
        throw hc.e.Z(e.getFirstConnectException(), r14);     // Catch: Throwable -> L51
    L31:
        e = e;
        if ((e instanceof ConnectionShutdownException) == true) goto L35;
        boolean r23 = true;
    L37:
        if (i(e, r13, r10, r23) == true) goto L45;
        throw hc.e.Z(e, r14);     // Catch: Throwable -> L51
    L35:
        r23 = false;
        goto L37
    L50:
        throw new IOException("Canceled");     // Catch: Throwable -> L51
    }

    public final boolean n(String r10, List<String> r11, List<String> r12) {
        Intrinsics.checkNotNullParameter(r10, "targetHeader");
        Intrinsics.checkNotNullParameter(r11, "keepHeaders");
        Intrinsics.checkNotNullParameter(r12, "rmStdKeepHeaders");
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return true;
    L5:
        Iterator<String> r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L11;
        if (StringsKt.equals(r10, r13.next(), true) == false) goto L7;
        return true;
    L11:
        Iterator<String> r14 = r12.iterator();
    L13:
        if (r14.hasNext() == false) goto L17;
        if (StringsKt.equals(r10, r14.next(), true) == false) goto L13;
        return false;
    L17:
        Iterator<String> r15 = this.f10186g.iterator();
    L19:
        if (r15.hasNext() == false) goto L23;
        if (StringsKt.equals(r10, r15.next(), true) == false) goto L19;
        return true;
    L23:
        return false;
    }
}
