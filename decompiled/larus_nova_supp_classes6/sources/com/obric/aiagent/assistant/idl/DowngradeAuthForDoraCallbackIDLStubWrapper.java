package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class DowngradeAuthForDoraCallbackIDLStubWrapper extends IDowngradeAuthForDoraCallbackIDL.Stub {
    boolean log;
    final IDowngradeAuthForDoraCallbackIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onDowngradeToNoneAuth() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth()");     // Catch: Exception -> L11
    L6:
        this.origin.onDowngradeToNoneAuth();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth", r14, r16);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onDowngradeToVoicePrint() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint()");     // Catch: Exception -> L11
    L6:
        this.origin.onDowngradeToVoicePrint();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint", r14, r16);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onNotDowngrade() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade()");     // Catch: Exception -> L11
    L6:
        this.origin.onNotDowngrade();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade", r14, r16);     // Catch: Exception -> L11
    }

    public DowngradeAuthForDoraCallbackIDLStubWrapper(IDowngradeAuthForDoraCallbackIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public DowngradeAuthForDoraCallbackIDLStubWrapper(IDowngradeAuthForDoraCallbackIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
