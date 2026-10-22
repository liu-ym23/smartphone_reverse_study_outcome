package df;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import we.w;

/* JADX INFO: loaded from: classes2.dex */
public class b extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n4.b f7075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n4.b f7076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n4.b f7077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n4.b f7078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f7079g;

    public static final class a extends android.support.v4.media.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f7080c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Method f7081d;

        public a(Object r8, Method r10) {
            this.f7080c = r8;
            this.f7081d = r10;
        }

        public final boolean equals(Object r8) {
            return r8 instanceof a;
        }

        @Override // android.support.v4.media.a
        public final List g(String r8, List r10) {
            X509Certificate[] r11 = (X509Certificate[]) r10.toArray(new X509Certificate[r10.size()]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L7
            return (List) this.f7081d.invoke(this.f7080c, new Object[]{r11, "RSA", r8});
        L4:
            e = move-exception;
            throw new AssertionError(e);
        L7:
            e = move-exception;
            SSLPeerUnverifiedException r12 = new SSLPeerUnverifiedException(e.getMessage());
            r12.initCause(e);
            throw r12;
        }

        public final int hashCode() {
            return 0;
        }
    }

    /* JADX INFO: renamed from: df.b$b, reason: collision with other inner class name */
    public static final class C0064b implements gf.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final X509TrustManager f7082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f7083b;

        public C0064b(X509TrustManager r8, Method r10) {
            this.f7083b = r10;
            this.f7082a = r8;
        }

        @Override // gf.d
        public final X509Certificate a(X509Certificate r8) {
            TrustAnchor r10 = (TrustAnchor) this.f7083b.invoke(this.f7082a, new Object[]{r8});     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L8
            if (r10 == null) goto L6;
            goto L6
        L14:
            return r10.getTrustedCert();
        L8:
            e = move-exception;
            throw xe.c.a("unable to get issues and signature", e);
        L6:
            return null;
        }

        public final boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof C0064b) == true) goto L8;
            return false;
        L8:
            C0064b r10 = (C0064b) r8;
            X509TrustManager r11 = r10.f7082a;
            if (this.f7082a.equals(r11) == false) goto L14;
            if (this.f7083b.equals(r10.f7083b) == false) goto L14;
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            int r8 = this.f7082a.hashCode();
            return (this.f7083b.hashCode() * 31) + r8;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f7084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f7085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f7086c;

        public c(Method r8, Method r10, Method r11) {
            this.f7084a = r8;
            this.f7085b = r10;
            this.f7086c = r11;
        }
    }

    public b(Class<?> r8, n4.b r10, n4.b r11, n4.b r12, n4.b r13) {
        Class<?> r14 = Class.forName("dalvik.system.CloseGuard");     // Catch: Exception -> L5
        Method r15 = r14.getMethod("get", new Class[0]);     // Catch: Exception -> L5
        Method r16 = r14.getMethod("open", new Class[]{String.class});     // Catch: Exception -> L5
        Method r17 = r14.getMethod("warnIfOpen", new Class[0]);     // Catch: Exception -> L5
    L6:
        this.f7079g = new c(r15, r16, r17);
        this.f7075c = r10;
        this.f7076d = r11;
        this.f7077e = r12;
        this.f7078f = r13;
        return;
    L5:
        r15 = null;
        r17 = null;
        r16 = null;
        goto L6
    }

    public static boolean n(Class r8, Object r10, String r11) {
        return ((Boolean) r8.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(r10, new Object[]{r11})).booleanValue();
    L5:
        return ((Boolean) r8.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(r10, new Object[0])).booleanValue();
    L11:
        return true;
    }

    @Override // df.f
    public final android.support.v4.media.a c(X509TrustManager r10) {
        Class<?> r8 = Class.forName("android.net.http.X509TrustManagerExtensions");     // Catch: Exception -> L5
        return new a(r8.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{r10}), r8.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
    L6:
        return super.c(r10);
    }

    @Override // df.f
    public final gf.d d(X509TrustManager r8) {
        Method r10 = r8.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});     // Catch: NoSuchMethodException -> L4
        r10.setAccessible(true);     // Catch: NoSuchMethodException -> L4
        return new C0064b(r8, r10);
    L5:
        return new gf.b(r8.getAcceptedIssuers());
    }

    @Override // df.f
    public void f(SSLSocket r8, String r10, List<w> r11) {
        if (r10 == null) goto L4;
        this.f7075c.e(new Object[]{Boolean.TRUE}, r8);
        this.f7076d.e(new Object[]{r10}, r8);
    L4:
        n4.b r12 = this.f7078f;
        if (r12 != null) goto L7;
        return;
    L7:
        if (r12.c(r8.getClass()) == null) goto L9;
        boolean r13 = true;
    L10:
        if (r13 == false) goto L39;
        Object[] r14 = new Object[1];
        jf.d r15 = new jf.d();
        int r16 = r11.size();
        int r17 = 0;
    L12:
        if (r17 >= r16) goto L35;
        w r18 = r11.get(r17);
        if (r18 == w.f13319b) goto L17;
        r15.G(r18.f13326a.length());
        String r19 = r18.f13326a;
        r15.c0(0, r19.length(), r19);
    L17:
        r17 = r17 + 1;
        goto L12
    L35:
        r14[0] = r15.w(r15.f8830b);
        r12.d(r14, r8);     // Catch: InvocationTargetException -> L22
        return;
    L22:
        e = move-exception;
        Throwable r20 = e.getTargetException();
        if ((r20 instanceof RuntimeException) == true) goto L26;
        AssertionError r21 = new AssertionError("Unexpected exception");
        r21.initCause(r20);
        throw r21;
    L26:
        throw ((RuntimeException) r20);
    L29:
        e = move-exception;
        throw new AssertionError(e);
    L39:
        return;
    L9:
        r13 = false;
        goto L10
    }

    @Override // df.f
    public final void g(Socket r8, InetSocketAddress r10, int r11) {
        r8.connect(r10, r11);     // Catch: ClassCastException -> L4 SecurityException -> L6 AssertionError -> L9
        return;
    L9:
        e = move-exception;
        if (xe.c.s(e) == true) goto L13;
        throw e;
    L13:
        throw new IOException(e);
    L4:
        e = move-exception;
        throw e;
    L6:
        e = move-exception;
        IOException r12 = new IOException("Exception in connect");
        r12.initCause(e);
        throw r12;
    }

    @Override // df.f
    public final SSLContext h() {
        return SSLContext.getInstance("TLS");
    L4:
        e = move-exception;
        throw new IllegalStateException("No TLS provider", e);
    }

    @Override // df.f
    @Nullable
    public String i(SSLSocket r8) {
        n4.b r10 = this.f7077e;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.c(r8.getClass()) == null) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == true) goto L24;
        return null;
    L24:
        byte[] r12 = (byte[]) r10.d(new Object[0], r8);
        if (r12 != null) goto L16;
        return null;
    L16:
        return new String(r12, xe.c.f13888i);
    L17:
        e = move-exception;
        Throwable r13 = e.getTargetException();
        if ((r13 instanceof RuntimeException) == true) goto L21;
        AssertionError r14 = new AssertionError("Unexpected exception");
        r14.initCause(r13);
        throw r14;
    L21:
        throw ((RuntimeException) r13);
    L8:
        r11 = false;
        goto L9
    }

    @Override // df.f
    public final Object j() {
        c r8 = this.f7079g;
        Method r10 = r8.f7084a;
        if (r10 != null) goto L9;
        return null;
    L9:
        Object r11 = r10.invoke(null, new Object[0]);     // Catch: Exception -> L8
        r8.f7085b.invoke(r11, new Object[]{"response.body().close()"});     // Catch: Exception -> L8
        return r11;
    L12:
        return null;
    }

    @Override // df.f
    public final boolean k(String r8) {
        Class<?> r10 = Class.forName("android.security.NetworkSecurityPolicy");     // Catch: Throwable -> L4 Throwable -> L7
        return n(r10, r10.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), r8);
    L7:
        return true;
    L4:
        e = move-exception;
        throw xe.c.a("unable to determine cleartext support", e);
    }

    @Override // df.f
    public final void l(int r8, @Nullable Throwable r10, String r11) {
        int r12 = 5;
        if (r8 == 5) goto L7;
        r12 = 3;
    L7:
        if (r10 == null) goto L9;
        r11 = r11 + '\n' + Log.getStackTraceString(r10);
    L9:
        int r13 = r11.length();
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L19;
        int r15 = r11.indexOf(10, r14);
        if (r15 != (-1)) goto L15;
        r15 = r13;
    L15:
        int r16 = Math.min(r15, r14 + 4000);
        Log.println(r12, "OkHttp", r11.substring(r14, r16));
        if (r16 >= r15) goto L17;
        r14 = r16;
        goto L15
    L17:
        r14 = r16 + 1;
        goto L10
    }

    @Override // df.f
    public final void m(Object r8, String r10) {
        c r11 = this.f7079g;
        r11.getClass();
        boolean r12 = false;
        if (r8 != null) goto L10;
    L6:
        if (r12 == true) goto L12;
        l(5, null, r10);
        return;
    L12:
        return;
    L10:
        r11.f7086c.invoke(r8, new Object[0]);     // Catch: Exception -> L9
        r12 = true;
        goto L6
    }
}
