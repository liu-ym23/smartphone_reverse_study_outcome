package com.bytedance.android.livesdk.gift.platform.business.dialog.topview;

import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<S> {
    public final Observable<S> a;
    public final Function2<S, e, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public i(Observable<S> r2, Function2<? super S, ? super e, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "emitter");
        this.a = r2;
        this.b = r3;
    }
}
