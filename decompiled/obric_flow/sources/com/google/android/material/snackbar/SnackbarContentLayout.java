package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.motion.MotionUtils;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    private Button actionView;
    private final TimeInterpolator contentInterpolator;
    private int maxInlineActionWidth;
    private TextView messageView;

    public SnackbarContentLayout(@NonNull Context r5) {
        this(r5, null);
    }

    private static void updateTopBottomPadding(@NonNull View r5, int r10, int r11) {
        if (ViewCompat.isPaddingRelative(r5) == false) goto L5;
        ViewCompat.setPaddingRelative(r5, ViewCompat.getPaddingStart(r5), r10, ViewCompat.getPaddingEnd(r5), r11);
        return;
    L5:
        r5.setPadding(r5.getPaddingLeft(), r10, r5.getPaddingRight(), r11);
    }

    private boolean updateViewsWithinLayout(int r5, int r10, int r11) {
        if (r5 == getOrientation()) goto L5;
        setOrientation(r5);
        boolean r12 = true;
    L7:
        if (this.messageView.getPaddingTop() == r10) goto L9;
    L12:
        updateTopBottomPadding(this.messageView, r10, r11);
        return true;
    L9:
        if (this.messageView.getPaddingBottom() != r11) goto L12;
        return r12;
    L5:
        r12 = false;
        goto L7
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentIn(int r10, int r11) {
        this.messageView.setAlpha(0.0f);
        long r5 = r11;
        long r12 = r10;
        this.messageView.animate().alpha(1.0f).setDuration(r5).setInterpolator(this.contentInterpolator).setStartDelay(r12).start();
        if (this.actionView.getVisibility() != 0) goto L6;
        this.actionView.setAlpha(0.0f);
        this.actionView.animate().alpha(1.0f).setDuration(r5).setInterpolator(this.contentInterpolator).setStartDelay(r12).start();
        return;
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentOut(int r10, int r11) {
        this.messageView.setAlpha(1.0f);
        long r5 = r11;
        long r12 = r10;
        this.messageView.animate().alpha(0.0f).setDuration(r5).setInterpolator(this.contentInterpolator).setStartDelay(r12).start();
        if (this.actionView.getVisibility() != 0) goto L6;
        this.actionView.setAlpha(1.0f);
        this.actionView.animate().alpha(0.0f).setDuration(r5).setInterpolator(this.contentInterpolator).setStartDelay(r12).start();
        return;
    }

    public Button getActionView() {
        return this.actionView;
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (TextView) findViewById(R.id.snackbar_text);
        this.actionView = (Button) findViewById(R.id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if (getOrientation() != 1) goto L5;
        return;
    L5:
        int r5 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int r12 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        Layout r13 = this.messageView.getLayout();
        if (r13 != null) goto L8;
    L10:
        boolean r14 = false;
    L11:
        if (r14 == true) goto L13;
    L19:
        if (r14 == true) goto L23;
        r5 = r12;
    L23:
        if (updateViewsWithinLayout(0, r5, r5) == false) goto L27;
    L24:
        super.onMeasure(r10, r11);
        return;
    L27:
        return;
    L13:
        if (this.maxInlineActionWidth <= 0) goto L19;
        if (this.actionView.getMeasuredWidth() <= this.maxInlineActionWidth) goto L19;
        if (updateViewsWithinLayout(1, r5, r5 - r12) == true) goto L24;
        return;
    L8:
        if (r13.getLineCount() <= 1) goto L10;
        r14 = true;
        goto L11
    }

    public void setMaxInlineActionWidth(int r5) {
        this.maxInlineActionWidth = r5;
    }

    public void updateActionTextColorAlphaIfNeeded(float r5) {
        if (r5 == 1.0f) goto L6;
        int r10 = this.actionView.getCurrentTextColor();
        int r11 = MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface), r10, r5);
        this.actionView.setTextColor(r11);
        return;
    }

    public SnackbarContentLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        super(r5, r10);
        this.contentInterpolator = MotionUtils.resolveThemeInterpolator(r5, R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }
}
