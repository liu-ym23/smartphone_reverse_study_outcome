package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class o implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected a f3983a;

    static class a extends ViewGroup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static Method f3984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ViewGroup f3985b;
        View c;
        ArrayList<Drawable> d;
        o e;
        private boolean f;

        static {
            f3984a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[]{Integer.TYPE, Integer.TYPE, Rect.class});     // Catch: NoSuchMethodException -> L4
            return;
        }

        a(Context r3, ViewGroup r4, View r5, o r6) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
            this.d = null;
            this.f3985b = r4;
            this.c = r5;
            setRight(r4.getWidth());
            setBottom(r4.getHeight());
            r4.addView(this);
            this.e = r6;
        }

        private void a() {
            if (this.f == true) goto L6;
            return;
        L6:
            throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
        }

        private void a(int[] r5) {
            int[] r1 = new int[2];
            int[] r0 = new int[2];
            this.f3985b.getLocationOnScreen(r1);
            this.c.getLocationOnScreen(r0);
            r5[0] = r0[0] - r1[0];
            r5[1] = r0[1] - r1[1];
        }

        private void b() {
            if (getChildCount() != 0) goto L10;
            ArrayList<Drawable> r0 = this.d;
            if (r0 != null) goto L7;
        L8:
            this.f = true;
            this.f3985b.removeView(this);
            return;
        L7:
            if (r0.size() == 0) goto L8;
            return;
        }

        public void a(Drawable r2) {
            a();
            if (this.d != null) goto L6;
            this.d = new ArrayList();
        L6:
            if (this.d.contains(r2) == true) goto L9;
            this.d.add(r2);
            invalidate(r2.getBounds());
            r2.setCallback(this);
            return;
        }

        public void b(Drawable r2) {
            ArrayList<Drawable> r0 = this.d;
            if (r0 == null) goto L6;
            r0.remove(r2);
            invalidate(r2.getBounds());
            r2.setCallback(null);
            b();
            return;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas r6) {
            int[] r1 = new int[2];
            int[] r0 = new int[2];
            this.f3985b.getLocationOnScreen(r1);
            this.c.getLocationOnScreen(r0);
            int r2 = 0;
            r6.translate(r0[0] - r1[0], r0[1] - r1[1]);
            r6.clipRect(new Rect(0, 0, this.c.getWidth(), this.c.getHeight()));
            super.dispatchDraw(r6);
            ArrayList<Drawable> r3 = this.d;
            if (r3 != null) goto L5;
            int r4 = 0;
        L6:
            if (r2 >= r4) goto L8;
            ((Drawable) ZeusTransformUtils.preCheckCast(this.d.get(r2), Drawable.class, "com.obric.memorydata.plugin")).draw(r6);
            r2 = r2 + 1;
            goto L6
        L8:
            return;
        L5:
            r4 = r3.size();
            goto L6
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent r1) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] r5, Rect r6) {
            if (this.f3985b == null) goto L11;
            r6.offset(r5[0], r5[1]);
            if (this.f3985b == null) goto L8;
            r5[0] = 0;
            r5[1] = 0;
            int[] r1 = new int[2];
            a(r1);
            r6.offset(r1[0], r1[1]);
            return super.invalidateChildInParent(r5, r6);
        L8:
            invalidate(r6);
            return null;
        L11:
            return null;
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable r1) {
            invalidate(r1.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        }

        @Override // android.view.View
        public boolean verifyDrawable(Drawable r2) {
            if (super.verifyDrawable(r2) == true) goto L10;
            ArrayList<Drawable> r1 = this.d;
            if (r1 != null) goto L7;
        L9:
            return false;
        L7:
            if (r1.contains(r2) == false) goto L9;
        L10:
            return true;
        }
    }

    o(Context r3, ViewGroup r4, View r5) {
        this.f3983a = new a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5, this);
    }

    static o a(View r6) {
        ViewGroup r0 = r.f(r6);
        if (r0 == null) goto L14;
        int r1 = r0.getChildCount();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L13;
        View r4 = r0.getChildAt(r2);
        if (ZeusTransformUtils.instanceOf(r4, a.class) == true) goto L10;
        r2 = r2 + 1;
        goto L6
    L10:
        return ((a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin")).e;
    L13:
        return new m((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r0, r6);
    L14:
        return null;
    }

    @Override // com.google.android.material.internal.q
    public void a(Drawable r1) {
        this.f3983a.a(r1);
    }

    @Override // com.google.android.material.internal.q
    public void b(Drawable r1) {
        this.f3983a.b(r1);
    }
}
