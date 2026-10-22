package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g0 {
    public final Function0<Integer> a;
    public final Function0<FeedExtra> b;
    public final Function0<Boolean> c;
    public final Function0<? extends FeedItem> d;
    public final boolean e;
    public final l0 f;
    public final Function0<? extends l0> g;
    public final Function0<String> h;
    public final Function1<? super Function1<? super String, String>, Unit> i;
    public final Function0<String> j;
    public final Function1<? super Function1<? super String, String>, Unit> k;
    public final Function1<? super String, Unit> l;

    public g0(Function0<Integer> r2, Function0<FeedExtra> r3, Function0<Boolean> r4, Function0<? extends FeedItem> r5, boolean r6, l0 r7, Function0<? extends l0> r8, Function0<String> r9, Function1<? super Function1<? super String, String>, Unit> r10, Function0<String> r11, Function1<? super Function1<? super String, String>, Unit> r12, Function1<? super String, Unit> r13) {
        Intrinsics.checkNotNullParameter(r2, "index");
        Intrinsics.checkNotNullParameter(r3, "extraData");
        Intrinsics.checkNotNullParameter(r4, "multiTab");
        Intrinsics.checkNotNullParameter(r5, "feedItem");
        Intrinsics.checkNotNullParameter(r7, "tabItem");
        Intrinsics.checkNotNullParameter(r8, "recommendTabItem");
        Intrinsics.checkNotNullParameter(r9, "showDislikeRoomId");
        Intrinsics.checkNotNullParameter(r10, "setShowDislikeRoomId");
        Intrinsics.checkNotNullParameter(r11, "showUnfollowRoomId");
        Intrinsics.checkNotNullParameter(r12, "setShowUnfollowRoomId");
        Intrinsics.checkNotNullParameter(r13, "deleteRoom");
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
        this.k = r12;
        this.l = r13;
    }
}
