package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.base.model.feed.FeedItem;
import com.relax.relaxframework.LongPressEvent;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i {
    public final Function0<? extends FeedItem> a;
    public final Function0<? extends LiveDrawerManageStatus> b;
    public final Function0<? extends ArrayList<Long>> c;
    public final Function1<? super Function1<? super ArrayList<Long>, ? extends ArrayList<Long>>, Unit> d;
    public final Function1<? super Long, Unit> e;
    public final Function1<? super LongPressEvent, Unit> f;

    public i(Function0<? extends FeedItem> r2, Function0<? extends LiveDrawerManageStatus> r3, Function0<? extends ArrayList<Long>> r4, Function1<? super Function1<? super ArrayList<Long>, ? extends ArrayList<Long>>, Unit> r5, Function1<? super Long, Unit> r6, Function1<? super LongPressEvent, Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "manageStatus");
        Intrinsics.checkNotNullParameter(r4, "deleteList");
        Intrinsics.checkNotNullParameter(r5, "setDeleteList");
        Intrinsics.checkNotNullParameter(r6, "toDelete");
        Intrinsics.checkNotNullParameter(r7, "handleLongPress");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
