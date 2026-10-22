package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.utils.l0;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0003\u0007\u0019\u001aB'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0014@\u0014X\u0094\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\u00028\u0014X\u0094D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/core/widget/ECFloatingFrameLayout;", "Landroid/widget/FrameLayout;", "", "visibility", "", "setVisibility", "", "a", "Z", "getAutoToEdge", "()Z", "setAutoToEdge", "(Z)V", "autoToEdge", "marginEdge", "I", "getMarginEdge", "()I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECFloatingFrameLayout extends FrameLayout {
    public static final /* synthetic */ int m = 0;
    public boolean a;
    public float b;
    public float c;
    public float d;
    public float e;
    public final c f;
    public int g;
    public int h;
    public final int i;
    public boolean j;
    public final b k;
    public final int l;

    public static final class a {
    }

    public final class b implements Runnable {
        public final Handler a;
        public final /* synthetic */ ECFloatingFrameLayout b;

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

        public b(ECFloatingFrameLayout r10) {
            this.b = r10;
            this.a = new Handler(Looper.getMainLooper());
        }
    }

    public final class c implements Runnable {
        public final Handler a;
        public float b;
        public float c;
        public long d;
        public final /* synthetic */ ECFloatingFrameLayout e;

        public final void a() {
            if (this.e.getRootView() != null) goto L5;
            return;
        L5:
            if (this.e.getRootView().getParent() == null) goto L13;
            float r0 = RangesKt.coerceAtMost(1.0f, (System.currentTimeMillis() - this.d) / 400.0f);
            float r1 = (this.b - this.e.getX()) * r0;
            float r10 = (this.c - this.e.getY()) * r0;
            ECFloatingFrameLayout r11 = this.e;
            int r12 = ECFloatingFrameLayout.m;
            r11.setX(r11.getX() + r1);
            r11.setY(r11.getY() + r10);
            if (r0 >= 1) goto L12;
            this.a.post(this);
            return;
        L12:
            return;
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

        public c(ECFloatingFrameLayout r10) {
            this.e = r10;
            this.a = new Handler(Looper.getMainLooper());
        }
    }

    static {
    }

    public ECFloatingFrameLayout(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public ECFloatingFrameLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    public int getMarginEdge() {
        return 0;
    }

    public final void b() {
        Point r0 = l0.f(getContext());
        if (r0 == null) goto L6;
        this.g = r0.x - getWidth();
        this.h = r0.y;
        return;
    }

    public boolean getAutoToEdge() {
        return this.a;
    }

    public final void a(boolean r10) {
        if (r10 == false) goto L4;
        int r11 = getMarginEdge();
    L5:
        c r0 = this.f;
        Intrinsics.checkNotNull(r0);
        float r1 = getY();
        r0.b = r11;
        r0.c = r1;
        r0.d = System.currentTimeMillis();
        r0.a.post(r0);
        return;
    L4:
        r11 = this.g - getMarginEdge();
        goto L5
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        b();
        a(this.j);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        boolean r0 = false;
        if (r10 != null) goto L5;
        return false;
    L5:
        int r1 = r10.getAction();
        if (r1 != 0) goto L8;
        this.d = getX();
        this.e = getY();
        this.b = r10.getRawX();
        this.c = r10.getRawY();
        System.currentTimeMillis();
        b r11 = this.k;
        r11.a.postDelayed(r11, ViewConfiguration.getLongPressTimeout());
        b();
        c r12 = this.f;
        if (r12 == null) goto L32;
        r12.a.removeCallbacks(r12);
    L32:
        return true;
    L8:
        if (r1 == 1) goto L22;
        if (r1 != 2) goto L32;
        setX((this.d + r10.getRawX()) - this.b);
        float r13 = (this.e + r10.getRawY()) - this.c;
        float r14 = this.i;
        if (r13 >= r14) goto L15;
        r13 = r14;
    L15:
        if (r13 <= (this.h - getHeight())) goto L17;
        r13 = this.h - getHeight();
    L17:
        setY(r13);
        if (Math.abs(r10.getRawX() - this.b) <= this.l) goto L20;
    L21:
        b r15 = this.k;
        r15.a.removeCallbacks(r15);
        goto L32
    L20:
        if (Math.abs(r10.getRawY() - this.c) <= this.l) goto L32;
    L22:
        b r16 = this.k;
        r16.a.removeCallbacks(r16);
        if (getAutoToEdge() == true) goto L25;
    L28:
        System.currentTimeMillis();
        goto L32
    L25:
        if (getX() >= (this.g / 2)) goto L27;
        r0 = true;
    L27:
        this.j = r0;
        a(r0);
        goto L28
    }

    public void setAutoToEdge(boolean r1) {
        this.a = r1;
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

    public ECFloatingFrameLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.a = true;
        this.j = true;
        this.k = new b(this);
        this.l = ViewConfiguration.get(r10).getScaledTouchSlop();
        this.f = new c(this);
        this.i = eh.b.b(r10);
        setClickable(true);
        setLongClickable(true);
        b();
    }

    public /* synthetic */ ECFloatingFrameLayout(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
