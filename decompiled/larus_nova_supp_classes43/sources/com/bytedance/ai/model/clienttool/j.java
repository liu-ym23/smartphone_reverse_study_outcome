package com.bytedance.ai.model.clienttool;

import com.bytedance.ai.event.MessageIndication;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.p;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j extends p {
    public final /* synthetic */ ClientToolRuntime a;

    public j(ClientToolRuntime r1) {
        this.a = r1;
    }

    public final void onEvaluateJavaScriptEnd(String r10) {
        if (Intrinsics.areEqual(r10, this.a.h) == true) goto L5;
        return;
    L5:
        ClientToolRuntime r11 = this.a;
        Object r0 = r11.i;
        monitor-enter(r0);
        ClientToolRuntime.d r1 = r11.l;     // Catch: Throwable -> L23
        if ((r1 instanceof ClientToolRuntime.d.e) == false) goto L11;
        ClientToolRuntime.d.e r12 = (ClientToolRuntime.d.e) r1;     // Catch: Throwable -> L23
    L12:
        if (r12 != null) goto L16;
        monitor-exit(r0);
        return;
    L16:
        if (r12.b == ClientToolRuntime.RunningPhase.PREPARING) goto L19;
        monitor-exit(r0);
        return;
    L19:
        r11.l = new ClientToolRuntime.d.e(r12.a, ClientToolRuntime.RunningPhase.EXECUTING);     // Catch: Throwable -> L23
        ClientToolRuntime.a r13 = r12.a;     // Catch: Throwable -> L23
        monitor-exit(r0);
        com.bytedance.ai.utils.g.a.i("ClientToolRuntime", "evaluate completed runtimeId=" + this.a.c + " messageId=" + r13.i);
        this.a.h(r13);
        return;
    L11:
        r12 = null;
    L23:
        th = move-exception;
        throw th;
    }

    public final void onReceivedError(LynxError r13) {
        if (r13 == null) goto L5;
        String r0 = r13.getSummaryMessage();
        if (r0 == null) goto L5;
    L6:
        String r10 = r0;
        ClientToolRuntime r1 = this.a;
        Object r11 = r1.i;
        monitor-enter(r11);
        ClientToolRuntime.d r12 = r1.l;     // Catch: Throwable -> L49
        Integer r14 = null;
        if ((r12 instanceof ClientToolRuntime.d.e) == false) goto L18;
        ClientToolRuntime.a r15 = ((ClientToolRuntime.d.e) r12).a;     // Catch: Throwable -> L49
        if (((ClientToolRuntime.d.e) r12).b != ClientToolRuntime.RunningPhase.PREPARING) goto L13;
        String r16 = MessageIndication.STATUS_PREPARE;
    L14:
        String r17 = ((ClientToolRuntime.d.e) r12).a.i;     // Catch: Throwable -> L49
        String r18 = r16;
    L15:
        boolean r19 = false;
    L16:
        boolean r20 = false;
    L30:
        monitor-exit(r11);
        com.bytedance.ai.utils.g r21 = com.bytedance.ai.utils.g.a;
        StringBuilder r110 = new StringBuilder("runtime error runtimeId=");
        r110.append(this.a.c);
        r110.append(" appletId=");
        r110.append(this.a.f);
        r110.append(" messageId=");
        r110.append(r17);
        r110.append(" errorCode=");
        if (r13 == null) goto L34;
        r14 = Integer.valueOf(r13.getErrorCode());
    L34:
        r110.append(r14);
        r110.append(" message=");
        r110.append(r10);
        r110.append(" error=");
        r110.append(r13);
        r21.e("ClientToolRuntime", r110.toString());
        if (r15 == null) goto L37;
        this.a.c(r15, new ClientToolRuntime.c(-1, r10, "", r18, "runtime_error"), false);
    L37:
        if (r19 == true) goto L39;
        if (r20 == true) goto L39;
    L40:
        if (r19 == false) goto L53;
        ClientToolRuntime r111 = this.a;
        r111.b.invoke(r111);
        return;
    L53:
        return;
    L39:
        this.a.g();
        goto L40
    L13:
        r16 = "execute";
        goto L14
    L18:
        if ((r12 instanceof ClientToolRuntime.d.a) == false) goto L20;
        r1.l = new ClientToolRuntime.d.a(((ClientToolRuntime.d.a) r12).a, false);     // Catch: Throwable -> L49
        r17 = ((ClientToolRuntime.d.a) r12).a.i;     // Catch: Throwable -> L49
        r18 = "execute";
        r15 = null;
        goto L15
    L20:
        r19 = true;
        if ((r12 instanceof ClientToolRuntime.d.c) == false) goto L27;
        Job r22 = ((ClientToolRuntime.d.c) r12).a;     // Catch: Throwable -> L49
        if (r22 == null) goto L25;
        Job.DefaultImpls.cancel$default(r22, null, 1, null);     // Catch: Throwable -> L49
    L25:
        ((ClientToolRuntime.d.c) r12).a = null;     // Catch: Throwable -> L49
        r1.l = ClientToolRuntime.d.b.a;     // Catch: Throwable -> L49
        r17 = "";
        r18 = "execute";
        r15 = null;
        goto L16
    L27:
        if (Intrinsics.areEqual(r12, ClientToolRuntime.d.C0042d.a) == false) goto L44;
        r1.l = ClientToolRuntime.d.b.a;     // Catch: Throwable -> L49
        r17 = "";
        r18 = "execute";
        r15 = null;
        r19 = false;
        r20 = true;
        goto L30
    L44:
        if (Intrinsics.areEqual(r12, ClientToolRuntime.d.b.a) == false) goto L48;
        monitor-exit(r11);
        return;
    L48:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;
    L5:
        r0 = "Client Tool Runtime error";
        goto L6
    }
}
