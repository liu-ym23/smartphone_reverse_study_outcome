package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import lr.l;
import lr.m;

/* JADX INFO: loaded from: classes3.dex */
public class ReactiveGuide extends View implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13054c;
    public boolean d;

    public ReactiveGuide(Context r5) {
        super(r5);
        this.f13052a = -1;
        this.f13053b = false;
        this.f13054c = 0;
        this.d = true;
        super.setVisibility(8);
        a(null);
    }

    public final void a(AttributeSet r5) {
        if (r5 == null) goto L20;
        TypedArray r10 = getContext().obtainStyledAttributes(r5, R$styleable.ConstraintLayout_ReactiveGuide);
        int r11 = r10.getIndexCount();
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L18;
        int r13 = r10.getIndex(r12);
        if (r13 != R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) goto L9;
        this.f13052a = r10.getResourceId(r13, this.f13052a);
    L17:
        r12 = r12 + 1;
        goto L4
    L9:
        if (r13 != R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) goto L12;
        this.f13053b = r10.getBoolean(r13, this.f13053b);
        goto L17
    L12:
        if (r13 != R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) goto L15;
        this.f13054c = r10.getResourceId(r13, this.f13054c);
        goto L17
    L15:
        if (r13 != R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) goto L17;
        this.d = r10.getBoolean(r13, this.d);
        goto L17
    L18:
        r10.recycle();
    L20:
        if (this.f13052a == (-1)) goto L29;
        ConstraintLayout.getSharedValues().a(this.f13052a, this);
        return;
    }

    @Override // android.view.View
    public final void draw(Canvas r5) {
    }

    public int getApplyToConstraintSetId() {
        return this.f13054c;
    }

    public int getAttributeId() {
        return this.f13052a;
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r10) {
        setMeasuredDimension(0, 0);
    }

    public void setAnimateChange(boolean r5) {
        this.f13053b = r5;
    }

    public void setApplyToConstraintSetId(int r5) {
        this.f13054c = r5;
    }

    public void setAttributeId(int r10) {
        m r5 = ConstraintLayout.getSharedValues();
        int r11 = this.f13052a;
        if (r11 == (-1)) goto L15;
        HashSet r12 = (HashSet) r5.f19773a.get(Integer.valueOf(r11));
        if (r12 == null) goto L15;
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L9:
        if (r14.hasNext() == false) goto L14;
        WeakReference r15 = (WeakReference) r14.next();
        l r16 = (l) r15.get();
        if (r16 == null) goto L13;
        if (r16 != this) goto L9;
    L13:
        r13.add(r15);
        goto L9
    L14:
        r12.removeAll(r13);
    L15:
        this.f13052a = r10;
        if (r10 == (-1)) goto L25;
        r5.a(r10, this);
        return;
    }

    public void setGuidelineBegin(int r5) {
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r10.f13001a = r5;
        setLayoutParams(r10);
    }

    public void setGuidelineEnd(int r5) {
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r10.f13003b = r5;
        setLayoutParams(r10);
    }

    public void setGuidelinePercent(float r5) {
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r10.f13005c = r5;
        setLayoutParams(r10);
    }

    @Override // android.view.View
    public void setVisibility(int r5) {
    }

    public ReactiveGuide(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f13052a = -1;
        this.f13053b = false;
        this.f13054c = 0;
        this.d = true;
        super.setVisibility(8);
        a(r10);
    }

    public ReactiveGuide(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f13052a = -1;
        this.f13053b = false;
        this.f13054c = 0;
        this.d = true;
        super.setVisibility(8);
        a(r10);
    }
}
