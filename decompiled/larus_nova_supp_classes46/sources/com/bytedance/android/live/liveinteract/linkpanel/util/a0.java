package com.bytedance.android.live.liveinteract.linkpanel.util;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(IRoom r6) {
        if (r6 == null) goto L7;
        Map r1 = r6.getAnchorABMap();
        if (r1 == null) goto L7;
        String r2 = (String) r1.get("rank_room_user_score");
    L8:
        boolean r7 = com.bytedance.android.livesdk.chatroom.paidlive.e.e(r6, null);
        if (r2 == null) goto L20;
        if (r2.length() <= 0) goto L13;
        boolean r4 = true;
    L14:
        if (r4 != true) goto L20;
        if (Intrinsics.areEqual(r2, "1") == false) goto L24;
        if (r7 == true) goto L25;
    L22:
        return true;
    L25:
        return false;
    L24:
        return false;
    L13:
        r4 = false;
    L20:
        if (((Boolean) vm2.d.t1.getValue(null, vm2.d.a[121(0x79, float:1.7E-43)])).booleanValue() == false) goto L26;
        if (r7 == false) goto L22;
        return false;
    L26:
        return false;
    L7:
        r2 = null;
        goto L8
    }
}
