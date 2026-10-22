package com.larus.bmhome.clarification;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s1 implements Runnable {
    public final /* synthetic */ ClarificationComponent a;
    public final /* synthetic */ boolean b;

    public s1(ClarificationComponent r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        ClarificationComponent r0 = this.a;
        boolean r1 = this.b;
        d2 r2 = r0.n.a;
        if (r2 == null) goto L12;
        ze8.b r3 = r2.k;
        if (r3 == null) goto L13;
        if (r1 == false) goto L9;
        int r4 = i5.D();
    L10:
        boolean r5 = r3.a(r4);
        FLogger.a.i("ClarificationComponent", "clarification panel ime height changed, isImeShow=" + r1 + ", maxPanelHeightPx=" + r4 + ", updated=" + r5);
        return;
    L9:
        r4 = r0.z3();
        goto L10
    L13:
        return;
    }

    @Override // java.lang.Runnable
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
}
