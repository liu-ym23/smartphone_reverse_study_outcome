package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class PlatformApiIDLStubWrapper extends IPlatformApiIDL.Stub {
    boolean log;
    final IPlatformApiIDL.Stub origin;

    public PlatformApiIDLStubWrapper(IPlatformApiIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public PlatformApiIDLStubWrapper(IPlatformApiIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    public boolean moveTaskToDisplay(int r26, int r27, boolean r28) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r11 = h.a;
        h.b("PlatformApiIDLStub", "moveTaskToDisplay(" + r26 + ", " + r27 + ", " + r28 + ")", e);
        IPCException r5 = new IPCException(e);
        long r23 = SystemClock.elapsedRealtimeNanos();
        long r10 = Math.max(0, r23 - r9) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("PlatformApiIDLStub", "moveTaskToDisplay(" + r26 + ", " + r27 + ", " + r28 + ") = fail", r5, r10);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("PlatformApiIDLStub", "moveTaskToDisplay", r5, r10, r23);
        throw r5;
    L4:
        if (this.log == false) goto L6;
        int r15 = h.a;     // Catch: Exception -> L11
        h.c("PlatformApiIDLStub", "moveTaskToDisplay(" + r26 + ", " + r27 + ", " + r28 + ")");     // Catch: Exception -> L11
    L6:
        boolean r16 = this.origin.moveTaskToDisplay(r26, r27, r28);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("PlatformApiIDLStub", "moveTaskToDisplay = " + r16);     // Catch: Exception -> L11
    L9:
        long r24 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r24 - r9) / 1000;     // Catch: Exception -> L11
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("PlatformApiIDLStub", "moveTaskToDisplay(" + r26 + ", " + r27 + ", " + r28 + ") = " + r16, r13);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("PlatformApiIDLStub", "moveTaskToDisplay", r13, r24);     // Catch: Exception -> L11
        return r16;
    }

    public List<String> getTasksPackages(int r26, boolean r27, boolean r28, int r29) throws RemoteException {
        long r10 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r1 = h.a;
        h.b("PlatformApiIDLStub", "getTasksPackages(" + r26 + ", " + r27 + ", " + r28 + ", " + r29 + ")", e);
        IPCException r2 = new IPCException(e);
        long r23 = SystemClock.elapsedRealtimeNanos();
        long r11 = Math.max(0, r23 - r10) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("PlatformApiIDLStub", "getTasksPackages(" + r26 + ", " + r27 + ", " + r28 + ", " + r29 + ") = fail", r2, r11);
        IPCAnomalyTrace r3 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("PlatformApiIDLStub", "getTasksPackages", r2, r11, r23);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        int r12 = h.a;     // Catch: Exception -> L11
        h.c("PlatformApiIDLStub", "getTasksPackages(" + r26 + ", " + r27 + ", " + r28 + ", " + r29 + ")");     // Catch: Exception -> L11
    L6:
        List<String> r13 = this.origin.getTasksPackages(r26, r27, r28, r29);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r14 = h.a;     // Catch: Exception -> L11
        h.d("PlatformApiIDLStub", "getTasksPackages = " + r13);     // Catch: Exception -> L11
    L9:
        long r24 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r4 = Math.max(0, r24 - r10) / 1000;     // Catch: Exception -> L11
        int r15 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("PlatformApiIDLStub", "getTasksPackages(" + r26 + ", " + r27 + ", " + r28 + ", " + r29 + ") = " + r13, r4);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("PlatformApiIDLStub", "getTasksPackages", r4, r24);     // Catch: Exception -> L11
        return r13;
    }
}
