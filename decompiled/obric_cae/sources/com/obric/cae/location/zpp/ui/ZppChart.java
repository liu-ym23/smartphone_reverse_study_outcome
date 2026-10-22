package com.obric.cae.location.zpp.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ZppChart extends View {
    private static final float CONFIDENCE_MAX_Y = 1.0f;
    private static final float CONFIDENCE_MIN_Y = 0.0f;
    private static final float DISTANCE_MAX_Y = 100.0f;
    private static final float DISTANCE_MIN_Y = 0.0f;
    private Paint mAxisLinePaint;
    private Paint mBackgroundPaint;
    private final List<ChartData> mDataList;
    private Paint mGridPaint;
    private Paint mTextPaint;

    public static class ChartData {
        float[] data;
        Paint linePaint;
        float maxY;
        float minY;

        public ChartData(float[] r8, int r10, float r11, float r12) {
            this.data = r8;
            this.minY = r11;
            this.maxY = r12;
            Paint r13 = new Paint(1);
            this.linePaint = r13;
            r13.setStyle(Paint.Style.STROKE);
            this.linePaint.setStrokeWidth(5.0f);
            this.linePaint.setColor(r10);
        }
    }

    public ZppChart(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.mDataList = new ArrayList();
        init();
    }

    private void drawChart(Canvas r10, ChartData r11) {
        float[] r8 = r11.data;
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.length < 2) goto L32;
        Path r12 = new Path();
        int r13 = 1;
        float r14 = getWidth() / (r11.data.length - 1);
        float r15 = getHeight() / 2.0f;
        float r16 = r11.maxY;
        float r17 = CONFIDENCE_MAX_Y;
        if (r16 != CONFIDENCE_MAX_Y) goto L10;
        boolean r18 = true;
    L11:
        if (r18 == true) goto L14;
        r17 = DISTANCE_MAX_Y;
    L14:
        float r19 = ((Math.max(r11.minY, Math.min(r11.data[0], r16)) - r11.minY) / r17) * r15;
        if (r18 == false) goto L17;
        float r20 = r15 - r19;
    L18:
        r12.moveTo(CONFIDENCE_MIN_Y, r20);
    L19:
        float[] r21 = r11.data;
        if (r13 >= r21.length) goto L26;
        float r22 = r13 * r14;
        float r23 = ((Math.max(r11.minY, Math.min(r21[r13], r11.maxY)) - r11.minY) / r17) * r15;
        if (r18 == false) goto L24;
        float r24 = r15 - r23;
    L25:
        r12.lineTo(r22, r24);
        r13 = r13 + 1;
        goto L19
    L24:
        r24 = r23 + r15;
        goto L25
    L26:
        r10.drawPath(r12, r11.linePaint);
        return;
    L17:
        r20 = r19 + r15;
        goto L18
    L10:
        r18 = false;
        goto L11
    }

    private void drawGrid(Canvas r12) {
        float r8 = getHeight() / 2.0f;
        r12.drawLine(CONFIDENCE_MIN_Y, r8, getWidth(), r8, this.mAxisLinePaint);
        int r10 = 1;
        int r11 = 1;
    L4:
        if (r11 > 5) goto L6;
        float r13 = r8 - ((r8 / 5.0f) * r11);
        r12.drawLine(CONFIDENCE_MIN_Y, r13, getWidth(), r13, this.mGridPaint);
        r11 = r11 + 1;
    L6:
        if (r10 > 5) goto L8;
        float r14 = ((r8 / 5.0f) * r10) + r8;
        r12.drawLine(CONFIDENCE_MIN_Y, r14, getWidth(), r14, this.mGridPaint);
        r10 = r10 + 1;
        goto L6
    }

    private void drawYAxisLabels(Canvas r10) {
        float r8 = getHeight() / 2.0f;
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
        int r11 = 0;
    L4:
        if (r11 > 5) goto L6;
        float r12 = r11;
        r10.drawText(String.format(Locale.US, "%.1f", new Object[]{Float.valueOf(r12 * 0.2f)}), 5.0f, (r8 - ((r8 / 5.0f) * r12)) + 5.0f, this.mTextPaint);
        r11 = r11 + 1;
        goto L4
    L6:
        int r13 = 1;
    L7:
        if (r13 > 5) goto L9;
        float r14 = r13;
        r10.drawText(String.format(Locale.US, "%d", new Object[]{Integer.valueOf((int) (r14 * 20.0f))}), 5.0f, (((r8 / 5.0f) * r14) + r8) + 5.0f, this.mTextPaint);
        r13 = r13 + 1;
        goto L7
    L9:
        this.mTextPaint.setTextAlign(Paint.Align.RIGHT);
        r10.drawText("Confidence (RED)", getWidth() - 5, this.mTextPaint.getTextSize(), this.mTextPaint);
        r10.drawText("Distance (BLUE)", getWidth() - 5, getHeight() - 5, this.mTextPaint);
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
    }

    private void init() {
        Paint r8 = new Paint();
        this.mBackgroundPaint = r8;
        r8.setColor(-1);
        this.mBackgroundPaint.setStyle(Paint.Style.FILL);
        Paint r10 = new Paint();
        this.mGridPaint = r10;
        r10.setColor(-3355444);
        this.mGridPaint.setStyle(Paint.Style.STROKE);
        this.mGridPaint.setPathEffect(new DashPathEffect(new float[]{10.0f, 5.0f}, CONFIDENCE_MIN_Y));
        Paint r11 = new Paint(1);
        this.mTextPaint = r11;
        r11.setColor(-16777216);
        this.mTextPaint.setTextSize(20.0f);
        Paint r12 = new Paint();
        this.mAxisLinePaint = r12;
        r12.setColor(-16777216);
        this.mAxisLinePaint.setStrokeWidth(2.0f);
    }

    @Override // android.view.View
    public void onDraw(Canvas r8) {
        super.onDraw(r8);
        r8.drawRect(CONFIDENCE_MIN_Y, CONFIDENCE_MIN_Y, getWidth(), getHeight(), this.mBackgroundPaint);
        drawGrid(r8);
        drawYAxisLabels(r8);
        Iterator<ChartData> r10 = this.mDataList.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        drawChart(r8, r10.next());
        goto L4
    }

    public void setData(float[] r8, float[] r10) {
        this.mDataList.clear();
        if (r8 == null) goto L5;
        this.mDataList.add(new ChartData(r8, -65536, CONFIDENCE_MIN_Y, CONFIDENCE_MAX_Y));
    L5:
        if (r10 == null) goto L7;
        this.mDataList.add(new ChartData(r10, -16776961, CONFIDENCE_MIN_Y, DISTANCE_MAX_Y));
    L7:
        invalidate();
    }
}
