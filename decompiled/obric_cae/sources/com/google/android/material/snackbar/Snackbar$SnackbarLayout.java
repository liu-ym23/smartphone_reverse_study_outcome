package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class Snackbar$SnackbarLayout extends BaseTransientBottomBar.c {
    public Snackbar$SnackbarLayout(Context r8, AttributeSet r10) {
        super(r8, r10);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.c, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
        int r11 = getChildCount();
        int r12 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L8;
        View r14 = getChildAt(r13);
        if (r14.getLayoutParams().width != (-1)) goto L7;
        r14.measure(View.MeasureSpec.makeMeasureSpec(r12, 1073741824), View.MeasureSpec.makeMeasureSpec(r14.getMeasuredHeight(), 1073741824));
    L7:
        r13 = r13 + 1;
        goto L3
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.c, android.view.View
    public /* bridge */ /* synthetic */ void setBackground(Drawable r8) {
        super.setBackground(r8);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.c, android.view.View
    public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable r8) {
        super.setBackgroundDrawable(r8);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.c, android.view.View
    public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList r8) {
        super.setBackgroundTintList(r8);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.c, android.view.View
    public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode r8) {
        super.setBackgroundTintMode(r8);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.c, android.view.View
    public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams r8) {
        super.setLayoutParams(r8);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.c, android.view.View
    public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener r8) {
        super.setOnClickListener(r8);
    }
}
