package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.FloatLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.GravityCompat;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: classes.dex */
public class MotionLabel extends View implements FloatLayout {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    static String TAG = "MotionLabel";
    private boolean mAutoSize;
    private int mAutoSizeTextType;
    float mBackgroundPanX;
    float mBackgroundPanY;
    private float mBaseTextSize;
    private float mDeltaLeft;
    private float mFloatHeight;
    private float mFloatWidth;
    private String mFontFamily;
    private int mGravity;
    private Layout mLayout;
    boolean mNotBuilt;
    Matrix mOutlinePositionMatrix;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    TextPaint mPaint;
    Path mPath;
    RectF mRect;
    float mRotate;
    private float mRound;
    private float mRoundPercent;
    private int mStyleIndex;
    Paint mTempPaint;
    Rect mTempRect;
    private String mText;
    private Drawable mTextBackground;
    private Bitmap mTextBackgroundBitmap;
    private Rect mTextBounds;
    private int mTextFillColor;
    private int mTextOutlineColor;
    private float mTextOutlineThickness;
    private float mTextPanX;
    private float mTextPanY;
    private BitmapShader mTextShader;
    private Matrix mTextShaderMatrix;
    private float mTextSize;
    private int mTextureEffect;
    private float mTextureHeight;
    private float mTextureWidth;
    private CharSequence mTransformed;
    private int mTypefaceIndex;
    private boolean mUseOutline;
    ViewOutlineProvider mViewOutlineProvider;
    float mZoom;
    Paint paintCache;
    float paintTextSize;

    static {
    }

