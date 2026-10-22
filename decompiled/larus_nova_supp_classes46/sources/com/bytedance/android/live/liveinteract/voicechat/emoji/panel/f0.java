package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f0<T> implements Consumer {
    public final /* synthetic */ s a;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.j b;
    public final /* synthetic */ long c;

    public f0(s r1, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        this.a.b = false;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        long r1 = this.b.getEmojiId();
        int r3 = this.b.getEmojiType();
        long r4 = this.c;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.t0(r1, r3, r4, r8);
        com.bytedance.android.live.liveinteract.plantform.utils.x.r0(r8, true);
        s.a r2 = (s.a) ((q46.b) this.a).a;
        if (r2 == null) goto L6;
        r2.za(r8);
        return;
    }
}
