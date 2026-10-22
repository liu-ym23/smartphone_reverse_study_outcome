package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i<T, R> implements Function {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final Object apply(Object r3) {
        BaseResponse r4 = (BaseResponse) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        if (r4.statusCode != 0) goto L6;
        return new com.bytedance.android.live.broadcastgame.j0();
    L6:
        return new com.bytedance.android.live.broadcastgame.j0(1, r4.error.message);
    }
}
