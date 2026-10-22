package pnb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements e {
    public final tnb.a a;

    public f(tnb.a r2) {
        Intrinsics.checkNotNullParameter(r2, "jsRuntime");
        this.a = r2;
    }

    @Override // pnb.e
    public final void a(String r3) {
        if (r3 == null) goto L5;
        this.a.a("requestFromNative", r3);
        return;
    }

    @Override // pnb.e
    public final void b(String r3) {
        if (r3 == null) goto L5;
        this.a.a("requestFromDocs", r3);
        return;
    }
}
