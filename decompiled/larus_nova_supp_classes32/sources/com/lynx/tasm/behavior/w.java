package com.lynx.tasm.behavior;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ JavaOnlyMap c;
    public final /* synthetic */ d0 d;

    public final void a() {
        LynxContext r0 = this.d.w.get();
        if (r0 != null) goto L5;
        return;
    L5:
        LynxView r1 = r0.getLynxView();
        if (r1 != null) goto L8;
        return;
    L8:
        JavaOnlyArray r2 = new JavaOnlyArray();
        JavaOnlyMap r3 = new JavaOnlyMap();
        r3.putInt("observerId", this.a);
        r3.putInt("callbackId", this.b);
        r3.putMap("payload", this.c);
        r2.pushMap(r3);
        r1.sendGlobalEvent("onIntersectionObserver", r2);
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

    public w(d0 r1, int r2, int r3, JavaOnlyMap r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
