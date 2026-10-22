package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.event.LynxTouchEvent;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g implements Runnable {
    public final /* synthetic */ LynxTouchEvent a;
    public final /* synthetic */ LynxEngineProxy b;

    public final void a() {
        if (this.b.a != 0) goto L6;
        LLog.e("LynxEngineProxy", "sendMultiTouchEvent failed since mNativePtr is null");
        return;
    L6:
        j7a.a r0 = j7a.a.a;
        JavaOnlyMap r1 = this.a.getUITouchMap();
        r0.getClass();
        ByteBuffer r6 = j7a.a.b(r1);
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        LynxEngineProxy r2 = this.b;
        LynxEngineProxy.g(r2, r2.a, this.a.getName(), r6, r7, this.a.getTimestamp());
        return;
    L9:
        r7 = r6.position();
        goto L10
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

    public g(LynxEngineProxy r1, LynxTouchEvent r2) {
        this.b = r1;
        this.a = r2;
    }
}
