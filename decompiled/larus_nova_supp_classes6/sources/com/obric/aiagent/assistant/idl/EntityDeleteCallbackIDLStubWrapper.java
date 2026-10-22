package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class EntityDeleteCallbackIDLStubWrapper extends IEntityDeleteCallbackIDL.Stub {
    boolean log;
    final IEntityDeleteCallbackIDL.Stub origin;

    public EntityDeleteCallbackIDLStubWrapper(IEntityDeleteCallbackIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public EntityDeleteCallbackIDLStubWrapper(IEntityDeleteCallbackIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IEntityDeleteCallbackIDL
    public void onResult(int r23, String r24, String[] r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r11 = h.a;
        h.b("EntityDeleteCallbackIDLStub", "onResult(" + r23 + ", " + r24 + ", " + r25 + ")", e);
        IPCException r5 = new IPCException(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r10 = Math.max(0, r20 - r9) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("EntityDeleteCallbackIDLStub", "onResult(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r5, r10);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("EntityDeleteCallbackIDLStub", "onResult", r5, r10, r20);
        throw r5;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("EntityDeleteCallbackIDLStub", "onResult(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onResult(r23, r24, r25);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("EntityDeleteCallbackIDLStub", "onResult = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("EntityDeleteCallbackIDLStub", "onResult(" + r23 + ", " + r24 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("EntityDeleteCallbackIDLStub", "onResult", r12, r21);     // Catch: Exception -> L11
    }
}
