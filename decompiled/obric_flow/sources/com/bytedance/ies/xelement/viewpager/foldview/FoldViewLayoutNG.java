package com.bytedance.ies.xelement.viewpager.foldview;

import android.content.Context;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import com.bytedance.ies.xelement.viewpager.CustomAppBarLayoutNG;
import com.bytedance.ies.xelement.viewpager.FoldToolbarLayout;
import com.obric.launcher.widget.R$layout;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/foldview/FoldViewLayoutNG;", "Lcom/bytedance/ies/xelement/viewpager/FoldToolbarLayout;", "Lcom/bytedance/ies/xelement/viewpager/CustomAppBarLayoutNG;", "Landroidx/core/view/NestedScrollingChild2;", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FoldViewLayoutNG extends FoldToolbarLayout<CustomAppBarLayoutNG> implements NestedScrollingChild2 {
    public boolean e;
    public final NestedScrollingChildHelper f;

    public FoldViewLayoutNG(Context r5, LynxFoldViewNG r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "mFoldview");
        new LinkedHashMap();
        super(r5);
        this.f = new NestedScrollingChildHelper(this);
        new OverScroller(r5);
    }

    @Override // com.bytedance.ies.xelement.viewpager.FoldToolbarLayout
    public final int a() {
        return R$layout.x_foldtoolbar_layout_ng;
    }

    @Override // com.bytedance.ies.xelement.viewpager.FoldToolbarLayout
    public final void b(boolean r5) {
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r5, float r10, boolean r11) {
        if (this.e == false) goto L7;
        return this.f.dispatchNestedFling(r5, r10, r11);
    L7:
        return super.dispatchNestedFling(r5, r10, r11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r5, float r10) {
        if (this.e == false) goto L7;
        return this.f.dispatchNestedPreFling(r5, r10);
    L7:
        return super.dispatchNestedPreFling(r5, r10);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13, int r14) {
        return this.f.dispatchNestedPreScroll(r10, r11, r12, r13, r14);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14, int r15) {
        return this.f.dispatchNestedScroll(r10, r11, r12, r13, r14, r15);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r5) {
        return this.f.hasNestedScrollingParent(r5);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void setNestedScrollingEnabled(boolean r5) {
        this.f.setNestedScrollingEnabled(r5);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r5, int r10) {
        return this.f.startNestedScroll(r5, r10);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r5) {
        this.f.stopNestedScroll(r5);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13) {
        if (this.e == false) goto L7;
        return this.f.dispatchNestedPreScroll(r10, r11, r12, r13, 0);
    L7:
        return super.dispatchNestedPreScroll(r10, r11, r12, r13);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14) {
        if (this.e == false) goto L7;
        return this.f.dispatchNestedScroll(r10, r11, r12, r13, r14, 0);
    L7:
        return super.dispatchNestedScroll(r10, r11, r12, r13, r14);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        if (this.e == false) goto L7;
        return this.f.hasNestedScrollingParent(0);
    L7:
        return super.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r5) {
        if (this.e == false) goto L7;
        return this.f.startNestedScroll(r5, 0);
    L7:
        return super.startNestedScroll(r5);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        if (this.e == false) goto L6;
        this.f.stopNestedScroll(0);
        return;
    }
}
