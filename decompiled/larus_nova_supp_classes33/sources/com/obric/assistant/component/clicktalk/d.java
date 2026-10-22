package com.obric.assistant.component.clicktalk;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class d implements Function1 {
    public final /* synthetic */ ChatClickTalkComponent a;

    public /* synthetic */ d(ChatClickTalkComponent r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.bmhome.chat.component.cvs.y$a, com.obric.assistant.component.clicktalk.ChatClickTalkComponent$f] */
    public final Object invoke(Object r6) {
        final ChatClickTalkComponent r0 = this.a;
        final kotlinx.coroutines.i r7 = (kotlinx.coroutines.i) r6;
        int r1 = ChatClickTalkComponent.L0;
        Intrinsics.checkNotNullParameter(r7, "cont");
        final AtomicBoolean r2 = new AtomicBoolean(false);
        final ?? r3 = new ChatClickTalkComponent$f(r0, r2, r7);
        com.larus.bmhome.chat.component.cvs.y r4 = r0.u0();
        if (r4 == null) goto L5;
        r4.ll(new q(), r3);
    L5:
        r7.i(new r(r2, r0, r3));
        return Unit.INSTANCE;
    }
}
