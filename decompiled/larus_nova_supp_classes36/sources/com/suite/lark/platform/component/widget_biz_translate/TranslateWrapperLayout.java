package com.suite.lark.platform.component.widget_biz_translate;

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
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0002&'B)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0014J\b\u0010\u001c\u001a\u00020\u0018H\u0014J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\u0018H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_translate/TranslateWrapperLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "preY", "", "startY", "totalOffsetY", "maxVelocity", "listener", "Lcom/suite/lark/platform/component/widget_biz_translate/TranslateWrapperLayout$ShrinkLayoutChangeListener;", "velocityTracker", "Landroid/view/VelocityTracker;", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "setListener", "", "onTouchEvent", "event", "onAttachedToWindow", "onDetachedFromWindow", "isChildNeedScroll", "viewGroup", "Landroid/view/ViewGroup;", "isLocationInView", "view", "Landroid/view/View;", "x", "y", "startRestore", "ShrinkLayoutChangeListener", "Companion", "widget-biz-translate_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class TranslateWrapperLayout extends LinearLayout {
    public static final /* synthetic */ int f = 0;
    public float a;
    public float b;
    public float c;
    public final int d;
    public VelocityTracker e;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public TranslateWrapperLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TranslateWrapperLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setListener(b r1) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        VelocityTracker r0 = this.e;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.recycle();
        this.e = null;
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.e = VelocityTracker.obtain();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        Log.d("TranslateWrapperLayout", "onInterceptTouchEvent: ev: " + r4.getActionMasked());
        if (r4.getActionMasked() != 0) goto L6;
        this.b = r4.getRawY();
    L17:
        return super.onInterceptTouchEvent(r4);
    L6:
        if (r4.getActionMasked() != 2) goto L17;
        if ((r4.getRawY() - this.b) <= 20.0f) goto L10;
        boolean r0 = true;
    L11:
        boolean r1 = a(this, r4);
        if (r0 == false) goto L17;
        if (r1 == true) goto L17;
        this.a = r4.getRawY();
        this.c = 0.0f;
        return true;
    L10:
        r0 = false;
        goto L11
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        int r0 = r8.getActionMasked();
        Log.d("TranslateWrapperLayout", "onTouchEvent: " + r8.getAction());
        if (this.e != null) goto L5;
        this.e = VelocityTracker.obtain();
    L5:
        VelocityTracker r1 = this.e;
        Intrinsics.checkNotNull(r1);
        r1.addMovement(r8);
        VelocityTracker r2 = this.e;
        Intrinsics.checkNotNull(r2);
        r2.computeCurrentVelocity(AudioViewModel.ASR_SESSION_IDLE, this.d);
        r2.getXVelocity();
        float r3 = r2.getYVelocity();
        boolean r4 = false;
        if (r0 == 1) goto L19;
        if (r0 == 2) goto L10;
    L24:
        return true;
    L10:
        if (this.a != 0.0f) goto L12;
        r4 = true;
    L12:
        if (r4 == false) goto L14;
        this.a = r8.getRawY();
    L14:
        this.c += r8.getRawY() - this.a;
        Log.d("TranslateWrapperLayout", "mTotalOffsetY is " + this.c + "  event.rawY is " + r8.getRawY() + " mPreY os " + this.a);
        if (this.c >= 0.0f) goto L17;
        this.c = 0.0f;
    L17:
        setTranslationY(this.c);
        this.a = r8.getRawY();
        goto L24
    L19:
        if (r3 > 2000.0f) goto L24;
        if (this.c > 300.0f) goto L24;
        ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{getTranslationY(), 0.0f});
        r9.setInterpolator(new DecelerateInterpolator());
        r9.addUpdateListener(new e(this));
        Intrinsics.checkNotNull(r9);
        r9.addListener(new d(this));
        r9.addListener(new c(this));
        r9.start();
        goto L24
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

    public TranslateWrapperLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        if (r1 == null) goto L7;
        this.d = ViewConfiguration.get(r1).getScaledMaximumFlingVelocity();
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public /* synthetic */ TranslateWrapperLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
