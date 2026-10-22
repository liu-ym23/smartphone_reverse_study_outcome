package com.ss.android.lark.inline.ai.creationai;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ CreationAIDragView a;

    public final void a() {
        Log.i("CreationAIDragView", "checkShowRunnable, needStartShowWhenKeyboardShow = " + this.a.O);
        CreationAIDragView r0 = this.a;
        if (r0.O == true) goto L5;
        return;
    L5:
        CreationAIDragView.d(r0);
        this.a.getClass();
        if (CreationAIDragView.j() == false) goto L8;
        CreationAIDragView r1 = this.a;
        r1.b.postDelayed(r1.d0, 200);
        return;
    L8:
        this.a.b.postDelayed(this, 200);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(CreationAIDragView r1) {
        this.a = r1;
    }
}
