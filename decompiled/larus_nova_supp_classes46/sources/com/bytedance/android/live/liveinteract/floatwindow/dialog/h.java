package com.bytedance.android.live.liveinteract.floatwindow.dialog;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ long b;

    public h(Function1 r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        this.a.invoke(r5);
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        long r1 = this.b;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.b(0, r1, r5);
        if ((r5 instanceof ApiServerException) == false) goto L12;
        String r6 = com.bytedance.android.live.broadcastgame.api.openplatform.h.b(r5);
        if (r6 != null) goto L7;
        return;
    L7:
        if (r6.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L15;
        f2.c(r6, 0);
        return;
    L15:
        return;
    L9:
        r2 = false;
        goto L10
    L12:
        f2.c(s1.B(2131917744), 0);
    }
}
