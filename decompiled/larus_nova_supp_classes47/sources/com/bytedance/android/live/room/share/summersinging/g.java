package com.bytedance.android.live.room.share.summersinging;

import android.graphics.Bitmap;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T, R> implements Function {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final Object apply(Object r2) {
        Bitmap r3 = (Bitmap) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return sh6.c.a(r3);
    }
}
