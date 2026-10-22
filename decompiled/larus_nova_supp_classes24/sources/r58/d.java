package r58;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public final int a;
    public final byte[] b;
    public final Long c;

    public d(int r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        this(r2, r3, null);
    }

    public d(int r2, byte[] r3, Long r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
