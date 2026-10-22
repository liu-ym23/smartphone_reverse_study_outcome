package com.lynx.tasm.behavior.ui.swiper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import x6a.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class SwiperView extends FrameLayout implements IDrawChildHook.IDrawChildHookBinding, x6a.e {
    public final ViewPager a;
    public final LinearLayout b;
    public final int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public IDrawChildHook h;
    public i i;

    @Override // x6a.e
    public final /* synthetic */ void applyRendererClipBounds(boolean r1, Rect r2) {
        x6a.d.a(this, r1, r2);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererOpacity(float r1) {
        x6a.d.b(this, r1);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererTransform(float[] r1) {
        x6a.d.c(this, r1);
    }

    @Override // x6a.e
    public final /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r1) {
        return x6a.d.d(this, r1);
    }

    @Override // x6a.e
    public final /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // x6a.e
    public final /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // x6a.e
    public final /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // x6a.e
    public final /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // x6a.e
    public final View getView() {
        return this;
    }

    @Override // x6a.e
    public final /* synthetic */ void invalidateForRenderer() {
        x6a.d.i(this);
    }

    @Override // x6a.e
    public final /* synthetic */ boolean invokeUIMethod(String r1, ReadableMap r2, Callback r3) {
        return false;
    }

    @Override // x6a.e
    public final /* synthetic */ void requestLayoutForRenderer() {
        x6a.d.j(this);
    }

    @Override // x6a.e
    public final /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, false);
    }

    @Override // x6a.e
    public final /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, false);
    }

    public final void a() {
        View r0 = new View(getContext());
        r0.setClickable(false);
        int r2 = this.c;
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(r2, r2);
        if (this.g != 1) goto L5;
        int r3 = this.c / 2;
        r1.bottomMargin = r3;
        r1.topMargin = r3;
    L6:
        this.b.addView(r0, r1);
        int r4 = this.b.getChildCount();
        int r5 = this.d;
        if (r4 != r5) goto L9;
        r0.setBackground(b(r5));
        return;
    L9:
        r0.setBackground(b(this.e));
        return;
    L5:
        int r6 = this.c / 2;
        r1.rightMargin = r6;
        r1.leftMargin = r6;
        goto L6
    }

    public final void e() {
        int r0 = this.b.getChildCount();
    L3:
        r0 = r0 - 1;
        if (r0 <= (-1)) goto L10;
        View r1 = this.b.getChildAt(r0);
        if (r0 != this.f) goto L8;
        r1.setBackground(b(this.d));
        goto L3
    L8:
        r1.setBackground(b(this.e));
        goto L3
    }

    @Override // x6a.e
    public final i getRenderer() {
        return this.i;
    }

    public final GradientDrawable b(int r3) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(1);
        r0.setColor(r3);
        return r0;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public final void bindDrawChildHook(IDrawChildHook r1) {
        this.h = r1;
    }

    public final void c(boolean r3) {
        if (r3 == false) goto L4;
        ViewCompat.setLayoutDirection(this.b, 1);
    L5:
        this.a.setIsRTL(r3);
        return;
    L4:
        ViewCompat.setLayoutDirection(this.b, 0);
        goto L5
    }

    public final void d(int r2) {
        this.g = r2;
        LinearLayout r0 = this.b;
        if (r0 == null) goto L5;
        removeView(r0);
        f(r2);
    L5:
        this.a.setOrientation(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        IDrawChildHook r0 = this.h;
        if (r0 == null) goto L5;
        r0.beforeDispatchDraw(r2);
    L5:
        super.dispatchDraw(r2);
        i r1 = this.i;
        if (r1 == null) goto L9;
        r1.a(r2);
        return;
    }

    public final void f(int r8) {
        int r4 = 0;
        if (r8 != 1) goto L5;
        this.b.setGravity(16);
        this.b.setOrientation(1);
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-2, -1);
        r9.rightMargin = (int) com.lynx.tasm.utils.i.b(10.0f, 0.0f);
        r9.gravity = 8388629;
    L6:
        addView(this.b, r9);
        int r10 = this.b.getChildCount();
        this.b.removeAllViews();
    L7:
        if (r4 >= r10) goto L9;
        a();
        r4 = r4 + 1;
        goto L7
    L9:
        e();
        return;
    L5:
        this.b.setGravity(17);
        this.b.setOrientation(0);
        r9 = new FrameLayout.LayoutParams(-1, -2);
        r9.bottomMargin = (int) com.lynx.tasm.utils.i.b(10.0f, 0.0f);
        r9.gravity = 81;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r2) {
        if (this.i == null) goto L6;
        this.i.g(r2);
        return;
    L6:
        super.onDraw(r2);
    }

    @Override // x6a.e
    public final void setRenderer(i r1) {
        this.i = r1;
    }

    public SwiperView(Context r4, AttributeSet r5) {
        super(r4, r5);
        this.d = XSwiperUI.G;
        this.e = XSwiperUI.H;
        this.f = 0;
        this.g = 0;
        this.c = (int) com.lynx.tasm.utils.i.b(7.0f, 0.0f);
        ViewPager r0 = new ViewPager(r4);
        this.a = r0;
        addView(r0, new FrameLayout.LayoutParams(-1, -1));
        this.b = new LinearLayout(r4);
        f(0);
    }

    @Override // x6a.e
    public final i createRenderer(PlatformRendererContext r2, int r3) {
        return new i(r2, r3);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r2, View r3, long r4) {
        i r0 = this.i;
        if (r0 == null) goto L5;
        r0.b(r2, r3);
    L5:
        boolean r5 = super.drawChild(r2, r3, r4);
        i r6 = this.i;
        if (r6 == null) goto L8;
        r6.getClass();
        r2.restore();
    L8:
        return r5;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        i r0 = this.i;
        if (r0 == null) goto L7;
        LynxBaseUI r1 = r0.h;
        if (r1 == null) goto L7;
        r1.measure();
    L7:
        super.onLayout(r2, r3, r4, r5, r6);
    }
}
