package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.la;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s1 {
    public static final /* synthetic */ int a = 0;

    public static int a() {
        if (la.a.getValue().c() == false) goto L6;
        return -1;
    L6:
        return 1;
    }

    public static int b() {
        Map r0 = jc1.k.f(IHostApp.class).getNQEParams();
        if (r0 != null) goto L5;
    L7:
        return -1;
    L5:
        if (r0.containsKey("net_effective_connection_type") == false) goto L7;
        return CastIntegerProtector.valueOf((String) r0.get("net_effective_connection_type")).intValue();
    }

    static {
    }

    public static boolean c(long r4) {
        if (la.a.getValue().d() == true) goto L5;
        return true;
    L5:
        RoomContext r0 = RoomContext.getShared();
        if (r0 != null) goto L8;
    L10:
        Room r1 = null;
    L11:
        if (r1 != null) goto L13;
        return false;
    L13:
        if (r1.getRoomId() != r4) goto L17;
        return true;
    L17:
        return false;
    L8:
        if (r0.getRoom() == null) goto L10;
        r1 = (Room) r0.getRoom().getValue();
        goto L11
    }
}
