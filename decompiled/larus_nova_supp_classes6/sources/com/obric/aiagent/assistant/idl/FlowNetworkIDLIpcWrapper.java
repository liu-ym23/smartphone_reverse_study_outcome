package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.OPushEvent;
import com.obric.aiagent.assistant.idl.bean.ObricConditionalTaskSweepRequest;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowNetworkIDLIpcWrapper implements IFlowNetworkIDL {
    boolean log;
    final IFlowNetworkIDL origin;

    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public int getCurrentNetworkStatus() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        int r11 = 0;
    L14:
        e = move-exception;
        h.b("IFlowNetworkIDLIPC", "getCurrentNetworkStatus()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowNetworkIDLIPC", "getCurrentNetworkStatus() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowNetworkIDLIPC", "getCurrentNetworkStatus", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowNetworkIDLIPC", "getCurrentNetworkStatus()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowNetworkIDLIPC", "getCurrentNetworkStatus()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getCurrentNetworkStatus();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowNetworkIDLIPC", "getCurrentNetworkStatus = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowNetworkIDLIPC", "getCurrentNetworkStatus() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowNetworkIDLIPC", "getCurrentNetworkStatus", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public FlowNetworkIDLIpcWrapper(IFlowNetworkIDL r2) throws RemoteException {
        this(r2, true);
    }

    public void notifyStopComplexTaskByHttp(long r23) throws RemoteException {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r13 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttp(" + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r15 = new IPCException(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r8 = Math.max(0, r18 - r7) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttp(" + r23 + ") = fail", r15, r8);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttp", r15, r8, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttp(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttp(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyStopComplexTaskByHttp(r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttp = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r19 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttp(" + r23 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttp", r14, r19);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public FlowNetworkIDLIpcWrapper(IFlowNetworkIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    public void clearOmniTasks(Map r22, IFlowNetworkResultCallbackIDL r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowNetworkIDLIPC", "clearOmniTasks(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowNetworkIDLIPC", "clearOmniTasks(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowNetworkIDLIPC", "clearOmniTasks", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowNetworkIDLIPC", "clearOmniTasks(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("clearOmniTasks(");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r22);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r14 = r23;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowNetworkIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r23 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L20;
        if ((r23 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L20;
        if ((r23 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L19;
        r14 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = u2.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowNetworkIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L26;
    L34:
        IFlowNetworkResultCallbackIDL r15 = r23;
    L35:
        r6.clearOmniTasks(r22, r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowNetworkIDLIPC", "clearOmniTasks = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowNetworkIDLIPC", "clearOmniTasks(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowNetworkIDLIPC", "clearOmniTasks", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r23 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L34;
        if ((r23 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L34;
        if ((r23 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L33;
        r15 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = u2.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void notifyStopComplexTaskByHttpWithScene(long r23, String r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r11 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttpWithScene(" + r23 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r10 = Math.max(0, r20 - r9) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttpWithScene(" + r23 + ", " + r25 + ") = fail", r5, r10);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttpWithScene", r5, r10, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttpWithScene(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttpWithScene(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyStopComplexTaskByHttpWithScene(r23, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttpWithScene = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttpWithScene(" + r23 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttpWithScene", r12, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void notifyUserOperateQueue(String r22, IFlowNetworkResultCallbackIDL r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowNetworkIDLIPC", "notifyUserOperateQueue(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowNetworkIDLIPC", "notifyUserOperateQueue(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowNetworkIDLIPC", "notifyUserOperateQueue", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowNetworkIDLIPC", "notifyUserOperateQueue(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("notifyUserOperateQueue(");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r22);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r14 = r23;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowNetworkIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r23 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L20;
        if ((r23 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L20;
        if ((r23 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L19;
        r14 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = u2.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowNetworkIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L26;
    L34:
        IFlowNetworkResultCallbackIDL r15 = r23;
    L35:
        r6.notifyUserOperateQueue(r22, r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowNetworkIDLIPC", "notifyUserOperateQueue = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowNetworkIDLIPC", "notifyUserOperateQueue(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowNetworkIDLIPC", "notifyUserOperateQueue", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r23 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L34;
        if ((r23 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L34;
        if ((r23 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L33;
        r15 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = u2.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void sweepConditionalTask(ObricConditionalTaskSweepRequest r22, IFlowNetworkResultCallbackIDL r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowNetworkIDLIPC", "sweepConditionalTask(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowNetworkIDLIPC", "sweepConditionalTask(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowNetworkIDLIPC", "sweepConditionalTask", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowNetworkIDLIPC", "sweepConditionalTask(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("sweepConditionalTask(");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r22);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r14 = r23;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowNetworkIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r23 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L20;
        if ((r23 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L20;
        if ((r23 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L19;
        r14 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = u2.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowNetworkIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L26;
    L34:
        IFlowNetworkResultCallbackIDL r15 = r23;
    L35:
        r6.sweepConditionalTask(r22, r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowNetworkIDLIPC", "sweepConditionalTask = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowNetworkIDLIPC", "sweepConditionalTask(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowNetworkIDLIPC", "sweepConditionalTask", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r23 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L34;
        if ((r23 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L34;
        if ((r23 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L33;
        r15 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = u2.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void deleteConditionalTask(String r23, Map r24, IFlowNetworkResultCallbackIDL r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r11 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowNetworkIDLIPC", "deleteConditionalTask(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L43
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L43
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r10 = Math.max(0, r20 - r9) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowNetworkIDLIPC", "deleteConditionalTask(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r5, r10);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowNetworkIDLIPC", "deleteConditionalTask", r5, r10, r20);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowNetworkIDLIPC", "deleteConditionalTask(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("deleteConditionalTask(");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r23);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r24);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r25 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r15 = r25;
    L21:
        r4.append(r15);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowNetworkIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r25 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L20;
        if ((r25 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L20;
        if ((r25 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L19;
        r15 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r25);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = u2.b(r25);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowNetworkIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r25 != null) goto L26;
    L34:
        IFlowNetworkResultCallbackIDL r16 = r25;
    L35:
        r6.deleteConditionalTask(r23, r24, r16);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowNetworkIDLIPC", "deleteConditionalTask = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowNetworkIDLIPC", "deleteConditionalTask(" + r23 + ", " + r24 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowNetworkIDLIPC", "deleteConditionalTask", r12, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r25 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L34;
        if ((r25 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L34;
        if ((r25 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L33;
        r16 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r25);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r16 = u2.b(r25);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void notifyStopOmniTaskByHttp(String r23, Map r24, IFlowNetworkResultCallbackIDL r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r11 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowNetworkIDLIPC", "notifyStopOmniTaskByHttp(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L43
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L43
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r10 = Math.max(0, r20 - r9) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowNetworkIDLIPC", "notifyStopOmniTaskByHttp(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r5, r10);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowNetworkIDLIPC", "notifyStopOmniTaskByHttp", r5, r10, r20);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowNetworkIDLIPC", "notifyStopOmniTaskByHttp(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("notifyStopOmniTaskByHttp(");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r23);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r24);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r25 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r15 = r25;
    L21:
        r4.append(r15);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowNetworkIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r25 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L20;
        if ((r25 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L20;
        if ((r25 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L19;
        r15 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r25);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = u2.b(r25);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowNetworkIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r25 != null) goto L26;
    L34:
        IFlowNetworkResultCallbackIDL r16 = r25;
    L35:
        r6.notifyStopOmniTaskByHttp(r23, r24, r16);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowNetworkIDLIPC", "notifyStopOmniTaskByHttp = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowNetworkIDLIPC", "notifyStopOmniTaskByHttp(" + r23 + ", " + r24 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowNetworkIDLIPC", "notifyStopOmniTaskByHttp", r12, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r25 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L34;
        if ((r25 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L34;
        if ((r25 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L33;
        r16 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r25);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r16 = u2.b(r25);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void sendIntentResultForAsyncNotifyByHttp(List<OPushEvent> r23, boolean r24, IFlowNetworkResultCallbackIDL r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r11 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowNetworkIDLIPC", "sendIntentResultForAsyncNotifyByHttp(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L43
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L43
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r10 = Math.max(0, r20 - r9) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowNetworkIDLIPC", "sendIntentResultForAsyncNotifyByHttp(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r5, r10);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowNetworkIDLIPC", "sendIntentResultForAsyncNotifyByHttp", r5, r10, r20);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowNetworkIDLIPC", "sendIntentResultForAsyncNotifyByHttp(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("sendIntentResultForAsyncNotifyByHttp(");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r23);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r24);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r25 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r15 = r25;
    L21:
        r4.append(r15);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowNetworkIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r25 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L20;
        if ((r25 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L20;
        if ((r25 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L19;
        r15 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r25);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = u2.b(r25);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowNetworkIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r25 != null) goto L26;
    L34:
        IFlowNetworkResultCallbackIDL r16 = r25;
    L35:
        r6.sendIntentResultForAsyncNotifyByHttp(r23, r24, r16);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowNetworkIDLIPC", "sendIntentResultForAsyncNotifyByHttp = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowNetworkIDLIPC", "sendIntentResultForAsyncNotifyByHttp(" + r23 + ", " + r24 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowNetworkIDLIPC", "sendIntentResultForAsyncNotifyByHttp", r12, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r25 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L34;
        if ((r25 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L34;
        if ((r25 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L33;
        r16 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r25);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r16 = u2.b(r25);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void sendIntentResultForCompensationByHttp(List<OPushEvent> r23, boolean r24, IFlowNetworkResultCallbackIDL r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r11 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowNetworkIDLIPC", "sendIntentResultForCompensationByHttp(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L43
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L43
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r10 = Math.max(0, r20 - r9) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowNetworkIDLIPC", "sendIntentResultForCompensationByHttp(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r5, r10);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowNetworkIDLIPC", "sendIntentResultForCompensationByHttp", r5, r10, r20);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowNetworkIDLIPC", "sendIntentResultForCompensationByHttp(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("sendIntentResultForCompensationByHttp(");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r23);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r24);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r25 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r15 = r25;
    L21:
        r4.append(r15);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowNetworkIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r25 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L20;
        if ((r25 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L20;
        if ((r25 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L19;
        r15 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r25);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = u2.b(r25);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowNetworkIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r25 != null) goto L26;
    L34:
        IFlowNetworkResultCallbackIDL r16 = r25;
    L35:
        r6.sendIntentResultForCompensationByHttp(r23, r24, r16);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowNetworkIDLIPC", "sendIntentResultForCompensationByHttp = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowNetworkIDLIPC", "sendIntentResultForCompensationByHttp(" + r23 + ", " + r24 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowNetworkIDLIPC", "sendIntentResultForCompensationByHttp", r12, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r25 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L34;
        if ((r25 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L34;
        if ((r25 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L33;
        r16 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r25);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r16 = u2.b(r25);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void sendNormalRouterByHttp(String r23, String r24, IFlowNetworkResultCallbackIDL r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r11 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowNetworkIDLIPC", "sendNormalRouterByHttp(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L43
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L43
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r10 = Math.max(0, r20 - r9) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowNetworkIDLIPC", "sendNormalRouterByHttp(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r5, r10);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowNetworkIDLIPC", "sendNormalRouterByHttp", r5, r10, r20);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowNetworkIDLIPC", "sendNormalRouterByHttp(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("sendNormalRouterByHttp(");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r23);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r24);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r25 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r15 = r25;
    L21:
        r4.append(r15);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowNetworkIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r25 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L20;
        if ((r25 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L20;
        if ((r25 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L19;
        r15 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r25);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = u2.b(r25);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowNetworkIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r25 != null) goto L26;
    L34:
        IFlowNetworkResultCallbackIDL r16 = r25;
    L35:
        r6.sendNormalRouterByHttp(r23, r24, r16);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowNetworkIDLIPC", "sendNormalRouterByHttp = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowNetworkIDLIPC", "sendNormalRouterByHttp(" + r23 + ", " + r24 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowNetworkIDLIPC", "sendNormalRouterByHttp", r12, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r25 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L34;
        if ((r25 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L34;
        if ((r25 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L33;
        r16 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r25);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r16 = u2.b(r25);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void sendReplyAskUserByHttp(String r30, String r31, String r32, Map r33, IFlowNetworkResultCallbackIDL r34) throws RemoteException {
        long r16 = SystemClock.elapsedRealtimeNanos();
    L52:
        e = e;
        String r4 = "sendReplyAskUserByHttp(";
        String r20 = ")";
        long r6 = 0;
        IFlowNetworkResultCallbackIDL r5 = r34;
    L54:
        int r2 = h.a;     // Catch: Throwable -> L56
        h.b("IFlowNetworkIDLIPC", r4 + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r5 + r20, e);     // Catch: Throwable -> L56
        IPCException r3 = new IPCException(e);     // Catch: Throwable -> L56
        long r25 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L56
        long r7 = Math.max(r6, r25 - r16) / 1000;     // Catch: Throwable -> L56
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L56
        com.obric.aiagent.ipc.utils.i.a("IFlowNetworkIDLIPC", r4 + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r5 + ") = fail", r3, r7);     // Catch: Throwable -> L56
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L56
        IPCAnomalyTrace.b("IFlowNetworkIDLIPC", "sendReplyAskUserByHttp", r3, r7, r25);     // Catch: Throwable -> L56
        return;
    L4:
        if (this.log == false) goto L7;
        int r8 = h.a;     // Catch: Exception -> L52 Throwable -> L56
        h.a("IFlowNetworkIDLIPC", "sendReplyAskUserByHttp(" + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r34 + ")");     // Catch: Exception -> L52 Throwable -> L56
    L7:
        if (this.log == false) goto L22;
        int r9 = h.a;     // Catch: Exception -> L52 Throwable -> L56
        StringBuilder r10 = new StringBuilder("sendReplyAskUserByHttp(");     // Catch: Exception -> L52 Throwable -> L56
        r10.append(r30);     // Catch: Exception -> L52 Throwable -> L56
        r10.append(", ");     // Catch: Exception -> L52 Throwable -> L56
        r10.append(r31);     // Catch: Exception -> L52 Throwable -> L56
        r10.append(", ");     // Catch: Exception -> L52 Throwable -> L56
        r10.append(r32);     // Catch: Exception -> L52 Throwable -> L56
        r10.append(", ");     // Catch: Exception -> L52 Throwable -> L56
        r10.append(r33);     // Catch: Exception -> L52 Throwable -> L56
        r10.append(", ");     // Catch: Exception -> L52 Throwable -> L56
        if (r34 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r11 = r34;
    L21:
        r10.append(r11);     // Catch: Exception -> L52 Throwable -> L56
        r10.append(")");     // Catch: Exception -> L52 Throwable -> L56
        h.a("IFlowNetworkIDLIPC", r10.toString());     // Catch: Exception -> L52 Throwable -> L56
        goto L22
    L12:
        if ((r34 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L20;
        if ((r34 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L20;
        if ((r34 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L19;
        r11 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r34);     // Catch: Exception -> L52 Throwable -> L56
        goto L21
    L19:
        r11 = u2.b(r34);     // Catch: Exception -> L52 Throwable -> L56
    L22:
        IFlowNetworkIDL r12 = this.origin;     // Catch: Exception -> L52 Throwable -> L56
        if (r34 != null) goto L26;
    L35:
        IFlowNetworkResultCallbackIDL r13 = r34;
    L36:
        r20 = ")";
        r12.sendReplyAskUserByHttp(r30, r31, r32, r33, r13);     // Catch: Exception -> L50 Throwable -> L56
        if (this.log == false) goto L40;
        h.d("IFlowNetworkIDLIPC", "sendReplyAskUserByHttp = void");     // Catch: Exception -> L50 Throwable -> L56
    L40:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L50 Throwable -> L56
        long r14 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L50 Throwable -> L56
        int r15 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L50 Throwable -> L56
        r4 = "sendReplyAskUserByHttp(";
        StringBuilder r17 = new StringBuilder(r4);     // Catch: Exception -> L48 Throwable -> L56
        r17.append(r30);     // Catch: Exception -> L48 Throwable -> L56
        r17.append(", ");     // Catch: Exception -> L48 Throwable -> L56
        r17.append(r31);     // Catch: Exception -> L48 Throwable -> L56
        r17.append(", ");     // Catch: Exception -> L48 Throwable -> L56
        r17.append(r32);     // Catch: Exception -> L48 Throwable -> L56
        r17.append(", ");     // Catch: Exception -> L48 Throwable -> L56
        r17.append(r33);     // Catch: Exception -> L48 Throwable -> L56
        r17.append(", ");     // Catch: Exception -> L48 Throwable -> L56
        r5 = r34;
        r6 = 0;
        r17.append(r5);     // Catch: Exception -> L46 Throwable -> L56
        r17.append(") = void");     // Catch: Exception -> L46 Throwable -> L56
        com.obric.aiagent.ipc.utils.i.b("IFlowNetworkIDLIPC", r17.toString(), r14);     // Catch: Exception -> L46 Throwable -> L56
        IPCAnomalyTrace.a.c("IFlowNetworkIDLIPC", "sendReplyAskUserByHttp", r14, r27);     // Catch: Exception -> L46 Throwable -> L56
        return;
    L46:
        e = e;
    L48:
        e = e;
        r5 = r34;
        r6 = 0;
    L50:
        e = e;
        r5 = r34;
        r6 = 0;
        r4 = "sendReplyAskUserByHttp(";
        goto L54
    L26:
        if ((r34 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L35;
        if ((r34 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L35;
        if ((r34 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L33;
        r13 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r34);     // Catch: Exception -> L52 Throwable -> L56
        goto L36
    L33:
        r13 = u2.b(r34);     // Catch: Exception -> L52 Throwable -> L56
    }

    public void uploadUserTakeOverByHttp(String r25, String r26, String r27, long r28, Map r30, IFlowNetworkResultCallbackIDL r31) throws RemoteException {
        long r16 = SystemClock.elapsedRealtimeNanos();
    L56:
        e = e;
        String r13 = "IFlowNetworkIDLIPC";
        String r14 = ", ";
        String r23 = ")";
        IFlowNetworkResultCallbackIDL r1 = r31;
        String r9 = "uploadUserTakeOverByHttp(";
    L58:
        int r2 = h.a;     // Catch: Throwable -> L60
        h.b(r13, r9 + r25 + r14 + r26 + r14 + r27 + r14 + r28 + r14 + r30 + r14 + r1 + r23, e);     // Catch: Throwable -> L60
        IPCException r3 = new IPCException(e);     // Catch: Throwable -> L60
        long r5 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L60
        long r6 = Math.max(0, r5 - r16) / 1000;     // Catch: Throwable -> L60
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L60
        com.obric.aiagent.ipc.utils.i.a(r13, r9 + r25 + r14 + r26 + r14 + r27 + r14 + r28 + r14 + r30 + r14 + r1 + ") = fail", r3, r6);     // Catch: Throwable -> L60
        IPCAnomalyTrace r4 = IPCAnomalyTrace.a;     // Catch: Throwable -> L60
        IPCAnomalyTrace.b("IFlowNetworkIDLIPC", "uploadUserTakeOverByHttp", r3, r6, r5);     // Catch: Throwable -> L60
        return;
    L4:
        if (this.log == false) goto L7;
        int r7 = h.a;     // Catch: Exception -> L56 Throwable -> L60
        h.a("IFlowNetworkIDLIPC", "uploadUserTakeOverByHttp(" + r25 + ", " + r26 + ", " + r27 + ", " + r28 + ", " + r30 + ", " + r31 + ")");     // Catch: Exception -> L56 Throwable -> L60
    L7:
        if (this.log == false) goto L22;
        int r8 = h.a;     // Catch: Exception -> L56 Throwable -> L60
        StringBuilder r10 = new StringBuilder("uploadUserTakeOverByHttp(");     // Catch: Exception -> L56 Throwable -> L60
        r10.append(r25);     // Catch: Exception -> L56 Throwable -> L60
        r10.append(", ");     // Catch: Exception -> L56 Throwable -> L60
        r10.append(r26);     // Catch: Exception -> L56 Throwable -> L60
        r10.append(", ");     // Catch: Exception -> L56 Throwable -> L60
        r10.append(r27);     // Catch: Exception -> L56 Throwable -> L60
        r10.append(", ");     // Catch: Exception -> L56 Throwable -> L60
        r10.append(r28);     // Catch: Exception -> L56 Throwable -> L60
        r10.append(", ");     // Catch: Exception -> L56 Throwable -> L60
        r10.append(r30);     // Catch: Exception -> L56 Throwable -> L60
        r10.append(", ");     // Catch: Exception -> L56 Throwable -> L60
        if (r31 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r11 = r31;
    L21:
        r10.append(r11);     // Catch: Exception -> L56 Throwable -> L60
        r10.append(")");     // Catch: Exception -> L56 Throwable -> L60
        h.a("IFlowNetworkIDLIPC", r10.toString());     // Catch: Exception -> L56 Throwable -> L60
        goto L22
    L12:
        if ((r31 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L20;
        if ((r31 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L20;
        if ((r31 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L19;
        r11 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r31);     // Catch: Exception -> L56 Throwable -> L60
        goto L21
    L19:
        r11 = u2.b(r31);     // Catch: Exception -> L56 Throwable -> L60
    L22:
        IFlowNetworkIDL r12 = this.origin;     // Catch: Exception -> L56 Throwable -> L60
        if (r31 != null) goto L26;
    L35:
        IFlowNetworkResultCallbackIDL r15 = r31;
    L36:
        r13 = "IFlowNetworkIDLIPC";
        r14 = ", ";
        r23 = ")";
        r12.uploadUserTakeOverByHttp(r25, r26, r27, r28, r30, r15);     // Catch: Exception -> L54 Throwable -> L60
        if (this.log == false) goto L40;
        h.d(r13, "uploadUserTakeOverByHttp = void");     // Catch: Exception -> L54 Throwable -> L60
    L40:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L54 Throwable -> L60
        long r18 = Math.max(0, r17 - r16) / 1000;     // Catch: Exception -> L54 Throwable -> L60
        int r19 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L54 Throwable -> L60
        r9 = "uploadUserTakeOverByHttp(";
        StringBuilder r20 = new StringBuilder(r9);     // Catch: Exception -> L52 Throwable -> L60
        r20.append(r25);     // Catch: Exception -> L52 Throwable -> L60
        r20.append(r14);     // Catch: Exception -> L52 Throwable -> L60
        r20.append(r26);     // Catch: Exception -> L52 Throwable -> L60
        r20.append(r14);     // Catch: Exception -> L52 Throwable -> L60
        r20.append(r27);     // Catch: Exception -> L52 Throwable -> L60
        r20.append(r14);     // Catch: Exception -> L52 Throwable -> L60
        r20.append(r28);     // Catch: Exception -> L52 Throwable -> L60
        r20.append(r14);     // Catch: Exception -> L52 Throwable -> L60
        r20.append(r30);     // Catch: Exception -> L52 Throwable -> L60
        r20.append(r14);     // Catch: Exception -> L52 Throwable -> L60
        r20.append(r31);     // Catch: Exception -> L50 Throwable -> L60
        r20.append(") = void");     // Catch: Exception -> L50 Throwable -> L60
        com.obric.aiagent.ipc.utils.i.b(r13, r20.toString(), r18);     // Catch: Exception -> L50 Throwable -> L60
        r1 = r31;
        IPCAnomalyTrace.a.c("IFlowNetworkIDLIPC", "uploadUserTakeOverByHttp", r18, r17);     // Catch: Exception -> L48 Throwable -> L60
        return;
    L48:
        e = e;
    L50:
        e = e;
        r1 = r31;
    L52:
        e = e;
        r1 = r31;
    L54:
        e = e;
        r1 = r31;
        r9 = "uploadUserTakeOverByHttp(";
        goto L58
    L26:
        if ((r31 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L35;
        if ((r31 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L35;
        if ((r31 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L33;
        r15 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r31);     // Catch: Exception -> L56 Throwable -> L60
        goto L36
    L33:
        r15 = u2.b(r31);     // Catch: Exception -> L56 Throwable -> L60
    }

    public void uploadOmniScreenshotByHttp(String r26, String r27, int r28, String r29, String r30, String r31, String r32, List<String> r33, String r34, String r35, IFlowNetworkResultCallbackIDL r36) throws RemoteException {
        String r14 = r26;
        String r15 = r27;
        int r13 = r28;
        String r12 = r29;
        String r11 = r30;
        r31 = r31;
        String r16 = "IFlowNetworkIDLIPC";
        String r3 = "uploadOmniScreenshotByHttp(";
        long r17 = SystemClock.elapsedRealtimeNanos();
        String r19 = ")";
    L107:
        e = e;
    L108:
        String r23 = r19;
        String r110 = r16;
    L106:
        String r18 = ", ";
    L109:
        int r2 = h.a;     // Catch: Throwable -> L111
        StringBuilder r4 = new StringBuilder(r3);     // Catch: Throwable -> L111
        r4.append(r14);     // Catch: Throwable -> L111
        r4.append(r18);     // Catch: Throwable -> L111
        r4.append(r15);     // Catch: Throwable -> L111
        r4.append(r18);     // Catch: Throwable -> L111
        r4.append(r13);     // Catch: Throwable -> L111
        r4.append(r18);     // Catch: Throwable -> L111
        r4.append(r12);     // Catch: Throwable -> L111
        r4.append(r18);     // Catch: Throwable -> L111
        r4.append(r11);     // Catch: Throwable -> L111
        r4.append(r18);     // Catch: Throwable -> L111
        r4.append(r31);     // Catch: Throwable -> L111
        r4.append(r18);     // Catch: Throwable -> L111
        String r5 = r12;
        r4.append(r32);     // Catch: Throwable -> L111
        r4.append(r18);     // Catch: Throwable -> L111
        r4.append(r33);     // Catch: Throwable -> L111
        r4.append(r18);     // Catch: Throwable -> L111
        r4.append(r34);     // Catch: Throwable -> L111
        r4.append(r18);     // Catch: Throwable -> L111
        r4.append(r35);     // Catch: Throwable -> L111
        r4.append(r18);     // Catch: Throwable -> L111
        r4.append(r36);     // Catch: Throwable -> L111
        r4.append(r23);     // Catch: Throwable -> L111
        String r10 = r110;
        h.b(r10, r4.toString(), e);     // Catch: Throwable -> L111
        IPCException r6 = new IPCException(e);     // Catch: Throwable -> L111
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L111
        long r7 = Math.max(0, r22 - r17) / 1000;     // Catch: Throwable -> L111
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L111
        com.obric.aiagent.ipc.utils.i.a(r10, r3 + r14 + r18 + r15 + r18 + r13 + r18 + r5 + r18 + r11 + r18 + r31 + r18 + r32 + r18 + r33 + r18 + r34 + r18 + r35 + r18 + r36 + ") = fail", r6, r7);     // Catch: Throwable -> L111
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L111
        IPCAnomalyTrace.b("IFlowNetworkIDLIPC", "uploadOmniScreenshotByHttp", r6, r7, r22);     // Catch: Throwable -> L111
        return;
    L4:
        if (this.log == true) goto L130;
        IFlowNetworkResultCallbackIDL r8 = r36;
        r110 = r16;
    L17:
        if (this.log == true) goto L123;
        r16 = ", ";
        String r9 = r19;
    L42:
        IFlowNetworkIDL r20 = this.origin;     // Catch: Exception -> L101 Throwable -> L111
        if (r8 != null) goto L45;
        String r111 = r9;
    L56:
        IFlowNetworkResultCallbackIDL r24 = r8;
    L57:
        String r112 = r16;
        r3 = "uploadOmniScreenshotByHttp(";
        String r113 = r110;
        r23 = r111;
        r20.uploadOmniScreenshotByHttp(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r24);     // Catch: Exception -> L97 Throwable -> L111
        if (this.log == false) goto L61;
        h.d(r113, "uploadOmniScreenshotByHttp = void");     // Catch: Exception -> L97 Throwable -> L111
    L61:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L97 Throwable -> L111
        long r25 = Math.max(0, r21 - r17) / 1000;     // Catch: Exception -> L97 Throwable -> L111
        int r37 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L97 Throwable -> L111
        StringBuilder r38 = new StringBuilder(r3);     // Catch: Exception -> L97 Throwable -> L111
        r14 = r26;
        r38.append(r14);     // Catch: Exception -> L95 Throwable -> L111
        r38.append(r112);     // Catch: Exception -> L93 Throwable -> L111
        r15 = r27;
        r18 = r112;
        r38.append(r15);     // Catch: Exception -> L91 Throwable -> L111
        r38.append(r18);     // Catch: Exception -> L91 Throwable -> L111
        r38.append(r28);     // Catch: Exception -> L89 Throwable -> L111
        r38.append(r18);     // Catch: Exception -> L89 Throwable -> L111
        r38.append(r29);     // Catch: Exception -> L85 Throwable -> L111
        r38.append(r18);     // Catch: Exception -> L85 Throwable -> L111
        r38.append(r30);     // Catch: Exception -> L83 Throwable -> L111
        r38.append(r18);     // Catch: Exception -> L83 Throwable -> L111
        r31 = r31;
        r38.append(r31);     // Catch: Exception -> L81 Throwable -> L111
        r38.append(r18);     // Catch: Exception -> L81 Throwable -> L111
        r38.append(r32);     // Catch: Exception -> L81 Throwable -> L111
        r38.append(r18);     // Catch: Exception -> L81 Throwable -> L111
        r38.append(r33);     // Catch: Exception -> L81 Throwable -> L111
        r38.append(r18);     // Catch: Exception -> L81 Throwable -> L111
        r38.append(r34);     // Catch: Exception -> L81 Throwable -> L111
        r38.append(r18);     // Catch: Exception -> L81 Throwable -> L111
        r38.append(r35);     // Catch: Exception -> L81 Throwable -> L111
        r38.append(r18);     // Catch: Exception -> L81 Throwable -> L111
        r38.append(r36);     // Catch: Exception -> L81 Throwable -> L111
        r38.append(") = void");     // Catch: Exception -> L81 Throwable -> L111
        com.obric.aiagent.ipc.utils.i.b(r113, r38.toString(), r25);     // Catch: Exception -> L81 Throwable -> L111
        r110 = r113;
        r11 = r30;
        r12 = r29;
        r13 = r28;
        IPCAnomalyTrace.a.c("IFlowNetworkIDLIPC", "uploadOmniScreenshotByHttp", r25, r21);     // Catch: Exception -> L79 Throwable -> L111
        return;
    L79:
        e = e;
    L81:
        e = e;
    L82:
        r12 = r29;
        r13 = r28;
        r110 = r113;
        r11 = r30;
    L83:
        e = e;
        r31 = r31;
    L85:
        e = e;
        r12 = r29;
    L87:
        r13 = r28;
    L88:
        r110 = r113;
        r11 = r30;
    L89:
        e = e;
        r12 = r29;
    L91:
        e = e;
        r13 = r28;
        r12 = r29;
        r31 = r31;
    L93:
        e = e;
        r15 = r27;
        r13 = r28;
        r12 = r29;
        r31 = r31;
        r18 = r112;
    L95:
        e = e;
        r15 = r27;
        r13 = r28;
        r12 = r29;
        r31 = r31;
        r18 = r112;
    L97:
        e = e;
        r14 = r26;
        r15 = r27;
        r13 = r28;
        r12 = r29;
        r11 = r30;
        r31 = r31;
        r110 = r113;
        r18 = r112;
        goto L109
    L45:
        r111 = r9;
        if ((r8 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L56;
        if ((r8 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L56;
        if ((r8 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L54;
        IFlowNetworkResultCallbackIDL r39 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r8);     // Catch: Exception -> L99 Throwable -> L111
    L55:
        r24 = r39;
        goto L57
    L54:
        r39 = u2.b(r36);     // Catch: Exception -> L99 Throwable -> L111
    L101:
        e = e;
    L102:
        r23 = r9;
    L103:
        r11 = r11;
        r14 = r14;
        r18 = r16;
        goto L109
    L123:
        int r40 = h.a;     // Catch: Exception -> L39 Throwable -> L111
        StringBuilder r41 = new StringBuilder("uploadOmniScreenshotByHttp(");     // Catch: Exception -> L39 Throwable -> L111
        r41.append(r14);     // Catch: Exception -> L39 Throwable -> L111
        r41.append(", ");     // Catch: Exception -> L39 Throwable -> L111
        r41.append(r15);     // Catch: Exception -> L39 Throwable -> L111
        r41.append(", ");     // Catch: Exception -> L39 Throwable -> L111
        r41.append(r13);     // Catch: Exception -> L39 Throwable -> L111
        r41.append(", ");     // Catch: Exception -> L39 Throwable -> L111
        r41.append(r12);     // Catch: Exception -> L39 Throwable -> L111
        r41.append(", ");     // Catch: Exception -> L39 Throwable -> L111
        r41.append(r11);     // Catch: Exception -> L39 Throwable -> L111
        r41.append(", ");     // Catch: Exception -> L39 Throwable -> L111
        r41.append(r31);     // Catch: Exception -> L39 Throwable -> L111
        r41.append(", ");     // Catch: Exception -> L39 Throwable -> L111
        r41.append(r32);     // Catch: Exception -> L39 Throwable -> L111
        r41.append(", ");     // Catch: Exception -> L39 Throwable -> L111
        r41.append(r33);     // Catch: Exception -> L39 Throwable -> L111
        r41.append(", ");     // Catch: Exception -> L39 Throwable -> L111
        r41.append(r34);     // Catch: Exception -> L39 Throwable -> L111
        r41.append(", ");     // Catch: Exception -> L39 Throwable -> L111
        r41.append(r35);     // Catch: Exception -> L39 Throwable -> L111
        r41.append(", ");     // Catch: Exception -> L39 Throwable -> L111
        r16 = ", ";
        if (r8 != null) goto L128;
    L33:
        IFlowNetworkResultCallbackIDL r42 = r8;
    L34:
        r41.append(r42);     // Catch: Exception -> L99 Throwable -> L111
        r9 = r19;
        r41.append(r9);     // Catch: Exception -> L101 Throwable -> L111
        h.a(r110, r41.toString());     // Catch: Exception -> L101 Throwable -> L111
        goto L42
    L128:
    L37:
        e = e;
    L38:
        r9 = r19;
        goto L102
    L24:
        if ((r8 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L33;
        if ((r8 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L33;
        if ((r8 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L32;
        r42 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r8);     // Catch: Exception -> L99 Throwable -> L111
        goto L34
    L32:
        r42 = u2.b(r36);     // Catch: Exception -> L99 Throwable -> L111
    L39:
        e = e;
        r16 = ", ";
    L99:
        e = e;
        r23 = r19;
    L104:
        e = e;
    L105:
        r23 = r19;
        r110 = r110;
        goto L106
    L130:
        int r43 = h.a;     // Catch: Exception -> L14 Throwable -> L111
        StringBuilder r44 = new StringBuilder("uploadOmniScreenshotByHttp(");     // Catch: Exception -> L14 Throwable -> L111
        r44.append(r14);     // Catch: Exception -> L14 Throwable -> L111
        r44.append(", ");     // Catch: Exception -> L14 Throwable -> L111
        r44.append(r15);     // Catch: Exception -> L14 Throwable -> L111
        r44.append(", ");     // Catch: Exception -> L14 Throwable -> L111
        r44.append(r13);     // Catch: Exception -> L14 Throwable -> L111
        r44.append(", ");     // Catch: Exception -> L14 Throwable -> L111
        r44.append(r12);     // Catch: Exception -> L14 Throwable -> L111
        r44.append(", ");     // Catch: Exception -> L14 Throwable -> L111
        r44.append(r11);     // Catch: Exception -> L14 Throwable -> L111
        r44.append(", ");     // Catch: Exception -> L14 Throwable -> L111
        r44.append(r31);     // Catch: Exception -> L14 Throwable -> L111
        r44.append(", ");     // Catch: Exception -> L14 Throwable -> L111
        r44.append(r32);     // Catch: Exception -> L14 Throwable -> L111
        r44.append(", ");     // Catch: Exception -> L14 Throwable -> L111
        r44.append(r33);     // Catch: Exception -> L14 Throwable -> L111
        r44.append(", ");     // Catch: Exception -> L14 Throwable -> L111
        r44.append(r34);     // Catch: Exception -> L14 Throwable -> L111
        r44.append(", ");     // Catch: Exception -> L14 Throwable -> L111
        r44.append(r35);     // Catch: Exception -> L14 Throwable -> L111
        r44.append(", ");     // Catch: Exception -> L14 Throwable -> L111
        r8 = r36;
        r44.append(r8);     // Catch: Exception -> L107 Throwable -> L111
        r44.append(r19);     // Catch: Exception -> L12 Throwable -> L111
        r19 = r19;
        r110 = r16;
        h.a(r110, r44.toString());     // Catch: Exception -> L104 Throwable -> L111
    L12:
        e = e;
        r19 = r19;
        r110 = r16;
    L14:
        e = e;
        goto L108
    }

    public void uploadOmniScreenshotByHttpV2(String r26, String r27, int r28, String r29, String r30, String r31, String r32, List<String> r33, String r34, String r35, boolean r36, IFlowNetworkResultCallbackIDL r37) throws RemoteException {
        r27 = r27;
        r28 = r28;
        r29 = r29;
        r31 = r31;
        String r17 = ")";
        long r18 = SystemClock.elapsedRealtimeNanos();
    L110:
        e = e;
    L111:
        r31 = r31;
        r29 = r29;
        r28 = r28;
        String r23 = r17;
        String r13 = ", ";
        String r12 = "uploadOmniScreenshotByHttpV2(";
        String r19 = "IFlowNetworkIDLIPC";
    L107:
        String r15 = r30;
        String r11 = r26;
    L112:
        int r2 = h.a;     // Catch: Throwable -> L114
        StringBuilder r3 = new StringBuilder(r12);     // Catch: Throwable -> L114
        r3.append(r11);     // Catch: Throwable -> L114
        r3.append(r13);     // Catch: Throwable -> L114
        r3.append(r27);     // Catch: Throwable -> L114
        r3.append(r13);     // Catch: Throwable -> L114
        r3.append(r28);     // Catch: Throwable -> L114
        r3.append(r13);     // Catch: Throwable -> L114
        r3.append(r29);     // Catch: Throwable -> L114
        r3.append(r13);     // Catch: Throwable -> L114
        r3.append(r15);     // Catch: Throwable -> L114
        r3.append(r13);     // Catch: Throwable -> L114
        r3.append(r31);     // Catch: Throwable -> L114
        r3.append(r13);     // Catch: Throwable -> L114
        int r4 = r28;
        r3.append(r32);     // Catch: Throwable -> L114
        r3.append(r13);     // Catch: Throwable -> L114
        r3.append(r33);     // Catch: Throwable -> L114
        r3.append(r13);     // Catch: Throwable -> L114
        r3.append(r34);     // Catch: Throwable -> L114
        r3.append(r13);     // Catch: Throwable -> L114
        r3.append(r35);     // Catch: Throwable -> L114
        r3.append(r13);     // Catch: Throwable -> L114
        r3.append(r36);     // Catch: Throwable -> L114
        r3.append(r13);     // Catch: Throwable -> L114
        r3.append(r37);     // Catch: Throwable -> L114
        r3.append(r23);     // Catch: Throwable -> L114
        String r10 = r19;
        h.b(r10, r3.toString(), e);     // Catch: Throwable -> L114
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L114
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L114
        long r6 = Math.max(0, r16 - r18) / 1000;     // Catch: Throwable -> L114
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L114
        com.obric.aiagent.ipc.utils.i.a(r10, r12 + r11 + r13 + r27 + r13 + r4 + r13 + r29 + r13 + r15 + r13 + r31 + r13 + r32 + r13 + r33 + r13 + r34 + r13 + r35 + r13 + r36 + r13 + r37 + ") = fail", r5, r6);     // Catch: Throwable -> L114
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L114
        IPCAnomalyTrace.b("IFlowNetworkIDLIPC", "uploadOmniScreenshotByHttpV2", r5, r6, r16);     // Catch: Throwable -> L114
        return;
    L4:
        if (this.log == true) goto L130;
        boolean r7 = r36;
        String r8 = "IFlowNetworkIDLIPC";
    L17:
        if (this.log == true) goto L140;
        IFlowNetworkResultCallbackIDL r9 = r37;
        String r110 = "uploadOmniScreenshotByHttpV2(";
        String r14 = r17;
        String r111 = ", ";
    L37:
        IFlowNetworkIDL r20 = this.origin;     // Catch: Exception -> L104 Throwable -> L114
        if (r9 != null) goto L41;
    L50:
        IFlowNetworkResultCallbackIDL r21 = r9;
    L51:
        String r22 = r111;
        r23 = r14;
        r19 = r8;
        r20.uploadOmniScreenshotByHttpV2(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r21);     // Catch: Exception -> L102 Throwable -> L114
        if (this.log == false) goto L55;
        h.d(r19, "uploadOmniScreenshotByHttpV2 = void");     // Catch: Exception -> L102 Throwable -> L114
    L55:
        long r24 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L102 Throwable -> L114
        long r25 = Math.max(0, r24 - r18) / 1000;     // Catch: Exception -> L102 Throwable -> L114
        int r38 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L102 Throwable -> L114
        String r39 = r110;
        StringBuilder r40 = new StringBuilder(r39);     // Catch: Exception -> L100 Throwable -> L114
        r11 = r26;
        r12 = r39;
        r40.append(r11);     // Catch: Exception -> L96 Throwable -> L114
        r13 = r22;
        r40.append(r13);     // Catch: Exception -> L94 Throwable -> L114
        r27 = r27;
        r40.append(r27);     // Catch: Exception -> L92 Throwable -> L114
        r40.append(r13);     // Catch: Exception -> L92 Throwable -> L114
        r40.append(r28);     // Catch: Exception -> L90 Throwable -> L114
        r40.append(r13);     // Catch: Exception -> L90 Throwable -> L114
        r40.append(r29);     // Catch: Exception -> L88 Throwable -> L114
        r40.append(r13);     // Catch: Exception -> L88 Throwable -> L114
        r40.append(r30);     // Catch: Exception -> L85 Throwable -> L114
        r40.append(r13);     // Catch: Exception -> L85 Throwable -> L114
        r31 = r31;
        r40.append(r31);     // Catch: Exception -> L83 Throwable -> L114
        r40.append(r13);     // Catch: Exception -> L83 Throwable -> L114
        r40.append(r32);     // Catch: Exception -> L83 Throwable -> L114
        r40.append(r13);     // Catch: Exception -> L83 Throwable -> L114
        r40.append(r33);     // Catch: Exception -> L83 Throwable -> L114
        r40.append(r13);     // Catch: Exception -> L83 Throwable -> L114
        r40.append(r34);     // Catch: Exception -> L83 Throwable -> L114
        r40.append(r13);     // Catch: Exception -> L83 Throwable -> L114
        r40.append(r35);     // Catch: Exception -> L83 Throwable -> L114
        r40.append(r13);     // Catch: Exception -> L83 Throwable -> L114
        r40.append(r36);     // Catch: Exception -> L83 Throwable -> L114
        r40.append(r13);     // Catch: Exception -> L83 Throwable -> L114
        r40.append(r37);     // Catch: Exception -> L83 Throwable -> L114
        r40.append(") = void");     // Catch: Exception -> L78 Throwable -> L114
        com.obric.aiagent.ipc.utils.i.b(r19, r40.toString(), r25);     // Catch: Exception -> L78 Throwable -> L114
        r19 = r19;
        r15 = r30;
        r29 = r29;
        r28 = r28;
        IPCAnomalyTrace.a.c("IFlowNetworkIDLIPC", "uploadOmniScreenshotByHttpV2", r25, r24);     // Catch: Exception -> L76 Throwable -> L114
        return;
    L76:
        e = e;
    L78:
        e = e;
    L79:
        r29 = r29;
    L80:
        r28 = r28;
    L81:
        r19 = r19;
    L82:
        r15 = r30;
    L83:
        e = e;
    L87:
        r29 = r29;
        r28 = r28;
        r19 = r19;
        r15 = r30;
    L85:
        e = e;
        r31 = r31;
    L88:
        e = e;
        r31 = r31;
    L90:
        e = e;
        r29 = r29;
        r31 = r31;
    L92:
        e = e;
    L93:
        r28 = r28;
        r29 = r29;
        r31 = r31;
    L94:
        e = e;
        r27 = r27;
    L96:
        e = e;
    L99:
        r13 = r22;
    L100:
        e = e;
        r11 = r26;
        r12 = r39;
    L102:
        e = e;
        r11 = r26;
        r27 = r27;
        r28 = r28;
        r29 = r29;
        r31 = r31;
        r12 = r110;
        goto L99
    L41:
        if ((r9 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L50;
        if ((r9 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L50;
        if ((r9 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L48;
        r21 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r9);     // Catch: Exception -> L104 Throwable -> L114
        goto L51
    L48:
        r21 = u2.b(r37);     // Catch: Exception -> L104 Throwable -> L114
        goto L51
    L140:
        int r41 = h.a;     // Catch: Exception -> L34 Throwable -> L114
        StringBuilder r42 = new StringBuilder("uploadOmniScreenshotByHttpV2(");     // Catch: Exception -> L34 Throwable -> L114
        r42.append(r26);     // Catch: Exception -> L34 Throwable -> L114
        r42.append(", ");     // Catch: Exception -> L34 Throwable -> L114
        r42.append(r27);     // Catch: Exception -> L34 Throwable -> L114
        r42.append(", ");     // Catch: Exception -> L34 Throwable -> L114
        r42.append(r28);     // Catch: Exception -> L34 Throwable -> L114
        r42.append(", ");     // Catch: Exception -> L34 Throwable -> L114
        r42.append(r29);     // Catch: Exception -> L34 Throwable -> L114
        r42.append(", ");     // Catch: Exception -> L34 Throwable -> L114
        r42.append(r30);     // Catch: Exception -> L34 Throwable -> L114
        r42.append(", ");     // Catch: Exception -> L34 Throwable -> L114
        r42.append(r31);     // Catch: Exception -> L34 Throwable -> L114
        r42.append(", ");     // Catch: Exception -> L34 Throwable -> L114
        r42.append(r32);     // Catch: Exception -> L34 Throwable -> L114
        r42.append(", ");     // Catch: Exception -> L34 Throwable -> L114
        r42.append(r33);     // Catch: Exception -> L34 Throwable -> L114
        r42.append(", ");     // Catch: Exception -> L34 Throwable -> L114
        r42.append(r34);     // Catch: Exception -> L34 Throwable -> L114
        r42.append(", ");     // Catch: Exception -> L34 Throwable -> L114
        r42.append(r35);     // Catch: Exception -> L34 Throwable -> L114
        r42.append(", ");     // Catch: Exception -> L34 Throwable -> L114
        r42.append(r7);     // Catch: Exception -> L34 Throwable -> L114
        r42.append(", ");     // Catch: Exception -> L34 Throwable -> L114
        r9 = r37;
        r110 = "uploadOmniScreenshotByHttpV2(";
        r14 = r17;
        r111 = ", ";
        if (r9 != null) goto L123;
    L32:
        IFlowNetworkResultCallbackIDL r43 = r9;
    L33:
        r42.append(r43);     // Catch: Exception -> L104 Throwable -> L114
        r42.append(r14);     // Catch: Exception -> L104 Throwable -> L114
        h.a(r8, r42.toString());     // Catch: Exception -> L104 Throwable -> L114
        goto L37
    L123:
    L104:
        e = e;
    L105:
        r23 = r14;
        r12 = r110;
        r13 = r111;
    L106:
        r19 = r8;
        goto L107
    L24:
        if ((r9 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L32;
        if ((r9 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L32;
        if ((r9 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L31;
        r43 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r9);     // Catch: Exception -> L104 Throwable -> L114
        goto L33
    L31:
        r43 = u2.b(r37);     // Catch: Exception -> L104 Throwable -> L114
    L34:
        e = e;
        r110 = "uploadOmniScreenshotByHttpV2(";
        r14 = r17;
        r111 = ", ";
    L108:
        e = e;
    L109:
        r23 = r17;
        r13 = ", ";
        r12 = "uploadOmniScreenshotByHttpV2(";
        goto L106
    L130:
        int r44 = h.a;     // Catch: Exception -> L14 Throwable -> L114
        StringBuilder r45 = new StringBuilder("uploadOmniScreenshotByHttpV2(");     // Catch: Exception -> L14 Throwable -> L114
        r45.append(r26);     // Catch: Exception -> L14 Throwable -> L114
        r45.append(", ");     // Catch: Exception -> L14 Throwable -> L114
        r45.append(r27);     // Catch: Exception -> L14 Throwable -> L114
        r45.append(", ");     // Catch: Exception -> L14 Throwable -> L114
        r45.append(r28);     // Catch: Exception -> L14 Throwable -> L114
        r45.append(", ");     // Catch: Exception -> L14 Throwable -> L114
        r45.append(r29);     // Catch: Exception -> L14 Throwable -> L114
        r45.append(", ");     // Catch: Exception -> L14 Throwable -> L114
        r45.append(r30);     // Catch: Exception -> L14 Throwable -> L114
        r45.append(", ");     // Catch: Exception -> L14 Throwable -> L114
        r45.append(r31);     // Catch: Exception -> L14 Throwable -> L114
        r45.append(", ");     // Catch: Exception -> L14 Throwable -> L114
        r45.append(r32);     // Catch: Exception -> L14 Throwable -> L114
        r45.append(", ");     // Catch: Exception -> L14 Throwable -> L114
        r45.append(r33);     // Catch: Exception -> L14 Throwable -> L114
        r45.append(", ");     // Catch: Exception -> L14 Throwable -> L114
        r45.append(r34);     // Catch: Exception -> L14 Throwable -> L114
        r45.append(", ");     // Catch: Exception -> L14 Throwable -> L114
        r45.append(r35);     // Catch: Exception -> L14 Throwable -> L114
        r45.append(", ");     // Catch: Exception -> L14 Throwable -> L114
        r7 = r36;
        r45.append(r7);     // Catch: Exception -> L110 Throwable -> L114
        r45.append(", ");     // Catch: Exception -> L110 Throwable -> L114
        r45.append(r37);     // Catch: Exception -> L110 Throwable -> L114
        r45.append(r17);     // Catch: Exception -> L12 Throwable -> L114
        r17 = r17;
        r8 = "IFlowNetworkIDLIPC";
        h.a(r8, r45.toString());     // Catch: Exception -> L108 Throwable -> L114
    L12:
        e = e;
        r17 = r17;
        r8 = "IFlowNetworkIDLIPC";
    L14:
        e = e;
        goto L111
    }

    public void uploadOmniDataFeedbackByHttp(String r27, String r28, int r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, List<String> r38, String r39, String r40, IFlowNetworkResultCallbackIDL r41) throws RemoteException {
        r32 = r32;
        String r16 = ")";
        String r17 = "IFlowNetworkIDLIPC";
        long r18 = SystemClock.elapsedRealtimeNanos();
        if (this.log == true) goto L158;
        String r4 = "uploadOmniDataFeedbackByHttp(";
        String r5 = r17;
        IFlowNetworkResultCallbackIDL r3 = r41;
    L25:
        if (this.log == true) goto L160;
        String r22 = r4;
        String r15 = r16;
        String r19 = ", ";
    L57:
        IFlowNetworkIDL r2 = this.origin;     // Catch: Exception -> L123 Throwable -> L131
        if (r3 != null) goto L61;
    L70:
        IFlowNetworkResultCallbackIDL r110 = r3;
    L71:
        String r23 = r19;
        String r24 = r5;
        String r25 = r15;
        r2.uploadOmniDataFeedbackByHttp(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r110);     // Catch: Exception -> L121 Throwable -> L131
        if (this.log == true) goto L75;
        r17 = r24;
    L78:
        long r8 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L119 Throwable -> L131
        long r6 = Math.max(0, r8 - r18) / 1000;     // Catch: Exception -> L119 Throwable -> L131
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L119 Throwable -> L131
        String r12 = r22;
        StringBuilder r1 = new StringBuilder(r12);     // Catch: Exception -> L117 Throwable -> L131
        String r13 = r27;
        r1.append(r13);     // Catch: Exception -> L114 Throwable -> L131
        String r14 = r23;
        r1.append(r14);     // Catch: Exception -> L112 Throwable -> L131
        r28 = r28;
        r1.append(r28);     // Catch: Exception -> L110 Throwable -> L131
        r1.append(r14);     // Catch: Exception -> L110 Throwable -> L131
        r1.append(r29);     // Catch: Exception -> L108 Throwable -> L131
        r1.append(r14);     // Catch: Exception -> L108 Throwable -> L131
        r1.append(r30);     // Catch: Exception -> L104 Throwable -> L131
        r1.append(r14);     // Catch: Exception -> L104 Throwable -> L131
        r1.append(r31);     // Catch: Exception -> L102 Throwable -> L131
        r1.append(r14);     // Catch: Exception -> L102 Throwable -> L131
        r32 = r32;
        r1.append(r32);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(r14);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(r33);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(r14);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(r34);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(r14);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(r35);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(r14);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(r36);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(r14);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(r37);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(r14);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(r38);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(r14);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(r39);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(r14);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(r40);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(r14);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(r41);     // Catch: Exception -> L100 Throwable -> L131
        r1.append(") = void");     // Catch: Exception -> L100 Throwable -> L131
        com.obric.aiagent.ipc.utils.i.b(r17, r1.toString(), r6);     // Catch: Exception -> L100 Throwable -> L131
        r17 = r17;
        String r7 = r31;
        r30 = r30;
        r29 = r29;
        IPCAnomalyTrace.a.c("IFlowNetworkIDLIPC", "uploadOmniDataFeedbackByHttp", r6, r8);     // Catch: Exception -> L98 Throwable -> L131
        return;
    L98:
        e = e;
    L129:
        int r9 = h.a;     // Catch: Throwable -> L131
        StringBuilder r10 = new StringBuilder(r12);     // Catch: Throwable -> L131
        r10.append(r13);     // Catch: Throwable -> L131
        r10.append(r14);     // Catch: Throwable -> L131
        r10.append(r28);     // Catch: Throwable -> L131
        r10.append(r14);     // Catch: Throwable -> L131
        r10.append(r29);     // Catch: Throwable -> L131
        r10.append(r14);     // Catch: Throwable -> L131
        r10.append(r30);     // Catch: Throwable -> L131
        r10.append(r14);     // Catch: Throwable -> L131
        r10.append(r7);     // Catch: Throwable -> L131
        r10.append(r14);     // Catch: Throwable -> L131
        r10.append(r32);     // Catch: Throwable -> L131
        r10.append(r14);     // Catch: Throwable -> L131
        String r11 = r30;
        r10.append(r33);     // Catch: Throwable -> L131
        r10.append(r14);     // Catch: Throwable -> L131
        r10.append(r34);     // Catch: Throwable -> L131
        r10.append(r14);     // Catch: Throwable -> L131
        r10.append(r35);     // Catch: Throwable -> L131
        r10.append(r14);     // Catch: Throwable -> L131
        r10.append(r36);     // Catch: Throwable -> L131
        r10.append(r14);     // Catch: Throwable -> L131
        r10.append(r37);     // Catch: Throwable -> L131
        r10.append(r14);     // Catch: Throwable -> L131
        r10.append(r38);     // Catch: Throwable -> L131
        r10.append(r14);     // Catch: Throwable -> L131
        r10.append(r39);     // Catch: Throwable -> L131
        r10.append(r14);     // Catch: Throwable -> L131
        r10.append(r40);     // Catch: Throwable -> L131
        r10.append(r14);     // Catch: Throwable -> L131
        r10.append(r41);     // Catch: Throwable -> L131
        r10.append(r25);     // Catch: Throwable -> L131
        String r111 = r17;
        h.b(r111, r10.toString(), e);     // Catch: Throwable -> L131
        IPCException r20 = new IPCException(e);     // Catch: Throwable -> L131
        long r112 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L131
        long r21 = Math.max(0, r112 - r18) / 1000;     // Catch: Throwable -> L131
        int r26 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L131
        com.obric.aiagent.ipc.utils.i.a(r111, r12 + r13 + r14 + r28 + r14 + r29 + r14 + r11 + r14 + r7 + r14 + r32 + r14 + r33 + r14 + r34 + r14 + r35 + r14 + r36 + r14 + r37 + r14 + r38 + r14 + r39 + r14 + r40 + r14 + r41 + ") = fail", r20, r21);     // Catch: Throwable -> L131
        IPCAnomalyTrace r42 = IPCAnomalyTrace.a;     // Catch: Throwable -> L131
        IPCAnomalyTrace.b("IFlowNetworkIDLIPC", "uploadOmniDataFeedbackByHttp", r20, r21, r112);     // Catch: Throwable -> L131
        return;
    L100:
        e = e;
    L101:
        r17 = r17;
        r7 = r31;
        r30 = r30;
        r29 = r29;
    L102:
        e = e;
        r32 = r32;
    L104:
        e = e;
        r30 = r30;
    L106:
        r29 = r29;
    L107:
        r7 = r31;
    L108:
        e = e;
        r30 = r30;
    L110:
        e = e;
    L111:
        r29 = r29;
        r30 = r30;
        r32 = r32;
        r17 = r17;
    L112:
        e = e;
        r28 = r28;
    L114:
        e = e;
    L115:
        r17 = r17;
    L116:
        r14 = r23;
    L117:
        e = e;
        r13 = r27;
    L119:
        e = e;
        r13 = r27;
        r17 = r17;
        r12 = r22;
        goto L116
    L75:
        r17 = r24;
        h.d(r17, "uploadOmniDataFeedbackByHttp = void");     // Catch: Exception -> L119 Throwable -> L131
    L121:
        e = e;
        r13 = r27;
        r28 = r28;
        r29 = r29;
        r30 = r30;
        r7 = r31;
        r32 = r32;
        r12 = r22;
        r14 = r23;
        r17 = r24;
        goto L129
    L61:
        if ((r3 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L70;
        if ((r3 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L70;
        if ((r3 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L68;
        IFlowNetworkResultCallbackIDL r43 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r3);     // Catch: Exception -> L123 Throwable -> L131
    L69:
        r110 = r43;
        goto L71
    L68:
        r43 = u2.b(r41);     // Catch: Exception -> L123 Throwable -> L131
        goto L69
    L160:
        int r44 = h.a;     // Catch: Exception -> L54 Throwable -> L131
        StringBuilder r45 = new StringBuilder(r4);     // Catch: Exception -> L54 Throwable -> L131
        r45.append(r27);     // Catch: Exception -> L54 Throwable -> L131
        r45.append(", ");     // Catch: Exception -> L54 Throwable -> L131
        r45.append(r28);     // Catch: Exception -> L54 Throwable -> L131
        r45.append(", ");     // Catch: Exception -> L54 Throwable -> L131
        r45.append(r29);     // Catch: Exception -> L54 Throwable -> L131
        r45.append(", ");     // Catch: Exception -> L54 Throwable -> L131
        r45.append(r30);     // Catch: Exception -> L54 Throwable -> L131
        r45.append(", ");     // Catch: Exception -> L54 Throwable -> L131
        r45.append(r31);     // Catch: Exception -> L54 Throwable -> L131
        r45.append(", ");     // Catch: Exception -> L54 Throwable -> L131
        r45.append(r32);     // Catch: Exception -> L54 Throwable -> L131
        r45.append(", ");     // Catch: Exception -> L54 Throwable -> L131
        r45.append(r33);     // Catch: Exception -> L54 Throwable -> L131
        r45.append(", ");     // Catch: Exception -> L54 Throwable -> L131
        r45.append(r34);     // Catch: Exception -> L54 Throwable -> L131
        r45.append(", ");     // Catch: Exception -> L54 Throwable -> L131
        r45.append(r35);     // Catch: Exception -> L54 Throwable -> L131
        r45.append(", ");     // Catch: Exception -> L54 Throwable -> L131
        r45.append(r36);     // Catch: Exception -> L54 Throwable -> L131
        r45.append(", ");     // Catch: Exception -> L54 Throwable -> L131
        r15 = r16;
        r45.append(r37);     // Catch: Exception -> L52 Throwable -> L131
        r45.append(", ");     // Catch: Exception -> L52 Throwable -> L131
        r22 = r4;
        r45.append(r38);     // Catch: Exception -> L50 Throwable -> L131
        r45.append(", ");     // Catch: Exception -> L50 Throwable -> L131
        r45.append(r39);     // Catch: Exception -> L48 Throwable -> L131
        r45.append(", ");     // Catch: Exception -> L48 Throwable -> L131
        r45.append(r40);     // Catch: Exception -> L48 Throwable -> L131
        r45.append(", ");     // Catch: Exception -> L48 Throwable -> L131
        r19 = ", ";
        if (r3 != null) goto L164;
    L46:
        IFlowNetworkResultCallbackIDL r46 = r3;
    L47:
        r45.append(r46);     // Catch: Exception -> L123 Throwable -> L131
        r45.append(r15);     // Catch: Exception -> L123 Throwable -> L131
        h.a(r5, r45.toString());     // Catch: Exception -> L123 Throwable -> L131
        goto L57
    L164:
    L123:
        e = e;
    L124:
        r17 = r5;
        r7 = r31;
        r30 = r30;
        r29 = r29;
        r25 = r15;
        r12 = r22;
        r13 = r27;
        r28 = r28;
        r14 = r19;
        goto L129
    L38:
        if ((r3 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L46;
        if ((r3 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L46;
        if ((r3 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L45;
        r46 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r3);     // Catch: Exception -> L123 Throwable -> L131
        goto L47
    L45:
        r46 = u2.b(r41);     // Catch: Exception -> L123 Throwable -> L131
    L48:
        e = e;
    L49:
        r19 = ", ";
    L50:
        e = e;
    L52:
        e = e;
        r19 = ", ";
        r22 = r4;
    L54:
        e = e;
        r22 = r4;
        r15 = r16;
    L125:
        e = e;
    L126:
        r17 = r5;
        r29 = r29;
        r13 = r27;
        r25 = r16;
        r28 = r28;
        r14 = ", ";
        r7 = r31;
        r30 = r30;
        r12 = r4;
        goto L129
    L158:
        int r47 = h.a;     // Catch: Exception -> L22 Throwable -> L131
        StringBuilder r48 = new StringBuilder("uploadOmniDataFeedbackByHttp(");     // Catch: Exception -> L22 Throwable -> L131
        r48.append(r27);     // Catch: Exception -> L22 Throwable -> L131
        r48.append(", ");     // Catch: Exception -> L22 Throwable -> L131
        r48.append(r28);     // Catch: Exception -> L22 Throwable -> L131
        r48.append(", ");     // Catch: Exception -> L22 Throwable -> L131
        r48.append(r29);     // Catch: Exception -> L22 Throwable -> L131
        r48.append(", ");     // Catch: Exception -> L22 Throwable -> L131
        r48.append(r30);     // Catch: Exception -> L22 Throwable -> L131
        r48.append(", ");     // Catch: Exception -> L22 Throwable -> L131
        r48.append(r31);     // Catch: Exception -> L22 Throwable -> L131
        r48.append(", ");     // Catch: Exception -> L22 Throwable -> L131
        r48.append(r32);     // Catch: Exception -> L22 Throwable -> L131
        r48.append(", ");     // Catch: Exception -> L22 Throwable -> L131
        r48.append(r33);     // Catch: Exception -> L22 Throwable -> L131
        r48.append(", ");     // Catch: Exception -> L22 Throwable -> L131
        r48.append(r34);     // Catch: Exception -> L22 Throwable -> L131
        r48.append(", ");     // Catch: Exception -> L22 Throwable -> L131
        r48.append(r35);     // Catch: Exception -> L22 Throwable -> L131
        r48.append(", ");     // Catch: Exception -> L22 Throwable -> L131
        r48.append(r36);     // Catch: Exception -> L22 Throwable -> L131
        r48.append(", ");     // Catch: Exception -> L22 Throwable -> L131
        r48.append(r37);     // Catch: Exception -> L22 Throwable -> L131
        r48.append(", ");     // Catch: Exception -> L22 Throwable -> L131
        r48.append(r38);     // Catch: Exception -> L22 Throwable -> L131
        r48.append(", ");     // Catch: Exception -> L22 Throwable -> L131
        r4 = "uploadOmniDataFeedbackByHttp(";
        r48.append(r39);     // Catch: Exception -> L20 Throwable -> L131
        r48.append(", ");     // Catch: Exception -> L20 Throwable -> L131
        r48.append(r40);     // Catch: Exception -> L16 Throwable -> L131
        r48.append(", ");     // Catch: Exception -> L16 Throwable -> L131
        r3 = r41;
        r48.append(r3);     // Catch: Exception -> L14 Throwable -> L131
        r48.append(r16);     // Catch: Exception -> L14 Throwable -> L131
        r16 = r16;
        r5 = r17;
        h.a(r5, r48.toString());     // Catch: Exception -> L125 Throwable -> L131
    L14:
        e = e;
    L18:
        r16 = r16;
    L19:
        r5 = r17;
    L16:
        e = e;
    L20:
        e = e;
    L22:
        e = e;
        r4 = "uploadOmniDataFeedbackByHttp(";
        r5 = r17;
    L127:
        e = e;
        r29 = r29;
        r13 = r27;
        r25 = r16;
        r28 = r28;
        r14 = ", ";
        r7 = r31;
        r30 = r30;
        r12 = "uploadOmniDataFeedbackByHttp(";
        goto L129
    }

    public void createConditionalTask(String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, Map r43, IFlowNetworkResultCallbackIDL r44) throws RemoteException {
        r32 = r32;
        r34 = r34;
        String r17 = "IFlowNetworkIDLIPC";
        String r2 = ", ";
        long r19 = SystemClock.elapsedRealtimeNanos();
        if (this.log == true) goto L172;
        String r4 = "createConditionalTask(";
        String r5 = ")";
        String r3 = r17;
    L24:
        if (this.log == true) goto L155;
        IFlowNetworkResultCallbackIDL r14 = r44;
        r2 = ", ";
        String r23 = r4;
        String r15 = r5;
    L62:
        IFlowNetworkIDL r6 = this.origin;     // Catch: Exception -> L132 Throwable -> L141
        if (r14 != null) goto L66;
    L75:
        IFlowNetworkResultCallbackIDL r18 = r14;
    L76:
        String r24 = r2;
        String r25 = r3;
        String r26 = r15;
        r6.createConditionalTask(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r18);     // Catch: Exception -> L130 Throwable -> L141
        if (this.log == true) goto L80;
        r17 = r25;
    L83:
        long r8 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L128 Throwable -> L141
        long r7 = Math.max(0, r8 - r19) / 1000;     // Catch: Exception -> L128 Throwable -> L141
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L128 Throwable -> L141
        String r12 = r23;
        StringBuilder r1 = new StringBuilder(r12);     // Catch: Exception -> L126 Throwable -> L141
        String r13 = r29;
        r1.append(r13);     // Catch: Exception -> L123 Throwable -> L141
        String r16 = r24;
        r1.append(r16);     // Catch: Exception -> L121 Throwable -> L141
        r30 = r30;
        r1.append(r30);     // Catch: Exception -> L119 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L119 Throwable -> L141
        r1.append(r31);     // Catch: Exception -> L117 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L117 Throwable -> L141
        r1.append(r32);     // Catch: Exception -> L115 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L115 Throwable -> L141
        r1.append(r33);     // Catch: Exception -> L112 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L112 Throwable -> L141
        r34 = r34;
        r1.append(r34);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r35);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r36);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r37);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r38);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r39);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r40);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r41);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r42);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r43);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r44);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(") = void");     // Catch: Exception -> L106 Throwable -> L141
        com.obric.aiagent.ipc.utils.i.b(r17, r1.toString(), r7);     // Catch: Exception -> L106 Throwable -> L141
        r17 = r17;
        String r9 = r33;
        r32 = r32;
        r31 = r31;
        IPCAnomalyTrace.a.c("IFlowNetworkIDLIPC", "createConditionalTask", r7, r8);     // Catch: Exception -> L104 Throwable -> L141
        return;
    L104:
        e = e;
    L139:
        int r10 = h.a;     // Catch: Throwable -> L141
        StringBuilder r11 = new StringBuilder(r12);     // Catch: Throwable -> L141
        r11.append(r13);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r30);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r31);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r32);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r9);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r34);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        String r20 = r31;
        r11.append(r35);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r36);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r37);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r38);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r39);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r40);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r41);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r42);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r43);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r44);     // Catch: Throwable -> L141
        r11.append(r26);     // Catch: Throwable -> L141
        String r110 = r17;
        h.b(r110, r11.toString(), e);     // Catch: Throwable -> L141
        IPCException r21 = new IPCException(e);     // Catch: Throwable -> L141
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L141
        long r22 = Math.max(0, r111 - r19) / 1000;     // Catch: Throwable -> L141
        int r27 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L141
        com.obric.aiagent.ipc.utils.i.a(r110, r12 + r13 + r16 + r30 + r16 + r20 + r16 + r32 + r16 + r9 + r16 + r34 + r16 + r35 + r16 + r36 + r16 + r37 + r16 + r38 + r16 + r39 + r16 + r40 + r16 + r41 + r16 + r42 + r16 + r43 + r16 + r44 + ") = fail", r21, r22);     // Catch: Throwable -> L141
        IPCAnomalyTrace r28 = IPCAnomalyTrace.a;     // Catch: Throwable -> L141
        IPCAnomalyTrace.b("IFlowNetworkIDLIPC", "createConditionalTask", r21, r22, r111);     // Catch: Throwable -> L141
        return;
    L106:
        e = e;
    L107:
        r32 = r32;
    L108:
        r31 = r31;
    L109:
        r9 = r33;
    L110:
        e = e;
    L114:
        r17 = r17;
        r9 = r33;
        r32 = r32;
        r31 = r31;
    L112:
        e = e;
        r34 = r34;
    L115:
        e = e;
        r34 = r34;
    L117:
        e = e;
        r32 = r32;
        r34 = r34;
    L119:
        e = e;
    L120:
        r31 = r31;
        r32 = r32;
        r34 = r34;
        r17 = r17;
    L121:
        e = e;
        r30 = r30;
    L123:
        e = e;
    L124:
        r17 = r17;
    L125:
        r16 = r24;
    L126:
        e = e;
        r13 = r29;
    L128:
        e = e;
        r13 = r29;
        r17 = r17;
        r12 = r23;
        goto L125
    L80:
        r17 = r25;
        h.d(r17, "createConditionalTask = void");     // Catch: Exception -> L128 Throwable -> L141
    L130:
        e = e;
        r13 = r29;
        r30 = r30;
        r31 = r31;
        r32 = r32;
        r9 = r33;
        r34 = r34;
        r12 = r23;
        r16 = r24;
        r17 = r25;
        goto L139
    L66:
        if ((r14 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L75;
        if ((r14 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L75;
        if ((r14 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L73;
        IFlowNetworkResultCallbackIDL r45 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r14);     // Catch: Exception -> L132 Throwable -> L141
    L74:
        r18 = r45;
        goto L76
    L73:
        r45 = u2.b(r44);     // Catch: Exception -> L132 Throwable -> L141
        goto L74
    L155:
        int r46 = h.a;     // Catch: Exception -> L59 Throwable -> L141
        StringBuilder r47 = new StringBuilder(r4);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r29);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r30);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r31);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r32);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r33);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r34);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r35);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r36);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r37);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r38);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r15 = r5;
        r47.append(r39);     // Catch: Exception -> L56 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L56 Throwable -> L141
        r23 = r4;
        r47.append(r40);     // Catch: Exception -> L54 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L54 Throwable -> L141
        r47.append(r41);     // Catch: Exception -> L51 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L51 Throwable -> L141
        r47.append(r42);     // Catch: Exception -> L51 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L51 Throwable -> L141
        r14 = r44;
        r47.append(r43);     // Catch: Exception -> L49 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L49 Throwable -> L141
        r2 = ", ";
        if (r14 != null) goto L148;
    L47:
        IFlowNetworkResultCallbackIDL r48 = r14;
    L48:
        r47.append(r48);     // Catch: Exception -> L132 Throwable -> L141
        r47.append(r15);     // Catch: Exception -> L132 Throwable -> L141
        h.a(r3, r47.toString());     // Catch: Exception -> L132 Throwable -> L141
        goto L62
    L148:
    L132:
        e = e;
    L58:
        r17 = r3;
        r9 = r33;
        r32 = r32;
        r31 = r31;
        r26 = r15;
        r16 = r2;
        r12 = r23;
        r13 = r29;
        r30 = r30;
        goto L139
    L39:
        if ((r14 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L47;
        if ((r14 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L47;
        if ((r14 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L46;
        r48 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r14);     // Catch: Exception -> L132 Throwable -> L141
        goto L48
    L46:
        r48 = u2.b(r44);     // Catch: Exception -> L132 Throwable -> L141
    L49:
        e = e;
    L53:
        r2 = ", ";
    L51:
        e = e;
    L54:
        e = e;
    L56:
        e = e;
        r23 = r4;
    L59:
        e = e;
        r23 = r4;
        r15 = r5;
    L134:
        e = e;
    L135:
        r17 = r3;
        r26 = r5;
        r12 = r4;
    L136:
        r16 = ", ";
        r9 = r33;
        r31 = r31;
        r13 = r29;
        r30 = r30;
        goto L139
    L172:
        int r49 = h.a;     // Catch: Exception -> L21 Throwable -> L141
        StringBuilder r50 = new StringBuilder("createConditionalTask(");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r29);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r30);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r31);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r32);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r33);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r34);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r35);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r36);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r37);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r38);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r39);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r40);     // Catch: Exception -> L18 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L18 Throwable -> L141
        r4 = "createConditionalTask(";
        r50.append(r41);     // Catch: Exception -> L16 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L16 Throwable -> L141
        r5 = ")";
        r50.append(r42);     // Catch: Exception -> L14 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L14 Throwable -> L141
        r50.append(r43);     // Catch: Exception -> L14 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L14 Throwable -> L141
        r50.append(r44);     // Catch: Exception -> L14 Throwable -> L141
        r50.append(r5);     // Catch: Exception -> L14 Throwable -> L141
        r3 = r17;
        h.a(r3, r50.toString());     // Catch: Exception -> L134 Throwable -> L141
    L14:
        e = e;
    L15:
        r3 = r17;
    L16:
        e = e;
    L17:
        r5 = ")";
    L18:
        e = e;
        r3 = r17;
        r23 = "createConditionalTask(";
        r15 = ")";
    L21:
        e = e;
        r4 = "createConditionalTask(";
    L137:
        e = e;
        r26 = ")";
        r12 = "createConditionalTask(";
        goto L136
    }

    public void uploadOmniDataFeedbackByHttpV2(String r29, String r30, int r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, List<String> r40, String r41, String r42, boolean r43, IFlowNetworkResultCallbackIDL r44) throws RemoteException {
        r32 = r32;
        r34 = r34;
        String r17 = "IFlowNetworkIDLIPC";
        String r2 = ", ";
        long r19 = SystemClock.elapsedRealtimeNanos();
        if (this.log == true) goto L170;
        String r4 = "uploadOmniDataFeedbackByHttpV2(";
        String r5 = ")";
        String r3 = r17;
    L24:
        if (this.log == true) goto L155;
        IFlowNetworkResultCallbackIDL r14 = r44;
        r2 = ", ";
        String r23 = r4;
        String r15 = r5;
    L62:
        IFlowNetworkIDL r6 = this.origin;     // Catch: Exception -> L132 Throwable -> L141
        if (r14 != null) goto L66;
    L75:
        IFlowNetworkResultCallbackIDL r18 = r14;
    L76:
        String r24 = r2;
        String r25 = r3;
        String r26 = r15;
        r6.uploadOmniDataFeedbackByHttpV2(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r18);     // Catch: Exception -> L130 Throwable -> L141
        if (this.log == true) goto L80;
        r17 = r25;
    L83:
        long r8 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L128 Throwable -> L141
        long r7 = Math.max(0, r8 - r19) / 1000;     // Catch: Exception -> L128 Throwable -> L141
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L128 Throwable -> L141
        String r12 = r23;
        StringBuilder r1 = new StringBuilder(r12);     // Catch: Exception -> L126 Throwable -> L141
        String r13 = r29;
        r1.append(r13);     // Catch: Exception -> L123 Throwable -> L141
        String r16 = r24;
        r1.append(r16);     // Catch: Exception -> L121 Throwable -> L141
        r30 = r30;
        r1.append(r30);     // Catch: Exception -> L119 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L119 Throwable -> L141
        r1.append(r31);     // Catch: Exception -> L117 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L117 Throwable -> L141
        r1.append(r32);     // Catch: Exception -> L115 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L115 Throwable -> L141
        r1.append(r33);     // Catch: Exception -> L112 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L112 Throwable -> L141
        r34 = r34;
        r1.append(r34);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r35);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r36);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r37);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r38);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r39);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r40);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r41);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r42);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r43);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r16);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(r44);     // Catch: Exception -> L110 Throwable -> L141
        r1.append(") = void");     // Catch: Exception -> L106 Throwable -> L141
        com.obric.aiagent.ipc.utils.i.b(r17, r1.toString(), r7);     // Catch: Exception -> L106 Throwable -> L141
        r17 = r17;
        String r9 = r33;
        r32 = r32;
        r31 = r31;
        IPCAnomalyTrace.a.c("IFlowNetworkIDLIPC", "uploadOmniDataFeedbackByHttpV2", r7, r8);     // Catch: Exception -> L104 Throwable -> L141
        return;
    L104:
        e = e;
    L139:
        int r10 = h.a;     // Catch: Throwable -> L141
        StringBuilder r11 = new StringBuilder(r12);     // Catch: Throwable -> L141
        r11.append(r13);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r30);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r31);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r32);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r9);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r34);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        int r20 = r31;
        r11.append(r35);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r36);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r37);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r38);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r39);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r40);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r41);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r42);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r43);     // Catch: Throwable -> L141
        r11.append(r16);     // Catch: Throwable -> L141
        r11.append(r44);     // Catch: Throwable -> L141
        r11.append(r26);     // Catch: Throwable -> L141
        String r110 = r17;
        h.b(r110, r11.toString(), e);     // Catch: Throwable -> L141
        IPCException r21 = new IPCException(e);     // Catch: Throwable -> L141
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L141
        long r22 = Math.max(0, r111 - r19) / 1000;     // Catch: Throwable -> L141
        int r27 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L141
        com.obric.aiagent.ipc.utils.i.a(r110, r12 + r13 + r16 + r30 + r16 + r20 + r16 + r32 + r16 + r9 + r16 + r34 + r16 + r35 + r16 + r36 + r16 + r37 + r16 + r38 + r16 + r39 + r16 + r40 + r16 + r41 + r16 + r42 + r16 + r43 + r16 + r44 + ") = fail", r21, r22);     // Catch: Throwable -> L141
        IPCAnomalyTrace r28 = IPCAnomalyTrace.a;     // Catch: Throwable -> L141
        IPCAnomalyTrace.b("IFlowNetworkIDLIPC", "uploadOmniDataFeedbackByHttpV2", r21, r22, r111);     // Catch: Throwable -> L141
        return;
    L106:
        e = e;
    L107:
        r32 = r32;
    L108:
        r31 = r31;
    L109:
        r9 = r33;
    L110:
        e = e;
    L114:
        r17 = r17;
        r9 = r33;
        r32 = r32;
        r31 = r31;
    L112:
        e = e;
        r34 = r34;
    L115:
        e = e;
        r34 = r34;
    L117:
        e = e;
        r32 = r32;
        r34 = r34;
    L119:
        e = e;
    L120:
        r31 = r31;
        r32 = r32;
        r34 = r34;
        r17 = r17;
    L121:
        e = e;
        r30 = r30;
    L123:
        e = e;
    L124:
        r17 = r17;
    L125:
        r16 = r24;
    L126:
        e = e;
        r13 = r29;
    L128:
        e = e;
        r13 = r29;
        r17 = r17;
        r12 = r23;
        goto L125
    L80:
        r17 = r25;
        h.d(r17, "uploadOmniDataFeedbackByHttpV2 = void");     // Catch: Exception -> L128 Throwable -> L141
    L130:
        e = e;
        r13 = r29;
        r30 = r30;
        r31 = r31;
        r32 = r32;
        r9 = r33;
        r34 = r34;
        r12 = r23;
        r16 = r24;
        r17 = r25;
        goto L139
    L66:
        if ((r14 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L75;
        if ((r14 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L75;
        if ((r14 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L73;
        IFlowNetworkResultCallbackIDL r45 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r14);     // Catch: Exception -> L132 Throwable -> L141
    L74:
        r18 = r45;
        goto L76
    L73:
        r45 = u2.b(r44);     // Catch: Exception -> L132 Throwable -> L141
        goto L74
    L155:
        int r46 = h.a;     // Catch: Exception -> L59 Throwable -> L141
        StringBuilder r47 = new StringBuilder(r4);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r29);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r30);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r31);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r32);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r33);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r34);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r35);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r36);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r37);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r47.append(r38);     // Catch: Exception -> L59 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L59 Throwable -> L141
        r15 = r5;
        r47.append(r39);     // Catch: Exception -> L56 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L56 Throwable -> L141
        r23 = r4;
        r47.append(r40);     // Catch: Exception -> L54 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L54 Throwable -> L141
        r47.append(r41);     // Catch: Exception -> L51 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L51 Throwable -> L141
        r47.append(r42);     // Catch: Exception -> L51 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L51 Throwable -> L141
        r14 = r44;
        r47.append(r43);     // Catch: Exception -> L49 Throwable -> L141
        r47.append(", ");     // Catch: Exception -> L49 Throwable -> L141
        r2 = ", ";
        if (r14 != null) goto L144;
    L47:
        IFlowNetworkResultCallbackIDL r48 = r14;
    L48:
        r47.append(r48);     // Catch: Exception -> L132 Throwable -> L141
        r47.append(r15);     // Catch: Exception -> L132 Throwable -> L141
        h.a(r3, r47.toString());     // Catch: Exception -> L132 Throwable -> L141
        goto L62
    L144:
    L132:
        e = e;
    L58:
        r17 = r3;
        r9 = r33;
        r32 = r32;
        r31 = r31;
        r26 = r15;
        r16 = r2;
        r12 = r23;
        r13 = r29;
        r30 = r30;
        goto L139
    L39:
        if ((r14 instanceof FlowNetworkResultCallbackIDLIpcWrapper) == true) goto L47;
        if ((r14 instanceof FlowNetworkResultCallbackIDLStubWrapper) == true) goto L47;
        if ((r14 instanceof IFlowNetworkResultCallbackIDL.Stub) == false) goto L46;
        r48 = u2.a((IFlowNetworkResultCallbackIDL.Stub) r14);     // Catch: Exception -> L132 Throwable -> L141
        goto L48
    L46:
        r48 = u2.b(r44);     // Catch: Exception -> L132 Throwable -> L141
    L49:
        e = e;
    L53:
        r2 = ", ";
    L51:
        e = e;
    L54:
        e = e;
    L56:
        e = e;
        r23 = r4;
    L59:
        e = e;
        r23 = r4;
        r15 = r5;
    L134:
        e = e;
    L135:
        r17 = r3;
        r26 = r5;
        r12 = r4;
    L136:
        r16 = ", ";
        r9 = r33;
        r31 = r31;
        r13 = r29;
        r30 = r30;
        goto L139
    L170:
        int r49 = h.a;     // Catch: Exception -> L21 Throwable -> L141
        StringBuilder r50 = new StringBuilder("uploadOmniDataFeedbackByHttpV2(");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r29);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r30);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r31);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r32);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r33);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r34);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r35);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r36);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r37);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r38);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r39);     // Catch: Exception -> L21 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L21 Throwable -> L141
        r50.append(r40);     // Catch: Exception -> L18 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L18 Throwable -> L141
        r4 = "uploadOmniDataFeedbackByHttpV2(";
        r50.append(r41);     // Catch: Exception -> L16 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L16 Throwable -> L141
        r5 = ")";
        r50.append(r42);     // Catch: Exception -> L14 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L14 Throwable -> L141
        r50.append(r43);     // Catch: Exception -> L14 Throwable -> L141
        r50.append(", ");     // Catch: Exception -> L14 Throwable -> L141
        r50.append(r44);     // Catch: Exception -> L14 Throwable -> L141
        r50.append(r5);     // Catch: Exception -> L14 Throwable -> L141
        r3 = r17;
        h.a(r3, r50.toString());     // Catch: Exception -> L134 Throwable -> L141
    L14:
        e = e;
    L15:
        r3 = r17;
    L16:
        e = e;
    L17:
        r5 = ")";
    L18:
        e = e;
        r3 = r17;
        r23 = "uploadOmniDataFeedbackByHttpV2(";
        r15 = ")";
    L21:
        e = e;
        r4 = "uploadOmniDataFeedbackByHttpV2(";
    L137:
        e = e;
        r26 = ")";
        r12 = "uploadOmniDataFeedbackByHttpV2(";
    }
}
