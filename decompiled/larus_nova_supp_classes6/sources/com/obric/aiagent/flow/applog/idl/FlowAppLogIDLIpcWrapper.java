package com.obric.aiagent.flow.applog.idl;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import com.obric.aiagent.ipc.utils.i;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowAppLogIDLIpcWrapper implements IFlowAppLogIDL {
    boolean log;
    final IFlowAppLogIDL origin;

    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public void clearLaunchService() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IFlowAppLogIDLIPC", "clearLaunchService()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        i.a("IFlowAppLogIDLIPC", "clearLaunchService() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "clearLaunchService", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowAppLogIDLIPC", "clearLaunchService()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowAppLogIDLIPC", "clearLaunchService()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.clearLaunchService();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowAppLogIDLIPC", "clearLaunchService = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFlowAppLogIDLIPC", "clearLaunchService() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "clearLaunchService", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public String getDid() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        String r11 = null;
    L14:
        e = move-exception;
        h.b("IFlowAppLogIDLIPC", "getDid()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        i.a("IFlowAppLogIDLIPC", "getDid() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "getDid", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowAppLogIDLIPC", "getDid()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowAppLogIDLIPC", "getDid()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getDid();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowAppLogIDLIPC", "getDid = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = i.a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFlowAppLogIDLIPC", "getDid() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "getDid", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public String getIid() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        String r11 = null;
    L14:
        e = move-exception;
        h.b("IFlowAppLogIDLIPC", "getIid()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        i.a("IFlowAppLogIDLIPC", "getIid() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "getIid", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowAppLogIDLIPC", "getIid()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowAppLogIDLIPC", "getIid()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getIid();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowAppLogIDLIPC", "getIid = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = i.a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFlowAppLogIDLIPC", "getIid() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "getIid", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public String getSsid() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        String r11 = null;
    L14:
        e = move-exception;
        h.b("IFlowAppLogIDLIPC", "getSsid()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        i.a("IFlowAppLogIDLIPC", "getSsid() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "getSsid", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowAppLogIDLIPC", "getSsid()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowAppLogIDLIPC", "getSsid()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getSsid();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowAppLogIDLIPC", "getSsid = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = i.a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFlowAppLogIDLIPC", "getSsid() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "getSsid", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public String getUserID() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        String r11 = null;
    L14:
        e = move-exception;
        h.b("IFlowAppLogIDLIPC", "getUserID()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        i.a("IFlowAppLogIDLIPC", "getUserID() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "getUserID", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowAppLogIDLIPC", "getUserID()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowAppLogIDLIPC", "getUserID()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getUserID();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowAppLogIDLIPC", "getUserID = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = i.a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFlowAppLogIDLIPC", "getUserID() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "getUserID", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public String getUserUniqueID() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        String r11 = null;
    L14:
        e = move-exception;
        h.b("IFlowAppLogIDLIPC", "getUserUniqueID()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        i.a("IFlowAppLogIDLIPC", "getUserUniqueID() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "getUserUniqueID", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowAppLogIDLIPC", "getUserUniqueID()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowAppLogIDLIPC", "getUserUniqueID()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getUserUniqueID();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowAppLogIDLIPC", "getUserUniqueID = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = i.a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFlowAppLogIDLIPC", "getUserUniqueID() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "getUserUniqueID", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public void onPause() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IFlowAppLogIDLIPC", "onPause()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        i.a("IFlowAppLogIDLIPC", "onPause() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "onPause", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowAppLogIDLIPC", "onPause()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowAppLogIDLIPC", "onPause()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onPause();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowAppLogIDLIPC", "onPause = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFlowAppLogIDLIPC", "onPause() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "onPause", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void onStop() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IFlowAppLogIDLIPC", "onStop()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        i.a("IFlowAppLogIDLIPC", "onStop() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "onStop", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowAppLogIDLIPC", "onStop()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowAppLogIDLIPC", "onStop()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onStop();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowAppLogIDLIPC", "onStop = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFlowAppLogIDLIPC", "onStop() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "onStop", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public FlowAppLogIDLIpcWrapper(IFlowAppLogIDL r2) throws RemoteException {
        this(r2, true);
    }

    public void addDataObserver(IFlowAppLogDataObserverIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowAppLogIDLIPC", "addDataObserver(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = i.a;     // Catch: Throwable -> L43
        i.a("IFlowAppLogIDLIPC", "addDataObserver(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "addDataObserver", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAppLogIDLIPC", "addDataObserver(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("addDataObserver(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowAppLogDataObserverIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAppLogIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowAppLogDataObserverIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowAppLogDataObserverIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowAppLogDataObserverIDL.Stub) == false) goto L19;
        r13 = c.a((IFlowAppLogDataObserverIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = c.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppLogIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowAppLogDataObserverIDL r15 = r20;
    L35:
        r5.addDataObserver(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowAppLogIDLIPC", "addDataObserver = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = i.a;     // Catch: Exception -> L40 Throwable -> L43
        i.b("IFlowAppLogIDLIPC", "addDataObserver(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "addDataObserver", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r20 instanceof FlowAppLogDataObserverIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowAppLogDataObserverIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowAppLogDataObserverIDL.Stub) == false) goto L33;
        r15 = c.a((IFlowAppLogDataObserverIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = c.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void addEventObserver(IFlowAppLogEventObserverIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowAppLogIDLIPC", "addEventObserver(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = i.a;     // Catch: Throwable -> L43
        i.a("IFlowAppLogIDLIPC", "addEventObserver(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "addEventObserver", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAppLogIDLIPC", "addEventObserver(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("addEventObserver(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowAppLogEventObserverIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAppLogIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowAppLogEventObserverIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowAppLogEventObserverIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowAppLogEventObserverIDL.Stub) == false) goto L19;
        r13 = f.a((IFlowAppLogEventObserverIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = f.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppLogIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowAppLogEventObserverIDL r15 = r20;
    L35:
        r5.addEventObserver(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowAppLogIDLIPC", "addEventObserver = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = i.a;     // Catch: Exception -> L40 Throwable -> L43
        i.b("IFlowAppLogIDLIPC", "addEventObserver(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "addEventObserver", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r20 instanceof FlowAppLogEventObserverIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowAppLogEventObserverIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowAppLogEventObserverIDL.Stub) == false) goto L33;
        r15 = f.a((IFlowAppLogEventObserverIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = f.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void addSessionHook(IFlowAppLogSessionObserverIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowAppLogIDLIPC", "addSessionHook(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = i.a;     // Catch: Throwable -> L43
        i.a("IFlowAppLogIDLIPC", "addSessionHook(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "addSessionHook", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAppLogIDLIPC", "addSessionHook(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("addSessionHook(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowAppLogSessionObserverIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAppLogIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowAppLogSessionObserverIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowAppLogSessionObserverIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowAppLogSessionObserverIDL.Stub) == false) goto L19;
        r13 = l.a((IFlowAppLogSessionObserverIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = l.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppLogIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowAppLogSessionObserverIDL r15 = r20;
    L35:
        r5.addSessionHook(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowAppLogIDLIPC", "addSessionHook = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = i.a;     // Catch: Exception -> L40 Throwable -> L43
        i.b("IFlowAppLogIDLIPC", "addSessionHook(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "addSessionHook", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r20 instanceof FlowAppLogSessionObserverIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowAppLogSessionObserverIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowAppLogSessionObserverIDL.Stub) == false) goto L33;
        r15 = l.a((IFlowAppLogSessionObserverIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = l.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void onEventV3(String r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowAppLogIDLIPC", "onEventV3(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = i.a;     // Catch: Throwable -> L17
        i.a("IFlowAppLogIDLIPC", "onEventV3(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "onEventV3", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogIDLIPC", "onEventV3(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogIDLIPC", "onEventV3(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onEventV3(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowAppLogIDLIPC", "onEventV3 = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = i.a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFlowAppLogIDLIPC", "onEventV3(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "onEventV3", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void removeDataObserver(IFlowAppLogDataObserverIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowAppLogIDLIPC", "removeDataObserver(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = i.a;     // Catch: Throwable -> L43
        i.a("IFlowAppLogIDLIPC", "removeDataObserver(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "removeDataObserver", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAppLogIDLIPC", "removeDataObserver(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("removeDataObserver(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowAppLogDataObserverIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAppLogIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowAppLogDataObserverIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowAppLogDataObserverIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowAppLogDataObserverIDL.Stub) == false) goto L19;
        r13 = c.a((IFlowAppLogDataObserverIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = c.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppLogIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowAppLogDataObserverIDL r15 = r20;
    L35:
        r5.removeDataObserver(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowAppLogIDLIPC", "removeDataObserver = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = i.a;     // Catch: Exception -> L40 Throwable -> L43
        i.b("IFlowAppLogIDLIPC", "removeDataObserver(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "removeDataObserver", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r20 instanceof FlowAppLogDataObserverIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowAppLogDataObserverIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowAppLogDataObserverIDL.Stub) == false) goto L33;
        r15 = c.a((IFlowAppLogDataObserverIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = c.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void removeEventObserver(IFlowAppLogEventObserverIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowAppLogIDLIPC", "removeEventObserver(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = i.a;     // Catch: Throwable -> L43
        i.a("IFlowAppLogIDLIPC", "removeEventObserver(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "removeEventObserver", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAppLogIDLIPC", "removeEventObserver(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("removeEventObserver(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowAppLogEventObserverIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAppLogIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowAppLogEventObserverIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowAppLogEventObserverIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowAppLogEventObserverIDL.Stub) == false) goto L19;
        r13 = f.a((IFlowAppLogEventObserverIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = f.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppLogIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowAppLogEventObserverIDL r15 = r20;
    L35:
        r5.removeEventObserver(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowAppLogIDLIPC", "removeEventObserver = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = i.a;     // Catch: Exception -> L40 Throwable -> L43
        i.b("IFlowAppLogIDLIPC", "removeEventObserver(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "removeEventObserver", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r20 instanceof FlowAppLogEventObserverIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowAppLogEventObserverIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowAppLogEventObserverIDL.Stub) == false) goto L33;
        r15 = f.a((IFlowAppLogEventObserverIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = f.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void removeSessionHook(IFlowAppLogSessionObserverIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowAppLogIDLIPC", "removeSessionHook(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = i.a;     // Catch: Throwable -> L43
        i.a("IFlowAppLogIDLIPC", "removeSessionHook(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "removeSessionHook", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAppLogIDLIPC", "removeSessionHook(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("removeSessionHook(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowAppLogSessionObserverIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAppLogIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowAppLogSessionObserverIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowAppLogSessionObserverIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowAppLogSessionObserverIDL.Stub) == false) goto L19;
        r13 = l.a((IFlowAppLogSessionObserverIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = l.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppLogIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowAppLogSessionObserverIDL r15 = r20;
    L35:
        r5.removeSessionHook(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowAppLogIDLIPC", "removeSessionHook = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = i.a;     // Catch: Exception -> L40 Throwable -> L43
        i.b("IFlowAppLogIDLIPC", "removeSessionHook(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "removeSessionHook", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r20 instanceof FlowAppLogSessionObserverIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowAppLogSessionObserverIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowAppLogSessionObserverIDL.Stub) == false) goto L33;
        r15 = l.a((IFlowAppLogSessionObserverIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = l.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void setHeaderInfo(Map r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowAppLogIDLIPC", "setHeaderInfo(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = i.a;     // Catch: Throwable -> L17
        i.a("IFlowAppLogIDLIPC", "setHeaderInfo(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "setHeaderInfo", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogIDLIPC", "setHeaderInfo(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogIDLIPC", "setHeaderInfo(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setHeaderInfo(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowAppLogIDLIPC", "setHeaderInfo = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = i.a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFlowAppLogIDLIPC", "setHeaderInfo(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "setHeaderInfo", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void setLaunchService(String r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowAppLogIDLIPC", "setLaunchService(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = i.a;     // Catch: Throwable -> L17
        i.a("IFlowAppLogIDLIPC", "setLaunchService(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "setLaunchService", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogIDLIPC", "setLaunchService(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogIDLIPC", "setLaunchService(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setLaunchService(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowAppLogIDLIPC", "setLaunchService = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = i.a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFlowAppLogIDLIPC", "setLaunchService(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "setLaunchService", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public FlowAppLogIDLIpcWrapper(IFlowAppLogIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    public void onEventV3Bundle(String r22, Bundle r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowAppLogIDLIPC", "onEventV3Bundle(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L17
        int r0 = i.a;     // Catch: Throwable -> L17
        i.a("IFlowAppLogIDLIPC", "onEventV3Bundle(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "onEventV3Bundle", r4, r9, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogIDLIPC", "onEventV3Bundle(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogIDLIPC", "onEventV3Bundle(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onEventV3Bundle(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowAppLogIDLIPC", "onEventV3Bundle = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r5 = i.a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFlowAppLogIDLIPC", "onEventV3Bundle(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "onEventV3Bundle", r14, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void onEventV3Json(String r22, String r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowAppLogIDLIPC", "onEventV3Json(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L17
        int r0 = i.a;     // Catch: Throwable -> L17
        i.a("IFlowAppLogIDLIPC", "onEventV3Json(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "onEventV3Json", r4, r9, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogIDLIPC", "onEventV3Json(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogIDLIPC", "onEventV3Json(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onEventV3Json(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowAppLogIDLIPC", "onEventV3Json = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r5 = i.a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFlowAppLogIDLIPC", "onEventV3Json(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "onEventV3Json", r14, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void onResume(String r22, int r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowAppLogIDLIPC", "onResume(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L17
        int r0 = i.a;     // Catch: Throwable -> L17
        i.a("IFlowAppLogIDLIPC", "onResume(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogIDLIPC", "onResume", r4, r9, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogIDLIPC", "onResume(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogIDLIPC", "onResume(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onResume(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowAppLogIDLIPC", "onResume = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r5 = i.a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFlowAppLogIDLIPC", "onResume(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppLogIDLIPC", "onResume", r14, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }
}
