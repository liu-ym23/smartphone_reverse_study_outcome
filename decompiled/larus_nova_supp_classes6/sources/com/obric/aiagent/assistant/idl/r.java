package com.obric.aiagent.assistant.idl;

import com.obric.aiagent.ipc.utils.g;
import com.obric.assistant.special_input.instruction.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class r implements g.b<IAgentTaskAppIDL> {
    public final /* synthetic */ g.b<IAgentTaskAppIDL> a;

    public r(b r1) {
        this.a = r1;
    }

    public final void a(Object r3) {
        IAgentTaskAppIDL r4 = (IAgentTaskAppIDL) r3;
        Intrinsics.checkNotNullParameter(r4, "inst");
        g.a.getClass();
        g.e(IAgentTaskAppIDL.class, this);
        this.a.a(r4);
    }
}
