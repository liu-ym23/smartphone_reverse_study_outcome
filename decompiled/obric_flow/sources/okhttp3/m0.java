package okhttp3;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 {
    public static Protocol a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "protocol");
        Protocol r10 = Protocol.HTTP_1_0;
        if (Intrinsics.areEqual(r5, Protocol.access$getProtocol$p(r10)) == true) goto L19;
        r10 = Protocol.HTTP_1_1;
        if (Intrinsics.areEqual(r5, Protocol.access$getProtocol$p(r10)) == true) goto L19;
        r10 = Protocol.H2_PRIOR_KNOWLEDGE;
        if (Intrinsics.areEqual(r5, Protocol.access$getProtocol$p(r10)) == true) goto L19;
        r10 = Protocol.HTTP_2;
        if (Intrinsics.areEqual(r5, Protocol.access$getProtocol$p(r10)) == true) goto L19;
        r10 = Protocol.SPDY_3;
        if (Intrinsics.areEqual(r5, Protocol.access$getProtocol$p(r10)) == true) goto L19;
        r10 = Protocol.QUIC;
        if (Intrinsics.areEqual(r5, Protocol.access$getProtocol$p(r10)) == true) goto L19;
        throw new IOException(ai.j0.C("Unexpected protocol: ", r5));
    L19:
        return r10;
    }
}
