package com.bytedance.android.livesdk.chatroom.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j2<T> implements Consumer {
    public final /* synthetic */ RoomWidget a;

    public j2(RoomWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Boolean r2 = (Boolean) sh6.c.b((sh6.b) r1);
        if (r2 == null) goto L6;
        r2.booleanValue();
        this.a.getClass();
        return;
    }
}
