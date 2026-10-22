package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.model.d3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshMostlyUsedTabPinTopStatus;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;

    public a0(int r1, int r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r11) {
        ExtraResponse r13 = (ExtraResponse) r11;
        uz1.a r0 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r0 == null) goto L5;
        r0.a(new RefreshMostlyUsedTabPinTopStatus((int) ((d3) r13.data).getSortStrategy(), this.a));
    L5:
        com.bytedance.android.livesdk.gift.platform.core.b0.a.e(this.b, this.c, Long.valueOf(((d3) r13.data).getSortStrategy()), null);
    }
}
