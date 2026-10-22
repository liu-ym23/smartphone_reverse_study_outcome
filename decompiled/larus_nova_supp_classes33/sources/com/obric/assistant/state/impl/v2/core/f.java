package com.obric.assistant.state.impl.v2.core;

import com.obric.aiagent.assistant.idl.IFlowAssistantTTSStateListenerIDL;
import com.obric.aiagent.assistant.idl.bean.TtsInfo;
import com.obric.assistant.state.api.v2.core.bean.ObricTtsInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ ObricTtsInfo a;
    public final /* synthetic */ int b;

    public /* synthetic */ f(ObricTtsInfo r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        ObricTtsInfo r0 = this.a;
        int r1 = this.b;
        IFlowAssistantTTSStateListenerIDL r5 = (IFlowAssistantTTSStateListenerIDL) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        r5.onChanged(new TtsInfo(r0.getMsgId(), Integer.valueOf(r1)));
        return Unit.INSTANCE;
    }
}
