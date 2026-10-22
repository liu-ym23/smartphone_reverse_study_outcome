package com.bytedance.android.livesdk.gift.platform.business.giftwall;

import com.google.gson.JsonObject;
import io.reactivex.functions.BiFunction;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T1, T2, R> implements BiFunction {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Object apply(Object r2, Object r3) {
        JsonObject r4 = (JsonObject) r2;
        JsonObject r5 = (JsonObject) r3;
        Intrinsics.checkNotNullParameter(r4, "home");
        Intrinsics.checkNotNullParameter(r5, "rare");
        return TuplesKt.to(r4, r5);
    }
}
