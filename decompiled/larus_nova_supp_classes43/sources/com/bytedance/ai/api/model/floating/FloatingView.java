package com.bytedance.ai.api.model.floating;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.bytedance.ai.utils.l;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 U2\u00020\u0001:\u0003STUB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010(\u001a\u00020)H\u0002J\u0012\u0010*\u001a\u00020\u00172\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020)H\u0002J\b\u0010.\u001a\u00020)H\u0014J\b\u0010/\u001a\u00020\u0017H\u0002J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u0007H\u0016J\u0010\u00102\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u00103\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0002J\u001e\u00104\u001a\u00020)2\u0016\b\u0002\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u000106J\u0006\u00107\u001a\u00020)J\u001c\u00108\u001a\u00020)2\b\b\u0002\u00109\u001a\u00020\u00172\b\b\u0002\u0010:\u001a\u00020\u0017H\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0014J\u0018\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000bH\u0002J\u0012\u0010C\u001a\u00020)2\b\u0010D\u001a\u0004\u0018\u00010EH\u0014J\u0012\u0010F\u001a\u00020)2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u000e\u0010I\u001a\u00020)2\u0006\u0010<\u001a\u00020\u0007J\u0018\u0010J\u001a\u00020)2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0007H\u0014J0\u0010M\u001a\u00020)2\u0006\u0010N\u001a\u00020\u00172\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00060\u0019R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/bytedance/ai/api/model/floating/FloatingView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOriginalRawX", "", "mOriginalRawY", "mOriginalX", "mOriginalY", "mLastTouchDownTime", "", "mMoveAnimator", "Lcom/bytedance/ai/api/model/floating/FloatingView$MoveAnimator;", "mScreenWidth", "mScreenHeight", "mStatusBarHeight", "isNearestLeft", "", "longClickRunnable", "Lcom/bytedance/ai/api/model/floating/FloatingView$LongClickRunnable;", "scaledTouchSlop", "autoToEdge", "getAutoToEdge", "()Z", "setAutoToEdge", "(Z)V", "hasFirstDraw", "firstPos", "", "getFirstPos", "()D", "setFirstPos", "(D)V", "nowWidth", "init", "", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "dealClickEvent", "dealLongClickEvent", "isClickEvent", "setVisibility", "visibility", "updateViewPosition", "changeOriginalTouchParams", "updateSize", "screenHeightRange", "Landroid/util/Pair;", "resetLocation", "moveToEdge", "isLeft", "isWidthChange", "onSizeChanged", "w", "h", "oldw", "oldh", "move", "deltaX", "deltaY", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "addWebView", "view", "Landroid/view/View;", "setRealWidth", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "left", "top", "right", "bottom", "LongClickRunnable", "MoveAnimator", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FloatingView extends FrameLayout {
    public static final /* synthetic */ int p = 0;
    public float a;
    public float b;
    public float c;
    public float d;
    public c e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public final b j;
    public final int k;
    public boolean l;
    public boolean m;
    public double n;
    public int o;

    public static final class a {
    }

    public final class b implements Runnable {
        public final Handler a;
        public final /* synthetic */ FloatingView b;

        @Override // java.lang.Runnable
        public final void run() {
            this.b.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(FloatingView r10) {
            this.b = r10;
            this.a = new Handler(Looper.getMainLooper());
        }
    }

    public final class c implements Runnable {
        public final Handler a;
        public float b;
        public float c;
        public long d;
        public boolean e;
        public final /* synthetic */ FloatingView f;

        public final void a() {
            if (this.f.getRootView() != null) goto L5;
            return;
        L5:
            if (this.f.getRootView().getParent() != null) goto L8;
            return;
        L8:
            if (this.e == false) goto L10;
            float r0 = 1.0f;
        L11:
            float r10 = (this.b - this.f.getX()) * r0;
            float r11 = (this.c - this.f.getY()) * r0;
            FloatingView r12 = this.f;
            int r13 = FloatingView.p;
            r12.setX(r12.getX() + r10);
            r12.setY(r12.getY() + r11);
            if (r0 >= 1.0f) goto L16;
            this.a.post(this);
            return;
        L16:
            return;
        L10:
            r0 = Math.min(1.0f, (System.currentTimeMillis() - this.d) / 400.0f);
            goto L11
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(FloatingView r10) {
            this.f = r10;
            this.a = new Handler(Looper.getMainLooper());
        }
    }

    static {
    }

    public FloatingView(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public FloatingView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 4, 0);
    }

    public static /* synthetic */ void a(FloatingView r0) {
        setRealWidth$lambda$0(r0);
    }

    public final boolean b() {
        if (getX() >= (this.f / 2)) goto L5;
        boolean r0 = true;
    L6:
        this.i = r0;
        return r0;
    L5:
        r0 = false;
        goto L6
    }

    public final void d() {
        float r0 = getY() + getHeight();
        int r1 = this.g;
        if (r0 > r1) goto L5;
        return;
    L5:
        if (r1 <= getHeight()) goto L9;
        setY(this.g - getHeight());
        return;
    }

    public final boolean getAutoToEdge() {
        return this.l;
    }

    public final double getFirstPos() {
        return this.n;
    }

    private static final void setRealWidth$lambda$0(FloatingView r0) {
        r0.requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r1 = r10.getAction();
        if (r1 != 0) goto L8;
        this.c = getX();
        this.d = getY();
        this.a = r10.getRawX();
        this.b = r10.getRawY();
        System.currentTimeMillis();
        b r0 = this.j;
        r0.a.postDelayed(r0, ViewConfiguration.getLongPressTimeout());
        e(null);
        c r11 = this.e;
        if (r11 == null) goto L31;
        r11.a.removeCallbacks(r11);
    L31:
        return super.dispatchTouchEvent(r10);
    L8:
        if (r1 != 1) goto L10;
        b r12 = this.j;
        r12.a.removeCallbacks(r12);
        if (this.l == false) goto L26;
        c(this, false, false, 3);
    L26:
        System.currentTimeMillis();
        goto L31
    L10:
        if (r1 != 2) goto L31;
        setX((this.c + r10.getRawX()) - this.a);
        float r13 = (this.d + r10.getRawY()) - this.b;
        float r14 = this.h;
        if (r13 >= r14) goto L16;
        r13 = r14;
    L16:
        if (r13 <= (this.g - getHeight())) goto L18;
        r13 = this.g - getHeight();
    L18:
        setY(r13);
        if (Math.abs(r10.getRawX() - this.a) <= this.k) goto L21;
    L22:
        b r15 = this.j;
        r15.a.removeCallbacks(r15);
        goto L31
    L21:
        if (Math.abs(r10.getRawY() - this.b) <= this.k) goto L31;
        goto L22
    }

    public final void e(Pair<Integer, Integer> r10) {
        this.f = l.c(null) - getWidth();
        if (r10 != null) goto L6;
        return;
    L6:
        if (((Number) r10.first).intValue() <= 0) goto L9;
        this.h = ((Number) r10.first).intValue();
    L9:
        if (((Number) r10.second).intValue() <= 0) goto L12;
        this.g = ((Number) r10.second).intValue();
        return;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        e(null);
        c(this, this.i, false, 2);
    }

    public final void setAutoToEdge(boolean r1) {
        this.l = r1;
    }

    public final void setFirstPos(double r1) {
        this.n = r1;
    }

    public final void setRealWidth(int r1) {
        this.o = r1;
        post(new i2.b(this));
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
        super.setVisibility(0);
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        getChildAt(r1).setVisibility(0);
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r10) {
        super.onMeasure(r1, r10);
        setMeasuredDimension(this.o, getMeasuredHeight());
    }

    public FloatingView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.g = l.b(null);
        this.h = UIUtils.getStatusBarHeight(r10);
        this.i = true;
        this.j = new b(this);
        this.k = ViewConfiguration.get(r10).getScaledTouchSlop();
        this.l = true;
        this.n = 0.5d;
        this.e = new c(this);
        setClickable(true);
        setLongClickable(true);
        e(null);
    }

    public /* synthetic */ FloatingView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }

    public static void c(FloatingView r1, boolean r10, boolean r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        r10 = r1.b();
    L5:
        int r0 = 0;
        if ((r12 & 2) == 0) goto L8;
        r11 = false;
    L8:
        if (r10 == true) goto L11;
        r0 = 0 + r1.f;
    L11:
        float r13 = r0;
        c r14 = r1.e;
        if (r14 == null) goto L15;
        float r15 = r1.getY();
        r14.b = r13;
        r14.c = r15;
        r14.d = System.currentTimeMillis();
        r14.e = r11;
        r14.a.post(r14);
        return;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        e(null);
        if (this.m == true) goto L6;
        this.m = true;
        int r14 = this.g;
        int r15 = this.h;
        setY((((r14 - r15) - r11) * (1 - ((float) this.n))) + r15);
    L6:
        if (b() == false) goto L8;
        setX(0.0f);
        return;
    L8:
        c r16 = this.e;
        if (r16 == null) goto L11;
        r16.a.removeCallbacks(r16);
    L11:
        c(this, false, true, 1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r10, int r11, int r12, int r13) {
        super.onLayout(r1, r10, r11, r12, r13);
        if (b() == false) goto L5;
        setX(0.0f);
        return;
    L5:
        setX((l.c(null) - this.o) - 0.0f);
        if (getX() >= 0.0f) goto L10;
        setX(0.0f);
        return;
    }
}
