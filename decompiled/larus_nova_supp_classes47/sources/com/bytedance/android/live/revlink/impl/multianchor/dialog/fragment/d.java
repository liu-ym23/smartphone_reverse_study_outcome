package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ boolean a;

    public d(boolean r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        ApiServerException r6 = (Throwable) r5;
        jy0.b.c("ttlive_anchor_link", "updateSetting showScore=" + this.a + " failed " + r6, null, 4);
        com.bytedance.android.live.revlink.impl.multianchor.profit.a r0 = com.bytedance.android.live.revlink.impl.global.b.Y();
        if (r0 == null) goto L6;
        r0.n(this.a, r6);
    L6:
        if ((r6 instanceof ApiServerException) == false) goto L9;
        int r1 = ToastUtil.a;
        ToastUtil.b(r6.getPrompt(), 0);
        return;
    }
}
