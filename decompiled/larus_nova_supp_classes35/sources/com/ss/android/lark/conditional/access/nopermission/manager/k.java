package com.ss.android.lark.conditional.access.nopermission.manager;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.component.appcontext.LarkAppContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements Runnable {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        LarkAppContext.Companion.getClass();     // Catch: Throwable -> L4
        x08.a.a(LarkAppContext.access$getInstance$cp().getContext(), 2131892748).show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
