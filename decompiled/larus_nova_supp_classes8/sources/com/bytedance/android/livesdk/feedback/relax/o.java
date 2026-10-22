package com.bytedance.android.livesdk.feedback.relax;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o {
    public final Function0<String> a;
    public final Function0<Integer> b;
    public final Function0<String> c;
    public final Function0<? extends ArrayList<Map<String, Object>>> d;
    public final boolean e;
    public final Function1<? super Map<String, Object>, Unit> f;
    public final Function0<Unit> g;

    public o(Function0<String> r2, Function0<Integer> r3, Function0<String> r4, Function0<? extends ArrayList<Map<String, Object>>> r5, boolean r6, Function1<? super Map<String, Object>, Unit> r7, Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r2, "feedType");
        Intrinsics.checkNotNullParameter(r3, "iconNeed");
        Intrinsics.checkNotNullParameter(r4, "questionDesc");
        Intrinsics.checkNotNullParameter(r5, "options");
        Intrinsics.checkNotNullParameter(r7, "handleSelected");
        Intrinsics.checkNotNullParameter(r8, "handleCloseClick");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
