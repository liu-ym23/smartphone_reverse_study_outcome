package androidx.appcompat.widget;

import ai.j0;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(@Nullable Context r5) {
        super(r5);
    }

    private void forceUniformWidth(int r11, int r12) {
        int r5 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY);
        int r10 = 0;
    L3:
        if (r10 >= r11) goto L10;
        View r13 = getChildAt(r10);
        if (r13.getVisibility() == 8) goto L9;
        LinearLayoutCompat.LayoutParams r14 = (LinearLayoutCompat.LayoutParams) r13.getLayoutParams();
        if (((LinearLayout.LayoutParams) r14).width != (-1)) goto L9;
        int r15 = ((LinearLayout.LayoutParams) r14).height;
        ((LinearLayout.LayoutParams) r14).height = r13.getMeasuredHeight();
        measureChildWithMargins(r13, r5, 0, r12, 0);
        ((LinearLayout.LayoutParams) r14).height = r15;
    L9:
        r10 = r10 + 1;
        goto L3
    }

    private static int resolveMinimumHeight(View r5) {
        int r10 = ViewCompat.getMinimumHeight(r5);
        if (r10 <= 0) goto L6;
        return r10;
    L6:
        if ((r5 instanceof ViewGroup) == false) goto L11;
        ViewGroup r11 = (ViewGroup) r5;
        if (r11.getChildCount() != 1) goto L11;
        return resolveMinimumHeight(r11.getChildAt(0));
    L11:
        return 0;
    }

    private void setChildFrame(View r5, int r10, int r11, int r12, int r13) {
        r5.layout(r10, r11, r12 + r10, r13 + r11);
    }

    private boolean tryOnMeasure(int r17, int r18) {
        int r5 = getChildCount();
        View r10 = null;
        View r11 = null;
        View r12 = null;
        int r13 = 0;
    L4:
        if (r13 >= r5) goto L24;
        View r14 = getChildAt(r13);
        if (r14.getVisibility() == 8) goto L23;
        int r15 = r14.getId();
        if (r15 != R.id.topPanel) goto L12;
        r10 = r14;
        goto L23
    L12:
        if (r15 != R.id.buttonPanel) goto L15;
        r11 = r14;
        goto L23
    L15:
        if (r15 != R.id.contentPanel) goto L17;
    L20:
        if (r12 != null) goto L21;
        r12 = r14;
        goto L23
    L21:
        return false;
    L17:
        if (r15 == R.id.customPanel) goto L20;
        return false;
    L23:
        r13 = r13 + 1;
        goto L4
    L24:
        int r16 = View.MeasureSpec.getMode(r18);
        int r19 = View.MeasureSpec.getSize(r18);
        int r110 = View.MeasureSpec.getMode(r17);
        int r111 = getPaddingBottom() + getPaddingTop();
        if (r10 == null) goto L27;
        r10.measure(r17, 0);
        r111 = r111 + r10.getMeasuredHeight();
        int r20 = View.combineMeasuredStates(0, r10.getMeasuredState());
    L28:
        if (r11 == null) goto L30;
        r11.measure(r17, 0);
        int r112 = resolveMinimumHeight(r11);
        int r113 = r11.getMeasuredHeight() - r112;
        r111 = r111 + r112;
        r20 = View.combineMeasuredStates(r20, r11.getMeasuredState());
    L31:
        if (r12 == null) goto L36;
        if (r16 != 0) goto L34;
        int r114 = 0;
    L35:
        r12.measure(r17, r114);
        int r115 = r12.getMeasuredHeight();
        r111 = r111 + r115;
        r20 = View.combineMeasuredStates(r20, r12.getMeasuredState());
    L37:
        int r116 = r19 - r111;
        if (r11 == null) goto L43;
        int r117 = r111 - r112;
        int r118 = Math.min(r116, r113);
        if (r118 <= 0) goto L42;
        r116 = r116 - r118;
        r112 = r112 + r118;
    L42:
        r11.measure(r17, View.MeasureSpec.makeMeasureSpec(r112, BasicMeasure.EXACTLY));
        r111 = r117 + r11.getMeasuredHeight();
        r20 = View.combineMeasuredStates(r20, r11.getMeasuredState());
    L43:
        if (r12 == null) goto L46;
        if (r116 <= 0) goto L46;
        r12.measure(r17, View.MeasureSpec.makeMeasureSpec(r115 + r116, r16));
        r111 = (r111 - r115) + r12.getMeasuredHeight();
        r20 = View.combineMeasuredStates(r20, r12.getMeasuredState());
    L46:
        int r21 = 0;
        int r22 = 0;
    L47:
        if (r21 >= r5) goto L52;
        View r23 = getChildAt(r21);
        if (r23.getVisibility() == 8) goto L51;
        r22 = Math.max(r22, r23.getMeasuredWidth());
    L51:
        r21 = r21 + 1;
        goto L47
    L52:
        setMeasuredDimension(View.resolveSizeAndState((getPaddingRight() + getPaddingLeft()) + r22, r17, r20), View.resolveSizeAndState(r111, r18, 0));
        if (r110 == 1073741824) goto L67;
        forceUniformWidth(r5, r18);
        return true;
    L67:
        return true;
    L34:
        r114 = View.MeasureSpec.makeMeasureSpec(Math.max(0, r19 - r111), r16);
        goto L35
    L36:
        r115 = 0;
        goto L37
    L30:
        r112 = 0;
        r113 = 0;
        goto L31
    L27:
        r20 = 0;
        goto L28
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        int r10 = getPaddingLeft();
        int r5 = r21 - r19;
        int r11 = r5 - getPaddingRight();
        int r12 = (r5 - r10) - getPaddingRight();
        int r13 = getMeasuredHeight();
        int r14 = getChildCount();
        int r15 = getGravity();
        int r16 = r15 & 112;
        int r17 = r15 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int r110 = 2;
        if (r16 != 16) goto L5;
        int r23 = (((r22 - r20) - r13) / 2) + getPaddingTop();
    L9:
        Drawable r24 = getDividerDrawable();
        if (r24 != null) goto L12;
        int r111 = 0;
    L13:
        int r112 = 0;
    L14:
        if (r112 >= r14) goto L35;
        View r25 = getChildAt(r112);
        if (r25 == null) goto L34;
        if (r25.getVisibility() == 8) goto L34;
        int r26 = r25.getMeasuredWidth();
        int r113 = r25.getMeasuredHeight();
        LinearLayoutCompat.LayoutParams r27 = (LinearLayoutCompat.LayoutParams) r25.getLayoutParams();
        int r28 = ((LinearLayout.LayoutParams) r27).gravity;
        if (r28 >= 0) goto L22;
        r28 = r17;
    L22:
        int r29 = GravityCompat.getAbsoluteGravity(r28, ViewCompat.getLayoutDirection(this)) & 7;
        if (r29 != 1) goto L25;
        int r30 = j0.c(r12, r26, r110, r10) + ((LinearLayout.LayoutParams) r27).leftMargin;
        int r31 = ((LinearLayout.LayoutParams) r27).rightMargin;
    L28:
        int r32 = r30 - r31;
    L31:
        if (hasDividerBeforeChildAt(r112) == false) goto L33;
        r23 = r23 + r111;
    L33:
        int r114 = r23 + ((LinearLayout.LayoutParams) r27).topMargin;
        setChildFrame(r25, r32, r114, r26, r113);
        r23 = (r113 + ((LinearLayout.LayoutParams) r27).bottomMargin) + r114;
        goto L34
    L25:
        if (r29 == 5) goto L27;
        r32 = ((LinearLayout.LayoutParams) r27).leftMargin + r10;
        goto L31
    L27:
        r30 = r11 - r26;
        r31 = ((LinearLayout.LayoutParams) r27).rightMargin;
    L34:
        r112 = r112 + 1;
        r110 = 2;
        goto L14
    L35:
        return;
    L12:
        r111 = r24.getIntrinsicHeight();
        goto L13
    L5:
        if (r16 == 80) goto L7;
        r23 = getPaddingTop();
        goto L9
    L7:
        r23 = ((getPaddingTop() + r22) - r20) - r13;
        goto L9
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int r5, int r10) {
        if (tryOnMeasure(r5, r10) == true) goto L6;
        super.onMeasure(r5, r10);
        return;
    }

    public AlertDialogLayout(@Nullable Context r5, @Nullable AttributeSet r10) {
        super(r5, r10);
    }
}
