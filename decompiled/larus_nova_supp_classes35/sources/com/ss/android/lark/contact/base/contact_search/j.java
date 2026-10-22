package com.ss.android.lark.contact.base.contact_search;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements Runnable {
    public final /* synthetic */ s a;

    @Override // java.lang.Runnable
    public final void run() {
        s r0 = this.a;     // Catch: Throwable -> L6
        ApiUtils.a<Boolean> r1 = r0.p;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r1.consume(Boolean.valueOf(r0.B));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public j(s r1) {
        this.a = r1;
    }
}
