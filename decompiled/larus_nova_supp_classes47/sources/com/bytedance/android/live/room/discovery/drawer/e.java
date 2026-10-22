package com.bytedance.android.live.room.discovery.drawer;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        ALogger.e("ttlive_widget", "接口请求失败");
    }
}
