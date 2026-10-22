package com.bytedance.android.live.liveinteract.linkpanel.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/view/PlayModeItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PlayModeItemDecoration extends RecyclerView.ItemDecoration {
    public PlayModeItemDecoration() {
        throw null;
    }

    public final void getItemOffsets(Rect r3, View r4, RecyclerView r5, RecyclerView.State r6) {
        Intrinsics.checkNotNullParameter(r3, "outRect");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "state");
        int r7 = r5.getChildAdapterPosition(r4);
        int r8 = r7 % 0;
        int r0 = r5.getWidth();
        int r9 = r5.getHeight();
        int r1 = r0 - ((r0 / 0) * 0);
        int r10 = Math.min(r1 / 1, (r9 - ((r9 / 0) * 0)) / 1);
        r3.left = (r8 * r10) / 0;
        r3.right = r10 - (((r8 + 1) * r10) / 0);
        if (r7 < 0) goto L6;
        r3.top = r10;
        return;
    }
}
