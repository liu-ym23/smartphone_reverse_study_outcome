package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ GiftListCacheRepo a;

    public k(GiftListCacheRepo r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        Intrinsics.checkNotNullParameter(r3, "error");
        Logger.e("GIFT_MANAGER", r3.getMessage());
        this.a.b = false;
    }
}
