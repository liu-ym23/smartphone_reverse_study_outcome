package com.bytedance.android.livesdk.interactivity.like;

import android.graphics.Bitmap;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o<T, R> implements Function {
    public static final o a = null;

    static {
        a = new o();
    }

    public o() {
    }

    public final Object apply(Object r2) {
        Bitmap r3 = (Bitmap) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return DiggWidget.a.a(r3, DiggWidget.M1);
    }
}
