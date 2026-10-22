package com.obric.assistant.component.clicktalk;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g0 implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e> {
    public final /* synthetic */ ChatClickTalkComponent a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ kotlinx.coroutines.i<wc9.e> c;

    public final void c(Object r4) {
        wc9.e r5 = (wc9.e) r4;
        Intrinsics.checkNotNullParameter(r5, "new");
        ChatClickTalkComponent r0 = this.a;
        int r1 = ChatClickTalkComponent.L0;
        com.larus.bmhome.chat.component.cvs.y r2 = r0.u0();
        if (r2 == null) goto L6;
        r2.lQ(this);
    L6:
        if (this.b.compareAndSet(false, true) == false) goto L9;
        this.c.resumeWith(Result.constructor-impl(r5));
        return;
    }

    public g0(ChatClickTalkComponent r1, AtomicBoolean r2, kotlinx.coroutines.i<? super wc9.e> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
