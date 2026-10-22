package eab;

import kotlin.jvm.internal.Intrinsics;
import v7b.f0;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f extends s {
    public final String j;
    public String k;
    public final int l;
    public final int m;
    public int n;

    @Override // v7b.s
    public final s h() {
        return new f(this.j, this.k, this.l, this.m, this.n);
    }

    @Override // v7b.s
    public final void c(f0 r1) {
        if (r1 == null) goto L5;
        r1.a(this);
        return;
    }

    public f(String r2, String r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "token");
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = r5;
        this.n = r6;
    }
}
