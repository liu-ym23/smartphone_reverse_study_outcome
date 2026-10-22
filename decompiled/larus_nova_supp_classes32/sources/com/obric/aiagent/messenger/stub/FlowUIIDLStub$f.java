package com.obric.aiagent.messenger.stub;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL;
import com.obric.assistant.common.utils.FunctionsKt;
import com.obric.assistant.n4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class FlowUIIDLStub$f implements n4 {
    public final /* synthetic */ IRequestAuthenticationCallbackIDL a;

    @Override // com.obric.assistant.n4
    public final void onAuthenticationCancelled() {
        FLogger.a.i("FlowUIIDLStub", "requestVoicePrintAuthentication: onAuthenticationCancelled");
        final IRequestAuthenticationCallbackIDL r0 = this.a;
        FunctionsKt.a(new y(r0));
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationFailed() {
        FLogger.a.i("FlowUIIDLStub", "requestVoicePrintAuthentication: onAuthenticationFailed");
        final IRequestAuthenticationCallbackIDL r0 = this.a;
        FunctionsKt.a(new z(r0));
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationNotAvailable() {
        FLogger.a.i("FlowUIIDLStub", "requestVoicePrintAuthentication: onAuthenticationNotAvailable");
        final IRequestAuthenticationCallbackIDL r0 = this.a;
        FunctionsKt.a(new a0(r0));
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationPass() {
        FLogger.a.i("FlowUIIDLStub", "requestVoicePrintAuthentication: onAuthenticationPass");
        final IRequestAuthenticationCallbackIDL r0 = this.a;
        FunctionsKt.a(new x(r0));
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationTimeout() {
        FLogger.a.i("FlowUIIDLStub", "requestVoicePrintAuthentication: onAuthenticationTimeout");
        final IRequestAuthenticationCallbackIDL r0 = this.a;
        FunctionsKt.a(new b0(r0));
    }

    public FlowUIIDLStub$f(IRequestAuthenticationCallbackIDL r1) {
        this.a = r1;
    }
}