    public MotionLabel(Context r10) {
        super(r10);
        this.mPaint = new TextPaint();
        this.mPath = new Path();
        this.mTextFillColor = SupportMenu.USER_MASK;
        this.mTextOutlineColor = SupportMenu.USER_MASK;
        this.mUseOutline = false;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mTextSize = 48.0f;
        this.mBaseTextSize = Float.NaN;
        this.mTextOutlineThickness = 0.0f;
        this.mText = "Hello World";
        this.mNotBuilt = true;
        this.mTextBounds = new Rect();
        this.mPaddingLeft = 1;
        this.mPaddingRight = 1;
        this.mPaddingTop = 1;
        this.mPaddingBottom = 1;
        this.mGravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        this.mAutoSizeTextType = 0;
        this.mAutoSize = false;
        this.mTextureHeight = Float.NaN;
        this.mTextureWidth = Float.NaN;
        this.mTextPanX = 0.0f;
        this.mTextPanY = 0.0f;
        this.paintCache = new Paint();
        this.mTextureEffect = 0;
        this.mBackgroundPanX = Float.NaN;
        this.mBackgroundPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r10, null);
    }

    public MotionLabel(Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.mPaint = new TextPaint();
        this.mPath = new Path();
        this.mTextFillColor = SupportMenu.USER_MASK;
        this.mTextOutlineColor = SupportMenu.USER_MASK;
        this.mUseOutline = false;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mTextSize = 48.0f;
        this.mBaseTextSize = Float.NaN;
        this.mTextOutlineThickness = 0.0f;
        this.mText = "Hello World";
        this.mNotBuilt = true;
        this.mTextBounds = new Rect();
        this.mPaddingLeft = 1;
        this.mPaddingRight = 1;
        this.mPaddingTop = 1;
        this.mPaddingBottom = 1;
        this.mGravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        this.mAutoSizeTextType = 0;
        this.mAutoSize = false;
        this.mTextureHeight = Float.NaN;
        this.mTextureWidth = Float.NaN;
        this.mTextPanX = 0.0f;
        this.mTextPanY = 0.0f;
        this.paintCache = new Paint();
        this.mTextureEffect = 0;
        this.mBackgroundPanX = Float.NaN;
        this.mBackgroundPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r10, r11);
    }

    public MotionLabel(Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mPaint = new TextPaint();
        this.mPath = new Path();
        this.mTextFillColor = SupportMenu.USER_MASK;
        this.mTextOutlineColor = SupportMenu.USER_MASK;
        this.mUseOutline = false;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mTextSize = 48.0f;
        this.mBaseTextSize = Float.NaN;
        this.mTextOutlineThickness = 0.0f;
        this.mText = "Hello World";
        this.mNotBuilt = true;
        this.mTextBounds = new Rect();
        this.mPaddingLeft = 1;
        this.mPaddingRight = 1;
        this.mPaddingTop = 1;
        this.mPaddingBottom = 1;
        this.mGravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        this.mAutoSizeTextType = 0;
        this.mAutoSize = false;
        this.mTextureHeight = Float.NaN;
        this.mTextureWidth = Float.NaN;
        this.mTextPanX = 0.0f;
        this.mTextPanY = 0.0f;
        this.paintCache = new Paint();
        this.mTextureEffect = 0;
        this.mBackgroundPanX = Float.NaN;
        this.mBackgroundPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r10, r11);
    }

    static /* synthetic */ float access$000(MotionLabel r10) {
        return r10.mRoundPercent;
    }

    static /* synthetic */ float access$100(MotionLabel r10) {
        return r10.mRound;
    }

    private void adjustTexture(float r10, float r11, float r12, float r13) {
        if (this.mTextShaderMatrix != null) goto L5;
        return;
    L5:
        this.mFloatWidth = r12 - r10;
        this.mFloatHeight = r13 - r11;
        updateShaderMatrix();
    }

    private float getHorizontalOffset() {
        if (Float.isNaN(this.mBaseTextSize) == false) goto L5;
        float r10 = 1.0f;
    L6:
        TextPaint r11 = this.mPaint;
        String r12 = this.mText;
        float r13 = r10 * r11.measureText(r12, 0, r12.length());
        if (Float.isNaN(this.mFloatWidth) == false) goto L9;
        float r14 = getMeasuredWidth();
    L11:
        return ((((r14 - getPaddingLeft()) - getPaddingRight()) - r13) * (this.mTextPanX + 1.0f)) / 2.0f;
    L9:
        r14 = this.mFloatWidth;
        goto L11
    L5:
        r10 = this.mTextSize / this.mBaseTextSize;
        goto L6
    }

    private float getVerticalOffset() {
        if (Float.isNaN(this.mBaseTextSize) == false) goto L5;
        float r10 = 1.0f;
    L6:
        Paint.FontMetrics r11 = this.mPaint.getFontMetrics();
        if (Float.isNaN(this.mFloatHeight) == false) goto L9;
        float r12 = getMeasuredHeight();
    L10:
        float r13 = (r12 - getPaddingTop()) - getPaddingBottom();
        float r14 = r11.descent;
        float r15 = r11.ascent;
        return (((r13 - ((r14 - r15) * r10)) * (1.0f - this.mTextPanY)) / 2.0f) - (r10 * r15);
    L9:
        r12 = this.mFloatHeight;
        goto L10
    L5:
        r10 = this.mTextSize / this.mBaseTextSize;
        goto L6
    }

    private void init(Context r10, AttributeSet r11) {
        setUpTheme(r10, r11);
        if (r11 == null) goto L82;
        TypedArray r12 = getContext().obtainStyledAttributes(r11, R.styleable.MotionLabel);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L81;
        int r15 = r12.getIndex(r14);
        if (r15 != R.styleable.MotionLabel_android_text) goto L10;
        setText(r12.getText(r15));
    L80:
        r14 = r14 + 1;
        goto L5
    L10:
        if (r15 != R.styleable.MotionLabel_android_fontFamily) goto L13;
        this.mFontFamily = r12.getString(r15);
        goto L80
    L13:
        if (r15 != R.styleable.MotionLabel_scaleFromTextSize) goto L16;
        this.mBaseTextSize = r12.getDimensionPixelSize(r15, (int) this.mBaseTextSize);
        goto L80
    L16:
        if (r15 != R.styleable.MotionLabel_android_textSize) goto L19;
        this.mTextSize = r12.getDimensionPixelSize(r15, (int) this.mTextSize);
        goto L80
    L19:
        if (r15 != R.styleable.MotionLabel_android_textStyle) goto L22;
        this.mStyleIndex = r12.getInt(r15, this.mStyleIndex);
        goto L80
    L22:
        if (r15 != R.styleable.MotionLabel_android_typeface) goto L25;
        this.mTypefaceIndex = r12.getInt(r15, this.mTypefaceIndex);
        goto L80
    L25:
        if (r15 != R.styleable.MotionLabel_android_textColor) goto L28;
        this.mTextFillColor = r12.getColor(r15, this.mTextFillColor);
        goto L80
    L28:
        if (r15 != R.styleable.MotionLabel_borderRound) goto L33;
        float r16 = r12.getDimension(r15, this.mRound);
        this.mRound = r16;
        if (Build.VERSION.SDK_INT < 21) goto L80;
        setRound(r16);
        goto L80
    L33:
        if (r15 != R.styleable.MotionLabel_borderRoundPercent) goto L38;
        float r17 = r12.getFloat(r15, this.mRoundPercent);
        this.mRoundPercent = r17;
        if (Build.VERSION.SDK_INT < 21) goto L80;
        setRoundPercent(r17);
        goto L80
    L38:
        if (r15 != R.styleable.MotionLabel_android_gravity) goto L41;
        setGravity(r12.getInt(r15, -1));
        goto L80
    L41:
        if (r15 != R.styleable.MotionLabel_android_autoSizeTextType) goto L44;
        this.mAutoSizeTextType = r12.getInt(r15, 0);
        goto L80
    L44:
        if (r15 != R.styleable.MotionLabel_textOutlineColor) goto L48;
        this.mTextOutlineColor = r12.getInt(r15, this.mTextOutlineColor);
    L46:
        this.mUseOutline = true;
        goto L80
    L48:
        if (r15 != R.styleable.MotionLabel_textOutlineThickness) goto L51;
        this.mTextOutlineThickness = r12.getDimension(r15, this.mTextOutlineThickness);
        goto L46
    L51:
        if (r15 != R.styleable.MotionLabel_textBackground) goto L54;
        this.mTextBackground = r12.getDrawable(r15);
        goto L46
    L54:
        if (r15 != R.styleable.MotionLabel_textBackgroundPanX) goto L57;
        this.mBackgroundPanX = r12.getFloat(r15, this.mBackgroundPanX);
        goto L80
    L57:
        if (r15 != R.styleable.MotionLabel_textBackgroundPanY) goto L60;
        this.mBackgroundPanY = r12.getFloat(r15, this.mBackgroundPanY);
        goto L80
    L60:
        if (r15 != R.styleable.MotionLabel_textPanX) goto L63;
        this.mTextPanX = r12.getFloat(r15, this.mTextPanX);
        goto L80
    L63:
        if (r15 != R.styleable.MotionLabel_textPanY) goto L66;
        this.mTextPanY = r12.getFloat(r15, this.mTextPanY);
        goto L80
    L66:
        if (r15 != R.styleable.MotionLabel_textBackgroundRotate) goto L69;
        this.mRotate = r12.getFloat(r15, this.mRotate);
        goto L80
    L69:
        if (r15 != R.styleable.MotionLabel_textBackgroundZoom) goto L72;
        this.mZoom = r12.getFloat(r15, this.mZoom);
        goto L80
    L72:
        if (r15 != R.styleable.MotionLabel_textureHeight) goto L75;
        this.mTextureHeight = r12.getDimension(r15, this.mTextureHeight);
        goto L80
    L75:
        if (r15 != R.styleable.MotionLabel_textureWidth) goto L78;
        this.mTextureWidth = r12.getDimension(r15, this.mTextureWidth);
        goto L80
    L78:
        if (r15 != R.styleable.MotionLabel_textureEffect) goto L80;
        this.mTextureEffect = r12.getInt(r15, this.mTextureEffect);
        goto L80
    L81:
        r12.recycle();
    L82:
        setupTexture();
        setupPath();
    }

    private void setTypefaceFromAttrs(String r10, int r11, int r12) {
        if (r10 == null) goto L7;
        Typeface r13 = Typeface.create(r10, r12);
        if (r13 == null) goto L8;
        setTypeface(r13);
        return;
    L8:
        boolean r14 = true;
        if (r11 == 1) goto L16;
        if (r11 != 2) goto L12;
        r13 = Typeface.SERIF;
    L17:
        float r15 = 0.0f;
        if (r12 <= 0) goto L34;
        if (r13 != null) goto L21;
        Typeface r16 = Typeface.defaultFromStyle(r12);
    L22:
        setTypeface(r16);
        if (r16 == null) goto L25;
        int r17 = r16.getStyle();
    L26:
        int r18 = (~r17) & r12;
        TextPaint r19 = this.mPaint;
        if ((r18 & 1) != 0) goto L30;
        r14 = false;
    L30:
        r19.setFakeBoldText(r14);
        TextPaint r20 = this.mPaint;
        if ((r18 & 2) == 0) goto L33;
        r15 = -0.25f;
    L33:
        r20.setTextSkewX(r15);
        return;
    L25:
        r17 = 0;
        goto L26
    L21:
        r16 = Typeface.create(r13, r12);
        goto L22
    L34:
        this.mPaint.setFakeBoldText(false);
        this.mPaint.setTextSkewX(0.0f);
        setTypeface(r13);
        return;
    L12:
        if (r11 != 3) goto L17;
        r13 = Typeface.MONOSPACE;
        goto L17
    L16:
        r13 = Typeface.SANS_SERIF;
        goto L17
    L7:
        r13 = null;
        goto L8
    }

    private void setUpTheme(Context r10, @Nullable AttributeSet r11) {
        TypedValue r12 = new TypedValue();
        r10.getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, r12, true);
        TextPaint r13 = this.mPaint;
        int r14 = r12.data;
        this.mTextFillColor = r14;
        r13.setColor(r14);
    }

    private void setupTexture() {
        if (this.mTextBackground == null) goto L28;
        this.mTextShaderMatrix = new Matrix();
        int r10 = this.mTextBackground.getIntrinsicWidth();
        int r11 = this.mTextBackground.getIntrinsicHeight();
        int r12 = 128;
        if (r10 > 0) goto L12;
        r10 = getWidth();
        if (r10 != 0) goto L12;
        if (Float.isNaN(this.mTextureWidth) == false) goto L11;
        r10 = 128;
        goto L12
    L11:
        r10 = (int) this.mTextureWidth;
    L12:
        if (r11 > 0) goto L21;
        r11 = getHeight();
        if (r11 != 0) goto L21;
        if (Float.isNaN(this.mTextureHeight) == true) goto L19;
        r12 = (int) this.mTextureHeight;
    L19:
        r11 = r12;
    L21:
        if (this.mTextureEffect == 0) goto L23;
        r10 = r10 / 2;
        r11 = r11 / 2;
    L23:
        this.mTextBackgroundBitmap = Bitmap.createBitmap(r10, r11, Bitmap.Config.ARGB_8888);
        Canvas r13 = new Canvas(this.mTextBackgroundBitmap);
        this.mTextBackground.setBounds(0, 0, r13.getWidth(), r13.getHeight());
        this.mTextBackground.setFilterBitmap(true);
        this.mTextBackground.draw(r13);
        if (this.mTextureEffect == 0) goto L26;
        this.mTextBackgroundBitmap = blur(this.mTextBackgroundBitmap, 4);
    L26:
        Bitmap r14 = this.mTextBackgroundBitmap;
        Shader.TileMode r15 = Shader.TileMode.REPEAT;
        this.mTextShader = new BitmapShader(r14, r15, r15);
        return;
    }

    private void updateShaderMatrix() {
        float r10 = 0.0f;
        if (Float.isNaN(this.mBackgroundPanX) == false) goto L5;
        float r11 = 0.0f;
    L7:
        if (Float.isNaN(this.mBackgroundPanY) == false) goto L9;
        float r12 = 0.0f;
    L11:
        if (Float.isNaN(this.mZoom) == false) goto L13;
        float r13 = 1.0f;
    L15:
        if (Float.isNaN(this.mRotate) == true) goto L18;
        r10 = this.mRotate;
    L18:
        this.mTextShaderMatrix.reset();
        float r14 = this.mTextBackgroundBitmap.getWidth();
        float r15 = this.mTextBackgroundBitmap.getHeight();
        if (Float.isNaN(this.mTextureWidth) == false) goto L21;
        float r16 = this.mFloatWidth;
    L23:
        if (Float.isNaN(this.mTextureHeight) == false) goto L25;
        float r17 = this.mFloatHeight;
    L27:
        if ((r14 * r17) >= (r15 * r16)) goto L29;
        float r18 = r16 / r14;
    L30:
        float r19 = r13 * r18;
        this.mTextShaderMatrix.postScale(r19, r19);
        float r20 = r14 * r19;
        float r21 = r16 - r20;
        float r22 = r19 * r15;
        float r23 = r17 - r22;
        if (Float.isNaN(this.mTextureHeight) == true) goto L34;
        r23 = this.mTextureHeight / 2.0f;
    L34:
        if (Float.isNaN(this.mTextureWidth) == true) goto L36;
        r21 = this.mTextureWidth / 2.0f;
    L36:
        float r24 = (((r12 * r23) + r17) - r22) * 0.5f;
        this.mTextShaderMatrix.postTranslate((((r11 * r21) + r16) - r20) * 0.5f, r24);
        this.mTextShaderMatrix.postRotate(r10, r16 / 2.0f, r17 / 2.0f);
        this.mTextShader.setLocalMatrix(this.mTextShaderMatrix);
        return;
    L29:
        r18 = r17 / r15;
        goto L30
    L25:
        r17 = this.mTextureHeight;
        goto L27
    L21:
        r16 = this.mTextureWidth;
        goto L23
    L13:
        r13 = this.mZoom;
        goto L15
    L9:
        r12 = this.mBackgroundPanY;
        goto L11
    L5:
        r11 = this.mBackgroundPanX;
        goto L7
    }

    Bitmap blur(Bitmap r10, int r11) {
        System.nanoTime();
        int r12 = r10.getWidth();
        int r13 = r12 / 2;
        int r14 = r10.getHeight() / 2;
        Bitmap r15 = Bitmap.createScaledBitmap(r10, r13, r14, true);
        int r16 = 0;
    L3:
        if (r16 >= r11) goto L9;
        if (r13 < 32) goto L9;
        if (r14 < 32) goto L9;
        r13 = r13 / 2;
        r14 = r14 / 2;
        r15 = Bitmap.createScaledBitmap(r15, r13, r14, true);
        r16 = r16 + 1;
    L9:
        return r15;
    }

    void buildShape(float r11) {
        if (this.mUseOutline == false) goto L5;
    L7:
        this.mPath.reset();
        String r10 = this.mText;
        int r12 = r10.length();
        this.mPaint.getTextBounds(r10, 0, r12, this.mTextBounds);
        this.mPaint.getTextPath(r10, 0, r12, 0.0f, 0.0f, this.mPath);
        if (r11 == 1.0f) goto L10;
        Log.v(TAG, Debug.getLoc() + " scale " + r11);
        Matrix r13 = new Matrix();
        r13.postScale(r11, r11);
        this.mPath.transform(r13);
    L10:
        Rect r14 = this.mTextBounds;
        r14.right--;
        r14.left++;
        r14.bottom++;
        r14.top--;
        RectF r15 = new RectF();
        r15.bottom = getHeight();
        r15.right = getWidth();
        this.mNotBuilt = false;
        return;
    L5:
        if (r11 != 1.0f) goto L7;
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getScaleFromTextSize() {
        return this.mBaseTextSize;
    }

    public float getTextBackgroundPanX() {
        return this.mBackgroundPanX;
    }

    public float getTextBackgroundPanY() {
        return this.mBackgroundPanY;
    }

    public float getTextBackgroundRotate() {
        return this.mRotate;
    }

    public float getTextBackgroundZoom() {
        return this.mZoom;
    }

    public int getTextOutlineColor() {
        return this.mTextOutlineColor;
    }

    public float getTextPanX() {
        return this.mTextPanX;
    }

    public float getTextPanY() {
        return this.mTextPanY;
    }

    public float getTextureHeight() {
        return this.mTextureHeight;
    }

    public float getTextureWidth() {
        return this.mTextureWidth;
    }

    public Typeface getTypeface() {
        return this.mPaint.getTypeface();
    }

    @Override // androidx.constraintlayout.motion.widget.FloatLayout
    public void layout(float r10, float r11, float r12, float r13) {
        int r14 = (int) (r10 + 0.5f);
        this.mDeltaLeft = r10 - r14;
        int r15 = (int) (r12 + 0.5f);
        int r16 = r15 - r14;
        int r17 = (int) (r13 + 0.5f);
        int r18 = (int) (0.5f + r11);
        int r19 = r17 - r18;
        float r20 = r12 - r10;
        this.mFloatWidth = r20;
        float r21 = r13 - r11;
        this.mFloatHeight = r21;
        adjustTexture(r10, r11, r12, r13);
        if (getMeasuredHeight() == r19) goto L5;
    L6:
        measure(View.MeasureSpec.makeMeasureSpec(r16, 1073741824), View.MeasureSpec.makeMeasureSpec(r19, 1073741824));
    L7:
        super.layout(r14, r18, r15, r17);
        if (this.mAutoSize == true) goto L10;
        return;
    L10:
        if (this.mTempRect != null) goto L12;
        this.mTempPaint = new Paint();
        this.mTempRect = new Rect();
        this.mTempPaint.set(this.mPaint);
        this.paintTextSize = this.mTempPaint.getTextSize();
    L12:
        this.mFloatWidth = r20;
        this.mFloatHeight = r21;
        Paint r22 = this.mTempPaint;
        String r110 = this.mText;
        r22.getTextBounds(r110, 0, r110.length(), this.mTempRect);
        int r23 = this.mTempRect.width();
        float r111 = this.mTempRect.height() * 1.3f;
        float r24 = (r20 - this.mPaddingRight) - this.mPaddingLeft;
        float r25 = (r21 - this.mPaddingBottom) - this.mPaddingTop;
        float r26 = r23;
        if ((r26 * r25) <= (r111 * r24)) goto L15;
        this.mPaint.setTextSize((this.paintTextSize * r24) / r26);
    L17:
        if (this.mUseOutline == true) goto L21;
        if (Float.isNaN(this.mBaseTextSize) == false) goto L21;
        return;
    L21:
        if (Float.isNaN(this.mBaseTextSize) == false) goto L23;
        float r27 = 1.0f;
    L24:
        buildShape(r27);
        return;
    L23:
        r27 = this.mTextSize / this.mBaseTextSize;
        goto L24
    L15:
        this.mPaint.setTextSize((this.paintTextSize * r25) / r111);
        goto L17
    L5:
        if (getMeasuredWidth() == r16) goto L7;
        goto L6
    }

    @Override // android.view.View
    public void layout(int r10, int r11, int r12, int r13) {
        super.layout(r10, r11, r12, r13);
        boolean r14 = Float.isNaN(this.mBaseTextSize);
        if (r14 == false) goto L5;
        float r15 = 1.0f;
    L6:
        this.mFloatWidth = r12 - r10;
        this.mFloatHeight = r13 - r11;
        if (this.mAutoSize == false) goto L22;
        if (this.mTempRect != null) goto L11;
        this.mTempPaint = new Paint();
        this.mTempRect = new Rect();
        this.mTempPaint.set(this.mPaint);
        this.paintTextSize = this.mTempPaint.getTextSize();
    L11:
        Paint r16 = this.mTempPaint;
        String r17 = this.mText;
        r16.getTextBounds(r17, 0, r17.length(), this.mTempRect);
        int r18 = this.mTempRect.width();
        int r19 = (int) (this.mTempRect.height() * 1.3f);
        float r20 = (this.mFloatWidth - this.mPaddingRight) - this.mPaddingLeft;
        float r21 = (this.mFloatHeight - this.mPaddingBottom) - this.mPaddingTop;
        if (r14 == false) goto L17;
        float r22 = r18;
        float r23 = r19;
        if ((r22 * r21) <= (r23 * r20)) goto L16;
        this.mPaint.setTextSize((this.paintTextSize * r20) / r22);
        goto L22
    L16:
        this.mPaint.setTextSize((this.paintTextSize * r21) / r23);
        goto L22
    L17:
        float r24 = r18;
        float r25 = r19;
        if ((r24 * r21) <= (r25 * r20)) goto L20;
        r15 = r20 / r24;
        goto L22
    L20:
        r15 = r21 / r25;
    L22:
        if (this.mUseOutline == true) goto L24;
        if (r14 == false) goto L24;
        return;
    L24:
        adjustTexture(r10, r11, r12, r13);
        buildShape(r15);
        return;
    L5:
        r15 = this.mTextSize / this.mBaseTextSize;
        goto L6
    }

    @Override // android.view.View
    protected void onDraw(Canvas r10) {
        if (Float.isNaN(this.mBaseTextSize) == false) goto L5;
        float r11 = 1.0f;
    L6:
        super.onDraw(r10);
        if (this.mUseOutline == true) goto L13;
        if (r11 != 1.0f) goto L13;
        float r12 = this.mPaddingLeft + getHorizontalOffset();
        r10.drawText(this.mText, this.mDeltaLeft + r12, this.mPaddingTop + getVerticalOffset(), this.mPaint);
        return;
    L13:
        if (this.mNotBuilt == false) goto L16;
        buildShape(r11);
    L16:
        if (this.mOutlinePositionMatrix != null) goto L19;
        this.mOutlinePositionMatrix = new Matrix();
    L19:
        if (this.mUseOutline == false) goto L28;
        this.paintCache.set(this.mPaint);
        this.mOutlinePositionMatrix.reset();
        float r13 = this.mPaddingLeft + getHorizontalOffset();
        float r14 = this.mPaddingTop + getVerticalOffset();
        this.mOutlinePositionMatrix.postTranslate(r13, r14);
        this.mOutlinePositionMatrix.preScale(r11, r11);
        this.mPath.transform(this.mOutlinePositionMatrix);
        if (this.mTextShader == null) goto L23;
        this.mPaint.setFilterBitmap(true);
        this.mPaint.setShader(this.mTextShader);
    L24:
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        r10.drawPath(this.mPath, this.mPaint);
        if (this.mTextShader == null) goto L27;
        this.mPaint.setShader(null);
    L27:
        this.mPaint.setColor(this.mTextOutlineColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        r10.drawPath(this.mPath, this.mPaint);
        this.mOutlinePositionMatrix.reset();
        this.mOutlinePositionMatrix.postTranslate(-r13, -r14);
        this.mPath.transform(this.mOutlinePositionMatrix);
        this.mPaint.set(this.paintCache);
        return;
    L23:
        this.mPaint.setColor(this.mTextFillColor);
        goto L24
    L28:
        float r15 = this.mPaddingLeft + getHorizontalOffset();
        float r16 = this.mPaddingTop + getVerticalOffset();
        this.mOutlinePositionMatrix.reset();
        this.mOutlinePositionMatrix.preTranslate(r15, r16);
        this.mPath.transform(this.mOutlinePositionMatrix);
        this.mPaint.setColor(this.mTextFillColor);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        r10.drawPath(this.mPath, this.mPaint);
        this.mOutlinePositionMatrix.reset();
        this.mOutlinePositionMatrix.preTranslate(-r15, -r16);
        this.mPath.transform(this.mOutlinePositionMatrix);
        return;
    L5:
        r11 = this.mTextSize / this.mBaseTextSize;
        goto L6
    }

    @Override // android.view.View
    protected void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getMode(r11);
        int r14 = View.MeasureSpec.getSize(r10);
        int r15 = View.MeasureSpec.getSize(r11);
        this.mAutoSize = false;
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
        if (r12 != 1073741824) goto L9;
        if (r13 != 1073741824) goto L9;
        if (this.mAutoSizeTextType == 0) goto L18;
        this.mAutoSize = true;
    L18:
        setMeasuredDimension(r14, r15);
        return;
    L9:
        TextPaint r16 = this.mPaint;
        String r17 = this.mText;
        r16.getTextBounds(r17, 0, r17.length(), this.mTextBounds);
        if (r12 == 1073741824) goto L12;
        r14 = (int) (this.mTextBounds.width() + 0.99999f);
    L12:
        r14 = r14 + (this.mPaddingLeft + this.mPaddingRight);
        if (r13 == 1073741824) goto L18;
        int r18 = (int) (this.mPaint.getFontMetricsInt(null) + 0.99999f);
        if (r13 != Integer.MIN_VALUE) goto L17;
        r18 = Math.min(r15, r18);
    L17:
        r15 = (this.mPaddingTop + this.mPaddingBottom) + r18;
        goto L18
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int r10) {
        if ((r10 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) != 0) goto L6;
        r10 = r10 | GravityCompat.START;
    L6:
        if ((r10 & 112) != 0) goto L9;
        r10 = r10 | 48;
    L9:
        if (r10 == this.mGravity) goto L11;
        invalidate();
    L11:
        this.mGravity = r10;
        int r11 = r10 & 112;
        if (r11 != 48) goto L14;
        this.mTextPanY = -1.0f;
    L18:
        int r12 = r10 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r12 != 3) goto L21;
    L27:
        this.mTextPanX = -1.0f;
        return;
    L21:
        if (r12 == 5) goto L26;
        if (r12 == 8388611) goto L27;
        if (r12 == 8388613) goto L26;
        this.mTextPanX = 0.0f;
        return;
    L26:
        this.mTextPanX = 1.0f;
        return;
    L14:
        if (r11 == 80) goto L16;
        this.mTextPanY = 0.0f;
        goto L18
    L16:
        this.mTextPanY = 1.0f;
        goto L18
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

    public void setScaleFromTextSize(float r10) {
        this.mBaseTextSize = r10;
    }

    public void setText(CharSequence r10) {
        this.mText = r10.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float r10) {
        this.mBackgroundPanX = r10;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundPanY(float r10) {
        this.mBackgroundPanY = r10;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundRotate(float r10) {
        this.mRotate = r10;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundZoom(float r10) {
        this.mZoom = r10;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextFillColor(int r10) {
        this.mTextFillColor = r10;
        invalidate();
    }

    public void setTextOutlineColor(int r10) {
        this.mTextOutlineColor = r10;
        this.mUseOutline = true;
        invalidate();
    }

    public void setTextOutlineThickness(float r10) {
        this.mTextOutlineThickness = r10;
        this.mUseOutline = true;
        if (Float.isNaN(r10) == false) goto L5;
        this.mTextOutlineThickness = 1.0f;
        this.mUseOutline = false;
    L5:
        invalidate();
    }

    public void setTextPanX(float r10) {
        this.mTextPanX = r10;
        invalidate();
    }

    public void setTextPanY(float r10) {
        this.mTextPanY = r10;
        invalidate();
    }

    public void setTextSize(float r10) {
        this.mTextSize = r10;
        Log.v(TAG, Debug.getLoc() + "  " + r10 + " / " + this.mBaseTextSize);
        TextPaint r11 = this.mPaint;
        if (Float.isNaN(this.mBaseTextSize) == true) goto L6;
        r10 = this.mBaseTextSize;
    L6:
        r11.setTextSize(r10);
        if (Float.isNaN(this.mBaseTextSize) == false) goto L9;
        float r12 = 1.0f;
    L10:
        buildShape(r12);
        requestLayout();
        invalidate();
        return;
    L9:
        r12 = this.mTextSize / this.mBaseTextSize;
        goto L10
    }

    public void setTextureHeight(float r10) {
        this.mTextureHeight = r10;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextureWidth(float r10) {
        this.mTextureWidth = r10;
        updateShaderMatrix();
        invalidate();
    }

    public void setTypeface(Typeface r10) {
        if (this.mPaint.getTypeface() == r10) goto L8;
        this.mPaint.setTypeface(r10);
        if (this.mLayout == null) goto L9;
        this.mLayout = null;
        requestLayout();
        invalidate();
        return;
    L9:
        return;
    }

    void setupPath() {
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
        setTypefaceFromAttrs(this.mFontFamily, this.mTypefaceIndex, this.mStyleIndex);
        this.mPaint.setColor(this.mTextFillColor);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setFlags(128);
        setTextSize(this.mTextSize);
        this.mPaint.setAntiAlias(true);
    }
}
