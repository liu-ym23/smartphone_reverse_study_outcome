package com.ss.android.common.applog;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.tool.BtmDebugTool;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import jta.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class c extends ThreadPlus {
    public final /* synthetic */ d a;

    public final void a() {
        super.run();
        boolean r0 = AppLog.L;
        g.j.v(g.c);
        LinkedList r1 = new LinkedList();     // Catch: Throwable -> L17
        LinkedList<d.a> r2 = this.a.a;     // Catch: Throwable -> L17
        monitor-enter(r2);     // Catch: Throwable -> L17
        r1.addAll(this.a.a);     // Catch: Throwable -> L14
        this.a.a.clear();     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L14
    L8:
        if (r1.isEmpty() == true) goto L26;
        d.a r3 = (d.a) r1.poll();     // Catch: Throwable -> L17
        String r15 = r3.a;     // Catch: Throwable -> L17
        String r14 = r3.b;     // Catch: Throwable -> L17
        String r13 = r3.c;     // Catch: Throwable -> L17
        long r10 = r3.d;     // Catch: Throwable -> L17
        long r8 = r3.e;     // Catch: Throwable -> L17
        boolean r12 = r3.f;     // Catch: Throwable -> L17
        com.bytedance.android.btm.api.model.j r7 = new com.bytedance.android.btm.api.model.j(null, r15, r14, r13, r10, r8, r12, r3.g, true);     // Catch: Throwable -> L17
        BtmSDK r4 = BtmSDK.INSTANCE;     // Catch: Throwable -> L17
        com.bytedance.android.btm.api.model.j r5 = r4.addBtmEventParam(r7);     // Catch: Throwable -> L17
        com.bytedance.android.btm.api.bst.b r6 = (com.bytedance.android.btm.api.bst.b) yc.b.a(com.bytedance.android.btm.api.bst.b.class);     // Catch: Throwable -> L17
        if (r6 == null) goto L12;
        r6.hookApplog(r5);     // Catch: Throwable -> L17
    L12:
        r4.getService().checkEventParam(r5);     // Catch: Throwable -> L17
        BtmDebugTool.b.onEventIntercepted(r5);     // Catch: Throwable -> L17
        AppLog.F(null, r15, r14, r13, r10, r8, r12, r5.h);     // Catch: Throwable -> L17
        goto L8
    L26:
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(d r1) {
        this.a = r1;
        super("handle_cached_events");
    }
}
