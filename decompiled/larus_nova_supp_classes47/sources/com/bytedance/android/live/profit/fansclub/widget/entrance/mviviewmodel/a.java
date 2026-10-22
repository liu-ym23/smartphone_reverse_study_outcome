package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.anya.BaseMVIComposableViewModel;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.scope.o;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends BaseMVIComposableViewModel<eu0.j, eu0.h> implements o {
    public final void onStart() {
    }

    public final void onStop() {
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new eu0.j();
    }

    public final boolean L0(p r2) {
        Intrinsics.checkNotNullParameter((eu0.h) r2, "action");
        return true;
    }

    public a(FollowMVIViewModel r3, SingleEntranceMVIViewModel r4, DoubleEntranceMVIViewModel r5, TipMVIViewModel r6) {
        Intrinsics.checkNotNullParameter(r3, "followVM");
        Intrinsics.checkNotNullParameter(r4, "singleEntranceVM");
        Intrinsics.checkNotNullParameter(r5, "doubleEntranceVM");
        Intrinsics.checkNotNullParameter(r6, "tipVM");
        super(CollectionsKt.listOf(new Object[]{r3, r4, r5, r6}));
        f0();
    }
}
