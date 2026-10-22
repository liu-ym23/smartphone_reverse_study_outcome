package com.bytedance.android.live.profit.lottery;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z0<T> implements Consumer {
    public final /* synthetic */ LotteryIconModel a;

    public z0(LotteryIconModel r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        sh6.d r5 = (sh6.b) r4;
        if ((r5 instanceof sh6.d) == false) goto L21;
        h1 r6 = (h1) r5.a;
        String r0 = r6.d;
        if (r0 == null) goto L7;
        this.a.f(r0);
    L7:
        String r7 = r6.g;
        if (r7 == null) goto L22;
        this.a.getClass();
        int r1 = ToastUtil.a;
        Context r2 = com.bytedance.android.live.core.utils.s1.getContext();
        if (r2 != null) goto L12;
        return;
    L12:
        if (r7.length() != 0) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == true) goto L25;
        Toast r8 = Toast.makeText(r2, r7, 0);
        if (r8 == null) goto L24;
        r8.show();
        return;
    L24:
        return;
    L25:
        return;
    L14:
        r3 = false;
        goto L15
    L22:
        return;
    }
}
