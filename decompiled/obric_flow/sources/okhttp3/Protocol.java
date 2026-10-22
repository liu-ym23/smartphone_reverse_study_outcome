package okhttp3;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/Protocol;", "", "", "toString", "()Ljava/lang/String;", "protocol", "Ljava/lang/String;", "Companion", "okhttp3/m0", "HTTP_1_0", "HTTP_1_1", "SPDY_3", "HTTP_2", "H2_PRIOR_KNOWLEDGE", "QUIC", "okhttp"}, k = 1, mv = {1, 4, 0})
public final enum Protocol extends Enum<Protocol> {
    public static final m0 Companion = null;
    public static final Protocol H2_PRIOR_KNOWLEDGE = null;
    public static final Protocol HTTP_1_0 = null;
    public static final Protocol HTTP_1_1 = null;
    public static final Protocol HTTP_2 = null;
    public static final Protocol QUIC = null;

    @Deprecated(message = "OkHttp has dropped support for SPDY. Prefer {@link #HTTP_2}.")
    public static final Protocol SPDY_3 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Protocol[] f20608a = null;
    private final String protocol;

    static {
        Protocol r5 = new Protocol("HTTP_1_0", 0, "http/1.0");
        HTTP_1_0 = r5;
        Protocol r10 = new Protocol("HTTP_1_1", 1, "http/1.1");
        HTTP_1_1 = r10;
        Protocol r11 = new Protocol("SPDY_3", 2, "spdy/3.1");
        SPDY_3 = r11;
        Protocol r12 = new Protocol("HTTP_2", 3, "h2");
        HTTP_2 = r12;
        Protocol r13 = new Protocol("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
        H2_PRIOR_KNOWLEDGE = r13;
        Protocol r14 = new Protocol("QUIC", 5, "quic");
        QUIC = r14;
        f20608a = new Protocol[]{r5, r10, r11, r12, r13, r14};
        Companion = new m0();
    }

    public Protocol(String r5, int r10, String r11) {
        super(r5, r10);
        this.protocol = r11;
    }

    public static final /* synthetic */ String access$getProtocol$p(Protocol r5) {
        return r5.protocol;
    }

    @JvmStatic
    public static final Protocol get(String r5) throws IOException {
        Companion.getClass();
        return m0.a(r5);
    }

    public static Protocol valueOf(String r5) {
        return (Protocol) Enum.valueOf(Protocol.class, r5);
    }

    public static Protocol[] values() {
        return (Protocol[]) f20608a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
