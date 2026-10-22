package com.bytedance.android.live.revenue.common.message;

import com.bytedance.android.livesdk.link.model.bridge.b0;
import com.bytedance.android.livesdk.link.model.bridge.c0;
import java.util.Map;
import yh6.e;
import yh6.f;
import yh6.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends DynamicMessageType {
    public static final f f = null;
    public static final a g = null;

    static {
        a r0 = new a();
        g = r0;
        f r1 = new f("WebcastBattleStateSyncMessage", new g(b0.class));
        ((yh6.a) r0).a.put("WebcastBattleStateSyncMessage", r1);
        Map r2 = e.a;
        r2.put("WebcastBattleStateSyncMessage", r1);
        f = r1;
        f r3 = new f("WebcastBattleStealDragonMessage", new g(c0.class));
        ((yh6.a) r0).a.put("WebcastBattleStealDragonMessage", r3);
        r2.put("WebcastBattleStealDragonMessage", r3);
    }

    public a() {
    }
}
