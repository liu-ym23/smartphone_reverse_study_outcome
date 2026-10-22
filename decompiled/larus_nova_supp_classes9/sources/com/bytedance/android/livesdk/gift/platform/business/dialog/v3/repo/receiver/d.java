package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public final yz0.f b;
    public final x c;

    public final void onStart() {
        yz0.f r0 = this.b;
        com.bytedance.android.live.revenue.common.message.a r1 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r2 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r1, "$this$GROUP_LIVE_GIFT_RECIPIENT_RECOMMEND_MESSAGE");
        Observable r3 = yz0.h.a.a(r0, (yh6.b) CommonMessageTypeKt.X.getValue(), false, 6);
        final GiftGroupLiveRecommendService$receiveRecommendMessage$1 r4 = new GiftGroupLiveRecommendService$receiveRecommendMessage$1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r3.subscribe(new c(r4)), this.a);
    }

    public final void onStop() {
        this.a.clear();
    }

    public d(yz0.f r2, x r3) {
        Intrinsics.checkNotNullParameter(r2, "roomMessageService");
        Intrinsics.checkNotNullParameter(r3, "recommendReceiverService");
        this.b = r2;
        this.c = r3;
        this.a = new CompositeDisposable();
    }
}
