package com.lynx.tasm.behavior;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class y implements Runnable {
    public final /* synthetic */ u a;
    public final /* synthetic */ d0 b;

    public final void a() {
        if (this.b.v.contains(this.a) == false) goto L5;
        return;
    L5:
        this.b.v.add(this.a);
        if (this.b.v.size() != 1) goto L14;
        LynxContext r0 = this.a.getContext();
        if (r0 == null) goto L10;
        this.b.l(r0);
        d0 r1 = this.b;
        r1.y = r0.getEnableNewIntersectionObserver();
    L10:
        d0 r2 = this.b;
        if (r2.y == false) goto L15;
        r2.b();
        return;
    L15:
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

    public y(d0 r1, u r2) {
        this.b = r1;
        this.a = r2;
    }
}
