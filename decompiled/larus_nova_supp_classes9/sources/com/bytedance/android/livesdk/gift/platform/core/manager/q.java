package com.bytedance.android.livesdk.gift.platform.core.manager;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q<T> implements SingleOnSubscribe {
    public final /* synthetic */ GiftManagerKt.h a;
    public final /* synthetic */ ExtraResponse b;

    public q(GiftManagerKt.h r1, ExtraResponse r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(SingleEmitter<Object> r13) {
        GiftManagerKt r0 = GiftManagerKt.z;
        ExtraResponse r14 = this.b;
        com.bytedance.android.livesdk.gift.platform.core.model.i r1 = (com.bytedance.android.livesdk.gift.platform.core.model.i) r14.data;
        long r2 = r14.extra.now;
        GiftManagerKt.h r15 = this.a;
        boolean r4 = r15.b;
        ca0.w r5 = (ca0.w) r15.d.get();
        GiftManagerKt.h r16 = this.a;
        GiftManagerKt.a(r0, r1, r2, r4, r5, r16.e, r16.f, this.b.logId, r16.a, r16.g);
    }
}
