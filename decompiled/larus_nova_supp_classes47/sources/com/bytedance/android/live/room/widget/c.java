package com.bytedance.android.live.room.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.live.datacontext.n;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ n a;
    public final /* synthetic */ LiveRoomAudienceWidget b;

    public c(n r1, LiveRoomAudienceWidget r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        sh6.b r7 = (sh6.b) r6;
        StringBuilder r0 = new StringBuilder("rtcRoomInfo onValueChanged RoomId: ");
        dh1.a r1 = (dh1.a) this.a.getValue();
        if (r1 == null) goto L5;
        Long r2 = Long.valueOf(r1.a);
    L6:
        r0.append(r2);
        r0.append(", startShowRtcInfo: ");
        r0.append(this.b.t);
        ALogger.i("LiveRoomAudienceWidget", r0.toString());
        LiveRoomAudienceWidget r3 = this.b;
        dh1.a r8 = (dh1.a) sh6.c.b(r7);
        if (r8 == null) goto L9;
        long r4 = r8.a;
    L11:
        if (r4 <= 0) goto L13;
        boolean r9 = true;
    L14:
        r3.t = r9;
        return;
    L13:
        r9 = false;
        goto L14
    L9:
        r4 = 0;
        goto L11
    L5:
        r2 = null;
        goto L6
    }
}
