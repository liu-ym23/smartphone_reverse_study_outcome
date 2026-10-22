package com.lynx.tasm.behavior.ui.text;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextUtils;
import com.lynx.tasm.b0;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.g0;
import com.lynx.tasm.behavior.ui.p;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.tasm.u0;
import zm.d0;
import zm.t;

/* JADX INFO: loaded from: classes2.dex */
public class FlattenUIText extends LynxFlattenUI {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Layout f10691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PointF f10692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10693c;
    public boolean d;
    public CharSequence e;
    public d0 f;

    public FlattenUIText(b0 r5, z r10) {
        super(r5, r10);
        this.mAccessibilityElementStatus = 1;
        u0 r11 = this.mContext.K;
        if (r11 == null) goto L5;
        boolean r12 = r11.f10981t;
    L6:
        if (r12 == false) goto L9;
        this.mOverflow = 3;
        return;
    L9:
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final p convertToMeaningfulPaintingArea(int r5, int r10) {
        if (this.f10691a != null) goto L6;
        return null;
    L6:
        getOriginLeft();
        getOriginTop();
        getWidth();
        getHeight();
        p r11 = new p();
        getAlpha();
        getScaleX();
        getScaleY();
        return r11;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        if (this.f10693c == true) goto L5;
        return;
    L5:
        if ((k() instanceof Spanned) == false) goto L9;
        a.d((Spanned) k(), null);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxFlattenUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void detachWithViewInfo(g0 r5) {
        super.detachWithViewInfo(r5);
        if (this.f10693c == true) goto L5;
        return;
    L5:
        if ((k() instanceof Spanned) == false) goto L9;
        a.d((Spanned) k(), new c(this));
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final CharSequence getAccessibilityLabel() {
        CharSequence r5 = super.getAccessibilityLabel();
        if (TextUtils.isEmpty(r5) == true) goto L6;
        return r5;
    L6:
        return k();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final wm.a hitTest(float r5, float r10) {
        return hitTest(r5, r10, false);
    }

    public final int i() {
        int r5 = this.mPaddingLeft + this.mBorderLeftWidth;
        PointF r10 = this.f10692b;
        if (r10 == null) goto L5;
        int r11 = (int) r10.x;
    L7:
        return r5 + r11;
    L5:
        r11 = 0;
        goto L7
    }

    public final int j() {
        int r5 = this.mPaddingTop + this.mBorderTopWidth;
        PointF r10 = this.f10692b;
        if (r10 == null) goto L5;
        int r11 = (int) r10.y;
    L7:
        return r5 + r11;
    L5:
        r11 = 0;
        goto L7
    }

    public final CharSequence k() {
        Layout r5 = this.f10691a;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getText();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean needGenerateMeaningfulPaintingArea() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxFlattenUI
    public final void onDraw(Canvas r10) {
        TraceEvent.c("text.FlattenUIText.onDraw");
        super.onDraw(r10);
        if (this.f10691a != null) goto L5;
    L33:
        TraceEvent.a(0, "text.FlattenUIText.onDraw");
        return;
    L5:
        if (isDetachedWithView() == true) goto L33;
        int r5 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r11 = this.mPaddingRight + this.mBorderRightWidth;
        int r12 = this.mPaddingTop + this.mBorderTopWidth;
        int r13 = this.mPaddingBottom + this.mBorderBottomWidth;
        r10.save();
        int r14 = 0;
        if (getOverflow() == 0) goto L12;
        Rect r15 = getBoundRectForOverflow();
        if (r15 == null) goto L18;
        r10.clipRect(r15);
    L18:
        PointF r16 = this.f10692b;
        r10.translate(r5 + r16.x, r12 + r16.y);
        Layout r17 = this.f10691a;
        if (r17 == null) goto L21;
        Spanned r18 = (Spanned) r17.getText();
    L22:
        int r19 = a.f10695p;
        if (r18 == null) goto L28;
        a[] r20 = (a[]) r18.getSpans(0, r18.length(), a.class);
        int r21 = r20.length;
    L26:
        if (r14 >= r21) goto L28;
        r20[r14].f();
        r14 = r14 + 1;
    L28:
        this.f10691a.draw(r10);
        if (this.d == false) goto L31;
        t.g(this.f10691a, r10);
    L31:
        t.e(r10, this.f10691a);
        r10.restore();
        TraceEvent.a(0, "text.FlattenUIText.onDraw");
        return;
    L21:
        r18 = null;
        goto L22
    L12:
        u0 r22 = this.mContext.K;
        if (r22 == null) goto L15;
        boolean r23 = r22.f10981t;
    L16:
        if (r23 == true) goto L18;
        r10.clipRect(r5, r12, getWidth() - r11, getHeight() - r13);
        goto L18
    L15:
        r23 = false;
        goto L16
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        invalidate();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        onAnimationNodeReady();
        afterAnimationNodeReady();
        this.mContext.getClass();
        d0 r5 = this.f;
        if (r5 == null) goto L6;
        fj.a.f(r5, this);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateExtraData(Object r10) {
        if ((r10 instanceof d0) == false) goto L19;
        d0 r11 = (d0) r10;
        this.f = r11;
        if (this.f10693c == true) goto L7;
    L11:
        this.f10691a = r11.f23476c;
        this.f10692b = r11.e;
        boolean r5 = r11.f23474a;
        this.f10693c = r5;
        this.d = r11.f;
        this.e = r11.g;
        if (r5 == true) goto L14;
    L16:
        invalidate();
        return;
    L14:
        if ((k() instanceof Spanned) == false) goto L16;
        a.d((Spanned) k(), new c(this));
        goto L16
    L7:
        if ((k() instanceof Spanned) == false) goto L11;
        Spanned r12 = (Spanned) k();
        int r13 = 0;
        a[] r14 = (a[]) r12.getSpans(0, r12.length(), a.class);
        int r15 = r14.length;
    L9:
        if (r13 >= r15) goto L11;
        a r16 = r14[r13];
        r16.h();
        getLynxContext().getClass();
        r16.c(null);
        r13 = r13 + 1;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final wm.a hitTest(float r10, float r11, boolean r12) {
        float r5 = r10 - (this.mPaddingLeft + this.mBorderLeftWidth);
        float r13 = r11 - (this.mPaddingTop + this.mBorderTopWidth);
        Layout r14 = this.f10691a;
        if (r14 != null) goto L6;
    L9:
        Spanned r15 = null;
    L11:
        return fj.a.c(this, r5, r13, this, r14, r15, this.f10692b, r12);
    L6:
        if ((r14.getText() instanceof Spanned) == false) goto L9;
        r15 = (Spanned) r14.getText();
        goto L11
    }
}
