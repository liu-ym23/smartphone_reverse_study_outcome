package com.bytedance.android.live.liveinteract.videotalk;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z<T> implements Observer {
    public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

    public z(MultiLinkVideoTalkRoomGuestWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Pair r4 = (Pair) r3;
        if (r4 == null) goto L10;
        tf0.o r0 = this.a.T;
        if (r0 == null) goto L9;
        r0.j(((Number) r4.getFirst()).intValue(), ((Number) r4.getSecond()).intValue());
        return;
    L9:
        return;
    }
}
