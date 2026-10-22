package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class ObricActionResultCallbackIDLStubWrapper extends IObricActionResultCallbackIDL.Stub {
    boolean log;
    final IObricActionResultCallbackIDL.Stub origin;

    public ObricActionResultCallbackIDLStubWrapper(IObricActionResultCallbackIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public ObricActionResultCallbackIDLStubWrapper(IObricActionResultCallbackIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IObricActionResultCallbackIDL
    public void onResult(boolean r23, String r24, String r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r11 = h.a;
        h.b("ObricActionResultCallbackIDLStub", "onResult(" + r23 + ", " + r24 + ", " + r25 + ")", e);
        IPCException r5 = new IPCException(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r10 = Math.max(0, r20 - r9) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("ObricActionResultCallbackIDLStub", "onResult(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r5, r10);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("ObricActionResultCallbackIDLStub", "onResult", r5, r10, r20);
        throw r5;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("ObricActionResultCallbackIDLStub", "onResult(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onResult(r23, r24, r25);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("ObricActionResultCallbackIDLStub", "onResult = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("ObricActionResultCallbackIDLStub", "onResult(" + r23 + ", " + r24 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("ObricActionResultCallbackIDLStub", "onResult", r12, r21);     // Catch: Exception -> L11
    }
}
