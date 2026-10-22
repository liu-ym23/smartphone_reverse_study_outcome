package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
class CircleImageView extends ImageView {
    private static final int FILL_SHADOW_COLOR = 1023410176;
    private static final int KEY_SHADOW_COLOR = 503316480;
    private static final int SHADOW_ELEVATION = 4;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 1.75f;
    private Animation.AnimationListener mListener;
    int mShadowRadius;

    public class OvalShadow extends OvalShape {
        private RadialGradient mRadialGradient;
        private Paint mShadowPaint;
        final /* synthetic */ CircleImageView this$0;

        public OvalShadow(CircleImageView r5, int r10) {
            this.this$0 = r5;
            this.mShadowPaint = new Paint();
            r5.mShadowRadius = r10;
            updateRadialGradient((int) rect().width());
        }

        private void updateRadialGradient(int r10) {
            float r5 = r10 / 2;
            RadialGradient r11 = new RadialGradient(r5, r5, this.this$0.mShadowRadius, new int[]{CircleImageView.FILL_SHADOW_COLOR, 0}, null, Shader.TileMode.CLAMP);
            this.mRadialGradient = r11;
            this.mShadowPaint.setShader(r11);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas r5, Paint r10) {
            int r11 = this.this$0.getWidth() / 2;
            float r12 = r11;
            float r13 = this.this$0.getHeight() / 2;
            r5.drawCircle(r12, r13, r12, this.mShadowPaint);
            r5.drawCircle(r12, r13, r11 - this.this$0.mShadowRadius, r10);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void onResize(float r5, float r10) {
            super.onResize(r5, r10);
            updateRadialGradient((int) r5);
        }
    }

    public CircleImageView(Context r10, int r11) {
        super(r10);
        float r12 = getContext().getResources().getDisplayMetrics().density;
        int r5 = (int) (Y_OFFSET * r12);
        int r13 = (int) (0.0f * r12);
        this.mShadowRadius = (int) (SHADOW_RADIUS * r12);
        if (elevationSupported() == false) goto L5;
        ShapeDrawable r14 = new ShapeDrawable(new OvalShape());
        ViewCompat.setElevation(this, r12 * 4.0f);
    L6:
        r14.getPaint().setColor(r11);
        ViewCompat.setBackground(this, r14);
        return;
    L5:
        ShapeDrawable r15 = new ShapeDrawable(new OvalShadow(this, this.mShadowRadius));
        setLayerType(1, r15.getPaint());
        r15.getPaint().setShadowLayer(this.mShadowRadius, r13, r5, KEY_SHADOW_COLOR);
        int r16 = this.mShadowRadius;
        setPadding(r16, r16, r16, r16);
        r14 = r15;
        goto L6
    }

    private boolean elevationSupported() {
        return true;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener r5 = this.mListener;
        if (r5 == null) goto L6;
        r5.onAnimationEnd(getAnimation());
        return;
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener r5 = this.mListener;
        if (r5 == null) goto L6;
        r5.onAnimationStart(getAnimation());
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        if (elevationSupported() == true) goto L6;
        int r11 = getMeasuredWidth();
        int r12 = (this.mShadowRadius * 2) + r11;
        int r13 = getMeasuredHeight();
        setMeasuredDimension(r12, (this.mShadowRadius * 2) + r13);
        return;
    }

    public void setAnimationListener(Animation.AnimationListener r5) {
        this.mListener = r5;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r5) {
        if ((getBackground() instanceof ShapeDrawable) == false) goto L6;
        ((ShapeDrawable) getBackground()).getPaint().setColor(r5);
        return;
    }

    public void setBackgroundColorRes(int r5) {
        setBackgroundColor(ContextCompat.getColor(getContext(), r5));
    }
}
