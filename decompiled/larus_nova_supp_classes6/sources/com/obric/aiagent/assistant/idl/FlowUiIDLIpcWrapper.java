package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.Authentication;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowUiIDLIpcWrapper implements IFlowUiIDL {
    boolean log;
    final IFlowUiIDL origin;

    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public void dismissKeyguard() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IFlowUiIDLIPC", "dismissKeyguard()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "dismissKeyguard() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "dismissKeyguard", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowUiIDLIPC", "dismissKeyguard()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowUiIDLIPC", "dismissKeyguard()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.dismissKeyguard();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowUiIDLIPC", "dismissKeyguard = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "dismissKeyguard() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "dismissKeyguard", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void finishChatPage() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IFlowUiIDLIPC", "finishChatPage()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "finishChatPage() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "finishChatPage", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowUiIDLIPC", "finishChatPage()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowUiIDLIPC", "finishChatPage()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.finishChatPage();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowUiIDLIPC", "finishChatPage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "finishChatPage() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "finishChatPage", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public String getCurrentDisplayModel() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        String r11 = null;
    L14:
        e = move-exception;
        h.b("IFlowUiIDLIPC", "getCurrentDisplayModel()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "getCurrentDisplayModel() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "getCurrentDisplayModel", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowUiIDLIPC", "getCurrentDisplayModel()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowUiIDLIPC", "getCurrentDisplayModel()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getCurrentDisplayModel();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowUiIDLIPC", "getCurrentDisplayModel = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "getCurrentDisplayModel() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "getCurrentDisplayModel", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public String getTaskSkillModelJson() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        String r11 = null;
    L14:
        e = move-exception;
        h.b("IFlowUiIDLIPC", "getTaskSkillModelJson()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "getTaskSkillModelJson() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "getTaskSkillModelJson", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowUiIDLIPC", "getTaskSkillModelJson()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowUiIDLIPC", "getTaskSkillModelJson()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getTaskSkillModelJson();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowUiIDLIPC", "getTaskSkillModelJson = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "getTaskSkillModelJson() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "getTaskSkillModelJson", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public int getWindowState() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        int r11 = 0;
    L14:
        e = move-exception;
        h.b("IFlowUiIDLIPC", "getWindowState()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "getWindowState() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "getWindowState", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowUiIDLIPC", "getWindowState()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowUiIDLIPC", "getWindowState()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getWindowState();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowUiIDLIPC", "getWindowState = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "getWindowState() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "getWindowState", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public boolean isAssistantRequestFromAIKey() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        h.b("IFlowUiIDLIPC", "isAssistantRequestFromAIKey()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "isAssistantRequestFromAIKey() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "isAssistantRequestFromAIKey", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowUiIDLIPC", "isAssistantRequestFromAIKey()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowUiIDLIPC", "isAssistantRequestFromAIKey()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.isAssistantRequestFromAIKey();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowUiIDLIPC", "isAssistantRequestFromAIKey = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "isAssistantRequestFromAIKey() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "isAssistantRequestFromAIKey", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public boolean isAuthenticationPass() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        h.b("IFlowUiIDLIPC", "isAuthenticationPass()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "isAuthenticationPass() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "isAuthenticationPass", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowUiIDLIPC", "isAuthenticationPass()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowUiIDLIPC", "isAuthenticationPass()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.isAuthenticationPass();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowUiIDLIPC", "isAuthenticationPass = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "isAuthenticationPass() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "isAuthenticationPass", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public boolean isWindowMode() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        h.b("IFlowUiIDLIPC", "isWindowMode()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "isWindowMode() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "isWindowMode", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowUiIDLIPC", "isWindowMode()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowUiIDLIPC", "isWindowMode()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.isWindowMode();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowUiIDLIPC", "isWindowMode = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "isWindowMode() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "isWindowMode", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public boolean isWindowShowing() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        h.b("IFlowUiIDLIPC", "isWindowShowing()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "isWindowShowing() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "isWindowShowing", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowUiIDLIPC", "isWindowShowing()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowUiIDLIPC", "isWindowShowing()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.isWindowShowing();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowUiIDLIPC", "isWindowShowing = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "isWindowShowing() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "isWindowShowing", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public void notifyOAutoDied() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IFlowUiIDLIPC", "notifyOAutoDied()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "notifyOAutoDied() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "notifyOAutoDied", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowUiIDLIPC", "notifyOAutoDied()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowUiIDLIPC", "notifyOAutoDied()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyOAutoDied();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowUiIDLIPC", "notifyOAutoDied = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "notifyOAutoDied() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "notifyOAutoDied", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void popWindow() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IFlowUiIDLIPC", "popWindow()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "popWindow() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "popWindow", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowUiIDLIPC", "popWindow()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowUiIDLIPC", "popWindow()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.popWindow();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowUiIDLIPC", "popWindow = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "popWindow() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "popWindow", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void processRequiresAuthentication() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IFlowUiIDLIPC", "processRequiresAuthentication()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "processRequiresAuthentication() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "processRequiresAuthentication", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowUiIDLIPC", "processRequiresAuthentication()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowUiIDLIPC", "processRequiresAuthentication()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.processRequiresAuthentication();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowUiIDLIPC", "processRequiresAuthentication = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "processRequiresAuthentication() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "processRequiresAuthentication", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void showWindow() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IFlowUiIDLIPC", "showWindow()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "showWindow() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "showWindow", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowUiIDLIPC", "showWindow()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowUiIDLIPC", "showWindow()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showWindow();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowUiIDLIPC", "showWindow = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "showWindow() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "showWindow", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public FlowUiIDLIpcWrapper(IFlowUiIDL r2) throws RemoteException {
        this(r2, true);
    }

    public void closeAssistantInputPanel(String r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowUiIDLIPC", "closeAssistantInputPanel(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "closeAssistantInputPanel(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "closeAssistantInputPanel", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "closeAssistantInputPanel(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "closeAssistantInputPanel(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.closeAssistantInputPanel(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowUiIDLIPC", "closeAssistantInputPanel = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "closeAssistantInputPanel(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "closeAssistantInputPanel", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public boolean isAudioMessage(String r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
        boolean r12 = false;
    L14:
        e = move-exception;
        int r13 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowUiIDLIPC", "isAudioMessage(" + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r15 = new IPCException(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "isAudioMessage(" + r23 + ") = fail", r15, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "isAudioMessage", r15, r7, r18);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r14 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "isAudioMessage(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r16 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "isAudioMessage(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r12 = this.origin.isAudioMessage(r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r17 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowUiIDLIPC", "isAudioMessage = " + r12);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r110 = Math.max(0, r19 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "isAudioMessage(" + r23 + ") = " + r12, r110);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "isAudioMessage", r110, r19);     // Catch: Exception -> L14 Throwable -> L17
        return r12;
    L16:
        return r12;
    }

    public boolean isAuthenticationPassV2(String r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
        boolean r12 = false;
    L14:
        e = move-exception;
        int r13 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowUiIDLIPC", "isAuthenticationPassV2(" + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r15 = new IPCException(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "isAuthenticationPassV2(" + r23 + ") = fail", r15, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "isAuthenticationPassV2", r15, r7, r18);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r14 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "isAuthenticationPassV2(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r16 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "isAuthenticationPassV2(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r12 = this.origin.isAuthenticationPassV2(r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r17 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowUiIDLIPC", "isAuthenticationPassV2 = " + r12);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r110 = Math.max(0, r19 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "isAuthenticationPassV2(" + r23 + ") = " + r12, r110);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "isAuthenticationPassV2", r110, r19);     // Catch: Exception -> L14 Throwable -> L17
        return r12;
    L16:
        return r12;
    }

    public Authentication isAuthenticationPassV3(String r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
        Authentication r12 = null;
    L14:
        e = move-exception;
        int r13 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowUiIDLIPC", "isAuthenticationPassV3(" + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r15 = new IPCException(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "isAuthenticationPassV3(" + r23 + ") = fail", r15, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "isAuthenticationPassV3", r15, r7, r18);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r14 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "isAuthenticationPassV3(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r16 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "isAuthenticationPassV3(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r12 = this.origin.isAuthenticationPassV3(r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r17 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowUiIDLIPC", "isAuthenticationPassV3 = " + r12);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r110 = Math.max(0, r19 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "isAuthenticationPassV3(" + r23 + ") = " + r12, r110);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "isAuthenticationPassV3", r110, r19);     // Catch: Exception -> L14 Throwable -> L17
        return r12;
    L16:
        return r12;
    }

    public void notifyMessageInAutoGui(String r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowUiIDLIPC", "notifyMessageInAutoGui(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "notifyMessageInAutoGui(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "notifyMessageInAutoGui", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "notifyMessageInAutoGui(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "notifyMessageInAutoGui(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyMessageInAutoGui(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowUiIDLIPC", "notifyMessageInAutoGui = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "notifyMessageInAutoGui(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "notifyMessageInAutoGui", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void openChatActivity(int r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowUiIDLIPC", "openChatActivity(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "openChatActivity(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "openChatActivity", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "openChatActivity(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "openChatActivity(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.openChatActivity(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowUiIDLIPC", "openChatActivity = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "openChatActivity(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "openChatActivity", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void setAutoIncreaseWindow(boolean r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowUiIDLIPC", "setAutoIncreaseWindow(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "setAutoIncreaseWindow(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "setAutoIncreaseWindow", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "setAutoIncreaseWindow(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "setAutoIncreaseWindow(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setAutoIncreaseWindow(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowUiIDLIPC", "setAutoIncreaseWindow = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "setAutoIncreaseWindow(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "setAutoIncreaseWindow", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void showToast(String r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowUiIDLIPC", "showToast(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "showToast(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "showToast", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "showToast(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "showToast(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showToast(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowUiIDLIPC", "showToast = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "showToast(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "showToast", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public FlowUiIDLIpcWrapper(IFlowUiIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    public void openRealtimeCall(int r22, IOpenRealTimeCallCallbackIDL r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowUiIDLIPC", "openRealtimeCall(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "openRealtimeCall(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "openRealtimeCall", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowUiIDLIPC", "openRealtimeCall(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("openRealtimeCall(");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r22);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L12;
    L20:
        IOpenRealTimeCallCallbackIDL r14 = r23;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowUiIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r23 instanceof OpenRealTimeCallCallbackIDLIpcWrapper) == true) goto L20;
        if ((r23 instanceof OpenRealTimeCallCallbackIDLStubWrapper) == true) goto L20;
        if ((r23 instanceof IOpenRealTimeCallCallbackIDL.Stub) == false) goto L19;
        r14 = k4.a((IOpenRealTimeCallCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = k4.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowUiIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L26;
    L34:
        IOpenRealTimeCallCallbackIDL r15 = r23;
    L35:
        r6.openRealtimeCall(r22, r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowUiIDLIPC", "openRealtimeCall = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "openRealtimeCall(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "openRealtimeCall", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r23 instanceof OpenRealTimeCallCallbackIDLIpcWrapper) == true) goto L34;
        if ((r23 instanceof OpenRealTimeCallCallbackIDLStubWrapper) == true) goto L34;
        if ((r23 instanceof IOpenRealTimeCallCallbackIDL.Stub) == false) goto L33;
        r15 = k4.a((IOpenRealTimeCallCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = k4.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void requestDeviceCredentialAuthentication(IRequestAuthenticationCallbackIDL r22, Bundle r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowUiIDLIPC", "requestDeviceCredentialAuthentication(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "requestDeviceCredentialAuthentication(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "requestDeviceCredentialAuthentication", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowUiIDLIPC", "requestDeviceCredentialAuthentication(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("requestDeviceCredentialAuthentication(");     // Catch: Exception -> L40 Throwable -> L43
        if (r22 != null) goto L12;
    L20:
        IRequestAuthenticationCallbackIDL r14 = r22;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r23);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowUiIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r22 instanceof RequestAuthenticationCallbackIDLIpcWrapper) == true) goto L20;
        if ((r22 instanceof RequestAuthenticationCallbackIDLStubWrapper) == true) goto L20;
        if ((r22 instanceof IRequestAuthenticationCallbackIDL.Stub) == false) goto L19;
        r14 = r4.a((IRequestAuthenticationCallbackIDL.Stub) r22);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = r4.b(r22);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowUiIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r22 != null) goto L26;
    L34:
        IRequestAuthenticationCallbackIDL r15 = r22;
    L35:
        r6.requestDeviceCredentialAuthentication(r15, r23);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowUiIDLIPC", "requestDeviceCredentialAuthentication = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "requestDeviceCredentialAuthentication(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "requestDeviceCredentialAuthentication", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r22 instanceof RequestAuthenticationCallbackIDLIpcWrapper) == true) goto L34;
        if ((r22 instanceof RequestAuthenticationCallbackIDLStubWrapper) == true) goto L34;
        if ((r22 instanceof IRequestAuthenticationCallbackIDL.Stub) == false) goto L33;
        r15 = r4.a((IRequestAuthenticationCallbackIDL.Stub) r22);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = r4.b(r22);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void requestVoicePrintAuthentication(IRequestAuthenticationCallbackIDL r22, Bundle r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowUiIDLIPC", "requestVoicePrintAuthentication(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "requestVoicePrintAuthentication(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "requestVoicePrintAuthentication", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowUiIDLIPC", "requestVoicePrintAuthentication(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("requestVoicePrintAuthentication(");     // Catch: Exception -> L40 Throwable -> L43
        if (r22 != null) goto L12;
    L20:
        IRequestAuthenticationCallbackIDL r14 = r22;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r23);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowUiIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r22 instanceof RequestAuthenticationCallbackIDLIpcWrapper) == true) goto L20;
        if ((r22 instanceof RequestAuthenticationCallbackIDLStubWrapper) == true) goto L20;
        if ((r22 instanceof IRequestAuthenticationCallbackIDL.Stub) == false) goto L19;
        r14 = r4.a((IRequestAuthenticationCallbackIDL.Stub) r22);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = r4.b(r22);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowUiIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r22 != null) goto L26;
    L34:
        IRequestAuthenticationCallbackIDL r15 = r22;
    L35:
        r6.requestVoicePrintAuthentication(r15, r23);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowUiIDLIPC", "requestVoicePrintAuthentication = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "requestVoicePrintAuthentication(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "requestVoicePrintAuthentication", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r22 instanceof RequestAuthenticationCallbackIDLIpcWrapper) == true) goto L34;
        if ((r22 instanceof RequestAuthenticationCallbackIDLStubWrapper) == true) goto L34;
        if ((r22 instanceof IRequestAuthenticationCallbackIDL.Stub) == false) goto L33;
        r15 = r4.a((IRequestAuthenticationCallbackIDL.Stub) r22);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = r4.b(r22);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void setAssistantInteractionListener(String r22, IAssistantInteractionListenerIDL r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowUiIDLIPC", "setAssistantInteractionListener(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "setAssistantInteractionListener(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "setAssistantInteractionListener", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowUiIDLIPC", "setAssistantInteractionListener(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("setAssistantInteractionListener(");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r22);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L12;
    L20:
        IAssistantInteractionListenerIDL r14 = r23;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowUiIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r23 instanceof AssistantInteractionListenerIDLIpcWrapper) == true) goto L20;
        if ((r23 instanceof AssistantInteractionListenerIDLStubWrapper) == true) goto L20;
        if ((r23 instanceof IAssistantInteractionListenerIDL.Stub) == false) goto L19;
        r14 = x.a((IAssistantInteractionListenerIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = x.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowUiIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L26;
    L34:
        IAssistantInteractionListenerIDL r15 = r23;
    L35:
        r6.setAssistantInteractionListener(r22, r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowUiIDLIPC", "setAssistantInteractionListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "setAssistantInteractionListener(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "setAssistantInteractionListener", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r23 instanceof AssistantInteractionListenerIDLIpcWrapper) == true) goto L34;
        if ((r23 instanceof AssistantInteractionListenerIDLStubWrapper) == true) goto L34;
        if ((r23 instanceof IAssistantInteractionListenerIDL.Stub) == false) goto L33;
        r15 = x.a((IAssistantInteractionListenerIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = x.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void shouldDowngradeAuthForDora(int r22, IDowngradeAuthForDoraCallbackIDL r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowUiIDLIPC", "shouldDowngradeAuthForDora(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L43
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L43
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "shouldDowngradeAuthForDora(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "shouldDowngradeAuthForDora", r4, r9, r19);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowUiIDLIPC", "shouldDowngradeAuthForDora(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r5 = new StringBuilder("shouldDowngradeAuthForDora(");     // Catch: Exception -> L40 Throwable -> L43
        r5.append(r22);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L12;
    L20:
        IDowngradeAuthForDoraCallbackIDL r14 = r23;
    L21:
        r5.append(r14);     // Catch: Exception -> L40 Throwable -> L43
        r5.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowUiIDLIPC", r5.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r23 instanceof DowngradeAuthForDoraCallbackIDLIpcWrapper) == true) goto L20;
        if ((r23 instanceof DowngradeAuthForDoraCallbackIDLStubWrapper) == true) goto L20;
        if ((r23 instanceof IDowngradeAuthForDoraCallbackIDL.Stub) == false) goto L19;
        r14 = d0.a((IDowngradeAuthForDoraCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r14 = d0.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowUiIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L26;
    L34:
        IDowngradeAuthForDoraCallbackIDL r15 = r23;
    L35:
        r6.shouldDowngradeAuthForDora(r22, r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowUiIDLIPC", "shouldDowngradeAuthForDora = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "shouldDowngradeAuthForDora(" + r22 + ", " + r23 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "shouldDowngradeAuthForDora", r16, r110);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r23 instanceof DowngradeAuthForDoraCallbackIDLIpcWrapper) == true) goto L34;
        if ((r23 instanceof DowngradeAuthForDoraCallbackIDLStubWrapper) == true) goto L34;
        if ((r23 instanceof IDowngradeAuthForDoraCallbackIDL.Stub) == false) goto L33;
        r15 = d0.a((IDowngradeAuthForDoraCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = d0.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void handleObricAction(String r23, String r24, IObricActionResultCallbackIDL r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r11 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowUiIDLIPC", "handleObricAction(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L43
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L43
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r10 = Math.max(0, r20 - r9) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "handleObricAction(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r5, r10);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "handleObricAction", r5, r10, r20);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowUiIDLIPC", "handleObricAction(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("handleObricAction(");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r23);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r24);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r25 != null) goto L12;
    L20:
        IObricActionResultCallbackIDL r15 = r25;
    L21:
        r4.append(r15);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowUiIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r25 instanceof ObricActionResultCallbackIDLIpcWrapper) == true) goto L20;
        if ((r25 instanceof ObricActionResultCallbackIDLStubWrapper) == true) goto L20;
        if ((r25 instanceof IObricActionResultCallbackIDL.Stub) == false) goto L19;
        r15 = h4.a((IObricActionResultCallbackIDL.Stub) r25);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = h4.b(r25);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowUiIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r25 != null) goto L26;
    L34:
        IObricActionResultCallbackIDL r16 = r25;
    L35:
        r6.handleObricAction(r23, r24, r16);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowUiIDLIPC", "handleObricAction = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "handleObricAction(" + r23 + ", " + r24 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "handleObricAction", r12, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r25 instanceof ObricActionResultCallbackIDLIpcWrapper) == true) goto L34;
        if ((r25 instanceof ObricActionResultCallbackIDLStubWrapper) == true) goto L34;
        if ((r25 instanceof IObricActionResultCallbackIDL.Stub) == false) goto L33;
        r16 = h4.a((IObricActionResultCallbackIDL.Stub) r25);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r16 = h4.b(r25);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void notifyAssistantState(String r23, boolean r24, StateInfo r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r11 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowUiIDLIPC", "notifyAssistantState(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r10 = Math.max(0, r20 - r9) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "notifyAssistantState(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r5, r10);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "notifyAssistantState", r5, r10, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "notifyAssistantState(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "notifyAssistantState(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyAssistantState(r23, r24, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowUiIDLIPC", "notifyAssistantState = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "notifyAssistantState(" + r23 + ", " + r24 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "notifyAssistantState", r12, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void openAssistantInputPanel(String r23, StateInfo r24, boolean r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r11 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowUiIDLIPC", "openAssistantInputPanel(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r10 = Math.max(0, r20 - r9) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "openAssistantInputPanel(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r5, r10);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "openAssistantInputPanel", r5, r10, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "openAssistantInputPanel(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowUiIDLIPC", "openAssistantInputPanel(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.openAssistantInputPanel(r23, r24, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowUiIDLIPC", "openAssistantInputPanel = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "openAssistantInputPanel(" + r23 + ", " + r24 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "openAssistantInputPanel", r12, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void requestBiometricAuthentication(IRequestAuthenticationCallbackIDL r23, boolean r24, Bundle r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r11 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowUiIDLIPC", "requestBiometricAuthentication(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L43
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L43
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r10 = Math.max(0, r20 - r9) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", "requestBiometricAuthentication(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r5, r10);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "requestBiometricAuthentication", r5, r10, r20);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowUiIDLIPC", "requestBiometricAuthentication(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("requestBiometricAuthentication(");     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L12;
    L20:
        IRequestAuthenticationCallbackIDL r15 = r23;
    L21:
        r4.append(r15);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r24);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(", ");     // Catch: Exception -> L40 Throwable -> L43
        r4.append(r25);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowUiIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r23 instanceof RequestAuthenticationCallbackIDLIpcWrapper) == true) goto L20;
        if ((r23 instanceof RequestAuthenticationCallbackIDLStubWrapper) == true) goto L20;
        if ((r23 instanceof IRequestAuthenticationCallbackIDL.Stub) == false) goto L19;
        r15 = r4.a((IRequestAuthenticationCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = r4.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowUiIDL r6 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r23 != null) goto L26;
    L34:
        IRequestAuthenticationCallbackIDL r16 = r23;
    L35:
        r6.requestBiometricAuthentication(r16, r24, r25);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowUiIDLIPC", "requestBiometricAuthentication = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r7 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", "requestBiometricAuthentication(" + r23 + ", " + r24 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "requestBiometricAuthentication", r12, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if ((r23 instanceof RequestAuthenticationCallbackIDLIpcWrapper) == true) goto L34;
        if ((r23 instanceof RequestAuthenticationCallbackIDLStubWrapper) == true) goto L34;
        if ((r23 instanceof IRequestAuthenticationCallbackIDL.Stub) == false) goto L33;
        r16 = r4.a((IRequestAuthenticationCallbackIDL.Stub) r23);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r16 = r4.b(r23);     // Catch: Exception -> L40 Throwable -> L43
    }

    public void addCustomBarAction(String r31, String r32, String r33, long r34) throws RemoteException {
        long r16 = SystemClock.elapsedRealtimeNanos();
    L26:
        e = e;
        String r4 = "addCustomBarAction(";
        long r5 = r34;
        long r11 = 0;
    L28:
        int r2 = h.a;     // Catch: Throwable -> L30
        h.b("IFlowUiIDLIPC", r4 + r31 + ", " + r32 + ", " + r33 + ", " + r5 + ")", e);     // Catch: Throwable -> L30
        IPCException r3 = new IPCException(e);     // Catch: Throwable -> L30
        long r25 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L30
        long r0 = Math.max(r11, r25 - r16) / 1000;     // Catch: Throwable -> L30
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L30
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", r4 + r31 + ", " + r32 + ", " + r33 + ", " + r5 + ") = fail", r3, r0);     // Catch: Throwable -> L30
        IPCAnomalyTrace r7 = IPCAnomalyTrace.a;     // Catch: Throwable -> L30
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "addCustomBarAction", r3, r0, r25);     // Catch: Throwable -> L30
        return;
    L4:
        if (this.log == false) goto L7;
        int r1 = h.a;     // Catch: Exception -> L26 Throwable -> L30
        h.a("IFlowUiIDLIPC", "addCustomBarAction(" + r31 + ", " + r32 + ", " + r33 + ", " + r34 + ")");     // Catch: Exception -> L26 Throwable -> L30
    L7:
        if (this.log == false) goto L9;
        int r8 = h.a;     // Catch: Exception -> L26 Throwable -> L30
        h.a("IFlowUiIDLIPC", "addCustomBarAction(" + r31 + ", " + r32 + ", " + r33 + ", " + r34 + ")");     // Catch: Exception -> L26 Throwable -> L30
    L9:
        r11 = 0;
        this.origin.addCustomBarAction(r31, r32, r33, r34);     // Catch: Exception -> L24 Throwable -> L30
        if (this.log == false) goto L14;
        h.d("IFlowUiIDLIPC", "addCustomBarAction = void");     // Catch: Exception -> L24 Throwable -> L30
    L14:
        long r26 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24 Throwable -> L30
        long r9 = Math.max(0, r26 - r16) / 1000;     // Catch: Exception -> L24 Throwable -> L30
        int r10 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L24 Throwable -> L30
        r4 = "addCustomBarAction(";
        StringBuilder r12 = new StringBuilder(r4);     // Catch: Exception -> L22 Throwable -> L30
        r12.append(r31);     // Catch: Exception -> L22 Throwable -> L30
        r12.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r12.append(r32);     // Catch: Exception -> L22 Throwable -> L30
        r12.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r12.append(r33);     // Catch: Exception -> L22 Throwable -> L30
        r12.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r5 = r34;
        r12.append(r5);     // Catch: Exception -> L20 Throwable -> L30
        r12.append(") = void");     // Catch: Exception -> L20 Throwable -> L30
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", r12.toString(), r9);     // Catch: Exception -> L20 Throwable -> L30
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "addCustomBarAction", r9, r26);     // Catch: Exception -> L20 Throwable -> L30
        return;
    L20:
        e = e;
    L22:
        e = e;
        r5 = r34;
    L24:
        e = e;
        r5 = r34;
        r4 = "addCustomBarAction(";
    }

    public void suspendDismissKeyguard(String r30, String[] r31, IDismissKeyguardCallbackIDL r32, boolean r33, Bundle r34) throws RemoteException {
        long r16 = SystemClock.elapsedRealtimeNanos();
    L52:
        e = e;
        String r4 = "suspendDismissKeyguard(";
        String r20 = ")";
        long r6 = 0;
        Bundle r5 = r34;
    L54:
        int r2 = h.a;     // Catch: Throwable -> L56
        h.b("IFlowUiIDLIPC", r4 + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r5 + r20, e);     // Catch: Throwable -> L56
        IPCException r3 = new IPCException(e);     // Catch: Throwable -> L56
        long r25 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L56
        long r7 = Math.max(r6, r25 - r16) / 1000;     // Catch: Throwable -> L56
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L56
        com.obric.aiagent.ipc.utils.i.a("IFlowUiIDLIPC", r4 + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r5 + ") = fail", r3, r7);     // Catch: Throwable -> L56
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L56
        IPCAnomalyTrace.b("IFlowUiIDLIPC", "suspendDismissKeyguard", r3, r7, r25);     // Catch: Throwable -> L56
        return;
    L4:
        if (this.log == false) goto L7;
        int r8 = h.a;     // Catch: Exception -> L52 Throwable -> L56
        h.a("IFlowUiIDLIPC", "suspendDismissKeyguard(" + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r34 + ")");     // Catch: Exception -> L52 Throwable -> L56
    L7:
        if (this.log == false) goto L22;
        int r9 = h.a;     // Catch: Exception -> L52 Throwable -> L56
        StringBuilder r10 = new StringBuilder("suspendDismissKeyguard(");     // Catch: Exception -> L52 Throwable -> L56
        r10.append(r30);     // Catch: Exception -> L52 Throwable -> L56
        r10.append(", ");     // Catch: Exception -> L52 Throwable -> L56
        r10.append(r31);     // Catch: Exception -> L52 Throwable -> L56
        r10.append(", ");     // Catch: Exception -> L52 Throwable -> L56
        if (r32 != null) goto L12;
    L20:
        IDismissKeyguardCallbackIDL r11 = r32;
    L21:
        r10.append(r11);     // Catch: Exception -> L52 Throwable -> L56
        r10.append(", ");     // Catch: Exception -> L52 Throwable -> L56
        r10.append(r33);     // Catch: Exception -> L52 Throwable -> L56
        r10.append(", ");     // Catch: Exception -> L52 Throwable -> L56
        r10.append(r34);     // Catch: Exception -> L52 Throwable -> L56
        r10.append(")");     // Catch: Exception -> L52 Throwable -> L56
        h.a("IFlowUiIDLIPC", r10.toString());     // Catch: Exception -> L52 Throwable -> L56
        goto L22
    L12:
        if ((r32 instanceof DismissKeyguardCallbackIDLIpcWrapper) == true) goto L20;
        if ((r32 instanceof DismissKeyguardCallbackIDLStubWrapper) == true) goto L20;
        if ((r32 instanceof IDismissKeyguardCallbackIDL.Stub) == false) goto L19;
        r11 = a0.a((IDismissKeyguardCallbackIDL.Stub) r32);     // Catch: Exception -> L52 Throwable -> L56
        goto L21
    L19:
        r11 = a0.b(r32);     // Catch: Exception -> L52 Throwable -> L56
    L22:
        IFlowUiIDL r12 = this.origin;     // Catch: Exception -> L52 Throwable -> L56
        if (r32 != null) goto L26;
    L35:
        IDismissKeyguardCallbackIDL r13 = r32;
    L36:
        r20 = ")";
        r12.suspendDismissKeyguard(r30, r31, r13, r33, r34);     // Catch: Exception -> L50 Throwable -> L56
        if (this.log == false) goto L40;
        h.d("IFlowUiIDLIPC", "suspendDismissKeyguard = void");     // Catch: Exception -> L50 Throwable -> L56
    L40:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L50 Throwable -> L56
        long r14 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L50 Throwable -> L56
        int r15 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L50 Throwable -> L56
        r4 = "suspendDismissKeyguard(";
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
        com.obric.aiagent.ipc.utils.i.b("IFlowUiIDLIPC", r17.toString(), r14);     // Catch: Exception -> L46 Throwable -> L56
        IPCAnomalyTrace.a.c("IFlowUiIDLIPC", "suspendDismissKeyguard", r14, r27);     // Catch: Exception -> L46 Throwable -> L56
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
        r4 = "suspendDismissKeyguard(";
        goto L54
    L26:
        if ((r32 instanceof DismissKeyguardCallbackIDLIpcWrapper) == true) goto L35;
        if ((r32 instanceof DismissKeyguardCallbackIDLStubWrapper) == true) goto L35;
        if ((r32 instanceof IDismissKeyguardCallbackIDL.Stub) == false) goto L33;
        r13 = a0.a((IDismissKeyguardCallbackIDL.Stub) r32);     // Catch: Exception -> L52 Throwable -> L56
        goto L36
    L33:
        r13 = a0.b(r32);     // Catch: Exception -> L52 Throwable -> L56
        goto L36
    }
}
