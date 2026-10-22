package com.bytedance.android.livesdk.drawer.relax;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p0 {
    public final Function0<String> a;
    public final Function1<? super Function1<? super String, String>, Unit> b;
    public final Function5<? super Boolean, ? super String, ? super String, ? super Boolean, ? super Integer, Unit> c;
    public final Function0<Unit> d;
    public final Function0<Boolean> e;
    public final Function1<? super Function1<? super LiveSearchResultPageStatus, ? extends LiveSearchResultPageStatus>, Unit> f;
    public final Function0<String> g;
    public final Function1<? super Function1<? super String, String>, Unit> h;
    public final Function0<Boolean> i;
    public final Function0<? extends ArrayList<String>> j;
    public final Function1<? super Function1<? super ArrayList<String>, ? extends ArrayList<String>>, Unit> k;
    public final Function0<Boolean> l;
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> m;
    public final Function0<Boolean> n;
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> o;
    public final Function0<? extends Map<String, Object>> p;

    public p0(Function0<String> r17, Function1<? super Function1<? super String, String>, Unit> r18, Function5<? super Boolean, ? super String, ? super String, ? super Boolean, ? super Integer, Unit> r19, Function0<Unit> r20, Function0<Boolean> r21, Function1<? super Function1<? super LiveSearchResultPageStatus, ? extends LiveSearchResultPageStatus>, Unit> r22, Function0<String> r23, Function1<? super Function1<? super String, String>, Unit> r24, Function0<Boolean> r25, Function0<? extends ArrayList<String>> r26, Function1<? super Function1<? super ArrayList<String>, ? extends ArrayList<String>>, Unit> r27, Function0<Boolean> r28, Function1<? super Function1<? super Boolean, Boolean>, Unit> r29, Function0<Boolean> r30, Function1<? super Function1<? super Boolean, Boolean>, Unit> r31, Function0<? extends Map<String, Object>> r32) {
        Intrinsics.checkNotNullParameter(r17, "searchText");
        Intrinsics.checkNotNullParameter(r18, "setSearchText");
        Intrinsics.checkNotNullParameter(r19, "searchWord");
        Intrinsics.checkNotNullParameter(r20, "loadMore");
        Intrinsics.checkNotNullParameter(r21, "hasMore");
        Intrinsics.checkNotNullParameter(r22, "setResultPageStatus");
        Intrinsics.checkNotNullParameter(r23, "searchId");
        Intrinsics.checkNotNullParameter(r24, "setSearchId");
        Intrinsics.checkNotNullParameter(r25, "fromRecommend");
        Intrinsics.checkNotNullParameter(r26, "searchHistoryData");
        Intrinsics.checkNotNullParameter(r27, "setSearchHistoryData");
        Intrinsics.checkNotNullParameter(r28, "showAllHistory");
        Intrinsics.checkNotNullParameter(r29, "setShowAllHistory");
        Intrinsics.checkNotNullParameter(r30, "isFocus");
        Intrinsics.checkNotNullParameter(r31, "setIsFocus");
        Intrinsics.checkNotNullParameter(r32, "getLogPassback");
        this.a = r17;
        this.b = r18;
        this.c = r19;
        this.d = r20;
        this.e = r21;
        this.f = r22;
        this.g = r23;
        this.h = r24;
        this.i = r25;
        this.j = r26;
        this.k = r27;
        this.l = r28;
        this.m = r29;
        this.n = r30;
        this.o = r31;
        this.p = r32;
    }
}
