package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.Permission;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowPermissionIDLIpcWrapper implements IFlowPermissionIDL {
    boolean log;
    final IFlowPermissionIDL origin;

    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public FlowPermissionIDLIpcWrapper(IFlowPermissionIDL r2) throws RemoteException {
        this(r2, true);
    }

    public Map isPermissionGranted(List<String> r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
        Map r12 = null;
    L14:
        e = move-exception;
        int r13 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowPermissionIDLIPC", "isPermissionGranted(" + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r15 = new IPCException(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowPermissionIDLIPC", "isPermissionGranted(" + r23 + ") = fail", r15, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowPermissionIDLIPC", "isPermissionGranted", r15, r7, r18);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r14 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowPermissionIDLIPC", "isPermissionGranted(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r16 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowPermissionIDLIPC", "isPermissionGranted(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r12 = this.origin.isPermissionGranted(r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r17 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowPermissionIDLIPC", "isPermissionGranted = " + r12);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r110 = Math.max(0, r19 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowPermissionIDLIPC", "isPermissionGranted(" + r23 + ") = " + r12, r110);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowPermissionIDLIPC", "isPermissionGranted", r110, r19);     // Catch: Exception -> L14 Throwable -> L17
        return r12;
    L16:
        return r12;
    }

    public void updateAppletPermissions(List<Permission> r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowPermissionIDLIPC", "updateAppletPermissions(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowPermissionIDLIPC", "updateAppletPermissions(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowPermissionIDLIPC", "updateAppletPermissions", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowPermissionIDLIPC", "updateAppletPermissions(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowPermissionIDLIPC", "updateAppletPermissions(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.updateAppletPermissions(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowPermissionIDLIPC", "updateAppletPermissions = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowPermissionIDLIPC", "updateAppletPermissions(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowPermissionIDLIPC", "updateAppletPermissions", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void updatePersonalPermissions(List<Permission> r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowPermissionIDLIPC", "updatePersonalPermissions(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowPermissionIDLIPC", "updatePersonalPermissions(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowPermissionIDLIPC", "updatePersonalPermissions", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowPermissionIDLIPC", "updatePersonalPermissions(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowPermissionIDLIPC", "updatePersonalPermissions(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.updatePersonalPermissions(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowPermissionIDLIPC", "updatePersonalPermissions = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowPermissionIDLIPC", "updatePersonalPermissions(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowPermissionIDLIPC", "updatePersonalPermissions", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public FlowPermissionIDLIpcWrapper(IFlowPermissionIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    public Map isAppletPermissionGranted(String r23, List<String> r24) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
        Map r12 = null;
    L14:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowPermissionIDLIPC", "isAppletPermissionGranted(" + r23 + ", " + r24 + ")", e);     // Catch: Throwable -> L17
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r20 - r8) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowPermissionIDLIPC", "isAppletPermissionGranted(" + r23 + ", " + r24 + ") = fail", r4, r9);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowPermissionIDLIPC", "isAppletPermissionGranted", r4, r9, r20);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r15 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowPermissionIDLIPC", "isAppletPermissionGranted(" + r23 + ", " + r24 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r16 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowPermissionIDLIPC", "isAppletPermissionGranted(" + r23 + ", " + r24 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r12 = this.origin.isAppletPermissionGranted(r23, r24);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r17 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowPermissionIDLIPC", "isAppletPermissionGranted = " + r12);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r11 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowPermissionIDLIPC", "isAppletPermissionGranted(" + r23 + ", " + r24 + ") = " + r12, r11);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowPermissionIDLIPC", "isAppletPermissionGranted", r11, r21);     // Catch: Exception -> L14 Throwable -> L17
        return r12;
    L16:
        return r12;
    }

    public Map isPersonalPermissionGranted(String r23, List<String> r24) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
        Map r12 = null;
    L14:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowPermissionIDLIPC", "isPersonalPermissionGranted(" + r23 + ", " + r24 + ")", e);     // Catch: Throwable -> L17
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r20 - r8) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowPermissionIDLIPC", "isPersonalPermissionGranted(" + r23 + ", " + r24 + ") = fail", r4, r9);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowPermissionIDLIPC", "isPersonalPermissionGranted", r4, r9, r20);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r15 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowPermissionIDLIPC", "isPersonalPermissionGranted(" + r23 + ", " + r24 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r16 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowPermissionIDLIPC", "isPersonalPermissionGranted(" + r23 + ", " + r24 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r12 = this.origin.isPersonalPermissionGranted(r23, r24);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r17 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowPermissionIDLIPC", "isPersonalPermissionGranted = " + r12);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r11 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowPermissionIDLIPC", "isPersonalPermissionGranted(" + r23 + ", " + r24 + ") = " + r12, r11);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowPermissionIDLIPC", "isPersonalPermissionGranted", r11, r21);     // Catch: Exception -> L14 Throwable -> L17
        return r12;
    L16:
        return r12;
    }

    public boolean requestPermission(String r23, String r24) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
        boolean r12 = false;
    L14:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowPermissionIDLIPC", "requestPermission(" + r23 + ", " + r24 + ")", e);     // Catch: Throwable -> L17
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r20 - r8) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowPermissionIDLIPC", "requestPermission(" + r23 + ", " + r24 + ") = fail", r4, r9);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowPermissionIDLIPC", "requestPermission", r4, r9, r20);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r15 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowPermissionIDLIPC", "requestPermission(" + r23 + ", " + r24 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r16 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowPermissionIDLIPC", "requestPermission(" + r23 + ", " + r24 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r12 = this.origin.requestPermission(r23, r24);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r17 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowPermissionIDLIPC", "requestPermission = " + r12);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r11 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowPermissionIDLIPC", "requestPermission(" + r23 + ", " + r24 + ") = " + r12, r11);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowPermissionIDLIPC", "requestPermission", r11, r21);     // Catch: Exception -> L14 Throwable -> L17
        return r12;
    L16:
        return r12;
    }
}
