package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere.AtmosphereDataStore;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b4<T> implements Consumer {
    public final /* synthetic */ z3 a;

    public b4(z3 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        dq2.e r5 = (dq2.e) r4;
        if (r5.getScene() != 5) goto L5;
        return;
    L5:
        if (r5.getScene() != 16) goto L7;
        return;
    L7:
        if (r5.getScene() == 0) goto L9;
    L10:
        i12.e r6 = i12.o.b();
        if (r6 == null) goto L13;
        Object r7 = com.bytedance.android.scope.m.e.d(r6, AtmosphereDataStore.class);
    L14:
        AtmosphereDataStore r8 = (AtmosphereDataStore) r7;
        if (r8 == null) goto L21;
        r8.k(0, true);
        return;
    L21:
        return;
    L13:
        r7 = null;
        goto L14
    L9:
        if (this.a.h.getRoom().isLiveTypeAudio() == false) goto L10;
    }
}
