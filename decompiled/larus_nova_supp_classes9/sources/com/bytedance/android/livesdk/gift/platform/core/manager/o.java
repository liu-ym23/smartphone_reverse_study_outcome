package com.bytedance.android.livesdk.gift.platform.core.manager;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o<T> implements SingleOnSubscribe {
    public final /* synthetic */ ca0.w a;

    public o(ca0.w r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<Object> r2) {
        this.a.b(new ArrayList());
    }
}
