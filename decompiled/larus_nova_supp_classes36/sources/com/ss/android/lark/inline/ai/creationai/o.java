package com.ss.android.lark.inline.ai.creationai;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o implements Runnable {
    public final /* synthetic */ CreationAIDragView a;

    public static final class a implements Runnable {
        public final /* synthetic */ CreationAIDragView a;

        public a(CreationAIDragView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CreationAIDragView r0 = this.a;     // Catch: Throwable -> L4
            int r1 = CreationAIDragView.h0;     // Catch: Throwable -> L4
            r0.n();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public o(CreationAIDragView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Log.i("CreationAIDragView", "showInternalRunnable() called");     // Catch: Throwable -> L4
        CreationAIDragView.c(this.a);     // Catch: Throwable -> L4
        CreationAIDragView r0 = this.a;     // Catch: Throwable -> L4
        r0.b.post(new a(r0));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
