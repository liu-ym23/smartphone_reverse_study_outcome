package com.obric.assistant.component.clicktalk;

import com.obric.assistant.audio.service.IdleQuiteServiceDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ ChatClickTalkComponent a;

    public /* synthetic */ f(ChatClickTalkComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        ChatClickTalkComponent r0 = this.a;
        String r5 = (String) r4;
        int r1 = ChatClickTalkComponent.L0;
        Intrinsics.checkNotNullParameter(r5, "botId");
        IdleQuiteServiceDelegate r2 = IdleQuiteServiceDelegate.b;
        r2.a(r5, "closeClickTalk");
        r2.c(r0.H0);
        return Unit.INSTANCE;
    }
}
