package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;

    public j(d r1, int r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        int r1 = je0.d.f();
        int r3 = this.b;
        long r4 = this.c;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.y(r1, 1, r3, r4, r8);
        d.a r2 = (d.a) ((q46.b) this.a).a;
        if (r2 == null) goto L6;
        r2.E3(r8);
        return;
    }
}
