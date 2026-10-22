package com.lynx.animax.loader;

import android.graphics.Bitmap;
import u4a.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXCloseableBitmapReferenceNativeAdapter {
    public final j a;

    public void close() {
        this.a.close();
    }

    public Bitmap get() {
        return this.a.get();
    }

    public boolean isValid() {
        return this.a.isValid();
    }

    public AnimaXCloseableBitmapReferenceNativeAdapter(j r1) {
        this.a = r1;
    }
}
