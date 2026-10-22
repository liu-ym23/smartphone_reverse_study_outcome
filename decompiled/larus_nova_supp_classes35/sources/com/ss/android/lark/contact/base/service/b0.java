package com.ss.android.lark.contact.base.service;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b0 implements Runnable {
    public final /* synthetic */ InvRequestUtils.LocalAndServerRequestImpl<Object> a;

    public b0(InvRequestUtils.LocalAndServerRequestImpl<Object> r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InvRequestUtils.LocalAndServerRequestImpl<Object> r0 = this.a;     // Catch: Throwable -> L4
        r0.b = false;     // Catch: Throwable -> L4
        r0.c = false;     // Catch: Throwable -> L4
        r0.a.onShowLoading();     // Catch: Throwable -> L4
        InvRequestUtils.LocalAndServerRequestImpl<Object> r1 = this.a;     // Catch: Throwable -> L4
        r1.b = true;     // Catch: Throwable -> L4
        r1.a.a(r1.d);     // Catch: Throwable -> L4
        InvRequestUtils.LocalAndServerRequestImpl<Object> r2 = this.a;     // Catch: Throwable -> L4
        r2.a.e(r2.e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
