package com.bytedance.android.live.liveinteract.plantform.commonwindow.utils;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.videotalk.ui.BaseEqualGridItemDecoration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/utils/MultiLinkCommonItemDecoration;", "Lcom/bytedance/android/live/liveinteract/videotalk/ui/BaseEqualGridItemDecoration;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkCommonItemDecoration extends BaseEqualGridItemDecoration {
    public final int b;

    public MultiLinkCommonItemDecoration(m r2, int r3, Drawable r4) {
        Intrinsics.checkNotNullParameter(r2, "layoutConfig");
        super(r4);
        this.b = r3;
    }

    public final void onDraw(Canvas r9, RecyclerView r10, RecyclerView.State r11) {
        Intrinsics.checkNotNullParameter(r9, "c");
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "state");
        Drawable r12 = this.a;
        if (r12 == null) goto L19;
        int r0 = r10.getChildCount();
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L12;
        View r4 = r10.getChildAt(r2);
        RecyclerView.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L11;
        RecyclerView.LayoutParams r6 = r5;
        int r3 = r4.getLeft() - ((ViewGroup.MarginLayoutParams) r6).leftMargin;
        int r7 = (r4.getRight() + ((ViewGroup.MarginLayoutParams) r6).rightMargin) + this.b;
        r12.setBounds(r3, r4.getBottom(), r7, (r4.getBottom() + ((ViewGroup.MarginLayoutParams) r6).bottomMargin) + this.b);
        r12.draw(r9);
        r2 = r2 + 1;
        goto L6
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L12:
        int r8 = r10.getChildCount();
    L13:
        if (r1 >= r8) goto L24;
        View r13 = r10.getChildAt(r1);
        RecyclerView.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L18;
        RecyclerView.LayoutParams r15 = r14;
        int r16 = r13.getTop() - ((ViewGroup.MarginLayoutParams) r15).topMargin;
        int r17 = r13.getBottom() + ((ViewGroup.MarginLayoutParams) r15).bottomMargin;
        r12.setBounds(r13.getRight(), r16, (r13.getRight() + ((ViewGroup.MarginLayoutParams) r15).rightMargin) + this.b, r17);
        r12.draw(r9);
        r1 = r1 + 1;
        goto L13
    L18:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L24:
        return;
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        r2.left = 0;
        r2.top = 0;
        r2.right = 0;
        r2.bottom = 0;
    }
}
