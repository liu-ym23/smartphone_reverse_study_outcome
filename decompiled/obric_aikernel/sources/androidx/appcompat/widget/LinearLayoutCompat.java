package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.card.MaterialCardView;
import com.ttnet.org.chromium.net.NetError;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface DividerMode {
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(int r10, int r11) {
            super(r10, r11);
        }

        public LayoutParams(int r10, int r11, float r12) {
            super(r10, r11, r12);
        }

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r10) {
            super(r10);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context r10) {
        this(r10, null);
    }

    public LinearLayoutCompat(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public LinearLayoutCompat(@NonNull Context r12, @Nullable AttributeSet r13, int r14) {
        super(r12, r13, r14);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        int[] r10 = R.styleable.LinearLayoutCompat;
        TintTypedArray r11 = TintTypedArray.obtainStyledAttributes(r12, r13, r10, r14, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r12, r10, r13, r11.getWrappedTypeArray(), r14, 0);
        int r15 = r11.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (r15 < 0) goto L5;
        setOrientation(r15);
    L5:
        int r16 = r11.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (r16 < 0) goto L8;
        setGravity(r16);
    L8:
        boolean r17 = r11.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (r17 == true) goto L11;
        setBaselineAligned(r17);
    L11:
        this.mWeightSum = r11.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = r11.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = r11.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(r11.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = r11.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = r11.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        r11.recycle();
    }

    private void forceUniformHeight(int r11, int r12) {
        int r10 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L10;
        View r14 = getVirtualChildAt(r13);
        if (r14.getVisibility() == 8) goto L9;
        LayoutParams r15 = (LayoutParams) r14.getLayoutParams();
        if (((LinearLayout.LayoutParams) r15).height != (-1)) goto L9;
        int r16 = ((LinearLayout.LayoutParams) r15).width;
        ((LinearLayout.LayoutParams) r15).width = r14.getMeasuredWidth();
        measureChildWithMargins(r14, r12, 0, r10, 0);
        ((LinearLayout.LayoutParams) r15).width = r16;
    L9:
        r13 = r13 + 1;
        goto L3
    }

    private void forceUniformWidth(int r11, int r12) {
        int r10 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L10;
        View r14 = getVirtualChildAt(r13);
        if (r14.getVisibility() == 8) goto L9;
        LayoutParams r15 = (LayoutParams) r14.getLayoutParams();
        if (((LinearLayout.LayoutParams) r15).width != (-1)) goto L9;
        int r16 = ((LinearLayout.LayoutParams) r15).height;
        ((LinearLayout.LayoutParams) r15).height = r14.getMeasuredHeight();
        measureChildWithMargins(r14, r10, 0, r12, 0);
        ((LinearLayout.LayoutParams) r15).height = r16;
    L9:
        r13 = r13 + 1;
        goto L3
    }

    private void setChildFrame(View r10, int r11, int r12, int r13, int r14) {
        r10.layout(r11, r12, r13 + r11, r14 + r12);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof LayoutParams;
    }

    void drawDividersHorizontal(Canvas r10) {
        int r11 = getVirtualChildCount();
        boolean r12 = ViewUtils.isLayoutRtl(this);
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L17;
        View r14 = getVirtualChildAt(r13);
        if (r14 == null) goto L15;
        if (r14.getVisibility() == 8) goto L15;
        if (hasDividerBeforeChildAt(r13) == false) goto L15;
        LayoutParams r15 = (LayoutParams) r14.getLayoutParams();
        if (r12 == false) goto L13;
        int r16 = r14.getRight() + ((LinearLayout.LayoutParams) r15).rightMargin;
    L14:
        drawVerticalDivider(r10, r16);
        goto L15
    L13:
        r16 = (r14.getLeft() - ((LinearLayout.LayoutParams) r15).leftMargin) - this.mDividerWidth;
    L15:
        r13 = r13 + 1;
        goto L3
    L17:
        if (hasDividerBeforeChildAt(r11) == false) goto L35;
        View r17 = getVirtualChildAt(r11 - 1);
        if (r17 != null) goto L23;
        if (r12 == false) goto L22;
        int r18 = getPaddingLeft();
    L28:
        drawVerticalDivider(r10, r18);
        return;
    L22:
        int r19 = getWidth();
        int r20 = getPaddingRight();
    L26:
        r18 = (r19 - r20) - this.mDividerWidth;
        goto L28
    L23:
        LayoutParams r21 = (LayoutParams) r17.getLayoutParams();
        if (r12 == false) goto L27;
        r19 = r17.getLeft();
        r20 = ((LinearLayout.LayoutParams) r21).leftMargin;
        goto L26
    L27:
        r18 = r17.getRight() + ((LinearLayout.LayoutParams) r21).rightMargin;
        goto L28
    }

    void drawDividersVertical(Canvas r10) {
        int r11 = getVirtualChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L13;
        View r13 = getVirtualChildAt(r12);
        if (r13 == null) goto L11;
        if (r13.getVisibility() == 8) goto L11;
        if (hasDividerBeforeChildAt(r12) == false) goto L11;
        drawHorizontalDivider(r10, (r13.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) r13.getLayoutParams())).topMargin) - this.mDividerHeight);
    L11:
        r12 = r12 + 1;
        goto L3
    L13:
        if (hasDividerBeforeChildAt(r11) == false) goto L25;
        View r14 = getVirtualChildAt(r11 - 1);
        if (r14 != null) goto L17;
        int r15 = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
    L18:
        drawHorizontalDivider(r10, r15);
        return;
    L17:
        r15 = r14.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) r14.getLayoutParams())).bottomMargin;
        goto L18
    }

    void drawHorizontalDivider(Canvas r10, int r11) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, r11, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + r11);
        this.mDivider.draw(r10);
    }

    void drawVerticalDivider(Canvas r10, int r11) {
        this.mDivider.setBounds(r11, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + r11, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(r10);
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        int r10 = this.mOrientation;
        if (r10 != 0) goto L7;
        return new LayoutParams(-2, -2);
    L7:
        if (r10 == 1) goto L9;
        return null;
    L9:
        return new LayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new LayoutParams(r10);
    }

    @Override // android.view.View
    public int getBaseline() {
        if (this.mBaselineAlignedChildIndex < 0) goto L5;
        int r10 = getChildCount();
        int r11 = this.mBaselineAlignedChildIndex;
        if (r10 <= r11) goto L29;
        View r12 = getChildAt(r11);
        int r13 = r12.getBaseline();
        if (r13 == (-1)) goto L11;
        int r14 = this.mBaselineChildTop;
        if (this.mOrientation != 1) goto L27;
        int r15 = this.mGravity & 112;
        if (r15 == 48) goto L27;
        if (r15 != 16) goto L22;
        r14 = r14 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2);
        goto L27
    L22:
        if (r15 != 80) goto L27;
        r14 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
    L27:
        return (r14 + ((LinearLayout.LayoutParams) ((LayoutParams) r12.getLayoutParams())).topMargin) + r13;
    L11:
        if (this.mBaselineAlignedChildIndex != 0) goto L14;
        return -1;
    L14:
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
    L29:
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    L5:
        return super.getBaseline();
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    int getChildrenSkipCount(View r10, int r11) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    @GravityInt
    public int getGravity() {
        return this.mGravity;
    }

    int getLocationOffset(View r10) {
        return 0;
    }

    int getNextLocationOffset(View r10) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    View getVirtualChildAt(int r10) {
        return getChildAt(r10);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    protected boolean hasDividerBeforeChildAt(int r10) {
        if (r10 != 0) goto L9;
        if ((this.mShowDividers & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (r10 != getChildCount()) goto L15;
        if ((this.mShowDividers & 4) != 0) goto L13;
        return false;
    L13:
        return true;
    L15:
        if ((this.mShowDividers & 2) == 0) goto L22;
        int r11 = r10 - 1;
    L17:
        if (r11 < 0) goto L28;
        if (getChildAt(r11).getVisibility() != 8) goto L27;
        r11 = r11 - 1;
        goto L17
    L27:
        return true;
    L28:
        return false;
    L22:
        return false;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    void layoutHorizontal(int r25, int r26, int r27, int r28) {
        boolean r10 = ViewUtils.isLayoutRtl(this);
        int r11 = getPaddingTop();
        int r12 = r28 - r26;
        int r13 = r12 - getPaddingBottom();
        int r14 = (r12 - r11) - getPaddingBottom();
        int r15 = getVirtualChildCount();
        int r16 = this.mGravity;
        int r17 = r16 & 112;
        boolean r18 = this.mBaselineAligned;
        int[] r19 = this.mMaxAscent;
        int[] r110 = this.mMaxDescent;
        int r20 = GravityCompat.getAbsoluteGravity(8388615 & r16, ViewCompat.getLayoutDirection(this));
        boolean r21 = true;
        if (r20 != 1) goto L5;
        int r22 = getPaddingLeft() + (((r27 - r25) - this.mTotalLength) / 2);
    L10:
        if (r10 == false) goto L12;
        int r111 = r15 - 1;
        int r112 = -1;
    L13:
        int r23 = 0;
    L14:
        if (r23 >= r15) goto L52;
        int r24 = r111 + (r112 * r23);
        View r29 = getVirtualChildAt(r24);
        if (r29 != null) goto L19;
        r22 = r22 + measureNullChild(r24);
        boolean r210 = r21;
    L51:
        r23 = r23 + 1;
        r15 = r15;
        r17 = r17;
        r21 = r210;
        r11 = r11;
        goto L14
    L19:
        if (r29.getVisibility() == 8) goto L49;
        int r113 = r29.getMeasuredWidth();
        int r30 = r29.getMeasuredHeight();
        LayoutParams r31 = (LayoutParams) r29.getLayoutParams();
        int r114 = r23;
        if (r18 == false) goto L25;
        r15 = r15;
        if (((LinearLayout.LayoutParams) r31).height == (-1)) goto L26;
        int r115 = r29.getBaseline();
    L27:
        int r32 = ((LinearLayout.LayoutParams) r31).gravity;
        if (r32 >= 0) goto L30;
        r32 = r17;
    L30:
        int r33 = r32 & 112;
        r17 = r17;
        if (r33 != 16) goto L33;
        r210 = true;
        int r34 = ((((r14 - r30) / 2) + r11) + ((LinearLayout.LayoutParams) r31).topMargin) - ((LinearLayout.LayoutParams) r31).bottomMargin;
    L46:
        if (hasDividerBeforeChildAt(r24) == false) goto L48;
        r22 = r22 + this.mDividerWidth;
    L48:
        int r116 = ((LinearLayout.LayoutParams) r31).leftMargin + r22;
        r11 = r11;
        setChildFrame(r29, r116 + getLocationOffset(r29), r34, r113, r30);
        int r117 = r116 + ((r113 + ((LinearLayout.LayoutParams) r31).rightMargin) + getNextLocationOffset(r29));
        r23 = r114 + getChildrenSkipCount(r29, r24);
        r22 = r117;
        goto L51
    L33:
        if (r33 != 48) goto L35;
        r34 = ((LinearLayout.LayoutParams) r31).topMargin + r11;
        if (r115 == (-1)) goto L43;
        r210 = true;
        r34 = r34 + (r19[1] - r115);
    L43:
        r210 = true;
        goto L46
    L35:
        if (r33 == 80) goto L37;
        r34 = r11;
        goto L43
    L37:
        r34 = (r13 - r30) - ((LinearLayout.LayoutParams) r31).bottomMargin;
        if (r115 == (-1)) goto L43;
        r34 = r34 - (r110[2] - (r29.getMeasuredHeight() - r115));
    L26:
        r115 = -1;
        goto L27
    L25:
        r15 = r15;
        goto L26
    L49:
        r210 = true;
        goto L51
    L52:
        return;
    L12:
        r111 = 0;
        r112 = 1;
        goto L13
    L5:
        if (r20 == 5) goto L7;
        r22 = getPaddingLeft();
        goto L10
    L7:
        r22 = ((getPaddingLeft() + r27) - r25) - this.mTotalLength;
        goto L10
    }

    void layoutVertical(int r18, int r19, int r20, int r21) {
        int r10 = getPaddingLeft();
        int r11 = r20 - r18;
        int r12 = r11 - getPaddingRight();
        int r13 = (r11 - r10) - getPaddingRight();
        int r14 = getVirtualChildCount();
        int r15 = this.mGravity;
        int r16 = r15 & 112;
        int r17 = r15 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r16 != 16) goto L5;
        int r22 = getPaddingTop() + (((r21 - r19) - this.mTotalLength) / 2);
    L9:
        int r110 = 0;
    L10:
        if (r110 >= r14) goto L33;
        View r111 = getVirtualChildAt(r110);
        if (r111 != null) goto L15;
        r22 = r22 + measureNullChild(r110);
    L31:
        int r23 = 1;
    L32:
        r110 = r110 + r23;
        goto L10
    L15:
        if (r111.getVisibility() == 8) goto L31;
        int r24 = r111.getMeasuredWidth();
        int r112 = r111.getMeasuredHeight();
        LayoutParams r25 = (LayoutParams) r111.getLayoutParams();
        int r26 = ((LinearLayout.LayoutParams) r25).gravity;
        if (r26 >= 0) goto L19;
        r26 = r17;
    L19:
        int r27 = GravityCompat.getAbsoluteGravity(r26, ViewCompat.getLayoutDirection(this)) & 7;
        if (r27 != 1) goto L22;
        int r28 = (((r13 - r24) / 2) + r10) + ((LinearLayout.LayoutParams) r25).leftMargin;
    L26:
        int r29 = r28 - ((LinearLayout.LayoutParams) r25).rightMargin;
    L27:
        int r30 = r29;
        if (hasDividerBeforeChildAt(r110) == false) goto L30;
        r22 = r22 + this.mDividerHeight;
    L30:
        int r113 = r22 + ((LinearLayout.LayoutParams) r25).topMargin;
        setChildFrame(r111, r30, r113 + getLocationOffset(r111), r24, r112);
        int r114 = r113 + ((r112 + ((LinearLayout.LayoutParams) r25).bottomMargin) + getNextLocationOffset(r111));
        r110 = r110 + getChildrenSkipCount(r111, r110);
        r22 = r114;
        r23 = 1;
        goto L32
    L22:
        if (r27 == 5) goto L24;
        r29 = ((LinearLayout.LayoutParams) r25).leftMargin + r10;
        goto L27
    L24:
        r28 = r12 - r24;
        goto L26
    L33:
        return;
    L5:
        if (r16 == 80) goto L7;
        r22 = getPaddingTop();
        goto L9
    L7:
        r22 = ((getPaddingTop() + r21) - r19) - this.mTotalLength;
        goto L9
    }

    void measureChildBeforeLayout(View r10, int r11, int r12, int r13, int r14, int r15) {
        measureChildWithMargins(r10, r12, r13, r14, r15);
    }

    void measureHorizontal(int r39, int r40) {
        this.mTotalLength = 0;
        int r11 = getVirtualChildCount();
        int r12 = View.MeasureSpec.getMode(r39);
        int r13 = View.MeasureSpec.getMode(r40);
        if (this.mMaxAscent != null) goto L5;
    L6:
        this.mMaxAscent = new int[4];
        this.mMaxDescent = new int[4];
    L7:
        int[] r15 = this.mMaxAscent;
        int[] r10 = this.mMaxDescent;
        r15[3] = -1;
        r15[2] = -1;
        r15[1] = -1;
        r15[0] = -1;
        r10[3] = -1;
        r10[2] = -1;
        r10[1] = -1;
        r10[0] = -1;
        boolean r14 = this.mBaselineAligned;
        boolean r16 = this.mUseLargestChild;
        int r17 = 1073741824;
        if (r12 != 1073741824) goto L10;
        boolean r19 = true;
    L11:
        int r18 = 0;
        int r110 = 0;
        int r21 = 0;
        int r22 = 0;
        int r23 = 0;
        boolean r24 = false;
        int r25 = 0;
        boolean r27 = false;
        boolean r26 = true;
        float r20 = 0.0f;
    L12:
        int[] r28 = r10;
        if (r18 >= r11) goto L91;
        View r29 = getVirtualChildAt(r18);
        if (r29 != null) goto L19;
        this.mTotalLength += measureNullChild(r18);
    L17:
        boolean r32 = r16;
        boolean r36 = r14;
        int r37 = r17;
        int r30 = r18;
        int r31 = r37;
    L90:
        int r33 = r30 + 1;
        r10 = r28;
        r16 = r32;
        r14 = r36;
        r17 = r31;
        r18 = r33;
        goto L12
    L19:
        if (r29.getVisibility() != 8) goto L22;
        r18 = r18 + getChildrenSkipCount(r29, r18);
        goto L17
    L22:
        if (hasDividerBeforeChildAt(r18) == false) goto L24;
        this.mTotalLength += this.mDividerWidth;
    L24:
        LayoutParams r111 = (LayoutParams) r29.getLayoutParams();
        float r34 = ((LinearLayout.LayoutParams) r111).weight;
        float r35 = r20 + r34;
        if (r12 != r17) goto L39;
        if (((LinearLayout.LayoutParams) r111).width != 0) goto L39;
        if (r34 <= 0.0f) goto L39;
        int r38 = this.mTotalLength;
        if (r19 == false) goto L33;
        int r41 = r38 + (((LinearLayout.LayoutParams) r111).leftMargin + ((LinearLayout.LayoutParams) r111).rightMargin);
    L34:
        this.mTotalLength = r41;
        if (r14 == false) goto L37;
        int r42 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r29.measure(r42, r42);
        int r310 = r18;
        r32 = r16;
        r36 = r14;
        View r43 = r29;
    L58:
        r31 = 1073741824;
    L59:
        if (r13 != r31) goto L61;
    L63:
        boolean r44 = false;
    L64:
        int r45 = ((LinearLayout.LayoutParams) r111).topMargin + ((LinearLayout.LayoutParams) r111).bottomMargin;
        int r46 = r43.getMeasuredHeight() + r45;
        r25 = View.combineMeasuredStates(r25, r43.getMeasuredState());
        if (r36 == false) goto L72;
        int r47 = r43.getBaseline();
        if (r47 == (-1)) goto L72;
        int r48 = ((LinearLayout.LayoutParams) r111).gravity;
        if (r48 >= 0) goto L71;
        r48 = this.mGravity;
    L71:
        int r49 = (((r48 & 112) >> 4) & (-2)) >> 1;
        r15[r49] = Math.max(r15[r49], r47);
        r28[r49] = Math.max(r28[r49], r46 - r47);
    L72:
        r21 = Math.max(r21, r46);
        if (r26 == true) goto L75;
    L77:
        r26 = false;
    L79:
        if (((LinearLayout.LayoutParams) r111).weight <= 0.0f) goto L84;
        if (r44 == true) goto L83;
        r45 = r46;
    L83:
        r23 = Math.max(r23, r45);
    L89:
        int r112 = r310;
        r30 = getChildrenSkipCount(r43, r112) + r112;
        r20 = r35;
        goto L90
    L84:
        int r113 = r23;
        if (r44 == true) goto L88;
        r45 = r46;
    L88:
        r22 = Math.max(r22, r45);
        r23 = r113;
        goto L89
    L75:
        if (((LinearLayout.LayoutParams) r111).height != (-1)) goto L77;
        r26 = true;
        goto L79
    L61:
        if (((LinearLayout.LayoutParams) r111).height != (-1)) goto L63;
        r44 = true;
        r27 = true;
        goto L64
    L37:
        r310 = r18;
        r32 = r16;
        r36 = r14;
        r43 = r29;
        r24 = true;
        r31 = 1073741824;
        goto L59
    L33:
        r41 = Math.max(r38, (((LinearLayout.LayoutParams) r111).leftMargin + r38) + ((LinearLayout.LayoutParams) r111).rightMargin);
    L39:
        if (((LinearLayout.LayoutParams) r111).width == 0) goto L41;
    L43:
        byte r50 = -2;
        int r51 = Integer.MIN_VALUE;
    L45:
        if (r35 != 0.0f) goto L47;
        int r210 = this.mTotalLength;
    L48:
        r310 = r18;
        int r311 = r51;
        r32 = r16;
        r36 = r14;
        measureChildBeforeLayout(r29, r310, r39, r210, r40, 0);
        if (r311 == Integer.MIN_VALUE) goto L51;
        ((LinearLayout.LayoutParams) r111).width = r311;
    L51:
        int r52 = r29.getMeasuredWidth();
        if (r19 == false) goto L54;
        r43 = r29;
        int r53 = this.mTotalLength + (((((LinearLayout.LayoutParams) r111).leftMargin + r52) + ((LinearLayout.LayoutParams) r111).rightMargin) + getNextLocationOffset(r43));
    L55:
        this.mTotalLength = r53;
        if (r32 == false) goto L58;
        r110 = Math.max(r52, r110);
        goto L58
    L54:
        r43 = r29;
        int r54 = this.mTotalLength;
        r53 = Math.max(r54, (((r54 + r52) + ((LinearLayout.LayoutParams) r111).leftMargin) + ((LinearLayout.LayoutParams) r111).rightMargin) + getNextLocationOffset(r43));
        goto L55
    L47:
        r210 = 0;
        goto L48
    L41:
        if (r34 <= 0.0f) goto L43;
        r50 = -2;
        ((LinearLayout.LayoutParams) r111).width = -2;
        r51 = 0;
        goto L45
    L91:
        boolean r312 = r16;
        boolean r313 = r14;
        int r55 = r21;
        int r56 = r22;
        int r114 = r23;
        int r57 = r25;
        if (this.mTotalLength <= 0) goto L97;
        if (hasDividerBeforeChildAt(r11) == false) goto L97;
        this.mTotalLength += this.mDividerWidth;
    L97:
        if (r15[1] == (-1)) goto L99;
    L106:
        int r58 = Math.max(r55, Math.max(r15[3], Math.max(r15[0], Math.max(r15[1], r15[2]))) + Math.max(r28[3], Math.max(r28[0], Math.max(r28[1], r28[2]))));
    L107:
        if (r312 == true) goto L109;
    L125:
        int r211 = r58;
        int r59 = this.mTotalLength + (getPaddingLeft() + getPaddingRight());
        this.mTotalLength = r59;
        int r60 = View.resolveSizeAndState(Math.max(r59, getSuggestedMinimumWidth()), r39, 0);
        int r61 = (16777215 & r60) - this.mTotalLength;
        if (r24 == true) goto L147;
        if (r61 != 0) goto L129;
    L131:
        int r62 = Math.max(r56, r114);
        if (r312 == true) goto L134;
    L146:
        int r212 = r11;
        int r63 = r211;
    L215:
        if (r26 == false) goto L217;
    L219:
        r62 = r63;
    L220:
        setMeasuredDimension(r60 | (r57 & ViewCompat.MEASURED_STATE_MASK), View.resolveSizeAndState(Math.max(r62 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), r40, r57 << 16));
        if (r27 == false) goto L238;
        forceUniformHeight(r212, r39);
        return;
    L238:
        return;
    L217:
        if (r13 == 1073741824) goto L219;
    L134:
        if (r12 == 1073741824) goto L146;
        int r115 = 0;
    L136:
        if (r115 >= r11) goto L146;
        View r64 = getVirtualChildAt(r115);
        if (r64 == null) goto L145;
        if (r64.getVisibility() == 8) goto L145;
        if (((LinearLayout.LayoutParams) ((LayoutParams) r64.getLayoutParams())).weight <= 0.0f) goto L145;
        r64.measure(View.MeasureSpec.makeMeasureSpec(r110, 1073741824), View.MeasureSpec.makeMeasureSpec(r64.getMeasuredHeight(), 1073741824));
    L145:
        r115 = r115 + 1;
        goto L136
    L129:
        if (r20 <= 0.0f) goto L131;
    L147:
        float r65 = this.mWeightSum;
        if (r65 <= 0.0f) goto L150;
        r20 = r65;
    L150:
        r15[3] = -1;
        r15[2] = -1;
        r15[1] = -1;
        r15[0] = -1;
        r28[3] = -1;
        r28[2] = -1;
        r28[1] = -1;
        r28[0] = -1;
        this.mTotalLength = 0;
        int r66 = r56;
        int r67 = -1;
        int r68 = r57;
        int r116 = 0;
    L151:
        if (r116 >= r11) goto L203;
        View r117 = getVirtualChildAt(r116);
        if (r117 != null) goto L155;
    L201:
        int r69 = r61;
        r11 = r11;
    L202:
        r116 = r116 + 1;
        r61 = r69;
        r11 = r11;
        goto L151
    L155:
        if (r117.getVisibility() == 8) goto L201;
        LayoutParams r70 = (LayoutParams) r117.getLayoutParams();
        float r71 = ((LinearLayout.LayoutParams) r70).weight;
        if (r71 <= 0.0f) goto L171;
        int r72 = (int) ((r61 * r71) / r20);
        float r73 = r20 - r71;
        int r74 = r61 - r72;
        int r75 = ViewGroup.getChildMeasureSpec(r40, ((getPaddingTop() + getPaddingBottom()) + ((LinearLayout.LayoutParams) r70).topMargin) + ((LinearLayout.LayoutParams) r70).bottomMargin, ((LinearLayout.LayoutParams) r70).height);
        if (((LinearLayout.LayoutParams) r70).width != 0) goto L166;
        int r76 = 1073741824;
        if (r12 != 1073741824) goto L167;
        if (r72 > 0) goto L170;
    L169:
        r72 = 0;
    L170:
        r117.measure(View.MeasureSpec.makeMeasureSpec(r72, r76), r75);
        r68 = View.combineMeasuredStates(r68, r117.getMeasuredState() & ViewCompat.MEASURED_STATE_MASK);
        r20 = r73;
        r69 = r74;
    L172:
        int r77 = this.mTotalLength;
        if (r19 == false) goto L175;
        this.mTotalLength = r77 + (((r117.getMeasuredWidth() + ((LinearLayout.LayoutParams) r70).leftMargin) + ((LinearLayout.LayoutParams) r70).rightMargin) + getNextLocationOffset(r117));
    L177:
        if (r13 != 1073741824) goto L179;
    L181:
        boolean r78 = false;
    L182:
        int r79 = ((LinearLayout.LayoutParams) r70).topMargin + ((LinearLayout.LayoutParams) r70).bottomMargin;
        int r118 = r117.getMeasuredHeight() + r79;
        r67 = Math.max(r67, r118);
        if (r78 == true) goto L186;
        r79 = r118;
    L186:
        int r80 = Math.max(r66, r79);
        if (r26 == false) goto L191;
        int r81 = -1;
        if (((LinearLayout.LayoutParams) r70).height != (-1)) goto L192;
        boolean r82 = true;
    L193:
        if (r313 == false) goto L200;
        int r119 = r117.getBaseline();
        if (r119 == r81) goto L200;
        int r83 = ((LinearLayout.LayoutParams) r70).gravity;
        if (r83 >= 0) goto L199;
        r83 = this.mGravity;
    L199:
        int r84 = (((r83 & 112) >> 4) & (-2)) >> 1;
        r15[r84] = Math.max(r15[r84], r119);
        r28[r84] = Math.max(r28[r84], r118 - r119);
    L200:
        r26 = r82;
        r66 = r80;
        r20 = r20;
    L192:
        r82 = false;
        goto L193
    L191:
        r81 = -1;
        goto L192
    L179:
        if (((LinearLayout.LayoutParams) r70).height != (-1)) goto L181;
        r78 = true;
        goto L182
    L175:
        this.mTotalLength = Math.max(r77, (((r117.getMeasuredWidth() + r77) + ((LinearLayout.LayoutParams) r70).leftMargin) + ((LinearLayout.LayoutParams) r70).rightMargin) + getNextLocationOffset(r117));
    L167:
        r72 = r117.getMeasuredWidth() + r72;
        if (r72 >= 0) goto L170;
    L166:
        r76 = 1073741824;
        goto L167
    L171:
        r69 = r61;
        goto L172
    L203:
        r212 = r11;
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        if (r15[1] == (-1)) goto L206;
    L213:
        int r85 = Math.max(r67, Math.max(r15[3], Math.max(r15[0], Math.max(r15[1], r15[2]))) + Math.max(r28[3], Math.max(r28[0], Math.max(r28[1], r28[2]))));
    L214:
        r63 = r85;
        r62 = r66;
        r57 = r68;
        goto L215
    L206:
        if (r15[0] != (-1)) goto L213;
        if (r15[2] != (-1)) goto L213;
        if (r15[3] != (-1)) goto L213;
        r85 = r67;
        goto L214
    L109:
        if (r12 == Integer.MIN_VALUE) goto L111;
        if (r12 != 0) goto L125;
    L111:
        this.mTotalLength = 0;
        int r86 = 0;
    L112:
        if (r86 >= r11) goto L125;
        View r87 = getVirtualChildAt(r86);
        if (r87 != null) goto L117;
        this.mTotalLength += measureNullChild(r86);
    L124:
        r86 = r86 + 1;
        r58 = r58;
        goto L112
    L117:
        if (r87.getVisibility() != 8) goto L120;
        r86 = r86 + getChildrenSkipCount(r87, r86);
        goto L124
    L120:
        LayoutParams r88 = (LayoutParams) r87.getLayoutParams();
        int r89 = this.mTotalLength;
        if (r19 == false) goto L123;
        this.mTotalLength = r89 + (((((LinearLayout.LayoutParams) r88).leftMargin + r110) + ((LinearLayout.LayoutParams) r88).rightMargin) + getNextLocationOffset(r87));
        goto L124
    L123:
        this.mTotalLength = Math.max(r89, (((r89 + r110) + ((LinearLayout.LayoutParams) r88).leftMargin) + ((LinearLayout.LayoutParams) r88).rightMargin) + getNextLocationOffset(r87));
        goto L124
    L99:
        if (r15[0] != (-1)) goto L106;
        if (r15[2] != (-1)) goto L106;
        if (r15[3] != (-1)) goto L106;
        r58 = r55;
        goto L107
    L10:
        r19 = false;
        goto L11
    L5:
        if (this.mMaxDescent != null) goto L7;
        goto L6
    }

    int measureNullChild(int r10) {
        return 0;
    }

    void measureVertical(int r34, int r35) {
        this.mTotalLength = 0;
        int r11 = getVirtualChildCount();
        int r12 = View.MeasureSpec.getMode(r34);
        int r13 = View.MeasureSpec.getMode(r35);
        int r14 = this.mBaselineAlignedChildIndex;
        boolean r15 = this.mUseLargestChild;
        int r10 = 0;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
        int r20 = 0;
        boolean r110 = false;
        boolean r21 = false;
        float r22 = 0.0f;
        boolean r111 = true;
    L3:
        int r112 = 8;
        int r23 = r18;
        if (r20 >= r11) goto L72;
        View r24 = getVirtualChildAt(r20);
        if (r24 != null) goto L8;
        this.mTotalLength += measureNullChild(r20);
        int r26 = r11;
        int r25 = r13;
        r18 = r23;
    L71:
        r20 = r20 + 1;
        r13 = r25;
        r11 = r26;
        goto L3
    L8:
        int r27 = r10;
        if (r24.getVisibility() != 8) goto L12;
        r20 = r20 + getChildrenSkipCount(r24, r20);
        r26 = r11;
        r18 = r23;
        r10 = r27;
        r25 = r13;
        goto L71
    L12:
        if (hasDividerBeforeChildAt(r20) == false) goto L14;
        this.mTotalLength += this.mDividerHeight;
    L14:
        LayoutParams r113 = (LayoutParams) r24.getLayoutParams();
        float r28 = ((LinearLayout.LayoutParams) r113).weight;
        float r29 = r22 + r28;
        if (r13 == 1073741824) goto L17;
    L21:
        int r210 = r16;
        if (((LinearLayout.LayoutParams) r113).height == 0) goto L24;
    L26:
        int r30 = Integer.MIN_VALUE;
    L28:
        if (r29 != 0.0f) goto L30;
        int r211 = this.mTotalLength;
    L31:
        int r31 = r27;
        int r32 = r30;
        int r212 = r210;
        int r33 = r17;
        r26 = r11;
        r25 = r13;
        int r114 = r23;
        int r36 = r19;
        int r115 = r20;
        measureChildBeforeLayout(r24, r20, r34, 0, r35, r211);
        if (r32 == Integer.MIN_VALUE) goto L34;
        ((LinearLayout.LayoutParams) r113).height = r32;
    L34:
        int r37 = r24.getMeasuredHeight();
        int r38 = this.mTotalLength;
        View r39 = r24;
        this.mTotalLength = Math.max(r38, (((r38 + r37) + ((LinearLayout.LayoutParams) r113).topMargin) + ((LinearLayout.LayoutParams) r113).bottomMargin) + getNextLocationOffset(r39));
        if (r15 == false) goto L37;
        int r40 = Math.max(r37, r33);
    L38:
        if (r14 >= 0) goto L40;
    L42:
        if (r115 >= r14) goto L49;
        if (((LinearLayout.LayoutParams) r113).weight <= 0.0f) goto L49;
        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
    L49:
        if (r12 != 1073741824) goto L51;
    L53:
        boolean r41 = false;
    L54:
        int r42 = ((LinearLayout.LayoutParams) r113).leftMargin + ((LinearLayout.LayoutParams) r113).rightMargin;
        int r43 = r39.getMeasuredWidth() + r42;
        int r44 = Math.max(r212, r43);
        int r45 = View.combineMeasuredStates(r31, r39.getMeasuredState());
        if (r111 == true) goto L57;
    L59:
        r111 = false;
    L61:
        if (((LinearLayout.LayoutParams) r113).weight <= 0.0f) goto L66;
        if (r41 == true) goto L65;
        r42 = r43;
    L65:
        r18 = Math.max(r114, r42);
        int r46 = r36;
    L70:
        int r47 = getChildrenSkipCount(r39, r115) + r115;
        r17 = r40;
        r22 = r29;
        r19 = r46;
        r10 = r45;
        r20 = r47;
        r16 = r44;
        goto L71
    L66:
        if (r41 == true) goto L69;
        r42 = r43;
    L69:
        r46 = Math.max(r36, r42);
        r18 = r114;
        goto L70
    L57:
        if (((LinearLayout.LayoutParams) r113).width != (-1)) goto L59;
        r111 = true;
        goto L61
    L51:
        if (((LinearLayout.LayoutParams) r113).width != (-1)) goto L53;
        r41 = true;
        r21 = true;
        goto L54
    L40:
        if (r14 != (r115 + 1)) goto L42;
        this.mBaselineChildTop = this.mTotalLength;
        goto L42
    L37:
        r40 = r33;
        goto L38
    L30:
        r211 = 0;
        goto L31
    L24:
        if (r28 <= 0.0f) goto L26;
        ((LinearLayout.LayoutParams) r113).height = -2;
        r30 = 0;
        goto L28
    L17:
        if (((LinearLayout.LayoutParams) r113).height != 0) goto L21;
        if (r28 <= 0.0f) goto L21;
        int r48 = this.mTotalLength;
        this.mTotalLength = Math.max(r48, (((LinearLayout.LayoutParams) r113).topMargin + r48) + ((LinearLayout.LayoutParams) r113).bottomMargin);
        r40 = r17;
        r39 = r24;
        r36 = r19;
        r110 = true;
        r31 = r27;
        r212 = r16;
        r26 = r11;
        r25 = r13;
        r114 = r23;
        r115 = r20;
        goto L38
    L72:
        int r49 = r10;
        int r50 = r17;
        int r51 = r19;
        int r213 = r11;
        int r214 = r13;
        int r52 = r16;
        if (this.mTotalLength <= 0) goto L77;
        int r53 = r213;
        if (hasDividerBeforeChildAt(r53) == false) goto L79;
        this.mTotalLength += this.mDividerHeight;
    L79:
        if (r15 == true) goto L81;
    L94:
        int r54 = this.mTotalLength + (getPaddingTop() + getPaddingBottom());
        this.mTotalLength = r54;
        int r55 = View.resolveSizeAndState(Math.max(r54, getSuggestedMinimumHeight()), r35, 0);
        int r56 = (16777215 & r55) - this.mTotalLength;
        if (r110 == true) goto L116;
        if (r56 != 0) goto L98;
    L100:
        int r57 = Math.max(r51, r23);
        if (r15 == true) goto L103;
    L115:
        int r58 = r49;
    L158:
        if (r111 == false) goto L160;
    L162:
        r57 = r52;
    L163:
        setMeasuredDimension(View.resolveSizeAndState(Math.max(r57 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), r34, r58), r55);
        if (r21 == false) goto L183;
        forceUniformWidth(r53, r35);
        return;
    L183:
        return;
    L160:
        if (r12 == 1073741824) goto L162;
    L103:
        if (r214 == 1073741824) goto L115;
        int r59 = 0;
    L105:
        if (r59 >= r53) goto L115;
        View r60 = getVirtualChildAt(r59);
        if (r60 == null) goto L114;
        if (r60.getVisibility() == 8) goto L114;
        if (((LinearLayout.LayoutParams) ((LayoutParams) r60.getLayoutParams())).weight <= 0.0f) goto L114;
        r60.measure(View.MeasureSpec.makeMeasureSpec(r60.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r50, 1073741824));
    L114:
        r59 = r59 + 1;
        goto L105
    L98:
        if (r22 <= 0.0f) goto L100;
    L116:
        float r116 = this.mWeightSum;
        if (r116 <= 0.0f) goto L119;
        r22 = r116;
    L119:
        this.mTotalLength = 0;
        int r117 = r56;
        int r61 = r51;
        r58 = r49;
        int r62 = 0;
    L120:
        if (r62 >= r53) goto L157;
        View r118 = getVirtualChildAt(r62);
        if (r118.getVisibility() != 8) goto L124;
        int r215 = r117;
    L156:
        r62 = r62 + 1;
        r117 = r215;
        goto L120
    L124:
        LayoutParams r119 = (LayoutParams) r118.getLayoutParams();
        float r120 = ((LinearLayout.LayoutParams) r119).weight;
        if (r120 <= 0.0f) goto L138;
        int r121 = (int) ((r117 * r120) / r22);
        float r63 = r22 - r120;
        r215 = r117 - r121;
        int r64 = ViewGroup.getChildMeasureSpec(r34, ((getPaddingLeft() + getPaddingRight()) + ((LinearLayout.LayoutParams) r119).leftMargin) + ((LinearLayout.LayoutParams) r119).rightMargin, ((LinearLayout.LayoutParams) r119).width);
        if (((LinearLayout.LayoutParams) r119).height != 0) goto L133;
        int r122 = 1073741824;
        if (r214 != 1073741824) goto L134;
        if (r121 > 0) goto L137;
    L136:
        r121 = 0;
    L137:
        r118.measure(r64, View.MeasureSpec.makeMeasureSpec(r121, r122));
        r58 = View.combineMeasuredStates(r58, r118.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
        r22 = r63;
    L139:
        int r123 = ((LinearLayout.LayoutParams) r119).leftMargin + ((LinearLayout.LayoutParams) r119).rightMargin;
        int r124 = r118.getMeasuredWidth() + r123;
        r52 = Math.max(r52, r124);
        float r125 = r22;
        if (r12 == 1073741824) goto L144;
        int r216 = r58;
        int r65 = -1;
        if (((LinearLayout.LayoutParams) r119).width != (-1)) goto L145;
        boolean r66 = true;
    L146:
        if (r66 == true) goto L149;
        r123 = r124;
    L149:
        int r67 = Math.max(r61, r123);
        if (r111 == true) goto L152;
    L154:
        boolean r68 = false;
    L155:
        int r126 = this.mTotalLength;
        this.mTotalLength = Math.max(r126, (((r118.getMeasuredHeight() + r126) + ((LinearLayout.LayoutParams) r119).topMargin) + ((LinearLayout.LayoutParams) r119).bottomMargin) + getNextLocationOffset(r118));
        r111 = r68;
        r58 = r216;
        r61 = r67;
        r22 = r125;
        goto L156
    L152:
        if (((LinearLayout.LayoutParams) r119).width != r65) goto L154;
        r68 = true;
    L145:
        r66 = false;
        goto L146
    L144:
        r216 = r58;
        r65 = -1;
    L134:
        r121 = r118.getMeasuredHeight() + r121;
        if (r121 >= 0) goto L137;
    L133:
        r122 = 1073741824;
        goto L134
    L138:
        r215 = r117;
        goto L139
    L157:
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        r57 = r61;
        goto L158
    L81:
        if (r214 == Integer.MIN_VALUE) goto L83;
        if (r214 != 0) goto L94;
    L83:
        this.mTotalLength = 0;
        int r69 = 0;
    L84:
        if (r69 >= r53) goto L94;
        View r70 = getVirtualChildAt(r69);
        if (r70 != null) goto L90;
        int r71 = this.mTotalLength + measureNullChild(r69);
    L88:
        this.mTotalLength = r71;
    L93:
        r69 = r69 + 1;
        r112 = 8;
        goto L84
    L90:
        if (r70.getVisibility() != r112) goto L92;
        r69 = r69 + getChildrenSkipCount(r70, r69);
        goto L93
    L92:
        LayoutParams r127 = (LayoutParams) r70.getLayoutParams();
        int r128 = this.mTotalLength;
        r71 = Math.max(r128, (((r128 + r50) + ((LinearLayout.LayoutParams) r127).topMargin) + ((LinearLayout.LayoutParams) r127).bottomMargin) + getNextLocationOffset(r70));
        goto L88
    L77:
        r53 = r213;
        goto L79
    }

    @Override // android.view.View
    protected void onDraw(Canvas r10) {
        if (this.mDivider != null) goto L6;
        return;
    L6:
        if (this.mOrientation != 1) goto L8;
        drawDividersVertical(r10);
        return;
    L8:
        drawDividersHorizontal(r10);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        r10.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        r10.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        if (this.mOrientation != 1) goto L5;
        layoutVertical(r11, r12, r13, r14);
        return;
    L5:
        layoutHorizontal(r11, r12, r13, r14);
    }

    @Override // android.view.View
    protected void onMeasure(int r10, int r11) {
        if (this.mOrientation != 1) goto L5;
        measureVertical(r10, r11);
        return;
    L5:
        measureHorizontal(r10, r11);
    }

    public void setBaselineAligned(boolean r10) {
        this.mBaselineAligned = r10;
    }

    public void setBaselineAlignedChildIndex(int r10) {
        if (r10 < 0) goto L8;
        if (r10 >= getChildCount()) goto L8;
        this.mBaselineAlignedChildIndex = r10;
        return;
    L8:
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable r10) {
        if (r10 != this.mDivider) goto L5;
        return;
    L5:
        this.mDivider = r10;
        boolean r11 = false;
        if (r10 == null) goto L8;
        this.mDividerWidth = r10.getIntrinsicWidth();
        this.mDividerHeight = r10.getIntrinsicHeight();
    L9:
        if (r10 != null) goto L11;
        r11 = true;
    L11:
        setWillNotDraw(r11);
        requestLayout();
        return;
    L8:
        this.mDividerWidth = 0;
        this.mDividerHeight = 0;
        goto L9
    }

    public void setDividerPadding(int r10) {
        this.mDividerPadding = r10;
    }

    public void setGravity(@GravityInt int r10) {
        if (this.mGravity != r10) goto L5;
        return;
    L5:
        if ((8388615 & r10) != 0) goto L8;
        r10 = r10 | GravityCompat.START;
    L8:
        if ((r10 & 112) != 0) goto L10;
        r10 = r10 | 48;
    L10:
        this.mGravity = r10;
        requestLayout();
    }

    public void setHorizontalGravity(int r10) {
        int r11 = r10 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int r12 = this.mGravity;
        if ((8388615 & r12) == r11) goto L6;
        this.mGravity = r11 | ((-8388616) & r12);
        requestLayout();
        return;
    }

    public void setMeasureWithLargestChildEnabled(boolean r10) {
        this.mUseLargestChild = r10;
    }

    public void setOrientation(int r10) {
        if (this.mOrientation == r10) goto L6;
        this.mOrientation = r10;
        requestLayout();
        return;
    }

    public void setShowDividers(int r10) {
        if (r10 == this.mShowDividers) goto L5;
        requestLayout();
    L5:
        this.mShowDividers = r10;
    }

    public void setVerticalGravity(int r10) {
        int r11 = r10 & 112;
        int r12 = this.mGravity;
        if ((r12 & 112) == r11) goto L6;
        this.mGravity = r11 | (r12 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH);
        requestLayout();
        return;
    }

    public void setWeightSum(float r10) {
        this.mWeightSum = Math.max(0.0f, r10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
