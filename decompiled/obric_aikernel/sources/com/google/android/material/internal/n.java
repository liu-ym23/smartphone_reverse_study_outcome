package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class n implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected a f3452a;

    @SuppressLint({"ViewConstructor", "PrivateApi"})
    static class a extends ViewGroup {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ViewGroup f3453c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        View f3454g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        ArrayList<Drawable> f3455h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        n f3456i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f3457j;

        static {
            Class r10 = Integer.TYPE;     // Catch: NoSuchMethodException -> L4
            ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[]{r10, r10, Rect.class});     // Catch: NoSuchMethodException -> L4
            return;
        }

        a(Context r10, ViewGroup r11, View r12, n r13) {
            super(r10);
            this.f3455h = null;
            this.f3453c = r11;
            this.f3454g = r12;
            setRight(r11.getWidth());
            setBottom(r11.getHeight());
            r11.addView(this);
            this.f3456i = r13;
        }

        private void b() {
            if (this.f3457j == true) goto L6;
            return;
        L6:
            throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
        }

        private void c() {
            if (getChildCount() != 0) goto L10;
            ArrayList<Drawable> r10 = this.f3455h;
            if (r10 != null) goto L7;
        L8:
            this.f3457j = true;
            this.f3453c.removeView(this);
            return;
        L7:
            if (r10.size() == 0) goto L8;
            return;
        }

        private void d(int[] r10) {
            int[] r11 = new int[2];
            int[] r12 = new int[2];
            this.f3453c.getLocationOnScreen(r11);
            this.f3454g.getLocationOnScreen(r12);
            r10[0] = r12[0] - r11[0];
            r10[1] = r12[1] - r11[1];
        }

        public void a(Drawable r10) {
            b();
            if (this.f3455h != null) goto L6;
            this.f3455h = new ArrayList();
        L6:
            if (this.f3455h.contains(r10) == true) goto L9;
            this.f3455h.add(r10);
            invalidate(r10.getBounds());
            r10.setCallback(this);
            return;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas r10) {
            int[] r11 = new int[2];
            int[] r12 = new int[2];
            this.f3453c.getLocationOnScreen(r11);
            this.f3454g.getLocationOnScreen(r12);
            int r13 = 0;
            r10.translate(r12[0] - r11[0], r12[1] - r11[1]);
            r10.clipRect(new Rect(0, 0, this.f3454g.getWidth(), this.f3454g.getHeight()));
            super.dispatchDraw(r10);
            ArrayList<Drawable> r14 = this.f3455h;
            if (r14 != null) goto L5;
            int r15 = 0;
        L6:
            if (r13 >= r15) goto L8;
            this.f3455h.get(r13).draw(r10);
            r13 = r13 + 1;
            goto L6
        L8:
            return;
        L5:
            r15 = r14.size();
            goto L6
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent r10) {
            return false;
        }

        public void e(Drawable r10) {
            ArrayList<Drawable> r11 = this.f3455h;
            if (r11 == null) goto L6;
            r11.remove(r10);
            invalidate(r10.getBounds());
            r10.setCallback(null);
            c();
            return;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] r10, Rect r11) {
            if (this.f3453c == null) goto L11;
            r11.offset(r10[0], r10[1]);
            if (this.f3453c == null) goto L8;
            r10[0] = 0;
            r10[1] = 0;
            int[] r12 = new int[2];
            d(r12);
            r11.offset(r12[0], r12[1]);
            return super.invalidateChildInParent(r10, r11);
        L8:
            invalidate(r11);
            return null;
        L11:
            return null;
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable r10) {
            invalidate(r10.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        }

        @Override // android.view.View
        protected boolean verifyDrawable(@NonNull Drawable r10) {
            if (super.verifyDrawable(r10) == true) goto L10;
            ArrayList<Drawable> r11 = this.f3455h;
            if (r11 != null) goto L7;
        L9:
            return false;
        L7:
            if (r11.contains(r10) == false) goto L9;
        L10:
            return true;
        }
    }

    n(Context r10, ViewGroup r11, View r12) {
        this.f3452a = new a(r10, r11, r12, this);
    }

    static n a(View r10) {
        ViewGroup r11 = ViewUtils.e(r10);
        if (r11 == null) goto L13;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L12;
        View r14 = r11.getChildAt(r13);
        if ((r14 instanceof a) == true) goto L9;
        r13 = r13 + 1;
        goto L5
    L9:
        return ((a) r14).f3456i;
    L12:
        return new m(r11.getContext(), r11, r10);
    L13:
        return null;
    }

    @Override // com.google.android.material.internal.p
    public void add(@NonNull Drawable r10) {
        this.f3452a.a(r10);
    }

    @Override // com.google.android.material.internal.p
    public void remove(@NonNull Drawable r10) {
        this.f3452a.e(r10);
    }
}
