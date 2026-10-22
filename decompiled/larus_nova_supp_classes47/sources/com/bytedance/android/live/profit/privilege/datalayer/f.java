package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.profit.privilege.model.touch.GiftPanelTouchData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ long b;

    public f(d r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        com.bytedance.android.live.profit.privilege.model.touch.g r9 = (com.bytedance.android.live.profit.privilege.model.touch.g) r8;
        com.bytedance.live.kmp.util.c r0 = com.bytedance.live.kmp.util.c.a;
        long r1 = System.currentTimeMillis() - this.b;
        com.bytedance.android.live.profit.privilege.e r2 = com.bytedance.android.live.profit.privilege.e.a;
        String r3 = this.a.f();
        long r4 = this.a.d();
        Intrinsics.checkNotNullParameter(r3, "userId");
        String r6 = null;
        com.bytedance.android.live.profit.privilege.e.p("ttlive_gift_panel_touch_status_all", com.bytedance.android.live.profit.privilege.e.k(true, null, null), com.bytedance.android.live.profit.privilege.e.n(Long.valueOf(r1)), com.bytedance.android.live.profit.privilege.e.m(r2, Long.valueOf(r4), 4));
        com.bytedance.android.live.revenue.common.reactive.c r5 = this.a.h;
        Intrinsics.checkNotNullParameter(r9, "$this$toGiftPanelTouchData");
        com.bytedance.android.live.profit.privilege.model.touch.l r7 = r9.getRechargeButtonTouch();
        if (r7 == null) goto L5;
        a5 r10 = r7.getButtonText();
    L6:
        com.bytedance.android.live.profit.privilege.model.touch.l r12 = r9.getRechargeButtonTouch();
        if (r12 == null) goto L9;
        r6 = r12.getSchema();
    L9:
        r5.setValue(new GiftPanelTouchData(new GiftPanelTouchData.a(r10, r6, r9.getExtra())));
        return;
    L5:
        r10 = null;
        goto L6
    }
}
