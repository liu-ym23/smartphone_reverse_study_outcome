package com.lynx.clay.embedding.engine.loader;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ImageLoaderCallback {
    private long mPtr;

    private native void nativeDestroyCallback(long r1);

    private native void nativeOnFailed(long r1, String r3);

    private native void nativeOnSucceeded(long r1, CloseableReference<CloseableImage> r3);

    public void destroy() {
        long r0 = this.mPtr;
        if (r0 == 0) goto L6;
        nativeDestroyCallback(r0);
        this.mPtr = 0;
        return;
    }

    public void finalize() throws Throwable {
        destroy();
        super.finalize();
    }

    public ImageLoaderCallback(long r1) {
        this.mPtr = r1;
    }

    public void onFailed(String r3) {
        nativeOnFailed(this.mPtr, r3);
    }

    public void onSucceeded(CloseableReference<CloseableImage> r3) {
        nativeOnSucceeded(this.mPtr, r3);
    }
}
