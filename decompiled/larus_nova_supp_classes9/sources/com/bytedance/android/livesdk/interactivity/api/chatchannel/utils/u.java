package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import zg1.k1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ RoomChatChannelCreator a;

    public u(RoomChatChannelCreator r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        if (((k1) r2).a == false) goto L11;
        RoomChatChannelCreator r3 = this.a;
        int r0 = RoomChatChannelCreator.m;
        s22.e r4 = r3.b();
        if (r4 == null) goto L7;
        r4.onLoginSuccess();
    L7:
        Disposable r5 = this.a.b;
        if (r5 == null) goto L12;
        r5.dispose();
        return;
    L12:
        return;
    }
}
