package com.obric.assistant.interaction.impl.window;

import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a0 implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ WindowAnimationType c;

    public /* synthetic */ a0(String r1, String r2, WindowAnimationType r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r4) {
        return WindowHost.h(this.a, this.b, this.c, ((Boolean) r4).booleanValue());
    }
}
