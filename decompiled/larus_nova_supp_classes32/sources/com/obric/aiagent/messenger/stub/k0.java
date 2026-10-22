package com.obric.aiagent.messenger.stub;

import com.obric.aiagent.assistant.idl.IFlowFrontierDataListenerIDL;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class k0 implements Function1 {
    public final /* synthetic */ byte[] a;

    public /* synthetic */ k0(byte[] r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return FrontierIDLStub.a(this.a, (IFlowFrontierDataListenerIDL) r2);
    }
}
