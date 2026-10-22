package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public u(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        BaseResponse r3 = (BaseResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "response");
        this.a.invoke((IUser) r3.data);
    }
}
