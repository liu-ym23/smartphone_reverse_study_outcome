package mo8;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c extends a {
    @Override // mo8.a
    public final String b() {
        return "flow_im_message_receive_first_package";
    }

    @Override // mo8.a
    public final String c() {
        return "client_message_receive_first_package";
    }

    @Override // mo8.a
    public final String d() {
        return "flow_im_message_sent_end";
    }

    @Override // mo8.a
    public final List<String> a() {
        return CollectionsKt.mutableListOf(new String[]{"flow_im_message_receive_first_chunk", "flow_im_message_receive_first_package"});
    }

    public c(com.larus.trace.tracespan.span.b r2) {
        Intrinsics.checkNotNullParameter(r2, "parentSpan");
        super(r2);
    }
}
