package com.larus.bmhome.bigimg;

import android.view.View;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h implements j19.e {
    public final /* synthetic */ Function1<Integer, Unit> a;
    public final /* synthetic */ List<Pair<Integer, View>> b;
    public final /* synthetic */ Function1<Integer, List<Pair<Integer, View>>> c;

    public final View d(int r3) {
        Function1<Integer, Unit> r0 = this.a;
        if (r0 == null) goto L8;
        if (r0 == null) goto L7;
        r0.invoke(Integer.valueOf(r3));
    L7:
        return k.a(this.b, r3);
    L8:
        Function1<Integer, List<Pair<Integer, View>>> r1 = this.c;
        if (r1 == null) goto L13;
        return k.a((List) r1.invoke(Integer.valueOf(r3)), r3);
    L13:
        return k.a(this.b, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function1<? super Integer, Unit> r1, List<? extends Pair<Integer, ? extends View>> r2, Function1<? super Integer, ? extends List<? extends Pair<Integer, ? extends View>>> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
