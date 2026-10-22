package com.ss.android.lark.chat.message.menu.v2;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 @2\u00020\u0001:\u0001@B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0016J\u0010\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u000200H\u0016J\u0018\u00101\u001a\u00020\r2\u0006\u00102\u001a\u0002032\u0006\u0010/\u001a\u000200H\u0002J \u00104\u001a\u00020\r2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\u001dH\u0002J\u0010\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u000200H\u0016J\u0010\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020\u001dH\u0002J\u0010\u0010=\u001a\u00020,2\b\u0010)\u001a\u0004\u0018\u00010*J\b\u0010>\u001a\u00020,H\u0014J\b\u0010?\u001a\u00020,H\u0014R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b$\u0010\u0019R\u000e\u0010&\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/DragPanelLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", BuildConfig.FLAVOR, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dragEnable", BuildConfig.FLAVOR, "getDragEnable", "()Z", "setDragEnable", "(Z)V", "interceptChildMove", "getInterceptChildMove", "setInterceptChildMove", "initParams", "Lcom/ss/android/lark/chat/message/menu/v2/DragPanelInitParams;", "rootHeight", "getRootHeight", "()I", "rootHeight$delegate", "Lkotlin/Lazy;", "halfExpandThreshold", BuildConfig.FLAVOR, "getHalfExpandThreshold", "()F", "halfExpandThreshold$delegate", "velocityTracker", "Landroid/view/VelocityTracker;", "maximumVelocity", "getMaximumVelocity", "maximumVelocity$delegate", "touchSlop", "startY", "preY", "listener", "Lcom/ss/android/lark/chat/message/menu/v2/PanelDragLayoutChangeListener;", "setInitParams", BuildConfig.FLAVOR, "params", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "isChildNeedScroll", "viewGroup", "Landroid/view/ViewGroup;", "isLocationInView", "view", "Landroid/view/View;", "x", "y", "onTouchEvent", "event", "handleActionUp", "velocityY", "setListener", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DragPanelLayout extends FrameLayout {
    public static final /* synthetic */ int k = 0;
    public boolean a;
    public boolean b;
    public final Lazy c;
    public final Lazy d;
    public VelocityTracker e;
    public final Lazy f;
    public final int g;
    public float h;
    public float i;
    public l0 j;

    public static final class a {
    }

    static {
    }

    public final void setInitParams(b r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    private final float getHalfExpandThreshold() {
        return ((Number) this.d.getValue()).floatValue();
    }

    private final int getMaximumVelocity() {
        return ((Number) this.f.getValue()).intValue();
    }

    private final int getRootHeight() {
        return ((Number) this.c.getValue()).intValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        VelocityTracker r0 = this.e;
        if (r0 == null) goto L7;
        if (r0 == null) goto L6;
        r0.recycle();
    L6:
        this.e = null;
    L7:
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.e = VelocityTracker.obtain();
    }

    public final boolean getDragEnable() {
        return this.a;
    }

    public final boolean getInterceptChildMove() {
        return this.b;
    }

    public DragPanelLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = true;
        this.b = true;
        this.c = LazyKt.lazy(new DragPanelLayout$rootHeight$2(this));
        this.d = LazyKt.lazy(new DragPanelLayout$halfExpandThreshold$2(this));
        this.f = LazyKt.lazy(new DragPanelLayout$maximumVelocity$2(this));
        this.g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public static final /* synthetic */ int a(DragPanelLayout r0) {
        return r0.getRootHeight();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        Log.d("DragPanelLayout", "onInterceptTouchEvent: event = " + r4.getActionMasked());
        int r0 = r4.getAction();
        if (r0 != 0) goto L5;
        l0 r1 = this.j;
        if (r1 == null) goto L19;
        r1.d();
    L19:
        float r2 = r4.getRawY();
        this.h = r2;
        this.i = r2;
    L21:
        return super.onInterceptTouchEvent(r4);
    L5:
        if (r0 != 2) goto L21;
        if (Math.abs(r4.getRawY() - this.h) <= this.g) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L21;
        if (b(this, r4) == true) goto L21;
        this.i = r4.getRawY();
        return true;
    L10:
        r3 = false;
        goto L11
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (this.a == true) goto L7;
        return super.onTouchEvent(r10);
    L7:
        if (this.e != null) goto L9;
        this.e = VelocityTracker.obtain();
    L9:
        VelocityTracker r0 = this.e;
        if (r0 == null) goto L12;
        r0.addMovement(r10);
    L12:
        VelocityTracker r1 = this.e;
        if (r1 == null) goto L15;
        r1.computeCurrentVelocity(1000, getMaximumVelocity());
    L15:
        VelocityTracker r2 = this.e;
        if (r2 == null) goto L18;
        float r3 = r2.getYVelocity();
    L19:
        int r4 = r10.getAction();
        boolean r5 = false;
        if (r4 != 1) goto L22;
        float r6 = this.i - this.h;
        if (getHeight() >= getHalfExpandThreshold()) goto L36;
        float r7 = 0.0f;
    L38:
        if (r3 <= 600.0f) goto L40;
        boolean r8 = true;
    L41:
        Log.d("DragPanelLayout", "onTouchEvent, action = ACTION_UP, isOverTouchSpeed = " + r8 + ", totalOffset = " + r6);
        if (r8 == false) goto L46;
        if (r6 < 0.0f) goto L46;
    L47:
        l0 r9 = this.j;
        if (r9 == null) goto L60;
        r9.e();
    L60:
        Log.i("DragPanelLayout", "onTouchEvent, event = " + r10.getAction());
        return true;
    L46:
        if (r6 > r7) goto L47;
        if (r8 == false) goto L52;
    L57:
        this.b = false;
        l0 r11 = this.j;
        if (r11 == null) goto L60;
        r11.b();
        goto L60
    L52:
        if (r6 < (-r7)) goto L57;
        l0 r12 = this.j;
        if (r12 == null) goto L60;
        r12.c();
        goto L60
    L40:
        r8 = false;
        goto L41
    L36:
        r7 = 150.0f;
        goto L38
    L22:
        if (r4 != 2) goto L60;
        if (this.i != 0.0f) goto L27;
        r5 = true;
    L27:
        if (r5 == false) goto L29;
        this.i = r10.getRawY();
    L29:
        Log.d("DragPanelLayout", "onTouchEvent, event = ACTION_MOVE, preY = " + this.i + ", rawY = " + r10.getRawY() + " offset = " + (r10.getRawY() - this.i));
        l0 r13 = this.j;
        if (r13 == null) goto L32;
        r13.a(r10.getRawY() - this.i);
    L32:
        this.i = r10.getRawY();
        goto L60
    L18:
        r3 = 0.0f;
        goto L19
    }

    public final void setDragEnable(boolean r1) {
        this.a = r1;
    }

    public final void setInterceptChildMove(boolean r1) {
        this.b = r1;
    }

    public final void setListener(l0 r1) {
        this.j = r1;
    }

    public DragPanelLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = true;
        this.b = true;
        this.c = LazyKt.lazy(new DragPanelLayout$rootHeight$2(this));
        this.d = LazyKt.lazy(new DragPanelLayout$halfExpandThreshold$2(this));
        this.f = LazyKt.lazy(new DragPanelLayout$maximumVelocity$2(this));
        this.g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public final boolean b(ViewGroup r17, MotionEvent r18) {
        if (this.b == false) goto L6;
        return false;
    L6:
        if ((r18.getRawY() - this.h) >= 0.0f) goto L9;
        return true;
    L9:
        if (r17.canScrollVertically(-1) == false) goto L11;
        return true;
    L11:
        int r4 = r17.getChildCount();
        int r6 = 0;
    L12:
        if (r6 >= r4) goto L26;
        View r7 = r17.getChildAt(r6);
        if (r7 == null) goto L25;
        float r8 = r18.getRawX();
        float r9 = r18.getRawY();
        int[] r10 = new int[2];
        r7.getLocationOnScreen(r10);
        int r12 = r10[0];
        if (new RectF(r12, r10[1], r12 + r7.getWidth(), r10[1] + r7.getHeight()).contains(r8, r9) == false) goto L25;
        if ((r7 instanceof ViewGroup) == false) goto L22;
        boolean r11 = b((ViewGroup) r7, r18);
    L23:
        if (r11 == false) goto L25;
        return true;
    L22:
        r11 = r7.canScrollVertically(-1);
    L25:
        r6 = r6 + 1;
        goto L12
    L26:
        return false;
    }

    public DragPanelLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = true;
        this.b = true;
        this.c = LazyKt.lazy(new DragPanelLayout$rootHeight$2(this));
        this.d = LazyKt.lazy(new DragPanelLayout$halfExpandThreshold$2(this));
        this.f = LazyKt.lazy(new DragPanelLayout$maximumVelocity$2(this));
        this.g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
