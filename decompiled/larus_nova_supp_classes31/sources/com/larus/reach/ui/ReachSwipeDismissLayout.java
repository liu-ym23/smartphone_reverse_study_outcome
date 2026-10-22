package com.larus.reach.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.larus.common_ui.venus.ShapeLinearLayout;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020\u0011H\u0002J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\"H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/reach/ui/ReachSwipeDismissLayout;", "Lcom/larus/common_ui/venus/ShapeLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "swipeDirection", "getSwipeDirection", "()I", "setSwipeDirection", "(I)V", "canHandleSwipe", "Lkotlin/Function0;", "", "getCanHandleSwipe", "()Lkotlin/jvm/functions/Function0;", "setCanHandleSwipe", "(Lkotlin/jvm/functions/Function0;)V", "onSwipeDismiss", "", "getOnSwipeDismiss", "setOnSwipeDismiss", "touchSlop", "downX", "", "downY", "intercepting", "dismissRequested", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "shouldIntercept", "hasMovedBeyondTap", "swipeEnabled", "cancelPendingClick", "reset", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ReachSwipeDismissLayout extends ShapeLinearLayout {
    public int N;
    public Function0<Boolean> O;
    public Function0<Unit> P;
    public final int Q;
    public float R;
    public float S;
    public boolean T;
    public boolean U;

    public static final class a {
    }

    static {
    }

    public ReachSwipeDismissLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ReachSwipeDismissLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void i() {
        this.T = false;
        this.U = false;
    }

    public final boolean k() {
        Function0<Boolean> r0 = this.O;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
    L12:
        return false;
    L10:
        if (this.P == null) goto L12;
        return true;
    L5:
        if (((Boolean) r0.invoke()).booleanValue() == true) goto L7;
        r1 = true;
        goto L8
    }

    public final Function0<Boolean> getCanHandleSwipe() {
        return this.O;
    }

    public final Function0<Unit> getOnSwipeDismiss() {
        return this.P;
    }

    public final int getSwipeDirection() {
        return this.N;
    }

    public final boolean h(MotionEvent r3) {
        float r0 = r3.getRawX() - this.R;
        float r4 = r3.getRawY() - this.S;
        if (Math.abs(r0) <= this.Q) goto L5;
    L8:
        return true;
    L5:
        if (Math.abs(r4) > this.Q) goto L8;
        return false;
    }

    public final boolean j(MotionEvent r5) {
        float r0 = r5.getRawX() - this.R;
        float r1 = r5.getRawY() - this.S;
        if (h(r5) == true) goto L6;
        return false;
    L6:
        if (this.N != 1) goto L11;
        if (r1 > this.Q) goto L12;
    L13:
        boolean r6 = false;
    L14:
        if (r6 == true) goto L16;
        return false;
    L16:
        if (Math.abs(r1) <= Math.abs(r0)) goto L20;
        return true;
    L20:
        return false;
    L12:
        r6 = true;
        goto L14
    L11:
        if (r1 >= (-this.Q)) goto L13;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        if (k() == true) goto L6;
        i();
        return super/*android.widget.LinearLayout*/.onInterceptTouchEvent(r4);
    L6:
        int r0 = r4.getActionMasked();
        if (r0 != 0) goto L9;
        this.R = r4.getRawX();
        this.S = r4.getRawY();
        this.T = false;
        this.U = false;
    L33:
        return super/*android.widget.LinearLayout*/.onInterceptTouchEvent(r4);
    L9:
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L19;
        if (r0 != 3) goto L33;
        if (this.U == true) goto L33;
        i();
        goto L33
    L19:
        if (j(r4) == false) goto L33;
        this.T = true;
        ViewParent r5 = getParent();
        if (r5 == null) goto L23;
        r5.requestDisallowInterceptTouchEvent(true);
    L23:
        return true;
    L25:
        if (h(r4) == false) goto L29;
        this.T = true;
        return true;
    L29:
        if (this.U == true) goto L33;
        i();
        goto L33
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (k() == true) goto L6;
        i();
        return super/*android.widget.LinearLayout*/.onTouchEvent(r6);
    L6:
        int r0 = r6.getActionMasked();
        if (r0 == 0) goto L58;
        if (r0 != 1) goto L10;
        boolean r1 = h(r6);
        if (j(r6) == true) goto L38;
    L42:
        if (r1 == false) goto L44;
    L49:
        boolean r2 = true;
    L50:
        i();
        ViewParent r3 = getParent();
        if (r3 == null) goto L53;
        r3.requestDisallowInterceptTouchEvent(false);
    L53:
        if (r2 == false) goto L55;
    L56:
        return true;
    L55:
        if (super/*android.widget.LinearLayout*/.onTouchEvent(r6) == true) goto L56;
        return false;
    L44:
        if (this.T == true) goto L49;
        if (this.U == true) goto L49;
        r2 = false;
        goto L50
    L38:
        if (this.U == true) goto L42;
        this.U = true;
        Function0<Unit> r4 = this.P;
        if (r4 == null) goto L42;
        r4.invoke();
        goto L42
    L10:
        if (r0 == 2) goto L23;
        if (r0 != 3) goto L60;
        if (this.U == false) goto L19;
        i();
        ViewParent r7 = getParent();
        if (r7 == null) goto L18;
        r7.requestDisallowInterceptTouchEvent(false);
    L18:
        return true;
    L19:
        i();
        ViewParent r5 = getParent();
        if (r5 == null) goto L60;
        r5.requestDisallowInterceptTouchEvent(false);
    L60:
        if (this.T == false) goto L62;
    L63:
        return true;
    L62:
        if (super/*android.widget.LinearLayout*/.onTouchEvent(r6) == true) goto L63;
        return false;
    L23:
        if (this.T == true) goto L27;
        if (j(r6) == false) goto L60;
    L27:
        if (this.U == true) goto L60;
        this.T = true;
        this.U = true;
        MotionEvent r8 = MotionEvent.obtain(r6);
        r8.setAction(3);
        super/*android.widget.LinearLayout*/.onTouchEvent(r8);
        r8.recycle();
        Function0<Unit> r9 = this.P;
        if (r9 == null) goto L31;
        r9.invoke();
    L31:
        ViewParent r10 = getParent();
        if (r10 == null) goto L34;
        r10.requestDisallowInterceptTouchEvent(false);
    L34:
        return true;
    L58:
        this.R = r6.getRawX();
        this.S = r6.getRawY();
        this.T = false;
        this.U = false;
        goto L60
    }

    public final void setCanHandleSwipe(Function0<Boolean> r1) {
        this.O = r1;
    }

    public final void setOnSwipeDismiss(Function0<Unit> r1) {
        this.P = r1;
    }

    public final void setSwipeDirection(int r1) {
        this.N = r1;
    }

    public ReachSwipeDismissLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.N = -1;
        this.Q = ViewConfiguration.get(r2).getScaledTouchSlop();
    }

    public /* synthetic */ ReachSwipeDismissLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
