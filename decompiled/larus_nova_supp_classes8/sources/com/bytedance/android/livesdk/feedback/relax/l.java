package com.bytedance.android.livesdk.feedback.relax;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l {
    public final Function0<String> a;
    public final Function0<Integer> b;
    public final Function0<String> c;
    public final Function0<? extends ArrayList<Map<String, Object>>> d;
    public final Function1<? super Map<String, Object>, Unit> e;
    public final Function0<Unit> f;

    public l(Function0<String> r1, Function0<Integer> r2, Function0<String> r3, Function0<? extends ArrayList<Map<String, Object>>> r4, boolean r5, Function1<? super Map<String, Object>, Unit> r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r1, "feedType");
        Intrinsics.checkNotNullParameter(r2, "iconNeed");
        Intrinsics.checkNotNullParameter(r3, "questionDesc");
        Intrinsics.checkNotNullParameter(r4, "options");
        Intrinsics.checkNotNullParameter(r6, "handleSelected");
        Intrinsics.checkNotNullParameter(r7, "handleCloseClick");
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r7;
    }
}
