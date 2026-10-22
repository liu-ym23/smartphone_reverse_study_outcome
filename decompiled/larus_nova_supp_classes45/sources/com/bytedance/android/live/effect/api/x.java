package com.bytedance.android.live.effect.api;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.ul;
import com.bytedance.android.livesdk.config.w1;
import com.bytedance.android.livesdkapi.service.IMiddlewareCommodityNoFilterUploadCallBack;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ LiveEffectContext a;
    public final /* synthetic */ IMiddlewareCommodityNoFilterUploadCallBack b;

    public x(LiveEffectContext r1, com.bytedance.android.livesdk.provideservices.d0.k r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        if (Intrinsics.areEqual(((w1) ul.a.getValue()).b(), Boolean.TRUE) == false) goto L5;
        m90.b.D.e(LiveEffectContextFactoryDelegate$Type.DEFAULT, Boolean.FALSE);
        this.a.a().x("ttlive_anchor_effect_LiveEffectContext_updateNoFilterSettingFail");
    L5:
        ALogger.d("COMMODITY_NO_FILTER", "update no filter setting fail, " + r5);
        this.a.e().d(true);
        this.b.onFail();
    }
}
