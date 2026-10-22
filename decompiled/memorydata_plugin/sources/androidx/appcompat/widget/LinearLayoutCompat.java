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
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.card.MaterialCardView;
import com.obric.memorydata.plugin.R;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    public @interface DividerMode {
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(int r1, int r2) {
            super(r1, r2);
        }

        public LayoutParams(int r1, int r2, float r3) {
            super(r1, r2, r3);
        }

        public LayoutParams(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public LinearLayoutCompat(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public LinearLayoutCompat(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r3, r5, r12);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        TintTypedArray r1 = TintTypedArray.obtainStyledAttributes(r3, r5, R.styleable.LinearLayoutCompat, r12, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r3, R.styleable.LinearLayoutCompat, r5, r1.getWrappedTypeArray(), r12, 0);
        int r13 = r1.getInt(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_android_orientation, "styleable", "LinearLayoutCompat_android_orientation"), -1);
        if (r13 < 0) goto L5;
        setOrientation(r13);
    L5:
        int r14 = r1.getInt(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_android_gravity, "styleable", "LinearLayoutCompat_android_gravity"), -1);
        if (r14 < 0) goto L8;
        setGravity(r14);
    L8:
        boolean r15 = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_android_baselineAligned, "styleable", "LinearLayoutCompat_android_baselineAligned"), true);
        if (r15 == true) goto L11;
        setBaselineAligned(r15);
    L11:
        this.mWeightSum = r1.getFloat(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_android_weightSum, "styleable", "LinearLayoutCompat_android_weightSum"), -1.0f);
        this.mBaselineAlignedChildIndex = r1.getInt(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, "styleable", "LinearLayoutCompat_android_baselineAlignedChildIndex"), -1);
        this.mUseLargestChild = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_measureWithLargestChild, "styleable", "LinearLayoutCompat_measureWithLargestChild"), false);
        setDividerDrawable(r1.getDrawable(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_divider, "styleable", "LinearLayoutCompat_divider")));
        this.mShowDividers = r1.getInt(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_showDividers, "styleable", "LinearLayoutCompat_showDividers"), 0);
        this.mDividerPadding = r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_dividerPadding, "styleable", "LinearLayoutCompat_dividerPadding"), 0);
        r1.recycle();
    }

    private void forceUniformHeight(int r11, int r12) {
        int r0 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L10;
        View r3 = getVirtualChildAt(r1);
        if (r3.getVisibility() == 8) goto L9;
        LayoutParams r8 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r8.height != (-1)) goto L9;
        int r9 = r8.width;
        r8.width = r3.getMeasuredWidth();
        measureChildWithMargins(r3, r12, 0, r0, 0);
        r8.width = r9;
    L9:
        r1 = r1 + 1;
        goto L3
    }

    private void forceUniformWidth(int r11, int r12) {
        int r0 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L10;
        View r3 = getVirtualChildAt(r1);
        if (r3.getVisibility() == 8) goto L9;
        LayoutParams r8 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r8.width != (-1)) goto L9;
        int r9 = r8.height;
        r8.height = r3.getMeasuredHeight();
        measureChildWithMargins(r3, r0, 0, r12, 0);
        r8.height = r9;
    L9:
        r1 = r1 + 1;
        goto L3
    }

    private void setChildFrame(View r1, int r2, int r3, int r4, int r5) {
        r1.layout(r2, r3, r4 + r2, r5 + r3);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, LayoutParams.class);
    }

    void drawDividersHorizontal(Canvas r8) {
        int r0 = getVirtualChildCount();
        boolean r1 = ViewUtils.isLayoutRtl(this);
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L18;
        View r4 = getVirtualChildAt(r2);
        if (r4 == null) goto L16;
        if (r4.getVisibility() == 8) goto L16;
        if (hasDividerBeforeChildAt(r2) == false) goto L16;
        LayoutParams r3 = (LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r1 == false) goto L14;
        int r5 = r4.getRight() + r3.rightMargin;
    L15:
        drawVerticalDivider(r8, r5);
        goto L16
    L14:
        r5 = (r4.getLeft() - r3.leftMargin) - this.mDividerWidth;
    L16:
        r2 = r2 + 1;
        goto L4
    L18:
        if (hasDividerBeforeChildAt(r0) == false) goto L36;
        View r6 = getVirtualChildAt(r0 - 1);
        if (r6 != null) goto L24;
        if (r1 == false) goto L23;
        int r7 = getPaddingLeft();
    L29:
        drawVerticalDivider(r8, r7);
        return;
    L23:
        int r9 = getWidth();
        int r10 = getPaddingRight();
    L27:
        r7 = (r9 - r10) - this.mDividerWidth;
        goto L29
    L24:
        LayoutParams r11 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r1 == false) goto L28;
        r9 = r6.getLeft();
        r10 = r11.leftMargin;
        goto L27
    L28:
        r7 = r6.getRight() + r11.rightMargin;
        goto L29
    }

    void drawDividersVertical(Canvas r7) {
        int r0 = getVirtualChildCount();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L14;
        View r3 = getVirtualChildAt(r1);
        if (r3 == null) goto L12;
        if (r3.getVisibility() == 8) goto L12;
        if (hasDividerBeforeChildAt(r1) == false) goto L12;
        drawHorizontalDivider(r7, (r3.getTop() - ((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).topMargin) - this.mDividerHeight);
    L12:
        r1 = r1 + 1;
        goto L4
    L14:
        if (hasDividerBeforeChildAt(r0) == false) goto L26;
        View r2 = getVirtualChildAt(r0 - 1);
        if (r2 != null) goto L18;
        int r4 = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
    L19:
        drawHorizontalDivider(r7, r4);
        return;
    L18:
        r4 = r2.getBottom() + ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).bottomMargin;
        goto L19
    }

    void drawHorizontalDivider(Canvas r5, int r6) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, r6, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + r6);
        this.mDivider.draw(r5);
    }

    void drawVerticalDivider(Canvas r6, int r7) {
        this.mDivider.setBounds(r7, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + r7, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(r6);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int r2 = this.mOrientation;
        if (r2 != 0) goto L7;
        return new LayoutParams(-2, -2);
    L7:
        if (r2 == 1) goto L9;
        return null;
    L9:
        return new LayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
    }

    @Override // android.view.View
    public int getBaseline() {
        if (this.mBaselineAlignedChildIndex < 0) goto L5;
        int r0 = getChildCount();
        int r1 = this.mBaselineAlignedChildIndex;
        if (r0 <= r1) goto L29;
        View r2 = getChildAt(r1);
        int r3 = r2.getBaseline();
        if (r3 == (-1)) goto L11;
        int r4 = this.mBaselineChildTop;
        if (this.mOrientation != 1) goto L27;
        int r5 = this.mGravity & 112;
        if (r5 == 48) goto L27;
        if (r5 != 16) goto L22;
        r4 = r4 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2);
        goto L27
    L22:
        if (r5 != 80) goto L27;
        r4 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
    L27:
        return (r4 + ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).topMargin) + r3;
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

    int getChildrenSkipCount(View r1, int r2) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    int getLocationOffset(View r1) {
        return 0;
    }

    int getNextLocationOffset(View r1) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    View getVirtualChildAt(int r1) {
        return getChildAt(r1);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public boolean hasDividerBeforeChildAt(int r5) {
        if (r5 != 0) goto L9;
        if ((this.mShowDividers & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (r5 != getChildCount()) goto L15;
        if ((this.mShowDividers & 4) != 0) goto L13;
        return false;
    L13:
        return true;
    L15:
        if ((this.mShowDividers & 2) == 0) goto L22;
        int r6 = r5 - 1;
    L17:
        if (r6 < 0) goto L28;
        if (getChildAt(r6).getVisibility() != 8) goto L27;
        r6 = r6 - 1;
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

    void layoutHorizontal(int r26, int r27, int r28, int r29) {
        boolean r0 = ViewUtils.isLayoutRtl(this);
        int r7 = getPaddingTop();
        int r1 = r29 - r27;
        int r8 = r1 - getPaddingBottom();
        int r9 = (r1 - r7) - getPaddingBottom();
        int r10 = getVirtualChildCount();
        int r2 = this.mGravity;
        int r11 = r2 & 112;
        boolean r12 = this.mBaselineAligned;
        int[] r13 = this.mMaxAscent;
        int[] r14 = this.mMaxDescent;
        int r3 = GravityCompat.getAbsoluteGravity(8388615 & r2, ViewCompat.getLayoutDirection(this));
        char r15 = 2;
        boolean r5 = true;
        if (r3 != 1) goto L5;
        int r4 = getPaddingLeft() + (((r28 - r26) - this.mTotalLength) / 2);
    L10:
        if (r0 == false) goto L12;
        int r16 = r10 - 1;
        int r17 = -1;
    L13:
        int r6 = 0;
    L14:
        if (r6 >= r10) goto L52;
        int r18 = r16 + (r17 * r6);
        View r19 = getVirtualChildAt(r18);
        if (r19 != null) goto L19;
        r4 = r4 + measureNullChild(r18);
        boolean r20 = r5;
        char r21 = r15;
    L51:
        r6 = r6 + 1;
        r10 = r10;
        r11 = r11;
        r5 = r20;
        r15 = r21;
        goto L14
    L19:
        if (r19.getVisibility() == 8) goto L49;
        int r110 = r19.getMeasuredWidth();
        int r22 = r19.getMeasuredHeight();
        int r210 = r6;
        r10 = r10;
        LayoutParams r111 = (LayoutParams) ZeusTransformUtils.preCheckCast(r19.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r12 == true) goto L23;
    L25:
        int r23 = -1;
    L26:
        int r24 = r111.gravity;
        if (r24 >= 0) goto L29;
        r24 = r11;
    L29:
        int r25 = r24 & 112;
        r11 = r11;
        if (r25 != 16) goto L32;
        r20 = true;
        r21 = 2;
        int r30 = ((((r9 - r22) / 2) + r7) + r111.topMargin) - r111.bottomMargin;
    L46:
        if (hasDividerBeforeChildAt(r18) == false) goto L48;
        r4 = r4 + this.mDividerWidth;
    L48:
        int r211 = r4 + r111.leftMargin;
        setChildFrame(r19, r211 + getLocationOffset(r19), r30, r110, r22);
        int r212 = r211 + ((r110 + r111.rightMargin) + getNextLocationOffset(r19));
        r6 = r210 + getChildrenSkipCount(r19, r18);
        r4 = r212;
        goto L51
    L32:
        if (r25 != 48) goto L34;
        r30 = r111.topMargin + r7;
        if (r23 == (-1)) goto L42;
        r20 = true;
        r30 = r30 + (r13[1] - r23);
    L43:
        r21 = 2;
    L42:
        r20 = true;
        goto L43
    L34:
        if (r25 == 80) goto L36;
        r30 = r7;
        goto L42
    L36:
        r30 = (r8 - r22) - r111.bottomMargin;
        if (r23 == (-1)) goto L42;
        r30 = r30 - (r14[2] - (r19.getMeasuredHeight() - r23));
        goto L42
    L23:
        if (r111.height == (-1)) goto L25;
        r23 = r19.getBaseline();
        goto L26
    L49:
        r20 = true;
        r21 = 2;
        goto L51
    L52:
        return;
    L12:
        r16 = 0;
        r17 = 1;
        goto L13
    L5:
        if (r3 == 5) goto L7;
        r4 = getPaddingLeft();
        goto L10
    L7:
        r4 = ((getPaddingLeft() + r28) - r26) - this.mTotalLength;
        goto L10
    }

    void layoutVertical(int r18, int r19, int r20, int r21) {
        int r7 = getPaddingLeft();
        int r0 = r20 - r18;
        int r8 = r0 - getPaddingRight();
        int r9 = (r0 - r7) - getPaddingRight();
        int r10 = getVirtualChildCount();
        int r1 = this.mGravity;
        int r2 = r1 & 112;
        int r11 = r1 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r2 != 16) goto L5;
        int r3 = getPaddingTop() + (((r21 - r19) - this.mTotalLength) / 2);
    L9:
        int r12 = 0;
    L10:
        if (r12 >= r10) goto L33;
        View r13 = getVirtualChildAt(r12);
        if (r13 != null) goto L15;
        r3 = r3 + measureNullChild(r12);
    L31:
        int r4 = 1;
    L32:
        r12 = r12 + r4;
        goto L10
    L15:
        if (r13.getVisibility() == 8) goto L31;
        int r5 = r13.getMeasuredWidth();
        int r15 = r13.getMeasuredHeight();
        LayoutParams r6 = (LayoutParams) ZeusTransformUtils.preCheckCast(r13.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r14 = r6.gravity;
        if (r14 >= 0) goto L19;
        r14 = r11;
    L19:
        int r16 = GravityCompat.getAbsoluteGravity(r14, ViewCompat.getLayoutDirection(this)) & 7;
        if (r16 != 1) goto L22;
        int r17 = (((r9 - r5) / 2) + r7) + r6.leftMargin;
    L26:
        int r22 = r17 - r6.rightMargin;
    L27:
        int r23 = r22;
        if (hasDividerBeforeChildAt(r12) == false) goto L30;
        r3 = r3 + this.mDividerHeight;
    L30:
        int r110 = r3 + r6.topMargin;
        setChildFrame(r13, r23, r110 + getLocationOffset(r13), r5, r15);
        int r111 = r110 + ((r15 + r6.bottomMargin) + getNextLocationOffset(r13));
        r12 = r12 + getChildrenSkipCount(r13, r12);
        r3 = r111;
        r4 = 1;
        goto L32
    L22:
        if (r16 == 5) goto L24;
        r22 = r6.leftMargin + r7;
        goto L27
    L24:
        r17 = r8 - r5;
        goto L26
    L33:
        return;
    L5:
        if (r2 == 80) goto L7;
        r3 = getPaddingTop();
        goto L9
    L7:
        r3 = ((getPaddingTop() + r21) - r19) - this.mTotalLength;
        goto L9
    }

    void measureChildBeforeLayout(View r7, int r8, int r9, int r10, int r11, int r12) {
        measureChildWithMargins(r7, r9, r10, r11, r12);
    }

    void measureHorizontal(int r41, int r42) {
        this.mTotalLength = 0;
        int r11 = getVirtualChildCount();
        int r12 = View.MeasureSpec.getMode(r41);
        int r13 = View.MeasureSpec.getMode(r42);
        if (this.mMaxAscent != null) goto L5;
    L6:
        this.mMaxAscent = new int[4];
        this.mMaxDescent = new int[4];
    L7:
        int[] r15 = this.mMaxAscent;
        int[] r6 = this.mMaxDescent;
        r15[3] = -1;
        r15[2] = -1;
        r15[1] = -1;
        r15[0] = -1;
        r6[3] = -1;
        r6[2] = -1;
        r6[1] = -1;
        r6[0] = -1;
        boolean r4 = this.mBaselineAligned;
        boolean r3 = this.mUseLargestChild;
        int r2 = 1073741824;
        if (r12 != 1073741824) goto L10;
        boolean r19 = true;
    L11:
        int r1 = 0;
        int r14 = 0;
        int r21 = 0;
        int r22 = 0;
        int r23 = 0;
        boolean r24 = false;
        int r26 = 0;
        boolean r28 = false;
        boolean r27 = true;
        float r0 = 0.0f;
    L12:
        int[] r29 = r6;
        String r5 = "com.obric.memorydata.plugin";
        if (r1 >= r11) goto L91;
        View r10 = getVirtualChildAt(r1);
        if (r10 != null) goto L18;
        this.mTotalLength += measureNullChild(r1);
        boolean r33 = r3;
        boolean r38 = r4;
        int r39 = r2;
        int r7 = r1;
        int r8 = r39;
    L90:
        int r9 = r7 + 1;
        r6 = r29;
        r3 = r33;
        r4 = r38;
        r2 = r8;
        r1 = r9;
        goto L12
    L18:
        if (r10.getVisibility() != 8) goto L21;
        r7 = r1 + getChildrenSkipCount(r10, r1);
        r33 = r3;
        r38 = r4;
        r8 = 1073741824;
        goto L90
    L21:
        if (hasDividerBeforeChildAt(r1) == false) goto L23;
        this.mTotalLength += this.mDividerWidth;
    L23:
        LayoutParams r16 = (LayoutParams) ZeusTransformUtils.preCheckCast(r10.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        float r34 = r0 + r16.weight;
        if (r12 != 1073741824) goto L38;
        if (r16.width != 0) goto L38;
        if (r16.weight <= 0.0f) goto L38;
        int r17 = this.mTotalLength;
        if (r19 == false) goto L32;
        int r18 = r17 + (r16.leftMargin + r16.rightMargin);
    L33:
        this.mTotalLength = r18;
        if (r4 == false) goto L36;
        int r20 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r10.measure(r20, r20);
        int r36 = r1;
        r33 = r3;
        r38 = r4;
        LayoutParams r25 = r16;
    L57:
        r8 = 1073741824;
    L58:
        if (r13 != r8) goto L60;
    L62:
        boolean r30 = false;
    L63:
        int r31 = r25.topMargin + r25.bottomMargin;
        int r32 = r10.getMeasuredHeight() + r31;
        r26 = View.combineMeasuredStates(r26, r10.getMeasuredState());
        if (r38 == false) goto L72;
        int r35 = r10.getBaseline();
        if (r35 == (-1)) goto L72;
        if (r25.gravity >= 0) goto L70;
        int r37 = this.mGravity;
    L71:
        int r40 = (((r37 & 112) >> 4) & (-2)) >> 1;
        r15[r40] = Math.max(r15[r40], r35);
        r29[r40] = Math.max(r29[r40], r32 - r35);
        goto L72
    L70:
        r37 = r25.gravity;
    L72:
        r21 = Math.max(r21, r32);
        if (r27 == true) goto L75;
    L77:
        r27 = false;
    L79:
        if (r25.weight <= 0.0f) goto L84;
        if (r30 == true) goto L83;
        r31 = r32;
    L83:
        r23 = Math.max(r23, r31);
    L89:
        int r43 = r36;
        r7 = r43 + getChildrenSkipCount(r10, r43);
        r0 = r34;
        goto L90
    L84:
        int r44 = r23;
        if (r30 == true) goto L88;
        r31 = r32;
    L88:
        r22 = Math.max(r22, r31);
        r23 = r44;
        goto L89
    L75:
        if (r25.height != (-1)) goto L77;
        r27 = true;
        goto L79
    L60:
        if (r25.height != (-1)) goto L62;
        r30 = true;
        r28 = true;
        goto L63
    L36:
        r36 = r1;
        r33 = r3;
        r38 = r4;
        r25 = r16;
        r24 = true;
        r8 = 1073741824;
        goto L58
    L32:
        r18 = Math.max(r17, (r16.leftMargin + r17) + r16.rightMargin);
    L38:
        if (r16.width == 0) goto L40;
    L42:
        byte r45 = -2;
        int r46 = Integer.MIN_VALUE;
    L44:
        if (r34 != 0.0f) goto L46;
        int r310 = this.mTotalLength;
    L47:
        r36 = r1;
        int r311 = r46;
        r33 = r3;
        r38 = r4;
        r25 = r16;
        measureChildBeforeLayout(r10, r36, r41, r310, r42, 0);
        if (r311 == Integer.MIN_VALUE) goto L50;
        r25.width = r311;
    L50:
        int r47 = r10.getMeasuredWidth();
        int r48 = this.mTotalLength;
        if (r19 == false) goto L53;
        int r49 = r48 + (((r25.leftMargin + r47) + r25.rightMargin) + getNextLocationOffset(r10));
    L54:
        this.mTotalLength = r49;
        if (r33 == false) goto L57;
        r14 = Math.max(r47, r14);
        goto L57
    L53:
        r49 = Math.max(r48, (((r48 + r47) + r25.leftMargin) + r25.rightMargin) + getNextLocationOffset(r10));
        goto L54
    L46:
        r310 = 0;
        goto L47
    L40:
        if (r16.weight <= 0.0f) goto L42;
        r45 = -2;
        r16.width = -2;
        r46 = 0;
        goto L44
    L91:
        boolean r312 = r3;
        boolean r313 = r4;
        int r50 = r21;
        int r51 = r22;
        int r52 = r23;
        int r110 = r26;
        if (this.mTotalLength <= 0) goto L97;
        if (hasDividerBeforeChildAt(r11) == false) goto L97;
        this.mTotalLength += this.mDividerWidth;
    L97:
        if (r15[1] == (-1)) goto L99;
    L106:
        int r53 = Math.max(r50, Math.max(r15[3], Math.max(r15[0], Math.max(r15[1], r15[2]))) + Math.max(r29[3], Math.max(r29[0], Math.max(r29[1], r29[2]))));
    L107:
        if (r312 == true) goto L109;
    L125:
        int r210 = r53;
        int r54 = this.mTotalLength + (getPaddingLeft() + getPaddingRight());
        this.mTotalLength = r54;
        int r55 = View.resolveSizeAndState(Math.max(r54, getSuggestedMinimumWidth()), r41, 0);
        int r56 = (16777215 & r55) - this.mTotalLength;
        if (r24 == true) goto L147;
        if (r56 != 0) goto L129;
    L131:
        int r57 = Math.max(r51, r52);
        if (r312 == true) goto L134;
    L146:
        int r314 = r11;
        int r211 = r110;
    L217:
        if (r27 == false) goto L219;
    L221:
        r57 = r210;
    L222:
        setMeasuredDimension(r55 | (r211 & ViewCompat.MEASURED_STATE_MASK), View.resolveSizeAndState(Math.max(r57 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), r42, r211 << 16));
        if (r28 == false) goto L241;
        forceUniformHeight(r314, r41);
        return;
    L241:
        return;
    L219:
        if (r13 == 1073741824) goto L221;
    L134:
        if (r12 == 1073741824) goto L146;
        int r111 = 0;
    L136:
        if (r111 >= r11) goto L146;
        View r58 = getVirtualChildAt(r111);
        if (r58 == null) goto L145;
        if (r58.getVisibility() == 8) goto L145;
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(r58.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).weight <= 0.0f) goto L145;
        r58.measure(View.MeasureSpec.makeMeasureSpec(r14, 1073741824), View.MeasureSpec.makeMeasureSpec(r58.getMeasuredHeight(), 1073741824));
    L145:
        r111 = r111 + 1;
        goto L136
    L129:
        if (r0 <= 0.0f) goto L131;
    L147:
        float r59 = this.mWeightSum;
        if (r59 <= 0.0f) goto L150;
        r0 = r59;
    L150:
        r15[3] = -1;
        r15[2] = -1;
        r15[1] = -1;
        r15[0] = -1;
        r29[3] = -1;
        r29[2] = -1;
        r29[1] = -1;
        r29[0] = -1;
        this.mTotalLength = 0;
        int r60 = r51;
        int r61 = -1;
        int r112 = r110;
        int r113 = 0;
    L151:
        if (r113 >= r11) goto L205;
        View r62 = getVirtualChildAt(r113);
        if (r62 != null) goto L155;
    L203:
        r5 = r5;
        r11 = r11;
        int r63 = r56;
    L204:
        r113 = r113 + 1;
        r56 = r63;
        r5 = r5;
        r11 = r11;
        goto L151
    L155:
        if (r62.getVisibility() == 8) goto L203;
        LayoutParams r64 = (LayoutParams) ZeusTransformUtils.preCheckCast(r62.getLayoutParams(), LayoutParams.class, r5);
        float r65 = r64.weight;
        if (r65 <= 0.0f) goto L171;
        int r66 = (int) ((r56 * r65) / r0);
        float r67 = r0 - r65;
        int r68 = r56 - r66;
        int r69 = getChildMeasureSpec(r42, ((getPaddingTop() + getPaddingBottom()) + r64.topMargin) + r64.bottomMargin, r64.height);
        if (r64.width != 0) goto L166;
        int r70 = 1073741824;
        if (r12 != 1073741824) goto L167;
        if (r66 > 0) goto L170;
    L169:
        r66 = 0;
    L170:
        r62.measure(View.MeasureSpec.makeMeasureSpec(r66, r70), r69);
        r112 = View.combineMeasuredStates(r112, r62.getMeasuredState() & ViewCompat.MEASURED_STATE_MASK);
        r0 = r67;
        r63 = r68;
    L172:
        int r71 = this.mTotalLength;
        if (r19 == false) goto L175;
        this.mTotalLength = r71 + (((r62.getMeasuredWidth() + r64.leftMargin) + r64.rightMargin) + getNextLocationOffset(r62));
    L177:
        if (r13 != 1073741824) goto L179;
    L181:
        boolean r72 = false;
    L182:
        int r73 = r64.topMargin + r64.bottomMargin;
        int r114 = r62.getMeasuredHeight() + r73;
        r61 = Math.max(r61, r114);
        if (r72 == true) goto L186;
        r73 = r114;
    L186:
        int r74 = Math.max(r60, r73);
        if (r27 == false) goto L191;
        int r75 = -1;
        if (r64.height != (-1)) goto L192;
        boolean r76 = true;
    L193:
        if (r313 == false) goto L202;
        int r77 = r62.getBaseline();
        if (r77 == r75) goto L202;
        if (r64.gravity >= 0) goto L199;
        int r78 = this.mGravity;
    L200:
        int r79 = (((r78 & 112) >> 4) & (-2)) >> 1;
        r15[r79] = Math.max(r15[r79], r77);
        r29[r79] = Math.max(r29[r79], r114 - r77);
        goto L202
    L199:
        r78 = r64.gravity;
    L202:
        r60 = r74;
        r27 = r76;
        r0 = r0;
    L192:
        r76 = false;
        goto L193
    L191:
        r75 = -1;
        goto L192
    L179:
        if (r64.height != (-1)) goto L181;
        r72 = true;
        goto L182
    L175:
        this.mTotalLength = Math.max(r71, (((r62.getMeasuredWidth() + r71) + r64.leftMargin) + r64.rightMargin) + getNextLocationOffset(r62));
    L167:
        r66 = r62.getMeasuredWidth() + r66;
        if (r66 >= 0) goto L170;
    L166:
        r70 = 1073741824;
        goto L167
    L171:
        r63 = r56;
        goto L172
    L205:
        r314 = r11;
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        if (r15[1] == (-1)) goto L208;
    L215:
        int r80 = Math.max(r61, Math.max(r15[3], Math.max(r15[0], Math.max(r15[1], r15[2]))) + Math.max(r29[3], Math.max(r29[0], Math.max(r29[1], r29[2]))));
    L216:
        r210 = r80;
        r57 = r60;
        r211 = r112;
        goto L217
    L208:
        if (r15[0] != (-1)) goto L215;
        if (r15[2] != (-1)) goto L215;
        if (r15[3] != (-1)) goto L215;
        r80 = r61;
        goto L216
    L109:
        if (r12 == Integer.MIN_VALUE) goto L111;
        if (r12 != 0) goto L125;
    L111:
        this.mTotalLength = 0;
        int r81 = 0;
    L112:
        if (r81 >= r11) goto L125;
        View r82 = getVirtualChildAt(r81);
        if (r82 != null) goto L117;
        this.mTotalLength += measureNullChild(r81);
    L124:
        r81 = r81 + 1;
        r53 = r53;
        goto L112
    L117:
        if (r82.getVisibility() != 8) goto L120;
        r81 = r81 + getChildrenSkipCount(r82, r81);
        goto L124
    L120:
        LayoutParams r83 = (LayoutParams) ZeusTransformUtils.preCheckCast(r82.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r84 = this.mTotalLength;
        if (r19 == false) goto L123;
        this.mTotalLength = r84 + (((r83.leftMargin + r14) + r83.rightMargin) + getNextLocationOffset(r82));
        goto L124
    L123:
        this.mTotalLength = Math.max(r84, (((r84 + r14) + r83.leftMargin) + r83.rightMargin) + getNextLocationOffset(r82));
        goto L124
    L99:
        if (r15[0] != (-1)) goto L106;
        if (r15[2] != (-1)) goto L106;
        if (r15[3] != (-1)) goto L106;
        r53 = r50;
        goto L107
    L10:
        r19 = false;
        goto L11
    L5:
        if (this.mMaxDescent != null) goto L7;
        goto L6
    }

    int measureNullChild(int r1) {
        return 0;
    }

    void measureVertical(int r33, int r34) {
        this.mTotalLength = 0;
        int r11 = getVirtualChildCount();
        int r12 = View.MeasureSpec.getMode(r33);
        int r13 = View.MeasureSpec.getMode(r34);
        int r14 = this.mBaselineAlignedChildIndex;
        boolean r15 = this.mUseLargestChild;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        boolean r18 = false;
        boolean r20 = false;
        float r0 = 0.0f;
        boolean r19 = true;
    L3:
        String r10 = "com.obric.memorydata.plugin";
        r1 = r1;
        int r7 = 8;
        r4 = r4;
        if (r6 >= r11) goto L73;
        View r8 = getVirtualChildAt(r6);
        if (r8 != null) goto L9;
        this.mTotalLength += measureNullChild(r6);
    L8:
        int r22 = r11;
    L72:
        r6 = r6 + 1;
        r11 = r22;
        r13 = r13;
        goto L3
    L9:
        int r24 = r2;
        if (r8.getVisibility() != 8) goto L13;
        r6 = r6 + getChildrenSkipCount(r8, r6);
        r2 = r24;
        goto L8
    L13:
        if (hasDividerBeforeChildAt(r6) == false) goto L15;
        this.mTotalLength += this.mDividerHeight;
    L15:
        LayoutParams r16 = (LayoutParams) ZeusTransformUtils.preCheckCast(r8.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        float r25 = r0 + r16.weight;
        if (r13 != 1073741824) goto L23;
        if (r16.height != 0) goto L23;
        if (r16.weight <= 0.0f) goto L23;
        int r9 = this.mTotalLength;
        this.mTotalLength = Math.max(r9, (r16.topMargin + r9) + r16.bottomMargin);
        int r17 = r3;
        View r21 = r8;
        int r30 = r5;
        r13 = r13;
        r18 = true;
        int r23 = r1;
        int r110 = r4;
        int r28 = r24;
        r22 = r11;
        int r111 = r6;
    L39:
        if (r14 >= 0) goto L41;
    L43:
        if (r111 >= r14) goto L50;
        if (r16.weight <= 0.0f) goto L50;
        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
    L50:
        if (r12 != 1073741824) goto L52;
    L54:
        boolean r26 = false;
    L55:
        int r27 = r16.leftMargin + r16.rightMargin;
        int r29 = r21.getMeasuredWidth() + r27;
        int r31 = Math.max(r28, r29);
        int r32 = View.combineMeasuredStates(r23, r21.getMeasuredState());
        if (r19 == true) goto L58;
    L60:
        r19 = false;
    L62:
        if (r16.weight <= 0.0f) goto L67;
        if (r26 == true) goto L66;
        r27 = r29;
    L66:
        r4 = Math.max(r110, r27);
        int r35 = r30;
    L71:
        int r36 = getChildrenSkipCount(r21, r111) + r111;
        r3 = r17;
        r0 = r25;
        r5 = r35;
        r1 = r32;
        r6 = r36;
        r2 = r31;
        goto L72
    L67:
        if (r26 == true) goto L70;
        r27 = r29;
    L70:
        r35 = Math.max(r30, r27);
        r4 = r110;
        goto L71
    L58:
        if (r16.width != (-1)) goto L60;
        r19 = true;
        goto L62
    L52:
        if (r16.width != (-1)) goto L54;
        r26 = true;
        r20 = true;
        goto L55
    L41:
        if (r14 != (r111 + 1)) goto L43;
        this.mBaselineChildTop = this.mTotalLength;
    L23:
        if (r16.height == 0) goto L25;
    L27:
        int r37 = Integer.MIN_VALUE;
    L29:
        if (r25 != 0.0f) goto L31;
        int r210 = this.mTotalLength;
    L32:
        r23 = r1;
        int r211 = r37;
        r28 = r24;
        int r38 = r3;
        r13 = r13;
        r110 = r4;
        r22 = r11;
        r30 = r5;
        r111 = r6;
        measureChildBeforeLayout(r8, r6, r33, 0, r34, r210);
        if (r211 == Integer.MIN_VALUE) goto L35;
        r16.height = r211;
    L35:
        int r39 = r8.getMeasuredHeight();
        int r40 = this.mTotalLength;
        r21 = r8;
        this.mTotalLength = Math.max(r40, (((r40 + r39) + r16.topMargin) + r16.bottomMargin) + getNextLocationOffset(r21));
        if (r15 == false) goto L38;
        r17 = Math.max(r39, r38);
        goto L39
    L38:
        r17 = r38;
        goto L39
    L31:
        r210 = 0;
        goto L32
    L25:
        if (r16.weight <= 0.0f) goto L27;
        r16.height = -2;
        r37 = 0;
        goto L29
    L73:
        int r41 = r3;
        int r42 = r5;
        int r212 = r13;
        int r43 = r1;
        int r44 = r2;
        int r213 = r11;
        if (this.mTotalLength <= 0) goto L78;
        int r45 = r213;
        if (hasDividerBeforeChildAt(r45) == false) goto L79;
        this.mTotalLength += this.mDividerHeight;
    L79:
        if (r15 == false) goto L96;
        int r46 = r212;
        if (r46 == Integer.MIN_VALUE) goto L85;
        if (r46 == 0) goto L85;
    L84:
        int r214 = r44;
    L97:
        int r47 = this.mTotalLength + (getPaddingTop() + getPaddingBottom());
        this.mTotalLength = r47;
        int r48 = View.resolveSizeAndState(Math.max(r47, getSuggestedMinimumHeight()), r34, 0);
        int r49 = (16777215 & r48) - this.mTotalLength;
        if (r18 == true) goto L119;
        if (r49 != 0) goto L101;
    L103:
        int r50 = Math.max(r42, r4);
        if (r15 == false) goto L161;
        if (r46 == 1073741824) goto L161;
        int r51 = 0;
    L108:
        if (r51 >= r45) goto L161;
        View r52 = getVirtualChildAt(r51);
        if (r52 == null) goto L117;
        if (r52.getVisibility() == 8) goto L117;
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(r52.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).weight <= 0.0f) goto L117;
        r52.measure(View.MeasureSpec.makeMeasureSpec(r52.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r41, 1073741824));
    L117:
        r51 = r51 + 1;
    L161:
        if (r19 == false) goto L163;
    L165:
        r50 = r214;
    L166:
        setMeasuredDimension(View.resolveSizeAndState(Math.max(r50 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), r33, r43), r48);
        if (r20 == false) goto L185;
        forceUniformWidth(r45, r34);
        return;
    L185:
        return;
    L163:
        if (r12 == 1073741824) goto L165;
    L101:
        if (r0 <= 0.0f) goto L103;
    L119:
        float r53 = this.mWeightSum;
        if (r53 <= 0.0f) goto L122;
        r0 = r53;
    L122:
        this.mTotalLength = 0;
        int r112 = 0;
        int r113 = r49;
        int r54 = r42;
        int r55 = r214;
    L123:
        if (r112 >= r45) goto L160;
        View r114 = getVirtualChildAt(r112);
        if (r114.getVisibility() != 8) goto L127;
        int r215 = r46;
        r10 = r10;
        int r216 = r113;
    L159:
        r112 = r112 + 1;
        r10 = r10;
        r113 = r216;
        r46 = r215;
        goto L123
    L127:
        LayoutParams r56 = (LayoutParams) ZeusTransformUtils.preCheckCast(r114.getLayoutParams(), LayoutParams.class, r10);
        float r115 = r56.weight;
        if (r115 <= 0.0f) goto L141;
        int r116 = (int) ((r113 * r115) / r0);
        float r57 = r0 - r115;
        r216 = r113 - r116;
        int r58 = getChildMeasureSpec(r33, ((getPaddingLeft() + getPaddingRight()) + r56.leftMargin) + r56.rightMargin, r56.width);
        if (r56.height != 0) goto L136;
        int r117 = 1073741824;
        if (r46 != 1073741824) goto L137;
        if (r116 > 0) goto L140;
    L139:
        r116 = 0;
    L140:
        r114.measure(r58, View.MeasureSpec.makeMeasureSpec(r116, r117));
        r43 = View.combineMeasuredStates(r43, r114.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
        r0 = r57;
    L142:
        int r118 = r56.leftMargin + r56.rightMargin;
        int r119 = r114.getMeasuredWidth() + r118;
        r55 = Math.max(r55, r119);
        float r217 = r0;
        if (r12 == 1073741824) goto L147;
        r215 = r46;
        int r59 = -1;
        if (r56.width != (-1)) goto L148;
        boolean r60 = true;
    L149:
        if (r60 == true) goto L152;
        r118 = r119;
    L152:
        int r61 = Math.max(r54, r118);
        if (r19 == true) goto L155;
    L157:
        boolean r62 = false;
    L158:
        int r120 = this.mTotalLength;
        this.mTotalLength = Math.max(r120, (((r114.getMeasuredHeight() + r120) + r56.topMargin) + r56.bottomMargin) + getNextLocationOffset(r114));
        r19 = r62;
        r54 = r61;
        r0 = r217;
        goto L159
    L155:
        if (r56.width != r59) goto L157;
        r62 = true;
    L148:
        r60 = false;
        goto L149
    L147:
        r215 = r46;
        r59 = -1;
    L137:
        r116 = r114.getMeasuredHeight() + r116;
        if (r116 >= 0) goto L140;
    L136:
        r117 = 1073741824;
        goto L137
    L141:
        r216 = r113;
        goto L142
    L160:
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        r214 = r55;
        r50 = r54;
    L85:
        this.mTotalLength = 0;
        int r63 = 0;
    L86:
        if (r63 >= r45) goto L84;
        View r121 = getVirtualChildAt(r63);
        if (r121 != null) goto L91;
        this.mTotalLength += measureNullChild(r63);
    L95:
        r63 = r63 + 1;
        r44 = r44;
        r7 = 8;
        goto L86
    L91:
        if (r121.getVisibility() != r7) goto L94;
        r63 = r63 + getChildrenSkipCount(r121, r63);
        goto L95
    L94:
        LayoutParams r64 = (LayoutParams) ZeusTransformUtils.preCheckCast(r121.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r122 = this.mTotalLength;
        this.mTotalLength = Math.max(r122, (((r122 + r41) + r64.topMargin) + r64.bottomMargin) + getNextLocationOffset(r121));
        goto L95
    L96:
        r214 = r44;
        r46 = r212;
        goto L97
    L78:
        r45 = r213;
        goto L79
    }

    @Override // android.view.View
    public void onDraw(Canvas r3) {
        if (this.mDivider != null) goto L6;
        return;
    L6:
        if (this.mOrientation != 1) goto L8;
        drawDividersVertical(r3);
        return;
    L8:
        drawDividersHorizontal(r3);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r1) {
        super.onInitializeAccessibilityEvent(r1);
        r1.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        r1.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        if (this.mOrientation != 1) goto L5;
        layoutVertical(r3, r4, r5, r6);
        return;
    L5:
        layoutHorizontal(r3, r4, r5, r6);
    }

    @Override // android.view.View
    public void onMeasure(int r3, int r4) {
        if (this.mOrientation != 1) goto L5;
        measureVertical(r3, r4);
        return;
    L5:
        measureHorizontal(r3, r4);
    }

    public void setBaselineAligned(boolean r1) {
        this.mBaselineAligned = r1;
    }

    public void setBaselineAlignedChildIndex(int r3) {
        if (r3 < 0) goto L8;
        if (r3 >= getChildCount()) goto L8;
        this.mBaselineAlignedChildIndex = r3;
        return;
    L8:
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable r3) {
        if (r3 != this.mDivider) goto L5;
        return;
    L5:
        this.mDivider = r3;
        boolean r0 = false;
        if (r3 == null) goto L8;
        this.mDividerWidth = r3.getIntrinsicWidth();
        this.mDividerHeight = r3.getIntrinsicHeight();
    L9:
        if (r3 != null) goto L11;
        r0 = true;
    L11:
        setWillNotDraw(r0);
        requestLayout();
        return;
    L8:
        this.mDividerWidth = 0;
        this.mDividerHeight = 0;
        goto L9
    }

    public void setDividerPadding(int r1) {
        this.mDividerPadding = r1;
    }

    public void setGravity(int r2) {
        if (this.mGravity != r2) goto L5;
        return;
    L5:
        if ((8388615 & r2) != 0) goto L8;
        r2 = r2 | GravityCompat.START;
    L8:
        if ((r2 & 112) != 0) goto L10;
        r2 = r2 | 48;
    L10:
        this.mGravity = r2;
        requestLayout();
    }

    public void setHorizontalGravity(int r3) {
        int r4 = r3 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int r1 = this.mGravity;
        if ((8388615 & r1) == r4) goto L6;
        this.mGravity = r4 | ((-8388616) & r1);
        requestLayout();
        return;
    }

    public void setMeasureWithLargestChildEnabled(boolean r1) {
        this.mUseLargestChild = r1;
    }

    public void setOrientation(int r2) {
        if (this.mOrientation == r2) goto L6;
        this.mOrientation = r2;
        requestLayout();
        return;
    }

    public void setShowDividers(int r2) {
        if (r2 == this.mShowDividers) goto L5;
        requestLayout();
    L5:
        this.mShowDividers = r2;
    }

    public void setVerticalGravity(int r3) {
        int r4 = r3 & 112;
        int r0 = this.mGravity;
        if ((r0 & 112) == r4) goto L6;
        this.mGravity = r4 | (r0 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH);
        requestLayout();
        return;
    }

    public void setWeightSum(float r2) {
        this.mWeightSum = Math.max(0.0f, r2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
