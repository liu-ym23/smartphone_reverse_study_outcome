package t98;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public final h a;
    public final d b;
    public final c c;
    public final b d;

    public f(i r5) {
        d r0 = new d(0);
        c r1 = new c();
        b r2 = new e();
        Intrinsics.checkNotNullParameter(r5, "snapshotSource");
        Intrinsics.checkNotNullParameter(r0, "config");
        Intrinsics.checkNotNullParameter(r1, "policy");
        Intrinsics.checkNotNullParameter(r2, "clock");
        this.a = r5;
        this.b = r0;
        this.c = r1;
        this.d = r2;
    }
}
