package com.bytedance.android.livesdk.gift.platform.core.manager;

import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m<T> implements Consumer {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        Intrinsics.checkNotNullParameter(r3, "error");
        Logger.e("GIFT_MANAGER", r3.getMessage());
        GiftManagerKt.e = false;
    }
}
