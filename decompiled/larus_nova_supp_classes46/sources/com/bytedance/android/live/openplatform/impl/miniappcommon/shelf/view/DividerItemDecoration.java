package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/DividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DividerItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public Drawable b;
    public int c;
    public final Rect d;

    public DividerItemDecoration(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this.a = 1;
        int[] r0 = {R.attr.listDivider};
        this.d = new Rect();
        TypedArray r5 = r4.obtainStyledAttributes(r0);
        this.b = r5.getDrawable(0);
        r5.recycle();
        this.c = 0;
    }

    public final void onDraw(Canvas r7, RecyclerView r8, RecyclerView.State r9) {
        Intrinsics.checkNotNullParameter(r7, "c");
        Intrinsics.checkNotNullParameter(r8, "parent");
        Intrinsics.checkNotNullParameter(r9, "state");
        if (r8.getLayoutManager() != null) goto L5;
        return;
    L5:
        if (this.b == null) goto L30;
        int r1 = 0;
        if (this.c != this.a) goto L17;
        r7.save();
        if (r8.getClipToPadding() == false) goto L12;
        int r10 = r8.getPaddingLeft();
        int r0 = r8.getWidth() - r8.getPaddingRight();
        r7.clipRect(r10, r8.getPaddingTop(), r0, r8.getHeight() - r8.getPaddingBottom());
    L13:
        int r2 = r8.getChildCount() - 1;
    L14:
        if (r1 >= r2) goto L16;
        View r3 = r8.getChildAt(r1);
        r8.getDecoratedBoundsWithMargins(r3, this.d);
        int r4 = this.d.bottom + Math.round(r3.getTranslationY());
        Drawable r5 = this.b;
        Intrinsics.checkNotNull(r5);
        int r6 = r4 - r5.getIntrinsicHeight();
        Drawable r11 = this.b;
        Intrinsics.checkNotNull(r11);
        r11.setBounds(r10, r6, r0, r4);
        Drawable r12 = this.b;
        Intrinsics.checkNotNull(r12);
        r12.draw(r7);
        r1 = r1 + 1;
        goto L14
    L16:
        r7.restore();
        return;
    L12:
        r0 = r8.getWidth();
        r10 = 0;
        goto L13
    L17:
        r7.save();
        if (r8.getClipToPadding() == false) goto L20;
        int r13 = r8.getPaddingTop();
        int r14 = r8.getHeight() - r8.getPaddingBottom();
        r7.clipRect(r8.getPaddingLeft(), r13, r8.getWidth() - r8.getPaddingRight(), r14);
    L21:
        int r15 = r8.getChildCount() - 1;
    L22:
        if (r1 >= r15) goto L24;
        View r16 = r8.getChildAt(r1);
        RecyclerView.LayoutManager r17 = r8.getLayoutManager();
        Intrinsics.checkNotNull(r17);
        r17.getDecoratedBoundsWithMargins(r16, this.d);
        int r18 = this.d.right + Math.round(r16.getTranslationX());
        Drawable r19 = this.b;
        Intrinsics.checkNotNull(r19);
        int r20 = r18 - r19.getIntrinsicWidth();
        Drawable r21 = this.b;
        Intrinsics.checkNotNull(r21);
        r21.setBounds(r20, r13, r18, r14);
        Drawable r22 = this.b;
        Intrinsics.checkNotNull(r22);
        r22.draw(r7);
        r1 = r1 + 1;
        goto L22
    L24:
        r7.restore();
        return;
    L20:
        r14 = r8.getHeight();
        r13 = 0;
        goto L21
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        Drawable r6 = this.b;
        if (r6 != null) goto L7;
        r2.set(0, 0, 0, 0);
        return;
    L7:
        if (this.c != this.a) goto L9;
        Intrinsics.checkNotNull(r6);
        r2.set(0, 0, 0, r6.getIntrinsicHeight());
        return;
    L9:
        Intrinsics.checkNotNull(r6);
        r2.set(0, 0, r6.getIntrinsicWidth(), 0);
    }
}
