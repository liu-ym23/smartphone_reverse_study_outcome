package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l0<T> implements Consumer {
    public final /* synthetic */ PaidLiveCompositeWidget a;

    public l0(PaidLiveCompositeWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        PaidLiveCompositeWidget r0 = this.a;
        r0.wq((com.bytedance.android.livesdk.vscore_api.paidlive.l) r2);
    }
}
