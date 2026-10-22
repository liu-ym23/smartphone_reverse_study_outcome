package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h3<T> implements Consumer {
    public final /* synthetic */ GiftExtraRepo a;
    public final /* synthetic */ long b;

    public h3(GiftExtraRepo r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.r0.a.a(this.a, CollectionsKt.listOf(Long.valueOf(this.b)), "updateExtraIfNeeded", null, 12);
    }
}
