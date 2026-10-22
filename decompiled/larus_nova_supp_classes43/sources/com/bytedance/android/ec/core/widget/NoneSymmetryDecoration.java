package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.common.utility.UIUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/core/widget/NoneSymmetryDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NoneSymmetryDecoration extends RecyclerView.ItemDecoration {
    public int a;
    public int b;
    public int c;
    public int d;
    public final Context e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;
    public final Function1<View, Boolean> j;

    public final void getItemOffsets(Rect r10, View r11, RecyclerView r12, RecyclerView.State r13) {
        Intrinsics.checkNotNullParameter(r10, "outRect");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "parent");
        Intrinsics.checkNotNullParameter(r13, "state");
        this.a = (int) UIUtils.dip2Px(this.e, this.h);
        this.b = (int) UIUtils.dip2Px(this.e, this.i);
        this.c = (int) UIUtils.dip2Px(this.e, this.f);
        this.d = (int) UIUtils.dip2Px(this.e, this.g);
        StaggeredGridLayoutManager.LayoutParams r14 = r11.getLayoutParams();
        if (r14 == null) goto L14;
        StaggeredGridLayoutManager.LayoutParams r15 = r14;
        if (((Boolean) this.j.invoke(r11)).booleanValue() == false) goto L8;
        return;
    L8:
        if ((r15.getSpanIndex() % 2) != 0) goto L10;
        r10.left = this.c;
        r10.right = this.d;
    L11:
        r10.top = this.a;
        r10.bottom = this.b;
        return;
    L10:
        r10.left = this.d;
        r10.right = this.c;
        goto L11
    L14:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
    }

    public NoneSymmetryDecoration(Context r10, float r11, float r12, float r13, Function1 r14) {
        Intrinsics.checkNotNullParameter(r14, "exceptView");
        this.e = r10;
        this.f = r11;
        this.g = r12;
        this.h = 0.0f;
        this.i = r13;
        this.j = r14;
    }
}
