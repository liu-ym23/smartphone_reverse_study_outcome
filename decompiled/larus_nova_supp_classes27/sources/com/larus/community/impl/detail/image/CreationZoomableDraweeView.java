package com.larus.community.impl.detail.image;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 D2\u00020\u0001:\u0003BCDB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u000209H\u0016J\u0006\u0010:\u001a\u00020;J\u0006\u0010<\u001a\u00020;J\u000e\u0010=\u001a\u0002052\u0006\u0010>\u001a\u00020\u0013J\u0010\u0010?\u001a\u00020\u00102\u0006\u00108\u001a\u000209H\u0002J\u0018\u0010\f\u001a\u0002052\u0006\u0010@\u001a\u00020\u000b2\u0006\u00108\u001a\u000209H\u0002J\b\u0010A\u001a\u000205H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006E"}, d2 = {"Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "startPoint", "Landroid/graphics/PointF;", "midPoint", "lastPoint", "mode", "oldDist", "", "currentScale", "isDragging", "", "isInFullscreenMode", "()Z", "setInFullscreenMode", "(Z)V", "hasTriggeredZoom", "touchSlop", "isLongPressTriggered", "longPressTimeout", "", "longPressHandler", "Landroid/os/Handler;", "longPressRunnable", "Ljava/lang/Runnable;", "doubleTapTimeout", "lastTapTime", "lastTapX", "lastTapY", "isDoubleTapTriggered", "zoomListener", "Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView$OnZoomListener;", "getZoomListener", "()Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView$OnZoomListener;", "setZoomListener", "(Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView$OnZoomListener;)V", "onLongClickListenerInternal", "Landroid/view/View$OnLongClickListener;", "onDoubleTapListener", "Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView$OnDoubleTapListener;", "getOnDoubleTapListener", "()Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView$OnDoubleTapListener;", "setOnDoubleTapListener", "(Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView$OnDoubleTapListener;)V", "setOnLongClickListener", "", "l", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "getLocationInWindow", "Landroid/graphics/Rect;", "getGlobalVisibleRect", "setFullscreenMode", "fullscreen", "spacing", "point", "onDetachedFromWindow", "OnZoomListener", "OnDoubleTapListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationZoomableDraweeView extends SimpleDraweeView {
    public final PointF a;
    public final PointF b;
    public final PointF c;
    public int d;
    public float e;
    public float f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final int j;
    public boolean k;
    public final long l;
    public final Handler m;
    public final r n;
    public final int o;
    public long p;
    public float q;
    public float r;
    public boolean s;
    public c t;
    public View.OnLongClickListener u;
    public b v;

    public static final class a {
    }

    public interface b {
        void c();
    }

    public interface c {
        void a(float r1);

        void b();

        void c(float r1, float r2);

        void d();

        void onDragEnd();

        void onDragStart();
    }

    static {
    }

    public CreationZoomableDraweeView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CreationZoomableDraweeView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Rect getLocationInWindow() {
        int[] r0 = new int[2];
        getLocationInWindow(r0);
        int r2 = r0[0];
        return new Rect(r2, r0[1], getWidth() + r2, r0[1] + getHeight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Rect getGlobalVisibleRect() {
        Rect r0 = new Rect();
        getGlobalVisibleRect(r0);
        return r0;
    }

    public final void onDetachedFromWindow() {
        super/*com.facebook.drawee.view.DraweeView*/.onDetachedFromWindow();
        this.m.removeCallbacks(this.n);
    }

    public final b getOnDoubleTapListener() {
        return this.v;
    }

    public final c getZoomListener() {
        return this.t;
    }

    public static float j(MotionEvent r4) {
        if (r4.getPointerCount() >= 2) goto L6;
        return 0.0f;
    L6:
        float r1 = r4.getX(0) - r4.getX(1);
        float r0 = r4.getY(0) - r4.getY(1);
        return (float) Math.sqrt((r1 * r1) + (r0 * r0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r13) {
        Intrinsics.checkNotNullParameter(r13, "event");
        int r0 = r13.getActionMasked();
        int r2 = 0;
        if (r0 != 0) goto L5;
        this.a.set(r13.getX(), r13.getY());
        this.c.set(r13.getX(), r13.getY());
        this.i = false;
        this.k = false;
        this.s = false;
        long r4 = System.currentTimeMillis();
        long r6 = r4 - this.p;
        float r1 = Math.abs(r13.getX() - this.q);
        float r8 = Math.abs(r13.getY() - this.r);
        if (r6 >= this.o) goto L110;
        float r7 = this.j;
        if (r1 >= r7) goto L110;
        if (r8 >= r7) goto L110;
        this.m.removeCallbacks(this.n);
        this.s = true;
        b r3 = this.v;
        if (r3 == null) goto L106;
        r13.getX();
        r13.getY();
        r3.c();
        boolean r5 = true;
    L107:
        if (r5 == false) goto L110;
        this.p = 0;
        return true;
    L106:
        r5 = false;
    L110:
        this.p = r4;
        this.q = r13.getX();
        this.r = r13.getY();
        if (this.h == false) goto L119;
        this.d = 2;
        this.g = true;
        c r9 = this.t;
        if (r9 == null) goto L115;
        r13.getX();
        r13.getY();
        r9.onDragStart();
    L115:
        ViewParent r14 = getParent();
        if (r14 == null) goto L118;
        r14.requestDisallowInterceptTouchEvent(true);
    L118:
        this.m.removeCallbacks(this.n);
    L125:
        return true;
    L119:
        this.d = 0;
        ViewParent r15 = getParent();
        if (r15 == null) goto L123;
        r15.requestDisallowInterceptTouchEvent(false);
    L123:
        if (this.u == null) goto L125;
        this.m.postDelayed(this.n, this.l);
        goto L125
    L5:
        if (r0 == 1) goto L70;
        if (r0 != 2) goto L8;
        float r10 = r13.getX() - this.a.x;
        float r11 = r13.getY() - this.a.y;
        if (Math.sqrt((r10 * r10) + (r11 * r11)) <= this.j) goto L44;
        this.m.removeCallbacks(this.n);
    L44:
        if (this.d != 1) goto L57;
        if (r13.getPointerCount() != 2) goto L57;
        float r12 = j(r13);
        if (r12 <= 10.0f) goto L55;
        this.f = r12 / this.e;
        f(this.b, r13);
        if (this.i == true) goto L52;
        this.i = true;
    L52:
        c r16 = this.t;
        if (r16 == null) goto L55;
        float r17 = this.f;
        float r18 = this.b.x;
        r16.a(r17);
    L55:
        return true;
    L57:
        if (this.d == 2) goto L59;
    L69:
        return super/*com.facebook.drawee.view.DraweeView*/.onTouchEvent(r13);
    L59:
        if (this.h == false) goto L69;
        float r20 = r13.getX() - this.c.x;
        float r21 = r13.getY() - this.c.y;
        if (Math.abs(r20) <= this.j) goto L63;
    L64:
        this.c.set(r13.getX(), r13.getY());
        c r110 = this.t;
        if (r110 == null) goto L67;
        r110.c(r20, r21);
    L67:
        return true;
    L63:
        if (Math.abs(r21) <= this.j) goto L67;
    L8:
        if (r0 == 3) goto L70;
        if (r0 == 5) goto L32;
        if (r0 != 6) goto L69;
        if (r13.getPointerCount() != 2) goto L69;
        if (this.d != 1) goto L69;
        if (r13.getActionIndex() != 0) goto L21;
        r2 = 1;
    L21:
        this.d = 2;
        this.g = true;
        this.c.set(r13.getX(r2), r13.getY(r2));
        c r111 = this.t;
        if (r111 == null) goto L25;
        r111.b();
    L25:
        if (this.h == false) goto L29;
        c r112 = this.t;
        if (r112 == null) goto L29;
        float r22 = this.c.x;
        r112.onDragStart();
    L29:
        this.f = 1.0f;
        return true;
    L32:
        if (r13.getPointerCount() != 2) goto L69;
        this.m.removeCallbacks(this.n);
        ViewParent r23 = getParent();
        if (r23 == null) goto L36;
        r23.requestDisallowInterceptTouchEvent(true);
    L36:
        this.e = j(r13);
        f(this.b, r13);
        this.d = 1;
        this.g = false;
        this.i = false;
        c r113 = this.t;
        if (r113 == null) goto L39;
        r113.d();
    L39:
        return true;
    L70:
        this.m.removeCallbacks(this.n);
        if (this.k == false) goto L73;
    L96:
        return true;
    L73:
        if (this.s == true) goto L96;
        int r114 = this.d;
        if (r114 != 1) goto L86;
        c r115 = this.t;
        if (r115 == null) goto L81;
        r115.b();
    L81:
        if (this.h == false) goto L85;
        c r116 = this.t;
        if (r116 == null) goto L85;
        r116.onDragEnd();
    L85:
        this.f = 1.0f;
    L93:
        this.d = 0;
        ViewParent r117 = getParent();
        if (r117 == null) goto L96;
        r117.requestDisallowInterceptTouchEvent(false);
        goto L96
    L86:
        if (r114 != 2) goto L93;
        if (this.g == false) goto L93;
        c r118 = this.t;
        if (r118 == null) goto L92;
        r118.onDragEnd();
    L92:
        this.g = false;
        goto L93
    }

    public final void setFullscreenMode(boolean r1) {
        this.h = r1;
    }

    public final void setInFullscreenMode(boolean r1) {
        this.h = r1;
    }

    public final void setOnDoubleTapListener(b r1) {
        this.v = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOnLongClickListener(View.OnLongClickListener r1) {
        this.u = r1;
        super/*android.widget.ImageView*/.setOnLongClickListener(r1);
    }

    public final void setZoomListener(c r1) {
        this.t = r1;
    }

    public static void f(PointF r5, MotionEvent r6) {
        if (r6.getPointerCount() >= 2) goto L5;
        return;
    L5:
        float r2 = r6.getX(0) + r6.getX(1);
        float r0 = r6.getY(0) + r6.getY(1);
        float r7 = 2;
        r5.set(r2 / r7, r0 / r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.larus.community.impl.detail.image.r] */
    public CreationZoomableDraweeView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new PointF();
        this.b = new PointF();
        this.c = new PointF();
        this.e = 1.0f;
        this.f = 1.0f;
        this.j = ViewConfiguration.get(r2).getScaledTouchSlop();
        this.l = ViewConfiguration.getLongPressTimeout();
        this.m = new Handler(Looper.getMainLooper());
        this.n = new r(this);
        this.o = ViewConfiguration.getDoubleTapTimeout();
        setClickable(true);
        setFocusable(true);
    }

    public /* synthetic */ CreationZoomableDraweeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
