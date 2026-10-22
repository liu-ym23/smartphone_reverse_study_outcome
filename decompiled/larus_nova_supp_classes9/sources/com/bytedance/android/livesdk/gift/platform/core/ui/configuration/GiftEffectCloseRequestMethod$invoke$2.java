package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import com.bytedance.android.live.browser.jsbridge.base.RevenueRequestStickerEffectStatusResultModel;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"onFail", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
final class GiftEffectCloseRequestMethod$invoke$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ f this$0;

    public GiftEffectCloseRequestMethod$invoke$2(f r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m343invoke() {
        RevenueRequestStickerEffectStatusResultModel r0 = new RevenueRequestStickerEffectStatusResultModel();
        RevenueRequestStickerEffectStatusResultModel.a r1 = new RevenueRequestStickerEffectStatusResultModel.a();
        r1.a(Boolean.FALSE);
        r1.b(BuildConfig.FLAVOR);
        Unit r2 = Unit.INSTANCE;
        r0.b(r1);
        r0.a(RevenueRequestStickerEffectStatusResultModel.Code.Failed);
        this.this$0.finishWithResult(r0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m343invoke();
        return Unit.INSTANCE;
    }
}
