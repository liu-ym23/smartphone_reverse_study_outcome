package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class RequestAuthenticationCallbackIDLStubWrapper extends IRequestAuthenticationCallbackIDL.Stub {
    boolean log;
    final IRequestAuthenticationCallbackIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationCancelled() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled()");     // Catch: Exception -> L11
    L6:
        this.origin.onAuthenticationCancelled();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled", r14, r16);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationFailed() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed()");     // Catch: Exception -> L11
    L6:
        this.origin.onAuthenticationFailed();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed", r14, r16);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationNotAvailable() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable()");     // Catch: Exception -> L11
    L6:
        this.origin.onAuthenticationNotAvailable();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable", r14, r16);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationPass() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass()");     // Catch: Exception -> L11
    L6:
        this.origin.onAuthenticationPass();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass", r14, r16);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationTimeout() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout()");     // Catch: Exception -> L11
    L6:
        this.origin.onAuthenticationTimeout();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout", r14, r16);     // Catch: Exception -> L11
    }

    public RequestAuthenticationCallbackIDLStubWrapper(IRequestAuthenticationCallbackIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public RequestAuthenticationCallbackIDLStubWrapper(IRequestAuthenticationCallbackIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
