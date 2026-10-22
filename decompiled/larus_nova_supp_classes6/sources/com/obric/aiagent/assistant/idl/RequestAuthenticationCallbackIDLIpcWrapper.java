package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class RequestAuthenticationCallbackIDLIpcWrapper implements IRequestAuthenticationCallbackIDL {
    boolean log;
    final IRequestAuthenticationCallbackIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationCancelled() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationCancelled()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationCancelled() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationCancelled", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationCancelled()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationCancelled()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onAuthenticationCancelled();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationCancelled = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationCancelled() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationCancelled", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationFailed() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationFailed()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationFailed() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationFailed", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationFailed()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationFailed()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onAuthenticationFailed();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationFailed = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationFailed() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationFailed", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationNotAvailable() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationNotAvailable()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationNotAvailable() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationNotAvailable", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationNotAvailable()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationNotAvailable()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onAuthenticationNotAvailable();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationNotAvailable = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationNotAvailable() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationNotAvailable", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationPass() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationPass()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationPass() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationPass", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationPass()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationPass()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onAuthenticationPass();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationPass = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationPass() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationPass", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationTimeout() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationTimeout()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationTimeout() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationTimeout", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationTimeout()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationTimeout()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onAuthenticationTimeout();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationTimeout = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationTimeout() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IRequestAuthenticationCallbackIDLIPC", "onAuthenticationTimeout", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public RequestAuthenticationCallbackIDLIpcWrapper(IRequestAuthenticationCallbackIDL r2) throws RemoteException {
        this(r2, true);
    }

    public RequestAuthenticationCallbackIDLIpcWrapper(IRequestAuthenticationCallbackIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
