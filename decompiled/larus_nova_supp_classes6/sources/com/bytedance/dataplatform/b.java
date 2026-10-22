package com.bytedance.dataplatform;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;

    @Override // java.lang.Runnable
    public final void run() {
        g.c(this.a, this.b).edit().putInt(this.c, this.d).apply();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(Context r1, String r2, int r3) {
        this.a = r1;
        this.b = "CLIENT_EXPERIMENT_CACHE_TAG";
        this.c = r2;
        this.d = r3;
    }
}
