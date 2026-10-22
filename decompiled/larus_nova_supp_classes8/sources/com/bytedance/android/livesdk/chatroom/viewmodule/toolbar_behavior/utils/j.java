package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j<T> implements Consumer {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final void accept(Object r2) {
        Response r3 = (Response) r2;
        Logger.e("introduce-card", "成功更新直播间状态: 取消联运");
    }
}
