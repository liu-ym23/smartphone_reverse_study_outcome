package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b0<T, R> implements Function {
    public static final b0 a = null;

    static {
        a = new b0();
    }

    public b0() {
    }

    public final Object apply(Object r4) {
        ExtraResponse r5 = (ExtraResponse) r4;
        Intrinsics.checkNotNullParameter(r5, "rawResp");
        e r0 = (e) GsonProtectorUtils.fromJson(GsonHelper.get(), (JsonElement) r5.data, e.class);
        return new v.a((JsonObject) r5.data, r0);
    }
}
