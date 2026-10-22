package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public Disposable a;
    public final Function0<Unit> b;

    public d(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b = r2;
    }
}
