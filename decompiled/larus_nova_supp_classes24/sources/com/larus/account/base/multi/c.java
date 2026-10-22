package com.larus.account.base.multi;

import com.larus.applog.api.IApplog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ q38.b.a a;

    public /* synthetic */ c(q38.b.a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q38.b.a r0 = this.a;
        if (r0 == null) goto L9;
        IApplog.Companion r1 = IApplog.a;
        String r2 = r0.a();
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        r1.a("tenant_id", r2);
        return;
    }
}
