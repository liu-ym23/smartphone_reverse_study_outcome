package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.OTaskTimeoutConfig;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowAppIntentIDLIpcWrapper implements IFlowAppIntentIDL {
    boolean log;
    final IFlowAppIntentIDL origin;

    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public long currentTimeMillis() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L17:
        e = e;
        long r11 = 0;
    L19:
        h.b("IFlowAppIntentIDLIPC", "currentTimeMillis()", e);     // Catch: Throwable -> L21
        IPCException r15 = new IPCException(e);     // Catch: Throwable -> L21
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L21
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L21
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "currentTimeMillis() = fail", r15, r4);     // Catch: Throwable -> L21
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L21
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "currentTimeMillis", r15, r4, r18);     // Catch: Throwable -> L21
        return r11;
    L22:
        return r11;
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowAppIntentIDLIPC", "currentTimeMillis()");     // Catch: Exception -> L17 Throwable -> L23
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowAppIntentIDLIPC", "currentTimeMillis()");     // Catch: Exception -> L17 Throwable -> L23
    L9:
        r11 = this.origin.currentTimeMillis();     // Catch: Exception -> L17 Throwable -> L23
    L15:
        e = e;
        goto L19
    L11:
        if (this.log == false) goto L13;
        int r13 = h.a;     // Catch: Exception -> L15 Throwable -> L21
        h.d("IFlowAppIntentIDLIPC", "currentTimeMillis = " + r11);     // Catch: Exception -> L15 Throwable -> L21
    L13:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L15 Throwable -> L21
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L15 Throwable -> L21
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L15 Throwable -> L21
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "currentTimeMillis() = " + r11, r14);     // Catch: Exception -> L15 Throwable -> L21
        IPCAnomalyTrace.a.c("IFlowAppIntentIDLIPC", "currentTimeMillis", r14, r19);     // Catch: Exception -> L15 Throwable -> L21
        return r11;
    L29:
        return 0;
    }

    public OTaskTimeoutConfig getObricTaskTimeoutConfig() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        OTaskTimeoutConfig r11 = null;
    L14:
        e = move-exception;
        h.b("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getObricTaskTimeoutConfig();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public String getUserId() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        String r11 = null;
    L14:
        e = move-exception;
        h.b("IFlowAppIntentIDLIPC", "getUserId()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "getUserId() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "getUserId", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowAppIntentIDLIPC", "getUserId()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowAppIntentIDLIPC", "getUserId()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getUserId();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowAppIntentIDLIPC", "getUserId = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "getUserId() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppIntentIDLIPC", "getUserId", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public boolean isDoraConnected() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        h.b("IFlowAppIntentIDLIPC", "isDoraConnected()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "isDoraConnected() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "isDoraConnected", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowAppIntentIDLIPC", "isDoraConnected()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowAppIntentIDLIPC", "isDoraConnected()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.isDoraConnected();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowAppIntentIDLIPC", "isDoraConnected = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "isDoraConnected() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppIntentIDLIPC", "isDoraConnected", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public boolean isEnterpriseAccount() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        h.b("IFlowAppIntentIDLIPC", "isEnterpriseAccount()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "isEnterpriseAccount() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "isEnterpriseAccount", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowAppIntentIDLIPC", "isEnterpriseAccount()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowAppIntentIDLIPC", "isEnterpriseAccount()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.isEnterpriseAccount();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowAppIntentIDLIPC", "isEnterpriseAccount = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "isEnterpriseAccount() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppIntentIDLIPC", "isEnterpriseAccount", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public boolean isLogin() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        h.b("IFlowAppIntentIDLIPC", "isLogin()", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r17 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "isLogin() = fail", r14, r4);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "isLogin", r14, r4, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowAppIntentIDLIPC", "isLogin()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowAppIntentIDLIPC", "isLogin()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.isLogin();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r12 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowAppIntentIDLIPC", "isLogin = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r6 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "isLogin() = " + r11, r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppIntentIDLIPC", "isLogin", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    public void jumpDoraPage() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IFlowAppIntentIDLIPC", "jumpDoraPage()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "jumpDoraPage() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "jumpDoraPage", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowAppIntentIDLIPC", "jumpDoraPage()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowAppIntentIDLIPC", "jumpDoraPage()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.jumpDoraPage();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowAppIntentIDLIPC", "jumpDoraPage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "jumpDoraPage() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppIntentIDLIPC", "jumpDoraPage", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public FlowAppIntentIDLIpcWrapper(IFlowAppIntentIDL r2) throws RemoteException {
        this(r2, true);
    }

    public void getLocation(IFlowGetLocationCallbackIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L43
        h.b("IFlowAppIntentIDLIPC", "getLocation(" + r20 + ")", e);     // Catch: Throwable -> L43
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L43
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L43
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "getLocation(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L43
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L43
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "getLocation", r14, r7, r17);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAppIntentIDLIPC", "getLocation(" + r20 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        int r3 = h.a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r4 = new StringBuilder("getLocation(");     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L12;
    L20:
        IFlowGetLocationCallbackIDL r13 = r20;
    L21:
        r4.append(r13);     // Catch: Exception -> L40 Throwable -> L43
        r4.append(")");     // Catch: Exception -> L40 Throwable -> L43
        h.a("IFlowAppIntentIDLIPC", r4.toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if ((r20 instanceof FlowGetLocationCallbackIDLIpcWrapper) == true) goto L20;
        if ((r20 instanceof FlowGetLocationCallbackIDLStubWrapper) == true) goto L20;
        if ((r20 instanceof IFlowGetLocationCallbackIDL.Stub) == false) goto L19;
        r13 = z1.a((IFlowGetLocationCallbackIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = z1.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppIntentIDL r5 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r20 != null) goto L26;
    L34:
        IFlowGetLocationCallbackIDL r15 = r20;
    L35:
        r5.getLocation(r15);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        h.d("IFlowAppIntentIDLIPC", "getLocation = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        int r8 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "getLocation(" + r20 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        IPCAnomalyTrace.a.c("IFlowAppIntentIDLIPC", "getLocation", r16, r18);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if ((r20 instanceof FlowGetLocationCallbackIDLIpcWrapper) == true) goto L34;
        if ((r20 instanceof FlowGetLocationCallbackIDLStubWrapper) == true) goto L34;
        if ((r20 instanceof IFlowGetLocationCallbackIDL.Stub) == false) goto L33;
        r15 = z1.a((IFlowGetLocationCallbackIDL.Stub) r20);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r15 = z1.b(r20);     // Catch: Exception -> L40 Throwable -> L43
    }

    public boolean openMiniApp(String r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
        boolean r12 = false;
    L14:
        e = move-exception;
        int r13 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowAppIntentIDLIPC", "openMiniApp(" + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r15 = new IPCException(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "openMiniApp(" + r23 + ") = fail", r15, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "openMiniApp", r15, r7, r18);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r14 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppIntentIDLIPC", "openMiniApp(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r16 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppIntentIDLIPC", "openMiniApp(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r12 = this.origin.openMiniApp(r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r17 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowAppIntentIDLIPC", "openMiniApp = " + r12);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r110 = Math.max(0, r19 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "openMiniApp(" + r23 + ") = " + r12, r110);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppIntentIDLIPC", "openMiniApp", r110, r19);     // Catch: Exception -> L14 Throwable -> L17
        return r12;
    L16:
        return r12;
    }

    public void setAppIntentActive(boolean r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowAppIntentIDLIPC", "setAppIntentActive(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "setAppIntentActive(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "setAppIntentActive", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppIntentIDLIPC", "setAppIntentActive(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppIntentIDLIPC", "setAppIntentActive(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setAppIntentActive(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowAppIntentIDLIPC", "setAppIntentActive = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "setAppIntentActive(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppIntentIDLIPC", "setAppIntentActive", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public void stopComplexTask(String r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowAppIntentIDLIPC", "stopComplexTask(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "stopComplexTask(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "stopComplexTask", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppIntentIDLIPC", "stopComplexTask(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppIntentIDLIPC", "stopComplexTask(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.stopComplexTask(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowAppIntentIDLIPC", "stopComplexTask = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "stopComplexTask(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppIntentIDLIPC", "stopComplexTask", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public boolean syncAppletData(String r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
        boolean r12 = false;
    L14:
        e = move-exception;
        int r13 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowAppIntentIDLIPC", "syncAppletData(" + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r15 = new IPCException(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "syncAppletData(" + r23 + ") = fail", r15, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "syncAppletData", r15, r7, r18);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        int r14 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppIntentIDLIPC", "syncAppletData(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r16 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppIntentIDLIPC", "syncAppletData(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r12 = this.origin.syncAppletData(r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        int r17 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.d("IFlowAppIntentIDLIPC", "syncAppletData = " + r12);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r110 = Math.max(0, r19 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "syncAppletData(" + r23 + ") = " + r12, r110);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppIntentIDLIPC", "syncAppletData", r110, r19);     // Catch: Exception -> L14 Throwable -> L17
        return r12;
    L16:
        return r12;
    }

    public FlowAppIntentIDLIpcWrapper(IFlowAppIntentIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    public boolean checkPermission(String r26, boolean r27, long r28) throws RemoteException {
        long r10 = SystemClock.elapsedRealtimeNanos();
        boolean r16 = false;
    L19:
        e = e;
    L20:
        int r1 = h.a;     // Catch: Throwable -> L22
        h.b("IFlowAppIntentIDLIPC", "checkPermission(" + r26 + ", " + r27 + ", " + r28 + ")", e);     // Catch: Throwable -> L22
        IPCException r2 = new IPCException(e);     // Catch: Throwable -> L22
        long r23 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L22
        long r11 = Math.max(0, r23 - r10) / 1000;     // Catch: Throwable -> L22
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.i.a("IFlowAppIntentIDLIPC", "checkPermission(" + r26 + ", " + r27 + ", " + r28 + ") = fail", r2, r11);     // Catch: Throwable -> L22
        IPCAnomalyTrace r3 = IPCAnomalyTrace.a;     // Catch: Throwable -> L22
        IPCAnomalyTrace.b("IFlowAppIntentIDLIPC", "checkPermission", r2, r11, r23);     // Catch: Throwable -> L22
        return r16;
    L4:
        if (this.log == false) goto L7;
        int r12 = h.a;     // Catch: Exception -> L19 Throwable -> L22
        h.a("IFlowAppIntentIDLIPC", "checkPermission(" + r26 + ", " + r27 + ", " + r28 + ")");     // Catch: Exception -> L19 Throwable -> L22
    L7:
        if (this.log == false) goto L9;
        int r13 = h.a;     // Catch: Exception -> L19 Throwable -> L22
        h.a("IFlowAppIntentIDLIPC", "checkPermission(" + r26 + ", " + r27 + ", " + r28 + ")");     // Catch: Exception -> L19 Throwable -> L22
    L9:
        boolean r14 = this.origin.checkPermission(r26, r27, r28);     // Catch: Exception -> L19 Throwable -> L22
    L15:
        e = e;
        r16 = r14;
        goto L20
    L11:
        if (this.log == false) goto L13;
        int r15 = h.a;     // Catch: Exception -> L15 Throwable -> L17
        h.d("IFlowAppIntentIDLIPC", "checkPermission = " + r14);     // Catch: Exception -> L15 Throwable -> L17
    L13:
        long r24 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L15 Throwable -> L17
        long r4 = Math.max(0, r24 - r10) / 1000;     // Catch: Exception -> L15 Throwable -> L17
        int r17 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L15 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowAppIntentIDLIPC", "checkPermission(" + r26 + ", " + r27 + ", " + r28 + ") = " + r14, r4);     // Catch: Exception -> L15 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppIntentIDLIPC", "checkPermission", r4, r24);     // Catch: Exception -> L15 Throwable -> L17
        return r14;
    L27:
        return r14;
    L28:
        return false;
    }
}
