package com.larus.bmhome.miniartifact.listpage.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/adapter/MiniArtifactGridSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", "spacing", "<init>", "(II)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactGridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;

    public MiniArtifactGridSpacingItemDecoration(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        super.getItemOffsets(r2, r3, r4, r5);
        StaggeredGridLayoutManager.LayoutParams r6 = r3.getLayoutParams();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        StaggeredGridLayoutManager.LayoutParams r7 = r6;
        if (this.a <= 2) goto L15;
        if (r7.isFullSpan() == false) goto L8;
        r2.left = 0;
        r2.right = 0;
        r2.top = 0;
        r2.bottom = 0;
        return;
    L8:
        if (r7.getSpanIndex() != 0) goto L11;
        int r8 = this.b;
        r2.left = r8 / 2;
        r2.right = r8 / 2;
        r2.top = r8 / 2;
        r2.bottom = r8 / 2;
        return;
    L11:
        if (r7.getSpanIndex() != (this.a - 1)) goto L13;
        int r9 = this.b;
        r2.left = r9 / 2;
        r2.right = r9 / 2;
        r2.top = r9 / 2;
        r2.bottom = r9 / 2;
        return;
    L13:
        int r10 = this.b;
        r2.left = r10 / 2;
        r2.right = r10 / 2;
        r2.top = r10 / 2;
        r2.bottom = r10 / 2;
        return;
    L15:
        if (r7.isFullSpan() == false) goto L18;
        r2.left = 0;
        r2.right = 0;
        r2.top = 0;
        r2.bottom = 0;
        return;
    L18:
        if (r7.getSpanIndex() != 0) goto L20;
        r2.left = 0;
        int r11 = this.b;
        r2.right = r11 / 2;
        r2.top = r11 / 2;
        r2.bottom = r11 / 2;
        return;
    L20:
        int r12 = this.b;
        r2.left = r12 / 2;
        r2.right = 0;
        r2.top = r12 / 2;
        r2.bottom = r12 / 2;
    }
}
