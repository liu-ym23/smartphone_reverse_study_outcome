package com.obric.assistant.component;

import com.obric.assistant.chat.IObricChatService;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class p6 implements Function0 {
    public /* synthetic */ p6() {
    }

    public final Object invoke() {
        int r0 = OrionInstructionComponent.p1;
        IObricChatService.a.getClass();
        IObricChatService r1 = IObricChatService.a.a();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.h();
    }
}
