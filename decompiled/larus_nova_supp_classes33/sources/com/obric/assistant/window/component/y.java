package com.obric.assistant.window.component;

import android.view.ViewGroup;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimator;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.Token$Delay;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oea.foundation.animation.token.Token$Easing;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class y implements IWindowAnimator {
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
    public final void start(final Function1<? super Boolean, Unit> r8) {
        Intrinsics.checkNotNullParameter(r8, "onEnd");
        FLogger r0 = FLogger.a;
        r0.i("WindowAnimationComponent", "window chat root start " + this.b);
        ViewGroup r1 = (ViewGroup) this.c.m.getValue();
        if (r1 != null) goto L6;
        r0.w("WindowAnimationComponent", "chatRoot is null");
        r8.invoke(Boolean.TRUE);
        return;
    L6:
        float r2 = 0.0f;
        r1.setTranslationY(0.0f);
        if (this.d == false) goto L9;
        float r3 = 0.0f;
    L10:
        r1.setAlpha(r3);
        com.obric.common.oea.foundation.animation.builder.b.a r4 = com.obric.common.oea.foundation.animation.builder.c.a(r1);
        AnimationProperty$FloatProperty r5 = AnimationProperty$FloatProperty.ALPHA;
        if (this.d == false) goto L13;
        float r6 = 0.0f;
    L14:
        Float r7 = Float.valueOf(r6);
        if (this.d == false) goto L17;
        r2 = 1.0f;
    L17:
        com.obric.common.oea.foundation.animation.builder.b.a.c(r4, r5, r7, r2, gja.b.d(Token$Duration.OUI_ANIMATION_DURATION_SHORT_4, Token$Delay.OUI_ANIMATION_DELAY_NONE, Token$Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD));
        final WindowAnimationType r9 = this.b;
        Function2<? super Boolean, ? super Throwable, Unit> r10 = new x(r9, r8);
        Intrinsics.checkNotNullParameter(r10, "callback");
        r4.e = r10;
        this.a = com.obric.common.oea.foundation.animation.builder.b.a(r4.a());
        return;
    L13:
        r6 = 1.0f;
        goto L14
    L9:
        r3 = 1.0f;
        goto L10
    }

    public y(WindowAnimationType r1, WindowAnimationComponent r2, boolean r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
