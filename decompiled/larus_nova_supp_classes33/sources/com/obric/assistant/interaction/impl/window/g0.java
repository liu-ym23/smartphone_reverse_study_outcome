package com.obric.assistant.interaction.impl.window;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class g0 implements Function0 {
    public final /* synthetic */ ChatWindowActivity a;
    public final /* synthetic */ String b;

    public /* synthetic */ g0(ChatWindowActivity r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        return WindowHost.H(this.a, this.b);
    }
}
