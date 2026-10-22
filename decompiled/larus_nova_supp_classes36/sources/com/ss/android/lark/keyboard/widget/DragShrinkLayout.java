package com.ss.android.lark.keyboard.widget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import com.ss.android.lark.keyboard.editor.input.RichTextInputExpandPlugin;
import com.ss.android.lark.keyboard.editor.input.w;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class DragShrinkLayout extends LinearLayout {
    public static final /* synthetic */ int i = 0;
    public float a;
    public float b;
    public float c;
    public float d;
    public a e;
    public VelocityTracker f;
    public int g;
    public boolean h;

    public interface a {
        void a();

        void b(float r1, float r2);

        void c();

        void d();

        void e();

        void f();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        VelocityTracker r0 = this.f;
        if (r0 == null) goto L5;
        r0.recycle();
        this.f = null;
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f = VelocityTracker.obtain();
    }

    public DragShrinkLayout(Context r2) {
        this(r2, null);
    }

    public final void b(RichTextInputExpandPlugin.b r7) {
        float r0 = getTranslationY();
        final float r1 = getRootView().getHeight();
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{r0, r1});
        r2.setInterpolator(new DecelerateInterpolator());
        r2.addUpdateListener(new g(this, r1));
        r2.addListener(new i(this, r7));
        AnimatorSet r8 = new AnimatorSet();
        r8.setDuration(350);
        r8.playTogether(new ValueAnimator[]{r2});
        r8.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r1) {
        return super.dispatchTouchEvent(r1);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        if (this.h == false) goto L5;
        Log.d("DragShrinkLayout", "onInterceptTouchEvent: " + r4.getRawY());
        if (r4.getAction() != 0) goto L10;
        this.b = r4.getRawY();
    L21:
        return super.onInterceptTouchEvent(r4);
    L10:
        if (r4.getAction() == 1) goto L21;
        if (r4.getAction() == 3) goto L21;
        if ((r4.getRawY() - this.b) <= 20.0f) goto L21;
        if (a(this, r4) == true) goto L21;
        this.a = r4.getRawY();
        this.c = 0.0f;
        return true;
    L5:
        return super.onInterceptTouchEvent(r4);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r9) {
        int r0 = r9.getAction();
        Log.d("DragShrinkLayout", "onTouchEvent: " + r9.getAction());
        if (this.f != null) goto L5;
        this.f = VelocityTracker.obtain();
    L5:
        this.f.addMovement(r9);
        VelocityTracker r1 = this.f;
        r1.computeCurrentVelocity(AudioViewModel.ASR_SESSION_IDLE, this.d);
        float r4 = r1.getXVelocity();
        float r2 = r1.getYVelocity();
        if (r0 == 1) goto L20;
        if (r0 != 2) goto L10;
        float r3 = this.c + (r9.getRawY() - this.a);
        this.c = r3;
        if (r3 >= 0.0f) goto L16;
        this.c = 0.0f;
    L16:
        setTranslationY(this.c);
        this.e.b(getRootView().getHeight(), this.c);
        this.a = r9.getRawY();
        a r5 = this.e;
        if (r5 == null) goto L26;
        r5.a();
    L26:
        Log.d("DragShrinkLayout", "onTouchEvent: " + r4 + "   " + r2);
        Log.d("DragShrinkLayout", "onTouchEvent: totaloffset=" + this.c + " current=" + r9.getRawY() + " pre=" + this.a + " start=" + this.b);
        return super.onTouchEvent(r9);
    L10:
        if (r0 != 3) goto L26;
        setTranslationY(0.0f);
        goto L26
    L20:
        if (r2 <= 2000.0f) goto L22;
    L25:
        b(null);
        goto L26
    L22:
        if (this.c > 300.0f) goto L25;
        c(null, Boolean.FALSE);
        goto L26
    }

    public void setDragEnabled(boolean r1) {
        this.h = r1;
    }

    public void setListener(a r1) {
        this.e = r1;
    }

    public DragShrinkLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static boolean a(ViewGroup r14, MotionEvent r15) {
        if (r14.canScrollVertically(-1) == false) goto L5;
        return true;
    L5:
        int r1 = r14.getChildCount();
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L20;
        View r5 = r14.getChildAt(r4);
        if (r5 == null) goto L19;
        float r6 = r15.getRawX();
        float r7 = r15.getRawY();
        int[] r8 = new int[2];
        r5.getLocationOnScreen(r8);
        int r10 = r8[0];
        if (new RectF(r10, r8[1], r10 + r5.getWidth(), r8[1] + r5.getHeight()).contains(r6, r7) == false) goto L19;
        if ((r5 instanceof ViewGroup) == false) goto L16;
        boolean r9 = a((ViewGroup) r5, r15);
    L17:
        if (r9 == false) goto L19;
        return true;
    L16:
        r9 = r5.canScrollVertically(-1);
    L19:
        r4 = r4 + 1;
        goto L6
    L20:
        return false;
    }

    public final void c(w r8, Boolean r9) {
        final float r0 = getRootView().getHeight();
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{getTranslationY(), 0.0f});
        r1.setInterpolator(new DecelerateInterpolator());
        r1.addUpdateListener(new f(this, r0));
        r1.addListener(new h(this, r8));
        AnimatorSet r10 = new AnimatorSet();
        if (r9.booleanValue() == false) goto L5;
        int r11 = 150;
    L6:
        r10.setDuration(r11);
        r10.playTogether(new ValueAnimator[]{r1});
        r10.start();
        return;
    L5:
        r11 = 350;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        if (View.MeasureSpec.getSize(r3) == 0) goto L5;
    L11:
        this.g = getMeasuredHeight();
        return;
    L5:
        if (View.MeasureSpec.getMode(r3) == 1073741824) goto L9;
        if (View.MeasureSpec.getMode(r3) != Integer.MIN_VALUE) goto L11;
    L9:
        if (this.g == 0) goto L11;
        post(new e(this));
        goto L11
    }

    public DragShrinkLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.g = 0;
        this.h = true;
        ViewConfiguration.get(getContext());
        this.d = ViewConfiguration.getMaximumFlingVelocity();
    }
}
