package com.obric.aiagent.assistant.idl;

import com.obric.aiagent.ipc.utils.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class m implements g.b<IAgentSkillManagerIDL> {
    public final /* synthetic */ g.b<IAgentSkillManagerIDL> a;

    public m(g.b<IAgentSkillManagerIDL> r1) {
        this.a = r1;
    }

    public final void a(Object r3) {
        IAgentSkillManagerIDL r4 = (IAgentSkillManagerIDL) r3;
        Intrinsics.checkNotNullParameter(r4, "inst");
        g.a.getClass();
        g.e(IAgentSkillManagerIDL.class, this);
        this.a.a(r4);
    }
}
