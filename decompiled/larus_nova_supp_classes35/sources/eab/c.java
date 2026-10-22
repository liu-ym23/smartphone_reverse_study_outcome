package eab;

import kotlin.jvm.internal.Intrinsics;
import v7b.f0;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends s {
    public final String j;
    public final String k;

    @Override // v7b.s
    public final s h() {
        return new c(this.j, this.k);
    }

    @Override // v7b.s
    public final void c(f0 r1) {
        if (r1 == null) goto L5;
        r1.a(this);
        return;
    }

    public c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "key");
        this.j = r2;
        this.k = r3;
    }
}
