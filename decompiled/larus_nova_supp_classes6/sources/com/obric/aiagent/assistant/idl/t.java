package com.obric.aiagent.assistant.idl;

import com.obric.aiagent.ipc.utils.g;
import com.obric.assistant.utils.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class t implements g.b<IAgentVoiceInteractionIDL> {
    public final /* synthetic */ g.b<IAgentVoiceInteractionIDL> a;

    public t(a r1) {
        this.a = r1;
    }

    public final void a(Object r3) {
        IAgentVoiceInteractionIDL r4 = (IAgentVoiceInteractionIDL) r3;
        Intrinsics.checkNotNullParameter(r4, "inst");
        g.a.getClass();
        g.e(IAgentVoiceInteractionIDL.class, this);
        this.a.a(r4);
    }
}
