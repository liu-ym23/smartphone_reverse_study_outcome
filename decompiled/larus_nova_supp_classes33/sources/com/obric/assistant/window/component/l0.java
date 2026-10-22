package com.obric.assistant.window.component;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimator;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l0 implements IWindowAnimator {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ WindowAnimationType b;
    public final /* synthetic */ WindowDimComponent.BackgroundDimScene c;
    public final /* synthetic */ WindowDimComponent d;

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
    public final void cancel() {
        FLogger.a.i("WindowDimComponent", "window background dim cancel, isShow=" + this.a + ", type=" + this.b + ", scene=" + this.c);
        WindowDimComponent r0 = this.d;
        int r1 = WindowDimComponent.u;
        r0.P2(false);
    }

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
    public final void start(final Function1<? super Boolean, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "onEnd");
        FLogger.a.i("WindowDimComponent", "window background dim start, isShow=" + this.a + ", type=" + this.b + ", scene=" + this.c);
        final WindowDimComponent r0 = this.d;
        final boolean r1 = this.a;
        r0.m = r1;
        final WindowAnimationType r5 = this.b;
        if (r5 != WindowAnimationType.None) goto L6;
        r0.P2(false);
        WindowDimComponent r2 = this.d;
        r2.F2(r2.m3(this.a, this.c));
        r11.invoke(Boolean.TRUE);
        return;
    L6:
        r0.q = true;
        final WindowDimComponent.BackgroundDimScene r3 = this.c;
        r0.z3(r1, r3, new k0(r1, r5, r11, r0, r3));
    }

    public l0(boolean r1, WindowAnimationType r2, WindowDimComponent.BackgroundDimScene r3, WindowDimComponent r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
