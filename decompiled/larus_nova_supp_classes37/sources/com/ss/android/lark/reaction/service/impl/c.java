package com.ss.android.lark.reaction.service.impl;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c<T> implements Consumer {
    public static final c<T> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void accept(Object r3) {
        Log.e("ReactionOrderService2", "onPushEmojiPanel error", (Throwable) r3);
    }
}
