package com.lynx.animax.loader;

import androidx.annotation.RestrictTo;
import com.lynx.animax.base.CalledByNative;
import java.util.concurrent.atomic.AtomicBoolean;
import q7.a;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AnimaXLoaderCompletionHandler implements IAnimaXLoaderCompletionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f9624b;

    public AnimaXLoaderCompletionHandler(long r5) {
        this.f9624b = new AtomicBoolean(false);
        this.f9623a = r5;
    }

    @CalledByNative
    public static AnimaXLoaderCompletionHandler createCompletionHandler(long r5) {
        return new AnimaXLoaderCompletionHandler(r5);
    }

    public final void a(a r5) {
        if (this.f9624b.getAndSet(true) == true) goto L6;
        AnimaXLoaderResponseNativeAdapter r10 = new AnimaXLoaderResponseNativeAdapter(r5);
        nativeOnComplete(this.f9623a, r10);
        return;
    }

    public native void nativeOnComplete(long r5, AnimaXLoaderResponseNativeAdapter r10);
}
