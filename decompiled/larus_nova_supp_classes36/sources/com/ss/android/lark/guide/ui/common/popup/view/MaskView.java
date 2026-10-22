package com.ss.android.lark.guide.ui.common.popup.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\nB\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\u000bJ\b\u0010\u001d\u001a\u00020\u001eH\u0014J\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0014J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0019H\u0014J\u000e\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u0007J\u000e\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u0007J\u000e\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u0007J\u000e\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u0012R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/ss/android/lark/guide/ui/common/popup/view/MaskView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mTargetRect", "Landroid/graphics/RectF;", "mOverlayRect", "mFullingPaint", "Landroid/graphics/Paint;", "mNeedHighlight", "", "mCorner", "mStyle", "mEraser", "mEraserBitmap", "Landroid/graphics/Bitmap;", "mEraserCanvas", "Landroid/graphics/Canvas;", "mInitHeight", "mChangedHeight", "mFirstFlag", "onDetachedFromWindow", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "setTargetRect", "rect", "Landroid/graphics/Rect;", "setFullingAlpha", "alpha", "setFullingColor", "color", "setHighlightTargetCorner", "corner", "setHighTargetGraphStyle", "style", "setTargetHighlight", "enable", "guide-ui_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MaskView extends View {
    public final RectF a;
    public final RectF b;
    public final Paint c;
    public boolean d;
    public int e;
    public int f;
    public final Paint g;
    public Bitmap h;
    public final Canvas i;
    public int j;
    public int k;
    public boolean l;

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearFocus();     // Catch: Exception -> L5
        this.i.setBitmap(null);     // Catch: Exception -> L5
        this.h = null;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public MaskView(Context r3) {
        this(r3, null, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super.onDraw(r6);
        if (this.h != null) goto L5;
        return;
    L5:
        int r0 = this.k;
        if (r0 == 0) goto L8;
        this.a.offset(0.0f, r0);
        this.j += this.k;
        this.k = 0;
    L8:
        Bitmap r1 = this.h;
        if (r1 == null) goto L11;
        r1.eraseColor(0);
    L11:
        this.i.drawColor(this.c.getColor());
        if (this.d == false) goto L20;
        float r2 = this.e;
        int r3 = this.f;
        if (r3 != 0) goto L16;
        this.i.drawCircle(this.a.centerX(), this.a.centerY(), this.a.width() / 2, this.g);
        goto L20
    L16:
        if (r3 == 1) goto L18;
        this.i.drawRoundRect(this.a, r2, r2, this.g);
        goto L20
    L18:
        this.i.drawRoundRect(this.a, r2, r2, this.g);
    L20:
        Bitmap r4 = this.h;
        if (r4 == null) goto L24;
        RectF r5 = this.b;
        r6.drawBitmap(r4, r5.left, r5.top, null);
        return;
    }

    public final void setFullingAlpha(int r2) {
        this.c.setAlpha(r2);
    }

    public final void setFullingColor(int r2) {
        this.c.setColor(r2);
    }

    public final void setHighTargetGraphStyle(int r1) {
        this.f = r1;
    }

    public final void setHighlightTargetCorner(int r1) {
        this.e = r1;
    }

    public final void setTargetHighlight(boolean r1) {
        this.d = r1;
    }

    public final void setTargetRect(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "rect");
        this.a.set(r2);
    }

    public MaskView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        int r5 = View.MeasureSpec.getSize(r3);
        int r6 = View.MeasureSpec.getSize(r4);
        int r1 = 0;
        if (this.l == false) goto L5;
        this.j = r6;
        this.l = false;
    L5:
        int r0 = this.j;
        if (r0 <= r6) goto L8;
    L7:
        r1 = r6 - r0;
    L10:
        this.k = r1;
        setMeasuredDimension(r5, r6);
        this.b.set(0.0f, 0.0f, r5, r6);
        return;
    L8:
        if (r0 >= r6) goto L10;
        goto L10
    }

    public MaskView(Context r5, AttributeSet r6, int r7) {
        super(r5, r6, r7);
        this.a = new RectF();
        RectF r8 = new RectF();
        this.b = r8;
        this.f = 1;
        this.l = true;
        setWillNotDraw(false);
        Object r9 = getContext().getSystemService("window");
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics r0 = new DisplayMetrics();
        ((WindowManager) r9).getDefaultDisplay().getRealMetrics(r0);
        int r10 = r0.widthPixels;
        int r1 = r0.heightPixels;
        r8.set(0.0f, 0.0f, r10, r1);
        this.h = Bitmap.createBitmap(r10, r1, Bitmap.Config.ARGB_8888);
        Bitmap r11 = this.h;
        Intrinsics.checkNotNull(r11);
        this.i = new Canvas(r11);
        this.c = new Paint();
        Paint r12 = new Paint();
        this.g = r12;
        r12.setColor(-1);
        r12.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        r12.setFlags(1);
    }
}
