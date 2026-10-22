package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements Runnable {
    public final /* synthetic */ CustomNoPermissionFragment a;
    public final /* synthetic */ String b;

    public i(CustomNoPermissionFragment r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r0 = this.a.getContext();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        UDToast.show(r0, this.b, 2131255144);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
