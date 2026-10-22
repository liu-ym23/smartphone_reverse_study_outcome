package com.lynx.tasm.behavior;

import android.graphics.RectF;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b0 implements Runnable {
    public final /* synthetic */ d0 a;

    public final void a() {
        Iterator<u> r0 = this.a.v.iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        u r1 = r0.next();
        if (r1 == null) goto L7;
        if (r1.n.size() == 0) goto L4;
        RectF r2 = r1.b();
        Iterator<u.b> r3 = r1.n.iterator();
    L14:
        if (r3.hasNext() == false) goto L4;
        r1.a(r3.next(), r2, false);
        goto L14
    L7:
        LLog.e("Lynx.IntersectionObserver", "LynxIntersectionObserverManager.notifyObservers failed, because observer is null");
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

    public b0(d0 r1) {
        this.a = r1;
    }
}
