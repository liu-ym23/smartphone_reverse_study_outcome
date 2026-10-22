package com.bytedance.android.live.schema.helper;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements Action {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void run() {
        ALogger.i("LynxCacheHelper", "evict success");
    }
}
