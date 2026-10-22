package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l<T, R> implements Function {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    public final Object apply(Object r2) {
        Response r3 = (Response) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return (Room) ((BaseResponse) r3).data;
    }
}
