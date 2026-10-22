package com.bytedance.android.livesdk.gift.platform.business.dialog.topview;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
final class NewLynxGiftBannerView$release$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ NewLynxGiftBannerView this$0;

    public NewLynxGiftBannerView$release$1(NewLynxGiftBannerView r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m50invoke() {
        this.this$0.a.removeAllViews();
        zy0.b r0 = this.this$0.h;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m50invoke();
        return Unit.INSTANCE;
    }
}
