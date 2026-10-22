package com.larus.avlink.gallery.view;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/larus/avlink/gallery/view/GridSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", "spacing", "isStaggeredGridLayoutManager", "", "<init>", "(IILjava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final Boolean c;

    public GridSpacingItemDecoration(int r2, Boolean r3) {
        this.a = 3;
        this.b = r2;
        this.c = r3;
    }

    public final void getItemOffsets(Rect r5, View r6, RecyclerView r7, RecyclerView.State r8) {
        Intrinsics.checkNotNullParameter(r5, "outRect");
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "parent");
        Intrinsics.checkNotNullParameter(r8, "state");
        super.getItemOffsets(r5, r6, r7, r8);
        int r9 = r7.getChildAdapterPosition(r6);
        int r0 = 0;
        if (r9 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        Boolean r2 = this.c;
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r3) == false) goto L11;
        ViewGroup.LayoutParams r10 = r6.getLayoutParams();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        StaggeredGridLayoutManager.LayoutParams r11 = (StaggeredGridLayoutManager.LayoutParams) r10;
    L13:
        if (Intrinsics.areEqual(this.c, r3) == true) goto L15;
        int r12 = this.a;
        int r13 = r9 % r12;
        if (r12 <= 2) goto L67;
        if (r13 != 0) goto L56;
        int r14 = this.b;
        r5.left = r14 / 2;
        r5.right = r14 / 2;
        if (r1 == true) goto L54;
        r0 = r14 / 2;
    L54:
        r5.top = r0;
        r5.bottom = r14 / 2;
        return;
    L56:
        if (r13 != (r12 - 1)) goto L62;
        int r15 = this.b;
        r5.left = r15 / 2;
        r5.right = r15 / 2;
        if (r1 == true) goto L61;
        r0 = r15 / 2;
    L61:
        r5.top = r0;
        r5.bottom = r15 / 2;
        return;
    L62:
        int r16 = this.b;
        r5.left = r16 / 2;
        r5.right = r16 / 2;
        if (r1 == true) goto L66;
        r0 = r16 / 2;
    L66:
        r5.top = r0;
        r5.bottom = r16 / 2;
        return;
    L67:
        if (r13 != 0) goto L73;
        r5.left = 0;
        int r17 = this.b;
        r5.right = r17 / 2;
        if (r1 == true) goto L72;
        r0 = r17 / 2;
    L72:
        r5.top = r0;
        r5.bottom = r17 / 2;
        return;
    L73:
        int r18 = this.b;
        r5.left = r18 / 2;
        r5.right = 0;
        if (r1 == true) goto L77;
        r0 = r18 / 2;
    L77:
        r5.top = r0;
        r5.bottom = r18 / 2;
        return;
    L15:
        if (this.a <= 2) goto L36;
        StaggeredGridLayoutManager.LayoutParams r19 = r11;
        if (r19.getSpanIndex() != 0) goto L24;
        int r20 = this.b;
        r5.left = r20 / 2;
        r5.right = r20 / 2;
        if (r1 == true) goto L22;
        r0 = r20 / 2;
    L22:
        r5.top = r0;
        r5.bottom = r20 / 2;
        return;
    L24:
        if (r19.getSpanIndex() != (this.a - 1)) goto L30;
        int r21 = this.b;
        r5.left = r21 / 2;
        r5.right = r21 / 2;
        if (r1 == true) goto L29;
        r0 = r21 / 2;
    L29:
        r5.top = r0;
        r5.bottom = r21 / 2;
        return;
    L30:
        int r22 = this.b;
        r5.left = r22 / 2;
        r5.right = r22 / 2;
        if (r1 == true) goto L34;
        r0 = r22 / 2;
    L34:
        r5.top = r0;
        r5.bottom = r22 / 2;
        return;
    L36:
        if (r11.getSpanIndex() != 0) goto L42;
        int r23 = this.b;
        r5.left = r23 / 2;
        r5.right = r23 / 2;
        if (r1 == true) goto L41;
        r0 = r23 / 2;
    L41:
        r5.top = r0;
        r5.bottom = r23 / 2;
        return;
    L42:
        int r24 = this.b;
        r5.left = r24 / 2;
        r5.right = r24 / 2;
        if (r1 == true) goto L46;
        r0 = r24 / 2;
    L46:
        r5.top = r0;
        r5.bottom = r24 / 2;
        return;
    L11:
        StaggeredGridLayoutManager.LayoutParams r25 = r6.getLayoutParams();
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
        r11 = (GridLayoutManager.LayoutParams) r25;
        goto L13
    L5:
        if (r9 >= this.a) goto L7;
        r1 = true;
        goto L8
    }
}
