package com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.SeatAnimManager;
import fd2.z;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ SeatAnimEngineWrapper a;

    public a(SeatAnimEngineWrapper r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        z r3 = (z) r2;
        SeatAnimManager r0 = this.a.a;
        if (r0 == null) goto L6;
        r0.d(r3.a);
        return;
    }
}
