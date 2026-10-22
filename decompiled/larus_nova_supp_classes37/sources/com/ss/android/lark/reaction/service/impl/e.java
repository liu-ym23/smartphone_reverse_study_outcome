package com.ss.android.lark.reaction.service.impl;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e<T> implements Consumer {
    public static final e<T> a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void accept(Object r3) {
        Log.e("ReactionOrderService2", "onPushMRUReaction error", (Throwable) r3);
    }
}
