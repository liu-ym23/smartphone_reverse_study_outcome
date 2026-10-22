package com.bytedance.android.livesdk.interactivity.like;

import android.graphics.Bitmap;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z0<T> implements Predicate {
    public static final z0 a = null;

    static {
        a = new z0();
    }

    public z0() {
    }

    public final boolean test(Object r2) {
        Bitmap r3 = (Bitmap) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return !r3.isRecycled();
    }
}
