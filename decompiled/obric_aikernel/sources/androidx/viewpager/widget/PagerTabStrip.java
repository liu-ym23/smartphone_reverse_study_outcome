package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {
    private static final int FULL_UNDERLINE_HEIGHT = 1;
    private static final int INDICATOR_HEIGHT = 3;
    private static final int MIN_PADDING_BOTTOM = 6;
    private static final int MIN_STRIP_HEIGHT = 32;
    private static final int MIN_TEXT_SPACING = 64;
    private static final int TAB_PADDING = 16;
    private static final int TAB_SPACING = 32;
    private static final String TAG = "PagerTabStrip";
    private boolean mDrawFullUnderline;
    private boolean mDrawFullUnderlineSet;
    private int mFullUnderlineHeight;
    private boolean mIgnoreTap;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mMinPaddingBottom;
    private int mMinStripHeight;
    private int mMinTextSpacing;
    private int mTabAlpha;
    private int mTabPadding;
    private final Paint mTabPaint;
    private final Rect mTempRect;
    private int mTouchSlop;

    public PagerTabStrip(@NonNull Context r10) {
        this(r10, null);
    }

    public PagerTabStrip(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        Paint r12 = new Paint();
        this.mTabPaint = r12;
        this.mTempRect = new Rect();
        this.mTabAlpha = 255;
        this.mDrawFullUnderline = false;
        this.mDrawFullUnderlineSet = false;
        int r13 = this.mTextColor;
        this.mIndicatorColor = r13;
        r12.setColor(r13);
        float r14 = r10.getResources().getDisplayMetrics().density;
        this.mIndicatorHeight = (int) ((3.0f * r14) + 0.5f);
        this.mMinPaddingBottom = (int) ((6.0f * r14) + 0.5f);
        this.mMinTextSpacing = (int) (64.0f * r14);
        this.mTabPadding = (int) ((16.0f * r14) + 0.5f);
        this.mFullUnderlineHeight = (int) ((1.0f * r14) + 0.5f);
        this.mMinStripHeight = (int) ((r14 * 32.0f) + 0.5f);
        this.mTouchSlop = ViewConfiguration.get(r10).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.mPrevText.setFocusable(true);
        this.mPrevText.setOnClickListener(new AnonymousClass1(this));
        this.mNextText.setFocusable(true);
        this.mNextText.setOnClickListener(new AnonymousClass2(this));
        if (getBackground() != null) goto L6;
        this.mDrawFullUnderline = true;
        return;
    }

    public boolean getDrawFullUnderline() {
        return this.mDrawFullUnderline;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.mMinStripHeight);
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.mIndicatorColor;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r15) {
        super.onDraw(r15);
        int r10 = getHeight();
        int r11 = this.mCurrText.getLeft() - this.mTabPadding;
        int r12 = this.mCurrText.getRight() + this.mTabPadding;
        int r13 = r10 - this.mIndicatorHeight;
        this.mTabPaint.setColor((this.mTabAlpha << 24) | (this.mIndicatorColor & ViewCompat.MEASURED_SIZE_MASK));
        float r14 = r10;
        r15.drawRect(r11, r13, r12, r14, this.mTabPaint);
        if (this.mDrawFullUnderline == false) goto L6;
        this.mTabPaint.setColor((-16777216) | (this.mIndicatorColor & ViewCompat.MEASURED_SIZE_MASK));
        r15.drawRect(getPaddingLeft(), r10 - this.mFullUnderlineHeight, getWidth() - getPaddingRight(), r14, this.mTabPaint);
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        int r11 = r10.getAction();
        if (r11 != 0) goto L5;
    L7:
        float r12 = r10.getX();
        float r13 = r10.getY();
        if (r11 == 0) goto L25;
        if (r11 == 1) goto L19;
        if (r11 == 2) goto L14;
    L26:
        return true;
    L14:
        if (Math.abs(r12 - this.mInitialMotionX) <= this.mTouchSlop) goto L16;
    L17:
        this.mIgnoreTap = true;
        goto L26
    L16:
        if (Math.abs(r13 - this.mInitialMotionY) <= this.mTouchSlop) goto L26;
    L19:
        if (r12 >= (this.mCurrText.getLeft() - this.mTabPadding)) goto L23;
        ViewPager r14 = this.mPager;
        int r15 = r14.getCurrentItem() - 1;
    L21:
        r14.setCurrentItem(r15);
        goto L26
    L23:
        if (r12 <= (this.mCurrText.getRight() + this.mTabPadding)) goto L26;
        r14 = this.mPager;
        r15 = r14.getCurrentItem() + 1;
        goto L21
    L25:
        this.mInitialMotionX = r12;
        this.mInitialMotionY = r13;
        this.mIgnoreTap = false;
        goto L26
    L5:
        if (this.mIgnoreTap == false) goto L7;
        return false;
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int r10) {
        super.setBackgroundColor(r10);
        if (this.mDrawFullUnderlineSet == false) goto L5;
        return;
    L5:
        if ((r10 & ViewCompat.MEASURED_STATE_MASK) != 0) goto L7;
        boolean r11 = true;
    L8:
        this.mDrawFullUnderline = r11;
        return;
    L7:
        r11 = false;
        goto L8
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r10) {
        super.setBackgroundDrawable(r10);
        if (this.mDrawFullUnderlineSet == true) goto L9;
        if (r10 != null) goto L6;
        boolean r11 = true;
    L7:
        this.mDrawFullUnderline = r11;
        return;
    L6:
        r11 = false;
        goto L7
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int r10) {
        super.setBackgroundResource(r10);
        if (this.mDrawFullUnderlineSet == true) goto L9;
        if (r10 != 0) goto L6;
        boolean r11 = true;
    L7:
        this.mDrawFullUnderline = r11;
        return;
    L6:
        r11 = false;
        goto L7
    }

    public void setDrawFullUnderline(boolean r10) {
        this.mDrawFullUnderline = r10;
        this.mDrawFullUnderlineSet = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int r10, int r11, int r12, int r13) {
        int r14 = this.mMinPaddingBottom;
        if (r13 >= r14) goto L5;
        r13 = r14;
    L5:
        super.setPadding(r10, r11, r12, r13);
    }

    public void setTabIndicatorColor(@ColorInt int r10) {
        this.mIndicatorColor = r10;
        this.mTabPaint.setColor(r10);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int r10) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), r10));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int r10) {
        int r11 = this.mMinTextSpacing;
        if (r10 >= r11) goto L5;
        r10 = r11;
    L5:
        super.setTextSpacing(r10);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    void updateTextPositions(int r10, float r11, boolean r12) {
        Rect r13 = this.mTempRect;
        int r14 = getHeight();
        int r15 = this.mCurrText.getLeft() - this.mTabPadding;
        int r16 = this.mCurrText.getRight() + this.mTabPadding;
        int r17 = r14 - this.mIndicatorHeight;
        r13.set(r15, r17, r16, r14);
        super.updateTextPositions(r10, r11, r12);
        this.mTabAlpha = (int) ((Math.abs(r11 - 0.5f) * 2.0f) * 255.0f);
        r13.union(this.mCurrText.getLeft() - this.mTabPadding, r17, this.mCurrText.getRight() + this.mTabPadding, r14);
        invalidate(r13);
    }
}
