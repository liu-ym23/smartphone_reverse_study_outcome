package com.bytedance.android.live.broadcastgame.opengame;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g extends com.bytedance.android.livesdk.log.filter.a<com.bytedance.android.live.broadcastgame.api.c> {
    public com.bytedance.android.live.broadcastgame.api.c c;

    public g() {
    }

    public final void a(Map<String, String> r4) {
        com.bytedance.android.live.broadcastgame.api.c r0 = this.c;
        if (r0 == null) goto L10;
        if (r4 == null) goto L6;
        String r1 = r4.put("game_name", String.valueOf(r0.a));
    L6:
        if (r4 == null) goto L8;
        String r2 = r4.put("game_id", String.valueOf(r0.b));
    L8:
        if (r4 == null) goto L10;
        String r3 = r4.put("game_category", String.valueOf(r0.c));
    L10:
        super.a(r4);
    }

    public final void setData(Object r1) {
        this.c = (com.bytedance.android.live.broadcastgame.api.c) r1;
    }

    public final void u(Map r3, Object r4) {
        com.bytedance.android.live.broadcastgame.api.c r5 = (com.bytedance.android.live.broadcastgame.api.c) r4;
        if (r5 == null) goto L6;
        if (r3 == null) goto L6;
        String r0 = (String) r3.put("game_name,", String.valueOf(r5.a));
    L6:
        super.u(r3, r5);
    }
}
