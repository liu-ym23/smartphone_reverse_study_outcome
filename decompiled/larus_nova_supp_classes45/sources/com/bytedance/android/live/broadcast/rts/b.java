package com.bytedance.android.live.broadcast.rts;

import com.relax.relaxframework.f5;
import com.relax.relaxframework.p6;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public final ArrayList<p6> a;
    public final Function1<? super f5, Unit> b;
    public final Function0<Unit> c;

    public b(ArrayList<p6> r2, Function1<? super f5, Unit> r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "modifiers");
        Intrinsics.checkNotNullParameter(r4, "onLoadSuccess");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
