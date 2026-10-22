package com.larus.bmhome.chat.component.cvs;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i implements Function2 {
    public final /* synthetic */ Function2 a;

    public /* synthetic */ i(Function2 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4) {
        Function2 r0 = this.a;
        ChatConversationVMState r5 = (ChatConversationVMState) r3;
        ChatConversationVMState r6 = (ChatConversationVMState) r4;
        int r1 = ChatConversationComponent.r;
        Intrinsics.checkNotNullParameter(r5, "old");
        Intrinsics.checkNotNullParameter(r6, "new");
        return Boolean.valueOf(((Boolean) r0.invoke(r5.getConversation(), r6.getConversation())).booleanValue());
    }
}
