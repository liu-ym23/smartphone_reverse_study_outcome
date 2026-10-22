package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowAssistantStateIDLIpcWrapper implements IFlowAssistantStateIDL {
    boolean log;
    final IFlowAssistantStateIDL origin;

    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public int getCurrentNightMode() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        int r11 = 0;
    L14:
        e = move-exception;
        h.b("IFlowAssistantStateIDLIPC", "getCurrentNightMode()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAssistantStateIDLIPC", "getCurrentNightMode() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAssistantStateIDLIPC", "getCurrentNightMode", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowAssistantStateIDLIPC", "getCurrentNightMode()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowAssistantStateIDLIPC", "getCurrentNightMode()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getCurrentNightMode();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowAssistantStateIDLIPC", "getCurrentNightMode = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAssistantStateIDLIPC", "getCurrentNightMode() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAssistantStateIDLIPC", "getCurrentNightMode", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public boolean isActive() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        h.b("IFlowAssistantStateIDLIPC", "isActive()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAssistantStateIDLIPC", "isActive() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAssistantStateIDLIPC", "isActive", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowAssistantStateIDLIPC", "isActive()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowAssistantStateIDLIPC", "isActive()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.isActive();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowAssistantStateIDLIPC", "isActive = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAssistantStateIDLIPC", "isActive() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAssistantStateIDLIPC", "isActive", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public boolean isBackgroundIntercepting() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        h.b("IFlowAssistantStateIDLIPC", "isBackgroundIntercepting()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAssistantStateIDLIPC", "isBackgroundIntercepting() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAssistantStateIDLIPC", "isBackgroundIntercepting", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowAssistantStateIDLIPC", "isBackgroundIntercepting()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowAssistantStateIDLIPC", "isBackgroundIntercepting()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.isBackgroundIntercepting();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowAssistantStateIDLIPC", "isBackgroundIntercepting = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAssistantStateIDLIPC", "isBackgroundIntercepting() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAssistantStateIDLIPC", "isBackgroundIntercepting", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public FlowAssistantStateIDLIpcWrapper(IFlowAssistantStateIDL r2) throws RemoteException {
        this(r2, true);
    }

    public void registerActiveStateListener(IFlowAssistantActiveStateListenerIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowAssistantStateIDLIPC", "registerActiveStateListener(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowAssistantStateIDLIPC", "registerActiveStateListener(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowAssistantStateIDLIPC", "registerActiveStateListener", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAssistantStateIDLIPC", "registerActiveStateListener(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("registerActiveStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowAssistantActiveStateListenerIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAssistantStateIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowAssistantActiveStateListenerIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowAssistantActiveStateListenerIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowAssistantActiveStateListenerIDL.Stub) == false) goto L19;
        r13 = p0.a((IFlowAssistantActiveStateListenerIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = p0.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAssistantStateIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowAssistantActiveStateListenerIDL r15 = r20;
    L35:
        r5.registerActiveStateListener(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowAssistantStateIDLIPC", "registerActiveStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowAssistantStateIDLIPC", "registerActiveStateListener(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowAssistantStateIDLIPC", "registerActiveStateListener", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r20 instanceof FlowAssistantActiveStateListenerIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowAssistantActiveStateListenerIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowAssistantActiveStateListenerIDL.Stub) == false) goto L33;
        r15 = p0.a((IFlowAssistantActiveStateListenerIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = p0.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void registerBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowAssistantStateIDLIPC", "registerBackgroundInterceptingListener(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowAssistantStateIDLIPC", "registerBackgroundInterceptingListener(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowAssistantStateIDLIPC", "registerBackgroundInterceptingListener", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAssistantStateIDLIPC", "registerBackgroundInterceptingListener(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("registerBackgroundInterceptingListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowBackgroundInterceptStateListenerIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAssistantStateIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowBackgroundInterceptStateListenerIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowBackgroundInterceptStateListenerIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowBackgroundInterceptStateListenerIDL.Stub) == false) goto L19;
        r13 = y0.a((IFlowBackgroundInterceptStateListenerIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = y0.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAssistantStateIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowBackgroundInterceptStateListenerIDL r15 = r20;
    L35:
        r5.registerBackgroundInterceptingListener(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowAssistantStateIDLIPC", "registerBackgroundInterceptingListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowAssistantStateIDLIPC", "registerBackgroundInterceptingListener(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowAssistantStateIDLIPC", "registerBackgroundInterceptingListener", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r20 instanceof FlowBackgroundInterceptStateListenerIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowBackgroundInterceptStateListenerIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowBackgroundInterceptStateListenerIDL.Stub) == false) goto L33;
        r15 = y0.a((IFlowBackgroundInterceptStateListenerIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = y0.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void registerNightModeListener(IFlowNightModeChangeListenerIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowAssistantStateIDLIPC", "registerNightModeListener(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowAssistantStateIDLIPC", "registerNightModeListener(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowAssistantStateIDLIPC", "registerNightModeListener", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAssistantStateIDLIPC", "registerNightModeListener(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("registerNightModeListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowNightModeChangeListenerIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAssistantStateIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowNightModeChangeListenerIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowNightModeChangeListenerIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowNightModeChangeListenerIDL.Stub) == false) goto L19;
        r13 = x2.a((IFlowNightModeChangeListenerIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = x2.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAssistantStateIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowNightModeChangeListenerIDL r15 = r20;
    L35:
        r5.registerNightModeListener(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowAssistantStateIDLIPC", "registerNightModeListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowAssistantStateIDLIPC", "registerNightModeListener(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowAssistantStateIDLIPC", "registerNightModeListener", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r20 instanceof FlowNightModeChangeListenerIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowNightModeChangeListenerIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowNightModeChangeListenerIDL.Stub) == false) goto L33;
        r15 = x2.a((IFlowNightModeChangeListenerIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = x2.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void registerTTSStateListener(IFlowAssistantTTSStateListenerIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowAssistantStateIDLIPC", "registerTTSStateListener(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowAssistantStateIDLIPC", "registerTTSStateListener(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowAssistantStateIDLIPC", "registerTTSStateListener", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAssistantStateIDLIPC", "registerTTSStateListener(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("registerTTSStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowAssistantTTSStateListenerIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAssistantStateIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowAssistantTTSStateListenerIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowAssistantTTSStateListenerIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowAssistantTTSStateListenerIDL.Stub) == false) goto L19;
        r13 = v0.a((IFlowAssistantTTSStateListenerIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = v0.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAssistantStateIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowAssistantTTSStateListenerIDL r15 = r20;
    L35:
        r5.registerTTSStateListener(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowAssistantStateIDLIPC", "registerTTSStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowAssistantStateIDLIPC", "registerTTSStateListener(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowAssistantStateIDLIPC", "registerTTSStateListener", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r20 instanceof FlowAssistantTTSStateListenerIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowAssistantTTSStateListenerIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowAssistantTTSStateListenerIDL.Stub) == false) goto L33;
        r15 = v0.a((IFlowAssistantTTSStateListenerIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = v0.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void unregisterActiveStateListener(IFlowAssistantActiveStateListenerIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowAssistantStateIDLIPC", "unregisterActiveStateListener(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowAssistantStateIDLIPC", "unregisterActiveStateListener(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowAssistantStateIDLIPC", "unregisterActiveStateListener", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAssistantStateIDLIPC", "unregisterActiveStateListener(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("unregisterActiveStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowAssistantActiveStateListenerIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAssistantStateIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowAssistantActiveStateListenerIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowAssistantActiveStateListenerIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowAssistantActiveStateListenerIDL.Stub) == false) goto L19;
        r13 = p0.a((IFlowAssistantActiveStateListenerIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = p0.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAssistantStateIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowAssistantActiveStateListenerIDL r15 = r20;
    L35:
        r5.unregisterActiveStateListener(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowAssistantStateIDLIPC", "unregisterActiveStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowAssistantStateIDLIPC", "unregisterActiveStateListener(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowAssistantStateIDLIPC", "unregisterActiveStateListener", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r20 instanceof FlowAssistantActiveStateListenerIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowAssistantActiveStateListenerIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowAssistantActiveStateListenerIDL.Stub) == false) goto L33;
        r15 = p0.a((IFlowAssistantActiveStateListenerIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = p0.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void unregisterBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowAssistantStateIDLIPC", "unregisterBackgroundInterceptingListener(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowAssistantStateIDLIPC", "unregisterBackgroundInterceptingListener(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowAssistantStateIDLIPC", "unregisterBackgroundInterceptingListener", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAssistantStateIDLIPC", "unregisterBackgroundInterceptingListener(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("unregisterBackgroundInterceptingListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowBackgroundInterceptStateListenerIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAssistantStateIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowBackgroundInterceptStateListenerIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowBackgroundInterceptStateListenerIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowBackgroundInterceptStateListenerIDL.Stub) == false) goto L19;
        r13 = y0.a((IFlowBackgroundInterceptStateListenerIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = y0.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAssistantStateIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowBackgroundInterceptStateListenerIDL r15 = r20;
    L35:
        r5.unregisterBackgroundInterceptingListener(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowAssistantStateIDLIPC", "unregisterBackgroundInterceptingListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowAssistantStateIDLIPC", "unregisterBackgroundInterceptingListener(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowAssistantStateIDLIPC", "unregisterBackgroundInterceptingListener", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r20 instanceof FlowBackgroundInterceptStateListenerIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowBackgroundInterceptStateListenerIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowBackgroundInterceptStateListenerIDL.Stub) == false) goto L33;
        r15 = y0.a((IFlowBackgroundInterceptStateListenerIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = y0.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void unregisterNightModeListener(IFlowNightModeChangeListenerIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowAssistantStateIDLIPC", "unregisterNightModeListener(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowAssistantStateIDLIPC", "unregisterNightModeListener(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowAssistantStateIDLIPC", "unregisterNightModeListener", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAssistantStateIDLIPC", "unregisterNightModeListener(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("unregisterNightModeListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowNightModeChangeListenerIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAssistantStateIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowNightModeChangeListenerIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowNightModeChangeListenerIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowNightModeChangeListenerIDL.Stub) == false) goto L19;
        r13 = x2.a((IFlowNightModeChangeListenerIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = x2.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAssistantStateIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowNightModeChangeListenerIDL r15 = r20;
    L35:
        r5.unregisterNightModeListener(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowAssistantStateIDLIPC", "unregisterNightModeListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowAssistantStateIDLIPC", "unregisterNightModeListener(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowAssistantStateIDLIPC", "unregisterNightModeListener", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r20 instanceof FlowNightModeChangeListenerIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowNightModeChangeListenerIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowNightModeChangeListenerIDL.Stub) == false) goto L33;
        r15 = x2.a((IFlowNightModeChangeListenerIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = x2.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void unregisterTTSStateListener(IFlowAssistantTTSStateListenerIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowAssistantStateIDLIPC", "unregisterTTSStateListener(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowAssistantStateIDLIPC", "unregisterTTSStateListener(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowAssistantStateIDLIPC", "unregisterTTSStateListener", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAssistantStateIDLIPC", "unregisterTTSStateListener(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("unregisterTTSStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowAssistantTTSStateListenerIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAssistantStateIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowAssistantTTSStateListenerIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowAssistantTTSStateListenerIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowAssistantTTSStateListenerIDL.Stub) == false) goto L19;
        r13 = v0.a((IFlowAssistantTTSStateListenerIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = v0.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAssistantStateIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowAssistantTTSStateListenerIDL r15 = r20;
    L35:
        r5.unregisterTTSStateListener(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowAssistantStateIDLIPC", "unregisterTTSStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowAssistantStateIDLIPC", "unregisterTTSStateListener(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowAssistantStateIDLIPC", "unregisterTTSStateListener", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r20 instanceof FlowAssistantTTSStateListenerIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowAssistantTTSStateListenerIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowAssistantTTSStateListenerIDL.Stub) == false) goto L33;
        r15 = v0.a((IFlowAssistantTTSStateListenerIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = v0.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public FlowAssistantStateIDLIpcWrapper(IFlowAssistantStateIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
