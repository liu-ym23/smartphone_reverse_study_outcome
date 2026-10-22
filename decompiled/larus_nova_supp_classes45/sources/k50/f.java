package k50;

import android.content.Context;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public final d a;
    public int b;
    public final Pair<Integer, Integer> c;
    public long d;
    public final boolean e;
    public final boolean f;
    public final Context g;

    public final Context getContext() {
        return this.g;
    }

    public f(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.g = r3;
        r3.getPackageName();
        this.a = new d();
        this.c = new Pair(770, 771);
        this.d = System.currentTimeMillis();
        this.e = true;
        this.f = true;
    }
}
