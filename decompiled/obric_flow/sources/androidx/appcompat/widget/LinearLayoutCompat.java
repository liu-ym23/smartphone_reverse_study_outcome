package androidx.appcompat.widget;

import ai.j0;
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
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
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
        public LayoutParams(Context r5, AttributeSet r10) {
            super(r5, r10);
        }

        public LayoutParams(int r5, int r10) {
            super(r5, r10);
        }

        public LayoutParams(int r5, int r10, float r11) {
            super(r5, r10, r11);
        }

        public LayoutParams(ViewGroup.LayoutParams r5) {
            super(r5);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r5) {
            super(r5);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context r5) {
        this(r5, null);
    }

    private void forceUniformHeight(int r11, int r12) {
        int r5 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), BasicMeasure.EXACTLY);
        int r10 = 0;
    L3:
        if (r10 >= r11) goto L10;
        View r13 = getVirtualChildAt(r10);
        if (r13.getVisibility() == 8) goto L9;
        LayoutParams r14 = (LayoutParams) r13.getLayoutParams();
        if (((LinearLayout.LayoutParams) r14).height != (-1)) goto L9;
        int r15 = ((LinearLayout.LayoutParams) r14).width;
        ((LinearLayout.LayoutParams) r14).width = r13.getMeasuredWidth();
        measureChildWithMargins(r13, r12, 0, r5, 0);
        ((LinearLayout.LayoutParams) r14).width = r15;
    L9:
        r10 = r10 + 1;
        goto L3
    }

    private void forceUniformWidth(int r11, int r12) {
        int r5 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY);
        int r10 = 0;
    L3:
        if (r10 >= r11) goto L10;
        View r13 = getVirtualChildAt(r10);
        if (r13.getVisibility() == 8) goto L9;
        LayoutParams r14 = (LayoutParams) r13.getLayoutParams();
        if (((LinearLayout.LayoutParams) r14).width != (-1)) goto L9;
        int r15 = ((LinearLayout.LayoutParams) r14).height;
        ((LinearLayout.LayoutParams) r14).height = r13.getMeasuredHeight();
        measureChildWithMargins(r13, r5, 0, r12, 0);
        ((LinearLayout.LayoutParams) r14).height = r15;
    L9:
        r10 = r10 + 1;
        goto L3
    }

    private void setChildFrame(View r5, int r10, int r11, int r12, int r13) {
        r5.layout(r10, r11, r12 + r10, r13 + r11);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r5) {
        return r5 instanceof LayoutParams;
    }

    public void drawDividersHorizontal(Canvas r10) {
        int r5 = getVirtualChildCount();
        boolean r11 = ViewUtils.isLayoutRtl(this);
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L17;
        View r13 = getVirtualChildAt(r12);
        if (r13 == null) goto L15;
        if (r13.getVisibility() == 8) goto L15;
        if (hasDividerBeforeChildAt(r12) == false) goto L15;
        LayoutParams r14 = (LayoutParams) r13.getLayoutParams();
        if (r11 == false) goto L13;
        int r15 = r13.getRight() + ((LinearLayout.LayoutParams) r14).rightMargin;
    L14:
        drawVerticalDivider(r10, r15);
        goto L15
    L13:
        r15 = (r13.getLeft() - ((LinearLayout.LayoutParams) r14).leftMargin) - this.mDividerWidth;
    L15:
        r12 = r12 + 1;
        goto L3
    L17:
        if (hasDividerBeforeChildAt(r5) == false) goto L35;
        View r16 = getVirtualChildAt(r5 - 1);
        if (r16 != null) goto L24;
        if (r11 == false) goto L22;
        int r17 = getPaddingLeft();
    L28:
        drawVerticalDivider(r10, r17);
        return;
    L22:
        int r18 = getWidth() - getPaddingRight();
        int r19 = this.mDividerWidth;
    L23:
        r17 = r18 - r19;
        goto L28
    L24:
        LayoutParams r20 = (LayoutParams) r16.getLayoutParams();
        if (r11 == false) goto L27;
        r18 = r16.getLeft() - ((LinearLayout.LayoutParams) r20).leftMargin;
        r19 = this.mDividerWidth;
        goto L23
    L27:
        r17 = r16.getRight() + ((LinearLayout.LayoutParams) r20).rightMargin;
        goto L28
    }

    public void drawDividersVertical(Canvas r10) {
        int r5 = getVirtualChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L13;
        View r12 = getVirtualChildAt(r11);
        if (r12 == null) goto L11;
        if (r12.getVisibility() == 8) goto L11;
        if (hasDividerBeforeChildAt(r11) == false) goto L11;
        drawHorizontalDivider(r10, (r12.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) r12.getLayoutParams())).topMargin) - this.mDividerHeight);
    L11:
        r11 = r11 + 1;
        goto L3
    L13:
        if (hasDividerBeforeChildAt(r5) == false) goto L25;
        View r13 = getVirtualChildAt(r5 - 1);
        if (r13 != null) goto L17;
        int r14 = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
    L18:
        drawHorizontalDivider(r10, r14);
        return;
    L17:
        r14 = r13.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) r13.getLayoutParams())).bottomMargin;
        goto L18
    }

    public void drawHorizontalDivider(Canvas r5, int r10) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, r10, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + r10);
        this.mDivider.draw(r5);
    }

    public void drawVerticalDivider(Canvas r10, int r11) {
        this.mDivider.setBounds(r11, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + r11, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(r10);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return generateLayoutParams(r5);
    }

    @Override // android.view.View
    public int getBaseline() {
        if (this.mBaselineAlignedChildIndex < 0) goto L5;
        int r5 = getChildCount();
        int r10 = this.mBaselineAlignedChildIndex;
        if (r5 <= r10) goto L29;
        View r11 = getChildAt(r10);
        int r12 = r11.getBaseline();
        if (r12 == (-1)) goto L11;
        int r13 = this.mBaselineChildTop;
        if (this.mOrientation != 1) goto L27;
        int r14 = this.mGravity & 112;
        if (r14 == 48) goto L27;
        if (r14 != 16) goto L22;
        r13 = j0.c(((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom(), this.mTotalLength, 2, r13);
        goto L27
    L22:
        if (r14 != 80) goto L27;
        r13 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
    L27:
        return (r13 + ((LinearLayout.LayoutParams) ((LayoutParams) r11.getLayoutParams())).topMargin) + r12;
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

    public int getChildrenSkipCount(View r5, int r10) {
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

    public int getLocationOffset(View r5) {
        return 0;
    }

    public int getNextLocationOffset(View r5) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public View getVirtualChildAt(int r5) {
        return getChildAt(r5);
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
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
        int r10 = r5 - 1;
    L17:
        if (r10 < 0) goto L28;
        if (getChildAt(r10).getVisibility() != 8) goto L27;
        r10 = r10 - 1;
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

    public void layoutHorizontal(int r25, int r26, int r27, int r28) {
        boolean r5 = ViewUtils.isLayoutRtl(this);
        int r10 = getPaddingTop();
        int r11 = r28 - r26;
        int r12 = r11 - getPaddingBottom();
        int r13 = (r11 - r10) - getPaddingBottom();
        int r14 = getVirtualChildCount();
        int r15 = this.mGravity;
        int r16 = r15 & 112;
        boolean r17 = this.mBaselineAligned;
        int[] r18 = this.mMaxAscent;
        int[] r19 = this.mMaxDescent;
        int r20 = GravityCompat.getAbsoluteGravity(8388615 & r15, ViewCompat.getLayoutDirection(this));
        boolean r21 = true;
        if (r20 != 1) goto L5;
        int r22 = j0.c(r27 - r25, this.mTotalLength, 2, getPaddingLeft());
    L10:
        if (r5 == false) goto L12;
        int r110 = r14 - 1;
        int r111 = -1;
    L13:
        int r23 = 0;
    L14:
        if (r23 >= r14) goto L52;
        int r24 = (r111 * r23) + r110;
        View r29 = getVirtualChildAt(r24);
        if (r29 != null) goto L20;
        r22 = measureNullChild(r24) + r22;
        boolean r210 = r21;
    L51:
        r23 = r23 + 1;
        r14 = r14;
        r16 = r16;
        r21 = r210;
        r10 = r10;
        goto L14
    L20:
        if (r29.getVisibility() == 8) goto L50;
        int r112 = r29.getMeasuredWidth();
        int r30 = r29.getMeasuredHeight();
        LayoutParams r31 = (LayoutParams) r29.getLayoutParams();
        int r113 = r23;
        if (r17 == false) goto L26;
        r14 = r14;
        if (((LinearLayout.LayoutParams) r31).height == (-1)) goto L27;
        int r114 = r29.getBaseline();
    L28:
        int r32 = ((LinearLayout.LayoutParams) r31).gravity;
        if (r32 >= 0) goto L31;
        r32 = r16;
    L31:
        int r33 = r32 & 112;
        r16 = r16;
        if (r33 != 16) goto L34;
        r210 = true;
        int r34 = (j0.c(r13, r30, 2, r10) + ((LinearLayout.LayoutParams) r31).topMargin) - ((LinearLayout.LayoutParams) r31).bottomMargin;
    L47:
        if (hasDividerBeforeChildAt(r24) == false) goto L49;
        r22 = r22 + this.mDividerWidth;
    L49:
        int r115 = ((LinearLayout.LayoutParams) r31).leftMargin + r22;
        r10 = r10;
        setChildFrame(r29, getLocationOffset(r29) + r115, r34, r112, r30);
        r22 = (getNextLocationOffset(r29) + (r112 + ((LinearLayout.LayoutParams) r31).rightMargin)) + r115;
        r23 = getChildrenSkipCount(r29, r24) + r113;
        goto L51
    L34:
        if (r33 != 48) goto L36;
        r34 = ((LinearLayout.LayoutParams) r31).topMargin + r10;
        if (r114 != (-1)) goto L44;
    L38:
        r210 = true;
        goto L47
    L44:
        r210 = true;
        r34 = (r18[1] - r114) + r34;
        goto L47
    L36:
        if (r33 == 80) goto L39;
        r34 = r10;
        goto L38
    L39:
        r34 = (r12 - r30) - ((LinearLayout.LayoutParams) r31).bottomMargin;
        if (r114 == (-1)) goto L38;
        r34 = r34 - (r19[2] - (r29.getMeasuredHeight() - r114));
    L27:
        r114 = -1;
        goto L28
    L26:
        r14 = r14;
        goto L27
    L50:
        r210 = true;
        goto L51
    L52:
        return;
    L12:
        r110 = 0;
        r111 = 1;
        goto L13
    L5:
        if (r20 == 5) goto L7;
        r22 = getPaddingLeft();
        goto L10
    L7:
        r22 = ((getPaddingLeft() + r27) - r25) - this.mTotalLength;
        goto L10
    }

    public void layoutVertical(int r19, int r20, int r21, int r22) {
        int r10 = getPaddingLeft();
        int r5 = r21 - r19;
        int r11 = r5 - getPaddingRight();
        int r12 = (r5 - r10) - getPaddingRight();
        int r13 = getVirtualChildCount();
        int r14 = this.mGravity;
        int r15 = r14 & 112;
        int r16 = r14 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int r17 = 2;
        if (r15 != 16) goto L5;
        int r18 = j0.c(r22 - r20, this.mTotalLength, 2, getPaddingTop());
    L9:
        int r110 = 0;
    L10:
        if (r110 >= r13) goto L33;
        View r111 = getVirtualChildAt(r110);
        if (r111 != null) goto L15;
        r18 = measureNullChild(r110) + r18;
    L32:
        r110 = r110 + 1;
        r17 = 2;
        goto L10
    L15:
        if (r111.getVisibility() == 8) goto L32;
        int r23 = r111.getMeasuredWidth();
        int r112 = r111.getMeasuredHeight();
        LayoutParams r24 = (LayoutParams) r111.getLayoutParams();
        int r25 = ((LinearLayout.LayoutParams) r24).gravity;
        if (r25 >= 0) goto L19;
        r25 = r16;
    L19:
        int r26 = GravityCompat.getAbsoluteGravity(r25, ViewCompat.getLayoutDirection(this)) & 7;
        if (r26 != 1) goto L22;
        int r27 = j0.c(r12, r23, r17, r10) + ((LinearLayout.LayoutParams) r24).leftMargin;
        int r28 = ((LinearLayout.LayoutParams) r24).rightMargin;
    L26:
        int r29 = r27 - r28;
    L24:
        int r30 = r29;
        if (hasDividerBeforeChildAt(r110) == false) goto L31;
        r18 = r18 + this.mDividerHeight;
    L31:
        int r113 = r18 + ((LinearLayout.LayoutParams) r24).topMargin;
        setChildFrame(r111, r30, getLocationOffset(r111) + r113, r23, r112);
        r18 = (getNextLocationOffset(r111) + (r112 + ((LinearLayout.LayoutParams) r24).bottomMargin)) + r113;
        r110 = r110 + getChildrenSkipCount(r111, r110);
        goto L32
    L22:
        if (r26 == 5) goto L25;
        r29 = ((LinearLayout.LayoutParams) r24).leftMargin + r10;
        goto L24
    L25:
        r27 = r11 - r23;
        r28 = ((LinearLayout.LayoutParams) r24).rightMargin;
        goto L26
    L33:
        return;
    L5:
        if (r15 == 80) goto L7;
        r18 = getPaddingTop();
        goto L9
    L7:
        r18 = ((getPaddingTop() + r22) - r20) - this.mTotalLength;
        goto L9
    }

    public void measureChildBeforeLayout(View r10, int r11, int r12, int r13, int r14, int r15) {
        measureChildWithMargins(r10, r12, r13, r14, r15);
    }

    public void measureHorizontal(int r40, int r41) {
        this.mTotalLength = 0;
        int r11 = getVirtualChildCount();
        int r12 = View.MeasureSpec.getMode(r40);
        int r13 = View.MeasureSpec.getMode(r41);
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
        boolean r5 = this.mBaselineAligned;
        boolean r14 = this.mUseLargestChild;
        int r16 = BasicMeasure.EXACTLY;
        if (r12 != 1073741824) goto L10;
        boolean r19 = true;
    L11:
        int r17 = 0;
        int r18 = 0;
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
        if (r17 >= r11) goto L89;
        View r29 = getVirtualChildAt(r17);
        if (r29 != null) goto L19;
        this.mTotalLength = measureNullChild(r17) + this.mTotalLength;
    L17:
        boolean r33 = r14;
        boolean r37 = r5;
        int r38 = r16;
        int r30 = r17;
        int r31 = r38;
    L88:
        int r32 = r30 + 1;
        r10 = r28;
        r14 = r33;
        r5 = r37;
        r16 = r31;
        r17 = r32;
        goto L12
    L19:
        if (r29.getVisibility() != 8) goto L22;
        r17 = r17 + getChildrenSkipCount(r29, r17);
        goto L17
    L22:
        if (hasDividerBeforeChildAt(r17) == false) goto L24;
        this.mTotalLength += this.mDividerWidth;
    L24:
        LayoutParams r110 = (LayoutParams) r29.getLayoutParams();
        float r34 = ((LinearLayout.LayoutParams) r110).weight;
        float r35 = r20 + r34;
        if (r12 != r16) goto L37;
        if (((LinearLayout.LayoutParams) r110).width != 0) goto L37;
        if (r34 <= 0.0f) goto L37;
        if (r19 == false) goto L32;
        this.mTotalLength = (((LinearLayout.LayoutParams) r110).leftMargin + ((LinearLayout.LayoutParams) r110).rightMargin) + this.mTotalLength;
    L33:
        if (r5 == false) goto L35;
        int r36 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r29.measure(r36, r36);
        int r39 = r17;
        r33 = r14;
        r37 = r5;
        View r42 = r29;
    L55:
        r31 = BasicMeasure.EXACTLY;
    L56:
        if (r13 != r31) goto L58;
    L60:
        boolean r43 = false;
    L61:
        int r44 = ((LinearLayout.LayoutParams) r110).topMargin + ((LinearLayout.LayoutParams) r110).bottomMargin;
        int r45 = r42.getMeasuredHeight() + r44;
        r25 = View.combineMeasuredStates(r25, r42.getMeasuredState());
        if (r37 == false) goto L69;
        int r46 = r42.getBaseline();
        if (r46 == (-1)) goto L69;
        int r47 = ((LinearLayout.LayoutParams) r110).gravity;
        if (r47 >= 0) goto L68;
        r47 = this.mGravity;
    L68:
        int r48 = (((r47 & 112) >> 4) & (-2)) >> 1;
        r15[r48] = Math.max(r15[r48], r46);
        r28[r48] = Math.max(r28[r48], r45 - r46);
    L69:
        r21 = Math.max(r21, r45);
        if (r26 == true) goto L72;
    L74:
        r26 = false;
    L76:
        if (((LinearLayout.LayoutParams) r110).weight <= 0.0f) goto L82;
        if (r43 == true) goto L80;
        r44 = r45;
    L80:
        r23 = Math.max(r23, r44);
    L81:
        int r111 = r39;
        r30 = getChildrenSkipCount(r42, r111) + r111;
        r20 = r35;
        goto L88
    L82:
        int r112 = r23;
        if (r43 == true) goto L86;
        r44 = r45;
    L86:
        r22 = Math.max(r22, r44);
        r23 = r112;
        goto L81
    L72:
        if (((LinearLayout.LayoutParams) r110).height != (-1)) goto L74;
        r26 = true;
        goto L76
    L58:
        if (((LinearLayout.LayoutParams) r110).height != (-1)) goto L60;
        r43 = true;
        r27 = true;
        goto L61
    L35:
        r39 = r17;
        r33 = r14;
        r37 = r5;
        r42 = r29;
        r24 = true;
        r31 = BasicMeasure.EXACTLY;
        goto L56
    L32:
        int r49 = this.mTotalLength;
        this.mTotalLength = Math.max(r49, (((LinearLayout.LayoutParams) r110).leftMargin + r49) + ((LinearLayout.LayoutParams) r110).rightMargin);
    L37:
        if (((LinearLayout.LayoutParams) r110).width == 0) goto L39;
    L41:
        byte r50 = -2;
        int r51 = Integer.MIN_VALUE;
    L43:
        if (r35 != 0.0f) goto L45;
        int r210 = this.mTotalLength;
    L46:
        r39 = r17;
        int r310 = r51;
        r33 = r14;
        r37 = r5;
        measureChildBeforeLayout(r29, r39, r40, r210, r41, 0);
        if (r310 == Integer.MIN_VALUE) goto L49;
        ((LinearLayout.LayoutParams) r110).width = r310;
    L49:
        int r52 = r29.getMeasuredWidth();
        if (r19 == false) goto L52;
        r42 = r29;
        this.mTotalLength = (getNextLocationOffset(r42) + ((((LinearLayout.LayoutParams) r110).leftMargin + r52) + ((LinearLayout.LayoutParams) r110).rightMargin)) + this.mTotalLength;
    L53:
        if (r33 == false) goto L55;
        r18 = Math.max(r52, r18);
        goto L55
    L52:
        r42 = r29;
        int r53 = this.mTotalLength;
        this.mTotalLength = Math.max(r53, getNextLocationOffset(r42) + (((r53 + r52) + ((LinearLayout.LayoutParams) r110).leftMargin) + ((LinearLayout.LayoutParams) r110).rightMargin));
        goto L53
    L45:
        r210 = 0;
        goto L46
    L39:
        if (r34 <= 0.0f) goto L41;
        r50 = -2;
        ((LinearLayout.LayoutParams) r110).width = -2;
        r51 = 0;
        goto L43
    L89:
        boolean r311 = r14;
        boolean r312 = r5;
        int r54 = r21;
        int r55 = r22;
        int r113 = r23;
        int r56 = r25;
        if (this.mTotalLength > 0) goto L92;
    L94:
        int r57 = r15[1];
        if (r57 == (-1)) goto L97;
    L104:
        int r58 = Math.max(r54, Math.max(r28[3], Math.max(r28[0], Math.max(r28[1], r28[2]))) + Math.max(r15[3], Math.max(r15[0], Math.max(r57, r15[2]))));
    L105:
        if (r311 == true) goto L107;
    L110:
        int r211 = r58;
        int r59 = (getPaddingRight() + getPaddingLeft()) + this.mTotalLength;
        this.mTotalLength = r59;
        int r60 = View.resolveSizeAndState(Math.max(r59, getSuggestedMinimumWidth()), r40, 0);
        int r61 = (16777215 & r60) - this.mTotalLength;
        if (r24 == true) goto L147;
        if (r61 != 0) goto L129;
    L131:
        int r62 = Math.max(r55, r113);
        if (r311 == true) goto L134;
    L146:
        int r212 = r11;
        int r63 = r56;
    L216:
        if (r26 == false) goto L218;
    L220:
        r62 = r211;
    L221:
        setMeasuredDimension(r60 | ((-16777216) & r63), View.resolveSizeAndState(Math.max((getPaddingBottom() + getPaddingTop()) + r62, getSuggestedMinimumHeight()), r41, r63 << 16));
        if (r27 == false) goto L239;
        forceUniformHeight(r212, r40);
        return;
    L239:
        return;
    L218:
        if (r13 == 1073741824) goto L220;
    L134:
        if (r12 == 1073741824) goto L146;
        int r114 = 0;
    L136:
        if (r114 >= r11) goto L146;
        View r64 = getVirtualChildAt(r114);
        if (r64 == null) goto L145;
        if (r64.getVisibility() == 8) goto L145;
        if (((LinearLayout.LayoutParams) ((LayoutParams) r64.getLayoutParams())).weight <= 0.0f) goto L145;
        r64.measure(View.MeasureSpec.makeMeasureSpec(r18, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r64.getMeasuredHeight(), BasicMeasure.EXACTLY));
    L145:
        r114 = r114 + 1;
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
        int r66 = r55;
        int r67 = -1;
        r63 = r56;
        int r115 = 0;
    L151:
        if (r115 >= r11) goto L204;
        View r116 = getVirtualChildAt(r115);
        if (r116 != null) goto L155;
    L156:
        int r68 = r61;
        r11 = r11;
    L203:
        r115 = r115 + 1;
        r61 = r68;
        r11 = r11;
        goto L151
    L155:
        if (r116.getVisibility() == 8) goto L156;
        LayoutParams r69 = (LayoutParams) r116.getLayoutParams();
        float r70 = ((LinearLayout.LayoutParams) r69).weight;
        if (r70 <= 0.0f) goto L174;
        int r71 = (int) ((r61 * r70) / r20);
        float r72 = r20 - r70;
        int r73 = r61 - r71;
        int r74 = ViewGroup.getChildMeasureSpec(r41, ((getPaddingBottom() + getPaddingTop()) + ((LinearLayout.LayoutParams) r69).topMargin) + ((LinearLayout.LayoutParams) r69).bottomMargin, ((LinearLayout.LayoutParams) r69).height);
        if (((LinearLayout.LayoutParams) r69).width != 0) goto L168;
        int r75 = BasicMeasure.EXACTLY;
        if (r12 != 1073741824) goto L169;
        if (r71 > 0) goto L167;
        r71 = 0;
    L167:
        r116.measure(View.MeasureSpec.makeMeasureSpec(r71, BasicMeasure.EXACTLY), r74);
    L173:
        r63 = View.combineMeasuredStates(r63, r116.getMeasuredState() & ViewCompat.MEASURED_STATE_MASK);
        r20 = r72;
        r68 = r73;
    L175:
        if (r19 == false) goto L178;
        this.mTotalLength = (getNextLocationOffset(r116) + ((r116.getMeasuredWidth() + ((LinearLayout.LayoutParams) r69).leftMargin) + ((LinearLayout.LayoutParams) r69).rightMargin)) + this.mTotalLength;
    L179:
        if (r13 != 1073741824) goto L181;
    L183:
        boolean r76 = false;
    L184:
        int r77 = ((LinearLayout.LayoutParams) r69).topMargin + ((LinearLayout.LayoutParams) r69).bottomMargin;
        int r117 = r116.getMeasuredHeight() + r77;
        r67 = Math.max(r67, r117);
        if (r76 == true) goto L188;
        r77 = r117;
    L188:
        int r78 = Math.max(r66, r77);
        if (r26 == false) goto L193;
        int r79 = -1;
        if (((LinearLayout.LayoutParams) r69).height != (-1)) goto L194;
        boolean r80 = true;
    L195:
        if (r312 == false) goto L202;
        int r118 = r116.getBaseline();
        if (r118 == r79) goto L202;
        int r81 = ((LinearLayout.LayoutParams) r69).gravity;
        if (r81 >= 0) goto L201;
        r81 = this.mGravity;
    L201:
        int r82 = (((r81 & 112) >> 4) & (-2)) >> 1;
        r15[r82] = Math.max(r15[r82], r118);
        r28[r82] = Math.max(r28[r82], r117 - r118);
    L202:
        r26 = r80;
        r66 = r78;
        r20 = r20;
    L194:
        r80 = false;
        goto L195
    L193:
        r79 = -1;
        goto L194
    L181:
        if (((LinearLayout.LayoutParams) r69).height != (-1)) goto L183;
        r76 = true;
        goto L184
    L178:
        int r83 = this.mTotalLength;
        this.mTotalLength = Math.max(r83, getNextLocationOffset(r116) + (((r116.getMeasuredWidth() + r83) + ((LinearLayout.LayoutParams) r69).leftMargin) + ((LinearLayout.LayoutParams) r69).rightMargin));
    L169:
        int r84 = r116.getMeasuredWidth() + r71;
        if (r84 >= 0) goto L172;
        r84 = 0;
    L172:
        r116.measure(View.MeasureSpec.makeMeasureSpec(r84, r75), r74);
        goto L173
    L168:
        r75 = BasicMeasure.EXACTLY;
        goto L169
    L174:
        r68 = r61;
        goto L175
    L204:
        r212 = r11;
        this.mTotalLength = (getPaddingRight() + getPaddingLeft()) + this.mTotalLength;
        int r85 = r15[1];
        if (r85 == (-1)) goto L207;
    L214:
        int r86 = Math.max(r67, Math.max(r28[3], Math.max(r28[0], Math.max(r28[1], r28[2]))) + Math.max(r15[3], Math.max(r15[0], Math.max(r85, r15[2]))));
    L215:
        r211 = r86;
        r62 = r66;
        goto L216
    L207:
        if (r15[0] != (-1)) goto L214;
        if (r15[2] != (-1)) goto L214;
        if (r15[3] != (-1)) goto L214;
        r86 = r67;
        goto L215
    L107:
        if (r12 == Integer.MIN_VALUE) goto L111;
        if (r12 != 0) goto L110;
    L111:
        this.mTotalLength = 0;
        int r87 = 0;
    L112:
        if (r87 >= r11) goto L110;
        View r88 = getVirtualChildAt(r87);
        if (r88 != null) goto L117;
        this.mTotalLength = measureNullChild(r87) + this.mTotalLength;
    L124:
        r87 = r87 + 1;
        r58 = r58;
        goto L112
    L117:
        if (r88.getVisibility() != 8) goto L120;
        r87 = r87 + getChildrenSkipCount(r88, r87);
        goto L124
    L120:
        LayoutParams r89 = (LayoutParams) r88.getLayoutParams();
        if (r19 == false) goto L123;
        this.mTotalLength = (getNextLocationOffset(r88) + ((((LinearLayout.LayoutParams) r89).leftMargin + r18) + ((LinearLayout.LayoutParams) r89).rightMargin)) + this.mTotalLength;
        goto L124
    L123:
        int r90 = this.mTotalLength;
        this.mTotalLength = Math.max(r90, getNextLocationOffset(r88) + (((r90 + r18) + ((LinearLayout.LayoutParams) r89).leftMargin) + ((LinearLayout.LayoutParams) r89).rightMargin));
        goto L124
    L97:
        if (r15[0] != (-1)) goto L104;
        if (r15[2] != (-1)) goto L104;
        if (r15[3] != (-1)) goto L104;
        r58 = r54;
        goto L105
    L92:
        if (hasDividerBeforeChildAt(r11) == false) goto L94;
        this.mTotalLength += this.mDividerWidth;
        goto L94
    L10:
        r19 = false;
        goto L11
    L5:
        if (this.mMaxDescent != null) goto L7;
        goto L6
    }

    public int measureNullChild(int r5) {
        return 0;
    }

    public void measureVertical(int r34, int r35) {
        this.mTotalLength = 0;
        int r11 = getVirtualChildCount();
        int r12 = View.MeasureSpec.getMode(r34);
        int r13 = View.MeasureSpec.getMode(r35);
        int r14 = this.mBaselineAlignedChildIndex;
        boolean r15 = this.mUseLargestChild;
        int r5 = 0;
        int r10 = 0;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
        boolean r110 = false;
        boolean r20 = false;
        boolean r111 = true;
        float r21 = 0.0f;
    L3:
        int r112 = 8;
        int r22 = r17;
        if (r19 >= r11) goto L71;
        View r23 = getVirtualChildAt(r19);
        if (r23 != null) goto L8;
        this.mTotalLength = measureNullChild(r19) + this.mTotalLength;
        int r24 = r13;
        r17 = r22;
        int r25 = r11;
    L70:
        r19 = r19 + 1;
        r11 = r25;
        r13 = r24;
        goto L3
    L8:
        int r26 = r5;
        if (r23.getVisibility() != 8) goto L12;
        r19 = r19 + getChildrenSkipCount(r23, r19);
        r17 = r22;
        r5 = r26;
        r25 = r11;
        r24 = r13;
        goto L70
    L12:
        if (hasDividerBeforeChildAt(r19) == false) goto L14;
        this.mTotalLength += this.mDividerHeight;
    L14:
        LayoutParams r113 = (LayoutParams) r23.getLayoutParams();
        float r27 = ((LinearLayout.LayoutParams) r113).weight;
        float r28 = r21 + r27;
        if (r13 == 1073741824) goto L17;
    L21:
        int r29 = r10;
        if (((LinearLayout.LayoutParams) r113).height == 0) goto L24;
    L26:
        int r30 = Integer.MIN_VALUE;
    L28:
        if (r28 != 0.0f) goto L30;
        int r210 = this.mTotalLength;
    L31:
        int r31 = r26;
        int r32 = r30;
        int r211 = r29;
        int r33 = r16;
        r24 = r13;
        int r114 = r22;
        r25 = r11;
        int r36 = r18;
        int r115 = r19;
        measureChildBeforeLayout(r23, r19, r34, 0, r35, r210);
        if (r32 == Integer.MIN_VALUE) goto L34;
        ((LinearLayout.LayoutParams) r113).height = r32;
    L34:
        int r37 = r23.getMeasuredHeight();
        int r38 = this.mTotalLength;
        View r39 = r23;
        this.mTotalLength = Math.max(r38, getNextLocationOffset(r39) + (((r38 + r37) + ((LinearLayout.LayoutParams) r113).topMargin) + ((LinearLayout.LayoutParams) r113).bottomMargin));
        if (r15 == false) goto L37;
        int r40 = Math.max(r37, r33);
    L38:
        if (r14 >= 0) goto L40;
    L42:
        if (r115 >= r14) goto L48;
        if (((LinearLayout.LayoutParams) r113).weight <= 0.0f) goto L48;
        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
    L48:
        if (r12 != 1073741824) goto L50;
    L52:
        boolean r41 = false;
    L53:
        int r42 = ((LinearLayout.LayoutParams) r113).leftMargin + ((LinearLayout.LayoutParams) r113).rightMargin;
        int r43 = r39.getMeasuredWidth() + r42;
        int r44 = Math.max(r211, r43);
        int r45 = View.combineMeasuredStates(r31, r39.getMeasuredState());
        if (r111 == true) goto L56;
    L58:
        r111 = false;
    L60:
        if (((LinearLayout.LayoutParams) r113).weight <= 0.0f) goto L65;
        if (r41 == true) goto L64;
        r42 = r43;
    L64:
        r17 = Math.max(r114, r42);
    L69:
        int r46 = getChildrenSkipCount(r39, r115) + r115;
        r16 = r40;
        r10 = r44;
        r21 = r28;
        r18 = r36;
        r19 = r46;
        r5 = r45;
        goto L70
    L65:
        if (r41 == true) goto L68;
        r42 = r43;
    L68:
        r36 = Math.max(r36, r42);
        r17 = r114;
        goto L69
    L56:
        if (((LinearLayout.LayoutParams) r113).width != (-1)) goto L58;
        r111 = true;
        goto L60
    L50:
        if (((LinearLayout.LayoutParams) r113).width != (-1)) goto L52;
        r41 = true;
        r20 = true;
        goto L53
    L40:
        if (r14 != (r115 + 1)) goto L42;
        this.mBaselineChildTop = this.mTotalLength;
        goto L42
    L37:
        r40 = r33;
        goto L38
    L30:
        r210 = 0;
        goto L31
    L24:
        if (r27 <= 0.0f) goto L26;
        ((LinearLayout.LayoutParams) r113).height = -2;
        r30 = 0;
        goto L28
    L17:
        if (((LinearLayout.LayoutParams) r113).height != 0) goto L21;
        if (r27 <= 0.0f) goto L21;
        int r47 = this.mTotalLength;
        this.mTotalLength = Math.max(r47, (((LinearLayout.LayoutParams) r113).topMargin + r47) + ((LinearLayout.LayoutParams) r113).bottomMargin);
        r40 = r16;
        r39 = r23;
        r36 = r18;
        r110 = true;
        r31 = r26;
        r211 = r10;
        r24 = r13;
        r114 = r22;
        r25 = r11;
        r115 = r19;
        goto L38
    L71:
        int r48 = r5;
        int r49 = r16;
        int r50 = r18;
        int r212 = r13;
        int r51 = r10;
        int r213 = r11;
        if (this.mTotalLength <= 0) goto L76;
        int r52 = r213;
        if (hasDividerBeforeChildAt(r52) == false) goto L78;
        this.mTotalLength += this.mDividerHeight;
    L78:
        if (r15 == true) goto L80;
    L92:
        int r116 = (getPaddingBottom() + getPaddingTop()) + this.mTotalLength;
        this.mTotalLength = r116;
        int r53 = View.resolveSizeAndState(Math.max(r116, getSuggestedMinimumHeight()), r35, 0);
        int r54 = (16777215 & r53) - this.mTotalLength;
        if (r110 == true) goto L114;
        if (r54 != 0) goto L96;
    L98:
        int r55 = Math.max(r50, r22);
        if (r15 == true) goto L101;
    L113:
        int r56 = r48;
    L156:
        if (r111 == false) goto L158;
    L160:
        r55 = r51;
    L161:
        setMeasuredDimension(View.resolveSizeAndState(Math.max((getPaddingRight() + getPaddingLeft()) + r55, getSuggestedMinimumWidth()), r34, r56), r53);
        if (r20 == false) goto L182;
        forceUniformWidth(r52, r35);
        return;
    L182:
        return;
    L158:
        if (r12 == 1073741824) goto L160;
    L101:
        if (r212 == 1073741824) goto L113;
        int r57 = 0;
    L103:
        if (r57 >= r52) goto L113;
        View r58 = getVirtualChildAt(r57);
        if (r58 == null) goto L112;
        if (r58.getVisibility() == 8) goto L112;
        if (((LinearLayout.LayoutParams) ((LayoutParams) r58.getLayoutParams())).weight <= 0.0f) goto L112;
        r58.measure(View.MeasureSpec.makeMeasureSpec(r58.getMeasuredWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r49, BasicMeasure.EXACTLY));
    L112:
        r57 = r57 + 1;
        goto L103
    L96:
        if (r21 <= 0.0f) goto L98;
    L114:
        float r117 = this.mWeightSum;
        if (r117 <= 0.0f) goto L117;
        r21 = r117;
    L117:
        this.mTotalLength = 0;
        int r118 = r54;
        int r59 = r50;
        r56 = r48;
        int r60 = 0;
    L118:
        if (r60 >= r52) goto L155;
        View r119 = getVirtualChildAt(r60);
        if (r119.getVisibility() != 8) goto L122;
        int r214 = r118;
    L154:
        r60 = r60 + 1;
        r118 = r214;
        goto L118
    L122:
        LayoutParams r120 = (LayoutParams) r119.getLayoutParams();
        float r121 = ((LinearLayout.LayoutParams) r120).weight;
        if (r121 <= 0.0f) goto L139;
        int r122 = (int) ((r118 * r121) / r21);
        float r61 = r21 - r121;
        r214 = r118 - r122;
        int r62 = ViewGroup.getChildMeasureSpec(r34, ((getPaddingRight() + getPaddingLeft()) + ((LinearLayout.LayoutParams) r120).leftMargin) + ((LinearLayout.LayoutParams) r120).rightMargin, ((LinearLayout.LayoutParams) r120).width);
        if (((LinearLayout.LayoutParams) r120).height != 0) goto L133;
        int r123 = BasicMeasure.EXACTLY;
        if (r212 != 1073741824) goto L134;
        if (r122 > 0) goto L132;
        r122 = 0;
    L132:
        r119.measure(r62, View.MeasureSpec.makeMeasureSpec(r122, BasicMeasure.EXACTLY));
    L138:
        r56 = View.combineMeasuredStates(r56, r119.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
        r21 = r61;
    L140:
        int r124 = ((LinearLayout.LayoutParams) r120).leftMargin + ((LinearLayout.LayoutParams) r120).rightMargin;
        int r125 = r119.getMeasuredWidth() + r124;
        r51 = Math.max(r51, r125);
        float r126 = r21;
        if (r12 == 1073741824) goto L145;
        int r215 = r56;
        int r63 = -1;
        if (((LinearLayout.LayoutParams) r120).width == (-1)) goto L147;
    L146:
        r124 = r125;
    L147:
        int r64 = Math.max(r59, r124);
        if (r111 == true) goto L150;
    L152:
        boolean r65 = false;
    L153:
        int r127 = this.mTotalLength;
        this.mTotalLength = Math.max(r127, getNextLocationOffset(r119) + (((r119.getMeasuredHeight() + r127) + ((LinearLayout.LayoutParams) r120).topMargin) + ((LinearLayout.LayoutParams) r120).bottomMargin));
        r111 = r65;
        r56 = r215;
        r59 = r64;
        r21 = r126;
        goto L154
    L150:
        if (((LinearLayout.LayoutParams) r120).width != r63) goto L152;
        r65 = true;
        goto L153
    L145:
        r215 = r56;
        r63 = -1;
    L134:
        int r128 = r119.getMeasuredHeight() + r122;
        if (r128 >= 0) goto L137;
        r128 = 0;
    L137:
        r119.measure(r62, View.MeasureSpec.makeMeasureSpec(r128, r123));
        goto L138
    L133:
        r123 = BasicMeasure.EXACTLY;
        goto L134
    L139:
        r214 = r118;
        goto L140
    L155:
        this.mTotalLength = (getPaddingBottom() + getPaddingTop()) + this.mTotalLength;
        r55 = r59;
        goto L156
    L80:
        if (r212 == Integer.MIN_VALUE) goto L82;
        if (r212 != 0) goto L92;
    L82:
        this.mTotalLength = 0;
        int r66 = 0;
    L83:
        if (r66 >= r52) goto L92;
        View r67 = getVirtualChildAt(r66);
        if (r67 != null) goto L88;
        this.mTotalLength = measureNullChild(r66) + this.mTotalLength;
    L91:
        r66 = r66 + 1;
        r112 = 8;
        goto L83
    L88:
        if (r67.getVisibility() != r112) goto L90;
        r66 = r66 + getChildrenSkipCount(r67, r66);
        goto L91
    L90:
        LayoutParams r129 = (LayoutParams) r67.getLayoutParams();
        int r130 = this.mTotalLength;
        this.mTotalLength = Math.max(r130, getNextLocationOffset(r67) + (((r130 + r49) + ((LinearLayout.LayoutParams) r129).topMargin) + ((LinearLayout.LayoutParams) r129).bottomMargin));
        goto L91
    L76:
        r52 = r213;
        goto L78
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        if (this.mDivider != null) goto L6;
        return;
    L6:
        if (this.mOrientation != 1) goto L8;
        drawDividersVertical(r5);
        return;
    L8:
        drawDividersHorizontal(r5);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r5) {
        super.onInitializeAccessibilityEvent(r5);
        r5.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r5) {
        super.onInitializeAccessibilityNodeInfo(r5);
        r5.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        if (this.mOrientation != 1) goto L5;
        layoutVertical(r10, r11, r12, r13);
        return;
    L5:
        layoutHorizontal(r10, r11, r12, r13);
    }

    @Override // android.view.View
    public void onMeasure(int r5, int r10) {
        if (this.mOrientation != 1) goto L5;
        measureVertical(r5, r10);
        return;
    L5:
        measureHorizontal(r5, r10);
    }

    public void setBaselineAligned(boolean r5) {
        this.mBaselineAligned = r5;
    }

    public void setBaselineAlignedChildIndex(int r5) {
        if (r5 < 0) goto L8;
        if (r5 >= getChildCount()) goto L8;
        this.mBaselineAlignedChildIndex = r5;
        return;
    L8:
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable r5) {
        if (r5 != this.mDivider) goto L5;
        return;
    L5:
        this.mDivider = r5;
        boolean r10 = false;
        if (r5 == null) goto L8;
        this.mDividerWidth = r5.getIntrinsicWidth();
        this.mDividerHeight = r5.getIntrinsicHeight();
    L9:
        if (r5 != null) goto L11;
        r10 = true;
    L11:
        setWillNotDraw(r10);
        requestLayout();
        return;
    L8:
        this.mDividerWidth = 0;
        this.mDividerHeight = 0;
        goto L9
    }

    public void setDividerPadding(int r5) {
        this.mDividerPadding = r5;
    }

    public void setGravity(@GravityInt int r5) {
        if (this.mGravity != r5) goto L5;
        return;
    L5:
        if ((8388615 & r5) != 0) goto L8;
        r5 = r5 | GravityCompat.START;
    L8:
        if ((r5 & 112) != 0) goto L10;
        r5 = r5 | 48;
    L10:
        this.mGravity = r5;
        requestLayout();
    }

    public void setHorizontalGravity(int r5) {
        int r10 = r5 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int r11 = this.mGravity;
        if ((8388615 & r11) == r10) goto L6;
        this.mGravity = r10 | ((-8388616) & r11);
        requestLayout();
        return;
    }

    public void setMeasureWithLargestChildEnabled(boolean r5) {
        this.mUseLargestChild = r5;
    }

    public void setOrientation(int r5) {
        if (this.mOrientation == r5) goto L6;
        this.mOrientation = r5;
        requestLayout();
        return;
    }

    public void setShowDividers(int r5) {
        if (r5 == this.mShowDividers) goto L5;
        requestLayout();
    L5:
        this.mShowDividers = r5;
    }

    public void setVerticalGravity(int r5) {
        int r10 = r5 & 112;
        int r11 = this.mGravity;
        if ((r11 & 112) == r10) goto L6;
        this.mGravity = r10 | (r11 & (-113));
        requestLayout();
        return;
    }

    public void setWeightSum(float r5) {
        this.mWeightSum = Math.max(0.0f, r5);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int r5 = this.mOrientation;
        if (r5 != 0) goto L7;
        return new LayoutParams(-2, -2);
    L7:
        if (r5 == 1) goto L9;
        return null;
    L9:
        return new LayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return generateLayoutParams(r5);
    }

    public LinearLayoutCompat(@NonNull Context r12, @Nullable AttributeSet r13, int r14) {
        super(r12, r13, r14);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray r5 = TintTypedArray.obtainStyledAttributes(r12, r13, R.styleable.LinearLayoutCompat, r14, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r12, R.styleable.LinearLayoutCompat, r13, r5.getWrappedTypeArray(), r14, 0);
        int r15 = r5.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (r15 < 0) goto L5;
        setOrientation(r15);
    L5:
        int r16 = r5.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (r16 < 0) goto L8;
        setGravity(r16);
    L8:
        boolean r17 = r5.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (r17 == true) goto L11;
        setBaselineAligned(r17);
    L11:
        this.mWeightSum = r5.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = r5.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = r5.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(r5.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = r5.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = r5.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        r5.recycle();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r5) {
        return new LayoutParams(getContext(), r5);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return new LayoutParams(r5);
    }
}
