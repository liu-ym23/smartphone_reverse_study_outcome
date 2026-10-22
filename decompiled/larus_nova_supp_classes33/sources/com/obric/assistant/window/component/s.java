package com.obric.assistant.window.component;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimator;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class s implements IWindowAnimator {
    public final /* synthetic */ WindowAnimationType a;
    public final /* synthetic */ WindowAnimationComponent b;
    public final /* synthetic */ boolean c;

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
    public final void cancel() {
        FLogger.a.i("WindowAnimationComponent", "window bottom blur cancel " + this.a);
    }

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
    public final void start(Function1<? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onEnd");
        FLogger r0 = FLogger.a;
        r0.i("WindowAnimationComponent", "window bottom blur start " + this.a);
        xha.f r1 = (xha.f) this.b.h.getValue();
        if (r1 == null) goto L13;
        com.obric.assistant.view.n r2 = r1.FG();
        if (r2 == null) goto L13;
        if (this.c == false) goto L10;
        float r3 = 1.0f;
    L11:
        r2.setBlurAlpha(r3);
        r4.invoke(Boolean.TRUE);
        return;
    L10:
        r3 = 0.0f;
    L13:
        r0.w("WindowAnimationComponent", "windowBottomBlurView is null");
        r4.invoke(Boolean.TRUE);
    }

    public s(WindowAnimationType r1, WindowAnimationComponent r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
