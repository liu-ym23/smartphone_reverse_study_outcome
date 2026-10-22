package com.bytedance.android.live.profile.usecase;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.v;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ n a;
    public final /* synthetic */ Context b;

    public p(n r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        v r0 = os0.b.b(this.a.c.getRoomDataCenter());
        Context r1 = this.b;
        r0.d(r1, (Throwable) r3);
    }
}
