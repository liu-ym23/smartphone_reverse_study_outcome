package com.bytedance.android.live.room.api.panel;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public d() {
    }

    static {
    }

    public static c a(RoomContext r1) {
        Intrinsics.checkNotNullParameter(r1, "roomContext");
        IPanelService r0 = (IPanelService) k.f(IPanelService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPanelManager(r1);
    }

    public static c b(DataCenter r1, long r2) {
        IPanelService r0 = (IPanelService) k.f(IPanelService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPanelManager(r1, r2);
    }

    public static /* synthetic */ c c(DataCenter r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = null;
    L6:
        return b(r2, 0);
    }
}
