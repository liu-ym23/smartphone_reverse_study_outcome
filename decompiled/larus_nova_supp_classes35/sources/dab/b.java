package dab;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements a {
    public final String a;
    public final int b;
    public final boolean c;
    public final int d;
    public final boolean e;
    public final String f;

    public b(String r2, int r3, boolean r4, int r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "iconKey");
        Intrinsics.checkNotNullParameter(r7, "faviconUrl");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
