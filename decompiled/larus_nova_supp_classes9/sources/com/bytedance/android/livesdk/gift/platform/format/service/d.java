package com.bytedance.android.livesdk.gift.platform.format.service;

import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements SingleOnSubscribe {
    public final /* synthetic */ FormatGiftListService a;

    public d(FormatGiftListService r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<com.bytedance.android.livesdk.gift.platform.core.model.i> r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        this.a.getClass();
        String r0 = (String) new com.bytedance.android.livesdk.sharedpref.e("format_gift_list_response", BuildConfig.FLAVOR).getValue();
        com.bytedance.android.livesdk.gift.platform.core.model.i r1 = (com.bytedance.android.livesdk.gift.platform.core.model.i) this.a.d.fromJson(r0, com.bytedance.android.livesdk.gift.platform.core.model.i.class);     // Catch: Exception -> L5
    L7:
        if (r1 == null) goto L12;
        r4.onSuccess(r1);
        return;
    L12:
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        r1 = null;
        goto L7
    }
}
