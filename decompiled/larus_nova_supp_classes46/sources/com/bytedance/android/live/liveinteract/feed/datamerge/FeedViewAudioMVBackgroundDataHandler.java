package com.bytedance.android.live.liveinteract.feed.datamerge;

import com.bytedance.android.live.liveinteract.interactivesong.panel.InteractiveSongMvManager;
import com.bytedance.android.livesdk.chatroom.model.interact.IOrderSingMVInfo;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class FeedViewAudioMVBackgroundDataHandler extends a {
    public InteractiveSongMvManager b;
    public final Function1<IOrderSingMVInfo, Unit> c;

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void attach() {
        new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void detach() {
        InteractiveSongMvManager r0 = this.b;
        if (r0 == null) goto L5;
        r0.e();
    L5:
        this.b = null;
    }

    public FeedViewAudioMVBackgroundDataHandler() {
        this.c = new FeedViewAudioMVBackgroundDataHandler$setMvInfoCallBack$1(this);
    }
}
