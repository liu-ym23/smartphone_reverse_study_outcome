package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements Runnable {
    public final /* synthetic */ CharSequence a;
    public final /* synthetic */ a.b b;

    public b(CharSequence r1, a.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EditText r0 = this.b.e;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.setText(this.a);     // Catch: Throwable -> L7
    L5:
        this.b.b.c();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
