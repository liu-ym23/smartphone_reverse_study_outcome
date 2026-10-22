package com.lynx.tasm.behavior.ui;

import android.view.Choreographer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f10768a;

    public v(y r5) {
        this.f10768a = new WeakReference(r5);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r5) {
        y r10 = (y) this.f10768a.get();
        if (r10 == null) goto L6;
        r10.f();
        return;
    }
}
