package com.lynx.animax.composition;

import am.d;
import androidx.annotation.RestrictTo;
import bm.a;
import com.lynx.animax.base.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
public class AnimaXComposition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9587a;

    public AnimaXComposition(long r5) {
        this.f9587a = r5;
        a r10 = new a(0);
        r10.f960b = r5;
        new d(this, r10);
    }

    public static /* synthetic */ void a(long r5) {
        nativeDestroy(r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @CalledByNative
    public static AnimaXComposition create(long r5) {
        return new AnimaXComposition(r5);
    }

    private static native void nativeDestroy(long r5);

    private native long nativeGetEndFrame(long r5);

    private native long nativeGetStartFrame(long r5);
}
