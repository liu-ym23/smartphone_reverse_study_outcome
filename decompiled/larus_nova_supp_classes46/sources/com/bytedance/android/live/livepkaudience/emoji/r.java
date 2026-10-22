package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ p a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;

    public r(p r1, int r2, long r3) {
        this.a = r1;
        this.b = 8;
        this.c = r2;
        this.d = r3;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        int r1 = this.b;
        int r3 = this.c;
        long r4 = this.d;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.y(r1, 2, r3, r4, r8);
        p.a r2 = (p.a) ((q46.b) this.a).a;
        if (r2 == null) goto L6;
        r2.j8(r8);
        return;
    }
}
