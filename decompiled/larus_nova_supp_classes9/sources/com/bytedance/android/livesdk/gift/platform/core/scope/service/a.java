package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.Single;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements oc6.h, com.bytedance.android.scope.o {
    public final AssetsService a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public a(AssetsService r2) {
        Intrinsics.checkNotNullParameter(r2, "assetService");
        this.a = r2;
    }

    public final Single<lc6.p> requireAssets(List<Long> r3) {
        Intrinsics.checkNotNullParameter(r3, "assetIds");
        AssetsService r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "assetIds");
        return Single.create(new h(r1, r3));
    }
}
