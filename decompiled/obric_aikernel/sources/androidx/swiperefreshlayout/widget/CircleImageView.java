package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
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

    private class OvalShadow extends OvalShape {
        private RadialGradient mRadialGradient;
        private Paint mShadowPaint;
        final /* synthetic */ CircleImageView this$0;

        OvalShadow(CircleImageView r10, int r11) {
            this.this$0 = r10;
            this.mShadowPaint = new Paint();
            r10.mShadowRadius = r11;
            updateRadialGradient((int) rect().width());
        }

        private void updateRadialGradient(int r10) {
            float r11 = r10 / 2;
            RadialGradient r12 = new RadialGradient(r11, r11, this.this$0.mShadowRadius, new int[]{CircleImageView.FILL_SHADOW_COLOR, 0}, null, Shader.TileMode.CLAMP);
            this.mRadialGradient = r12;
            this.mShadowPaint.setShader(r12);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas r10, Paint r11) {
            int r12 = this.this$0.getWidth() / 2;
            float r13 = r12;
            float r14 = this.this$0.getHeight() / 2;
            r10.drawCircle(r13, r14, r13, this.mShadowPaint);
            r10.drawCircle(r13, r14, r12 - this.this$0.mShadowRadius, r11);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float r10, float r11) {
            super.onResize(r10, r11);
            updateRadialGradient((int) r10);
        }
    }

    CircleImageView(Context r10, int r11) {
        super(r10);
        float r12 = getContext().getResources().getDisplayMetrics().density;
        int r13 = (int) (Y_OFFSET * r12);
        int r14 = (int) (0.0f * r12);
        this.mShadowRadius = (int) (SHADOW_RADIUS * r12);
        if (elevationSupported() == false) goto L5;
        ShapeDrawable r15 = new ShapeDrawable(new OvalShape());
        ViewCompat.setElevation(this, r12 * 4.0f);
    L6:
        r15.getPaint().setColor(r11);
        ViewCompat.setBackground(this, r15);
        return;
    L5:
        ShapeDrawable r16 = new ShapeDrawable(new OvalShadow(this, this.mShadowRadius));
        setLayerType(1, r16.getPaint());
        r16.getPaint().setShadowLayer(this.mShadowRadius, r14, r13, KEY_SHADOW_COLOR);
        int r17 = this.mShadowRadius;
        setPadding(r17, r17, r17, r17);
        r15 = r16;
        goto L6
    }

    private boolean elevationSupported() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener r10 = this.mListener;
        if (r10 == null) goto L6;
        r10.onAnimationEnd(getAnimation());
        return;
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener r10 = this.mListener;
        if (r10 == null) goto L6;
        r10.onAnimationStart(getAnimation());
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if (elevationSupported() == true) goto L6;
        setMeasuredDimension(getMeasuredWidth() + (this.mShadowRadius * 2), getMeasuredHeight() + (this.mShadowRadius * 2));
        return;
    }

    public void setAnimationListener(Animation.AnimationListener r10) {
        this.mListener = r10;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r10) {
        if ((getBackground() instanceof ShapeDrawable) == false) goto L6;
        ((ShapeDrawable) getBackground()).getPaint().setColor(r10);
        return;
    }

    public void setBackgroundColorRes(int r10) {
        setBackgroundColor(ContextCompat.getColor(getContext(), r10));
    }
}
