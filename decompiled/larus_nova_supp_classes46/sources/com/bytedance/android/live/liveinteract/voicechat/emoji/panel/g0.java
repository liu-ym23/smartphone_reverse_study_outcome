package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g0<T> implements Consumer {
    public final /* synthetic */ s a;

    public g0(s r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        IFollowPair r4 = (IFollowPair) r3;
        s r0 = this.a;
        r0.c = false;
        s.a r1 = (s.a) ((q46.b) r0).a;
        if (r1 == null) goto L8;
        if (r4 == null) goto L7;
        r1.GN(r4);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair");
    }
}
