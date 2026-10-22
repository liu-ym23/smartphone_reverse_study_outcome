package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {
    private float mCrossfade;
    private ImageMatrix mImageMatrix;
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay;
    private Path mPath;
    RectF mRect;
    private float mRound;
    private float mRoundPercent;
    ViewOutlineProvider mViewOutlineProvider;

    public static class ImageMatrix {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        float[] f441m;
        float mBrightness;
        ColorMatrix mColorMatrix;
        float mContrast;
        float mSaturation;
        ColorMatrix mTmpColorMatrix;
        float mWarmth;

        public ImageMatrix() {
            this.f441m = new float[20];
            this.mColorMatrix = new ColorMatrix();
            this.mTmpColorMatrix = new ColorMatrix();
            this.mBrightness = 1.0f;
            this.mSaturation = 1.0f;
            this.mContrast = 1.0f;
            this.mWarmth = 1.0f;
        }

        private void brightness(float r5) {
            float[] r10 = this.f441m;
            r10[0] = r5;
            r10[1] = 0.0f;
            r10[2] = 0.0f;
            r10[3] = 0.0f;
            r10[4] = 0.0f;
            r10[5] = 0.0f;
            r10[6] = r5;
            r10[7] = 0.0f;
            r10[8] = 0.0f;
            r10[9] = 0.0f;
            r10[10] = 0.0f;
            r10[11] = 0.0f;
            r10[12] = r5;
            r10[13] = 0.0f;
            r10[14] = 0.0f;
            r10[15] = 0.0f;
            r10[16] = 0.0f;
            r10[17] = 0.0f;
            r10[18] = 1.0f;
            r10[19] = 0.0f;
        }

        private void saturation(float r10) {
            float r5 = 1.0f - r10;
            float r11 = 0.2999f * r5;
            float r12 = 0.587f * r5;
            float r13 = r5 * 0.114f;
            float[] r14 = this.f441m;
            r14[0] = r11 + r10;
            r14[1] = r12;
            r14[2] = r13;
            r14[3] = 0.0f;
            r14[4] = 0.0f;
            r14[5] = r11;
            r14[6] = r12 + r10;
            r14[7] = r13;
            r14[8] = 0.0f;
            r14[9] = 0.0f;
            r14[10] = r11;
            r14[11] = r12;
            r14[12] = r13 + r10;
            r14[13] = 0.0f;
            r14[14] = 0.0f;
            r14[15] = 0.0f;
            r14[16] = 0.0f;
            r14[17] = 0.0f;
            r14[18] = 1.0f;
            r14[19] = 0.0f;
        }

        private void warmth(float r12) {
            if (r12 > 0.0f) goto L5;
            r12 = 0.01f;
        L5:
            float r5 = (5000.0f / r12) / 100.0f;
            if (r5 <= 66.0f) goto L8;
            double r10 = r5 - 60.0f;
            float r11 = ((float) Math.pow(r10, -0.13320475816726685d)) * 329.69873f;
            float r13 = ((float) Math.pow(r10, 0.07551484555006027d)) * 288.12216f;
        L10:
            if (r5 < 66.0f) goto L12;
            float r14 = 255.0f;
        L16:
            float r15 = Math.min(255.0f, Math.max(r11, 0.0f));
            float r16 = Math.min(255.0f, Math.max(r13, 0.0f));
            float r17 = Math.min(255.0f, Math.max(r14, 0.0f));
            float r18 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float r19 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float r20 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float r21 = Math.min(255.0f, Math.max(r18, 0.0f));
            float r110 = r17 / Math.min(255.0f, Math.max(r19, 0.0f));
            float[] r111 = this.f441m;
            r111[0] = r15 / r20;
            r111[1] = 0.0f;
            r111[2] = 0.0f;
            r111[3] = 0.0f;
            r111[4] = 0.0f;
            r111[5] = 0.0f;
            r111[6] = r16 / r21;
            r111[7] = 0.0f;
            r111[8] = 0.0f;
            r111[9] = 0.0f;
            r111[10] = 0.0f;
            r111[11] = 0.0f;
            r111[12] = r110;
            r111[13] = 0.0f;
            r111[14] = 0.0f;
            r111[15] = 0.0f;
            r111[16] = 0.0f;
            r111[17] = 0.0f;
            r111[18] = 1.0f;
            r111[19] = 0.0f;
            return;
        L12:
            if (r5 <= 19.0f) goto L14;
            r14 = (((float) Math.log(r5 - 10.0f)) * 138.51773f) - 305.0448f;
            goto L16
        L14:
            r14 = 0.0f;
            goto L16
        L8:
            r13 = (((float) Math.log(r5)) * 99.4708f) - 161.11957f;
            r11 = 255.0f;
            goto L10
        }

        public void updateMatrix(ImageView r10) {
            this.mColorMatrix.reset();
            float r5 = this.mSaturation;
            boolean r11 = true;
            if (r5 == 1.0f) goto L5;
            saturation(r5);
            this.mColorMatrix.set(this.f441m);
            boolean r12 = true;
        L6:
            float r13 = this.mContrast;
            if (r13 == 1.0f) goto L9;
            this.mTmpColorMatrix.setScale(r13, r13, r13, 1.0f);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            r12 = true;
        L9:
            float r14 = this.mWarmth;
            if (r14 == 1.0f) goto L12;
            warmth(r14);
            this.mTmpColorMatrix.set(this.f441m);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            r12 = true;
        L12:
            float r15 = this.mBrightness;
            if (r15 == 1.0f) goto L15;
            brightness(r15);
            this.mTmpColorMatrix.set(this.f441m);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
        L16:
            if (r11 == false) goto L18;
            r10.setColorFilter(new ColorMatrixColorFilter(this.mColorMatrix));
            return;
        L18:
            r10.clearColorFilter();
            return;
        L15:
            r11 = r12;
            goto L16
        L5:
            r12 = false;
            goto L6
        }
    }

    public ImageFilterView(Context r5) {
        super(r5);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(r5, null);
    }

    public static /* synthetic */ float access$000(ImageFilterView r5) {
        return r5.mRoundPercent;
    }

    public static /* synthetic */ float access$100(ImageFilterView r5) {
        return r5.mRound;
    }

    private void init(Context r10, AttributeSet r11) {
        if (r11 == null) goto L40;
        TypedArray r12 = getContext().obtainStyledAttributes(r11, R.styleable.ImageFilterView);
        int r13 = r12.getIndexCount();
        Drawable r5 = r12.getDrawable(R.styleable.ImageFilterView_altSrc);
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L27;
        int r15 = r12.getIndex(r14);
        if (r15 != R.styleable.ImageFilterView_crossfade) goto L9;
        this.mCrossfade = r12.getFloat(r15, 0.0f);
    L26:
        r14 = r14 + 1;
        goto L4
    L9:
        if (r15 != R.styleable.ImageFilterView_warmth) goto L12;
        setWarmth(r12.getFloat(r15, 0.0f));
        goto L26
    L12:
        if (r15 != R.styleable.ImageFilterView_saturation) goto L15;
        setSaturation(r12.getFloat(r15, 0.0f));
        goto L26
    L15:
        if (r15 != R.styleable.ImageFilterView_contrast) goto L18;
        setContrast(r12.getFloat(r15, 0.0f));
        goto L26
    L18:
        if (r15 != R.styleable.ImageFilterView_round) goto L21;
        setRound(r12.getDimension(r15, 0.0f));
        goto L26
    L21:
        if (r15 != R.styleable.ImageFilterView_roundPercent) goto L24;
        setRoundPercent(r12.getFloat(r15, 0.0f));
        goto L26
    L24:
        if (r15 != R.styleable.ImageFilterView_overlay) goto L26;
        setOverlay(r12.getBoolean(r15, this.mOverlay));
        goto L26
    L27:
        r12.recycle();
        if (r5 == null) goto L41;
        Drawable[] r16 = new Drawable[2];
        this.mLayers = r16;
        r16[0] = getDrawable();
        this.mLayers[1] = r5;
        LayerDrawable r17 = new LayerDrawable(this.mLayers);
        this.mLayer = r17;
        r17.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
        super.setImageDrawable(this.mLayer);
        return;
    L41:
        return;
    }

    private void setOverlay(boolean r5) {
        this.mOverlay = r5;
    }

    @Override // android.view.View
    public void draw(Canvas r5) {
        super.draw(r5);
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

    public void setBrightness(float r5) {
        ImageMatrix r10 = this.mImageMatrix;
        r10.mBrightness = r5;
        r10.updateMatrix(this);
    }

    public void setContrast(float r5) {
        ImageMatrix r10 = this.mImageMatrix;
        r10.mContrast = r5;
        r10.updateMatrix(this);
    }

    public void setCrossfade(float r5) {
        this.mCrossfade = r5;
        if (this.mLayers != null) goto L5;
        return;
    L5:
        if (this.mOverlay == true) goto L7;
        this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
    L7:
        this.mLayer.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
        super.setImageDrawable(this.mLayer);
    }

    @RequiresApi(21)
    public void setRound(float r5) {
        if (Float.isNaN(r5) == false) goto L7;
        this.mRound = r5;
        float r10 = this.mRoundPercent;
        this.mRoundPercent = -1.0f;
        setRoundPercent(r10);
        return;
    L7:
        if (this.mRound == r5) goto L9;
        boolean r11 = true;
    L10:
        this.mRound = r5;
        if (r5 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r11 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.mPath != null) goto L16;
        this.mPath = new Path();
    L16:
        if (this.mRect != null) goto L19;
        this.mRect = new RectF();
    L19:
        if (this.mViewOutlineProvider != null) goto L21;
        ViewOutlineProvider r12 = new AnonymousClass2(this);
        this.mViewOutlineProvider = r12;
        setOutlineProvider(r12);
    L21:
        setClipToOutline(true);
        this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.mPath.reset();
        Path r13 = this.mPath;
        RectF r14 = this.mRect;
        float r15 = this.mRound;
        r13.addRoundRect(r14, r15, r15, Path.Direction.CW);
        goto L23
    L9:
        r11 = false;
        goto L10
    }

    @RequiresApi(21)
    public void setRoundPercent(float r10) {
        if (this.mRoundPercent == r10) goto L5;
        boolean r5 = true;
    L6:
        this.mRoundPercent = r10;
        if (r10 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r5 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.mPath != null) goto L12;
        this.mPath = new Path();
    L12:
        if (this.mRect != null) goto L15;
        this.mRect = new RectF();
    L15:
        if (this.mViewOutlineProvider != null) goto L17;
        ViewOutlineProvider r11 = new AnonymousClass1(this);
        this.mViewOutlineProvider = r11;
        setOutlineProvider(r11);
    L17:
        setClipToOutline(true);
        int r12 = getWidth();
        int r13 = getHeight();
        float r14 = (Math.min(r12, r13) * this.mRoundPercent) / 2.0f;
        this.mRect.set(0.0f, 0.0f, r12, r13);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, r14, r14, Path.Direction.CW);
        goto L19
    L5:
        r5 = false;
        goto L6
    }

    public void setSaturation(float r5) {
        ImageMatrix r10 = this.mImageMatrix;
        r10.mSaturation = r5;
        r10.updateMatrix(this);
    }

    public void setWarmth(float r5) {
        ImageMatrix r10 = this.mImageMatrix;
        r10.mWarmth = r5;
        r10.updateMatrix(this);
    }

    public ImageFilterView(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(r5, r10);
    }

    public ImageFilterView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(r5, r10);
    }
}
