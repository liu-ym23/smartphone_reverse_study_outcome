package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements Runnable {
    public final /* synthetic */ a.b a;

    public c(a.b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EditText r0 = this.a.e;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.requestFocus();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
