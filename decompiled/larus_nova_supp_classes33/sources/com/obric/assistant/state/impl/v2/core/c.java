package com.obric.assistant.state.impl.v2.core;

import com.obric.aiagent.assistant.idl.IFlowAssistantActiveStateListenerIDL;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ ObricStateIDLStub a;

    public /* synthetic */ c(ObricStateIDLStub r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return ObricStateIDLStub.b(this.a, (IFlowAssistantActiveStateListenerIDL) r2);
    }
}
