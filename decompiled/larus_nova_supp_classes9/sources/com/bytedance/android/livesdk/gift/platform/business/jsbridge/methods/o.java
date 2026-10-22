package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.livesdk.gift.model.GiftExtraWrapper;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ q a;
    public final /* synthetic */ boolean b;

    public o(q r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Pair r8 = (Pair) r7;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.a() == true) goto L11;
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L7;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, GiftExtraRepo.class);
    L8:
        GiftExtraRepo r2 = (GiftExtraRepo) r1;
        if (r2 == null) goto L11;
        r2.b0(((g0) r8.getFirst()).getGiftId(), new GiftExtraWrapper((g0) r8.getFirst(), null, (JsonObject) r8.getSecond()), this.b);
        goto L11
    L7:
        r1 = null;
    L11:
        this.a.finishWithSuccess();
    }
}
