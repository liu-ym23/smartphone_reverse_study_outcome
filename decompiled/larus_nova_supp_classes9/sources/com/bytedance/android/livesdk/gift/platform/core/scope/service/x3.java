package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere.AtmosphereDataStore;
import com.bytedance.android.livesdk.message.model.l6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x3 implements com.bytedance.android.livesdk.revenue.service.effect.f {
    public final /* synthetic */ z3 a;
    public final /* synthetic */ l6 b;

    public final void onError() {
    }

    public final void a(yp2.c r5) {
        Intrinsics.checkNotNullParameter(r5, "sticker");
        z3.a(this.a, r5.getId(), r5.b());
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, AtmosphereDataStore.class);
    L6:
        AtmosphereDataStore r2 = (AtmosphereDataStore) r1;
        if (r2 == null) goto L10;
        r2.q(this.b, r5.b());
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public x3(z3 r1, l6 r2) {
        this.a = r1;
        this.b = r2;
    }
}
