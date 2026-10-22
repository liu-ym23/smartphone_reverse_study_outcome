package com.ss.android.lark.contact.customized.externalcontact.data;

import com.larus.apm.impl.protector.RunnableProtector;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Runnable {
    public final /* synthetic */ EnterpriseContactsLoader a;
    public final /* synthetic */ String b;

    public a(EnterpriseContactsLoader r1) {
        this.a = r1;
        this.b = BuildConfig.FLAVOR;
    }

    @Override // java.lang.Runnable
    public final void run() {
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
