package com.ss.android.lark.router;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements Runnable {
    public final /* synthetic */ Context a;

    public b(Context r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UDToast.show(this.a, 2131891854);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
