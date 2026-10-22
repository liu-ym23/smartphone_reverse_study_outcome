package com.bytedance.ies.xelement.viewpager.childitem;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import com.lynx.tasm.behavior.a0;
import com.lynx.tasm.behavior.ui.a;
import com.lynx.tasm.behavior.ui.b;
import java.util.ArrayList;
import java.util.Iterator;
import mn.h;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidNestedScrollView extends NestedScrollView implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fn.a f6525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final oe.a f6527c;
    public int d;
    public int e;
    public boolean f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f6531k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f6532l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a0 f6533m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6534n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6535o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f6536p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6537q;

    public AndroidNestedScrollView(Context r10) {
        super(r10);
        this.f6526b = false;
        this.f = false;
        this.g = 0;
        this.f6528h = 0;
        this.f6529i = false;
        this.f6530j = false;
        this.f6534n = 0;
        this.f6535o = 0;
        this.f6536p = 300;
        this.f6537q = 0;
        setVerticalScrollBarEnabled(false);
        setOverScrollMode(2);
        setFadingEdgeLength(0);
        setScrollContainer(false);
        this.f6531k = new ArrayList();
        if (this.f6525a != null) goto L5;
        fn.a r5 = new fn.a(this, getContext(), 3);
        this.f6525a = r5;
        r5.setOrientation(1);
        r5.setWillNotDraw(true);
        oe.a r11 = new oe.a(this, getContext(), 1);
        this.f6527c = r11;
        r11.setHorizontalScrollBarEnabled(false);
        r11.setOverScrollMode(2);
        r11.setFadingEdgeLength(0);
        r11.setWillNotDraw(true);
        r11.addView(r5, new FrameLayout.LayoutParams(-1, -1));
        addView(r11, new FrameLayout.LayoutParams(-2, -2));
    L5:
        this.f6533m = new a0(this);
    }

    public final void a(int r5) {
        this.f6537q = r5;
        Iterator r10 = this.f6531k.iterator();
        if (r10.hasNext() == true) goto L6;
        return;
    L6:
        throw h.c(r10);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void addView(View r5) {
        if (this.f6526b == false) goto L6;
        this.f6525a.addView(r5);
        return;
    L6:
        super.addView(r5);
        this.f6526b = true;
    }

    public final void b(MotionEvent r5) {
        if (r5.getAction() != 0) goto L7;
        this.f6529i = true;
        return;
    L7:
        if (r5.getAction() == 1) goto L9;
        return;
    L9:
        if (this.f6530j == false) goto L15;
        a(2);
        Iterator r10 = this.f6531k.iterator();
        if (r10.hasNext() == false) goto L15;
        throw h.c(r10);
    L15:
        this.f6530j = false;
        this.f6529i = false;
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public final void bindDrawChildHook(b r5) {
        this.f6532l = r5;
    }

    public final void finalize() {
        removeCallbacks(this.f6533m);
        super.finalize();
    }

    public int getContentHeight() {
        return this.f6528h;
    }

    public int getContentWidth() {
        return this.g;
    }

    public HorizontalScrollView getHScrollView() {
        return this.f6527c;
    }

    public LinearLayout getLinearLayout() {
        return this.f6525a;
    }

    public int getOrientation() {
        return this.f6525a.getOrientation();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        if (this.f == false) goto L5;
        return false;
    L5:
        return super.onInterceptTouchEvent(r5);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final void onScrollChanged(int r5, int r10, int r11, int r12) {
        super.onScrollChanged(r5, r10, r11, r12);
        if (r10 == this.d) goto L23;
        boolean r13 = this.f6529i;
        ArrayList r14 = this.f6531k;
        if (r13 == true) goto L8;
    L14:
        a(this.f6537q);
        Iterator r15 = r14.iterator();
        if (r15.hasNext() == true) goto L21;
    L17:
        if (this.d == getScrollY()) goto L22;
        this.d = getScrollY();
        return;
    L22:
        return;
    L21:
        throw h.c(r15);
    L8:
        if (this.f6530j == true) goto L14;
        this.f6530j = true;
        a(1);
        Iterator r16 = r14.iterator();
        if (r16.hasNext() == false) goto L17;
        throw h.c(r16);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        if (this.f == true) goto L12;
        b(r5);
        if (r5.getAction() != 0) goto L8;
        a(this.f6537q);
    L8:
        if (r5.getAction() != 1) goto L11;
        this.f6534n = getScrollY();
        this.f6535o = this.f6527c.getScrollX();
        postDelayed(this.f6533m, this.f6536p);
    L11:
        return super.onTouchEvent(r5);
    L12:
        return false;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        if (this.f6526b == false) goto L6;
        this.f6525a.removeAllViews();
        return;
    L6:
        super.removeAllViews();
        this.f6526b = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r5) {
        if (this.f6526b == false) goto L6;
        this.f6525a.removeView(r5);
        return;
    L6:
        super.removeView(r5);
        this.f6526b = true;
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int r5) {
        if (this.f6526b == false) goto L6;
        this.f6525a.removeViewAt(r5);
        return;
    L6:
        super.removeViewAt(r5);
        this.f6526b = true;
    }

    public void setOnScrollListener(ye.a r5) {
        this.f6531k.add(r5);
    }

    public void setOrientation(int r5) {
        fn.a r10 = this.f6525a;
        if (r5 != 0) goto L6;
        r10.setOrientation(0);
        this.f = true;
        return;
    L6:
        if (r5 != 1) goto L9;
        r10.setOrientation(1);
        this.f = false;
        return;
    }

    @Override // android.view.View
    public final void setPadding(int r5, int r10, int r11, int r12) {
        this.f6525a.setPadding(r5, r10, r11, r12);
    }

    public void setScrollBarEnable(boolean r5) {
        setVerticalScrollBarEnabled(r5);
        this.f6527c.setHorizontalScrollBarEnabled(r5);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void addView(View r5, int r10) {
        if (this.f6526b == false) goto L6;
        this.f6525a.addView(r5, r10);
        return;
    L6:
        super.addView(r5, r10);
        this.f6526b = true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void addView(View r5, int r10, ViewGroup.LayoutParams r11) {
        if (this.f6526b == false) goto L6;
        this.f6525a.addView(r5, r10, r11);
        return;
    L6:
        super.addView(r5, r10, r11);
        this.f6526b = true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r5, ViewGroup.LayoutParams r10) {
        if (this.f6526b == false) goto L6;
        this.f6525a.addView(r5, r10);
        return;
    L6:
        super.addView(r5, r10);
        this.f6526b = true;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r5, int r10, int r11) {
        if (this.f6526b == false) goto L6;
        this.f6525a.addView(r5, r10, r11);
        return;
    L6:
        super.addView(r5, r10, r11);
        this.f6526b = true;
    }
}
