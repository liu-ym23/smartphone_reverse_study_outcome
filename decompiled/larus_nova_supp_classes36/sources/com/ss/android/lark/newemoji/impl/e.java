package com.ss.android.lark.newemoji.impl;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e<T> implements Consumer {
    public static final e<T> a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void accept(Object r3) {
        Log.e("EmojiService2", "PUSH_EMOJIS error", (Throwable) r3);
    }
}
