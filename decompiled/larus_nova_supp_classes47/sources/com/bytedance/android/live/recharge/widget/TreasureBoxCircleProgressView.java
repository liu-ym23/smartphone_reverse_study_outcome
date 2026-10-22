package com.bytedance.android.live.recharge.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0014B\u0013\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rB\u001d\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\f\u0010\u0010B%\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/recharge/widget/TreasureBoxCircleProgressView;", "Landroid/view/View;", "", "getProgress", "progress", "", "setProgress", "", "isDrawCircleOutside", "setCircleOutsideGone", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TreasureBoxCircleProgressView extends View {
    public Paint a;
    public int b;
    public int c;
    public float d;
    public float e;
    public RectF f;
    public float g;
    public Path h;
    public int i;
    public int j;
    public boolean k;

    public static final class a {
    }

    static {
    }

    public final float getProgress() {
        return this.g / 360;
    }

    public final void a() {
        this.b = getResources().getColor(2131108105);
        this.c = getResources().getColor(2131108455);
        Paint r0 = new Paint();
        this.a = r0;
        r0.setAntiAlias(true);
        Paint r1 = this.a;
        if (r1 == null) goto L6;
        r1.setDither(true);
        return;
    }

    public TreasureBoxCircleProgressView(Context r1) {
        super(r1);
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.onDraw(r9);
        Paint r0 = this.a;
        if (r0 == null) goto L5;
        r0.setStyle(Paint.Style.STROKE);
    L5:
        Paint r1 = this.a;
        if (r1 == null) goto L8;
        r1.setColor(this.b);
    L8:
        Paint r2 = this.a;
        if (r2 == null) goto L12;
        r2.setStrokeWidth(this.d);
    L12:
        if (this.k == true) goto L14;
    L16:
        Paint r3 = this.a;
        if (r3 == null) goto L19;
        r3.setColor(this.c);
    L19:
        RectF r4 = this.f;
        if (r4 != null) goto L22;
        return;
    L22:
        if (this.a == null) goto L26;
        Intrinsics.checkNotNull(r4);
        float r5 = this.g;
        Paint r7 = this.a;
        Intrinsics.checkNotNull(r7);
        r9.drawArc(r4, -90.0f, r5, false, r7);
        return;
    L26:
        return;
    L14:
        if (this.a == null) goto L16;
        float r6 = getWidth() / 2.0f;
        float r8 = getHeight() / 2.0f;
        float r10 = this.e;
        Paint r12 = this.a;
        Intrinsics.checkNotNull(r12);
        r9.drawCircle(r6, r8, r10, r12);
        goto L16
    }

    public final void setCircleOutsideGone(boolean r1) {
        this.k = r1;
    }

    public final void setProgress(float r2) {
        float r0 = 360;
        float r3 = r2 * r0;
        this.g = r3;
        if (r3 < r0) goto L5;
        this.g = r0;
    L5:
        invalidate();
    }

    public TreasureBoxCircleProgressView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    public TreasureBoxCircleProgressView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }

    @Override // android.view.View
    public final void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        super.onLayout(r4, r5, r6, r7, r8);
        if (this.e != 0.0f) goto L5;
    L6:
        float r9 = getWidth();
        float r10 = (0.061f * r9) * 0.8f;
        this.d = r10;
        this.e = (r9 - r10) / 2.0f;
        float r12 = 0;
        float r13 = this.d;
        float r0 = 2;
        this.f = new RectF((r13 / r0) + r12, r12 + (r13 / r0), r9 - (r13 / r0), r9 - (r13 / r0));
        int r14 = (int) (((double) (getWidth() - this.d)) * 0.45d);
        int r15 = (int) (((double) (getHeight() - this.d)) * 0.32d);
        this.i = (getWidth() - r14) / 2;
        this.j = getHeight() / 2;
        getWidth();
        int r16 = (getWidth() - r14) / 2;
        int r17 = (getHeight() - r15) / 2;
        Path r18 = new Path();
        this.h = r18;
        r18.moveTo(this.i, this.j);
        return;
    L5:
        if (this.h == null) goto L6;
    }
}
