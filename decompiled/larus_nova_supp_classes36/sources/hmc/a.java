package hmc;

import com.ss.ugc.live.sdk.msg.network.g;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWFetchResponse;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final g a;
    public final UMGWFetchResponse b;
    public final List<b> c;

    public a(g r2, UMGWFetchResponse r3, List<b> r4) {
        Intrinsics.checkNotNullParameter(r2, "httpResponse");
        Intrinsics.checkNotNullParameter(r3, "originResponse");
        Intrinsics.checkNotNullParameter(r4, "decodePackets");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
