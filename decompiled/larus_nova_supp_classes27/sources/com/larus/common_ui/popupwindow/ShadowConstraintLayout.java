package com.larus.common_ui.popupwindow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ0\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0014J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/common_ui/popupwindow/ShadowConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anchorView", "Landroid/view/View;", "getAnchorView", "()Landroid/view/View;", "setAnchorView", "(Landroid/view/View;)V", "shadowRadius", "", "getShadowRadius", "()F", "setShadowRadius", "(F)V", "cornerRadius", "shadowColor", "shadowPaint", "Landroid/graphics/Paint;", "shadowRect", "Landroid/graphics/RectF;", "onLayout", "", "changed", "", "left", "top", "right", "bottom", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShadowConstraintLayout extends ConstraintLayout {
    public View a;
    public float b;
    public final float c;
    public final int d;
    public final Paint e;
    public final RectF f;

    public final View getAnchorView() {
        return this.a;
    }

    public final float getShadowRadius() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShadowConstraintLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.c = c7.b(12);
        this.d = Color.argb(30, Color.red(-16777216), Color.green(-16777216), Color.blue(-16777216));
        Paint r5 = new Paint();
        r5.setAntiAlias(true);
        this.e = r5;
        this.f = new RectF();
        setBackgroundColor(0);
    }

    public final void dispatchDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        View r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        float r1 = r0.getLeft();
        float r2 = r0.getTop();
        this.f.set(r1, r2, r0.getWidth() + r1, r0.getHeight() + r2);
        Paint r3 = this.e;
        r3.setColor(this.d);
        r3.setShadowLayer(this.b, 0.0f, 0.0f, this.d);
        RectF r4 = this.f;
        float r5 = this.c;
        r6.drawRoundRect(r4, r5, r5, this.e);
        super.dispatchDraw(r6);
    }

    public final void setAnchorView(View r1) {
        this.a = r1;
    }

    public final void setShadowRadius(float r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShadowConstraintLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.c = c7.b(12);
        this.d = Color.argb(30, Color.red(-16777216), Color.green(-16777216), Color.blue(-16777216));
        Paint r5 = new Paint();
        r5.setAntiAlias(true);
        this.e = r5;
        this.f = new RectF();
        setBackgroundColor(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShadowConstraintLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = c7.b(12);
        this.d = Color.argb(30, Color.red(-16777216), Color.green(-16777216), Color.blue(-16777216));
        Paint r5 = new Paint();
        r5.setAntiAlias(true);
        this.e = r5;
        this.f = new RectF();
        setBackgroundColor(0);
    }

    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
