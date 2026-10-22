package com.google.android.material.snackbar;

import aa.f;
import aa.j;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.q;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.obric.cae.R;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f4951a = 0;

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final b f4952i;

        public Behavior() {
            this.f4952i = new b(this);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean g(CoordinatorLayout r8, View r10, MotionEvent r11) {
            this.f4952i.getClass();
            int r12 = r11.getActionMasked();
            if (r12 == 0) goto L17;
            if (r12 != 1) goto L7;
        L9:
            Object r13 = ca.a.a().f3426a;
            monitor-enter(r13);
            monitor-exit(r13);     // Catch: Throwable -> L13
        L26:
            return super.g(r8, r10, r11);
        L13:
            th = move-exception;
            throw th;
        L7:
            if (r12 == 3) goto L9;
        L17:
            if (r8.l(r10, (int) r11.getX(), (int) r11.getY()) == false) goto L26;
            Object r14 = ca.a.a().f3426a;
            monitor-enter(r14);
            monitor-exit(r14);     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            throw th;
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public final boolean y(View r8) {
            this.f4952i.getClass();
            return r8 instanceof c;
        }
    }

    public class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r8) {
            int r10 = r8.what;
            if (r10 != 0) goto L5;
            ((BaseTransientBottomBar) r8.obj).getClass();
            throw null;
        L5:
            if (r10 == 1) goto L8;
            return false;
        L8:
            ((BaseTransientBottomBar) r8.obj).getClass();
            throw null;
        }
    }

    public static class b {
        public b(SwipeDismissBehavior<?> r8) {
            r8.getClass();
            r8.f4357f = Math.min(Math.max(0.0f, 0.1f), 1.0f);
            r8.f4358g = Math.min(Math.max(0.0f, 0.6f), 1.0f);
            r8.f4355d = 0;
        }
    }

    public static class c extends FrameLayout {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final a f4953t = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BaseTransientBottomBar<?> f4954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j f4955b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f4956m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final float f4957n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final float f4958o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final int f4959p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f4960q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public ColorStateList f4961r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public PorterDuff.Mode f4962s;

        public class a implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public final boolean onTouch(View r8, MotionEvent r10) {
                return true;
            }
        }

        static {
            f4953t = new a();
        }

        public c(Context r8, AttributeSet r10) {
            super(ea.a.a(r8, r10, 0, 0), r10);
            Context r11 = getContext();
            TypedArray r12 = r11.obtainStyledAttributes(r10, g9.a.f7784y);
            if (r12.hasValue(6) == false) goto L5;
            float r13 = r12.getDimensionPixelSize(6, 0);
            WeakHashMap<View, h0> r14 = w.f8437a;
            w.i.s(this, r13);
        L5:
            this.f4956m = r12.getInt(2, 0);
            if (r12.hasValue(8) == false) goto L8;
        L9:
            this.f4955b = new j(j.b(r11, r10, 0, 0));
        L10:
            this.f4957n = r12.getFloat(3, 1.0f);
            setBackgroundTintList(x9.c.a(r11, r12, 4));
            setBackgroundTintMode(q.b(r12.getInt(5, -1), PorterDuff.Mode.SRC_IN));
            this.f4958o = r12.getFloat(1, 1.0f);
            this.f4959p = r12.getDimensionPixelSize(0, -1);
            this.f4960q = r12.getDimensionPixelSize(7, -1);
            r12.recycle();
            setOnTouchListener(f4953t);
            setFocusable(true);
            if (getBackground() != null) goto L21;
            int r15 = t2.b.K(getBackgroundOverlayColorAlpha(), t2.b.z(this, R.attr.colorSurface), t2.b.z(this, R.attr.colorOnSurface));
            j r16 = this.f4955b;
            if (r16 == null) goto L15;
            int r17 = BaseTransientBottomBar.f4951a;
            f r18 = new f(r16);
            r18.k(ColorStateList.valueOf(r15));
            Drawable r19 = r18;
        L16:
            ColorStateList r20 = this.f4961r;
            if (r20 == null) goto L19;
            b0.a.b.h(r19, r20);
        L19:
            WeakHashMap<View, h0> r21 = w.f8437a;
            w.d.q(this, r19);
            return;
        L15:
            Resources r22 = getResources();
            int r23 = BaseTransientBottomBar.f4951a;
            float r24 = r22.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
            GradientDrawable r25 = new GradientDrawable();
            r25.setShape(0);
            r25.setCornerRadius(r24);
            r25.setColor(r15);
            r19 = r25;
            goto L16
        L21:
            return;
        L8:
            if (r12.hasValue(9) == false) goto L10;
            goto L9
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar<?> r8) {
            this.f4954a = r8;
        }

        public float getActionTextColorAlpha() {
            return this.f4958o;
        }

        public int getAnimationMode() {
            return this.f4956m;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f4957n;
        }

        public int getMaxInlineActionWidth() {
            return this.f4960q;
        }

        public int getMaxWidth() {
            return this.f4959p;
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> r8 = this.f4954a;
            if (r8 != null) goto L6;
            WeakHashMap<View, h0> r10 = w.f8437a;
            w.h.c(this);
            return;
        L6:
            r8.getClass();
            throw null;
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f4954a == null) goto L11;
            Object r8 = ca.a.a().f3426a;
            monitor-enter(r8);
            monitor-exit(r8);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
            super.onLayout(r8, r10, r11, r12, r13);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int r8, int r10) {
            super.onMeasure(r8, r10);
            int r11 = this.f4959p;
            if (r11 > 0) goto L5;
            return;
        L5:
            if (getMeasuredWidth() <= r11) goto L9;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(r11, 1073741824), r10);
            return;
        }

        public void setAnimationMode(int r8) {
            this.f4956m = r8;
        }

        @Override // android.view.View
        public void setBackground(Drawable r8) {
            setBackgroundDrawable(r8);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable r8) {
            if (r8 != null) goto L4;
        L6:
            super.setBackgroundDrawable(r8);
            return;
        L4:
            if (this.f4961r == null) goto L6;
            r8 = r8.mutate();
            b0.a.b.h(r8, this.f4961r);
            b0.a.b.i(r8, this.f4962s);
            goto L6
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList r8) {
            this.f4961r = r8;
            if (getBackground() == null) goto L8;
            Drawable r10 = getBackground().mutate();
            b0.a.b.h(r10, r8);
            b0.a.b.i(r10, this.f4962s);
            if (r10 == getBackground()) goto L9;
            super.setBackgroundDrawable(r10);
            return;
        L9:
            return;
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode r8) {
            this.f4962s = r8;
            if (getBackground() == null) goto L8;
            Drawable r10 = getBackground().mutate();
            b0.a.b.i(r10, r8);
            if (r10 == getBackground()) goto L9;
            super.setBackgroundDrawable(r10);
            return;
        L9:
            return;
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams r8) {
            super.setLayoutParams(r8);
            if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
            ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r8;
            new Rect(r10.leftMargin, r10.topMargin, r10.rightMargin, r10.bottomMargin);
            if (this.f4954a == null) goto L10;
            int r11 = BaseTransientBottomBar.f4951a;
            throw null;
        L10:
            return;
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener r8) {
            if (r8 == null) goto L4;
            a r10 = null;
        L5:
            setOnTouchListener(r10);
            super.setOnClickListener(r8);
            return;
        L4:
            r10 = f4953t;
            goto L5
        }
    }

    static {
        LinearInterpolator r8 = h9.a.f7943a;
        new Handler(Looper.getMainLooper(), new a());
    }
}
