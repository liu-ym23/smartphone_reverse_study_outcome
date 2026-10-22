package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ ye0.a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;

    public k(ye0.a r1, long r2) {
        this.a = r1;
        this.b = 0;
        this.c = r2;
    }

    public final void accept(Object r5) {
        com.bytedance.android.live.network.response.a r6 = (com.bytedance.android.live.network.response.a) r5;
        this.a.onSuccess();
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        int r1 = this.b;
        long r2 = this.c;
        Intrinsics.checkNotNull(r6);
        TalkRoomBusinessFullLinkMonitor.d(r0, r1, r2, r6);
    }
}
