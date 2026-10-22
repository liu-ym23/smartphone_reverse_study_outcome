package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Snackbar$SnackbarLayout extends BaseTransientBottomBar.o {
    public Snackbar$SnackbarLayout(Context r10) {
        super(r10);
    }

    public Snackbar$SnackbarLayout(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.o, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r12 = getChildCount();
        int r13 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L8;
        View r15 = getChildAt(r14);
        if (r15.getLayoutParams().width != (-1)) goto L7;
        r15.measure(View.MeasureSpec.makeMeasureSpec(r13, 1073741824), View.MeasureSpec.makeMeasureSpec(r15.getMeasuredHeight(), 1073741824));
    L7:
        r14 = r14 + 1;
        goto L3
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.o, android.view.View
    public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable r10) {
        super.setBackground(r10);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.o, android.view.View
    public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable r10) {
        super.setBackgroundDrawable(r10);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.o, android.view.View
    public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList r10) {
        super.setBackgroundTintList(r10);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.o, android.view.View
    public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        super.setBackgroundTintMode(r10);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.o, android.view.View
    public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams r10) {
        super.setLayoutParams(r10);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.o, android.view.View
    public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener r10) {
        super.setOnClickListener(r10);
    }
}
