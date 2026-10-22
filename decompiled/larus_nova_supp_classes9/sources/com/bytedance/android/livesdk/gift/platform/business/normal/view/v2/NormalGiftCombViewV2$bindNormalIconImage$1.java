package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.graphics.Bitmap;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Landroid/graphics/Bitmap;", "invoke"}, k = 3, mv = {1, 4, 3})
final class NormalGiftCombViewV2$bindNormalIconImage$1 extends Lambda implements Function1<Bitmap, Unit> {
    final /* synthetic */ NormalGiftCombViewV2 this$0;

    public NormalGiftCombViewV2$bindNormalIconImage$1(NormalGiftCombViewV2 r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(Bitmap r3) {
        GiftIconMaskView r0 = (GiftIconMaskView) this.this$0.o(2131373725);
        if (r0 == null) goto L6;
        r0.a(r3);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Bitmap) r1);
        return Unit.INSTANCE;
    }
}
