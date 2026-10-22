package com.lynx.tasm.behavior.ui.list;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class GapItemDecoration extends RecyclerView.ItemDecoration {
    public boolean a;
    public boolean b;
    public int c;
    public int d;
    public int e;

    public GapItemDecoration() {
        this.a = true;
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }

    public final void h(Rect r3, boolean r4, int r5) {
        if (r4 == false) goto L4;
        return;
    L4:
        int r6 = this.e;
        int r0 = this.c;
        int r7 = (r6 * (r0 - 1)) / r0;
        if (r5 != 0) goto L11;
        if (this.a == false) goto L9;
        r3.right = r7;
        return;
    L9:
        r3.bottom = r7;
        return;
    L11:
        if (r5 != (r0 - 1)) goto L17;
        if (this.a == false) goto L15;
        r3.left = r7;
        return;
    L15:
        r3.top = r7;
        return;
    L17:
        if (this.a == false) goto L19;
        int r8 = r7 / 2;
        r3.left = r8;
        r3.right = r8;
        return;
    L19:
        int r9 = r7 / 2;
        r3.top = r9;
        r3.bottom = r9;
    }

    public final void getItemOffsets(Rect r4, View r5, RecyclerView r6, RecyclerView.State r7) {
        super.getItemOffsets(r4, r5, r6, r7);
        RecyclerView.Adapter r8 = r6.getAdapter();
        RecyclerView.ViewHolder r9 = r6.getChildViewHolder(r5);
        if ((r8 instanceof UIListAdapter) == true) goto L5;
        return;
    L5:
        if ((r9 instanceof ListViewHolder) == false) goto L46;
        UIListAdapter r10 = (UIListAdapter) r8;
        ListViewHolder r11 = (ListViewHolder) r9;
        int r12 = r11.getAdapterPosition();
        boolean r0 = false;
        if (r12 != 0) goto L9;
    L14:
        boolean r13 = true;
    L16:
        if (this.a == false) goto L22;
        if (r13 == false) goto L19;
        int r14 = 0;
    L20:
        r4.top = r14;
    L32:
        if (this.c <= 1) goto L47;
        View r15 = ((RecyclerView.ViewHolder) r11).itemView;
        if (r15 == null) goto L48;
        GridLayoutManager.LayoutParams r16 = r15.getLayoutParams();
        if ((r16 instanceof GridLayoutManager.LayoutParams) == false) goto L42;
        GridLayoutManager.LayoutParams r17 = r16;
        if (r17.getSpanSize() != this.c) goto L40;
        r0 = true;
    L40:
        h(r4, r0, r17.getSpanIndex());
        return;
    L42:
        if ((r16 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L50;
        StaggeredGridLayoutManager.LayoutParams r18 = (StaggeredGridLayoutManager.LayoutParams) r16;
        h(r4, r18.isFullSpan(), r18.getSpanIndex());
        return;
    L50:
        return;
    L48:
        return;
    L47:
        return;
    L19:
        r14 = this.d;
        goto L20
    L22:
        if (this.b == false) goto L27;
        if (r13 == false) goto L25;
        int r19 = 0;
    L26:
        r4.right = r19;
        goto L32
    L25:
        r19 = this.d;
        goto L26
    L27:
        if (r13 == false) goto L29;
        int r20 = 0;
    L30:
        r4.left = r20;
        goto L32
    L29:
        r20 = this.d;
        goto L30
    L9:
        if (r12 < this.c) goto L11;
    L13:
        r13 = false;
        goto L16
    L11:
        if (r10.B2(r12) != (-1)) goto L13;
    }
}
