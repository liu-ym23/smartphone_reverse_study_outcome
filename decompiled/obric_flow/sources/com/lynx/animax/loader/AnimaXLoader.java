package com.lynx.animax.loader;

import androidx.annotation.RestrictTo;
import com.lynx.animax.base.CalledByNative;
import em.b;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AnimaXLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f9622a;

    public AnimaXLoader(b r5) {
        this.f9622a = r5;
    }

    @CalledByNative
    public static AnimaXLoader create(b r5) {
        return new AnimaXLoader(r5);
    }

    @CalledByNative
    public void load(AnimaXLoaderRequest r5, AnimaXLoaderCompletionHandler r10) {
        this.f9622a.a(r5, r10);
    }
}
