package com.larus.bmhome.view.screenmenu;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 @2\u00020\u0001:\u0002@AB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0017J&\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0%J4\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u001b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0%2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0%J \u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u000eJ\b\u0010(\u001a\u00020\u001dH\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u001dH\u0002J\u0016\u0010.\u001a\u00020\u001d2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001d0%H\u0002J$\u00100\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000202012\u0006\u0010'\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000eH\u0002J\u000e\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u001bJ\u0016\u00106\u001a\b\u0012\u0004\u0012\u000208072\u0006\u00109\u001a\u00020\u000eH\u0002J\u0006\u0010:\u001a\u00020\u001dJ\u0014\u0010:\u001a\u00020\u001d2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001d0%J\b\u0010;\u001a\u00020\u001dH\u0002J\u0010\u0010<\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000eH\u0002J\u0018\u0010=\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u000eH\u0003J\u0018\u0010?\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000eH\u0002R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/larus/bmhome/view/screenmenu/ScreenMenuLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "menuLocate", "Lkotlin/Function1;", "Landroid/view/View;", "Lcom/larus/bmhome/view/screenmenu/MenuLocateResult;", "getMenuLocate$common_ui_mainlandRelease", "()Lkotlin/jvm/functions/Function1;", "setMenuLocate$common_ui_mainlandRelease", "(Lkotlin/jvm/functions/Function1;)V", "currentAnchorView", "currentMenuView", "menuMaskView", "enterAnimator", "Landroid/animation/Animator;", "exitAnimator", "isClearingMenuState", "", "init", "", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "show", "anchor", "isBgBlur", "menuViewHolder", "Lkotlin/Function0;", "itemViewHolder", "menuView", "showBlurView", "captureActivity", "Landroid/graphics/Bitmap;", "activity", "Landroid/app/Activity;", "doEnterAnimation", "doExitAnimation", "onAnimationEnd", "calculateScalePivot", "Lkotlin/Pair;", "", "anchorView", "setMenuMask", "visible", "getViewCornersOnScreen", "", "Lcom/larus/bmhome/view/screenmenu/ScreenMenuLayout$CornerPoint;", "targetView", "gone", "clearMenuState", "addFocusImg", "addFocusItem", "itemView", "locateMenu", "Companion", "CornerPoint", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenMenuLayout extends FrameLayout {
    public static final int h = 0;
    public static final int i = 0;
    public Function1<? super View, r0> a;
    public View b;
    public View c;
    public View d;
    public Animator e;
    public Animator f;
    public boolean g;

    public static final class a {
    }

    public static final class b {
        public final float a;
        public final float b;
        public final float c;
        public final float d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Float.compare(this.a, r6.a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r6.b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.c, r6.c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.d, r6.d) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d);
        }

        public final String toString() {
            return "CornerPoint(localX=" + this.a + ", localY=" + this.b + ", xOnScreen=" + this.c + ", yOnScreen=" + this.d + ')';
        }

        public b(float r1, float r2, float r3, float r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
        h = i5.A();
        i = i5.r0();
    }

    public final void d() {
        if (this.g == false) goto L5;
        return;
    L5:
        this.g = true;
        Animator r0 = this.e;
        Animator r1 = this.f;
        this.e = null;
        this.f = null;
        if (r0 == null) goto L8;
        r0.removeAllListeners();
    L8:
        if (r1 == null) goto L10;
        r1.removeAllListeners();
    L10:
        if (r0 == null) goto L12;
        r0.cancel();
    L12:
        if (r1 == null) goto L14;
        r1.cancel();
    L14:
        removeAllViews();
        this.d = null;
        this.b = null;
        this.c = null;
        setAlpha(1.0f);
        setVisibility(8);
        this.g = false;
    }

    public final Function1<View, r0> getMenuLocate$common_ui_mainlandRelease() {
        return this.a;
    }

    public ScreenMenuLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        g(r2);
    }

    public static final void a(ScreenMenuLayout r8) {
        Animator r0 = r8.f;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        Animator r1 = r8.e;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r8, "alpha", new float[]{0.0f, 1.0f});
        r2.setDuration(100);
        View r4 = r8.c;
        View r5 = r8.b;
        if (r4 == null) goto L17;
        if (r5 == null) goto L17;
        if (r4.getWidth() == 0) goto L17;
        if (r4.getHeight() == 0) goto L17;
        Pair r6 = b(r4, r5);
        r4.setPivotX(((Number) r6.getFirst()).floatValue());
        r4.setPivotY(((Number) r6.getSecond()).floatValue());
        r4.setScaleX(0.0f);
        r4.setScaleY(0.0f);
        ObjectAnimator r7 = ObjectAnimator.ofFloat(r4, View.SCALE_X, new float[]{0.0f, 1.0f});
        r7.setDuration(100);
        ObjectAnimator r9 = ObjectAnimator.ofFloat(r4, View.SCALE_Y, new float[]{0.0f, 1.0f});
        r9.setDuration(100);
        AnimatorSet r3 = new AnimatorSet();
        r3.playTogether(new Animator[]{r2, r7, r9});
        r3.start();
        r8.e = r3;
        return;
    L17:
        r2.start();
    }

    public static Bitmap c(Activity r3) {
        View r4 = r3.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        View r5 = r4.getRootView();
        r5.setDrawingCacheEnabled(true);
        Bitmap r1 = Bitmap.createBitmap(r5.getDrawingCache());
        r5.setDrawingCacheEnabled(false);
        return r1;
    }

    public static List e(View r10) {
        int[] r1 = new int[2];
        r10.getLocationOnScreen(r1);
        float r3 = r1[0];
        float r2 = r1[1];
        float r5 = r10.getWidth() + r3;
        float r6 = r10.getHeight() + r2;
        return CollectionsKt.listOf(new b[]{new b(0.0f, 0.0f, r3, r2), new b(r10.getWidth(), 0.0f, r5, r2), new b(0.0f, r10.getHeight(), r3, r6), new b(r10.getWidth(), r10.getHeight(), r5, r6)});
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.bmhome.view.screenmenu.a1] */
    public final void f(final Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r13, "onAnimationEnd");
        if (getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        d();
        r13.invoke();
        return;
    L9:
        ?? r1 = new a1(this, r13);
        Animator r14 = this.e;
        if (r14 == null) goto L12;
        r14.cancel();
    L12:
        Animator r15 = this.f;
        if (r15 == null) goto L15;
        r15.cancel();
    L15:
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this, "alpha", new float[]{getAlpha(), 0.0f});
        r3.setDuration(100);
        View r7 = this.c;
        View r8 = this.b;
        if (r7 == null) goto L24;
        if (r8 == null) goto L24;
        if (r7.getWidth() == 0) goto L24;
        if (r7.getHeight() == 0) goto L24;
        Pair r9 = b(r7, r8);
        r7.setPivotX(((Number) r9.getFirst()).floatValue());
        r7.setPivotY(((Number) r9.getSecond()).floatValue());
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r7, View.SCALE_X, new float[]{r7.getScaleX(), 0.0f});
        r10.setDuration(100);
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r7, View.SCALE_Y, new float[]{r7.getScaleY(), 0.0f});
        r4.setDuration(100);
        AnimatorSet r5 = new AnimatorSet();
        r5.playTogether(new Animator[]{r3, r10, r4});
        r5.addListener(new c1(r1));
        r5.start();
        this.f = r5;
        return;
    L24:
        r3.addListener(new b1(r1));
        this.f = r3;
        r3.start();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void g(Context r2) {
        setBackgroundColor(ContextCompat.getColor(r2, 2131103293));
        setVisibility(8);
        setOnClickListener(new z0(this));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r3) {
        if (r3 == null) goto L4;
        Integer r0 = Integer.valueOf(r3.getActionMasked());
    L5:
        if (r0 == null) goto L11;
        if (r0.intValue() != 0) goto L11;
        getParent().requestDisallowInterceptTouchEvent(true);
    L11:
        return super.onTouchEvent(r3);
    L4:
        r0 = null;
        goto L5
    }

    public final void setMenuLocate$common_ui_mainlandRelease(Function1<? super View, r0> r1) {
        this.a = r1;
    }

    public final void setMenuMask(boolean r8) {
        View r0 = this.c;
        if (r8 == false) goto L18;
        if (r0 == null) goto L18;
        if (r0.getWidth() <= 0) goto L18;
        if (r0.getHeight() <= 0) goto L18;
        View r9 = this.d;
        if (r9 != null) goto L13;
        r9 = new View(getContext());
        r9.setBackgroundResource(v19.c.b(2130971607, r9.getContext(), 2131240710));
        r9.setAlpha(0.5f);
        r9.setClickable(true);
        this.d = r9;
    L13:
        int[] r3 = new int[2];
        r0.getLocationOnScreen(r3);
        int[] r2 = new int[2];
        getLocationOnScreen(r2);
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(r0.getWidth(), r0.getHeight());
        r4.gravity = 51;
        r4.leftMargin = r3[0] - r2[0];
        r4.topMargin = r3[1] - r2[1];
        r9.setLayoutParams(r4);
        if (r9.getParent() != null) goto L16;
        addView(r9);
    L16:
        r9.bringToFront();
        r9.setVisibility(0);
        return;
    L18:
        View r10 = this.d;
        if (r10 == null) goto L21;
        removeView(r10);
    L21:
        this.d = null;
    }

    public ScreenMenuLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        g(r2);
    }

    public static Pair b(View r7, View r8) {
        List r9 = e(r7);
        List r10 = e(r8);
        Object r0 = CollectionsKt.first(r9);
        Iterator r11 = r9.iterator();
        float r1 = Float.MAX_VALUE;
    L4:
        if (r11.hasNext() == false) goto L11;
        b r2 = (b) r11.next();
        Iterator r3 = r10.iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        b r4 = (b) r3.next();
        float r5 = r2.c - r4.c;
        float r6 = r2.d - r4.d;
        float r12 = (r5 * r5) + (r6 * r6);
        if (r12 >= r1) goto L7;
        r0 = r2;
        r1 = r12;
        goto L7
    L11:
        b r13 = (b) r0;
        return TuplesKt.to(Float.valueOf(r13.a), Float.valueOf(r13.b));
    }

    public ScreenMenuLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        g(r2);
    }
}
