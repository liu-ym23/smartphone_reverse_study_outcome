package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.obric.cae.R;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f994b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f995m;

    public ButtonBarLayout(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f995m = -1;
        int[] r8 = c.a.f3225k;
        TypedArray r12 = r10.obtainStyledAttributes(r11, r8);
        WeakHashMap<View, j0.h0> r13 = j0.w.f8437a;
        j0.w.m.c(this, r10, r8, r11, r12, 0, 0);
        this.f993a = r12.getBoolean(0, true);
        r12.recycle();
        if (getOrientation() != 1) goto L6;
        setStacked(this.f993a);
        return;
    }

    private void setStacked(boolean r8) {
        if (this.f994b == r8) goto L20;
        if (r8 == true) goto L6;
    L7:
        this.f994b = r8;
        setOrientation(r8 ? 1 : 0);
        if (r8 == false) goto L10;
        int r10 = 8388613;
    L11:
        setGravity(r10);
        View r11 = findViewById(R.id.spacer);
        if (r11 == null) goto L17;
        if (r8 == false) goto L15;
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
        if (this.f993a == true) goto L7;
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        int r11 = View.MeasureSpec.getSize(r8);
        int r12 = 0;
        if (this.f993a == false) goto L11;
        if (r11 > this.f995m) goto L7;
    L9:
        this.f995m = r11;
        goto L11
    L7:
        if (this.f994b == false) goto L9;
        setStacked(false);
    L11:
        if (this.f994b == false) goto L13;
    L15:
        int r13 = r8;
        boolean r14 = false;
    L16:
        super.onMeasure(r13, r10);
        if (this.f993a == true) goto L19;
    L26:
        if (r14 == false) goto L28;
        super.onMeasure(r8, r10);
    L28:
        int r15 = getChildCount();
        int r16 = 0;
    L29:
        int r17 = -1;
        if (r16 >= r15) goto L35;
        if (getChildAt(r16).getVisibility() == 0) goto L36;
        r16 = r16 + 1;
    L36:
        if (r16 < 0) goto L49;
        View r18 = getChildAt(r16);
        LinearLayout.LayoutParams r19 = (LinearLayout.LayoutParams) r18.getLayoutParams();
        r12 = 0 + (((r18.getMeasuredHeight() + getPaddingTop()) + r19.topMargin) + r19.bottomMargin);
        if (this.f994b == false) goto L47;
        int r20 = r16 + 1;
        int r21 = getChildCount();
    L40:
        if (r20 >= r21) goto L45;
        if (getChildAt(r20).getVisibility() == 0) goto L43;
        r20 = r20 + 1;
        goto L40
    L43:
        r17 = r20;
    L45:
        if (r17 < 0) goto L49;
        int r22 = getChildAt(r17).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
    L48:
        r12 = r12 + r22;
        goto L49
    L47:
        r22 = getPaddingBottom();
    L49:
        WeakHashMap<View, j0.h0> r23 = j0.w.f8437a;
        if (j0.w.d.d(this) == r12) goto L59;
        setMinimumHeight(r12);
        if (r10 != 0) goto L60;
        super.onMeasure(r8, r10);
        return;
    L60:
        return;
    L59:
        return;
    L35:
        r16 = -1;
        goto L36
    L19:
        if (this.f994b == true) goto L26;
        if ((getMeasuredWidthAndState() & (-16777216)) != 16777216) goto L23;
        boolean r24 = true;
    L24:
        if (r24 == false) goto L26;
        setStacked(true);
        r14 = true;
        goto L26
    L23:
        r24 = false;
        goto L24
    L13:
        if (View.MeasureSpec.getMode(r8) != 1073741824) goto L15;
        r13 = View.MeasureSpec.makeMeasureSpec(r11, Integer.MIN_VALUE);
        r14 = true;
        goto L16
    }

    public void setAllowStacking(boolean r8) {
        if (this.f993a == r8) goto L11;
        this.f993a = r8;
        if (r8 == false) goto L7;
    L9:
        requestLayout();
        return;
    L7:
        if (this.f994b == false) goto L9;
        setStacked(false);
        goto L9
    }
}
