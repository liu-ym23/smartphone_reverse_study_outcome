package com.bytedance.android.live.liveinteract.feed;

import com.bytedance.android.live.liveinteract.feed.datamerge.FeedViewInteractSongDataHandler;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceChatFeedView a;

    public u(MultiLinkVoiceChatFeedView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        FeedViewInteractSongDataHandler r0 = this.a.r;
        if (r0 == null) goto L5;
        r0.i = r3;
    L5:
        if (r0 == null) goto L8;
        r0.f(InteractiveSongContext.Companion.f());
        return;
    }
}
