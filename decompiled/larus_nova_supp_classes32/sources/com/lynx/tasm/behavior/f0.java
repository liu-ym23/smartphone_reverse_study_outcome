package com.lynx.tasm.behavior;

import android.view.Choreographer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f0 implements Runnable {
    public final /* synthetic */ e0 a;

    public class a implements Choreographer.FrameCallback {
        public final /* synthetic */ f0 a;

        public a(f0 r1) {
            this.a = r1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r1) {
            LLog.i(this.a.a.u, "onRootViewDraw ObserverHandler");
            this.a.a.h();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        e0 r0 = this.a;     // Catch: Throwable -> L6
        if (r0.f == true) goto L9;
        r0.f = true;     // Catch: Throwable -> L6
        Choreographer.getInstance().postFrameCallback(new a(this));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public f0(e0 r1) {
        this.a = r1;
    }
}
