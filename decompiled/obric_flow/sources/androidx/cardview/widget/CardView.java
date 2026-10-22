package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;

/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = null;
    private static final CardViewImpl IMPL = null;
    private final CardViewDelegate mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    static {
        COLOR_BACKGROUND_ATTR = new int[]{R.attr.colorBackground};
        CardViewApi21Impl r5 = new CardViewApi21Impl();
        IMPL = r5;
        r5.initStatic();
    }

    public CardView(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ void access$001(CardView r5, int r10, int r11, int r12, int r13) {
        super.setPadding(r10, r11, r12, r13);
    }

    public static /* synthetic */ void access$101(CardView r5, int r10) {
        super.setMinimumWidth(r10);
    }

    public static /* synthetic */ void access$201(CardView r5, int r10) {
        super.setMinimumHeight(r10);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return IMPL.getBackgroundColor(this.mCardViewDelegate);
    }

    public float getCardElevation() {
        return IMPL.getElevation(this.mCardViewDelegate);
    }

    @Px
    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    @Px
    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    @Px
    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    @Px
    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return IMPL.getMaxElevation(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return IMPL.getRadius(this.mCardViewDelegate);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        CardViewImpl r5 = IMPL;
        if ((r5 instanceof CardViewApi21Impl) == true) goto L15;
        int r12 = View.MeasureSpec.getMode(r10);
        if (r12 == Integer.MIN_VALUE) goto L8;
        if (r12 == 1073741824) goto L8;
    L9:
        int r13 = View.MeasureSpec.getMode(r11);
        if (r13 == Integer.MIN_VALUE) goto L13;
        if (r13 == 1073741824) goto L13;
    L14:
        super.onMeasure(r10, r11);
        return;
    L13:
        r11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r5.getMinHeight(this.mCardViewDelegate)), View.MeasureSpec.getSize(r11)), r13);
    L8:
        r10 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r5.getMinWidth(this.mCardViewDelegate)), View.MeasureSpec.getSize(r10)), r12);
        goto L9
    L15:
        super.onMeasure(r10, r11);
    }

    public void setCardBackgroundColor(@ColorInt int r5) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, ColorStateList.valueOf(r5));
    }

    public void setCardElevation(float r5) {
        IMPL.setElevation(this.mCardViewDelegate, r5);
    }

    public void setContentPadding(@Px int r5, @Px int r10, @Px int r11, @Px int r12) {
        this.mContentPadding.set(r5, r10, r11, r12);
        IMPL.updatePadding(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float r5) {
        IMPL.setMaxElevation(this.mCardViewDelegate, r5);
    }

    @Override // android.view.View
    public void setMinimumHeight(int r5) {
        this.mUserSetMinHeight = r5;
        super.setMinimumHeight(r5);
    }

    @Override // android.view.View
    public void setMinimumWidth(int r5) {
        this.mUserSetMinWidth = r5;
        super.setMinimumWidth(r5);
    }

    @Override // android.view.View
    public void setPadding(int r5, int r10, int r11, int r12) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int r5, int r10, int r11, int r12) {
    }

    public void setPreventCornerOverlap(boolean r5) {
        if (r5 == this.mPreventCornerOverlap) goto L6;
        this.mPreventCornerOverlap = r5;
        IMPL.onPreventCornerOverlapChanged(this.mCardViewDelegate);
        return;
    }

    public void setRadius(float r5) {
        IMPL.setRadius(this.mCardViewDelegate, r5);
    }

    public void setUseCompatPadding(boolean r5) {
        if (this.mCompatPadding == r5) goto L6;
        this.mCompatPadding = r5;
        IMPL.onCompatPaddingChanged(this.mCardViewDelegate);
        return;
    }

    public CardView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, androidx.cardview.R.attr.cardViewStyle);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList r5) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, r5);
    }

    public CardView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        Rect r5 = new Rect();
        this.mContentPadding = r5;
        this.mShadowBounds = new Rect();
        CardViewDelegate r13 = new AnonymousClass1(this);
        this.mCardViewDelegate = r13;
        TypedArray r14 = r10.obtainStyledAttributes(r11, androidx.cardview.R.styleable.CardView, r12, androidx.cardview.R.style.CardView);
        if (r14.hasValue(androidx.cardview.R.styleable.CardView_cardBackgroundColor) == false) goto L6;
        ColorStateList r15 = r14.getColorStateList(androidx.cardview.R.styleable.CardView_cardBackgroundColor);
    L5:
        ColorStateList r16 = r15;
        float r17 = r14.getDimension(androidx.cardview.R.styleable.CardView_cardCornerRadius, 0.0f);
        float r18 = r14.getDimension(androidx.cardview.R.styleable.CardView_cardElevation, 0.0f);
        float r19 = r14.getDimension(androidx.cardview.R.styleable.CardView_cardMaxElevation, 0.0f);
        this.mCompatPadding = r14.getBoolean(androidx.cardview.R.styleable.CardView_cardUseCompatPadding, false);
        this.mPreventCornerOverlap = r14.getBoolean(androidx.cardview.R.styleable.CardView_cardPreventCornerOverlap, true);
        int r20 = r14.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPadding, 0);
        r5.left = r14.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingLeft, r20);
        r5.top = r14.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingTop, r20);
        r5.right = r14.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingRight, r20);
        r5.bottom = r14.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingBottom, r20);
        if (r18 <= r19) goto L14;
        float r21 = r18;
    L15:
        this.mUserSetMinWidth = r14.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minWidth, 0);
        this.mUserSetMinHeight = r14.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minHeight, 0);
        r14.recycle();
        IMPL.initialize(r13, r10, r16, r17, r18, r21);
        return;
    L14:
        r21 = r19;
        goto L15
    L6:
        TypedArray r110 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
        int r22 = r110.getColor(0, 0);
        r110.recycle();
        float[] r111 = new float[3];
        Color.colorToHSV(r22, r111);
        if (r111[2] <= 0.5f) goto L9;
        int r112 = getResources().getColor(androidx.cardview.R.color.cardview_light_background);
    L10:
        r15 = ColorStateList.valueOf(r112);
        goto L5
    L9:
        r112 = getResources().getColor(androidx.cardview.R.color.cardview_dark_background);
        goto L10
    }
}
