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
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

        OvalShadow(CircleImageView r2, int r3) {
            this.this$0 = r2;
            this.mShadowPaint = new Paint();
            r2.mShadowRadius = r3;
            updateRadialGradient((int) rect().width());
        }

        private void updateRadialGradient(int r9) {
            float r2 = r9 / 2;
            RadialGradient r7 = new RadialGradient(r2, r2, this.this$0.mShadowRadius, new int[]{CircleImageView.FILL_SHADOW_COLOR, 0}, null, Shader.TileMode.CLAMP);
            this.mRadialGradient = r7;
            this.mShadowPaint.setShader(r7);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas r5, Paint r6) {
            int r0 = this.this$0.getWidth() / 2;
            float r2 = r0;
            float r1 = this.this$0.getHeight() / 2;
            r5.drawCircle(r2, r1, r2, this.mShadowPaint);
            r5.drawCircle(r2, r1, r0 - this.this$0.mShadowRadius, r6);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void onResize(float r1, float r2) {
            super.onResize(r1, r2);
            updateRadialGradient((int) r1);
        }
    }

    CircleImageView(Context r6, int r7) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"));
        float r8 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics().density;
        int r0 = (int) (Y_OFFSET * r8);
        int r1 = (int) (0.0f * r8);
        this.mShadowRadius = (int) (SHADOW_RADIUS * r8);
        if (elevationSupported() == false) goto L5;
        ShapeDrawable r2 = new ShapeDrawable(new OvalShape());
        ViewCompat.setElevation(this, r8 * 4.0f);
    L6:
        r2.getPaint().setColor(r7);
        ViewCompat.setBackground(this, r2);
        return;
    L5:
        ShapeDrawable r3 = new ShapeDrawable(new OvalShadow(this, this.mShadowRadius));
        setLayerType(1, r3.getPaint());
        r3.getPaint().setShadowLayer(this.mShadowRadius, r1, r0, KEY_SHADOW_COLOR);
        int r9 = this.mShadowRadius;
        setPadding(r9, r9, r9, r9);
        r2 = r3;
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
        Animation.AnimationListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onAnimationEnd(getAnimation());
        return;
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onAnimationStart(getAnimation());
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        if (elevationSupported() == true) goto L6;
        setMeasuredDimension(getMeasuredWidth() + (this.mShadowRadius * 2), getMeasuredHeight() + (this.mShadowRadius * 2));
        return;
    }

    public void setAnimationListener(Animation.AnimationListener r3) {
        this.mListener = (Animation.AnimationListener) ZeusTransformUtils.wrapperContextForParams(r3, Animation.AnimationListener.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.View
    public void setBackgroundColor(int r3) {
        if (ZeusTransformUtils.instanceOf(getBackground(), ShapeDrawable.class) == false) goto L6;
        ((ShapeDrawable) ZeusTransformUtils.preCheckCast(getBackground(), ShapeDrawable.class, "com.obric.memorydata.plugin")).getPaint().setColor(r3);
        return;
    }

    public void setBackgroundColorRes(int r4) {
        setBackgroundColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }
}
