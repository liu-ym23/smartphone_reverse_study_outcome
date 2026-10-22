package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.message.model.q7;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m1 extends ca0.w {
    public final /* synthetic */ GiftMessageService a;
    public final /* synthetic */ q7 b;

    public final void a() {
    }

    public final void b(List<? extends com.bytedance.android.livesdk.gift.model.w1> r3) {
        Intrinsics.checkNotNullParameter(r3, "giftPages");
        GiftMessageService r4 = this.a;
        com.bytedance.android.livesdk.gift.model.a2 r0 = this.b.getSceneInsertStrategy();
        int r1 = GiftMessageService.M;
        r4.c(r0);
    }

    public m1(GiftMessageService r1, q7 r2) {
        this.a = r1;
        this.b = r2;
    }
}
