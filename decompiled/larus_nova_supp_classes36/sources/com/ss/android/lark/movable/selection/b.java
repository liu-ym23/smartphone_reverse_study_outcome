package com.ss.android.lark.movable.selection;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends View {
    public final com.ss.android.lark.movable.selection.d a;
    public final int[] b;
    public final ViewTreeObserverOnDrawListenerC0191b c;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r6, MotionEvent r7) {
            b r8 = this.a;
            Intrinsics.checkNotNull(r7);
            View r0 = r8.a.getView();
            r0.getLocationOnScreen(r8.b);
            MotionEvent r1 = MotionEvent.obtain(r7);
            r1.offsetLocation((r7.getRawX() - r8.b[0]) - r7.getX(), (r7.getRawY() - r8.b[1]) - r7.getY());
            boolean r9 = r0.dispatchTouchEvent(r1);     // Catch: Throwable -> L6
            r1.recycle();
            return r9;
        L6:
            th = move-exception;
            r1.recycle();
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.movable.selection.b$b, reason: collision with other inner class name */
    public static final class ViewTreeObserverOnDrawListenerC0191b implements ViewTreeObserver.OnDrawListener {
        public final /* synthetic */ b a;

        public ViewTreeObserverOnDrawListenerC0191b(b r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            this.a.invalidate();
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ b b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            this.a.removeOnAttachStateChangeListener(this);
            this.b.a.getView().getViewTreeObserver().addOnDrawListener(this.b.c);
        }

        public c(View r1, b r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ b b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            this.a.removeOnAttachStateChangeListener(this);
            this.b.a.getView().getViewTreeObserver().removeOnDrawListener(this.b.c);
        }

        public d(View r1, b r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        super.onDraw(r3);
        this.a.setIsGhost(false);
        this.a.getView().draw(r3);
        this.a.setIsGhost(true);
    }

    public b(Context r2, com.ss.android.lark.movable.selection.d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "origin");
        super(r2);
        this.a = r3;
        this.b = new int[2];
        ViewTreeObserverOnDrawListenerC0191b r4 = new ViewTreeObserverOnDrawListenerC0191b(this);
        this.c = r4;
        if (isAttachedToWindow() == false) goto L5;
        r3.getView().getViewTreeObserver().addOnDrawListener(r4);
    L7:
        if (isAttachedToWindow() == true) goto L9;
        r3.getView().getViewTreeObserver().removeOnDrawListener(r4);
    L10:
        setOnTouchListener(new a(this));
        return;
    L9:
        addOnAttachStateChangeListener(new d(this, this));
        goto L10
    L5:
        addOnAttachStateChangeListener(new c(this, this));
        goto L7
    }

    @Override // android.view.View
    public final void onMeasure(int r6, int r7) {
        View r8 = this.a.getView();
        Integer r9 = Integer.valueOf(r8.getWidth());
        boolean r1 = true;
        if (r9.intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        Integer r3 = null;
        if (r0 == true) goto L10;
        r9 = null;
    L10:
        if (r9 == null) goto L12;
        int r10 = r9.intValue();
    L13:
        Integer r2 = Integer.valueOf(r8.getHeight());
        if (r2.intValue() > 0) goto L17;
        r1 = false;
    L17:
        if (r1 == false) goto L19;
        r3 = r2;
    L19:
        if (r3 == null) goto L21;
        int r11 = r3.intValue();
    L22:
        setMeasuredDimension(r10, r11);
        return;
    L21:
        r11 = r8.getMeasuredHeight();
        goto L22
    L12:
        r10 = r8.getMeasuredWidth();
        goto L13
    L5:
        r0 = false;
        goto L6
    }
}
