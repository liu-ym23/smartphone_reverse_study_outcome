package com.obric.aiagent.messenger.stub;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL;
import com.obric.assistant.common.utils.FunctionsKt;
import com.obric.assistant.n4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class FlowUIIDLStub$e implements n4 {
    public final /* synthetic */ IRequestAuthenticationCallbackIDL a;

    @Override // com.obric.assistant.n4
    public final void onAuthenticationCancelled() {
        FLogger.a.i("FlowUIIDLStub", "requestDeviceCredentialAuthentication: onAuthenticationCancelled");
        final IRequestAuthenticationCallbackIDL r0 = this.a;
        FunctionsKt.a(new v(r0));
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationFailed() {
        FLogger.a.i("FlowUIIDLStub", "requestDeviceCredentialAuthentication: onAuthenticationFailed");
        final IRequestAuthenticationCallbackIDL r0 = this.a;
        FunctionsKt.a(new u(r0));
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationNotAvailable() {
        FLogger.a.i("FlowUIIDLStub", "requestDeviceCredentialAuthentication: onAuthenticationNotAvailable");
        final IRequestAuthenticationCallbackIDL r0 = this.a;
        FunctionsKt.a(new s(r0));
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationPass() {
        FLogger.a.i("FlowUIIDLStub", "requestDeviceCredentialAuthentication: onAuthenticationPass");
        final IRequestAuthenticationCallbackIDL r0 = this.a;
        FunctionsKt.a(new w(r0));
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationTimeout() {
        FLogger.a.i("FlowUIIDLStub", "requestDeviceCredentialAuthentication: onAuthenticationTimeout");
        final IRequestAuthenticationCallbackIDL r0 = this.a;
        FunctionsKt.a(new t(r0));
    }

    public FlowUIIDLStub$e(IRequestAuthenticationCallbackIDL r1) {
        this.a = r1;
    }
}
