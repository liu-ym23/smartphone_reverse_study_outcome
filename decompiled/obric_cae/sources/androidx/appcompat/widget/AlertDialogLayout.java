package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.obric.cae.R;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context r8, AttributeSet r10) {
        super(r8, r10);
    }

    public static int j(View r8) {
        WeakHashMap<View, j0.h0> r10 = j0.w.f8437a;
        int r11 = j0.w.d.d(r8);
        if (r11 <= 0) goto L6;
        return r11;
    L6:
        if ((r8 instanceof ViewGroup) == false) goto L11;
        ViewGroup r12 = (ViewGroup) r8;
        if (r12.getChildCount() != 1) goto L11;
        return j(r12.getChildAt(0));
    L11:
        return 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getPaddingLeft();
        int r16 = r13 - r11;
        int r17 = r16 - getPaddingRight();
        int r18 = (r16 - r15) - getPaddingRight();
        int r8 = getMeasuredHeight();
        int r19 = getChildCount();
        int r20 = getGravity();
        int r21 = r20 & BWDLInnerConstant.LINK_RECOVERY;
        int r22 = r20 & 8388615;
        if (r21 != 16) goto L5;
        int r110 = (((r14 - r12) - r8) / 2) + getPaddingTop();
    L9:
        Drawable r111 = getDividerDrawable();
        int r23 = 0;
        if (r111 != null) goto L12;
        int r112 = 0;
    L13:
        if (r23 >= r19) goto L34;
        View r24 = getChildAt(r23);
        if (r24 == null) goto L33;
        if (r24.getVisibility() == 8) goto L33;
        int r25 = r24.getMeasuredWidth();
        int r26 = r24.getMeasuredHeight();
        LinearLayoutCompat.a r27 = (LinearLayoutCompat.a) r24.getLayoutParams();
        int r28 = ((LinearLayout.LayoutParams) r27).gravity;
        if (r28 >= 0) goto L21;
        r28 = r22;
    L21:
        WeakHashMap<View, j0.h0> r29 = j0.w.f8437a;
        int r30 = Gravity.getAbsoluteGravity(r28, j0.w.e.d(this)) & 7;
        if (r30 != 1) goto L24;
        int r31 = (((r18 - r25) / 2) + r15) + ((LinearLayout.LayoutParams) r27).leftMargin;
    L28:
        int r32 = r31 - ((LinearLayout.LayoutParams) r27).rightMargin;
    L30:
        if (i(r23) == false) goto L32;
        r110 = r110 + r112;
    L32:
        int r113 = r110 + ((LinearLayout.LayoutParams) r27).topMargin;
        r24.layout(r32, r113, r25 + r32, r26 + r113);
        r110 = (r26 + ((LinearLayout.LayoutParams) r27).bottomMargin) + r113;
        goto L33
    L24:
        if (r30 == 5) goto L26;
        r32 = ((LinearLayout.LayoutParams) r27).leftMargin + r15;
        goto L30
    L26:
        r31 = r17 - r25;
    L33:
        r23 = r23 + 1;
        goto L13
    L34:
        return;
    L12:
        r112 = r111.getIntrinsicHeight();
        goto L13
    L5:
        if (r21 == 80) goto L7;
        r110 = getPaddingTop();
        goto L9
    L7:
        r110 = ((getPaddingTop() + r14) - r12) - r8;
        goto L9
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int r17, int r18) {
        int r8 = getChildCount();
        View r10 = null;
        boolean r11 = false;
        View r12 = null;
        View r13 = null;
        int r14 = 0;
    L4:
        if (r14 >= r8) goto L22;
        View r15 = getChildAt(r14);
        if (r15.getVisibility() == 8) goto L21;
        int r16 = r15.getId();
        if (r16 != R.id.topPanel) goto L12;
        r10 = r15;
        goto L21
    L12:
        if (r16 != R.id.buttonPanel) goto L15;
        r12 = r15;
        goto L21
    L15:
        if (r16 != R.id.contentPanel) goto L17;
    L18:
        if (r13 != null) goto L61;
        r13 = r15;
    L61:
        if (r11 == true) goto L78;
        super.onMeasure(r17, r18);
        return;
    L78:
        return;
    L17:
        if (r16 != R.id.customPanel) goto L61;
    L21:
        r14 = r14 + 1;
        goto L4
    L22:
        int r19 = View.MeasureSpec.getMode(r18);
        int r20 = View.MeasureSpec.getSize(r18);
        int r110 = View.MeasureSpec.getMode(r17);
        int r111 = getPaddingBottom() + getPaddingTop();
        if (r10 == null) goto L25;
        r10.measure(r17, 0);
        r111 = r111 + r10.getMeasuredHeight();
        int r21 = View.combineMeasuredStates(0, r10.getMeasuredState());
    L26:
        if (r12 == null) goto L28;
        r12.measure(r17, 0);
        int r112 = j(r12);
        int r113 = r12.getMeasuredHeight() - r112;
        r111 = r111 + r112;
        r21 = View.combineMeasuredStates(r21, r12.getMeasuredState());
    L29:
        if (r13 == null) goto L34;
        if (r19 != 0) goto L32;
        int r114 = 0;
    L33:
        r13.measure(r17, r114);
        int r115 = r13.getMeasuredHeight();
        r111 = r111 + r115;
        r21 = View.combineMeasuredStates(r21, r13.getMeasuredState());
    L35:
        int r22 = r20 - r111;
        if (r12 == null) goto L41;
        int r116 = r111 - r112;
        int r117 = Math.min(r22, r113);
        if (r117 <= 0) goto L40;
        r22 = r22 - r117;
        r112 = r112 + r117;
    L40:
        r12.measure(r17, View.MeasureSpec.makeMeasureSpec(r112, 1073741824));
        r111 = r116 + r12.getMeasuredHeight();
        r21 = View.combineMeasuredStates(r21, r12.getMeasuredState());
    L41:
        if (r13 == null) goto L44;
        if (r22 <= 0) goto L44;
        r13.measure(r17, View.MeasureSpec.makeMeasureSpec(r115 + r22, r19));
        r111 = (r111 - r115) + r13.getMeasuredHeight();
        r21 = View.combineMeasuredStates(r21, r13.getMeasuredState());
    L44:
        int r23 = 0;
        int r24 = 0;
    L45:
        if (r23 >= r8) goto L50;
        View r25 = getChildAt(r23);
        if (r25.getVisibility() == 8) goto L49;
        r24 = Math.max(r24, r25.getMeasuredWidth());
    L49:
        r23 = r23 + 1;
        goto L45
    L50:
        setMeasuredDimension(View.resolveSizeAndState((getPaddingRight() + getPaddingLeft()) + r24, r17, r21), View.resolveSizeAndState(r111, r18, 0));
        if (r110 == 1073741824) goto L60;
        int r118 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int r119 = 0;
    L53:
        if (r119 >= r8) goto L60;
        View r26 = getChildAt(r119);
        if (r26.getVisibility() == 8) goto L59;
        LinearLayoutCompat.a r120 = (LinearLayoutCompat.a) r26.getLayoutParams();
        if (((LinearLayout.LayoutParams) r120).width != (-1)) goto L59;
        int r121 = ((LinearLayout.LayoutParams) r120).height;
        ((LinearLayout.LayoutParams) r120).height = r26.getMeasuredHeight();
        measureChildWithMargins(r26, r118, 0, r18, 0);
        ((LinearLayout.LayoutParams) r120).height = r121;
    L59:
        r119 = r119 + 1;
    L60:
        r11 = true;
        goto L61
    L32:
        r114 = View.MeasureSpec.makeMeasureSpec(Math.max(0, r20 - r111), r19);
        goto L33
    L34:
        r115 = 0;
        goto L35
    L28:
        r112 = 0;
        r113 = 0;
        goto L29
    L25:
        r21 = 0;
        goto L26
    }
}
