package com.obric.aiagent.messenger.stub;

import com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class k implements Function0 {
    public final /* synthetic */ IRequestAuthenticationCallbackIDL a;

    public /* synthetic */ k(IRequestAuthenticationCallbackIDL r1) {
        this.a = r1;
    }

    public final Object invoke() {
        return FlowUIIDLStub.i(this.a);
    }
}
