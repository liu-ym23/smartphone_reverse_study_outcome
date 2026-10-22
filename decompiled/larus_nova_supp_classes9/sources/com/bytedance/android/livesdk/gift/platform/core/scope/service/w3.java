package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w3 implements com.bytedance.android.livesdk.revenue.service.effect.e {
    public final /* synthetic */ z3 a;
    public final /* synthetic */ com.bytedance.android.livesdk.revenue.service.effect.f b;

    public final void onFail() {
    }

    public final void onStart() {
    }

    public final void a(com.bytedance.android.livesdk.revenue.service.effect.i r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
        Single r3 = this.a.g.Y7(r2);
        if (r3 == null) goto L10;
        Single r4 = r3.observeOn(AndroidSchedulers.mainThread());
        if (r4 == null) goto L11;
        Disposable r5 = r4.subscribe(new v3(this));
        if (r5 == null) goto L12;
        RxUtilKt.c(r5, this.a.a);
        return;
    L12:
        return;
    L11:
        return;
    }

    public w3(z3 r1, com.bytedance.android.livesdk.revenue.service.effect.f r2) {
        this.a = r1;
        this.b = r2;
    }
}
