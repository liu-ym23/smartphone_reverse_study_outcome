package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final void accept(Object r2) {
        ExtraResponse r3 = (ExtraResponse) r2;
        ToastUtil.a(2131914792, 0);
        jy0.b.d("ttlive_anchor_link", "clear ext score success");
        com.bytedance.android.live.revlink.impl.multianchor.profit.a r4 = com.bytedance.android.live.revlink.impl.global.b.Y();
        if (r4 == null) goto L6;
        int r0 = com.bytedance.android.live.revlink.impl.multianchor.profit.a.e;
        r4.m(null);
        return;
    }
}
