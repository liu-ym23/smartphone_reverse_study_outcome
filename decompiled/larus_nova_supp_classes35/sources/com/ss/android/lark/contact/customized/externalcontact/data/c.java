package com.ss.android.lark.contact.customized.externalcontact.data;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements Runnable {
    public final /* synthetic */ PersonalContactsLoader a;
    public final /* synthetic */ String b;

    public c(PersonalContactsLoader r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((HashMap) this.a.f).clear();     // Catch: Throwable -> L4
        this.a.e.setValue(new i9b.a.C0235a(this.b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
