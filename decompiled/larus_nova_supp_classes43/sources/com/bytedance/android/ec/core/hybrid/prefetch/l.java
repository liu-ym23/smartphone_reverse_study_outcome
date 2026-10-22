package com.bytedance.android.ec.core.hybrid.prefetch;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ NativePrefetch c;

    public l(String r1, Map r10, NativePrefetch r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.i(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
