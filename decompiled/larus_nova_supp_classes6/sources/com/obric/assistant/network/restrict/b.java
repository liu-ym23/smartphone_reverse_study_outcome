package com.obric.assistant.network.restrict;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentNetworkIDL;
import com.obric.aiagent.assistant.idl.bean.RequestRestrictRule;
import com.obric.aiagent.ipc.utils.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class b implements g.b {
    public final /* synthetic */ RequestRestrictRule a;

    public /* synthetic */ b(RequestRestrictRule r1) {
        this.a = r1;
    }

    public final void a(Object r5) {
        RequestRestrictRule r0 = this.a;
        FLogger.a.i("ObricAIagentNetworkConfigManager", "IPC registered, update rules");
        ((IAgentNetworkIDL) r5).updateExcludeRules(r0);
    }
}
