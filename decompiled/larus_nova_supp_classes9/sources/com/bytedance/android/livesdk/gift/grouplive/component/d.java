package com.bytedance.android.livesdk.gift.grouplive.component;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r3) {
        jy0.b.a("GroupComponentView", "request success: " + ((ExtraResponse) r3).data);
    }
}
