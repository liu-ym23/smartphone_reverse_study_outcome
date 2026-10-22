package com.obric.assistant.interaction.impl.window;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class r1 implements Function1 {
    public final /* synthetic */ AssistantChatDialog a;

    public /* synthetic */ r1(AssistantChatDialog r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return WindowHost.l(this.a, ((Boolean) r2).booleanValue());
    }
}
