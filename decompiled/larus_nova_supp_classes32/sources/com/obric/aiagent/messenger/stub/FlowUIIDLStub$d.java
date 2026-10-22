package com.obric.aiagent.messenger.stub;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL;
import com.obric.assistant.common.utils.FunctionsKt;
import com.obric.assistant.n4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class FlowUIIDLStub$d implements n4 {
    public final /* synthetic */ IRequestAuthenticationCallbackIDL a;

    @Override // com.obric.assistant.n4
    public final void onAuthenticationCancelled() {
        FLogger.a.i("FlowUIIDLStub", "requestBiometricAuthentication: onAuthenticationCancelled");
        final IRequestAuthenticationCallbackIDL r0 = this.a;
        FunctionsKt.a(new p(r0));
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationFailed() {
        FLogger.a.i("FlowUIIDLStub", "requestBiometricAuthentication: onAuthenticationFailed");
        final IRequestAuthenticationCallbackIDL r0 = this.a;
        FunctionsKt.a(new n(r0));
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationNotAvailable() {
        FLogger.a.i("FlowUIIDLStub", "requestBiometricAuthentication: onAuthenticationNotAvailable");
        final IRequestAuthenticationCallbackIDL r0 = this.a;
        FunctionsKt.a(new q(r0));
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationPass() {
        FLogger.a.i("FlowUIIDLStub", "requestBiometricAuthentication: onAuthenticationPass");
        final IRequestAuthenticationCallbackIDL r0 = this.a;
        FunctionsKt.a(new o(r0));
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationTimeout() {
        FLogger.a.i("FlowUIIDLStub", "requestBiometricAuthentication: onAuthenticationTimeout");
        final IRequestAuthenticationCallbackIDL r0 = this.a;
        FunctionsKt.a(new r(r0));
    }

    public FlowUIIDLStub$d(IRequestAuthenticationCallbackIDL r1) {
        this.a = r1;
    }
}
