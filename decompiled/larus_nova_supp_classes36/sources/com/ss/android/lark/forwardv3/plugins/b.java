package com.ss.android.lark.forwardv3.plugins;

import androidx.appcompat.widget.AppCompatEditText;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ ForwardAtPlugin a;

    public b(ForwardAtPlugin r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AppCompatEditText r0 = this.a.b;     // Catch: Throwable -> L6
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
