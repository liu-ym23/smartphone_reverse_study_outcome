package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomEmojiListResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;

    public e(d r1, int r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r7) {
        com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
        int r0 = nd0.g.a;
        nd0.g.c(8, 1, this.b, this.c, r8);
        d.a r1 = (d.a) ((q46.b) this.a).a;
        if (r1 == null) goto L9;
        DATA r9 = r8.data;
        if (r9 == 0) goto L8;
        r1.vM((TalkRoomEmojiListResponse) r9);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomEmojiListResponse");
    }
}
