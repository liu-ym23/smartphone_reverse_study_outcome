package com.obric.assistant.interaction.impl.window;

import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class m1 implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ WindowAnimationType b;

    public /* synthetic */ m1(String r1, WindowAnimationType r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        return WindowHost.T(this.a, this.b);
    }
}
