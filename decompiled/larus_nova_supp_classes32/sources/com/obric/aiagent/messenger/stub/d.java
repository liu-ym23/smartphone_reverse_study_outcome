package com.obric.aiagent.messenger.stub;

import com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class d implements Function1 {
    public /* synthetic */ d() {
    }

    public final Object invoke(Object r2) {
        IFlowOnAppStateChangedListenerIDL r3 = (IFlowOnAppStateChangedListenerIDL) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        r3.onMainBotChatPageResume(false, false);
        return Unit.INSTANCE;
    }
}
