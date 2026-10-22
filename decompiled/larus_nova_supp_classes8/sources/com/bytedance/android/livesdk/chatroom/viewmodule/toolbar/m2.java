package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m2<T> implements Consumer {
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.vsplayer.api.b a;

    public m2(com.bytedance.android.livesdk.chatroom.vsplayer.api.b r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        this.a.hidePlayerTip("schedule_close");
    }
}
