package com.obric.aiagent.assistant.idl;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.ShortcutRecommendItem;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class AgentTaskAppIDLStubWrapper extends IAgentTaskAppIDL.Stub {
    boolean log;
    final IAgentTaskAppIDL.Stub origin;

    public boolean shouldShowAddTaskManagerIconGuide() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide()");     // Catch: Exception -> L11
    L6:
        boolean r11 = this.origin.shouldShowAddTaskManagerIconGuide();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public AgentTaskAppIDLStubWrapper(IAgentTaskAppIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public void addTaskManagerShortcut(PendingIntent r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentTaskAppIDLStub", "addTaskManagerShortcut(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentTaskAppIDLStub", "addTaskManagerShortcut(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentTaskAppIDLStub", "addTaskManagerShortcut", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentTaskAppIDLStub", "addTaskManagerShortcut(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.addTaskManagerShortcut(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentTaskAppIDLStub", "addTaskManagerShortcut = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentTaskAppIDLStub", "addTaskManagerShortcut(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentTaskAppIDLStub", "addTaskManagerShortcut", r14, r18);     // Catch: Exception -> L11
    }

    public List<ShortcutRecommendItem> getShortcutRecommendItems(int r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentTaskAppIDLStub", "getShortcutRecommendItems(" + r23 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentTaskAppIDLStub", "getShortcutRecommendItems(" + r23 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentTaskAppIDLStub", "getShortcutRecommendItems", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r13 = h.a;     // Catch: Exception -> L11
        h.c("AgentTaskAppIDLStub", "getShortcutRecommendItems(" + r23 + ")");     // Catch: Exception -> L11
    L6:
        List<ShortcutRecommendItem> r14 = this.origin.getShortcutRecommendItems(r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r15 = h.a;     // Catch: Exception -> L11
        h.d("AgentTaskAppIDLStub", "getShortcutRecommendItems = " + r14);     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentTaskAppIDLStub", "getShortcutRecommendItems(" + r23 + ") = " + r14, r16);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentTaskAppIDLStub", "getShortcutRecommendItems", r16, r18);     // Catch: Exception -> L11
        return r14;
    }

    public boolean hasShortcutForMessage(String r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentTaskAppIDLStub", "hasShortcutForMessage(" + r23 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentTaskAppIDLStub", "hasShortcutForMessage(" + r23 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentTaskAppIDLStub", "hasShortcutForMessage", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r13 = h.a;     // Catch: Exception -> L11
        h.c("AgentTaskAppIDLStub", "hasShortcutForMessage(" + r23 + ")");     // Catch: Exception -> L11
    L6:
        boolean r14 = this.origin.hasShortcutForMessage(r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r15 = h.a;     // Catch: Exception -> L11
        h.d("AgentTaskAppIDLStub", "hasShortcutForMessage = " + r14);     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentTaskAppIDLStub", "hasShortcutForMessage(" + r23 + ") = " + r14, r16);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentTaskAppIDLStub", "hasShortcutForMessage", r16, r18);     // Catch: Exception -> L11
        return r14;
    }

    public AgentTaskAppIDLStubWrapper(IAgentTaskAppIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    public void openEventTaskDetailPage(String r22, String r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r10 = h.a;
        h.b("AgentTaskAppIDLStub", "openEventTaskDetailPage(" + r22 + ", " + r23 + ")", e);
        IPCException r4 = new IPCException(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r19 - r8) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentTaskAppIDLStub", "openEventTaskDetailPage(" + r22 + ", " + r23 + ") = fail", r4, r9);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentTaskAppIDLStub", "openEventTaskDetailPage", r4, r9, r19);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentTaskAppIDLStub", "openEventTaskDetailPage(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.openEventTaskDetailPage(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentTaskAppIDLStub", "openEventTaskDetailPage = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentTaskAppIDLStub", "openEventTaskDetailPage(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentTaskAppIDLStub", "openEventTaskDetailPage", r14, r110);     // Catch: Exception -> L11
    }

    public void runShortcutTaskFromRecommendPanel(String r22, String r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r10 = h.a;
        h.b("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel(" + r22 + ", " + r23 + ")", e);
        IPCException r4 = new IPCException(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r19 - r8) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel(" + r22 + ", " + r23 + ") = fail", r4, r9);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel", r4, r9, r19);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.runShortcutTaskFromRecommendPanel(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel", r14, r110);     // Catch: Exception -> L11
    }

    public void testRunConditionTask(String r22, String r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r10 = h.a;
        h.b("AgentTaskAppIDLStub", "testRunConditionTask(" + r22 + ", " + r23 + ")", e);
        IPCException r4 = new IPCException(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r19 - r8) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentTaskAppIDLStub", "testRunConditionTask(" + r22 + ", " + r23 + ") = fail", r4, r9);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentTaskAppIDLStub", "testRunConditionTask", r4, r9, r19);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentTaskAppIDLStub", "testRunConditionTask(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.testRunConditionTask(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentTaskAppIDLStub", "testRunConditionTask = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentTaskAppIDLStub", "testRunConditionTask(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentTaskAppIDLStub", "testRunConditionTask", r14, r110);     // Catch: Exception -> L11
    }
}
