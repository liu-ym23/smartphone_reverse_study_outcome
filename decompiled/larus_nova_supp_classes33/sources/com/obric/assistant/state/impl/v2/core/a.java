package com.obric.assistant.state.impl.v2.core;

import com.obric.aiagent.assistant.idl.IFlowNightModeChangeListenerIDL;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ int a;

    public /* synthetic */ a(int r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return ObricStateIDLStub.d(this.a, (IFlowNightModeChangeListenerIDL) r2);
    }
}
