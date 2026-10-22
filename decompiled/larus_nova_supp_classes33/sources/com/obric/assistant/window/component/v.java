package com.obric.assistant.window.component;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimator;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.obric.common.oea.foundation.animation.token.Token$Delay;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oea.foundation.animation.token.Token$Easing;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class v implements IWindowAnimator {
    public fja.d a;
    public final /* synthetic */ WindowAnimationType b;
    public final /* synthetic */ WindowAnimationComponent c;
    public final /* synthetic */ boolean d;

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
    public final void cancel() {
        FLogger.a.i("WindowAnimationComponent", "window bottom blur cancel: " + this.b);
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
        r0.i("WindowAnimationComponent", "window bottom blur start " + this.b);
        xha.f r1 = (xha.f) this.c.h.getValue();
        if (r1 == null) goto L16;
        final com.obric.assistant.view.n r2 = r1.FG();
        if (r2 == null) goto L16;
        boolean r3 = this.d;
        float r4 = 1.0f;
        if (r3 == false) goto L10;
        float r5 = 0.0f;
    L11:
        if (r3 == true) goto L14;
        r4 = 0.0f;
    L14:
        r2.setBlurAlpha(r5);
        com.obric.common.oea.foundation.animation.builder.d.a r6 = new com.obric.common.oea.foundation.animation.builder.d.a();
        r6.b(r5, r4, gja.b.d(Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_4, Token$Delay.OUI_ANIMATION_DELAY_NONE, Token$Easing.OUI_ANIMATION_EASING_LINEAR), null);
        Function3<? super String, Object, Object, Unit> r7 = new t(r2);
        Intrinsics.checkNotNullParameter(r7, "callback");
        r6.d = r7;
        final WindowAnimationType r9 = this.b;
        Function2<? super Boolean, ? super Throwable, Unit> r10 = new u(r9, r8);
        Intrinsics.checkNotNullParameter(r10, "callback");
        r6.e = r10;
        this.a = r6.a().a();
        return;
    L10:
        r5 = 1.0f;
    L16:
        r0.w("WindowAnimationComponent", "windowBottomBlurView is null");
        r8.invoke(Boolean.TRUE);
    }

    public v(WindowAnimationType r1, WindowAnimationComponent r2, boolean r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
