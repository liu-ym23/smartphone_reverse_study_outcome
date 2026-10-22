package df;

import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.conscrypt.Conscrypt;
import we.w;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends f {
    public static c n() {
        Class.forName("org.conscrypt.Conscrypt");     // Catch: ClassNotFoundException -> L8
        if (Conscrypt.isAvailable() == true) goto L6;
        return null;
    L6:
        return new c();
    L8:
        return null;
    }

    public static Provider o() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    @Override // df.f
    public final void e(SSLSocketFactory r8) {
        if (Conscrypt.isConscrypt(r8) == false) goto L6;
        Conscrypt.setUseEngineSocket(r8, true);
        return;
    }

    @Override // df.f
    public final void f(SSLSocket r8, String r10, List<w> r11) {
        if (Conscrypt.isConscrypt(r8) == false) goto L8;
        if (r10 == null) goto L6;
        Conscrypt.setUseSessionTickets(r8, true);
        Conscrypt.setHostname(r8, r10);
    L6:
        Conscrypt.setApplicationProtocols(r8, (String[]) f.b(r11).toArray(new String[0]));
        return;
    }

    @Override // df.f
    public final SSLContext h() {
        return SSLContext.getInstance("TLSv1.3", o());
    L4:
        e = move-exception;
        return SSLContext.getInstance("TLS", o());
    L8:
        throw new IllegalStateException("No TLS provider", e);
    }

    @Override // df.f
    @Nullable
    public final String i(SSLSocket r8) {
        if (Conscrypt.isConscrypt(r8) == true) goto L5;
        return null;
    L5:
        return Conscrypt.getApplicationProtocol(r8);
    }
}
