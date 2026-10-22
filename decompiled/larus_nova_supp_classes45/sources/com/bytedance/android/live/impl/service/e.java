package com.bytedance.android.live.impl.service;

import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.common.utility.concurrent.TTExecutors;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Consumer {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void accept(Object r3) {
        TTExecutors.getNormalExecutor().submit(new d((UserEvent) r3));
    }
}
