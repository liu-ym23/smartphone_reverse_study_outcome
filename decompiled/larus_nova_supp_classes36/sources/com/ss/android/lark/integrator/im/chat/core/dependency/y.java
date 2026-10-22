package com.ss.android.lark.integrator.im.chat.core.dependency;

import com.ss.android.lark.rustinfrabridge.netstate.api.WSConnState;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class y implements h3c.a {
    public y() {
    }

    public final void a(WSConnState.ConnState r4) {
        Iterator r0 = ((CopyOnWriteArrayList) z.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        aqb.d r1 = (aqb.d) r0.next();
        if (r4 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        r1.a(r2);
        goto L4
    L8:
        if (r4 != WSConnState.ConnState.Connected) goto L10;
        r2 = true;
        goto L11
    }
}
