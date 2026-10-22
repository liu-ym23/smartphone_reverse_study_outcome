package com.ss.android.lark.contact.customized.externalcontact.data;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements Runnable {
    public final /* synthetic */ EnterpriseContactsLoader a;

    public b(EnterpriseContactsLoader r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EnterpriseContactsLoader r0 = this.a;     // Catch: Throwable -> L4
        r0.e.setValue(new i9b.a.c(r0.f));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
