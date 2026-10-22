package eab;

import kotlin.jvm.internal.Intrinsics;
import v7b.f0;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends s {
    public final String j;

    @Override // v7b.s
    public final s h() {
        return new g(this.j);
    }

    public g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "numberDetail");
        this.j = r2;
    }

    @Override // v7b.s
    public final void c(f0 r1) {
        if (r1 == null) goto L5;
        r1.a(this);
        return;
    }
}
