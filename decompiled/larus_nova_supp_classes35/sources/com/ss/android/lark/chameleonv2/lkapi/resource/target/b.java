package com.ss.android.lark.chameleonv2.lkapi.resource.target;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements Runnable {
    public final /* synthetic */ Context a;

    public b(Context r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UDToast.a r0 = UDToast.build(this.a);     // Catch: Throwable -> L4
        r0.d(2131256189);     // Catch: Throwable -> L4
        r0.g(this.a.getString(2131889046));     // Catch: Throwable -> L4
        r0.b.d = -1;     // Catch: Throwable -> L4
        r0.h();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
