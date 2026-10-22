package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
            sInvalidateChildInParentFastMethod = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[]{Integer.TYPE, Integer.TYPE, Rect.class});     // Catch: NoSuchMethodException -> L4
            return;
        }

        OverlayViewGroup(Context r3, ViewGroup r4, View r5, ViewOverlayApi14 r6) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
            this.mDrawables = null;
            this.mHostView = r4;
            this.mRequestingView = r5;
            setRight(r4.getWidth());
            setBottom(r4.getHeight());
            r4.addView(this);
            this.mViewOverlay = r6;
        }

        private void assertNotDisposed() {
            if (this.mDisposed == true) goto L6;
            return;
        L6:
            throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
        }

        private void disposeIfEmpty() {
            if (getChildCount() != 0) goto L10;
            ArrayList<Drawable> r0 = this.mDrawables;
            if (r0 != null) goto L7;
        L8:
            this.mDisposed = true;
            this.mHostView.removeView(this);
            return;
        L7:
            if (r0.size() == 0) goto L8;
            return;
        }

        private void getOffset(int[] r5) {
            int[] r1 = new int[2];
            int[] r0 = new int[2];
            this.mHostView.getLocationOnScreen(r1);
            this.mRequestingView.getLocationOnScreen(r0);
            r5[0] = r0[0] - r1[0];
            r5[1] = r0[1] - r1[1];
        }

        public void add(Drawable r2) {
            assertNotDisposed();
            if (this.mDrawables != null) goto L6;
            this.mDrawables = new ArrayList();
        L6:
            if (this.mDrawables.contains(r2) == true) goto L9;
            this.mDrawables.add(r2);
            invalidate(r2.getBounds());
            r2.setCallback(this);
            return;
        }

        public void add(View r6) {
            assertNotDisposed();
            if (ZeusTransformUtils.instanceOf(r6.getParent(), ViewGroup.class) == false) goto L14;
            ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r6.getParent(), ViewGroup.class, "com.obric.memorydata.plugin");
            if (r0 != this.mHostView) goto L7;
        L11:
            r0.removeView(r6);
            if (r6.getParent() == null) goto L14;
            r0.removeView(r6);
            goto L14
        L7:
            if (r0.getParent() == null) goto L11;
            if (ViewCompat.isAttachedToWindow(r0) == false) goto L11;
            int[] r2 = new int[2];
            int[] r1 = new int[2];
            r0.getLocationOnScreen(r2);
            this.mHostView.getLocationOnScreen(r1);
            ViewCompat.offsetLeftAndRight(r6, r2[0] - r1[0]);
            ViewCompat.offsetTopAndBottom(r6, r2[1] - r1[1]);
        L14:
            super.addView(r6);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas r6) {
            int[] r1 = new int[2];
            int[] r0 = new int[2];
            this.mHostView.getLocationOnScreen(r1);
            this.mRequestingView.getLocationOnScreen(r0);
            int r2 = 0;
            r6.translate(r0[0] - r1[0], r0[1] - r1[1]);
            r6.clipRect(new Rect(0, 0, this.mRequestingView.getWidth(), this.mRequestingView.getHeight()));
            super.dispatchDraw(r6);
            ArrayList<Drawable> r3 = this.mDrawables;
            if (r3 != null) goto L5;
            int r4 = 0;
        L6:
            if (r2 >= r4) goto L8;
            ((Drawable) ZeusTransformUtils.preCheckCast(this.mDrawables.get(r2), Drawable.class, "com.obric.memorydata.plugin")).draw(r6);
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
            if (this.mHostView == null) goto L11;
            r6.offset(r5[0], r5[1]);
            if (ZeusTransformUtils.instanceOf(this.mHostView, ViewGroup.class) == false) goto L8;
            r5[0] = 0;
            r5[1] = 0;
            int[] r1 = new int[2];
            getOffset(r1);
            r6.offset(r1[0], r1[1]);
            return super.invalidateChildInParent(r5, r6);
        L8:
            invalidate(r6);
            return null;
        L11:
            return null;
        }

        public ViewParent invalidateChildInParentFast(int r5, int r6, Rect r7) {
            if (ZeusTransformUtils.instanceOf(this.mHostView, ViewGroup.class) == true) goto L5;
            return null;
        L5:
            if (sInvalidateChildInParentFastMethod != null) goto L15;
            return null;
        L15:
            getOffset(new int[2]);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
            sInvalidateChildInParentFastMethod.invoke(this.mHostView, new Object[]{Integer.valueOf(r5), Integer.valueOf(r6), r7});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
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
        public void invalidateDrawable(Drawable r1) {
            invalidate(r1.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        }

        public void remove(Drawable r2) {
            ArrayList<Drawable> r0 = this.mDrawables;
            if (r0 == null) goto L6;
            r0.remove(r2);
            invalidate(r2.getBounds());
            r2.setCallback(null);
            disposeIfEmpty();
            return;
        }

        public void remove(View r1) {
            super.removeView(r1);
            disposeIfEmpty();
        }

        @Override // android.view.View
        public boolean verifyDrawable(Drawable r2) {
            if (super.verifyDrawable(r2) == true) goto L10;
            ArrayList<Drawable> r1 = this.mDrawables;
            if (r1 != null) goto L7;
        L9:
            return false;
        L7:
            if (r1.contains(r2) == false) goto L9;
        L10:
            return true;
        }
    }

    ViewOverlayApi14(Context r3, ViewGroup r4, View r5) {
        this.mOverlayViewGroup = new OverlayViewGroup((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5, this);
    }

    static ViewOverlayApi14 createFrom(View r6) {
        ViewGroup r0 = getContentView(r6);
        if (r0 == null) goto L14;
        int r1 = r0.getChildCount();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L13;
        View r4 = r0.getChildAt(r2);
        if (ZeusTransformUtils.instanceOf(r4, OverlayViewGroup.class) == true) goto L10;
        r2 = r2 + 1;
        goto L6
    L10:
        return ((OverlayViewGroup) ZeusTransformUtils.preCheckCast(r4, OverlayViewGroup.class, "com.obric.memorydata.plugin")).mViewOverlay;
    L13:
        return new ViewGroupOverlayApi14((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r0, r6);
    L14:
        return null;
    }

    static ViewGroup getContentView(View r3) {
    L2:
        if (r3 == null) goto L12;
        if (r3.getId() != 16908290) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L10;
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin");
    L10:
        if (ZeusTransformUtils.instanceOf(r3.getParent(), ViewGroup.class) == false) goto L2;
        r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(r3.getParent(), ViewGroup.class, "com.obric.memorydata.plugin");
        goto L2
    L12:
        return null;
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(Drawable r1) {
        this.mOverlayViewGroup.add(r1);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(Drawable r1) {
        this.mOverlayViewGroup.remove(r1);
    }
}
