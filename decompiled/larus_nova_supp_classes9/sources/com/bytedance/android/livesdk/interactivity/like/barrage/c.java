package com.bytedance.android.livesdk.interactivity.like.barrage;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements Runnable {
    public final /* synthetic */ DiggController a;

    public c(DiggController r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbsBarrage r0 = this.a.g();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        DiggController r1 = this.a;     // Catch: Throwable -> L6
        int r2 = r1.p.nextInt(r1.o.size());     // Catch: Throwable -> L6
        ((d) ListProtector.get(this.a.o, r2)).a(r0, false);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
