package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class MotionTelltales extends MockView {
    private static final String TAG = "MotionTelltales";
    Matrix mInvertMatrix;
    MotionLayout mMotionLayout;
    private Paint mPaintTelltales;
    int mTailColor;
    float mTailScale;
    int mVelocityMode;
    float[] velocity;

    public MotionTelltales(Context r10) {
        super(r10);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(r10, null);
    }

    public MotionTelltales(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(r10, r11);
    }

    public MotionTelltales(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(r10, r11);
    }

    private void init(Context r10, AttributeSet r11) {
        if (r11 == null) goto L16;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.MotionTelltales);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L15;
        int r15 = r12.getIndex(r14);
        if (r15 != R.styleable.MotionTelltales_telltales_tailColor) goto L9;
        this.mTailColor = r12.getColor(r15, this.mTailColor);
    L14:
        r14 = r14 + 1;
        goto L4
    L9:
        if (r15 != R.styleable.MotionTelltales_telltales_velocityMode) goto L12;
        this.mVelocityMode = r12.getInt(r15, this.mVelocityMode);
        goto L14
    L12:
        if (r15 != R.styleable.MotionTelltales_telltales_tailScale) goto L14;
        this.mTailScale = r12.getFloat(r15, this.mTailScale);
        goto L14
    L15:
        r12.recycle();
    L16:
        this.mPaintTelltales.setColor(this.mTailColor);
        this.mPaintTelltales.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas r23) {
        super.onDraw(r23);
        getMatrix().invert(this.mInvertMatrix);
        if (this.mMotionLayout != null) goto L8;
        ViewParent r10 = getParent();
        if ((r10 instanceof MotionLayout) == false) goto L17;
        this.mMotionLayout = (MotionLayout) r10;
        return;
    L17:
        return;
    L8:
        int r11 = getWidth();
        int r12 = getHeight();
        float[] r13 = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        int r14 = 0;
    L9:
        if (r14 >= 5) goto L14;
        float r15 = r13[r14];
        int r16 = 0;
    L11:
        if (r16 >= 5) goto L13;
        float r17 = r13[r16];
        this.mMotionLayout.getViewVelocity(this, r17, r15, this.velocity, this.mVelocityMode);
        this.mInvertMatrix.mapVectors(this.velocity);
        float r18 = r11 * r17;
        float r19 = r12 * r15;
        float[] r20 = this.velocity;
        float r21 = r20[0];
        float r22 = this.mTailScale;
        float r24 = r19 - (r20[1] * r22);
        this.mInvertMatrix.mapVectors(r20);
        r23.drawLine(r18, r19, r18 - (r21 * r22), r24, this.mPaintTelltales);
        r16 = r16 + 1;
        goto L11
    L13:
        r14 = r14 + 1;
        goto L9
    }

    @Override // android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        postInvalidate();
    }

    public void setText(CharSequence r10) {
        this.mText = r10.toString();
        requestLayout();
    }
}
