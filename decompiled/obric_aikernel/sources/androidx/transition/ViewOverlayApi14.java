package androidx.transition;

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

/* JADX INFO: loaded from: classes.dex */
class ViewOverlayApi14 implements ViewOverlayImpl {
    protected OverlayViewGroup mOverlayViewGroup;

    static class OverlayViewGroup extends ViewGroup {
        static Method sInvalidateChildInParentFastMethod;
        private boolean mDisposed;
        ArrayList<Drawable> mDrawables;
        ViewGroup mHostView;
        View mRequestingView;
        ViewOverlayApi14 mViewOverlay;

        static {
            Class r10 = Integer.TYPE;     // Catch: NoSuchMethodException -> L4
            sInvalidateChildInParentFastMethod = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[]{r10, r10, Rect.class});     // Catch: NoSuchMethodException -> L4
            return;
        }

        OverlayViewGroup(Context r10, ViewGroup r11, View r12, ViewOverlayApi14 r13) {
            super(r10);
            this.mDrawables = null;
            this.mHostView = r11;
            this.mRequestingView = r12;
            setRight(r11.getWidth());
            setBottom(r11.getHeight());
            r11.addView(this);
            this.mViewOverlay = r13;
        }

        private void assertNotDisposed() {
            if (this.mDisposed == true) goto L6;
            return;
        L6:
            throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
        }

        private void disposeIfEmpty() {
            if (getChildCount() != 0) goto L10;
            ArrayList<Drawable> r10 = this.mDrawables;
            if (r10 != null) goto L7;
        L8:
            this.mDisposed = true;
            this.mHostView.removeView(this);
            return;
        L7:
            if (r10.size() == 0) goto L8;
            return;
        }

        private void getOffset(int[] r10) {
            int[] r11 = new int[2];
            int[] r12 = new int[2];
            this.mHostView.getLocationOnScreen(r11);
            this.mRequestingView.getLocationOnScreen(r12);
            r10[0] = r12[0] - r11[0];
            r10[1] = r12[1] - r11[1];
        }

        public void add(Drawable r10) {
            assertNotDisposed();
            if (this.mDrawables != null) goto L6;
            this.mDrawables = new ArrayList();
        L6:
            if (this.mDrawables.contains(r10) == true) goto L9;
            this.mDrawables.add(r10);
            invalidate(r10.getBounds());
            r10.setCallback(this);
            return;
        }

        public void add(View r10) {
            assertNotDisposed();
            if ((r10.getParent() instanceof ViewGroup) == false) goto L14;
            ViewGroup r11 = (ViewGroup) r10.getParent();
            if (r11 != this.mHostView) goto L7;
        L11:
            r11.removeView(r10);
            if (r10.getParent() == null) goto L14;
            r11.removeView(r10);
            goto L14
        L7:
            if (r11.getParent() == null) goto L11;
            if (ViewCompat.isAttachedToWindow(r11) == false) goto L11;
            int[] r12 = new int[2];
            int[] r13 = new int[2];
            r11.getLocationOnScreen(r12);
            this.mHostView.getLocationOnScreen(r13);
            ViewCompat.offsetLeftAndRight(r10, r12[0] - r13[0]);
            ViewCompat.offsetTopAndBottom(r10, r12[1] - r13[1]);
        L14:
            super.addView(r10);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas r10) {
            int[] r11 = new int[2];
            int[] r12 = new int[2];
            this.mHostView.getLocationOnScreen(r11);
            this.mRequestingView.getLocationOnScreen(r12);
            int r13 = 0;
            r10.translate(r12[0] - r11[0], r12[1] - r11[1]);
            r10.clipRect(new Rect(0, 0, this.mRequestingView.getWidth(), this.mRequestingView.getHeight()));
            super.dispatchDraw(r10);
            ArrayList<Drawable> r14 = this.mDrawables;
            if (r14 != null) goto L5;
            int r15 = 0;
        L6:
            if (r13 >= r15) goto L8;
            this.mDrawables.get(r13).draw(r10);
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

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] r10, Rect r11) {
            if (this.mHostView == null) goto L11;
            r11.offset(r10[0], r10[1]);
            if ((this.mHostView instanceof ViewGroup) == false) goto L8;
            r10[0] = 0;
            r10[1] = 0;
            int[] r12 = new int[2];
            getOffset(r12);
            r11.offset(r12[0], r12[1]);
            return super.invalidateChildInParent(r10, r11);
        L8:
            invalidate(r11);
            return null;
        L11:
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected ViewParent invalidateChildInParentFast(int r10, int r11, Rect r12) {
            if ((this.mHostView instanceof ViewGroup) == true) goto L5;
            return null;
        L5:
            if (sInvalidateChildInParentFastMethod != null) goto L15;
            return null;
        L15:
            getOffset(new int[2]);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
            sInvalidateChildInParentFastMethod.invoke(this.mHostView, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11), r12});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
        L20:
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
        public void invalidateDrawable(@NonNull Drawable r10) {
            invalidate(r10.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        }

        public void remove(Drawable r10) {
            ArrayList<Drawable> r11 = this.mDrawables;
            if (r11 == null) goto L6;
            r11.remove(r10);
            invalidate(r10.getBounds());
            r10.setCallback(null);
            disposeIfEmpty();
            return;
        }

        public void remove(View r10) {
            super.removeView(r10);
            disposeIfEmpty();
        }

        @Override // android.view.View
        protected boolean verifyDrawable(@NonNull Drawable r10) {
            if (super.verifyDrawable(r10) == true) goto L10;
            ArrayList<Drawable> r11 = this.mDrawables;
            if (r11 != null) goto L7;
        L9:
            return false;
        L7:
            if (r11.contains(r10) == false) goto L9;
        L10:
            return true;
        }
    }

    ViewOverlayApi14(Context r10, ViewGroup r11, View r12) {
        this.mOverlayViewGroup = new OverlayViewGroup(r10, r11, r12, this);
    }

    static ViewOverlayApi14 createFrom(View r10) {
        ViewGroup r11 = getContentView(r10);
        if (r11 == null) goto L13;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L12;
        View r14 = r11.getChildAt(r13);
        if ((r14 instanceof OverlayViewGroup) == true) goto L9;
        r13 = r13 + 1;
        goto L5
    L9:
        return ((OverlayViewGroup) r14).mViewOverlay;
    L12:
        return new ViewGroupOverlayApi14(r11.getContext(), r11, r10);
    L13:
        return null;
    }

    static ViewGroup getContentView(View r10) {
    L2:
        if (r10 == null) goto L12;
        if (r10.getId() != 16908290) goto L10;
        if ((r10 instanceof ViewGroup) == false) goto L10;
        return (ViewGroup) r10;
    L10:
        if ((r10.getParent() instanceof ViewGroup) == false) goto L2;
        r10 = (ViewGroup) r10.getParent();
        goto L2
    L12:
        return null;
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(@NonNull Drawable r10) {
        this.mOverlayViewGroup.add(r10);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(@NonNull Drawable r10) {
        this.mOverlayViewGroup.remove(r10);
    }
}
