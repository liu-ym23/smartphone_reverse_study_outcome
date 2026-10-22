package com.obric.aiagent.assistant.idl;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.PersonalContextInfo;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class AgentVoiceInteractionIDLStubWrapper extends IAgentVoiceInteractionIDL.Stub {
    boolean log;
    final IAgentVoiceInteractionIDL.Stub origin;

    public PersonalContextInfo getUserRecentData() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentVoiceInteractionIDLStub", "getUserRecentData()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentVoiceInteractionIDLStub", "getUserRecentData() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentVoiceInteractionIDLStub", "getUserRecentData", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentVoiceInteractionIDLStub", "getUserRecentData()");     // Catch: Exception -> L11
    L6:
        PersonalContextInfo r11 = this.origin.getUserRecentData();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentVoiceInteractionIDLStub", "getUserRecentData = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentVoiceInteractionIDLStub", "getUserRecentData() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentVoiceInteractionIDLStub", "getUserRecentData", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public void onAsrEnd() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentVoiceInteractionIDLStub", "onAsrEnd()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentVoiceInteractionIDLStub", "onAsrEnd() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentVoiceInteractionIDLStub", "onAsrEnd", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentVoiceInteractionIDLStub", "onAsrEnd()");     // Catch: Exception -> L11
    L6:
        this.origin.onAsrEnd();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentVoiceInteractionIDLStub", "onAsrEnd = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentVoiceInteractionIDLStub", "onAsrEnd() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentVoiceInteractionIDLStub", "onAsrEnd", r14, r16);     // Catch: Exception -> L11
    }

    public void onHide() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentVoiceInteractionIDLStub", "onHide()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentVoiceInteractionIDLStub", "onHide() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentVoiceInteractionIDLStub", "onHide", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentVoiceInteractionIDLStub", "onHide()");     // Catch: Exception -> L11
    L6:
        this.origin.onHide();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentVoiceInteractionIDLStub", "onHide = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentVoiceInteractionIDLStub", "onHide() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentVoiceInteractionIDLStub", "onHide", r14, r16);     // Catch: Exception -> L11
    }

    public AgentVoiceInteractionIDLStubWrapper(IAgentVoiceInteractionIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public void onAsrStart(String r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentVoiceInteractionIDLStub", "onAsrStart(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentVoiceInteractionIDLStub", "onAsrStart(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentVoiceInteractionIDLStub", "onAsrStart", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentVoiceInteractionIDLStub", "onAsrStart(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onAsrStart(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentVoiceInteractionIDLStub", "onAsrStart = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentVoiceInteractionIDLStub", "onAsrStart(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentVoiceInteractionIDLStub", "onAsrStart", r14, r18);     // Catch: Exception -> L11
    }

    public void onHandleScreenshot(Bitmap r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentVoiceInteractionIDLStub", "onHandleScreenshot(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentVoiceInteractionIDLStub", "onHandleScreenshot(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentVoiceInteractionIDLStub", "onHandleScreenshot", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentVoiceInteractionIDLStub", "onHandleScreenshot(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onHandleScreenshot(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentVoiceInteractionIDLStub", "onHandleScreenshot = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentVoiceInteractionIDLStub", "onHandleScreenshot(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentVoiceInteractionIDLStub", "onHandleScreenshot", r14, r18);     // Catch: Exception -> L11
    }

    public void onShow(Bundle r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentVoiceInteractionIDLStub", "onShow(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentVoiceInteractionIDLStub", "onShow(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentVoiceInteractionIDLStub", "onShow", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentVoiceInteractionIDLStub", "onShow(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onShow(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentVoiceInteractionIDLStub", "onShow = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentVoiceInteractionIDLStub", "onShow(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentVoiceInteractionIDLStub", "onShow", r14, r18);     // Catch: Exception -> L11
    }

    public void onStartChatWindow(int r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentVoiceInteractionIDLStub", "onStartChatWindow(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentVoiceInteractionIDLStub", "onStartChatWindow(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentVoiceInteractionIDLStub", "onStartChatWindow", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentVoiceInteractionIDLStub", "onStartChatWindow(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onStartChatWindow(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentVoiceInteractionIDLStub", "onStartChatWindow = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentVoiceInteractionIDLStub", "onStartChatWindow(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentVoiceInteractionIDLStub", "onStartChatWindow", r14, r18);     // Catch: Exception -> L11
    }

    public AgentVoiceInteractionIDLStubWrapper(IAgentVoiceInteractionIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    public void onHandleAssist(AssistStructure r22, AssistContent r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r10 = h.a;
        h.b("AgentVoiceInteractionIDLStub", "onHandleAssist(" + r22 + ", " + r23 + ")", e);
        IPCException r4 = new IPCException(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r19 - r8) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentVoiceInteractionIDLStub", "onHandleAssist(" + r22 + ", " + r23 + ") = fail", r4, r9);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentVoiceInteractionIDLStub", "onHandleAssist", r4, r9, r19);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentVoiceInteractionIDLStub", "onHandleAssist(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onHandleAssist(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentVoiceInteractionIDLStub", "onHandleAssist = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentVoiceInteractionIDLStub", "onHandleAssist(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentVoiceInteractionIDLStub", "onHandleAssist", r14, r110);     // Catch: Exception -> L11
    }

    public void onQueryAudioFile(String r22, String r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r10 = h.a;
        h.b("AgentVoiceInteractionIDLStub", "onQueryAudioFile(" + r22 + ", " + r23 + ")", e);
        IPCException r4 = new IPCException(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r19 - r8) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentVoiceInteractionIDLStub", "onQueryAudioFile(" + r22 + ", " + r23 + ") = fail", r4, r9);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentVoiceInteractionIDLStub", "onQueryAudioFile", r4, r9, r19);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentVoiceInteractionIDLStub", "onQueryAudioFile(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onQueryAudioFile(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentVoiceInteractionIDLStub", "onQueryAudioFile = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentVoiceInteractionIDLStub", "onQueryAudioFile(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentVoiceInteractionIDLStub", "onQueryAudioFile", r14, r110);     // Catch: Exception -> L11
    }
}
