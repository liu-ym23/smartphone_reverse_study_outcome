package com.bytedance.android.live.service.grouppurchasetip;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.BaseResponse;
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
        BaseResponse r3 = (BaseResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return (IBaseUser) r3.data;
    }
}
