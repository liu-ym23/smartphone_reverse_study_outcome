package df;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import we.w;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
public final class a extends b {
    public a(Class<?> r8) {
        super(r8, null, null, null, null);
    }

    @Override // df.b, df.f
    @SuppressLint({"NewApi"})
    @IgnoreJRERequirement
    public final void f(SSLSocket r8, String r10, List<w> r11) {
    L7:
        e = move-exception;
        throw new IOException("Android internal error", e);
    L3:
        if (SSLSockets.isSupportedSocket(r8) == false) goto L5;
        SSLSockets.setUseSessionTickets(r8, true);     // Catch: IllegalArgumentException -> L7
    L5:
        SSLParameters r12 = r8.getSSLParameters();     // Catch: IllegalArgumentException -> L7
        r12.setApplicationProtocols((String[]) f.b(r11).toArray(new String[0]));     // Catch: IllegalArgumentException -> L7
        r8.setSSLParameters(r12);     // Catch: IllegalArgumentException -> L7
    }

    @Override // df.b, df.f
    @Nullable
    @IgnoreJRERequirement
    public final String i(SSLSocket r8) {
        String r10 = r8.getApplicationProtocol();
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.isEmpty() == true) goto L10;
        return r10;
    L10:
        return null;
    }
}
