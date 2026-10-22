package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q3<T> implements SingleOnSubscribe {
    public final /* synthetic */ Function0 a;

    public q3(Function0 r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        this.a.invoke();
    }
}
