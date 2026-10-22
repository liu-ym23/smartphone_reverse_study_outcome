package com.obric.cae.userAware.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class LineChart extends View {
    public static final int MODE_TIME_SERIES = 0;
    public static final int MODE_XY = 1;
    private String TAG;
    private Bitmap bitmap;
    private int blcolor;
    private Canvas canvas;
    private Paint mGridPaint;
    private float mLastXpx;
    private float mLastYpx;
    private float mMaxY;
    private float mMinY;
    private int mMode;
    private Paint mPointPaint;
    private float mPointRadiusPx;
    private boolean mShowYAxisGrid;
    private int mSingleLineColor;
    private Paint mTextPaint;
    private boolean mUseYAxisRange;
    private float mXMax;
    private float mXMin;
    private int mXStep;
    private boolean mXYAxisCenterValuesSet;
    private double mXYAxisCenterXValue;
    private double mXYAxisCenterYValue;
    private boolean mXYAxisXWrapTo180;
    private String mXYCenterXLabel;
    private String mXYCenterYLabel;
    private final SparseArray<float[]> mXYLastPointBySeries;
    private float mXYMetersPerPixel;
    private boolean mXYUseRange;
    private int mYAxisTickCount;
    private float mYMax;
    private float mYMin;
    private Paint paint;
    private int preX;
    private float preY1;
    private float preY2;
    private float preY3;

    public LineChart(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.mMode = 0;
        this.mXStep = 1;
        this.preX = 0;
        this.preY1 = 250.0f;
        this.preY2 = 250.0f;
        this.preY3 = 250.0f;
        this.mMinY = -12.5f;
        this.mMaxY = 12.5f;
        this.mUseYAxisRange = false;
        this.mSingleLineColor = -1;
        this.mLastXpx = Float.NaN;
        this.mLastYpx = Float.NaN;
        this.mXYLastPointBySeries = new SparseArray();
        this.mXYMetersPerPixel = 1.0f;
        this.mXYUseRange = false;
        this.mXMin = -180.0f;
        this.mXMax = 180.0f;
        this.mYMin = -90.0f;
        this.mYMax = 90.0f;
        this.mXYAxisCenterValuesSet = false;
        this.mXYAxisCenterXValue = 0.0d;
        this.mXYAxisCenterYValue = 0.0d;
        this.mXYAxisXWrapTo180 = false;
        this.mPointRadiusPx = 4.0f;
        this.mShowYAxisGrid = false;
        this.mYAxisTickCount = 5;
        this.TAG = "LINE_CHART";
        this.paint = new Paint(4);
        this.canvas = new Canvas();
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(5.0f);
        this.paint.setColor(-65536);
        this.paint.setAntiAlias(true);
        Paint r11 = new Paint(1);
        this.mGridPaint = r11;
        r11.setStyle(Paint.Style.STROKE);
        this.mGridPaint.setStrokeWidth(1.0f);
        this.mGridPaint.setColor(-12303292);
        Paint r12 = new Paint(1);
        this.mTextPaint = r12;
        r12.setColor(-3355444);
        this.mTextPaint.setTextSize(18.0f);
        this.mTextPaint.setTypeface(Typeface.MONOSPACE);
        Paint r13 = new Paint(1);
        this.mPointPaint = r13;
        r13.setStyle(Paint.Style.FILL);
    }

    private float clampBaselineY(float r8, float r10) {
        float r11 = r8 - 2.0f;
        float r12 = this.mTextPaint.getTextSize();
        float r13 = r10 - this.mTextPaint.getFontMetrics().descent;
        if (r11 >= r12) goto L6;
        r11 = r12;
    L6:
        if (r11 <= r13) goto L9;
        return r13;
    L9:
        return r11;
    }

    private void drawCenteredText(Canvas r8, String r10, float r11, float r12, float r13) {
        float r14 = this.mTextPaint.measureText(r10);
        float r15 = r11 - (r14 / 2.0f);
        if (r15 >= 0.0f) goto L6;
        r15 = 0.0f;
    L6:
        if ((r15 + r14) <= r13) goto L8;
        r15 = r13 - r14;
    L8:
        r8.drawText(r10, r15, r12, this.mTextPaint);
    }

    private static String formatAxisNumber(double r8) {
        String r10 = String.format(Locale.US, "%.6f", new Object[]{Double.valueOf(r8)});
        int r11 = r10.length();
    L3:
        if (r11 <= 0) goto L7;
        if (r10.charAt(r11 - 1) != '0') goto L7;
        r11 = r11 - 1;
    L7:
        if (r11 <= 0) goto L12;
        if (r10.charAt(r11 - 1) != '.') goto L12;
        r11 = r11 - 1;
    L12:
        return r10.substring(0, r11);
    }

    private float mapValueToY(float r8) {
        Bitmap r10 = this.bitmap;
        if (r10 != null) goto L7;
        return 0.0f;
    L7:
        if (this.mUseYAxisRange == false) goto L9;
        float r11 = this.mMaxY;
        float r12 = this.mMinY;
        if (r11 > r12) goto L15;
        return r10.getHeight() / 2.0f;
    L15:
        if (r8 >= r12) goto L18;
        r8 = r12;
    L18:
        if (r8 <= r11) goto L21;
        r8 = r11;
    L21:
        return r10.getHeight() - (((r8 - r12) / (r11 - r12)) * this.bitmap.getHeight());
    L9:
        return (r10.getHeight() / 2.0f) + (((int) r8) * 10.0f);
    }

    private static double wrapTo180(double r8) {
    L3:
        if (r8 > (-180.0d)) goto L6;
        r8 = r8 + 360.0d;
    L6:
        if (r8 <= 180.0d) goto L9;
        r8 = r8 - 360.0d;
        goto L6
    L9:
        if (r8 == (-180.0d)) goto L11;
        return r8;
    L11:
        return 180.0d;
    }

    public void UpdateData(float[] r19, float[] r20, float[] r21) {
        if (this.mMode == 0) goto L5;
        return;
    L5:
        if (r19 == null) goto L21;
        if (r20 == null) goto L22;
        if (r21 == null) goto L23;
        Bitmap r8 = this.bitmap;
        if (r8 != null) goto L13;
        return;
    L13:
        if (this.preX <= r8.getWidth()) goto L15;
        reset();
    L15:
        int r10 = Math.min(r19.length, Math.min(r20.length, r21.length));
        int r11 = 0;
    L16:
        if (r11 >= r10) goto L18;
        int r12 = this.preX + 1;
        float r13 = mapValueToY(r19[r11]);
        float r15 = mapValueToY(r20[r11]);
        float r14 = mapValueToY(r21[r11]);
        this.paint.setColor(-65536);
        float r16 = r12;
        this.canvas.drawLine(this.preX, this.preY1, r16, r13, this.paint);
        this.paint.setColor(-16711936);
        this.canvas.drawLine(this.preX, this.preY2, r16, r15, this.paint);
        this.paint.setColor(-16776961);
        this.canvas.drawLine(this.preX, this.preY3, r16, r14, this.paint);
        this.preX = r12;
        this.preY1 = r13;
        this.preY2 = r15;
        this.preY3 = r14;
        r11 = r11 + 1;
        goto L16
    L18:
        invalidate();
        return;
    L23:
        return;
    L22:
        return;
    }

    public void UpdateSingleData(float[] r10) {
        if (this.mMode == 0) goto L5;
        return;
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        Bitmap r8 = this.bitmap;
        if (r8 != null) goto L11;
        return;
    L11:
        if (this.preX <= r8.getWidth()) goto L13;
        reset();
    L13:
        int r11 = 0;
    L15:
        if (r11 >= r10.length) goto L24;
        int r12 = this.preX + this.mXStep;
        if (r12 <= this.bitmap.getWidth()) goto L19;
        reset();
        r12 = this.mXStep;
    L19:
        float r13 = mapValueToY(r10[r11]);
        if (this.preX <= 0) goto L22;
        this.paint.setColor(this.mSingleLineColor);
        this.canvas.drawLine(this.preX, this.preY1, r12, r13, this.paint);
    L23:
        this.preX = r12;
        this.preY1 = r13;
        r11 = r11 + 1;
        goto L15
    L22:
        this.mPointPaint.setColor(this.mSingleLineColor);
        this.canvas.drawCircle(r12, r13, this.mPointRadiusPx, this.mPointPaint);
        goto L23
    L24:
        invalidate();
    }

    public void UpdateXYData(float[] r8, float[] r10) {
        UpdateXYData(r8, r10, 0, -16711681);
    }

    @Override // android.view.View
    public void onDraw(Canvas r12) {
        Bitmap r8 = this.bitmap;
        if (r8 == null) goto L6;
        r12.drawBitmap(r8, 0.0f, 0.0f, null);
    L6:
        if (this.mMode != 1) goto L33;
        Bitmap r10 = this.bitmap;
        if (r10 != null) goto L10;
        return;
    L10:
        float r11 = r10.getWidth();
        float r13 = this.bitmap.getHeight();
        boolean r14 = this.mXYUseRange;
        if (r14 == false) goto L13;
        float r15 = this.mXMin;
        float r16 = (0.0f - r15) / (this.mXMax - r15);
        float r17 = this.mYMin;
        float r18 = r13 - (((0.0f - r17) / (this.mYMax - r17)) * r13);
        float r19 = r16 * r11;
    L14:
        if (r14 == true) goto L16;
    L22:
        String r20 = this.mXYCenterYLabel;
        if (r20 != null) goto L25;
    L27:
        String r21 = this.mXYCenterXLabel;
        if (r21 != null) goto L30;
        return;
    L30:
        if (r21.isEmpty() == true) goto L35;
        r12.drawText(this.mXYCenterXLabel, r19 + 6.0f, Math.min(r13 - 2.0f, (this.mTextPaint.getTextSize() + r18) + 6.0f), this.mTextPaint);
        return;
    L35:
        return;
    L25:
        if (r20.isEmpty() == true) goto L27;
        r12.drawText(this.mXYCenterYLabel, r19 + 6.0f, Math.max(this.mTextPaint.getTextSize(), r18 - 6.0f), this.mTextPaint);
        goto L27
    L16:
        if (this.mXYAxisCenterValuesSet == false) goto L22;
        double r22 = this.mXYAxisCenterXValue;
        if (this.mXYAxisXWrapTo180 == false) goto L20;
        r22 = wrapTo180(r22);
    L20:
        double r23 = this.mXYAxisCenterYValue;
        Locale r24 = Locale.US;
        String r25 = String.format(r24, "%.6f", new Object[]{Double.valueOf(r22)});
        String r26 = String.format(r24, "%.6f", new Object[]{Double.valueOf(r23)});
        drawCenteredText(r12, r25, r19, (r13 - this.mTextPaint.getFontMetrics().descent) - 2.0f, r11);
        Paint.FontMetrics r27 = this.mTextPaint.getFontMetrics();
        r12.drawText(r26, 2.0f, r18 - ((r27.ascent + r27.descent) / 2.0f), this.mTextPaint);
        return;
    L13:
        r19 = r11 / 2.0f;
        r18 = r13 / 2.0f;
        goto L14
    }

    @Override // android.view.View
    public void onSizeChanged(int r8, int r10, int r11, int r12) {
        super.onSizeChanged(r8, r10, r11, r12);
        if (r8 <= 0) goto L16;
        if (r10 <= 0) goto L17;
        Bitmap r13 = this.bitmap;
        if (r13 != null) goto L8;
    L11:
        Bitmap r14 = this.bitmap;
        if (r14 == null) goto L14;
        r14.recycle();
    L14:
        Bitmap r15 = Bitmap.createBitmap(r8, r10, Bitmap.Config.ARGB_8888);
        this.bitmap = r15;
        this.canvas.setBitmap(r15);
        reset();
        return;
    L8:
        if (r13.getWidth() != r8) goto L11;
        if (this.bitmap.getHeight() != r10) goto L11;
        return;
    L17:
        return;
    }

    public void reset() {
        int r8 = 0;
        this.preX = 0;
        this.mLastXpx = Float.NaN;
        this.mLastYpx = Float.NaN;
        this.mXYLastPointBySeries.clear();
        Bitmap r10 = this.bitmap;
        if (r10 != null) goto L6;
        invalidate();
        return;
    L6:
        this.preY1 = r10.getHeight();
        this.preY2 = this.bitmap.getHeight();
        this.preY3 = this.bitmap.getHeight();
        Paint r11 = new Paint(1);
        r11.setColor(-16777216);
        this.canvas.drawRect(0.0f, 0.0f, this.bitmap.getWidth(), this.bitmap.getHeight(), r11);
        if (this.mMode != 1) goto L10;
        Paint r12 = new Paint(1);
        r12.setStyle(Paint.Style.STROKE);
        r12.setStrokeWidth(2.0f);
        r12.setColor(-12303292);
        float r13 = this.bitmap.getWidth() / 2.0f;
        float r14 = this.bitmap.getHeight() / 2.0f;
        this.canvas.drawLine(0.0f, r14, this.bitmap.getWidth(), r14, r12);
        this.canvas.drawLine(r13, 0.0f, r13, this.bitmap.getHeight(), r12);
    L10:
        if (this.mMode == 0) goto L12;
    L18:
        invalidate();
        return;
    L12:
        if (this.mShowYAxisGrid == false) goto L18;
        if (this.mUseYAxisRange == false) goto L18;
    L15:
        int r15 = this.mYAxisTickCount;
        if (r8 > r15) goto L18;
        float r16 = r8 / r15;
        float r17 = this.mMinY;
        float r18 = defpackage.a.a(this.mMaxY, r17, r16, r17);
        float r19 = mapValueToY(r18);
        this.canvas.drawLine(0.0f, r19, this.bitmap.getWidth(), r19, this.mGridPaint);
        this.canvas.drawText(String.format(Locale.US, "%.0f", new Object[]{Float.valueOf(r18)}), 6.0f, Math.max(this.mTextPaint.getTextSize(), r19 - 2.0f), this.mTextPaint);
        r8 = r8 + 1;
        goto L15
    }

    public void setMode(int r8) {
        if (this.mMode != r8) goto L5;
        return;
    L5:
        this.mMode = r8;
        reset();
    }

    public void setShowYAxisGrid(boolean r8) {
        this.mShowYAxisGrid = r8;
    }

    public void setSingleLineColor(int r8) {
        this.mSingleLineColor = r8;
    }

    public void setXStep(int r8) {
        if (r8 <= 0) goto L5;
        this.mXStep = r8;
        return;
    }

    public void setXYAxisCenterValues(double r8, double r10) {
        if (Double.isNaN(r8) == false) goto L5;
    L14:
        this.mXYAxisCenterValuesSet = false;
    L12:
        invalidate();
        return;
    L5:
        if (Double.isInfinite(r8) == true) goto L14;
        if (Double.isNaN(r10) == true) goto L14;
        if (Double.isInfinite(r10) == true) goto L14;
        this.mXYAxisCenterValuesSet = true;
        this.mXYAxisCenterXValue = r8;
        this.mXYAxisCenterYValue = r10;
        goto L12
    }

    public void setXYAxisXWrapTo180(boolean r8) {
        this.mXYAxisXWrapTo180 = r8;
        invalidate();
    }

    public void setXYCenterLabels(String r8, String r10) {
        this.mXYCenterXLabel = r8;
        this.mXYCenterYLabel = r10;
        invalidate();
    }

    public void setXYMetersPerPixel(float r8) {
        if (r8 > 0.0f) goto L5;
        return;
    L5:
        this.mXYMetersPerPixel = r8;
    }

    public void setXYRange(float r8, float r10, float r11, float r12) {
        if (r10 > r8) goto L5;
        return;
    L5:
        if (r12 <= r11) goto L10;
        this.mXYUseRange = true;
        this.mXMin = r8;
        this.mXMax = r10;
        this.mYMin = r11;
        this.mYMax = r12;
        return;
    }

    public void setYAxisRange(float r8, float r10) {
        this.mUseYAxisRange = true;
        this.mMinY = r8;
        this.mMaxY = r10;
    }

    public void setYAxisTickCount(int r8) {
        if (r8 > 0) goto L4;
        return;
    L4:
        this.mYAxisTickCount = r8;
    }

    public void UpdateXYData(float[] r21, float[] r22, int r23, int r24) {
        if (this.mMode == 1) goto L5;
        return;
    L5:
        if (r21 == null) goto L47;
        if (r22 != null) goto L9;
        return;
    L9:
        if (this.bitmap != null) goto L11;
        return;
    L11:
        int r8 = Math.min(r21.length, r22.length);
        float r10 = this.bitmap.getWidth() / 2.0f;
        float r11 = this.bitmap.getHeight() / 2.0f;
        float[] r12 = this.mXYLastPointBySeries.get(r23);
        if (r12 != null) goto L14;
    L16:
        float r13 = Float.NaN;
        float r14 = Float.NaN;
    L17:
        float r15 = r14;
        int r16 = 0;
        float r17 = r13;
    L18:
        if (r16 >= r8) goto L41;
        if (this.mXYUseRange == false) goto L34;
        float r18 = r21[r16];
        float r19 = r22[r16];
        float r20 = this.mXMin;
        if (r18 >= r20) goto L24;
        r18 = r20;
    L24:
        float r110 = this.mXMax;
        if (r18 <= r110) goto L27;
        r18 = r110;
    L27:
        float r111 = this.mYMin;
        if (r19 >= r111) goto L30;
        r19 = r111;
    L30:
        float r25 = this.mYMax;
        if (r19 <= r25) goto L33;
        r19 = r25;
    L33:
        float r112 = ((r18 - r20) / (r110 - r20)) * this.bitmap.getWidth();
        float r26 = this.bitmap.getHeight() - (((r19 - r111) / (r25 - r111)) * this.bitmap.getHeight());
    L36:
        if (Float.isNaN(r17) == true) goto L40;
        if (Float.isNaN(r15) == true) goto L40;
        this.paint.setColor(r24);
        this.canvas.drawLine(r17, r15, r112, r26, this.paint);
    L40:
        this.mPointPaint.setColor(r24);
        this.canvas.drawCircle(r112, r26, this.mPointRadiusPx, this.mPointPaint);
        r16 = r16 + 1;
        r15 = r26;
        r17 = r112;
        r8 = r8;
        goto L18
    L34:
        float r27 = r21[r16];
        float r28 = this.mXYMetersPerPixel;
        r112 = (r27 / r28) + r10;
        r26 = r11 - (r22[r16] / r28);
        goto L36
    L41:
        this.mXYLastPointBySeries.put(r23, new float[]{r17, r15});
        this.mLastXpx = r17;
        this.mLastYpx = r15;
        invalidate();
        return;
    L14:
        if (r12.length < 2) goto L16;
        r13 = r12[0];
        r14 = r12[1];
        goto L17
    }
}
