package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

    public MotionTelltales(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r4);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(r4, null);
    }

    public MotionTelltales(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r5, r6);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(r5, r6);
    }

    public MotionTelltales(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(r6, r7);
    }

    private void init(Context r6, AttributeSet r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L17;
        TypedArray r10 = r8.obtainStyledAttributes(r9, R.styleable.MotionTelltales);
        int r11 = r10.getIndexCount();
        int r0 = 0;
    L5:
        if (r0 >= r11) goto L16;
        int r1 = r10.getIndex(r0);
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.MotionTelltales_telltales_tailColor, "styleable", "MotionTelltales_telltales_tailColor")) goto L10;
        this.mTailColor = r10.getColor(r1, this.mTailColor);
    L15:
        r0 = r0 + 1;
        goto L5
    L10:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.MotionTelltales_telltales_velocityMode, "styleable", "MotionTelltales_telltales_velocityMode")) goto L13;
        this.mVelocityMode = r10.getInt(r1, this.mVelocityMode);
        goto L15
    L13:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.MotionTelltales_telltales_tailScale, "styleable", "MotionTelltales_telltales_tailScale")) goto L15;
        this.mTailScale = r10.getFloat(r1, this.mTailScale);
        goto L15
    L16:
        r10.recycle();
    L17:
        this.mPaintTelltales.setColor(this.mTailColor);
        this.mPaintTelltales.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas r23) {
        super.onDraw(r23);
        getMatrix().invert(this.mInvertMatrix);
        if (this.mMotionLayout != null) goto L8;
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, MotionLayout.class) == false) goto L17;
        this.mMotionLayout = (MotionLayout) ZeusTransformUtils.preCheckCast(r0, MotionLayout.class, "com.obric.memorydata.plugin");
        return;
    L17:
        return;
    L8:
        int r7 = getWidth();
        int r8 = getHeight();
        float[] r10 = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        int r12 = 0;
    L9:
        if (r12 >= 5) goto L14;
        float r13 = r10[r12];
        int r14 = 0;
    L11:
        if (r14 >= 5) goto L13;
        float r15 = r10[r14];
        this.mMotionLayout.getViewVelocity(this, r15, r13, this.velocity, this.mVelocityMode);
        this.mInvertMatrix.mapVectors(this.velocity);
        float r17 = r7 * r15;
        float r18 = r8 * r13;
        float[] r1 = this.velocity;
        float r2 = r1[0];
        float r3 = this.mTailScale;
        float r20 = r18 - (r1[1] * r3);
        this.mInvertMatrix.mapVectors(r1);
        r23.drawLine(r17, r18, r17 - (r2 * r3), r20, this.mPaintTelltales);
        r14 = r14 + 1;
        goto L11
    L13:
        r12 = r12 + 1;
        goto L9
    }

    @Override // android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        postInvalidate();
    }

    public void setText(CharSequence r3) {
        this.mText = ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        requestLayout();
    }
}
