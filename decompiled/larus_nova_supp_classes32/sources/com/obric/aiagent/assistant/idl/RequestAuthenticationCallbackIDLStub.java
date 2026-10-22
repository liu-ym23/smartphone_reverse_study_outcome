package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001J\t\u0010\n\u001a\u00020\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\bH\u0096\u0001J\t\u0010\f\u001a\u00020\bH\u0096\u0001¨\u0006\r"}, d2 = {"Lcom/obric/aiagent/assistant/idl/RequestAuthenticationCallbackIDLStub;", "Lcom/obric/aiagent/assistant/idl/IRequestAuthenticationCallbackIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IRequestAuthenticationCallbackIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onAuthenticationCancelled", NameKeys.UnloadStrategy_No_Strategy, "onAuthenticationFailed", "onAuthenticationNotAvailable", "onAuthenticationPass", "onAuthenticationTimeout", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class RequestAuthenticationCallbackIDLStub extends IRequestAuthenticationCallbackIDL.Stub {
    private final /* synthetic */ IRequestAuthenticationCallbackIDL $$delegate_0;

    public void onAuthenticationCancelled() {
        this.$$delegate_0.onAuthenticationCancelled();
    }

    public void onAuthenticationFailed() {
        this.$$delegate_0.onAuthenticationFailed();
    }

    public void onAuthenticationNotAvailable() {
        this.$$delegate_0.onAuthenticationNotAvailable();
    }

    public void onAuthenticationPass() {
        this.$$delegate_0.onAuthenticationPass();
    }

    public void onAuthenticationTimeout() {
        this.$$delegate_0.onAuthenticationTimeout();
    }

    public RequestAuthenticationCallbackIDLStub() {
        IRequestAuthenticationCallbackIDL r0 = (IRequestAuthenticationCallbackIDLSPI) ServiceManager.get().getService(IRequestAuthenticationCallbackIDLSPI.class);
        if (r0 != null) goto L6;
        r0 = new IRequestAuthenticationCallbackIDL$Default();
    L6:
        this.$$delegate_0 = r0;
    }

    public IBinder asBinder() {
        return super.asBinder();
    }
}
