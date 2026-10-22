package com.larus.bmhome.chat.layout.item;

import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b4 implements pi8.b {
    public final /* synthetic */ SearchListBox a;
    public final /* synthetic */ oi8.k b;
    public final /* synthetic */ oi8.c c;

    @Override // pi8.b
    public final ExpandCardViewMode a() {
        return this.a.D;
    }

    @Override // pi8.b
    public final void b(pi8.k r4) {
        Intrinsics.checkNotNullParameter(r4, "callbackData");
        Function3<? super pi8.k, ? super oi8.k, ? super oi8.c, Unit> r0 = this.a.A;
        if (r0 == null) goto L6;
        r0.invoke(r4, this.b, this.c);
        return;
    }

    public b4(SearchListBox r1, oi8.k r2, oi8.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
