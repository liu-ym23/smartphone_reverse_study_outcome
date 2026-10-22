package com.larus.community.impl.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/larus/community/impl/adapter/GridSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", "spacing", "isStaggeredGridLayoutManager", "", "<init>", "(IILjava/lang/Boolean;)V", "Ljava/lang/Boolean;", "updateSpanCount", "", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    public int a;
    public final int b;
    public final Boolean c;

    public GridSpacingItemDecoration(int r1, int r2, Boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void getItemOffsets(Rect r3, View r4, RecyclerView r5, RecyclerView.State r6) {
        Intrinsics.checkNotNullParameter(r3, "outRect");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "state");
        super.getItemOffsets(r3, r4, r5, r6);
        Boolean r7 = this.c;
        Boolean r0 = Boolean.TRUE;
        if (Intrinsics.areEqual(r7, r0) == false) goto L5;
        ViewGroup.LayoutParams r8 = r4.getLayoutParams();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        StaggeredGridLayoutManager.LayoutParams r9 = (StaggeredGridLayoutManager.LayoutParams) r8;
    L7:
        if (Intrinsics.areEqual(this.c, r0) == true) goto L9;
        int r10 = r5.getChildAdapterPosition(r4);
        int r11 = this.a;
        int r12 = r10 % r11;
        if (r11 <= 2) goto L30;
        if (r12 != 0) goto L26;
        int r13 = this.b;
        r3.left = r13 / 2;
        r3.right = r13 / 2;
        r3.top = r13 / 2;
        r3.bottom = r13 / 2;
        return;
    L26:
        if (r12 != (r11 - 1)) goto L28;
        int r14 = this.b;
        r3.left = r14 / 2;
        r3.right = r14 / 2;
        r3.top = r14 / 2;
        r3.bottom = r14 / 2;
        return;
    L28:
        int r15 = this.b;
        r3.left = r15 / 2;
        r3.right = r15 / 2;
        r3.top = r15 / 2;
        r3.bottom = r15 / 2;
        return;
    L30:
        if (r12 != 0) goto L32;
        r3.left = 0;
        int r16 = this.b;
        r3.right = r16 / 2;
        r3.top = r16 / 2;
        r3.bottom = r16 / 2;
        return;
    L32:
        int r17 = this.b;
        r3.left = r17 / 2;
        r3.right = 0;
        r3.top = r17 / 2;
        r3.bottom = r17 / 2;
        return;
    L9:
        if (this.a <= 2) goto L18;
        StaggeredGridLayoutManager.LayoutParams r18 = r9;
        if (r18.getSpanIndex() != 0) goto L14;
        int r20 = this.b;
        r3.left = r20 / 2;
        r3.right = r20 / 2;
        r3.top = r20 / 2;
        r3.bottom = r20 / 2;
        return;
    L14:
        if (r18.getSpanIndex() != (this.a - 1)) goto L16;
        int r21 = this.b;
        r3.left = r21 / 2;
        r3.right = r21 / 2;
        r3.top = r21 / 2;
        r3.bottom = r21 / 2;
        return;
    L16:
        int r22 = this.b;
        r3.left = r22 / 2;
        r3.right = r22 / 2;
        r3.top = r22 / 2;
        r3.bottom = r22 / 2;
        return;
    L18:
        if (r9.getSpanIndex() != 0) goto L20;
        int r23 = this.b;
        r3.left = r23 / 2;
        r3.right = r23 / 2;
        r3.top = r23 / 2;
        r3.bottom = r23 / 2;
        return;
    L20:
        int r24 = this.b;
        r3.left = r24 / 2;
        r3.right = r24 / 2;
        r3.top = r24 / 2;
        r3.bottom = r24 / 2;
        return;
    L5:
        StaggeredGridLayoutManager.LayoutParams r25 = r4.getLayoutParams();
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
        r9 = (GridLayoutManager.LayoutParams) r25;
        goto L7
    }
}
