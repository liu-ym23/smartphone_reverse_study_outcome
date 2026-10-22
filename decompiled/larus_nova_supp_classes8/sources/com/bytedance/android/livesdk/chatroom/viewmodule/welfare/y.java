package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ WelfareProjectCardWidget a;

    public y(WelfareProjectCardWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        WelfareProjectCardWidget r7 = this.a;
        int r0 = WelfareProjectCardWidget.h;
        r7.getClass();
        xs2.b.a().post(new w(false, true, new int[2], 0));
    }
}
