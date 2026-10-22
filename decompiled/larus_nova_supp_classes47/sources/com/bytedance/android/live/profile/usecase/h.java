package com.bytedance.android.live.profile.usecase;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ f a;

    public h(f r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        this.a.a = false;
        if ((r4 instanceof ApiServerException) == true) goto L5;
        r4 = null;
    L5:
        ApiServerException r5 = (ApiServerException) r4;
        if (r5 == null) goto L8;
        f2.c(r5.getPrompt(), 0);
        return;
    L8:
        f2.b(2131919116, 0);
    }
}
