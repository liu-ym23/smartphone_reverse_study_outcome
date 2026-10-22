package com.lynx.tasm.behavior;

import android.view.Choreographer;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.base.TraceEvent;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b0 f10811b;

    public /* synthetic */ x(b0 r5, int r10) {
        this.f10810a = r10;
        this.f10811b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f10810a) {
            case 0: goto L16;
            case 1: goto L8;
            default: goto L4;
        };
    L4:
        b0 r5 = this.f10811b;
        if (r5.f == true) goto L25;
        r5.f = true;
        Choreographer.getInstance().postFrameCallback(new c7.e(this, 1));
        return;
    L25:
        return;
    L8:
        b0 r10 = this.f10811b;
        boolean r11 = r10.f;
        String r12 = r10.f10213u;
        if (r11 == true) goto L12;
        LynxLog.b(4, r12, "Lynx observerHandler failed since rootView not draw");
        return;
    L12:
        if (r10.f10208o == false) goto L14;
        LynxLog.b(3, r12, "Lynx observerHandler failed since inner function is delayed");
        return;
    L14:
        com.lynx.tasm.utils.j.f(new x(r10, 0));
        return;
    L16:
        b0 r13 = this.f10811b;
        TraceEvent.c("ObserverManager.ObserverHandler");
        r13.f();     // Catch: Throwable -> L19
    L21:
        TraceEvent.a(0, "ObserverManager.ObserverHandler");
        return;
    L19:
        th = move-exception;
        LynxLog.b(4, r13.f10213u, "observerManager.intersectionObserverHandler failed: " + th.toString());
        goto L21
    }
}
