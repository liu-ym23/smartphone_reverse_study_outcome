package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.business.sendGift.GiftTransaction;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t3 extends com.bytedance.android.livesdk.gift.platform.core.model.c0 {
    public final /* synthetic */ r3 a;
    public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.core.model.t b;

    public t3(r3 r1, GiftTransaction r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.r
    public final void b(com.bytedance.android.livesdk.gift.platform.core.model.t r2, com.bytedance.android.livesdk.gift.platform.core.model.y r3) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r3, "response");
        List<com.bytedance.android.livesdk.gift.platform.core.model.t> r4 = this.a.b;
        ArrayList r5 = (ArrayList) r4;
        r5.remove(this.b);
        if (((ArrayList) this.a.b).isEmpty() == false) goto L8;
        r3.a r6 = this.a.e;
        if (r6 == null) goto L9;
        r6.a();
        return;
    L9:
        return;
    }
}
