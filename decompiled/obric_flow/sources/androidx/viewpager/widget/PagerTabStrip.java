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

    public PagerTabStrip(@NonNull Context r5) {
        this(r5, null);
    }

    public boolean getDrawFullUnderline() {
        return this.mDrawFullUnderline;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.mMinStripHeight);
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.mIndicatorColor;
    }

    @Override // android.view.View
    public void onDraw(Canvas r15) {
        super.onDraw(r15);
        int r5 = getHeight();
        int r10 = this.mCurrText.getLeft() - this.mTabPadding;
        int r11 = this.mCurrText.getRight() + this.mTabPadding;
        int r12 = r5 - this.mIndicatorHeight;
        this.mTabPaint.setColor((this.mTabAlpha << 24) | (this.mIndicatorColor & ViewCompat.MEASURED_SIZE_MASK));
        float r13 = r5;
        r15.drawRect(r10, r12, r11, r13, this.mTabPaint);
        if (this.mDrawFullUnderline == false) goto L6;
        this.mTabPaint.setColor((this.mIndicatorColor & ViewCompat.MEASURED_SIZE_MASK) | ViewCompat.MEASURED_STATE_MASK);
        r15.drawRect(getPaddingLeft(), r5 - this.mFullUnderlineHeight, getWidth() - getPaddingRight(), r13, this.mTabPaint);
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        int r10 = r5.getAction();
        if (r10 != 0) goto L5;
    L7:
        float r11 = r5.getX();
        float r12 = r5.getY();
        if (r10 == 0) goto L24;
        if (r10 == 1) goto L19;
        if (r10 == 2) goto L14;
    L25:
        return true;
    L14:
        if (Math.abs(r11 - this.mInitialMotionX) <= this.mTouchSlop) goto L16;
    L17:
        this.mIgnoreTap = true;
        goto L25
    L16:
        if (Math.abs(r12 - this.mInitialMotionY) <= this.mTouchSlop) goto L25;
    L19:
        if (r11 >= (this.mCurrText.getLeft() - this.mTabPadding)) goto L22;
        ViewPager r13 = this.mPager;
        r13.setCurrentItem(r13.getCurrentItem() - 1);
        goto L25
    L22:
        if (r11 <= (this.mCurrText.getRight() + this.mTabPadding)) goto L25;
        ViewPager r14 = this.mPager;
        r14.setCurrentItem(r14.getCurrentItem() + 1);
        goto L25
    L24:
        this.mInitialMotionX = r11;
        this.mInitialMotionY = r12;
        this.mIgnoreTap = false;
        goto L25
    L5:
        if (this.mIgnoreTap == false) goto L7;
        return false;
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int r5) {
        super.setBackgroundColor(r5);
        if (this.mDrawFullUnderlineSet == false) goto L5;
        return;
    L5:
        if ((r5 & ViewCompat.MEASURED_STATE_MASK) != 0) goto L7;
        boolean r10 = true;
    L8:
        this.mDrawFullUnderline = r10;
        return;
    L7:
        r10 = false;
        goto L8
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r5) {
        super.setBackgroundDrawable(r5);
        if (this.mDrawFullUnderlineSet == true) goto L9;
        if (r5 != null) goto L6;
        boolean r10 = true;
    L7:
        this.mDrawFullUnderline = r10;
        return;
    L6:
        r10 = false;
        goto L7
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int r5) {
        super.setBackgroundResource(r5);
        if (this.mDrawFullUnderlineSet == true) goto L9;
        if (r5 != 0) goto L6;
        boolean r10 = true;
    L7:
        this.mDrawFullUnderline = r10;
        return;
    L6:
        r10 = false;
        goto L7
    }

    public void setDrawFullUnderline(boolean r5) {
        this.mDrawFullUnderline = r5;
        this.mDrawFullUnderlineSet = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int r5, int r10, int r11, int r12) {
        int r13 = this.mMinPaddingBottom;
        if (r12 >= r13) goto L5;
        r12 = r13;
    L5:
        super.setPadding(r5, r10, r11, r12);
    }

    public void setTabIndicatorColor(@ColorInt int r5) {
        this.mIndicatorColor = r5;
        this.mTabPaint.setColor(r5);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int r5) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), r5));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int r5) {
        int r10 = this.mMinTextSpacing;
        if (r5 >= r10) goto L5;
        r5 = r10;
    L5:
        super.setTextSpacing(r5);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void updateTextPositions(int r10, float r11, boolean r12) {
        Rect r5 = this.mTempRect;
        int r13 = getHeight();
        int r14 = this.mCurrText.getLeft() - this.mTabPadding;
        int r15 = this.mCurrText.getRight() + this.mTabPadding;
        int r16 = r13 - this.mIndicatorHeight;
        r5.set(r14, r16, r15, r13);
        super.updateTextPositions(r10, r11, r12);
        this.mTabAlpha = (int) ((Math.abs(r11 - 0.5f) * 2.0f) * 255.0f);
        r5.union(this.mCurrText.getLeft() - this.mTabPadding, r16, this.mCurrText.getRight() + this.mTabPadding, r13);
        invalidate(r5);
    }

    public PagerTabStrip(@NonNull Context r5, @Nullable AttributeSet r10) {
        super(r5, r10);
        Paint r11 = new Paint();
        this.mTabPaint = r11;
        this.mTempRect = new Rect();
        this.mTabAlpha = 255;
        this.mDrawFullUnderline = false;
        this.mDrawFullUnderlineSet = false;
        int r12 = this.mTextColor;
        this.mIndicatorColor = r12;
        r11.setColor(r12);
        float r13 = r5.getResources().getDisplayMetrics().density;
        this.mIndicatorHeight = (int) ((3.0f * r13) + 0.5f);
        this.mMinPaddingBottom = (int) ((6.0f * r13) + 0.5f);
        this.mMinTextSpacing = (int) (64.0f * r13);
        this.mTabPadding = (int) ((16.0f * r13) + 0.5f);
        this.mFullUnderlineHeight = (int) ((1.0f * r13) + 0.5f);
        this.mMinStripHeight = (int) ((r13 * 32.0f) + 0.5f);
        this.mTouchSlop = ViewConfiguration.get(r5).getScaledTouchSlop();
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
}
