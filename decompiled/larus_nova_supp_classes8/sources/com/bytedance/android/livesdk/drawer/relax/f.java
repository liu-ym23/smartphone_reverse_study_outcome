package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f {
    public Function1<? super Boolean, Unit> a;
    public final Function3<? super n0, ? super Function0<Unit>, ? super Function0<Unit>, Unit> b;
    public final Function0<Unit> c;
    public final Function0<Unit> d;
    public final Function0<Boolean> e;

    public f(Function3 r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r2, "drawerUnFollow");
        this.a = null;
        this.b = r2;
        this.c = r3;
        this.d = null;
        this.e = null;
    }
}
