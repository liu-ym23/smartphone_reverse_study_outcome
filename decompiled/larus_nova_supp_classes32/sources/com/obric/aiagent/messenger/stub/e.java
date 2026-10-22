package com.obric.aiagent.messenger.stub;

import com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class e implements Function1 {
    public final /* synthetic */ boolean a;

    public /* synthetic */ e(boolean r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        boolean r0 = this.a;
        IFlowOnAppStateChangedListenerIDL r4 = (IFlowOnAppStateChangedListenerIDL) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        r4.onMainBotChatPageResume(true, r0);
        return Unit.INSTANCE;
    }
}
