package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import com.obric.eventkit.eventstaskmanager.AppEvent;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowVoiceInteractionIDLIpcWrapper implements IFlowVoiceInteractionIDL {
    boolean log;
    final IFlowVoiceInteractionIDL origin;

    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public boolean closeContinuousTalk() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        h.b("IFlowVoiceInteractionIDLIPC", "closeContinuousTalk()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "closeContinuousTalk() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "closeContinuousTalk", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowVoiceInteractionIDLIPC", "closeContinuousTalk()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowVoiceInteractionIDLIPC", "closeContinuousTalk()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.closeContinuousTalk();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowVoiceInteractionIDLIPC", "closeContinuousTalk = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "closeContinuousTalk() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowVoiceInteractionIDLIPC", "closeContinuousTalk", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public boolean isInRealtimeCalling() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        h.b("IFlowVoiceInteractionIDLIPC", "isInRealtimeCalling()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "isInRealtimeCalling() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "isInRealtimeCalling", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowVoiceInteractionIDLIPC", "isInRealtimeCalling()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowVoiceInteractionIDLIPC", "isInRealtimeCalling()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.isInRealtimeCalling();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowVoiceInteractionIDLIPC", "isInRealtimeCalling = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "isInRealtimeCalling() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowVoiceInteractionIDLIPC", "isInRealtimeCalling", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public boolean isInteractionSessionStateListening() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        h.b("IFlowVoiceInteractionIDLIPC", "isInteractionSessionStateListening()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "isInteractionSessionStateListening() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "isInteractionSessionStateListening", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowVoiceInteractionIDLIPC", "isInteractionSessionStateListening()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowVoiceInteractionIDLIPC", "isInteractionSessionStateListening()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.isInteractionSessionStateListening();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowVoiceInteractionIDLIPC", "isInteractionSessionStateListening = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "isInteractionSessionStateListening() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowVoiceInteractionIDLIPC", "isInteractionSessionStateListening", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public FlowVoiceInteractionIDLIpcWrapper(IFlowVoiceInteractionIDL r2) throws RemoteException {
        this(r2, true);
    }

    public void readContent(String r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowVoiceInteractionIDLIPC", "readContent(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "readContent(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "readContent", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowVoiceInteractionIDLIPC", "readContent(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowVoiceInteractionIDLIPC", "readContent(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.readContent(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowVoiceInteractionIDLIPC", "readContent = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "readContent(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowVoiceInteractionIDLIPC", "readContent", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void readContentByMessage(IMMessage r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowVoiceInteractionIDLIPC", "readContentByMessage(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "readContentByMessage(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "readContentByMessage", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowVoiceInteractionIDLIPC", "readContentByMessage(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowVoiceInteractionIDLIPC", "readContentByMessage(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.readContentByMessage(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowVoiceInteractionIDLIPC", "readContentByMessage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "readContentByMessage(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowVoiceInteractionIDLIPC", "readContentByMessage", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void replayMessageTts(String r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowVoiceInteractionIDLIPC", "replayMessageTts(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "replayMessageTts(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "replayMessageTts", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowVoiceInteractionIDLIPC", "replayMessageTts(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowVoiceInteractionIDLIPC", "replayMessageTts(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.replayMessageTts(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowVoiceInteractionIDLIPC", "replayMessageTts = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "replayMessageTts(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowVoiceInteractionIDLIPC", "replayMessageTts", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void requireSyncData(IFlowSyncDataResultIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowVoiceInteractionIDLIPC", "requireSyncData(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "requireSyncData(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "requireSyncData", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowVoiceInteractionIDLIPC", "requireSyncData(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("requireSyncData(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowSyncDataResultIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowVoiceInteractionIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowSyncDataResultIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowSyncDataResultIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowSyncDataResultIDL.Stub) == false) goto L19;
        r13 = s3.a((IFlowSyncDataResultIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = s3.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowVoiceInteractionIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowSyncDataResultIDL r15 = r20;
    L35:
        r5.requireSyncData(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowVoiceInteractionIDLIPC", "requireSyncData = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "requireSyncData(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowVoiceInteractionIDLIPC", "requireSyncData", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r20 instanceof FlowSyncDataResultIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowSyncDataResultIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowSyncDataResultIDL.Stub) == false) goto L33;
        r15 = s3.a((IFlowSyncDataResultIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = s3.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public boolean tryInterruptAssistant(AppEvent r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
        boolean r12 = false;
    L14:
        e = move-exception;
        int r13 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowVoiceInteractionIDLIPC", "tryInterruptAssistant(" + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r15 = new IPCException(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "tryInterruptAssistant(" + r23 + ") = fail", r15, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "tryInterruptAssistant", r15, r7, r18);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r14 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowVoiceInteractionIDLIPC", "tryInterruptAssistant(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r16 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowVoiceInteractionIDLIPC", "tryInterruptAssistant(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r12 = this.origin.tryInterruptAssistant(r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r17 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowVoiceInteractionIDLIPC", "tryInterruptAssistant = " + r12);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r110 = Math.max(0, r19 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "tryInterruptAssistant(" + r23 + ") = " + r12, r110);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowVoiceInteractionIDLIPC", "tryInterruptAssistant", r110, r19);     // Catch: Exception -> L14 Throwable -> L17
        return r12;
    L16:
        return r12;
    }

    public void tryOpenClickTalk(int r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowVoiceInteractionIDLIPC", "tryOpenClickTalk(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "tryOpenClickTalk(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "tryOpenClickTalk", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowVoiceInteractionIDLIPC", "tryOpenClickTalk(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowVoiceInteractionIDLIPC", "tryOpenClickTalk(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.tryOpenClickTalk(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowVoiceInteractionIDLIPC", "tryOpenClickTalk = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "tryOpenClickTalk(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowVoiceInteractionIDLIPC", "tryOpenClickTalk", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public boolean tryOpenMicToRecording(AppEvent r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
        boolean r12 = false;
    L14:
        e = move-exception;
        int r13 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowVoiceInteractionIDLIPC", "tryOpenMicToRecording(" + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r15 = new IPCException(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "tryOpenMicToRecording(" + r23 + ") = fail", r15, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "tryOpenMicToRecording", r15, r7, r18);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r14 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowVoiceInteractionIDLIPC", "tryOpenMicToRecording(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r16 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowVoiceInteractionIDLIPC", "tryOpenMicToRecording(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r12 = this.origin.tryOpenMicToRecording(r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r17 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowVoiceInteractionIDLIPC", "tryOpenMicToRecording = " + r12);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r110 = Math.max(0, r19 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "tryOpenMicToRecording(" + r23 + ") = " + r12, r110);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowVoiceInteractionIDLIPC", "tryOpenMicToRecording", r110, r19);     // Catch: Exception -> L14 Throwable -> L17
        return r12;
    L16:
        return r12;
    }

    public void updateIntentExt(Map r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowVoiceInteractionIDLIPC", "updateIntentExt(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "updateIntentExt(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "updateIntentExt", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowVoiceInteractionIDLIPC", "updateIntentExt(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowVoiceInteractionIDLIPC", "updateIntentExt(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.updateIntentExt(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowVoiceInteractionIDLIPC", "updateIntentExt = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "updateIntentExt(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowVoiceInteractionIDLIPC", "updateIntentExt", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void updateScreenshotForAsr(String r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowVoiceInteractionIDLIPC", "updateScreenshotForAsr(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "updateScreenshotForAsr(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "updateScreenshotForAsr", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowVoiceInteractionIDLIPC", "updateScreenshotForAsr(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowVoiceInteractionIDLIPC", "updateScreenshotForAsr(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.updateScreenshotForAsr(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowVoiceInteractionIDLIPC", "updateScreenshotForAsr = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "updateScreenshotForAsr(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowVoiceInteractionIDLIPC", "updateScreenshotForAsr", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void wakeupAssistant(String r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowVoiceInteractionIDLIPC", "wakeupAssistant(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowVoiceInteractionIDLIPC", "wakeupAssistant(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowVoiceInteractionIDLIPC", "wakeupAssistant", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowVoiceInteractionIDLIPC", "wakeupAssistant(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowVoiceInteractionIDLIPC", "wakeupAssistant(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.wakeupAssistant(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowVoiceInteractionIDLIPC", "wakeupAssistant = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowVoiceInteractionIDLIPC", "wakeupAssistant(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowVoiceInteractionIDLIPC", "wakeupAssistant", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public FlowVoiceInteractionIDLIpcWrapper(IFlowVoiceInteractionIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
