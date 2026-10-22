package hvc;

import android.os.Build;
import android.util.Log;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import jvc.e;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.Protocol;
import okio.Buffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class b extends g {
    public final Class<?> c;
    public final f<Socket> d;
    public final f<Socket> e;
    public final f<Socket> f;
    public final f<Socket> g;
    public final c h;

    public static final class a extends jvc.c {
        public final Object a;
        public final Method b;

        public final int hashCode() {
            return 0;
        }

        public final boolean equals(Object r1) {
            return r1 instanceof a;
        }

        public a(Object r1, Method r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // jvc.c
        public final List<Certificate> a(List<Certificate> r5, String r6) throws SSLPeerUnverifiedException {
            X509Certificate[] r7 = (X509Certificate[]) r5.toArray(new X509Certificate[r5.size()]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L7
            return (List) this.b.invoke(this.a, new Object[]{r7, "RSA", r6});
        L4:
            e = move-exception;
            throw new AssertionError(e);
        L7:
            e = move-exception;
            SSLPeerUnverifiedException r8 = new SSLPeerUnverifiedException(e.getMessage());
            r8.initCause(e);
            throw r8;
        }
    }

    public static final class c {
        public final Method a;
        public final Method b;
        public final Method c;

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r2 = Class.forName("dalvik.system.CloseGuard");     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("dalvik.system.CloseGuard");     // Catch: Throwable -> L8
        L7:
            return r2;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("dalvik.system.CloseGuard");
        L12:
            throw th;
        L34:
            Class<?> r3 = Class.forName("dalvik.system.CloseGuard");     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("dalvik.system.CloseGuard");     // Catch: Throwable -> L17
        L16:
            return r3;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("dalvik.system.CloseGuard");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("dalvik.system.CloseGuard");
        }

        public c(Method r1, Method r2, Method r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    @Override // hvc.g
    public final SSLContext i() {
        boolean r0 = true;
        if (Build.VERSION.SDK_INT < 22) goto L9;
        r0 = false;
    L9:
        if (r0 == false) goto L20;
        return SSLContext.getInstance("TLSv1.2");
    L20:
        return SSLContext.getInstance("TLS");
    L14:
        e = move-exception;
        throw new IllegalStateException("No TLS provider", e);
    }

    @Override // hvc.g
    public final Object k() {
        c r1 = this.h;
        Method r2 = r1.a;
        if (r2 != null) goto L9;
        return null;
    L9:
        Object r3 = r2.invoke(null, new Object[0]);     // Catch: Exception -> L8
        r1.b.invoke(r3, new Object[]{"response.body().close()"});     // Catch: Exception -> L8
        return r3;
    L12:
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class q(ClassLoader r5) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == false) goto L34;
        Class<?> r6 = Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, r5);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.google.android.gms.org.conscrypt.SSLParametersImpl");     // Catch: Throwable -> L17
    L16:
        return r6;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.google.android.gms.org.conscrypt.SSLParametersImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl");
    L34:
        Class<?> r7 = Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, r5);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.google.android.gms.org.conscrypt.SSLParametersImpl");     // Catch: Throwable -> L8
    L7:
        return r7;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.google.android.gms.org.conscrypt.SSLParametersImpl");
    L12:
        throw th;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class r(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    @Override // hvc.g
    public final jvc.c d(X509TrustManager r8) {
        Class r0 = r("android.net.http.X509TrustManagerExtensions");     // Catch: Exception -> L4
        return new a(r0.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{r8}), r0.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
    L5:
        return super.d(r8);
    }

    @Override // hvc.g
    public final e e(X509TrustManager r7) {
        Method r0 = r7.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});     // Catch: NoSuchMethodException -> L4
        r0.setAccessible(true);     // Catch: NoSuchMethodException -> L4
        return new b(r7, r0);
    L5:
        return super.e(r7);
    }

    @Override // hvc.g
    @Nullable
    public String j(SSLSocket r4) {
        f<Socket> r0 = this.f;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.a(r4.getClass()) == null) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return null;
    L11:
        f<Socket> r2 = this.f;
        Object[] r3 = new Object[0];
        r2.getClass();
        byte[] r5 = (byte[]) r2.b(r4, r3);
        if (r5 != null) goto L16;
        return null;
    L16:
        return new String(r5, cvc.c.j);
    L17:
        e = move-exception;
        Throwable r6 = e.getTargetException();
        if ((r6 instanceof RuntimeException) == true) goto L21;
        AssertionError r7 = new AssertionError("Unexpected exception");
        r7.initCause(r6);
        throw r7;
    L21:
        throw ((RuntimeException) r6);
    L8:
        r1 = false;
        goto L9
    }

    @Override // hvc.g
    public final boolean l(String r6) {
        if (Build.VERSION.SDK_INT >= 23) goto L15;
        return true;
    L15:
        Class r0 = r("android.security.NetworkSecurityPolicy");     // Catch: InvocationTargetException -> L7 IllegalArgumentException -> L9 IllegalAccessException -> L11 Throwable -> L14
        return s(r6, r0, r0.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
    L14:
        return true;
    L11:
        e = e;
    L13:
        throw cvc.c.a("unable to determine cleartext support", e);
    L9:
        e = e;
    L7:
        e = e;
        goto L13
    }

    @Override // hvc.g
    @Nullable
    public final X509TrustManager p(SSLSocketFactory r3) {
        Object r0 = g.o(r3, this.c, "sslParameters");
        if (r0 == null) goto L13;
    L8:
        X509TrustManager r4 = (X509TrustManager) g.o(r0, X509TrustManager.class, "x509TrustManager");
        if (r4 == null) goto L12;
        return r4;
    L12:
        return (X509TrustManager) g.o(r0, X509TrustManager.class, "trustManager");
    L13:
        r0 = g.o(r3, q(r3.getClass().getClassLoader()), "sslParameters");     // Catch: ClassNotFoundException -> L6
    L7:
        return super.p(r3);
    }

    @Override // hvc.g
    public final void n(String r4, Object r5) {
        c r0 = this.h;
        r0.getClass();
        boolean r1 = false;
        if (r5 != null) goto L10;
    L7:
        if (r1 == true) goto L12;
        m(5, r4, null);
        return;
    L12:
        return;
    L10:
        r0.c.invoke(r5, new Object[0]);     // Catch: Exception -> L6
        r1 = true;
        goto L7
    }

    public static boolean s(String r5, Class r6, Object r7) throws InvocationTargetException, IllegalAccessException {
        return ((Boolean) r6.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(r7, new Object[]{r5})).booleanValue();
    L5:
        return ((Boolean) r6.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(r7, new Object[0])).booleanValue();
    L11:
        return true;
    }

    @Override // hvc.g
    public void g(SSLSocket r7, String r8, List<Protocol> r9) throws IOException {
        if (r8 == null) goto L5;
        this.d.c(r7, new Object[]{Boolean.TRUE});
        this.e.c(r7, new Object[]{r8});
    L5:
        f<Socket> r10 = this.g;
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.a(r7.getClass()) == null) goto L10;
        boolean r11 = true;
    L11:
        if (r11 == false) goto L35;
        Object[] r12 = new Object[1];
        Buffer r1 = new Buffer();
        int r2 = r9.size();
        int r3 = 0;
    L13:
        if (r3 >= r2) goto L19;
        Protocol r4 = (Protocol) ListProtector.get(r9, r3);
        if (r4 == Protocol.HTTP_1_0) goto L18;
        r1.writeByte(r4.toString().length());
        r1.writeUtf8(r4.toString());
    L18:
        r3 = r3 + 1;
        goto L13
    L19:
        r12[0] = r1.readByteArray();
        f<Socket> r13 = this.g;
        r13.getClass();
        r13.b(r7, r12);     // Catch: InvocationTargetException -> L22
        return;
    L22:
        e = move-exception;
        Throwable r14 = e.getTargetException();
        if ((r14 instanceof RuntimeException) == true) goto L26;
        AssertionError r15 = new AssertionError("Unexpected exception");
        r15.initCause(r14);
        throw r15;
    L26:
        throw ((RuntimeException) r14);
    L35:
        return;
    L10:
        r11 = false;
        goto L11
    }

    @Override // hvc.g
    public final void h(Socket r2, InetSocketAddress r3, int r4) throws IOException {
        r2.connect(r3, r4);     // Catch: ClassCastException -> L5 SecurityException -> L11 AssertionError -> L14
        return;
    L14:
        e = move-exception;
        if (cvc.c.q(e) == true) goto L18;
        throw e;
    L18:
        throw new IOException(e);
    L5:
        e = move-exception;
        if (Build.VERSION.SDK_INT != 26) goto L10;
        IOException r5 = new IOException("Exception in connect");
        r5.initCause(e);
        throw r5;
    L10:
        throw e;
    L11:
        e = move-exception;
        IOException r6 = new IOException("Exception in connect");
        r6.initCause(e);
        throw r6;
    }

    @Override // hvc.g
    public final void m(int r4, String r5, @Nullable Throwable r6) {
        if (r6 == null) goto L5;
        r5 = r5 + '\n' + Log.getStackTraceString(r6);
    L5:
        int r7 = r5.length();
        int r0 = 0;
    L6:
        if (r0 >= r7) goto L15;
        int r1 = r5.indexOf(10, r0);
        if (r1 != (-1)) goto L11;
        r1 = r7;
    L11:
        int r2 = Math.min(r1, r0 + 4000);
        r5.substring(r0, r2);
        if (r2 >= r1) goto L13;
        r0 = r2;
        goto L11
    L13:
        r0 = r2 + 1;
        goto L6
    }

    public b(Class<?> r7, f<Socket> r8, f<Socket> r9, f<Socket> r10, f<Socket> r11) {
        Class r0 = c.a();     // Catch: Exception -> L5
        Method r1 = r0.getMethod("get", new Class[0]);     // Catch: Exception -> L5
        Method r3 = r0.getMethod("open", new Class[]{String.class});     // Catch: Exception -> L5
        Method r2 = r0.getMethod("warnIfOpen", new Class[0]);     // Catch: Exception -> L5
    L6:
        this.h = new c(r1, r3, r2);
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = r11;
        return;
    L5:
        r1 = null;
        r2 = null;
        r3 = null;
        goto L6
    }
}
