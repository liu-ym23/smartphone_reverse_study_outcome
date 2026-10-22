package com.ss.android.lark.contact.base.common_ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class FloatingBarItemDecoration extends RecyclerView.ItemDecoration {
    public final void onDraw(Canvas r1, RecyclerView r2, RecyclerView.State r3) {
        super.onDraw(r1, r2, r3);
        r2.getPaddingLeft();
        r2.getWidth();
        r2.getPaddingRight();
        if (r2.getChildCount() > 0) goto L5;
        return;
    L5:
        r2.getChildAt(0).getLayoutParams().getViewAdapterPosition();
        throw null;
    }

    public final void onDrawOver(Canvas r1, RecyclerView r2, RecyclerView.State r3) {
        super.onDrawOver(r1, r2, r3);
        int r4 = r2.getLayoutManager().findFirstVisibleItemPosition();
        if (r4 != (-1)) goto L5;
        return;
    L5:
        View r5 = r2.findViewHolderForAdapterPosition(r4).itemView;
        if (r4 >= 0) goto L9;
        return;
    L9:
        throw null;
    }

    public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        super.getItemOffsets(r1, r2, r3, r4);
        r2.getLayoutParams().getViewAdapterPosition();
        throw null;
    }
}
