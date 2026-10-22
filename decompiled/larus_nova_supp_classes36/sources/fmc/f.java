package fmc;

import com.ss.ugc.live.sdk.msg.network.HttpException;
import com.ss.ugc.live.sdk.msg.task.HistoryHttpException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements com.ss.ugc.live.sdk.msg.network.e {
    public final /* synthetic */ g a;
    public final /* synthetic */ com.ss.ugc.live.sdk.msg.utils.j b;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.ugc.live.sdk.msg.network.e
    public final void a(com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
    L18:
        th = move-exception;
        if ((th instanceof Exception) == false) goto L32;
        int r0 = com.ss.ugc.live.sdk.msg.utils.g.a;
        com.ss.ugc.live.sdk.msg.utils.g r5 = com.ss.ugc.live.sdk.msg.utils.g.a.a(th);
    L23:
        if ((r5 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L26;
        com.ss.ugc.live.sdk.msg.utils.g r1 = new com.ss.ugc.live.sdk.msg.utils.g.c(((com.ss.ugc.live.sdk.msg.utils.g.c) r5).b);
    L28:
        this.b.b(new com.ss.ugc.live.sdk.msg.utils.k(this.a.b, r1));
        return;
    L26:
        if ((r5 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L31;
        Exception r6 = (Exception) ((com.ss.ugc.live.sdk.msg.utils.g.b) r5).b;
        r1 = new com.ss.ugc.live.sdk.msg.utils.g.b(new HistoryHttpException(this.a.e, r6));
        goto L28
    L31:
        throw new NoWhenBranchMatchedException();
    L32:
        throw th;
    L4:
        if ((r4 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L14;
        com.ss.ugc.live.sdk.msg.network.g r7 = (com.ss.ugc.live.sdk.msg.network.g) ((com.ss.ugc.live.sdk.msg.utils.g.c) r4).b;     // Catch: Throwable -> L18
        Object r2 = r7.e;     // Catch: Throwable -> L18
        if ((r2 instanceof com.ss.ugc.live.sdk.msg.data.b) == true) goto L8;
        r2 = null;
    L8:
        com.ss.ugc.live.sdk.msg.data.b r3 = (com.ss.ugc.live.sdk.msg.data.b) r2;     // Catch: Throwable -> L18
        if (r7.a() == false) goto L12;
        if (r3 == null) goto L12;
        int r8 = com.ss.ugc.live.sdk.msg.utils.g.a;     // Catch: Throwable -> L18
        r5 = new com.ss.ugc.live.sdk.msg.utils.g.c(r3);     // Catch: Throwable -> L18
    L12:
        int r9 = com.ss.ugc.live.sdk.msg.utils.g.a;     // Catch: Throwable -> L18
        r5 = com.ss.ugc.live.sdk.msg.utils.g.a.a(new HttpException(r7.a, com.ss.ugc.live.sdk.msg.utils.c.c(r7)));     // Catch: Throwable -> L18
        goto L23
    L14:
        if ((r4 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L17;
        r5 = new com.ss.ugc.live.sdk.msg.utils.g.b(((com.ss.ugc.live.sdk.msg.utils.g.b) r4).b);     // Catch: Throwable -> L18
        goto L23
    L17:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L18
    }

    public f(g r1, com.ss.ugc.live.sdk.msg.utils.j r2) {
        this.a = r1;
        this.b = r2;
    }
}
