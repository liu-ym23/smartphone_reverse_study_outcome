package com.larus.bmhome.bigimg;

import android.view.View;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j implements j19.e {
    public final /* synthetic */ Function1<Integer, List<Pair<Integer, View>>> a;
    public final /* synthetic */ List<Pair<Integer, View>> b;

    public final View d(int r3) {
        Function1<Integer, List<Pair<Integer, View>>> r0 = this.a;
        if (r0 == null) goto L7;
        return k.a((List) r0.invoke(Integer.valueOf(r3)), r3);
    L7:
        return k.a(this.b, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(Function1<? super Integer, ? extends List<? extends Pair<Integer, ? extends View>>> r1, List<? extends Pair<Integer, ? extends View>> r2) {
        this.a = r1;
        this.b = r2;
    }
}
