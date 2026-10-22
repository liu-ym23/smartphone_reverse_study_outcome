package com.obric.oui.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatButton;
import com.obric.oui.constraintlayout.widget.R$styleable;
import kr.d;

/* JADX INFO: loaded from: classes3.dex */
public class MotionButton extends AppCompatButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f12949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f12950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Path f12951c;
    public ViewOutlineProvider d;
    public RectF e;

    public MotionButton(Context r5) {
        super(r5);
        this.f12949a = 0.0f;
        this.f12950b = Float.NaN;
        setPadding(0, 0, 0, 0);
    }

    public final void a(Context r5, AttributeSet r10) {
        int r11 = 0;
        setPadding(0, 0, 0, 0);
        if (r10 == null) goto L19;
        TypedArray r12 = r5.obtainStyledAttributes(r10, R$styleable.ImageFilterView);
        int r13 = r12.getIndexCount();
    L5:
        if (r11 >= r13) goto L13;
        int r14 = r12.getIndex(r11);
        if (r14 != R$styleable.ImageFilterView_round) goto L10;
        setRound(r12.getDimension(r14, 0.0f));
    L12:
        r11 = r11 + 1;
        goto L5
    L10:
        if (r14 != R$styleable.ImageFilterView_roundPercent) goto L12;
        setRoundPercent(r12.getFloat(r14, 0.0f));
        goto L12
    L13:
        r12.recycle();
        return;
    }

    public float getRound() {
        return this.f12950b;
    }

    public float getRoundPercent() {
        return this.f12949a;
    }

    public void setRound(float r5) {
        if (Float.isNaN(r5) == false) goto L7;
        this.f12950b = r5;
        float r10 = this.f12949a;
        this.f12949a = -1.0f;
        setRoundPercent(r10);
        return;
    L7:
        if (this.f12950b == r5) goto L9;
        boolean r11 = true;
    L10:
        this.f12950b = r5;
        if (r5 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r11 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.f12951c != null) goto L16;
        this.f12951c = new Path();
    L16:
        if (this.e != null) goto L19;
        this.e = new RectF();
    L19:
        if (this.d != null) goto L21;
        d r12 = new d(this, 1);
        this.d = r12;
        setOutlineProvider(r12);
    L21:
        setClipToOutline(true);
        this.e.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f12951c.reset();
        Path r13 = this.f12951c;
        RectF r14 = this.e;
        float r15 = this.f12950b;
        r13.addRoundRect(r14, r15, r15, Path.Direction.CW);
        goto L23
    L9:
        r11 = false;
        goto L10
    }

    public void setRoundPercent(float r10) {
        if (this.f12949a == r10) goto L5;
        boolean r5 = true;
    L6:
        this.f12949a = r10;
        if (r10 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r5 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.f12951c != null) goto L12;
        this.f12951c = new Path();
    L12:
        if (this.e != null) goto L15;
        this.e = new RectF();
    L15:
        if (this.d != null) goto L17;
        d r11 = new d(this, 0);
        this.d = r11;
        setOutlineProvider(r11);
    L17:
        setClipToOutline(true);
        int r12 = getWidth();
        int r13 = getHeight();
        float r14 = (Math.min(r12, r13) * this.f12949a) / 2.0f;
        this.e.set(0.0f, 0.0f, r12, r13);
        this.f12951c.reset();
        this.f12951c.addRoundRect(this.e, r14, r14, Path.Direction.CW);
        goto L19
    L5:
        r5 = false;
        goto L6
    }

    public MotionButton(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f12949a = 0.0f;
        this.f12950b = Float.NaN;
        a(r5, r10);
    }

    public MotionButton(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f12949a = 0.0f;
        this.f12950b = Float.NaN;
        a(r5, r10);
    }
}
