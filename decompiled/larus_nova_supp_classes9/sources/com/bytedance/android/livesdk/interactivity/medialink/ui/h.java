package com.bytedance.android.livesdk.interactivity.medialink.ui;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T, R> implements Function {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final Object apply(Object r2) {
        BaseResponse r3 = (BaseResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "response");
        return (IBaseUser) r3.data;
    }
}
