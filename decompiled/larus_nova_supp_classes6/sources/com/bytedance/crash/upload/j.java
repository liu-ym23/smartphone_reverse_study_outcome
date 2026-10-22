package com.bytedance.crash.upload;

import com.bytedance.crash.util.p;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class j implements Runnable {
    public final /* synthetic */ i a;

    public final void a() {
        i r0 = this.a;
        r0.getClass();
        p.d("disaster:checkNetworkRestore");
        if (r0.a.size() <= 0) goto L23;
        HashMap r1 = new HashMap();     // Catch: Throwable -> L24
        Iterator r2 = r0.a.entrySet().iterator();     // Catch: Throwable -> L24
    L8:
        if (r2.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) r2.next();     // Catch: Throwable -> L24
        if (r3 == null) goto L8;
        h r4 = (h) r3.getValue();     // Catch: Throwable -> L24
        if (r4 == null) goto L8;
        if (r0.i(r4) > 0) goto L8;
        r1.put(r4.b, r4.c);     // Catch: Throwable -> L24
        goto L8
    L18:
        Iterator r5 = r1.entrySet().iterator();     // Catch: Throwable -> L24
    L19:
        if (r5.hasNext() == false) goto L40;
        Map.Entry r6 = (Map.Entry) r5.next();     // Catch: Throwable -> L24
        r0.p((String) r6.getKey(), (String) r6.getValue());     // Catch: Throwable -> L24
        goto L19
    L40:
        return;
    L23:
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

    public j(i r1) {
        this.a = r1;
    }
}
