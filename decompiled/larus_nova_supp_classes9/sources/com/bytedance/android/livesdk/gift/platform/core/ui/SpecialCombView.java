package com.bytedance.android.livesdk.gift.platform.core.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class SpecialCombView extends View {
    private static final int ANGLE_360 = 360;
    private static final float PROGRESS_START_ANGLE = -90.0f;
    private int bgColor;
    private RectF bordRectF;
    private LinearGradient bordShader;
    private ValueAnimator borderAnimator;
    private float borderWidth;
    private Bitmap combBitmap;
    private Rect combBmRect;
    private RectF combDrawRectF;
    private Paint mPaint;
    private float progress;
    private float radius;
    private TextPaint textPaint;
    private int time;
    private String timeStr;
    private int totalTimeCount;
    private float viewHeight;
    private LinearGradient viewShader;
    private float viewWidth;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ SpecialCombView a;

        public a(SpecialCombView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r7) {
            float r8 = r7.getAnimatedFraction();
            double r0 = r8;
            if (r0 > 0.1d) goto L6;
            float r9 = -r8;
            float r1 = 1.1f;
        L18:
            float r10 = r9 + r1;
            this.a.setScaleX(r10);
            this.a.setScaleY(r10);
            this.a.invalidate();
            return;
        L6:
            if (r0 > 0.3333d) goto L9;
            r9 = r8 * 0.4286f;
            r1 = 0.9571f;
            goto L18
        L9:
            if (r0 > 0.4333d) goto L12;
            r9 = -r8;
            r1 = 1.4333f;
            goto L18
        L12:
            if (r0 > 0.6667d) goto L15;
            r9 = r8 * 0.4286f;
            r1 = 0.8143f;
            goto L18
        L15:
            if (r0 > 0.7667d) goto L17;
            r9 = -r8;
            r1 = 1.76667f;
            goto L18
        L17:
            r9 = r8 * 0.4286f;
            r1 = 0.6714f;
            goto L18
        }
    }

    private void init() {
        this.viewWidth = measureWidth();
        this.viewHeight = measureHeight();
        float r1 = getResources().getDimension(2131169137);
        this.borderWidth = r1;
        this.radius = (this.viewWidth - (r1 * 2.0f)) / 2.0f;
        float r2 = r1 / 2.0f;
        float r3 = this.viewWidth;
        this.bordRectF = new RectF(r2, r2, r3 - r2, r3 - r2);
        this.combBitmap = BitmapFactory.decodeResource(getResources(), 2131250951);
        this.combBmRect = new Rect(0, 0, this.combBitmap.getWidth(), this.combBitmap.getHeight());
        float r4 = s1.f(11.0f);
        this.combDrawRectF = new RectF(r4, r4, this.viewWidth - r4, this.viewHeight - r4);
        this.mPaint = new Paint();
        TextPaint r5 = new TextPaint();
        this.textPaint = r5;
        r5.setAntiAlias(true);
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        this.textPaint.setColor(getResources().getColor(2131108310));
        this.textPaint.setTextSize(getResources().getDimension(2131169138));
        this.bordShader = new LinearGradient(0.0f, 0.0f, this.viewWidth, this.viewHeight, getResources().getColor(2131108304), getResources().getColor(2131108302), Shader.TileMode.CLAMP);
        this.viewShader = new LinearGradient(this.viewWidth, 0.0f, 0.0f, this.viewHeight, getResources().getColor(2131108308), getResources().getColor(2131108306), Shader.TileMode.CLAMP);
        this.bgColor = getResources().getColor(2131108301);
    }

    public void endScaleAnim() {
        ValueAnimator r0 = this.borderAnimator;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() == false) goto L9;
        this.borderAnimator.end();
        return;
    }

    public void release() {
        ValueAnimator r0 = this.borderAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
        this.borderAnimator.removeAllUpdateListeners();
        this.borderAnimator.removeAllListeners();
        this.borderAnimator = null;
        return;
    }

    private float measureHeight() {
        return getResources().getDimension(2131169139);
    }

    private float measureWidth() {
        return getResources().getDimension(2131169140);
    }

    public float getProgress() {
        return this.progress;
    }

    public SpecialCombView(Context r1) {
        super(r1);
        this.timeStr = "1s";
        this.progress = 0.0f;
        init();
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);
        this.mPaint.reset();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.bgColor);
        float r0 = this.viewWidth;
        r10.drawCircle(r0 / 2.0f, this.viewHeight / 2.0f, r0 / 2.0f, this.mPaint);
        this.mPaint.reset();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setShader(this.bordShader);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setStrokeWidth(this.borderWidth);
        r10.drawArc(this.bordRectF, PROGRESS_START_ANGLE, -this.progress, false, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setShader(this.viewShader);
        r10.drawCircle(this.viewWidth / 2.0f, this.viewHeight / 2.0f, this.radius, this.mPaint);
        r10.drawBitmap(this.combBitmap, this.combBmRect, this.combDrawRectF, this.mPaint);
    }

    public void setCountDownTime(int r1) {
        this.totalTimeCount = r1;
    }

    public void setProgress(float r2) {
        this.progress = r2;
        this.time = ((int) ((r2 / 360.0f) * this.totalTimeCount)) + 1;
        this.timeStr = String.valueOf(this.time) + "s";
        invalidate();
    }

    public SpecialCombView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.timeStr = "1s";
        this.progress = 0.0f;
        init();
    }

    private void animateBorderView(long r2, Animator.AnimatorListener r4) {
        if (this.borderAnimator != null) goto L9;
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.borderAnimator = r0;
        if (r4 == null) goto L7;
        r0.addListener(r4);
    L7:
        this.borderAnimator.addUpdateListener(new a(this));
        this.borderAnimator.setDuration(r2);
    L9:
        if (this.borderAnimator.isRunning() == false) goto L11;
        this.borderAnimator.cancel();
        setScaleX(1.0f);
        setScaleY(1.0f);
    L11:
        this.borderAnimator.start();
    }

    @Override // android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        setMeasuredDimension((int) measureWidth(), (int) measureHeight());
    }

    public void setCircleBackgroundColor(int r10, int r11) {
        this.viewShader = new LinearGradient(this.viewWidth, 0.0f, 0.0f, this.viewHeight, r10, r11, Shader.TileMode.CLAMP);
    }

    public void setProgressColor(int r10, int r11) {
        this.bordShader = new LinearGradient(0.0f, 0.0f, this.viewWidth, this.viewHeight, r10, r11, Shader.TileMode.CLAMP);
    }

    public void startScaleAnim(long r1, Animator.AnimatorListener r3) {
        animateBorderView(r1, r3);
    }

    public SpecialCombView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.timeStr = "1s";
        this.progress = 0.0f;
        init();
    }
}
