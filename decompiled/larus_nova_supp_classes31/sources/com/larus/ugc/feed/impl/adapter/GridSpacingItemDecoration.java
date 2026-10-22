package com.larus.ugc.feed.impl.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/larus/ugc/feed/impl/adapter/GridSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", "spacing", "isStaggeredGridLayoutManager", "", "<init>", "(IILjava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final Boolean c;

    public GridSpacingItemDecoration(int r1, int r2, Boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void getItemOffsets(Rect r4, View r5, RecyclerView r6, RecyclerView.State r7) {
        Intrinsics.checkNotNullParameter(r4, "outRect");
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r7, "state");
        super.getItemOffsets(r4, r5, r6, r7);
        boolean r0 = true;
        if (Intrinsics.areEqual(this.c, Boolean.TRUE) == false) goto L33;
        StaggeredGridLayoutManager.LayoutParams r8 = r5.getLayoutParams();
        if ((r8 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L7;
        StaggeredGridLayoutManager.LayoutParams r9 = r8;
    L9:
        if (this.a <= 2) goto L25;
        if (r9 != null) goto L12;
    L14:
        boolean r10 = false;
    L15:
        if (r10 == false) goto L17;
        int r11 = this.b;
        r4.left = r11 / 2;
        r4.right = r11 / 2;
        r4.top = r11 / 2;
        r4.bottom = r11 / 2;
        return;
    L17:
        if (r9 != null) goto L19;
    L21:
        r0 = false;
    L22:
        if (r0 == false) goto L24;
        int r12 = this.b;
        r4.left = r12 / 2;
        r4.right = r12 / 2;
        r4.top = r12 / 2;
        r4.bottom = r12 / 2;
        return;
    L24:
        int r13 = this.b;
        r4.left = r13 / 2;
        r4.right = r13 / 2;
        r4.top = r13 / 2;
        r4.bottom = r13 / 2;
        return;
    L19:
        if (r9.getSpanIndex() != (this.a - 1)) goto L21;
    L12:
        if (r9.getSpanIndex() != 0) goto L14;
        r10 = true;
        goto L15
    L25:
        if (r9 != null) goto L27;
    L29:
        r0 = false;
    L30:
        if (r0 == false) goto L32;
        int r14 = this.b;
        r4.left = r14 / 2;
        r4.right = r14 / 2;
        r4.top = r14 / 2;
        r4.bottom = r14 / 2;
        return;
    L32:
        int r15 = this.b;
        r4.left = r15 / 2;
        r4.right = r15 / 2;
        r4.top = r15 / 2;
        r4.bottom = r15 / 2;
        return;
    L27:
        if (r9.getSpanIndex() != 0) goto L29;
    L7:
        r9 = null;
        goto L9
    L33:
        int r16 = r6.getChildAdapterPosition(r5);
        int r17 = this.a;
        int r18 = r16 % r17;
        if (r17 <= 2) goto L41;
        if (r18 != 0) goto L38;
        int r19 = this.b;
        r4.left = r19 / 2;
        r4.right = r19 / 2;
        r4.top = r19 / 2;
        r4.bottom = r19 / 2;
        return;
    L38:
        if (r18 != (r17 - 1)) goto L40;
        int r20 = this.b;
        r4.left = r20 / 2;
        r4.right = r20 / 2;
        r4.top = r20 / 2;
        r4.bottom = r20 / 2;
        return;
    L40:
        int r21 = this.b;
        r4.left = r21 / 2;
        r4.right = r21 / 2;
        r4.top = r21 / 2;
        r4.bottom = r21 / 2;
        return;
    L41:
        if (r18 != 0) goto L43;
        r4.left = 0;
        int r22 = this.b;
        r4.right = r22 / 2;
        r4.top = r22 / 2;
        r4.bottom = r22 / 2;
        return;
    L43:
        int r23 = this.b;
        r4.left = r23 / 2;
        r4.right = 0;
        r4.top = r23 / 2;
        r4.bottom = r23 / 2;
    }
}
