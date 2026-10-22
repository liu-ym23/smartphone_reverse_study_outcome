package fmc;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c<T> extends com.ss.ugc.live.sdk.msg.utils.task.a<T, List<? extends tlc.d>> {
    public final cmc.d<T> c;

    public c(cmc.d<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        super(b.a);
        this.c = r2;
    }

    @Override // com.ss.ugc.live.sdk.msg.utils.task.a
    public final void c(T r2) {
        List<tlc.d> r3 = this.c.a(r2);
        if (r3 != null) goto L6;
        r3 = CollectionsKt.emptyList();
    L6:
        int r0 = com.ss.ugc.live.sdk.msg.utils.g.a;
        b(new com.ss.ugc.live.sdk.msg.utils.g.c(r3));
    }
}
