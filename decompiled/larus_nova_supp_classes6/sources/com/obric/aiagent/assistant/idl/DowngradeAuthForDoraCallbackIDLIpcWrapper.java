package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class DowngradeAuthForDoraCallbackIDLIpcWrapper implements IDowngradeAuthForDoraCallbackIDL {
    boolean log;
    final IDowngradeAuthForDoraCallbackIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onDowngradeToNoneAuth() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onDowngradeToNoneAuth();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onDowngradeToVoicePrint() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onDowngradeToVoicePrint();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onNotDowngrade() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onNotDowngrade();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public DowngradeAuthForDoraCallbackIDLIpcWrapper(IDowngradeAuthForDoraCallbackIDL r2) throws RemoteException {
        this(r2, true);
    }

    public DowngradeAuthForDoraCallbackIDLIpcWrapper(IDowngradeAuthForDoraCallbackIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
