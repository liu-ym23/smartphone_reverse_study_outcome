package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum TlsVersion extends Enum<TlsVersion> {
    public static final TlsVersion SSL_3_0 = null;
    public static final TlsVersion TLS_1_0 = null;
    public static final TlsVersion TLS_1_1 = null;
    public static final TlsVersion TLS_1_2 = null;
    public static final TlsVersion TLS_1_3 = null;
    public static final /* synthetic */ TlsVersion[] a = null;
    final String javaName;

    static {
        TlsVersion r0 = new TlsVersion("TLS_1_3", 0, "TLSv1.3");
        TLS_1_3 = r0;
        TlsVersion r1 = new TlsVersion("TLS_1_2", 1, "TLSv1.2");
        TLS_1_2 = r1;
        TlsVersion r2 = new TlsVersion("TLS_1_1", 2, "TLSv1.1");
        TLS_1_1 = r2;
        TlsVersion r4 = new TlsVersion("TLS_1_0", 3, "TLSv1");
        TLS_1_0 = r4;
        TlsVersion r6 = new TlsVersion("SSL_3_0", 4, "SSLv3");
        SSL_3_0 = r6;
        a = new TlsVersion[]{r0, r1, r2, r4, r6};
    }

    public static TlsVersion[] values() {
        return (TlsVersion[]) a.clone();
    }

    public String javaName() {
        return this.javaName;
    }

    public static TlsVersion forJavaName(String r2) {
        r2.getClass();
        byte r1 = -1;
        switch(r2.hashCode()) {
            case -503070503: goto L22;
            case -503070502: goto L18;
            case -503070501: goto L14;
            case 79201641: goto L10;
            case 79923350: goto L6;
            default: goto L25;
        };
    L25:
        switch(r1) {
            case 0: goto L37;
            case 1: goto L35;
            case 2: goto L33;
            case 3: goto L31;
            case 4: goto L29;
            default: goto L27;
        };
    L27:
        throw new IllegalArgumentException("Unexpected TLS version: ".concat(r2));
    L29:
        return TLS_1_0;
    L31:
        return SSL_3_0;
    L33:
        return TLS_1_3;
    L35:
        return TLS_1_2;
    L37:
        return TLS_1_1;
    L6:
        if (r2.equals("TLSv1") == false) goto L25;
        r1 = 4;
        goto L25
    L10:
        if (r2.equals("SSLv3") == false) goto L25;
        r1 = 3;
        goto L25
    L14:
        if (r2.equals("TLSv1.3") == false) goto L25;
        r1 = 2;
        goto L25
    L18:
        if (r2.equals("TLSv1.2") == false) goto L25;
        r1 = 1;
        goto L25
    L22:
        if (r2.equals("TLSv1.1") == false) goto L25;
        r1 = 0;
        goto L25
    }

    public static List<TlsVersion> forJavaNames(String... r4) {
        ArrayList r0 = new ArrayList(r4.length);
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(forJavaName(r4[r2]));
        r2 = r2 + 1;
        goto L3
    L6:
        return Collections.unmodifiableList(r0);
    }

    public static TlsVersion valueOf(String r1) {
        return (TlsVersion) r27.a.a(TlsVersion.class, r1);
    }

    public TlsVersion(String r1, int r2, String r3) {
        super(r1, r2);
        this.javaName = r3;
    }
}
