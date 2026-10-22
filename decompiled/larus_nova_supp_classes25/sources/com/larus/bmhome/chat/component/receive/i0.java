package com.larus.bmhome.chat.component.receive;

import hq9.j4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i0 implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e> {
    public final /* synthetic */ ChatReceiveServiceComponent a;
    public final /* synthetic */ j4 b;

    public final void c(Object r3) {
        wc9.e r4 = (wc9.e) r3;
        Intrinsics.checkNotNullParameter(r4, "new");
        ChatReceiveServiceComponent r0 = this.a;
        int r1 = ChatReceiveServiceComponent.x;
        com.larus.bmhome.chat.component.cvs.y r2 = r0.u0();
        if (r2 == null) goto L5;
        r2.lQ(this);
    L5:
        ChatReceiveServiceComponent r5 = this.a;
        j4 r6 = this.b;
        Intrinsics.checkNotNull(r6);
        r5.h3(r4, r6);
    }

    public i0(ChatReceiveServiceComponent r1, j4 r2) {
        this.a = r1;
        this.b = r2;
    }
}
