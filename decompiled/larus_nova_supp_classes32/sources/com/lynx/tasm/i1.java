package com.lynx.tasm;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i1 implements Runnable {
    public final /* synthetic */ LynxTemplateRender.p a;

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (LynxTemplateRender.access$1500(this.a.a) == null) goto L9;
        LynxTemplateRender.access$1500(this.a.a).onFirstScreen();     // Catch: Throwable -> L6
        return;
    }

    public i1(LynxTemplateRender.p r1) {
        this.a = r1;
    }
}
