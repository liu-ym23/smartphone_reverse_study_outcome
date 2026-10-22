package uqb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public final byte[] a;
    public final String b;
    public final String c;

    public c(byte[] r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "templateByteArray");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public /* synthetic */ c(byte[] r3, String r4, String r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        this(r3, r4, r5);
    }
}
