package nc;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nConscryptSocketAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConscryptSocketAdapter.kt\nokhttp3/internal/platform/android/ConscryptSocketAdapter\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,64:1\n37#2,2:65\n*S KotlinDebug\n*F\n+ 1 ConscryptSocketAdapter.kt\nokhttp3/internal/platform/android/ConscryptSocketAdapter\n*L\n51#1:65,2\n*E\n"})
public final class i implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11360a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final j.a f11361b = null;

    public static final class a implements j.a {
        a() {
        }

        @Override // nc.j.a
        public boolean a(SSLSocket r10) {
            Intrinsics.checkNotNullParameter(r10, "sslSocket");
            if (okhttp3.internal.platform.d.f11961e.c() == true) goto L5;
        L7:
            return false;
        L5:
            if (Conscrypt.isConscrypt(r10) == false) goto L7;
            return true;
        }

        @Override // nc.j.a
        public k b(SSLSocket r10) {
            Intrinsics.checkNotNullParameter(r10, "sslSocket");
            return new i();
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public final j.a a() {
            return i.f();
        }
    }

    static {
        f11360a = new b(null);
        f11361b = new a();
    }

    public i() {
    }

    public static final /* synthetic */ j.a f() {
        return f11361b;
    }

    @Override // nc.k
    public boolean a(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        return Conscrypt.isConscrypt(r10);
    }

    @Override // nc.k
    public String b(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        if (a(r10) == true) goto L7;
        return null;
    L7:
        return Conscrypt.getApplicationProtocol(r10);
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
        Conscrypt.setUseSessionTickets(r10, true);
        Conscrypt.setApplicationProtocols(r10, (String[]) okhttp3.internal.platform.h.f11979a.b(r12).toArray(new String[0]));
        return;
    }

    @Override // nc.k
    public boolean isSupported() {
        return okhttp3.internal.platform.d.f11961e.c();
    }
}
