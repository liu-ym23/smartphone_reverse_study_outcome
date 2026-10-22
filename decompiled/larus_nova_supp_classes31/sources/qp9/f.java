package qp9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f implements rp9.c.b {
    public final /* synthetic */ h a;

    @Override // rp9.c.b
    public final void b(rp9.c r2) {
        Intrinsics.checkNotNullParameter(r2, "detector");
    }

    @Override // rp9.c.b
    public final void c(rp9.c r2) {
        Intrinsics.checkNotNullParameter(r2, "detector");
    }

    public f(h r1) {
        this.a = r1;
    }

    @Override // rp9.c.b
    public final void a(rp9.c r2) {
        Intrinsics.checkNotNullParameter(r2, "detector");
        i r0 = this.a.a;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }
}
