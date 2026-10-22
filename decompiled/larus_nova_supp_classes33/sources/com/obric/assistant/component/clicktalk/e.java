package com.obric.assistant.component.clicktalk;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class e implements Function1 {
    public final /* synthetic */ ChatClickTalkComponent a;

    public /* synthetic */ e(ChatClickTalkComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r6) {
        final ChatClickTalkComponent r0 = this.a;
        kotlinx.coroutines.i r7 = (kotlinx.coroutines.i) r6;
        int r1 = ChatClickTalkComponent.L0;
        Intrinsics.checkNotNullParameter(r7, "cont");
        final AtomicBoolean r2 = new AtomicBoolean(false);
        final g0 r3 = new g0(r0, r2, r7);
        com.larus.bmhome.chat.component.cvs.y r4 = r0.u0();
        if (r4 == null) goto L5;
        r4.rh(new o(), r3);
    L5:
        r7.i(new p(r2, r0, r3));
        return Unit.INSTANCE;
    }
}
