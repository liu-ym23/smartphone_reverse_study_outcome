package nc;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Protocol;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nBouncyCastleSocketAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BouncyCastleSocketAdapter.kt\nokhttp3/internal/platform/android/BouncyCastleSocketAdapter\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,68:1\n37#2,2:69\n*S KotlinDebug\n*F\n+ 1 BouncyCastleSocketAdapter.kt\nokhttp3/internal/platform/android/BouncyCastleSocketAdapter\n*L\n53#1:69,2\n*E\n"})
public final class g implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11354a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final j.a f11355b = null;

    public static final class a implements j.a {
        a() {
        }

        @Override // nc.j.a
        public boolean a(SSLSocket r10) {
            Intrinsics.checkNotNullParameter(r10, "sslSocket");
            if (okhttp3.internal.platform.c.f11958e.b() == true) goto L5;
        L7:
            return false;
        L5:
            if ((r10 instanceof BCSSLSocket) == false) goto L7;
            return true;
        }

        @Override // nc.j.a
        public k b(SSLSocket r10) {
            Intrinsics.checkNotNullParameter(r10, "sslSocket");
            return new g();
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public final j.a a() {
            return g.f();
        }
    }

    static {
        f11354a = new b(null);
        f11355b = new a();
    }

    public g() {
    }

    public static final /* synthetic */ j.a f() {
        return f11355b;
    }

    @Override // nc.k
    public boolean a(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        return r10 instanceof BCSSLSocket;
    }

    @Override // nc.k
    public String b(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        String r11 = ((BCSSLSocket) r10).getApplicationProtocol();
        if (r11 != null) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return null;
    L9:
        return r11;
    L5:
        r12 = Intrinsics.areEqual(r11, "");
        goto L6
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
        if (a(r10) == false) goto L6;
        BCSSLSocket r13 = (BCSSLSocket) r10;
        BCSSLParameters r14 = r13.getParameters();
        r14.setApplicationProtocols((String[]) okhttp3.internal.platform.h.f11979a.b(r12).toArray(new String[0]));
        r13.setParameters(r14);
        return;
    }

    @Override // nc.k
    public boolean isSupported() {
        return okhttp3.internal.platform.c.f11958e.b();
    }
}
