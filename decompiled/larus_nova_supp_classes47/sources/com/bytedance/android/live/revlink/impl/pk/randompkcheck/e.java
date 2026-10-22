package com.bytedance.android.live.revlink.impl.pk.randompkcheck;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        jy0.b.c("random_pk_check_fragment", "on confirm autocheck error", null, 4);
    }
}
