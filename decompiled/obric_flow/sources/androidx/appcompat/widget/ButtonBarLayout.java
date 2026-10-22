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
        TypedArray r5 = r10.obtainStyledAttributes(r11, R.styleable.ButtonBarLayout);
        ViewCompat.saveAttributeDataForStyleable(this, r10, R.styleable.ButtonBarLayout, r11, r5, 0, 0);
        this.mAllowStacking = r5.getBoolean(R.styleable.ButtonBarLayout_allowStacking, true);
        r5.recycle();
        if (getOrientation() != 1) goto L6;
        setStacked(this.mAllowStacking);
        return;
    }

    private int getNextVisibleChildIndex(int r5) {
        int r10 = getChildCount();
    L3:
        if (r5 >= r10) goto L8;
        if (getChildAt(r5).getVisibility() == 0) goto L6;
        r5 = r5 + 1;
        goto L3
    L6:
        return r5;
    L8:
        return -1;
    }

    private boolean isStacked() {
        return this.mStacked;
    }

    private void setStacked(boolean r5) {
        if (this.mStacked == r5) goto L20;
        if (r5 == true) goto L6;
    L7:
        this.mStacked = r5;
        setOrientation(r5 ? 1 : 0);
        if (r5 == false) goto L10;
        int r10 = GravityCompat.END;
    L11:
        setGravity(r10);
        View r11 = findViewById(R.id.spacer);
        if (r11 == null) goto L17;
        if (r5 == false) goto L15;
        int r12 = 8;
    L16:
        r11.setVisibility(r12);
        goto L17
    L15:
        r12 = 4;
    L17:
        int r13 = getChildCount() - 2;
    L18:
        if (r13 < 0) goto L23;
        bringChildToFront(getChildAt(r13));
        r13 = r13 - 1;
        goto L18
    L23:
        return;
    L10:
        r10 = 80;
        goto L11
    L6:
        if (this.mAllowStacking == true) goto L7;
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        int r5 = View.MeasureSpec.getSize(r10);
        int r12 = 0;
        if (this.mAllowStacking == false) goto L11;
        if (r5 > this.mLastWidthSize) goto L7;
    L9:
        this.mLastWidthSize = r5;
        goto L11
    L7:
        if (isStacked() == false) goto L9;
        setStacked(false);
    L11:
        if (isStacked() == false) goto L13;
    L15:
        int r13 = r10;
        boolean r14 = false;
    L16:
        super.onMeasure(r13, r11);
        if (this.mAllowStacking == true) goto L19;
    L23:
        if (r14 == false) goto L25;
        super.onMeasure(r10, r11);
    L25:
        int r15 = getNextVisibleChildIndex(0);
        if (r15 < 0) goto L35;
        View r16 = getChildAt(r15);
        LinearLayout.LayoutParams r17 = (LinearLayout.LayoutParams) r16.getLayoutParams();
        int r18 = ((r16.getMeasuredHeight() + getPaddingTop()) + r17.topMargin) + r17.bottomMargin;
        if (isStacked() == false) goto L33;
        int r19 = getNextVisibleChildIndex(r15 + 1);
        if (r19 < 0) goto L32;
        r12 = (getChildAt(r19).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f))) + r18;
        goto L35
    L32:
        r12 = r18;
        goto L35
    L33:
        r12 = getPaddingBottom() + r18;
    L35:
        if (ViewCompat.getMinimumHeight(this) == r12) goto L40;
        setMinimumHeight(r12);
        if (r11 != 0) goto L41;
        super.onMeasure(r10, r11);
        return;
    L41:
        return;
    L40:
        return;
    L19:
        if (isStacked() == true) goto L23;
        if ((getMeasuredWidthAndState() & ViewCompat.MEASURED_STATE_MASK) != 16777216) goto L23;
        setStacked(true);
        r14 = true;
        goto L23
    L13:
        if (View.MeasureSpec.getMode(r10) != 1073741824) goto L15;
        r13 = View.MeasureSpec.makeMeasureSpec(r5, Integer.MIN_VALUE);
        r14 = true;
        goto L16
    }

    public void setAllowStacking(boolean r5) {
        if (this.mAllowStacking == r5) goto L11;
        this.mAllowStacking = r5;
        if (r5 == false) goto L7;
    L9:
        requestLayout();
        return;
    L7:
        if (isStacked() == false) goto L9;
        setStacked(false);
        goto L9
    }
}
