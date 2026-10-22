package com.bytedance.android.live.liveinteract.videotalk;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ long a;

    public n(long r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        long r1 = this.a;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.z(r1, r5);
        jy0.b.e("video_talk", "", r5);
    }
}
