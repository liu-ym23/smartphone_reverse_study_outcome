package com.bytedance.android.live.profile.servicewidget;

import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r3) {
        ApiServerException r4 = (Throwable) r3;
        if ((r4 instanceof ApiServerException) == false) goto L7;
        ApiServerException r5 = r4;
        if (TextUtils.isEmpty(r5.getPrompt()) == true) goto L7;
        f2.c(r5.getPrompt(), 0);
        return;
    L7:
        f2.c("服务异常，请稍后重试", 0);
    }
}
