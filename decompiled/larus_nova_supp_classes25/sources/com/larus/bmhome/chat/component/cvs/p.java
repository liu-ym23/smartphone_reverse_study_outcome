package com.larus.bmhome.chat.component.cvs;

import kotlin.jvm.functions.Function1;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p implements Function1 {
    public final /* synthetic */ e a;
    public final /* synthetic */ String b;

    public /* synthetic */ p(e r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        return ChatConversationVM.To(this.a, this.b, (ChatConversationVMState) r3);
    }
}
