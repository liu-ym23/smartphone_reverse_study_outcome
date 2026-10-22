package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ s a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;

    public w(s r1, int r2, int r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r7) {
        com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
        int r0 = nd0.g.a;
        nd0.g.c(this.b, 2, this.c, this.d, r8);
        s.a r1 = (s.a) ((q46.b) this.a).a;
        if (r1 == null) goto L9;
        vh7.c r9 = jm2.a.d((vh7.c) r8.data);
        if (r9 == null) goto L8;
        r1.up((com.bytedance.android.live.liveinteract.videotalk.emoji.model.k) r9);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.emoji.model.ITalkRoomEmojiListResponse");
    }
}
