package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterButton extends AppCompatImageButton {
    private Drawable mAltDrawable;
    private float mCrossfade;
    private Drawable mDrawable;
    private ImageFilterView.ImageMatrix mImageMatrix;
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay;
    private float mPanX;
    private float mPanY;
    private Path mPath;
    RectF mRect;
    private float mRotate;
    private float mRound;
    private float mRoundPercent;
    ViewOutlineProvider mViewOutlineProvider;
    private float mZoom;

    public ImageFilterButton(Context r10) {
        super(r10);
        this.mImageMatrix = new ImageFilterView.ImageMatrix();
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r10, null);
    }

    public ImageFilterButton(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mImageMatrix = new ImageFilterView.ImageMatrix();
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r10, r11);
    }

    public ImageFilterButton(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mImageMatrix = new ImageFilterView.ImageMatrix();
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r10, r11);
    }

    static /* synthetic */ float access$000(ImageFilterButton r10) {
        return r10.mRoundPercent;
    }

    static /* synthetic */ float access$100(ImageFilterButton r10) {
        return r10.mRound;
    }

    private void init(Context r10, AttributeSet r11) {
        setPadding(0, 0, 0, 0);
        if (r11 == null) goto L70;
        TypedArray r12 = getContext().obtainStyledAttributes(r11, R.styleable.ImageFilterView);
        int r13 = r12.getIndexCount();
        this.mAltDrawable = r12.getDrawable(R.styleable.ImageFilterView_altSrc);
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L44;
        int r15 = r12.getIndex(r14);
        if (r15 != R.styleable.ImageFilterView_crossfade) goto L10;
        this.mCrossfade = r12.getFloat(r15, 0.0f);
    L43:
        r14 = r14 + 1;
        goto L5
    L10:
        if (r15 != R.styleable.ImageFilterView_warmth) goto L13;
        setWarmth(r12.getFloat(r15, 0.0f));
        goto L43
    L13:
        if (r15 != R.styleable.ImageFilterView_saturation) goto L16;
        setSaturation(r12.getFloat(r15, 0.0f));
        goto L43
    L16:
        if (r15 != R.styleable.ImageFilterView_contrast) goto L19;
        setContrast(r12.getFloat(r15, 0.0f));
        goto L43
    L19:
        if (r15 != R.styleable.ImageFilterView_round) goto L24;
        if (Build.VERSION.SDK_INT < 21) goto L43;
        setRound(r12.getDimension(r15, 0.0f));
        goto L43
    L24:
        if (r15 != R.styleable.ImageFilterView_roundPercent) goto L29;
        if (Build.VERSION.SDK_INT < 21) goto L43;
        setRoundPercent(r12.getFloat(r15, 0.0f));
        goto L43
    L29:
        if (r15 != R.styleable.ImageFilterView_overlay) goto L32;
        setOverlay(r12.getBoolean(r15, this.mOverlay));
        goto L43
    L32:
        if (r15 != R.styleable.ImageFilterView_imagePanX) goto L35;
        setImagePanX(r12.getFloat(r15, this.mPanX));
        goto L43
    L35:
        if (r15 != R.styleable.ImageFilterView_imagePanY) goto L38;
        setImagePanY(r12.getFloat(r15, this.mPanY));
        goto L43
    L38:
        if (r15 != R.styleable.ImageFilterView_imageRotate) goto L41;
        setImageRotate(r12.getFloat(r15, this.mRotate));
        goto L43
    L41:
        if (r15 != R.styleable.ImageFilterView_imageZoom) goto L43;
        setImageZoom(r12.getFloat(r15, this.mZoom));
        goto L43
    L44:
        r12.recycle();
        Drawable r16 = getDrawable();
        this.mDrawable = r16;
        if (this.mAltDrawable == null) goto L51;
        if (r16 == null) goto L51;
        Drawable[] r17 = this.mLayers;
        Drawable r18 = getDrawable().mutate();
        this.mDrawable = r18;
        r17[0] = r18;
        this.mLayers[1] = this.mAltDrawable.mutate();
        LayerDrawable r19 = new LayerDrawable(this.mLayers);
        this.mLayer = r19;
        r19.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
        if (this.mOverlay == true) goto L50;
        this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
    L50:
        super.setImageDrawable(this.mLayer);
        return;
    L51:
        Drawable r20 = getDrawable();
        this.mDrawable = r20;
        if (r20 == null) goto L72;
        Drawable[] r21 = this.mLayers;
        Drawable r22 = r20.mutate();
        this.mDrawable = r22;
        r21[0] = r22;
        return;
    L72:
        return;
    }

    private void setMatrix() {
        if (Float.isNaN(this.mPanX) == true) goto L5;
    L11:
        float r10 = 0.0f;
        if (Float.isNaN(this.mPanX) == false) goto L14;
        float r11 = 0.0f;
    L16:
        if (Float.isNaN(this.mPanY) == false) goto L18;
        float r12 = 0.0f;
    L20:
        if (Float.isNaN(this.mZoom) == false) goto L22;
        float r13 = 1.0f;
    L24:
        if (Float.isNaN(this.mRotate) == true) goto L27;
        r10 = this.mRotate;
    L27:
        Matrix r14 = new Matrix();
        r14.reset();
        float r15 = getDrawable().getIntrinsicWidth();
        float r16 = getDrawable().getIntrinsicHeight();
        float r17 = getWidth();
        float r18 = getHeight();
        if ((r15 * r18) >= (r16 * r17)) goto L30;
        float r19 = r17 / r15;
    L31:
        float r20 = r13 * r19;
        r14.postScale(r20, r20);
        float r21 = r15 * r20;
        float r22 = r20 * r16;
        r14.postTranslate((((r11 * (r17 - r21)) + r17) - r21) * 0.5f, (((r12 * (r18 - r22)) + r18) - r22) * 0.5f);
        r14.postRotate(r10, r17 / 2.0f, r18 / 2.0f);
        setImageMatrix(r14);
        setScaleType(ImageView.ScaleType.MATRIX);
        return;
    L30:
        r19 = r18 / r16;
        goto L31
    L22:
        r13 = this.mZoom;
        goto L24
    L18:
        r12 = this.mPanY;
        goto L20
    L14:
        r11 = this.mPanX;
        goto L16
    L5:
        if (Float.isNaN(this.mPanY) == false) goto L11;
        if (Float.isNaN(this.mZoom) == false) goto L11;
        if (Float.isNaN(this.mRotate) == false) goto L11;
    }

    private void setOverlay(boolean r10) {
        this.mOverlay = r10;
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
    public void draw(Canvas r10) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
    L9:
        boolean r11 = false;
    L10:
        super.draw(r10);
        if (r11 == false) goto L14;
        r10.restore();
        return;
    L14:
        return;
    L5:
        if (this.mRound == 0.0f) goto L9;
        if (this.mPath == null) goto L9;
        r11 = true;
        r10.save();
        r10.clipPath(this.mPath);
        goto L10
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
    public void layout(int r10, int r11, int r12, int r13) {
        super.layout(r10, r11, r12, r13);
        setMatrix();
    }

    public void setAltImageResource(int r10) {
        Drawable r11 = AppCompatResources.getDrawable(getContext(), r10).mutate();
        this.mAltDrawable = r11;
        Drawable[] r12 = this.mLayers;
        r12[0] = this.mDrawable;
        r12[1] = r11;
        LayerDrawable r13 = new LayerDrawable(this.mLayers);
        this.mLayer = r13;
        super.setImageDrawable(r13);
        setCrossfade(this.mCrossfade);
    }

    public void setBrightness(float r10) {
        ImageFilterView.ImageMatrix r11 = this.mImageMatrix;
        r11.mBrightness = r10;
        r11.updateMatrix(this);
    }

    public void setContrast(float r10) {
        ImageFilterView.ImageMatrix r11 = this.mImageMatrix;
        r11.mContrast = r10;
        r11.updateMatrix(this);
    }

    public void setCrossfade(float r10) {
        this.mCrossfade = r10;
        if (this.mLayers != null) goto L5;
        return;
    L5:
        if (this.mOverlay == true) goto L7;
        this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
    L7:
        this.mLayer.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
        super.setImageDrawable(this.mLayer);
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable r10) {
        if (this.mAltDrawable == null) goto L6;
        if (r10 == null) goto L6;
        Drawable r11 = r10.mutate();
        this.mDrawable = r11;
        Drawable[] r12 = this.mLayers;
        r12[0] = r11;
        r12[1] = this.mAltDrawable;
        LayerDrawable r13 = new LayerDrawable(this.mLayers);
        this.mLayer = r13;
        super.setImageDrawable(r13);
        setCrossfade(this.mCrossfade);
        return;
    L6:
        super.setImageDrawable(r10);
    }

    public void setImagePanX(float r10) {
        this.mPanX = r10;
        updateViewMatrix();
    }

    public void setImagePanY(float r10) {
        this.mPanY = r10;
        updateViewMatrix();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int r10) {
        if (this.mAltDrawable == null) goto L5;
        Drawable r11 = AppCompatResources.getDrawable(getContext(), r10).mutate();
        this.mDrawable = r11;
        Drawable[] r12 = this.mLayers;
        r12[0] = r11;
        r12[1] = this.mAltDrawable;
        LayerDrawable r13 = new LayerDrawable(this.mLayers);
        this.mLayer = r13;
        super.setImageDrawable(r13);
        setCrossfade(this.mCrossfade);
        return;
    L5:
        super.setImageResource(r10);
    }

    public void setImageRotate(float r10) {
        this.mRotate = r10;
        updateViewMatrix();
    }

    public void setImageZoom(float r10) {
        this.mZoom = r10;
        updateViewMatrix();
    }

    @RequiresApi(21)
    public void setRound(float r10) {
        if (Float.isNaN(r10) == false) goto L7;
        this.mRound = r10;
        float r11 = this.mRoundPercent;
        this.mRoundPercent = -1.0f;
        setRoundPercent(r11);
        return;
    L7:
        if (this.mRound == r10) goto L9;
        boolean r12 = true;
    L10:
        this.mRound = r10;
        if (r10 == 0.0f) goto L26;
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
        Path r13 = this.mPath;
        RectF r14 = this.mRect;
        float r15 = this.mRound;
        r13.addRoundRect(r14, r15, r15, Path.Direction.CW);
    L28:
        if (r12 == true) goto L30;
        return;
    L30:
        if (Build.VERSION.SDK_INT < 21) goto L34;
        invalidateOutline();
        return;
    L34:
        return;
    L21:
        if (this.mViewOutlineProvider != null) goto L23;
        ViewOutlineProvider r16 = new AnonymousClass2(this);
        this.mViewOutlineProvider = r16;
        setOutlineProvider(r16);
    L23:
        setClipToOutline(true);
        goto L24
    L26:
        if (Build.VERSION.SDK_INT < 21) goto L28;
        setClipToOutline(false);
        goto L28
    L9:
        r12 = false;
        goto L10
    }

    @RequiresApi(21)
    public void setRoundPercent(float r10) {
        if (this.mRoundPercent == r10) goto L5;
        boolean r11 = true;
    L6:
        this.mRoundPercent = r10;
        if (r10 == 0.0f) goto L22;
        if (this.mPath != null) goto L12;
        this.mPath = new Path();
    L12:
        if (this.mRect != null) goto L15;
        this.mRect = new RectF();
    L15:
        if (Build.VERSION.SDK_INT >= 21) goto L17;
    L20:
        int r12 = getWidth();
        int r13 = getHeight();
        float r14 = (Math.min(r12, r13) * this.mRoundPercent) / 2.0f;
        this.mRect.set(0.0f, 0.0f, r12, r13);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, r14, r14, Path.Direction.CW);
    L24:
        if (r11 == true) goto L26;
        return;
    L26:
        if (Build.VERSION.SDK_INT < 21) goto L30;
        invalidateOutline();
        return;
    L30:
        return;
    L17:
        if (this.mViewOutlineProvider != null) goto L19;
        ViewOutlineProvider r15 = new AnonymousClass1(this);
        this.mViewOutlineProvider = r15;
        setOutlineProvider(r15);
    L19:
        setClipToOutline(true);
        goto L20
    L22:
        if (Build.VERSION.SDK_INT < 21) goto L24;
        setClipToOutline(false);
        goto L24
    L5:
        r11 = false;
        goto L6
    }

    public void setSaturation(float r10) {
        ImageFilterView.ImageMatrix r11 = this.mImageMatrix;
        r11.mSaturation = r10;
        r11.updateMatrix(this);
    }

    public void setWarmth(float r10) {
        ImageFilterView.ImageMatrix r11 = this.mImageMatrix;
        r11.mWarmth = r10;
        r11.updateMatrix(this);
    }
}
