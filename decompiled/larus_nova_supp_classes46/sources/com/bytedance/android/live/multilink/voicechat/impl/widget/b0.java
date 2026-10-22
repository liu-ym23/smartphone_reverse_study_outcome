package com.bytedance.android.live.multilink.voicechat.impl.widget;

import androidx.lifecycle.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0<T> implements Observer {
    public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

    public b0(MultiLinkVoiceChatRoomGuestWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Pair r4 = (Pair) r3;
        if (r4 == null) goto L10;
        tf0.o r0 = this.a.Z;
        if (r0 == null) goto L9;
        r0.j(((Number) r4.getFirst()).intValue(), ((Number) r4.getSecond()).intValue());
        return;
    L9:
        return;
    }
}
