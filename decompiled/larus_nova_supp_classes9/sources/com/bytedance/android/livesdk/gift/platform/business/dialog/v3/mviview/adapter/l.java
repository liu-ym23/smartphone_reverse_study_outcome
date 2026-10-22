package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;

    public l(int r1) {
        this.a = r1;
        this.b = 0;
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
        if (r7 == null) goto L18;
        int r9 = r7.getSpanSizeLookup().getSpanGroupIndex(r8, r7.getSpanCount());
        if (r9 != 0) goto L10;
        r2.top = this.a;
    L11:
        RecyclerView.Adapter r10 = r4.getAdapter();
        if (r10 == null) goto L19;
        int r11 = (r10.getItemCount() - 1) / 4;
        if (r9 != r11) goto L20;
        if (r11 <= 1) goto L21;
        r2.bottom = com.bytedance.android.live.revenue.common.i.b(58);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L10:
        r2.top = -this.b;
        goto L11
    }
}
