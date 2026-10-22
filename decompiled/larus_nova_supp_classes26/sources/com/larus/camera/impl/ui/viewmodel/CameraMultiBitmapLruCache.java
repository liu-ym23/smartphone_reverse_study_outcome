package com.larus.camera.impl.ui.viewmodel;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CameraMultiBitmapLruCache {
    public final CameraMultiBitmapLruCache$cache$1 a;

    public CameraMultiBitmapLruCache() {
        this(10);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.camera.impl.ui.viewmodel.CameraMultiBitmapLruCache$cache$1] */
    public CameraMultiBitmapLruCache(final int r2) {
        this.a = new CameraMultiBitmapLruCache$cache$1(r2);
    }

    public final Bitmap a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return (Bitmap) get(r2);
    }

    public final Bitmap b(String r2, Bitmap r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "bitmap");
        return (Bitmap) put(r2, r3);
    }
}
