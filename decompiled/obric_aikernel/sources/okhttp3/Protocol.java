package okhttp3;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final enum Protocol extends Enum<Protocol> {
    private static final /* synthetic */ Protocol[] $VALUES = null;
    public static final a Companion = null;
    public static final Protocol H2_PRIOR_KNOWLEDGE = null;
    public static final Protocol HTTP_1_0 = null;
    public static final Protocol HTTP_1_1 = null;
    public static final Protocol HTTP_2 = null;
    public static final Protocol QUIC = null;

    @Deprecated(message = "OkHttp has dropped support for SPDY. Prefer {@link #HTTP_2}.")
    public static final Protocol SPDY_3 = null;
    private final String protocol;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        @JvmStatic
        public final Protocol a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "protocol");
            Protocol r11 = Protocol.HTTP_1_0;
            if (Intrinsics.areEqual(r10, Protocol.access$getProtocol$p(r11)) == true) goto L19;
            r11 = Protocol.HTTP_1_1;
            if (Intrinsics.areEqual(r10, Protocol.access$getProtocol$p(r11)) == true) goto L19;
            r11 = Protocol.H2_PRIOR_KNOWLEDGE;
            if (Intrinsics.areEqual(r10, Protocol.access$getProtocol$p(r11)) == true) goto L19;
            r11 = Protocol.HTTP_2;
            if (Intrinsics.areEqual(r10, Protocol.access$getProtocol$p(r11)) == true) goto L19;
            r11 = Protocol.SPDY_3;
            if (Intrinsics.areEqual(r10, Protocol.access$getProtocol$p(r11)) == true) goto L19;
            r11 = Protocol.QUIC;
            if (Intrinsics.areEqual(r10, Protocol.access$getProtocol$p(r11)) == true) goto L19;
            throw new IOException("Unexpected protocol: " + r10);
        L19:
            return r11;
        }
    }

    private static final /* synthetic */ Protocol[] $values() {
        return new Protocol[]{HTTP_1_0, HTTP_1_1, SPDY_3, HTTP_2, H2_PRIOR_KNOWLEDGE, QUIC};
    }

    static {
        HTTP_1_0 = new Protocol("HTTP_1_0", 0, "http/1.0");
        HTTP_1_1 = new Protocol("HTTP_1_1", 1, "http/1.1");
        SPDY_3 = new Protocol("SPDY_3", 2, "spdy/3.1");
        HTTP_2 = new Protocol("HTTP_2", 3, "h2");
        H2_PRIOR_KNOWLEDGE = new Protocol("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
        QUIC = new Protocol("QUIC", 5, "quic");
        $VALUES = $values();
        Companion = new a(null);
    }

    private Protocol(String r10, int r11, String r12) {
        super(r10, r11);
        this.protocol = r12;
    }

    public static final /* synthetic */ String access$getProtocol$p(Protocol r10) {
        return r10.protocol;
    }

    @JvmStatic
    public static final Protocol get(String r10) {
        return Companion.a(r10);
    }

    public static Protocol valueOf(String r10) {
        return (Protocol) Enum.valueOf(Protocol.class, r10);
    }

    public static Protocol[] values() {
        return (Protocol[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
