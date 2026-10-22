package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ButtonBarLayout extends LinearLayout {
    private static final int PEEK_BUTTON_DP = 16;
    private boolean mAllowStacking;
    private int mLastWidthSize;
    private boolean mStacked;

    public ButtonBarLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.mLastWidthSize = -1;
        int[] r12 = R.styleable.ButtonBarLayout;
        TypedArray r13 = r10.obtainStyledAttributes(r11, r12);
        ViewCompat.saveAttributeDataForStyleable(this, r10, r12, r11, r13, 0, 0);
        this.mAllowStacking = r13.getBoolean(R.styleable.ButtonBarLayout_allowStacking, true);
        r13.recycle();
        if (getOrientation() != 1) goto L6;
        setStacked(this.mAllowStacking);
        return;
    }

    private int getNextVisibleChildIndex(int r10) {
        int r11 = getChildCount();
    L3:
        if (r10 >= r11) goto L8;
        if (getChildAt(r10).getVisibility() == 0) goto L6;
        r10 = r10 + 1;
        goto L3
    L6:
        return r10;
    L8:
        return -1;
    }

    private boolean isStacked() {
        return this.mStacked;
    }

    private void setStacked(boolean r10) {
        if (this.mStacked == r10) goto L20;
        if (r10 == true) goto L6;
    L7:
        this.mStacked = r10;
        setOrientation(r10 ? 1 : 0);
        if (r10 == false) goto L10;
        int r11 = GravityCompat.END;
    L11:
        setGravity(r11);
        View r12 = findViewById(R.id.spacer);
        if (r12 == null) goto L17;
        if (r10 == false) goto L15;
        int r13 = 8;
    L16:
        r12.setVisibility(r13);
        goto L17
    L15:
        r13 = 4;
    L17:
        int r14 = getChildCount() - 2;
    L18:
        if (r14 < 0) goto L23;
        bringChildToFront(getChildAt(r14));
        r14 = r14 - 1;
        goto L18
    L23:
        return;
    L10:
        r11 = 80;
        goto L11
    L6:
        if (this.mAllowStacking == true) goto L7;
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getSize(r10);
        int r13 = 0;
        if (this.mAllowStacking == false) goto L11;
        if (r12 > this.mLastWidthSize) goto L7;
    L9:
        this.mLastWidthSize = r12;
        goto L11
    L7:
        if (isStacked() == false) goto L9;
        setStacked(false);
    L11:
        if (isStacked() == false) goto L13;
    L15:
        int r14 = r10;
        boolean r15 = false;
    L16:
        super.onMeasure(r14, r11);
        if (this.mAllowStacking == true) goto L19;
    L26:
        if (r15 == false) goto L28;
        super.onMeasure(r10, r11);
    L28:
        int r16 = getNextVisibleChildIndex(0);
        if (r16 < 0) goto L38;
        View r17 = getChildAt(r16);
        LinearLayout.LayoutParams r18 = (LinearLayout.LayoutParams) r17.getLayoutParams();
        int r19 = (((getPaddingTop() + r17.getMeasuredHeight()) + r18.topMargin) + r18.bottomMargin) + 0;
        if (isStacked() == false) goto L36;
        int r20 = getNextVisibleChildIndex(r16 + 1);
        if (r20 < 0) goto L35;
        r19 = r19 + (getChildAt(r20).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f)));
    L35:
        r13 = r19;
        goto L38
    L36:
        r13 = r19 + getPaddingBottom();
    L38:
        if (ViewCompat.getMinimumHeight(this) == r13) goto L43;
        setMinimumHeight(r13);
        if (r11 != 0) goto L44;
        super.onMeasure(r10, r11);
        return;
    L44:
        return;
    L43:
        return;
    L19:
        if (isStacked() == true) goto L26;
        if ((getMeasuredWidthAndState() & ViewCompat.MEASURED_STATE_MASK) != 16777216) goto L23;
        boolean r21 = true;
    L24:
        if (r21 == false) goto L26;
        setStacked(true);
        r15 = true;
        goto L26
    L23:
        r21 = false;
        goto L24
    L13:
        if (View.MeasureSpec.getMode(r10) != 1073741824) goto L15;
        r14 = View.MeasureSpec.makeMeasureSpec(r12, Integer.MIN_VALUE);
        r15 = true;
        goto L16
    }

    public void setAllowStacking(boolean r10) {
        if (this.mAllowStacking == r10) goto L11;
        this.mAllowStacking = r10;
        if (r10 == false) goto L7;
    L9:
        requestLayout();
        return;
    L7:
        if (isStacked() == false) goto L9;
        setStacked(false);
        goto L9
    }
}
