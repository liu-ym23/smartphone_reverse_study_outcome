package com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class LinearDividerDecoration extends RecyclerView.ItemDecoration {
    public final Drawable a;
    public final int b;
    public final int c;

    public LinearDividerDecoration(Resources r3, int r4) {
        this.a = new ColorDrawable(r3.getColor(2131106784));
        this.b = r4;
        this.c = 0;
    }

    public final void onDraw(Canvas r9, RecyclerView r10, RecyclerView.State r11) {
        int r0 = 0;
        if (this.c != 0) goto L10;
        int r13 = r10.getPaddingTop();
        int r1 = r10.getHeight() - r10.getPaddingBottom();
        int r2 = r10.getChildCount();
    L5:
        if (r0 >= r2) goto L16;
        View r3 = r10.getChildAt(r0);
        RecyclerView.LayoutParams r4 = r3.getLayoutParams();
        int r5 = r3.getRight() + ((ViewGroup.MarginLayoutParams) r4).rightMargin;
        int r6 = this.b + r5;
        this.a.setBounds(r5, r13, r6, r1);
        this.a.draw(r9);
        if (r0 != 0) goto L9;
        int r7 = r3.getLeft() - ((ViewGroup.MarginLayoutParams) r4).leftMargin;
        int r8 = r7 - this.b;
        this.a.setBounds(r8, r13, r7, r1);
        this.a.draw(r9);
    L9:
        r0 = r0 + 1;
        goto L5
    L16:
        return;
    L10:
        int r14 = r10.getPaddingLeft();
        int r15 = r10.getWidth() - r10.getPaddingRight();
        int r16 = r10.getChildCount();
    L11:
        if (r0 >= r16) goto L23;
        View r17 = r10.getChildAt(r0);
        RecyclerView.LayoutParams r18 = r17.getLayoutParams();
        int r19 = r17.getBottom() + ((ViewGroup.MarginLayoutParams) r18).bottomMargin;
        int r20 = this.b + r19;
        this.a.setBounds(r14, r19, r15, r20);
        this.a.draw(r9);
        if (r0 != 0) goto L15;
        int r21 = r17.getTop() - ((ViewGroup.MarginLayoutParams) r18).topMargin;
        int r23 = r21 - this.b;
        this.a.setBounds(r14, r23, r15, r21);
        this.a.draw(r9);
    L15:
        r0 = r0 + 1;
        goto L11
    }

    public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        if (this.c != 0) goto L9;
        if (r3.getChildAdapterPosition(r2) != 0) goto L7;
        r1.left = this.b;
    L7:
        r1.right = this.b;
        return;
    L9:
        if (r3.getChildAdapterPosition(r2) != 0) goto L11;
        r1.top = this.b;
    L11:
        r1.bottom = this.b;
    }
}
