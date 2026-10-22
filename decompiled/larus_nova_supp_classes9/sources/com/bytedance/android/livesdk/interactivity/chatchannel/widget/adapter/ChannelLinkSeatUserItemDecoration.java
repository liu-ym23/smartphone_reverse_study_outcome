package com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/adapter/ChannelLinkSeatUserItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelLinkSeatUserItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;

    public ChannelLinkSeatUserItemDecoration(int r1) {
        this.a = r1;
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        r2.set(0, 0, this.a, 0);
    }
}
