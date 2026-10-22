package com.bytedance.bdinstall;

import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m0 implements Runnable {
    public final /* synthetic */ i0$d a;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r0 = new ArrayList(this.a.a).iterator();     // Catch: Throwable -> L9
    L4:
        if (r0.hasNext() == false) goto L21;
        i0$d.a r1 = (i0$d.a) ((WeakReference) r0.next()).get();     // Catch: Throwable -> L9
        if (r1 == null) goto L4;
        r1.onNetworkReady();     // Catch: Throwable -> L9
        goto L4
    L21:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }

    public m0(i0$d r1) {
        this.a = r1;
    }
}
