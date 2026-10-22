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
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class ViewOverlayApi14 implements ViewOverlayImpl {
    protected OverlayViewGroup overlayViewGroup;

    @SuppressLint({"ViewConstructor", "PrivateApi"})
    public static class OverlayViewGroup extends ViewGroup {
        static Method invalidateChildInParentFastMethod;
        private boolean disposed;
        ArrayList<Drawable> drawables;
        ViewGroup hostView;
        View requestingView;
        ViewOverlayApi14 viewOverlay;

        static {
            Class r5 = Integer.TYPE;     // Catch: NoSuchMethodException -> L4
            invalidateChildInParentFastMethod = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[]{r5, r5, Rect.class});     // Catch: NoSuchMethodException -> L4
            return;
        }

        public OverlayViewGroup(Context r5, ViewGroup r10, View r11, ViewOverlayApi14 r12) {
            super(r5);
            this.drawables = null;
            this.hostView = r10;
            this.requestingView = r11;
            setRight(r10.getWidth());
            setBottom(r10.getHeight());
            r10.addView(this);
            this.viewOverlay = r12;
        }

        private void assertNotDisposed() {
            if (this.disposed == true) goto L6;
            return;
        L6:
            throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
        }

        private void disposeIfEmpty() {
            if (getChildCount() != 0) goto L10;
            ArrayList<Drawable> r5 = this.drawables;
            if (r5 != null) goto L7;
        L8:
            this.disposed = true;
            this.hostView.removeView(this);
            return;
        L7:
            if (r5.size() == 0) goto L8;
            return;
        }

        private void getOffset(int[] r5) {
            int[] r10 = new int[2];
            int[] r11 = new int[2];
            this.hostView.getLocationOnScreen(r10);
            this.requestingView.getLocationOnScreen(r11);
            r5[0] = r11[0] - r10[0];
            r5[1] = r11[1] - r10[1];
        }

        public void add(Drawable r5) {
            assertNotDisposed();
            if (this.drawables != null) goto L6;
            this.drawables = new ArrayList();
        L6:
            if (this.drawables.contains(r5) == true) goto L9;
            this.drawables.add(r5);
            invalidate(r5.getBounds());
            r5.setCallback(this);
            return;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas r10) {
            int[] r5 = new int[2];
            int[] r11 = new int[2];
            this.hostView.getLocationOnScreen(r5);
            this.requestingView.getLocationOnScreen(r11);
            int r12 = 0;
            r10.translate(r11[0] - r5[0], r11[1] - r5[1]);
            r10.clipRect(new Rect(0, 0, this.requestingView.getWidth(), this.requestingView.getHeight()));
            super.dispatchDraw(r10);
            ArrayList<Drawable> r13 = this.drawables;
            if (r13 != null) goto L5;
            int r14 = 0;
        L6:
            if (r12 >= r14) goto L8;
            this.drawables.get(r12).draw(r10);
            r12 = r12 + 1;
            goto L6
        L8:
            return;
        L5:
            r14 = r13.size();
            goto L6
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent r5) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] r5, Rect r10) {
            if (this.hostView == null) goto L11;
            r10.offset(r5[0], r5[1]);
            if (this.hostView == null) goto L8;
            r5[0] = 0;
            r5[1] = 0;
            int[] r11 = new int[2];
            getOffset(r11);
            r10.offset(r11[0], r11[1]);
            return super.invalidateChildInParent(r5, r10);
        L8:
            invalidate(r10);
            return null;
        L11:
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ViewParent invalidateChildInParentFast(int r5, int r10, Rect r11) {
            if (this.hostView != null) goto L5;
            return null;
        L5:
            if (invalidateChildInParentFastMethod != null) goto L17;
            return null;
        L17:
            getOffset(new int[2]);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
            invalidateChildInParentFastMethod.invoke(this.hostView, new Object[]{Integer.valueOf(r5), Integer.valueOf(r10), r11});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
        L22:
            return null;
        L11:
            e = move-exception;
            e.printStackTrace();
            return null;
        L9:
            e = move-exception;
            e.printStackTrace();
            return null;
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable r5) {
            invalidate(r5.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        }

        public void remove(Drawable r5) {
            ArrayList<Drawable> r10 = this.drawables;
            if (r10 == null) goto L6;
            r10.remove(r5);
            invalidate(r5.getBounds());
            r5.setCallback(null);
            disposeIfEmpty();
            return;
        }

        @Override // android.view.View
        public boolean verifyDrawable(@NonNull Drawable r5) {
            if (super.verifyDrawable(r5) == true) goto L10;
            ArrayList<Drawable> r10 = this.drawables;
            if (r10 != null) goto L7;
        L9:
            return false;
        L7:
            if (r10.contains(r5) == false) goto L9;
        L10:
            return true;
        }

        public void remove(View r5) {
            super.removeView(r5);
            disposeIfEmpty();
        }

        public void add(View r10) {
            assertNotDisposed();
            if ((r10.getParent() instanceof ViewGroup) == false) goto L14;
            ViewGroup r5 = (ViewGroup) r10.getParent();
            if (r5 != this.hostView) goto L7;
        L11:
            r5.removeView(r10);
            if (r10.getParent() == null) goto L14;
            r5.removeView(r10);
            goto L14
        L7:
            if (r5.getParent() == null) goto L11;
            if (ViewCompat.isAttachedToWindow(r5) == false) goto L11;
            int[] r11 = new int[2];
            int[] r12 = new int[2];
            r5.getLocationOnScreen(r11);
            this.hostView.getLocationOnScreen(r12);
            ViewCompat.offsetLeftAndRight(r10, r11[0] - r12[0]);
            ViewCompat.offsetTopAndBottom(r10, r11[1] - r12[1]);
        L14:
            super.addView(r10);
        }
    }

    public ViewOverlayApi14(Context r5, ViewGroup r10, View r11) {
        this.overlayViewGroup = new OverlayViewGroup(r5, r10, r11, this);
    }

    public static ViewOverlayApi14 createFrom(View r5) {
        ViewGroup r10 = ViewUtils.getContentView(r5);
        if (r10 == null) goto L13;
        int r11 = r10.getChildCount();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L12;
        View r13 = r10.getChildAt(r12);
        if ((r13 instanceof OverlayViewGroup) == true) goto L9;
        r12 = r12 + 1;
        goto L5
    L9:
        return ((OverlayViewGroup) r13).viewOverlay;
    L12:
        return new ViewGroupOverlayApi14(r10.getContext(), r10, r5);
    L13:
        return null;
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void add(@NonNull Drawable r5) {
        this.overlayViewGroup.add(r5);
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void remove(@NonNull Drawable r5) {
        this.overlayViewGroup.remove(r5);
    }
}
