package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r5) {
        ApiServerException r6 = (Throwable) r5;
        jy0.b.c("ttlive_anchor_link", "clear ext score failed " + r6, null, 4);
        com.bytedance.android.live.revlink.impl.multianchor.profit.a r0 = com.bytedance.android.live.revlink.impl.global.b.Y();
        if (r0 == null) goto L6;
        r0.m(r6);
    L6:
        if ((r6 instanceof ApiServerException) == false) goto L9;
        int r1 = ToastUtil.a;
        ToastUtil.b(r6.getPrompt(), 0);
        return;
    }
}
