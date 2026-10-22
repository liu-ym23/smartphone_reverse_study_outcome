package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z<T> implements Consumer {
    public static final z a = null;

    static {
        a = new z();
    }

    public z() {
    }

    public final void accept(Object r2) {
        BaseResponse r3 = (BaseResponse) r2;
        int r4 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.g("开播后恢复app/stop请求成功", "XplayGlobalService");
    }
}
