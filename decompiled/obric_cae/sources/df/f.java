package df;

import android.os.Build;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import we.v;
import we.w;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f7097a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f7098b = null;

    static {
        f r8 = null;
        boolean r10 = true;
        if ("Dalvik".equals(System.getProperty("java.vm.name")) == false) goto L39;
        if ("Dalvik".equals(System.getProperty("java.vm.name")) == true) goto L66;
    L14:
        f r11 = null;
    L15:
        if (r11 == null) goto L18;
    L57:
        f7097a = r11;
        f7098b = Logger.getLogger(v.class.getName());
        return;
    L18:
        if ("Dalvik".equals(System.getProperty("java.vm.name")) == true) goto L64;
    L34:
        if (r8 == null) goto L37;
    L35:
        r11 = r8;
        goto L57
    L37:
        throw new NullPointerException("No platform found on Android");
    L64:
        Class<?> r12 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");     // Catch: ClassNotFoundException -> L22
    L21:
        Class<?> r13 = r12;
        n4.b r14 = new n4.b(null, "setUseSessionTickets", new Class[]{Boolean.TYPE});     // Catch: ClassNotFoundException -> L59
        n4.b r15 = new n4.b(null, "setHostname", new Class[]{String.class});     // Catch: ClassNotFoundException -> L59
        if (Security.getProvider("GMSCore_OpenSSL") == null) goto L62;
    L29:
        if (r10 == false) goto L31;
        n4.b r16 = new n4.b(byte[].class, "getAlpnSelectedProtocol", new Class[0]);     // Catch: ClassNotFoundException -> L59
        n4.b r17 = new n4.b(null, "setAlpnProtocols", new Class[]{byte[].class});     // Catch: ClassNotFoundException -> L59
    L32:
        r8 = new b(r13, r14, r15, r16, r17);     // Catch: ClassNotFoundException -> L59
        goto L34
    L31:
        r16 = null;
        r17 = null;
        goto L32
    L62:
        Class.forName("android.net.Network");     // Catch: ClassNotFoundException -> L28
    L28:
        r10 = false;
        goto L29
    L22:
        r12 = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");     // Catch: ClassNotFoundException -> L59
        goto L21
    L66:
        int r18 = Build.VERSION.SDK_INT;     // Catch: NoClassDefFoundError -> L9 ClassNotFoundException -> L60
    L11:
        if (r18 < 29) goto L14;
        r11 = new a(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));     // Catch: ClassNotFoundException -> L60
    L9:
        r18 = 0;
        goto L11
    L39:
        if ("conscrypt".equals(System.getProperty("okhttp.platform")) == false) goto L41;
        boolean r19 = true;
    L42:
        if (r19 == false) goto L70;
        c r20 = c.n();
        if (r20 == null) goto L70;
        r11 = r20;
    L70:
        d r21 = new d(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));     // Catch: NoSuchMethodException -> L48
    L49:
        if (r21 == null) goto L68;
        r11 = r21;
        goto L57
    L68:
        Class<?> r22 = Class.forName("org.eclipse.jetty.alpn.ALPN");     // Catch: Throwable -> L61
        r8 = new e(r22.getMethod("put", new Class[]{SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider")}), r22.getMethod("get", new Class[]{SSLSocket.class}), r22.getMethod("remove", new Class[]{SSLSocket.class}), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));     // Catch: Throwable -> L61
    L54:
        if (r8 != null) goto L35;
        r11 = new f();
    L48:
        r21 = null;
        goto L49
    L41:
        r19 = "Conscrypt".equals(Security.getProviders()[0].getName());
        goto L42
    }

    public f() {
    }

    public static ArrayList b(List r8) {
        ArrayList r10 = new ArrayList(r8.size());
        int r11 = r8.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        w r13 = (w) r8.get(r12);
        if (r13 == w.f13319b) goto L8;
        r10.add(r13.f13326a);
    L8:
        r12 = r12 + 1;
        goto L3
    L9:
        return r10;
    }

    public void a(SSLSocket r8) {
    }

    public android.support.v4.media.a c(X509TrustManager r8) {
        return new gf.a(d(r8));
    }

    public gf.d d(X509TrustManager r8) {
        return new gf.b(r8.getAcceptedIssuers());
    }

    public void e(SSLSocketFactory r8) {
    }

    public void f(SSLSocket r8, @Nullable String r10, List<w> r11) {
    }

    public void g(Socket r8, InetSocketAddress r10, int r11) {
        r8.connect(r10, r11);
    }

    public SSLContext h() {
        if ("1.7".equals(System.getProperty("java.specification.version")) == false) goto L14;
        return SSLContext.getInstance("TLSv1.2");
    L14:
        return SSLContext.getInstance("TLS");
    L8:
        e = move-exception;
        throw new IllegalStateException("No TLS provider", e);
    }

    @Nullable
    public String i(SSLSocket r8) {
        return null;
    }

    public Object j() {
        if (f7098b.isLoggable(Level.FINE) == true) goto L5;
        return null;
    L5:
        return new Throwable("response.body().close()");
    }

    public boolean k(String r8) {
        return true;
    }

    public void l(int r8, @Nullable Throwable r10, String r11) {
        if (r8 != 5) goto L5;
        Level r12 = Level.WARNING;
    L6:
        f7098b.log(r12, r11, r10);
        return;
    L5:
        r12 = Level.INFO;
        goto L6
    }

    public void m(Object r8, String r10) {
        if (r8 != null) goto L4;
        r10 = defpackage.a.e(r10, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
    L4:
        l(5, (Throwable) r8, r10);
    }

    public final String toString() {
        return getClass().getSimpleName();
    }
}
