package com.bytedance.android.ec.core.monitor;

import android.view.Choreographer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements Choreographer.FrameCallback {
    public final /* synthetic */ Function0 a;

    public b(Function0 r1) {
        this.a = r1;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r1) {
        this.a.invoke();
    }
}
