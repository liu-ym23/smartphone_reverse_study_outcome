package com.bytedance.android.ec.core.gecko;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a<T> implements SingleOnSubscribe {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final void subscribe(SingleEmitter<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        com.bytedance.geckox.b r11 = com.bytedance.geckox.b.a.a;
        com.bytedance.geckox.b.e(new ECGeckoRegister());
    }
}
