package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.bytedance.android.livesdkapi.feed.IKtvRoomFeedView;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h0<T> implements Consumer {
    public final /* synthetic */ g0 a;

    public h0(g0 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        List r3 = (List) r2;
        IKtvRoomFeedView r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.onOnlineListChanged(com.bytedance.android.live.liveinteract.spatial.b.b(r3));
        return;
    }
}
