package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.SmoothLinearLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/TextMessageLayoutManager;", "Lcom/bytedance/android/livesdk/chatroom/ui/SmoothLinearLayoutManager;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextMessageLayoutManager extends SmoothLinearLayoutManager {
    public TextMessageLayoutManager(Context r1) {
        super(r1);
    }

    public final void onLayoutCompleted(RecyclerView.State r1) {
        super/*androidx.recyclerview.widget.LinearLayoutManager*/.onLayoutCompleted(r1);
    }

    public final void onDetachedFromWindow(RecyclerView r4, RecyclerView.Recycler r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "recycler");
        if (getRecycleChildrenOnDetach() == false) goto L5;
        int r0 = (r4.getRecycledViewPool().getRecycledViewCount(0) + getChildCount()) + 2;
        r4.getRecycledViewPool().setMaxRecycledViews(0, r0);
    L5:
        super/*androidx.recyclerview.widget.LinearLayoutManager*/.onDetachedFromWindow(r4, r5);
    }

    public final void onMeasure(RecyclerView.Recycler r2, RecyclerView.State r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "recycler");
        Intrinsics.checkNotNullParameter(r3, "state");
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onMeasure(r2, r3, r4, r5);
    }
}
