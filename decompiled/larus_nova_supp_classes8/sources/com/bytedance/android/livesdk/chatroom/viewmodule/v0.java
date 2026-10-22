package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v0 implements Consumer<Long> {
    public final /* synthetic */ RoomContext a;

    public v0(RoomContext r1) {
        this.a = r1;
    }

    public final void accept(Object r2) throws Exception {
        Long r3 = (Long) r2;
        RoomContext r4 = this.a;
        if (r4 == null) goto L6;
        r4.isShowFullScreenUIByClickScreen().setValue(Boolean.FALSE);
        return;
    }
}
