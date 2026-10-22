package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.conditional.access.nopermission.manager.SecurityPolicyDialogActionManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c0 implements Runnable {
    public static final c0 a = null;

    static {
        a = new c0();
    }

    public c0() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        SecurityPolicyDialogActionManager.a.getClass();     // Catch: Throwable -> L4
        SecurityPolicyDialogActionManager.b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
