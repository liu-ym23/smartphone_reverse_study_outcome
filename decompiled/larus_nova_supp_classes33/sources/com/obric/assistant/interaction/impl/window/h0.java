package com.obric.assistant.interaction.impl.window;

import com.obric.assistant.data.ObricFloatChatPageState;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class h0 implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ObricFloatChatPageState c;

    public /* synthetic */ h0(String r1, int r2, ObricFloatChatPageState r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        return WindowHost.j(this.a, this.b, this.c);
    }
}
