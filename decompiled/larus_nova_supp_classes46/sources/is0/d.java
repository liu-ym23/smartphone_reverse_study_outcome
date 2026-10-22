package is0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> extends b<T> {
    public final String b;
    public final int c;
    public final T d;

    @Override // is0.b
    public final int a() {
        return this.c;
    }

    @Override // is0.b
    public final String b() {
        return this.b;
    }

    @Override // is0.b
    public final T c() {
        return this.d;
    }

    public d(String r2, int r3, T r4) {
        Intrinsics.checkNotNullParameter(r2, "_feature");
        Intrinsics.checkNotNullParameter(r4, "_value");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
