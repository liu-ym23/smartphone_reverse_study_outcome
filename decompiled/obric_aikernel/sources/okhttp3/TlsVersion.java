package okhttp3;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final enum TlsVersion extends Enum<TlsVersion> {
    private static final /* synthetic */ TlsVersion[] $VALUES = null;
    public static final a Companion = null;
    public static final TlsVersion SSL_3_0 = null;
    public static final TlsVersion TLS_1_0 = null;
    public static final TlsVersion TLS_1_1 = null;
    public static final TlsVersion TLS_1_2 = null;
    public static final TlsVersion TLS_1_3 = null;
    private final String javaName;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        @JvmStatic
        public final TlsVersion a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "javaName");
            int r11 = r10.hashCode();
            if (r11 == 79201641) goto L21;
            if (r11 == 79923350) goto L18;
            switch(r11) {
                case -503070503: goto L15;
                case -503070502: goto L12;
                case -503070501: goto L9;
                default: goto L25;
            };
        L9:
            if (r10.equals("TLSv1.3") == false) goto L25;
            return TlsVersion.TLS_1_3;
        L12:
            if (r10.equals("TLSv1.2") == false) goto L25;
            return TlsVersion.TLS_1_2;
        L15:
            if (r10.equals("TLSv1.1") == false) goto L25;
            return TlsVersion.TLS_1_1;
        L25:
            throw new IllegalArgumentException("Unexpected TLS version: " + r10);
        L18:
            if (r10.equals("TLSv1") == false) goto L25;
            return TlsVersion.TLS_1_0;
        L21:
            if (r10.equals("SSLv3") == false) goto L25;
            return TlsVersion.SSL_3_0;
        }
    }

    private static final /* synthetic */ TlsVersion[] $values() {
        return new TlsVersion[]{TLS_1_3, TLS_1_2, TLS_1_1, TLS_1_0, SSL_3_0};
    }

    static {
        TLS_1_3 = new TlsVersion("TLS_1_3", 0, "TLSv1.3");
        TLS_1_2 = new TlsVersion("TLS_1_2", 1, "TLSv1.2");
        TLS_1_1 = new TlsVersion("TLS_1_1", 2, "TLSv1.1");
        TLS_1_0 = new TlsVersion("TLS_1_0", 3, "TLSv1");
        SSL_3_0 = new TlsVersion("SSL_3_0", 4, "SSLv3");
        $VALUES = $values();
        Companion = new a(null);
    }

    private TlsVersion(String r10, int r11, String r12) {
        super(r10, r11);
        this.javaName = r12;
    }

    @JvmStatic
    public static final TlsVersion forJavaName(String r10) {
        return Companion.a(r10);
    }

    public static TlsVersion valueOf(String r10) {
        return (TlsVersion) Enum.valueOf(TlsVersion.class, r10);
    }

    public static TlsVersion[] values() {
        return (TlsVersion[]) $VALUES.clone();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "javaName", imports = {}))
    @JvmName(name = "-deprecated_javaName")
    /* JADX INFO: renamed from: -deprecated_javaName, reason: not valid java name */
    public final String m1550deprecated_javaName() {
        return this.javaName;
    }

    @JvmName(name = "javaName")
    public final String javaName() {
        return this.javaName;
    }
}
