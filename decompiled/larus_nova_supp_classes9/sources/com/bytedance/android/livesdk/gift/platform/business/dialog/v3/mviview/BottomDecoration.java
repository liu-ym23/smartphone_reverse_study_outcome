package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/mviview/BottomDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomDecoration extends RecyclerView.ItemDecoration {
    public BottomDecoration() {
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        super.getItemOffsets(r2, r3, r4, r5);
        RecyclerView.LayoutManager r6 = r4.getLayoutManager();
        if ((r6 instanceof GridLayoutManager) == true) goto L5;
        r6 = null;
    L5:
        GridLayoutManager r7 = (GridLayoutManager) r6;
        int r8 = r4.getChildAdapterPosition(r3);
        if (r7 == null) goto L14;
        int r9 = r7.getSpanSizeLookup().getSpanGroupIndex(r8, r7.getSpanCount());
        RecyclerView.Adapter r10 = r4.getAdapter();
        if (r10 == null) goto L15;
        int r11 = (r10.getItemCount() - 1) / 4;
        if (r9 != r11) goto L16;
        if (r11 <= 1) goto L17;
        r2.bottom = com.bytedance.android.live.revenue.common.i.b(58);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }
}
