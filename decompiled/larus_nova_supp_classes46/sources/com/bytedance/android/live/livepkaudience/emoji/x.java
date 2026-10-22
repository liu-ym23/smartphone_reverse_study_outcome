package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ p a;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.r b;
    public final /* synthetic */ long c;

    public x(p r1, com.bytedance.android.live.liveinteract.videotalk.emoji.model.r r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r8) {
        Throwable r9 = (Throwable) r8;
        this.a.b = false;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.r r1 = this.b;
        long r2 = r1.emojiId;
        int r4 = r1.emojiType;
        long r5 = this.c;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.t0(r2, r4, r5, r9);
        p.a r3 = (p.a) ((q46.b) this.a).a;
        if (r3 == null) goto L6;
        r3.za(r9);
        return;
    }
}
