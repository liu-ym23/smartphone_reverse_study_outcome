package com.obric.assistant.window.component;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.component.ObricIntercomComponent;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimator;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.obric.assistant.view.glowui.OverlayerAudioView;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.Token$Delay;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oea.foundation.animation.token.Token$Easing;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a0 implements IWindowAnimator {
    public fja.d a;
    public final /* synthetic */ WindowAnimationType b;
    public final /* synthetic */ WindowAnimationComponent c;
    public final /* synthetic */ boolean d;

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
    public final void cancel() {
        FLogger.a.i("WindowAnimationComponent", "window chat root cancel " + this.b);
        fja.d r0 = this.a;
        if (r0 == null) goto L6;
        int r1 = fja.d.d;
        r0.a(false);
        return;
    }

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
    public final void start(final Function1<? super Boolean, Unit> r14) {
        Intrinsics.checkNotNullParameter(r14, "onEnd");
        FLogger r0 = FLogger.a;
        r0.i("WindowAnimationComponent", "window chat root start " + this.b);
        ObricIntercomComponent r1 = (ObricIntercomComponent) this.c.j.getValue();
        Float r3 = null;
        if (r1 == null) goto L5;
        final OverlayerAudioView r2 = r1.X3();
    L6:
        if (r2 == null) goto L8;
        Float r4 = Float.valueOf(r2.getAlpha());
    L10:
        if (Intrinsics.areEqual(r4, 0.0f) == true) goto L12;
    L13:
        if (r2 == null) goto L16;
        r3 = Float.valueOf(r2.getAlpha());
    L16:
        if (Intrinsics.areEqual(r3, 1.0f) == true) goto L18;
    L21:
        ViewGroup r5 = (ViewGroup) this.c.m.getValue();
        if (r5 != null) goto L25;
        r0.w("WindowAnimationComponent", "chatRoot is null");
        r14.invoke(Boolean.TRUE);
        return;
    L25:
        r0.i("WindowAnimationComponent", "isShow is " + this.d);
        laa.d r6 = (laa.d) this.c.i.getValue();
        boolean r7 = false;
        if (r6 == null) goto L28;
        int r8 = r6.mb();
    L29:
        com.obric.common.oea.foundation.animation.builder.b.a r9 = com.obric.common.oea.foundation.animation.builder.c.a(r5);
        AnimationProperty$FloatProperty r10 = AnimationProperty$FloatProperty.ALPHA;
        if (this.d == false) goto L32;
        float r11 = 0.0f;
    L33:
        Float r12 = Float.valueOf(r11);
        if (this.d == false) goto L36;
        float r13 = 1.0f;
    L37:
        com.obric.common.oea.foundation.animation.builder.b.a.c(r9, r10, r12, r13, gja.b.d(Token$Duration.OUI_ANIMATION_DURATION_SHORT_4, Token$Delay.OUI_ANIMATION_DELAY_NONE, Token$Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD));
        final WindowAnimationType r15 = this.b;
        final boolean r16 = this.d;
        Function2<? super Boolean, ? super Throwable, Unit> r17 = new z(r15, r14, r16, r2);
        Intrinsics.checkNotNullParameter(r17, "callback");
        r9.e = r17;
        com.obric.common.oea.foundation.animation.builder.b r18 = r9.a();
        if (this.d == false) goto L51;
        r5.setAlpha(0.0f);
        ObricIntercomComponent r19 = (ObricIntercomComponent) this.c.j.getValue();
        if (r19 != null) goto L42;
    L44:
        if (r7 == false) goto L50;
        va8.l r20 = (va8.l) this.c.l.getValue();
        if (r20 == null) goto L50;
        FrameLayout r21 = r20.getInput();
        if (r21 == null) goto L50;
        r21.setAlpha(0.0f);
    L50:
        r5.setTranslationY(0.0f);
        this.a = com.obric.common.oea.foundation.animation.builder.b.a(r18);
        return;
    L42:
        if (r19.j4() != true) goto L44;
        r7 = true;
        goto L44
    L51:
        this.a = com.obric.common.oea.foundation.animation.builder.b.a(r18);
        r5.setTranslationY(r8);
        va8.l r110 = (va8.l) this.c.l.getValue();
        if (r110 == null) goto L58;
        FrameLayout r111 = r110.getInput();
        if (r111 == null) goto L59;
        r111.setAlpha(1.0f);
        return;
    L59:
        return;
    L58:
        return;
    L36:
        r13 = 0.0f;
        goto L37
    L32:
        r11 = 1.0f;
        goto L33
    L28:
        r8 = 0;
        goto L29
    L18:
        if (this.d == false) goto L21;
    L19:
        r0.i("WindowAnimationComponent", "overlayContainer alpha is " + r2.getAlpha() + ", isShow is " + this.d);
        r14.invoke(Boolean.TRUE);
        return;
    L12:
        if (this.d == false) goto L19;
    L8:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public a0(WindowAnimationType r1, WindowAnimationComponent r2, boolean r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
