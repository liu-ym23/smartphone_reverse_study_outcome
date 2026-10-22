package com.larus.voicecall.impl.video;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.ViewGroupKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.voicecall.impl.component.vlm.b1;
import com.larus.voicecall.impl.component.vlm.d1;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.List;
import java.util.ListIterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class y {
    public final View a;
    public final View b;
    public final boolean c;
    public final Function0<Float> d;
    public final Function0<Float> e;
    public final o f;
    public ViewPortContainerView g;
    public h h;
    public Function0<Unit> i;
    public final boolean j;
    public final boolean k;
    public final int l;

    public static final class a {
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ y a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ ViewGroup c;

        public b(y r1, ViewGroup r2, ViewGroup r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            Pair r10 = y.a(this.a, this.b, this.c);
            if (r10 == null) goto L7;
            b0 r11 = (b0) r10.component1();
            h r12 = (h) r10.component2();
            y r13 = this.a;
            r13.g = r11.c;
            r13.h = r12;
            r13.c(r11, true, null, new c(r11));
            return;
        }
    }

    public static final class c implements Function0<Unit> {
        public final /* synthetic */ b0 a;

        public c(b0 r1) {
            this.a = r1;
        }

        public final Object invoke() {
            e1.q(this.a.c.a);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    private final Context getContext() {
        return this.a.getContext();
    }

    public final void f() {
        ViewPortContainerView r3 = this.g;
        h r0 = this.h;
        boolean r1 = true;
        if (r3 == null) goto L8;
        if (r0 == null) goto L8;
        int[] r7 = {(int) ((r0.a - (r0.b / (this.b.getHeight() / this.b.getWidth()))) / 2), 0};
        Unit r2 = Unit.INSTANCE;
        final b0 r9 = new b0(1.0f, r7, r3, 1.0f, 0.0f);
        e1.q(r9.c.a);
        c(r9, false, new v(r9), new w(this));
        return;
    L8:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("invalid state, viewPortContainer is null ? (");
        if (r3 == null) goto L12;
        r1 = false;
    L12:
        r5.append(r1);
        r5.append("), originParams: ");
        r5.append(r0);
        r4.e("ViewPortSwitcher", r5.toString());
    }

    public final void g() {
        ViewGroup r0 = b(this.a);
        if (r0 != null) goto L6;
        FLogger.a.e("ViewPortSwitcher", "content view must in the view tree");
        return;
    L6:
        ViewParent r1 = this.a.getParent();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r2 = (ViewGroup) r1;
        e1.x(this.b);
        float r3 = this.b.getX() + (this.b.getWidth() / 2);
        int r4 = m0.a;
        int r5 = m0.b(getContext());
        if (r3 > (r5 / 2)) goto L9;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L17;
        View r7 = this.b;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 == null) goto L16;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
        int r10 = this.l;
        r9.leftMargin = r10;
        r9.setMarginStart(r10);
        r7.setLayoutParams(r9);
    L20:
        View r11 = this.b;
        if (r11.isLaidOut() == true) goto L23;
    L28:
        r11.addOnLayoutChangeListener(new b(this, r0, r2));
        return;
    L23:
        if (r11.isLayoutRequested() == true) goto L28;
        Pair r12 = a(this, r0, r2);
        if (r12 == null) goto L33;
        b0 r13 = (b0) r12.component1();
        h r14 = (h) r12.component2();
        this.g = r13.c;
        this.h = r14;
        c(r13, true, null, new c(r13));
        return;
    L33:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L17:
        View r15 = this.b;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L31;
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;
        r17.leftMargin = (r5 - this.b.getWidth()) - this.l;
        r15.setLayoutParams(r17);
        goto L20
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        r6 = false;
        goto L11
    }

    public static ViewGroup b(View r2) {
        if (r2.getId() == 16908290) goto L5;
    L8:
        Object r3 = r2.getParent();
        if ((r3 instanceof View) == true) goto L11;
        return null;
    L11:
        return b((View) r3);
    L5:
        if ((r2 instanceof FrameLayout) == false) goto L8;
        return (ViewGroup) r2;
    }

    public static void d(View r2) {
        ViewParent r0 = r2.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L9;
        r1.removeView(r2);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void e(ViewPortContainerView r5) {
        Function0<Float> r0 = this.d;
        float r1 = -1.0f;
        if (r0 == null) goto L5;
        float r2 = ((Number) r0.invoke()).floatValue();
    L6:
        Function0<Float> r3 = this.e;
        if (r3 == null) goto L10;
        r1 = ((Number) r3.invoke()).floatValue();
    L10:
        if (r2 >= 0.0f) goto L12;
        return;
    L12:
        if (r1 > 0.0f) goto L14;
        return;
    L14:
        if (r1 <= r2) goto L19;
        e r6 = r5.d;
        r6.getClass();
        r6.o = Math.max(r2, 0.0f);
        int r4 = m0.a;
        r6.p = Math.max(0.0f, Math.min(r1, m0.a(r6.a.getContext())));
        FLogger.a.d("DragFloatingEffect", "setDragLimit, topLmt = " + r6.o + ", bottomLmt = " + r6.p);
        return;
    L19:
        return;
    L5:
        r2 = -1.0f;
        goto L6
    }

    public static final Pair a(final y r18, ViewGroup r19, ViewGroup r20) {
        int[] r4 = new int[2];
        r18.a.getLocationOnScreen(r4);
        int[] r7 = new int[2];
        r18.b.getLocationOnScreen(r7);
        final ViewPortContainerView r8 = new ViewPortContainerView(r18.getContext(), null, 6, 0);
        r8.setUpdateLimitCallBack(new x(r18, r8));
        r8.d.j = r18.j;
        r18.e(r8);
        r8.setDragListener(new a0(r18));
        int r2 = r18.b.getWidth();
        int r3 = r18.b.getHeight();
        if (r2 == 0) goto L17;
        if (r3 == 0) goto L17;
        float r6 = r3;
        int r11 = r18.a.getWidth();
        int r12 = r18.a.getHeight();
        float r10 = r12;
        int r9 = (int) (r10 / (r6 / r2));
        int r14 = (int) r10;
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(r9, r14);
        FLogger.a.d("ViewPortSwitcher", "targetHeight: " + r3 + ", targetWidth: " + r2 + ", contentOriginWidth: " + r11 + ", contentOriginHeight: " + r12 + ", viewPortContainerWidth: " + r9 + ", viewPortContainerHeight: " + r14);
        d(r18.a);
        View r5 = r18.a;
        int r15 = -1;
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(-1, -1);
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r16, LynxResourceModule.PARAMS_KEY);
        r8.b.addView(r5, r16);
        if (r18.c == false) goto L15;
        List r0 = SequencesKt.toList(ViewGroupKt.getChildren(r19));
        ListIterator r1 = r0.listIterator(r0.size());
    L10:
        if (r1.hasPrevious() == false) goto L14;
        if ((((View) r1.previous()) instanceof ViewPortContainerView) == false) goto L10;
        r15 = r1.nextIndex();
    L14:
        r19.addView(r8, r15, r13);
    L16:
        e1.q(r8.a);
        return TuplesKt.to(new b0(r6 / r10, r7, r8, 0.0f, 1.0f), new h(r11, r12, r4, r20));
    L15:
        r19.addView(r8, r13);
    L17:
        FLogger.a.e("ViewPortSwitcher", "place holder view must has positive width: " + r2 + ", height: " + r3);
        return null;
    }

    public y(View r2, View r3, b1 r4, d1 r5) {
        Intrinsics.checkNotNullParameter(r2, "contentView");
        Intrinsics.checkNotNullParameter(r3, "placeHolder");
        this.a = r2;
        this.b = r3;
        this.c = true;
        this.d = r4;
        this.e = r5;
        this.f = new o();
        this.j = true;
        this.k = true;
        this.l = i5.j0();
    }

    public final void c(b0 r26, boolean r27, Function0<Unit> r28, Function0<Unit> r29) {
        int[] r0 = r26.b;
        ViewPortContainerView r13 = r26.c;
        float r12 = r26.a;
        float r11 = r0[1];
        float r10 = r0[0];
        float r1 = 0.0f;
        r13.setPivotX(0.0f);
        r13.setPivotY(0.0f);
        FLogger.a.d("ViewPortSwitcher", "target scale: " + r12 + ", targetTransX = " + r10 + ", targetTransY: " + r11 + ", enableZoomAnimate: " + this.k);
        if (this.k == true) goto L10;
        if (r28 == null) goto L6;
        r28.invoke();
    L6:
        r13.setScaleX(r12);
        r13.setScaleY(r12);
        r13.setTranslationX(r10);
        r13.setTranslationY(r11);
        if (r29 == null) goto L29;
        r29.invoke();
        return;
    L29:
        return;
    L10:
        View r2 = (View) SequencesKt.firstOrNull(ViewGroupKt.getChildren(r13));
        if (r2 == null) goto L20;
        o r3 = this.f;
        if (r27 == false) goto L15;
        float r4 = 1.0f;
    L16:
        if (r27 == true) goto L19;
        r1 = 1.0f;
    L19:
        TimeInterpolator r5 = com.larus.voicecall.impl.video.c.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "view");
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r2, "alpha", new float[]{r4, r1});
        r6.setDuration(50);
        r6.setInterpolator(r5);
        r6.addListener(new z(this, r27, r13, r12, r10, r11, r29, r13, r12, r10, r11, r27, r13, r12, r10, r11, r28));
        ObjectAnimator r7 = r6;
    L21:
        o r8 = this.f;
        float r9 = r26.d;
        float r14 = r26.e;
        TimeInterpolator r15 = com.larus.voicecall.impl.video.c.a;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r13, "view");
        ObjectAnimator r16 = ObjectAnimator.ofFloat(r13, "alpha", new float[]{r9, r14});
        r16.setDuration(150);
        r16.setInterpolator(r15);
        AnimatorSet r17 = new AnimatorSet();
        if (r7 == null) goto L26;
        if (r27 == false) goto L25;
        r17.play(r16).after(r7);
    L27:
        r17.start();
        return;
    L25:
        r17.play(r7).after(r16);
        goto L27
    L26:
        r17.play(r16);
        goto L27
    L15:
        r4 = 0.0f;
        goto L16
    L20:
        r7 = null;
        goto L21
    }
}
