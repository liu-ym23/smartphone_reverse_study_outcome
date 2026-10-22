package com.bytedance.ies.xelement.input;

import ai.j0;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.ies.xelement.overlay.LynxOverlayView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll;
import com.lynx.tasm.behavior.ui.y;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.picker.reels.views.WheelView;
import com.obric.oui.titlebar.optimize.OCTitleBar;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class n implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6451b;

    public /* synthetic */ n(Object r5, int r10) {
        this.f6450a = r10;
        this.f6451b = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        LynxEditText r5 = null;
        ViewGroup.LayoutParams r10 = null;
        r10 = null;
        boolean r11 = false;
        Object r12 = this.f6451b;
        switch(this.f6450a) {
            case 0: goto L75;
            case 1: goto L69;
            case 2: goto L63;
            default: goto L4;
        };
    L4:
        int r13 = OCTitleBar.f14866m;
        OCTitleBar r14 = (OCTitleBar) r12;
        Intrinsics.checkNotNullParameter(r14, "this$0");
        r14.getClass();
        r14.getViewTreeObserver().removeOnGlobalLayoutListener(r14.f14876l);     // Catch: Exception -> L7
    L10:
        if (r14.f14869a == false) goto L131;
        Rect r15 = new Rect();
        Rect r16 = new Rect();
        List r17 = r14.e;
        if (r17 == null) goto L19;
        Iterator r18 = r17.iterator();
    L17:
        if (r18.hasNext() == false) goto L19;
        View r19 = (View) r18.next();
        Rect r20 = new Rect();
        r19.getGlobalVisibleRect(r20);
        r15.union(r20.left, r20.top, r20.right, r20.bottom);
    L19:
        List r21 = r14.f;
        if (r21 == null) goto L27;
        Iterator r22 = r21.iterator();
    L24:
        if (r22.hasNext() == false) goto L27;
        View r23 = (View) r22.next();
        Rect r24 = new Rect();
        r23.getGlobalVisibleRect(r24);
        r16.union(r24.left, r24.top, r24.right, r24.bottom);
    L27:
        if (r15.isEmpty() == false) goto L29;
        int r25 = 0;
    L30:
        int r26 = RangesKt.coerceAtLeast(r25, 0);
        if (r16.isEmpty() == false) goto L33;
        int r27 = 0;
    L34:
        int r28 = RangesKt.coerceAtLeast(r27, 0);
        int r29 = Math.max(r26, r28);
        StringBuilder r30 = j0.v("adjustTitleViewSpace, scene: OnGlobalLayoutListener, leftSpace: ", r26, r28, ", rightSpace: ", ", leftViewRectF: ");
        r30.append(r15);
        r30.append(", rightViewRectF: ");
        r30.append(r16);
        r30.append(", width: ");
        r30.append(r14.getWidth());
        r30.append(", height: ");
        r30.append(r14.getHeight());
        ps.a.a("OCTitleBar", r30.toString());
        if (r29 <= 0) goto L130;
        TextView r110 = r14.f14872h;
        if (r110 != null) goto L39;
        ViewGroup.LayoutParams r111 = null;
    L40:
        if (r111 != null) goto L43;
    L41:
        r111 = null;
    L44:
        RelativeLayout.LayoutParams r112 = (RelativeLayout.LayoutParams) r111;
        if (r112 == null) goto L48;
        r112.leftMargin = r29;
        r112.rightMargin = r29;
    L48:
        TextView r113 = r14.f14874j;
        if (r113 != null) goto L51;
        ViewGroup.LayoutParams r114 = null;
    L52:
        if (r114 != null) goto L55;
    L57:
        RelativeLayout.LayoutParams r31 = (RelativeLayout.LayoutParams) r10;
        if (r31 == null) goto L61;
        r31.leftMargin = r29;
        r31.rightMargin = r29;
    L61:
        r14.requestLayout();
        return;
    L55:
        if ((r114 instanceof RelativeLayout.LayoutParams) == false) goto L57;
        r10 = r114;
        goto L57
    L51:
        r114 = r113.getLayoutParams();
        goto L52
    L43:
        if ((r111 instanceof RelativeLayout.LayoutParams) == false) goto L41;
    L39:
        r111 = r110.getLayoutParams();
        goto L40
    L130:
        return;
    L33:
        r27 = r14.getWidth() - r16.left;
        goto L34
    L29:
        r25 = r15.right;
        goto L30
    L131:
        return;
    L7:
        e = move-exception;
        ps.a.b(e, "OCTitleBar", "removeGlobalLayoutListener: ");
        goto L10
    L63:
        int r115 = WheelView.C;
        WheelView r32 = (WheelView) r12;
        Intrinsics.checkNotNullParameter(r32, "this$0");
        RecyclerView r116 = r32.f14042a;
        if (r116.getHeight() <= 0) goto L67;
        r116.setPadding(r116.getPaddingLeft(), 0, r116.getPaddingRight(), 0);
    L67:
        r32.c();
        return;
    L69:
        int r117 = LynxOverlayView.f6470t;
        LynxOverlayView r33 = (LynxOverlayView) r12;
        Intrinsics.checkNotNullParameter(r33, "this$0");
        LynxContext r118 = r33.getLynxContext();
        if (r118 == null) goto L132;
        y r119 = r118.f10155x;
        if (r119 == null) goto L133;
        r119.h();
        return;
    L133:
        return;
    L132:
        return;
    L75:
        o r34 = (o) r12;
        Intrinsics.checkNotNullParameter(r34, "this$0");
        com.lynx.tasm.behavior.o r120 = r34.f;
        r34.f6455h = r120.f;
        r34.g = r120.f10305h;
        boolean r121 = r34.d();
        LynxBaseInputView r35 = r34.f6452a;
        if (r121 == false) goto L111;
        int r122 = r34.f.e.getWindow().getDecorView().getHeight();
        int r36 = r34.f6455h;
        if ((((double) r122) / ((double) r36)) >= 0.8d) goto L80;
        Object[] r37 = true;
    L81:
        int r38 = r36 - r122;
        if (r34.f6460m == r38) goto L84;
        r34.f6462o = true;
        r34.f6460m = r38;
    L86:
        if (r34.f6462o == false) goto L111;
        if (r37 == false) goto L101;
        LynxEditText r39 = r34.e;
        if (r39 == null) goto L111;
        if (r39.isFocused() != true) goto L111;
        LynxBaseUI r40 = r35.getParentBaseUI();
    L94:
        if (r40 == null) goto L99;
        if ((r40 instanceof AbsLynxUIScroll) == true) goto L97;
        r40 = r40.getParentBaseUI();
        goto L94
    L97:
        r122 = r122 - ((ViewGroup) ((AbsLynxUIScroll) r40).getView()).getTop();
    L99:
        r34.f6461n = r122;
        r34.e();
        goto L111
    L101:
        if (r34.f6457j == false) goto L111;
        LynxBaseUI r123 = r35.getParentBaseUI();
    L103:
        if (r123 == null) goto L111;
        if ((r123 instanceof AbsLynxUIScroll) == true) goto L106;
        r123 = r123.getParentBaseUI();
        goto L103
    L106:
        AbsLynxUIScroll r124 = (AbsLynxUIScroll) r123;
        if (((ViewGroup) r124.getView()).getChildAt(0).getPaddingBottom() == 0) goto L111;
        ((ViewGroup) r124.getView()).getChildAt(0).setPadding(0, 0, 0, 0);
        goto L111
    L84:
        r34.f6462o = false;
        goto L86
    L80:
        r37 = false;
    L111:
        if ((((double) r35.getLynxContext().k().getKeyboardEvent().e.getWindow().getDecorView().getHeight()) / ((double) r35.H.f6455h)) >= 0.8d) goto L114;
        r11 = true;
    L114:
        if (r35.E == false) goto L134;
        if (r11 == true) goto L135;
        LynxEditText r125 = r35.f6402a;
        if (r125 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L120:
        r5.clearFocus();
        return;
    L119:
        r5 = r125;
        goto L120
    L135:
        return;
    }
}
