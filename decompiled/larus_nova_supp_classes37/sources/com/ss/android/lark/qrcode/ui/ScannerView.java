package com.ss.android.lark.qrcode.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SurfaceView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ScannerView extends SurfaceView implements ScaleGestureDetector.OnScaleGestureListener {
    public final Matrix a;
    public final float[] b;
    public ScaleGestureDetector c;
    public a d;

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final void onScaleEnd(ScaleGestureDetector r1) {
    }

    private float getScale() {
        this.a.getValues(this.b);
        return this.b[0];
    }

    public ScannerView(Context r2) {
        super(r2);
        this.a = new Matrix();
        this.b = new float[9];
        Resources r3 = getContext().getResources();
        float r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density;
        this.c = new ScaleGestureDetector(getContext(), this);
    }

    private void setScanner(a r1) {
        this.d = r1;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector r1) {
        getScale();
        r1.getScaleFactor();
        r1.getCurrentSpan();
        r1.getCurrentSpan();
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScaleBegin(ScaleGestureDetector r1) {
        r1.getCurrentSpan();
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r3) {
        ScaleGestureDetector r0 = this.c;
        if (r0 != null) goto L5;
        return true;
    L5:
        r0.onTouchEvent(r3);
        if (r3.getPointerCount() != 1) goto L10;
        a r1 = this.d;
        if (r1 == null) goto L10;
        r3.getX();
        r3.getY();
        getWidth();
        getHeight();
        r1.getClass();
    L10:
        return true;
    }

    public ScannerView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = new Matrix();
        this.b = new float[9];
        Resources r3 = getContext().getResources();
        float r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density;
        this.c = new ScaleGestureDetector(getContext(), this);
    }

    public ScannerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new Matrix();
        this.b = new float[9];
        Resources r4 = getContext().getResources();
        float r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density;
        this.c = new ScaleGestureDetector(getContext(), this);
    }
}
