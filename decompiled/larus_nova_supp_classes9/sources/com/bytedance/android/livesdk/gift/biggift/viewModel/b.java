package com.bytedance.android.livesdk.gift.biggift.viewModel;

import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.platform.core.model.c0;
import com.bytedance.android.livesdk.gift.platform.core.model.t;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends c0 {
    public final /* synthetic */ BigGiftViewModel a;

    public b(BigGiftViewModel r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.r
    public final void b(t r2, y r3) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r3, "response");
        if ((r3 instanceof y.c.a) == false) goto L6;
        this.a.c();
    L6:
        if ((r3 instanceof y.c.a.C0068c) == false) goto L9;
        ToastUtil.a(2131917092, 0);
        return;
    }
}
