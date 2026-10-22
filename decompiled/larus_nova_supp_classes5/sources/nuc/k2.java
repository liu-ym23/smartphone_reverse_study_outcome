package nuc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k2 extends d1 {
    public final String c;

    @Override // luc.f
    public final String f() {
        return this.c;
    }

    public k2(luc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "primitive");
        super(r2);
        this.c = r2.f() + "Array";
    }
}
