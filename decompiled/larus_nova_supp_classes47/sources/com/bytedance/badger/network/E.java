package com.bytedance.badger.network;

import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.badger.data.ReportStage;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class E extends Lambda implements Function0 {
    final /* synthetic */ F a;

    public E(F r1) {
        this.a = r1;
        super(0);
    }

    public Object invoke() {
        z0 r0 = d0.a;
        b r1 = this.a.a;
        ReportStage r6 = ReportStage.FINAL;
        boolean r7 = r1.e;
        long r8 = r1.f;
        d0.c(new b(r1.a, r1.b, r1.c, r6, r7, r8, r1.g, r1.h, false, DefaultConfig.MAX_CACHE_ENTRIES));
        return Unit.INSTANCE;
    }
}
