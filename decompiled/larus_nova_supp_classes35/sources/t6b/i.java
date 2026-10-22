package t6b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class i implements s6b.b<i, j> {
    public final boolean a;

    public i() {
        this(true);
    }

    @Override // s6b.b
    public final s6b.b a() {
        return new j(this);
    }

    public boolean c() {
        return this.a;
    }

    public i(boolean r1) {
        this.a = r1;
    }

    @Override // s6b.b
    public final s6b.b b(s6b.b r2) {
        i r3 = (i) r2;
        Intrinsics.checkNotNullParameter(r3, "patch");
        return new i(r3.c());
    }
}
