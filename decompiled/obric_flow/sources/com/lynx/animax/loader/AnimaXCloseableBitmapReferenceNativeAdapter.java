package com.lynx.animax.loader;

import android.graphics.Bitmap;
import androidx.annotation.RestrictTo;
import com.lynx.animax.base.CalledByNative;
import em.d;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AnimaXCloseableBitmapReferenceNativeAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f9621a;

    public AnimaXCloseableBitmapReferenceNativeAdapter(d r5) {
        this.f9621a = r5;
    }

    @CalledByNative
    public void close() {
        this.f9621a.f16838a.recycle();
    }

    @CalledByNative
    public Bitmap get() {
        d r5 = this.f9621a;
        if (r5.f16838a.isRecycled() == false) goto L5;
        return null;
    L5:
        return r5.f16838a;
    }

    @CalledByNative
    public boolean isValid() {
        return !this.f9621a.f16838a.isRecycled();
    }
}
