package com.obric.assistant.window.component;

import android.view.ViewGroup;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimator;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class w implements IWindowAnimator {
    public final /* synthetic */ WindowAnimationType a;
    public final /* synthetic */ WindowAnimationComponent b;
    public final /* synthetic */ boolean c;

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
    public final void cancel() {
        FLogger.a.i("WindowAnimationComponent", "window chat root cancel " + this.a);
    }

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
    public final void start(Function1<? super Boolean, Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "onEnd");
        FLogger r0 = FLogger.a;
        r0.i("WindowAnimationComponent", "window chat root start " + this.a);
        ViewGroup r1 = (ViewGroup) this.b.m.getValue();
        if (r1 != null) goto L6;
        r0.w("WindowAnimationComponent", "chatRoot is null");
        r7.invoke(Boolean.TRUE);
        return;
    L6:
        float r4 = 0.0f;
        r1.setTranslationY(0.0f);
        if (this.c == false) goto L9;
        r4 = 1.0f;
    L9:
        r1.setAlpha(r4);
        r7.invoke(Boolean.TRUE);
        r0.i("WindowAnimationComponent", "window chat root start " + this.a + " end");
    }

    public w(WindowAnimationType r1, WindowAnimationComponent r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
