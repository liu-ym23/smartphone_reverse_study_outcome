package com.obric.assistant.util;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ p a;
    public final /* synthetic */ long b;
    public final /* synthetic */ zga.e c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ d(p r1, long r2, zga.e r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p r0 = this.a;
        long r1 = this.b;
        zga.e r3 = this.c;
        boolean r4 = this.d;
        if (r0.g(r1, r3) == true) goto L5;
        FLogger.a.i("AutoDismissDelegate", "ignore stale attention result, ownerId=" + r0.e + ", generation=" + r1);
        return;
    L5:
        r0.t = null;
        FLogger r2 = FLogger.a;
        r2.i("AutoDismissDelegate", "attention result, ownerId=" + r0.e + ", present=" + r4);
        long r5 = p.c(p.d());
        if (r5 != (-1)) goto L8;
        r0.b("follow system lock time after attention result");
        return;
    L8:
        if (r4 == true) goto L11;
        return;
    L11:
        if (com.obric.assistant.t1.a.s1() == true) goto L14;
        r2.i("AutoDismissDelegate", "attention extension skipped: setting disabled, ownerId=" + r0.e);
        return;
    L14:
        if (r0.z("after attention result") == false) goto L16;
        r0.b("active after attention result");
        return;
    L16:
        r0.w(r5, false, "attention present");
    }
}
