package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {
    private Drawable mAltDrawable;
    private float mCrossfade;
    private Drawable mDrawable;
    private ImageMatrix mImageMatrix;
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay;
    float mPanX;
    float mPanY;
    private Path mPath;
    RectF mRect;
    float mRotate;
    private float mRound;
    private float mRoundPercent;
    ViewOutlineProvider mViewOutlineProvider;
    float mZoom;

    static class ImageMatrix {
        float[] m;
        float mBrightness;
        ColorMatrix mColorMatrix;
        float mContrast;
        float mSaturation;
        ColorMatrix mTmpColorMatrix;
        float mWarmth;

        ImageMatrix() {
            this.m = new float[20];
            this.mColorMatrix = new ColorMatrix();
            this.mTmpColorMatrix = new ColorMatrix();
            this.mBrightness = 1.0f;
            this.mSaturation = 1.0f;
            this.mContrast = 1.0f;
            this.mWarmth = 1.0f;
        }

        private void brightness(float r3) {
            float[] r2 = this.m;
            r2[0] = r3;
            r2[1] = 0.0f;
            r2[2] = 0.0f;
            r2[3] = 0.0f;
            r2[4] = 0.0f;
            r2[5] = 0.0f;
            r2[6] = r3;
            r2[7] = 0.0f;
            r2[8] = 0.0f;
            r2[9] = 0.0f;
            r2[10] = 0.0f;
            r2[11] = 0.0f;
            r2[12] = r3;
            r2[13] = 0.0f;
            r2[14] = 0.0f;
            r2[15] = 0.0f;
            r2[16] = 0.0f;
            r2[17] = 0.0f;
            r2[18] = 1.0f;
            r2[19] = 0.0f;
        }

        private void saturation(float r8) {
            float r1 = 1.0f - r8;
            float r2 = 0.2999f * r1;
            float r3 = 0.587f * r1;
            float r4 = r1 * 0.114f;
            float[] r7 = this.m;
            r7[0] = r2 + r8;
            r7[1] = r3;
            r7[2] = r4;
            r7[3] = 0.0f;
            r7[4] = 0.0f;
            r7[5] = r2;
            r7[6] = r3 + r8;
            r7[7] = r4;
            r7[8] = 0.0f;
            r7[9] = 0.0f;
            r7[10] = r2;
            r7[11] = r3;
            r7[12] = r4 + r8;
            r7[13] = 0.0f;
            r7[14] = 0.0f;
            r7[15] = 0.0f;
            r7[16] = 0.0f;
            r7[17] = 0.0f;
            r7[18] = 1.0f;
            r7[19] = 0.0f;
        }

        private void warmth(float r12) {
            if (r12 > 0.0f) goto L5;
            r12 = 0.01f;
        L5:
            float r1 = (5000.0f / r12) / 100.0f;
            if (r1 <= 66.0f) goto L8;
            double r7 = r1 - 60.0f;
            float r2 = ((float) Math.pow(r7, -0.13320475816726685d)) * 329.69873f;
            float r8 = ((float) Math.pow(r7, 0.07551484555006027d)) * 288.12216f;
        L10:
            if (r1 < 66.0f) goto L12;
            float r13 = 255.0f;
        L16:
            float r3 = Math.min(255.0f, Math.max(r2, 0.0f));
            float r4 = Math.min(255.0f, Math.max(r8, 0.0f));
            float r14 = Math.min(255.0f, Math.max(r13, 0.0f));
            float r9 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float r5 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float r6 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float r10 = Math.min(255.0f, Math.max(r9, 0.0f));
            float r15 = r14 / Math.min(255.0f, Math.max(r5, 0.0f));
            float[] r11 = this.m;
            r11[0] = r3 / r6;
            r11[1] = 0.0f;
            r11[2] = 0.0f;
            r11[3] = 0.0f;
            r11[4] = 0.0f;
            r11[5] = 0.0f;
            r11[6] = r4 / r10;
            r11[7] = 0.0f;
            r11[8] = 0.0f;
            r11[9] = 0.0f;
            r11[10] = 0.0f;
            r11[11] = 0.0f;
            r11[12] = r15;
            r11[13] = 0.0f;
            r11[14] = 0.0f;
            r11[15] = 0.0f;
            r11[16] = 0.0f;
            r11[17] = 0.0f;
            r11[18] = 1.0f;
            r11[19] = 0.0f;
            return;
        L12:
            if (r1 <= 19.0f) goto L14;
            r13 = (((float) Math.log(r1 - 10.0f)) * 138.51773f) - 305.0448f;
            goto L16
        L14:
            r13 = 0.0f;
            goto L16
        L8:
            r8 = (((float) Math.log(r1)) * 99.4708f) - 161.11957f;
            r2 = 255.0f;
            goto L10
        }

        void updateMatrix(ImageView r6) {
            this.mColorMatrix.reset();
            float r0 = this.mSaturation;
            boolean r3 = true;
            if (r0 == 1.0f) goto L5;
            saturation(r0);
            this.mColorMatrix.set(this.m);
            boolean r1 = true;
        L6:
            float r2 = this.mContrast;
            if (r2 == 1.0f) goto L9;
            this.mTmpColorMatrix.setScale(r2, r2, r2, 1.0f);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            r1 = true;
        L9:
            float r4 = this.mWarmth;
            if (r4 == 1.0f) goto L12;
            warmth(r4);
            this.mTmpColorMatrix.set(this.m);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            r1 = true;
        L12:
            float r5 = this.mBrightness;
            if (r5 == 1.0f) goto L15;
            brightness(r5);
            this.mTmpColorMatrix.set(this.m);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
        L16:
            if (r3 == false) goto L18;
            r6.setColorFilter(new ColorMatrixColorFilter(this.mColorMatrix));
            return;
        L18:
            r6.clearColorFilter();
            return;
        L15:
            r3 = r1;
            goto L16
        L5:
            r1 = false;
            goto L6
        }
    }

    public ImageFilterView(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        super(r5);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r5, null);
    }

    public ImageFilterView(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r5, r6);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r5, r6);
    }

    public ImageFilterView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r6, r7);
    }

    static /* synthetic */ float access$000(ImageFilterView r0) {
        return r0.mRoundPercent;
    }

    static /* synthetic */ float access$100(ImageFilterView r0) {
        return r0.mRound;
    }

    private void init(Context r9, AttributeSet r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L74;
        TypedArray r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r12, R.styleable.ImageFilterView);
        int r14 = r13.getIndexCount();
        this.mAltDrawable = r13.getDrawable(ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_altSrc, "styleable", "ImageFilterView_altSrc"));
        int r2 = 0;
    L5:
        if (r2 >= r14) goto L47;
        int r3 = r13.getIndex(r2);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_crossfade, "styleable", "ImageFilterView_crossfade")) goto L10;
        this.mCrossfade = r13.getFloat(r3, 0.0f);
    L46:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_warmth, "styleable", "ImageFilterView_warmth")) goto L13;
        setWarmth(r13.getFloat(r3, 0.0f));
        goto L46
    L13:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_saturation, "styleable", "ImageFilterView_saturation")) goto L16;
        setSaturation(r13.getFloat(r3, 0.0f));
        goto L46
    L16:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_contrast, "styleable", "ImageFilterView_contrast")) goto L19;
        setContrast(r13.getFloat(r3, 0.0f));
        goto L46
    L19:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_brightness, "styleable", "ImageFilterView_brightness")) goto L22;
        setBrightness(r13.getFloat(r3, 0.0f));
        goto L46
    L22:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_round, "styleable", "ImageFilterView_round")) goto L27;
        if (Build.VERSION.SDK_INT < 21) goto L46;
        setRound(r13.getDimension(r3, 0.0f));
        goto L46
    L27:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_roundPercent, "styleable", "ImageFilterView_roundPercent")) goto L32;
        if (Build.VERSION.SDK_INT < 21) goto L46;
        setRoundPercent(r13.getFloat(r3, 0.0f));
        goto L46
    L32:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_overlay, "styleable", "ImageFilterView_overlay")) goto L35;
        setOverlay(r13.getBoolean(r3, this.mOverlay));
        goto L46
    L35:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_imagePanX, "styleable", "ImageFilterView_imagePanX")) goto L38;
        setImagePanX(r13.getFloat(r3, this.mPanX));
        goto L46
    L38:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_imagePanY, "styleable", "ImageFilterView_imagePanY")) goto L41;
        setImagePanY(r13.getFloat(r3, this.mPanY));
        goto L46
    L41:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_imageRotate, "styleable", "ImageFilterView_imageRotate")) goto L44;
        setImageRotate(r13.getFloat(r3, this.mRotate));
        goto L46
    L44:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_imageZoom, "styleable", "ImageFilterView_imageZoom")) goto L46;
        setImageZoom(r13.getFloat(r3, this.mZoom));
        goto L46
    L47:
        r13.recycle();
        Drawable r15 = getDrawable();
        this.mDrawable = r15;
        if (this.mAltDrawable == null) goto L54;
        if (r15 == null) goto L54;
        Drawable[] r16 = this.mLayers;
        Drawable r17 = getDrawable().mutate();
        this.mDrawable = r17;
        r16[0] = r17;
        this.mLayers[1] = this.mAltDrawable.mutate();
        LayerDrawable r18 = new LayerDrawable(this.mLayers);
        this.mLayer = r18;
        r18.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
        if (this.mOverlay == true) goto L53;
        this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
    L53:
        super.setImageDrawable(this.mLayer);
        return;
    L54:
        Drawable r19 = getDrawable();
        this.mDrawable = r19;
        if (r19 == null) goto L76;
        Drawable[] r110 = this.mLayers;
        Drawable r20 = r19.mutate();
        this.mDrawable = r20;
        r110[0] = r20;
        return;
    L76:
        return;
    }

    private void setMatrix() {
        if (Float.isNaN(this.mPanX) == true) goto L5;
    L11:
        float r1 = 0.0f;
        if (Float.isNaN(this.mPanX) == false) goto L14;
        float r0 = 0.0f;
    L16:
        if (Float.isNaN(this.mPanY) == false) goto L18;
        float r2 = 0.0f;
    L20:
        if (Float.isNaN(this.mZoom) == false) goto L22;
        float r3 = 1.0f;
    L24:
        if (Float.isNaN(this.mRotate) == true) goto L27;
        r1 = this.mRotate;
    L27:
        Matrix r4 = new Matrix();
        r4.reset();
        float r5 = getDrawable().getIntrinsicWidth();
        float r6 = getDrawable().getIntrinsicHeight();
        float r7 = getWidth();
        float r8 = getHeight();
        if ((r5 * r8) >= (r6 * r7)) goto L30;
        float r9 = r7 / r5;
    L31:
        float r10 = r3 * r9;
        r4.postScale(r10, r10);
        float r11 = r5 * r10;
        float r12 = r10 * r6;
        r4.postTranslate((((r0 * (r7 - r11)) + r7) - r11) * 0.5f, (((r2 * (r8 - r12)) + r8) - r12) * 0.5f);
        r4.postRotate(r1, r7 / 2.0f, r8 / 2.0f);
        setImageMatrix(r4);
        setScaleType(ImageView.ScaleType.MATRIX);
        return;
    L30:
        r9 = r8 / r6;
        goto L31
    L22:
        r3 = this.mZoom;
        goto L24
    L18:
        r2 = this.mPanY;
        goto L20
    L14:
        r0 = this.mPanX;
        goto L16
    L5:
        if (Float.isNaN(this.mPanY) == false) goto L11;
        if (Float.isNaN(this.mZoom) == false) goto L11;
        if (Float.isNaN(this.mRotate) == false) goto L11;
    }

    private void setOverlay(boolean r1) {
        this.mOverlay = r1;
    }

    private void updateViewMatrix() {
        if (Float.isNaN(this.mPanX) == true) goto L5;
    L12:
        setMatrix();
        return;
    L5:
        if (Float.isNaN(this.mPanY) == false) goto L12;
        if (Float.isNaN(this.mZoom) == false) goto L12;
        if (Float.isNaN(this.mRotate) == false) goto L12;
        setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    @Override // android.view.View
    public void draw(Canvas r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
    L9:
        boolean r0 = false;
    L10:
        super.draw(r3);
        if (r0 == false) goto L14;
        r3.restore();
        return;
    L14:
        return;
    L5:
        if (this.mRoundPercent == 0.0f) goto L9;
        if (this.mPath == null) goto L9;
        r0 = true;
        r3.save();
        r3.clipPath(this.mPath);
        goto L10
    }

    public float getBrightness() {
        return this.mImageMatrix.mBrightness;
    }

    public float getContrast() {
        return this.mImageMatrix.mContrast;
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public float getImagePanX() {
        return this.mPanX;
    }

    public float getImagePanY() {
        return this.mPanY;
    }

    public float getImageRotate() {
        return this.mRotate;
    }

    public float getImageZoom() {
        return this.mZoom;
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getSaturation() {
        return this.mImageMatrix.mSaturation;
    }

    public float getWarmth() {
        return this.mImageMatrix.mWarmth;
    }

    @Override // android.view.View
    public void layout(int r1, int r2, int r3, int r4) {
        super.layout(r1, r2, r3, r4);
        setMatrix();
    }

    public void setAltImageResource(int r4) {
        Drawable r5 = AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4).mutate();
        this.mAltDrawable = r5;
        Drawable[] r0 = this.mLayers;
        r0[0] = this.mDrawable;
        r0[1] = r5;
        LayerDrawable r6 = new LayerDrawable(this.mLayers);
        this.mLayer = r6;
        super.setImageDrawable(r6);
        setCrossfade(this.mCrossfade);
    }

    public void setBrightness(float r2) {
        this.mImageMatrix.mBrightness = r2;
        this.mImageMatrix.updateMatrix(this);
    }

    public void setContrast(float r2) {
        this.mImageMatrix.mContrast = r2;
        this.mImageMatrix.updateMatrix(this);
    }

    public void setCrossfade(float r4) {
        this.mCrossfade = r4;
        if (this.mLayers != null) goto L5;
        return;
    L5:
        if (this.mOverlay == true) goto L7;
        this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
    L7:
        this.mLayer.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
        super.setImageDrawable(this.mLayer);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r3) {
        if (this.mAltDrawable == null) goto L6;
        if (r3 == null) goto L6;
        Drawable r4 = r3.mutate();
        this.mDrawable = r4;
        Drawable[] r0 = this.mLayers;
        r0[0] = r4;
        r0[1] = this.mAltDrawable;
        LayerDrawable r5 = new LayerDrawable(this.mLayers);
        this.mLayer = r5;
        super.setImageDrawable(r5);
        setCrossfade(this.mCrossfade);
        return;
    L6:
        super.setImageDrawable(r3);
    }

    public void setImagePanX(float r1) {
        this.mPanX = r1;
        updateViewMatrix();
    }

    public void setImagePanY(float r1) {
        this.mPanY = r1;
        updateViewMatrix();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r4) {
        if (this.mAltDrawable == null) goto L5;
        Drawable r5 = AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4).mutate();
        this.mDrawable = r5;
        Drawable[] r0 = this.mLayers;
        r0[0] = r5;
        r0[1] = this.mAltDrawable;
        LayerDrawable r6 = new LayerDrawable(this.mLayers);
        this.mLayer = r6;
        super.setImageDrawable(r6);
        setCrossfade(this.mCrossfade);
        return;
    L5:
        super.setImageResource(r4);
    }

    public void setImageRotate(float r1) {
        this.mRotate = r1;
        updateViewMatrix();
    }

    public void setImageZoom(float r1) {
        this.mZoom = r1;
        updateViewMatrix();
    }

    public void setRound(float r6) {
        if (Float.isNaN(r6) == false) goto L7;
        this.mRound = r6;
        float r7 = this.mRoundPercent;
        this.mRoundPercent = -1.0f;
        setRoundPercent(r7);
        return;
    L7:
        if (this.mRound == r6) goto L9;
        boolean r0 = true;
    L10:
        this.mRound = r6;
        if (r6 == 0.0f) goto L26;
        if (this.mPath != null) goto L16;
        this.mPath = new Path();
    L16:
        if (this.mRect != null) goto L19;
        this.mRect = new RectF();
    L19:
        if (Build.VERSION.SDK_INT >= 21) goto L21;
    L24:
        this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.mPath.reset();
        Path r8 = this.mPath;
        RectF r1 = this.mRect;
        float r2 = this.mRound;
        r8.addRoundRect(r1, r2, r2, Path.Direction.CW);
    L28:
        if (r0 == true) goto L30;
        return;
    L30:
        if (Build.VERSION.SDK_INT < 21) goto L34;
        invalidateOutline();
        return;
    L34:
        return;
    L21:
        if (this.mViewOutlineProvider != null) goto L23;
        ViewOutlineProvider r9 = new AnonymousClass2(this);
        this.mViewOutlineProvider = r9;
        setOutlineProvider(r9);
    L23:
        setClipToOutline(true);
        goto L24
    L26:
        if (Build.VERSION.SDK_INT < 21) goto L28;
        setClipToOutline(false);
        goto L28
    L9:
        r0 = false;
        goto L10
    }

    public void setRoundPercent(float r7) {
        if (this.mRoundPercent == r7) goto L5;
        boolean r0 = true;
    L6:
        this.mRoundPercent = r7;
        if (r7 == 0.0f) goto L22;
        if (this.mPath != null) goto L12;
        this.mPath = new Path();
    L12:
        if (this.mRect != null) goto L15;
        this.mRect = new RectF();
    L15:
        if (Build.VERSION.SDK_INT >= 21) goto L17;
    L20:
        int r8 = getWidth();
        int r1 = getHeight();
        float r2 = (Math.min(r8, r1) * this.mRoundPercent) / 2.0f;
        this.mRect.set(0.0f, 0.0f, r8, r1);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, r2, r2, Path.Direction.CW);
    L24:
        if (r0 == true) goto L26;
        return;
    L26:
        if (Build.VERSION.SDK_INT < 21) goto L30;
        invalidateOutline();
        return;
    L30:
        return;
    L17:
        if (this.mViewOutlineProvider != null) goto L19;
        ViewOutlineProvider r9 = new AnonymousClass1(this);
        this.mViewOutlineProvider = r9;
        setOutlineProvider(r9);
    L19:
        setClipToOutline(true);
        goto L20
    L22:
        if (Build.VERSION.SDK_INT < 21) goto L24;
        setClipToOutline(false);
        goto L24
    L5:
        r0 = false;
        goto L6
    }

    public void setSaturation(float r2) {
        this.mImageMatrix.mSaturation = r2;
        this.mImageMatrix.updateMatrix(this);
    }

    public void setWarmth(float r2) {
        this.mImageMatrix.mWarmth = r2;
        this.mImageMatrix.updateMatrix(this);
    }
}
