package q22;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public Bitmap a;
    public long b;
    public final String c;
    public final String d;
    public final boolean e;
    public final k f;
    public final String g;
    public final int h;
    public final long i;
    public final String j;
    public final boolean k;

    public a(String r2, boolean r3, k r4, String r5, int r6, long r7, String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "giftUniqueKey");
        Intrinsics.checkNotNullParameter(r5, "giftDescription");
        Intrinsics.checkNotNullParameter(r9, "giftComboCount");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r9;
        this.k = r10;
        this.c = "uniqueKey: " + r2 + ", desc: " + r5 + ", combo: " + r9 + ", big: " + r10;
    }
}
