package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j1<T> implements Consumer {
    public static final j1 a = null;

    static {
        a = new j1();
    }

    public j1() {
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        ALogger.e("SecretChatListProvider", "get history chat list error");
    }
}
