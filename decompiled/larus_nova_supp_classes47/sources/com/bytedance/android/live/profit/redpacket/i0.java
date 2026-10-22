package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i0<T> implements Consumer {
    public final /* synthetic */ RedPacketIconModel a;

    public i0(RedPacketIconModel r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        l1 r7 = (l1) r10;
        if (this.a.u.c().isShowing() == true) goto L10;
        if (r7 == null) goto L6;
        String r12 = r7.b();
    L7:
        if (r12 == null) goto L11;
        RedPacketIconModel r13 = this.a;
        RedPacketDialogShowFrom r6 = RedPacketDialogShowFrom.REWARD;
        r13.u.f(r13.getContext(), null, null, r13.t.getRoom(), CollectionsKt.emptyList(), r6, r7, RedPacketIconModel$showSurpriseRushDialog$1.INSTANCE);
        return;
    L11:
        return;
    L6:
        r12 = null;
        goto L7
    }
}
