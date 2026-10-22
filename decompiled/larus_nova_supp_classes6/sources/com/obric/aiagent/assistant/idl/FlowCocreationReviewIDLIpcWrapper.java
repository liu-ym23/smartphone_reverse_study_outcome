package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowCocreationReviewIDLIpcWrapper implements IFlowCocreationReviewIDL {
    boolean log;
    final IFlowCocreationReviewIDL origin;

    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public FlowCocreationReviewIDLIpcWrapper(IFlowCocreationReviewIDL r2) throws RemoteException {
        this(r2, true);
    }

    public FlowCocreationReviewIDLIpcWrapper(IFlowCocreationReviewIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    public void logOmniUserStop(String r24, long r25, String r27, long r28, String r30, String r31) throws RemoteException {
        long r16 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = e;
        String r1 = ", ";
        String r20 = "IFlowCocreationReviewIDLIPC";
        String r22 = ")";
        String r13 = r27;
        String r12 = r30;
        String r14 = "logOmniUserStop(";
        String r15 = r31;
    L42:
        int r2 = h.a;     // Catch: Throwable -> L44
        String r7 = r20;
        h.b(r7, r14 + r24 + r1 + r25 + r1 + r13 + r1 + r28 + r1 + r12 + r1 + r15 + r22, e);     // Catch: Throwable -> L44
        IPCException r3 = new IPCException(e);     // Catch: Throwable -> L44
        long r8 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L44
        long r5 = Math.max(0, r8 - r16) / 1000;     // Catch: Throwable -> L44
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L44
        com.obric.aiagent.ipc.utils.i.a(r7, r14 + r24 + r1 + r25 + r1 + r13 + r1 + r28 + r1 + r12 + r1 + r15 + ") = fail", r3, r5);     // Catch: Throwable -> L44
        IPCAnomalyTrace r4 = IPCAnomalyTrace.a;     // Catch: Throwable -> L44
        IPCAnomalyTrace.b("IFlowCocreationReviewIDLIPC", "logOmniUserStop", r3, r5, r8);     // Catch: Throwable -> L44
        return;
    L4:
        if (this.log == false) goto L7;
        int r6 = h.a;     // Catch: Exception -> L40 Throwable -> L44
        h.a("IFlowCocreationReviewIDLIPC", "logOmniUserStop(" + r24 + ", " + r25 + ", " + r27 + ", " + r28 + ", " + r30 + ", " + r31 + ")");     // Catch: Exception -> L40 Throwable -> L44
    L7:
        if (this.log == false) goto L9;
        int r9 = h.a;     // Catch: Exception -> L40 Throwable -> L44
        h.a("IFlowCocreationReviewIDLIPC", "logOmniUserStop(" + r24 + ", " + r25 + ", " + r27 + ", " + r28 + ", " + r30 + ", " + r31 + ")");     // Catch: Exception -> L40 Throwable -> L44
    L9:
        r15 = r31;
        r22 = ")";
        this.origin.logOmniUserStop(r24, r25, r27, r28, r30, r31);     // Catch: Exception -> L38 Throwable -> L44
        if (this.log == false) goto L14;
        h.d("IFlowCocreationReviewIDLIPC", "logOmniUserStop = void");     // Catch: Exception -> L38 Throwable -> L44
    L14:
        long r10 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L38 Throwable -> L44
        long r11 = Math.max(0, r10 - r16) / 1000;     // Catch: Exception -> L38 Throwable -> L44
        int r17 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L38 Throwable -> L44
        StringBuilder r18 = new StringBuilder("logOmniUserStop(");     // Catch: Exception -> L36 Throwable -> L44
        r18.append(r24);     // Catch: Exception -> L36 Throwable -> L44
        r1 = ", ";
        r18.append(r1);     // Catch: Exception -> L34 Throwable -> L44
        r18.append(r25);     // Catch: Exception -> L34 Throwable -> L44
        r18.append(r1);     // Catch: Exception -> L34 Throwable -> L44
        r18.append(r27);     // Catch: Exception -> L32 Throwable -> L44
        r18.append(r1);     // Catch: Exception -> L32 Throwable -> L44
        r18.append(r28);     // Catch: Exception -> L32 Throwable -> L44
        r18.append(r1);     // Catch: Exception -> L32 Throwable -> L44
        r18.append(r30);     // Catch: Exception -> L28 Throwable -> L44
        r18.append(r1);     // Catch: Exception -> L28 Throwable -> L44
        r18.append(r15);     // Catch: Exception -> L28 Throwable -> L44
        r18.append(") = void");     // Catch: Exception -> L28 Throwable -> L44
        com.obric.aiagent.ipc.utils.i.b("IFlowCocreationReviewIDLIPC", r18.toString(), r11);     // Catch: Exception -> L28 Throwable -> L44
        r1 = r1;
        r12 = r30;
        r13 = r27;
        r20 = "IFlowCocreationReviewIDLIPC";
        r14 = "logOmniUserStop(";
        IPCAnomalyTrace.a.c("IFlowCocreationReviewIDLIPC", "logOmniUserStop", r11, r10);     // Catch: Exception -> L26 Throwable -> L44
        return;
    L26:
        e = e;
    L28:
        e = e;
        r12 = r30;
    L30:
        r13 = r27;
    L31:
        r20 = "IFlowCocreationReviewIDLIPC";
        r14 = "logOmniUserStop(";
    L32:
        e = e;
        r12 = r30;
    L34:
        e = e;
        r13 = r27;
        r12 = r30;
        r1 = r1;
    L36:
        e = e;
        r13 = r27;
        r12 = r30;
        r1 = ", ";
    L38:
        e = e;
        r13 = r27;
        r12 = r30;
        r1 = ", ";
        r20 = "IFlowCocreationReviewIDLIPC";
        r14 = "logOmniUserStop(";
    }

    public void logOmniStep(String r25, long r26, String r28, int r29, String r30, String r31, boolean r32, boolean r33, long r34, String r36) throws RemoteException {
        String r15 = r25;
        r26 = r26;
        r28 = r28;
        String r2 = ", ";
        String r17 = ")";
        long r18 = SystemClock.elapsedRealtimeNanos();
        if (this.log == true) goto L82;
        long r4 = r34;
        String r6 = "IFlowCocreationReviewIDLIPC";
    L20:
        if (this.log == true) goto L86;
        String r7 = r36;
        String r16 = "logOmniStep(";
        String r3 = r17;
    L31:
        String r23 = r3;
        String r19 = r6;
        this.origin.logOmniStep(r25, r26, r28, r29, r30, r31, r32, r33, r34, r36);     // Catch: Exception -> L67 Throwable -> L79
        if (this.log == false) goto L36;
        h.d(r19, "logOmniStep = void");     // Catch: Exception -> L67 Throwable -> L79
    L36:
        long r8 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L67 Throwable -> L79
        long r5 = Math.max(0, r8 - r18) / 1000;     // Catch: Exception -> L67 Throwable -> L79
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L67 Throwable -> L79
        String r9 = r16;
        StringBuilder r1 = new StringBuilder(r9);     // Catch: Exception -> L65 Throwable -> L79
        r15 = r25;
        String r12 = r9;
        r1.append(r15);     // Catch: Exception -> L62 Throwable -> L79
        r2 = ", ";
        r1.append(r2);     // Catch: Exception -> L60 Throwable -> L79
        r1.append(r26);     // Catch: Exception -> L58 Throwable -> L79
        r1.append(r2);     // Catch: Exception -> L58 Throwable -> L79
        r28 = r28;
        r1.append(r28);     // Catch: Exception -> L56 Throwable -> L79
        r1.append(r2);     // Catch: Exception -> L56 Throwable -> L79
        r1.append(r29);     // Catch: Exception -> L56 Throwable -> L79
        r1.append(r2);     // Catch: Exception -> L56 Throwable -> L79
        r1.append(r30);     // Catch: Exception -> L56 Throwable -> L79
        r1.append(r2);     // Catch: Exception -> L56 Throwable -> L79
        r1.append(r31);     // Catch: Exception -> L56 Throwable -> L79
        r1.append(r2);     // Catch: Exception -> L56 Throwable -> L79
        r1.append(r32);     // Catch: Exception -> L56 Throwable -> L79
        r1.append(r2);     // Catch: Exception -> L56 Throwable -> L79
        r1.append(r33);     // Catch: Exception -> L56 Throwable -> L79
        r1.append(r2);     // Catch: Exception -> L56 Throwable -> L79
        r1.append(r34);     // Catch: Exception -> L56 Throwable -> L79
        r1.append(r2);     // Catch: Exception -> L56 Throwable -> L79
        r36 = r36;
        r1.append(r36);     // Catch: Exception -> L54 Throwable -> L79
        r1.append(") = void");     // Catch: Exception -> L54 Throwable -> L79
        com.obric.aiagent.ipc.utils.i.b(r19, r1.toString(), r5);     // Catch: Exception -> L54 Throwable -> L79
        r26 = r26;
        IPCAnomalyTrace.a.c("IFlowCocreationReviewIDLIPC", "logOmniStep", r5, r8);     // Catch: Exception -> L52 Throwable -> L79
        return;
    L52:
        e = e;
    L77:
        int r10 = h.a;     // Catch: Throwable -> L79
        StringBuilder r11 = new StringBuilder(r12);     // Catch: Throwable -> L79
        r11.append(r15);     // Catch: Throwable -> L79
        r11.append(r2);     // Catch: Throwable -> L79
        r11.append(r26);     // Catch: Throwable -> L79
        r11.append(r2);     // Catch: Throwable -> L79
        r11.append(r28);     // Catch: Throwable -> L79
        r11.append(r2);     // Catch: Throwable -> L79
        r11.append(r29);     // Catch: Throwable -> L79
        r11.append(r2);     // Catch: Throwable -> L79
        r11.append(r30);     // Catch: Throwable -> L79
        r11.append(r2);     // Catch: Throwable -> L79
        r11.append(r31);     // Catch: Throwable -> L79
        r11.append(r2);     // Catch: Throwable -> L79
        r11.append(r32);     // Catch: Throwable -> L79
        r11.append(r2);     // Catch: Throwable -> L79
        r11.append(r33);     // Catch: Throwable -> L79
        r11.append(r2);     // Catch: Throwable -> L79
        r11.append(r34);     // Catch: Throwable -> L79
        r11.append(r2);     // Catch: Throwable -> L79
        r11.append(r36);     // Catch: Throwable -> L79
        r11.append(r23);     // Catch: Throwable -> L79
        h.b(r19, r11.toString(), e);     // Catch: Throwable -> L79
        IPCException r13 = new IPCException(e);     // Catch: Throwable -> L79
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L79
        long r14 = Math.max(0, r110 - r18) / 1000;     // Catch: Throwable -> L79
        int r20 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L79
        com.obric.aiagent.ipc.utils.i.a(r19, r12 + r15 + r2 + r26 + r2 + r28 + r2 + r29 + r2 + r30 + r2 + r31 + r2 + r32 + r2 + r33 + r2 + r34 + r2 + r36 + ") = fail", r13, r14);     // Catch: Throwable -> L79
        IPCAnomalyTrace r21 = IPCAnomalyTrace.a;     // Catch: Throwable -> L79
        IPCAnomalyTrace.b("IFlowCocreationReviewIDLIPC", "logOmniStep", r13, r14, r110);     // Catch: Throwable -> L79
        return;
    L54:
        e = e;
    L55:
        r26 = r26;
    L56:
        e = e;
    L57:
        r36 = r36;
    L58:
        e = e;
        r28 = r28;
    L60:
        e = e;
        r26 = r26;
        r28 = r28;
        r36 = r36;
    L62:
        e = e;
    L64:
        r2 = ", ";
    L65:
        e = e;
        r15 = r25;
        r12 = r9;
    L67:
        e = e;
        r15 = r25;
        r12 = r16;
    L69:
        e = e;
    L70:
        r23 = r3;
        r36 = r7;
        r12 = r16;
    L72:
        r19 = r6;
        goto L77
    L86:
        int r22 = h.a;     // Catch: Exception -> L28 Throwable -> L79
        StringBuilder r24 = new StringBuilder("logOmniStep(");     // Catch: Exception -> L28 Throwable -> L79
        r24.append(r15);     // Catch: Exception -> L28 Throwable -> L79
        r24.append(", ");     // Catch: Exception -> L28 Throwable -> L79
        r24.append(r26);     // Catch: Exception -> L28 Throwable -> L79
        r24.append(", ");     // Catch: Exception -> L28 Throwable -> L79
        r24.append(r28);     // Catch: Exception -> L28 Throwable -> L79
        r24.append(", ");     // Catch: Exception -> L28 Throwable -> L79
        r24.append(r29);     // Catch: Exception -> L28 Throwable -> L79
        r24.append(", ");     // Catch: Exception -> L28 Throwable -> L79
        r24.append(r30);     // Catch: Exception -> L28 Throwable -> L79
        r24.append(", ");     // Catch: Exception -> L28 Throwable -> L79
        r24.append(r31);     // Catch: Exception -> L28 Throwable -> L79
        r24.append(", ");     // Catch: Exception -> L28 Throwable -> L79
        r24.append(r32);     // Catch: Exception -> L26 Throwable -> L79
        r24.append(", ");     // Catch: Exception -> L26 Throwable -> L79
        r24.append(r33);     // Catch: Exception -> L26 Throwable -> L79
        r24.append(", ");     // Catch: Exception -> L26 Throwable -> L79
        r24.append(r4);     // Catch: Exception -> L26 Throwable -> L79
        r24.append(", ");     // Catch: Exception -> L26 Throwable -> L79
        r7 = r36;
        r16 = "logOmniStep(";
        r3 = r17;
        r24.append(r7);     // Catch: Exception -> L69 Throwable -> L79
        r24.append(r3);     // Catch: Exception -> L69 Throwable -> L79
        h.a(r6, r24.toString());     // Catch: Exception -> L69 Throwable -> L79
    L26:
        e = e;
        r36 = r36;
        r12 = "logOmniStep(";
        r23 = r17;
    L28:
        e = e;
        r7 = r36;
        r16 = "logOmniStep(";
        r3 = r17;
    L73:
        e = e;
    L74:
        r36 = r36;
        r26 = r26;
        r15 = r15;
        r23 = r17;
        r12 = "logOmniStep(";
        goto L72
    L82:
        int r27 = h.a;     // Catch: Exception -> L17 Throwable -> L79
        StringBuilder r35 = new StringBuilder("logOmniStep(");     // Catch: Exception -> L17 Throwable -> L79
        r35.append(r15);     // Catch: Exception -> L17 Throwable -> L79
        r35.append(", ");     // Catch: Exception -> L17 Throwable -> L79
        r35.append(r26);     // Catch: Exception -> L17 Throwable -> L79
        r35.append(", ");     // Catch: Exception -> L17 Throwable -> L79
        r35.append(r28);     // Catch: Exception -> L17 Throwable -> L79
        r35.append(", ");     // Catch: Exception -> L17 Throwable -> L79
        r35.append(r29);     // Catch: Exception -> L17 Throwable -> L79
        r35.append(", ");     // Catch: Exception -> L17 Throwable -> L79
        r35.append(r30);     // Catch: Exception -> L17 Throwable -> L79
        r35.append(", ");     // Catch: Exception -> L17 Throwable -> L79
        r35.append(r31);     // Catch: Exception -> L17 Throwable -> L79
        r35.append(", ");     // Catch: Exception -> L17 Throwable -> L79
        r35.append(r32);     // Catch: Exception -> L17 Throwable -> L79
        r35.append(", ");     // Catch: Exception -> L17 Throwable -> L79
        r35.append(r33);     // Catch: Exception -> L17 Throwable -> L79
        r35.append(", ");     // Catch: Exception -> L17 Throwable -> L79
        r4 = r34;
        r35.append(r4);     // Catch: Exception -> L15 Throwable -> L79
        r35.append(", ");     // Catch: Exception -> L15 Throwable -> L79
        r35.append(r36);     // Catch: Exception -> L15 Throwable -> L79
        r35.append(r17);     // Catch: Exception -> L12 Throwable -> L79
        r17 = r17;
        r6 = "IFlowCocreationReviewIDLIPC";
        h.a(r6, r35.toString());     // Catch: Exception -> L73 Throwable -> L79
    L12:
        e = e;
        r17 = r17;
    L14:
        r6 = "IFlowCocreationReviewIDLIPC";
    L15:
        e = e;
    L17:
        e = e;
    L75:
        e = e;
        r36 = r36;
        r26 = r26;
        r15 = r15;
        r19 = "IFlowCocreationReviewIDLIPC";
        r23 = r17;
        r2 = ", ";
        r12 = "logOmniStep(";
    }
}
