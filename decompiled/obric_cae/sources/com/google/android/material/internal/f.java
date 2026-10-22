package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.obric.aikernel.core.data.IdlErrors;
import com.sdk.bwdl.Utils.BWDLInnerConstant;

/* JADX INFO: loaded from: classes.dex */
public class f extends LinearLayoutCompat {
    public final Rect A;
    public final Rect B;
    public int C;
    public final boolean D;
    public boolean E;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Drawable f4862z;

    public f(Context r8, AttributeSet r10) {
        this(r8, r10, 0);
    }

    @Override // android.view.View
    public final void draw(Canvas r8) {
        super.draw(r8);
        Drawable r10 = this.f4862z;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.E == false) goto L11;
        this.E = false;
        int r11 = getRight() - getLeft();
        int r12 = getBottom() - getTop();
        boolean r13 = this.D;
        Rect r14 = this.A;
        if (r13 == false) goto L9;
        r14.set(0, 0, r11, r12);
    L10:
        int r15 = this.C;
        int r16 = r10.getIntrinsicWidth();
        int r17 = r10.getIntrinsicHeight();
        Rect r18 = this.B;
        Gravity.apply(r15, r16, r17, r14, r18);
        r10.setBounds(r18);
        goto L11
    L9:
        r14.set(getPaddingLeft(), getPaddingTop(), r11 - getPaddingRight(), r12 - getPaddingBottom());
    L11:
        r10.draw(r8);
    }

    @Override // android.view.View
    @TargetApi(21)
    public final void drawableHotspotChanged(float r8, float r10) {
        super.drawableHotspotChanged(r8, r10);
        Drawable r11 = this.f4862z;
        if (r11 == null) goto L6;
        r11.setHotspot(r8, r10);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r8 = this.f4862z;
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.isStateful() == false) goto L9;
        this.f4862z.setState(getDrawableState());
        return;
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f4862z;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.C;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r8 = this.f4862z;
        if (r8 == null) goto L6;
        r8.jumpToCurrentState();
        return;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
        this.E = r8 | this.E;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r8, int r10, int r11, int r12) {
        super.onSizeChanged(r8, r10, r11, r12);
        this.E = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable r8) {
        Drawable r10 = this.f4862z;
        if (r10 == r8) goto L17;
        if (r10 == null) goto L6;
        r10.setCallback(null);
        unscheduleDrawable(this.f4862z);
    L6:
        this.f4862z = r8;
        this.E = true;
        if (r8 == null) goto L14;
        setWillNotDraw(false);
        r8.setCallback(this);
        if (r8.isStateful() == false) goto L12;
        r8.setState(getDrawableState());
    L12:
        if (this.C != 119) goto L15;
        r8.getPadding(new Rect());
    L15:
        requestLayout();
        invalidate();
        return;
    L14:
        setWillNotDraw(true);
        goto L15
    }

    @Override // android.view.View
    public void setForegroundGravity(int r8) {
        if (this.C != r8) goto L5;
        return;
    L5:
        if ((8388615 & r8) != 0) goto L8;
        r8 = r8 | 8388611;
    L8:
        if ((r8 & BWDLInnerConstant.LINK_RECOVERY) != 0) goto L10;
        r8 = r8 | 48;
    L10:
        this.C = r8;
        if (r8 == 119) goto L13;
    L15:
        requestLayout();
        return;
    L13:
        if (this.f4862z == null) goto L15;
        Rect r10 = new Rect();
        this.f4862z.getPadding(r10);
        goto L15
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r8) {
        if (super.verifyDrawable(r8) == false) goto L5;
    L8:
        return true;
    L5:
        if (r8 == this.f4862z) goto L8;
        return false;
    }

    public f(Context r8, AttributeSet r10, int r11) {
        super(r8, r10, 0);
        this.A = new Rect();
        this.B = new Rect();
        this.C = IdlErrors.E_RejectInferDeviceOverheat;
        this.D = true;
        this.E = false;
        TypedArray r12 = l.d(r8, r10, g9.a.f7768i, 0, 0, new int[0]);
        this.C = r12.getInt(1, this.C);
        Drawable r13 = r12.getDrawable(0);
        if (r13 == null) goto L5;
        setForeground(r13);
    L5:
        this.D = r12.getBoolean(2, true);
        r12.recycle();
    }
}
