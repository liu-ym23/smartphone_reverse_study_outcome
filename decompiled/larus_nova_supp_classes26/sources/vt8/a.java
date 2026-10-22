package vt8;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements d {
    public a() {
    }

    @Override // vt8.d
    public final int b() {
        return 5;
    }

    @Override // vt8.d
    public final Pair<Integer, Integer> a(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "txt");
        return TuplesKt.to(0, Integer.valueOf(r1.length()));
    }
}
