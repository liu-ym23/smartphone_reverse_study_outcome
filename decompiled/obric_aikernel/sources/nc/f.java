package nc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes3.dex */
public class f implements k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f11346f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final j.a f11347g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<? super SSLSocket> f11348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Method f11349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Method f11350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Method f11351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Method f11352e;

    public static final class a {

        /* JADX INFO: renamed from: nc.f$a$a, reason: collision with other inner class name */
        public static final class C0253a implements j.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f11353a;

            C0253a(String r10) {
                this.f11353a = r10;
            }

            @Override // nc.j.a
            public boolean a(SSLSocket r10) {
                Intrinsics.checkNotNullParameter(r10, "sslSocket");
                String r11 = r10.getClass().getName();
                Intrinsics.checkNotNullExpressionValue(r11, "sslSocket.javaClass.name");
                return StringsKt.startsWith$default(r11, this.f11353a + '.', false, 2, null);
            }

            @Override // nc.j.a
            public k b(SSLSocket r10) {
                Intrinsics.checkNotNullParameter(r10, "sslSocket");
                return a.a(f.f11346f, r10.getClass());
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ f a(a r10, Class r11) {
            return r10.b(r11);
        }

        private final f b(Class<? super SSLSocket> r10) {
            Class<? super SSLSocket> r11 = r10;
        L3:
            if (r11 == null) goto L11;
            if (Intrinsics.areEqual(r11.getSimpleName(), "OpenSSLSocketImpl") == true) goto L11;
            r11 = r11.getSuperclass();
            if (r11 != null) goto L3;
            throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + r10);
        L11:
            Intrinsics.checkNotNull(r11);
            return new f(r11);
        }

        public final j.a c(String r10) {
            Intrinsics.checkNotNullParameter(r10, "packageName");
            return new C0253a(r10);
        }

        public final j.a d() {
            return f.f();
        }
    }

    static {
        a r10 = new a(null);
        f11346f = r10;
        f11347g = r10.c("com.google.android.gms.org.conscrypt");
    }

    public f(Class<? super SSLSocket> r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocketClass");
        this.f11348a = r10;
        Method r11 = r10.getDeclaredMethod("setUseSessionTickets", new Class[]{Boolean.TYPE});
        Intrinsics.checkNotNullExpressionValue(r11, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f11349b = r11;
        this.f11350c = r10.getMethod("setHostname", new Class[]{String.class});
        this.f11351d = r10.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.f11352e = r10.getMethod("setAlpnProtocols", new Class[]{byte[].class});
    }

    public static final /* synthetic */ j.a f() {
        return f11347g;
    }

    @Override // nc.k
    public boolean a(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        return this.f11348a.isInstance(r10);
    }

    @Override // nc.k
    public String b(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        if (a(r10) == true) goto L20;
        return null;
    L20:
        byte[] r11 = (byte[]) this.f11351d.invoke(r10, new Object[0]);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L17
        if (r11 == null) goto L14;
    L22:
        return new String(r11, Charsets.UTF_8);
    L14:
        return null;
    L17:
        e = move-exception;
        throw new AssertionError(e);
    L9:
        e = move-exception;
        Throwable r12 = e.getCause();
        if ((r12 instanceof NullPointerException) == false) goto L16;
        if (Intrinsics.areEqual(((NullPointerException) r12).getMessage(), "ssl == null") == false) goto L16;
        return null;
    L16:
        throw new AssertionError(e);
    }

    @Override // nc.k
    public X509TrustManager c(SSLSocketFactory r10) {
        return k.a.b(this, r10);
    }

    @Override // nc.k
    public boolean d(SSLSocketFactory r10) {
        return k.a.a(this, r10);
    }

    @Override // nc.k
    public void e(SSLSocket r10, String r11, List<? extends Protocol> r12) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        Intrinsics.checkNotNullParameter(r12, "protocols");
        if (a(r10) == true) goto L16;
        return;
    L16:
        this.f11349b.invoke(r10, new Object[]{Boolean.TRUE});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
        if (r11 == null) goto L7;
        this.f11350c.invoke(r10, new Object[]{r11});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
    L7:
        this.f11352e.invoke(r10, new Object[]{okhttp3.internal.platform.h.f11979a.c(r12)});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
    L18:
        return;
    L12:
        e = move-exception;
        throw new AssertionError(e);
    L9:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // nc.k
    public boolean isSupported() {
        return okhttp3.internal.platform.b.f11952f.b();
    }
}
