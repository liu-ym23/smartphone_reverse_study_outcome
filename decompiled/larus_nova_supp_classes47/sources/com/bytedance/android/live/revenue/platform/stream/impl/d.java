package com.bytedance.android.live.revenue.platform.stream.impl;

import android.graphics.Bitmap;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ Bitmap a;

    public d(Bitmap r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        Integer r5 = (Integer) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        if (r5.intValue() != 0) goto L6;
        return Single.just(this.a);
    L6:
        return Single.error(new IllegalStateException("PixelCopy failed with result " + r5));
    }
}
