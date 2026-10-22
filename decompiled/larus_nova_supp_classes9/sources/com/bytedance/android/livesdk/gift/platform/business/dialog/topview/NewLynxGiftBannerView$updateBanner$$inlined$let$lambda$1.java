package com.bytedance.android.livesdk.gift.platform.business.dialog.topview;

import com.bytedance.bdlocation.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lyy0/c;", BuildConfig.FLAVOR, "invoke", "(Lyy0/c;)V", "com/bytedance/android/livesdk/gift/platform/business/dialog/topview/NewLynxGiftBannerView$updateBanner$1$hybridCard$1", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class NewLynxGiftBannerView$updateBanner$$inlined$let$lambda$1 extends Lambda implements Function1<yy0.c, Unit> {
    final /* synthetic */ Map $renderData$inlined;
    final /* synthetic */ NewLynxGiftBannerView this$0;

    public NewLynxGiftBannerView$updateBanner$$inlined$let$lambda$1(NewLynxGiftBannerView r1, Map r2) {
        this.this$0 = r1;
        this.$renderData$inlined = r2;
        super(1);
    }

    public final void invoke(yy0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.d(new AnonymousClass1(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((yy0.c) r1);
        return Unit.INSTANCE;
    }
}
