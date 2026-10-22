package com.obric.oui.swipeaction;

import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.bytedance.ies.bullet.service.popup.ui.primary.PrimaryDialog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f14613b;

    public /* synthetic */ b(KeyEvent.Callback r5, int r10) {
        this.f14612a = r10;
        this.f14613b = r5;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent r5) {
        switch(this.f14612a) {
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        OSwipeLayout.DragEdge r10 = OSwipeLayout.O;
        ((OSwipeLayout) this.f14613b).getClass();
        return true;
    L5:
        return super.onDoubleTap(r5);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent r5) {
        switch(this.f14612a) {
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        jn.f r10 = (jn.f) this.f14613b;
        r10.f18379i.abortAnimation();
        r10.F = 0;
        r10.D = true;
        r10.A = false;
        float r11 = r5.getX();
        r10.J = r11;
        r10.H = r11;
        float r12 = r5.getY();
        r10.K = r12;
        r10.I = r12;
        r10.E = r5.getPointerId(r5.getActionIndex());
        return true;
    L5:
        return super.onDown(r5);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent r5, MotionEvent r10, float r11, float r12) {
        switch(this.f14612a) {
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        boolean r13 = super.onFling(r5, r10, r11, r12);
        jn.f r14 = (jn.f) this.f14613b;
        if (r14.o() == false) goto L13;
        int r15 = r14.f18394y;
        if (r12 < (-r15)) goto L13;
        if (r12 > r15) goto L13;
        return r13;
    L13:
        if (r14.o() == true) goto L19;
        int r16 = r14.f18393x;
        if (r11 < (-r16)) goto L19;
        if (r11 > r16) goto L19;
        return r13;
    L19:
        r14.A = true;
        r14.f18379i.abortAnimation();
        jn.f.g(r14, r11, r12);
        return super.onFling(r5, r10, r11, r12);
    L5:
        return super.onFling(r5, r10, r11, r12);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent r10, MotionEvent r11, float r12, float r13) {
        switch(this.f14612a) {
            case 0: goto L44;
            case 1: goto L5;
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        jn.f r5 = (jn.f) this.f14613b;
        if (r5.B == true) goto L30;
        if (r11.findPointerIndex(r5.E) == (-1)) goto L50;
        float r14 = Math.abs(r12);
        float r15 = Math.abs(r13);
        if (r5.o() == false) goto L18;
        if (r15 <= r14) goto L18;
        if (r5.k((int) r13) == false) goto L18;
    L23:
        r5.B = true;
        jn.f.f(r5);
        ViewParent r16 = r5.getParent();
        if (r16 == null) goto L30;
        r16.requestDisallowInterceptTouchEvent(true);
    L18:
        if (r5.o() == false) goto L20;
    L26:
        ViewParent r17 = r5.getParent();
        if (r17 == null) goto L30;
        r17.requestDisallowInterceptTouchEvent(false);
        goto L30
    L20:
        if (r14 <= r15) goto L26;
        if (r5.h((int) r12) == false) goto L26;
    L50:
        return super.onScroll(r10, r11, r12, r13);
    L30:
        if (r5.B == false) goto L43;
        int r18 = r11.findPointerIndex(r5.E);
        float r19 = r11.getX(r18);
        float r20 = r11.getY(r18);
        float r21 = r5.H - r19;
        float r22 = r5.I - r20;
        float r23 = r5.F;
        if (r5.o() == false) goto L34;
        float r24 = r22;
    L35:
        r5.F = (int) (r23 + r24);
        r5.H = r19;
        r5.I = r20;
        if (r5.D == false) goto L39;
        r5.s();
        r5.D = false;
    L39:
        if (r5.o() == false) goto L41;
        r5.scrollBy(0, (int) (((double) r22) + 0.5d));
        goto L43
    L41:
        r5.scrollBy((int) (((double) r21) + 0.5d), 0);
        goto L43
    L34:
        r24 = r21;
    L43:
        return r5.B;
    L44:
        Intrinsics.checkNotNullParameter(r10, "e1");
        Intrinsics.checkNotNullParameter(r11, "e2");
        ViewParent r25 = ((OSwipeActionLayout) this.f14613b).getParent();
        if (r25 == null) goto L51;
        r25.requestDisallowInterceptTouchEvent(true);
        return false;
    L51:
        return false;
    L5:
        return super.onScroll(r10, r11, r12, r13);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent r5) {
        switch(this.f14612a) {
            case 3: goto L6;
            default: goto L5;
        };
    L6:
        Intrinsics.checkNotNullParameter(r5, "e");
        if (((PrimaryDialog) this.f14613b).g.contains((int) r5.getRawX(), (int) r5.getRawY()) == true) goto L13;
        Function0 r10 = ((PrimaryDialog) this.f14613b).f6060a;
        if (r10 == null) goto L13;
        if (((Boolean) r10.invoke()).booleanValue() != true) goto L13;
        ((PrimaryDialog) this.f14613b).dismiss();
        return true;
    L13:
        return false;
    L5:
        return super.onSingleTapConfirmed(r5);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent r5) {
        switch(this.f14612a) {
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        OSwipeLayout r10 = (OSwipeLayout) this.f14613b;
        if (r10.f14605w == false) goto L12;
        if (r10.w(r5) == false) goto L12;
        r10.q(true);
    L12:
        return super.onSingleTapUp(r5);
    L5:
        return super.onSingleTapUp(r5);
    }
}
