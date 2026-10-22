package com.bytedance.android.live.profile.seeselftransition;

import android.graphics.BitmapFactory;
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
        sh6.b r3 = (sh6.b) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return sh6.c.a(BitmapFactory.decodeFile((String) sh6.c.b(r3)));
    }
}
