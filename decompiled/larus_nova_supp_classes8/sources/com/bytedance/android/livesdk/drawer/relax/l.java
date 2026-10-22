package com.bytedance.android.livesdk.drawer.relax;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l {
    public final Function0<Boolean> a;
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> b;
    public final Function0<? extends LiveDrawerPageName> c;
    public final Function1<? super Function1<? super LiveDrawerPageName, ? extends LiveDrawerPageName>, Unit> d;
    public final Function0<? extends ArrayList<Long>> e;
    public final Function1<? super Function1<? super ArrayList<Long>, ? extends ArrayList<Long>>, Unit> f;
    public final Function0<? extends LiveDrawerManageStatus> g;
    public final Function1<? super Function1<? super LiveDrawerManageStatus, ? extends LiveDrawerManageStatus>, Unit> h;
    public final Function0<Boolean> i;
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> j;

    public l(Function0<Boolean> r2, Function1<? super Function1<? super Boolean, Boolean>, Unit> r3, Function0<? extends LiveDrawerPageName> r4, Function1<? super Function1<? super LiveDrawerPageName, ? extends LiveDrawerPageName>, Unit> r5, Function0<? extends ArrayList<Long>> r6, Function1<? super Function1<? super ArrayList<Long>, ? extends ArrayList<Long>>, Unit> r7, Function0<? extends LiveDrawerManageStatus> r8, Function1<? super Function1<? super LiveDrawerManageStatus, ? extends LiveDrawerManageStatus>, Unit> r9, Function0<Boolean> r10, Function1<? super Function1<? super Boolean, Boolean>, Unit> r11) {
        Intrinsics.checkNotNullParameter(r6, "deleteList");
        Intrinsics.checkNotNullParameter(r7, "setDeleteList");
        Intrinsics.checkNotNullParameter(r8, "manageStatus");
        Intrinsics.checkNotNullParameter(r9, "setManageStatus");
        Intrinsics.checkNotNullParameter(r10, "allSelected");
        Intrinsics.checkNotNullParameter(r11, "setAllSelected");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }
}
