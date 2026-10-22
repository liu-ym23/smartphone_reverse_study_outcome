package com.google.android.material.snackbar;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.cae.R;
import h9.a;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;
import v9.d;

/* JADX INFO: loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f4963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Button f4964b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4965m;

    public SnackbarContentLayout(Context r8, AttributeSet r10) {
        super(r8, r10);
        d.d(r8, R.attr.motionEasingEmphasizedInterpolator, a.f7944b);
    }

    public final boolean a(int r8, int r10, int r11) {
        if (r8 == getOrientation()) goto L5;
        setOrientation(r8);
        boolean r12 = true;
    L7:
        if (this.f4963a.getPaddingTop() == r10) goto L9;
    L12:
        TextView r13 = this.f4963a;
        WeakHashMap<View, h0> r14 = w.f8437a;
        if (w.e.g(r13) == false) goto L15;
        w.e.k(r13, w.e.f(r13), r10, w.e.e(r13), r11);
        return true;
    L15:
        r13.setPadding(r13.getPaddingLeft(), r10, r13.getPaddingRight(), r11);
        return true;
    L9:
        if (this.f4963a.getPaddingBottom() != r11) goto L12;
        return r12;
    L5:
        r12 = false;
        goto L7
    }

    public Button getActionView() {
        return this.f4964b;
    }

    public TextView getMessageView() {
        return this.f4963a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f4963a = (TextView) findViewById(R.id.snackbar_text);
        this.f4964b = (Button) findViewById(R.id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
        boolean r11 = true;
        if (getOrientation() != 1) goto L5;
        return;
    L5:
        int r12 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int r13 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        Layout r14 = this.f4963a.getLayout();
        if (r14 != null) goto L8;
    L10:
        boolean r15 = false;
    L11:
        if (r15 == true) goto L13;
    L19:
        if (r15 == true) goto L23;
        r12 = r13;
    L23:
        if (a(0, r12, r12) == true) goto L26;
    L25:
        r11 = false;
    L26:
        if (r11 == false) goto L29;
        super.onMeasure(r8, r10);
        return;
    L29:
        return;
    L13:
        if (this.f4965m <= 0) goto L19;
        if (this.f4964b.getMeasuredWidth() <= this.f4965m) goto L19;
        if (a(1, r12, r12 - r13) == false) goto L25;
    L8:
        if (r14.getLineCount() <= 1) goto L10;
        r15 = true;
        goto L11
    }

    public void setMaxInlineActionWidth(int r8) {
        this.f4965m = r8;
    }
}
