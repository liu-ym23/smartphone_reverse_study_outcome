package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w0<T> implements Consumer {
    public final /* synthetic */ r0.e a;

    public w0(r0.e r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        r0 r0 = this.a.a;
        int r1 = r0.g;
        r0.getClass();
        String r2 = null;
        if ((r5 instanceof ApiServerException) == true) goto L5;
        r5 = null;
    L5:
        ApiServerException r6 = (ApiServerException) r5;
        if (r6 == null) goto L15;
        String r7 = r6.getPrompt();
        if (r7 == null) goto L15;
        if (r7.length() <= 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        r2 = r7;
        goto L15
    L12:
        r3 = false;
    L15:
        if (r2 == null) goto L17;
        ToastUtil.b(r2, 0);
        return;
    L17:
        ToastUtil.a(2131922341, 0);
    }
}
