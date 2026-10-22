package okhttp3;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f11712b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Comparator<String> f11713c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, h> f11714d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    public static final h f11715e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @JvmField
    public static final h f11716f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public static final h f11717g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public static final h f11718h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @JvmField
    public static final h f11719i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @JvmField
    public static final h f11720j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @JvmField
    public static final h f11721k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @JvmField
    public static final h f11722l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @JvmField
    public static final h f11723m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @JvmField
    public static final h f11724n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @JvmField
    public static final h f11725o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @JvmField
    public static final h f11726p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @JvmField
    public static final h f11727q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @JvmField
    public static final h f11728r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @JvmField
    public static final h f11729s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @JvmField
    public static final h f11730t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11731a;

    public static final class a implements Comparator<String> {
        a() {
        }

        public int a(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "a");
            Intrinsics.checkNotNullParameter(r11, "b");
            int r12 = Math.min(r10.length(), r11.length());
            int r13 = 4;
        L4:
            if (r13 >= r12) goto L13;
            char r14 = r10.charAt(r13);
            char r15 = r11.charAt(r13);
            if (r14 != r15) goto L8;
            r13 = r13 + 1;
            goto L4
        L8:
            if (Intrinsics.compare(r14, r15) >= 0) goto L11;
            return -1;
        L11:
            return 1;
        L13:
            int r16 = r10.length();
            int r17 = r11.length();
            if (r16 == r17) goto L19;
            if (r16 >= r17) goto L18;
            return -1;
        L18:
            return 1;
        L19:
            return 0;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(String r10, String r11) {
            return a(r10, r11);
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ h a(b r10, String r11, int r12) {
            return r10.d(r11, r12);
        }

        private final h d(String r10, int r11) {
            h r12 = new h(r10, null);
            h.a().put(r10, r12);
            return r12;
        }

        private final String e(String r10) {
            if (StringsKt.startsWith$default(r10, "TLS_", false, 2, null) == false) goto L6;
            StringBuilder r11 = new StringBuilder();
            r11.append("SSL_");
            String r12 = r10.substring(4);
            Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).substring(startIndex)");
            r11.append(r12);
            return r11.toString();
        L6:
            if (StringsKt.startsWith$default(r10, "SSL_", false, 2, null) == false) goto L10;
            StringBuilder r13 = new StringBuilder();
            r13.append("TLS_");
            String r14 = r10.substring(4);
            Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).substring(startIndex)");
            r13.append(r14);
            return r13.toString();
        L10:
            return r10;
        }

        @JvmStatic
        public final synchronized h b(String r10) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r10, "javaName");     // Catch: Throwable -> L11
            h r11 = (h) h.a().get(r10);     // Catch: Throwable -> L11
            if (r11 != null) goto L9;
            r11 = (h) h.a().get(e(r10));     // Catch: Throwable -> L11
            if (r11 != null) goto L8;
            r11 = new h(r10, null);     // Catch: Throwable -> L11
        L8:
            h.a().put(r10, r11);     // Catch: Throwable -> L11
        L9:
            monitor-exit(this);
            return r11;
        L11:
            th = move-exception;
            throw th;
        }

        public final Comparator<String> c() {
            return h.b();
        }
    }

    static {
        b r10 = new b(null);
        f11712b = r10;
        f11713c = new a();
        f11714d = new LinkedHashMap();
        b.a(r10, "SSL_RSA_WITH_NULL_MD5", 1);
        b.a(r10, "SSL_RSA_WITH_NULL_SHA", 2);
        b.a(r10, "SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        b.a(r10, "SSL_RSA_WITH_RC4_128_MD5", 4);
        b.a(r10, "SSL_RSA_WITH_RC4_128_SHA", 5);
        b.a(r10, "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        b.a(r10, "SSL_RSA_WITH_DES_CBC_SHA", 9);
        f11715e = b.a(r10, "SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        b.a(r10, "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        b.a(r10, "SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        b.a(r10, "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        b.a(r10, "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        b.a(r10, "SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        b.a(r10, "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        b.a(r10, "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        b.a(r10, "SSL_DH_anon_WITH_RC4_128_MD5", 24);
        b.a(r10, "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        b.a(r10, "SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        b.a(r10, "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        b.a(r10, "TLS_KRB5_WITH_DES_CBC_SHA", 30);
        b.a(r10, "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        b.a(r10, "TLS_KRB5_WITH_RC4_128_SHA", 32);
        b.a(r10, "TLS_KRB5_WITH_DES_CBC_MD5", 34);
        b.a(r10, "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        b.a(r10, "TLS_KRB5_WITH_RC4_128_MD5", 36);
        b.a(r10, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        b.a(r10, "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        b.a(r10, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        b.a(r10, "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        f11716f = b.a(r10, "TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        b.a(r10, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        b.a(r10, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        b.a(r10, "TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        f11717g = b.a(r10, "TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        b.a(r10, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        b.a(r10, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        b.a(r10, "TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        b.a(r10, "TLS_RSA_WITH_NULL_SHA256", 59);
        b.a(r10, "TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        b.a(r10, "TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        b.a(r10, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        b.a(r10, "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        b.a(r10, "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        b.a(r10, "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        b.a(r10, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        b.a(r10, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        b.a(r10, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        b.a(r10, "TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        b.a(r10, "TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        b.a(r10, "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        b.a(r10, "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        b.a(r10, "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        b.a(r10, "TLS_PSK_WITH_RC4_128_SHA", 138);
        b.a(r10, "TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        b.a(r10, "TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        b.a(r10, "TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        b.a(r10, "TLS_RSA_WITH_SEED_CBC_SHA", 150);
        f11718h = b.a(r10, "TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        f11719i = b.a(r10, "TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        b.a(r10, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        b.a(r10, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        b.a(r10, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        b.a(r10, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        b.a(r10, "TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        b.a(r10, "TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        b.a(r10, "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        b.a(r10, "TLS_FALLBACK_SCSV", 22016);
        b.a(r10, "TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        b.a(r10, "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        b.a(r10, "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        b.a(r10, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        b.a(r10, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        b.a(r10, "TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        b.a(r10, "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        b.a(r10, "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        b.a(r10, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        b.a(r10, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        b.a(r10, "TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        b.a(r10, "TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        b.a(r10, "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        b.a(r10, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        b.a(r10, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        b.a(r10, "TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        b.a(r10, "TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        b.a(r10, "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        f11720j = b.a(r10, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        f11721k = b.a(r10, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        b.a(r10, "TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        b.a(r10, "TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        b.a(r10, "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        b.a(r10, "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        b.a(r10, "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        b.a(r10, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        b.a(r10, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        b.a(r10, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        b.a(r10, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        b.a(r10, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        b.a(r10, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        b.a(r10, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        b.a(r10, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        f11722l = b.a(r10, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        f11723m = b.a(r10, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        b.a(r10, "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        b.a(r10, "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        f11724n = b.a(r10, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        f11725o = b.a(r10, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        b.a(r10, "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        b.a(r10, "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        b.a(r10, "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        b.a(r10, "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        f11726p = b.a(r10, "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        f11727q = b.a(r10, "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        b.a(r10, "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        b.a(r10, "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        f11728r = b.a(r10, "TLS_AES_128_GCM_SHA256", 4865);
        f11729s = b.a(r10, "TLS_AES_256_GCM_SHA384", 4866);
        f11730t = b.a(r10, "TLS_CHACHA20_POLY1305_SHA256", 4867);
        b.a(r10, "TLS_AES_128_CCM_SHA256", 4868);
        b.a(r10, "TLS_AES_128_CCM_8_SHA256", 4869);
    }

    private h(String r10) {
        this.f11731a = r10;
    }

    public /* synthetic */ h(String r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    public static final /* synthetic */ Map a() {
        return f11714d;
    }

    public static final /* synthetic */ Comparator b() {
        return f11713c;
    }

    @JvmName(name = "javaName")
    public final String c() {
        return this.f11731a;
    }

    public String toString() {
        return this.f11731a;
    }
}
