package com.bytedance.android.livesdk.chatroom.viewmodule;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j2 implements Consumer<Long> {
    public final /* synthetic */ NewFullVideoButtonWidget a;

    public j2(NewFullVideoButtonWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) throws Exception {
        Long r3 = (Long) r2;
        this.a.p.setVisibility(0);
    }
}
