package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.business.sendGift.GiftTransaction;
import com.bytedance.android.livesdk.gift.platform.core.model.c0;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r extends c0 {
    public final /* synthetic */ SendGiftMethod a;
    public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.core.model.t b;
    public final /* synthetic */ SendGiftMethod.a c;
    public final /* synthetic */ CompositeDisposable d;

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.r
    public final void b(com.bytedance.android.livesdk.gift.platform.core.model.t r3, com.bytedance.android.livesdk.gift.platform.core.model.y r4) {
        Intrinsics.checkNotNullParameter(r3, "info");
        Intrinsics.checkNotNullParameter(r4, "response");
        List<com.bytedance.android.livesdk.gift.platform.core.model.x> r5 = this.b.c();
        if ((!r5.isEmpty()) == true) goto L6;
        r5 = null;
    L6:
        p2 r0 = this.b.f();
        if (r0 == null) goto L9;
        ALogger.i("GiftTransaction", "onTransactionFinish: finalResponse != null");
        this.a.m(this.c, r0, r5);
    L13:
        this.d.clear();
        return;
    L9:
        if ((r4 instanceof com.bytedance.android.livesdk.gift.platform.core.model.y.c.a.C0067a) == false) goto L11;
        ALogger.i("GiftTransaction", "onTransactionFinish: ApiFailed");
        this.a.k(((com.bytedance.android.livesdk.gift.platform.core.model.y.c.a.C0067a) r4).d, r5);
        goto L13
    L11:
        ALogger.i("GiftTransaction", "onTransactionFinish: error_code = -8");
        this.a.k(new ApiException(-8), r5);
        goto L13
    }

    public r(SendGiftMethod r1, GiftTransaction r2, SendGiftMethod.a r3, CompositeDisposable r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
