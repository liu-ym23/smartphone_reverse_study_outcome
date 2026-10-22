package com.bytedance.android.livesdk.chatroom.viewmodule;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s0 implements Consumer<Long> {
    public final /* synthetic */ FullVideoButtonWidget a;

    public s0(FullVideoButtonWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) throws Exception {
        Long r3 = (Long) r2;
        this.a.l.setVisibility(0);
    }
}
