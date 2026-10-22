package com.bytedance.android.live.broadcastgame.opengame.view;

import com.bytedance.common.utility.Logger;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u implements f {
    public final ArrayDeque<m> a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.f
    public final com.bytedance.android.live.broadcastgame.opengame.message.r poll() {
        m r0 = this.a.poll();
    L3:
        if (r0 == null) goto L14;
        if ((System.currentTimeMillis() - r0.a) > 10000) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
    L12:
        if (r1 == true) goto L14;
        r0 = this.a.poll();
        goto L3
    L10:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L12;
        Logger.d("PayFlowView", "PayMsgQueue, msg is invalid and removed, msg=" + r0.b);
        goto L12
    L7:
        r1 = false;
    L14:
        if (r0 != null) goto L20;
        return null;
    L20:
        return r0.b;
    }

    public u() {
        this.a = new ArrayDeque();
    }
}
