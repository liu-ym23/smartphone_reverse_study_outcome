package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterButton extends AppCompatImageButton {
    private float mCrossfade;
    private ImageFilterView.ImageMatrix mImageMatrix;
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay;
    private Path mPath;
    RectF mRect;
    private float mRound;
    private float mRoundPercent;
    ViewOutlineProvider mViewOutlineProvider;

    public ImageFilterButton(Context r5) {
        super(r5);
        this.mImageMatrix = new ImageFilterView.ImageMatrix();
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mOverlay = true;
        init(r5, null);
    }

    public static /* synthetic */ float access$000(ImageFilterButton r5) {
        return r5.mRoundPercent;
    }

    public static /* synthetic */ float access$100(ImageFilterButton r5) {
        return r5.mRound;
    }

    private void init(Context r10, AttributeSet r11) {
        setPadding(0, 0, 0, 0);
        if (r11 == null) goto L41;
        TypedArray r12 = getContext().obtainStyledAttributes(r11, R.styleable.ImageFilterView);
        int r5 = r12.getIndexCount();
        Drawable r13 = r12.getDrawable(R.styleable.ImageFilterView_altSrc);
        int r14 = 0;
    L5:
        if (r14 >= r5) goto L28;
        int r15 = r12.getIndex(r14);
        if (r15 != R.styleable.ImageFilterView_crossfade) goto L10;
        this.mCrossfade = r12.getFloat(r15, 0.0f);
    L27:
        r14 = r14 + 1;
        goto L5
    L10:
        if (r15 != R.styleable.ImageFilterView_warmth) goto L13;
        setWarmth(r12.getFloat(r15, 0.0f));
        goto L27
    L13:
        if (r15 != R.styleable.ImageFilterView_saturation) goto L16;
        setSaturation(r12.getFloat(r15, 0.0f));
        goto L27
    L16:
        if (r15 != R.styleable.ImageFilterView_contrast) goto L19;
        setContrast(r12.getFloat(r15, 0.0f));
        goto L27
    L19:
        if (r15 != R.styleable.ImageFilterView_round) goto L22;
        setRound(r12.getDimension(r15, 0.0f));
        goto L27
    L22:
        if (r15 != R.styleable.ImageFilterView_roundPercent) goto L25;
        setRoundPercent(r12.getFloat(r15, 0.0f));
        goto L27
    L25:
        if (r15 != R.styleable.ImageFilterView_overlay) goto L27;
        setOverlay(r12.getBoolean(r15, this.mOverlay));
        goto L27
    L28:
        r12.recycle();
        if (r13 == null) goto L42;
        Drawable[] r16 = new Drawable[2];
        this.mLayers = r16;
        r16[0] = getDrawable();
        this.mLayers[1] = r13;
        LayerDrawable r17 = new LayerDrawable(this.mLayers);
        this.mLayer = r17;
        r17.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
        super.setImageDrawable(this.mLayer);
        return;
    L42:
        return;
    }

    private void setOverlay(boolean r5) {
        this.mOverlay = r5;
    }

    @Override // android.view.View
    public void draw(Canvas r5) {
        super.draw(r5);
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
        ImageFilterView.ImageMatrix r10 = this.mImageMatrix;
        r10.mBrightness = r5;
        r10.updateMatrix(this);
    }

    public void setContrast(float r5) {
        ImageFilterView.ImageMatrix r10 = this.mImageMatrix;
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
        ImageFilterView.ImageMatrix r10 = this.mImageMatrix;
        r10.mSaturation = r5;
        r10.updateMatrix(this);
    }

    public void setWarmth(float r5) {
        ImageFilterView.ImageMatrix r10 = this.mImageMatrix;
        r10.mWarmth = r5;
        r10.updateMatrix(this);
    }

    public ImageFilterButton(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.mImageMatrix = new ImageFilterView.ImageMatrix();
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mOverlay = true;
        init(r5, r10);
    }

    public ImageFilterButton(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.mImageMatrix = new ImageFilterView.ImageMatrix();
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mOverlay = true;
        init(r5, r10);
    }
}
