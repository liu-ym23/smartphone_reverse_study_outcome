package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements SingleOnSubscribe {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void subscribe(SingleEmitter<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        float r0 = vh6.c.b(dr2.c.class).getAppStorageByMB() / vh6.c.b(dr2.c.class).getTotalStorageByMB();
        int r1 = GiftRoomCleanCacheService.i;
        if (r0 <= (com.bytedance.android.livesdk.gift.platform.business.i.d().F1() / 100.0f)) goto L5;
        boolean r2 = true;
    L6:
        r5.onSuccess(Boolean.valueOf(r2));
        return;
    L5:
        r2 = false;
        goto L6
    }
}
