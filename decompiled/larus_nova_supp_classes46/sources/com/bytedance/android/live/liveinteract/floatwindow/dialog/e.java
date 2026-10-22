package com.bytedance.android.live.liveinteract.floatwindow.dialog;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ long b;

    public e(Function0 r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        this.a.invoke();
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        long r2 = this.b;
        TalkRoomBusinessFullLinkMonitor.d(r0, 0, r2, (com.bytedance.android.live.network.response.a) r5);
    }
}
