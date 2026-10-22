package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowMessageIDLIpcWrapper implements IFlowMessageIDL {
    boolean log;
    final IFlowMessageIDL origin;

    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public String generateLocalMessageId() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        String r11 = null;
    L14:
        e = move-exception;
        h.b("IFlowMessageIDLIPC", "generateLocalMessageId()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "generateLocalMessageId() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "generateLocalMessageId", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowMessageIDLIPC", "generateLocalMessageId()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowMessageIDLIPC", "generateLocalMessageId()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.generateLocalMessageId();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowMessageIDLIPC", "generateLocalMessageId = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "generateLocalMessageId() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "generateLocalMessageId", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public FlowMessageIDLIpcWrapper(IFlowMessageIDL r2) throws RemoteException {
        this(r2, true);
    }

    public void deleteRemoteResource(List<String> r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowMessageIDLIPC", "deleteRemoteResource(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "deleteRemoteResource(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "deleteRemoteResource", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "deleteRemoteResource(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "deleteRemoteResource(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.deleteRemoteResource(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowMessageIDLIPC", "deleteRemoteResource = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "deleteRemoteResource(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "deleteRemoteResource", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public String getMainTxtContentFromMessage(IMMessage r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
        String r12 = null;
    L14:
        e = move-exception;
        int r13 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowMessageIDLIPC", "getMainTxtContentFromMessage(" + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r15 = new IPCException(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "getMainTxtContentFromMessage(" + r23 + ") = fail", r15, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "getMainTxtContentFromMessage", r15, r7, r18);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r14 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "getMainTxtContentFromMessage(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r16 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "getMainTxtContentFromMessage(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r12 = this.origin.getMainTxtContentFromMessage(r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r17 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowMessageIDLIPC", "getMainTxtContentFromMessage = " + r12);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r110 = Math.max(0, r19 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "getMainTxtContentFromMessage(" + r23 + ") = " + r12, r110);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "getMainTxtContentFromMessage", r110, r19);     // Catch: Exception -> L14 Throwable -> L17
        return r12;
    L16:
        return r12;
    }

    public boolean isConversationTtsEnabled(String r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
        boolean r12 = false;
    L14:
        e = move-exception;
        int r13 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowMessageIDLIPC", "isConversationTtsEnabled(" + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r15 = new IPCException(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "isConversationTtsEnabled(" + r23 + ") = fail", r15, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "isConversationTtsEnabled", r15, r7, r18);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r14 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "isConversationTtsEnabled(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r16 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "isConversationTtsEnabled(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r12 = this.origin.isConversationTtsEnabled(r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r17 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowMessageIDLIPC", "isConversationTtsEnabled = " + r12);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r110 = Math.max(0, r19 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "isConversationTtsEnabled(" + r23 + ") = " + r12, r110);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "isConversationTtsEnabled", r110, r19);     // Catch: Exception -> L14 Throwable -> L17
        return r12;
    L16:
        return r12;
    }

    public void registerCallback(IFlowMessageCallbackIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowMessageIDLIPC", "registerCallback(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "registerCallback(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "registerCallback", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", "registerCallback(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("registerCallback(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowMessageCallbackIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowMessageCallbackIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowMessageCallbackIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowMessageCallbackIDL.Stub) == false) goto L19;
        r13 = i2.a((IFlowMessageCallbackIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = i2.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowMessageCallbackIDL r15 = r20;
    L35:
        r5.registerCallback(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowMessageIDLIPC", "registerCallback = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "registerCallback(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "registerCallback", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r20 instanceof FlowMessageCallbackIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowMessageCallbackIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowMessageCallbackIDL.Stub) == false) goto L33;
        r15 = i2.a((IFlowMessageCallbackIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = i2.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void registerSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowMessageIDLIPC", "registerSendMessageExtCallback(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "registerSendMessageExtCallback(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "registerSendMessageExtCallback", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", "registerSendMessageExtCallback(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("registerSendMessageExtCallback(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowSendMessageExtCallbackIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowSendMessageExtCallbackIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowSendMessageExtCallbackIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowSendMessageExtCallbackIDL.Stub) == false) goto L19;
        r13 = j3.a((IFlowSendMessageExtCallbackIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = j3.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowSendMessageExtCallbackIDL r15 = r20;
    L35:
        r5.registerSendMessageExtCallback(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowMessageIDLIPC", "registerSendMessageExtCallback = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "registerSendMessageExtCallback(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "registerSendMessageExtCallback", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r20 instanceof FlowSendMessageExtCallbackIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowSendMessageExtCallbackIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowSendMessageExtCallbackIDL.Stub) == false) goto L33;
        r15 = j3.a((IFlowSendMessageExtCallbackIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = j3.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void registerStreamObserver(IFlowStreamObserverIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowMessageIDLIPC", "registerStreamObserver(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "registerStreamObserver(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "registerStreamObserver", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", "registerStreamObserver(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("registerStreamObserver(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowStreamObserverIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowStreamObserverIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowStreamObserverIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowStreamObserverIDL.Stub) == false) goto L19;
        r13 = p3.a((IFlowStreamObserverIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = p3.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowStreamObserverIDL r15 = r20;
    L35:
        r5.registerStreamObserver(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowMessageIDLIPC", "registerStreamObserver = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "registerStreamObserver(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "registerStreamObserver", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r20 instanceof FlowStreamObserverIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowStreamObserverIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowStreamObserverIDL.Stub) == false) goto L33;
        r15 = p3.a((IFlowStreamObserverIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = p3.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void retryFetchMessage(IMMessage r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowMessageIDLIPC", "retryFetchMessage(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "retryFetchMessage(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "retryFetchMessage", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "retryFetchMessage(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "retryFetchMessage(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.retryFetchMessage(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowMessageIDLIPC", "retryFetchMessage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "retryFetchMessage(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "retryFetchMessage", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void unregisterCallback(IFlowMessageCallbackIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowMessageIDLIPC", "unregisterCallback(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "unregisterCallback(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "unregisterCallback", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", "unregisterCallback(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("unregisterCallback(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowMessageCallbackIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowMessageCallbackIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowMessageCallbackIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowMessageCallbackIDL.Stub) == false) goto L19;
        r13 = i2.a((IFlowMessageCallbackIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = i2.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowMessageCallbackIDL r15 = r20;
    L35:
        r5.unregisterCallback(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowMessageIDLIPC", "unregisterCallback = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "unregisterCallback(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "unregisterCallback", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r20 instanceof FlowMessageCallbackIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowMessageCallbackIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowMessageCallbackIDL.Stub) == false) goto L33;
        r15 = i2.a((IFlowMessageCallbackIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = i2.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void unregisterSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowMessageIDLIPC", "unregisterSendMessageExtCallback(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "unregisterSendMessageExtCallback(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "unregisterSendMessageExtCallback", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", "unregisterSendMessageExtCallback(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("unregisterSendMessageExtCallback(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowSendMessageExtCallbackIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowSendMessageExtCallbackIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowSendMessageExtCallbackIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowSendMessageExtCallbackIDL.Stub) == false) goto L19;
        r13 = j3.a((IFlowSendMessageExtCallbackIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = j3.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowSendMessageExtCallbackIDL r15 = r20;
    L35:
        r5.unregisterSendMessageExtCallback(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowMessageIDLIPC", "unregisterSendMessageExtCallback = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "unregisterSendMessageExtCallback(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "unregisterSendMessageExtCallback", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r20 instanceof FlowSendMessageExtCallbackIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowSendMessageExtCallbackIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowSendMessageExtCallbackIDL.Stub) == false) goto L33;
        r15 = j3.a((IFlowSendMessageExtCallbackIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = j3.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void unregisterStreamObserver(IFlowStreamObserverIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowMessageIDLIPC", "unregisterStreamObserver(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "unregisterStreamObserver(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "unregisterStreamObserver", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", "unregisterStreamObserver(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("unregisterStreamObserver(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowStreamObserverIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowStreamObserverIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowStreamObserverIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowStreamObserverIDL.Stub) == false) goto L19;
        r13 = p3.a((IFlowStreamObserverIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = p3.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowStreamObserverIDL r15 = r20;
    L35:
        r5.unregisterStreamObserver(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowMessageIDLIPC", "unregisterStreamObserver = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "unregisterStreamObserver(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "unregisterStreamObserver", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r20 instanceof FlowStreamObserverIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowStreamObserverIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowStreamObserverIDL.Stub) == false) goto L33;
        r15 = p3.a((IFlowStreamObserverIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = p3.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public FlowMessageIDLIpcWrapper(IFlowMessageIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    public void appendMessageExt(String r22, Map r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowMessageIDLIPC", "appendMessageExt(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "appendMessageExt(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "appendMessageExt", r4, r9, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "appendMessageExt(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "appendMessageExt(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.appendMessageExt(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowMessageIDLIPC", "appendMessageExt = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r5 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "appendMessageExt(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "appendMessageExt", r14, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void deleteMessage(String r22, IFlowDeleteMessageCallbackIDL r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowMessageIDLIPC", "deleteMessage(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "deleteMessage(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "deleteMessage", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", "deleteMessage(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("deleteMessage(");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r22);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L12;
    L20:
        IFlowDeleteMessageCallbackIDL r14 = r23;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r23 instanceof FlowDeleteMessageCallbackIDLIpcWrapper) == true) goto L20;
        if ((r23 instanceof FlowDeleteMessageCallbackIDLStubWrapper) == true) goto L20;
        if ((r23 instanceof IFlowDeleteMessageCallbackIDL.Stub) == false) goto L19;
        r14 = e1.a((IFlowDeleteMessageCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = e1.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L26;
    L34:
        IFlowDeleteMessageCallbackIDL r15 = r23;
    L35:
        r6.deleteMessage(r22, r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowMessageIDLIPC", "deleteMessage = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "deleteMessage(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "deleteMessage", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r23 instanceof FlowDeleteMessageCallbackIDLIpcWrapper) == true) goto L34;
        if ((r23 instanceof FlowDeleteMessageCallbackIDLStubWrapper) == true) goto L34;
        if ((r23 instanceof IFlowDeleteMessageCallbackIDL.Stub) == false) goto L33;
        r15 = e1.a((IFlowDeleteMessageCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = e1.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void fetchLatestMessages(int r22, IFlowFindMessagesCallbackIDL r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowMessageIDLIPC", "fetchLatestMessages(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "fetchLatestMessages(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "fetchLatestMessages", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", "fetchLatestMessages(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("fetchLatestMessages(");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r22);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L12;
    L20:
        IFlowFindMessagesCallbackIDL r14 = r23;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r23 instanceof FlowFindMessagesCallbackIDLIpcWrapper) == true) goto L20;
        if ((r23 instanceof FlowFindMessagesCallbackIDLStubWrapper) == true) goto L20;
        if ((r23 instanceof IFlowFindMessagesCallbackIDL.Stub) == false) goto L19;
        r14 = n1.a((IFlowFindMessagesCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = n1.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L26;
    L34:
        IFlowFindMessagesCallbackIDL r15 = r23;
    L35:
        r6.fetchLatestMessages(r22, r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowMessageIDLIPC", "fetchLatestMessages = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "fetchLatestMessages(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "fetchLatestMessages", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r23 instanceof FlowFindMessagesCallbackIDLIpcWrapper) == true) goto L34;
        if ((r23 instanceof FlowFindMessagesCallbackIDLStubWrapper) == true) goto L34;
        if ((r23 instanceof IFlowFindMessagesCallbackIDL.Stub) == false) goto L33;
        r15 = n1.a((IFlowFindMessagesCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = n1.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void findAnswersbyQueryId(String r22, IFlowFindMessagesCallbackIDL r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowMessageIDLIPC", "findAnswersbyQueryId(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "findAnswersbyQueryId(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "findAnswersbyQueryId", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", "findAnswersbyQueryId(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("findAnswersbyQueryId(");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r22);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L12;
    L20:
        IFlowFindMessagesCallbackIDL r14 = r23;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r23 instanceof FlowFindMessagesCallbackIDLIpcWrapper) == true) goto L20;
        if ((r23 instanceof FlowFindMessagesCallbackIDLStubWrapper) == true) goto L20;
        if ((r23 instanceof IFlowFindMessagesCallbackIDL.Stub) == false) goto L19;
        r14 = n1.a((IFlowFindMessagesCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = n1.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L26;
    L34:
        IFlowFindMessagesCallbackIDL r15 = r23;
    L35:
        r6.findAnswersbyQueryId(r22, r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowMessageIDLIPC", "findAnswersbyQueryId = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "findAnswersbyQueryId(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "findAnswersbyQueryId", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r23 instanceof FlowFindMessagesCallbackIDLIpcWrapper) == true) goto L34;
        if ((r23 instanceof FlowFindMessagesCallbackIDLStubWrapper) == true) goto L34;
        if ((r23 instanceof IFlowFindMessagesCallbackIDL.Stub) == false) goto L33;
        r15 = n1.a((IFlowFindMessagesCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = n1.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void findMessagebyId(String r22, IFlowFindMessageCallbackIDL r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowMessageIDLIPC", "findMessagebyId(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "findMessagebyId(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "findMessagebyId", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", "findMessagebyId(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("findMessagebyId(");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r22);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L12;
    L20:
        IFlowFindMessageCallbackIDL r14 = r23;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r23 instanceof FlowFindMessageCallbackIDLIpcWrapper) == true) goto L20;
        if ((r23 instanceof FlowFindMessageCallbackIDLStubWrapper) == true) goto L20;
        if ((r23 instanceof IFlowFindMessageCallbackIDL.Stub) == false) goto L19;
        r14 = k1.a((IFlowFindMessageCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = k1.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L26;
    L34:
        IFlowFindMessageCallbackIDL r15 = r23;
    L35:
        r6.findMessagebyId(r22, r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowMessageIDLIPC", "findMessagebyId = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "findMessagebyId(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "findMessagebyId", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r23 instanceof FlowFindMessageCallbackIDLIpcWrapper) == true) goto L34;
        if ((r23 instanceof FlowFindMessageCallbackIDLStubWrapper) == true) goto L34;
        if ((r23 instanceof IFlowFindMessageCallbackIDL.Stub) == false) goto L33;
        r15 = k1.a((IFlowFindMessageCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = k1.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void getMainTxtContentForMessage(String r22, IFlowMessageMainTextBlockCallbackIDL r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowMessageIDLIPC", "getMainTxtContentForMessage(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "getMainTxtContentForMessage(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "getMainTxtContentForMessage", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", "getMainTxtContentForMessage(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("getMainTxtContentForMessage(");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r22);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L12;
    L20:
        IFlowMessageMainTextBlockCallbackIDL r14 = r23;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r23 instanceof FlowMessageMainTextBlockCallbackIDLIpcWrapper) == true) goto L20;
        if ((r23 instanceof FlowMessageMainTextBlockCallbackIDLStubWrapper) == true) goto L20;
        if ((r23 instanceof IFlowMessageMainTextBlockCallbackIDL.Stub) == false) goto L19;
        r14 = o2.a((IFlowMessageMainTextBlockCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = o2.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L26;
    L34:
        IFlowMessageMainTextBlockCallbackIDL r15 = r23;
    L35:
        r6.getMainTxtContentForMessage(r22, r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowMessageIDLIPC", "getMainTxtContentForMessage = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "getMainTxtContentForMessage(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "getMainTxtContentForMessage", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r23 instanceof FlowMessageMainTextBlockCallbackIDLIpcWrapper) == true) goto L34;
        if ((r23 instanceof FlowMessageMainTextBlockCallbackIDLStubWrapper) == true) goto L34;
        if ((r23 instanceof IFlowMessageMainTextBlockCallbackIDL.Stub) == false) goto L33;
        r15 = o2.a((IFlowMessageMainTextBlockCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = o2.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void imageXUpload(String r22, IImageXUploadCallbackIDL r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowMessageIDLIPC", "imageXUpload(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "imageXUpload(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "imageXUpload", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", "imageXUpload(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("imageXUpload(");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r22);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L12;
    L20:
        IImageXUploadCallbackIDL r14 = r23;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r23 instanceof ImageXUploadCallbackIDLIpcWrapper) == true) goto L20;
        if ((r23 instanceof ImageXUploadCallbackIDLStubWrapper) == true) goto L20;
        if ((r23 instanceof IImageXUploadCallbackIDL.Stub) == false) goto L19;
        r14 = b4.a((IImageXUploadCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = b4.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L26;
    L34:
        IImageXUploadCallbackIDL r15 = r23;
    L35:
        r6.imageXUpload(r22, r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowMessageIDLIPC", "imageXUpload = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "imageXUpload(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "imageXUpload", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r23 instanceof ImageXUploadCallbackIDLIpcWrapper) == true) goto L34;
        if ((r23 instanceof ImageXUploadCallbackIDLStubWrapper) == true) goto L34;
        if ((r23 instanceof IImageXUploadCallbackIDL.Stub) == false) goto L33;
        r15 = b4.a((IImageXUploadCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = b4.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void isMessageLocalInterrupted(String r22, IFlowIsMessageInterruptedCallbackIDL r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowMessageIDLIPC", "isMessageLocalInterrupted(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "isMessageLocalInterrupted(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "isMessageLocalInterrupted", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", "isMessageLocalInterrupted(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("isMessageLocalInterrupted(");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r22);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L12;
    L20:
        IFlowIsMessageInterruptedCallbackIDL r14 = r23;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r23 instanceof FlowIsMessageInterruptedCallbackIDLIpcWrapper) == true) goto L20;
        if ((r23 instanceof FlowIsMessageInterruptedCallbackIDLStubWrapper) == true) goto L20;
        if ((r23 instanceof IFlowIsMessageInterruptedCallbackIDL.Stub) == false) goto L19;
        r14 = f2.a((IFlowIsMessageInterruptedCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = f2.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L26;
    L34:
        IFlowIsMessageInterruptedCallbackIDL r15 = r23;
    L35:
        r6.isMessageLocalInterrupted(r22, r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowMessageIDLIPC", "isMessageLocalInterrupted = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "isMessageLocalInterrupted(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "isMessageLocalInterrupted", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r23 instanceof FlowIsMessageInterruptedCallbackIDLIpcWrapper) == true) goto L34;
        if ((r23 instanceof FlowIsMessageInterruptedCallbackIDLStubWrapper) == true) goto L34;
        if ((r23 instanceof IFlowIsMessageInterruptedCallbackIDL.Stub) == false) goto L33;
        r15 = f2.a((IFlowIsMessageInterruptedCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = f2.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void refreshLatestMessages(String r22, int r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowMessageIDLIPC", "refreshLatestMessages(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "refreshLatestMessages(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "refreshLatestMessages", r4, r9, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "refreshLatestMessages(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "refreshLatestMessages(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.refreshLatestMessages(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowMessageIDLIPC", "refreshLatestMessages = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r5 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "refreshLatestMessages(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "refreshLatestMessages", r14, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void registerCallbackWithEvents(IFlowMessageCallbackIDL r22, int r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowMessageIDLIPC", "registerCallbackWithEvents(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "registerCallbackWithEvents(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "registerCallbackWithEvents", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", "registerCallbackWithEvents(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("registerCallbackWithEvents(");     // Catch: Exception -> L40 Throwable -> L43
        if (r22 != null) goto L12;
    L20:
        IFlowMessageCallbackIDL r14 = r22;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r23);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r22 instanceof FlowMessageCallbackIDLIpcWrapper) == true) goto L20;
        if ((r22 instanceof FlowMessageCallbackIDLStubWrapper) == true) goto L20;
        if ((r22 instanceof IFlowMessageCallbackIDL.Stub) == false) goto L19;
        r14 = i2.a((IFlowMessageCallbackIDL.Stub) r22);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = i2.b(r22);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r22 != null) goto L26;
    L34:
        IFlowMessageCallbackIDL r15 = r22;
    L35:
        r6.registerCallbackWithEvents(r15, r23);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowMessageIDLIPC", "registerCallbackWithEvents = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "registerCallbackWithEvents(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "registerCallbackWithEvents", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r22 instanceof FlowMessageCallbackIDLIpcWrapper) == true) goto L34;
        if ((r22 instanceof FlowMessageCallbackIDLStubWrapper) == true) goto L34;
        if ((r22 instanceof IFlowMessageCallbackIDL.Stub) == false) goto L33;
        r15 = i2.a((IFlowMessageCallbackIDL.Stub) r22);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = i2.b(r22);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void updateMessageExt(String r22, Map r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowMessageIDLIPC", "updateMessageExt(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "updateMessageExt(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "updateMessageExt", r4, r9, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "updateMessageExt(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "updateMessageExt(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.updateMessageExt(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowMessageIDLIPC", "updateMessageExt = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r5 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "updateMessageExt(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "updateMessageExt", r14, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void updateMutableMessageContent(String r22, String r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowMessageIDLIPC", "updateMutableMessageContent(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "updateMutableMessageContent(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "updateMutableMessageContent", r4, r9, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "updateMutableMessageContent(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "updateMutableMessageContent(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.updateMutableMessageContent(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowMessageIDLIPC", "updateMutableMessageContent = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r5 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "updateMutableMessageContent(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "updateMutableMessageContent", r14, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void addMessage(IMMessage r23, String r24, String r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r11 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowMessageIDLIPC", "addMessage(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r10 = Math.max(0, r20 - r9) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "addMessage(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r5, r10);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "addMessage", r5, r10, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "addMessage(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "addMessage(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.addMessage(r23, r24, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowMessageIDLIPC", "addMessage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "addMessage(" + r23 + ", " + r24 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "addMessage", r12, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void updateMutableWidgetRenderData(String r23, String r24, String r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r11 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowMessageIDLIPC", "updateMutableWidgetRenderData(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r10 = Math.max(0, r20 - r9) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "updateMutableWidgetRenderData(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r5, r10);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "updateMutableWidgetRenderData", r5, r10, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "updateMutableWidgetRenderData(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "updateMutableWidgetRenderData(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.updateMutableWidgetRenderData(r23, r24, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowMessageIDLIPC", "updateMutableWidgetRenderData = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "updateMutableWidgetRenderData(" + r23 + ", " + r24 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "updateMutableWidgetRenderData", r12, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void uploadImage(String r23, String r24, IImageXUploadCallbackIDL r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r11 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowMessageIDLIPC", "uploadImage(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L43
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L43
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r10 = Math.max(0, r20 - r9) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "uploadImage(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r5, r10);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "uploadImage", r5, r10, r20);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", "uploadImage(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("uploadImage(");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r23);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r24);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r25 != null) goto L12;
    L20:
        IImageXUploadCallbackIDL r15 = r25;
    L21:
        r4.append(r15);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r25 instanceof ImageXUploadCallbackIDLIpcWrapper) == true) goto L20;
        if ((r25 instanceof ImageXUploadCallbackIDLStubWrapper) == true) goto L20;
        if ((r25 instanceof IImageXUploadCallbackIDL.Stub) == false) goto L19;
        r15 = b4.a((IImageXUploadCallbackIDL.Stub) r25);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = b4.b(r25);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r25 != null) goto L26;
    L34:
        IImageXUploadCallbackIDL r16 = r25;
    L35:
        r6.uploadImage(r23, r24, r16);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowMessageIDLIPC", "uploadImage = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "uploadImage(" + r23 + ", " + r24 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "uploadImage", r12, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r25 instanceof ImageXUploadCallbackIDLIpcWrapper) == true) goto L34;
        if ((r25 instanceof ImageXUploadCallbackIDLStubWrapper) == true) goto L34;
        if ((r25 instanceof IImageXUploadCallbackIDL.Stub) == false) goto L33;
        r16 = b4.a((IImageXUploadCallbackIDL.Stub) r25);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r16 = b4.b(r25);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void notifySemanticUserEditEvent(String r26, String r27, Map r28, IFlowSemanticEditCallbackIDL r29) throws RemoteException {
        long r10 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowMessageIDLIPC", "notifySemanticUserEditEvent(" + r26 + ", " + r27 + ", " + r28 + ", " + r29 + ")", e);     // Catch: Throwable -> L43
        IPCException r6 = new IPCException(e);     // Catch: Throwable -> L43
        long r23 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r11 = Math.max(0, r23 - r10) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "notifySemanticUserEditEvent(" + r26 + ", " + r27 + ", " + r28 + ", " + r29 + ") = fail", r6, r11);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "notifySemanticUserEditEvent", r6, r11, r23);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", "notifySemanticUserEditEvent(" + r26 + ", " + r27 + ", " + r28 + ", " + r29 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("notifySemanticUserEditEvent(");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r26);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r27);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r28);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r29 != null) goto L12;
    L20:
        IFlowSemanticEditCallbackIDL r13 = r29;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowMessageIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r29 instanceof FlowSemanticEditCallbackIDLIpcWrapper) == true) goto L20;
        if ((r29 instanceof FlowSemanticEditCallbackIDLStubWrapper) == true) goto L20;
        if ((r29 instanceof IFlowSemanticEditCallbackIDL.Stub) == false) goto L19;
        r13 = g3.a((IFlowSemanticEditCallbackIDL.Stub) r29);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = g3.b(r29);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r29 != null) goto L26;
    L34:
        IFlowSemanticEditCallbackIDL r14 = r29;
    L35:
        r5.notifySemanticUserEditEvent(r26, r27, r28, r14);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowMessageIDLIPC", "notifySemanticUserEditEvent = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r24 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r15 = Math.max(0, r24 - r10) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "notifySemanticUserEditEvent(" + r26 + ", " + r27 + ", " + r28 + ", " + r29 + ") = void", r15);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "notifySemanticUserEditEvent", r15, r24);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r29 instanceof FlowSemanticEditCallbackIDLIpcWrapper) == true) goto L34;
        if ((r29 instanceof FlowSemanticEditCallbackIDLStubWrapper) == true) goto L34;
        if ((r29 instanceof IFlowSemanticEditCallbackIDL.Stub) == false) goto L33;
        r14 = g3.a((IFlowSemanticEditCallbackIDL.Stub) r29);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r14 = g3.b(r29);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void sendMessage(String r24, String r25, String r26, String r27) throws RemoteException {
        long r10 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowMessageIDLIPC", "sendMessage(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r11 = Math.max(0, r17 - r10) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", "sendMessage(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ") = fail", r14, r11);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "sendMessage", r14, r11, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "sendMessage(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowMessageIDLIPC", "sendMessage(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.sendMessage(r24, r25, r26, r27);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowMessageIDLIPC", "sendMessage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r21 - r10) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", "sendMessage(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "sendMessage", r13, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void notifySemanticUserEditEventWithIdentifier(String r30, String r31, String r32, Map r33, IFlowSemanticEditCallbackIDL r34) throws RemoteException {
        long r16 = SystemClock.elapsedRealtimeNanos();
    L52:
        e = e;
        String r4 = "notifySemanticUserEditEventWithIdentifier(";
        String r20 = ")";
        long r6 = 0;
        IFlowSemanticEditCallbackIDL r5 = r34;
    L54:
        int r2 = h.a;     // Catch: Throwable -> L56
        h.b("IFlowMessageIDLIPC", r4 + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r5 + r20, e);     // Catch: Throwable -> L56
        IPCException r3 = new IPCException(e);     // Catch: Throwable -> L56
        long r25 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L56
        long r7 = Math.max(r6, r25 - r16) / 1000;     // Catch: Throwable -> L56
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L56
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", r4 + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r5 + ") = fail", r3, r7);     // Catch: Throwable -> L56
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L56
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithIdentifier", r3, r7, r25);     // Catch: Throwable -> L56
        return;
    L4:
        if (this.log == false) goto L7;
        int r8 = h.a;     // Catch: Exception -> L52 Throwable -> L56
        h.a("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithIdentifier(" + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r34 + ")");     // Catch: Exception -> L52 Throwable -> L56
    L7:
        if (this.log == false) goto L22;
        int r9 = h.a;     // Catch: Exception -> L52 Throwable -> L56
        StringBuilder r10 = new StringBuilder("notifySemanticUserEditEventWithIdentifier(");     // Catch: Exception -> L52 Throwable -> L56
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
        IFlowSemanticEditCallbackIDL r11 = r34;
    L21:
        r10.append(r11);     // Catch: Exception -> L52 Throwable -> L56
        r10.append(")");     // Catch: Exception -> L52 Throwable -> L56
        h.a("IFlowMessageIDLIPC", r10.toString());     // Catch: Exception -> L52 Throwable -> L56
        goto L22
    L12:
        if ((r34 instanceof FlowSemanticEditCallbackIDLIpcWrapper) == true) goto L20;
        if ((r34 instanceof FlowSemanticEditCallbackIDLStubWrapper) == true) goto L20;
        if ((r34 instanceof IFlowSemanticEditCallbackIDL.Stub) == false) goto L19;
        r11 = g3.a((IFlowSemanticEditCallbackIDL.Stub) r34);     // Catch: Exception -> L52 Throwable -> L56
        goto L21
    L19:
        r11 = g3.b(r34);     // Catch: Exception -> L52 Throwable -> L56
    L22:
        IFlowMessageIDL r12 = this.origin;     // Catch: Exception -> L52 Throwable -> L56
        if (r34 != null) goto L26;
    L35:
        IFlowSemanticEditCallbackIDL r13 = r34;
    L36:
        r20 = ")";
        r12.notifySemanticUserEditEventWithIdentifier(r30, r31, r32, r33, r13);     // Catch: Exception -> L50 Throwable -> L56
        if (this.log == false) goto L40;
        h.d("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithIdentifier = void");     // Catch: Exception -> L50 Throwable -> L56
    L40:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L50 Throwable -> L56
        long r14 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L50 Throwable -> L56
        int r15 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L50 Throwable -> L56
        r4 = "notifySemanticUserEditEventWithIdentifier(";
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
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", r17.toString(), r14);     // Catch: Exception -> L46 Throwable -> L56
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithIdentifier", r14, r27);     // Catch: Exception -> L46 Throwable -> L56
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
        r4 = "notifySemanticUserEditEventWithIdentifier(";
        goto L54
    L26:
        if ((r34 instanceof FlowSemanticEditCallbackIDLIpcWrapper) == true) goto L35;
        if ((r34 instanceof FlowSemanticEditCallbackIDLStubWrapper) == true) goto L35;
        if ((r34 instanceof IFlowSemanticEditCallbackIDL.Stub) == false) goto L33;
        r13 = g3.a((IFlowSemanticEditCallbackIDL.Stub) r34);     // Catch: Exception -> L52 Throwable -> L56
        goto L36
    L33:
        r13 = g3.b(r34);     // Catch: Exception -> L52 Throwable -> L56
    }

    public void notifySemanticUserEditEventWithUri(String r30, String r31, String r32, Map r33, IFlowSemanticEditCallbackIDL r34) throws RemoteException {
        long r16 = SystemClock.elapsedRealtimeNanos();
    L52:
        e = e;
        String r4 = "notifySemanticUserEditEventWithUri(";
        String r20 = ")";
        long r6 = 0;
        IFlowSemanticEditCallbackIDL r5 = r34;
    L54:
        int r2 = h.a;     // Catch: Throwable -> L56
        h.b("IFlowMessageIDLIPC", r4 + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r5 + r20, e);     // Catch: Throwable -> L56
        IPCException r3 = new IPCException(e);     // Catch: Throwable -> L56
        long r25 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L56
        long r7 = Math.max(r6, r25 - r16) / 1000;     // Catch: Throwable -> L56
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L56
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", r4 + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r5 + ") = fail", r3, r7);     // Catch: Throwable -> L56
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L56
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithUri", r3, r7, r25);     // Catch: Throwable -> L56
        return;
    L4:
        if (this.log == false) goto L7;
        int r8 = h.a;     // Catch: Exception -> L52 Throwable -> L56
        h.a("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithUri(" + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r34 + ")");     // Catch: Exception -> L52 Throwable -> L56
    L7:
        if (this.log == false) goto L22;
        int r9 = h.a;     // Catch: Exception -> L52 Throwable -> L56
        StringBuilder r10 = new StringBuilder("notifySemanticUserEditEventWithUri(");     // Catch: Exception -> L52 Throwable -> L56
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
        IFlowSemanticEditCallbackIDL r11 = r34;
    L21:
        r10.append(r11);     // Catch: Exception -> L52 Throwable -> L56
        r10.append(")");     // Catch: Exception -> L52 Throwable -> L56
        h.a("IFlowMessageIDLIPC", r10.toString());     // Catch: Exception -> L52 Throwable -> L56
        goto L22
    L12:
        if ((r34 instanceof FlowSemanticEditCallbackIDLIpcWrapper) == true) goto L20;
        if ((r34 instanceof FlowSemanticEditCallbackIDLStubWrapper) == true) goto L20;
        if ((r34 instanceof IFlowSemanticEditCallbackIDL.Stub) == false) goto L19;
        r11 = g3.a((IFlowSemanticEditCallbackIDL.Stub) r34);     // Catch: Exception -> L52 Throwable -> L56
        goto L21
    L19:
        r11 = g3.b(r34);     // Catch: Exception -> L52 Throwable -> L56
    L22:
        IFlowMessageIDL r12 = this.origin;     // Catch: Exception -> L52 Throwable -> L56
        if (r34 != null) goto L26;
    L35:
        IFlowSemanticEditCallbackIDL r13 = r34;
    L36:
        r20 = ")";
        r12.notifySemanticUserEditEventWithUri(r30, r31, r32, r33, r13);     // Catch: Exception -> L50 Throwable -> L56
        if (this.log == false) goto L40;
        h.d("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithUri = void");     // Catch: Exception -> L50 Throwable -> L56
    L40:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L50 Throwable -> L56
        long r14 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L50 Throwable -> L56
        int r15 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L50 Throwable -> L56
        r4 = "notifySemanticUserEditEventWithUri(";
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
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", r17.toString(), r14);     // Catch: Exception -> L46 Throwable -> L56
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithUri", r14, r27);     // Catch: Exception -> L46 Throwable -> L56
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
        r4 = "notifySemanticUserEditEventWithUri(";
        goto L54
    L26:
        if ((r34 instanceof FlowSemanticEditCallbackIDLIpcWrapper) == true) goto L35;
        if ((r34 instanceof FlowSemanticEditCallbackIDLStubWrapper) == true) goto L35;
        if ((r34 instanceof IFlowSemanticEditCallbackIDL.Stub) == false) goto L33;
        r13 = g3.a((IFlowSemanticEditCallbackIDL.Stub) r34);     // Catch: Exception -> L52 Throwable -> L56
        goto L36
    L33:
        r13 = g3.b(r34);     // Catch: Exception -> L52 Throwable -> L56
    }

    public void sendMessageWithExtra(String r30, String r31, String r32, String r33, Map r34) throws RemoteException {
        long r16 = SystemClock.elapsedRealtimeNanos();
    L26:
        e = e;
        String r4 = "sendMessageWithExtra(";
        String r20 = ")";
        long r6 = 0;
        Map r5 = r34;
    L28:
        int r2 = h.a;     // Catch: Throwable -> L30
        h.b("IFlowMessageIDLIPC", r4 + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r5 + r20, e);     // Catch: Throwable -> L30
        IPCException r3 = new IPCException(e);     // Catch: Throwable -> L30
        long r25 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L30
        long r7 = Math.max(r6, r25 - r16) / 1000;     // Catch: Throwable -> L30
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L30
        com.obric.aiagent.ipc.utils.i.a("IFlowMessageIDLIPC", r4 + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r5 + ") = fail", r3, r7);     // Catch: Throwable -> L30
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L30
        IPCAnomalyTrace.b("IFlowMessageIDLIPC", "sendMessageWithExtra", r3, r7, r25);     // Catch: Throwable -> L30
        return;
    L4:
        if (this.log == false) goto L7;
        int r8 = h.a;     // Catch: Exception -> L26 Throwable -> L30
        h.a("IFlowMessageIDLIPC", "sendMessageWithExtra(" + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r34 + ")");     // Catch: Exception -> L26 Throwable -> L30
    L7:
        if (this.log == false) goto L9;
        int r9 = h.a;     // Catch: Exception -> L26 Throwable -> L30
        h.a("IFlowMessageIDLIPC", "sendMessageWithExtra(" + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r34 + ")");     // Catch: Exception -> L26 Throwable -> L30
    L9:
        r20 = ")";
        this.origin.sendMessageWithExtra(r30, r31, r32, r33, r34);     // Catch: Exception -> L24 Throwable -> L30
        if (this.log == false) goto L14;
        h.d("IFlowMessageIDLIPC", "sendMessageWithExtra = void");     // Catch: Exception -> L24 Throwable -> L30
    L14:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24 Throwable -> L30
        long r10 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L24 Throwable -> L30
        int r11 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L24 Throwable -> L30
        r4 = "sendMessageWithExtra(";
        StringBuilder r12 = new StringBuilder(r4);     // Catch: Exception -> L22 Throwable -> L30
        r12.append(r30);     // Catch: Exception -> L22 Throwable -> L30
        r12.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r12.append(r31);     // Catch: Exception -> L22 Throwable -> L30
        r12.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r12.append(r32);     // Catch: Exception -> L22 Throwable -> L30
        r12.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r12.append(r33);     // Catch: Exception -> L22 Throwable -> L30
        r12.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r5 = r34;
        r6 = 0;
        r12.append(r5);     // Catch: Exception -> L20 Throwable -> L30
        r12.append(") = void");     // Catch: Exception -> L20 Throwable -> L30
        com.obric.aiagent.ipc.utils.i.b("IFlowMessageIDLIPC", r12.toString(), r10);     // Catch: Exception -> L20 Throwable -> L30
        IPCAnomalyTrace.a.c("IFlowMessageIDLIPC", "sendMessageWithExtra", r10, r27);     // Catch: Exception -> L20 Throwable -> L30
        return;
    L20:
        e = e;
    L22:
        e = e;
        r5 = r34;
        r6 = 0;
    L24:
        e = e;
        r5 = r34;
        r6 = 0;
        r4 = "sendMessageWithExtra(";
        goto L28
    }
}
