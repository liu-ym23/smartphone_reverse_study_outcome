package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class Placeholder extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f13048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13049c;

    public Placeholder(Context r5) {
        super(r5);
        this.f13047a = -1;
        this.f13048b = null;
        this.f13049c = 4;
        a(null);
    }

    public final void a(AttributeSet r5) {
        super.setVisibility(this.f13049c);
        this.f13047a = -1;
        if (r5 == null) goto L19;
        TypedArray r10 = getContext().obtainStyledAttributes(r5, R$styleable.ConstraintLayout_placeholder);
        int r11 = r10.getIndexCount();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L13;
        int r13 = r10.getIndex(r12);
        if (r13 != R$styleable.ConstraintLayout_placeholder_content) goto L10;
        this.f13047a = r10.getResourceId(r13, this.f13047a);
    L12:
        r12 = r12 + 1;
        goto L5
    L10:
        if (r13 != R$styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) goto L12;
        this.f13049c = r10.getInt(r13, this.f13049c);
        goto L12
    L13:
        r10.recycle();
        return;
    }

    public View getContent() {
        return this.f13048b;
    }

    public int getEmptyVisibility() {
        return this.f13049c;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        if (isInEditMode() == false) goto L6;
        r10.drawRGB(223, 223, 223);
        Paint r11 = new Paint();
        r11.setARGB(255, 210, 210, 210);
        r11.setTextAlign(Paint.Align.CENTER);
        r11.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        Rect r5 = new Rect();
        r10.getClipBounds(r5);
        r11.setTextSize(r5.height());
        int r12 = r5.height();
        int r13 = r5.width();
        r11.setTextAlign(Paint.Align.LEFT);
        r11.getTextBounds("?", 0, 1, r5);
        r10.drawText("?", ((r13 / 2.0f) - (r5.width() / 2.0f)) - r5.left, ((r5.height() / 2.0f) + (r12 / 2.0f)) - r5.bottom, r11);
        return;
    }

    public void setContentId(int r5) {
        if (this.f13047a != r5) goto L5;
        return;
    L5:
        View r10 = this.f13048b;
        if (r10 == null) goto L8;
        r10.setVisibility(0);
        ((ConstraintLayout.LayoutParams) this.f13048b.getLayoutParams()).f13009f0 = false;
        this.f13048b = null;
    L8:
        this.f13047a = r5;
        if (r5 == (-1)) goto L14;
        View r11 = ((View) getParent()).findViewById(r5);
        if (r11 == null) goto L15;
        r11.setVisibility(8);
        return;
    L15:
        return;
    }

    public void setEmptyVisibility(int r5) {
        this.f13049c = r5;
    }

    public Placeholder(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f13047a = -1;
        this.f13048b = null;
        this.f13049c = 4;
        a(r10);
    }

    public Placeholder(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f13047a = -1;
        this.f13048b = null;
        this.f13049c = 4;
        a(r10);
    }
}
