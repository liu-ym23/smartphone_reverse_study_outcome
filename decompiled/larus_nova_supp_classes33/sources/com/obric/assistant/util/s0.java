package com.obric.assistant.util;

import android.animation.ObjectAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.larus.common_ui.view.GradientMaskView;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.component.ObricChatPageStateComponent;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.impl.performance.WindowAnimationBoostCoordinator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class s0 {
    public final int[] a;
    public final hca.a b;
    public final FrameLayout c;
    public final ViewGroup d;
    public final FrameLayout e;
    public final ViewGroup f;
    public final Lazy g;
    public final m0 h;
    public final Lazy i;
    public final Lazy j;

    public static final class a {
    }

    static {
    }

    public final void a() {
        FLogger.a.i("ChatPageStateAnimationHelper", "cancelTopEmptyHeightAnim");
        c().cancel();
    }

    public final SpringAnimation c() {
        return (SpringAnimation) this.g.getValue();
    }

    public final SpringAnimation d() {
        return (SpringAnimation) this.i.getValue();
    }

    public final void e(int r7) {
        FLogger.a.e("ChatPageStateAnimationHelper", "initViewParams translation is " + r7);
        ViewGroup r0 = this.d;
        if (r0 == null) goto L11;
        int r1 = r0.getChildCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L15;
        View r3 = r0.getChildAt(r2);
        if (r3.getId() == 2131381196) goto L10;
        Intrinsics.checkNotNullParameter(r3, "it");
        this.h.invoke(r3, Float.valueOf(r7));
        Unit r4 = Unit.INSTANCE;
    L10:
        r2 = r2 + 1;
        goto L5
    L15:
        return;
    }

    public final void g(int r4) {
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r0 == null) goto L11;
        if (r4 != 0) goto L6;
        String r1 = "activity_window_enter_animation";
    L7:
        if (r4 != 0) goto L9;
        int r2 = 800;
    L10:
        r0.applyWindowAnimationBoost(r1, r2);
        goto L11
    L9:
        r2 = WindowAnimationBoostCoordinator.DEFAULT_WINDOW_ANIMATION_DURATION_MS;
        goto L10
    L6:
        r1 = "activity_window_exit_animation";
    L11:
        SpringAnimation r3 = d();
        FrameLayout r5 = this.e;
        if (r5 == null) goto L14;
        float r6 = r5.getTranslationY();
    L15:
        r3.setStartValue(r6);
        if (r4 != 0) goto L18;
        d().getSpring().setStiffness(440.0f);
        d().getSpring().setDampingRatio(0.8f);
    L19:
        d().animateToFinalPosition(r4);
        FLogger.a.i("ChatPageStateAnimationHelper", "startWindowAnim height is " + r4);
        return;
    L18:
        d().getSpring().setStiffness(1800.0f);
        d().getSpring().setDampingRatio(1.0f);
        goto L19
    L14:
        r6 = 0.0f;
        goto L15
    }

    public final void f(boolean r4, boolean r5) {
        ((ObjectAnimator) this.j.getValue()).cancel();
        ViewGroup r0 = this.d;
        ColorDrawable r1 = null;
        if (r0 == null) goto L5;
        Drawable r2 = r0.getBackground();
    L7:
        if ((r2 instanceof ColorDrawable) == false) goto L10;
        r1 = (ColorDrawable) r2;
    L10:
        if (r1 == null) goto L12;
        int r3 = r1.getColor();
    L13:
        if (r4 == false) goto L17;
        if (r5 == false) goto L16;
        int r6 = 1711276032;
    L18:
        if (r3 != r6) goto L21;
        FLogger.a.e("ChatPageStateAnimationHelper", "startBackgroundAnim startValue == endValue, ignore");
        return;
    L21:
        ((ObjectAnimator) this.j.getValue()).setIntValues(new int[]{r3, r6});
        ((ObjectAnimator) this.j.getValue()).start();
        return;
    L16:
        r6 = 1291845632;
        goto L18
    L17:
        r6 = 0;
        goto L18
    L12:
        r3 = 0;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    public final void b(float r4, float r5, Float r6) {
        FLogger.a.i("ChatPageStateAnimationHelper", "doTopEmptyHeightAnimation, startValue = " + r4 + ", finalPosition = " + r5);
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r0 == null) goto L5;
        r0.applyWindowAnimationBoost("activity_window_height_animation", WindowAnimationBoostCoordinator.DEFAULT_WINDOW_ANIMATION_DURATION_MS);
    L5:
        c().getSpring().setStiffness(322.0f);
        c().getSpring().setDampingRatio(1.0f);
        c().setStartValue(r4);
        c().animateToFinalPosition(r5);
        if (r6 == null) goto L9;
        r6.floatValue();
        SpringAnimation r7 = c().setStartVelocity(r6.floatValue());
        return;
    }

    public s0(va8.l r2, va8.c r3, int[] r4, ObricChatPageStateComponent r5) {
        Intrinsics.checkNotNullParameter(r4, "includeViewIds");
        Intrinsics.checkNotNullParameter(r5, "callBack");
        this.a = r4;
        this.b = r5;
        GradientMaskView r6 = null;
        if (r2 == null) goto L5;
        FrameLayout r7 = r2.z8();
    L6:
        this.c = r7;
        if (r2 == null) goto L9;
        ViewGroup r8 = r2.d();
    L10:
        this.d = r8;
        if (r2 == null) goto L13;
        FrameLayout r9 = r2.getInput();
    L14:
        this.e = r9;
        if (r3 == null) goto L17;
        r6 = r3.a();
    L17:
        this.f = r6;
        this.g = LazyKt.lazy(new l0(this));
        this.h = new m0(this);
        this.i = LazyKt.lazy(new n0(this));
        this.j = LazyKt.lazy(new o0(this));
        return;
    L13:
        r9 = null;
        goto L14
    L9:
        r8 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
    }
}
