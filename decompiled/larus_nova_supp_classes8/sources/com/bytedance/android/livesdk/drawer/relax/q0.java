package com.bytedance.android.livesdk.drawer.relax;

import com.relax.relaxframework.y5;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q0 {
    public final Function0<Boolean> a;
    public final Function0<Boolean> b;
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> c;
    public final Function1<? super Function1<? super y5, ? extends y5>, Unit> d;
    public final Function0<? extends y5> e;

    public q0(Function0<Boolean> r2, Function0<Boolean> r3, Function1<? super Function1<? super Boolean, Boolean>, Unit> r4, Function1<? super Function1<? super y5, ? extends y5>, Unit> r5, Function0<? extends y5> r6) {
        Intrinsics.checkNotNullParameter(r2, "showResult");
        Intrinsics.checkNotNullParameter(r3, "showSug");
        Intrinsics.checkNotNullParameter(r4, "setShowSug");
        Intrinsics.checkNotNullParameter(r5, "setInputRef");
        Intrinsics.checkNotNullParameter(r6, "inputRef");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
