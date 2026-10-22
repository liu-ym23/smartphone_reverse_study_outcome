package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ m a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;

    public j(m r1, int r2, int r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        long r1 = this.b;
        int r3 = this.c;
        long r4 = this.d;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.W(r1, r3, r4, r8);
        ExceptionUtils.handleException(this.a.getContext(), r8);
    }
}
