package com.lynx.animax.loader;

import java.util.concurrent.atomic.AtomicBoolean;
import u4a.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXLoaderCompletionHandler implements l {
    public final long a;
    public final AtomicBoolean b;

    public native void nativeOnComplete(long r1, AnimaXLoaderResponseNativeAdapter r3);

    public AnimaXLoaderCompletionHandler(long r3) {
        this.b = new AtomicBoolean(false);
        this.a = r3;
    }

    public static AnimaXLoaderCompletionHandler createCompletionHandler(long r1) {
        return new AnimaXLoaderCompletionHandler(r1);
    }

    public final void a(AnimaXLoaderResponse<?> r4) {
        if (this.b.getAndSet(true) == true) goto L6;
        nativeOnComplete(this.a, new AnimaXLoaderResponseNativeAdapter(r4));
        return;
    }
}
