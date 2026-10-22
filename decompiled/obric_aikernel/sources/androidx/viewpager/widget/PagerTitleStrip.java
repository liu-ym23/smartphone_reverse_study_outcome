package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@ViewPager.DecorView
public class PagerTitleStrip extends ViewGroup {
    private static final int[] ATTRS = null;
    private static final float SIDE_ALPHA = 0.6f;
    private static final int[] TEXT_ATTRS = null;
    private static final int TEXT_SPACING = 16;
    TextView mCurrText;
    private int mGravity;
    private int mLastKnownCurrentPage;
    float mLastKnownPositionOffset;
    TextView mNextText;
    private int mNonPrimaryAlpha;
    private final PageListener mPageListener;
    ViewPager mPager;
    TextView mPrevText;
    private int mScaledTextSpacing;
    int mTextColor;
    private boolean mUpdatingPositions;
    private boolean mUpdatingText;
    private WeakReference<PagerAdapter> mWatchingAdapter;

    private class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
        private int mScrollState;
        final /* synthetic */ PagerTitleStrip this$0;

        PageListener(PagerTitleStrip r10) {
            this.this$0 = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager r10, PagerAdapter r11, PagerAdapter r12) {
            this.this$0.updateAdapter(r11, r12);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip r10 = this.this$0;
            r10.updateText(r10.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
            PagerTitleStrip r11 = this.this$0;
            float r12 = r11.mLastKnownPositionOffset;
            if (r12 >= 0.0f) goto L6;
            r12 = 0.0f;
        L6:
            r11.updateTextPositions(r11.mPager.getCurrentItem(), r12, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r10) {
            this.mScrollState = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r10, float r11, int r12) {
            if (r11 <= 0.5f) goto L5;
            r10 = r10 + 1;
        L5:
            this.this$0.updateTextPositions(r10, r11, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r10) {
            if (this.mScrollState != 0) goto L10;
            PagerTitleStrip r11 = this.this$0;
            r11.updateText(r11.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
            PagerTitleStrip r12 = this.this$0;
            float r13 = r12.mLastKnownPositionOffset;
            if (r13 >= 0.0f) goto L8;
            r13 = 0.0f;
        L8:
            r12.updateTextPositions(r12.mPager.getCurrentItem(), r13, true);
            return;
        }
    }

    private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
        private Locale mLocale;

        SingleLineAllCapsTransform(Context r10) {
            this.mLocale = r10.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence r10, View r11) {
            CharSequence r12 = super.getTransformation(r10, r11);
            if (r12 != null) goto L7;
            return null;
        L7:
            return r12.toString().toUpperCase(this.mLocale);
        }
    }

    static {
        ATTRS = new int[]{R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};
        TEXT_ATTRS = new int[]{R.attr.textAllCaps};
    }

    public PagerTitleStrip(@NonNull Context r10) {
        this(r10, null);
    }

    public PagerTitleStrip(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        this.mPageListener = new PageListener(this);
        TextView r12 = new TextView(r10);
        this.mPrevText = r12;
        addView(r12);
        TextView r13 = new TextView(r10);
        this.mCurrText = r13;
        addView(r13);
        TextView r14 = new TextView(r10);
        this.mNextText = r14;
        addView(r14);
        TypedArray r15 = r10.obtainStyledAttributes(r11, ATTRS);
        boolean r16 = false;
        int r17 = r15.getResourceId(0, 0);
        if (r17 == 0) goto L5;
        TextViewCompat.setTextAppearance(this.mPrevText, r17);
        TextViewCompat.setTextAppearance(this.mCurrText, r17);
        TextViewCompat.setTextAppearance(this.mNextText, r17);
    L5:
        int r18 = r15.getDimensionPixelSize(1, 0);
        if (r18 == 0) goto L9;
        setTextSize(0, r18);
    L9:
        if (r15.hasValue(2) == false) goto L11;
        int r19 = r15.getColor(2, 0);
        this.mPrevText.setTextColor(r19);
        this.mCurrText.setTextColor(r19);
        this.mNextText.setTextColor(r19);
    L11:
        this.mGravity = r15.getInteger(3, 80);
        r15.recycle();
        this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(SIDE_ALPHA);
        this.mPrevText.setEllipsize(TextUtils.TruncateAt.END);
        this.mCurrText.setEllipsize(TextUtils.TruncateAt.END);
        this.mNextText.setEllipsize(TextUtils.TruncateAt.END);
        if (r17 == 0) goto L14;
        TypedArray r20 = r10.obtainStyledAttributes(r17, TEXT_ATTRS);
        r16 = r20.getBoolean(0, false);
        r20.recycle();
    L14:
        TextView r21 = this.mPrevText;
        if (r16 == false) goto L17;
        setSingleLineAllCaps(r21);
        setSingleLineAllCaps(this.mCurrText);
        setSingleLineAllCaps(this.mNextText);
    L18:
        this.mScaledTextSpacing = (int) (r10.getResources().getDisplayMetrics().density * 16.0f);
        return;
    L17:
        r21.setSingleLine();
        this.mCurrText.setSingleLine();
        this.mNextText.setSingleLine();
        goto L18
    }

    private static void setSingleLineAllCaps(TextView r10) {
        r10.setTransformationMethod(new SingleLineAllCapsTransform(r10.getContext()));
    }

    int getMinHeight() {
        Drawable r10 = getBackground();
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getIntrinsicHeight();
    }

    public int getTextSpacing() {
        return this.mScaledTextSpacing;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r10 = getParent();
        if ((r10 instanceof ViewPager) == false) goto L11;
        ViewPager r11 = (ViewPager) r10;
        PagerAdapter r12 = r11.getAdapter();
        r11.setInternalPageChangeListener(this.mPageListener);
        r11.addOnAdapterChangeListener(this.mPageListener);
        this.mPager = r11;
        WeakReference<PagerAdapter> r13 = this.mWatchingAdapter;
        if (r13 == null) goto L7;
        PagerAdapter r14 = r13.get();
    L8:
        updateAdapter(r14, r12);
        return;
    L7:
        r14 = null;
        goto L8
    L11:
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager r10 = this.mPager;
        if (r10 == null) goto L6;
        updateAdapter(r10.getAdapter(), null);
        this.mPager.setInternalPageChangeListener(null);
        this.mPager.removeOnAdapterChangeListener(this.mPageListener);
        this.mPager = null;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        if (this.mPager == null) goto L10;
        float r15 = this.mLastKnownPositionOffset;
        if (r15 >= 0.0f) goto L8;
        r15 = 0.0f;
    L8:
        updateTextPositions(this.mLastKnownCurrentPage, r15, true);
        return;
    }

    @Override // android.view.View
    protected void onMeasure(int r10, int r11) {
        if (View.MeasureSpec.getMode(r10) != 1073741824) goto L11;
        int r12 = getPaddingTop() + getPaddingBottom();
        int r13 = ViewGroup.getChildMeasureSpec(r11, r12, -2);
        int r14 = View.MeasureSpec.getSize(r10);
        int r15 = ViewGroup.getChildMeasureSpec(r10, (int) (r14 * 0.2f), -2);
        this.mPrevText.measure(r15, r13);
        this.mCurrText.measure(r15, r13);
        this.mNextText.measure(r15, r13);
        if (View.MeasureSpec.getMode(r11) != 1073741824) goto L7;
        int r16 = View.MeasureSpec.getSize(r11);
    L8:
        setMeasuredDimension(r14, View.resolveSizeAndState(r16, r11, this.mCurrText.getMeasuredState() << 16));
        return;
    L7:
        r16 = Math.max(getMinHeight(), this.mCurrText.getMeasuredHeight() + r12);
        goto L8
    L11:
        throw new IllegalStateException("Must measure with an exact width");
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mUpdatingText == true) goto L6;
        super.requestLayout();
        return;
    }

    public void setGravity(int r10) {
        this.mGravity = r10;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        int r11 = ((int) (r10 * 255.0f)) & 255;
        this.mNonPrimaryAlpha = r11;
        int r12 = (r11 << 24) | (this.mTextColor & ViewCompat.MEASURED_SIZE_MASK);
        this.mPrevText.setTextColor(r12);
        this.mNextText.setTextColor(r12);
    }

    public void setTextColor(@ColorInt int r10) {
        this.mTextColor = r10;
        this.mCurrText.setTextColor(r10);
        int r11 = (this.mNonPrimaryAlpha << 24) | (this.mTextColor & ViewCompat.MEASURED_SIZE_MASK);
        this.mPrevText.setTextColor(r11);
        this.mNextText.setTextColor(r11);
    }

    public void setTextSize(int r10, float r11) {
        this.mPrevText.setTextSize(r10, r11);
        this.mCurrText.setTextSize(r10, r11);
        this.mNextText.setTextSize(r10, r11);
    }

    public void setTextSpacing(int r10) {
        this.mScaledTextSpacing = r10;
        requestLayout();
    }

    void updateAdapter(PagerAdapter r10, PagerAdapter r11) {
        if (r10 == null) goto L4;
        r10.unregisterDataSetObserver(this.mPageListener);
        this.mWatchingAdapter = null;
    L4:
        if (r11 == null) goto L6;
        r11.registerDataSetObserver(this.mPageListener);
        this.mWatchingAdapter = new WeakReference(r11);
    L6:
        ViewPager r12 = this.mPager;
        if (r12 == null) goto L10;
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        updateText(r12.getCurrentItem(), r11);
        requestLayout();
        return;
    }

    void updateText(int r10, PagerAdapter r11) {
        if (r11 == null) goto L5;
        int r12 = r11.getCount();
    L6:
        this.mUpdatingText = true;
        CharSequence r13 = null;
        if (r10 < 1) goto L10;
        if (r11 == null) goto L10;
        CharSequence r14 = r11.getPageTitle(r10 - 1);
    L11:
        this.mPrevText.setText(r14);
        TextView r15 = this.mCurrText;
        if (r11 == null) goto L15;
        if (r10 >= r12) goto L15;
        CharSequence r16 = r11.getPageTitle(r10);
    L16:
        r15.setText(r16);
        int r17 = r10 + 1;
        if (r17 >= r12) goto L20;
        if (r11 == null) goto L20;
        r13 = r11.getPageTitle(r17);
    L20:
        this.mNextText.setText(r13);
        int r18 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int r19 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.mPrevText.measure(r18, r19);
        this.mCurrText.measure(r18, r19);
        this.mNextText.measure(r18, r19);
        this.mLastKnownCurrentPage = r10;
        if (this.mUpdatingPositions == true) goto L23;
        updateTextPositions(r10, this.mLastKnownPositionOffset, false);
    L23:
        this.mUpdatingText = false;
        return;
    L15:
        r16 = null;
    L10:
        r14 = null;
        goto L11
    L5:
        r12 = 0;
        goto L6
    }

    void updateTextPositions(int r18, float r19, boolean r20) {
        if (r18 == this.mLastKnownCurrentPage) goto L5;
        updateText(r18, this.mPager.getAdapter());
    L9:
        this.mUpdatingPositions = true;
        int r10 = this.mPrevText.getMeasuredWidth();
        int r11 = this.mCurrText.getMeasuredWidth();
        int r12 = this.mNextText.getMeasuredWidth();
        int r13 = r11 / 2;
        int r14 = getWidth();
        int r15 = getHeight();
        int r16 = getPaddingLeft();
        int r17 = getPaddingRight();
        int r110 = getPaddingTop();
        int r111 = getPaddingBottom();
        int r112 = r17 + r13;
        int r113 = (r14 - (r16 + r13)) - r112;
        float r114 = 0.5f + r19;
        if (r114 <= 1.0f) goto L12;
        r114 = r114 - 1.0f;
    L12:
        int r115 = ((r14 - r112) - ((int) (r113 * r114))) - r13;
        int r21 = r11 + r115;
        int r22 = this.mPrevText.getBaseline();
        int r116 = this.mCurrText.getBaseline();
        int r117 = this.mNextText.getBaseline();
        int r118 = Math.max(Math.max(r22, r116), r117);
        int r23 = r118 - r22;
        int r119 = r118 - r116;
        int r120 = r118 - r117;
        int r121 = this.mPrevText.getMeasuredHeight() + r23;
        int r24 = this.mCurrText.getMeasuredHeight() + r119;
        int r25 = Math.max(Math.max(r121, r24), this.mNextText.getMeasuredHeight() + r120);
        int r26 = this.mGravity & 112;
        if (r26 != 16) goto L15;
        int r27 = (((r15 - r110) - r111) - r25) / 2;
    L19:
        int r28 = r23 + r27;
        int r122 = r119 + r27;
        int r123 = r27 + r120;
    L20:
        TextView r29 = this.mCurrText;
        r29.layout(r115, r122, r21, r29.getMeasuredHeight() + r122);
        int r30 = Math.min(r16, (r115 - this.mScaledTextSpacing) - r10);
        TextView r31 = this.mPrevText;
        r31.layout(r30, r28, r10 + r30, r31.getMeasuredHeight() + r28);
        int r32 = Math.max((r14 - r17) - r12, r21 + this.mScaledTextSpacing);
        TextView r33 = this.mNextText;
        r33.layout(r32, r123, r32 + r12, r33.getMeasuredHeight() + r123);
        this.mLastKnownPositionOffset = r19;
        this.mUpdatingPositions = false;
        return;
    L15:
        if (r26 == 80) goto L17;
        r28 = r23 + r110;
        r122 = r119 + r110;
        r123 = r110 + r120;
        goto L20
    L17:
        r27 = (r15 - r111) - r25;
        goto L19
    L5:
        if (r20 == true) goto L9;
        if (r19 != this.mLastKnownPositionOffset) goto L9;
    }
}
