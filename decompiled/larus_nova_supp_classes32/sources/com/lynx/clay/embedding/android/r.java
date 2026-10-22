package com.lynx.clay.embedding.android;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ SurfaceSnapshotController b;

    @Override // java.lang.Runnable
    public final void run() {
        SurfaceSnapshotController r0 = this.b;     // Catch: Throwable -> L18
        if (r0.l != this) goto L21;
        r0.l = null;     // Catch: Throwable -> L18
        if (r0.j == this.a) goto L8;
        return;
    L8:
        if (r0.e == SurfaceSnapshotController.OverlayState.FOREGROUND_VISIBLE) goto L10;
        return;
    L10:
        if (r0.f(2) == false) goto L12;
        return;
    L12:
        if (this.b.f(1) == true) goto L14;
        return;
    L14:
        if (this.b.f(4) == false) goto L29;
        this.b.u(0);     // Catch: Throwable -> L18
        return;
    L29:
        return;
    L21:
        return;
    L18:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L30;
        throw th;
    }

    public r(SurfaceSnapshotController r1, int r2) {
        this.b = r1;
        this.a = r2;
    }
}
