package com.bytedance.android.live.core.performance;

import android.view.Choreographer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class FpsSampler extends BaseSampler<Double> implements Choreographer.FrameCallback {
    public long d;

    @Override // java.lang.Runnable
    public final void run() {
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r6) {
        if (this.d != (-1)) goto L6;
        this.d = r6;
    L6:
        throw null;
    }
}
