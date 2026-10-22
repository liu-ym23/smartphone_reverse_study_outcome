package com.bytedance.android.live.profit.vote.transfer;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T, R> implements Function {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final Object apply(Object r3) {
        ExtraResponse r4 = (ExtraResponse) r3;
        Intrinsics.checkNotNullParameter(r4, "res");
        return Long.valueOf(((a) r4.data).getMVoteType());
    }
}
