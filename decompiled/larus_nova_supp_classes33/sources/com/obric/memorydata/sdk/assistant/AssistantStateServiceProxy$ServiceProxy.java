package com.obric.memorydata.sdk.assistant;

import android.os.IBinder;
import android.os.RemoteException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/sdk/assistant/AssistantStateServiceProxy$ServiceProxy;", "Lcom/obric/memorydata/sdk/assistant/IAssistantStateService;", "service", "<init>", "(Lcom/obric/memorydata/sdk/assistant/IAssistantStateService;)V", "getService", "()Lcom/obric/memorydata/sdk/assistant/IAssistantStateService;", "asBinder", "Landroid/os/IBinder;", "onActive", "", "onQuery", "queryContext", "Lcom/obric/memorydata/sdk/assistant/QueryContext;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AssistantStateServiceProxy$ServiceProxy implements IAssistantStateService {
    private final IAssistantStateService service;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.service.asBinder();
    L4:
        return null;
    }

    @Override // com.obric.memorydata.sdk.assistant.IAssistantStateService
    public void onActive() {
        this.service.onActive();     // Catch: RemoteException -> L4
        return;
    }

    public final IAssistantStateService getService() {
        return this.service;
    }

    public AssistantStateServiceProxy$ServiceProxy(IAssistantStateService r2) {
        Intrinsics.checkNotNullParameter(r2, "service");
        this.service = r2;
    }

    @Override // com.obric.memorydata.sdk.assistant.IAssistantStateService
    public void onQuery(QueryContext r2) {
        Intrinsics.checkNotNullParameter(r2, "queryContext");
        this.service.onQuery(r2);     // Catch: RemoteException -> L5
        return;
    }
}
