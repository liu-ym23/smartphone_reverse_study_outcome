package okhttp3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class y0 {
    public static TlsVersion a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "javaName");
        int r10 = r5.hashCode();
        if (r10 == 79201641) goto L21;
        if (r10 == 79923350) goto L18;
        switch(r10) {
            case -503070503: goto L15;
            case -503070502: goto L12;
            case -503070501: goto L9;
            default: goto L25;
        };
    L9:
        if (r5.equals("TLSv1.3") == false) goto L25;
        return TlsVersion.TLS_1_3;
    L12:
        if (r5.equals("TLSv1.2") == false) goto L25;
        return TlsVersion.TLS_1_2;
    L15:
        if (r5.equals("TLSv1.1") == false) goto L25;
        return TlsVersion.TLS_1_1;
    L25:
        throw new IllegalArgumentException("Unexpected TLS version: ".concat(r5));
    L18:
        if (r5.equals("TLSv1") == false) goto L25;
        return TlsVersion.TLS_1_0;
    L21:
        if (r5.equals("SSLv3") == false) goto L25;
        return TlsVersion.SSL_3_0;
    }
}
