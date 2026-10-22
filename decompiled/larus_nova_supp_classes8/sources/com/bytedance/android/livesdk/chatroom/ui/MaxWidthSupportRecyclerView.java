package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class MaxWidthSupportRecyclerView extends RecyclerView {
    public float a;
    public boolean b;

    public interface a {
    }

    public void setDrawerSlideOperation(a r1) {
    }

    public MaxWidthSupportRecyclerView(Context r1) {
        super(r1);
        this.a = 3.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        int r0 = r4.getAction();
        if (r0 == 0) goto L7;
        if (r0 != 1) goto L7;
    L7:
        if ((getParent() instanceof ViewGroup) == false) goto L10;
        getParent().requestDisallowInterceptTouchEvent(true);
    L10:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r4);
    }

    public void setEnable(boolean r1) {
        this.b = r1;
    }

    public void setMaxItem(float r1) {
        this.a = r1;
    }

    public MaxWidthSupportRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = 3.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r6, int r7) {
        super.onMeasure(r6, r7);
        float r8 = this.a;
        int r0 = (int) r8;
        float r9 = r8 % r0;
        if (this.b == true) goto L5;
        return;
    L5:
        if (getAdapter() != null) goto L7;
        return;
    L7:
        if (getAdapter().getItemCount() >= r0) goto L9;
        return;
    L9:
        if (getChildCount() < r0) goto L34;
        int r1 = 0;
        int r2 = 0;
    L11:
        if (r1 >= r0) goto L19;
        View r3 = getChildAt(r1);
        if (r3 == null) goto L17;
        r2 = r2 + r3.getMeasuredWidth();
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        r2 = r2 + (r5.leftMargin + r5.rightMargin);
    L17:
        r1 = r1 + 1;
        goto L11
    L19:
        if (getAdapter().getItemCount() > r0) goto L21;
    L25:
        setMeasuredDimension(r2, View.MeasureSpec.getSize(r7));
        return;
    L21:
        if (r9 <= 0.0f) goto L25;
        View r10 = getChildAt(r0);
        r2 = r2 + (r10.getMeasuredWidth() / 2);
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        r2 = r2 + ((r12.leftMargin + r12.rightMargin) / 2);
        goto L25
    }

    public MaxWidthSupportRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = 3.0f;
    }
}
