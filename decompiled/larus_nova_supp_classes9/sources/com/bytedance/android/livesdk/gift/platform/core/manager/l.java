package com.bytedance.android.livesdk.gift.platform.core.manager;

import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l<T> implements Consumer {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    public final void accept(Object r2) {
        GiftManagerKt r0 = GiftManagerKt.z;
        GiftManagerKt.b(r0, (Map) r2);
    }
}
