package np1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements a {
    public d<? extends a> b;
    public final c c;
    public final int d;

    @Override // np1.a
    public final d<? extends a> a() {
        return this.b;
    }

    @Override // np1.a
    public final c c() {
        return this.c;
    }

    @Override // np1.a
    public int getType() {
        return this.d;
    }

    public e(c r2) {
        Intrinsics.checkNotNullParameter(r2, "panelContext");
        this.c = r2;
        this.d = 2;
    }
}
