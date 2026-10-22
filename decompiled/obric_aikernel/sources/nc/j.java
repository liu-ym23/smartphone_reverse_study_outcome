package nc;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f11362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k f11363b;

    public interface a {
        boolean a(SSLSocket r10);

        k b(SSLSocket r10);
    }

    public j(a r10) {
        Intrinsics.checkNotNullParameter(r10, "socketAdapterFactory");
        this.f11362a = r10;
    }

    private final synchronized k f(SSLSocket r10) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f11363b == null) goto L6;
    L8:
        k r11 = this.f11363b;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r11;
    L6:
        if (this.f11362a.a(r10) == false) goto L8;
        this.f11363b = this.f11362a.b(r10);     // Catch: Throwable -> L11
        goto L8
    }

    @Override // nc.k
    public boolean a(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        return this.f11362a.a(r10);
    }

    @Override // nc.k
    public String b(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        k r11 = f(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.b(r10);
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
        k r13 = f(r10);
        if (r13 == null) goto L6;
        r13.e(r10, r11, r12);
        return;
    }

    @Override // nc.k
    public boolean isSupported() {
        return true;
    }
}
