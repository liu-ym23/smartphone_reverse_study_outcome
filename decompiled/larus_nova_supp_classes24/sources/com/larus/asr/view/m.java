package com.larus.asr.view;

import com.larus.common.apphost.AppHost;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class m implements Function1 {
    public final /* synthetic */ ChatSpeaker a;

    public /* synthetic */ m(ChatSpeaker r1) {
        this.a = r1;
    }

    public final Object invoke(Object r8) {
        ChatSpeaker r6 = this.a;
        if (((Boolean) r8).booleanValue() == false) goto L5;
        r6.w = true;
        ChatSpeaker.N8(r6, false, AppHost.a.getApplication().getResources().getString(2131911051), false, null, 12);
        r6.R7(null);
    L7:
        return Unit.INSTANCE;
    L5:
        int r9 = ChatSpeaker.T;
        goto L7
    }
}
