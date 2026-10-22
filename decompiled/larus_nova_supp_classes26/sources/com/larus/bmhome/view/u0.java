package com.larus.bmhome.view;

import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class u0 implements Function0 {
    public final /* synthetic */ ChatMessageList a;
    public final /* synthetic */ int b;

    public /* synthetic */ u0(ChatMessageList r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        ChatMessageList r0 = this.a;
        int r1 = this.b;
        Lazy r2 = ChatMessageList.V0;
        r0.e(r1);
        return Unit.INSTANCE;
    }
}
