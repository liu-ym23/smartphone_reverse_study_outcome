package com.bytedance.android.anniex.ui;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.tasm.LynxError;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ AnnieXLynxView c;

    @Override // java.lang.Runnable
    public final void run() {
        LynxError r0 = new LynxError(10203, "Error occurred while fetching app bundle resource");     // Catch: Throwable -> L6
        r0.setRootCause(this.a);     // Catch: Throwable -> L6
        r0.setCallStack(this.b);     // Catch: Throwable -> L6
        LynxDevtool r1 = this.c.D();     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r1.showErrorMessage(r0);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public d(String r1, String r10, AnnieXLynxView r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
