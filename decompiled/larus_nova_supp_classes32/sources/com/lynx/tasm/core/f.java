package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.event.LynxTouchEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f implements Runnable {
    public final /* synthetic */ LynxTouchEvent a;
    public final /* synthetic */ LynxEngineProxy b;

    public final void a() {
        if (this.b.a != 0) goto L6;
        LLog.e("LynxEngineProxy", "sendTouchEvent failed since mNativePtr is null");
        return;
    L6:
        LynxTouchEvent.a r1 = this.a.getClientPoint();
        LynxTouchEvent.a r2 = this.a.getPagePoint();
        LynxTouchEvent.a r3 = this.a.getViewPoint();
        LynxEngineProxy r4 = this.b;
        LynxEngineProxy.f(r4, r4.a, this.a.getName(), this.a.getTag(), r1.a, r1.b, r2.a, r2.b, r3.a, r3.b, this.a.getTimestamp());
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

    public f(LynxEngineProxy r1, LynxTouchEvent r2) {
        this.b = r1;
        this.a = r2;
    }
}
