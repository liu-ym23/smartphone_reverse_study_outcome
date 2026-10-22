package hvc;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import jvc.c;
import jvc.e;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class g {
    public static final g a = null;
    public static final Logger b = null;

    public g() {
    }

    public void b(SSLSocket r1) {
    }

    public void f(SSLSocketFactory r1) {
    }

    public void g(SSLSocket r1, @Nullable String r2, List<Protocol> r3) throws IOException {
    }

    @Nullable
    public String j(SSLSocket r1) {
        return null;
    }

    public boolean l(String r1) {
        return true;
    }

    static {
        b r5 = null;
        if ("Dalvik".equals(System.getProperty("java.vm.name")) == false) goto L41;
        if ("Dalvik".equals(System.getProperty("java.vm.name")) == true) goto L63;
    L15:
        g r7 = null;
    L16:
        if (r7 == null) goto L65;
    L59:
        a = r7;
        b = Logger.getLogger(OkHttpClient.class.getName());
        return;
    L65:
        if ("Dalvik".equals(System.getProperty("java.vm.name")) == false) goto L36;
        Class r0 = b.r("com.android.org.conscrypt.SSLParametersImpl");     // Catch: ClassNotFoundException -> L23
    L22:
        Class r8 = r0;
        f r9 = new f(null, "setUseSessionTickets", new Class[]{Boolean.TYPE});     // Catch: ClassNotFoundException -> L35
        f r10 = new f(null, "setHostname", new Class[]{String.class});     // Catch: ClassNotFoundException -> L35
        if (Security.getProvider("GMSCore_OpenSSL") == null) goto L72;
    L28:
        boolean r1 = true;
    L30:
        if (r1 == false) goto L32;
        f r11 = new f(byte[].class, "getAlpnSelectedProtocol", new Class[0]);     // Catch: ClassNotFoundException -> L35
        f r12 = new f(null, "setAlpnProtocols", new Class[]{byte[].class});     // Catch: ClassNotFoundException -> L35
    L33:
        r5 = new b(r8, r9, r10, r11, r12);     // Catch: ClassNotFoundException -> L35
        goto L36
    L32:
        r11 = null;
        r12 = null;
        goto L33
    L72:
        b.r("android.net.Network");     // Catch: ClassNotFoundException -> L29
    L29:
        r1 = false;
        goto L30
    L23:
        r0 = b.r("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");     // Catch: ClassNotFoundException -> L35
    L36:
        if (r5 == null) goto L39;
    L37:
        r7 = r5;
        goto L59
    L39:
        throw new NullPointerException("No platform found on Android");
    L63:
        int r2 = Build.VERSION.SDK_INT;     // Catch: ClassNotFoundException -> L9 NoClassDefFoundError -> L10
    L12:
        if (r2 < 29) goto L15;
        r7 = new a(a.t());     // Catch: ClassNotFoundException -> L9
    L10:
        r2 = 0;
        goto L12
    L41:
        if ("conscrypt".equals(System.getProperty("okhttp.platform")) == false) goto L43;
        boolean r3 = true;
    L44:
        if (r3 == false) goto L61;
        g r4 = c.r();
        if (r4 == null) goto L61;
    L47:
        r7 = r4;
    L61:
        r7 = new d(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));     // Catch: NoSuchMethodException -> L50
    L51:
        if (r7 != null) goto L59;
        Class r6 = e.q("org.eclipse.jetty.alpn.ALPN");     // Catch: Throwable -> L55
        Class<?> r13 = e.q("org.eclipse.jetty.alpn.ALPN$Provider");     // Catch: Throwable -> L55
        r5 = new e(r6.getMethod("put", new Class[]{SSLSocket.class, r13}), r6.getMethod("get", new Class[]{SSLSocket.class}), r6.getMethod("remove", new Class[]{SSLSocket.class}), e.q("org.eclipse.jetty.alpn.ALPN$ClientProvider"), e.q("org.eclipse.jetty.alpn.ALPN$ServerProvider"));     // Catch: Throwable -> L55
    L56:
        if (r5 != null) goto L37;
        r4 = new g();
    L50:
        r7 = null;
        goto L51
    L43:
        r3 = "Conscrypt".equals(Security.getProviders()[0].getName());
        goto L44
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("sun.security.ssl.SSLContextImpl");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("sun.security.ssl.SSLContextImpl");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("sun.security.ssl.SSLContextImpl");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("sun.security.ssl.SSLContextImpl");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("sun.security.ssl.SSLContextImpl");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("sun.security.ssl.SSLContextImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("sun.security.ssl.SSLContextImpl");
    }

    public SSLContext i() {
        if ("1.7".equals(System.getProperty("java.specification.version")) == false) goto L14;
        return SSLContext.getInstance("TLSv1.2");
    L14:
        return SSLContext.getInstance("TLS");
    L8:
        e = move-exception;
        throw new IllegalStateException("No TLS provider", e);
    }

    public Object k() {
        if (b.isLoggable(Level.FINE) == true) goto L5;
        return null;
    L5:
        return new Throwable("response.body().close()");
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    public static List<String> c(List<Protocol> r5) {
        ArrayList r0 = new ArrayList(r5.size());
        int r1 = r5.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        Protocol r3 = (Protocol) ListProtector.get(r5, r2);
        if (r3 == Protocol.HTTP_1_0) goto L8;
        r0.add(r3.toString());
    L8:
        r2 = r2 + 1;
        goto L3
    L9:
        return r0;
    }

    public c d(X509TrustManager r2) {
        return new jvc.a(e(r2));
    }

    public e e(X509TrustManager r2) {
        return new jvc.b(r2.getAcceptedIssuers());
    }

    @Nullable
    public X509TrustManager p(SSLSocketFactory r4) {
        Object r5 = o(r4, a(), "context");     // Catch: ClassNotFoundException -> L8
        if (r5 != null) goto L6;
        return null;
    L6:
        return (X509TrustManager) o(r5, X509TrustManager.class, "trustManager");
    L8:
        return null;
    }

    public void n(String r2, Object r3) {
        if (r3 != null) goto L4;
        r2 = r2 + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
    L4:
        m(5, r2, (Throwable) r3);
    }

    @Nullable
    public static <T> T o(Object r4, Class<T> r5, String r6) {
        Class<?> r0 = r4.getClass();
    L4:
        if (r0 == Object.class) goto L17;
        Field r1 = r0.getDeclaredField(r6);     // Catch: IllegalAccessException -> L13 NoSuchFieldException -> L15
        r1.setAccessible(true);     // Catch: IllegalAccessException -> L13 NoSuchFieldException -> L15
        Object r2 = r1.get(r4);     // Catch: IllegalAccessException -> L13 NoSuchFieldException -> L15
        if (r2 == null) goto L12;
        if (r5.isInstance(r2) == false) goto L12;
        goto L14
    L11:
        return r5.cast(r2);
    L12:
        return null;
    L15:
        r0 = r0.getSuperclass();
    L14:
        throw new AssertionError();
    L17:
        if (r6.equals("delegate") == true) goto L22;
        Object r7 = o(r4, Object.class, "delegate");
        if (r7 == null) goto L22;
        return (T) o(r7, r5, r6);
    L22:
        return null;
    }

    public void h(Socket r1, InetSocketAddress r2, int r3) throws IOException {
        r1.connect(r2, r3);
    }

    public void m(int r2, String r3, @Nullable Throwable r4) {
        if (r2 != 5) goto L5;
        Level r5 = Level.WARNING;
    L6:
        b.log(r5, r3, r4);
        return;
    L5:
        r5 = Level.INFO;
        goto L6
    }
}
