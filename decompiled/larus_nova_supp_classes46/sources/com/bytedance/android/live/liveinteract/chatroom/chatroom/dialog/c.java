package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ AdjustGuestPositionDialog a;

    public c(AdjustGuestPositionDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        this.a.d(LinkmicAdjustPositionPingType.AdjustPositinoPingType_Continue);
    }
}
