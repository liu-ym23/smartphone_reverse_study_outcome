package com.lynx.xelement.scroll.coordinator.childitem;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import q8a.c;
import q8a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ScrollCoordinatorNestedScrollView extends NestedScrollView implements IDrawChildHook.IDrawChildHookBinding {
    public c a;
    public boolean b;
    public d c;
    public int d;
    public int e;
    public boolean f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public ArrayList<a> k;
    public IDrawChildHook l;
    public b m;
    public int n;
    public int o;
    public final int p;
    public int q;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void onScrollChanged();
    }

    public static class b implements Runnable {
        public final WeakReference<ScrollCoordinatorNestedScrollView> a;

        /* JADX WARN: Type inference failed for: r0v4, types: [android.widget.FrameLayout, com.lynx.xelement.scroll.coordinator.childitem.ScrollCoordinatorNestedScrollView] */
        public final void a() {
            if (this.a.get() == null) goto L18;
            ScrollCoordinatorNestedScrollView r0 = this.a.get();
            int r1 = r0.getScrollY();
            int r2 = r0.c.getScrollX();
            boolean r3 = r0.f;
            if (r3 == true) goto L7;
        L8:
            if (r3 == false) goto L10;
        L15:
            r0.n = r1;
            r0.o = r2;
            r0.postDelayed(this, r0.p);
            return;
        L10:
            if ((r0.n - r1) != 0) goto L15;
        L11:
            r0.f(0);
            Iterator<a> r4 = r0.k.iterator();
        L13:
            if (r4.hasNext() == false) goto L19;
            r4.next().b();
            goto L13
        L19:
            return;
        L7:
            if ((r0.o - r2) == 0) goto L11;
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

        public b(ScrollCoordinatorNestedScrollView r2) {
            this.a = new WeakReference(r2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finalize() throws Throwable {
        removeCallbacks(this.m);
        super.finalize();
    }

    public int getOrientation() {
        return this.a.getOrientation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void removeAllViews() {
        if (this.b == false) goto L5;
        this.a.removeAllViews();
        return;
    L5:
        super/*android.widget.FrameLayout*/.removeAllViews();
        this.b = true;
    }

    public int getContentHeight() {
        return this.h;
    }

    public int getContentWidth() {
        return this.g;
    }

    public HorizontalScrollView getHScrollView() {
        return this.c;
    }

    public LinearLayout getLinearLayout() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScrollCoordinatorNestedScrollView(Context r5) {
        super(r5);
        this.b = false;
        this.f = false;
        this.g = 0;
        this.h = 0;
        this.i = false;
        this.j = false;
        this.n = 0;
        this.o = 0;
        this.p = 300;
        this.q = 0;
        setVerticalScrollBarEnabled(false);
        setOverScrollMode(2);
        setFadingEdgeLength(0);
        setScrollContainer(false);
        this.k = new ArrayList();
        if (this.a != null) goto L5;
        c r1 = new c(this, getContext());
        this.a = r1;
        r1.setOrientation(1);
        this.a.setWillNotDraw(true);
        d r2 = new d(this, getContext());
        this.c = r2;
        r2.setHorizontalScrollBarEnabled(false);
        this.c.setOverScrollMode(2);
        this.c.setFadingEdgeLength(0);
        this.c.setWillNotDraw(true);
        this.c.addView(this.a, new FrameLayout.LayoutParams(-1, -1));
        addView(this.c, new FrameLayout.LayoutParams(-2, -2));
    L5:
        this.m = new b(this);
    }

    public final void addView(View r2) {
        if (this.b == false) goto L5;
        this.a.addView(r2);
        return;
    L5:
        super.addView(r2);
        this.b = true;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public final void bindDrawChildHook(IDrawChildHook r1) {
        this.l = r1;
    }

    public final void e(MotionEvent r3) {
        if (r3.getAction() != 0) goto L6;
        this.i = true;
        return;
    L6:
        if (r3.getAction() == 1) goto L8;
        return;
    L8:
        if (this.j == false) goto L13;
        f(2);
        Iterator<a> r4 = this.k.iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        r4.next().d();
    L13:
        this.j = false;
        this.i = false;
    }

    public final void f(int r2) {
        this.q = r2;
        Iterator<a> r3 = this.k.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().c();
        goto L4
    }

    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.f == false) goto L5;
        return false;
    L5:
        return super.onInterceptTouchEvent(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r4) {
        if (this.f == true) goto L12;
        e(r4);
        if (r4.getAction() != 0) goto L8;
        f(this.q);
    L8:
        if (r4.getAction() != 1) goto L11;
        this.n = getScrollY();
        this.o = this.c.getScrollX();
        postDelayed(this.m, this.p);
    L11:
        return super.onTouchEvent(r4);
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void removeView(View r2) {
        if (this.b == false) goto L5;
        this.a.removeView(r2);
        return;
    L5:
        super/*android.widget.FrameLayout*/.removeView(r2);
        this.b = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void removeViewAt(int r2) {
        if (this.b == false) goto L5;
        this.a.removeViewAt(r2);
        return;
    L5:
        super/*android.widget.FrameLayout*/.removeViewAt(r2);
        this.b = true;
    }

    public void setOnScrollListener(a r2) {
        this.k.add(r2);
    }

    public void setOrientation(int r3) {
        if (r3 != 0) goto L5;
        this.a.setOrientation(0);
        this.f = true;
        return;
    L5:
        if (r3 != 1) goto L9;
        this.a.setOrientation(1);
        this.f = false;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setScrollBarEnable(boolean r2) {
        setVerticalScrollBarEnabled(r2);
        this.c.setHorizontalScrollBarEnabled(r2);
    }

    public final void addView(View r2, int r3) {
        if (this.b == false) goto L5;
        this.a.addView(r2, r3);
        return;
    L5:
        super.addView(r2, r3);
        this.b = true;
    }

    public final void addView(View r2, ViewGroup.LayoutParams r3) {
        if (this.b == false) goto L5;
        this.a.addView(r2, r3);
        return;
    L5:
        super.addView(r2, r3);
        this.b = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void addView(View r2, int r3, int r4) {
        if (this.b == false) goto L5;
        this.a.addView(r2, r3, r4);
        return;
    L5:
        super/*android.widget.FrameLayout*/.addView(r2, r3, r4);
        this.b = true;
    }

    public final void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        if (this.b == false) goto L5;
        this.a.addView(r2, r3, r4);
        return;
    L5:
        super.addView(r2, r3, r4);
        this.b = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
        if (r2 != this.d) goto L6;
        return;
    L6:
        if (this.i == true) goto L8;
    L13:
        f(this.q);
        Iterator<a> r5 = this.k.iterator();
    L15:
        if (r5.hasNext() == false) goto L18;
        r5.next().onScrollChanged();
    L18:
        if (this.d == getScrollY()) goto L23;
        this.d = getScrollY();
        return;
    L23:
        return;
    L8:
        if (this.j == true) goto L13;
        this.j = true;
        f(1);
        Iterator<a> r6 = this.k.iterator();
    L11:
        if (r6.hasNext() == false) goto L18;
        r6.next().a();
        goto L11
    }

    public final void setPadding(int r2, int r3, int r4, int r5) {
        this.a.setPadding(r2, r3, r4, r5);
    }
}
