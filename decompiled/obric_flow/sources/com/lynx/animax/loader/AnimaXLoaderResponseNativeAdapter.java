package com.lynx.animax.loader;

import androidx.annotation.RestrictTo;
import com.lynx.animax.base.CalledByNative;
import em.d;
import q7.a;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AnimaXLoaderResponseNativeAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f9631a;

    public AnimaXLoaderResponseNativeAdapter(a r5) {
        this.f9631a = r5;
    }

    @CalledByNative
    public AnimaXCloseableBitmapReferenceNativeAdapter getBitmap() {
        return new AnimaXCloseableBitmapReferenceNativeAdapter((d) this.f9631a.f21489c);
    }

    @CalledByNative
    public byte[] getData() {
        return (byte[]) this.f9631a.f21489c;
    }

    @CalledByNative
    public String getErrorMessage() {
        a r5 = this.f9631a;
        if (((AnimaXLoaderResponse$Type) r5.f21488b) != AnimaXLoaderResponse$Type.f9630c) goto L8;
        Throwable r10 = (Throwable) r5.f21489c;
        if (r10 != null) goto L7;
        return "";
    L7:
        return r10.getMessage();
    L8:
        return "";
    }

    @CalledByNative
    public String getFilePath() {
        return (String) this.f9631a.f21489c;
    }

    @CalledByNative
    public int getType() {
        return ((AnimaXLoaderResponse$Type) this.f9631a.f21488b).ordinal();
    }
}
