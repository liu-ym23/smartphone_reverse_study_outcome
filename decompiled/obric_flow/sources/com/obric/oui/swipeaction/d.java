package com.obric.oui.swipeaction;

import android.graphics.Rect;
import android.view.View;
import androidx.customview.widget.ViewDragHelper;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends ViewDragHelper.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSwipeLayout f14618b;

    public d(OSwipeLayout r5) {
        this.f14618b = r5;
        this.f14617a = true;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionHorizontal(View r10, int r11, int r12) {
        OSwipeLayout r13 = this.f14618b;
        if (r10 != r13.getSurfaceView()) goto L85;
        int r5 = f.f14620a[r13.f14592i.ordinal()];
        if (r5 == 1) goto L83;
        if (r5 == 2) goto L83;
        if (r5 == 3) goto L75;
        if (r5 == 4) goto L11;
    L106:
        return r11;
    L11:
        if (r11 > r13.getPaddingLeft()) goto L13;
        int r14 = r13.D;
        if (r14 > 0) goto L18;
        r14 = r13.f14595l;
    L18:
        int r15 = r13.getPaddingLeft() - r14;
        if (r13.f14608z == false) goto L72;
        float r16 = r14;
        int r17 = r13.getPaddingLeft() - ((int) (r13.B * r16));
        int r18 = r13.getPaddingLeft() - ((int) (r16 * r13.C));
        float r19 = 0.0f;
        if (r13.f14593j.getViewDragState() != 1) goto L48;
        float r20 = r13.f14594k + r12;
        r13.f14594k = r20;
        float r21 = r17;
        if (r20 >= r21) goto L47;
        float r22 = r18;
        float r23 = r10.getLeft();
        float r24 = r13.f14594k;
        if (r23 != r24) goto L28;
    L29:
        r19 = r23;
    L45:
        return (int) r19;
    L28:
        if (r23 == r22) goto L29;
        if (r21 >= r22) goto L36;
        if (r24 >= r21) goto L36;
    L34:
        r19 = r24;
    L36:
        if (r21 > r22) goto L38;
    L40:
        float r25 = r22 - r21;
        float r26 = (((r24 - r21) * 1.0f) / r25) + 1.0f;
        if (r26 == 0.0f) goto L45;
        r19 = ((1.0f - (1.0f / r26)) * r25) + r21;
        goto L45
    L38:
        if (r24 <= r21) goto L40;
    L47:
        return (int) r20;
    L48:
        if (r11 >= r17) goto L71;
        float r27 = r17;
        float r28 = r18;
        float r29 = r10.getLeft();
        float r30 = r11;
        if (r29 != r30) goto L53;
    L54:
        r19 = r29;
    L70:
        return (int) r19;
    L53:
        if (r29 == r28) goto L54;
        if (r27 >= r28) goto L61;
        if (r30 >= r27) goto L61;
    L59:
        r19 = r30;
    L61:
        if (r27 > r28) goto L63;
    L65:
        float r31 = r28 - r27;
        float r32 = (((r30 - r27) * 1.0f) / r31) + 1.0f;
        if (r32 == 0.0f) goto L70;
        r19 = ((1.0f - (1.0f / r32)) * r31) + r27;
        goto L70
    L63:
        if (r30 <= r27) goto L65;
    L71:
        return r11;
    L72:
        if (r11 >= r15) goto L106;
        return r15;
    L13:
        return r13.getPaddingLeft();
    L75:
        if (r11 >= r13.getPaddingLeft()) goto L79;
        return r13.getPaddingLeft();
    L79:
        if (r11 <= (r13.getPaddingLeft() + r13.f14595l)) goto L106;
        return r13.getPaddingLeft() + r13.f14595l;
    L83:
        return r13.getPaddingLeft();
    L85:
        if (r13.getCurrentBottomView() != r10) goto L106;
        int r33 = f.f14620a[r13.f14592i.ordinal()];
        if (r33 == 1) goto L105;
        if (r33 == 2) goto L105;
        if (r33 == 3) goto L99;
        if (r33 != 4) goto L106;
        if (r13.f14597n != OSwipeLayout.ShowMode.PullOut) goto L106;
        if (r11 >= (r13.getMeasuredWidth() - r13.f14595l)) goto L106;
        return r13.getMeasuredWidth() - r13.f14595l;
    L99:
        if (r13.f14597n != OSwipeLayout.ShowMode.PullOut) goto L106;
        if (r11 <= r13.getPaddingLeft()) goto L106;
        return r13.getPaddingLeft();
    L105:
        return r13.getPaddingLeft();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionVertical(View r10, int r11, int r12) {
        OSwipeLayout r13 = this.f14618b;
        if (r10 != r13.getSurfaceView()) goto L28;
        int r14 = f.f14620a[r13.f14592i.ordinal()];
        if (r14 == 1) goto L21;
        if (r14 == 2) goto L13;
        if (r14 == 3) goto L11;
        if (r14 == 4) goto L11;
    L68:
        return r11;
    L11:
        return r13.getPaddingTop();
    L13:
        if (r11 >= (r13.getPaddingTop() - r13.f14595l)) goto L17;
        return r13.getPaddingTop() - r13.f14595l;
    L17:
        if (r11 <= r13.getPaddingTop()) goto L68;
        return r13.getPaddingTop();
    L21:
        if (r11 >= r13.getPaddingTop()) goto L25;
        return r13.getPaddingTop();
    L25:
        if (r11 <= (r13.getPaddingTop() + r13.f14595l)) goto L68;
        return r13.getPaddingTop() + r13.f14595l;
    L28:
        View r15 = r13.getSurfaceView();
        if (r15 != null) goto L31;
        int r16 = 0;
    L32:
        int r5 = f.f14620a[r13.f14592i.ordinal()];
        if (r5 == 1) goto L55;
        if (r5 == 2) goto L41;
        if (r5 == 3) goto L39;
        if (r5 != 4) goto L68;
    L39:
        return r13.getPaddingTop();
    L41:
        if (r13.f14597n == OSwipeLayout.ShowMode.PullOut) goto L43;
        int r17 = r16 + r12;
        if (r17 < r13.getPaddingTop()) goto L51;
        return r13.getPaddingTop();
    L51:
        if (r17 > (r13.getPaddingTop() - r13.f14595l)) goto L68;
        return r13.getPaddingTop() - r13.f14595l;
    L43:
        if (r11 >= (r13.getMeasuredHeight() - r13.f14595l)) goto L68;
        return r13.getMeasuredHeight() - r13.f14595l;
    L55:
        if (r13.f14597n == OSwipeLayout.ShowMode.PullOut) goto L57;
        int r18 = r16 + r12;
        if (r18 >= r13.getPaddingTop()) goto L65;
        return r13.getPaddingTop();
    L65:
        if (r18 <= (r13.getPaddingTop() + r13.f14595l)) goto L68;
        return r13.getPaddingTop() + r13.f14595l;
    L57:
        if (r11 <= r13.getPaddingTop()) goto L68;
        return r13.getPaddingTop();
    L31:
        r16 = r15.getTop();
        goto L32
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int getViewHorizontalDragRange(View r5) {
        OSwipeLayout r10 = this.f14618b;
        int r11 = r10.D;
        if (r11 <= 0) goto L7;
        return (int) ((r11 * r10.C) * 2.0f);
    L7:
        return r10.f14595l;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int getViewVerticalDragRange(View r5) {
        return this.f14618b.f14595l;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewPositionChanged(View r11, int r12, int r13, int r14, int r15) {
        OSwipeLayout r10 = this.f14618b;
        View r16 = r10.getSurfaceView();
        if (r16 != null) goto L5;
        return;
    L5:
        View r17 = r10.getCurrentBottomView();
        int r5 = r16.getLeft();
        int r18 = r16.getRight();
        int r19 = r16.getTop();
        int r20 = r16.getBottom();
        if (r11 != r16) goto L18;
        if (r10.f14597n != OSwipeLayout.ShowMode.PullOut) goto L58;
        if (r17 == null) goto L58;
        OSwipeLayout.DragEdge r110 = r10.f14592i;
        if (r110 != OSwipeLayout.DragEdge.Left) goto L13;
    L16:
        r17.offsetLeftAndRight(r14);
        goto L58
    L13:
        if (r110 == OSwipeLayout.DragEdge.Right) goto L16;
        r17.offsetTopAndBottom(r15);
    L58:
        r10.t(r5, r19, r18, r20);
        r10.u(r5, r19, r14, r15);
        int r111 = 0;
        if (r10.f14608z == true) goto L61;
    L78:
        r10.invalidate();
        View r112 = r10.getCurrentBottomView();
        View r113 = r10.getSurfaceView();
        OSwipeLayout.Status r114 = r10.getOpenStatus();
        OSwipeLayout.Status r115 = OSwipeLayout.Status.Close;
        HashMap r116 = r10.f14602t;
        if (r114 != r115) goto L81;
        r116.remove(r112);
        r116.remove(r113);
        return;
    L81:
        View[] r117 = {r113, r112};
    L83:
        if (r111 >= 2) goto L92;
        View r118 = r117[r111];
        Rect r119 = (Rect) r116.get(r118);
        if (r119 != null) goto L87;
        r119 = new Rect();
        r116.put(r118, r119);
    L87:
        r119.left = r118.getLeft();
        r119.top = r118.getTop();
        r119.right = r118.getRight();
        r119.bottom = r118.getBottom();
        r111 = r111 + 1;
        goto L83
    L92:
        return;
    L61:
        if (r10.f14592i != OSwipeLayout.DragEdge.Right) goto L78;
        int r120 = r10.D;
        if (r120 > 0) goto L67;
        r120 = r10.f14595l;
    L67:
        if (r5 >= (r10.getPaddingLeft() - ((int) (r120 * r10.B)))) goto L69;
        boolean r121 = true;
    L70:
        h r122 = r10.A;
        if (r122 == null) goto L78;
        l r123 = (l) r122;
        if (r123.f14629k == r121) goto L78;
        r123.f14629k = r121;
        if (r121 == false) goto L78;
        com.lynx.tasm.utils.g.p(3, r123.f14623a.getContext());
        goto L78
    L69:
        r121 = false;
        goto L70
    L18:
        if (r10.getBottomViews().contains(r11) == false) goto L58;
        if (r10.f14597n != OSwipeLayout.ShowMode.PullOut) goto L22;
        r16.offsetLeftAndRight(r14);
        r16.offsetTopAndBottom(r15);
        goto L58
    L22:
        OSwipeLayout.DragEdge r124 = r10.f14592i;
        int r21 = r10.getPaddingLeft();
        int r22 = r10.getPaddingTop();
        OSwipeLayout.DragEdge r23 = OSwipeLayout.DragEdge.Right;
        if (r124 != r23) goto L26;
        r21 = r10.getMeasuredWidth() - r10.f14595l;
    L28:
        OSwipeLayout.DragEdge r24 = OSwipeLayout.DragEdge.Left;
        if (r124 == r24) goto L33;
        if (r124 == r23) goto L33;
        int r125 = r10.getMeasuredWidth() + r21;
        int r25 = r10.f14595l + r22;
    L34:
        Rect r26 = new Rect(r21, r22, r125, r25);
        if (r17 == null) goto L37;
        r17.layout(r26.left, r26.top, r26.right, r26.bottom);
    L37:
        int r126 = r16.getLeft() + r14;
        int r127 = r16.getTop() + r15;
        if (r10.f14592i != r24) goto L43;
        if (r126 >= r10.getPaddingLeft()) goto L43;
        r126 = r10.getPaddingLeft();
    L57:
        r16.layout(r126, r127, r10.getMeasuredWidth() + r126, r10.getMeasuredHeight() + r127);
    L43:
        if (r10.f14592i != r23) goto L48;
        if (r126 <= r10.getPaddingLeft()) goto L48;
        r126 = r10.getPaddingLeft();
    L48:
        if (r10.f14592i != OSwipeLayout.DragEdge.Top) goto L53;
        if (r127 >= r10.getPaddingTop()) goto L53;
        r127 = r10.getPaddingTop();
    L53:
        if (r10.f14592i != OSwipeLayout.DragEdge.Bottom) goto L57;
        if (r127 <= r10.getPaddingTop()) goto L57;
        r127 = r10.getPaddingTop();
    L33:
        r125 = r10.f14595l + r21;
        r25 = r10.getMeasuredHeight() + r22;
        goto L34
    L26:
        if (r124 != OSwipeLayout.DragEdge.Bottom) goto L28;
        r22 = r10.getMeasuredHeight() - r10.f14595l;
        goto L28
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewReleased(View r10, float r11, float r12) {
        super.onViewReleased(r10, r11, r12);
        OSwipeLayout r13 = this.f14618b;
        if (r13.f14608z == true) goto L5;
    L20:
        boolean r5 = this.f14617a;
        float r14 = r13.f14593j.getMinVelocity();
        View r15 = r13.getSurfaceView();
        OSwipeLayout.DragEdge r16 = r13.f14592i;
        if (r16 == null) goto L80;
        if (r15 == null) goto L80;
        if (r13.f14608z == true) goto L27;
    L29:
        if (r5 == false) goto L31;
        float r17 = r13.f14607y;
    L33:
        if (r16 != OSwipeLayout.DragEdge.Left) goto L45;
        if (r11 <= r14) goto L38;
        r13.x();
        goto L80
    L38:
        if (r11 >= (-r14)) goto L41;
        r13.q(true);
        goto L80
    L41:
        if (((r13.getSurfaceView().getLeft() * 1.0f) / r13.f14595l) <= r17) goto L43;
        r13.x();
        goto L80
    L43:
        r13.q(true);
        goto L80
    L45:
        if (r16 != OSwipeLayout.DragEdge.Right) goto L57;
        if (r11 <= r14) goto L50;
        r13.q(true);
        goto L80
    L50:
        if (r11 >= (-r14)) goto L53;
        r13.x();
        goto L80
    L53:
        if ((((-r13.getSurfaceView().getLeft()) * 1.0f) / r13.f14595l) <= r17) goto L55;
        r13.x();
        goto L80
    L55:
        r13.q(true);
        goto L80
    L57:
        if (r16 != OSwipeLayout.DragEdge.Top) goto L69;
        if (r12 <= r14) goto L62;
        r13.x();
        goto L80
    L62:
        if (r12 >= (-r14)) goto L65;
        r13.q(true);
        goto L80
    L65:
        if (((r13.getSurfaceView().getTop() * 1.0f) / r13.f14595l) <= r17) goto L67;
        r13.x();
        goto L80
    L67:
        r13.q(true);
        goto L80
    L69:
        if (r16 != OSwipeLayout.DragEdge.Bottom) goto L80;
        if (r12 <= r14) goto L74;
        r13.q(true);
        goto L80
    L74:
        if (r12 >= (-r14)) goto L77;
        r13.x();
        goto L80
    L77:
        if ((((-r13.getSurfaceView().getTop()) * 1.0f) / r13.f14595l) <= r17) goto L79;
        r13.x();
        goto L80
    L79:
        r13.q(true);
        goto L80
    L31:
        r17 = r13.f14606x;
        goto L33
    L27:
        if (r13.E == false) goto L29;
    L80:
        Iterator r18 = r13.f14599p.iterator();
    L82:
        if (r18.hasNext() == false) goto L84;
        ((i) r18.next()).b(r13);
        goto L82
    L84:
        r13.invalidate();
        return;
    L5:
        if (r13.f14592i != OSwipeLayout.DragEdge.Right) goto L20;
        int r19 = r13.D;
        if (r19 > 0) goto L10;
        r19 = r13.f14595l;
    L10:
        int r20 = r13.getPaddingLeft() - ((int) (r19 * r13.B));
        View r21 = r13.getSurfaceView();
        if (r21 == null) goto L20;
        if (r21.getLeft() >= r20) goto L20;
        h r22 = r13.A;
        if (r22 == null) goto L20;
        r13.E = true;
        k r23 = ((l) r22).f14625c;
        if (r23 == null) goto L20;
        r23.onQuickDelete();
        goto L20
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final boolean tryCaptureView(View r10, int r11) {
        OSwipeLayout r12 = this.f14618b;
        boolean r5 = true;
        if (r10 != r12.getSurfaceView()) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == true) goto L11;
    L15:
        return r13;
    L11:
        if (r12.getOpenStatus() == OSwipeLayout.Status.Close) goto L14;
        r5 = false;
    L14:
        this.f14617a = r5;
        r12.f14594k = r10.getLeft();
        goto L15
    L5:
        if (r12.getBottomViews().contains(r10) == true) goto L8;
        r13 = false;
        goto L9
    }
}
