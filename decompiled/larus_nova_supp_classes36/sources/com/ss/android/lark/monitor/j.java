package com.ss.android.lark.monitor;

import android.content.Intent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements Runnable {
    public final /* synthetic */ k a;

    public final void a() {
        k.a r0 = this.a.a;
        if (r0 == null) goto L13;
        LarkMetrics r1 = (LarkMetrics) r0;
        if (r1.d.g == false) goto L8;
        Log.d("LarkMetrics", "background ticked");
    L8:
        if (r1.k == true) goto L14;
        r1.b("Background");
        if (r1.d.d == false) goto L15;
        Intent r2 = new Intent("com.ss.android.lark.metrics.doMetrics");
        r2.setPackage(r1.a.getPackageName());
        r2.putExtra("activity_name", "Background");
        r1.a.sendBroadcast(r2);
        return;
    L15:
        return;
    L14:
        return;
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

    public j(k r1) {
        this.a = r1;
    }
}
