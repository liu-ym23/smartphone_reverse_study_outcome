package com.bytedance.android.androidadbbindings;

import android.net.LocalSocket;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AdbBindingsServerContentProvider$a$a implements Runnable {
    public final /* synthetic */ LocalSocket a;
    public final /* synthetic */ b b;

    public AdbBindingsServerContentProvider$a$a(LocalSocket r1, b r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(new a(this.a));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
