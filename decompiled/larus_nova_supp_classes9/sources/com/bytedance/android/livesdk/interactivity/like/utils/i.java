package com.bytedance.android.livesdk.interactivity.like.utils;

import android.graphics.Bitmap;
import com.bytedance.android.livesdk.message.model.d4;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T, R> implements Function {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final Object apply(Object r2) {
        Pair r3 = (Pair) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        int r0 = j.a;
        return j.a((Bitmap) r3.getSecond(), ((d4) r3.getFirst()).a());
    }
}
