package we;

import java.util.Comparator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f13173b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap f13174c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f13175d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f13176e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f13177f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g f13178g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g f13179h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final g f13180i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final g f13181j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final g f13182k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final g f13183l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final g f13184m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final g f13185n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final g f13186o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final g f13187p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final g f13188q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final g f13189r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final g f13190s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final g f13191t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final g f13192u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13193a;

    public static class a implements Comparator<String> {
        @Override // java.util.Comparator
        public final int compare(String r8, String r10) {
            String r11 = r8;
            String r12 = r10;
            int r13 = Math.min(r11.length(), r12.length());
            int r14 = 4;
        L4:
            if (r14 >= r13) goto L10;
            char r15 = r11.charAt(r14);
            char r16 = r12.charAt(r14);
            if (r15 != r16) goto L7;
            r14 = r14 + 1;
            goto L4
        L7:
            if (r15 < r16) goto L19;
            return 1;
        L19:
            return -1;
        L10:
            int r17 = r11.length();
            int r18 = r12.length();
            if (r17 == r18) goto L14;
            if (r17 < r18) goto L19;
            return 1;
        L14:
            return 0;
        }
    }

    static {
        f13173b = new a();
        f13174c = new LinkedHashMap();
        b("SSL_RSA_WITH_NULL_MD5");
        b("SSL_RSA_WITH_NULL_SHA");
        b("SSL_RSA_EXPORT_WITH_RC4_40_MD5");
        b("SSL_RSA_WITH_RC4_128_MD5");
        b("SSL_RSA_WITH_RC4_128_SHA");
        b("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
        b("SSL_RSA_WITH_DES_CBC_SHA");
        f13175d = b("SSL_RSA_WITH_3DES_EDE_CBC_SHA");
        b("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
        b("SSL_DHE_DSS_WITH_DES_CBC_SHA");
        b("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
        b("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
        b("SSL_DHE_RSA_WITH_DES_CBC_SHA");
        b("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
        b("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
        b("SSL_DH_anon_WITH_RC4_128_MD5");
        b("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
        b("SSL_DH_anon_WITH_DES_CBC_SHA");
        b("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
        b("TLS_KRB5_WITH_DES_CBC_SHA");
        b("TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
        b("TLS_KRB5_WITH_RC4_128_SHA");
        b("TLS_KRB5_WITH_DES_CBC_MD5");
        b("TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
        b("TLS_KRB5_WITH_RC4_128_MD5");
        b("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
        b("TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
        b("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
        b("TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
        f13176e = b("TLS_RSA_WITH_AES_128_CBC_SHA");
        b("TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
        b("TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
        b("TLS_DH_anon_WITH_AES_128_CBC_SHA");
        f13177f = b("TLS_RSA_WITH_AES_256_CBC_SHA");
        b("TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
        b("TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
        b("TLS_DH_anon_WITH_AES_256_CBC_SHA");
        b("TLS_RSA_WITH_NULL_SHA256");
        b("TLS_RSA_WITH_AES_128_CBC_SHA256");
        b("TLS_RSA_WITH_AES_256_CBC_SHA256");
        b("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
        b("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");
        b("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");
        b("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");
        b("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
        b("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
        b("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
        b("TLS_DH_anon_WITH_AES_128_CBC_SHA256");
        b("TLS_DH_anon_WITH_AES_256_CBC_SHA256");
        b("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");
        b("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");
        b("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");
        b("TLS_PSK_WITH_RC4_128_SHA");
        b("TLS_PSK_WITH_3DES_EDE_CBC_SHA");
        b("TLS_PSK_WITH_AES_128_CBC_SHA");
        b("TLS_PSK_WITH_AES_256_CBC_SHA");
        b("TLS_RSA_WITH_SEED_CBC_SHA");
        f13178g = b("TLS_RSA_WITH_AES_128_GCM_SHA256");
        f13179h = b("TLS_RSA_WITH_AES_256_GCM_SHA384");
        b("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
        b("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
        b("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
        b("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
        b("TLS_DH_anon_WITH_AES_128_GCM_SHA256");
        b("TLS_DH_anon_WITH_AES_256_GCM_SHA384");
        b("TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
        b("TLS_FALLBACK_SCSV");
        b("TLS_ECDH_ECDSA_WITH_NULL_SHA");
        b("TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
        b("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
        b("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
        b("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
        b("TLS_ECDHE_ECDSA_WITH_NULL_SHA");
        b("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
        b("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
        b("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
        b("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
        b("TLS_ECDH_RSA_WITH_NULL_SHA");
        b("TLS_ECDH_RSA_WITH_RC4_128_SHA");
        b("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
        b("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
        b("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
        b("TLS_ECDHE_RSA_WITH_NULL_SHA");
        b("TLS_ECDHE_RSA_WITH_RC4_128_SHA");
        b("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
        f13180i = b("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
        f13181j = b("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
        b("TLS_ECDH_anon_WITH_NULL_SHA");
        b("TLS_ECDH_anon_WITH_RC4_128_SHA");
        b("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
        b("TLS_ECDH_anon_WITH_AES_128_CBC_SHA");
        b("TLS_ECDH_anon_WITH_AES_256_CBC_SHA");
        b("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
        b("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
        b("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
        b("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
        b("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
        b("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
        b("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
        b("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
        f13182k = b("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
        f13183l = b("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
        b("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
        b("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
        f13184m = b("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        f13185n = b("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
        b("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
        b("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
        b("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA");
        b("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA");
        f13186o = b("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        f13187p = b("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");
        b("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        b("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256");
        f13188q = b("TLS_AES_128_GCM_SHA256");
        f13189r = b("TLS_AES_256_GCM_SHA384");
        f13190s = b("TLS_CHACHA20_POLY1305_SHA256");
        f13191t = b("TLS_AES_128_CCM_SHA256");
        f13192u = b("TLS_AES_256_CCM_8_SHA256");
    }

    public g(String r8) {
        if (r8 == null) goto L7;
        this.f13193a = r8;
        return;
    L7:
        throw null;
    }

    public static synchronized g a(String r8) {
        monitor-enter(g.class);
        LinkedHashMap r10 = f13174c;     // Catch: Throwable -> L19
        g r11 = (g) r10.get(r8);     // Catch: Throwable -> L19
        if (r11 == null) goto L7;
    L17:
        monitor-exit(g.class);
        return r11;
    L7:
        if (r8.startsWith("TLS_") == false) goto L10;
        String r12 = "SSL_" + r8.substring(4);     // Catch: Throwable -> L19
    L13:
        r11 = (g) r10.get(r12);     // Catch: Throwable -> L19
        if (r11 != null) goto L16;
        r11 = new g(r8);     // Catch: Throwable -> L19
    L16:
        r10.put(r8, r11);     // Catch: Throwable -> L19
        goto L17
    L10:
        if (r8.startsWith("SSL_") == false) goto L12;
        r12 = "TLS_" + r8.substring(4);     // Catch: Throwable -> L19
        goto L13
    L12:
        r12 = r8;
    L19:
        th = move-exception;
        throw th;
    }

    public static g b(String r8) {
        g r10 = new g(r8);
        f13174c.put(r8, r10);
        return r10;
    }

    public final String toString() {
        return this.f13193a;
    }
}
