package com.lynx.tasm.fontface;

import android.graphics.Typeface;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e implements Runnable {
    public final /* synthetic */ com.lynx.tasm.behavior.shadow.text.g.c a;
    public final /* synthetic */ Typeface b;
    public final /* synthetic */ int c;

    @Override // java.lang.Runnable
    public final void run() {
        LLog.i("Lynx", "load font success");     // Catch: Throwable -> L4
        this.a.a(this.b, this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(com.lynx.tasm.behavior.shadow.text.g.c r1, Typeface r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
