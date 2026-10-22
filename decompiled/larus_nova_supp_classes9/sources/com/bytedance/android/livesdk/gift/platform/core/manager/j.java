package com.bytedance.android.livesdk.gift.platform.core.manager;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T> implements SingleOnSubscribe {
    public final /* synthetic */ Map a;

    public j(Map r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<Object> r2) {
        GiftManagerKt.b(GiftManagerKt.z, this.a);
    }
}
