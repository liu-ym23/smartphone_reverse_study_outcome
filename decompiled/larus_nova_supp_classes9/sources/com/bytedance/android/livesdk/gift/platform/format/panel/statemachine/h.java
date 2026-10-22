package com.bytedance.android.livesdk.gift.platform.format.panel.statemachine;

import com.bytedance.android.live.recharge.k;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.scope.m;
import com.bytedance.live.datacontext.n;
import i12.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements k.a {
    public final /* synthetic */ FormatGiftPanelDialogViewModel a;
    public final /* synthetic */ boolean b;

    public final /* synthetic */ void b(int r1, int r2, long r3) {
    }

    public final void a() {
        if (this.b == true) goto L5;
        return;
    L5:
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L10;
        n<Boolean> r1 = r0.isContinuous();
        if (r1 == null) goto L10;
        r1.setValue(Boolean.TRUE);
    L10:
        this.a.getClass();
        i12.e r2 = o.a();
        if (r2 == null) goto L13;
        Object r3 = m.e.d(r2, com.bytedance.android.livesdk.gift.platform.format.service.m.class);
    L14:
        com.bytedance.android.livesdk.gift.platform.format.service.m r4 = (com.bytedance.android.livesdk.gift.platform.format.service.m) r3;
        if (r4 == null) goto L18;
        r4.a(0);
        return;
    L18:
        return;
    L13:
        r3 = null;
        goto L14
    }

    public h(FormatGiftPanelDialogViewModel r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
