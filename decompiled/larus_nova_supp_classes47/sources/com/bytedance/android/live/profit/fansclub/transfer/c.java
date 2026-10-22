package com.bytedance.android.live.profit.fansclub.transfer;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profit.fansclub.backend.IGetFansclubHomepageResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T, R> implements Function {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final Object apply(Object r2) {
        ExtraResponse r3 = (ExtraResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return (IGetFansclubHomepageResult) r3.data;
    }
}
