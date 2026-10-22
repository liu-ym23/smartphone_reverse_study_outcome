package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ s a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;

    public r(s r1, long r2, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r9) {
        Throwable r5 = (Throwable) r9;
        this.a.b = false;
        ExceptionUtils.handleException(s1.getContext(), r5);
        TalkRoomBusinessFullLinkMonitor r10 = TalkRoomBusinessFullLinkMonitor.a;
        long r0 = this.b;
        long r2 = this.c;
        r10.getClass();
        TalkRoomBusinessFullLinkMonitor.D0(r0, r2, r5);
        x.N(false, this.b, System.currentTimeMillis() - this.c, r5);
    }
}
