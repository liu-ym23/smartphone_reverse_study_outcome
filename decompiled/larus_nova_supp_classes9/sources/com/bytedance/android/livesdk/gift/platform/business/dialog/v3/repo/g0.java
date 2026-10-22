package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g0 extends com.bytedance.android.livesdk.gift.platform.core.model.c0 {
    public final /* synthetic */ Function0 a;

    public g0(Function0 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.r
    public final void b(com.bytedance.android.livesdk.gift.platform.core.model.t r2, com.bytedance.android.livesdk.gift.platform.core.model.y r3) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r3, "response");
        if ((r3 instanceof com.bytedance.android.livesdk.gift.platform.core.model.y.c.a) == false) goto L6;
        this.a.invoke();
        return;
    }
}
