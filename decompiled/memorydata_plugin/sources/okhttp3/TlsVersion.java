package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0006R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lokhttp3/TlsVersion;", "", "javaName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "()Ljava/lang/String;", "-deprecated_javaName", "TLS_1_3", "TLS_1_2", "TLS_1_1", "TLS_1_0", "SSL_3_0", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final enum TlsVersion extends Enum<TlsVersion> {
    private static final /* synthetic */ TlsVersion[] $VALUES = null;
    public static final Companion Companion = null;
    public static final TlsVersion SSL_3_0 = null;
    public static final TlsVersion TLS_1_0 = null;
    public static final TlsVersion TLS_1_1 = null;
    public static final TlsVersion TLS_1_2 = null;
    public static final TlsVersion TLS_1_3 = null;
    private final String javaName;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lokhttp3/TlsVersion$Companion;", "", "()V", "forJavaName", "Lokhttp3/TlsVersion;", "javaName", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final TlsVersion forJavaName(String r3) {
            Intrinsics.checkParameterIsNotNull(r3, "javaName");
            int r2 = r3.hashCode();
            if (r2 == 79201641) goto L21;
            if (r2 == 79923350) goto L18;
            switch(r2) {
                case -503070503: goto L15;
                case -503070502: goto L12;
                case -503070501: goto L9;
                default: goto L25;
            };
        L9:
            if (r3.equals("TLSv1.3") == false) goto L25;
            return TlsVersion.TLS_1_3;
        L12:
            if (r3.equals("TLSv1.2") == false) goto L25;
            return TlsVersion.TLS_1_2;
        L15:
            if (r3.equals("TLSv1.1") == false) goto L25;
            return TlsVersion.TLS_1_1;
        L25:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Unexpected TLS version: " + r3), Throwable.class, "com.obric.memorydata.plugin"));
        L18:
            if (r3.equals("TLSv1") == false) goto L25;
            return TlsVersion.TLS_1_0;
        L21:
            if (r3.equals("SSLv3") == false) goto L25;
            return TlsVersion.SSL_3_0;
        }
    }

    static {
        TlsVersion r1 = new TlsVersion("TLS_1_3", 0, "TLSv1.3");
        TLS_1_3 = r1;
        TlsVersion r2 = new TlsVersion("TLS_1_2", 1, "TLSv1.2");
        TLS_1_2 = r2;
        TlsVersion r3 = new TlsVersion("TLS_1_1", 2, "TLSv1.1");
        TLS_1_1 = r3;
        TlsVersion r4 = new TlsVersion("TLS_1_0", 3, "TLSv1");
        TLS_1_0 = r4;
        TlsVersion r5 = new TlsVersion("SSL_3_0", 4, "SSLv3");
        SSL_3_0 = r5;
        $VALUES = new TlsVersion[]{r1, r2, r3, r4, r5};
        Companion = new Companion(null);
    }

    private TlsVersion(String r1, int r2, String r3) {
        super(r1, r2);
        this.javaName = r3;
    }

    @JvmStatic
    public static final TlsVersion forJavaName(String r1) {
        return Companion.forJavaName(r1);
    }

    public static TlsVersion valueOf(String r2) {
        return (TlsVersion) ZeusTransformUtils.preCheckCast(Enum.valueOf(TlsVersion.class, r2), TlsVersion.class, "com.obric.memorydata.plugin");
    }

    public static TlsVersion[] values() {
        return (TlsVersion[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TlsVersion[].class, "com.obric.memorydata.plugin");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "javaName", imports = {}))
    /* JADX INFO: renamed from: -deprecated_javaName, reason: not valid java name */
    public final String m3046deprecated_javaName() {
        return this.javaName;
    }

    public final String javaName() {
        return this.javaName;
    }
}
