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

    public MotionTelltales(Context r5) {
        super(r5);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(r5, null);
    }

    private void init(Context r5, AttributeSet r10) {
        if (r10 == null) goto L16;
        TypedArray r11 = r5.obtainStyledAttributes(r10, R.styleable.MotionTelltales);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L15;
        int r14 = r11.getIndex(r13);
        if (r14 != R.styleable.MotionTelltales_telltales_tailColor) goto L9;
        this.mTailColor = r11.getColor(r14, this.mTailColor);
    L14:
        r13 = r13 + 1;
        goto L4
    L9:
        if (r14 != R.styleable.MotionTelltales_telltales_velocityMode) goto L12;
        this.mVelocityMode = r11.getInt(r14, this.mVelocityMode);
        goto L14
    L12:
        if (r14 != R.styleable.MotionTelltales_telltales_tailScale) goto L14;
        this.mTailScale = r11.getFloat(r14, this.mTailScale);
        goto L14
    L15:
        r11.recycle();
    L16:
        this.mPaintTelltales.setColor(this.mTailColor);
        this.mPaintTelltales.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas r24) {
        super.onDraw(r24);
        getMatrix().invert(this.mInvertMatrix);
        if (this.mMotionLayout != null) goto L8;
        ViewParent r5 = getParent();
        if ((r5 instanceof MotionLayout) == false) goto L17;
        this.mMotionLayout = (MotionLayout) r5;
        return;
    L17:
        return;
    L8:
        int r10 = getWidth();
        int r11 = getHeight();
        float[] r12 = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        int r13 = 0;
    L9:
        if (r13 >= 5) goto L14;
        float r14 = r12[r13];
        int r15 = 0;
    L11:
        if (r15 >= 5) goto L13;
        float r16 = r12[r15];
        this.mMotionLayout.getViewVelocity(this, r16, r14, this.velocity, this.mVelocityMode);
        this.mInvertMatrix.mapVectors(this.velocity);
        float r18 = r10 * r16;
        float r19 = r11 * r14;
        float[] r17 = this.velocity;
        float r20 = r17[0];
        float r21 = this.mTailScale;
        float r22 = r19 - (r17[1] * r21);
        this.mInvertMatrix.mapVectors(r17);
        r24.drawLine(r18, r19, r18 - (r20 * r21), r22, this.mPaintTelltales);
        r15 = r15 + 1;
        goto L11
    L13:
        r13 = r13 + 1;
        goto L9
    }

    @Override // android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        postInvalidate();
    }

    public void setText(CharSequence r5) {
        this.mText = r5.toString();
        requestLayout();
    }

    public MotionTelltales(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(r5, r10);
    }

    public MotionTelltales(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(r5, r10);
    }
}
