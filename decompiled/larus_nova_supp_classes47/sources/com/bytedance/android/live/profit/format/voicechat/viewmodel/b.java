package com.bytedance.android.live.profit.format.voicechat.viewmodel;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T, R> implements Function {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object apply(Object r2) {
        ExtraResponse r3 = (ExtraResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return (com.bytedance.android.live.profit.format.voicechat.model.a) r3.data;
    }
}
