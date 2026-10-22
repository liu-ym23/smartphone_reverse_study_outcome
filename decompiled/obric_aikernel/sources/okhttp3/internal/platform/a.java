package okhttp3.internal.platform;

import android.annotation.SuppressLint;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
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
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nAndroid10Platform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Android10Platform.kt\nokhttp3/internal/platform/Android10Platform\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,72:1\n766#2:73\n857#2,2:74\n1#3:76\n*S KotlinDebug\n*F\n+ 1 Android10Platform.kt\nokhttp3/internal/platform/Android10Platform\n*L\n43#1:73\n43#1:74,2\n*E\n"})
public final class a extends h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0267a f11949e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f11950f = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<k> f11951d;

    /* JADX INFO: renamed from: okhttp3.internal.platform.a$a, reason: collision with other inner class name */
    public static final class C0267a {
        private C0267a() {
        }

        public /* synthetic */ C0267a(DefaultConstructorMarker r10) {
            this();
        }

        public final h a() {
            if (b() == true) goto L7;
            return null;
        L7:
            return new a();
        }

        public final boolean b() {
            return a.q();
        }
    }

    static {
        f11949e = new C0267a(null);
        if (h.f11979a.h() == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        f11950f = r10;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L7;
        r10 = true;
        goto L8
    }

    public a() {
        List r10 = CollectionsKt.listOfNotNull(new k[]{nc.a.f11338a.a(), new j(nc.f.f11346f.d()), new j(i.f11360a.a()), new j(nc.g.f11354a.a())});
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if (((k) r13).isSupported() == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        this.f11951d = r11;
    }

    public static final /* synthetic */ boolean q() {
        return f11950f;
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
    public void e(SSLSocket r10, String r11, List<? extends Protocol> r12) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        Intrinsics.checkNotNullParameter(r12, "protocols");
        Iterator<T> r13 = this.f11951d.iterator();
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
    public String g(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        Iterator<T> r11 = this.f11951d.iterator();
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
    @SuppressLint({"NewApi"})
    public boolean i(String r10) {
        Intrinsics.checkNotNullParameter(r10, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(r10);
    }

    @Override // okhttp3.internal.platform.h
    public X509TrustManager p(SSLSocketFactory r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocketFactory");
        Iterator<T> r11 = this.f11951d.iterator();
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
