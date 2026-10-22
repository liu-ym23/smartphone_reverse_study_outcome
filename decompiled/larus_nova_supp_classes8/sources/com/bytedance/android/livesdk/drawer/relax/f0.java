package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f0 {
    public final Long a;
    public final l0 b;
    public final Function0<? extends l0> c;
    public final Function0<Boolean> d;
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> e;
    public final Function0<Integer> f;

    public f0(Long r2, l0 r3, Function0<? extends l0> r4, Function0<Boolean> r5, Function1<? super Function1<? super Boolean, Boolean>, Unit> r6, Function0<Integer> r7) {
        Intrinsics.checkNotNullParameter(r3, "tabItem");
        Intrinsics.checkNotNullParameter(r4, "recommendTab");
        Intrinsics.checkNotNullParameter(r5, "multiTab");
        Intrinsics.checkNotNullParameter(r6, "setShowOpenLiveComp");
        Intrinsics.checkNotNullParameter(r7, "tabIndex");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
