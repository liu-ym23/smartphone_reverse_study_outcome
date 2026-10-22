package com.bytedance.android.livesdk.gift.platform.business.effect.giftview.lynxView;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import yy0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lyy0/c;", BuildConfig.FLAVOR, "invoke", "(Lyy0/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class BaseLynxGiftView$createLynxComponentDelegateWithAnnie$1 extends Lambda implements Function1<c, Unit> {
    final /* synthetic */ b $lynxViewParam;
    final /* synthetic */ BaseLynxGiftView this$0;

    public BaseLynxGiftView$createLynxComponentDelegateWithAnnie$1(BaseLynxGiftView r1, b r2) {
        this.this$0 = r1;
        this.$lynxViewParam = r2;
        super(1);
    }

    public final void invoke(c r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.d(new AnonymousClass1(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((c) r1);
        return Unit.INSTANCE;
    }
}
