package t6b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j extends i {
    public final boolean b;

    @Override // t6b.i
    public final boolean c() {
        return this.b;
    }

    public j(i r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(true);
        this.b = r2.c();
    }
}
