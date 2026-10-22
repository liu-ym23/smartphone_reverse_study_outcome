package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z<T, R> implements Function {
    public static final z a = null;

    static {
        a = new z();
    }

    public z() {
    }

    public final Object apply(Object r2) {
        Response r3 = (Response) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        Room r4 = (Room) ((BaseResponse) r3).data;
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.roomChannel;
    }
}
