package okhttp3;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum Protocol extends Enum<Protocol> {
    public static final Protocol H2_PRIOR_KNOWLEDGE = null;
    public static final Protocol HTTP_1_0 = null;
    public static final Protocol HTTP_1_1 = null;
    public static final Protocol HTTP_2 = null;
    public static final Protocol QUIC = null;
    public static final Protocol SPDY_3 = null;
    public static final /* synthetic */ Protocol[] a = null;
    private final String protocol;

    static {
        Protocol r0 = new Protocol("HTTP_1_0", 0, "http/1.0");
        HTTP_1_0 = r0;
        Protocol r1 = new Protocol("HTTP_1_1", 1, "http/1.1");
        HTTP_1_1 = r1;
        Protocol r2 = new Protocol("SPDY_3", 2, "spdy/3.1");
        SPDY_3 = r2;
        Protocol r4 = new Protocol("HTTP_2", 3, "h2");
        HTTP_2 = r4;
        Protocol r6 = new Protocol("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
        H2_PRIOR_KNOWLEDGE = r6;
        Protocol r8 = new Protocol("QUIC", 5, "quic");
        QUIC = r8;
        a = new Protocol[]{r0, r1, r2, r4, r6, r8};
    }

    public static Protocol[] values() {
        return (Protocol[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }

    public static Protocol get(String r2) throws IOException {
        Protocol r0 = HTTP_1_0;
        if (r2.equals(r0.protocol) == false) goto L5;
        return r0;
    L5:
        Protocol r1 = HTTP_1_1;
        if (r2.equals(r1.protocol) == false) goto L8;
        return r1;
    L8:
        Protocol r3 = H2_PRIOR_KNOWLEDGE;
        if (r2.equals(r3.protocol) == false) goto L11;
        return r3;
    L11:
        Protocol r4 = HTTP_2;
        if (r2.equals(r4.protocol) == false) goto L14;
        return r4;
    L14:
        Protocol r5 = SPDY_3;
        if (r2.equals(r5.protocol) == false) goto L17;
        return r5;
    L17:
        Protocol r6 = QUIC;
        if (r2.equals(r6.protocol) == false) goto L21;
        return r6;
    L21:
        throw new IOException("Unexpected protocol: ".concat(r2));
    }

    public static Protocol valueOf(String r1) {
        return (Protocol) r27.a.a(Protocol.class, r1);
    }

    public Protocol(String r1, int r2, String r3) {
        super(r1, r2);
        this.protocol = r3;
    }
}
