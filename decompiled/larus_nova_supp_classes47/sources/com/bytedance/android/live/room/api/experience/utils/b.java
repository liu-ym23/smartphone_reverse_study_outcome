package com.bytedance.android.live.room.api.experience.utils;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.strategy.api.IStrategyService;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements ObservableOnSubscribe {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void subscribe(ObservableEmitter<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        IStrategyService r0 = k.f(IStrategyService.class);
        if (r0 == null) goto L8;
        LiveData r1 = r0.getFactor("live_push_consume_advice", Boolean.FALSE, true, true);
        if (r1 == null) goto L8;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L8;
    L9:
        r5.onNext(r2);
        return;
    L8:
        r2 = Boolean.FALSE;
        goto L9
    }
}
