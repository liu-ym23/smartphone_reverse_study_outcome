package com.ss.android.agilelogger;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class a implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ ALog.p e;

    @Override // java.lang.Runnable
    public final void run() {
        int r2 = ALog.access$400(3);     // Catch: Throwable -> L5
        this.e.a.o(r2, this.a, this.b, this.c, this.d);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }

    public a(ALog.p r1, String r2, String r3, long r4, long r6) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
    }
}
