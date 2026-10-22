package com.obric.aiagent.assistant.idl;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowFrontierIDLIpcWrapper implements IFlowFrontierIDL {
    boolean log;
    final IFlowFrontierIDL origin;

    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public int getState() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        int r11 = 0;
    L14:
        e = move-exception;
        h.b("IFlowFrontierIDLIPC", "getState()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowFrontierIDLIPC", "getState() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowFrontierIDLIPC", "getState", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowFrontierIDLIPC", "getState()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowFrontierIDLIPC", "getState()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getState();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowFrontierIDLIPC", "getState = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowFrontierIDLIPC", "getState() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowFrontierIDLIPC", "getState", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public FlowFrontierIDLIpcWrapper(IFlowFrontierIDL r2) throws RemoteException {
        this(r2, true);
    }

    public FlowFrontierIDLIpcWrapper(IFlowFrontierIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    public void registerDataListener(int r22, IFlowFrontierDataListenerIDL r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowFrontierIDLIPC", "registerDataListener(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowFrontierIDLIPC", "registerDataListener(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowFrontierIDLIPC", "registerDataListener", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowFrontierIDLIPC", "registerDataListener(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("registerDataListener(");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r22);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L12;
    L20:
        IFlowFrontierDataListenerIDL r14 = r23;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowFrontierIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r23 instanceof FlowFrontierDataListenerIDLIpcWrapper) == true) goto L20;
        if ((r23 instanceof FlowFrontierDataListenerIDLStubWrapper) == true) goto L20;
        if ((r23 instanceof IFlowFrontierDataListenerIDL.Stub) == false) goto L19;
        r14 = q1.a((IFlowFrontierDataListenerIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = q1.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowFrontierIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L26;
    L34:
        IFlowFrontierDataListenerIDL r15 = r23;
    L35:
        r6.registerDataListener(r22, r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowFrontierIDLIPC", "registerDataListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowFrontierIDLIPC", "registerDataListener(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowFrontierIDLIPC", "registerDataListener", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r23 instanceof FlowFrontierDataListenerIDLIpcWrapper) == true) goto L34;
        if ((r23 instanceof FlowFrontierDataListenerIDLStubWrapper) == true) goto L34;
        if ((r23 instanceof IFlowFrontierDataListenerIDL.Stub) == false) goto L33;
        r15 = q1.a((IFlowFrontierDataListenerIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = q1.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void registerStateListener(int r22, IFlowFrontierStateListenerIDL r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowFrontierIDLIPC", "registerStateListener(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowFrontierIDLIPC", "registerStateListener(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowFrontierIDLIPC", "registerStateListener", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowFrontierIDLIPC", "registerStateListener(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("registerStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r22);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L12;
    L20:
        IFlowFrontierStateListenerIDL r14 = r23;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowFrontierIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r23 instanceof FlowFrontierStateListenerIDLIpcWrapper) == true) goto L20;
        if ((r23 instanceof FlowFrontierStateListenerIDLStubWrapper) == true) goto L20;
        if ((r23 instanceof IFlowFrontierStateListenerIDL.Stub) == false) goto L19;
        r14 = w1.a((IFlowFrontierStateListenerIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = w1.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowFrontierIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L26;
    L34:
        IFlowFrontierStateListenerIDL r15 = r23;
    L35:
        r6.registerStateListener(r22, r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowFrontierIDLIPC", "registerStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowFrontierIDLIPC", "registerStateListener(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowFrontierIDLIPC", "registerStateListener", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r23 instanceof FlowFrontierStateListenerIDLIpcWrapper) == true) goto L34;
        if ((r23 instanceof FlowFrontierStateListenerIDLStubWrapper) == true) goto L34;
        if ((r23 instanceof IFlowFrontierStateListenerIDL.Stub) == false) goto L33;
        r15 = w1.a((IFlowFrontierStateListenerIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = w1.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void unregisterDataListener(int r22, IFlowFrontierDataListenerIDL r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowFrontierIDLIPC", "unregisterDataListener(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowFrontierIDLIPC", "unregisterDataListener(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowFrontierIDLIPC", "unregisterDataListener", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowFrontierIDLIPC", "unregisterDataListener(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("unregisterDataListener(");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r22);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L12;
    L20:
        IFlowFrontierDataListenerIDL r14 = r23;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowFrontierIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r23 instanceof FlowFrontierDataListenerIDLIpcWrapper) == true) goto L20;
        if ((r23 instanceof FlowFrontierDataListenerIDLStubWrapper) == true) goto L20;
        if ((r23 instanceof IFlowFrontierDataListenerIDL.Stub) == false) goto L19;
        r14 = q1.a((IFlowFrontierDataListenerIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = q1.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowFrontierIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L26;
    L34:
        IFlowFrontierDataListenerIDL r15 = r23;
    L35:
        r6.unregisterDataListener(r22, r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowFrontierIDLIPC", "unregisterDataListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowFrontierIDLIPC", "unregisterDataListener(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowFrontierIDLIPC", "unregisterDataListener", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r23 instanceof FlowFrontierDataListenerIDLIpcWrapper) == true) goto L34;
        if ((r23 instanceof FlowFrontierDataListenerIDLStubWrapper) == true) goto L34;
        if ((r23 instanceof IFlowFrontierDataListenerIDL.Stub) == false) goto L33;
        r15 = q1.a((IFlowFrontierDataListenerIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = q1.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void unregisterStateListener(int r22, IFlowFrontierStateListenerIDL r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowFrontierIDLIPC", "unregisterStateListener(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowFrontierIDLIPC", "unregisterStateListener(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowFrontierIDLIPC", "unregisterStateListener", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowFrontierIDLIPC", "unregisterStateListener(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("unregisterStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r22);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L12;
    L20:
        IFlowFrontierStateListenerIDL r14 = r23;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowFrontierIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r23 instanceof FlowFrontierStateListenerIDLIpcWrapper) == true) goto L20;
        if ((r23 instanceof FlowFrontierStateListenerIDLStubWrapper) == true) goto L20;
        if ((r23 instanceof IFlowFrontierStateListenerIDL.Stub) == false) goto L19;
        r14 = w1.a((IFlowFrontierStateListenerIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = w1.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowFrontierIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L26;
    L34:
        IFlowFrontierStateListenerIDL r15 = r23;
    L35:
        r6.unregisterStateListener(r22, r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowFrontierIDLIPC", "unregisterStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowFrontierIDLIPC", "unregisterStateListener(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowFrontierIDLIPC", "unregisterStateListener", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r23 instanceof FlowFrontierStateListenerIDLIpcWrapper) == true) goto L34;
        if ((r23 instanceof FlowFrontierStateListenerIDLStubWrapper) == true) goto L34;
        if ((r23 instanceof IFlowFrontierStateListenerIDL.Stub) == false) goto L33;
        r15 = w1.a((IFlowFrontierStateListenerIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = w1.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void cacheScreenshot(int r23, Bitmap r24, Map r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r11 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowFrontierIDLIPC", "cacheScreenshot(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r10 = Math.max(0, r20 - r9) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowFrontierIDLIPC", "cacheScreenshot(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r5, r10);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowFrontierIDLIPC", "cacheScreenshot", r5, r10, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowFrontierIDLIPC", "cacheScreenshot(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowFrontierIDLIPC", "cacheScreenshot(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.cacheScreenshot(r23, r24, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowFrontierIDLIPC", "cacheScreenshot = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowFrontierIDLIPC", "cacheScreenshot(" + r23 + ", " + r24 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowFrontierIDLIPC", "cacheScreenshot", r12, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void sendData(int r23, byte[] r24, Map r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r11 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowFrontierIDLIPC", "sendData(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r10 = Math.max(0, r20 - r9) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowFrontierIDLIPC", "sendData(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r5, r10);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowFrontierIDLIPC", "sendData", r5, r10, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowFrontierIDLIPC", "sendData(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowFrontierIDLIPC", "sendData(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.sendData(r23, r24, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowFrontierIDLIPC", "sendData = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowFrontierIDLIPC", "sendData(" + r23 + ", " + r24 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowFrontierIDLIPC", "sendData", r12, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void cacheScreenshotFd(int r24, String r25, ParcelFileDescriptor r26, Map r27) throws RemoteException {
        long r10 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowFrontierIDLIPC", "cacheScreenshotFd(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r11 = Math.max(0, r17 - r10) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowFrontierIDLIPC", "cacheScreenshotFd(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ") = fail", r14, r11);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowFrontierIDLIPC", "cacheScreenshotFd", r14, r11, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowFrontierIDLIPC", "cacheScreenshotFd(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowFrontierIDLIPC", "cacheScreenshotFd(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.cacheScreenshotFd(r24, r25, r26, r27);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowFrontierIDLIPC", "cacheScreenshotFd = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r21 - r10) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowFrontierIDLIPC", "cacheScreenshotFd(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowFrontierIDLIPC", "cacheScreenshotFd", r13, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }
}
