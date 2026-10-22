package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterViewItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "leftSpace", "", "topSpace", "rightSpace", "bottomSpace", "space", "<init>", "(IIIII)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "widget-biz-searchfilter_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FilterViewItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public final void getItemOffsets(Rect r4, View r5, RecyclerView r6, RecyclerView.State r7) {
        Intrinsics.checkNotNullParameter(r4, "outRect");
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r7, "state");
        int r0 = r6.getChildAdapterPosition(r5);
        RecyclerView.Adapter r1 = r6.getAdapter();
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.getItemCount();
    L6:
        if (r0 >= r3) goto L15;
        r4.top = this.b;
        r4.bottom = this.d;
        if (r0 != 0) goto L10;
        int r8 = this.a;
    L11:
        r4.left = r8;
        if (r0 != (r3 - 1)) goto L14;
        r2 = this.c;
    L14:
        r4.right = r2;
        return;
    L10:
        r8 = this.e;
        goto L11
    L15:
        super.getItemOffsets(r4, r5, r6, r7);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public FilterViewItemDecoration(int r1, int r2, int r3, int r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
