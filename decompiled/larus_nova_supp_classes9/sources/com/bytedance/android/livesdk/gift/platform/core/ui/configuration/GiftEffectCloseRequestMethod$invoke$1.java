package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import com.bytedance.android.live.browser.jsbridge.base.RevenueRequestStickerEffectStatusResultModel;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"onSuccess", BuildConfig.FLAVOR, "resultString", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
final class GiftEffectCloseRequestMethod$invoke$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ f this$0;

    public GiftEffectCloseRequestMethod$invoke$1(f r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(String r4) {
        RevenueRequestStickerEffectStatusResultModel r0 = new RevenueRequestStickerEffectStatusResultModel();
        RevenueRequestStickerEffectStatusResultModel.a r1 = new RevenueRequestStickerEffectStatusResultModel.a();
        r1.a(Boolean.valueOf(com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r4)));
        r1.b(r4);
        Unit r5 = Unit.INSTANCE;
        r0.b(r1);
        r0.a(RevenueRequestStickerEffectStatusResultModel.Code.Success);
        this.this$0.finishWithResult(r0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
