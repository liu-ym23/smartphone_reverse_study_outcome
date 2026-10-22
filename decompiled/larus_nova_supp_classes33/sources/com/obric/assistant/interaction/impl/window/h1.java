package com.obric.assistant.interaction.impl.window;

import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class h1 implements Function0 {
    public final /* synthetic */ WindowAnimationType a;

    public /* synthetic */ h1(WindowAnimationType r1) {
        this.a = r1;
    }

    public final Object invoke() {
        return WindowHost.p(this.a);
    }
}
