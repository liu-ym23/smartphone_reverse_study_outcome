package com.obric.aiagent.assistant.idl;

import com.obric.aiagent.ipc.utils.g;
import com.obric.assistant.network.restrict.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class i implements g.b<IAgentNetworkIDL> {
    public final /* synthetic */ g.b<IAgentNetworkIDL> a;

    public i(b r1) {
        this.a = r1;
    }

    public final void a(Object r3) {
        IAgentNetworkIDL r4 = (IAgentNetworkIDL) r3;
        Intrinsics.checkNotNullParameter(r4, "inst");
        g.a.getClass();
        g.e(IAgentNetworkIDL.class, this);
        this.a.a(r4);
    }
}
