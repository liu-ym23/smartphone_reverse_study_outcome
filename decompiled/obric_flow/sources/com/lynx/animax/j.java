package com.lynx.animax;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f9620b;

    public /* synthetic */ j(int r5, long r10) {
        this.f9619a = r5;
        this.f9620b = r10;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r5) {
        switch(this.f9619a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        com.lynx.tasm.core.VSyncMonitor.a(this.f9620b, r5);
        return;
    L6:
        com.lynx.tasm.core.VSyncMonitor.a(this.f9620b, r5);
        return;
    L8:
        VSyncMonitor.a(this.f9620b, r5);
    }
}
