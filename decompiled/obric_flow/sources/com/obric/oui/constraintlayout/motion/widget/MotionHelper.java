package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.constraintlayout.widget.ConstraintHelper;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class MotionHelper extends ConstraintHelper implements z {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f12659j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f12660k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f12661l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View[] f12662m;

    public MotionHelper(Context r5) {
        super(r5);
        this.f12659j = false;
        this.f12660k = false;
    }

    public void a(int r5) {
    }

    public float getProgress() {
        return this.f12661l;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet r5) {
        super.k(r5);
        if (r5 == null) goto L19;
        TypedArray r10 = getContext().obtainStyledAttributes(r5, R$styleable.MotionHelper);
        int r11 = r10.getIndexCount();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L13;
        int r13 = r10.getIndex(r12);
        if (r13 != R$styleable.MotionHelper_onShow) goto L10;
        this.f12659j = r10.getBoolean(r13, this.f12659j);
    L12:
        r12 = r12 + 1;
        goto L5
    L10:
        if (r13 != R$styleable.MotionHelper_onHide) goto L12;
        this.f12660k = r10.getBoolean(r13, this.f12660k);
        goto L12
    L13:
        r10.recycle();
        return;
    }

    public void r(MotionLayout r5, HashMap r10) {
    }

    public void setProgress(float r5) {
        this.f12661l = r5;
        int r10 = 0;
        if (this.f12985b <= 0) goto L8;
        this.f12662m = j((ConstraintLayout) getParent());
    L6:
        if (r10 >= this.f12985b) goto L11;
        View r11 = this.f12662m[r10];
        r10 = r10 + 1;
        goto L6
    L11:
        return;
    L8:
        ViewGroup r12 = (ViewGroup) getParent();
        int r13 = r12.getChildCount();
    L9:
        if (r10 >= r13) goto L14;
        boolean r14 = r12.getChildAt(r10) instanceof MotionHelper;
        r10 = r10 + 1;
        goto L9
    }

    public MotionHelper(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f12659j = false;
        this.f12660k = false;
        k(r10);
    }

    public MotionHelper(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f12659j = false;
        this.f12660k = false;
        k(r10);
    }
}
