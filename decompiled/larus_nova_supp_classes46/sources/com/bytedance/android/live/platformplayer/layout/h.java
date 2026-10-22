package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.awemeopen.infra.base.net.AoNetworkEventHelper;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Observer {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final void onChanged(Object r7) {
        Boolean r8 = (Boolean) r7;
        com.bytedance.android.livesdk.log.j0 r9 = com.bytedance.android.livesdk.log.j0.l();
        HashMap r0 = new HashMap();
        r0.put(AoNetworkEventHelper.NETWORK_TYPE, com.bytedance.android.livesdk.log.j0.k());
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(jc1.k.n(IRoomContextService.class), null, 0, 3);
        if (r1 == null) goto L7;
        Room r2 = r1.getCurrentRoom();
        if (r2 == null) goto L7;
        r0.putAll(com.bytedance.android.live.core.utils.h1.a(r2));
    L7:
        Unit r3 = Unit.INSTANCE;
        r9.sendLog("livesdk_backgroud_cut", r0, new Object[]{IRoom.class, am2.x.class});
    }
}
