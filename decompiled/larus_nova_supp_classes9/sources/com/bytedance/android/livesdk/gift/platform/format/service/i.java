package com.bytedance.android.livesdk.gift.platform.format.service;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements SingleOnSubscribe {
    public final /* synthetic */ FormatGiftListService a;
    public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.core.model.i b;

    public i(FormatGiftListService r1, com.bytedance.android.livesdk.gift.platform.core.model.i r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(SingleEmitter<Object> r4) {
        com.bytedance.android.livesdk.gift.platform.core.model.i r5 = this.b;
        if (r5 == null) goto L6;
        this.a.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("format_gift_list_response", BuildConfig.FLAVOR), GsonProtectorUtils.toJson(this.a.d, r5));
        return;
    }
}
