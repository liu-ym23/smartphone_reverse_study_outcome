package com.bytedance.android.livesdk.interactivity.like.utils;

import android.graphics.Bitmap;
import com.bytedance.android.livesdk.message.model.d4;
import io.reactivex.functions.BiFunction;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T1, T2, R> implements BiFunction {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final Object apply(Object r2, Object r3) {
        d4 r4 = (d4) r2;
        Bitmap r5 = (Bitmap) r3;
        Intrinsics.checkNotNullParameter(r4, "detail");
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        return new Pair(r4, r5);
    }
}
