package bz0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements yy0.f {
    public final cq2.b a;

    @Override // yy0.f
    public final void b() {
        this.a.a();
    }

    public i(cq2.b r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        this.a = r2;
    }

    @Override // yy0.f
    public final void a(String r2) {
        this.a.setTitle(r2);
    }
}
