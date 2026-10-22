package com.ss.android.lark.chat.utils;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i1 implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    @Override // java.lang.Runnable
    public final void run() {
        h7b.i.b(this.a, this.b, this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i1(Context r1, String r2) {
        this.a = r1;
        this.b = null;
        this.c = r2;
    }
}
