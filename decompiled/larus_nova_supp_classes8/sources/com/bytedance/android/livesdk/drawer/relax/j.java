package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j {
    public final Function0<? extends LiveDrawerManageStatus> a;
    public final Function1<? super Function1<? super LiveDrawerManageStatus, ? extends LiveDrawerManageStatus>, Unit> b;
    public final Function0<? extends ArrayList<Long>> c;
    public final Function1<? super Function1<? super ArrayList<Long>, ? extends ArrayList<Long>>, Unit> d;
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> e;
    public final Function0<? extends ArrayList<FeedItem>> f;
    public final Function1<? super Function1<? super ArrayList<FeedItem>, ? extends ArrayList<FeedItem>>, Unit> g;
    public final Function0<Boolean> h;
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> i;
    public final Function0<Long> j;
    public final Function1<? super Function1<? super Long, Long>, Unit> k;
    public final Function0<Boolean> l;
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> m;
    public final Function0<? extends LiveDrawerPageName> n;
    public final Function1<? super Function1<? super LiveDrawerPageName, ? extends LiveDrawerPageName>, Unit> o;
    public final Function0<FeedExtra> p;
    public final Function1<? super Function1<? super FeedExtra, FeedExtra>, Unit> q;
    public final Function3<? super Boolean, ? super Boolean, ? super Function0<Unit>, Unit> r;

    public j(Function0<? extends LiveDrawerManageStatus> r17, Function1<? super Function1<? super LiveDrawerManageStatus, ? extends LiveDrawerManageStatus>, Unit> r18, Function0<? extends ArrayList<Long>> r19, Function1<? super Function1<? super ArrayList<Long>, ? extends ArrayList<Long>>, Unit> r20, Function1<? super Function1<? super Boolean, Boolean>, Unit> r21, Function0<? extends ArrayList<FeedItem>> r22, Function1<? super Function1<? super ArrayList<FeedItem>, ? extends ArrayList<FeedItem>>, Unit> r23, Function0<Boolean> r24, Function1<? super Function1<? super Boolean, Boolean>, Unit> r25, Function0<Long> r26, Function1<? super Function1<? super Long, Long>, Unit> r27, Function0<Boolean> r28, Function1<? super Function1<? super Boolean, Boolean>, Unit> r29, Function0<? extends LiveDrawerPageName> r30, Function1<? super Function1<? super LiveDrawerPageName, ? extends LiveDrawerPageName>, Unit> r31, Function0<FeedExtra> r32, Function1<? super Function1<? super FeedExtra, FeedExtra>, Unit> r33, Function3<? super Boolean, ? super Boolean, ? super Function0<Unit>, Unit> r34) {
        Intrinsics.checkNotNullParameter(r17, "manageStatus");
        Intrinsics.checkNotNullParameter(r18, "setManageStatus");
        Intrinsics.checkNotNullParameter(r19, "deleteList");
        Intrinsics.checkNotNullParameter(r20, "setDeleteList");
        Intrinsics.checkNotNullParameter(r21, "setAllSelected");
        Intrinsics.checkNotNullParameter(r22, "dataList");
        Intrinsics.checkNotNullParameter(r23, "setDataList");
        Intrinsics.checkNotNullParameter(r24, "hasMore");
        Intrinsics.checkNotNullParameter(r25, "setHasMore");
        Intrinsics.checkNotNullParameter(r26, "maxTime");
        Intrinsics.checkNotNullParameter(r27, "setMaxTime");
        Intrinsics.checkNotNullParameter(r28, "firstLoading");
        Intrinsics.checkNotNullParameter(r29, "setFirstLoading");
        Intrinsics.checkNotNullParameter(r30, "pageName");
        Intrinsics.checkNotNullParameter(r31, "setPageName");
        Intrinsics.checkNotNullParameter(r32, "extra");
        Intrinsics.checkNotNullParameter(r33, "setExtra");
        Intrinsics.checkNotNullParameter(r34, "fetchFeed");
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
        this.q = r33;
        this.r = r34;
    }
}
