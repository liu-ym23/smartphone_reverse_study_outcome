package com.bytedance.android.livesdk.drawer.relax;

import android.content.Context;
import com.bytedance.salamander.anniex.r3;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public final Function0<? extends ArrayList<l0>> a;
    public final Function0<d> b;
    public final j0 c;
    public final Function0<? extends r3> d;
    public final Context e;
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> f;
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> g;
    public final f h;
    public final Function0<? extends Map<String, Object>> i;

    public final Context getContext() {
        return this.e;
    }

    public e(Function0<? extends ArrayList<l0>> r2, Function0<d> r3, j0 r4, Function0<? extends r3> r5, Context r6, Function1<? super Function1<? super Boolean, Boolean>, Unit> r7, Function1<? super Function1<? super Boolean, Boolean>, Unit> r8, f r9, Function0<? extends Map<String, Object>> r10) {
        Intrinsics.checkNotNullParameter(r2, "tabList");
        Intrinsics.checkNotNullParameter(r3, "businessContext");
        Intrinsics.checkNotNullParameter(r4, "settings");
        Intrinsics.checkNotNullParameter(r5, "userInfo");
        Intrinsics.checkNotNullParameter(r7, "setShowHistoryPage");
        Intrinsics.checkNotNullParameter(r8, "setShowSearchPage");
        Intrinsics.checkNotNullParameter(r10, "trackContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
