package com.ss.android.lark.passport.flow.mfa;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class w implements Runnable {
    public final /* synthetic */ IGetDataCallback<Object> a;
    public final /* synthetic */ Object b;

    public w(IGetDataCallback<Object> r1, Object r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onSuccess(this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
