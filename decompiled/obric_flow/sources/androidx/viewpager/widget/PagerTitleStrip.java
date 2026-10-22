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
import com.google.android.material.color.utilities.Contrast;
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

    public class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
        private int mScrollState;
        final /* synthetic */ PagerTitleStrip this$0;

        public PageListener(PagerTitleStrip r5) {
            this.this$0 = r5;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager r5, PagerAdapter r10, PagerAdapter r11) {
            this.this$0.updateAdapter(r10, r11);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip r5 = this.this$0;
            r5.updateText(r5.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
            PagerTitleStrip r10 = this.this$0;
            float r11 = r10.mLastKnownPositionOffset;
            if (r11 >= 0.0f) goto L6;
            r11 = 0.0f;
        L6:
            r10.updateTextPositions(r10.mPager.getCurrentItem(), r11, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r5) {
            this.mScrollState = r5;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r5, float r10, int r11) {
            if (r10 <= 0.5f) goto L5;
            r5 = r5 + 1;
        L5:
            this.this$0.updateTextPositions(r5, r10, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r5) {
            if (this.mScrollState != 0) goto L10;
            PagerTitleStrip r10 = this.this$0;
            r10.updateText(r10.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
            PagerTitleStrip r11 = this.this$0;
            float r12 = r11.mLastKnownPositionOffset;
            if (r12 >= 0.0f) goto L8;
            r12 = 0.0f;
        L8:
            r11.updateTextPositions(r11.mPager.getCurrentItem(), r12, true);
            return;
        }
    }

    public static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
        private Locale mLocale;

        public SingleLineAllCapsTransform(Context r5) {
            this.mLocale = r5.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence r5, View r10) {
            CharSequence r11 = super.getTransformation(r5, r10);
            if (r11 != null) goto L7;
            return null;
        L7:
            return r11.toString().toUpperCase(this.mLocale);
        }
    }

    static {
        ATTRS = new int[]{R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};
        TEXT_ATTRS = new int[]{R.attr.textAllCaps};
    }

    public PagerTitleStrip(@NonNull Context r5) {
        this(r5, null);
    }

    private static void setSingleLineAllCaps(TextView r5) {
        r5.setTransformationMethod(new SingleLineAllCapsTransform(r5.getContext()));
    }

    public int getMinHeight() {
        Drawable r5 = getBackground();
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getIntrinsicHeight();
    }

    public int getTextSpacing() {
        return this.mScaledTextSpacing;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r5 = getParent();
        if ((r5 instanceof ViewPager) == false) goto L11;
        ViewPager r10 = (ViewPager) r5;
        PagerAdapter r11 = r10.getAdapter();
        r10.setInternalPageChangeListener(this.mPageListener);
        r10.addOnAdapterChangeListener(this.mPageListener);
        this.mPager = r10;
        WeakReference<PagerAdapter> r12 = this.mWatchingAdapter;
        if (r12 == null) goto L7;
        PagerAdapter r13 = r12.get();
    L8:
        updateAdapter(r13, r11);
        return;
    L7:
        r13 = null;
        goto L8
    L11:
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager r5 = this.mPager;
        if (r5 == null) goto L6;
        updateAdapter(r5.getAdapter(), null);
        this.mPager.setInternalPageChangeListener(null);
        this.mPager.removeOnAdapterChangeListener(this.mPageListener);
        this.mPager = null;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        if (this.mPager == null) goto L10;
        float r14 = this.mLastKnownPositionOffset;
        if (r14 >= 0.0f) goto L8;
        r14 = 0.0f;
    L8:
        updateTextPositions(this.mLastKnownCurrentPage, r14, true);
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        if (View.MeasureSpec.getMode(r10) != 1073741824) goto L11;
        int r5 = getPaddingBottom() + getPaddingTop();
        int r12 = ViewGroup.getChildMeasureSpec(r11, r5, -2);
        int r13 = View.MeasureSpec.getSize(r10);
        int r14 = ViewGroup.getChildMeasureSpec(r10, (int) (r13 * 0.2f), -2);
        this.mPrevText.measure(r14, r12);
        this.mCurrText.measure(r14, r12);
        this.mNextText.measure(r14, r12);
        if (View.MeasureSpec.getMode(r11) != 1073741824) goto L7;
        int r15 = View.MeasureSpec.getSize(r11);
    L8:
        setMeasuredDimension(r13, View.resolveSizeAndState(r15, r11, this.mCurrText.getMeasuredState() << 16));
        return;
    L7:
        r15 = Math.max(getMinHeight(), this.mCurrText.getMeasuredHeight() + r5);
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

    public void setGravity(int r5) {
        this.mGravity = r5;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5) {
        int r10 = ((int) (r5 * 255.0f)) & 255;
        this.mNonPrimaryAlpha = r10;
        int r11 = (r10 << 24) | (this.mTextColor & ViewCompat.MEASURED_SIZE_MASK);
        this.mPrevText.setTextColor(r11);
        this.mNextText.setTextColor(r11);
    }

    public void setTextColor(@ColorInt int r5) {
        this.mTextColor = r5;
        this.mCurrText.setTextColor(r5);
        int r10 = (this.mNonPrimaryAlpha << 24) | (this.mTextColor & ViewCompat.MEASURED_SIZE_MASK);
        this.mPrevText.setTextColor(r10);
        this.mNextText.setTextColor(r10);
    }

    public void setTextSize(int r5, float r10) {
        this.mPrevText.setTextSize(r5, r10);
        this.mCurrText.setTextSize(r5, r10);
        this.mNextText.setTextSize(r5, r10);
    }

    public void setTextSpacing(int r5) {
        this.mScaledTextSpacing = r5;
        requestLayout();
    }

    public void updateAdapter(PagerAdapter r5, PagerAdapter r10) {
        if (r5 == null) goto L4;
        r5.unregisterDataSetObserver(this.mPageListener);
        this.mWatchingAdapter = null;
    L4:
        if (r10 == null) goto L6;
        r10.registerDataSetObserver(this.mPageListener);
        this.mWatchingAdapter = new WeakReference(r10);
    L6:
        ViewPager r11 = this.mPager;
        if (r11 == null) goto L10;
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        updateText(r11.getCurrentItem(), r10);
        requestLayout();
        return;
    }

    public void updateText(int r10, PagerAdapter r11) {
        if (r11 == null) goto L5;
        int r5 = r11.getCount();
    L6:
        this.mUpdatingText = true;
        CharSequence r12 = null;
        if (r10 < 1) goto L10;
        if (r11 == null) goto L10;
        CharSequence r13 = r11.getPageTitle(r10 - 1);
    L11:
        this.mPrevText.setText(r13);
        TextView r14 = this.mCurrText;
        if (r11 == null) goto L15;
        if (r10 >= r5) goto L15;
        CharSequence r15 = r11.getPageTitle(r10);
    L16:
        r14.setText(r15);
        int r16 = r10 + 1;
        if (r16 >= r5) goto L20;
        if (r11 == null) goto L20;
        r12 = r11.getPageTitle(r16);
    L20:
        this.mNextText.setText(r12);
        int r17 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int r18 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.mPrevText.measure(r17, r18);
        this.mCurrText.measure(r17, r18);
        this.mNextText.measure(r17, r18);
        this.mLastKnownCurrentPage = r10;
        if (this.mUpdatingPositions == true) goto L23;
        updateTextPositions(r10, this.mLastKnownPositionOffset, false);
    L23:
        this.mUpdatingText = false;
        return;
    L15:
        r15 = null;
    L10:
        r13 = null;
        goto L11
    L5:
        r5 = 0;
        goto L6
    }

    public void updateTextPositions(int r18, float r19, boolean r20) {
        if (r18 == this.mLastKnownCurrentPage) goto L5;
        updateText(r18, this.mPager.getAdapter());
    L9:
        this.mUpdatingPositions = true;
        int r5 = this.mPrevText.getMeasuredWidth();
        int r10 = this.mCurrText.getMeasuredWidth();
        int r11 = this.mNextText.getMeasuredWidth();
        int r12 = r10 / 2;
        int r13 = getWidth();
        int r14 = getHeight();
        int r15 = getPaddingLeft();
        int r16 = getPaddingRight();
        int r17 = getPaddingTop();
        int r110 = getPaddingBottom();
        int r111 = r16 + r12;
        int r112 = (r13 - (r15 + r12)) - r111;
        float r113 = 0.5f + r19;
        if (r113 <= 1.0f) goto L12;
        r113 = r113 - 1.0f;
    L12:
        int r114 = ((r13 - r111) - ((int) (r112 * r113))) - r12;
        int r21 = r10 + r114;
        int r22 = this.mPrevText.getBaseline();
        int r115 = this.mCurrText.getBaseline();
        int r116 = this.mNextText.getBaseline();
        int r117 = Math.max(Math.max(r22, r115), r116);
        int r23 = r117 - r22;
        int r118 = r117 - r115;
        int r119 = r117 - r116;
        int r120 = this.mPrevText.getMeasuredHeight() + r23;
        int r24 = this.mCurrText.getMeasuredHeight() + r118;
        int r25 = Math.max(Math.max(r120, r24), this.mNextText.getMeasuredHeight() + r119);
        int r26 = this.mGravity & 112;
        if (r26 != 16) goto L15;
        int r27 = (((r14 - r17) - r110) - r25) / 2;
    L18:
        int r28 = r23 + r27;
        int r121 = r118 + r27;
        int r122 = r27 + r119;
    L20:
        TextView r29 = this.mCurrText;
        r29.layout(r114, r121, r21, r29.getMeasuredHeight() + r121);
        int r30 = Math.min(r15, (r114 - this.mScaledTextSpacing) - r5);
        TextView r31 = this.mPrevText;
        r31.layout(r30, r28, r5 + r30, r31.getMeasuredHeight() + r28);
        int r32 = Math.max((r13 - r16) - r11, r21 + this.mScaledTextSpacing);
        TextView r33 = this.mNextText;
        r33.layout(r32, r122, r32 + r11, r33.getMeasuredHeight() + r122);
        this.mLastKnownPositionOffset = r19;
        this.mUpdatingPositions = false;
        return;
    L15:
        if (r26 == 80) goto L17;
        r28 = r23 + r17;
        r121 = r118 + r17;
        r122 = r17 + r119;
        goto L20
    L17:
        r27 = (r14 - r110) - r25;
        goto L18
    L5:
        if (r20 == true) goto L9;
        if (r19 != this.mLastKnownPositionOffset) goto L9;
    }

    public PagerTitleStrip(@NonNull Context r5, @Nullable AttributeSet r10) {
        super(r5, r10);
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        this.mPageListener = new PageListener(this);
        TextView r11 = new TextView(r5);
        this.mPrevText = r11;
        addView(r11);
        TextView r12 = new TextView(r5);
        this.mCurrText = r12;
        addView(r12);
        TextView r13 = new TextView(r5);
        this.mNextText = r13;
        addView(r13);
        TypedArray r14 = r5.obtainStyledAttributes(r10, ATTRS);
        boolean r15 = false;
        int r16 = r14.getResourceId(0, 0);
        if (r16 == 0) goto L5;
        TextViewCompat.setTextAppearance(this.mPrevText, r16);
        TextViewCompat.setTextAppearance(this.mCurrText, r16);
        TextViewCompat.setTextAppearance(this.mNextText, r16);
    L5:
        int r17 = r14.getDimensionPixelSize(1, 0);
        if (r17 == 0) goto L9;
        setTextSize(0, r17);
    L9:
        if (r14.hasValue(2) == false) goto L11;
        int r18 = r14.getColor(2, 0);
        this.mPrevText.setTextColor(r18);
        this.mCurrText.setTextColor(r18);
        this.mNextText.setTextColor(r18);
    L11:
        this.mGravity = r14.getInteger(3, 80);
        r14.recycle();
        this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(SIDE_ALPHA);
        TextView r19 = this.mPrevText;
        TextUtils.TruncateAt r20 = TextUtils.TruncateAt.END;
        r19.setEllipsize(r20);
        this.mCurrText.setEllipsize(r20);
        this.mNextText.setEllipsize(r20);
        if (r16 == 0) goto L14;
        TypedArray r21 = r5.obtainStyledAttributes(r16, TEXT_ATTRS);
        r15 = r21.getBoolean(0, false);
        r21.recycle();
    L14:
        if (r15 == false) goto L16;
        setSingleLineAllCaps(this.mPrevText);
        setSingleLineAllCaps(this.mCurrText);
        setSingleLineAllCaps(this.mNextText);
    L17:
        this.mScaledTextSpacing = (int) (r5.getResources().getDisplayMetrics().density * 16.0f);
        return;
    L16:
        this.mPrevText.setSingleLine();
        this.mCurrText.setSingleLine();
        this.mNextText.setSingleLine();
        goto L17
    }
}
