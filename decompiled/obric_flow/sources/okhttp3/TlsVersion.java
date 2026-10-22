package okhttp3;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0004j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lokhttp3/TlsVersion;", "", "", "-deprecated_javaName", "()Ljava/lang/String;", "javaName", "Ljava/lang/String;", "Companion", "okhttp3/y0", "TLS_1_3", "TLS_1_2", "TLS_1_1", "TLS_1_0", "SSL_3_0", "okhttp"}, k = 1, mv = {1, 4, 0})
public final enum TlsVersion extends Enum<TlsVersion> {
    public static final y0 Companion = null;
    public static final TlsVersion SSL_3_0 = null;
    public static final TlsVersion TLS_1_0 = null;
    public static final TlsVersion TLS_1_1 = null;
    public static final TlsVersion TLS_1_2 = null;
    public static final TlsVersion TLS_1_3 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TlsVersion[] f20609a = null;
    private final String javaName;

    static {
        TlsVersion r5 = new TlsVersion("TLS_1_3", 0, "TLSv1.3");
        TLS_1_3 = r5;
        TlsVersion r10 = new TlsVersion("TLS_1_2", 1, "TLSv1.2");
        TLS_1_2 = r10;
        TlsVersion r11 = new TlsVersion("TLS_1_1", 2, "TLSv1.1");
        TLS_1_1 = r11;
        TlsVersion r12 = new TlsVersion("TLS_1_0", 3, "TLSv1");
        TLS_1_0 = r12;
        TlsVersion r13 = new TlsVersion("SSL_3_0", 4, "SSLv3");
        SSL_3_0 = r13;
        f20609a = new TlsVersion[]{r5, r10, r11, r12, r13};
        Companion = new y0();
    }

    public TlsVersion(String r5, int r10, String r11) {
        super(r5, r10);
        this.javaName = r11;
    }

    @JvmStatic
    public static final TlsVersion forJavaName(String r5) {
        Companion.getClass();
        return y0.a(r5);
    }

    public static TlsVersion valueOf(String r5) {
        return (TlsVersion) Enum.valueOf(TlsVersion.class, r5);
    }

    public static TlsVersion[] values() {
        return (TlsVersion[]) f20609a.clone();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "javaName", imports = {}))
    @JvmName(name = "-deprecated_javaName")
    /* JADX INFO: renamed from: -deprecated_javaName, reason: not valid java name */
    public final String m1641deprecated_javaName() {
        return this.javaName;
    }

    @JvmName(name = "javaName")
    public final String javaName() {
        return this.javaName;
    }
}
