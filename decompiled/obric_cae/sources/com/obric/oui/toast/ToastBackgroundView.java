package com.obric.oui.toast;

import ac.o;
import android.aimedia.a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import com.obric.cae.R;
import he.i;
import xd.j;
import z.f;
import zc.b;

/* JADX INFO: loaded from: classes2.dex */
public final class ToastBackgroundView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f6685b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RectF f6686m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Paint f6687n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Paint f6688o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f6689p;

    public ToastBackgroundView(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
        this.f6684a = a.a("Resources.getSystem()", 1, 24.0f);
        this.f6685b = 1.0f;
        this.f6686m = new RectF();
        Paint r11 = new Paint(1);
        r11.setStyle(Paint.Style.FILL);
        j r12 = j.f13877a;
        this.f6687n = r11;
        Paint r13 = new Paint(1);
        r13.setStyle(Paint.Style.STROKE);
        r13.setStrokeWidth(1.0f);
        this.f6688o = r13;
        setBackgroundColor(0);
        r11.setColor(getResources().getColor(R.color.oui_fill_toast_tooltip, null));
        r13.setColor(getResources().getColor(R.color.LineTertiary, null));
    }

    public final int getCornerRadius() {
        return this.f6684a;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        i.f(r10, "canvas");
        if (this.f6689p == false) goto L5;
        RectF r8 = this.f6686m;
        float r11 = getPaddingLeft();
        float r12 = 2;
        float r13 = this.f6685b;
        r8.set((r13 / r12) + r11, (r13 / r12) + getPaddingTop(), (getWidth() - getPaddingRight()) - (r13 / r12), (getHeight() - getPaddingBottom()) - (r13 / r12));
        float r14 = this.f6684a * 1.0f;
        o.e(r10, r8, r14, this.f6687n);
        o.e(r10, r8, r14, this.f6688o);
    L5:
        super.onDraw(r10);
    }

    public final void setupBackground(int r8) {
        if (r8 != (this.f6684a * 2)) goto L5;
        Resources r10 = getResources();
        ThreadLocal<TypedValue> r11 = f.f14146a;
        setBackground(f.a.a(r10, R.drawable.o_toast_background_capsule_form, null));
        boolean r12 = false;
    L6:
        this.f6689p = r12;
        b.a("ToastBackgroundView", "setupBackground: drawSelf = " + this.f6689p + ", height = " + r8);
        invalidate();
        return;
    L5:
        r12 = true;
        goto L6
    }
}
