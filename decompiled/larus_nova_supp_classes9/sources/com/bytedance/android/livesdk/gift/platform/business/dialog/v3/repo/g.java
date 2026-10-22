package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ GiftListCacheRepo a;

    public g(GiftListCacheRepo r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        GiftListCacheRepo r0 = this.a;
        GiftListCacheRepo.a(r0, (Map) r2);
    }
}
