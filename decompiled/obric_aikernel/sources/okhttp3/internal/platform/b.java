package okhttp3.internal.platform;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import com.bytedance.crash.event.EnsureReportData;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import nc.i;
import nc.j;
import nc.k;
import nc.l;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nAndroidPlatform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidPlatform.kt\nokhttp3/internal/platform/AndroidPlatform\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,163:1\n766#2:164\n857#2,2:165\n1#3:167\n*S KotlinDebug\n*F\n+ 1 AndroidPlatform.kt\nokhttp3/internal/platform/AndroidPlatform\n*L\n52#1:164\n52#1:165,2\n*E\n"})
public final class b extends h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f11952f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f11953g = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<k> f11954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final nc.h f11955e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final h a() {
            if (b() == true) goto L7;
            return null;
        L7:
            return new b();
        }

        public final boolean b() {
            return b.q();
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.platform.b$b, reason: collision with other inner class name */
    public static final class C0268b implements qc.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final X509TrustManager f11956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f11957b;

        public C0268b(X509TrustManager r10, Method r11) {
            Intrinsics.checkNotNullParameter(r10, "trustManager");
            Intrinsics.checkNotNullParameter(r11, "findByIssuerAndSignatureMethod");
            this.f11956a = r10;
            this.f11957b = r11;
        }

        @Override // qc.e
        public X509Certificate a(X509Certificate r10) {
            Intrinsics.checkNotNullParameter(r10, "cert");
            Object r11 = this.f11957b.invoke(this.f11956a, new Object[]{r10});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.security.cert.TrustAnchor");     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7
        L12:
            return ((TrustAnchor) r11).getTrustedCert();
        L7:
            e = move-exception;
            throw new AssertionError("unable to get issues and signature", e);
        L5:
            return null;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0268b) == true) goto L8;
            return false;
        L8:
            C0268b r11 = (C0268b) r10;
            if (Intrinsics.areEqual(this.f11956a, r11.f11956a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11957b, r11.f11957b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f11956a.hashCode() * 31) + this.f11957b.hashCode();
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.f11956a + ", findByIssuerAndSignatureMethod=" + this.f11957b + ')';
        }
    }

    static {
        f11952f = new a(null);
        boolean r10 = true;
        boolean r11 = false;
        if (h.f11979a.h() == true) goto L5;
    L4:
        r10 = false;
    L12:
        f11953g = r10;
        return;
    L5:
        int r12 = Build.VERSION.SDK_INT;
        if (r12 >= 30) goto L4;
        if (r12 < 21) goto L11;
        r11 = true;
    L11:
        if (r11 == true) goto L12;
        throw new IllegalStateException(("Expected Android API level 21+ but was " + r12).toString());
    }

    public b() {
        List r10 = CollectionsKt.listOfNotNull(new k[]{l.a.b(l.f11364j, null, 1, null), new j(nc.f.f11346f.d()), new j(i.f11360a.a()), new j(nc.g.f11354a.a())});
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if (((k) r13).isSupported() == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        this.f11954d = r11;
        this.f11955e = nc.h.f11356d.a();
    }

    public static final /* synthetic */ boolean q() {
        return f11953g;
    }

    @Override // okhttp3.internal.platform.h
    public qc.c c(X509TrustManager r10) {
        Intrinsics.checkNotNullParameter(r10, "trustManager");
        nc.b r11 = nc.b.f11339d.a(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        return super.c(r10);
    }

    @Override // okhttp3.internal.platform.h
    public qc.e d(X509TrustManager r10) {
        Intrinsics.checkNotNullParameter(r10, "trustManager");
        Method r11 = r10.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});     // Catch: NoSuchMethodException -> L5
        r11.setAccessible(true);     // Catch: NoSuchMethodException -> L5
        Intrinsics.checkNotNullExpressionValue(r11, EnsureReportData.METHOD);     // Catch: NoSuchMethodException -> L5
        return new C0268b(r10, r11);
    L6:
        return super.d(r10);
    }

    @Override // okhttp3.internal.platform.h
    public void e(SSLSocket r10, String r11, List<Protocol> r12) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        Intrinsics.checkNotNullParameter(r12, "protocols");
        Iterator<T> r13 = this.f11954d.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Object r14 = r13.next();
        if (((k) r14).a(r10) == false) goto L4;
    L9:
        k r15 = (k) r14;
        if (r15 == null) goto L16;
        r15.e(r10, r11, r12);
        return;
    L16:
        return;
    L8:
        r14 = null;
        goto L9
    }

    @Override // okhttp3.internal.platform.h
    public void f(Socket r10, InetSocketAddress r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "socket");
        Intrinsics.checkNotNullParameter(r11, "address");
        r10.connect(r11, r12);     // Catch: ClassCastException -> L5
        return;
    L5:
        e = move-exception;
        if (Build.VERSION.SDK_INT == 26) goto L9;
        throw e;
    L9:
        throw new IOException("Exception in connect", e);
    }

    @Override // okhttp3.internal.platform.h
    public String g(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        Iterator<T> r11 = this.f11954d.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        if (((k) r12).a(r10) == false) goto L4;
    L9:
        k r13 = (k) r12;
        if (r13 != null) goto L12;
        return null;
    L12:
        return r13.b(r10);
    L8:
        r12 = null;
        goto L9
    }

    @Override // okhttp3.internal.platform.h
    public Object h(String r10) {
        Intrinsics.checkNotNullParameter(r10, "closer");
        return this.f11955e.a(r10);
    }

    @Override // okhttp3.internal.platform.h
    public boolean i(String r10) {
        Intrinsics.checkNotNullParameter(r10, "hostname");
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 24) goto L6;
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(r10);
    L6:
        if (r11 >= 23) goto L11;
        return true;
    L11:
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    @Override // okhttp3.internal.platform.h
    public void l(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "message");
        if (this.f11955e.b(r11) == true) goto L6;
        h.k(this, r10, 5, null, 4, null);
        return;
    }

    @Override // okhttp3.internal.platform.h
    public X509TrustManager p(SSLSocketFactory r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocketFactory");
        Iterator<T> r11 = this.f11954d.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        if (((k) r12).d(r10) == false) goto L4;
    L9:
        k r13 = (k) r12;
        if (r13 != null) goto L12;
        return null;
    L12:
        return r13.c(r10);
    L8:
        r12 = null;
        goto L9
    }
}
