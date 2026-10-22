package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import q5.d;
import q5.f;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SnackbarContentLayout extends LinearLayout implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f3801c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Button f3802g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3803h;

    public SnackbarContentLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public SnackbarContentLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
    }

    private static void c(@NonNull View r10, int r11, int r12) {
        if (ViewCompat.isPaddingRelative(r10) == false) goto L5;
        ViewCompat.setPaddingRelative(r10, ViewCompat.getPaddingStart(r10), r11, ViewCompat.getPaddingEnd(r10), r12);
        return;
    L5:
        r10.setPadding(r10.getPaddingLeft(), r11, r10.getPaddingRight(), r12);
    }

    private boolean d(int r10, int r11, int r12) {
        if (r10 == getOrientation()) goto L5;
        setOrientation(r10);
        boolean r13 = true;
    L7:
        if (this.f3801c.getPaddingTop() == r11) goto L9;
    L12:
        c(this.f3801c, r11, r12);
        return true;
    L9:
        if (this.f3801c.getPaddingBottom() != r12) goto L12;
        return r13;
    L5:
        r13 = false;
        goto L7
    }

    @Override // com.google.android.material.snackbar.a
    public void a(int r10, int r11) {
        this.f3801c.setAlpha(0.0f);
        long r12 = r11;
        long r13 = r10;
        this.f3801c.animate().alpha(1.0f).setDuration(r12).setStartDelay(r13).start();
        if (this.f3802g.getVisibility() != 0) goto L6;
        this.f3802g.setAlpha(0.0f);
        this.f3802g.animate().alpha(1.0f).setDuration(r12).setStartDelay(r13).start();
        return;
    }

    @Override // com.google.android.material.snackbar.a
    public void b(int r10, int r11) {
        this.f3801c.setAlpha(1.0f);
        long r12 = r11;
        long r13 = r10;
        this.f3801c.animate().alpha(0.0f).setDuration(r12).setStartDelay(r13).start();
        if (this.f3802g.getVisibility() != 0) goto L6;
        this.f3802g.setAlpha(1.0f);
        this.f3802g.animate().alpha(0.0f).setDuration(r12).setStartDelay(r13).start();
        return;
    }

    public Button getActionView() {
        return this.f3802g;
    }

    public TextView getMessageView() {
        return this.f3801c;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f3801c = (TextView) findViewById(f.snackbar_text);
        this.f3802g = (Button) findViewById(f.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        boolean r12 = true;
        if (getOrientation() != 1) goto L5;
        return;
    L5:
        int r13 = getResources().getDimensionPixelSize(d.design_snackbar_padding_vertical_2lines);
        int r14 = getResources().getDimensionPixelSize(d.design_snackbar_padding_vertical);
        if (this.f3801c.getLayout().getLineCount() <= 1) goto L8;
        boolean r15 = true;
    L9:
        if (r15 == true) goto L11;
    L17:
        if (r15 == true) goto L21;
        r13 = r14;
    L21:
        if (d(0, r13, r13) == true) goto L24;
    L23:
        r12 = false;
    L24:
        if (r12 == false) goto L27;
        super.onMeasure(r10, r11);
        return;
    L27:
        return;
    L11:
        if (this.f3803h <= 0) goto L17;
        if (this.f3802g.getMeasuredWidth() <= this.f3803h) goto L17;
        if (d(1, r13, r13 - r14) == false) goto L23;
    L8:
        r15 = false;
        goto L9
    }

    public void setMaxInlineActionWidth(int r10) {
        this.f3803h = r10;
    }
}
