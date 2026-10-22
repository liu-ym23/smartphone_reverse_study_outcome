package com.bytedance.android.live.recharge.nopassword;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ k a;

    public i(k r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        ExtraResponse r6 = (ExtraResponse) r5;
        this.a.a.d.getClass();
        com.bytedance.live.kmp.util.c r7 = com.bytedance.live.kmp.util.c.a;
        long r0 = System.currentTimeMillis();
        com.bytedance.android.live.recharge.utils.i.b.setValue(null, com.bytedance.android.live.recharge.utils.i.a[0], Long.valueOf(r0));
    }
}
