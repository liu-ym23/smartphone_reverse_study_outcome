package com.bytedance.android.live.room.share.summersinging;

import android.graphics.Bitmap;
import io.reactivex.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T1, T2, T3, R> implements Function3 {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final Object apply(Object r2, Object r3, Object r4) {
        sh6.b r5 = (sh6.b) r2;
        sh6.b r6 = (sh6.b) r3;
        sh6.b r7 = (sh6.b) r4;
        Intrinsics.checkNotNullParameter(r5, "t1");
        Intrinsics.checkNotNullParameter(r6, "t2");
        Intrinsics.checkNotNullParameter(r7, "t3");
        return new p((Bitmap) sh6.c.b(r5), (Bitmap) sh6.c.b(r6), (Bitmap) sh6.c.b(r7));
    }
}
