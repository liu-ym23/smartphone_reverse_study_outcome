package com.larus.voicecall.impl.continue_talk;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class j implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ChatContinuousTalkComponent c;

    public /* synthetic */ j(String r1, String r2, ChatContinuousTalkComponent r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        String r1 = this.a;
        String r2 = this.b;
        ChatContinuousTalkComponent r7 = this.c;
        int r0 = ChatContinuousTalkComponent.M;
        r7.ai(new xa8.e(r1, r2, null, null, false, 28));
        return Unit.INSTANCE;
    }
}
