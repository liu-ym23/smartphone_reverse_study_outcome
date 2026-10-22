package com.lynx.tasm.ui.image;

import com.facebook.datasource.DataSource;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w implements Runnable {
    public final /* synthetic */ y a;

    public final void a() {
        q r0 = this.a.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.l == null) goto L14;
        r0.a.a.remove(r0);
        r0.c = true;
        if (r0.d == true) goto L15;
        r0.d().onSubmit(r0.o, r0.p);
        r0.d = true;
        r0.e = false;
        DataSource<T> r1 = r0.e();
        r0.g = r1;
        String r2 = r0.o;
        if (r1 == 0) goto L11;
        r1.subscribe(new r(r0, r2, r1.hasResult()), r0.b);
        return;
    L11:
        LLog.i("LynxImage", "request after dataSource release url= " + r0.n);
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

    public w(y r1) {
        this.a = r1;
    }
}
