package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ m a;
    public final /* synthetic */ long b;

    public l(m r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.m] */
    public final void accept(Object r9) {
        Throwable r5 = (Throwable) r9;
        ?? r10 = this.a;
        r10.o = false;
        ExceptionUtils.handleException(r10.getContext(), r5);
        TalkRoomBusinessFullLinkMonitor r11 = TalkRoomBusinessFullLinkMonitor.a;
        long r0 = this.a.s;
        long r2 = this.b;
        r11.getClass();
        TalkRoomBusinessFullLinkMonitor.D0(r0, r2, r5);
        com.bytedance.android.live.liveinteract.plantform.utils.x.N(false, this.a.s, System.currentTimeMillis() - this.b, r5);
    }
}
